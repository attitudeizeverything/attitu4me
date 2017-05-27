package com.mstar.android.tvapi.dtv.common;

import android.text.format.Time;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.vo.EnumOadVersionType;
import java.lang.ref.WeakReference;

public final class OadManager {
    private static OadManager _OadManager;
    private int mNativeContext;
    private int mOadManagerContext;

    private final native boolean hasOadSchedule(int i) throws TvCommonException;

    private final native void native_finalize();

    private final native long native_getOadBroadcastEndTime() throws TvCommonException;

    private final native long native_getOadBroadcastStartTime() throws TvCommonException;

    private final native int native_getOadVersion(int i) throws TvCommonException;

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public static native boolean resetForOadUpgrade() throws TvCommonException;

    public static native boolean standbyForOadUpgrade() throws TvCommonException;

    protected final native short getOadDownloadProgress() throws TvCommonException;

    protected final native short getOadUpdatedServiceNumber() throws TvCommonException;

    protected final native void setOadOff() throws TvCommonException;

    protected final native void setOadOn() throws TvCommonException;

    protected final native void startAutoOadScan() throws TvCommonException;

    protected final native void startOad() throws TvCommonException;

    protected final native boolean startOadInStandby() throws TvCommonException;

    protected final native boolean startOadInStandy() throws TvCommonException;

    protected final native void stopOad(boolean z) throws TvCommonException;

    protected final int getOadVersion(EnumOadVersionType oadVersionType) throws TvCommonException {
        return native_getOadVersion(oadVersionType.ordinal());
    }

    protected Time getOadBroadcastStartTime() throws TvCommonException {
        Time returnTime = new Time();
        returnTime.set(native_getOadBroadcastStartTime());
        returnTime.normalize(true);
        return returnTime;
    }

    protected Time getOadBroadcastEndTime() throws TvCommonException {
        Time returnTime = new Time();
        returnTime.set(native_getOadBroadcastEndTime());
        returnTime.normalize(true);
        return returnTime;
    }

    static {
        _OadManager = null;
        try {
            System.loadLibrary("oadmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load oadmanager_jni library:\n" + e.toString());
        }
    }

    protected static OadManager getInstance() {
        if (_OadManager == null) {
            synchronized (OadManager.class) {
                if (_OadManager == null) {
                    _OadManager = new OadManager();
                }
            }
        }
        return _OadManager;
    }

    private OadManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("ThreeDimensionManager callback  \n");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }
}
