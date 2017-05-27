package jcifs.netbios;

import com.mstar.android.MKeyEvent;
import com.mstar.android.media.MMediaPlayer;
import com.mstar.android.media.MstMediaMetadataRetriever;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import jcifs.Config;
import jcifs.util.Hexdump;

public final class NbtAddress {
    private static final HashMap ADDRESS_CACHE;
    static final String ANY_HOSTS_NAME = "*\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
    public static final int B_NODE = 0;
    private static final int CACHE_POLICY;
    private static final NameServiceClient CLIENT;
    private static final int DEFAULT_CACHE_POLICY = 30;
    private static final int FOREVER = -1;
    public static final int H_NODE = 3;
    private static final HashMap LOOKUP_TABLE;
    public static final String MASTER_BROWSER_NAME = "\u0001\u0002__MSBROWSE__\u0002";
    public static final int M_NODE = 2;
    static final InetAddress[] NBNS;
    public static final int P_NODE = 1;
    public static final String SMBSERVER_NAME = "*SMBSERVER     ";
    static final NbtAddress UNKNOWN_ADDRESS;
    static final byte[] UNKNOWN_MAC_ADDRESS;
    static final Name UNKNOWN_NAME;
    static NbtAddress localhost;
    private static int nbnsIndex;
    int address;
    String calledName;
    boolean groupName;
    Name hostName;
    boolean isActive;
    boolean isBeingDeleted;
    boolean isDataFromNodeStatus;
    boolean isInConflict;
    boolean isPermanent;
    byte[] macAddress;
    int nodeType;

    static final class CacheEntry {
        NbtAddress address;
        long expiration;
        Name hostName;

        CacheEntry(Name hostName, NbtAddress address, long expiration) {
            this.hostName = hostName;
            this.address = address;
            this.expiration = expiration;
        }
    }

    static {
        NBNS = Config.getInetAddressArray("jcifs.netbios.wins", ",", new InetAddress[CACHE_POLICY]);
        CLIENT = new NameServiceClient();
        CACHE_POLICY = Config.getInt("jcifs.netbios.cachePolicy", DEFAULT_CACHE_POLICY);
        nbnsIndex = CACHE_POLICY;
        ADDRESS_CACHE = new HashMap();
        LOOKUP_TABLE = new HashMap();
        UNKNOWN_NAME = new Name("0.0.0.0", CACHE_POLICY, null);
        UNKNOWN_ADDRESS = new NbtAddress(UNKNOWN_NAME, CACHE_POLICY, false, CACHE_POLICY);
        UNKNOWN_MAC_ADDRESS = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        ADDRESS_CACHE.put(UNKNOWN_NAME, new CacheEntry(UNKNOWN_NAME, UNKNOWN_ADDRESS, -1));
        InetAddress localInetAddress = CLIENT.laddr;
        if (localInetAddress == null) {
            try {
                localInetAddress = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                try {
                    localInetAddress = InetAddress.getByName("127.0.0.1");
                } catch (UnknownHostException e2) {
                }
            }
        }
        String localHostname = Config.getProperty("jcifs.netbios.hostname", null);
        if (localHostname == null || localHostname.length() == 0) {
            byte[] addr = localInetAddress.getAddress();
            localHostname = "JCIFS" + (addr[M_NODE] & MKeyEvent.KEYCODE_SLEEP) + "_" + (addr[H_NODE] & MKeyEvent.KEYCODE_SLEEP) + "_" + Hexdump.toHexString((int) (Math.random() * 255.0d), (int) M_NODE);
        }
        Name localName = new Name(localHostname, CACHE_POLICY, Config.getProperty("jcifs.netbios.scope", null));
        localhost = new NbtAddress(localName, localInetAddress.hashCode(), false, CACHE_POLICY, false, false, true, false, UNKNOWN_MAC_ADDRESS);
        cacheAddress(localName, localhost, -1);
    }

    static void cacheAddress(Name hostName, NbtAddress addr) {
        if (CACHE_POLICY != 0) {
            long expiration = -1;
            if (CACHE_POLICY != FOREVER) {
                expiration = System.currentTimeMillis() + ((long) (CACHE_POLICY * MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA));
            }
            cacheAddress(hostName, addr, expiration);
        }
    }

    static void cacheAddress(Name hostName, NbtAddress addr, long expiration) {
        if (CACHE_POLICY != 0) {
            synchronized (ADDRESS_CACHE) {
                CacheEntry entry = (CacheEntry) ADDRESS_CACHE.get(hostName);
                if (entry == null) {
                    ADDRESS_CACHE.put(hostName, new CacheEntry(hostName, addr, expiration));
                } else {
                    entry.address = addr;
                    entry.expiration = expiration;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cacheAddressArray(jcifs.netbios.NbtAddress[] r8) {
        /*
        r4 = CACHE_POLICY;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r2 = -1;
        r4 = CACHE_POLICY;
        r5 = -1;
        if (r4 == r5) goto L_0x0017;
    L_0x000c:
        r4 = java.lang.System.currentTimeMillis();
        r6 = CACHE_POLICY;
        r6 = r6 * 1000;
        r6 = (long) r6;
        r2 = r4 + r6;
    L_0x0017:
        r5 = ADDRESS_CACHE;
        monitor-enter(r5);
        r1 = 0;
    L_0x001b:
        r4 = r8.length;	 Catch:{ all -> 0x004a }
        if (r1 >= r4) goto L_0x004d;
    L_0x001e:
        r4 = ADDRESS_CACHE;	 Catch:{ all -> 0x004a }
        r6 = r8[r1];	 Catch:{ all -> 0x004a }
        r6 = r6.hostName;	 Catch:{ all -> 0x004a }
        r0 = r4.get(r6);	 Catch:{ all -> 0x004a }
        r0 = (jcifs.netbios.NbtAddress.CacheEntry) r0;	 Catch:{ all -> 0x004a }
        if (r0 != 0) goto L_0x0043;
    L_0x002c:
        r0 = new jcifs.netbios.NbtAddress$CacheEntry;	 Catch:{ all -> 0x004a }
        r4 = r8[r1];	 Catch:{ all -> 0x004a }
        r4 = r4.hostName;	 Catch:{ all -> 0x004a }
        r6 = r8[r1];	 Catch:{ all -> 0x004a }
        r0.<init>(r4, r6, r2);	 Catch:{ all -> 0x004a }
        r4 = ADDRESS_CACHE;	 Catch:{ all -> 0x004a }
        r6 = r8[r1];	 Catch:{ all -> 0x004a }
        r6 = r6.hostName;	 Catch:{ all -> 0x004a }
        r4.put(r6, r0);	 Catch:{ all -> 0x004a }
    L_0x0040:
        r1 = r1 + 1;
        goto L_0x001b;
    L_0x0043:
        r4 = r8[r1];	 Catch:{ all -> 0x004a }
        r0.address = r4;	 Catch:{ all -> 0x004a }
        r0.expiration = r2;	 Catch:{ all -> 0x004a }
        goto L_0x0040;
    L_0x004a:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x004a }
        throw r4;
    L_0x004d:
        monitor-exit(r5);	 Catch:{ all -> 0x004a }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.netbios.NbtAddress.cacheAddressArray(jcifs.netbios.NbtAddress[]):void");
    }

    static NbtAddress getCachedAddress(Name hostName) {
        NbtAddress nbtAddress = null;
        if (CACHE_POLICY != 0) {
            synchronized (ADDRESS_CACHE) {
                CacheEntry entry = (CacheEntry) ADDRESS_CACHE.get(hostName);
                if (entry != null && entry.expiration < System.currentTimeMillis() && entry.expiration >= 0) {
                    entry = null;
                }
                if (entry != null) {
                    nbtAddress = entry.address;
                }
            }
        }
        return nbtAddress;
    }

    static NbtAddress doNameQuery(Name name, InetAddress svr) throws UnknownHostException {
        if (name.hexCode == 29 && svr == null) {
            svr = CLIENT.baddr;
        }
        name.srcHashCode = svr != null ? svr.hashCode() : CACHE_POLICY;
        NbtAddress addr = getCachedAddress(name);
        if (addr == null) {
            addr = (NbtAddress) checkLookupTable(name);
            if (addr == null) {
                try {
                    addr = CLIENT.getByName(name, svr);
                } catch (UnknownHostException e) {
                    addr = UNKNOWN_ADDRESS;
                } finally {
                    cacheAddress(name, addr);
                    updateLookupTable(name);
                }
            }
        }
        if (addr != UNKNOWN_ADDRESS) {
            return addr;
        }
        throw new UnknownHostException(name.toString());
    }

    private static Object checkLookupTable(Name name) {
        Object obj;
        synchronized (LOOKUP_TABLE) {
            if (LOOKUP_TABLE.containsKey(name)) {
                while (LOOKUP_TABLE.containsKey(name)) {
                    try {
                        LOOKUP_TABLE.wait();
                    } catch (InterruptedException e) {
                    }
                }
                obj = getCachedAddress(name);
                if (obj == null) {
                    synchronized (LOOKUP_TABLE) {
                        LOOKUP_TABLE.put(name, name);
                    }
                }
            } else {
                LOOKUP_TABLE.put(name, name);
                obj = null;
            }
        }
        return obj;
    }

    private static void updateLookupTable(Name name) {
        synchronized (LOOKUP_TABLE) {
            LOOKUP_TABLE.remove(name);
            LOOKUP_TABLE.notifyAll();
        }
    }

    public static NbtAddress getLocalHost() throws UnknownHostException {
        return localhost;
    }

    public static Name getLocalName() {
        return localhost.hostName;
    }

    public static NbtAddress getByName(String host) throws UnknownHostException {
        return getByName(host, CACHE_POLICY, null);
    }

    public static NbtAddress getByName(String host, int type, String scope) throws UnknownHostException {
        return getByName(host, type, scope, null);
    }

    public static NbtAddress getByName(String host, int type, String scope, InetAddress svr) throws UnknownHostException {
        if (host == null || host.length() == 0) {
            return getLocalHost();
        }
        if (!Character.isDigit(host.charAt(CACHE_POLICY))) {
            return doNameQuery(new Name(host, type, scope), svr);
        }
        int IP = CACHE_POLICY;
        int hitDots = CACHE_POLICY;
        char[] data = host.toCharArray();
        int i = CACHE_POLICY;
        while (i < data.length) {
            char c = data[i];
            if (c < '0' || c > '9') {
                return doNameQuery(new Name(host, type, scope), svr);
            }
            int b = CACHE_POLICY;
            while (c != '.') {
                if (c < '0' || c > '9') {
                    return doNameQuery(new Name(host, type, scope), svr);
                }
                b = ((b * 10) + c) - 48;
                i += P_NODE;
                if (i >= data.length) {
                    break;
                }
                c = data[i];
            }
            if (b > MKeyEvent.KEYCODE_SLEEP) {
                return doNameQuery(new Name(host, type, scope), svr);
            }
            IP = (IP << 8) + b;
            hitDots += P_NODE;
            i += P_NODE;
        }
        if (hitDots != 4 || host.endsWith(".")) {
            return doNameQuery(new Name(host, type, scope), svr);
        }
        return new NbtAddress(UNKNOWN_NAME, IP, false, CACHE_POLICY);
    }

    public static NbtAddress[] getAllByName(String host, int type, String scope, InetAddress svr) throws UnknownHostException {
        return CLIENT.getAllByName(new Name(host, type, scope), svr);
    }

    public static NbtAddress[] getAllByAddress(String host) throws UnknownHostException {
        return getAllByAddress(getByName(host, CACHE_POLICY, null));
    }

    public static NbtAddress[] getAllByAddress(String host, int type, String scope) throws UnknownHostException {
        return getAllByAddress(getByName(host, type, scope));
    }

    public static NbtAddress[] getAllByAddress(NbtAddress addr) throws UnknownHostException {
        try {
            NbtAddress[] addrs = CLIENT.getNodeStatus(addr);
            cacheAddressArray(addrs);
            return addrs;
        } catch (UnknownHostException e) {
            StringBuilder append = new StringBuilder().append("no name with type 0x").append(Hexdump.toHexString(addr.hostName.hexCode, (int) M_NODE));
            String str = (addr.hostName.scope == null || addr.hostName.scope.length() == 0) ? " with no scope" : " with scope " + addr.hostName.scope;
            throw new UnknownHostException(append.append(str).append(" for host ").append(addr.getHostAddress()).toString());
        }
    }

    public static InetAddress getWINSAddress() {
        return NBNS.length == 0 ? null : NBNS[nbnsIndex];
    }

    public static boolean isWINS(InetAddress svr) {
        int i = CACHE_POLICY;
        while (svr != null && i < NBNS.length) {
            if (svr.hashCode() == NBNS[i].hashCode()) {
                return true;
            }
            i += P_NODE;
        }
        return false;
    }

    static InetAddress switchWINS() {
        nbnsIndex = nbnsIndex + P_NODE < NBNS.length ? nbnsIndex + P_NODE : CACHE_POLICY;
        return NBNS.length == 0 ? null : NBNS[nbnsIndex];
    }

    NbtAddress(Name hostName, int address, boolean groupName, int nodeType) {
        this.hostName = hostName;
        this.address = address;
        this.groupName = groupName;
        this.nodeType = nodeType;
    }

    NbtAddress(Name hostName, int address, boolean groupName, int nodeType, boolean isBeingDeleted, boolean isInConflict, boolean isActive, boolean isPermanent, byte[] macAddress) {
        this.hostName = hostName;
        this.address = address;
        this.groupName = groupName;
        this.nodeType = nodeType;
        this.isBeingDeleted = isBeingDeleted;
        this.isInConflict = isInConflict;
        this.isActive = isActive;
        this.isPermanent = isPermanent;
        this.macAddress = macAddress;
        this.isDataFromNodeStatus = true;
    }

    public String firstCalledName() {
        this.calledName = this.hostName.name;
        if (!Character.isDigit(this.calledName.charAt(CACHE_POLICY))) {
            switch (this.hostName.hexCode) {
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_IS_DEVICE_REG /*27*/:
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_REG_CODE /*28*/:
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_DEREG_CODE /*29*/:
                    this.calledName = SMBSERVER_NAME;
                    break;
                default:
                    break;
            }
        }
        int dots = CACHE_POLICY;
        int i = CACHE_POLICY;
        int len = this.calledName.length();
        char[] data = this.calledName.toCharArray();
        int i2 = i;
        while (i2 < len) {
            i = i2 + P_NODE;
            if (Character.isDigit(data[i2])) {
                if (i == len && dots == H_NODE) {
                    this.calledName = SMBSERVER_NAME;
                    break;
                } else if (i >= len || data[i] != '.') {
                    i2 = i;
                } else {
                    dots += P_NODE;
                    i2 = i + P_NODE;
                }
            } else {
                break;
            }
        }
        i = i2;
        return this.calledName;
    }

    public String nextCalledName() {
        if (this.calledName == this.hostName.name) {
            this.calledName = SMBSERVER_NAME;
        } else if (this.calledName == SMBSERVER_NAME) {
            try {
                NbtAddress[] addrs = CLIENT.getNodeStatus(this);
                if (this.hostName.hexCode == 29) {
                    for (int i = CACHE_POLICY; i < addrs.length; i += P_NODE) {
                        if (addrs[i].hostName.hexCode == 32) {
                            return addrs[i].hostName.name;
                        }
                    }
                    return null;
                } else if (this.isDataFromNodeStatus) {
                    this.calledName = null;
                    return this.hostName.name;
                }
            } catch (UnknownHostException e) {
                this.calledName = null;
            }
        } else {
            this.calledName = null;
        }
        return this.calledName;
    }

    void checkData() throws UnknownHostException {
        if (this.hostName == UNKNOWN_NAME) {
            getAllByAddress(this);
        }
    }

    void checkNodeStatusData() throws UnknownHostException {
        if (!this.isDataFromNodeStatus) {
            getAllByAddress(this);
        }
    }

    public boolean isGroupAddress() throws UnknownHostException {
        checkData();
        return this.groupName;
    }

    public int getNodeType() throws UnknownHostException {
        checkData();
        return this.nodeType;
    }

    public boolean isBeingDeleted() throws UnknownHostException {
        checkNodeStatusData();
        return this.isBeingDeleted;
    }

    public boolean isInConflict() throws UnknownHostException {
        checkNodeStatusData();
        return this.isInConflict;
    }

    public boolean isActive() throws UnknownHostException {
        checkNodeStatusData();
        return this.isActive;
    }

    public boolean isPermanent() throws UnknownHostException {
        checkNodeStatusData();
        return this.isPermanent;
    }

    public byte[] getMacAddress() throws UnknownHostException {
        checkNodeStatusData();
        return this.macAddress;
    }

    public String getHostName() {
        if (this.hostName == UNKNOWN_NAME) {
            return getHostAddress();
        }
        return this.hostName.name;
    }

    public byte[] getAddress() {
        return new byte[]{(byte) ((this.address >>> 24) & MKeyEvent.KEYCODE_SLEEP), (byte) ((this.address >>> 16) & MKeyEvent.KEYCODE_SLEEP), (byte) ((this.address >>> 8) & MKeyEvent.KEYCODE_SLEEP), (byte) (this.address & MKeyEvent.KEYCODE_SLEEP)};
    }

    public InetAddress getInetAddress() throws UnknownHostException {
        return InetAddress.getByName(getHostAddress());
    }

    public String getHostAddress() {
        return ((this.address >>> 24) & MKeyEvent.KEYCODE_SLEEP) + "." + ((this.address >>> 16) & MKeyEvent.KEYCODE_SLEEP) + "." + ((this.address >>> 8) & MKeyEvent.KEYCODE_SLEEP) + "." + ((this.address >>> CACHE_POLICY) & MKeyEvent.KEYCODE_SLEEP);
    }

    public int getNameType() {
        return this.hostName.hexCode;
    }

    public int hashCode() {
        return this.address;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof NbtAddress) && ((NbtAddress) obj).address == this.address;
    }

    public String toString() {
        return this.hostName.toString() + "/" + getHostAddress();
    }
}
