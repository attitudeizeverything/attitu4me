package jcifs.smb;

import com.mstar.android.MKeyEvent;
import com.mstar.android.camera.MCamera.Parameters;
import jcifs.util.LogStream;

class SmbTree {
    private static int tree_conn_counter;
    int connectionState;
    boolean inDfs;
    boolean inDomainDfs;
    String service;
    String service0;
    SmbSession session;
    String share;
    int tid;
    int tree_num;

    SmbTree(SmbSession session, String share, String service) {
        this.service = "?????";
        this.session = session;
        this.share = share.toUpperCase();
        if (!(service == null || service.startsWith("??"))) {
            this.service = service;
        }
        this.service0 = this.service;
        this.connectionState = 0;
    }

    boolean matches(String share, String service) {
        return this.share.equalsIgnoreCase(share) && (service == null || service.startsWith("??") || this.service.equalsIgnoreCase(service));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SmbTree)) {
            return false;
        }
        SmbTree tree = (SmbTree) obj;
        return matches(tree.share, tree.service);
    }

    void send(ServerMessageBlock request, ServerMessageBlock response) throws SmbException {
        synchronized (this.session.transport()) {
            if (response != null) {
                response.received = false;
            }
            treeConnect(request, response);
            if (request == null || (response != null && response.received)) {
                return;
            }
            if (!this.service.equals("A:")) {
                switch (request.command) {
                    case Parameters.MAPI_INPUT_SOURCE_DTV2 /*37*/:
                    case (byte) 50:
                        switch (((SmbComTransaction) request).subCommand & MKeyEvent.KEYCODE_SLEEP) {
                            case SID.SID_TYPE_USE_NONE /*0*/:
                            case SmbFile.TYPE_NAMED_PIPE /*16*/:
                            case Parameters.MAPI_INPUT_SOURCE_KTV /*35*/:
                            case Parameters.MAPI_INPUT_SOURCE_STORAGE2 /*38*/:
                            case 83:
                            case 84:
                            case 104:
                            case 215:
                                break;
                            default:
                                throw new SmbException("Invalid operation for " + this.service + " service");
                        }
                    case (byte) -94:
                    case SID.SID_TYPE_ALIAS /*4*/:
                    case (byte) 45:
                    case (byte) 46:
                    case (byte) 47:
                    case (byte) 113:
                        request.tid = this.tid;
                        if (this.inDfs && !this.service.equals("IPC") && request.path != null && request.path.length() > 0) {
                            request.flags2 = SmbConstants.FLAGS2_RESOLVE_PATHS_IN_DFS;
                            request.path = '\\' + this.session.transport().tconHostName + '\\' + this.share + request.path;
                        }
                        this.session.send(request, response);
                    default:
                        throw new SmbException("Invalid operation for " + this.service + " service" + request);
                }
            }
            request.tid = this.tid;
            request.flags2 = SmbConstants.FLAGS2_RESOLVE_PATHS_IN_DFS;
            request.path = '\\' + this.session.transport().tconHostName + '\\' + this.share + request.path;
            try {
                this.session.send(request, response);
            } catch (SmbException se) {
                if (se.getNtStatus() == NtStatus.NT_STATUS_NETWORK_NAME_DELETED) {
                    treeDisconnect(true);
                }
                throw se;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void treeConnect(jcifs.smb.ServerMessageBlock r10, jcifs.smb.ServerMessageBlock r11) throws jcifs.smb.SmbException {
        /*
        r9 = this;
        r8 = 2;
        r5 = r9.session;
        r6 = r5.transport();
        monitor-enter(r6);
    L_0x0008:
        r5 = r9.connectionState;	 Catch:{ all -> 0x002a }
        if (r5 == 0) goto L_0x002d;
    L_0x000c:
        r5 = r9.connectionState;	 Catch:{ all -> 0x002a }
        if (r5 == r8) goto L_0x0015;
    L_0x0010:
        r5 = r9.connectionState;	 Catch:{ all -> 0x002a }
        r7 = 3;
        if (r5 != r7) goto L_0x0017;
    L_0x0015:
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
    L_0x0016:
        return;
    L_0x0017:
        r5 = r9.session;	 Catch:{ InterruptedException -> 0x001f }
        r5 = r5.transport;	 Catch:{ InterruptedException -> 0x001f }
        r5.wait();	 Catch:{ InterruptedException -> 0x001f }
        goto L_0x0008;
    L_0x001f:
        r0 = move-exception;
        r5 = new jcifs.smb.SmbException;	 Catch:{ all -> 0x002a }
        r7 = r0.getMessage();	 Catch:{ all -> 0x002a }
        r5.<init>(r7, r0);	 Catch:{ all -> 0x002a }
        throw r5;	 Catch:{ all -> 0x002a }
    L_0x002a:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
        throw r5;
    L_0x002d:
        r5 = 1;
        r9.connectionState = r5;	 Catch:{ all -> 0x002a }
        r5 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r5.transport;	 Catch:{ SmbException -> 0x00c0 }
        r5.connect();	 Catch:{ SmbException -> 0x00c0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SmbException -> 0x00c0 }
        r5.<init>();	 Catch:{ SmbException -> 0x00c0 }
        r7 = "\\\\";
        r5 = r5.append(r7);	 Catch:{ SmbException -> 0x00c0 }
        r7 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r7 = r7.transport;	 Catch:{ SmbException -> 0x00c0 }
        r7 = r7.tconHostName;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r5.append(r7);	 Catch:{ SmbException -> 0x00c0 }
        r7 = 92;
        r5 = r5.append(r7);	 Catch:{ SmbException -> 0x00c0 }
        r7 = r9.share;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r5.append(r7);	 Catch:{ SmbException -> 0x00c0 }
        r4 = r5.toString();	 Catch:{ SmbException -> 0x00c0 }
        r5 = r9.service0;	 Catch:{ SmbException -> 0x00c0 }
        r9.service = r5;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r5.transport;	 Catch:{ SmbException -> 0x00c0 }
        r5 = jcifs.smb.SmbTransport.log;	 Catch:{ SmbException -> 0x00c0 }
        r5 = jcifs.util.LogStream.level;	 Catch:{ SmbException -> 0x00c0 }
        r7 = 4;
        if (r5 < r7) goto L_0x0093;
    L_0x006b:
        r5 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r5.transport;	 Catch:{ SmbException -> 0x00c0 }
        r5 = jcifs.smb.SmbTransport.log;	 Catch:{ SmbException -> 0x00c0 }
        r7 = new java.lang.StringBuilder;	 Catch:{ SmbException -> 0x00c0 }
        r7.<init>();	 Catch:{ SmbException -> 0x00c0 }
        r8 = "treeConnect: unc=";
        r7 = r7.append(r8);	 Catch:{ SmbException -> 0x00c0 }
        r7 = r7.append(r4);	 Catch:{ SmbException -> 0x00c0 }
        r8 = ",service=";
        r7 = r7.append(r8);	 Catch:{ SmbException -> 0x00c0 }
        r8 = r9.service;	 Catch:{ SmbException -> 0x00c0 }
        r7 = r7.append(r8);	 Catch:{ SmbException -> 0x00c0 }
        r7 = r7.toString();	 Catch:{ SmbException -> 0x00c0 }
        r5.println(r7);	 Catch:{ SmbException -> 0x00c0 }
    L_0x0093:
        r2 = new jcifs.smb.SmbComTreeConnectAndXResponse;	 Catch:{ SmbException -> 0x00c0 }
        r2.<init>(r11);	 Catch:{ SmbException -> 0x00c0 }
        r1 = new jcifs.smb.SmbComTreeConnectAndX;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r7 = r9.service;	 Catch:{ SmbException -> 0x00c0 }
        r1.<init>(r5, r4, r7, r10);	 Catch:{ SmbException -> 0x00c0 }
        r5 = r9.session;	 Catch:{ SmbException -> 0x00c0 }
        r5.send(r1, r2);	 Catch:{ SmbException -> 0x00c0 }
        r5 = r2.tid;	 Catch:{ SmbException -> 0x00c0 }
        r9.tid = r5;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r2.service;	 Catch:{ SmbException -> 0x00c0 }
        r9.service = r5;	 Catch:{ SmbException -> 0x00c0 }
        r5 = r2.shareIsInDfs;	 Catch:{ SmbException -> 0x00c0 }
        r9.inDfs = r5;	 Catch:{ SmbException -> 0x00c0 }
        r5 = tree_conn_counter;	 Catch:{ SmbException -> 0x00c0 }
        r7 = r5 + 1;
        tree_conn_counter = r7;	 Catch:{ SmbException -> 0x00c0 }
        r9.tree_num = r5;	 Catch:{ SmbException -> 0x00c0 }
        r5 = 2;
        r9.connectionState = r5;	 Catch:{ SmbException -> 0x00c0 }
        monitor-exit(r6);	 Catch:{ all -> 0x002a }
        goto L_0x0016;
    L_0x00c0:
        r3 = move-exception;
        r5 = 1;
        r9.treeDisconnect(r5);	 Catch:{ all -> 0x002a }
        r5 = 0;
        r9.connectionState = r5;	 Catch:{ all -> 0x002a }
        throw r3;	 Catch:{ all -> 0x002a }
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.SmbTree.treeConnect(jcifs.smb.ServerMessageBlock, jcifs.smb.ServerMessageBlock):void");
    }

    void treeDisconnect(boolean inError) {
        synchronized (this.session.transport()) {
            if (this.connectionState != 2) {
                return;
            }
            this.connectionState = 3;
            if (!(inError || this.tid == 0)) {
                try {
                    send(new SmbComTreeDisconnect(), null);
                } catch (SmbException se) {
                    r1 = this.session.transport;
                    LogStream logStream = SmbTransport.log;
                    if (LogStream.level > 1) {
                        SmbTransport smbTransport;
                        smbTransport = this.session.transport;
                        se.printStackTrace(SmbTransport.log);
                    }
                }
            }
            this.inDfs = false;
            this.inDomainDfs = false;
            this.connectionState = 0;
            this.session.transport.notifyAll();
        }
    }

    public String toString() {
        return "SmbTree[share=" + this.share + ",service=" + this.service + ",tid=" + this.tid + ",inDfs=" + this.inDfs + ",inDomainDfs=" + this.inDomainDfs + ",connectionState=" + this.connectionState + "]";
    }
}
