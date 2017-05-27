package com.mstar.android.samba;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.mstar.android.storage.MStorageManager;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import jcifs.Config;
import jcifs.netbios.NbtAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class SmbDevice implements Parcelable {
    public static final Creator<SmbDevice> CREATOR;
    private static final String DEF_SMB_DEV_NAME = "Default Smb Device";
    public static final int FLAG_WRITEABLE = 1;
    private static final String TAG = "SmbDevice";
    private static final String localpath = "/mnt/samba/";
    private boolean DEBUG;
    private String SmbURL;
    private SmbAuthentication auth;
    ArrayList<SmbShareFolder> folderList;
    private String ip;
    private boolean mHasPassWord;
    private boolean mMountedFlag;
    private String mName;
    private String mPassWord;
    private String mUser;
    private boolean mountPointByIp;
    private OnRecvMsg onRecvMsg;
    SmbFile root;
    private MStorageManager stm;

    /* renamed from: com.mstar.android.samba.SmbDevice.1 */
    static class C00991 implements Creator<SmbDevice> {
        C00991() {
        }

        public SmbDevice createFromParcel(Parcel in) {
            return new SmbDevice(in);
        }

        public SmbDevice[] newArray(int size) {
            return new SmbDevice[size];
        }
    }

    private String getServerName() {
        try {
            NbtAddress nbt = NbtAddress.getByName(this.ip);
            if (nbt != null && nbt.isActive()) {
                NbtAddress[] all = NbtAddress.getAllByAddress(nbt);
                for (int i = 0; i < all.length; i += FLAG_WRITEABLE) {
                    NbtAddress n = all[i];
                    if (!n.isGroupAddress() && n.getNameType() == 0 && n.getHostName() != null) {
                        return n.getHostName();
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SmbDevice() {
        this.folderList = new ArrayList();
        this.ip = null;
        this.mUser = "";
        this.mPassWord = "";
        this.mName = DEF_SMB_DEV_NAME;
        this.onRecvMsg = null;
        this.SmbURL = null;
        this.auth = null;
        this.mountPointByIp = false;
        this.mMountedFlag = false;
        this.mHasPassWord = false;
        this.DEBUG = true;
        this.ip = "";
        this.mUser = "";
        this.mPassWord = "";
        this.mName = DEF_SMB_DEV_NAME;
        Config.setProperty("jcifs.encoding", "GBK");
    }

    public SmbDevice(String ipaddress) {
        this.folderList = new ArrayList();
        this.ip = null;
        this.mUser = "";
        this.mPassWord = "";
        this.mName = DEF_SMB_DEV_NAME;
        this.onRecvMsg = null;
        this.SmbURL = null;
        this.auth = null;
        this.mountPointByIp = false;
        this.mMountedFlag = false;
        this.mHasPassWord = false;
        this.DEBUG = true;
        this.ip = ipaddress;
        this.mUser = "";
        this.mPassWord = "";
        this.mName = DEF_SMB_DEV_NAME;
        Config.setProperty("jcifs.encoding", "GBK");
    }

    public SmbDevice(Parcel in) {
        this.folderList = new ArrayList();
        this.ip = null;
        this.mUser = "";
        this.mPassWord = "";
        this.mName = DEF_SMB_DEV_NAME;
        this.onRecvMsg = null;
        this.SmbURL = null;
        this.auth = null;
        this.mountPointByIp = false;
        this.mMountedFlag = false;
        this.mHasPassWord = false;
        this.DEBUG = true;
        this.ip = in.readString();
        this.mUser = in.readString();
        this.mPassWord = in.readString();
        this.mName = in.readString();
        this.auth = new SmbAuthentication(this.mUser, this.mPassWord);
        Config.setProperty("jcifs.encoding", "GBK");
    }

    public void setStorageManager(MStorageManager mstoragemanger) {
        this.stm = mstoragemanger;
    }

    public String getAddress() {
        return this.ip;
    }

    public String getHostName() throws UnknownHostException {
        this.mName = getServerName();
        if (this.mName == null) {
            this.mName = InetAddress.getByName(this.ip).getHostName();
        }
        System.out.println(" hostName : " + this.mName);
        return this.mName;
    }

    public void setHostName(String name) {
        this.mName = name;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.mstar.android.samba.SmbShareFolder> getSharefolderList() {
        /*
        r15 = this;
        r14 = 0;
        r1 = 0;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "smb://";
        r12 = r12.append(r13);
        r13 = r15.ip;
        r12 = r12.append(r13);
        r12 = r12.toString();
        r15.SmbURL = r12;
        r12 = r15.auth;
        if (r12 == 0) goto L_0x008f;
    L_0x001d:
        r12 = r15.auth;
        r11 = r12.getName();
        r12 = r15.auth;
        r8 = r12.getPassword();
        r12 = "\\";
        r5 = r11.indexOf(r12);
        if (r5 <= 0) goto L_0x00b6;
    L_0x0031:
        r12 = r15.auth;
        r12 = r12.getName();
        r13 = r5 + 1;
        r11 = r12.substring(r13);
        r12 = r15.auth;
        r12 = r12.getName();
        r3 = r12.substring(r14, r5);
        r1 = new jcifs.smb.NtlmPasswordAuthentication;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r12 = r12.append(r3);
        r13 = ";";
        r12 = r12.append(r13);
        r12 = r12.append(r11);
        r13 = ":";
        r12 = r12.append(r13);
        r12 = r12.append(r8);
        r12 = r12.toString();
        r1.<init>(r12);
    L_0x006d:
        r12 = java.lang.System.out;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = " NtlmPasswordAuthentication = ";
        r13 = r13.append(r14);
        r13 = r13.append(r3);
        r14 = " ";
        r13 = r13.append(r14);
        r13 = r13.append(r11);
        r13 = r13.toString();
        r12.println(r13);
    L_0x008f:
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = " SmbURL ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r15.SmbURL;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r15.SmbURL;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 != 0) goto L_0x00d4;
    L_0x00ad:
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = " SmbURL == null";
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = 0;
    L_0x00b5:
        return r12;
    L_0x00b6:
        r3 = 0;
        r1 = new jcifs.smb.NtlmPasswordAuthentication;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r12 = r12.append(r11);
        r13 = ":";
        r12 = r12.append(r13);
        r12 = r12.append(r8);
        r12 = r12.toString();
        r1.<init>(r12);
        goto L_0x006d;
    L_0x00d4:
        r12 = r15.auth;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 != 0) goto L_0x017f;
    L_0x00d8:
        r12 = new jcifs.smb.SmbFile;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r15.SmbURL;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.<init>(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r15.root = r12;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
    L_0x00e1:
        r12 = r15.root;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r0 = r12.listFiles();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = "list1 number: ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r0.length;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r6 = 0;
    L_0x0101:
        r12 = r0.length;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r6 >= r12) goto L_0x01bc;
    L_0x0104:
        r12 = r0[r6];	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r15.isHost(r12);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 == 0) goto L_0x011b;
    L_0x010c:
        r10 = new com.mstar.android.samba.SmbShareFolder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r10.<init>(r15);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r0[r6];	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        convertToSambaFolder(r10, r12);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r15.folderList;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.add(r10);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
    L_0x011b:
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = "get type :";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r0[r6];	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r14.getType();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r0[r6];	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r12.getType();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = 2;
        if (r12 != r13) goto L_0x01b8;
    L_0x0142:
        r12 = r0[r6];	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r2 = r12.listFiles();	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12 = java.lang.System.out;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r13 = new java.lang.StringBuilder;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r13.<init>();	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r14 = "list2 number: ";
        r13 = r13.append(r14);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r14 = r2.length;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r13 = r13.append(r14);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r13 = r13.toString();	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12.println(r13);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r9 = 0;
    L_0x0162:
        r12 = r2.length;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        if (r9 >= r12) goto L_0x01b8;
    L_0x0165:
        r12 = r2[r9];	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12 = r15.isHost(r12);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        if (r12 == 0) goto L_0x017c;
    L_0x016d:
        r10 = new com.mstar.android.samba.SmbShareFolder;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r10.<init>(r15);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12 = r2[r9];	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        convertToSambaFolder(r10, r12);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12 = r15.folderList;	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
        r12.add(r10);	 Catch:{ SmbException -> 0x0192, MalformedURLException -> 0x018a }
    L_0x017c:
        r9 = r9 + 1;
        goto L_0x0162;
    L_0x017f:
        r12 = new jcifs.smb.SmbFile;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r15.SmbURL;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.<init>(r13, r1);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r15.root = r12;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        goto L_0x00e1;
    L_0x018a:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x018e:
        r12 = r15.folderList;
        goto L_0x00b5;
    L_0x0192:
        r4 = move-exception;
        r7 = r4.getNtStatus();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 == 0) goto L_0x01a0;
    L_0x019b:
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.onRecvMsg(r7);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
    L_0x01a0:
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = "workgroup :";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.append(r7);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
    L_0x01b8:
        r6 = r6 + 1;
        goto L_0x0101;
    L_0x01bc:
        r12 = r15.folderList;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r12.isEmpty();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 != 0) goto L_0x0204;
    L_0x01c4:
        r12 = java.lang.System.out;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13.<init>();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = "folderList : ";
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r15.folderList;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r14 = r14.size();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.append(r14);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = r13.toString();	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12.println(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 == 0) goto L_0x018e;
    L_0x01e6:
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = 0;
        r12.onRecvMsg(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        goto L_0x018e;
    L_0x01ed:
        r4 = move-exception;
        r7 = r4.getNtStatus();
        r12 = java.lang.System.out;
        r12.println(r7);
        r12 = r15.onRecvMsg;
        if (r12 == 0) goto L_0x0200;
    L_0x01fb:
        r12 = r15.onRecvMsg;
        r12.onRecvMsg(r7);
    L_0x0200:
        r4.printStackTrace();
        goto L_0x018e;
    L_0x0204:
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        if (r12 == 0) goto L_0x018e;
    L_0x0208:
        r12 = r15.onRecvMsg;	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        r13 = -1073741275; // 0xffffffffc0000225 float:-2.000131 double:NaN;
        r12.onRecvMsg(r13);	 Catch:{ MalformedURLException -> 0x018a, SmbException -> 0x01ed }
        goto L_0x018e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.samba.SmbDevice.getSharefolderList():java.util.ArrayList<com.mstar.android.samba.SmbShareFolder>");
    }

    public void setAuth(SmbAuthentication auth) {
        this.auth = auth;
        if (auth != null) {
            this.mUser = auth.getName();
            this.mPassWord = auth.getPassword();
            if (this.mPassWord != null) {
                this.mHasPassWord = true;
            }
        }
    }

    public SmbAuthentication getAuth() {
        if (this.mHasPassWord) {
            return this.auth;
        }
        return SmbAuthentication.ANONYMOUS;
    }

    public boolean hasPassword() {
        try {
            SmbFile sf = new SmbFile("smb://" + this.ip + "/", new NtlmPasswordAuthentication(null));
            SmbFile[] urls = sf.listFiles();
            if (!sf.exists()) {
                return true;
            }
            Log.d(TAG, "hasPassword : smb server has no password!");
            SmbFile[] arr$ = urls;
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$ += FLAG_WRITEABLE) {
                SmbFile url = arr$[i$];
                if (!url.getPath().endsWith("$/")) {
                    Log.d(TAG, "hasPassword : Test shared folder: " + url.getPath());
                    new SmbFile(url.getPath(), new NtlmPasswordAuthentication(null)).list();
                }
            }
            return false;
        } catch (Exception e) {
            Log.d(TAG, this.mName + ": hasPassword : yes !");
            return true;
        }
    }

    public void mount(SmbAuthentication smbAuthentication) {
        Iterator i$ = this.folderList.iterator();
        while (i$.hasNext()) {
            boolean res;
            String folderName = ((SmbShareFolder) i$.next()).getFileName();
            System.out.println(" mount " + this.ip + " " + folderName);
            if (isChinese(folderName)) {
                char[] datas = folderName.toCharArray();
                System.out.println(" datas.length " + datas.length);
                for (int i = 0; i < datas.length; i += FLAG_WRITEABLE) {
                    if (datas[i] == '\u0000') {
                        folderName = String.copyValueOf(datas, 0, i);
                        System.out.println(" folderName " + folderName);
                        break;
                    }
                }
            }
            if (this.auth == null) {
                res = this.stm.mountSamba(this.ip, folderName, folderName, " ", "");
            } else {
                String username = this.auth.getName();
                int index = username.indexOf("\\");
                if (index > 0) {
                    username = this.auth.getName().substring(index + FLAG_WRITEABLE);
                }
                res = this.stm.mountSamba(this.ip, folderName, folderName, username, smbAuthentication.getPassword());
            }
            if (res) {
                this.mMountedFlag = true;
                this.mountPointByIp = false;
            } else {
                System.out.println(" mount jcifs fail! ");
            }
        }
    }

    public int mount(SmbAuthentication smbAuthentication, int flags) {
        if (flags == FLAG_WRITEABLE) {
        }
        Iterator i$ = this.folderList.iterator();
        while (i$.hasNext()) {
            boolean res;
            String folderName = ((SmbShareFolder) i$.next()).getFileName();
            System.out.println(" mount " + this.ip + " " + folderName);
            if (isChinese(folderName)) {
                char[] datas = folderName.toCharArray();
                System.out.println(" datas.length " + datas.length);
                for (int i = 0; i < datas.length; i += FLAG_WRITEABLE) {
                    if (datas[i] == '\u0000') {
                        folderName = String.copyValueOf(datas, 0, i);
                        System.out.println(" folderName " + folderName);
                        break;
                    }
                }
            }
            if (this.auth == null) {
                res = this.stm.mountSamba(this.ip, folderName, this.ip + "/" + folderName, " ", "");
            } else {
                String username = this.auth.getName();
                int index = username.indexOf("\\");
                if (index > 0) {
                    username = this.auth.getName().substring(index + FLAG_WRITEABLE);
                }
                res = this.stm.mountSamba(this.ip, folderName, this.ip + "/" + folderName, username, smbAuthentication.getPassword());
            }
            if (res) {
                this.mMountedFlag = true;
                this.mountPointByIp = true;
            } else {
                System.out.println(" mount jcifs fail! ");
            }
        }
        if (this.mMountedFlag) {
            return 16;
        }
        return 17;
    }

    public int unmount() {
        boolean res = false;
        Iterator i$ = this.folderList.iterator();
        while (i$.hasNext()) {
            SmbShareFolder folder = (SmbShareFolder) i$.next();
            System.out.println(" umount " + folder.getFileName());
            String folderName = folder.getFileName();
            if (isChinese(folderName)) {
                char[] datas = folderName.toCharArray();
                System.out.println(" datas.length " + datas.length);
                for (int i = 0; i < datas.length; i += FLAG_WRITEABLE) {
                    if (datas[i] == '\u0000') {
                        folderName = String.copyValueOf(datas, 0, i);
                        System.out.println(" folderName " + folderName);
                        break;
                    }
                }
            }
            if (this.mountPointByIp) {
                res = this.stm.unmountSamba(this.ip + "/" + folderName, true);
            } else {
                res = this.stm.unmountSamba(folderName, true);
            }
            if (res) {
                this.mMountedFlag = false;
            } else {
                System.out.println(" umount jcifs fail! ");
            }
        }
        if (res) {
            return 18;
        }
        return 19;
    }

    public boolean isMounted() {
        return this.mMountedFlag;
    }

    private boolean isChinese(String str) {
        if (str.length() < str.getBytes().length) {
            return true;
        }
        return false;
    }

    public String localPath() {
        if (this.mountPointByIp) {
            return localpath + this.ip + "/";
        }
        return localpath;
    }

    public String remotePath() {
        return "//" + this.ip;
    }

    public void setOnRecvMsg(OnRecvMsg onRecvMsg) {
        this.onRecvMsg = onRecvMsg;
    }

    static void convertToSambaFolder(SmbShareFolder dstFile, SmbFile srcFile) throws SmbException {
        dstFile.file = srcFile;
    }

    public boolean isHost(SmbFile file) throws SmbException {
        int fileType = file.getType();
        if (!file.isHidden()) {
            if (fileType == FLAG_WRITEABLE || fileType == 8) {
                return true;
            }
            if (fileType == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isActive() {
        try {
            if (this.ip != null) {
                NbtAddress nbt = NbtAddress.getByName(this.ip);
                if (nbt != null) {
                    return nbt.isActive();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean testPassword(String user, String pw) {
        try {
            if (this.ip != null) {
                SmbFile sf = new SmbFile("smb://" + this.ip + "/", new NtlmPasswordAuthentication(user + ":" + pw));
                SmbFile[] urls = sf.listFiles();
                if (!sf.exists()) {
                    return false;
                }
                SmbFile[] arr$ = urls;
                int len$ = arr$.length;
                for (int i$ = 0; i$ < len$; i$ += FLAG_WRITEABLE) {
                    SmbFile url = arr$[i$];
                    if (!url.getPath().endsWith("$/")) {
                        Log.d(TAG, "hasPassword : Test shared folder: " + url.getPath());
                        new SmbFile(url.getPath(), new NtlmPasswordAuthentication(user + ":" + pw)).list();
                    }
                }
                Log.d(TAG, "testPassword : password is correct!");
                return true;
            } else if (!this.DEBUG) {
                return false;
            } else {
                Log.d(TAG, "testPassword --> Ip is null!");
                return false;
            }
        } catch (Exception e) {
            Log.d(TAG, "testPassword : password is wrong!");
            e.printStackTrace();
            return false;
        }
    }

    public void setAddress(String ip) {
        this.ip = ip;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ip);
        dest.writeString(this.mUser);
        dest.writeString(this.mPassWord);
        dest.writeString(this.mName);
    }

    static {
        CREATOR = new C00991();
    }
}
