package jcifs.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.HashMap;
import java.util.Map;

public class Handler extends URLStreamHandler {
    public static final int DEFAULT_HTTP_PORT = 80;
    private static final String HANDLER_PKGS_PROPERTY = "java.protocol.handler.pkgs";
    private static final String[] JVM_VENDOR_DEFAULT_PKGS;
    private static final Map PROTOCOL_HANDLERS;
    private static URLStreamHandlerFactory factory;

    static {
        PROTOCOL_HANDLERS = new HashMap();
        JVM_VENDOR_DEFAULT_PKGS = new String[]{"sun.net.www.protocol"};
    }

    public static void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        synchronized (PROTOCOL_HANDLERS) {
            if (factory != null) {
                throw new IllegalStateException("URLStreamHandlerFactory already set.");
            }
            PROTOCOL_HANDLERS.clear();
            factory = factory;
        }
    }

    protected int getDefaultPort() {
        return DEFAULT_HTTP_PORT;
    }

    protected URLConnection openConnection(URL url) throws IOException {
        return new NtlmHttpURLConnection((HttpURLConnection) new URL(url, url.toExternalForm(), getDefaultStreamHandler(url.getProtocol())).openConnection());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.URLStreamHandler getDefaultStreamHandler(java.lang.String r13) throws java.io.IOException {
        /*
        r10 = PROTOCOL_HANDLERS;
        monitor-enter(r10);
        r9 = PROTOCOL_HANDLERS;	 Catch:{ all -> 0x00d0 }
        r2 = r9.get(r13);	 Catch:{ all -> 0x00d0 }
        r2 = (java.net.URLStreamHandler) r2;	 Catch:{ all -> 0x00d0 }
        if (r2 == 0) goto L_0x0010;
    L_0x000d:
        monitor-exit(r10);	 Catch:{ all -> 0x00d0 }
        r3 = r2;
    L_0x000f:
        return r3;
    L_0x0010:
        r9 = factory;	 Catch:{ all -> 0x00d0 }
        if (r9 == 0) goto L_0x001a;
    L_0x0014:
        r9 = factory;	 Catch:{ all -> 0x00d0 }
        r2 = r9.createURLStreamHandler(r13);	 Catch:{ all -> 0x00d0 }
    L_0x001a:
        if (r2 != 0) goto L_0x0073;
    L_0x001c:
        r9 = "java.protocol.handler.pkgs";
        r6 = java.lang.System.getProperty(r9);	 Catch:{ all -> 0x00d0 }
        r8 = new java.util.StringTokenizer;	 Catch:{ all -> 0x00d0 }
        r9 = "|";
        r8.<init>(r6, r9);	 Catch:{ all -> 0x00d0 }
    L_0x0029:
        r9 = r8.hasMoreTokens();	 Catch:{ all -> 0x00d0 }
        if (r9 == 0) goto L_0x0073;
    L_0x002f:
        r9 = r8.nextToken();	 Catch:{ all -> 0x00d0 }
        r7 = r9.trim();	 Catch:{ all -> 0x00d0 }
        r9 = "jcifs";
        r9 = r7.equals(r9);	 Catch:{ all -> 0x00d0 }
        if (r9 != 0) goto L_0x0029;
    L_0x003f:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r9.<init>();	 Catch:{ all -> 0x00d0 }
        r9 = r9.append(r7);	 Catch:{ all -> 0x00d0 }
        r11 = ".";
        r9 = r9.append(r11);	 Catch:{ all -> 0x00d0 }
        r9 = r9.append(r13);	 Catch:{ all -> 0x00d0 }
        r11 = ".Handler";
        r9 = r9.append(r11);	 Catch:{ all -> 0x00d0 }
        r1 = r9.toString();	 Catch:{ all -> 0x00d0 }
        r4 = 0;
        r4 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x00df }
    L_0x0061:
        if (r4 != 0) goto L_0x006b;
    L_0x0063:
        r9 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ Exception -> 0x00e5 }
        r4 = r9.loadClass(r1);	 Catch:{ Exception -> 0x00e5 }
    L_0x006b:
        r9 = r4.newInstance();	 Catch:{ Exception -> 0x00e5 }
        r0 = r9;
        r0 = (java.net.URLStreamHandler) r0;	 Catch:{ Exception -> 0x00e5 }
        r2 = r0;
    L_0x0073:
        if (r2 != 0) goto L_0x00b5;
    L_0x0075:
        r5 = 0;
    L_0x0076:
        r9 = JVM_VENDOR_DEFAULT_PKGS;	 Catch:{ all -> 0x00d0 }
        r9 = r9.length;	 Catch:{ all -> 0x00d0 }
        if (r5 >= r9) goto L_0x00b5;
    L_0x007b:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r9.<init>();	 Catch:{ all -> 0x00d0 }
        r11 = JVM_VENDOR_DEFAULT_PKGS;	 Catch:{ all -> 0x00d0 }
        r11 = r11[r5];	 Catch:{ all -> 0x00d0 }
        r9 = r9.append(r11);	 Catch:{ all -> 0x00d0 }
        r11 = ".";
        r9 = r9.append(r11);	 Catch:{ all -> 0x00d0 }
        r9 = r9.append(r13);	 Catch:{ all -> 0x00d0 }
        r11 = ".Handler";
        r9 = r9.append(r11);	 Catch:{ all -> 0x00d0 }
        r1 = r9.toString();	 Catch:{ all -> 0x00d0 }
        r4 = 0;
        r4 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x00e1 }
    L_0x00a1:
        if (r4 != 0) goto L_0x00ab;
    L_0x00a3:
        r9 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ Exception -> 0x00e3 }
        r4 = r9.loadClass(r1);	 Catch:{ Exception -> 0x00e3 }
    L_0x00ab:
        r9 = r4.newInstance();	 Catch:{ Exception -> 0x00e3 }
        r0 = r9;
        r0 = (java.net.URLStreamHandler) r0;	 Catch:{ Exception -> 0x00e3 }
        r2 = r0;
    L_0x00b3:
        if (r2 == 0) goto L_0x00d3;
    L_0x00b5:
        if (r2 != 0) goto L_0x00d6;
    L_0x00b7:
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00d0 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r11.<init>();	 Catch:{ all -> 0x00d0 }
        r12 = "Unable to find default handler for protocol: ";
        r11 = r11.append(r12);	 Catch:{ all -> 0x00d0 }
        r11 = r11.append(r13);	 Catch:{ all -> 0x00d0 }
        r11 = r11.toString();	 Catch:{ all -> 0x00d0 }
        r9.<init>(r11);	 Catch:{ all -> 0x00d0 }
        throw r9;	 Catch:{ all -> 0x00d0 }
    L_0x00d0:
        r9 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00d0 }
        throw r9;
    L_0x00d3:
        r5 = r5 + 1;
        goto L_0x0076;
    L_0x00d6:
        r9 = PROTOCOL_HANDLERS;	 Catch:{ all -> 0x00d0 }
        r9.put(r13, r2);	 Catch:{ all -> 0x00d0 }
        monitor-exit(r10);	 Catch:{ all -> 0x00d0 }
        r3 = r2;
        goto L_0x000f;
    L_0x00df:
        r9 = move-exception;
        goto L_0x0061;
    L_0x00e1:
        r9 = move-exception;
        goto L_0x00a1;
    L_0x00e3:
        r9 = move-exception;
        goto L_0x00b3;
    L_0x00e5:
        r9 = move-exception;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.http.Handler.getDefaultStreamHandler(java.lang.String):java.net.URLStreamHandler");
    }
}
