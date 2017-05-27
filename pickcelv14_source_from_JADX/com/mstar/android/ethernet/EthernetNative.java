package com.mstar.android.ethernet;

import android.util.Log;

public class EthernetNative {
    private static final String TAG = "EthernetNative";

    public static native int getInterfaceCnt();

    public static native String getInterfaceName(int i);

    public static native String getMacAddress(String str);

    public static native int initEthernetNative();

    public static native String waitForEvent();

    static {
        try {
            System.loadLibrary("ethernet_jni");
        } catch (Exception e) {
            Log.e(TAG, "Failed to load libethernet_jni.so while initializing com.mstar.android.ethernet; exception was ", e);
        }
    }
}
