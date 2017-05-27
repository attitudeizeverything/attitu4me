package com.pickcel.agent;

import android.os.AsyncTask;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import jcifs.https.Handler;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class RequestTask extends AsyncTask<String, String, String> {
    static TrustManager[] trustAllCerts;
    int currentVersion;
    String downloadPath;
    String updatedVersion;

    /* renamed from: com.pickcel.agent.RequestTask.1 */
    class C02541 implements X509TrustManager {
        C02541() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }

    public RequestTask(int currentVersion, String downloadPath) {
        this.currentVersion = currentVersion;
        this.downloadPath = downloadPath;
    }

    protected String doInBackground(String... uri) {
        try {
            HttpResponse response = createHttpClient().execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                String responseString = out.toString();
                out.close();
                return responseString;
            }
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        } catch (ClientProtocolException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public void onPostExecute(String result) {
        super.onPostExecute(result);
        this.updatedVersion = result;
        int latestVersion = Integer.parseInt(this.updatedVersion);
        if (latestVersion > this.currentVersion) {
            File file = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Download/").append("Pickcel").append(latestVersion).append(".apk").toString());
            if (file.exists()) {
                file.delete();
            }
            this.downloadPath += "/downloads/pickcelv" + latestVersion + ".apk";
            new UpdateApp(latestVersion).execute(new String[]{this.downloadPath});
        }
    }

    public static HttpClient createHttpClient() {
        try {
            KeyStore.getInstance(KeyStore.getDefaultType()).load(null, null);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, "UTF-8");
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Handler.DEFAULT_HTTPS_PORT));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(params, registry), params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    static {
        trustAllCerts = new TrustManager[]{new C02541()};
    }
}
