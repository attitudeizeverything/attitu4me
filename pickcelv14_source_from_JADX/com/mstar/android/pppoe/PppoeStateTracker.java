package com.mstar.android.pppoe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LinkAddress;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkStateTracker;
import android.net.NetworkUtils;
import android.net.RouteInfo;
import android.os.Handler;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Slog;
import com.mstar.android.ethernet.EthernetManager;
import com.mstar.android.wifi.MWifiManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PppoeStateTracker extends Handler implements NetworkStateTracker {
    private static final String TAG = "PppoeStateTracker";
    public static PppoeStateTracker sInstance;
    private Context mContext;
    private Handler mCsHandler;
    private AtomicBoolean mDefaultRouteSet;
    private LinkCapabilities mLinkCapabilities;
    private LinkProperties mLinkProperties;
    private NetworkInfo mNetworkInfo;
    private PppoeManager mPppoeManager;
    private BroadcastReceiver mPppoeStateReceiver;
    private int mPrefixLength;
    private AtomicBoolean mPrivateDnsRouteSet;
    private AtomicBoolean mTeardownRequested;

    private class PppoeStateReceiver extends BroadcastReceiver {
        private PppoeStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PppoeStateTracker.this.checkPppoeManager();
            String action = intent.getAction();
            if (action.equals(PppoeManager.PPPOE_STATE_ACTION)) {
                PppoeStateTracker.this.notifyStateChange(intent.getStringExtra(PppoeManager.PPPOE_STATE_STATUE));
            } else if (action.equals(EthernetManager.ETHERNET_STATE_CHANGED_ACTION)) {
                if (intent.getIntExtra(EthernetManager.EXTRA_ETHERNET_STATE, -1) == 4) {
                    Slog.i(PppoeStateTracker.TAG, "receive EthernetStateTracker.EVENT_HW_DISCONNECTED");
                    if (PppoeStateTracker.this.mPppoeManager.getPppoeStatus().equals(PppoeManager.PPPOE_STATE_CONNECT)) {
                        netif = PppoeStateTracker.this.mPppoeManager.PppoeGetInterface();
                        if (netif != null && netif.startsWith("eth")) {
                            PppoeStateTracker.this.mPppoeManager.disconnectPppoe();
                        }
                    }
                }
            } else if (action.equals(MWifiManager.WIFI_DEVICE_REMOVED_ACTION)) {
                Slog.i(PppoeStateTracker.TAG, "receive WifiManager.WIFI_DEVICE_REMOVED_ACTION");
                if (PppoeStateTracker.this.mPppoeManager.getPppoeStatus().equals(PppoeManager.PPPOE_STATE_CONNECT)) {
                    netif = PppoeStateTracker.this.mPppoeManager.PppoeGetInterface();
                    if (netif != null && netif.startsWith("wlan")) {
                        PppoeStateTracker.this.mPppoeManager.disconnectPppoe();
                    }
                }
            }
        }

        private boolean isCableAvailable(String netif) {
            return isCableStatusAvailable("/sys/class/net/" + netif + "/carrier");
        }

        private boolean isCableStatusAvailable(String statusFile) {
            if (readCableStatus(statusFile) == '1') {
                return true;
            }
            return false;
        }

        private char readCableStatus(String filePath) {
            FileNotFoundException e;
            Throwable th;
            File file = new File(filePath);
            int tempChar = 0;
            if (file.exists()) {
                Reader reader = null;
                try {
                    Reader reader2 = new InputStreamReader(new FileInputStream(file));
                    try {
                        tempChar = reader2.read();
                    } catch (IOException e2) {
                        try {
                            e2.printStackTrace();
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            reader = reader2;
                            try {
                                e.printStackTrace();
                                try {
                                    reader.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                                return (char) tempChar;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    reader.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            reader = reader2;
                            reader.close();
                            throw th;
                        }
                    }
                    try {
                        reader2.close();
                    } catch (IOException e2222) {
                        e2222.printStackTrace();
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    reader.close();
                    return (char) tempChar;
                }
            }
            return (char) tempChar;
        }
    }

    public PppoeStateTracker() {
        this.mTeardownRequested = new AtomicBoolean(false);
        this.mPrivateDnsRouteSet = new AtomicBoolean(false);
        this.mDefaultRouteSet = new AtomicBoolean(false);
        this.mNetworkInfo = new NetworkInfo(14, 0, "PPPOE", "");
        this.mLinkProperties = new LinkProperties();
        this.mNetworkInfo.setIsAvailable(false);
        setTeardownRequested(false);
        this.mPppoeManager = null;
    }

    public static synchronized PppoeStateTracker getInstance() {
        PppoeStateTracker pppoeStateTracker;
        synchronized (PppoeStateTracker.class) {
            if (sInstance == null) {
                sInstance = new PppoeStateTracker();
            }
            pppoeStateTracker = sInstance;
        }
        return pppoeStateTracker;
    }

    public void startMonitoring(Context context, Handler target) {
        this.mContext = context;
        this.mCsHandler = target;
        IntentFilter filter = new IntentFilter();
        filter.addAction(PppoeManager.PPPOE_STATE_ACTION);
        filter.addAction(EthernetManager.ETHERNET_STATE_CHANGED_ACTION);
        filter.addAction(MWifiManager.WIFI_DEVICE_REMOVED_ACTION);
        this.mPppoeStateReceiver = new PppoeStateReceiver();
        this.mContext.registerReceiver(this.mPppoeStateReceiver, filter);
    }

    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(this.mNetworkInfo);
    }

    public LinkProperties getLinkProperties() {
        return new LinkProperties(this.mLinkProperties);
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities();
    }

    public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.default";
    }

    public boolean teardown() {
        return true;
    }

    public boolean reconnect() {
        return false;
    }

    public void captivePortalCheckComplete() {
    }

    public void captivePortalCheckCompleted(boolean isCaptivePortal) {
    }

    public boolean setRadio(boolean turnOn) {
        return false;
    }

    public boolean isAvailable() {
        return this.mNetworkInfo.isAvailable();
    }

    public void setUserDataEnable(boolean enabled) {
    }

    public void setPolicyDataEnable(boolean enabled) {
    }

    public boolean isPrivateDnsRouteSet() {
        return this.mPrivateDnsRouteSet.get();
    }

    public void privateDnsRouteSet(boolean enabled) {
        this.mPrivateDnsRouteSet.set(enabled);
    }

    public boolean isDefaultRouteSet() {
        return this.mDefaultRouteSet.get();
    }

    public void defaultRouteSet(boolean enabled) {
        this.mDefaultRouteSet.set(enabled);
    }

    public boolean isTeardownRequested() {
        return this.mTeardownRequested.get();
    }

    public void setTeardownRequested(boolean isRequested) {
        this.mTeardownRequested.set(isRequested);
    }

    public void setDependencyMet(boolean met) {
    }

    private LinkAddress makeLinkAddress() {
        String ipaddr = this.mPppoeManager.getIpaddr();
        if (!TextUtils.isEmpty(ipaddr)) {
            return new LinkAddress(NetworkUtils.numericToInetAddress(ipaddr), this.mPrefixLength);
        }
        Slog.i(TAG, "pppoe ip is null");
        return null;
    }

    private void updateLinkProperties() {
        this.mLinkProperties.clear();
        LinkAddress linkAddress = makeLinkAddress();
        this.mLinkProperties.addLinkAddress(linkAddress);
        try {
            this.mLinkProperties.addRoute(new RouteInfo(linkAddress, InetAddress.getByName(this.mPppoeManager.getIpaddr())));
        } catch (UnknownHostException e) {
            Slog.i(TAG, "failed to add route");
        }
        String dns1 = this.mPppoeManager.getDns1();
        if (TextUtils.isEmpty(dns1)) {
            Slog.i(TAG, "dns1 is empty");
        } else {
            this.mLinkProperties.addDns(NetworkUtils.numericToInetAddress(dns1));
        }
        String dns2 = this.mPppoeManager.getDns2();
        if (TextUtils.isEmpty(dns2)) {
            Slog.i(TAG, "dns2 is empty");
        } else {
            this.mLinkProperties.addDns(NetworkUtils.numericToInetAddress(dns2));
        }
        this.mLinkProperties.setInterfaceName(this.mPppoeManager.getInterfaceName());
        Slog.i(TAG, "print linkproperties of pppoe:");
        Slog.i(TAG, this.mLinkProperties.toString());
    }

    private void notifyStateChange(String status) {
        if (status.equals(PppoeManager.PPPOE_STATE_CONNECT) || status.equals(PppoeManager.PPPOE_STATE_DISCONNECT)) {
            if (status.equals(PppoeManager.PPPOE_STATE_CONNECT)) {
                this.mNetworkInfo.setDetailedState(DetailedState.CONNECTED, null, null);
                this.mNetworkInfo.setIsAvailable(true);
                updateLinkProperties();
            } else if (status.equals(PppoeManager.PPPOE_STATE_DISCONNECT)) {
                this.mNetworkInfo.setDetailedState(DetailedState.DISCONNECTED, null, null);
                this.mNetworkInfo.setIsAvailable(false);
            }
            this.mCsHandler.obtainMessage(458752, new NetworkInfo(this.mNetworkInfo)).sendToTarget();
        }
    }

    private void checkPppoeManager() {
        if (this.mPppoeManager == null) {
            this.mPppoeManager = PppoeManager.getInstance();
        }
    }

    public void addStackedLink(LinkProperties link) {
        this.mLinkProperties.addStackedLink(link);
    }

    public void removeStackedLink(LinkProperties link) {
        this.mLinkProperties.removeStackedLink(link);
    }

    public void supplyMessenger(Messenger messenger) {
    }
}
