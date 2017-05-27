package jcifs.smb;

import android.support.v4.widget.ExploreByTouchHelper;
import com.mstar.android.widi.WidiMonitor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Vector;
import jcifs.Config;
import jcifs.UniAddress;
import jcifs.netbios.NbtAddress;
import jcifs.util.LogStream;

public final class SmbSession {
    private static final int CACHE_POLICY;
    private static final String DOMAIN;
    private static final String LOGON_SHARE;
    private static final int LOOKUP_RESP_LIMIT;
    private static final String USERNAME;
    static NbtAddress[] dc_list;
    static int dc_list_counter;
    static long dc_list_expiration;
    private UniAddress address;
    NtlmPasswordAuthentication auth;
    int connectionState;
    long expiration;
    private InetAddress localAddr;
    private int localPort;
    String netbiosName;
    private int port;
    SmbTransport transport;
    Vector trees;
    int uid;

    static {
        LOGON_SHARE = Config.getProperty("jcifs.smb.client.logonShare", null);
        LOOKUP_RESP_LIMIT = Config.getInt("jcifs.netbios.lookupRespLimit", 3);
        DOMAIN = Config.getProperty("jcifs.smb.client.domain", null);
        USERNAME = Config.getProperty("jcifs.smb.client.username", null);
        CACHE_POLICY = Config.getInt("jcifs.netbios.cachePolicy", 600) * 60;
        dc_list = null;
    }

    private static NtlmChallenge interrogate(NbtAddress addr) throws SmbException {
        UniAddress dc = new UniAddress(addr);
        SmbTransport trans = SmbTransport.getSmbTransport(dc, 0);
        if (USERNAME == null) {
            trans.connect();
            LogStream logStream = SmbTransport.log;
            if (LogStream.level >= 3) {
                SmbTransport.log.println("Default credentials (jcifs.smb.client.username/password) not specified. SMB signing may not work propertly.  Skipping DC interrogation.");
            }
        } else {
            trans.getSmbSession(NtlmPasswordAuthentication.DEFAULT).getSmbTree(LOGON_SHARE, null).treeConnect(null, null);
        }
        return new NtlmChallenge(trans.server.encryptionKey, dc);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jcifs.smb.NtlmChallenge getChallengeForDomain() throws jcifs.smb.SmbException, java.net.UnknownHostException {
        /*
        r9 = DOMAIN;
        if (r9 != 0) goto L_0x000c;
    L_0x0004:
        r9 = new jcifs.smb.SmbException;
        r10 = "A domain was not specified";
        r9.<init>(r10);
        throw r9;
    L_0x000c:
        r10 = DOMAIN;
        monitor-enter(r10);
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x006e }
        r6 = 1;
        r7 = r6;
    L_0x0015:
        r12 = dc_list_expiration;	 Catch:{ all -> 0x006e }
        r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r9 >= 0) goto L_0x0035;
    L_0x001b:
        r9 = DOMAIN;	 Catch:{ all -> 0x006e }
        r11 = 28;
        r12 = 0;
        r13 = 0;
        r2 = jcifs.netbios.NbtAddress.getAllByName(r9, r11, r12, r13);	 Catch:{ all -> 0x006e }
        r9 = CACHE_POLICY;	 Catch:{ all -> 0x006e }
        r12 = (long) r9;	 Catch:{ all -> 0x006e }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 * r14;
        r12 = r12 + r4;
        dc_list_expiration = r12;	 Catch:{ all -> 0x006e }
        if (r2 == 0) goto L_0x0059;
    L_0x0030:
        r9 = r2.length;	 Catch:{ all -> 0x006e }
        if (r9 <= 0) goto L_0x0059;
    L_0x0033:
        dc_list = r2;	 Catch:{ all -> 0x006e }
    L_0x0035:
        r9 = dc_list;	 Catch:{ all -> 0x006e }
        r9 = r9.length;	 Catch:{ all -> 0x006e }
        r11 = LOOKUP_RESP_LIMIT;	 Catch:{ all -> 0x006e }
        r3 = java.lang.Math.min(r9, r11);	 Catch:{ all -> 0x006e }
        r1 = 0;
    L_0x003f:
        if (r1 >= r3) goto L_0x00a9;
    L_0x0041:
        r9 = dc_list_counter;	 Catch:{ all -> 0x006e }
        r11 = r9 + 1;
        dc_list_counter = r11;	 Catch:{ all -> 0x006e }
        r0 = r9 % r3;
        r9 = dc_list;	 Catch:{ all -> 0x006e }
        r9 = r9[r0];	 Catch:{ all -> 0x006e }
        if (r9 == 0) goto L_0x00a6;
    L_0x004f:
        r9 = dc_list;	 Catch:{ SmbException -> 0x0071 }
        r9 = r9[r0];	 Catch:{ SmbException -> 0x0071 }
        r9 = interrogate(r9);	 Catch:{ SmbException -> 0x0071 }
        monitor-exit(r10);	 Catch:{ all -> 0x006e }
        return r9;
    L_0x0059:
        r12 = 900000; // 0xdbba0 float:1.261169E-39 double:4.44659E-318;
        r12 = r12 + r4;
        dc_list_expiration = r12;	 Catch:{ all -> 0x006e }
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r9 = jcifs.util.LogStream.level;	 Catch:{ all -> 0x006e }
        r11 = 2;
        if (r9 < r11) goto L_0x0035;
    L_0x0066:
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r11 = "Failed to retrieve DC list from WINS";
        r9.println(r11);	 Catch:{ all -> 0x006e }
        goto L_0x0035;
    L_0x006e:
        r9 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x006e }
        throw r9;
    L_0x0071:
        r8 = move-exception;
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r9 = jcifs.util.LogStream.level;	 Catch:{ all -> 0x006e }
        r11 = 2;
        if (r9 < r11) goto L_0x00a1;
    L_0x0079:
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006e }
        r11.<init>();	 Catch:{ all -> 0x006e }
        r12 = "Failed validate DC: ";
        r11 = r11.append(r12);	 Catch:{ all -> 0x006e }
        r12 = dc_list;	 Catch:{ all -> 0x006e }
        r12 = r12[r0];	 Catch:{ all -> 0x006e }
        r11 = r11.append(r12);	 Catch:{ all -> 0x006e }
        r11 = r11.toString();	 Catch:{ all -> 0x006e }
        r9.println(r11);	 Catch:{ all -> 0x006e }
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r9 = jcifs.util.LogStream.level;	 Catch:{ all -> 0x006e }
        r11 = 2;
        if (r9 <= r11) goto L_0x00a1;
    L_0x009c:
        r9 = jcifs.smb.SmbTransport.log;	 Catch:{ all -> 0x006e }
        r8.printStackTrace(r9);	 Catch:{ all -> 0x006e }
    L_0x00a1:
        r9 = dc_list;	 Catch:{ all -> 0x006e }
        r11 = 0;
        r9[r0] = r11;	 Catch:{ all -> 0x006e }
    L_0x00a6:
        r1 = r1 + 1;
        goto L_0x003f;
    L_0x00a9:
        r12 = 0;
        dc_list_expiration = r12;	 Catch:{ all -> 0x006e }
        r6 = r7 + -1;
        if (r7 > 0) goto L_0x00d3;
    L_0x00b1:
        r12 = 900000; // 0xdbba0 float:1.261169E-39 double:4.44659E-318;
        r12 = r12 + r4;
        dc_list_expiration = r12;	 Catch:{ all -> 0x006e }
        monitor-exit(r10);	 Catch:{ all -> 0x006e }
        r9 = new java.net.UnknownHostException;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Failed to negotiate with a suitable domain controller for ";
        r10 = r10.append(r11);
        r11 = DOMAIN;
        r10 = r10.append(r11);
        r10 = r10.toString();
        r9.<init>(r10);
        throw r9;
    L_0x00d3:
        r7 = r6;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.SmbSession.getChallengeForDomain():jcifs.smb.NtlmChallenge");
    }

    public static byte[] getChallenge(UniAddress dc) throws SmbException, UnknownHostException {
        return getChallenge(dc, 0);
    }

    public static byte[] getChallenge(UniAddress dc, int port) throws SmbException, UnknownHostException {
        SmbTransport trans = SmbTransport.getSmbTransport(dc, port);
        trans.connect();
        return trans.server.encryptionKey;
    }

    public static void logon(UniAddress dc, NtlmPasswordAuthentication auth) throws SmbException {
        logon(dc, 0, auth);
    }

    public static void logon(UniAddress dc, int port, NtlmPasswordAuthentication auth) throws SmbException {
        SmbTree tree = SmbTransport.getSmbTransport(dc, port).getSmbSession(auth).getSmbTree(LOGON_SHARE, null);
        if (LOGON_SHARE == null) {
            tree.treeConnect(null, null);
        } else {
            tree.send(new Trans2FindFirst2("\\", "*", 16), new Trans2FindFirst2Response());
        }
    }

    SmbSession(UniAddress address, int port, InetAddress localAddr, int localPort, NtlmPasswordAuthentication auth) {
        this.transport = null;
        this.netbiosName = null;
        this.address = address;
        this.port = port;
        this.localAddr = localAddr;
        this.localPort = localPort;
        this.auth = auth;
        this.trees = new Vector();
        this.connectionState = 0;
    }

    synchronized SmbTree getSmbTree(String share, String service) {
        Object t;
        SmbTree t2;
        if (share == null) {
            share = "IPC$";
        }
        Enumeration e = this.trees.elements();
        while (e.hasMoreElements()) {
            t2 = (SmbTree) e.nextElement();
            if (t2.matches(share, service)) {
                t = t2;
                break;
            }
        }
        t2 = new SmbTree(this, share, service);
        this.trees.addElement(t2);
        SmbTree t3 = t2;
        return t;
    }

    boolean matches(NtlmPasswordAuthentication auth) {
        return this.auth == auth || this.auth.equals(auth);
    }

    synchronized SmbTransport transport() {
        if (this.transport == null) {
            this.transport = SmbTransport.getSmbTransport(this.address, this.port, this.localAddr, this.localPort, null);
        }
        return this.transport;
    }

    void send(ServerMessageBlock request, ServerMessageBlock response) throws SmbException {
        synchronized (transport()) {
            if (response != null) {
                response.received = false;
            }
            this.expiration = System.currentTimeMillis() + ((long) SmbTransport.SO_TIMEOUT);
            sessionSetup(request, response);
            if (response == null || !response.received) {
                if (request instanceof SmbComTreeConnectAndX) {
                    SmbComTreeConnectAndX tcax = (SmbComTreeConnectAndX) request;
                    if (this.netbiosName != null && tcax.path.endsWith("\\IPC$")) {
                        tcax.path = "\\\\" + this.netbiosName + "\\IPC$";
                    }
                }
                request.uid = this.uid;
                request.auth = this.auth;
                try {
                    this.transport.send(request, response);
                    return;
                } catch (SmbException se) {
                    if (request instanceof SmbComTreeConnectAndX) {
                        logoff(true);
                    }
                    request.digest = null;
                    throw se;
                }
            }
        }
    }

    void sessionSetup(ServerMessageBlock andx, ServerMessageBlock andxResponse) throws SmbException {
        synchronized (transport()) {
            NtlmContext nctx = null;
            SmbException ex = null;
            byte[] token = new byte[0];
            int state = 10;
            while (this.connectionState != 0) {
                if (this.connectionState == 2 || this.connectionState == 3) {
                    return;
                }
                try {
                    this.transport.wait();
                } catch (Throwable ie) {
                    throw new SmbException(ie.getMessage(), ie);
                }
            }
            this.connectionState = 1;
            this.transport.connect();
            SmbTransport smbTransport = this.transport;
            LogStream logStream = SmbTransport.log;
            if (LogStream.level >= 4) {
                smbTransport = this.transport;
                SmbTransport.log.println("sessionSetup: accountName=" + this.auth.username + ",primaryDomain=" + this.auth.domain);
            }
            this.uid = 0;
            do {
                SmbException se;
                NtlmContext nctx2 = nctx;
                SmbComSessionSetupAndX request;
                SmbComSessionSetupAndXResponse response;
                switch (state) {
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        if (this.auth == NtlmPasswordAuthentication.ANONYMOUS || !this.transport.hasCapability(ExploreByTouchHelper.INVALID_ID)) {
                            try {
                                request = new SmbComSessionSetupAndX(this, andx, this.auth);
                                response = new SmbComSessionSetupAndXResponse(andxResponse);
                                if (this.transport.isSignatureSetupRequired(this.auth)) {
                                    if (!this.auth.hashesExternal || NtlmPasswordAuthentication.DEFAULT_PASSWORD == "") {
                                        request.digest = new SigningDigest(this.auth.getSigningKey(this.transport.server.encryptionKey), false);
                                    } else {
                                        this.transport.getSmbSession(NtlmPasswordAuthentication.DEFAULT).getSmbTree(LOGON_SHARE, null).treeConnect(null, null);
                                    }
                                }
                                request.auth = this.auth;
                                this.transport.send(request, response);
                            } catch (SmbAuthException sae) {
                                throw sae;
                            } catch (SmbException se2) {
                                ex = se2;
                            } catch (SmbException e) {
                                se2 = e;
                                nctx = nctx2;
                                break;
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                nctx = nctx2;
                                break;
                            }
                            if (response.isLoggedInAsGuest) {
                                if (!("GUEST".equalsIgnoreCase(this.auth.username) || this.transport.server.security == 0 || this.auth == NtlmPasswordAuthentication.ANONYMOUS)) {
                                    throw new SmbAuthException(NtStatus.NT_STATUS_LOGON_FAILURE);
                                }
                            }
                            if (ex != null) {
                                throw ex;
                            }
                            this.uid = response.uid;
                            if (request.digest != null) {
                                this.transport.digest = request.digest;
                            }
                            this.connectionState = 2;
                            state = 0;
                            nctx = nctx2;
                            continue;
                        } else {
                            state = 20;
                            nctx = nctx2;
                            continue;
                        }
                    case WidiMonitor.WIDI_BINDED_FAIL_EVENT /*20*/:
                        if (nctx2 == null) {
                            nctx = new NtlmContext(this.auth, (this.transport.flags2 & 4) != 0);
                        } else {
                            nctx = nctx2;
                        }
                        logStream = SmbTransport.log;
                        if (LogStream.level >= 4) {
                            SmbTransport.log.println(nctx);
                        }
                        if (!nctx.isEstablished()) {
                            try {
                                token = nctx.initSecContext(token, 0, token.length);
                                if (token != null) {
                                    request = new SmbComSessionSetupAndX(this, null, token);
                                    response = new SmbComSessionSetupAndXResponse(null);
                                    if (this.transport.isSignatureSetupRequired(this.auth)) {
                                        byte[] signingKey = nctx.getSigningKey();
                                        if (signingKey != null) {
                                            request.digest = new SigningDigest(signingKey, true);
                                        }
                                    }
                                    request.uid = this.uid;
                                    this.uid = 0;
                                    this.transport.send(request, response);
                                    if (response.isLoggedInAsGuest) {
                                        if (!"GUEST".equalsIgnoreCase(this.auth.username)) {
                                            throw new SmbAuthException(NtStatus.NT_STATUS_LOGON_FAILURE);
                                        }
                                    }
                                    if (ex != null) {
                                        throw ex;
                                    }
                                    this.uid = response.uid;
                                    if (request.digest != null) {
                                        this.transport.digest = request.digest;
                                    }
                                    token = response.blob;
                                    continue;
                                } else {
                                    continue;
                                }
                            } catch (SmbAuthException sae2) {
                                throw sae2;
                            } catch (SmbException se22) {
                                ex = se22;
                                try {
                                    this.transport.disconnect(true);
                                } catch (Exception e2) {
                                }
                            } catch (SmbException se222) {
                                try {
                                    this.transport.disconnect(true);
                                } catch (IOException e3) {
                                }
                                this.uid = 0;
                                throw se222;
                            } catch (SmbException e4) {
                                se222 = e4;
                                break;
                            }
                        }
                        this.netbiosName = nctx.getNetbiosName();
                        this.connectionState = 2;
                        state = 0;
                        continue;
                    default:
                        throw new SmbException("Unexpected session setup state: " + state);
                }
                try {
                    logoff(true);
                    this.connectionState = 0;
                    throw se222;
                } catch (Throwable th3) {
                    th2 = th3;
                    this.transport.notifyAll();
                    throw th2;
                }
            } while (state != 0);
            this.transport.notifyAll();
        }
    }

    void logoff(boolean inError) {
        synchronized (transport()) {
            if (this.connectionState != 2) {
                return;
            }
            this.connectionState = 3;
            this.netbiosName = null;
            Enumeration e = this.trees.elements();
            while (e.hasMoreElements()) {
                ((SmbTree) e.nextElement()).treeDisconnect(inError);
            }
            if (!inError) {
                if (this.transport.server.security != 0) {
                    SmbComLogoffAndX request = new SmbComLogoffAndX(null);
                    request.uid = this.uid;
                    try {
                        this.transport.send(request, null);
                    } catch (SmbException e2) {
                    }
                    this.uid = 0;
                }
            }
            this.connectionState = 0;
            this.transport.notifyAll();
        }
    }

    public String toString() {
        return "SmbSession[accountName=" + this.auth.username + ",primaryDomain=" + this.auth.domain + ",uid=" + this.uid + ",connectionState=" + this.connectionState + "]";
    }
}
