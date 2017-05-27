package com.mstar.android.widi;

public class WidiNative {
    public static native void closeWidiConnection();

    public static native boolean connectToWidi();

    public static native boolean loadWidiDriver(String str);

    public static native int sendWidiCmd(String str);

    public static native boolean unloadWidiDriver(String str);

    public static native int updateInterface(String str);

    public static native String waitForWidiEvent();

    public WidiNative() {
        try {
            System.loadLibrary("widi_jni");
        } catch (UnsatisfiedLinkError e) {
        }
    }
}
