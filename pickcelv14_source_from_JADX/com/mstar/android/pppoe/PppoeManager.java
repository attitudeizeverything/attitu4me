package com.mstar.android.pppoe;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import com.mstar.android.pppoe.IPppoeManager.Stub;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PppoeManager {
    public static final int MSG_PPPOE_AUTH_FAILED = 4;
    public static final int MSG_PPPOE_CONNECT = 0;
    public static final int MSG_PPPOE_CONNECTING = 2;
    public static final int MSG_PPPOE_DISCONNECT = 1;
    public static final int MSG_PPPOE_DISCONNECTING = 3;
    public static final int MSG_PPPOE_FAILED = 6;
    public static final int MSG_PPPOE_TIME_OUT = 5;
    private static final String NET_INTERFACE = "net_if";
    private static final String PASS_WORD = "pass_word";
    public static final String PPPOE_STATE_ACTION = "com.mstar.android.pppoe.PPPOE_STATE_ACTION";
    public static final String PPPOE_STATE_AUTHFAILED = "authfailed";
    public static final String PPPOE_STATE_CONNECT = "connect";
    public static final String PPPOE_STATE_CONNECTING = "connecting";
    public static final String PPPOE_STATE_DISCONNECT = "disconnect";
    public static final String PPPOE_STATE_DISCONNECTING = "disconnecting";
    public static final String PPPOE_STATE_FAILED = "failed";
    public static final String PPPOE_STATE_LINKTIMEOUT = "linktimeout";
    public static final String PPPOE_STATE_STATUE = "PppoeStatus";
    private static final String TAG = "PppoeManager";
    private static final String USER_NAME = "user_name";
    static PppoeManager mInstance;
    static final Object mInstanceSync;
    private static Thread mSocketThread;
    private PPPOE_STA gpppoe_sta;
    private boolean mIsDialing;
    IPppoeManager mService;
    private String netif;
    private String passwd;
    private String user;

    /* renamed from: com.mstar.android.pppoe.PppoeManager.1 */
    class C00961 extends Thread {
        final /* synthetic */ String val$account;
        final /* synthetic */ String val$net;
        final /* synthetic */ String val$password;

        C00961(String x0, String str, String str2, String str3) {
            this.val$account = str;
            this.val$password = str2;
            this.val$net = str3;
            super(x0);
        }

        public void run() {
            PppoeManager.this.PppoeSetUser(this.val$account);
            PppoeManager.this.PppoeSetPW(this.val$password);
            PppoeManager.this.PppoeSetInterface(this.val$net);
            PppoeManager.this.PppoeDialup();
        }
    }

    /* renamed from: com.mstar.android.pppoe.PppoeManager.2 */
    class C00972 extends Thread {
        C00972() {
        }

        public void run() {
            do {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Log.e(PppoeManager.TAG, "InterruptedException: " + e.getMessage());
                }
            } while (PppoeManager.this.isPppoeRunning());
            String currPppState = PppoeManager.this.getPppoeStatus();
            if (currPppState.equals(PppoeManager.PPPOE_STATE_AUTHFAILED)) {
                PppoeManager.this.setPppoeStatus(PppoeManager.PPPOE_STATE_AUTHFAILED, true);
            } else if (!PppoeManager.PPPOE_STATE_CONNECT.equals(currPppState)) {
                PppoeManager.this.setPppoeStatus(PppoeManager.PPPOE_STATE_DISCONNECT, true);
            }
            PppoeManager.this.updatePppoeStatus();
            PppoeManager.this.mIsDialing = false;
        }
    }

    static {
        mSocketThread = null;
        mInstanceSync = new Object();
        mInstance = null;
    }

    private PppoeManager(IPppoeManager service) {
        this.mIsDialing = false;
        this.user = null;
        this.passwd = null;
        this.netif = null;
        this.gpppoe_sta = PPPOE_STA.DISCONNECTED;
        this.mService = null;
        this.mService = service;
        init();
    }

    public static PppoeManager getInstance() {
        if (mInstance == null) {
            synchronized (mInstanceSync) {
                if (mInstance == null) {
                    mInstance = new PppoeManager(Stub.asInterface(ServiceManager.getService("pppoe")));
                }
            }
        }
        return mInstance;
    }

    public void connectPppoe(String account, String password) {
        connectPppoe(account, password, "eth0");
    }

    public void connectPppoe(String account, String password, String net) {
        Log.i(TAG, "connectPppoe");
        new C00961("pppoe_dialup_thread", account, password, net).start();
    }

    public void disconnectPppoe() {
        Log.i(TAG, "disconnectPppoe");
        PppoeHangUp();
    }

    public String getInterfaceName() {
        return readPppInfoFromFile("ifname");
    }

    public String getIpaddr() {
        return readPppInfoFromFile("ip");
    }

    public String getRoute() {
        return readPppInfoFromFile("route");
    }

    public String getMask() {
        return readPppInfoFromFile("mask");
    }

    public String getDns1() {
        return readPppInfoFromFile("dns1");
    }

    public String getDns2() {
        return readPppInfoFromFile("dns2");
    }

    private void setPppoeStatus(String status, boolean sendBroadcast) {
        try {
            this.mService.setPppoeStatus(status, sendBroadcast);
        } catch (RemoteException e) {
        }
    }

    public String getPppoeStatus() {
        try {
            return this.mService.getPppoeStatus();
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean PppoeSetInterface(String pu8NetIf) {
        if (pu8NetIf == null || pu8NetIf.equals("")) {
            return false;
        }
        this.netif = pu8NetIf;
        writeFile();
        setup();
        return true;
    }

    public boolean PppoeSetUser(String Suser) {
        if (Suser == null || Suser.equals("")) {
            return false;
        }
        this.user = Suser;
        writeFile();
        setup();
        return true;
    }

    public boolean PppoeSetPW(String Spasswd) {
        if (Spasswd == null || Spasswd.equals("")) {
            return false;
        }
        this.passwd = Spasswd;
        writeFile();
        setup();
        return true;
    }

    private synchronized void writeFile() {
        IOException e;
        Throwable th;
        FileWriter fw = null;
        try {
            FileWriter fw2 = new FileWriter("/data/misc/ppp/pppoe.data");
            try {
                fw2.write("user_name=" + this.user + "\n");
                fw2.write("pass_word=" + this.passwd + "\n");
                fw2.write("net_if=" + this.netif + "\n");
                if (fw2 != null) {
                    try {
                        fw2.close();
                        fw = fw2;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        fw = fw2;
                    } catch (Throwable th2) {
                        th = th2;
                        fw = fw2;
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                fw = fw2;
                try {
                    e2.printStackTrace();
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fw = fw2;
                if (fw != null) {
                    fw.close();
                }
                throw th;
            }
        } catch (IOException e4) {
            e222 = e4;
            e222.printStackTrace();
            if (fw != null) {
                fw.close();
            }
        }
    }

    private void setup() {
        SystemProperties.set("ctl.start", "pppoe-setup");
        do {
        } while (isSetupRunning());
    }

    private boolean isSetupRunning() {
        String ret = SystemProperties.get("init.svc.pppoe-setup", "");
        if (ret == null || !ret.equals("stopped")) {
            return true;
        }
        return false;
    }

    public boolean PppoeDialup() {
        if (this.mIsDialing) {
            Log.w(TAG, "you can NOT dial up again when dialing");
            return false;
        }
        this.mIsDialing = true;
        PppoeSetStatus(PPPOE_STA.CONNECTING);
        setPppoeStatus(PPPOE_STATE_CONNECTING, true);
        connect();
        new C00972().start();
        Log.i(TAG, "PppoeDialup");
        return true;
    }

    public void PppoeHangUp() {
        stop();
        PppoeSetStatus(PPPOE_STA.DISCONNECTED);
        setPppoeStatus(PPPOE_STATE_DISCONNECT, true);
        Log.i(TAG, "PppoeHangUp");
    }

    public void PppoeMonitor() {
    }

    public PPPOE_STA PppoeGetStatus() {
        if (this.gpppoe_sta != PPPOE_STA.CONNECTING) {
            updatePppoeStatus();
        }
        return this.gpppoe_sta;
    }

    public String PppoeGetUser() {
        return readSettingInfoFromFile(USER_NAME);
    }

    public String PppoeGetPW() {
        return readSettingInfoFromFile(PASS_WORD);
    }

    public String PppoeGetInterface() {
        return readSettingInfoFromFile(NET_INTERFACE);
    }

    private void connect() {
        SystemProperties.set("ctl.start", "pppoe-start");
    }

    private void stop() {
        SystemProperties.set("ctl.start", "pppoe-stop");
    }

    private void PppoeSetStatus(PPPOE_STA status) {
        this.gpppoe_sta = status;
    }

    private void updatePppoeStatus() {
        if (getPppoeStatus().equals(PPPOE_STATE_CONNECT)) {
            PppoeSetStatus(PPPOE_STA.CONNECTED);
        } else {
            PppoeSetStatus(PPPOE_STA.DISCONNECTED);
        }
    }

    private void init() {
        PppoeGetInfo();
        updatePppoeStatus();
    }

    private void PppoeGetInfo() {
        this.user = PppoeGetUser();
        this.passwd = PppoeGetPW();
        this.netif = PppoeGetInterface();
    }

    public boolean isPppoeRunning() {
        String ret = SystemProperties.get("init.svc.pppoe-start", "");
        if (ret == null || !ret.equals("stopped")) {
            return true;
        }
        return false;
    }

    private String readSettingInfoFromFile(String what) {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        String result = null;
        if (what == null) {
            return null;
        }
        File pppInfoFile = new File("/data/misc/ppp/pppoe.data");
        if (!pppInfoFile.exists()) {
            return null;
        }
        BufferedReader br = null;
        try {
            String[] pppInfo;
            BufferedReader br2 = new BufferedReader(new FileReader(pppInfoFile));
            while (true) {
                try {
                    String s = br2.readLine();
                    if (s == null) {
                        break;
                    }
                    pppInfo = s.split("=");
                    if (pppInfo != null && pppInfo.length == MSG_PPPOE_CONNECTING && what.equals(pppInfo[MSG_PPPOE_CONNECT])) {
                        break;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    br = br2;
                } catch (IOException e4) {
                    e2 = e4;
                    br = br2;
                } catch (Throwable th2) {
                    th = th2;
                    br = br2;
                }
            }
            result = pppInfo[MSG_PPPOE_DISCONNECT];
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e5) {
                    Log.e(TAG, "failure to close BufferedReader");
                    br = br2;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            try {
                e.printStackTrace();
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e7) {
                        Log.e(TAG, "failure to close BufferedReader");
                    }
                }
                return result;
            } catch (Throwable th3) {
                th = th3;
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e8) {
                        Log.e(TAG, "failure to close BufferedReader");
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e2 = e9;
            e2.printStackTrace();
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e10) {
                    Log.e(TAG, "failure to close BufferedReader");
                }
            }
            return result;
        }
        return result;
    }

    private String readPppInfoFromFile(String what) {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        String result = null;
        if (what == null) {
            return null;
        }
        int readLineNum = -1;
        if ("ifname".equals(what)) {
            readLineNum = MSG_PPPOE_DISCONNECT;
        } else if ("ip".equals(what)) {
            readLineNum = MSG_PPPOE_CONNECTING;
        } else if ("route".equals(what)) {
            readLineNum = MSG_PPPOE_DISCONNECTING;
        } else if ("mask".equals(what)) {
            readLineNum = MSG_PPPOE_AUTH_FAILED;
        } else if ("dns1".equals(what)) {
            readLineNum = MSG_PPPOE_TIME_OUT;
        } else if ("dns2".equals(what)) {
            readLineNum = MSG_PPPOE_FAILED;
        }
        if (readLineNum != -1) {
            File pppInfoFile = new File("/data/misc/ppp/ipaddr");
            if (pppInfoFile == null || !pppInfoFile.exists()) {
                return null;
            }
            BufferedReader br = null;
            try {
                String s;
                BufferedReader br2 = new BufferedReader(new FileReader(pppInfoFile));
                int currReadLineNum = MSG_PPPOE_CONNECT;
                do {
                    try {
                        s = br2.readLine();
                        if (s == null) {
                            break;
                        }
                        currReadLineNum += MSG_PPPOE_DISCONNECT;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        br = br2;
                    } catch (IOException e4) {
                        e2 = e4;
                        br = br2;
                    } catch (Throwable th2) {
                        th = th2;
                        br = br2;
                    }
                } while (currReadLineNum != readLineNum);
                result = s;
                if (br2 != null) {
                    try {
                        br2.close();
                    } catch (IOException e5) {
                        Log.e(TAG, "failure to close BufferedReader");
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                try {
                    e.printStackTrace();
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e7) {
                            Log.e(TAG, "failure to close BufferedReader");
                        }
                    }
                    return result;
                } catch (Throwable th3) {
                    th = th3;
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e8) {
                            Log.e(TAG, "failure to close BufferedReader");
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e2 = e9;
                e2.printStackTrace();
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e10) {
                        Log.e(TAG, "failure to close BufferedReader");
                    }
                }
                return result;
            }
        }
        return result;
    }
}
