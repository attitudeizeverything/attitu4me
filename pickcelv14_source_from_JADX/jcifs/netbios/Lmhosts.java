package jcifs.netbios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import jcifs.Config;
import jcifs.util.LogStream;

public class Lmhosts {
    private static final String FILENAME;
    private static final Hashtable TAB;
    private static int alt;
    private static long lastModified;
    private static LogStream log;

    static {
        FILENAME = Config.getProperty("jcifs.netbios.lmhosts");
        TAB = new Hashtable();
        lastModified = 1;
        log = LogStream.getInstance();
    }

    public static synchronized NbtAddress getByName(String host) {
        NbtAddress byName;
        synchronized (Lmhosts.class) {
            byName = getByName(new Name(host, 32, null));
        }
        return byName;
    }

    static synchronized NbtAddress getByName(Name name) {
        NbtAddress result;
        LogStream logStream;
        synchronized (Lmhosts.class) {
            result = null;
            try {
                if (FILENAME != null) {
                    File f = new File(FILENAME);
                    long lm = f.lastModified();
                    if (lm > lastModified) {
                        lastModified = lm;
                        TAB.clear();
                        alt = 0;
                        populate(new FileReader(f));
                    }
                    result = (NbtAddress) TAB.get(name);
                }
            } catch (FileNotFoundException fnfe) {
                logStream = log;
                if (LogStream.level > 1) {
                    log.println("lmhosts file: " + FILENAME);
                    fnfe.printStackTrace(log);
                }
            } catch (IOException ioe) {
                logStream = log;
                if (LogStream.level > 0) {
                    ioe.printStackTrace(log);
                }
            }
        }
        return result;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void populate(java.io.Reader r22) throws java.io.IOException {
        /*
        r14 = new java.io.BufferedReader;
        r0 = r22;
        r14.<init>(r0);
    L_0x0007:
        r20 = r14.readLine();
        if (r20 == 0) goto L_0x0180;
    L_0x000d:
        r6 = r20.toUpperCase();
        r20 = r6.trim();
        r6 = r20.length();
        if (r6 == 0) goto L_0x0007;
    L_0x001b:
        r6 = 0;
        r0 = r20;
        r6 = r0.charAt(r6);
        r7 = 35;
        if (r6 != r7) goto L_0x00f1;
    L_0x0026:
        r6 = "#INCLUDE ";
        r0 = r20;
        r6 = r0.startsWith(r6);
        if (r6 == 0) goto L_0x00c3;
    L_0x0030:
        r6 = 92;
        r0 = r20;
        r6 = r0.indexOf(r6);
        r0 = r20;
        r20 = r0.substring(r6);
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "smb:";
        r6 = r6.append(r7);
        r7 = 92;
        r8 = 47;
        r0 = r20;
        r7 = r0.replace(r7, r8);
        r6 = r6.append(r7);
        r21 = r6.toString();
        r6 = alt;
        if (r6 <= 0) goto L_0x00b2;
    L_0x005f:
        r6 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x008e }
        r7 = new jcifs.smb.SmbFileInputStream;	 Catch:{ IOException -> 0x008e }
        r0 = r21;
        r7.<init>(r0);	 Catch:{ IOException -> 0x008e }
        r6.<init>(r7);	 Catch:{ IOException -> 0x008e }
        populate(r6);	 Catch:{ IOException -> 0x008e }
        r6 = alt;
        r6 = r6 + -1;
        alt = r6;
    L_0x0074:
        r20 = r14.readLine();
        if (r20 == 0) goto L_0x0007;
    L_0x007a:
        r6 = r20.toUpperCase();
        r20 = r6.trim();
        r6 = "#END_ALTERNATE";
        r0 = r20;
        r6 = r0.startsWith(r6);
        if (r6 == 0) goto L_0x0074;
    L_0x008c:
        goto L_0x0007;
    L_0x008e:
        r18 = move-exception;
        r6 = log;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "lmhosts URL: ";
        r7 = r7.append(r8);
        r0 = r21;
        r7 = r7.append(r0);
        r7 = r7.toString();
        r6.println(r7);
        r6 = log;
        r0 = r18;
        r0.printStackTrace(r6);
        goto L_0x0007;
    L_0x00b2:
        r6 = new java.io.InputStreamReader;
        r7 = new jcifs.smb.SmbFileInputStream;
        r0 = r21;
        r7.<init>(r0);
        r6.<init>(r7);
        populate(r6);
        goto L_0x0007;
    L_0x00c3:
        r6 = "#BEGIN_ALTERNATE";
        r0 = r20;
        r6 = r0.startsWith(r6);
        if (r6 == 0) goto L_0x00d5;
    L_0x00cd:
        r6 = alt;
        r6 = r6 + 1;
        alt = r6;
        goto L_0x0007;
    L_0x00d5:
        r6 = "#END_ALTERNATE";
        r0 = r20;
        r6 = r0.startsWith(r6);
        if (r6 == 0) goto L_0x0007;
    L_0x00df:
        r6 = alt;
        if (r6 <= 0) goto L_0x0007;
    L_0x00e3:
        r6 = alt;
        r6 = r6 + -1;
        alt = r6;
        r6 = new java.io.IOException;
        r7 = "no lmhosts alternate includes loaded";
        r6.<init>(r7);
        throw r6;
    L_0x00f1:
        r6 = 0;
        r0 = r20;
        r6 = r0.charAt(r6);
        r6 = java.lang.Character.isDigit(r6);
        if (r6 == 0) goto L_0x0007;
    L_0x00fe:
        r16 = r20.toCharArray();
        r15 = 46;
        r17 = 0;
        r5 = r17;
    L_0x0108:
        r0 = r16;
        r6 = r0.length;
        r0 = r17;
        if (r0 >= r6) goto L_0x0134;
    L_0x010f:
        r6 = 46;
        if (r15 != r6) goto L_0x0134;
    L_0x0113:
        r13 = 0;
    L_0x0114:
        r0 = r16;
        r6 = r0.length;
        r0 = r17;
        if (r0 >= r6) goto L_0x012d;
    L_0x011b:
        r15 = r16[r17];
        r6 = 48;
        if (r15 < r6) goto L_0x012d;
    L_0x0121:
        r6 = 57;
        if (r15 > r6) goto L_0x012d;
    L_0x0125:
        r6 = r13 * 10;
        r6 = r6 + r15;
        r13 = r6 + -48;
        r17 = r17 + 1;
        goto L_0x0114;
    L_0x012d:
        r6 = r5 << 8;
        r5 = r6 + r13;
        r17 = r17 + 1;
        goto L_0x0108;
    L_0x0134:
        r0 = r16;
        r6 = r0.length;
        r0 = r17;
        if (r0 >= r6) goto L_0x0146;
    L_0x013b:
        r6 = r16[r17];
        r6 = java.lang.Character.isWhitespace(r6);
        if (r6 == 0) goto L_0x0146;
    L_0x0143:
        r17 = r17 + 1;
        goto L_0x0134;
    L_0x0146:
        r19 = r17;
    L_0x0148:
        r0 = r16;
        r6 = r0.length;
        r0 = r19;
        if (r0 >= r6) goto L_0x015a;
    L_0x014f:
        r6 = r16[r19];
        r6 = java.lang.Character.isWhitespace(r6);
        if (r6 != 0) goto L_0x015a;
    L_0x0157:
        r19 = r19 + 1;
        goto L_0x0148;
    L_0x015a:
        r4 = new jcifs.netbios.Name;
        r0 = r20;
        r1 = r17;
        r2 = r19;
        r6 = r0.substring(r1, r2);
        r7 = 32;
        r8 = 0;
        r4.<init>(r6, r7, r8);
        r3 = new jcifs.netbios.NbtAddress;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 1;
        r11 = 1;
        r12 = jcifs.netbios.NbtAddress.UNKNOWN_MAC_ADDRESS;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12);
        r6 = TAB;
        r6.put(r4, r3);
        goto L_0x0007;
    L_0x0180:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.netbios.Lmhosts.populate(java.io.Reader):void");
    }
}
