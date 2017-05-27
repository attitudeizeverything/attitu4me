package com.pickcel.agent;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

class sendScreenShot extends AsyncTask<String, Void, String> {
    String deviceId;
    String randomNumber;
    String url;

    public sendScreenShot(String deviceId, String random_number, String url) {
        this.deviceId = deviceId;
        this.randomNumber = random_number;
        this.url = url;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... params) {
        fileUpload();
        return "sResponse";
    }

    private void fileUpload() {
        ContentBody contentFile = new FileBody(new File(Environment.getExternalStorageDirectory(), "screen_shot.png"));
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            Log.e("url ", "url " + this.url);
            HttpPost httpPost = new HttpPost(this.url + "/snapshot_upload/");
            MultipartEntity entity = new MultipartEntity();
            entity.addPart("device_id", new StringBody(this.deviceId));
            entity.addPart("random_number", new StringBody(this.randomNumber));
            entity.addPart("type", new StringBody("scrnshot"));
            entity.addPart("userfile", contentFile);
            httpPost.setEntity(entity);
            System.out.println("Server Responded: " + httpClient.execute(httpPost, localContext).getStatusLine().getStatusCode());
            httpClient.getConnectionManager().shutdown();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            Log.e(e2.getClass().getName(), e2.getMessage(), e2);
        }
    }
}
