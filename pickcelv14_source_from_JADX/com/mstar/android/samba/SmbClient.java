package com.mstar.android.samba;

import com.mstar.android.MKeyEvent;
import com.mstar.android.widi.WidiMonitor;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import jcifs.Config;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public class SmbClient {
    private static final int MAX_THREAD_COUNT = 8;
    private static final int bit0 = 1;
    private static final int bit1 = 2;
    private static final int bit10 = 1024;
    private static final int bit11 = 2048;
    private static final int bit12 = 4096;
    private static final int bit13 = 8192;
    private static final int bit14 = 16384;
    private static final int bit15 = 32768;
    private static final int bit2 = 4;
    private static final int bit3 = 8;
    private static final int bit4 = 16;
    private static final int bit5 = 32;
    private static final int bit6 = 64;
    private static final int bit7 = 128;
    private static final int bit8 = 256;
    private static final int bit9 = 512;
    private static boolean logEnable = false;
    private static final String smbclient_version = "00.14";
    private int ScanCompleted;
    ArrayList<SmbDevice> deviceList;
    private boolean isScanning;
    private OnRecvMsgListener onRecvMsglistener;
    private volatile boolean stoprun;
    private int timeout;

    class scanHostByPing implements Runnable {
        OnRecvMsgListener callback;
        int endIndex;
        int startIndex;
        String startIp;
        int threadid;

        scanHostByPing(String SmbURL, int threadID, int startindex, int endindex, OnRecvMsgListener callback) {
            this.startIp = null;
            this.startIp = SmbURL;
            this.callback = callback;
            this.startIndex = startindex;
            this.endIndex = endindex;
            this.threadid = threadID;
        }

        public void run() {
            if (this.startIp != null) {
                int lastDotIndex = this.startIp.lastIndexOf(46);
                String newStr = this.startIp.substring(0, lastDotIndex + SmbClient.bit0);
                int ipNum = Integer.parseInt(this.startIp.substring(lastDotIndex + SmbClient.bit0, this.startIp.length()));
                if (SmbClient.logEnable) {
                    System.out.println("start ip : " + newStr);
                    System.out.println(" ip : " + ipNum);
                }
                int loop = this.startIndex;
                while (loop <= this.endIndex && !SmbClient.this.stoprun && loop <= MKeyEvent.KEYCODE_SLEEP && loop >= SmbClient.bit0) {
                    if (!(ipNum == loop || loop == SmbClient.bit0)) {
                        String tmp = newStr + loop;
                        if (SmbClient.this.pingHost(tmp, SmbClient.this.timeout)) {
                            synchronized (this) {
                                SmbClient.this.deviceList.add(new SmbDevice(tmp));
                                this.callback.onRecvMsgListener(3);
                            }
                        } else {
                            continue;
                        }
                    }
                    loop += SmbClient.bit0;
                }
                switch (this.threadid) {
                    case SmbClient.bit0 /*1*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit0);
                        break;
                    case SmbClient.bit1 /*2*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit1);
                        break;
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit2);
                        break;
                    case SmbClient.bit2 /*4*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit3);
                        break;
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit4);
                        break;
                    case SID.SID_TYPE_DELETED /*6*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit5);
                        break;
                    case SID.SID_TYPE_INVALID /*7*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit6);
                        break;
                    case SmbClient.bit3 /*8*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit7);
                        break;
                    case SmbConstants.FLAGS_OFFSET /*9*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit8);
                        break;
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit9);
                        break;
                    case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit10);
                        break;
                    case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit11);
                        break;
                    case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit12);
                        break;
                    case SmbConstants.SIGNATURE_OFFSET /*14*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit13);
                        break;
                    case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit14);
                        break;
                    case SmbClient.bit4 /*16*/:
                        SmbClient.access$476(SmbClient.this, SmbClient.bit15);
                        break;
                }
                if ((SmbClient.this.ScanCompleted & MKeyEvent.KEYCODE_SLEEP) == MKeyEvent.KEYCODE_SLEEP) {
                    SmbClient.this.isScanning = false;
                    if (SmbClient.this.stoprun) {
                        this.callback.onRecvMsgListener(SmbClient.bit0);
                    } else {
                        this.callback.onRecvMsgListener(SmbClient.bit1);
                    }
                }
            }
        }
    }

    public SmbClient() {
        this.deviceList = new ArrayList();
        this.timeout = NanoHTTPD.SOCKET_READ_TIMEOUT;
        this.isScanning = false;
        this.stoprun = false;
        this.onRecvMsglistener = null;
    }

    static /* synthetic */ int access$476(SmbClient x0, int x1) {
        int i = x0.ScanCompleted | x1;
        x0.ScanCompleted = i;
        return i;
    }

    static {
        logEnable = false;
    }

    public void updateSmbDeviceList() {
        this.deviceList.clear();
        String SmbURL = getLocalIP();
        if (SmbURL == null) {
            System.out.println("no ip address!");
            if (this.onRecvMsglistener != null) {
                this.onRecvMsglistener.onRecvMsgListener(bit0);
            }
        } else if (SmbURL.contentEquals("127.0.0.1") || this.onRecvMsglistener == null || SmbURL.contains(":")) {
            this.isScanning = false;
            System.out.println("no ip address or recv listener! ");
            if (this.onRecvMsglistener != null) {
                this.onRecvMsglistener.onRecvMsgListener(bit0);
            }
        } else {
            ArrayList<Thread> scanThread = new ArrayList();
            this.ScanCompleted = 0;
            for (int i = 0; i < bit3; i += bit0) {
                scanThread.add(new Thread(new scanHostByPing(SmbURL, i + bit0, ((i * bit8) / bit3) + bit0, ((i * bit8) / bit3) + bit5, this.onRecvMsglistener)));
                if (scanThread.get(i) != null) {
                    ((Thread) scanThread.get(i)).start();
                    this.isScanning = true;
                }
            }
        }
    }

    public ArrayList<SmbDevice> getSmbDeviceList() {
        return this.deviceList;
    }

    public void setOnRecvMsgListener(OnRecvMsgListener onRecvMsglistener) {
        this.onRecvMsglistener = onRecvMsglistener;
    }

    public boolean isUpdating() {
        return this.isScanning;
    }

    public void StopUpdate() {
        this.stoprun = true;
    }

    public void SetPingTimeout(int Timeout) {
        if (Timeout > 100) {
            this.timeout = Timeout;
        }
    }

    public static void initSamba() {
        System.out.println("   smbclient_version : 00.14");
        Config.setProperty("jcifs.encoding", "GBK");
        Config.setProperty("jcifs.smb.lmCompatibility", "0");
        Config.setProperty("jcifs.smb.client.responseTimeout", "10000");
        Config.setProperty("jcifs.netbios.retryTimeout", "10000");
        Config.setProperty("jcifs.smb.client.dfs.disabled", "true");
        Config.registerSmbURLHandler();
    }

    private boolean pingHost(String host, int timeout) {
        boolean ret = false;
        try {
            ret = InetAddress.getByName(host).isReachable(timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pingCommand = "ping  -w " + timeout + " " + host + " " + ret;
        if (logEnable) {
            System.out.println(pingCommand);
        }
        return ret;
    }

    private String getLocalIP() {
        String ip = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        ip = inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.println("WifiPreference IpAddress" + ex.toString());
        }
        System.out.println("ip addr=:" + ip);
        return ip;
    }
}
