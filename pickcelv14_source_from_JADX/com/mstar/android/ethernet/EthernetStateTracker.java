package com.mstar.android.ethernet;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.DhcpResults;
import android.net.LinkAddress;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkStateTracker;
import android.net.NetworkUtils;
import android.net.ProxyProperties;
import android.net.RouteInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.util.Slog;
import com.mstar.android.MKeyEvent;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class EthernetStateTracker extends Handler implements NetworkStateTracker {
    private static final String DEFAULT_DLNA_IP_PREFIX = "169.254.1.";
    private static final String DEFAULT_DLNA_NETMASK = "255.255.0.0";
    private static final String DEFAULT_INTERFACE_PROPERTY = "net.eth.interface";
    private static final String DEFAULT_PROXY_HOST_PROPERTY = "http.proxyHost";
    private static final String DEFAULT_PROXY_PORT_PROPERTY = "http.proxyPort";
    public static final int EVENT_ADDR_REMOVE = 8;
    public static final int EVENT_DHCP_START = 0;
    public static final int EVENT_HW_CONNECTED = 3;
    public static final int EVENT_HW_DISCONNECTED = 4;
    public static final int EVENT_HW_PHYCONNECTED = 5;
    public static final int EVENT_INTERFACE_CONFIGURATION_FAILED = 2;
    public static final int EVENT_INTERFACE_CONFIGURATION_SUCCEEDED = 1;
    public static final int EVENT_PROXY_CHANGE = 9;
    public static final int EVENT_RESET_INTERFACE = 7;
    public static final int EVENT_STOP_INTERFACE = 6;
    private static final int NOTIFY_ID = 10;
    private static final String TAG = "EthernetStateTracker";
    private static final String VERSION = "v1.1.2";
    private static final boolean localLOGV = true;
    public static EthernetStateTracker sInstance;
    private boolean mCableConnected;
    private Context mContext;
    private Handler mCsHandler;
    private AtomicBoolean mDefaultRouteSet;
    private DhcpResults mDhcpInfo;
    private DhcpHandler mDhcpTarget;
    private EthernetManager mEM;
    private boolean mEnableProxy;
    private ProxyProperties mHttpProxy;
    private String mInterfaceName;
    private boolean mInterfaceStopped;
    private LinkProperties mLinkProperties;
    private EthernetMonitor mMonitor;
    private NetworkInfo mNetworkInfo;
    private AtomicBoolean mPrivateDnsRouteSet;
    private boolean mServiceStarted;
    private boolean mStartingDhcp;
    private AtomicBoolean mTeardownRequested;
    private Handler mTrackerTarget;
    private String[] sDnsPropNames;

    private class DhcpHandler extends Handler {
        public DhcpHandler(Looper looper, Handler target) {
            super(looper);
            EthernetStateTracker.this.mTrackerTarget = target;
        }

        public void PreDhcpStart() {
            while (SystemProperties.get("init.svc.bootanim").compareTo("stopped") != 0) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EthernetStateTracker.EVENT_DHCP_START /*0*/:
                    synchronized (EthernetStateTracker.this.mDhcpTarget) {
                        if (EthernetStateTracker.this.mInterfaceStopped) {
                            EthernetStateTracker.this.mInterfaceStopped = false;
                        } else {
                            int event;
                            Slog.d(EthernetStateTracker.TAG, "dhcp req started");
                            PreDhcpStart();
                            if (!NetworkUtils.runDhcp(EthernetStateTracker.this.mInterfaceName, EthernetStateTracker.this.mDhcpInfo)) {
                                event = EthernetStateTracker.EVENT_INTERFACE_CONFIGURATION_FAILED;
                                Slog.e(EthernetStateTracker.TAG, "dhcp req failed: " + NetworkUtils.getDhcpError());
                                break;
                            }
                            event = EthernetStateTracker.EVENT_INTERFACE_CONFIGURATION_SUCCEEDED;
                            Slog.d(EthernetStateTracker.TAG, "dhcp req succeeded: " + EthernetStateTracker.this.mDhcpInfo.toString());
                            EthernetStateTracker.this.PostLinkageConfig(EthernetStateTracker.this.mDhcpInfo);
                            EthernetStateTracker.this.updateDhcpDevInfo(EthernetStateTracker.this.mDhcpInfo);
                            EthernetStateTracker.this.mTrackerTarget.sendEmptyMessage(event);
                        }
                        EthernetStateTracker.this.mStartingDhcp = false;
                        break;
                    }
                default:
            }
        }
    }

    private EthernetStateTracker() {
        this.mTeardownRequested = new AtomicBoolean(false);
        this.mPrivateDnsRouteSet = new AtomicBoolean(false);
        this.mDefaultRouteSet = new AtomicBoolean(false);
        this.mStartingDhcp = false;
        this.mEnableProxy = false;
        this.mHttpProxy = null;
        this.mNetworkInfo = new NetworkInfo(EVENT_PROXY_CHANGE, EVENT_DHCP_START, "ETHERNET", "");
        this.mLinkProperties = new LinkProperties();
        Slog.v(TAG, "Ethernet State Tracker v1.1.2");
        if (EthernetNative.initEthernetNative() != 0) {
            Slog.e(TAG, "init eth dev failed");
            return;
        }
        this.mServiceStarted = localLOGV;
        HandlerThread dhcpThread = new HandlerThread("DHCP Handler Thread");
        dhcpThread.start();
        this.mDhcpTarget = new DhcpHandler(dhcpThread.getLooper(), this);
        this.mMonitor = new EthernetMonitor(this);
        this.mDhcpInfo = new DhcpResults();
    }

    public static synchronized EthernetStateTracker getInstance() {
        EthernetStateTracker ethernetStateTracker;
        synchronized (EthernetStateTracker.class) {
            if (sInstance == null) {
                sInstance = new EthernetStateTracker();
            }
            ethernetStateTracker = sInstance;
        }
        return ethernetStateTracker;
    }

    public boolean stopInterface(boolean suspend) {
        if (this.mEM != null) {
            EthernetDevInfo info = this.mEM.getSavedConfig();
            if (info != null && this.mEM.isConfigured()) {
                synchronized (this.mDhcpTarget) {
                    this.mInterfaceStopped = localLOGV;
                    Slog.i(TAG, "stop eth i/f, suspend " + suspend);
                    this.mDhcpTarget.removeMessages(EVENT_DHCP_START);
                    String ifname = info.getIfName();
                    if (!NetworkUtils.stopDhcp(ifname)) {
                        Slog.w(TAG, "could not stop dhcp");
                    }
                    this.mStartingDhcp = false;
                    NetworkUtils.resetConnections(ifname, EVENT_HW_CONNECTED);
                    if (suspend) {
                        NetworkUtils.clearAddresses(ifname);
                    } else {
                        NetworkUtils.disableInterface(ifname);
                    }
                    this.mLinkProperties.clear();
                }
            }
        }
        return localLOGV;
    }

    private boolean configureInterface(EthernetDevInfo info) throws UnknownHostException {
        this.mInterfaceStopped = false;
        String[] strArr;
        if (info.getConnectMode().equals(EthernetDevInfo.ETHERNET_CONN_MODE_DHCP)) {
            strArr = new String[EVENT_INTERFACE_CONFIGURATION_FAILED];
            strArr[EVENT_DHCP_START] = "dhcp." + this.mInterfaceName + ".dns1";
            strArr[EVENT_INTERFACE_CONFIGURATION_SUCCEEDED] = "dhcp." + this.mInterfaceName + ".dns2";
            this.sDnsPropNames = strArr;
            synchronized (this) {
                if (!this.mStartingDhcp) {
                    this.mStartingDhcp = localLOGV;
                    this.mDhcpTarget.sendEmptyMessage(EVENT_DHCP_START);
                    Slog.i(TAG, "trigger dhcp for dev " + info.getIfName());
                }
            }
        } else {
            int event;
            this.mStartingDhcp = false;
            DhcpInfo mStaticInfo = new DhcpInfo();
            strArr = new String[EVENT_INTERFACE_CONFIGURATION_FAILED];
            strArr[EVENT_DHCP_START] = "net." + this.mInterfaceName + ".dns1";
            strArr[EVENT_INTERFACE_CONFIGURATION_SUCCEEDED] = "net." + this.mInterfaceName + ".dns2";
            this.sDnsPropNames = strArr;
            mStaticInfo.ipAddress = lookupHost(info.getIpAddress());
            mStaticInfo.gateway = lookupHost(info.getRouteAddr());
            mStaticInfo.netmask = lookupHost(info.getNetMask());
            mStaticInfo.dns1 = lookupHost(info.getDnsAddr());
            mStaticInfo.dns2 = lookupHost(info.getDns2Addr());
            Slog.i(TAG, "static ip config " + mStaticInfo.toString());
            NetworkUtils.removeDefaultRoute(info.getIfName());
            if (NetworkUtils.configureInterface(info.getIfName(), mStaticInfo)) {
                event = EVENT_INTERFACE_CONFIGURATION_SUCCEEDED;
                Slog.v(TAG, "static ip config succeeded");
                PostLinkageConfig(makeInfoResults(mStaticInfo));
            } else {
                event = EVENT_INTERFACE_CONFIGURATION_FAILED;
                Slog.w(TAG, "static ip config failed");
            }
            sendEmptyMessage(event);
        }
        return localLOGV;
    }

    public boolean resetInterface() throws UnknownHostException {
        if (this.mEM != null) {
            EthernetDevInfo info = this.mEM.getSavedConfig();
            if (info != null && this.mEM.isConfigured()) {
                synchronized (this) {
                    this.mInterfaceName = info.getIfName();
                    Slog.i(TAG, "reset dev " + this.mInterfaceName);
                    SystemProperties.set(DEFAULT_INTERFACE_PROPERTY, this.mInterfaceName);
                    NetworkUtils.resetConnections(this.mInterfaceName, EVENT_HW_CONNECTED);
                    if (this.mDhcpTarget != null) {
                        this.mDhcpTarget.removeMessages(EVENT_DHCP_START);
                    }
                    if (!NetworkUtils.stopDhcp(this.mInterfaceName)) {
                        Slog.w(TAG, "could not stop dhcp");
                    }
                    this.mStartingDhcp = false;
                    this.mDhcpInfo.clear();
                    this.mLinkProperties.clear();
                    configureInterface(info);
                }
            }
        }
        return localLOGV;
    }

    public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.default";
    }

    public void StartPolling() {
        this.mMonitor.startMonitoring();
    }

    public boolean isAvailable() {
        return (this.mEM.getTotalInterface() == 0 || this.mEM.getState() == EVENT_INTERFACE_CONFIGURATION_SUCCEEDED) ? false : localLOGV;
    }

    public boolean reconnect() {
        try {
            if (this.mEM.getState() != EVENT_INTERFACE_CONFIGURATION_SUCCEEDED) {
                this.mEM.setEnabled(localLOGV);
                if (!this.mEM.isConfigured()) {
                    this.mEM.setDefaultConf();
                }
                return resetInterface();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void captivePortalCheckComplete() {
    }

    public void captivePortalCheckCompleted(boolean isCaptivePortal) {
    }

    public boolean setRadio(boolean turnOn) {
        return false;
    }

    public void startMonitoring(Context context, Handler target) {
        boolean z = localLOGV;
        Slog.v(TAG, "start to monitor eth dev");
        if (this.mServiceStarted) {
            this.mEM = EthernetManager.getInstance();
            this.mContext = context;
            this.mCsHandler = target;
            int state = this.mEM.getState();
            if (state == EVENT_INTERFACE_CONFIGURATION_SUCCEEDED) {
                return;
            }
            if (state == 0) {
                EthernetManager ethernetManager = this.mEM;
                if (this.mEM.getDeviceNameList() == null) {
                    z = false;
                }
                ethernetManager.setEnabled(z);
                return;
            }
            try {
                resetInterface();
            } catch (UnknownHostException e) {
                Slog.e(TAG, "Wrong ethernet config");
            }
        }
    }

    public void setUserDataEnable(boolean enabled) {
        Log.w(TAG, "ignoring setUserDataEnable(" + enabled + ")");
    }

    public void setPolicyDataEnable(boolean enabled) {
        Log.w(TAG, "ignoring setPolicyDataEnable(" + enabled + ")");
    }

    public boolean teardown() {
        return this.mEM != null ? stopInterface(false) : false;
    }

    private void IntentBroadcast(int event) {
        Intent intent = new Intent(EthernetManager.ETHERNET_STATE_CHANGED_ACTION);
        intent.addFlags(134217728);
        intent.putExtra(EthernetManager.EXTRA_ETHERNET_STATE, event);
        this.mContext.sendStickyBroadcast(intent);
        Slog.i(TAG, "IntentBroadcast, event " + event);
    }

    private void postNotification(int event) {
        this.mCsHandler.obtainMessage(458752, new NetworkInfo(this.mNetworkInfo)).sendToTarget();
        IntentBroadcast(event);
    }

    private boolean setState(boolean state, int event) {
        if (this.mNetworkInfo.isConnected() != state) {
            EthernetDevInfo devInfo = this.mEM.getSavedConfig();
            if (state) {
                this.mNetworkInfo.setDetailedState(DetailedState.CONNECTED, null, devInfo.getMacAddress(this.mInterfaceName));
            } else {
                this.mNetworkInfo.setDetailedState(DetailedState.DISCONNECTED, null, devInfo.getMacAddress(this.mInterfaceName));
                stopInterface(localLOGV);
            }
            this.mNetworkInfo.setIsAvailable(state);
            postNotification(event);
            return localLOGV;
        }
        Slog.i(TAG, "setState, skip: " + event);
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r2 = r6.what;	 Catch:{ all -> 0x0035 }
        switch(r2) {
            case 1: goto L_0x0008;
            case 2: goto L_0x0038;
            case 3: goto L_0x003c;
            case 4: goto L_0x0057;
            case 5: goto L_0x007b;
            case 6: goto L_0x00a2;
            case 7: goto L_0x00c2;
            case 8: goto L_0x00f9;
            default: goto L_0x0006;
        };	 Catch:{ all -> 0x0035 }
    L_0x0006:
        monitor-exit(r5);	 Catch:{ all -> 0x0035 }
        return;
    L_0x0008:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received config succeeded, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r2 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0006;
    L_0x0026:
        r2 = 1;
        r3 = r6.what;	 Catch:{ all -> 0x0035 }
        r2 = r5.setState(r2, r3);	 Catch:{ all -> 0x0035 }
        if (r2 != 0) goto L_0x0006;
    L_0x002f:
        r2 = r6.what;	 Catch:{ all -> 0x0035 }
        r5.IntentBroadcast(r2);	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x0035:
        r2 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0035 }
        throw r2;
    L_0x0038:
        r5.configureInterfaceAutoIP();	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x003c:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received i/f connected, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x0057:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received i/f disconnected, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r5.mCableConnected = r2;	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r3 = r6.what;	 Catch:{ all -> 0x0035 }
        r5.setState(r2, r3);	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x007b:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received i/f up, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r2 = 1;
        r5.mCableConnected = r2;	 Catch:{ all -> 0x0035 }
        r2 = r6.what;	 Catch:{ all -> 0x0035 }
        r5.IntentBroadcast(r2);	 Catch:{ all -> 0x0035 }
        r5.reconnect();	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x00a2:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received i/f stop, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r5.stopInterface(r2);	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x00c2:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received i/f reset, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r5.resetInterface();	 Catch:{ UnknownHostException -> 0x00f3 }
        r2 = r5.mCsHandler;	 Catch:{ UnknownHostException -> 0x00f3 }
        if (r2 == 0) goto L_0x0006;
    L_0x00e3:
        r2 = r5.mCsHandler;	 Catch:{ UnknownHostException -> 0x00f3 }
        r3 = 458753; // 0x70001 float:6.4285E-40 double:2.26654E-318;
        r4 = r5.mNetworkInfo;	 Catch:{ UnknownHostException -> 0x00f3 }
        r1 = r2.obtainMessage(r3, r4);	 Catch:{ UnknownHostException -> 0x00f3 }
        r1.sendToTarget();	 Catch:{ UnknownHostException -> 0x00f3 }
        goto L_0x0006;
    L_0x00f3:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
    L_0x00f9:
        r2 = "EthernetStateTracker";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0035 }
        r3.<init>();	 Catch:{ all -> 0x0035 }
        r4 = "received addr removed, CC ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r4 = r5.mCableConnected;	 Catch:{ all -> 0x0035 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0035 }
        r3 = r3.toString();	 Catch:{ all -> 0x0035 }
        android.util.Slog.i(r2, r3);	 Catch:{ all -> 0x0035 }
        r5.configureInterfaceAutoIP();	 Catch:{ all -> 0x0035 }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.ethernet.EthernetStateTracker.handleMessage(android.os.Message):void");
    }

    private void updateDhcpDevInfo(DhcpResults dhcpRes) {
        EthernetDevInfo info = this.mEM.getSavedConfig();
        if (info != null && this.mEM.isConfigured()) {
            LinkProperties lp = dhcpRes.linkProperties;
            int index = EVENT_DHCP_START;
            for (LinkAddress linkAddr : lp.getLinkAddresses()) {
                if (index == 0) {
                    info.setIpAddress(linkAddr.getAddress().getHostAddress());
                    info.setNetMask(NetworkUtils.intToInetAddress(NetworkUtils.prefixLengthToNetmaskInt(linkAddr.getNetworkPrefixLength())).getHostAddress());
                }
                index += EVENT_INTERFACE_CONFIGURATION_SUCCEEDED;
            }
            index = EVENT_DHCP_START;
            for (RouteInfo route : lp.getRoutes()) {
                if (route.getGateway() != null) {
                    info.setRouteAddr(route.getGateway().getHostAddress());
                }
                index += EVENT_INTERFACE_CONFIGURATION_SUCCEEDED;
            }
            index = EVENT_DHCP_START;
            for (InetAddress inetAddr : lp.getDnses()) {
                if (index == 0) {
                    info.setDnsAddr(inetAddr.getHostAddress());
                }
                if (index == EVENT_INTERFACE_CONFIGURATION_SUCCEEDED) {
                    info.setDns2Addr(inetAddr.getHostAddress());
                }
                index += EVENT_INTERFACE_CONFIGURATION_SUCCEEDED;
            }
            if (this.mServiceStarted) {
                ContentResolver cr = this.mContext.getContentResolver();
                Secure.putString(cr, "ethernet_ip", info.getIpAddress());
                Secure.putString(cr, "ethernet_dns", info.getDnsAddr());
                Secure.putString(cr, "ethernet_dns2", info.getDns2Addr());
                Secure.putString(cr, "ethernet_iproute", info.getRouteAddr());
                Secure.putString(cr, "ethernet_netmask", info.getNetMask());
            }
        }
    }

    private void sendProxyBroadcast(ProxyProperties proxy) {
        Intent intent = new Intent("android.intent.action.PROXY_CHANGE");
        intent.addFlags(671088640);
        intent.putExtra("proxy", proxy);
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);
    }

    public void PostLinkageConfig(DhcpResults dhcpRes) {
        this.mLinkProperties = dhcpRes.linkProperties;
        this.mLinkProperties.setInterfaceName(this.mInterfaceName);
        EthernetDevInfo DevInfo = this.mEM.getSavedConfig();
        boolean enable = DevInfo.getProxyOn();
        String host = DevInfo.getProxyHost();
        String port = DevInfo.getProxyPort();
        String exclusion = DevInfo.getProxyExclusionList();
        ProxyProperties proxyProp = null;
        if (this.mEnableProxy || enable) {
            if (!enable) {
                host = "";
                port = "0";
                exclusion = "";
            }
            if (!(host == null || port == null)) {
                proxyProp = new ProxyProperties(host, Integer.parseInt(port), exclusion);
            }
            if (proxyProp != null && proxyProp != this.mHttpProxy && !proxyProp.equals(this.mHttpProxy)) {
                this.mEnableProxy = enable;
                this.mHttpProxy = new ProxyProperties(proxyProp);
                this.mLinkProperties.setHttpProxy(proxyProp);
                SystemProperties.set(DEFAULT_PROXY_HOST_PROPERTY, host);
                SystemProperties.set(DEFAULT_PROXY_PORT_PROPERTY, port);
                IntentBroadcast(EVENT_PROXY_CHANGE);
                sendProxyBroadcast(proxyProp);
                Slog.d(TAG, "proxy host " + host + ", port " + port + ", exclusion " + exclusion);
            }
        }
    }

    private String convertToString(int addr) {
        return NetworkUtils.intToInetAddress(addr).getHostAddress();
    }

    public DhcpResults makeInfoResults(DhcpInfo Info) {
        DhcpResults dhcpRes = new DhcpResults();
        try {
            dhcpRes.addLinkAddress(convertToString(Info.ipAddress), NetworkUtils.netmaskIntToPrefixLength(Info.netmask));
        } catch (IllegalArgumentException e) {
        }
        dhcpRes.addGateway(convertToString(Info.gateway));
        dhcpRes.addDns(convertToString(Info.dns1));
        dhcpRes.addDns(convertToString(Info.dns2));
        return dhcpRes;
    }

    public String getEthernetIPAddr() {
        EthernetDevInfo DevInfo = this.mEM.getSavedConfig();
        String ip = null;
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                if (ni.getName().equals(DevInfo.getIfName())) {
                    Enumeration<InetAddress> address = ni.getInetAddresses();
                    while (address.hasMoreElements()) {
                        InetAddress ia = (InetAddress) address.nextElement();
                        if (!ia.isLoopbackAddress() && ia.getHostAddress().indexOf(":") == -1) {
                            ip = ia.getHostAddress();
                            Slog.v(TAG, "getIP: " + ip);
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public boolean configureInterfaceAutoIP() {
        EthernetDevInfo DevInfo = this.mEM.getSavedConfig();
        if (!isCableConnected() || !DevInfo.getConnectMode().equals(EthernetDevInfo.ETHERNET_CONN_MODE_DHCP)) {
            Slog.v(TAG, "autoIP skip!");
            return false;
        } else if (getEthernetIPAddr() != null) {
            Slog.v(TAG, "autoIP skip!!");
            return false;
        } else {
            Random rand = new Random();
            DhcpInfo mStaticInfo = new DhcpInfo();
            mStaticInfo.ipAddress = lookupHost(DEFAULT_DLNA_IP_PREFIX + Integer.toString(rand.nextInt(100)));
            mStaticInfo.netmask = lookupHost(DEFAULT_DLNA_NETMASK);
            Slog.i(TAG, "autoIP: " + mStaticInfo.toString());
            NetworkUtils.removeDefaultRoute(DevInfo.getIfName());
            if (NetworkUtils.configureInterface(DevInfo.getIfName(), mStaticInfo)) {
                Slog.v(TAG, "autoIP succeeded");
            } else {
                Slog.w(TAG, "autoIP failed");
            }
            return localLOGV;
        }
    }

    public void notifyPhyConnected(String ifname) {
        Slog.v(TAG, "report " + ifname + " i/f is up");
        synchronized (this) {
            sendEmptyMessage(EVENT_HW_PHYCONNECTED);
        }
    }

    public void notifyStateChange(String ifname, DetailedState state) {
        Slog.i(TAG, "report new state " + state.toString() + " on dev " + ifname);
        if (ifname.equals(this.mInterfaceName)) {
            synchronized (this) {
                sendEmptyMessage(state.equals(DetailedState.CONNECTED) ? EVENT_HW_CONNECTED : EVENT_HW_DISCONNECTED);
            }
        }
    }

    public void notifyAddressRemove(String ifname) {
        Slog.v(TAG, "report " + ifname + " i/f addr removed");
        synchronized (this) {
            sendEmptyMessage(EVENT_ADDR_REMOVE);
        }
    }

    private static int lookupHost(String hostname) {
        try {
            byte[] addrBytes = InetAddress.getByName(hostname).getAddress();
            return ((((addrBytes[EVENT_HW_CONNECTED] & MKeyEvent.KEYCODE_SLEEP) << 24) | ((addrBytes[EVENT_INTERFACE_CONFIGURATION_FAILED] & MKeyEvent.KEYCODE_SLEEP) << 16)) | ((addrBytes[EVENT_INTERFACE_CONFIGURATION_SUCCEEDED] & MKeyEvent.KEYCODE_SLEEP) << EVENT_ADDR_REMOVE)) | (addrBytes[EVENT_DHCP_START] & MKeyEvent.KEYCODE_SLEEP);
        } catch (UnknownHostException e) {
            return -1;
        }
    }

    public void setDependencyMet(boolean met) {
    }

    public void setTeardownRequested(boolean isRequested) {
        this.mTeardownRequested.set(isRequested);
    }

    public boolean isTeardownRequested() {
        return this.mTeardownRequested.get();
    }

    public boolean isPrivateDnsRouteSet() {
        return this.mPrivateDnsRouteSet.get();
    }

    public void privateDnsRouteSet(boolean enabled) {
        this.mPrivateDnsRouteSet.set(enabled);
    }

    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(this.mNetworkInfo);
    }

    public boolean isNetworkConnected() {
        return (this.mNetworkInfo.isConnected() && this.mCableConnected) ? localLOGV : false;
    }

    public boolean isCableConnected() {
        return this.mCableConnected;
    }

    public LinkProperties getLinkProperties() {
        return new LinkProperties(this.mLinkProperties);
    }

    public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities();
    }

    public boolean isDefaultRouteSet() {
        return this.mDefaultRouteSet.get();
    }

    public void defaultRouteSet(boolean enabled) {
        this.mDefaultRouteSet.set(enabled);
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
