package com.pickcel.agent;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.mstar.android.tv.TvCommonManager;
import com.mstar.android.tvapi.common.PictureManager;
import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import com.squareup.okhttp.internal.http.HttpTransport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import softwinner.tv.TVDecoder;

public class Pickcel extends Activity implements CordovaInterface, Callback, SurfaceTextureListener {
    private String TAG;
    private boolean add;
    private String advertisementUrl;
    private AudioManager audioManager;
    private String authCode;
    private String cId;
    private String cId2;
    RelativeLayout color_layout;
    SharedPreferences colorset_prf;
    private JSONArray content;
    private JSONArray content2;
    private int contentIndex;
    private int contentIndex2;
    int contrast_value;
    private CordovaWebView cordova_webview;
    SimpleDateFormat dateFormatForContent;
    SimpleDateFormat dateFormatForContent2;
    View decorView;
    private String engagementFileSet;
    private String engagementUrl;
    private JSONArray entertainmentUrls;
    StretchVideoView entertainmentVideo;
    File[] fileLst;
    File[] fileLst1;
    private String fileNameIsPlaying;
    private String fileNameIsPlaying2;
    int g_height;
    int g_width;
    private int hour;
    int hue_value;
    ImageView imageView;
    ImageView imageView2;
    private boolean isShowHDMI;
    private boolean is_ip_tv;
    private boolean is_portrait;
    private boolean is_tv_hdmi_started;
    private boolean is_tv_started;
    private boolean is_usb;
    private boolean is_web_app_loaded;
    File latestFile;
    File latestFile1;
    int luma_value;
    private SurfaceHolder mHolder;
    private MediaPlayer mMediaPlayer;
    private OnErrorListener mOnErrorListener;
    private OnErrorListener mOnErrorListener2;
    int maxFiles;
    File newFile;
    File newFile1;
    File newFolder;
    File newFolder1;
    private boolean playingImage;
    private boolean playingImage2;
    private boolean playingVideo;
    private int position;
    RelativeLayout rl;
    int saturation_value;
    NativeRss scrollText;
    TimerTask sendScreenShot;
    SurfaceView sfv;
    private boolean startContent;
    private boolean startContent2;
    private String startTimeForContent;
    private String startTimeForContent2;
    private boolean startTimer;
    TextureView stv;
    private final ExecutorService threadPool;
    private String timeZone;
    TimerTask timer;
    TimerTask timer2;
    TimerTask timerTast;
    private TVDecoder tv;
    int tv_x;
    int tv_y;
    int uiOptions;
    private String uri;
    private String url;
    Uri urlToPlay;
    private String usb_path;
    StretchVideoView video;
    StretchVideoView video2;
    int video_idx;
    List<Uri> video_urls;
    TimerTask ytubeRestart;

    /* renamed from: com.pickcel.agent.Pickcel.10 */
    class AnonymousClass10 implements Runnable {
        private final /* synthetic */ boolean val$boolean1;
        private final /* synthetic */ String val$type;

        /* renamed from: com.pickcel.agent.Pickcel.10.1 */
        class C02431 implements Runnable {
            C02431() {
            }

            public void run() {
                Pickcel.this.reboot_device();
            }
        }

        AnonymousClass10(String str, boolean z) {
            this.val$type = str;
            this.val$boolean1 = z;
        }

        public void run() {
            if (this.val$type.equals("reboot_display")) {
                Pickcel.this.reboot_device();
            } else if (this.val$type.equals("soft_reset")) {
                Pickcel.this.clear_cache();
                Pickcel.this.stopYoutubeView();
            } else if (this.val$type.equals("hard_reset") && !this.val$boolean1) {
                Pickcel.this.delete_dir();
            } else if (this.val$type.equals("hard_reset") && this.val$boolean1) {
                Pickcel.this.delete_dir();
                new Handler().postDelayed(new C02431(), 1000);
            }
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.11 */
    class AnonymousClass11 implements Runnable {
        private final /* synthetic */ boolean val$boolean1;

        AnonymousClass11(boolean z) {
            this.val$boolean1 = z;
        }

        public void run() {
            if (this.val$boolean1) {
                int currentHour = Calendar.getInstance().get(10);
                if (Pickcel.this.hour == 12) {
                    Pickcel.this.hour = 0;
                }
                if (Pickcel.this.hour < currentHour) {
                    Pickcel.this.hour = currentHour;
                    new RequestTask(Pickcel.this.getVersionCode(), Pickcel.this.url).execute(new String[]{new StringBuilder(String.valueOf(Pickcel.this.url)).append("/getpickcelversion/").toString()});
                    return;
                }
                return;
            }
            Pickcel.this.freeMemory();
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.12 */
    class AnonymousClass12 implements Runnable {
        private final /* synthetic */ String val$backgroundColor;
        private final /* synthetic */ String val$rss;
        private final /* synthetic */ int val$speed;
        private final /* synthetic */ double val$startPosition;
        private final /* synthetic */ String val$textColor;
        private final /* synthetic */ int val$textSize;
        private final /* synthetic */ String val$textStyle;
        private final /* synthetic */ double val$x;
        private final /* synthetic */ double val$y;
        private final /* synthetic */ double val$zoneHeight;

        AnonymousClass12(double d, double d2, double d3, double d4, String str, String str2, int i, String str3, int i2, String str4) {
            this.val$x = d;
            this.val$y = d2;
            this.val$startPosition = d3;
            this.val$zoneHeight = d4;
            this.val$textColor = str;
            this.val$backgroundColor = str2;
            this.val$textSize = i;
            this.val$rss = str3;
            this.val$speed = i2;
            this.val$textStyle = str4;
        }

        public void run() {
            double y1;
            Pickcel.this.decorView.setSystemUiVisibility(Pickcel.this.uiOptions);
            double d = (double) Pickcel.this.g_width;
            double x1 = (this.val$x / 100.0d) * r0;
            if (this.val$y > 20.0d) {
                d = (double) Pickcel.this.g_height;
                y1 = ((this.val$y + 2.6d) / 100.0d) * r0;
            } else {
                d = (double) Pickcel.this.g_height;
                y1 = ((this.val$y + 1.6d) / 100.0d) * r0;
            }
            d = (double) Pickcel.this.g_width;
            double startPosition1 = (this.val$startPosition / 100.0d) * r0;
            d = (double) Pickcel.this.g_height;
            double zoneHeight1 = (this.val$zoneHeight / 100.0d) * r0;
            d = (double) Pickcel.this.g_width;
            long width = Math.round(((this.val$startPosition - this.val$x) / 100.0d) * r0);
            long height = Math.round(zoneHeight1);
            long startPosition = Math.round(startPosition1);
            Pickcel.this.scrollText.setX((float) Math.round(x1));
            Pickcel.this.scrollText.setY((float) Math.round(y1));
            Pickcel.this.scrollText.setTextColor(Color.parseColor(this.val$textColor));
            Pickcel.this.scrollText.setBackgroundColor(Color.parseColor(this.val$backgroundColor));
            Pickcel.this.scrollText.setTextSize((float) this.val$textSize);
            Pickcel.this.scrollText.setMinWidth(Math.round((float) width));
            Pickcel.this.scrollText.setMaxWidth(Math.round((float) width));
            Pickcel.this.scrollText.setMinHeight(Math.round((float) height));
            Pickcel.this.scrollText.setMaxHeight(Math.round((float) height));
            Pickcel.this.scrollText.setSpeed(this.val$rss.length() * (this.val$speed * 100));
            Pickcel.this.scrollText.setStartPosition(-Math.round((float) startPosition));
            Pickcel.this.scrollText.setText(this.val$rss);
            Typeface font = Typeface.SANS_SERIF;
            if (this.val$textStyle.equals("BOLD")) {
                Pickcel.this.scrollText.setTypeface(font, 1);
            }
            if (this.val$textStyle.equals("ITALIC")) {
                Pickcel.this.scrollText.setTypeface(font, 2);
            }
            if (this.val$textStyle.equals("BOLD_ITALIC")) {
                Pickcel.this.scrollText.setTypeface(font, 3);
            }
            if (this.val$textStyle.equals("NORMAL")) {
                Pickcel.this.scrollText.setTypeface(font, 0);
            }
            Pickcel.this.scrollText.setVisibility(0);
            Pickcel.this.scrollText.startScroll();
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.14 */
    class AnonymousClass14 implements Runnable {
        private final /* synthetic */ JSONArray val$cntnt;
        private final /* synthetic */ double val$height;
        private final /* synthetic */ double val$width;
        private final /* synthetic */ double val$x;
        private final /* synthetic */ double val$y;

        AnonymousClass14(JSONArray jSONArray, double d, double d2, double d3, double d4) {
            this.val$cntnt = jSONArray;
            this.val$x = d;
            this.val$y = d2;
            this.val$width = d3;
            this.val$height = d4;
        }

        public void run() {
            Pickcel.this.decorView.setSystemUiVisibility(Pickcel.this.uiOptions);
            Pickcel.this.stopContent();
            Pickcel pickcel = Pickcel.this;
            pickcel.video_urls = new ArrayList();
            Pickcel.this.contentIndex = 0;
            Pickcel.this.position = 0;
            Pickcel.this.video_idx = 0;
            Pickcel.this.add = false;
            int i = 0;
            while (true) {
                if (i >= this.val$cntnt.length()) {
                    break;
                }
                try {
                    if (this.val$cntnt.getJSONObject(i).getString("type").equals("image")) {
                        Pickcel.this.add = true;
                    } else {
                        if (this.val$cntnt.getJSONObject(i).getString("type").equals("video")) {
                            Pickcel.this.add = true;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
            double d = this.val$x;
            double x1 = (r0 / 100.0d) * ((double) Pickcel.this.g_width);
            d = this.val$y;
            double y1 = (r0 / 100.0d) * ((double) Pickcel.this.g_height);
            d = this.val$width;
            double width1 = (r0 / 100.0d) * ((double) Pickcel.this.g_width);
            d = this.val$height;
            double height1 = ((r0 + 2.7d) / 100.0d) * ((double) Pickcel.this.g_height);
            long width = Math.round(width1);
            long height = Math.round(height1);
            Pickcel.this.video.setX((float) Math.round(x1));
            Pickcel.this.video.setY((float) Math.round(y1));
            Pickcel.this.video.setWidth(Math.round((float) width));
            Pickcel.this.video.setHeight(Math.round((float) height));
            Pickcel.this.entertainmentVideo.setX((float) Math.round(x1));
            Pickcel.this.entertainmentVideo.setY((float) Math.round(y1));
            Pickcel.this.entertainmentVideo.setWidth(Math.round((float) width));
            Pickcel.this.entertainmentVideo.setHeight(Math.round((float) height));
            Pickcel.this.imageView.setX((float) Math.round(x1));
            Pickcel.this.imageView.setY((float) Math.round(y1));
            LayoutParams layoutParams = Pickcel.this.imageView.getLayoutParams();
            layoutParams.width = Math.round((float) width);
            layoutParams = Pickcel.this.imageView.getLayoutParams();
            layoutParams.height = Math.round((float) height);
            Pickcel.this.imageView.setMaxWidth(Math.round((float) width));
            Pickcel.this.imageView.setMaxHeight(Math.round((float) height));
            Pickcel.this.imageView.setMinimumHeight(Math.round((float) height));
            if (Pickcel.this.is_usb) {
                if (Pickcel.this.usb_path.endsWith("pickcel_usb/")) {
                    File dir = new File(Pickcel.this.usb_path);
                    if (dir.exists()) {
                        JSONArray jsArray = null;
                        try {
                            jsArray = new JSONArray(dir.list());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        Pickcel.this.entertainmentUrls = jsArray;
                    }
                }
            }
            if (Pickcel.this.entertainmentUrls != null) {
                if (Pickcel.this.entertainmentUrls.length() != 0) {
                    i = 0;
                    while (true) {
                        if (i >= Pickcel.this.entertainmentUrls.length()) {
                            break;
                        }
                        try {
                            Pickcel.this.video_urls.add(Uri.parse(Pickcel.this.entertainmentUrls.getString(i)));
                        } catch (JSONException e22) {
                            e22.printStackTrace();
                        }
                        i++;
                    }
                }
            }
            Pickcel.this.content = this.val$cntnt;
            Pickcel.this.playMedia();
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.18 */
    class AnonymousClass18 implements Runnable {
        private final /* synthetic */ JSONArray val$cntnt;
        private final /* synthetic */ double val$height;
        private final /* synthetic */ double val$width;
        private final /* synthetic */ double val$x;
        private final /* synthetic */ double val$y;

        AnonymousClass18(double d, double d2, double d3, double d4, JSONArray jSONArray) {
            this.val$x = d;
            this.val$y = d2;
            this.val$width = d3;
            this.val$height = d4;
            this.val$cntnt = jSONArray;
        }

        public void run() {
            Pickcel.this.decorView.setSystemUiVisibility(Pickcel.this.uiOptions);
            Pickcel.this.stopContentInZoneTwo();
            Pickcel.this.contentIndex2 = 0;
            double x1 = (this.val$x / 100.0d) * ((double) Pickcel.this.g_width);
            double y1 = (this.val$y / 100.0d) * ((double) Pickcel.this.g_height);
            double width1 = (this.val$width / 100.0d) * ((double) Pickcel.this.g_width);
            double height1 = ((this.val$height + 2.7d) / 100.0d) * ((double) Pickcel.this.g_height);
            long width = Math.round(width1);
            long height = Math.round(height1);
            Pickcel.this.video2.setX((float) Math.round(x1));
            Pickcel.this.video2.setY((float) Math.round(y1));
            Pickcel.this.video2.setWidth(Math.round((float) width));
            Pickcel.this.video2.setHeight(Math.round((float) height));
            Pickcel.this.imageView2.setX((float) Math.round(x1));
            Pickcel.this.imageView2.setY((float) Math.round(y1));
            Pickcel.this.imageView2.getLayoutParams().width = Math.round((float) width);
            Pickcel.this.imageView2.getLayoutParams().height = Math.round((float) height);
            Pickcel.this.imageView2.setMaxWidth(Math.round((float) width));
            Pickcel.this.imageView2.setMaxHeight(Math.round((float) height));
            Pickcel.this.imageView2.setMinimumHeight(Math.round((float) height));
            Pickcel.this.content2 = this.val$cntnt;
            Pickcel.this.playMediaInZoneTwo();
            Pickcel.this.playBackfunctionInZoneTwo();
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.1 */
    class C02441 implements OnErrorListener {
        C02441() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            Pickcel.this.stopContentForEntertainment();
            if (!Pickcel.this.is_usb) {
                Pickcel.this.errorWhilePlaying(Pickcel.this.engagementUrl, true);
            }
            if (Pickcel.this.add) {
                Pickcel.this.contentIndex = (Pickcel.this.contentIndex + 1) % Pickcel.this.content.length();
                Pickcel.this.playMedia();
            }
            return true;
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.22 */
    class AnonymousClass22 implements Runnable {
        private final /* synthetic */ double val$height;
        private final /* synthetic */ double val$width;
        private final /* synthetic */ double val$x;
        private final /* synthetic */ double val$y;

        AnonymousClass22(double d, double d2, double d3, double d4) {
            this.val$x = d;
            this.val$y = d2;
            this.val$width = d3;
            this.val$height = d4;
        }

        public void run() {
            Pickcel.this.showTv(this.val$x, this.val$y, this.val$width, this.val$height);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.26 */
    class AnonymousClass26 extends TimerTask {
        private final /* synthetic */ String val$url;

        AnonymousClass26(String str) {
            this.val$url = str;
        }

        public void run() {
            Intent intent = new Intent(Pickcel.this.getApplicationContext(), YoutubeView.class);
            Bundle b = new Bundle();
            b.putString("url_path", this.val$url);
            intent.putExtras(b);
            Pickcel.this.startActivity(intent);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.27 */
    class AnonymousClass27 implements Runnable {
        private final /* synthetic */ double val$height;
        private final /* synthetic */ String val$url;
        private final /* synthetic */ double val$width;
        private final /* synthetic */ double val$x;
        private final /* synthetic */ double val$y;

        AnonymousClass27(double d, double d2, double d3, double d4, String str) {
            this.val$x = d;
            this.val$y = d2;
            this.val$width = d3;
            this.val$height = d4;
            this.val$url = str;
        }

        public void run() {
            if (Pickcel.this.video.isPlaying()) {
                Pickcel.this.video.stopPlayback();
                Pickcel.this.video.setVisibility(8);
            }
            double x1 = (this.val$x / 100.0d) * ((double) Pickcel.this.g_width);
            double y1 = (this.val$y / 100.0d) * ((double) Pickcel.this.g_height);
            double width1 = (this.val$width / 100.0d) * ((double) Pickcel.this.g_width);
            double height1 = ((this.val$height + 2.7d) / 100.0d) * ((double) Pickcel.this.g_height);
            long width = Math.round(width1);
            long height = Math.round(height1);
            Pickcel.this.video.setX((float) Math.round(x1));
            Pickcel.this.video.setY((float) Math.round(y1));
            Pickcel.this.video.setWidth(Math.round((float) width));
            Pickcel.this.video.setHeight(Math.round((float) height));
            Pickcel.this.stream(this.val$url);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.28 */
    class AnonymousClass28 extends TimerTask {
        private final /* synthetic */ String val$device_uuid;
        private final /* synthetic */ String val$randomNumber;

        AnonymousClass28(String str, String str2) {
            this.val$device_uuid = str;
            this.val$randomNumber = str2;
        }

        public void run() {
            new sendScreenShot(this.val$device_uuid, this.val$randomNumber, Pickcel.this.url).execute(new String[0]);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.2 */
    class C02452 implements OnErrorListener {
        C02452() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            Pickcel.this.errorWhilePlaying(Pickcel.this.advertisementUrl, false);
            return true;
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.3 */
    class C02463 implements OnCompletionListener {
        C02463() {
        }

        public void onCompletion(MediaPlayer mp) {
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.4 */
    class C02474 implements OnCompletionListener {
        C02474() {
        }

        public void onCompletion(MediaPlayer mp) {
            if (new File(Pickcel.this.fileNameIsPlaying2).exists()) {
                Pickcel.this.video2.setVideoPath(Pickcel.this.fileNameIsPlaying2);
                Pickcel.this.video2.setVisibility(0);
                Pickcel.this.video2.start();
                Pickcel.this.startTimeForContent2 = Pickcel.this.dateFormatForContent2.format(new Date());
                Pickcel.this.video2.setOnErrorListener(Pickcel.this.mOnErrorListener2);
            }
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.5 */
    class C02485 implements OnCompletionListener {
        C02485() {
        }

        public void onCompletion(MediaPlayer mp) {
            Pickcel.this.video_idx = (Pickcel.this.video_idx + 1) % Pickcel.this.video_urls.size();
            Pickcel.this.urlToPlay = (Uri) Pickcel.this.video_urls.get(Pickcel.this.video_idx);
            Pickcel.this.engagementUrl = Pickcel.this.urlToPlay.toString();
            String fileName = Pickcel.this.urlToPlay.toString().substring(Pickcel.this.urlToPlay.toString().lastIndexOf("/") + 1);
            Pickcel.this.engagementFileSet = fileName;
            if (Pickcel.this.is_usb) {
                fileName = new StringBuilder(String.valueOf(Pickcel.this.usb_path)).append(fileName).toString();
            } else {
                fileName = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).toString();
            }
            if (new File(fileName).exists()) {
                Pickcel.this.entertainmentVideo.setVideoPath(fileName);
                Pickcel.this.entertainmentVideo.setVisibility(0);
                Pickcel.this.entertainmentVideo.start();
                Pickcel.this.entertainmentVideo.setOnErrorListener(Pickcel.this.mOnErrorListener);
                return;
            }
            Pickcel.this.video_idx = (Pickcel.this.video_idx + 1) % Pickcel.this.video_urls.size();
            Pickcel.this.stopContentForEntertainment();
            if (Pickcel.this.add) {
                Pickcel.this.contentIndex = (Pickcel.this.contentIndex + 1) % Pickcel.this.content.length();
                Pickcel.this.playMedia();
            }
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.6 */
    class C02496 implements Runnable {
        private final /* synthetic */ String val$uri;

        C02496(String str) {
            this.val$uri = str;
        }

        public void run() {
            Pickcel.this.load_url(this.val$uri);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.7 */
    class C02507 implements Runnable {
        private final /* synthetic */ int val$height;
        private final /* synthetic */ int val$width;

        C02507(int i, int i2) {
            this.val$width = i;
            this.val$height = i2;
        }

        public void run() {
            if (Pickcel.this.sfv.getParent() != null) {
                Pickcel.this.rl.removeView(Pickcel.this.sfv);
                Pickcel.this.tvd_disconnect();
            }
            Pickcel.this.rl.addView(Pickcel.this.sfv, this.val$width, this.val$height);
            Pickcel.this.sfv.setX((float) Pickcel.this.tv_x);
            Pickcel.this.sfv.setY((float) Pickcel.this.tv_y);
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.8 */
    class C02518 implements Runnable {
        C02518() {
        }

        public void run() {
            if (Pickcel.this.is_tv_started) {
                Pickcel.this.rl.removeView(Pickcel.this.sfv);
                Pickcel.this.tvd_disconnect();
                Pickcel.this.is_tv_started = false;
            }
        }
    }

    /* renamed from: com.pickcel.agent.Pickcel.9 */
    class C02529 implements Runnable {
        C02529() {
        }

        public void run() {
            Pickcel.this.stopContent();
            Pickcel.this.stopContentInZoneTwo();
            File dir = new File(Environment.getExternalStorageDirectory() + "/pickcel/");
            if (dir.isDirectory()) {
                String[] children = dir.list();
                for (String file : children) {
                    new File(dir, file).delete();
                }
            }
        }
    }

    public Pickcel() {
        this.TAG = "CORDOVA_ACTIVITY";
        this.threadPool = Executors.newCachedThreadPool();
        this.mHolder = null;
        this.video_urls = new ArrayList();
        this.video_idx = 0;
        this.is_tv_started = false;
        this.is_web_app_loaded = false;
        this.luma_value = 50;
        this.contrast_value = 50;
        this.saturation_value = 50;
        this.hue_value = 50;
        this.g_width = 800;
        this.g_height = 480;
        this.maxFiles = 20;
        this.contentIndex = 0;
        this.startContent = false;
        this.playingImage = false;
        this.contentIndex2 = 0;
        this.startContent2 = false;
        this.playingImage2 = false;
        this.isShowHDMI = false;
        this.is_tv_hdmi_started = false;
        this.timerTast = null;
        this.hour = 0;
        this.is_usb = false;
        this.entertainmentUrls = null;
        this.position = 0;
        this.startTimer = false;
        this.playingVideo = false;
        this.add = false;
        this.mOnErrorListener = new C02441();
        this.mOnErrorListener2 = new C02452();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(HttpTransport.DEFAULT_CHUNK_LENGTH, HttpTransport.DEFAULT_CHUNK_LENGTH);
        Bundle b = getIntent().getExtras();
        this.decorView = getWindow().getDecorView();
        this.uiOptions = 6;
        this.decorView.setSystemUiVisibility(this.uiOptions);
        this.uri = b.getString("uri");
        this.is_ip_tv = b.getBoolean("is_ip_tv");
        this.is_portrait = b.getBoolean("is_portrait");
        this.is_usb = b.getBoolean("is_usb");
        this.usb_path = b.getString("usb_path");
        this.timeZone = b.getString("tz");
        this.authCode = b.getString("code");
        ((AlarmManager) getBaseContext().getSystemService("alarm")).setTimeZone(this.timeZone);
        this.url = b.getString("url");
        setContentView(C0253R.layout.cordova_layout);
        WifiManager wifiManager = (WifiManager) getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        if (this.is_portrait) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        this.rl = (RelativeLayout) findViewById(C0253R.id.content_layout);
        this.sfv = new SurfaceView(this);
        this.video = new StretchVideoView(this);
        this.video2 = new StretchVideoView(this);
        this.entertainmentVideo = new StretchVideoView(this);
        this.stv = new TextureView(this);
        this.scrollText = new NativeRss(this);
        this.imageView = new ImageView(this);
        this.imageView2 = new ImageView(this);
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        this.g_width = display.getWidth();
        this.g_height = display.getHeight();
        this.g_height += getStatusBarHeight();
        if (this.is_ip_tv) {
            if (this.is_portrait) {
                this.rl.addView(this.stv, this.g_width, this.g_height / 3);
            } else {
                this.rl.addView(this.stv, this.g_width / 2, this.g_height / 2);
            }
            this.stv.setSurfaceTextureListener(this);
        } else {
            this.stv.setVisibility(8);
        }
        this.video.setZOrderOnTop(true);
        this.video.setZOrderMediaOverlay(true);
        this.video.setVisibility(8);
        this.rl.addView(this.video);
        this.video2.setZOrderOnTop(true);
        this.video2.setZOrderMediaOverlay(true);
        this.video2.setVisibility(8);
        this.rl.addView(this.video2);
        this.entertainmentVideo.setZOrderOnTop(true);
        this.entertainmentVideo.setZOrderMediaOverlay(true);
        this.entertainmentVideo.setVisibility(8);
        this.rl.addView(this.entertainmentVideo);
        this.scrollText.setVisibility(8);
        this.rl.addView(this.scrollText);
        this.imageView.setVisibility(8);
        this.rl.addView(this.imageView);
        this.imageView2.setVisibility(8);
        this.rl.addView(this.imageView2);
        this.dateFormatForContent = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ");
        this.dateFormatForContent2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ");
        this.video.setOnCompletionListener(new C02463());
        this.video2.setOnCompletionListener(new C02474());
        this.entertainmentVideo.setOnCompletionListener(new C02485());
        this.cordova_webview = (CordovaWebView) findViewById(C0253R.id.web_view);
        Config.init(this);
        Log.e("Pickcel", "Loading url " + this.uri);
        load_url(this.uri);
    }

    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    private void load_url(String uri) {
        if (!this.is_web_app_loaded) {
            this.cordova_webview.loadUrl(uri, 5);
            new Handler().postDelayed(new C02496(uri), 5000);
        }
    }

    protected void initTV() {
        this.tv = new TVDecoder();
        this.audioManager = (AudioManager) getSystemService("audio");
    }

    public void surfaceCreated(SurfaceHolder holder) {
        tvd_connect();
    }

    public void show_tv(int x, int y, int width, int height) {
        this.is_tv_started = true;
        this.tv_x = x;
        this.tv_y = y;
        runOnUiThread(new C02507(width, height));
        this.sfv.setZOrderOnTop(true);
        this.sfv.setZOrderMediaOverlay(true);
        this.sfv.getHolder().addCallback(this);
        initTV();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Surface surface = holder.getSurface();
        this.tv.setSize(this.tv_x, this.tv_y, width, height);
        this.tv.setPreviewDisplay(surface);
        tvd_start();
        tvd_setcolor(this.luma_value, this.contrast_value, this.saturation_value, this.hue_value);
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    void tvd_connect() {
        this.tv.connect(1, 0, 1, 0);
    }

    void tvd_disconnect() {
        this.tv.disconnect();
    }

    void tvd_start() {
        this.tv.startDecoder();
    }

    void tvd_setcolor(int luma_value, int contrast_value, int saturation_value, int hue_value) {
        this.tv.setColor(luma_value, contrast_value, saturation_value, hue_value);
    }

    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {
    }

    public void setActivityResultCallback(CordovaPlugin plugin) {
    }

    public Activity getActivity() {
        return this;
    }

    public Object onMessage(String id, Object data) {
        Log.d(this.TAG, "got message");
        return null;
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void stop_tv() {
        runOnUiThread(new C02518());
    }

    public void reboot_device() {
        try {
            Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot"}).waitFor();
        } catch (Exception e) {
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTetxure) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void push_notification(String title, String subject, String body) {
    }

    public void app_loaded() {
        this.is_web_app_loaded = true;
    }

    public void delete_dir() {
        runOnUiThread(new C02529());
    }

    public void clear_cache() {
        File appDir = new File(getCacheDir().getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            if (children[3].equals("lib")) {
                clear_files(new File(appDir, children[3]));
            }
        }
    }

    private boolean clear_files(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String file : children) {
                if (!clear_files(new File(dir, file))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public void reset(String type, boolean boolean1) {
        runOnUiThread(new AnonymousClass10(type, boolean1));
    }

    public void onStart() {
        super.onStart();
        writeInFolder("App_Records", true, 1);
        updatePickcelEndTime(6000);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.is_tv_hdmi_started) {
            onDestroyTv();
            this.rl.removeView(this.sfv);
            this.is_tv_hdmi_started = false;
        }
    }

    public void connectionStats(boolean boolean1) {
        runOnUiThread(new AnonymousClass11(boolean1));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void writeInFolder(java.lang.String r27, boolean r28, int r29) {
        /*
        r26 = this;
        r3 = 0;
        r26.createNewFolder1(r27);
        r0 = r26;
        r0 = r0.fileLst1;
        r22 = r0;
        r0 = r22;
        r0 = r0.length;
        r22 = r0;
        if (r22 != 0) goto L_0x0018;
    L_0x0011:
        r26.createNewFile1();
        r26.writeWithTimeStampInNewFile();
    L_0x0017:
        return;
    L_0x0018:
        r0 = r26;
        r0 = r0.fileLst1;
        r22 = r0;
        r23 = 0;
        r13 = r22[r23];
        r12 = 1;
    L_0x0023:
        r0 = r26;
        r0 = r0.fileLst1;
        r22 = r0;
        r0 = r22;
        r0 = r0.length;
        r22 = r0;
        r0 = r22;
        if (r12 < r0) goto L_0x0089;
    L_0x0032:
        r22 = new java.io.File;
        r0 = r26;
        r0 = r0.newFolder1;
        r23 = r0;
        r24 = r13.getName();
        r22.<init>(r23, r24);
        r0 = r22;
        r1 = r26;
        r1.latestFile1 = r0;
        r16 = 0;
        r10 = new java.io.FileReader;	 Catch:{ IOException -> 0x00ac }
        r0 = r26;
        r0 = r0.latestFile1;	 Catch:{ IOException -> 0x00ac }
        r22 = r0;
        r0 = r22;
        r10.<init>(r0);	 Catch:{ IOException -> 0x00ac }
        r18 = new java.io.LineNumberReader;	 Catch:{ IOException -> 0x00ac }
        r0 = r18;
        r0.<init>(r10);	 Catch:{ IOException -> 0x00ac }
    L_0x005d:
        r22 = r18.readLine();	 Catch:{ IOException -> 0x00ac }
        if (r22 != 0) goto L_0x00a9;
    L_0x0063:
        r18.close();	 Catch:{ IOException -> 0x00ac }
    L_0x0066:
        if (r28 == 0) goto L_0x00c1;
    L_0x0068:
        r0 = r26;
        r0 = r0.fileLst1;
        r22 = r0;
        r0 = r22;
        r0 = r0.length;
        r22 = r0;
        r0 = r26;
        r0 = r0.maxFiles;
        r23 = r0;
        r0 = r22;
        r1 = r23;
        if (r0 > r1) goto L_0x00b9;
    L_0x007f:
        r0 = r16;
        r1 = r29;
        if (r0 >= r1) goto L_0x00b1;
    L_0x0085:
        r26.writeWithTimeStampInLatestFile();
        goto L_0x0017;
    L_0x0089:
        r22 = r13.lastModified();
        r0 = r26;
        r0 = r0.fileLst1;
        r24 = r0;
        r24 = r24[r12];
        r24 = r24.lastModified();
        r22 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r22 >= 0) goto L_0x00a5;
    L_0x009d:
        r0 = r26;
        r0 = r0.fileLst1;
        r22 = r0;
        r13 = r22[r12];
    L_0x00a5:
        r12 = r12 + 1;
        goto L_0x0023;
    L_0x00a9:
        r16 = r16 + 1;
        goto L_0x005d;
    L_0x00ac:
        r7 = move-exception;
        r7.printStackTrace();
        goto L_0x0066;
    L_0x00b1:
        r26.createNewFile1();
        r26.writeWithTimeStampInNewFile();
        goto L_0x0017;
    L_0x00b9:
        r26.getOldestFileAndDelete1(r27);
        r26.writeWithTimeStampInLatestFile();
        goto L_0x0017;
    L_0x00c1:
        r14 = 0;
        r17 = new java.util.ArrayList;
        r17.<init>();
        r9 = new java.io.FileReader;	 Catch:{ Exception -> 0x0198 }
        r0 = r26;
        r0 = r0.latestFile1;	 Catch:{ Exception -> 0x0198 }
        r22 = r0;
        r0 = r22;
        r9.<init>(r0);	 Catch:{ Exception -> 0x0198 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0198 }
        r2.<init>(r9);	 Catch:{ Exception -> 0x0198 }
        r4 = r3;
    L_0x00da:
        r14 = r2.readLine();	 Catch:{ Exception -> 0x0158 }
        if (r14 != 0) goto L_0x00e3;
    L_0x00e0:
        r3 = r4;
        goto L_0x0017;
    L_0x00e3:
        r22 = ",";
        r0 = r22;
        r20 = r14.lastIndexOf(r0);	 Catch:{ Exception -> 0x0158 }
        r22 = r20 + 1;
        r0 = r22;
        r15 = r14.substring(r0);	 Catch:{ Exception -> 0x0158 }
        r22 = r15.length();	 Catch:{ Exception -> 0x0158 }
        r23 = 1;
        r0 = r22;
        r1 = r23;
        if (r0 <= r1) goto L_0x015f;
    L_0x00ff:
        r6 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0158 }
        r22 = "yyyy-MM-dd HH:mm:ssZZZZZ";
        r0 = r22;
        r6.<init>(r0);	 Catch:{ Exception -> 0x0158 }
        r22 = new java.util.Date;	 Catch:{ Exception -> 0x0158 }
        r22.<init>();	 Catch:{ Exception -> 0x0158 }
        r0 = r22;
        r21 = r6.format(r0);	 Catch:{ Exception -> 0x0158 }
        r0 = r21;
        r14 = r14.replace(r15, r0);	 Catch:{ Exception -> 0x0158 }
        r0 = r17;
        r0.add(r14);	 Catch:{ Exception -> 0x0158 }
        r9.close();	 Catch:{ Exception -> 0x0158 }
        r2.close();	 Catch:{ Exception -> 0x0158 }
        r11 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0158 }
        r0 = r26;
        r0 = r0.latestFile1;	 Catch:{ Exception -> 0x0158 }
        r22 = r0;
        r0 = r22;
        r11.<init>(r0);	 Catch:{ Exception -> 0x0158 }
        r5 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x0158 }
        r5.<init>(r11);	 Catch:{ Exception -> 0x0158 }
        r22 = r17.iterator();	 Catch:{ Exception -> 0x0158 }
    L_0x013a:
        r23 = r22.hasNext();	 Catch:{ Exception -> 0x0158 }
        if (r23 != 0) goto L_0x014c;
    L_0x0140:
        r5.flush();	 Catch:{ Exception -> 0x0158 }
        r5.close();	 Catch:{ Exception -> 0x0158 }
        r11.close();	 Catch:{ Exception -> 0x0158 }
        r3 = r4;
        goto L_0x0017;
    L_0x014c:
        r19 = r22.next();	 Catch:{ Exception -> 0x0158 }
        r19 = (java.lang.String) r19;	 Catch:{ Exception -> 0x0158 }
        r0 = r19;
        r5.write(r0);	 Catch:{ Exception -> 0x0158 }
        goto L_0x013a;
    L_0x0158:
        r8 = move-exception;
        r3 = r4;
    L_0x015a:
        r8.printStackTrace();
        goto L_0x0017;
    L_0x015f:
        r6 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0158 }
        r22 = "yyyy-MM-dd HH:mm:ssZZZZZ";
        r0 = r22;
        r6.<init>(r0);	 Catch:{ Exception -> 0x0158 }
        r22 = new java.util.Date;	 Catch:{ Exception -> 0x0158 }
        r22.<init>();	 Catch:{ Exception -> 0x0158 }
        r0 = r22;
        r21 = r6.format(r0);	 Catch:{ Exception -> 0x0158 }
        r3 = new java.io.BufferedWriter;	 Catch:{ IOException -> 0x019a }
        r22 = new java.io.FileWriter;	 Catch:{ IOException -> 0x019a }
        r0 = r26;
        r0 = r0.latestFile1;	 Catch:{ IOException -> 0x019a }
        r23 = r0;
        r24 = 1;
        r22.<init>(r23, r24);	 Catch:{ IOException -> 0x019a }
        r0 = r22;
        r3.<init>(r0);	 Catch:{ IOException -> 0x019a }
        r0 = r21;
        r3.append(r0);	 Catch:{ IOException -> 0x0191 }
        r3.close();	 Catch:{ IOException -> 0x0191 }
        goto L_0x0017;
    L_0x0191:
        r7 = move-exception;
    L_0x0192:
        r7.printStackTrace();	 Catch:{ Exception -> 0x0198 }
        r4 = r3;
        goto L_0x00da;
    L_0x0198:
        r8 = move-exception;
        goto L_0x015a;
    L_0x019a:
        r7 = move-exception;
        r3 = r4;
        goto L_0x0192;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pickcel.agent.Pickcel.writeInFolder(java.lang.String, boolean, int):void");
    }

    protected void getOldestFileAndDelete1(String folder_name) {
        this.fileLst1 = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString())).append("/").append(folder_name).toString()).listFiles();
        String oldestFile = this.fileLst1[0].getName();
        for (int i = 1; i < this.fileLst1.length; i++) {
            if (oldestFile.compareTo(this.fileLst1[i].getName()) > 0) {
                oldestFile = this.fileLst1[i].getName();
            }
        }
        new File(this.newFolder1, oldestFile).delete();
    }

    private void createNewFolder1(String fldr_name) {
        this.newFolder1 = new File(Environment.getExternalStorageDirectory(), fldr_name);
        if (!this.newFolder1.exists()) {
            this.newFolder1.mkdir();
        }
        this.fileLst1 = this.newFolder1.listFiles();
    }

    private void createNewFile1() {
        this.newFile1 = new File(this.newFolder1, new StringBuilder(String.valueOf(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()))).append(".csv").toString());
        if (!this.newFile1.exists()) {
            try {
                this.newFile1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeWithTimeStampInNewFile() {
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ").format(new Date());
            BufferedWriter buf = new BufferedWriter(new FileWriter(this.newFile1, true));
            buf.append(new StringBuilder(String.valueOf(timeStamp)).append(",").toString());
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeWithTimeStampInLatestFile() {
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ").format(new Date());
            BufferedWriter buf = new BufferedWriter(new FileWriter(this.latestFile1, true));
            buf.newLine();
            buf.append(new StringBuilder(String.valueOf(timeStamp)).append(",").toString());
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playNativeRss(double x, double y, int textSize, String textColor, String backgroundColor, int speed, double startPosition, String rss, String textStyle, double zoneHeight) {
        runOnUiThread(new AnonymousClass12(x, y, startPosition, zoneHeight, textColor, backgroundColor, textSize, rss, speed, textStyle));
    }

    public void stopNativeRss() {
        runOnUiThread(new Runnable() {
            public void run() {
                Pickcel.this.scrollText.pauseScroll();
                Pickcel.this.scrollText.setVisibility(8);
            }
        });
    }

    public int getVersionCode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getAuthCode() {
        if (this.authCode != null) {
            return this.authCode;
        }
        return "";
    }

    public void playContent(double x, double y, double width, double height, JSONArray cntnt) {
        runOnUiThread(new AnonymousClass14(cntnt, x, y, width, height));
    }

    private void playMedia() {
        runOnUiThread(new Runnable() {
            public void run() {
                Pickcel.this.decorView.setSystemUiVisibility(Pickcel.this.uiOptions);
                try {
                    String type = Pickcel.this.content.getJSONObject(Pickcel.this.contentIndex).getString("type");
                    String url = Pickcel.this.content.getJSONObject(Pickcel.this.contentIndex).getString("url");
                    String fileName = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel/").append(url.substring(url.lastIndexOf("/") + 1)).toString();
                    Pickcel.this.startContent = true;
                    if (type.equals("image")) {
                        Pickcel.this.playImage(fileName);
                    } else if (type.equals("video")) {
                        Pickcel.this.advertisementUrl = url;
                        Pickcel.this.playVideo(fileName);
                    } else if (!type.equals("entertainment")) {
                    } else {
                        if (Pickcel.this.entertainmentUrls == null) {
                            Pickcel.this.startContent = false;
                            if (Pickcel.this.add) {
                                Pickcel.this.contentIndex = (Pickcel.this.contentIndex + 1) % Pickcel.this.content.length();
                                Pickcel.this.playMedia();
                            }
                        } else if (Pickcel.this.entertainmentUrls.length() != 0) {
                            Pickcel.this.playEntertainmentVideo();
                        } else {
                            Pickcel.this.startContent = false;
                            if (Pickcel.this.add) {
                                Pickcel.this.contentIndex = (Pickcel.this.contentIndex + 1) % Pickcel.this.content.length();
                                Pickcel.this.playMedia();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void playEntertainmentVideo() {
        if (this.playingImage) {
            this.imageView.setVisibility(8);
            this.imageView.setImageBitmap(null);
            this.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.playingImage = false;
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.playingVideo) {
            this.video.stopPlayback();
            this.playingVideo = false;
            this.video.setVisibility(8);
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.entertainmentVideo.isPlaying()) {
            this.position = this.entertainmentVideo.getCurrentPosition();
            this.entertainmentVideo.stopPlayback();
        }
        this.urlToPlay = (Uri) this.video_urls.get(this.video_idx);
        this.engagementUrl = this.urlToPlay.toString();
        String fileName = this.urlToPlay.toString().substring(this.urlToPlay.toString().lastIndexOf("/") + 1);
        this.engagementFileSet = fileName;
        if (this.is_usb) {
            fileName = this.usb_path + fileName;
        } else {
            fileName = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).toString();
        }
        if (new File(fileName).exists()) {
            this.entertainmentVideo.setVideoPath(fileName);
            this.entertainmentVideo.setVisibility(0);
            this.entertainmentVideo.seekTo(this.position);
            this.entertainmentVideo.start();
            this.entertainmentVideo.setOnErrorListener(this.mOnErrorListener);
            playBackfunction();
            return;
        }
        this.video_idx = (this.video_idx + 1) % this.video_urls.size();
        stopContentForEntertainment();
        if (this.add) {
            this.contentIndex = (this.contentIndex + 1) % this.content.length();
            playMedia();
        }
    }

    private void playBackfunction() {
        int duration = 0;
        try {
            duration = this.content.getJSONObject(this.contentIndex).getInt("duration");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.startTimer = true;
        Timer timer = new Timer();
        TimerTask anonymousClass16 = new TimerTask() {
            public void run() {
                Pickcel.this.contentIndex = (Pickcel.this.contentIndex + 1) % Pickcel.this.content.length();
                Pickcel.this.playMedia();
            }
        };
        this.timer = anonymousClass16;
        timer.schedule(anonymousClass16, (long) duration);
    }

    private void playVideo(String fileName) {
        if (this.playingImage) {
            this.imageView.setVisibility(8);
            this.imageView.setImageBitmap(null);
            this.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.playingImage = false;
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.playingVideo) {
            this.video.stopPlayback();
            this.playingVideo = false;
            this.video.setVisibility(8);
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.entertainmentVideo.isPlaying()) {
            this.position = this.entertainmentVideo.getCurrentPosition();
            this.entertainmentVideo.stopPlayback();
            this.entertainmentVideo.setVisibility(8);
        }
        try {
            this.cId = this.content.getJSONObject(this.contentIndex).getString("campaignId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (new File(fileName).exists()) {
            this.video.setVideoPath(fileName);
            this.fileNameIsPlaying = fileName;
            this.video.setVisibility(0);
            this.video.start();
            this.playingVideo = true;
            this.startTimeForContent = this.dateFormatForContent.format(new Date());
            this.video.setOnErrorListener(this.mOnErrorListener2);
            playBackfunction();
        } else if (this.startTimer) {
            this.timer.cancel();
            this.startTimer = false;
            this.contentIndex = (this.contentIndex + 1) % this.content.length();
            playMedia();
        }
    }

    private void playImage(String fileName) {
        if (this.playingImage) {
            this.imageView.setVisibility(8);
            this.playingImage = false;
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.playingVideo) {
            this.video.stopPlayback();
            this.playingVideo = false;
            this.video.setVisibility(8);
            writeAssetRecords(this.fileNameIsPlaying, 100);
        }
        if (this.entertainmentVideo.isPlaying()) {
            this.position = this.entertainmentVideo.getCurrentPosition();
            this.entertainmentVideo.stopPlayback();
            this.entertainmentVideo.setVisibility(8);
        }
        try {
            this.cId = this.content.getJSONObject(this.contentIndex).getString("campaignId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        if (file.exists()) {
            Bitmap bmp;
            if ((file.length() / 1024) / 1024 > 1) {
                Options options = new Options();
                options.inSampleSize = 6;
                bmp = BitmapFactory.decodeFile(fileName, options);
            } else {
                bmp = BitmapFactory.decodeFile(fileName);
            }
            this.imageView.setVisibility(0);
            this.fileNameIsPlaying = fileName;
            this.imageView.setScaleType(ScaleType.FIT_XY);
            this.imageView.setImageBitmap(bmp);
            this.startTimeForContent = this.dateFormatForContent.format(new Date());
            this.playingImage = true;
            playBackfunction();
        } else if (this.startTimer) {
            this.timer.cancel();
            this.startTimer = false;
            this.contentIndex = (this.contentIndex + 1) % this.content.length();
            playMedia();
        }
    }

    public void stopContent() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (Pickcel.this.startContent) {
                    if (Pickcel.this.startTimer) {
                        Pickcel.this.timer.cancel();
                        Pickcel.this.startTimer = false;
                    }
                    if (Pickcel.this.playingImage) {
                        Pickcel.this.imageView.setImageBitmap(null);
                        Pickcel.this.imageView.setVisibility(8);
                        Pickcel.this.playingImage = false;
                    }
                    if (Pickcel.this.playingVideo) {
                        Pickcel.this.video.stopPlayback();
                        Pickcel.this.playingVideo = false;
                        Pickcel.this.video.setVisibility(8);
                    }
                    if (Pickcel.this.entertainmentVideo.isPlaying()) {
                        Pickcel.this.entertainmentVideo.stopPlayback();
                        Pickcel.this.entertainmentVideo.setVisibility(8);
                    }
                    Pickcel.this.entertainmentVideo.setVisibility(8);
                    Pickcel.this.video.setVisibility(8);
                    Pickcel.this.startContent = false;
                }
                Pickcel.this.stopYoutubeView();
            }
        });
    }

    public void stopContentForEntertainment() {
        if (this.startContent) {
            if (this.startTimer) {
                this.timer.cancel();
                this.startTimer = false;
            }
            if (this.playingImage) {
                this.imageView.setImageBitmap(null);
                this.imageView.setVisibility(8);
                this.playingImage = false;
            }
            if (this.playingVideo) {
                this.video.stopPlayback();
                this.playingVideo = false;
                this.video.setVisibility(8);
            }
            if (this.entertainmentVideo.isPlaying()) {
                this.entertainmentVideo.stopPlayback();
                this.entertainmentVideo.setVisibility(8);
            }
            this.video.stopPlayback();
            this.entertainmentVideo.stopPlayback();
            this.entertainmentVideo.setVisibility(8);
            this.video.setVisibility(8);
            this.startContent = false;
        }
    }

    protected void writeAssetRecords(String fileName, int maxLine) {
        int splitStartPosition = fileName.lastIndexOf("/");
        int splitEndPosition = fileName.lastIndexOf(".");
        String assetId = fileName.substring(splitStartPosition + 1, splitEndPosition);
        createNewFolder("Assets_Records_Zone1");
        if (this.fileLst.length == 0) {
            createNewFile();
            apend(this.newFile, assetId, true);
        } else if (this.fileLst.length <= this.maxFiles) {
            lastModifiedFile = this.fileLst[0];
            for (j = 1; j < this.fileLst.length; j++) {
                if (lastModifiedFile.lastModified() < this.fileLst[j].lastModified()) {
                    lastModifiedFile = this.fileLst[j];
                }
            }
            File latestFile = new File(this.newFolder, lastModifiedFile.getName());
            try {
                LineNumberReader lnr = new LineNumberReader(new FileReader(latestFile));
                int linenumber = 0;
                while (lnr.readLine() != null) {
                    linenumber++;
                }
                lnr.close();
                if (linenumber < maxLine) {
                    apend(latestFile, assetId, false);
                    return;
                }
                createNewFile();
                apend(this.newFile, assetId, true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            getOldestFileAndDelete("Assets_Records_Zone1");
            lastModifiedFile = this.fileLst[0];
            for (j = 1; j < this.fileLst.length; j++) {
                if (lastModifiedFile.lastModified() < this.fileLst[j].lastModified()) {
                    lastModifiedFile = this.fileLst[j];
                }
            }
            apend(new File(this.newFolder, lastModifiedFile.getName()), assetId, false);
        }
    }

    private void apend(File file, String assetId, boolean bln) {
        IOException e;
        try {
            String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZZZZZ").format(new Date());
            BufferedWriter buf = new BufferedWriter(new FileWriter(file, true));
            BufferedWriter bufferedWriter;
            try {
                String type = "Campaign";
                if (this.cId.equalsIgnoreCase("null")) {
                    type = "Creative";
                }
                buf.append(new StringBuilder(String.valueOf(type)).append(",").append(this.cId).append(",").append(assetId).append(",").append(this.startTimeForContent).append(",").append(endTime).toString());
                buf.newLine();
                buf.close();
                bufferedWriter = buf;
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = buf;
                e.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    protected void getOldestFileAndDelete(String folder_name) {
        this.fileLst = this.newFolder.listFiles();
        String oldestFile = this.fileLst[0].getName();
        for (int i = 1; i < this.fileLst.length; i++) {
            if (oldestFile.compareTo(this.fileLst[i].getName()) > 0) {
                oldestFile = this.fileLst[i].getName();
            }
        }
        new File(this.newFolder, oldestFile).delete();
    }

    private void createNewFolder(String fldr_name) {
        this.newFolder = new File(Environment.getExternalStorageDirectory(), fldr_name);
        if (!this.newFolder.exists()) {
            this.newFolder.mkdir();
        }
        this.fileLst = this.newFolder.listFiles();
    }

    private void createNewFile() {
        this.newFile = new File(this.newFolder, new StringBuilder(String.valueOf(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()))).append(".csv").toString());
        if (!this.newFile.exists()) {
            try {
                this.newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playContentInZoneTwo(double x, double y, double width, double height, JSONArray cntnt) {
        runOnUiThread(new AnonymousClass18(x, y, width, height, cntnt));
    }

    private void playMediaInZoneTwo() {
        runOnUiThread(new Runnable() {
            public void run() {
                Pickcel.this.decorView.setSystemUiVisibility(Pickcel.this.uiOptions);
                try {
                    String type = Pickcel.this.content2.getJSONObject(Pickcel.this.contentIndex2).getString("type");
                    String url = Pickcel.this.content2.getJSONObject(Pickcel.this.contentIndex2).getString("url");
                    String fileName = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel/").append(url.substring(url.lastIndexOf("/") + 1)).toString();
                    Pickcel.this.startContent2 = true;
                    if (type.equals("image")) {
                        Pickcel.this.playImageInZoneTwo(fileName);
                    } else if (type.equals("video")) {
                        Pickcel.this.advertisementUrl = url;
                        Pickcel.this.playVideoInZoneTwo(fileName);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void playBackfunctionInZoneTwo() {
        int duration = 0;
        try {
            duration = this.content2.getJSONObject(this.contentIndex2).getInt("duration");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        TimerTask anonymousClass20 = new TimerTask() {
            public void run() {
                Pickcel.this.contentIndex2 = (Pickcel.this.contentIndex2 + 1) % Pickcel.this.content2.length();
                Pickcel.this.playMediaInZoneTwo();
                Pickcel.this.playBackfunctionInZoneTwo();
            }
        };
        this.timer2 = anonymousClass20;
        timer.schedule(anonymousClass20, (long) duration);
    }

    private void playVideoInZoneTwo(String fileName) {
        if (this.playingImage2) {
            this.imageView2.setVisibility(8);
            this.imageView2.setImageBitmap(null);
            this.imageView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.playingImage2 = false;
        }
        if (this.video2.isPlaying()) {
            this.video2.stopPlayback();
            this.video2.setVisibility(8);
        }
        try {
            this.cId2 = this.content2.getJSONObject(this.contentIndex2).getString("campaignId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (new File(fileName).exists()) {
            this.video2.setVideoPath(fileName);
            this.fileNameIsPlaying2 = fileName;
            this.video2.setVisibility(0);
            this.video2.start();
            this.startTimeForContent2 = this.dateFormatForContent2.format(new Date());
            this.video2.setOnErrorListener(this.mOnErrorListener2);
        }
    }

    private void playImageInZoneTwo(String fileName) {
        if (this.playingImage2) {
            this.imageView2.setImageBitmap(null);
            this.imageView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.playingImage2 = false;
        }
        if (this.video2.isPlaying()) {
            this.video2.stopPlayback();
            this.video2.setVisibility(8);
        }
        try {
            this.cId2 = this.content2.getJSONObject(this.contentIndex2).getString("campaignId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        if (file.exists()) {
            Bitmap bmp;
            if ((file.length() / 1024) / 1024 > 1) {
                Options options = new Options();
                options.inSampleSize = 6;
                bmp = BitmapFactory.decodeFile(fileName, options);
            } else {
                bmp = BitmapFactory.decodeFile(fileName);
            }
            this.imageView2.setVisibility(0);
            this.fileNameIsPlaying2 = fileName;
            this.imageView2.setScaleType(ScaleType.FIT_XY);
            this.imageView2.setImageBitmap(bmp);
            this.startTimeForContent2 = this.dateFormatForContent2.format(new Date());
            this.playingImage2 = true;
        }
    }

    public void stopContentInZoneTwo() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (Pickcel.this.startContent2) {
                    Pickcel.this.timer2.cancel();
                    if (Pickcel.this.playingImage2) {
                        Pickcel.this.imageView2.setImageBitmap(null);
                        Pickcel.this.imageView2.setVisibility(8);
                        Pickcel.this.playingImage2 = false;
                    }
                    if (Pickcel.this.video2.isPlaying()) {
                        Pickcel.this.video2.stopPlayback();
                        Pickcel.this.video2.setVisibility(8);
                    }
                    Pickcel.this.video2.setVisibility(8);
                    Pickcel.this.startContent2 = false;
                    Pickcel.this.video.stopPlayback();
                    Pickcel.this.video.setVisibility(8);
                }
            }
        });
    }

    public void startTvHdmi(double x, double y, double width, double height) {
        this.is_tv_hdmi_started = true;
        runOnUiThread(new AnonymousClass22(x, y, width, height));
    }

    public void showTv(double x, double y, double width, double height) {
        if (this.sfv.getParent() != null) {
            onDestroyTv();
            this.rl.removeView(this.sfv);
        }
        double x1 = (x / 100.0d) * ((double) this.g_width);
        double y1 = (y / 100.0d) * ((double) this.g_height);
        int width2 = (int) ((width / 100.0d) * ((double) this.g_width));
        int height2 = ((int) ((height / 100.0d) * ((double) this.g_height))) - 20;
        this.rl.addView(this.sfv, width2, height2);
        this.sfv.setX((float) Math.round(x1));
        this.sfv.setY((float) Math.round(y1));
        this.isShowHDMI = isDisHDMI();
        changeInputSource(EnumInputSource.E_INPUT_SOURCE_HDMI);
        setFillScale(x1, y1, width2, height2);
    }

    public void stopTvHdmi() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (Pickcel.this.is_tv_hdmi_started) {
                    Pickcel.this.onDestroyTv();
                    Pickcel.this.rl.removeView(Pickcel.this.sfv);
                    Pickcel.this.is_tv_hdmi_started = false;
                }
            }
        });
    }

    private void setFillScale(double x, double y, int width, int height) {
        int x2 = (int) x;
        int y2 = (int) y;
        VideoWindowType videoWindowType = new VideoWindowType();
        videoWindowType.f60x = x2;
        videoWindowType.f61y = y2;
        videoWindowType.width = width;
        videoWindowType.height = height;
        if (TvManager.getInstance() != null) {
            PictureManager pictureManager = TvManager.getInstance().getPictureManager();
            if (pictureManager != null) {
                try {
                    pictureManager.selectWindow(EnumScalerWindow.E_MAIN_WINDOW);
                    pictureManager.setDisplayWindow(videoWindowType);
                    pictureManager.scaleWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void changeInputSource(EnumInputSource eis) {
        TvCommonManager commonService = TvCommonManager.getInstance();
        if (commonService != null) {
            EnumInputSource currentSource = commonService.getCurrentInputSource();
            if (currentSource != null && !currentSource.equals(eis)) {
                commonService.setInputSource(eis);
            }
        }
    }

    private boolean isDisHDMI() {
        boolean bRet = false;
        try {
            changeInputSource(EnumInputSource.E_INPUT_SOURCE_HDMI);
            bRet = TvManager.getInstance().getPlayerManager().isSignalStable();
        } catch (TvCommonException e) {
            e.printStackTrace();
        }
        return bRet;
    }

    public void onDestroyTv() {
        try {
            if (this.timerTast != null) {
                this.timerTast.cancel();
                this.timerTast = null;
            }
            changeInputSource(EnumInputSource.E_INPUT_SOURCE_STORAGE);
            changeInputSource(EnumInputSource.E_INPUT_SOURCE_STORAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEngageArrays(JSONArray jsonArray) {
        if (!this.is_usb) {
            this.entertainmentUrls = jsonArray;
        }
    }

    public void changeFileName(String fileName) {
        File oldFile = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).append(".progress").toString());
        File newFile = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).toString());
        if (newFile.exists()) {
            newFile.delete();
        }
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
        }
    }

    public void deleteFileName(String fileName) {
        File fileNameToDelete = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).append(".progress").toString());
        if (fileNameToDelete.exists()) {
            fileNameToDelete.delete();
        }
    }

    public boolean checkFileName(String fileName) {
        if (new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(fileName).toString()).exists()) {
            return true;
        }
        return false;
    }

    public void errorWhilePlaying(String fileUrl, boolean isEngagement) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Play_Exception.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            if (isEngagement) {
                bw.append("Engagement Url:- " + fileUrl);
                File engagementFile = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel_engagement/").append(this.engagementFileSet).toString());
                if (engagementFile.exists()) {
                    engagementFile.delete();
                }
            } else {
                bw.append("Advertisement Url:- " + fileUrl);
                File advertisementFile = new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel/").append(fileUrl.substring(fileUrl.lastIndexOf("/") + 1)).toString());
                if (advertisementFile.exists()) {
                    advertisementFile.delete();
                }
            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void regMessage(String message) {
        String[] subString = message.split(":");
        if (!subString[1].equalsIgnoreCase("true")) {
            AlertDialog alertDialog = new Builder(this).create();
            alertDialog.setTitle("ERROR");
            alertDialog.setMessage(subString[0]);
            alertDialog.setCancelable(true);
            alertDialog.setButton(-3, "OK", new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    File appDir = new File(Pickcel.this.getCacheDir().getParent());
                    if (appDir.exists()) {
                        for (String s : appDir.list()) {
                            if (!s.equals("lib")) {
                                Pickcel.this.clear_files(new File(appDir, s));
                            }
                        }
                    }
                    Pickcel.this.startActivity(new Intent(Pickcel.this.getApplicationContext(), Bootstrap.class));
                    Pickcel.this.finish();
                }
            });
            alertDialog.show();
        }
    }

    private void updatePickcelEndTime(int time) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                Pickcel.this.writeInFolder("App_Records", false, 1);
                Pickcel.this.updatePickcelEndTime(600000);
            }
        }, (long) time);
    }

    public void startPre() {
        startActivity(getPackageManager().getLaunchIntentForPackage("com.pickcel.eye"));
    }

    public void startYoutubeView(String url, int schTime) {
        Intent intent = new Intent(getApplicationContext(), Pickcel.class);
        intent.addFlags(67108864);
        startActivity(intent);
        Timer timer = new Timer();
        TimerTask anonymousClass26 = new AnonymousClass26(url);
        this.ytubeRestart = anonymousClass26;
        timer.schedule(anonymousClass26, 4000);
    }

    public void stopYoutubeView() {
        Intent intent = new Intent(getApplicationContext(), Pickcel.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    public void playLocalStream(double x, double y, double width, double height, String url) {
        runOnUiThread(new AnonymousClass27(x, y, width, height, url));
    }

    protected void stream(String url) {
        this.video.setVisibility(0);
        String path = url;
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(this.video);
        Uri uri = Uri.parse(path);
        this.video.setMediaController(mediaController);
        this.video.setVideoURI(uri);
        this.video.requestFocus();
        this.video.start();
        this.video.setOnErrorListener(this.mOnErrorListener2);
    }

    public void showScreenShot(String randomNumber) {
        File check = new File(Environment.getExternalStorageDirectory(), "/screen_shot.png");
        if (check.exists()) {
            check.delete();
        }
        try {
            OutputStream os = Runtime.getRuntime().exec("su", null, null).getOutputStream();
            os.write("/system/bin/screencap -p /sdcard/screen_shot.png".getBytes("ASCII"));
            os.flush();
            os.close();
            sendFile(randomNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String randomNumber) {
        String device_uuid = Secure.getString(getContentResolver(), "android_id");
        Timer timer = new Timer();
        TimerTask anonymousClass28 = new AnonymousClass28(device_uuid, randomNumber);
        this.sendScreenShot = anonymousClass28;
        timer.schedule(anonymousClass28, 5000);
    }

    public void freeMemory() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if ((((long) stat.getBlockSize()) * ((long) stat.getAvailableBlocks())) / 1048576 < 1000) {
            File folder = new File(Environment.getExternalStorageDirectory(), "pickcel");
            if (folder.exists()) {
                File[] fileList = folder.listFiles();
                if (fileList.length > 1) {
                    for (File name : fileList) {
                        String fileName = name.getName();
                        boolean verified = false;
                        String lastModifiedContent = getPreferences(0).getString("lastModifiedContent", null);
                        if (lastModifiedContent != null) {
                            if (lastModifiedContent.contains(fileName)) {
                                verified = true;
                            }
                            if (!verified) {
                                new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/pickcel/").append(fileName).toString()).delete();
                            }
                        }
                    }
                }
            }
        }
    }

    public void lastModifiedContent(JSONArray jsonArray) {
        Editor editor = getPreferences(0).edit();
        editor.putString("lastModifiedContent", jsonArray.toString());
        editor.commit();
    }
}
