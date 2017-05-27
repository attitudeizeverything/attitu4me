package com.pickcel.agent;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.pickcel.agent.plugin.Utils;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;
import fi.iki.elonen.SimpleWebServer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Bootstrap extends Activity implements OnClickListener {
    private static final String SET_PROP_COMMAND_OFF = "setprop service.adb.tcp.port -1";
    private static final String SET_PROP_COMMAND_ON = "setprop service.adb.tcp.port 5555";
    private static final String START_ADBD_COMMAND = "start adbd";
    private static final String STOP_ADBD_COMMAND = "stop adbd";
    Bootstrap ACTIVITY;
    PendingIntent RESTART_INTENT;
    AlarmManager alarm_mgr;
    private String code;
    ProgressDialog dialog;
    String entityId;
    String entityName;
    String groupName;
    boolean has_settings;
    boolean isAdmin;
    private boolean is_debug;
    private boolean is_portrait;
    private boolean is_usb;
    private String path;
    TextView textViewOfIp;
    private String timeZone;
    private String uri;
    List<File> web_root_dirs;

    /* renamed from: com.pickcel.agent.Bootstrap.1 */
    class C02421 implements UncaughtExceptionHandler {
        C02421() {
        }

        public void uncaughtException(Thread thread, Throwable ex) {
            Bootstrap.this.alarm_mgr.set(1, System.currentTimeMillis() + 1000, Bootstrap.this.RESTART_INTENT);
            System.exit(2);
        }
    }

    public Bootstrap() {
        this.is_portrait = false;
        this.is_debug = false;
        this.is_usb = false;
        this.web_root_dirs = new ArrayList();
        this.path = null;
        this.entityId = null;
        this.isAdmin = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ACTIVITY = this;
        this.RESTART_INTENT = PendingIntent.getActivity(this, 0, new Intent(this, Bootstrap.class), 0);
        this.alarm_mgr = (AlarmManager) this.ACTIVITY.getSystemService("alarm");
        Thread.setDefaultUncaughtExceptionHandler(new C02421());
        ActionBar bar = getActionBar();
        createWebDir();
        SimpleWebServer.startServer(this.web_root_dirs);
        this.has_settings = getSettings();
        Bundle b = getIntent().getExtras();
        if (b != null && b.getBoolean("show_settings", false)) {
            displayControlLayout();
        } else if (this.has_settings) {
            startCordovaActivity();
        } else {
            displayControlLayout();
        }
    }

    private void enable_debug() {
        String command = SET_PROP_COMMAND_ON;
        try {
            RootTools.getShell(true).add(new CommandCapture(0, SET_PROP_COMMAND_ON));
            RootTools.getShell(true).add(new CommandCapture(0, STOP_ADBD_COMMAND));
            RootTools.getShell(true).add(new CommandCapture(0, START_ADBD_COMMAND));
            Toast.makeText(getApplicationContext(), "Debug enabled successfully", 1).show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e2) {
            e2.printStackTrace();
        } catch (RootDeniedException e3) {
            e3.printStackTrace();
        }
    }

    private void connection_status() {
        if (checkInternetConnection()) {
            Toast.makeText(getApplicationContext(), "You have Internet connection", 1).show();
            ((ImageView) findViewById(C0253R.id.img_network_status)).setImageResource(C0253R.drawable.green);
            this.textViewOfIp = (TextView) findViewById(C0253R.id.textView4);
            this.textViewOfIp.setText("IP : " + Utils.getIPAddress(true));
            return;
        }
        Toast.makeText(getApplicationContext(), "You don't have Internet connection", 1).show();
        ((ImageView) findViewById(C0253R.id.img_network_status)).setImageResource(C0253R.drawable.red);
        this.textViewOfIp = (TextView) findViewById(C0253R.id.textView4);
        this.textViewOfIp.setText("IP : ");
    }

    private void displayControlLayout() {
        setContentView(C0253R.layout.new_layout);
        ((Button) findViewById(C0253R.id.btn_invoke_content)).setOnClickListener(this);
        ((CheckBox) findViewById(C0253R.id.is_usb)).setOnClickListener(this);
        ((CheckBox) findViewById(C0253R.id.is_portrait)).setOnClickListener(this);
        WifiManager wifiManager = (WifiManager) getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        if (this.has_settings) {
            ((EditText) findViewById(C0253R.id.uri)).setText(this.uri);
            ((CheckBox) findViewById(C0253R.id.is_portrait)).setChecked(this.is_portrait);
            ((CheckBox) findViewById(C0253R.id.is_usb)).setChecked(this.is_usb);
            if (this.is_usb) {
                ((EditText) findViewById(C0253R.id.usb_path)).setText(this.path);
            }
        }
        connection_status();
        ((TextView) findViewById(C0253R.id.display_date)).setText(new SimpleDateFormat("dd/MM/yyyy ").format(Calendar.getInstance().getTime()));
        try {
            Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createWebDir() {
        String primary_storage = Environment.getExternalStorageDirectory() + "/pickcel";
        File folder = new File(primary_storage);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                Log.e("Bootstrap", "Dir created successfully");
            } else {
                Log.e("Bootstarp", "Dir create failed");
            }
        }
        this.web_root_dirs.add(new File(primary_storage).getAbsoluteFile());
        String primary_storage2 = Environment.getExternalStorageDirectory() + "/pickcel_engagement";
        File folder2 = new File(primary_storage2);
        if (!folder2.exists()) {
            if (folder2.mkdir()) {
                Log.e("Bootstrap", "Dir2 created successfully");
            } else {
                Log.e("Bootstarp", "Dir2 create failed");
            }
        }
        this.web_root_dirs.add(new File(primary_storage2).getAbsoluteFile());
    }

    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case C0253R.id.btn_invoke_content /*2131230739*/:
                applySettings();
            case C0253R.id.is_usb /*2131230743*/:
                EditText usbPath = (EditText) findViewById(C0253R.id.usb_path);
                if (((CheckBox) view).isChecked()) {
                    usbPath.setVisibility(0);
                    showUsbPath();
                    return;
                }
                usbPath.setVisibility(8);
            case C0253R.id.btn_clear_data /*2131230748*/:
                File appDir = new File(getCacheDir().getParent());
                if (appDir.exists()) {
                    String[] children = appDir.list();
                    int length = children.length;
                    while (i < length) {
                        String s = children[i];
                        if (!s.equals("lib")) {
                            deleteDir(new File(appDir, s));
                            Log.i("TAG", "deleted" + s + " DELETED");
                        }
                        i++;
                    }
                }
            default:
        }
    }

    public boolean checkInternetConnection() {
        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        if (connectivity != null) {
            NetworkInfo[] inf = connectivity.getAllNetworkInfo();
            if (inf != null) {
                for (NetworkInfo state : inf) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void showUsbPath() {
        String[] dirList;
        int i;
        EditText usbPath = (EditText) findViewById(C0253R.id.usb_path);
        File storageDir = new File("/mnt/");
        if (storageDir.isDirectory()) {
            dirList = storageDir.list();
            for (i = 0; i < dirList.length; i++) {
                if (dirList[i].toLowerCase().contains("usb")) {
                    this.path = "/mnt/" + dirList[i] + "/";
                    usbPath.setText(this.path);
                }
            }
        }
        storageDir = new File(this.path);
        if (storageDir.isDirectory()) {
            dirList = storageDir.list();
            if (dirList != null) {
                for (i = 0; i < dirList.length; i++) {
                    if (dirList[i].toLowerCase().equalsIgnoreCase("pickcel_usb")) {
                        this.path += dirList[i] + "/";
                        usbPath.setText(this.path);
                        return;
                    }
                    if (dirList[i].toLowerCase().contains("usb")) {
                        this.path += dirList[i] + "/";
                        usbPath.setText(this.path);
                        storageDir = new File(this.path);
                        if (storageDir.isDirectory()) {
                            String[] dirList2 = storageDir.list();
                            if (dirList2 != null) {
                                for (int j = 0; j < dirList2.length; j++) {
                                    if (dirList2[j].toLowerCase().equalsIgnoreCase("pickcel_usb")) {
                                        this.path += dirList2[j] + "/";
                                        usbPath.setText(this.path);
                                        return;
                                    }
                                    if (dirList2 != null) {
                                        for (String str : dirList2) {
                                            this.path += str + "/";
                                            usbPath.setText(this.path);
                                            storageDir = new File(this.path);
                                            if (storageDir.isDirectory()) {
                                                String[] dirList3 = storageDir.list();
                                                if (dirList3 != null) {
                                                    for (int l = 0; l < dirList3.length; l++) {
                                                        if (dirList3[l].toLowerCase().equalsIgnoreCase("pickcel_usb")) {
                                                            this.path += dirList3[l] + "/";
                                                            usbPath.setText(this.path);
                                                            return;
                                                        }
                                                    }
                                                    continue;
                                                } else {
                                                    continue;
                                                }
                                            }
                                        }
                                        continue;
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private boolean getSettings() {
        SharedPreferences sharedPref = getPreferences(0);
        this.uri = sharedPref.getString("uri", "");
        this.path = sharedPref.getString("usb_path", "");
        if (this.uri.length() == 0) {
            return false;
        }
        this.is_portrait = sharedPref.getBoolean("is_portrait", false);
        this.is_debug = sharedPref.getBoolean("is_debug", false);
        this.is_usb = sharedPref.getBoolean("is_usb", false);
        this.timeZone = sharedPref.getString("tz", "");
        return true;
    }

    private void applySettings() {
        this.uri = ((EditText) findViewById(C0253R.id.uri)).getText().toString().replace(" ", "");
        Log.e("BootStrap", "Uri " + this.uri);
        this.is_portrait = ((CheckBox) findViewById(C0253R.id.is_portrait)).isChecked();
        this.is_usb = ((CheckBox) findViewById(C0253R.id.is_usb)).isChecked();
        this.code = ((EditText) findViewById(C0253R.id.code)).getText().toString();
        if (this.code.length() > 0) {
            Editor editor = getPreferences(0).edit();
            editor.putString("uri", this.uri);
            editor.putString("usb_path", this.path);
            editor.putBoolean("is_portrait", this.is_portrait);
            editor.putBoolean("is_debug", this.is_debug);
            editor.putBoolean("is_usb", this.is_usb);
            editor.commit();
            startCordovaActivity();
            return;
        }
        Toast.makeText(getApplicationContext(), "Please Insert Your Authentication Code", 1).show();
    }

    private void startCordovaActivity() {
        Intent intent = new Intent(getApplicationContext(), Pickcel.class);
        Bundle b = new Bundle();
        b.putString("uri", this.uri + "/player/index_3.6.3.html");
        b.putString("usb_path", this.path);
        b.putString("tz", this.timeZone);
        b.putBoolean("is_portrait", this.is_portrait);
        b.putBoolean("is_debug", this.is_debug);
        b.putBoolean("is_usb", this.is_usb);
        b.putString("url", this.uri);
        b.putString("code", this.code);
        writeInLocalMem();
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    private void writeInLocalMem() {
        File file = new File(Environment.getExternalStorageDirectory(), "pickcel_config");
        if (file.exists()) {
            file.delete();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.uri);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String file : children) {
                if (!deleteDir(new File(dir, file))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0253R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.toString().equalsIgnoreCase("Set Time")) {
            startActivity(new Intent("android.settings.DATE_SETTINGS"));
        }
        if (item.toString().equalsIgnoreCase("Refresh")) {
            connection_status();
        }
        if (item.toString().equalsIgnoreCase("Enable Debug")) {
            enable_debug();
        }
        return super.onOptionsItemSelected(item);
    }
}
