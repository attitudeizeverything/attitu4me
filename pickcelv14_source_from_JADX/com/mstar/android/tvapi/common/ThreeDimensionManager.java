package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnThreeDimensionEventListener;
import com.mstar.android.tvapi.common.vo.Detect3dFormatParameter;
import com.mstar.android.tvapi.common.vo.Enum3dAspectRatioType;
import com.mstar.android.tvapi.common.vo.Enum3dItemType;
import com.mstar.android.tvapi.common.vo.Enum3dType;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.lang.ref.WeakReference;
import jcifs.smb.SmbNamedPipe;

public final class ThreeDimensionManager {
    private static ThreeDimensionManager _3dManager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnThreeDimensionEventListener mOnEventListener;
    private int mThreeDimensionManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.ThreeDimensionManager.1 */
    static /* synthetic */ class C01161 {
        static final /* synthetic */ int[] f56x85eaf86b;

        static {
            f56x85eaf86b = new int[EVENT.values().length];
            try {
                f56x85eaf86b[EVENT.EV_ENABLE_3D.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f56x85eaf86b[EVENT.EV_4K2K_UNSUPPORT_DUALVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected enum EVENT {
        EV_ENABLE_3D,
        EV_4K2K_UNSUPPORT_DUALVIEW,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private ThreeDimensionManager mMSrv;

        public EventHandler(ThreeDimensionManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_ENABLE_3D.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01161.f56x85eaf86b[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (ThreeDimensionManager.this.mOnEventListener != null) {
                            ThreeDimensionManager.this.mOnEventListener.onEnable3D(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (ThreeDimensionManager.this.mOnEventListener != null) {
                            ThreeDimensionManager.this.mOnEventListener.on4k2kUnsupportDualView(msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private final native boolean enable3d(int i) throws TvCommonException;

    private final native int native_detect3dFormat(int i) throws TvCommonException;

    private native boolean native_enable3dDualView(int i, int i2, VideoWindowType videoWindowType, VideoWindowType videoWindowType2) throws TvCommonException;

    private final native boolean native_enable3dTo2d(int i) throws TvCommonException;

    private final native void native_finalize();

    private final native int native_get3dArc() throws TvCommonException;

    private final native int native_getCurrent3dFormat() throws TvCommonException;

    private static final native void native_init();

    private final native boolean native_query3dCapability(int i) throws TvCommonException;

    private final native boolean native_set3dArc(int i) throws TvCommonException;

    private final native void native_setup(Object obj);

    public native boolean disable3dDualView() throws TvCommonException;

    public final native boolean disable3dLrSwitch() throws TvCommonException;

    public native void disableLow3dQuality() throws TvCommonException;

    public final native boolean enable3dLrSwitch() throws TvCommonException;

    public native void enableLow3dQuality() throws TvCommonException;

    public native boolean generateMvopTiming(int i, int i2, int i3) throws TvCommonException;

    public final native boolean get3dFormatDetectFlag() throws TvCommonException;

    public final native int get3dGain() throws TvCommonException;

    public final native int get3dOffset() throws TvCommonException;

    public final native Detect3dFormatParameter getDetect3dFormatParameters() throws TvCommonException;

    public final native boolean is3dLrSwitched() throws TvCommonException;

    public final native boolean set3dFormatDetectFlag(boolean z) throws TvCommonException;

    public final native boolean set3dGain(int i) throws TvCommonException;

    public final native boolean set3dOffset(int i) throws TvCommonException;

    public native void setDebugMode(boolean z);

    public final native boolean setDetect3dFormatParameters(Detect3dFormatParameter detect3dFormatParameter) throws TvCommonException;

    static {
        _3dManager = null;
        try {
            System.loadLibrary("threedimensionmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load threedimensionmanager_jni library:\n" + e.toString());
        }
    }

    public static ThreeDimensionManager getInstance() {
        if (_3dManager == null) {
            synchronized (ThreeDimensionManager.class) {
                if (_3dManager == null) {
                    _3dManager = new ThreeDimensionManager();
                }
            }
        }
        return _3dManager;
    }

    public final boolean enable3dTo2d(Enum3dType en3dType) throws TvCommonException {
        return native_enable3dTo2d(en3dType.ordinal());
    }

    public final boolean set3dArc(Enum3dAspectRatioType en3dArc) throws TvCommonException {
        return native_set3dArc(en3dArc.ordinal());
    }

    public final Enum3dType getCurrent3dFormat() throws TvCommonException {
        int iReturn = native_getCurrent3dFormat();
        if (iReturn >= Enum3dType.EN_3D_NONE.ordinal() && iReturn <= Enum3dType.EN_3D_TYPE_NUM.ordinal()) {
            return Enum3dType.values()[iReturn];
        }
        throw new TvCommonException("getCurrent3dFormat failed");
    }

    public final Enum3dType detect3dFormat(EnumScalerWindow eWindow) throws TvCommonException {
        int iReturn = native_detect3dFormat(eWindow.ordinal());
        if (iReturn >= Enum3dType.EN_3D_NONE.ordinal() && iReturn <= Enum3dType.EN_3D_TYPE_NUM.ordinal()) {
            return Enum3dType.values()[iReturn];
        }
        throw new TvCommonException("detect3dFormat failed");
    }

    public final Enum3dAspectRatioType get3dArc() throws TvCommonException {
        int iReturn = native_get3dArc();
        if (iReturn >= Enum3dAspectRatioType.E_3D_ASPECTRATIO_FULL.ordinal() && iReturn <= Enum3dAspectRatioType.E_3D_ASPECTRATIO_NUM.ordinal()) {
            return Enum3dAspectRatioType.values()[iReturn];
        }
        throw new TvCommonException("get3dArc failed");
    }

    public final boolean query3dCapability(Enum3dItemType en3dItem) throws TvCommonException {
        return native_query3dCapability(en3dItem.ordinal());
    }

    public final boolean enable3d(Enum3dType en3dType) throws TvCommonException {
        return enable3d(en3dType.ordinal());
    }

    public boolean enable3dDualView(EnumInputSource eMainInputSource, EnumInputSource eSubInputSource, VideoWindowType mainDisplayType, VideoWindowType subDisplayerType) throws TvCommonException {
        return native_enable3dDualView(eMainInputSource.ordinal(), eSubInputSource.ordinal(), mainDisplayType, subDisplayerType);
    }

    public ThreeDimensionManager() {
        Looper looper = Looper.myLooper();
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            looper = Looper.getMainLooper();
            if (looper != null) {
                this.mEventHandler = new EventHandler(this, looper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    public void setOnThreeDimensionEventListener(OnThreeDimensionEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("ThreeDimensionManager callback  \n");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    private static void PostEvent_Enable3D(Object srv_ref, int arg1, int arg2) {
        ThreeDimensionManager srv = (ThreeDimensionManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ENABLE_3D.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kUnsupportDualView(Object srv_ref, int arg1, int arg2) {
        ThreeDimensionManager srv = (ThreeDimensionManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_UNSUPPORT_DUALVIEW.ordinal(), arg1, arg2));
        }
    }

    protected void release() throws Throwable {
        _3dManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _3dManager = null;
    }
}
