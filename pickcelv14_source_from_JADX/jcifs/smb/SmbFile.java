package jcifs.smb;

import android.support.v4.widget.ExploreByTouchHelper;
import com.mstar.android.MKeyEvent;
import com.mstar.android.camera.MCamera.Parameters;
import com.mstar.android.media.MMediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import jcifs.Config;
import jcifs.UniAddress;
import jcifs.dcerpc.DcerpcHandle;
import jcifs.dcerpc.msrpc.MsrpcDfsRootEnum;
import jcifs.dcerpc.msrpc.MsrpcShareEnum;
import jcifs.dcerpc.msrpc.MsrpcShareGetInfo;
import jcifs.netbios.NbtAddress;
import jcifs.util.LogStream;

public class SmbFile extends URLConnection implements SmbConstants {
    public static final int ATTR_ARCHIVE = 32;
    static final int ATTR_COMPRESSED = 2048;
    public static final int ATTR_DIRECTORY = 16;
    static final int ATTR_GET_MASK = 32767;
    public static final int ATTR_HIDDEN = 2;
    static final int ATTR_NORMAL = 128;
    public static final int ATTR_READONLY = 1;
    static final int ATTR_SET_MASK = 12455;
    public static final int ATTR_SYSTEM = 4;
    static final int ATTR_TEMPORARY = 256;
    public static final int ATTR_VOLUME = 8;
    static final int DEFAULT_ATTR_EXPIRATION_PERIOD = 5000;
    public static final int FILE_NO_SHARE = 0;
    public static final int FILE_SHARE_DELETE = 4;
    public static final int FILE_SHARE_READ = 1;
    public static final int FILE_SHARE_WRITE = 2;
    static final int HASH_DOT;
    static final int HASH_DOT_DOT;
    static final int O_APPEND = 4;
    static final int O_CREAT = 16;
    static final int O_EXCL = 32;
    static final int O_RDONLY = 1;
    static final int O_RDWR = 3;
    static final int O_TRUNC = 64;
    static final int O_WRONLY = 2;
    public static final int TYPE_COMM = 64;
    public static final int TYPE_FILESYSTEM = 1;
    public static final int TYPE_NAMED_PIPE = 16;
    public static final int TYPE_PRINTER = 32;
    public static final int TYPE_SERVER = 4;
    public static final int TYPE_SHARE = 8;
    public static final int TYPE_WORKGROUP = 2;
    static long attrExpirationPeriod;
    protected static Dfs dfs;
    static boolean ignoreCopyToException;
    static LogStream log;
    int addressIndex;
    UniAddress[] addresses;
    private long attrExpiration;
    private int attributes;
    NtlmPasswordAuthentication auth;
    private SmbComBlankResponse blank_resp;
    private String canon;
    private long createTime;
    private DfsReferral dfsReferral;
    int fid;
    private boolean isExists;
    private long lastModified;
    boolean opened;
    private String share;
    private int shareAccess;
    private long size;
    private long sizeExpiration;
    SmbTree tree;
    int tree_num;
    int type;
    String unc;

    class WriterThread extends Thread {
        byte[] f68b;
        SmbFile dest;
        SmbException f69e;
        int f70n;
        long off;
        boolean ready;
        SmbComWrite req;
        SmbComWriteAndX reqx;
        ServerMessageBlock resp;
        boolean useNTSmbs;

        WriterThread() throws SmbException {
            super("JCIFS-WriterThread");
            this.f69e = null;
            this.useNTSmbs = SmbFile.this.tree.session.transport.hasCapability(SmbFile.TYPE_NAMED_PIPE);
            if (this.useNTSmbs) {
                this.reqx = new SmbComWriteAndX();
                this.resp = new SmbComWriteAndXResponse();
            } else {
                this.req = new SmbComWrite();
                this.resp = new SmbComWriteResponse();
            }
            this.ready = false;
        }

        synchronized void write(byte[] b, int n, SmbFile dest, long off) {
            this.f68b = b;
            this.f70n = n;
            this.dest = dest;
            this.off = off;
            this.ready = false;
            notify();
        }

        public void run() {
            synchronized (this) {
                while (true) {
                    try {
                        notify();
                        this.ready = true;
                        while (this.ready) {
                            wait();
                        }
                        if (this.f70n == -1) {
                            return;
                        } else if (this.useNTSmbs) {
                            this.reqx.setParam(this.dest.fid, this.off, this.f70n, this.f68b, SmbFile.HASH_DOT_DOT, this.f70n);
                            this.dest.send(this.reqx, this.resp);
                        } else {
                            this.req.setParam(this.dest.fid, this.off, this.f70n, this.f68b, SmbFile.HASH_DOT_DOT, this.f70n);
                            this.dest.send(this.req, this.resp);
                        }
                    } catch (SmbException e) {
                        this.f69e = e;
                        notify();
                        return;
                    } catch (Throwable x) {
                        this.f69e = new SmbException("WriterThread", x);
                        notify();
                        return;
                    }
                }
            }
        }
    }

    static {
        HASH_DOT = ".".hashCode();
        HASH_DOT_DOT = "..".hashCode();
        log = LogStream.getInstance();
        try {
            Class.forName("jcifs.Config");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        attrExpirationPeriod = Config.getLong("jcifs.smb.client.attrExpirationPeriod", 5000);
        ignoreCopyToException = Config.getBoolean("jcifs.smb.client.ignoreCopyToException", true);
        dfs = new Dfs();
    }

    public SmbFile(String url) throws MalformedURLException {
        this(new URL(null, url, Handler.SMB_HANDLER));
    }

    public SmbFile(SmbFile context, String name) throws MalformedURLException, UnknownHostException {
        this(context.isWorkgroup0() ? new URL(null, "smb://" + name, Handler.SMB_HANDLER) : new URL(context.url, name, Handler.SMB_HANDLER), context.auth);
    }

    public SmbFile(String context, String name) throws MalformedURLException {
        this(new URL(new URL(null, context, Handler.SMB_HANDLER), name, Handler.SMB_HANDLER));
    }

    public SmbFile(String url, NtlmPasswordAuthentication auth) throws MalformedURLException {
        this(new URL(null, url, Handler.SMB_HANDLER), auth);
    }

    public SmbFile(String url, NtlmPasswordAuthentication auth, int shareAccess) throws MalformedURLException {
        this(new URL(null, url, Handler.SMB_HANDLER), auth);
        if ((shareAccess & -8) != 0) {
            throw new RuntimeException("Illegal shareAccess parameter");
        }
        this.shareAccess = shareAccess;
    }

    public SmbFile(String context, String name, NtlmPasswordAuthentication auth) throws MalformedURLException {
        this(new URL(new URL(null, context, Handler.SMB_HANDLER), name, Handler.SMB_HANDLER), auth);
    }

    public SmbFile(String context, String name, NtlmPasswordAuthentication auth, int shareAccess) throws MalformedURLException {
        this(new URL(new URL(null, context, Handler.SMB_HANDLER), name, Handler.SMB_HANDLER), auth);
        if ((shareAccess & -8) != 0) {
            throw new RuntimeException("Illegal shareAccess parameter");
        }
        this.shareAccess = shareAccess;
    }

    public SmbFile(SmbFile context, String name, int shareAccess) throws MalformedURLException, UnknownHostException {
        this(context.isWorkgroup0() ? new URL(null, "smb://" + name, Handler.SMB_HANDLER) : new URL(context.url, name, Handler.SMB_HANDLER), context.auth);
        if ((shareAccess & -8) != 0) {
            throw new RuntimeException("Illegal shareAccess parameter");
        }
        this.shareAccess = shareAccess;
    }

    public SmbFile(URL url) {
        this(url, new NtlmPasswordAuthentication(url.getUserInfo()));
    }

    public SmbFile(URL url, NtlmPasswordAuthentication auth) {
        super(url);
        this.shareAccess = 7;
        this.blank_resp = null;
        this.dfsReferral = null;
        this.tree = null;
        if (auth == null) {
            auth = new NtlmPasswordAuthentication(url.getUserInfo());
        }
        this.auth = auth;
        getUncPath0();
    }

    SmbFile(SmbFile context, String name, int type, int attributes, long createTime, long lastModified, long size) throws MalformedURLException, UnknownHostException {
        URL url;
        if (context.isWorkgroup0()) {
            url = new URL(null, "smb://" + name + "/", Handler.SMB_HANDLER);
        } else {
            url = new URL(context.url, name + ((attributes & TYPE_NAMED_PIPE) > 0 ? "/" : ""));
        }
        this(url);
        this.auth = context.auth;
        if (context.share != null) {
            this.tree = context.tree;
            this.dfsReferral = context.dfsReferral;
        }
        int last = name.length() - 1;
        if (name.charAt(last) == '/') {
            name = name.substring(HASH_DOT_DOT, last);
        }
        if (context.share == null) {
            this.unc = "\\";
        } else if (context.unc.equals("\\")) {
            this.unc = '\\' + name;
        } else {
            this.unc = context.unc + '\\' + name;
        }
        this.type = type;
        this.attributes = attributes;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.size = size;
        this.isExists = true;
        long currentTimeMillis = System.currentTimeMillis() + attrExpirationPeriod;
        this.sizeExpiration = currentTimeMillis;
        this.attrExpiration = currentTimeMillis;
    }

    private SmbComBlankResponse blank_resp() {
        if (this.blank_resp == null) {
            this.blank_resp = new SmbComBlankResponse();
        }
        return this.blank_resp;
    }

    void resolveDfs(ServerMessageBlock request) throws SmbException {
        if (!(request instanceof SmbComClose)) {
            connect0();
            DfsReferral dr = dfs.resolve(this.tree.session.transport.tconHostName, this.tree.share, this.unc, this.auth);
            if (dr != null) {
                LogStream logStream;
                SmbException se;
                String dunc;
                String service = null;
                if (request != null) {
                    switch (request.command) {
                        case Parameters.MAPI_INPUT_SOURCE_DTV2 /*37*/:
                        case (byte) 50:
                            switch (((SmbComTransaction) request).subCommand & MKeyEvent.KEYCODE_SLEEP) {
                                case TYPE_NAMED_PIPE /*16*/:
                                    break;
                                default:
                                    service = "A:";
                                    break;
                            }
                        default:
                            service = "A:";
                            break;
                    }
                }
                DfsReferral start = dr;
                do {
                    try {
                        logStream = log;
                        if (LogStream.level >= TYPE_WORKGROUP) {
                            log.println("DFS redirect: " + dr);
                        }
                        SmbTransport trans = SmbTransport.getSmbTransport(UniAddress.getByName(dr.server), this.url.getPort());
                        trans.connect();
                        this.tree = trans.getSmbSession(this.auth).getSmbTree(dr.share, service);
                        if (!(dr == start || dr.key == null)) {
                            dr.map.put(dr.key, dr);
                        }
                        se = null;
                    } catch (Throwable ioe) {
                        if (ioe instanceof SmbException) {
                            se = (SmbException) ioe;
                        } else {
                            se = new SmbException(dr.server, ioe);
                        }
                        dr = dr.next;
                        if (dr == start) {
                        }
                    }
                    if (se == null) {
                        throw se;
                    }
                    logStream = log;
                    if (LogStream.level >= O_RDWR) {
                        log.println(dr);
                    }
                    this.dfsReferral = dr;
                    if (dr.pathConsumed < 0) {
                        dr.pathConsumed = HASH_DOT_DOT;
                    } else if (dr.pathConsumed > this.unc.length()) {
                        dr.pathConsumed = this.unc.length();
                    }
                    dunc = this.unc.substring(dr.pathConsumed);
                    if (dunc.equals("")) {
                        dunc = "\\";
                    }
                    if (!dr.path.equals("")) {
                        dunc = "\\" + dr.path + dunc;
                    }
                    this.unc = dunc;
                    if (!(request == null || request.path == null || !request.path.endsWith("\\") || dunc.endsWith("\\"))) {
                        dunc = dunc + "\\";
                    }
                    if (request != null) {
                        request.path = dunc;
                        request.flags2 |= SmbConstants.FLAGS2_RESOLVE_PATHS_IN_DFS;
                        return;
                    }
                    return;
                } while (dr == start);
                if (se == null) {
                    logStream = log;
                    if (LogStream.level >= O_RDWR) {
                        log.println(dr);
                    }
                    this.dfsReferral = dr;
                    if (dr.pathConsumed < 0) {
                        dr.pathConsumed = HASH_DOT_DOT;
                    } else if (dr.pathConsumed > this.unc.length()) {
                        dr.pathConsumed = this.unc.length();
                    }
                    dunc = this.unc.substring(dr.pathConsumed);
                    if (dunc.equals("")) {
                        dunc = "\\";
                    }
                    if (dr.path.equals("")) {
                        dunc = "\\" + dr.path + dunc;
                    }
                    this.unc = dunc;
                    dunc = dunc + "\\";
                    if (request != null) {
                        request.path = dunc;
                        request.flags2 |= SmbConstants.FLAGS2_RESOLVE_PATHS_IN_DFS;
                        return;
                    }
                    return;
                }
                throw se;
            } else if (this.tree.inDomainDfs && !(request instanceof NtTransQuerySecurityDesc) && !(request instanceof SmbComClose) && !(request instanceof SmbComFindClose2)) {
                throw new SmbException((int) NtStatus.NT_STATUS_NOT_FOUND, false);
            } else if (request != null) {
                request.flags2 &= -4097;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void send(jcifs.smb.ServerMessageBlock r3, jcifs.smb.ServerMessageBlock r4) throws jcifs.smb.SmbException {
        /*
        r2 = this;
    L_0x0000:
        r2.resolveDfs(r3);
        r1 = r2.tree;	 Catch:{ DfsReferral -> 0x0009 }
        r1.send(r3, r4);	 Catch:{ DfsReferral -> 0x0009 }
        return;
    L_0x0009:
        r0 = move-exception;
        r1 = r0.resolveHashes;
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        throw r0;
    L_0x000f:
        r3.reset();
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.SmbFile.send(jcifs.smb.ServerMessageBlock, jcifs.smb.ServerMessageBlock):void");
    }

    static String queryLookup(String query, String param) {
        char[] in = query.toCharArray();
        int eq = HASH_DOT_DOT;
        int st = HASH_DOT_DOT;
        for (int i = HASH_DOT_DOT; i < in.length; i += TYPE_FILESYSTEM) {
            int ch = in[i];
            if (ch == 38) {
                if (eq <= st || !new String(in, st, eq - st).equalsIgnoreCase(param)) {
                    st = i + TYPE_FILESYSTEM;
                } else {
                    eq += TYPE_FILESYSTEM;
                    return new String(in, eq, i - eq);
                }
            } else if (ch == 61) {
                eq = i;
            }
        }
        if (eq <= st || !new String(in, st, eq - st).equalsIgnoreCase(param)) {
            return null;
        }
        eq += TYPE_FILESYSTEM;
        return new String(in, eq, in.length - eq);
    }

    UniAddress getAddress() throws UnknownHostException {
        if (this.addressIndex == 0) {
            return getFirstAddress();
        }
        return this.addresses[this.addressIndex - 1];
    }

    UniAddress getFirstAddress() throws UnknownHostException {
        this.addressIndex = HASH_DOT_DOT;
        String host = this.url.getHost();
        String path = this.url.getPath();
        String query = this.url.getQuery();
        if (query != null) {
            String server = queryLookup(query, "server");
            if (server == null || server.length() <= 0) {
                String address = queryLookup(query, "address");
                if (address != null && address.length() > 0) {
                    byte[] ip = InetAddress.getByName(address).getAddress();
                    this.addresses = new UniAddress[TYPE_FILESYSTEM];
                    this.addresses[HASH_DOT_DOT] = new UniAddress(InetAddress.getByAddress(host, ip));
                    return getNextAddress();
                }
            }
            this.addresses = new UniAddress[TYPE_FILESYSTEM];
            this.addresses[HASH_DOT_DOT] = UniAddress.getByName(server);
            return getNextAddress();
        }
        if (host.length() == 0) {
            try {
                NbtAddress addr = NbtAddress.getByName(NbtAddress.MASTER_BROWSER_NAME, TYPE_FILESYSTEM, null);
                this.addresses = new UniAddress[TYPE_FILESYSTEM];
                this.addresses[HASH_DOT_DOT] = UniAddress.getByName(addr.getHostAddress());
            } catch (UnknownHostException uhe) {
                NtlmPasswordAuthentication.initDefaults();
                if (NtlmPasswordAuthentication.DEFAULT_DOMAIN.equals("?")) {
                    throw uhe;
                }
                this.addresses = UniAddress.getAllByName(NtlmPasswordAuthentication.DEFAULT_DOMAIN, true);
            }
        } else if (path.length() == 0 || path.equals("/")) {
            this.addresses = UniAddress.getAllByName(host, true);
        } else {
            this.addresses = UniAddress.getAllByName(host, false);
        }
        return getNextAddress();
    }

    UniAddress getNextAddress() {
        if (this.addressIndex >= this.addresses.length) {
            return null;
        }
        UniAddress[] uniAddressArr = this.addresses;
        int i = this.addressIndex;
        this.addressIndex = i + TYPE_FILESYSTEM;
        return uniAddressArr[i];
    }

    boolean hasNextAddress() {
        return this.addressIndex < this.addresses.length;
    }

    void connect0() throws SmbException {
        try {
            connect();
        } catch (Throwable uhe) {
            throw new SmbException("Failed to connect to server", uhe);
        } catch (SmbException se) {
            throw se;
        } catch (Throwable ioe) {
            throw new SmbException("Failed to connect to server", ioe);
        }
    }

    void doConnect() throws IOException {
        SmbTransport trans;
        boolean z;
        boolean z2 = true;
        UniAddress addr = getAddress();
        if (this.tree != null) {
            trans = this.tree.session.transport;
        } else {
            trans = SmbTransport.getSmbTransport(addr, this.url.getPort());
            this.tree = trans.getSmbSession(this.auth).getSmbTree(this.share, null);
        }
        String hostName = getServerWithDfs();
        SmbTree smbTree = this.tree;
        if (dfs.resolve(hostName, this.tree.share, null, this.auth) != null) {
            z = true;
        } else {
            z = false;
        }
        smbTree.inDomainDfs = z;
        if (this.tree.inDomainDfs) {
            this.tree.connectionState = TYPE_WORKGROUP;
        }
        LogStream logStream;
        try {
            logStream = log;
            if (LogStream.level >= O_RDWR) {
                log.println("doConnect: " + addr);
            }
            this.tree.treeConnect(null, null);
        } catch (SmbAuthException sae) {
            if (this.share == null) {
                this.tree = trans.getSmbSession(NtlmPasswordAuthentication.NULL).getSmbTree(null, null);
                this.tree.treeConnect(null, null);
                return;
            }
            NtlmPasswordAuthentication a = NtlmAuthenticator.requestNtlmPasswordAuthentication(this.url.toString(), sae);
            if (a != null) {
                this.auth = a;
                this.tree = trans.getSmbSession(this.auth).getSmbTree(this.share, null);
                SmbTree smbTree2 = this.tree;
                if (dfs.resolve(hostName, this.tree.share, null, this.auth) == null) {
                    z2 = false;
                }
                smbTree2.inDomainDfs = z2;
                if (this.tree.inDomainDfs) {
                    this.tree.connectionState = TYPE_WORKGROUP;
                }
                this.tree.treeConnect(null, null);
                return;
            }
            logStream = log;
            if (LogStream.level >= TYPE_FILESYSTEM && hasNextAddress()) {
                sae.printStackTrace(log);
            }
            throw sae;
        }
    }

    public void connect() throws IOException {
        if (!isConnected()) {
            getUncPath0();
            getFirstAddress();
            while (true) {
                try {
                    doConnect();
                    return;
                } catch (SmbAuthException sae) {
                    throw sae;
                } catch (SmbException se) {
                    if (getNextAddress() == null) {
                        break;
                        throw se;
                    }
                    LogStream logStream = log;
                    if (LogStream.level >= O_RDWR) {
                        se.printStackTrace(log);
                    }
                }
            }
            throw se;
        }
    }

    boolean isConnected() {
        return this.tree != null && this.tree.connectionState == TYPE_WORKGROUP;
    }

    int open0(int flags, int access, int attrs, int options) throws SmbException {
        connect0();
        LogStream logStream = log;
        if (LogStream.level >= O_RDWR) {
            log.println("open0: " + this.unc);
        }
        if (this.tree.session.transport.hasCapability(TYPE_NAMED_PIPE)) {
            SmbComNTCreateAndXResponse response = new SmbComNTCreateAndXResponse();
            SmbComNTCreateAndX request = new SmbComNTCreateAndX(this.unc, flags, access, this.shareAccess, attrs, options, null);
            if (this instanceof SmbNamedPipe) {
                request.flags0 |= 22;
                request.desiredAccess |= SmbConstants.READ_CONTROL;
                response.isExtended = true;
            }
            send(request, response);
            int f = response.fid;
            this.attributes = response.extFileAttributes & ATTR_GET_MASK;
            this.attrExpiration = System.currentTimeMillis() + attrExpirationPeriod;
            this.isExists = true;
            return f;
        }
        SmbComOpenAndXResponse response2 = new SmbComOpenAndXResponse();
        send(new SmbComOpenAndX(this.unc, access, flags, null), response2);
        return response2.fid;
    }

    void open(int flags, int access, int attrs, int options) throws SmbException {
        if (!isOpen()) {
            this.fid = open0(flags, access, attrs, options);
            this.opened = true;
            this.tree_num = this.tree.tree_num;
        }
    }

    boolean isOpen() {
        return this.opened && isConnected() && this.tree_num == this.tree.tree_num;
    }

    void close(int f, long lastWriteTime) throws SmbException {
        LogStream logStream = log;
        if (LogStream.level >= O_RDWR) {
            log.println("close: " + f);
        }
        send(new SmbComClose(f, lastWriteTime), blank_resp());
    }

    void close(long lastWriteTime) throws SmbException {
        if (isOpen()) {
            close(this.fid, lastWriteTime);
            this.opened = false;
        }
    }

    void close() throws SmbException {
        close(0);
    }

    public Principal getPrincipal() {
        return this.auth;
    }

    public String getName() {
        getUncPath0();
        if (this.canon.length() > TYPE_FILESYSTEM) {
            int i = this.canon.length() - 2;
            while (this.canon.charAt(i) != '/') {
                i--;
            }
            return this.canon.substring(i + TYPE_FILESYSTEM);
        } else if (this.share != null) {
            return this.share + '/';
        } else {
            if (this.url.getHost().length() > 0) {
                return this.url.getHost() + '/';
            }
            return "smb://";
        }
    }

    public String getParent() {
        String str = this.url.getAuthority();
        if (str.length() <= 0) {
            return "smb://";
        }
        StringBuffer sb = new StringBuffer("smb://");
        sb.append(str);
        getUncPath0();
        if (this.canon.length() > TYPE_FILESYSTEM) {
            sb.append(this.canon);
        } else {
            sb.append('/');
        }
        str = sb.toString();
        int i = str.length() - 2;
        while (str.charAt(i) != '/') {
            i--;
        }
        return str.substring(HASH_DOT_DOT, i + TYPE_FILESYSTEM);
    }

    public String getPath() {
        return this.url.toString();
    }

    String getUncPath0() {
        if (this.unc == null) {
            int o;
            char[] in = this.url.getPath().toCharArray();
            char[] out = new char[in.length];
            int length = in.length;
            int state = HASH_DOT_DOT;
            int i = HASH_DOT_DOT;
            int o2 = HASH_DOT_DOT;
            while (i < length) {
                switch (state) {
                    case HASH_DOT_DOT:
                        if (in[i] == '/') {
                            o = o2 + TYPE_FILESYSTEM;
                            out[o2] = in[i];
                            state = TYPE_FILESYSTEM;
                            break;
                        }
                        return null;
                    case TYPE_FILESYSTEM /*1*/:
                        if (in[i] != '/') {
                            if (in[i] != '.' || (i + TYPE_FILESYSTEM < length && in[i + TYPE_FILESYSTEM] != '/')) {
                                if (i + TYPE_FILESYSTEM < length && in[i] == '.' && in[i + TYPE_FILESYSTEM] == '.' && (i + TYPE_WORKGROUP >= length || in[i + TYPE_WORKGROUP] == '/')) {
                                    i += TYPE_WORKGROUP;
                                    if (o2 != TYPE_FILESYSTEM) {
                                        o = o2;
                                        do {
                                            o--;
                                            if (o <= TYPE_FILESYSTEM) {
                                                break;
                                            }
                                        } while (out[o - 1] != '/');
                                        break;
                                    }
                                    o = o2;
                                    break;
                                }
                                state = TYPE_WORKGROUP;
                            } else {
                                i += TYPE_FILESYSTEM;
                                o = o2;
                                break;
                            }
                        }
                        o = o2;
                        break;
                        break;
                    case TYPE_WORKGROUP /*2*/:
                        if (in[i] == '/') {
                            state = TYPE_FILESYSTEM;
                        }
                        o = o2 + TYPE_FILESYSTEM;
                        out[o2] = in[i];
                        break;
                    default:
                        o = o2;
                        break;
                }
                i += TYPE_FILESYSTEM;
                o2 = o;
            }
            this.canon = new String(out, HASH_DOT_DOT, o2);
            if (o2 > TYPE_FILESYSTEM) {
                o = o2 - 1;
                i = this.canon.indexOf(47, TYPE_FILESYSTEM);
                if (i < 0) {
                    this.share = this.canon.substring(TYPE_FILESYSTEM);
                    this.unc = "\\";
                } else if (i == o) {
                    this.share = this.canon.substring(TYPE_FILESYSTEM, i);
                    this.unc = "\\";
                } else {
                    this.share = this.canon.substring(TYPE_FILESYSTEM, i);
                    String str = this.canon;
                    if (out[o] != '/') {
                        o += TYPE_FILESYSTEM;
                    }
                    this.unc = str.substring(i, o);
                    this.unc = this.unc.replace('/', '\\');
                }
            } else {
                this.share = null;
                this.unc = "\\";
            }
        }
        return this.unc;
    }

    public String getUncPath() {
        getUncPath0();
        if (this.share == null) {
            return "\\\\" + this.url.getHost();
        }
        return "\\\\" + this.url.getHost() + this.canon.replace('/', '\\');
    }

    public String getCanonicalPath() {
        String str = this.url.getAuthority();
        getUncPath0();
        if (str.length() > 0) {
            return "smb://" + this.url.getAuthority() + this.canon;
        }
        return "smb://";
    }

    public String getShare() {
        return this.share;
    }

    String getServerWithDfs() {
        if (this.dfsReferral != null) {
            return this.dfsReferral.server;
        }
        return getServer();
    }

    public String getServer() {
        String str = this.url.getHost();
        if (str.length() == 0) {
            return null;
        }
        return str;
    }

    public int getType() throws SmbException {
        if (this.type == 0) {
            if (getUncPath0().length() > TYPE_FILESYSTEM) {
                this.type = TYPE_FILESYSTEM;
            } else if (this.share != null) {
                connect0();
                if (this.share.equals("IPC$")) {
                    this.type = TYPE_NAMED_PIPE;
                } else if (this.tree.service.equals("LPT1:")) {
                    this.type = TYPE_PRINTER;
                } else if (this.tree.service.equals("COMM")) {
                    this.type = TYPE_COMM;
                } else {
                    this.type = TYPE_SHARE;
                }
            } else if (this.url.getAuthority() == null || this.url.getAuthority().length() == 0) {
                this.type = TYPE_WORKGROUP;
            } else {
                try {
                    UniAddress addr = getAddress();
                    if (addr.getAddress() instanceof NbtAddress) {
                        int code = ((NbtAddress) addr.getAddress()).getNameType();
                        if (code == 29 || code == 27) {
                            this.type = TYPE_WORKGROUP;
                            return this.type;
                        }
                    }
                    this.type = TYPE_SERVER;
                } catch (Throwable uhe) {
                    throw new SmbException(this.url.toString(), uhe);
                }
            }
        }
        return this.type;
    }

    boolean isWorkgroup0() throws UnknownHostException {
        if (this.type == TYPE_WORKGROUP || this.url.getHost().length() == 0) {
            this.type = TYPE_WORKGROUP;
            return true;
        }
        getUncPath0();
        if (this.share == null) {
            UniAddress addr = getAddress();
            if (addr.getAddress() instanceof NbtAddress) {
                int code = ((NbtAddress) addr.getAddress()).getNameType();
                if (code == 29 || code == 27) {
                    this.type = TYPE_WORKGROUP;
                    return true;
                }
            }
            this.type = TYPE_SERVER;
        }
        return false;
    }

    Info queryPath(String path, int infoLevel) throws SmbException {
        connect0();
        LogStream logStream = log;
        if (LogStream.level >= O_RDWR) {
            log.println("queryPath: " + path);
        }
        if (this.tree.session.transport.hasCapability(TYPE_NAMED_PIPE)) {
            Trans2QueryPathInformationResponse response = new Trans2QueryPathInformationResponse(infoLevel);
            send(new Trans2QueryPathInformation(path, infoLevel), response);
            return response.info;
        }
        response = new SmbComQueryInformationResponse(((long) (this.tree.session.transport.server.serverTimeZone * MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA)) * 60);
        send(new SmbComQueryInformation(path), response);
        return response;
    }

    public boolean exists() throws SmbException {
        if (this.attrExpiration > System.currentTimeMillis()) {
            return this.isExists;
        }
        this.attributes = 17;
        this.createTime = 0;
        this.lastModified = 0;
        this.isExists = false;
        try {
            if (this.url.getHost().length() != 0) {
                if (this.share == null) {
                    if (getType() == TYPE_WORKGROUP) {
                        UniAddress.getByName(this.url.getHost(), true);
                    } else {
                        UniAddress.getByName(this.url.getHost()).getHostName();
                    }
                } else if (getUncPath0().length() == TYPE_FILESYSTEM || this.share.equalsIgnoreCase("IPC$")) {
                    connect0();
                } else {
                    Info info = queryPath(getUncPath0(), MKeyEvent.KEYCODE_LIST);
                    this.attributes = info.getAttributes();
                    this.createTime = info.getCreateTime();
                    this.lastModified = info.getLastWriteTime();
                }
            }
            this.isExists = true;
        } catch (UnknownHostException e) {
        } catch (SmbException se) {
            switch (se.getNtStatus()) {
                case NtStatus.NT_STATUS_NO_SUCH_FILE /*-1073741809*/:
                case NtStatus.NT_STATUS_OBJECT_NAME_INVALID /*-1073741773*/:
                case NtStatus.NT_STATUS_OBJECT_NAME_NOT_FOUND /*-1073741772*/:
                case NtStatus.NT_STATUS_OBJECT_PATH_NOT_FOUND /*-1073741766*/:
                    break;
                default:
                    throw se;
            }
        }
        this.attrExpiration = System.currentTimeMillis() + attrExpirationPeriod;
        return this.isExists;
    }

    public boolean canRead() throws SmbException {
        if (getType() == TYPE_NAMED_PIPE) {
            return true;
        }
        return exists();
    }

    public boolean canWrite() throws SmbException {
        if (getType() == TYPE_NAMED_PIPE) {
            return true;
        }
        if (exists() && (this.attributes & TYPE_FILESYSTEM) == 0) {
            return true;
        }
        return false;
    }

    public boolean isDirectory() throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            return true;
        }
        if (!exists()) {
            return false;
        }
        if ((this.attributes & TYPE_NAMED_PIPE) != TYPE_NAMED_PIPE) {
            return false;
        }
        return true;
    }

    public boolean isFile() throws SmbException {
        boolean z = true;
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            return false;
        }
        exists();
        if ((this.attributes & TYPE_NAMED_PIPE) != 0) {
            z = false;
        }
        return z;
    }

    public boolean isHidden() throws SmbException {
        boolean z = true;
        if (this.share == null) {
            return false;
        }
        if (getUncPath0().length() != TYPE_FILESYSTEM) {
            exists();
            if ((this.attributes & TYPE_WORKGROUP) != TYPE_WORKGROUP) {
                z = false;
            }
            return z;
        } else if (this.share.endsWith("$")) {
            return true;
        } else {
            return false;
        }
    }

    public String getDfsPath() throws SmbException {
        resolveDfs(null);
        if (this.dfsReferral == null) {
            return null;
        }
        String path = ("smb:/" + this.dfsReferral.server + "/" + this.dfsReferral.share + this.unc).replace('\\', '/');
        if (isDirectory()) {
            return path + '/';
        }
        return path;
    }

    public long createTime() throws SmbException {
        if (getUncPath0().length() <= TYPE_FILESYSTEM) {
            return 0;
        }
        exists();
        return this.createTime;
    }

    public long lastModified() throws SmbException {
        if (getUncPath0().length() <= TYPE_FILESYSTEM) {
            return 0;
        }
        exists();
        return this.lastModified;
    }

    public String[] list() throws SmbException {
        return list("*", 22, null, null);
    }

    public String[] list(SmbFilenameFilter filter) throws SmbException {
        return list("*", 22, filter, null);
    }

    public SmbFile[] listFiles() throws SmbException {
        return listFiles("*", 22, null, null);
    }

    public SmbFile[] listFiles(String wildcard) throws SmbException {
        return listFiles(wildcard, 22, null, null);
    }

    public SmbFile[] listFiles(SmbFilenameFilter filter) throws SmbException {
        return listFiles("*", 22, filter, null);
    }

    public SmbFile[] listFiles(SmbFileFilter filter) throws SmbException {
        return listFiles("*", 22, null, filter);
    }

    String[] list(String wildcard, int searchAttributes, SmbFilenameFilter fnf, SmbFileFilter ff) throws SmbException {
        ArrayList list = new ArrayList();
        doEnum(list, false, wildcard, searchAttributes, fnf, ff);
        return (String[]) list.toArray(new String[list.size()]);
    }

    SmbFile[] listFiles(String wildcard, int searchAttributes, SmbFilenameFilter fnf, SmbFileFilter ff) throws SmbException {
        ArrayList list = new ArrayList();
        doEnum(list, true, wildcard, searchAttributes, fnf, ff);
        return (SmbFile[]) list.toArray(new SmbFile[list.size()]);
    }

    void doEnum(ArrayList list, boolean files, String wildcard, int searchAttributes, SmbFilenameFilter fnf, SmbFileFilter ff) throws SmbException {
        if (ff != null && (ff instanceof DosFileFilter)) {
            DosFileFilter dff = (DosFileFilter) ff;
            if (dff.wildcard != null) {
                wildcard = dff.wildcard;
            }
            searchAttributes = dff.attributes;
        }
        try {
            if (this.url.getHost().length() == 0 || getType() == TYPE_WORKGROUP) {
                doNetServerEnum(list, files, wildcard, searchAttributes, fnf, ff);
            } else if (this.share == null) {
                doShareEnum(list, files, wildcard, searchAttributes, fnf, ff);
            } else {
                doFindFirstNext(list, files, wildcard, searchAttributes, fnf, ff);
            }
        } catch (Throwable uhe) {
            throw new SmbException(this.url.toString(), uhe);
        } catch (Throwable mue) {
            throw new SmbException(this.url.toString(), mue);
        }
    }

    void doShareEnum(ArrayList list, boolean files, String wildcard, int searchAttributes, SmbFilenameFilter fnf, SmbFileFilter ff) throws SmbException, UnknownHostException, MalformedURLException {
        LogStream logStream;
        String p = this.url.getPath();
        Throwable last = null;
        if (p.lastIndexOf(47) != p.length() - 1) {
            throw new SmbException(this.url.toString() + " directory must end with '/'");
        } else if (getType() != TYPE_SERVER) {
            throw new SmbException("The requested list operations is invalid: " + this.url.toString());
        } else {
            FileEntry[] entries;
            int ei;
            FileEntry e;
            HashMap map = new HashMap();
            if (dfs.isTrustedDomain(getServer(), this.auth)) {
                try {
                    entries = doDfsRootEnum();
                    for (ei = HASH_DOT_DOT; ei < entries.length; ei += TYPE_FILESYSTEM) {
                        e = entries[ei];
                        if (!map.containsKey(e)) {
                            map.put(e, e);
                        }
                    }
                } catch (IOException ioe) {
                    logStream = log;
                    if (LogStream.level >= TYPE_SERVER) {
                        ioe.printStackTrace(log);
                    }
                }
            }
            UniAddress addr = getFirstAddress();
            loop1:
            while (addr != null) {
                try {
                    doConnect();
                    try {
                        entries = doMsrpcShareEnum();
                    } catch (IOException ioe2) {
                        logStream = log;
                        if (LogStream.level >= O_RDWR) {
                            ioe2.printStackTrace(log);
                        }
                        entries = doNetShareEnum();
                    }
                    for (ei = HASH_DOT_DOT; ei < entries.length; ei += TYPE_FILESYSTEM) {
                        e = entries[ei];
                        if (!map.containsKey(e)) {
                            map.put(e, e);
                        }
                    }
                    break loop1;
                } catch (Throwable ioe3) {
                    logStream = log;
                    if (LogStream.level >= O_RDWR) {
                        ioe3.printStackTrace(log);
                    }
                    last = ioe3;
                    addr = getNextAddress();
                }
            }
            if (last == null || !map.isEmpty()) {
                for (FileEntry e2 : map.keySet()) {
                    String name = e2.getName();
                    if ((fnf == null || fnf.accept(this, name)) && name.length() > 0) {
                        SmbFile f = new SmbFile(this, name, e2.getType(), 17, 0, 0, 0);
                        if (ff == null || ff.accept(f)) {
                            if (files) {
                                list.add(f);
                            } else {
                                list.add(name);
                            }
                        }
                    }
                }
            } else if (last instanceof SmbException) {
                throw ((SmbException) last);
            } else {
                throw new SmbException(this.url.toString(), last);
            }
        }
    }

    FileEntry[] doDfsRootEnum() throws IOException {
        DcerpcHandle handle = DcerpcHandle.getHandle("ncacn_np:" + getAddress().getHostAddress() + "[\\PIPE\\netdfs]", this.auth);
        try {
            MsrpcDfsRootEnum rpc = new MsrpcDfsRootEnum(getServer());
            handle.sendrecv(rpc);
            if (rpc.retval != 0) {
                throw new SmbException(rpc.retval, true);
            }
            FileEntry[] entries = rpc.getEntries();
            return entries;
        } finally {
            try {
                handle.close();
            } catch (IOException ioe) {
                LogStream logStream = log;
                if (LogStream.level >= TYPE_SERVER) {
                    ioe.printStackTrace(log);
                }
            }
        }
    }

    FileEntry[] doMsrpcShareEnum() throws IOException {
        MsrpcShareEnum rpc = new MsrpcShareEnum(this.url.getHost());
        DcerpcHandle handle = DcerpcHandle.getHandle("ncacn_np:" + getAddress().getHostAddress() + "[\\PIPE\\srvsvc]", this.auth);
        try {
            handle.sendrecv(rpc);
            if (rpc.retval != 0) {
                throw new SmbException(rpc.retval, true);
            }
            FileEntry[] entries = rpc.getEntries();
            return entries;
        } finally {
            try {
                handle.close();
            } catch (IOException ioe) {
                LogStream logStream = log;
                if (LogStream.level >= TYPE_SERVER) {
                    ioe.printStackTrace(log);
                }
            }
        }
    }

    FileEntry[] doNetShareEnum() throws SmbException {
        SmbComTransaction req = new NetShareEnum();
        SmbComTransactionResponse resp = new NetShareEnumResponse();
        send(req, resp);
        if (resp.status == 0) {
            return resp.results;
        }
        throw new SmbException(resp.status, true);
    }

    void doNetServerEnum(ArrayList list, boolean files, String wildcard, int searchAttributes, SmbFilenameFilter fnf, SmbFileFilter ff) throws SmbException, UnknownHostException, MalformedURLException {
        ServerMessageBlock resp;
        int listType = this.url.getHost().length() == 0 ? HASH_DOT_DOT : getType();
        ServerMessageBlock netServerEnum2;
        if (listType == 0) {
            connect0();
            netServerEnum2 = new NetServerEnum2(this.tree.session.transport.server.oemDomainName, ExploreByTouchHelper.INVALID_ID);
            resp = new NetServerEnum2Response();
        } else if (listType == TYPE_WORKGROUP) {
            netServerEnum2 = new NetServerEnum2(this.url.getHost(), -1);
            resp = new NetServerEnum2Response();
        } else {
            throw new SmbException("The requested list operations is invalid: " + this.url.toString());
        }
        boolean more;
        do {
            send(req, resp);
            if (resp.status == 0 || resp.status == WinError.ERROR_MORE_DATA) {
                more = resp.status == WinError.ERROR_MORE_DATA;
                int n = more ? resp.numEntries - 1 : resp.numEntries;
                for (int i = HASH_DOT_DOT; i < n; i += TYPE_FILESYSTEM) {
                    FileEntry e = resp.results[i];
                    String name = e.getName();
                    if ((fnf == null || fnf.accept(this, name)) && name.length() > 0) {
                        SmbFile f = new SmbFile(this, name, e.getType(), 17, 0, 0, 0);
                        if (ff == null || ff.accept(f)) {
                            if (files) {
                                list.add(f);
                            } else {
                                list.add(name);
                            }
                        }
                    }
                }
                if (getType() == TYPE_WORKGROUP) {
                    req.subCommand = (byte) -41;
                    req.reset(HASH_DOT_DOT, ((NetServerEnum2Response) resp).lastName);
                    resp.reset();
                } else {
                    return;
                }
            }
            throw new SmbException(resp.status, true);
        } while (more);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void doFindFirstNext(java.util.ArrayList r25, boolean r26, java.lang.String r27, int r28, jcifs.smb.SmbFilenameFilter r29, jcifs.smb.SmbFileFilter r30) throws jcifs.smb.SmbException, java.net.UnknownHostException, java.net.MalformedURLException {
        /*
        r24 = this;
        r19 = r24.getUncPath0();
        r0 = r24;
        r6 = r0.url;
        r18 = r6.getPath();
        r6 = 47;
        r0 = r18;
        r6 = r0.lastIndexOf(r6);
        r8 = r18.length();
        r8 = r8 + -1;
        if (r6 == r8) goto L_0x003d;
    L_0x001c:
        r6 = new jcifs.smb.SmbException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r24;
        r9 = r0.url;
        r9 = r9.toString();
        r8 = r8.append(r9);
        r9 = " directory must end with '/'";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r6.<init>(r8);
        throw r6;
    L_0x003d:
        r20 = new jcifs.smb.Trans2FindFirst2;
        r0 = r20;
        r1 = r19;
        r2 = r27;
        r3 = r28;
        r0.<init>(r1, r2, r3);
        r21 = new jcifs.smb.Trans2FindFirst2Response;
        r21.<init>();
        r6 = log;
        r6 = jcifs.util.LogStream.level;
        r8 = 3;
        if (r6 < r8) goto L_0x0072;
    L_0x0056:
        r6 = log;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "doFindFirstNext: ";
        r8 = r8.append(r9);
        r0 = r20;
        r9 = r0.path;
        r8 = r8.append(r9);
        r8 = r8.toString();
        r6.println(r8);
    L_0x0072:
        r0 = r24;
        r1 = r20;
        r2 = r21;
        r0.send(r1, r2);
        r0 = r21;
        r0 = r0.sid;
        r23 = r0;
        r20 = new jcifs.smb.Trans2FindNext2;
        r0 = r21;
        r6 = r0.resumeKey;
        r0 = r21;
        r8 = r0.lastName;
        r0 = r20;
        r1 = r23;
        r0.<init>(r1, r6, r8);
        r6 = 2;
        r0 = r21;
        r0.subCommand = r6;
    L_0x0097:
        r17 = 0;
    L_0x0099:
        r0 = r21;
        r6 = r0.numEntries;
        r0 = r17;
        if (r0 >= r6) goto L_0x0117;
    L_0x00a1:
        r0 = r21;
        r6 = r0.results;
        r4 = r6[r17];
        r7 = r4.getName();
        r6 = r7.length();
        r8 = 3;
        if (r6 >= r8) goto L_0x00d5;
    L_0x00b2:
        r16 = r7.hashCode();
        r6 = HASH_DOT;
        r0 = r16;
        if (r0 == r6) goto L_0x00c2;
    L_0x00bc:
        r6 = HASH_DOT_DOT;
        r0 = r16;
        if (r0 != r6) goto L_0x00d5;
    L_0x00c2:
        r6 = ".";
        r6 = r7.equals(r6);
        if (r6 != 0) goto L_0x00d2;
    L_0x00ca:
        r6 = "..";
        r6 = r7.equals(r6);
        if (r6 == 0) goto L_0x00d5;
    L_0x00d2:
        r17 = r17 + 1;
        goto L_0x0099;
    L_0x00d5:
        if (r29 == 0) goto L_0x00e1;
    L_0x00d7:
        r0 = r29;
        r1 = r24;
        r6 = r0.accept(r1, r7);
        if (r6 == 0) goto L_0x00d2;
    L_0x00e1:
        r6 = r7.length();
        if (r6 <= 0) goto L_0x00d2;
    L_0x00e7:
        r5 = new jcifs.smb.SmbFile;
        r8 = 1;
        r9 = r4.getAttributes();
        r10 = r4.createTime();
        r12 = r4.lastModified();
        r14 = r4.length();
        r6 = r24;
        r5.<init>(r6, r7, r8, r9, r10, r12, r14);
        if (r30 == 0) goto L_0x0109;
    L_0x0101:
        r0 = r30;
        r6 = r0.accept(r5);
        if (r6 == 0) goto L_0x00d2;
    L_0x0109:
        if (r26 == 0) goto L_0x0111;
    L_0x010b:
        r0 = r25;
        r0.add(r5);
        goto L_0x00d2;
    L_0x0111:
        r0 = r25;
        r0.add(r7);
        goto L_0x00d2;
    L_0x0117:
        r0 = r21;
        r6 = r0.isEndOfSearch;
        if (r6 != 0) goto L_0x0123;
    L_0x011d:
        r0 = r21;
        r6 = r0.numEntries;
        if (r6 != 0) goto L_0x0134;
    L_0x0123:
        r6 = new jcifs.smb.SmbComFindClose2;	 Catch:{ SmbException -> 0x014f }
        r0 = r23;
        r6.<init>(r0);	 Catch:{ SmbException -> 0x014f }
        r8 = r24.blank_resp();	 Catch:{ SmbException -> 0x014f }
        r0 = r24;
        r0.send(r6, r8);	 Catch:{ SmbException -> 0x014f }
    L_0x0133:
        return;
    L_0x0134:
        r0 = r21;
        r6 = r0.resumeKey;
        r0 = r21;
        r8 = r0.lastName;
        r0 = r20;
        r0.reset(r6, r8);
        r21.reset();
        r0 = r24;
        r1 = r20;
        r2 = r21;
        r0.send(r1, r2);
        goto L_0x0097;
    L_0x014f:
        r22 = move-exception;
        r6 = log;
        r6 = jcifs.util.LogStream.level;
        r8 = 4;
        if (r6 < r8) goto L_0x0133;
    L_0x0157:
        r6 = log;
        r0 = r22;
        r0.printStackTrace(r6);
        goto L_0x0133;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.SmbFile.doFindFirstNext(java.util.ArrayList, boolean, java.lang.String, int, jcifs.smb.SmbFilenameFilter, jcifs.smb.SmbFileFilter):void");
    }

    public void renameTo(SmbFile dest) throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM || dest.getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        resolveDfs(null);
        dest.resolveDfs(null);
        if (this.tree.equals(dest.tree)) {
            LogStream logStream = log;
            if (LogStream.level >= O_RDWR) {
                log.println("renameTo: " + this.unc + " -> " + dest.unc);
            }
            this.sizeExpiration = 0;
            this.attrExpiration = 0;
            dest.attrExpiration = 0;
            send(new SmbComRename(this.unc, dest.unc), blank_resp());
            return;
        }
        throw new SmbException("Invalid operation for workgroups, servers, or shares");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void copyTo0(jcifs.smb.SmbFile r30, byte[][] r31, int r32, jcifs.smb.SmbFile.WriterThread r33, jcifs.smb.SmbComReadAndX r34, jcifs.smb.SmbComReadAndXResponse r35) throws jcifs.smb.SmbException {
        /*
        r29 = this;
        r0 = r29;
        r6 = r0.attrExpiration;
        r8 = java.lang.System.currentTimeMillis();
        r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r4 >= 0) goto L_0x0057;
    L_0x000c:
        r4 = 17;
        r0 = r29;
        r0.attributes = r4;
        r6 = 0;
        r0 = r29;
        r0.createTime = r6;
        r6 = 0;
        r0 = r29;
        r0.lastModified = r6;
        r4 = 0;
        r0 = r29;
        r0.isExists = r4;
        r4 = r29.getUncPath0();
        r6 = 257; // 0x101 float:3.6E-43 double:1.27E-321;
        r0 = r29;
        r23 = r0.queryPath(r4, r6);
        r4 = r23.getAttributes();
        r0 = r29;
        r0.attributes = r4;
        r6 = r23.getCreateTime();
        r0 = r29;
        r0.createTime = r6;
        r6 = r23.getLastWriteTime();
        r0 = r29;
        r0.lastModified = r6;
        r4 = 1;
        r0 = r29;
        r0.isExists = r4;
        r6 = java.lang.System.currentTimeMillis();
        r8 = attrExpirationPeriod;
        r6 = r6 + r8;
        r0 = r29;
        r0.attrExpiration = r6;
    L_0x0057:
        r4 = r29.isDirectory();
        if (r4 == 0) goto L_0x00fa;
    L_0x005d:
        r25 = r30.getUncPath0();
        r4 = r25.length();
        r6 = 1;
        if (r4 <= r6) goto L_0x007c;
    L_0x0068:
        r30.mkdir();	 Catch:{ SmbException -> 0x00c4 }
        r0 = r29;
        r5 = r0.attributes;	 Catch:{ SmbException -> 0x00c4 }
        r0 = r29;
        r6 = r0.createTime;	 Catch:{ SmbException -> 0x00c4 }
        r0 = r29;
        r8 = r0.lastModified;	 Catch:{ SmbException -> 0x00c4 }
        r4 = r30;
        r4.setPathInformation(r5, r6, r8);	 Catch:{ SmbException -> 0x00c4 }
    L_0x007c:
        r4 = "*";
        r6 = 22;
        r7 = 0;
        r8 = 0;
        r0 = r29;
        r20 = r0.listFiles(r4, r6, r7, r8);
        r21 = 0;
    L_0x008a:
        r0 = r20;
        r4 = r0.length;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r0 = r21;
        if (r0 >= r4) goto L_0x0201;
    L_0x0091:
        r5 = new jcifs.smb.SmbFile;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r7 = r4.getName();	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r8 = r4.type;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r9 = r4.attributes;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r10 = r4.createTime;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r12 = r4.lastModified;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r14 = r4.size;	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r6 = r30;
        r5.<init>(r6, r7, r8, r9, r10, r12, r14);	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r4 = r20[r21];	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r6 = r31;
        r7 = r32;
        r8 = r33;
        r9 = r34;
        r10 = r35;
        r4.copyTo0(r5, r6, r7, r8, r9, r10);	 Catch:{ UnknownHostException -> 0x00d8, MalformedURLException -> 0x00e9 }
        r21 = r21 + 1;
        goto L_0x008a;
    L_0x00c4:
        r27 = move-exception;
        r4 = r27.getNtStatus();
        r6 = -1073741790; // 0xffffffffc0000022 float:-2.000008 double:NaN;
        if (r4 == r6) goto L_0x007c;
    L_0x00ce:
        r4 = r27.getNtStatus();
        r6 = -1073741771; // 0xffffffffc0000035 float:-2.0000126 double:NaN;
        if (r4 == r6) goto L_0x007c;
    L_0x00d7:
        throw r27;
    L_0x00d8:
        r28 = move-exception;
        r4 = new jcifs.smb.SmbException;
        r0 = r29;
        r6 = r0.url;
        r6 = r6.toString();
        r0 = r28;
        r4.<init>(r6, r0);
        throw r4;
    L_0x00e9:
        r24 = move-exception;
        r4 = new jcifs.smb.SmbException;
        r0 = r29;
        r6 = r0.url;
        r6 = r6.toString();
        r0 = r24;
        r4.<init>(r6, r0);
        throw r4;
    L_0x00fa:
        r4 = 1;
        r6 = 0;
        r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r8 = 0;
        r0 = r29;
        r0.open(r4, r6, r7, r8);	 Catch:{ SmbException -> 0x0141 }
        r4 = 82;
        r6 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
        r0 = r29;
        r7 = r0.attributes;	 Catch:{ SmbAuthException -> 0x017e }
        r8 = 0;
        r0 = r30;
        r0.open(r4, r6, r7, r8);	 Catch:{ SmbAuthException -> 0x017e }
    L_0x0112:
        r21 = 0;
        r10 = 0;
    L_0x0116:
        r0 = r29;
        r4 = r0.fid;	 Catch:{ SmbException -> 0x0141 }
        r0 = r34;
        r1 = r32;
        r0.setParam(r4, r10, r1);	 Catch:{ SmbException -> 0x0141 }
        r4 = r31[r21];	 Catch:{ SmbException -> 0x0141 }
        r6 = 0;
        r0 = r35;
        r0.setParam(r4, r6);	 Catch:{ SmbException -> 0x0141 }
        r0 = r29;
        r1 = r34;
        r2 = r35;
        r0.send(r1, r2);	 Catch:{ SmbException -> 0x0141 }
        monitor-enter(r33);	 Catch:{ SmbException -> 0x0141 }
        r0 = r33;
        r4 = r0.f69e;	 Catch:{ all -> 0x013e }
        if (r4 == 0) goto L_0x01a7;
    L_0x0139:
        r0 = r33;
        r4 = r0.f69e;	 Catch:{ all -> 0x013e }
        throw r4;	 Catch:{ all -> 0x013e }
    L_0x013e:
        r4 = move-exception;
        monitor-exit(r33);	 Catch:{ all -> 0x013e }
        throw r4;	 Catch:{ SmbException -> 0x0141 }
    L_0x0141:
        r27 = move-exception;
        r4 = ignoreCopyToException;	 Catch:{ all -> 0x0179 }
        if (r4 != 0) goto L_0x0222;
    L_0x0146:
        r4 = new jcifs.smb.SmbException;	 Catch:{ all -> 0x0179 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0179 }
        r6.<init>();	 Catch:{ all -> 0x0179 }
        r7 = "Failed to copy file from [";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0179 }
        r7 = r29.toString();	 Catch:{ all -> 0x0179 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0179 }
        r7 = "] to [";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0179 }
        r7 = r30.toString();	 Catch:{ all -> 0x0179 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0179 }
        r7 = "]";
        r6 = r6.append(r7);	 Catch:{ all -> 0x0179 }
        r6 = r6.toString();	 Catch:{ all -> 0x0179 }
        r0 = r27;
        r4.<init>(r6, r0);	 Catch:{ all -> 0x0179 }
        throw r4;	 Catch:{ all -> 0x0179 }
    L_0x0179:
        r4 = move-exception;
        r29.close();
        throw r4;
    L_0x017e:
        r26 = move-exception;
        r0 = r30;
        r4 = r0.attributes;	 Catch:{ SmbException -> 0x0141 }
        r4 = r4 & 1;
        if (r4 == 0) goto L_0x01a6;
    L_0x0187:
        r0 = r30;
        r4 = r0.attributes;	 Catch:{ SmbException -> 0x0141 }
        r7 = r4 & -2;
        r8 = 0;
        r10 = 0;
        r6 = r30;
        r6.setPathInformation(r7, r8, r10);	 Catch:{ SmbException -> 0x0141 }
        r4 = 82;
        r6 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
        r0 = r29;
        r7 = r0.attributes;	 Catch:{ SmbException -> 0x0141 }
        r8 = 0;
        r0 = r30;
        r0.open(r4, r6, r7, r8);	 Catch:{ SmbException -> 0x0141 }
        goto L_0x0112;
    L_0x01a6:
        throw r26;	 Catch:{ SmbException -> 0x0141 }
    L_0x01a7:
        r0 = r33;
        r4 = r0.ready;	 Catch:{ all -> 0x013e }
        if (r4 != 0) goto L_0x01c2;
    L_0x01ad:
        r33.wait();	 Catch:{ InterruptedException -> 0x01b1 }
        goto L_0x01a7;
    L_0x01b1:
        r22 = move-exception;
        r4 = new jcifs.smb.SmbException;	 Catch:{ all -> 0x013e }
        r0 = r30;
        r6 = r0.url;	 Catch:{ all -> 0x013e }
        r6 = r6.toString();	 Catch:{ all -> 0x013e }
        r0 = r22;
        r4.<init>(r6, r0);	 Catch:{ all -> 0x013e }
        throw r4;	 Catch:{ all -> 0x013e }
    L_0x01c2:
        r0 = r33;
        r4 = r0.f69e;	 Catch:{ all -> 0x013e }
        if (r4 == 0) goto L_0x01cd;
    L_0x01c8:
        r0 = r33;
        r4 = r0.f69e;	 Catch:{ all -> 0x013e }
        throw r4;	 Catch:{ all -> 0x013e }
    L_0x01cd:
        r0 = r35;
        r4 = r0.dataLength;	 Catch:{ all -> 0x013e }
        if (r4 > 0) goto L_0x0202;
    L_0x01d3:
        monitor-exit(r33);	 Catch:{ all -> 0x013e }
        r13 = new jcifs.smb.Trans2SetFileInformation;	 Catch:{ SmbException -> 0x0141 }
        r0 = r30;
        r14 = r0.fid;	 Catch:{ SmbException -> 0x0141 }
        r0 = r29;
        r15 = r0.attributes;	 Catch:{ SmbException -> 0x0141 }
        r0 = r29;
        r0 = r0.createTime;	 Catch:{ SmbException -> 0x0141 }
        r16 = r0;
        r0 = r29;
        r0 = r0.lastModified;	 Catch:{ SmbException -> 0x0141 }
        r18 = r0;
        r13.<init>(r14, r15, r16, r18);	 Catch:{ SmbException -> 0x0141 }
        r4 = new jcifs.smb.Trans2SetFileInformationResponse;	 Catch:{ SmbException -> 0x0141 }
        r4.<init>();	 Catch:{ SmbException -> 0x0141 }
        r0 = r30;
        r0.send(r13, r4);	 Catch:{ SmbException -> 0x0141 }
        r6 = 0;
        r0 = r30;
        r0.close(r6);	 Catch:{ SmbException -> 0x0141 }
        r29.close();
    L_0x0201:
        return;
    L_0x0202:
        r7 = r31[r21];	 Catch:{ all -> 0x013e }
        r0 = r35;
        r8 = r0.dataLength;	 Catch:{ all -> 0x013e }
        r6 = r33;
        r9 = r30;
        r6.write(r7, r8, r9, r10);	 Catch:{ all -> 0x013e }
        monitor-exit(r33);	 Catch:{ all -> 0x013e }
        r4 = 1;
        r0 = r21;
        if (r0 != r4) goto L_0x021f;
    L_0x0215:
        r21 = 0;
    L_0x0217:
        r0 = r35;
        r4 = r0.dataLength;	 Catch:{ SmbException -> 0x0141 }
        r6 = (long) r4;
        r10 = r10 + r6;
        goto L_0x0116;
    L_0x021f:
        r21 = 1;
        goto L_0x0217;
    L_0x0222:
        r4 = log;	 Catch:{ all -> 0x0179 }
        r4 = jcifs.util.LogStream.level;	 Catch:{ all -> 0x0179 }
        r6 = 1;
        if (r4 <= r6) goto L_0x0230;
    L_0x0229:
        r4 = log;	 Catch:{ all -> 0x0179 }
        r0 = r27;
        r0.printStackTrace(r4);	 Catch:{ all -> 0x0179 }
    L_0x0230:
        r29.close();
        goto L_0x0201;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.SmbFile.copyTo0(jcifs.smb.SmbFile, byte[][], int, jcifs.smb.SmbFile$WriterThread, jcifs.smb.SmbComReadAndX, jcifs.smb.SmbComReadAndXResponse):void");
    }

    public void copyTo(SmbFile dest) throws SmbException {
        if (this.share == null || dest.share == null) {
            throw new SmbException("Invalid operation for workgroups or servers");
        }
        SmbComReadAndX req = new SmbComReadAndX();
        SmbComReadAndXResponse resp = new SmbComReadAndXResponse();
        connect0();
        dest.connect0();
        resolveDfs(null);
        try {
            if (getAddress().equals(dest.getAddress()) && this.canon.regionMatches(true, HASH_DOT_DOT, dest.canon, HASH_DOT_DOT, Math.min(this.canon.length(), dest.canon.length()))) {
                throw new SmbException("Source and destination paths overlap.");
            }
        } catch (UnknownHostException e) {
        }
        WriterThread w = new WriterThread();
        w.setDaemon(true);
        w.start();
        SmbTransport t1 = this.tree.session.transport;
        SmbTransport t2 = dest.tree.session.transport;
        if (t1.snd_buf_size < t2.snd_buf_size) {
            t2.snd_buf_size = t1.snd_buf_size;
        } else {
            t1.snd_buf_size = t2.snd_buf_size;
        }
        int bsize = Math.min(t1.rcv_buf_size - 70, t1.snd_buf_size - 70);
        try {
            copyTo0(dest, (byte[][]) Array.newInstance(Byte.TYPE, new int[]{TYPE_WORKGROUP, bsize}), bsize, w, req, resp);
        } finally {
            w.write(null, -1, null, 0);
        }
    }

    public void delete() throws SmbException {
        exists();
        getUncPath0();
        delete(this.unc);
    }

    void delete(String fileName) throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        if (System.currentTimeMillis() > this.attrExpiration) {
            this.attributes = 17;
            this.createTime = 0;
            this.lastModified = 0;
            this.isExists = false;
            Info info = queryPath(getUncPath0(), MKeyEvent.KEYCODE_LIST);
            this.attributes = info.getAttributes();
            this.createTime = info.getCreateTime();
            this.lastModified = info.getLastWriteTime();
            this.attrExpiration = System.currentTimeMillis() + attrExpirationPeriod;
            this.isExists = true;
        }
        if ((this.attributes & TYPE_FILESYSTEM) != 0) {
            setReadWrite();
        }
        LogStream logStream = log;
        if (LogStream.level >= O_RDWR) {
            log.println("delete: " + fileName);
        }
        if ((this.attributes & TYPE_NAMED_PIPE) != 0) {
            try {
                SmbFile[] l = listFiles("*", 22, null, null);
                for (int i = HASH_DOT_DOT; i < l.length; i += TYPE_FILESYSTEM) {
                    l[i].delete();
                }
            } catch (SmbException se) {
                if (se.getNtStatus() != NtStatus.NT_STATUS_NO_SUCH_FILE) {
                    throw se;
                }
            }
            send(new SmbComDeleteDirectory(fileName), blank_resp());
        } else {
            send(new SmbComDelete(fileName), blank_resp());
        }
        this.sizeExpiration = 0;
        this.attrExpiration = 0;
    }

    public long length() throws SmbException {
        if (this.sizeExpiration > System.currentTimeMillis()) {
            return this.size;
        }
        if (getType() == TYPE_SHARE) {
            Trans2QueryFSInformationResponse response = new Trans2QueryFSInformationResponse(TYPE_FILESYSTEM);
            send(new Trans2QueryFSInformation(TYPE_FILESYSTEM), response);
            this.size = response.info.getCapacity();
        } else if (getUncPath0().length() <= TYPE_FILESYSTEM || this.type == TYPE_NAMED_PIPE) {
            this.size = 0;
        } else {
            this.size = queryPath(getUncPath0(), MKeyEvent.KEYCODE_SUBTITLE).getSize();
        }
        this.sizeExpiration = System.currentTimeMillis() + attrExpirationPeriod;
        return this.size;
    }

    public long getDiskFreeSpace() throws SmbException {
        if (getType() != TYPE_SHARE && this.type != TYPE_FILESYSTEM) {
            return 0;
        }
        try {
            return queryFSInformation(1007);
        } catch (SmbException ex) {
            switch (ex.getNtStatus()) {
                case NtStatus.NT_STATUS_UNSUCCESSFUL /*-1073741823*/:
                case NtStatus.NT_STATUS_INVALID_INFO_CLASS /*-1073741821*/:
                    return queryFSInformation(TYPE_FILESYSTEM);
                default:
                    throw ex;
            }
        }
    }

    private long queryFSInformation(int level) throws SmbException {
        Trans2QueryFSInformationResponse response = new Trans2QueryFSInformationResponse(level);
        send(new Trans2QueryFSInformation(level), response);
        if (this.type == TYPE_SHARE) {
            this.size = response.info.getCapacity();
            this.sizeExpiration = System.currentTimeMillis() + attrExpirationPeriod;
        }
        return response.info.getFree();
    }

    public void mkdir() throws SmbException {
        String path = getUncPath0();
        if (path.length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        LogStream logStream = log;
        if (LogStream.level >= O_RDWR) {
            log.println("mkdir: " + path);
        }
        send(new SmbComCreateDirectory(path), blank_resp());
        this.sizeExpiration = 0;
        this.attrExpiration = 0;
    }

    public void mkdirs() throws SmbException {
        try {
            SmbFile parent = new SmbFile(getParent(), this.auth);
            if (!parent.exists()) {
                parent.mkdirs();
            }
            mkdir();
        } catch (IOException e) {
        }
    }

    public void createNewFile() throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        close(open0(51, HASH_DOT_DOT, ATTR_NORMAL, HASH_DOT_DOT), 0);
    }

    void setPathInformation(int attrs, long ctime, long mtime) throws SmbException {
        exists();
        int dir = this.attributes & TYPE_NAMED_PIPE;
        int f = open0(TYPE_FILESYSTEM, ATTR_TEMPORARY, dir, dir != 0 ? TYPE_FILESYSTEM : TYPE_COMM);
        send(new Trans2SetFileInformation(f, attrs | dir, ctime, mtime), new Trans2SetFileInformationResponse());
        close(f, 0);
        this.attrExpiration = 0;
    }

    public void setCreateTime(long time) throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        setPathInformation(HASH_DOT_DOT, time, 0);
    }

    public void setLastModified(long time) throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        setPathInformation(HASH_DOT_DOT, 0, time);
    }

    public int getAttributes() throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            return HASH_DOT_DOT;
        }
        exists();
        return this.attributes & ATTR_GET_MASK;
    }

    public void setAttributes(int attrs) throws SmbException {
        if (getUncPath0().length() == TYPE_FILESYSTEM) {
            throw new SmbException("Invalid operation for workgroups, servers, or shares");
        }
        setPathInformation(attrs & ATTR_SET_MASK, 0, 0);
    }

    public void setReadOnly() throws SmbException {
        setAttributes(getAttributes() | TYPE_FILESYSTEM);
    }

    public void setReadWrite() throws SmbException {
        setAttributes(getAttributes() & -2);
    }

    public URL toURL() throws MalformedURLException {
        return this.url;
    }

    public int hashCode() {
        int hash;
        try {
            hash = getAddress().hashCode();
        } catch (UnknownHostException e) {
            hash = getServer().toUpperCase().hashCode();
        }
        getUncPath0();
        return this.canon.toUpperCase().hashCode() + hash;
    }

    protected boolean pathNamesPossiblyEqual(String path1, String path2) {
        int p1 = path1.lastIndexOf(47);
        int p2 = path2.lastIndexOf(47);
        int l1 = path1.length() - p1;
        int l2 = path2.length() - p2;
        if (l1 > TYPE_FILESYSTEM && path1.charAt(p1 + TYPE_FILESYSTEM) == '.') {
            return true;
        }
        if (l2 > TYPE_FILESYSTEM && path2.charAt(p2 + TYPE_FILESYSTEM) == '.') {
            return true;
        }
        if (l1 == l2 && path1.regionMatches(true, p1, path2, p2, l1)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SmbFile) {
            SmbFile f = (SmbFile) obj;
            if (this == f) {
                return true;
            }
            if (pathNamesPossiblyEqual(this.url.getPath(), f.url.getPath())) {
                getUncPath0();
                f.getUncPath0();
                if (this.canon.equalsIgnoreCase(f.canon)) {
                    try {
                        return getAddress().equals(f.getAddress());
                    } catch (UnknownHostException e) {
                        return getServer().equalsIgnoreCase(f.getServer());
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return this.url.toString();
    }

    public int getContentLength() {
        try {
            return (int) (length() & 4294967295L);
        } catch (SmbException e) {
            return HASH_DOT_DOT;
        }
    }

    public long getDate() {
        try {
            return lastModified();
        } catch (SmbException e) {
            return 0;
        }
    }

    public long getLastModified() {
        try {
            return lastModified();
        } catch (SmbException e) {
            return 0;
        }
    }

    public InputStream getInputStream() throws IOException {
        return new SmbFileInputStream(this);
    }

    public OutputStream getOutputStream() throws IOException {
        return new SmbFileOutputStream(this);
    }

    private void processAces(ACE[] aces, boolean resolveSids) throws IOException {
        String server = getServerWithDfs();
        int ai;
        if (resolveSids) {
            SID[] sids = new SID[aces.length];
            for (ai = HASH_DOT_DOT; ai < aces.length; ai += TYPE_FILESYSTEM) {
                sids[ai] = aces[ai].sid;
            }
            for (int off = HASH_DOT_DOT; off < sids.length; off += TYPE_COMM) {
                int len = sids.length - off;
                if (len > TYPE_COMM) {
                    len = TYPE_COMM;
                }
                SID.resolveSids(server, this.auth, sids, off, len);
            }
            return;
        }
        for (ai = HASH_DOT_DOT; ai < aces.length; ai += TYPE_FILESYSTEM) {
            aces[ai].sid.origin_server = server;
            aces[ai].sid.origin_auth = this.auth;
        }
    }

    public ACE[] getSecurity(boolean resolveSids) throws IOException {
        int i;
        if (isDirectory()) {
            i = TYPE_FILESYSTEM;
        } else {
            i = HASH_DOT_DOT;
        }
        int f = open0(TYPE_FILESYSTEM, SmbConstants.READ_CONTROL, HASH_DOT_DOT, i);
        NtTransQuerySecurityDesc request = new NtTransQuerySecurityDesc(f, TYPE_SERVER);
        NtTransQuerySecurityDescResponse response = new NtTransQuerySecurityDescResponse();
        try {
            send(request, response);
            ACE[] aces = response.securityDescriptor.aces;
            if (aces != null) {
                processAces(aces, resolveSids);
            }
            return aces;
        } finally {
            close(f, 0);
        }
    }

    public ACE[] getShareSecurity(boolean resolveSids) throws IOException {
        String p = this.url.getPath();
        resolveDfs(null);
        String server = getServerWithDfs();
        MsrpcShareGetInfo rpc = new MsrpcShareGetInfo(server, this.tree.share);
        DcerpcHandle handle = DcerpcHandle.getHandle("ncacn_np:" + server + "[\\PIPE\\srvsvc]", this.auth);
        try {
            handle.sendrecv(rpc);
            if (rpc.retval != 0) {
                throw new SmbException(rpc.retval, true);
            }
            ACE[] aces = rpc.getSecurity();
            if (aces != null) {
                processAces(aces, resolveSids);
            }
            return aces;
        } finally {
            try {
                handle.close();
            } catch (IOException ioe) {
                LogStream logStream = log;
                if (LogStream.level >= TYPE_FILESYSTEM) {
                    ioe.printStackTrace(log);
                }
            }
        }
    }

    public ACE[] getSecurity() throws IOException {
        return getSecurity(false);
    }
}
