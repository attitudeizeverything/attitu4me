package com.pickcel.agent.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;
import com.mstar.android.MKeyEvent;
import com.pickcel.agent.Bootstrap;
import com.pickcel.agent.Pickcel;
import com.squareup.okhttp.internal.http.HttpTransport;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils extends CordovaPlugin {
    public static String ip;
    private long storage_available;
    private long storage_total;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();
        Pickcel pickcel = (Pickcel) this.cordova.getActivity();
        JSONObject r;
        if (action.equals("getinfo")) {
            r = new JSONObject();
            getStorageStatus();
            JSONObject jSONObject = r;
            jSONObject.put("storage_available", this.storage_available);
            jSONObject = r;
            jSONObject.put("storage_total", this.storage_total);
            r.put("uptime", SystemClock.uptimeMillis() / 1000);
            r.put("ip", getIPAddress(true));
            r.put("versionCode", pickcel.getVersionCode());
            MemoryInfo mi = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(mi);
            jSONObject = r;
            jSONObject.put("ram_available", mi.availMem);
            callbackContext.success(r);
        } else {
            if (action.equals("show_settings")) {
                Bundle b = new Bundle();
                b.putBoolean("show_settings", true);
                Intent intent = new Intent(context, Bootstrap.class);
                intent.putExtras(b);
                intent.addFlags(SmbConstants.GENERIC_ALL);
                context.startActivity(intent);
            } else {
                if (!action.equals("render_video")) {
                    if (action.equals("start_tv")) {
                        pickcel.show_tv(args.getInt(0), args.getInt(1), args.getInt(2), args.getInt(3));
                    } else {
                        if (action.equals("push_notification")) {
                            pickcel.push_notification(args.getString(0), args.getString(1), args.getString(2));
                        } else {
                            if (action.equals("set_app_loaded")) {
                                pickcel.app_loaded();
                            } else {
                                if (action.equals("stop_tv")) {
                                    pickcel.stop_tv();
                                } else {
                                    if (!action.equals("stop_video")) {
                                        if (action.equals("write_display_manager_connection_stats")) {
                                            pickcel.connectionStats(args.getBoolean(0));
                                        } else {
                                            if (action.equals("cpu_usage")) {
                                                cpu_usage_handler(callbackContext);
                                            } else {
                                                if (action.equals("clear_content")) {
                                                    pickcel.reset(args.getString(0), args.getBoolean(1));
                                                } else {
                                                    if (action.equals("stopContent")) {
                                                        pickcel.stopContent();
                                                    } else {
                                                        if (action.equals("stopContent2")) {
                                                            pickcel.stopContentInZoneTwo();
                                                        } else {
                                                            if (action.equals("playContent")) {
                                                                pickcel.playContent(args.getDouble(0), args.getDouble(1), args.getDouble(2), args.getDouble(3), args.getJSONArray(4));
                                                            } else {
                                                                if (action.equals("playContent2")) {
                                                                    pickcel.playContentInZoneTwo(args.getDouble(0), args.getDouble(1), args.getDouble(2), args.getDouble(3), args.getJSONArray(4));
                                                                } else {
                                                                    if (action.equals("stopNativeRss")) {
                                                                        pickcel.stopNativeRss();
                                                                    } else {
                                                                        if (action.equals("playNativeRss")) {
                                                                            pickcel.playNativeRss(args.getDouble(0), args.getDouble(1), args.getInt(2), args.getString(3), args.getString(4), args.getInt(5), args.getDouble(6), args.getString(7), args.getString(8), args.getDouble(9));
                                                                        } else {
                                                                            if (!action.equals("write_asset_record")) {
                                                                                if (action.equals("startTvHdmi")) {
                                                                                    pickcel.startTvHdmi(args.getDouble(0), args.getDouble(1), args.getDouble(2), args.getDouble(3));
                                                                                } else {
                                                                                    if (action.equals("sendEngageArrays")) {
                                                                                        pickcel.getEngageArrays(args.getJSONArray(0));
                                                                                    } else {
                                                                                        if (action.equals("changeFileName")) {
                                                                                            pickcel.changeFileName(args.getString(0));
                                                                                        } else {
                                                                                            if (action.equals("deleteFileName")) {
                                                                                                pickcel.deleteFileName(args.getString(0));
                                                                                            } else {
                                                                                                if (action.equals("checkFileName")) {
                                                                                                    r = new JSONObject();
                                                                                                    r.put("checksum", pickcel.checkFileName(args.getString(0)));
                                                                                                    callbackContext.success(r);
                                                                                                } else {
                                                                                                    if (action.equals("preUpdate")) {
                                                                                                        pickcel.startPre();
                                                                                                    } else {
                                                                                                        if (action.equals("playYoutube")) {
                                                                                                            pickcel.startYoutubeView(args.getString(0), args.getInt(1));
                                                                                                        } else {
                                                                                                            if (action.equals("stopYoutube")) {
                                                                                                                pickcel.stopYoutubeView();
                                                                                                            } else {
                                                                                                                if (action.equals("playLocalStream")) {
                                                                                                                    pickcel.playLocalStream(args.getDouble(0), args.getDouble(1), args.getDouble(2), args.getDouble(3), args.getString(4));
                                                                                                                } else {
                                                                                                                    if (action.equals("regMessage")) {
                                                                                                                        pickcel.regMessage(args.getString(0));
                                                                                                                    } else {
                                                                                                                        if (action.equals("getAuthCode")) {
                                                                                                                            JSONObject code = new JSONObject();
                                                                                                                            code.put("authCode", pickcel.getAuthCode());
                                                                                                                            callbackContext.success(code);
                                                                                                                        } else {
                                                                                                                            if (action.equals("showScreenShot")) {
                                                                                                                                pickcel.showScreenShot(args.getString(0));
                                                                                                                            } else {
                                                                                                                                if (action.equals("lastModifiedContent")) {
                                                                                                                                    pickcel.lastModifiedContent(args.getJSONArray(0));
                                                                                                                                } else {
                                                                                                                                    if (action.equals("stopTvHdmi")) {
                                                                                                                                        pickcel.stopTvHdmi();
                                                                                                                                    } else {
                                                                                                                                        if (action.equals("set_time")) {
                                                                                                                                            try {
                                                                                                                                                Runtime.getRuntime().exec("su");
                                                                                                                                                if (ShellInterface.isSuAvailable()) {
                                                                                                                                                    ShellInterface.runCommand("chmod 666 /dev/alarm");
                                                                                                                                                    SystemClock.setCurrentTimeMillis(args.getLong(0) * 1000);
                                                                                                                                                }
                                                                                                                                            } catch (IOException e) {
                                                                                                                                                e.printStackTrace();
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            callbackContext.error("Action not supported");
                                                                                                                                            return false;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private void cpu_usage_handler(CallbackContext ctx) {
        JSONObject cpuUsage = new JSONObject();
        String[] cpudata = get_cpu_usage();
        try {
            cpuUsage.put("user", cpudata[0]);
            cpuUsage.put("system", cpudata[1]);
            ctx.success(cpuUsage);
        } catch (JSONException e) {
            e.printStackTrace();
            ctx.error("could not get the cpuUsage");
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sbuf = new StringBuilder();
        for (byte b : bytes) {
            int intVal = b & MKeyEvent.KEYCODE_SLEEP;
            if (intVal < 16) {
                sbuf.append("0");
            }
            sbuf.append(Integer.toHexString(intVal).toUpperCase());
        }
        return sbuf.toString();
    }

    public static byte[] getUTF8Bytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static String loadFileAsString(String filename) throws IOException {
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(filename), HttpTransport.DEFAULT_CHUNK_LENGTH);
        try {
            String str;
            ByteArrayOutputStream baos = new ByteArrayOutputStream(HttpTransport.DEFAULT_CHUNK_LENGTH);
            byte[] bytes = new byte[HttpTransport.DEFAULT_CHUNK_LENGTH];
            boolean isUTF8 = false;
            int count = 0;
            while (true) {
                int read = is.read(bytes);
                if (read == -1) {
                    break;
                }
                if (count == 0) {
                    if (bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) {
                        isUTF8 = true;
                        baos.write(bytes, 3, read - 3);
                        count += read;
                    }
                }
                baos.write(bytes, 0, read);
                count += read;
            }
            if (isUTF8) {
                str = new String(baos.toByteArray(), "UTF-8");
            } else {
                str = new String(baos.toByteArray());
            }
            return str;
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }

    public static String getMACAddress(String interfaceName) {
        try {
            NetworkInterface intf;
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            do {
                if (it.hasNext()) {
                    intf = (NetworkInterface) it.next();
                    if (interfaceName == null) {
                        break;
                    }
                } else {
                    return "";
                }
            } while (!intf.getName().equalsIgnoreCase(interfaceName));
            byte[] mac = intf.getHardwareAddress();
            if (mac == null) {
                return "";
            }
            StringBuilder buf = new StringBuilder();
            for (int idx = 0; idx < mac.length; idx++) {
                buf.append(String.format("%02X:", new Object[]{Byte.valueOf(mac[idx])}));
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }
            return buf.toString();
        } catch (Exception e) {
        }
    }

    public static String getIPAddress(boolean useIPv4) {
        Log.d("My tag", "in getIPAddress");
        try {
            for (NetworkInterface intf : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress addr : Collections.list(intf.getInetAddresses())) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        if (useIPv4) {
                            if (isIPv4) {
                                return sAddr;
                            }
                        } else if (!isIPv4) {
                            int delim = sAddr.indexOf(37);
                            if (delim >= 0) {
                                return sAddr.substring(0, delim);
                            }
                            return sAddr;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    private void getStorageStatus() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        this.storage_total = ((long) stat.getBlockSize()) * ((long) stat.getBlockCount());
        this.storage_available = ((long) stat.getBlockSize()) * ((long) stat.getAvailableBlocks());
    }

    public String[] get_cpu_usage() {
        String[] split_topdata = null;
        try {
            Process procs = Runtime.getRuntime().exec("top -m 1 -n 1");
            procs.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(procs.getInputStream()));
            String full_cpu_info = reader.readLine();
            full_cpu_info = reader.readLine();
            full_cpu_info = reader.readLine();
            full_cpu_info = reader.readLine();
            if (full_cpu_info != null) {
                split_topdata = full_cpu_info.split(",", 3);
            }
            String[] user = split_topdata[0].split(" ");
            String[] system = split_topdata[1].split(" ");
            return new String[]{user[1], system[2]};
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"0", "0"};
        }
    }
}
