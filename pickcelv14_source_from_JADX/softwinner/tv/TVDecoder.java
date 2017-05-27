package softwinner.tv;

import android.view.Surface;

public class TVDecoder {
    public native int connect(int i, int i2, int i3, int i4);

    public native int disconnect();

    public native int setColor(int i, int i2, int i3, int i4);

    public native int setPreviewDisplay(Surface surface);

    public native int setSize(int i, int i2, int i3, int i4);

    public native int startDecoder();

    public native int stopDecoder();

    static {
        try {
            System.loadLibrary("tvdecoder_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load tvdecoder_jni library!");
        }
    }
}
