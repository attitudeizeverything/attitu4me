package org.apache.cordova.filetransfer;

import android.net.Uri;
import android.util.Log;
import com.mstar.android.MKeyEvent;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileTransfer extends CordovaPlugin {
    public static int ABORTED_ERR = 0;
    private static final String BOUNDARY = "+++++";
    public static int CONNECTION_ERR = 0;
    private static final HostnameVerifier DO_NOT_VERIFY;
    public static int FILE_NOT_FOUND_ERR = 0;
    public static int INVALID_URL_ERR = 0;
    private static final String LINE_END = "\r\n";
    private static final String LINE_START = "--";
    private static final String LOG_TAG = "FileTransfer";
    private static final int MAX_BUFFER_SIZE = 16384;
    public static int NOT_MODIFIED_ERR;
    private static HashMap<String, RequestContext> activeRequests;
    private static final TrustManager[] trustAllCerts;

    /* renamed from: org.apache.cordova.filetransfer.FileTransfer.1 */
    class C03171 implements HostnameVerifier {
        C03171() {
        }

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /* renamed from: org.apache.cordova.filetransfer.FileTransfer.2 */
    class C03182 implements X509TrustManager {
        C03182() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }

    /* renamed from: org.apache.cordova.filetransfer.FileTransfer.3 */
    class C03193 implements Runnable {
        private final /* synthetic */ boolean val$chunkedMode;
        private final /* synthetic */ RequestContext val$context;
        private final /* synthetic */ String val$fileKey;
        private final /* synthetic */ String val$fileName;
        private final /* synthetic */ JSONObject val$headers;
        private final /* synthetic */ String val$httpMethod;
        private final /* synthetic */ String val$mimeType;
        private final /* synthetic */ String val$objectId;
        private final /* synthetic */ JSONObject val$params;
        private final /* synthetic */ CordovaResourceApi val$resourceApi;
        private final /* synthetic */ String val$source;
        private final /* synthetic */ Uri val$sourceUri;
        private final /* synthetic */ String val$target;
        private final /* synthetic */ Uri val$targetUri;
        private final /* synthetic */ boolean val$trustEveryone;
        private final /* synthetic */ boolean val$useHttps;

        C03193(RequestContext requestContext, String str, boolean z, boolean z2, CordovaResourceApi cordovaResourceApi, Uri uri, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, String str4, String str5, String str6, Uri uri2, boolean z3, String str7) {
            this.val$context = requestContext;
            this.val$objectId = str;
            this.val$trustEveryone = z;
            this.val$useHttps = z2;
            this.val$resourceApi = cordovaResourceApi;
            this.val$targetUri = uri;
            this.val$httpMethod = str2;
            this.val$target = str3;
            this.val$headers = jSONObject;
            this.val$params = jSONObject2;
            this.val$fileKey = str4;
            this.val$fileName = str5;
            this.val$mimeType = str6;
            this.val$sourceUri = uri2;
            this.val$chunkedMode = z3;
            this.val$source = str7;
        }

        public void run() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:141:0x04f7
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r40 = this;
            r0 = r40;
            r0 = r0.val$context;
            r36 = r0;
            r0 = r36;
            r0 = r0.aborted;
            r36 = r0;
            if (r36 == 0) goto L_0x000f;
        L_0x000e:
            return;
        L_0x000f:
            r10 = 0;
            r19 = 0;
            r20 = 0;
            r34 = 0;
            r14 = -1;
            r29 = new org.apache.cordova.filetransfer.FileUploadResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r29.<init>();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r24 = new org.apache.cordova.filetransfer.FileProgressResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r24.<init>();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$targetUri;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10 = r36.createHttpConnection(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$useHttps;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 == 0) goto L_0x0056;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0039:
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$trustEveryone;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 == 0) goto L_0x0056;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0041:
            r0 = r10;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r15 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r20 = org.apache.cordova.filetransfer.FileTransfer.trustAllHosts(r15);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r19 = r15.getHostnameVerifier();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = org.apache.cordova.filetransfer.FileTransfer.DO_NOT_VERIFY;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r15.setHostnameVerifier(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0056:
            r36 = 1;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setDoInput(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = 1;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setDoOutput(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setUseCaches(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$httpMethod;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setRequestMethod(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "Content-Type";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "multipart/form-data; boundary=+++++";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setRequestProperty(r0, r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = android.webkit.CookieManager.getInstance();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r11 = r36.getCookie(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r11 == 0) goto L_0x0098;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0091:
            r36 = "Cookie";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setRequestProperty(r0, r11);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0098:
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$headers;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 == 0) goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x00a0:
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$headers;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.addHeadersToRequest(r10, r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x00ab:
            r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r4.<init>();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r0.val$params;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r0;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r17 = r36.keys();	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
        L_0x00ba:
            r36 = r17.hasNext();	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            if (r36 != 0) goto L_0x022f;
        L_0x00c0:
            r36 = "--";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "+++++";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "\r\n";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "Content-Disposition: form-data; name=\"";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$fileKey;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "\";";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = " filename=\"";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$fileName;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = 34;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "\r\n";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "Content-Type: ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$mimeType;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "\r\n";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "\r\n";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.append(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r4.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r5 = r36.getBytes(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "\r\n--+++++--\r\n";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r33 = r36.getBytes(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$sourceUri;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r26 = r36.openForRead(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r5.length;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r33;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.length;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r31 = r36 + r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r26;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.length;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1));	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 < 0) goto L_0x017c;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x015c:
            r0 = r26;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.length;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = (int) r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r14 = r36 + r31;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = 1;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r24;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.setLengthComputable(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = (long) r14;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r24;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.setTotal(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x017c:
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = "Content Length: ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r14);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$chunkedMode;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 == 0) goto L_0x0312;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x019a:
            r36 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = 8;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r0 < r1) goto L_0x01ac;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01a4:
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$useHttps;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r36 == 0) goto L_0x0312;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01ac:
            r35 = 1;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01ae:
            if (r35 != 0) goto L_0x0316;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01b0:
            r36 = -1;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r14 == r0) goto L_0x0316;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01b6:
            r35 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01b8:
            if (r35 == 0) goto L_0x031a;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01ba:
            r36 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setChunkedStreamingMode(r0);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "Transfer-Encoding";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "chunked";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r10.setRequestProperty(r0, r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x01cc:
            r10.connect();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r30 = 0;
            r30 = r10.getOutputStream();	 Catch:{ all -> 0x04f6 }
            r0 = r40;	 Catch:{ all -> 0x04f6 }
            r0 = r0.val$context;	 Catch:{ all -> 0x04f6 }
            r37 = r0;	 Catch:{ all -> 0x04f6 }
            monitor-enter(r37);	 Catch:{ all -> 0x04f6 }
            r0 = r40;	 Catch:{ all -> 0x04f6 }
            r0 = r0.val$context;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r0 = r0.aborted;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            if (r36 == 0) goto L_0x03be;	 Catch:{ all -> 0x04f6 }
        L_0x01ea:
            monitor-exit(r37);	 Catch:{ all -> 0x04f6 }
            r0 = r26;
            r0 = r0.inputStream;
            r36 = r0;
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r36);
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r30);
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r38 = r0;
            r0 = r36;
            r1 = r38;
            r0.remove(r1);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x000e;
        L_0x0210:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0218:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0220:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x022f:
            r18 = r17.next();	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = java.lang.String.valueOf(r18);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = "headers";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r36.equals(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            if (r36 != 0) goto L_0x00ba;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
        L_0x023f:
            r36 = "--";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r36;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r4.append(r0);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = "+++++";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r36.append(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = "\r\n";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36.append(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = "Content-Disposition: form-data; name=\"";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r36;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r4.append(r0);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = r18.toString();	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r36.append(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = 34;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36.append(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = "\r\n";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r36;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r4.append(r0);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = "\r\n";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36.append(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r40;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r0.val$params;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r0;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r37 = r18.toString();	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = r36.getString(r37);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r36;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r4.append(r0);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r36 = "\r\n";	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r0 = r36;	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            r4.append(r0);	 Catch:{ JSONException -> 0x0290, FileNotFoundException -> 0x02a0, IOException -> 0x031f, Throwable -> 0x0608 }
            goto L_0x00ba;
        L_0x0290:
            r12 = move-exception;
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r12.getMessage();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            goto L_0x00c0;
        L_0x02a0:
            r12 = move-exception;
            r36 = org.apache.cordova.filetransfer.FileTransfer.FILE_NOT_FOUND_ERR;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r2 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r13 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r10, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r13.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.<init>(r1, r13);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.sendPluginResult(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$objectId;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.remove(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r10 == 0) goto L_0x000e;
        L_0x02f3:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x02fb:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0303:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x0312:
            r35 = 0;
            goto L_0x01ae;
        L_0x0316:
            r35 = 1;
            goto L_0x01b8;
        L_0x031a:
            r10.setFixedLengthStreamingMode(r14);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            goto L_0x01cc;
        L_0x031f:
            r12 = move-exception;
            r36 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r2 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r13 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r10, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r13.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = "Failed after uploading ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r34;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = " of ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.append(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r14);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = " bytes.";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.append(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.<init>(r1, r13);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.sendPluginResult(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$objectId;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.remove(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            if (r10 == 0) goto L_0x000e;
        L_0x039c:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x03a4:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x03ac:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x03bb:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
        L_0x03be:
            r0 = r40;	 Catch:{ all -> 0x04f6 }
            r0 = r0.val$context;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r0.connection = r10;	 Catch:{ all -> 0x04f6 }
            monitor-exit(r37);	 Catch:{ all -> 0x04f6 }
            r0 = r30;	 Catch:{ all -> 0x04f6 }
            r0.write(r5);	 Catch:{ all -> 0x04f6 }
            r0 = r5.length;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r34 = r34 + r36;	 Catch:{ all -> 0x04f6 }
            r0 = r26;	 Catch:{ all -> 0x04f6 }
            r0 = r0.inputStream;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r8 = r36.available();	 Catch:{ all -> 0x04f6 }
            r36 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r7 = java.lang.Math.min(r8, r0);	 Catch:{ all -> 0x04f6 }
            r6 = new byte[r7];	 Catch:{ all -> 0x04f6 }
            r0 = r26;	 Catch:{ all -> 0x04f6 }
            r0 = r0.inputStream;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r37 = 0;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r1 = r37;	 Catch:{ all -> 0x04f6 }
            r9 = r0.read(r6, r1, r7);	 Catch:{ all -> 0x04f6 }
            r22 = 0;	 Catch:{ all -> 0x04f6 }
        L_0x03f9:
            if (r9 > 0) goto L_0x055a;	 Catch:{ all -> 0x04f6 }
        L_0x03fb:
            r0 = r30;	 Catch:{ all -> 0x04f6 }
            r1 = r33;	 Catch:{ all -> 0x04f6 }
            r0.write(r1);	 Catch:{ all -> 0x04f6 }
            r0 = r33;	 Catch:{ all -> 0x04f6 }
            r0 = r0.length;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r34 = r34 + r36;	 Catch:{ all -> 0x04f6 }
            r30.flush();	 Catch:{ all -> 0x04f6 }
            r0 = r26;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.inputStream;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r36);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r30);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-enter(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1.connection = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = "Sent ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r34;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = " of ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.append(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r14);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r27 = r10.getResponseCode();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = "response code: ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r27;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = "response headers: ";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r10.getHeaderFields();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.append(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r37.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r16 = 0;
            r16 = org.apache.cordova.filetransfer.FileTransfer.getInputStream(r10);	 Catch:{ all -> 0x0787 }
            r0 = r40;	 Catch:{ all -> 0x0787 }
            r0 = r0.val$context;	 Catch:{ all -> 0x0787 }
            r37 = r0;	 Catch:{ all -> 0x0787 }
            monitor-enter(r37);	 Catch:{ all -> 0x0787 }
            r0 = r40;	 Catch:{ all -> 0x0787 }
            r0 = r0.val$context;	 Catch:{ all -> 0x0787 }
            r36 = r0;	 Catch:{ all -> 0x0787 }
            r0 = r36;	 Catch:{ all -> 0x0787 }
            r0 = r0.aborted;	 Catch:{ all -> 0x0787 }
            r36 = r0;	 Catch:{ all -> 0x0787 }
            if (r36 == 0) goto L_0x06b8;	 Catch:{ all -> 0x0787 }
        L_0x04a1:
            monitor-exit(r37);	 Catch:{ all -> 0x0787 }
            r0 = r40;
            r0 = r0.val$context;
            r37 = r0;
            monitor-enter(r37);
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1.connection = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r38 = r0;
            r0 = r36;
            r1 = r38;
            r0.remove(r1);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x000e;
        L_0x04d4:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x04dc:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x04e4:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x04f3:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ all -> 0x04f6 }
            throw r36;	 Catch:{ all -> 0x04f6 }
        L_0x04f6:
            r36 = move-exception;
            r0 = r26;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.inputStream;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r30);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0504:
            r12 = move-exception;
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r12.getMessage();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = org.apache.cordova.PluginResult.Status.JSON_EXCEPTION;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.sendPluginResult(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r38 = r0;
            r0 = r36;
            r1 = r38;
            r0.remove(r1);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x000e;
        L_0x053b:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0543:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x054b:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x055a:
            r0 = r34;
            r0 = (long) r0;
            r36 = r0;
            r0 = r29;	 Catch:{ all -> 0x04f6 }
            r1 = r36;	 Catch:{ all -> 0x04f6 }
            r0.setBytesSent(r1);	 Catch:{ all -> 0x04f6 }
            r36 = 0;	 Catch:{ all -> 0x04f6 }
            r0 = r30;	 Catch:{ all -> 0x04f6 }
            r1 = r36;	 Catch:{ all -> 0x04f6 }
            r0.write(r6, r1, r9);	 Catch:{ all -> 0x04f6 }
            r34 = r34 + r9;	 Catch:{ all -> 0x04f6 }
            r0 = r34;	 Catch:{ all -> 0x04f6 }
            r0 = (long) r0;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r38 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;	 Catch:{ all -> 0x04f6 }
            r38 = r38 + r22;	 Catch:{ all -> 0x04f6 }
            r36 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1));	 Catch:{ all -> 0x04f6 }
            if (r36 <= 0) goto L_0x05ae;	 Catch:{ all -> 0x04f6 }
        L_0x057f:
            r0 = r34;	 Catch:{ all -> 0x04f6 }
            r0 = (long) r0;	 Catch:{ all -> 0x04f6 }
            r22 = r0;	 Catch:{ all -> 0x04f6 }
            r36 = "FileTransfer";	 Catch:{ all -> 0x04f6 }
            r37 = new java.lang.StringBuilder;	 Catch:{ all -> 0x04f6 }
            r38 = "Uploaded ";	 Catch:{ all -> 0x04f6 }
            r37.<init>(r38);	 Catch:{ all -> 0x04f6 }
            r0 = r37;	 Catch:{ all -> 0x04f6 }
            r1 = r34;	 Catch:{ all -> 0x04f6 }
            r37 = r0.append(r1);	 Catch:{ all -> 0x04f6 }
            r38 = " of ";	 Catch:{ all -> 0x04f6 }
            r37 = r37.append(r38);	 Catch:{ all -> 0x04f6 }
            r0 = r37;	 Catch:{ all -> 0x04f6 }
            r37 = r0.append(r14);	 Catch:{ all -> 0x04f6 }
            r38 = " bytes";	 Catch:{ all -> 0x04f6 }
            r37 = r37.append(r38);	 Catch:{ all -> 0x04f6 }
            r37 = r37.toString();	 Catch:{ all -> 0x04f6 }
            android.util.Log.d(r36, r37);	 Catch:{ all -> 0x04f6 }
        L_0x05ae:
            r0 = r26;	 Catch:{ all -> 0x04f6 }
            r0 = r0.inputStream;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r8 = r36.available();	 Catch:{ all -> 0x04f6 }
            r36 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r7 = java.lang.Math.min(r8, r0);	 Catch:{ all -> 0x04f6 }
            r0 = r26;	 Catch:{ all -> 0x04f6 }
            r0 = r0.inputStream;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r37 = 0;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r1 = r37;	 Catch:{ all -> 0x04f6 }
            r9 = r0.read(r6, r1, r7);	 Catch:{ all -> 0x04f6 }
            r0 = r34;	 Catch:{ all -> 0x04f6 }
            r0 = (long) r0;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r0 = r24;	 Catch:{ all -> 0x04f6 }
            r1 = r36;	 Catch:{ all -> 0x04f6 }
            r0.setLoaded(r1);	 Catch:{ all -> 0x04f6 }
            r25 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x04f6 }
            r36 = org.apache.cordova.PluginResult.Status.OK;	 Catch:{ all -> 0x04f6 }
            r37 = r24.toJSONObject();	 Catch:{ all -> 0x04f6 }
            r0 = r25;	 Catch:{ all -> 0x04f6 }
            r1 = r36;	 Catch:{ all -> 0x04f6 }
            r2 = r37;	 Catch:{ all -> 0x04f6 }
            r0.<init>(r1, r2);	 Catch:{ all -> 0x04f6 }
            r36 = 1;	 Catch:{ all -> 0x04f6 }
            r0 = r25;	 Catch:{ all -> 0x04f6 }
            r1 = r36;	 Catch:{ all -> 0x04f6 }
            r0.setKeepCallback(r1);	 Catch:{ all -> 0x04f6 }
            r0 = r40;	 Catch:{ all -> 0x04f6 }
            r0 = r0.val$context;	 Catch:{ all -> 0x04f6 }
            r36 = r0;	 Catch:{ all -> 0x04f6 }
            r0 = r36;	 Catch:{ all -> 0x04f6 }
            r1 = r25;	 Catch:{ all -> 0x04f6 }
            r0.sendPluginResult(r1);	 Catch:{ all -> 0x04f6 }
            goto L_0x03f9;
        L_0x0605:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0608:
            r32 = move-exception;
            r36 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r2 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r3 = r32;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r13 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r10, r3);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r13.toString();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r2 = r32;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.e(r0, r1, r2);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.<init>(r1, r13);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.sendPluginResult(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r38 = r0;
            r0 = r36;
            r1 = r38;
            r0.remove(r1);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x000e;
        L_0x065f:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0667:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x066f:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x067e:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x0681:
            r36 = move-exception;
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r38 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r39 = r0;
            r38.remove(r39);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x06b4;
        L_0x0697:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r37 = r0;
            if (r37 == 0) goto L_0x06b4;
        L_0x069f:
            r0 = r40;
            r0 = r0.val$useHttps;
            r37 = r0;
            if (r37 == 0) goto L_0x06b4;
        L_0x06a7:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
        L_0x06b4:
            throw r36;
        L_0x06b5:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
        L_0x06b8:
            r0 = r40;	 Catch:{ all -> 0x0787 }
            r0 = r0.val$context;	 Catch:{ all -> 0x0787 }
            r36 = r0;	 Catch:{ all -> 0x0787 }
            r0 = r36;	 Catch:{ all -> 0x0787 }
            r0.connection = r10;	 Catch:{ all -> 0x0787 }
            monitor-exit(r37);	 Catch:{ all -> 0x0787 }
            r21 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0787 }
            r36 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0787 }
            r37 = r10.getContentLength();	 Catch:{ all -> 0x0787 }
            r36 = java.lang.Math.max(r36, r37);	 Catch:{ all -> 0x0787 }
            r0 = r21;	 Catch:{ all -> 0x0787 }
            r1 = r36;	 Catch:{ all -> 0x0787 }
            r0.<init>(r1);	 Catch:{ all -> 0x0787 }
            r36 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0787 }
            r0 = r36;	 Catch:{ all -> 0x0787 }
            r6 = new byte[r0];	 Catch:{ all -> 0x0787 }
            r9 = 0;	 Catch:{ all -> 0x0787 }
        L_0x06dd:
            r0 = r16;	 Catch:{ all -> 0x0787 }
            r9 = r0.read(r6);	 Catch:{ all -> 0x0787 }
            if (r9 > 0) goto L_0x07a2;	 Catch:{ all -> 0x0787 }
        L_0x06e5:
            r36 = "UTF-8";	 Catch:{ all -> 0x0787 }
            r0 = r21;	 Catch:{ all -> 0x0787 }
            r1 = r36;	 Catch:{ all -> 0x0787 }
            r28 = r0.toString(r1);	 Catch:{ all -> 0x0787 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-enter(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1.connection = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = "got response from server";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = "FileTransfer";	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r39 = r28.length();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = java.lang.Math.min(r38, r39);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r28;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r37;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r2 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0.substring(r1, r2);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            android.util.Log.d(r36, r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r29;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r27;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.setResponseCode(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r29;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r28;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0.setResponse(r1);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = org.apache.cordova.PluginResult.Status.OK;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r39 = r29.toJSONObject();	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37.<init>(r38, r39);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r36.sendPluginResult(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r37);
            r36 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            r0 = r40;
            r0 = r0.val$objectId;
            r38 = r0;
            r0 = r36;
            r1 = r38;
            r0.remove(r1);
            monitor-exit(r37);
            if (r10 == 0) goto L_0x000e;
        L_0x0765:
            r0 = r40;
            r0 = r0.val$trustEveryone;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x076d:
            r0 = r40;
            r0 = r0.val$useHttps;
            r36 = r0;
            if (r36 == 0) goto L_0x000e;
        L_0x0775:
            r15 = r10;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r19;
            r15.setHostnameVerifier(r0);
            r0 = r20;
            r15.setSSLSocketFactory(r0);
            goto L_0x000e;
        L_0x0784:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ all -> 0x0787 }
            throw r36;	 Catch:{ all -> 0x0787 }
        L_0x0787:
            r36 = move-exception;
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r37 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-enter(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r40;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r38 = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r39 = 0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r0 = r39;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1 = r38;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            r1.connection = r0;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x07a2:
            r36 = 0;
            r0 = r21;	 Catch:{ all -> 0x0787 }
            r1 = r36;	 Catch:{ all -> 0x0787 }
            r0.write(r6, r1, r9);	 Catch:{ all -> 0x0787 }
            goto L_0x06dd;
        L_0x07ad:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x07b0:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
        L_0x07b3:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;
        L_0x07b6:
            r36 = move-exception;
            monitor-exit(r37);	 Catch:{ FileNotFoundException -> 0x02a0, IOException -> 0x031f, JSONException -> 0x0504, Throwable -> 0x0608, all -> 0x0681 }
            throw r36;
        L_0x07b9:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
        L_0x07bc:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
        L_0x07bf:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
        L_0x07c2:
            r36 = move-exception;
            monitor-exit(r37);
            throw r36;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.filetransfer.FileTransfer.3.run():void");
        }
    }

    /* renamed from: org.apache.cordova.filetransfer.FileTransfer.4 */
    class C03204 implements Runnable {
        private final /* synthetic */ RequestContext val$context;
        private final /* synthetic */ JSONObject val$headers;
        private final /* synthetic */ boolean val$isLocalTransfer;
        private final /* synthetic */ String val$objectId;
        private final /* synthetic */ CordovaResourceApi val$resourceApi;
        private final /* synthetic */ String val$source;
        private final /* synthetic */ Uri val$sourceUri;
        private final /* synthetic */ String val$target;
        private final /* synthetic */ Uri val$targetUri;
        private final /* synthetic */ boolean val$trustEveryone;
        private final /* synthetic */ boolean val$useHttps;

        C03204(RequestContext requestContext, String str, boolean z, boolean z2, String str2, String str3, CordovaResourceApi cordovaResourceApi, Uri uri, Uri uri2, boolean z3, JSONObject jSONObject) {
            this.val$context = requestContext;
            this.val$objectId = str;
            this.val$trustEveryone = z;
            this.val$useHttps = z2;
            this.val$source = str2;
            this.val$target = str3;
            this.val$resourceApi = cordovaResourceApi;
            this.val$targetUri = uri;
            this.val$sourceUri = uri2;
            this.val$isLocalTransfer = z3;
            this.val$headers = jSONObject;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r39 = this;
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r0 = r0.aborted;
            r33 = r0;
            if (r33 == 0) goto L_0x000f;
        L_0x000e:
            return;
        L_0x000f:
            r7 = 0;
            r20 = 0;
            r21 = 0;
            r11 = 0;
            r30 = 0;
            r16 = 0;
            r6 = 0;
            r28 = 0;
            r22 = 0;
            r29 = 0;
            r0 = r39;
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r39;
            r0 = r0.val$targetUri;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r11 = r33.mapUriToFile(r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r33;
            r0.targetFile = r11;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = "FileTransfer";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "Download file:";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$sourceUri;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = r0;
            r34 = r34.append(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            android.util.Log.d(r33, r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r26 = new org.apache.cordova.filetransfer.FileProgressResult;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r26.<init>();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$isLocalTransfer;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            if (r33 == 0) goto L_0x014c;
        L_0x0061:
            r0 = r39;
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r39;
            r0 = r0.val$sourceUri;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r29 = r33.openForRead(r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r29;
            r0 = r0.length;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r36 = -1;
            r33 = (r34 > r36 ? 1 : (r34 == r36 ? 0 : -1));
            if (r33 == 0) goto L_0x0093;
        L_0x007d:
            r33 = 1;
            r0 = r26;
            r1 = r33;
            r0.setLengthComputable(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r29;
            r0 = r0.length;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r0 = r26;
            r1 = r34;
            r0.setTotal(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x0093:
            r17 = new org.apache.cordova.filetransfer.FileTransfer$SimpleTrackingInputStream;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r29;
            r0 = r0.inputStream;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r17;
            r1 = r33;
            r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r16 = r17;
            r31 = r30;
        L_0x00a6:
            if (r6 != 0) goto L_0x081e;
        L_0x00a8:
            if (r28 != 0) goto L_0x03b8;
        L_0x00aa:
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x04e2 }
            r34 = r0;
            monitor-enter(r34);	 Catch:{ all -> 0x04e2 }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x04df }
            r33 = r0;
            r0 = r33;
            r0 = r0.aborted;	 Catch:{ all -> 0x04df }
            r33 = r0;
            if (r33 == 0) goto L_0x0375;
        L_0x00bf:
            monitor-exit(r34);	 Catch:{ all -> 0x04df }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = r0;
            monitor-enter(r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x02ce }
            r33 = r0;
            r35 = 0;
            r0 = r35;
            r1 = r33;
            r1.connection = r0;	 Catch:{ all -> 0x02ce }
            monitor-exit(r34);	 Catch:{ all -> 0x02ce }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r22);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x0372 }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x0372 }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x0372 }
            monitor-exit(r34);	 Catch:{ all -> 0x0372 }
            if (r7 == 0) goto L_0x0112;
        L_0x00f5:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x0112;
        L_0x00fd:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x0112;
        L_0x0105:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x0112:
            if (r31 != 0) goto L_0x081a;
        L_0x0114:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x013d:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x014c:
            r0 = r39;
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r39;
            r0 = r0.val$sourceUri;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r7 = r33.createHttpConnection(r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
            r0 = r33;
            r7.setReadTimeout(r0);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$useHttps;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            if (r33 == 0) goto L_0x0189;
        L_0x016c:
            r0 = r39;
            r0 = r0.val$trustEveryone;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            if (r33 == 0) goto L_0x0189;
        L_0x0174:
            r0 = r7;
            r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r15 = r0;
            r21 = org.apache.cordova.filetransfer.FileTransfer.trustAllHosts(r15);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r20 = r15.getHostnameVerifier();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = org.apache.cordova.filetransfer.FileTransfer.DO_NOT_VERIFY;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r33;
            r15.setHostnameVerifier(r0);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x0189:
            r33 = "GET";
            r0 = r33;
            r7.setRequestMethod(r0);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r18 = r11.length();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = 0;
            r33 = (r18 > r34 ? 1 : (r18 == r34 ? 0 : -1));
            if (r33 <= 0) goto L_0x01d4;
        L_0x019a:
            r33 = "FileTransfer";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "File exists, adding range heder for ";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r34;
            r1 = r18;
            r34 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            android.util.Log.d(r33, r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = "Range";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "bytes=";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r34;
            r1 = r18;
            r34 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "-";
            r34 = r34.append(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r33;
            r1 = r34;
            r7.setRequestProperty(r0, r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x01d4:
            r33 = android.webkit.CookieManager.getInstance();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$sourceUri;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r8 = r33.getCookie(r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            if (r8 == 0) goto L_0x01ef;
        L_0x01e8:
            r33 = "cookie";
            r0 = r33;
            r7.setRequestProperty(r0, r8);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x01ef:
            r33 = "Accept-Encoding";
            r34 = "gzip";
            r0 = r33;
            r1 = r34;
            r7.setRequestProperty(r0, r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$headers;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            if (r33 == 0) goto L_0x020d;
        L_0x0202:
            r0 = r39;
            r0 = r0.val$headers;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r0;
            r0 = r33;
            org.apache.cordova.filetransfer.FileTransfer.addHeadersToRequest(r7, r0);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x020d:
            r7.connect();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r7.getResponseCode();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
            r0 = r33;
            r1 = r34;
            if (r0 != r1) goto L_0x0263;
        L_0x021c:
            r6 = 1;
            r7.disconnect();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = "FileTransfer";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "Resource not modified: ";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = r0;
            r34 = r34.append(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            android.util.Log.d(r33, r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = org.apache.cordova.filetransfer.FileTransfer.NOT_MODIFIED_ERR;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = r0;
            r36 = 0;
            r0 = r33;
            r1 = r34;
            r2 = r35;
            r3 = r36;
            r10 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r31 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = org.apache.cordova.PluginResult.Status.ERROR;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r31;
            r1 = r33;
            r0.<init>(r1, r10);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            goto L_0x00a6;
        L_0x0263:
            r33 = r7.getResponseCode();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
            r0 = r33;
            r1 = r34;
            if (r0 != r1) goto L_0x028f;
        L_0x026f:
            r28 = 1;
            r33 = "FileTransfer";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = "Resource Already Downloaded: ";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r35 = r0;
            r34 = r34.append(r35);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            android.util.Log.d(r33, r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r31 = r30;
            goto L_0x00a6;
        L_0x028f:
            r33 = r7.getContentEncoding();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            if (r33 == 0) goto L_0x02a1;
        L_0x0295:
            r33 = r7.getContentEncoding();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = "gzip";
            r33 = r33.equalsIgnoreCase(r34);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            if (r33 == 0) goto L_0x02c6;
        L_0x02a1:
            r33 = r7.getContentLength();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = -1;
            r0 = r33;
            r1 = r34;
            if (r0 == r1) goto L_0x02c6;
        L_0x02ad:
            r33 = 1;
            r0 = r26;
            r1 = r33;
            r0.setLengthComputable(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r33 = r7.getContentLength();	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r0 = r33;
            r0 = (long) r0;	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r34 = r0;
            r0 = r26;
            r1 = r34;
            r0.setTotal(r1);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
        L_0x02c6:
            r16 = org.apache.cordova.filetransfer.FileTransfer.getInputStream(r7);	 Catch:{ FileNotFoundException -> 0x0806, IOException -> 0x07fc, JSONException -> 0x07f2, Throwable -> 0x06c8, all -> 0x076e }
            r31 = r30;
            goto L_0x00a6;
        L_0x02ce:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x02ce }
            throw r33;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
        L_0x02d1:
            r9 = move-exception;
        L_0x02d2:
            r33 = org.apache.cordova.filetransfer.FileTransfer.FILE_NOT_FOUND_ERR;	 Catch:{ all -> 0x07e0 }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ all -> 0x07e0 }
            r34 = r0;
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ all -> 0x07e0 }
            r35 = r0;
            r0 = r33;
            r1 = r34;
            r2 = r35;
            r10 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r9);	 Catch:{ all -> 0x07e0 }
            r33 = "FileTransfer";
            r34 = r10.toString();	 Catch:{ all -> 0x07e0 }
            r0 = r33;
            r1 = r34;
            android.util.Log.e(r0, r1, r9);	 Catch:{ all -> 0x07e0 }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x07e0 }
            r33 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ all -> 0x07e0 }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1, r10);	 Catch:{ all -> 0x07e0 }
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x06bf }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x06bf }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x06bf }
            monitor-exit(r34);	 Catch:{ all -> 0x06bf }
            if (r7 == 0) goto L_0x0338;
        L_0x031b:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x0338;
        L_0x0323:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x0338;
        L_0x032b:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x0338:
            if (r30 != 0) goto L_0x0363;
        L_0x033a:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x0363:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x0372:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x0372 }
            throw r33;
        L_0x0375:
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x04df }
            r33 = r0;
            r0 = r33;
            r0.connection = r7;	 Catch:{ all -> 0x04df }
            monitor-exit(r34);	 Catch:{ all -> 0x04df }
            r33 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            r0 = r33;
            r4 = new byte[r0];	 Catch:{ all -> 0x04e2 }
            r5 = 0;
            r23 = new java.io.FileOutputStream;	 Catch:{ all -> 0x04e2 }
            r33 = 1;
            r0 = r23;
            r1 = r33;
            r0.<init>(r11, r1);	 Catch:{ all -> 0x04e2 }
        L_0x0392:
            r0 = r16;
            r5 = r0.read(r4);	 Catch:{ all -> 0x05de }
            if (r5 > 0) goto L_0x05a1;
        L_0x039a:
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x0672, IOException -> 0x0801, JSONException -> 0x07f7, Throwable -> 0x07ed, all -> 0x07e4 }
            r34 = r0;
            monitor-enter(r34);	 Catch:{ FileNotFoundException -> 0x0672, IOException -> 0x0801, JSONException -> 0x07f7, Throwable -> 0x07ed, all -> 0x07e4 }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x066f }
            r33 = r0;
            r35 = 0;
            r0 = r35;
            r1 = r33;
            r1.connection = r0;	 Catch:{ all -> 0x066f }
            monitor-exit(r34);	 Catch:{ all -> 0x066f }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x0672, IOException -> 0x0801, JSONException -> 0x07f7, Throwable -> 0x07ed, all -> 0x07e4 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r23);	 Catch:{ FileNotFoundException -> 0x0672, IOException -> 0x0801, JSONException -> 0x07f7, Throwable -> 0x07ed, all -> 0x07e4 }
            r22 = r23;
        L_0x03b8:
            r33 = "FileTransfer";
            r34 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r35 = "Saved file: ";
            r34.<init>(r35);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r35 = r0;
            r34 = r34.append(r35);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = r34.toString();	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            android.util.Log.d(r33, r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = org.apache.cordova.filetransfer.FileTransfer.this;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = r0;
            r0 = r33;
            r0 = r0.webView;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = r0;
            r32 = r33.getClass();	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r24 = 0;
            r33 = "getPluginManager";
            r34 = 0;
            r0 = r34;
            r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r34 = r0;
            r14 = r32.getMethod(r33, r34);	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r0 = r39;
            r0 = org.apache.cordova.filetransfer.FileTransfer.this;	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r33 = r0;
            r0 = r33;
            r0 = r0.webView;	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r33 = r0;
            r34 = 0;
            r0 = r34;
            r0 = new java.lang.Object[r0];	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r34 = r0;
            r0 = r33;
            r1 = r34;
            r33 = r14.invoke(r0, r1);	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r0 = r33;
            r0 = (org.apache.cordova.PluginManager) r0;	 Catch:{ NoSuchMethodException -> 0x0817, IllegalAccessException -> 0x0814, InvocationTargetException -> 0x0811 }
            r24 = r0;
        L_0x0414:
            if (r24 != 0) goto L_0x0436;
        L_0x0416:
            r33 = "pluginManager";
            r25 = r32.getField(r33);	 Catch:{ NoSuchFieldException -> 0x080e, IllegalAccessException -> 0x080b }
            r0 = r39;
            r0 = org.apache.cordova.filetransfer.FileTransfer.this;	 Catch:{ NoSuchFieldException -> 0x080e, IllegalAccessException -> 0x080b }
            r33 = r0;
            r0 = r33;
            r0 = r0.webView;	 Catch:{ NoSuchFieldException -> 0x080e, IllegalAccessException -> 0x080b }
            r33 = r0;
            r0 = r25;
            r1 = r33;
            r33 = r0.get(r1);	 Catch:{ NoSuchFieldException -> 0x080e, IllegalAccessException -> 0x080b }
            r0 = r33;
            r0 = (org.apache.cordova.PluginManager) r0;	 Catch:{ NoSuchFieldException -> 0x080e, IllegalAccessException -> 0x080b }
            r24 = r0;
        L_0x0436:
            r0 = r39;
            r0 = r0.val$resourceApi;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = r0;
            r0 = r39;
            r0 = r0.val$targetUri;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = r0;
            r11 = r33.mapUriToFile(r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = r0;
            r0 = r33;
            r0.targetFile = r11;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = "File";
            r0 = r24;
            r1 = r33;
            r13 = r0.getPlugin(r1);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r13 = (org.apache.cordova.file.FileUtils) r13;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            if (r13 == 0) goto L_0x06a7;
        L_0x045e:
            r12 = r13.getEntryForFile(r11);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            if (r12 == 0) goto L_0x0677;
        L_0x0464:
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = org.apache.cordova.PluginResult.Status.OK;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1, r12);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
        L_0x046f:
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x07dd }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x07dd }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x07dd }
            monitor-exit(r34);	 Catch:{ all -> 0x07dd }
            if (r7 == 0) goto L_0x04a5;
        L_0x0488:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x04a5;
        L_0x0490:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x04a5;
        L_0x0498:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x04a5:
            if (r30 != 0) goto L_0x04d0;
        L_0x04a7:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x04d0:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x04df:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x04df }
            throw r33;	 Catch:{ all -> 0x04e2 }
        L_0x04e2:
            r33 = move-exception;
        L_0x04e3:
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = r0;
            monitor-enter(r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x05e3 }
            r35 = r0;
            r36 = 0;
            r0 = r36;
            r1 = r35;
            r1.connection = r0;	 Catch:{ all -> 0x05e3 }
            monitor-exit(r34);	 Catch:{ all -> 0x05e3 }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r16);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            org.apache.cordova.filetransfer.FileTransfer.safeClose(r22);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            throw r33;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
        L_0x0500:
            r9 = move-exception;
        L_0x0501:
            r33 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;	 Catch:{ all -> 0x07e0 }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ all -> 0x07e0 }
            r34 = r0;
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ all -> 0x07e0 }
            r35 = r0;
            r0 = r33;
            r1 = r34;
            r2 = r35;
            r10 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r9);	 Catch:{ all -> 0x07e0 }
            r33 = "FileTransfer";
            r34 = r10.toString();	 Catch:{ all -> 0x07e0 }
            r0 = r33;
            r1 = r34;
            android.util.Log.e(r0, r1, r9);	 Catch:{ all -> 0x07e0 }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x07e0 }
            r33 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ all -> 0x07e0 }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1, r10);	 Catch:{ all -> 0x07e0 }
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x06c2 }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x06c2 }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x06c2 }
            monitor-exit(r34);	 Catch:{ all -> 0x06c2 }
            if (r7 == 0) goto L_0x0567;
        L_0x054a:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x0567;
        L_0x0552:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x0567;
        L_0x055a:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x0567:
            if (r30 != 0) goto L_0x0592;
        L_0x0569:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x0592:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x05a1:
            r33 = 0;
            r0 = r23;
            r1 = r33;
            r0.write(r4, r1, r5);	 Catch:{ all -> 0x05de }
            r34 = r16.getTotalRawBytesRead();	 Catch:{ all -> 0x05de }
            r0 = r26;
            r1 = r34;
            r0.setLoaded(r1);	 Catch:{ all -> 0x05de }
            r27 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x05de }
            r33 = org.apache.cordova.PluginResult.Status.OK;	 Catch:{ all -> 0x05de }
            r34 = r26.toJSONObject();	 Catch:{ all -> 0x05de }
            r0 = r27;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);	 Catch:{ all -> 0x05de }
            r33 = 1;
            r0 = r27;
            r1 = r33;
            r0.setKeepCallback(r1);	 Catch:{ all -> 0x05de }
            r0 = r39;
            r0 = r0.val$context;	 Catch:{ all -> 0x05de }
            r33 = r0;
            r0 = r33;
            r1 = r27;
            r0.sendPluginResult(r1);	 Catch:{ all -> 0x05de }
            goto L_0x0392;
        L_0x05de:
            r33 = move-exception;
            r22 = r23;
            goto L_0x04e3;
        L_0x05e3:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x05e3 }
            throw r33;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
        L_0x05e6:
            r9 = move-exception;
        L_0x05e7:
            r33 = "FileTransfer";
            r34 = r9.getMessage();	 Catch:{ all -> 0x07e0 }
            r0 = r33;
            r1 = r34;
            android.util.Log.e(r0, r1, r9);	 Catch:{ all -> 0x07e0 }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x07e0 }
            r33 = org.apache.cordova.PluginResult.Status.JSON_EXCEPTION;	 Catch:{ all -> 0x07e0 }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1);	 Catch:{ all -> 0x07e0 }
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x06c5 }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x06c5 }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x06c5 }
            monitor-exit(r34);	 Catch:{ all -> 0x06c5 }
            if (r7 == 0) goto L_0x0635;
        L_0x0618:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x0635;
        L_0x0620:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x0635;
        L_0x0628:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x0635:
            if (r30 != 0) goto L_0x0660;
        L_0x0637:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x0660:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x066f:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x066f }
            throw r33;	 Catch:{ FileNotFoundException -> 0x0672, IOException -> 0x0801, JSONException -> 0x07f7, Throwable -> 0x07ed, all -> 0x07e4 }
        L_0x0672:
            r9 = move-exception;
            r22 = r23;
            goto L_0x02d2;
        L_0x0677:
            r33 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = r0;
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r35 = r0;
            r36 = 0;
            r0 = r33;
            r1 = r34;
            r2 = r35;
            r3 = r36;
            r10 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = "FileTransfer";
            r34 = "File plugin cannot represent download path";
            android.util.Log.e(r33, r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1, r10);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            goto L_0x046f;
        L_0x06a7:
            r33 = "FileTransfer";
            r34 = "File plugin not found; cannot save downloaded file";
            android.util.Log.e(r33, r34);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r33 = org.apache.cordova.PluginResult.Status.ERROR;	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            r34 = "File plugin not found; cannot save downloaded file";
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);	 Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x0500, JSONException -> 0x05e6, Throwable -> 0x07ea }
            goto L_0x046f;
        L_0x06bf:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x06bf }
            throw r33;
        L_0x06c2:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x06c2 }
            throw r33;
        L_0x06c5:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x06c5 }
            throw r33;
        L_0x06c8:
            r9 = move-exception;
            r31 = r30;
        L_0x06cb:
            r33 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;	 Catch:{ all -> 0x07e0 }
            r0 = r39;
            r0 = r0.val$source;	 Catch:{ all -> 0x07e0 }
            r34 = r0;
            r0 = r39;
            r0 = r0.val$target;	 Catch:{ all -> 0x07e0 }
            r35 = r0;
            r0 = r33;
            r1 = r34;
            r2 = r35;
            r10 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r9);	 Catch:{ all -> 0x07e0 }
            r33 = "FileTransfer";
            r34 = r10.toString();	 Catch:{ all -> 0x07e0 }
            r0 = r33;
            r1 = r34;
            android.util.Log.e(r0, r1, r9);	 Catch:{ all -> 0x07e0 }
            r30 = new org.apache.cordova.PluginResult;	 Catch:{ all -> 0x07e0 }
            r33 = org.apache.cordova.PluginResult.Status.IO_EXCEPTION;	 Catch:{ all -> 0x07e0 }
            r0 = r30;
            r1 = r33;
            r0.<init>(r1, r10);	 Catch:{ all -> 0x07e0 }
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r33 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x076b }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x076b }
            r35 = r0;
            r0 = r33;
            r1 = r35;
            r0.remove(r1);	 Catch:{ all -> 0x076b }
            monitor-exit(r34);	 Catch:{ all -> 0x076b }
            if (r7 == 0) goto L_0x0731;
        L_0x0714:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r33 = r0;
            if (r33 == 0) goto L_0x0731;
        L_0x071c:
            r0 = r39;
            r0 = r0.val$useHttps;
            r33 = r0;
            if (r33 == 0) goto L_0x0731;
        L_0x0724:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x0731:
            if (r30 != 0) goto L_0x075c;
        L_0x0733:
            r30 = new org.apache.cordova.PluginResult;
            r33 = org.apache.cordova.PluginResult.Status.ERROR;
            r34 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r35 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r36 = r0;
            r37 = 0;
            r0 = r34;
            r1 = r35;
            r2 = r36;
            r3 = r37;
            r34 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r33;
            r2 = r34;
            r0.<init>(r1, r2);
        L_0x075c:
            r0 = r39;
            r0 = r0.val$context;
            r33 = r0;
            r0 = r33;
            r1 = r30;
            r0.sendPluginResult(r1);
            goto L_0x000e;
        L_0x076b:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x076b }
            throw r33;
        L_0x076e:
            r33 = move-exception;
        L_0x076f:
            r34 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;
            monitor-enter(r34);
            r35 = org.apache.cordova.filetransfer.FileTransfer.activeRequests;	 Catch:{ all -> 0x07da }
            r0 = r39;
            r0 = r0.val$objectId;	 Catch:{ all -> 0x07da }
            r36 = r0;
            r35.remove(r36);	 Catch:{ all -> 0x07da }
            monitor-exit(r34);	 Catch:{ all -> 0x07da }
            if (r7 == 0) goto L_0x07a1;
        L_0x0784:
            r0 = r39;
            r0 = r0.val$trustEveryone;
            r34 = r0;
            if (r34 == 0) goto L_0x07a1;
        L_0x078c:
            r0 = r39;
            r0 = r0.val$useHttps;
            r34 = r0;
            if (r34 == 0) goto L_0x07a1;
        L_0x0794:
            r15 = r7;
            r15 = (javax.net.ssl.HttpsURLConnection) r15;
            r0 = r20;
            r15.setHostnameVerifier(r0);
            r0 = r21;
            r15.setSSLSocketFactory(r0);
        L_0x07a1:
            if (r30 != 0) goto L_0x07cc;
        L_0x07a3:
            r30 = new org.apache.cordova.PluginResult;
            r34 = org.apache.cordova.PluginResult.Status.ERROR;
            r35 = org.apache.cordova.filetransfer.FileTransfer.CONNECTION_ERR;
            r0 = r39;
            r0 = r0.val$source;
            r36 = r0;
            r0 = r39;
            r0 = r0.val$target;
            r37 = r0;
            r38 = 0;
            r0 = r35;
            r1 = r36;
            r2 = r37;
            r3 = r38;
            r35 = org.apache.cordova.filetransfer.FileTransfer.createFileTransferError(r0, r1, r2, r7, r3);
            r0 = r30;
            r1 = r34;
            r2 = r35;
            r0.<init>(r1, r2);
        L_0x07cc:
            r0 = r39;
            r0 = r0.val$context;
            r34 = r0;
            r0 = r34;
            r1 = r30;
            r0.sendPluginResult(r1);
            throw r33;
        L_0x07da:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x07da }
            throw r33;
        L_0x07dd:
            r33 = move-exception;
            monitor-exit(r34);	 Catch:{ all -> 0x07dd }
            throw r33;
        L_0x07e0:
            r33 = move-exception;
            r30 = r31;
            goto L_0x076f;
        L_0x07e4:
            r33 = move-exception;
            r22 = r23;
            r30 = r31;
            goto L_0x076f;
        L_0x07ea:
            r9 = move-exception;
            goto L_0x06cb;
        L_0x07ed:
            r9 = move-exception;
            r22 = r23;
            goto L_0x06cb;
        L_0x07f2:
            r9 = move-exception;
            r31 = r30;
            goto L_0x05e7;
        L_0x07f7:
            r9 = move-exception;
            r22 = r23;
            goto L_0x05e7;
        L_0x07fc:
            r9 = move-exception;
            r31 = r30;
            goto L_0x0501;
        L_0x0801:
            r9 = move-exception;
            r22 = r23;
            goto L_0x0501;
        L_0x0806:
            r9 = move-exception;
            r31 = r30;
            goto L_0x02d2;
        L_0x080b:
            r33 = move-exception;
            goto L_0x0436;
        L_0x080e:
            r33 = move-exception;
            goto L_0x0436;
        L_0x0811:
            r33 = move-exception;
            goto L_0x0414;
        L_0x0814:
            r33 = move-exception;
            goto L_0x0414;
        L_0x0817:
            r33 = move-exception;
            goto L_0x0414;
        L_0x081a:
            r30 = r31;
            goto L_0x013d;
        L_0x081e:
            r30 = r31;
            goto L_0x046f;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.filetransfer.FileTransfer.4.run():void");
        }
    }

    /* renamed from: org.apache.cordova.filetransfer.FileTransfer.5 */
    class C03215 implements Runnable {
        private final /* synthetic */ RequestContext val$context;

        C03215(RequestContext requestContext) {
            this.val$context = requestContext;
        }

        public void run() {
            synchronized (this.val$context) {
                File file = this.val$context.targetFile;
                if (file != null) {
                    file.delete();
                }
                this.val$context.sendPluginResult(new PluginResult(Status.ERROR, FileTransfer.createFileTransferError(FileTransfer.ABORTED_ERR, this.val$context.source, this.val$context.target, null, Integer.valueOf(-1), null)));
                this.val$context.aborted = true;
                if (this.val$context.connection != null) {
                    this.val$context.connection.disconnect();
                }
            }
        }
    }

    private static class ExposedGZIPInputStream extends GZIPInputStream {
        public ExposedGZIPInputStream(InputStream in) throws IOException {
            super(in);
        }

        public Inflater getInflater() {
            return this.inf;
        }
    }

    private static final class RequestContext {
        boolean aborted;
        CallbackContext callbackContext;
        HttpURLConnection connection;
        String source;
        String target;
        File targetFile;

        RequestContext(String source, String target, CallbackContext callbackContext) {
            this.source = source;
            this.target = target;
            this.callbackContext = callbackContext;
        }

        void sendPluginResult(PluginResult pluginResult) {
            synchronized (this) {
                if (!this.aborted) {
                    this.callbackContext.sendPluginResult(pluginResult);
                }
            }
        }
    }

    private static abstract class TrackingInputStream extends FilterInputStream {
        public abstract long getTotalRawBytesRead();

        public TrackingInputStream(InputStream in) {
            super(in);
        }
    }

    private static class SimpleTrackingInputStream extends TrackingInputStream {
        private long bytesRead;

        public SimpleTrackingInputStream(InputStream stream) {
            super(stream);
            this.bytesRead = 0;
        }

        private int updateBytesRead(int newBytesRead) {
            if (newBytesRead != -1) {
                this.bytesRead += (long) newBytesRead;
            }
            return newBytesRead;
        }

        public int read() throws IOException {
            return updateBytesRead(super.read());
        }

        public int read(byte[] bytes, int offset, int count) throws IOException {
            return updateBytesRead(super.read(bytes, offset, count));
        }

        public long getTotalRawBytesRead() {
            return this.bytesRead;
        }
    }

    private static class TrackingGZIPInputStream extends TrackingInputStream {
        private ExposedGZIPInputStream gzin;

        public TrackingGZIPInputStream(ExposedGZIPInputStream gzin) throws IOException {
            super(gzin);
            this.gzin = gzin;
        }

        public long getTotalRawBytesRead() {
            return this.gzin.getInflater().getBytesRead();
        }
    }

    static {
        FILE_NOT_FOUND_ERR = 1;
        INVALID_URL_ERR = 2;
        CONNECTION_ERR = 3;
        ABORTED_ERR = 4;
        NOT_MODIFIED_ERR = 5;
        activeRequests = new HashMap();
        DO_NOT_VERIFY = new C03171();
        trustAllCerts = new TrustManager[]{new C03182()};
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("upload") || action.equals("download")) {
            String source = args.getString(0);
            String target = args.getString(1);
            if (action.equals("upload")) {
                upload(source, target, args, callbackContext);
                return true;
            }
            download(source, target, args, callbackContext);
            return true;
        } else if (!action.equals("abort")) {
            return false;
        } else {
            abort(args.getString(0));
            callbackContext.success();
            return true;
        }
    }

    private static void addHeadersToRequest(URLConnection connection, JSONObject headers) {
        try {
            Iterator<?> iter = headers.keys();
            while (iter.hasNext()) {
                String headerKey = iter.next().toString();
                JSONArray headerValues = headers.optJSONArray(headerKey);
                if (headerValues == null) {
                    headerValues = new JSONArray();
                    headerValues.put(headers.getString(headerKey));
                }
                connection.setRequestProperty(headerKey, headerValues.getString(0));
                for (int i = 1; i < headerValues.length(); i++) {
                    connection.addRequestProperty(headerKey, headerValues.getString(i));
                }
            }
        } catch (JSONException e) {
        }
    }

    private void upload(String source, String target, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject headers;
        Log.d(LOG_TAG, "upload " + source + " to " + target);
        String fileKey = getArgument(args, 2, "file");
        String fileName = getArgument(args, 3, "image.jpg");
        String mimeType = getArgument(args, 4, "image/jpeg");
        JSONObject params = args.optJSONObject(5) == null ? new JSONObject() : args.optJSONObject(5);
        boolean trustEveryone = args.optBoolean(6);
        boolean chunkedMode = args.optBoolean(7) || args.isNull(7);
        if (args.optJSONObject(8) == null) {
            headers = params.optJSONObject("headers");
        } else {
            headers = args.optJSONObject(8);
        }
        String objectId = args.getString(9);
        String httpMethod = getArgument(args, 10, "POST");
        CordovaResourceApi resourceApi = this.webView.getResourceApi();
        Log.d(LOG_TAG, "fileKey: " + fileKey);
        Log.d(LOG_TAG, "fileName: " + fileName);
        Log.d(LOG_TAG, "mimeType: " + mimeType);
        Log.d(LOG_TAG, "params: " + params);
        Log.d(LOG_TAG, "trustEveryone: " + trustEveryone);
        Log.d(LOG_TAG, "chunkedMode: " + chunkedMode);
        Log.d(LOG_TAG, "headers: " + headers);
        Log.d(LOG_TAG, "objectId: " + objectId);
        Log.d(LOG_TAG, "httpMethod: " + httpMethod);
        Uri targetUri = resourceApi.remapUri(Uri.parse(target));
        Uri tmpSrc = Uri.parse(source);
        if (tmpSrc.getScheme() == null) {
            tmpSrc = Uri.fromFile(new File(source));
        }
        Uri sourceUri = resourceApi.remapUri(tmpSrc);
        int uriType = CordovaResourceApi.getUriType(targetUri);
        boolean useHttps = uriType == 6;
        if (uriType == 5 || useHttps) {
            RequestContext context = new RequestContext(source, target, callbackContext);
            synchronized (activeRequests) {
                activeRequests.put(objectId, context);
            }
            this.cordova.getThreadPool().execute(new C03193(context, objectId, trustEveryone, useHttps, resourceApi, targetUri, httpMethod, target, headers, params, fileKey, fileName, mimeType, sourceUri, chunkedMode, source));
            return;
        }
        JSONObject error = createFileTransferError(INVALID_URL_ERR, source, target, null, Integer.valueOf(0), false);
        Log.e(LOG_TAG, "Unsupported URI: " + targetUri);
        callbackContext.sendPluginResult(new PluginResult(Status.IO_EXCEPTION, error));
    }

    private static void safeClose(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
            }
        }
    }

    private static TrackingInputStream getInputStream(URLConnection conn) throws IOException {
        String encoding = conn.getContentEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase("gzip")) {
            return new SimpleTrackingInputStream(conn.getInputStream());
        }
        return new TrackingGZIPInputStream(new ExposedGZIPInputStream(conn.getInputStream()));
    }

    private static SSLSocketFactory trustAllHosts(HttpsURLConnection connection) {
        SSLSocketFactory oldFactory = connection.getSSLSocketFactory();
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            connection.setSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
        return oldFactory;
    }

    private static JSONObject createFileTransferError(int errorCode, String source, String target, URLConnection connection, Throwable throwable) {
        int httpStatus = 0;
        StringBuilder bodyBuilder = new StringBuilder();
        String body = null;
        if (connection != null) {
            BufferedReader reader;
            try {
                if (connection instanceof HttpURLConnection) {
                    httpStatus = ((HttpURLConnection) connection).getResponseCode();
                    InputStream err = ((HttpURLConnection) connection).getErrorStream();
                    if (err != null) {
                        reader = new BufferedReader(new InputStreamReader(err, "UTF-8"));
                        String line = reader.readLine();
                        while (line != null) {
                            bodyBuilder.append(line);
                            line = reader.readLine();
                            if (line != null) {
                                bodyBuilder.append('\n');
                            }
                        }
                        body = bodyBuilder.toString();
                        reader.close();
                    }
                }
            } catch (Throwable e) {
                Log.w(LOG_TAG, "Error getting HTTP status code from connection.", e);
            }
        }
        return createFileTransferError(errorCode, source, target, body, Integer.valueOf(httpStatus), throwable);
    }

    private static JSONObject createFileTransferError(int errorCode, String source, String target, String body, Integer httpStatus, Throwable throwable) {
        JSONException e;
        JSONObject error = null;
        try {
            JSONObject error2 = new JSONObject();
            try {
                error2.put("code", errorCode);
                error2.put("source", source);
                error2.put("target", target);
                if (body != null) {
                    error2.put("body", body);
                }
                if (httpStatus != null) {
                    error2.put("http_status", httpStatus);
                }
                if (throwable == null) {
                    return error2;
                }
                String msg = throwable.getMessage();
                if (msg == null || "".equals(msg)) {
                    msg = throwable.toString();
                }
                error2.put("exception", msg);
                return error2;
            } catch (JSONException e2) {
                e = e2;
                error = error2;
                Log.e(LOG_TAG, e.getMessage(), e);
                return error;
            }
        } catch (JSONException e3) {
            e = e3;
            Log.e(LOG_TAG, e.getMessage(), e);
            return error;
        }
    }

    private static String getArgument(JSONArray args, int position, String defaultString) {
        String arg = defaultString;
        if (args.length() <= position) {
            return arg;
        }
        arg = args.optString(position);
        if (arg == null || "null".equals(arg)) {
            return defaultString;
        }
        return arg;
    }

    private void download(String source, String target, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(LOG_TAG, "download " + source + " to " + target);
        CordovaResourceApi resourceApi = this.webView.getResourceApi();
        boolean trustEveryone = args.optBoolean(2);
        String objectId = args.getString(3);
        JSONObject headers = args.optJSONObject(4);
        Uri sourceUri = resourceApi.remapUri(Uri.parse(source));
        Uri tmpTarget = Uri.parse(target);
        if (tmpTarget.getScheme() == null) {
            tmpTarget = Uri.fromFile(new File(target));
        }
        Uri targetUri = resourceApi.remapUri(tmpTarget);
        int uriType = CordovaResourceApi.getUriType(sourceUri);
        boolean useHttps = uriType == 6;
        boolean isLocalTransfer = (useHttps || uriType == 5) ? false : true;
        if (uriType == -1) {
            JSONObject error = createFileTransferError(INVALID_URL_ERR, source, target, null, Integer.valueOf(0), false);
            Log.e(LOG_TAG, "Unsupported URI: " + targetUri);
            callbackContext.sendPluginResult(new PluginResult(Status.IO_EXCEPTION, error));
        } else if (isLocalTransfer || Config.isUrlWhiteListed(source)) {
            RequestContext context = new RequestContext(source, target, callbackContext);
            synchronized (activeRequests) {
                activeRequests.put(objectId, context);
            }
            this.cordova.getThreadPool().execute(new C03204(context, objectId, trustEveryone, useHttps, source, target, resourceApi, targetUri, sourceUri, isLocalTransfer, headers));
        } else {
            Log.w(LOG_TAG, "Source URL is not in white list: '" + source + "'");
            callbackContext.sendPluginResult(new PluginResult(Status.IO_EXCEPTION, createFileTransferError(CONNECTION_ERR, source, target, null, Integer.valueOf(MKeyEvent.KEYCODE_HAIER_TASK), false)));
        }
    }

    private void abort(String objectId) {
        synchronized (activeRequests) {
            RequestContext context = (RequestContext) activeRequests.remove(objectId);
        }
        if (context != null) {
            this.cordova.getThreadPool().execute(new C03215(context));
        }
    }
}
