package com.pickcel.agent;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UpdateApp extends AsyncTask<String, String, String> {
    private static final String GET_PROP_COMMAND = "getprop service.adb.tcp.port";
    private static final String SET_PROP_COMMAND_OFF = "setprop service.adb.tcp.port -1";
    private static final String SET_PROP_COMMAND_ON = "setprop service.adb.tcp.port 5555";
    private static final String START_ADBD_COMMAND = "start adbd";
    private static final String STOP_ADBD_COMMAND = "stop adbd";
    private boolean installing;
    int latestVersion;
    TrustManager[] trustAllCerts;

    /* renamed from: com.pickcel.agent.UpdateApp.1 */
    class C02551 implements X509TrustManager {
        C02551() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }

    public UpdateApp(int latestVersion) {
        this.installing = false;
        this.trustAllCerts = new TrustManager[]{new C02551()};
        this.latestVersion = latestVersion;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... f_url) {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, this.trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            URL url = new URL(f_url[0]);
            url.openConnection().connect();
            InputStream input = new BufferedInputStream(url.openStream(), HTTPSession.BUFSIZE);
            OutputStream output = new FileOutputStream(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Download/").append("Pickcel").append(this.latestVersion).append(".apk").toString());
            byte[] data = new byte[HttpTransport.DEFAULT_CHUNK_LENGTH];
            long total = 0;
            while (true) {
                int count = input.read(data);
                if (count == -1) {
                    break;
                }
                total += (long) count;
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
        }
        return null;
    }

    protected void onProgressUpdate(String... progress) {
    }

    protected void onPostExecute(String file_url) {
        if (!this.installing) {
            this.installing = true;
            enableDebug();
        }
    }

    private void enableDebug() {
        String command = SET_PROP_COMMAND_ON;
        try {
            RootTools.getShell(true).add(new CommandCapture(0, SET_PROP_COMMAND_ON));
            RootTools.getShell(true).add(new CommandCapture(0, STOP_ADBD_COMMAND));
            RootTools.getShell(true).add(new CommandCapture(0, START_ADBD_COMMAND));
            rootIt();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e2) {
            e2.printStackTrace();
        } catch (RootDeniedException e3) {
            e3.printStackTrace();
        }
    }

    private void update() {
        String cmnd1 = "adb connect localhost";
        String cmnd2 = "adb install -r " + new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Download/").append("Pickcel").append(this.latestVersion).append(".apk").toString();
        try {
            Runtime.getRuntime().exec(new String[]{"su", "-c", cmnd1}).waitFor();
            Process proc2 = Runtime.getRuntime().exec(new String[]{"su", "-c", cmnd2});
            this.installing = false;
            proc2.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public boolean rootIt() {
        try {
            Process suProcess = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());
            DataInputStream osRes = new DataInputStream(suProcess.getInputStream());
            if (os == null || osRes == null) {
                return false;
            }
            boolean retval;
            boolean exitSu;
            os.writeBytes("id\n");
            os.flush();
            String currUid = osRes.readLine();
            if (currUid == null) {
                retval = false;
                exitSu = false;
                Log.d("ROOT", "Can't get root access or denied by user");
            } else if (currUid.contains("uid=0")) {
                retval = true;
                exitSu = true;
                Log.e("ROOT", "Root access granted");
                update();
            } else {
                retval = false;
                exitSu = true;
                Log.d("ROOT", "Root access rejected: " + currUid);
            }
            if (!exitSu) {
                return retval;
            }
            os.writeBytes("exit\n");
            os.flush();
            return retval;
        } catch (Exception e) {
            Log.d("ROOT", "Root access rejected [" + e.getClass().getName() + "] : " + e.getMessage());
            return false;
        }
    }
}
