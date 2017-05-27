package jcifs;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import jcifs.netbios.NbtAddress;
import jcifs.util.LogStream;

public class UniAddress {
    private static final int RESOLVER_BCAST = 1;
    private static final int RESOLVER_DNS = 2;
    private static final int RESOLVER_LMHOSTS = 3;
    private static final int RESOLVER_WINS = 0;
    private static InetAddress baddr;
    private static LogStream log;
    private static int[] resolveOrder;
    Object addr;
    String calledName;

    static class QueryThread extends Thread {
        NbtAddress ans;
        String host;
        String scope;
        Sem sem;
        InetAddress svr;
        int type;
        UnknownHostException uhe;

        QueryThread(Sem sem, String host, int type, String scope, InetAddress svr) {
            super("JCIFS-QueryThread: " + host);
            this.ans = null;
            this.sem = sem;
            this.host = host;
            this.type = type;
            this.scope = scope;
            this.svr = svr;
        }

        public void run() {
            Sem sem;
            try {
                this.ans = NbtAddress.getByName(this.host, this.type, this.scope, this.svr);
                synchronized (this.sem) {
                    sem = this.sem;
                    sem.count--;
                    this.sem.notify();
                }
            } catch (UnknownHostException uhe) {
                this.uhe = uhe;
                synchronized (this.sem) {
                }
                sem = this.sem;
                sem.count--;
                this.sem.notify();
            } catch (Exception ex) {
                this.uhe = new UnknownHostException(ex.getMessage());
                synchronized (this.sem) {
                }
                sem = this.sem;
                sem.count--;
                this.sem.notify();
            } catch (Throwable th) {
                synchronized (this.sem) {
                }
                Sem sem2 = this.sem;
                sem2.count--;
                this.sem.notify();
            }
        }
    }

    static class Sem {
        int count;

        Sem(int count) {
            this.count = count;
        }
    }

    static {
        log = LogStream.getInstance();
        String ro = Config.getProperty("jcifs.resolveOrder");
        InetAddress nbns = NbtAddress.getWINSAddress();
        try {
            baddr = Config.getInetAddress("jcifs.netbios.baddr", InetAddress.getByName("255.255.255.255"));
        } catch (UnknownHostException e) {
        }
        if (ro != null && ro.length() != 0) {
            int[] tmp = new int[4];
            StringTokenizer st = new StringTokenizer(ro, ",");
            int i = 0;
            while (st.hasMoreTokens()) {
                String s = st.nextToken().trim();
                int i2;
                if (s.equalsIgnoreCase("LMHOSTS")) {
                    i2 = i + RESOLVER_BCAST;
                    tmp[i] = RESOLVER_LMHOSTS;
                    i = i2;
                } else if (s.equalsIgnoreCase("WINS")) {
                    if (nbns == null) {
                        r7 = log;
                        if (LogStream.level > RESOLVER_BCAST) {
                            log.println("UniAddress resolveOrder specifies WINS however the jcifs.netbios.wins property has not been set");
                        }
                    } else {
                        i2 = i + RESOLVER_BCAST;
                        tmp[i] = 0;
                        i = i2;
                    }
                } else if (s.equalsIgnoreCase("BCAST")) {
                    i2 = i + RESOLVER_BCAST;
                    tmp[i] = RESOLVER_BCAST;
                    i = i2;
                } else if (s.equalsIgnoreCase("DNS")) {
                    i2 = i + RESOLVER_BCAST;
                    tmp[i] = RESOLVER_DNS;
                    i = i2;
                } else {
                    r7 = log;
                    if (LogStream.level > RESOLVER_BCAST) {
                        log.println("unknown resolver method: " + s);
                    }
                }
            }
            resolveOrder = new int[i];
            System.arraycopy(tmp, 0, resolveOrder, 0, i);
        } else if (nbns == null) {
            resolveOrder = new int[RESOLVER_LMHOSTS];
            resolveOrder[0] = RESOLVER_LMHOSTS;
            resolveOrder[RESOLVER_BCAST] = RESOLVER_DNS;
            resolveOrder[RESOLVER_DNS] = RESOLVER_BCAST;
        } else {
            resolveOrder = new int[4];
            resolveOrder[0] = RESOLVER_LMHOSTS;
            resolveOrder[RESOLVER_BCAST] = 0;
            resolveOrder[RESOLVER_DNS] = RESOLVER_DNS;
            resolveOrder[RESOLVER_LMHOSTS] = RESOLVER_BCAST;
        }
    }

    static NbtAddress lookupServerOrWorkgroup(String name, InetAddress svr) throws UnknownHostException {
        Sem sem = new Sem(RESOLVER_DNS);
        QueryThread q1x = new QueryThread(sem, name, NbtAddress.isWINS(svr) ? 27 : 29, null, svr);
        QueryThread q20 = new QueryThread(sem, name, 32, null, svr);
        q1x.setDaemon(true);
        q20.setDaemon(true);
        try {
            synchronized (sem) {
                q1x.start();
                q20.start();
                while (sem.count > 0 && q1x.ans == null && q20.ans == null) {
                    sem.wait();
                }
            }
            if (q1x.ans != null) {
                return q1x.ans;
            }
            if (q20.ans != null) {
                return q20.ans;
            }
            throw q1x.uhe;
        } catch (InterruptedException e) {
            throw new UnknownHostException(name);
        }
    }

    public static UniAddress getByName(String hostname) throws UnknownHostException {
        return getByName(hostname, false);
    }

    static boolean isDotQuadIP(String hostname) {
        if (!Character.isDigit(hostname.charAt(0))) {
            return false;
        }
        int dots = 0;
        int i = 0;
        int len = hostname.length();
        char[] data = hostname.toCharArray();
        int i2 = i;
        while (i2 < len) {
            i = i2 + RESOLVER_BCAST;
            if (!Character.isDigit(data[i2])) {
                return false;
            }
            if (i == len && dots == RESOLVER_LMHOSTS) {
                return true;
            }
            if (i >= len || data[i] != '.') {
                i2 = i;
            } else {
                dots += RESOLVER_BCAST;
                i2 = i + RESOLVER_BCAST;
            }
        }
        return false;
    }

    static boolean isAllDigits(String hostname) {
        for (int i = 0; i < hostname.length(); i += RESOLVER_BCAST) {
            if (!Character.isDigit(hostname.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static UniAddress getByName(String hostname, boolean possibleNTDomainOrWorkgroup) throws UnknownHostException {
        return getAllByName(hostname, possibleNTDomainOrWorkgroup)[0];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jcifs.UniAddress[] getAllByName(java.lang.String r9, boolean r10) throws java.net.UnknownHostException {
        /*
        r8 = 15;
        r6 = 1;
        r7 = 0;
        if (r9 == 0) goto L_0x000c;
    L_0x0006:
        r5 = r9.length();
        if (r5 != 0) goto L_0x0012;
    L_0x000c:
        r5 = new java.net.UnknownHostException;
        r5.<init>();
        throw r5;
    L_0x0012:
        r5 = isDotQuadIP(r9);
        if (r5 == 0) goto L_0x0026;
    L_0x0018:
        r1 = new jcifs.UniAddress[r6];
        r5 = new jcifs.UniAddress;
        r6 = jcifs.netbios.NbtAddress.getByName(r9);
        r5.<init>(r6);
        r1[r7] = r5;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = 0;
    L_0x0027:
        r5 = resolveOrder;
        r5 = r5.length;
        if (r2 >= r5) goto L_0x00ac;
    L_0x002c:
        r5 = resolveOrder;	 Catch:{ IOException -> 0x0039 }
        r5 = r5[r2];	 Catch:{ IOException -> 0x0039 }
        switch(r5) {
            case 0: goto L_0x004f;
            case 1: goto L_0x0070;
            case 2: goto L_0x0089;
            case 3: goto L_0x003d;
            default: goto L_0x0033;
        };	 Catch:{ IOException -> 0x0039 }
    L_0x0033:
        r5 = new java.net.UnknownHostException;	 Catch:{ IOException -> 0x0039 }
        r5.<init>(r9);	 Catch:{ IOException -> 0x0039 }
        throw r5;	 Catch:{ IOException -> 0x0039 }
    L_0x0039:
        r5 = move-exception;
    L_0x003a:
        r2 = r2 + 1;
        goto L_0x0027;
    L_0x003d:
        r0 = jcifs.netbios.Lmhosts.getByName(r9);	 Catch:{ IOException -> 0x0039 }
        if (r0 == 0) goto L_0x003a;
    L_0x0043:
        r5 = 1;
        r1 = new jcifs.UniAddress[r5];	 Catch:{ IOException -> 0x0039 }
        r5 = 0;
        r6 = new jcifs.UniAddress;	 Catch:{ IOException -> 0x0039 }
        r6.<init>(r0);	 Catch:{ IOException -> 0x0039 }
        r1[r5] = r6;	 Catch:{ IOException -> 0x0039 }
        goto L_0x0025;
    L_0x004f:
        r5 = "\u0001\u0002__MSBROWSE__\u0002";
        if (r9 == r5) goto L_0x003a;
    L_0x0053:
        r5 = r9.length();	 Catch:{ IOException -> 0x0039 }
        if (r5 > r8) goto L_0x003a;
    L_0x0059:
        if (r10 == 0) goto L_0x0064;
    L_0x005b:
        r5 = jcifs.netbios.NbtAddress.getWINSAddress();	 Catch:{ IOException -> 0x0039 }
        r0 = lookupServerOrWorkgroup(r9, r5);	 Catch:{ IOException -> 0x0039 }
        goto L_0x0043;
    L_0x0064:
        r5 = 32;
        r6 = 0;
        r7 = jcifs.netbios.NbtAddress.getWINSAddress();	 Catch:{ IOException -> 0x0039 }
        r0 = jcifs.netbios.NbtAddress.getByName(r9, r5, r6, r7);	 Catch:{ IOException -> 0x0039 }
        goto L_0x0043;
    L_0x0070:
        r5 = r9.length();	 Catch:{ IOException -> 0x0039 }
        if (r5 > r8) goto L_0x003a;
    L_0x0076:
        if (r10 == 0) goto L_0x007f;
    L_0x0078:
        r5 = baddr;	 Catch:{ IOException -> 0x0039 }
        r0 = lookupServerOrWorkgroup(r9, r5);	 Catch:{ IOException -> 0x0039 }
        goto L_0x0043;
    L_0x007f:
        r5 = 32;
        r6 = 0;
        r7 = baddr;	 Catch:{ IOException -> 0x0039 }
        r0 = jcifs.netbios.NbtAddress.getByName(r9, r5, r6, r7);	 Catch:{ IOException -> 0x0039 }
        goto L_0x0043;
    L_0x0089:
        r5 = isAllDigits(r9);	 Catch:{ IOException -> 0x0039 }
        if (r5 == 0) goto L_0x0095;
    L_0x008f:
        r5 = new java.net.UnknownHostException;	 Catch:{ IOException -> 0x0039 }
        r5.<init>(r9);	 Catch:{ IOException -> 0x0039 }
        throw r5;	 Catch:{ IOException -> 0x0039 }
    L_0x0095:
        r3 = java.net.InetAddress.getAllByName(r9);	 Catch:{ IOException -> 0x0039 }
        r5 = r3.length;	 Catch:{ IOException -> 0x0039 }
        r1 = new jcifs.UniAddress[r5];	 Catch:{ IOException -> 0x0039 }
        r4 = 0;
    L_0x009d:
        r5 = r3.length;	 Catch:{ IOException -> 0x0039 }
        if (r4 >= r5) goto L_0x0025;
    L_0x00a0:
        r5 = new jcifs.UniAddress;	 Catch:{ IOException -> 0x0039 }
        r6 = r3[r4];	 Catch:{ IOException -> 0x0039 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x0039 }
        r1[r4] = r5;	 Catch:{ IOException -> 0x0039 }
        r4 = r4 + 1;
        goto L_0x009d;
    L_0x00ac:
        r5 = new java.net.UnknownHostException;
        r5.<init>(r9);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.UniAddress.getAllByName(java.lang.String, boolean):jcifs.UniAddress[]");
    }

    public UniAddress(Object addr) {
        if (addr == null) {
            throw new IllegalArgumentException();
        }
        this.addr = addr;
    }

    public int hashCode() {
        return this.addr.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof UniAddress) && this.addr.equals(((UniAddress) obj).addr);
    }

    public String firstCalledName() {
        if (this.addr instanceof NbtAddress) {
            return ((NbtAddress) this.addr).firstCalledName();
        }
        this.calledName = ((InetAddress) this.addr).getHostName();
        if (isDotQuadIP(this.calledName)) {
            this.calledName = NbtAddress.SMBSERVER_NAME;
        } else {
            int i = this.calledName.indexOf(46);
            if (i > RESOLVER_BCAST && i < 15) {
                this.calledName = this.calledName.substring(0, i).toUpperCase();
            } else if (this.calledName.length() > 15) {
                this.calledName = NbtAddress.SMBSERVER_NAME;
            } else {
                this.calledName = this.calledName.toUpperCase();
            }
        }
        return this.calledName;
    }

    public String nextCalledName() {
        if (this.addr instanceof NbtAddress) {
            return ((NbtAddress) this.addr).nextCalledName();
        }
        if (this.calledName == NbtAddress.SMBSERVER_NAME) {
            return null;
        }
        this.calledName = NbtAddress.SMBSERVER_NAME;
        return this.calledName;
    }

    public Object getAddress() {
        return this.addr;
    }

    public String getHostName() {
        if (this.addr instanceof NbtAddress) {
            return ((NbtAddress) this.addr).getHostName();
        }
        return ((InetAddress) this.addr).getHostName();
    }

    public String getHostAddress() {
        if (this.addr instanceof NbtAddress) {
            return ((NbtAddress) this.addr).getHostAddress();
        }
        return ((InetAddress) this.addr).getHostAddress();
    }

    public String toString() {
        return this.addr.toString();
    }
}
