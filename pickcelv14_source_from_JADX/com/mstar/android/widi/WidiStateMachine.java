package com.mstar.android.widi;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.mstar.android.media.MMediaPlayer;
import com.squareup.okhttp.internal.http.HttpTransport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import jcifs.dcerpc.msrpc.lsarpc;

public class WidiStateMachine extends StateMachine {
    static final int BASE = 0;
    static final int CMD_LOAD_DRIVER = 1;
    static final int CMD_LOAD_DRIVER_FAILURE = 4;
    static final int CMD_LOAD_DRIVER_SUCCESS = 3;
    static final int CMD_UNLOAD_DRIVER = 2;
    static final int CMD_UNLOAD_DRIVER_FAILURE = 6;
    static final int CMD_UNLOAD_DRIVER_SUCCESS = 5;
    static final int CMD_WIDI_NOT_SUPPORT = 7;
    private static final boolean DBG = true;
    private static final String DEFAULT_FAMILY_NAME = "MSWIDI";
    private static final String DEFAULT_ID = "0000";
    private static final String ENTER = "entering...";
    private static final String TAG = "WidiStateMachine";
    private static final String adapterConfig = "/data/adapter.config";
    private static String adapterId = null;
    private static String adapterName = null;
    private static int currentWidiState = 0;
    private static final String mVendorAth1021 = "ATH1021";
    private static final String mVendorAth9374 = "ATH9374";
    private static final String mVendorAth9375 = "ATH9375";
    private static final String mVendorRal5370 = "RAL5370";
    private static final String mVendorRtl8192cu = "RTL8192CU";
    private static final String mVendorRtl8192eu = "RTL8192EU";
    private static String pinCode;
    private static int previousWidiState;
    private String l2sdIf;
    private Context mContext;
    private State mDefaultState;
    private State mDriverLoadedState;
    private State mDriverLoadingState;
    private State mDriverUnloadedState;
    private State mDriverUnloadingState;
    private String mInterface;
    private State mObtainingIpState;
    private State mShowPinState;
    private State mShowScreenState;
    private State mWidiConnectedState;
    private State mWidiConnectingState;
    private String mWidiDeviceName;
    private State mWidiDisconnectedState;
    private WidiMonitor mWidiMonitor;
    private WidiNative mWidiNative;
    private State mWidiNotSupportedState;
    private final AtomicInteger mWidiState;
    private WifiManager mWifiManager;
    private String wfdIf;

    /* renamed from: com.mstar.android.widi.WidiStateMachine.1 */
    class C02391 implements Runnable {
        C02391() {
        }

        public void run() {
            String serverIp = "";
            SystemProperties.set("dhcp." + WidiStateMachine.this.mInterface + ".server", "");
            WidiStateMachine.this.log("mInterface = " + WidiStateMachine.this.mInterface);
            if (WidiStateMachine.this.dhcpDoRequest(WidiStateMachine.this.mInterface) == 0) {
                serverIp = SystemProperties.get("dhcp." + WidiStateMachine.this.mInterface + ".server");
                WidiStateMachine.this.mWidiNative;
                WidiNative.sendWidiCmd("SERVERIP=" + serverIp);
                WidiStateMachine.this.log("serverIp = " + serverIp);
                return;
            }
            WidiStateMachine.this.log("can't get serverIp, timeout...");
        }
    }

    class DefaultState extends State {
        DefaultState() {
        }

        public boolean processMessage(Message message) {
            return WidiStateMachine.DBG;
        }
    }

    class DriverLoadedState extends State {
        DriverLoadedState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_LOAD_DRIVER_FAILURE);
            WidiStateMachine.this.log("driver loaded, start monitor...");
            WidiStateMachine.this.mWidiMonitor.startMonitor();
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiStateMachine.CMD_UNLOAD_DRIVER /*2*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverUnloadingState);
                    break;
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                case WidiMonitor.WIDI_START_SUCCESS_EVENT /*17*/:
                    WidiStateMachine.adapterName = WidiStateMachine.this.getAdapterName();
                    WidiStateMachine.adapterId = WidiStateMachine.this.getAdapterId(WidiStateMachine.this.l2sdIf);
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiDisconnectedState);
                    break;
                case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                    WidiStateMachine.this.ensureWidiQuit();
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverUnloadingState);
                    break;
            }
            return false;
        }
    }

    class DriverLoadingState extends State {

        /* renamed from: com.mstar.android.widi.WidiStateMachine.DriverLoadingState.1 */
        class C02401 implements Runnable {
            C02401() {
            }

            public void run() {
                String usb_init_done = SystemProperties.get("wlan.detect.ready", null);
                while (!usb_init_done.equals("1")) {
                    try {
                        WidiStateMachine.this.log("sleep until usb init done");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WidiStateMachine.this.setWidiAttr();
                WidiStateMachine.this.log("widi deivce = " + WidiStateMachine.this.mWidiDeviceName);
                if (WidiStateMachine.this.isDriverSupportWidi()) {
                    WidiStateMachine.this.mWidiNative;
                    if (!WidiNative.loadWidiDriver(WidiStateMachine.this.mWidiDeviceName)) {
                        WidiStateMachine.this.log("load driver failure");
                        WidiStateMachine.this.sendMessage(WidiStateMachine.CMD_LOAD_DRIVER_FAILURE);
                        return;
                    } else if (WidiStateMachine.this.ensureWidiDriverWorked()) {
                        WidiStateMachine.this.log("load driver success");
                        WidiStateMachine.this.sendMessage(WidiStateMachine.CMD_LOAD_DRIVER_SUCCESS);
                        return;
                    } else {
                        return;
                    }
                }
                WidiStateMachine.this.sendMessage(WidiStateMachine.this.obtainMessage(WidiStateMachine.CMD_WIDI_NOT_SUPPORT));
            }
        }

        DriverLoadingState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_LOAD_DRIVER_SUCCESS);
            new Thread(new C02401()).start();
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiStateMachine.CMD_LOAD_DRIVER_SUCCESS /*3*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverLoadedState);
                    break;
                case WidiStateMachine.CMD_LOAD_DRIVER_FAILURE /*4*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverUnloadedState);
                    break;
                case WidiStateMachine.CMD_WIDI_NOT_SUPPORT /*7*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiNotSupportedState);
                    break;
            }
            return false;
        }
    }

    class DriverUnloadedState extends State {
        DriverUnloadedState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_LOAD_DRIVER);
            if (WidiStateMachine.this.mWifiManager.getWifiState() != WidiStateMachine.CMD_LOAD_DRIVER || WidiStateMachine.this.mWifiManager.getWifiApState() != 11) {
                WidiStateMachine.this.setWifiDisabled();
            }
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiStateMachine.CMD_LOAD_DRIVER /*1*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverLoadingState);
                    break;
            }
            return false;
        }
    }

    class DriverUnloadingState extends State {

        /* renamed from: com.mstar.android.widi.WidiStateMachine.DriverUnloadingState.1 */
        class C02411 implements Runnable {
            C02411() {
            }

            public void run() {
                WidiStateMachine.this.mWidiNative;
                if (WidiNative.unloadWidiDriver(WidiStateMachine.this.mWidiDeviceName)) {
                    WidiStateMachine.this.log("unload driver success");
                    WidiStateMachine.this.sendMessage(WidiStateMachine.CMD_UNLOAD_DRIVER_SUCCESS);
                    return;
                }
                WidiStateMachine.this.log("unload driver failure");
                WidiStateMachine.this.sendMessage(WidiStateMachine.CMD_UNLOAD_DRIVER_FAILURE);
            }
        }

        DriverUnloadingState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_UNLOAD_DRIVER);
            new Thread(new C02411()).start();
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiStateMachine.CMD_UNLOAD_DRIVER_SUCCESS /*5*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverUnloadedState);
                    break;
                case WidiStateMachine.CMD_UNLOAD_DRIVER_FAILURE /*6*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mDriverLoadedState);
                    break;
            }
            return false;
        }
    }

    class ObtainingIpState extends State {
        ObtainingIpState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(9);
            WidiStateMachine.this.rundhcp(WidiStateMachine.this.mInterface);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mShowScreenState);
                    break;
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                case WidiMonitor.WIDI_DHCP_FAIL_EVENT /*23*/:
                    WidiStateMachine.this.releaseDhcp(WidiStateMachine.this.mInterface);
                    WidiStateMachine.this.stopDhcp();
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiDisconnectedState);
                    break;
            }
            return false;
        }
    }

    class ShowPinState extends State {
        ShowPinState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_WIDI_NOT_SUPPORT, WidiStateMachine.pinCode);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                    WidiStateMachine.this.mInterface = (String) message.obj;
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mObtainingIpState);
                    break;
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                case WidiMonitor.WIDI_AUTHENTICATE_FAIL_EVENT /*22*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiDisconnectedState);
                    break;
            }
            return false;
        }
    }

    class ShowScreenState extends State {
        ShowScreenState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(10);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                    WidiStateMachine.this.releaseDhcp(WidiStateMachine.this.mInterface);
                    WidiStateMachine.this.stopDhcp();
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiDisconnectedState);
                    break;
            }
            return false;
        }
    }

    class WidiConnectedState extends State {
        WidiConnectedState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(8);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            return WidiStateMachine.DBG;
        }
    }

    class WidiConnectingState extends State {
        WidiConnectingState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_UNLOAD_DRIVER_FAILURE);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                    WidiStateMachine.this.mInterface = (String) message.obj;
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mObtainingIpState);
                    break;
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                case WidiMonitor.WIDI_CONNECTION_FAIL_EVENT /*21*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiDisconnectedState);
                    break;
            }
            return false;
        }
    }

    class WidiDisconnectedState extends State {
        WidiDisconnectedState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
            WidiStateMachine.this.setWidiState(WidiStateMachine.CMD_UNLOAD_DRIVER_SUCCESS, WidiStateMachine.adapterName, WidiStateMachine.adapterId);
        }

        public boolean processMessage(Message message) {
            WidiStateMachine.this.log(getName() + message.toString() + "\n");
            switch (message.what) {
                case SmbConstants.SIGNATURE_OFFSET /*14*/:
                    WidiStateMachine.pinCode = (String) message.obj;
                    WidiStateMachine.this.log("start show pincode = " + WidiStateMachine.pinCode);
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mShowPinState);
                    break;
                case WidiMonitor.WIDI_CONNECTING_EVENT /*25*/:
                    WidiStateMachine.this.transitionTo(WidiStateMachine.this.mWidiConnectingState);
                    break;
            }
            return false;
        }
    }

    class WidiNotSupportedState extends State {
        WidiNotSupportedState() {
        }

        public void enter() {
            WidiStateMachine.this.log(WidiStateMachine.ENTER + getName() + "\n");
        }

        public boolean processMessage(Message message) {
            return false;
        }
    }

    static {
        adapterName = "Mstar Widi";
        adapterId = DEFAULT_ID;
        previousWidiState = CMD_LOAD_DRIVER;
        currentWidiState = CMD_LOAD_DRIVER;
    }

    public WidiStateMachine(Context context) {
        super(TAG);
        this.mWidiDeviceName = mVendorRtl8192cu;
        this.l2sdIf = "ra0";
        this.wfdIf = "p2p0";
        this.mInterface = this.l2sdIf;
        this.mDefaultState = new DefaultState();
        this.mWidiNotSupportedState = new WidiNotSupportedState();
        this.mDriverUnloadedState = new DriverUnloadedState();
        this.mDriverUnloadingState = new DriverUnloadingState();
        this.mDriverLoadingState = new DriverLoadingState();
        this.mDriverLoadedState = new DriverLoadedState();
        this.mWidiDisconnectedState = new WidiDisconnectedState();
        this.mWidiConnectingState = new WidiConnectingState();
        this.mShowPinState = new ShowPinState();
        this.mWidiConnectedState = new WidiConnectedState();
        this.mObtainingIpState = new ObtainingIpState();
        this.mShowScreenState = new ShowScreenState();
        this.mWidiState = new AtomicInteger(CMD_LOAD_DRIVER);
        this.mContext = context;
        this.mWidiNative = new WidiNative();
        this.mWidiMonitor = new WidiMonitor(this, this.mWidiNative);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        addState(this.mDefaultState);
        addState(this.mWidiNotSupportedState, this.mDefaultState);
        addState(this.mDriverUnloadedState, this.mDefaultState);
        addState(this.mDriverUnloadingState, this.mDefaultState);
        addState(this.mDriverLoadingState, this.mDefaultState);
        addState(this.mDriverLoadedState, this.mDefaultState);
        addState(this.mWidiDisconnectedState, this.mDriverLoadedState);
        addState(this.mWidiConnectingState, this.mDriverLoadedState);
        addState(this.mShowPinState, this.mDriverLoadedState);
        addState(this.mWidiConnectedState, this.mDriverLoadedState);
        addState(this.mObtainingIpState, this.mWidiConnectedState);
        addState(this.mShowScreenState, this.mWidiConnectedState);
        setInitialState(this.mDriverUnloadedState);
        log("state machine start");
        start();
    }

    public void startWidi() {
        log("start widi..");
        sendMessage(obtainMessage(CMD_LOAD_DRIVER));
    }

    public void stopWidi() {
        WidiNative widiNative = this.mWidiNative;
        WidiNative.sendWidiCmd("WIDI_STOP");
    }

    private void ensureWidiQuit() {
        WidiNative widiNative = this.mWidiNative;
        WidiNative.closeWidiConnection();
        releaseDhcp(this.mInterface);
        stopDhcp();
    }

    private boolean isDriverSupportWidi() {
        String widiDeviceName = SystemProperties.get("wlan.driver", null);
        log("wlan.driver = " + widiDeviceName);
        if (widiDeviceName.equals(mVendorRtl8192cu) || widiDeviceName.equals(mVendorRtl8192eu) || widiDeviceName.equals(mVendorRal5370) || widiDeviceName.equals(mVendorAth1021) || widiDeviceName.equals(mVendorAth9374) || widiDeviceName.equals(mVendorAth9375)) {
            log("driver support widi");
            return DBG;
        }
        log("not support widi");
        return false;
    }

    private void setWidiAttr() {
        String widiDeviceName = SystemProperties.get("wlan.driver", null);
        log("wlan.driver = " + widiDeviceName);
        if (widiDeviceName == null) {
            log("Not a widi device");
        } else if (widiDeviceName.equals(mVendorRtl8192cu)) {
            this.mWidiDeviceName = mVendorRtl8192cu;
            this.l2sdIf = "wlan0";
            this.wfdIf = "wlan0";
        } else if (widiDeviceName.equals(mVendorRtl8192eu)) {
            this.mWidiDeviceName = mVendorRtl8192eu;
            this.l2sdIf = "wlan0";
            this.wfdIf = "wlan0";
        } else if (widiDeviceName.equals(mVendorRal5370)) {
            this.mWidiDeviceName = mVendorRal5370;
            this.l2sdIf = "ra0";
            this.wfdIf = "p2p0";
        } else if (widiDeviceName.equals(mVendorAth1021)) {
            this.mWidiDeviceName = mVendorAth1021;
            this.l2sdIf = "wlan0";
            this.wfdIf = "p2p0";
        } else if (widiDeviceName.equals(mVendorAth9374)) {
            this.mWidiDeviceName = mVendorAth9374;
            this.l2sdIf = "wlan0";
            this.wfdIf = "p2p0";
        } else if (widiDeviceName.equals(mVendorAth9375)) {
            this.mWidiDeviceName = mVendorAth9375;
            this.l2sdIf = "wlan0";
            this.wfdIf = "p2p0";
        } else {
            this.mWidiDeviceName = mVendorRtl8192cu;
            this.l2sdIf = "wlan0";
            this.wfdIf = "wlan0";
        }
    }

    private void setWidiState(int widiState) {
        setWidiState(widiState, adapterName, adapterId);
    }

    private void setWidiState(int widiState, String pinCode) {
        setWidiState(widiState, pinCode, adapterId);
    }

    private void setWidiState(int widiState, String arg1, String arg2) {
        previousWidiState = this.mWidiState.get();
        this.mWidiState.set(widiState);
        currentWidiState = this.mWidiState.get();
        if (previousWidiState != currentWidiState) {
            log("==============================");
            log("Widi state:" + previousWidiState + " -> " + currentWidiState);
            log("arg1:" + arg1 + " arg2:" + arg2);
            log("==============================");
            Intent intent = new Intent(WidiManager.WIDI_STATE_CHANGED_ACTION);
            intent.addFlags(134217728);
            intent.putExtra(WidiManager.EXTRA_PREVIOUS_WIDI_STATE, previousWidiState);
            intent.putExtra(WidiManager.EXTRA_CURRENT_WIDI_STATE, currentWidiState);
            intent.putExtra(WidiManager.EXTRA_ARG1, arg1);
            intent.putExtra(WidiManager.EXTRA_ARG2, arg2);
            this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
        }
    }

    private void stopDhcp() {
        log("stop dhcp");
        String resultPropName = "dhcp." + this.mInterface + ".result";
        SystemProperties.set("ctl.stop", "dhcpcd_" + this.mInterface);
        SystemProperties.set(resultPropName, "");
        SystemProperties.set("dhcp." + this.mInterface + ".server", "");
    }

    private void releaseDhcp(String intf) {
        log("relese dhcp : " + intf);
        SystemProperties.set("ctl.start", "dhcpcd_release:" + intf);
    }

    private void rundhcp(String iface) {
        log("run dhcp");
        if ("".equals(iface)) {
            this.mInterface = this.wfdIf;
        } else {
            this.mInterface = iface;
        }
        new Thread(new C02391()).start();
    }

    private int dhcpDoRequest(String iface) {
        log("requst for ip");
        String daemonCmd = "dhcpcd_" + iface + ":" + iface + " -d";
        String daemonPropName = "init.svc.dhcpcd_" + iface;
        String propValue = "";
        String resultPropName = "dhcp." + iface + ".result";
        SystemProperties.set(resultPropName, "");
        SystemProperties.set("ctl.start", daemonCmd);
        if (waitForProperty(daemonPropName, "running", 10) < 0) {
            log("Time out waiting for dhcp start");
            return -1;
        } else if (waitForProperty(resultPropName, "ok", 35) < 0) {
            log("Time out waiting for dhcp get ip");
            return -1;
        } else if (SystemProperties.get(resultPropName).equals("ok")) {
            return BASE;
        } else {
            log("dhcp result property not set");
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int waitForProperty(java.lang.String r7, java.lang.String r8, int r9) {
        /*
        r6 = this;
        r3 = "";
        r2 = "";
        r1 = r9;
    L_0x0005:
        r9 = r1 + -1;
        if (r1 <= 0) goto L_0x005b;
    L_0x0009:
        r4 = 0;
        r3 = android.os.SystemProperties.get(r7, r4);
        if (r8 == 0) goto L_0x0016;
    L_0x0010:
        r4 = r3.equals(r8);
        if (r4 == 0) goto L_0x002e;
    L_0x0016:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "value = desiredValue = ";
        r4 = r4.append(r5);
        r4 = r4.append(r3);
        r4 = r4.toString();
        r6.log(r4);
        r4 = 0;
    L_0x002d:
        return r4;
    L_0x002e:
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0055 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x0055 }
        r5 = "Waiting for property = ";
        r4 = r4.append(r5);	 Catch:{ InterruptedException -> 0x0055 }
        r4 = r4.append(r8);	 Catch:{ InterruptedException -> 0x0055 }
        r5 = " Now value = ";
        r4 = r4.append(r5);	 Catch:{ InterruptedException -> 0x0055 }
        r4 = r4.append(r3);	 Catch:{ InterruptedException -> 0x0055 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x0055 }
        r6.log(r4);	 Catch:{ InterruptedException -> 0x0055 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0055 }
        r1 = r9;
        goto L_0x0005;
    L_0x0055:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = r9;
        goto L_0x0005;
    L_0x005b:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "time out waiting for property ";
        r4 = r4.append(r5);
        r4 = r4.append(r8);
        r4 = r4.toString();
        r6.log(r4);
        r4 = -1;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.widi.WidiStateMachine.waitForProperty(java.lang.String, java.lang.String, int):int");
    }

    private void setWifiDisabled() {
        log("before load widi driver, disable wifi first...");
        if (this.mWifiManager.getWifiState() != CMD_LOAD_DRIVER) {
            this.mWifiManager.setWifiEnabled(false);
        } else if (this.mWifiManager.getWifiState() != 11) {
            this.mWifiManager.setWifiApEnabled(null, false);
        }
        while (true) {
            int wifiState = this.mWifiManager.getWifiState();
            WifiManager wifiManager = this.mWifiManager;
            if (wifiState == CMD_LOAD_DRIVER) {
                wifiState = this.mWifiManager.getWifiApState();
                wifiManager = this.mWifiManager;
                if (wifiState == 11) {
                    return;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("wait for disable wifi...");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ensureWidiDriverWorked() {
        /*
        r6 = this;
        r0 = 10;
        r2 = new java.io.File;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "/sys/class/net/";
        r4 = r4.append(r5);
        r5 = r6.l2sdIf;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2.<init>(r4);
        r3 = new java.io.File;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "/sys/class/net/";
        r4 = r4.append(r5);
        r5 = r6.wfdIf;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4);
    L_0x0036:
        r4 = r2.exists();
        if (r4 == 0) goto L_0x0042;
    L_0x003c:
        r4 = r3.exists();
        if (r4 != 0) goto L_0x0051;
    L_0x0042:
        if (r0 <= 0) goto L_0x0051;
    L_0x0044:
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x004c }
    L_0x0049:
        r0 = r0 + -1;
        goto L_0x0036;
    L_0x004c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0049;
    L_0x0051:
        r2 = 0;
        r3 = 0;
        if (r0 > 0) goto L_0x005c;
    L_0x0055:
        r4 = "driver not load well";
        r6.log(r4);
        r4 = 0;
    L_0x005b:
        return r4;
    L_0x005c:
        r4 = "driver load well";
        r6.log(r4);
        r4 = 1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.widi.WidiStateMachine.ensureWidiDriverWorked():boolean");
    }

    private String loadFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer(MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[HttpTransport.DEFAULT_CHUNK_LENGTH];
        while (true) {
            int numRead = reader.read(buf);
            if (numRead != -1) {
                fileData.append(String.valueOf(buf, BASE, numRead));
            } else {
                reader.close();
                return fileData.toString();
            }
        }
    }

    public String getAdapterName() {
        try {
            String result = loadFileAsString(adapterConfig);
            if (result == null) {
                return DEFAULT_FAMILY_NAME;
            }
            String[] tmp = result.split("\n");
            for (int i = BASE; tmp[i] != null; i += CMD_LOAD_DRIVER) {
                if (tmp[i].startsWith("friendly_name")) {
                    String[] tmp1 = tmp[i].split("=");
                    log("friendly_name = " + tmp1[CMD_LOAD_DRIVER]);
                    return tmp1[CMD_LOAD_DRIVER];
                }
            }
            return DEFAULT_FAMILY_NAME;
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_FAMILY_NAME;
        }
    }

    private String getMacAddress(String iface) {
        try {
            return loadFileAsString("/sys/class/net/" + iface + "/address").toUpperCase().substring(BASE, 17);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAdapterId(String iface) {
        String macAddress = "";
        String result = "";
        macAddress = getMacAddress(iface);
        if (macAddress == null) {
            return DEFAULT_ID;
        }
        String[] tmp = macAddress.split(":");
        if (tmp == null) {
            return DEFAULT_ID;
        }
        for (int i = CMD_LOAD_DRIVER_FAILURE; i < tmp.length; i += CMD_LOAD_DRIVER) {
            result = result + tmp[i];
        }
        log("getAdapterId = " + result);
        return result;
    }

    public void log(String s) {
        Log.d(TAG, s);
    }
}
