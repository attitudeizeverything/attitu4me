package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnPipEventListener;
import com.mstar.android.tvapi.common.vo.EnumPipMode;
import com.mstar.android.tvapi.common.vo.EnumPipModes;
import com.mstar.android.tvapi.common.vo.EnumPipReturn;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TravelingEngineCaps;
import com.mstar.android.tvapi.common.vo.TravelingModeInfo;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumTravelingEngineType;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.lang.ref.WeakReference;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public final class PipManager {
    private static PipManager _pipManager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnPipEventListener mOnEventListener;
    private int mPipManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.PipManager.1 */
    static /* synthetic */ class C01141 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_ENABLE_POP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_ENABLE_PIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_4K2K_UNSUPPORT_PIP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_4K2K_UNSUPPORT_POP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_4K2K_UNSUPPORT_TRAVELINGMODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[EVENT.EV_REFRESH_PREVIEWMODE_WINDOW.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    protected enum EVENT {
        EV_ENABLE_POP,
        EV_4K2K_UNSUPPORT_PIP,
        EV_4K2K_UNSUPPORT_POP,
        EV_4K2K_UNSUPPORT_TRAVELINGMODE,
        EV_ENABLE_PIP,
        EV_REFRESH_PREVIEWMODE_WINDOW,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private PipManager mMSrv;

        public EventHandler(PipManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_ENABLE_POP.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01141.$SwitchMap$com$mstar$android$tvapi$common$PipManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.onEnablePop(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.onEnablePip(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.on4k2kUnsupportPip(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.on4k2kUnsupportPop(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.on4k2kUnsupportTravelingMode(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_DELETED /*6*/:
                        if (PipManager.this.mOnEventListener != null) {
                            PipManager.this.mOnEventListener.onRefreshPreviewModeWindow(msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private final native boolean native_disablePip(int i) throws TvCommonException;

    private final native boolean native_disablePop(int i) throws TvCommonException;

    private final native int native_enablePipMm(int i, VideoWindowType videoWindowType) throws TvCommonException;

    private final native int native_enablePipTv(int i, int i2, VideoWindowType videoWindowType) throws TvCommonException;

    private final native int native_enablePopMm(int i) throws TvCommonException;

    private final native int native_enablePopTv(int i, int i2) throws TvCommonException;

    private final native void native_finalize();

    private final native int native_getPipMode() throws TvCommonException;

    private final native boolean[] native_getPipSupportedSubInputSourceList(int i) throws TvCommonException;

    private static final native void native_init();

    private final native boolean native_isPipSupported(int i, int i2) throws TvCommonException;

    private final native boolean native_isPopSupported(int i, int i2) throws TvCommonException;

    private final native boolean native_isTravelingModeSupported(int i, int i2, int i3) throws TvCommonException;

    private final native void native_setup(Object obj);

    private native void setPipDisplayFocusWindow(int i) throws TvCommonException;

    public final native void clearFrame() throws TvCommonException;

    public final native void disablePreviewMode() throws TvCommonException;

    public final native void enablePreviewMode() throws TvCommonException;

    public final native boolean isPipModeEnabled() throws TvCommonException;

    public final native boolean native_getTravelingEngineCaps(int i, TravelingEngineCaps travelingEngineCaps) throws TvCommonException;

    public final native int native_initTravelingModeTv(TravelingModeInfo travelingModeInfo, int i) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setFirstPreviewModeInputSource(int i) throws TvCommonException;

    public final native boolean setPipSubWindow(VideoWindowType videoWindowType) throws TvCommonException;

    static {
        _pipManager = null;
        try {
            System.loadLibrary("pipmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load pipmanager_jni library:\n" + e.toString());
        }
    }

    public static PipManager getInstance() {
        if (_pipManager == null) {
            synchronized (PipManager.class) {
                if (_pipManager == null) {
                    _pipManager = new PipManager();
                }
            }
        }
        return _pipManager;
    }

    private PipManager() {
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

    public void setOnPipEventListener(OnPipEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("PipManager callback  \n");
    }

    private static void PostEvent_EnablePop(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ENABLE_POP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_EnablePip(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ENABLE_PIP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kUnsupportPip(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_UNSUPPORT_PIP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kUnsupportPop(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_UNSUPPORT_POP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kUnsupportTravelingMode(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_UNSUPPORT_TRAVELINGMODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_RefreshPreviewModeWindow(Object srv_ref, int arg1, int arg2) {
        PipManager srv = (PipManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_REFRESH_PREVIEWMODE_WINDOW.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _pipManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _pipManager = null;
    }

    public final boolean isPipSupported(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) throws TvCommonException {
        return native_isPipSupported(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
    }

    public final EnumPipReturn enablePipTv(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc, VideoWindowType dispWinType) throws TvCommonException {
        int iReturn = native_enablePipTv(eMainInputSrc.ordinal(), eSubInputSrc.ordinal(), dispWinType);
        if (iReturn >= EnumPipReturn.E_PIP_NOT_SUPPORT.ordinal() && iReturn <= EnumPipReturn.E_PIP_POP_MODE_NUM.ordinal()) {
            return EnumPipReturn.values()[iReturn];
        }
        throw new TvCommonException("enablePipTv failed");
    }

    public final EnumPipReturn enablePipMm(EnumInputSource eMainInputSrc, VideoWindowType dispWinType) throws TvCommonException {
        int iReturn = native_enablePipMm(eMainInputSrc.ordinal(), dispWinType);
        if (iReturn >= EnumPipReturn.E_PIP_NOT_SUPPORT.ordinal() && iReturn <= EnumPipReturn.E_PIP_POP_MODE_NUM.ordinal()) {
            return EnumPipReturn.values()[iReturn];
        }
        throw new TvCommonException("enablePipMm failed");
    }

    public final boolean disablePip(EnumScalerWindow eWindow) throws TvCommonException {
        return native_disablePip(eWindow.ordinal());
    }

    public final boolean isPopSupported(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) throws TvCommonException {
        return native_isPopSupported(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
    }

    public final EnumPipReturn enablePopTv(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) throws TvCommonException {
        int iReturn = native_enablePopTv(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
        if (iReturn >= EnumPipReturn.E_PIP_NOT_SUPPORT.ordinal() && iReturn <= EnumPipReturn.E_PIP_POP_MODE_NUM.ordinal()) {
            return EnumPipReturn.values()[iReturn];
        }
        throw new TvCommonException("enablePopTv failed");
    }

    public final EnumPipReturn enablePopMm(EnumInputSource eMainInputSrc) throws TvCommonException {
        int iReturn = native_enablePopMm(eMainInputSrc.ordinal());
        if (iReturn >= EnumPipReturn.E_PIP_NOT_SUPPORT.ordinal() && iReturn <= EnumPipReturn.E_PIP_POP_MODE_NUM.ordinal()) {
            return EnumPipReturn.values()[iReturn];
        }
        throw new TvCommonException("enablePopMm failed");
    }

    public final boolean disablePop(EnumScalerWindow eWindow) throws TvCommonException {
        return native_disablePop(eWindow.ordinal());
    }

    public final void setPipDisplayFocusWindow(EnumScalerWindow enScalerWindow) throws TvCommonException {
        setPipDisplayFocusWindow(enScalerWindow.ordinal());
    }

    @Deprecated
    public final boolean[] getPipSupportedSubInputSource(EnumPipMode pipMode) throws TvCommonException {
        return native_getPipSupportedSubInputSourceList(pipMode.ordinal());
    }

    public final boolean[] getPipSupportedSubInputSourceList(EnumPipMode pipMode) throws TvCommonException {
        return native_getPipSupportedSubInputSourceList(pipMode.ordinal());
    }

    public final EnumPipModes getPipMode() throws TvCommonException {
        int iReturn = native_getPipMode();
        if (iReturn >= EnumPipModes.E_PIP_MODE_OFF.ordinal() && iReturn <= EnumPipModes.E_PIP_MODE_TRAVELING.ordinal()) {
            return EnumPipModes.values()[iReturn];
        }
        throw new TvCommonException("get pipmode  failed");
    }

    public final boolean isTravelingModeSupported(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc, EnumTravelingEngineType eEngineType) throws TvCommonException {
        return native_isTravelingModeSupported(eMainInputSrc.ordinal(), eSubInputSrc.ordinal(), eEngineType.ordinal());
    }

    public final boolean isTravelingModeSupported(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) throws TvCommonException {
        return native_isTravelingModeSupported(eMainInputSrc.ordinal(), eSubInputSrc.ordinal(), 0);
    }
}
