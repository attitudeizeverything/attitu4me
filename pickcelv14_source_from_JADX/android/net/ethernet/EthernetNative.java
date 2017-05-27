package android.net.ethernet;

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
            System.loadLibrary("libethernet_deprecated_jni");
        } catch (Exception e) {
            Log.e(TAG, "Failed to load libethernet_deprecated_jni.so while initializing android.net.ethernet; exception was ", e);
        }
    }
}
