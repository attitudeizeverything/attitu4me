package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnPictureEventListener;
import com.mstar.android.tvapi.common.vo.ColorTemperature;
import com.mstar.android.tvapi.common.vo.EnumLocalDimmingMode;
import com.mstar.android.tvapi.common.vo.EnumMfcMode;
import com.mstar.android.tvapi.common.vo.EnumMfcOsdWindow;
import com.mstar.android.tvapi.common.vo.EnumPanelTiming;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.EnumUrsaMode;
import com.mstar.android.tvapi.common.vo.EnumVideoArcType;
import com.mstar.android.tvapi.common.vo.Film.EnumFilm;
import com.mstar.android.tvapi.common.vo.GetPixelRgbStage.EnumGetPixelRgbStage;
import com.mstar.android.tvapi.common.vo.MpegNoiseReduction.EnumMpegNoiseReduction;
import com.mstar.android.tvapi.common.vo.MweType.EnumMweType;
import com.mstar.android.tvapi.common.vo.NoiseReduction.EnumNoiseReduction;
import com.mstar.android.tvapi.common.vo.PanelProperty;
import com.mstar.android.tvapi.common.vo.Rgb_Data;
import com.mstar.android.tvapi.common.vo.ScreenPixelInfo;
import com.mstar.android.tvapi.common.vo.ScreenPixelInfo.EnumPixelRGBStage;
import com.mstar.android.tvapi.common.vo.SetLocationType.EnumSetLocationType;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.lang.ref.WeakReference;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public final class PictureManager {
    private static PictureManager _pictureManager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnPictureEventListener mOnEventListener;
    private int mPictureManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.PictureManager.1 */
    static /* synthetic */ class C01131 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[EVENT.EV_SET_ASPECTRATIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[EVENT.EV_4K2K_PHOTO_DISABLE_PIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[EVENT.EV_4K2K_PHOTO_DISABLE_POP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[EVENT.EV_4K2K_PHOTO_DISABLE_DUALVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[EVENT.EV_4K2K_PHOTO_DISABLE_TRAVELINGMODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    protected enum EVENT {
        EV_SET_ASPECTRATIO,
        EV_4K2K_PHOTO_DISABLE_PIP,
        EV_4K2K_PHOTO_DISABLE_POP,
        EV_4K2K_PHOTO_DISABLE_DUALVIEW,
        EV_4K2K_PHOTO_DISABLE_TRAVELINGMODE,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private PictureManager mMSrv;

        public EventHandler(PictureManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_SET_ASPECTRATIO.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01131.$SwitchMap$com$mstar$android$tvapi$common$PictureManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (PictureManager.this.mOnEventListener != null) {
                            PictureManager.this.mOnEventListener.onSetAspectratio(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (PictureManager.this.mOnEventListener != null) {
                            PictureManager.this.mOnEventListener.on4K2KPhotoDisablePip(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (PictureManager.this.mOnEventListener != null) {
                            PictureManager.this.mOnEventListener.on4K2KPhotoDisablePop(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (PictureManager.this.mOnEventListener != null) {
                            PictureManager.this.mOnEventListener.on4K2KPhotoDisableDualview(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (PictureManager.this.mOnEventListener != null) {
                            PictureManager.this.mOnEventListener.on4K2KPhotoDisableTravelingmode(msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private native boolean native_disableAllOsdWindow() throws TvCommonException;

    private native boolean native_disableOsdWindow(int i) throws TvCommonException;

    private final native void native_finalize();

    private native int native_get4K2KMode() throws TvCommonException;

    private final native int native_getAspectRatio() throws TvCommonException;

    private final native int native_getDemoMode() throws TvCommonException;

    private native ScreenPixelInfo native_getPixelInfo(int i, int i2, int i3, int i4) throws TvCommonException;

    private native Rgb_Data native_getPixelRgb(int i, short s, short s2, int i2) throws TvCommonException;

    private final native int native_getReproduceRate() throws TvCommonException;

    private final native byte native_getResolution() throws TvCommonException;

    private static final native void native_init();

    private final native boolean native_selectWindow(int i) throws TvCommonException;

    private native boolean native_set4K2KMode(int i, int i2) throws TvCommonException;

    private final native void native_setAspectRatio(int i) throws TvCommonException;

    private final native void native_setDemoMode(int i) throws TvCommonException;

    private final native void native_setFilm(int i) throws TvCommonException;

    private native boolean native_setLocalDimmingMode(int i) throws TvCommonException;

    private final native void native_setMfc(int i) throws TvCommonException;

    private final native boolean native_setMpegNoiseReduction(int i) throws TvCommonException;

    private final native boolean native_setNoiseReduction(int i) throws TvCommonException;

    private native boolean native_setOsdWindow(int i, int i2, int i3, int i4, int i5) throws TvCommonException;

    private final native void native_setPictureModeBrightness(int i, int i2) throws TvCommonException;

    private final native void native_setReproduceRate(int i) throws TvCommonException;

    private final native void native_setResolution(byte b) throws TvCommonException;

    private final native void native_setup(Object obj);

    public native boolean autoHDMIColorRange() throws TvCommonException;

    public native boolean disableAllDualWinMode() throws TvCommonException;

    public native void disableBacklight() throws TvCommonException;

    public final native void disableDlc() throws TvCommonException;

    public final native void disableOverScan() throws TvCommonException;

    public native void enableBacklight() throws TvCommonException;

    public final native void enableDlc() throws TvCommonException;

    public final native void enableOverScan() throws TvCommonException;

    public native boolean enableXvyccCompensation(boolean z, int i) throws TvCommonException;

    public native boolean enter4K2KMode(boolean z) throws TvCommonException;

    public native boolean forceFreerun(boolean z, boolean z2) throws TvCommonException;

    public final native boolean freezeImage() throws TvCommonException;

    public final native int getBacklight() throws TvCommonException;

    public final native int getBacklightMaxValue() throws TvCommonException;

    public final native int getBacklightMinValue() throws TvCommonException;

    public native int getCustomerPqRuleNumber() throws TvCommonException;

    public native short getDlcAverageLuma() throws TvCommonException;

    public native short getDlcHistogramMax() throws TvCommonException;

    public native short getDlcHistogramMin() throws TvCommonException;

    public native int[] getDlcLumArray(int i) throws TvCommonException;

    public native int getDlcLumAverageTemporary() throws TvCommonException;

    public native int getDlcLumTotalCount() throws TvCommonException;

    public final native int[] getDynamicContrastCurve() throws TvCommonException;

    public final native PanelProperty getPanelWidthHeight() throws TvCommonException;

    public native int getStatusNumberByCustomerPqRule(int i) throws TvCommonException;

    public native boolean is4K2KMode(boolean z) throws TvCommonException;

    public final native boolean isImageFreezed() throws TvCommonException;

    public final native boolean isOverscanEnabled() throws TvCommonException;

    public native boolean keepScalerOutput4k2k(boolean z) throws TvCommonException;

    public native void lock4K2KMode(boolean z) throws TvCommonException;

    public native boolean moveWindow() throws TvCommonException;

    public final native boolean scaleWindow() throws TvCommonException;

    public final native void setBacklight(int i) throws TvCommonException;

    public native void setColorRange(boolean z) throws TvCommonException;

    public final native void setColorTemperature(ColorTemperature colorTemperature) throws TvCommonException;

    public final native void setCropWindow(VideoWindowType videoWindowType) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setDisplayWindow(VideoWindowType videoWindowType) throws TvCommonException;

    public final native void setDynamicContrastCurve(int[] iArr, int[] iArr2, int[] iArr3) throws TvCommonException;

    public native boolean setHLinearScaling(boolean z, boolean z2, int i) throws TvCommonException;

    public native boolean setLocalDimmingBrightLevel(short s) throws TvCommonException;

    public native boolean setMEMCMode(String str) throws TvCommonException;

    public final native void setOutputPattern(boolean z, int i, int i2, int i3) throws TvCommonException;

    public final native void setOverscan(int i, int i2, int i3, int i4) throws TvCommonException;

    public final native void setPictureModeBrightness(short s) throws TvCommonException;

    public final native void setPictureModeColor(short s) throws TvCommonException;

    public final native void setPictureModeContrast(short s) throws TvCommonException;

    public final native void setPictureModeSharpness(short s) throws TvCommonException;

    public final native void setPictureModeTint(short s) throws TvCommonException;

    public native void setScalerGammaByIndex(byte b) throws TvCommonException;

    public native boolean setStatusByCustomerPqRule(int i, int i2) throws TvCommonException;

    public native boolean setSwingLevel(short s) throws TvCommonException;

    @Deprecated
    public native boolean setTurnOffLocalDimmingBacklight(boolean z) throws TvCommonException;

    public native boolean setUltraClear(boolean z) throws TvCommonException;

    public final native void setWindowInvisible() throws TvCommonException;

    public final native void setWindowVisible() throws TvCommonException;

    public native boolean switchDlcCurve(short s) throws TvCommonException;

    public native boolean turnOffLocalDimmingBacklight(boolean z) throws TvCommonException;

    public final native boolean unFreezeImage() throws TvCommonException;

    static {
        try {
            System.loadLibrary("picturemanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load picturemanager_jni library:\n" + e.toString());
        }
        _pictureManager = null;
    }

    public static PictureManager getInstance() {
        if (_pictureManager == null) {
            synchronized (PictureManager.class) {
                if (_pictureManager == null) {
                    _pictureManager = new PictureManager();
                }
            }
        }
        return _pictureManager;
    }

    public boolean selectWindow(EnumScalerWindow windowId) throws TvCommonException {
        return native_selectWindow(windowId.ordinal());
    }

    public final void setAspectRatio(EnumVideoArcType videoArcType) throws TvCommonException {
        native_setAspectRatio(videoArcType.ordinal());
    }

    public final EnumVideoArcType getAspectRatio() throws TvCommonException {
        int iReturn = native_getAspectRatio();
        if (iReturn >= EnumVideoArcType.E_DEFAULT.ordinal() && iReturn <= EnumVideoArcType.E_MAX.ordinal()) {
            return EnumVideoArcType.values()[iReturn];
        }
        throw new TvCommonException("native_getAspectRatio failed");
    }

    public final void setPictureModeBrightness(EnumSetLocationType setLocationType, int value) throws TvCommonException {
        native_setPictureModeBrightness(setLocationType.getValue(), value);
    }

    public void setDemoMode(EnumMweType enMweType) throws TvCommonException {
        native_setDemoMode(enMweType.getValue());
    }

    public final EnumMweType getDemoMode() throws TvCommonException {
        int iordinal = EnumMweType.getOrdinalThroughValue(native_getDemoMode());
        if (iordinal != -1) {
            return EnumMweType.values()[iordinal];
        }
        throw new TvCommonException("get demomode error ");
    }

    public final boolean setMpegNoiseReduction(EnumMpegNoiseReduction mpegNR) throws TvCommonException {
        return native_setMpegNoiseReduction(mpegNR.getValue());
    }

    public final boolean setNoiseReduction(EnumNoiseReduction nr) throws TvCommonException {
        return native_setNoiseReduction(nr.getValue());
    }

    public void setFilm(EnumFilm enMsFilm) throws TvCommonException {
        native_setFilm(enMsFilm.getValue());
    }

    public final void setMfc(EnumMfcMode mfcMode) throws TvCommonException {
        native_setMfc(mfcMode.ordinal());
    }

    public final boolean disableOsdWindow(EnumMfcOsdWindow mfcOsdWindow) throws TvCommonException {
        return native_disableOsdWindow(mfcOsdWindow.ordinal());
    }

    public final boolean disableAllOsdWindow() throws TvCommonException {
        return native_disableAllOsdWindow();
    }

    public final boolean setOsdWindow(EnumMfcOsdWindow mfcOsdWindow, int startX, int width, int startY, int height) throws TvCommonException {
        return native_setOsdWindow(mfcOsdWindow.ordinal(), startX, width, startY, height);
    }

    public Rgb_Data getPixelRgb(EnumGetPixelRgbStage eStage, short x, short y, EnumScalerWindow eWindow) throws TvCommonException {
        return native_getPixelRgb(eStage.getValue(), x, y, eWindow.ordinal());
    }

    public boolean setLocalDimmingMode(EnumLocalDimmingMode localDimingMode) throws TvCommonException {
        return native_setLocalDimmingMode(localDimingMode.ordinal());
    }

    public final byte getResolution() throws TvCommonException {
        return native_getResolution();
    }

    public void setResolution(byte resolution) throws TvCommonException {
        native_setResolution(resolution);
    }

    public final int getReproduceRate() throws TvCommonException {
        return native_getReproduceRate();
    }

    public void setReproduceRate(int rate) throws TvCommonException {
        native_setReproduceRate(rate);
    }

    public ScreenPixelInfo getPixelInfo(int x, int y, int w, int h) throws TvCommonException {
        ScreenPixelInfo PixelInfo = native_getPixelInfo(x, y, w, h);
        if (PixelInfo != null) {
            PixelInfo.enStage = EnumPixelRGBStage.valueOf(PixelInfo.tmpStage);
        }
        return PixelInfo;
    }

    public EnumUrsaMode get4K2KMode() throws TvCommonException {
        int iReturn = native_get4K2KMode();
        if (iReturn >= EnumUrsaMode.E_URSA_4K2K_MODE_FULLHD.ordinal() && iReturn <= EnumUrsaMode.E_URSA_4K2K_MODE_UNDEFINED.ordinal()) {
            return EnumUrsaMode.values()[iReturn];
        }
        throw new TvCommonException("native_get4K2KMode failed");
    }

    public boolean set4K2KMode(EnumPanelTiming enOutPutTimming, EnumUrsaMode enUrsaMode) throws TvCommonException {
        return native_set4K2KMode(enOutPutTimming.ordinal(), enUrsaMode.ordinal());
    }

    protected PictureManager() {
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

    public void setOnPictureEventListener(OnPictureEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("picturemanager callback  \n");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    private static void PostEvent_SetAspectratio(Object srv_ref, int arg1, int arg2) {
        PictureManager srv = (PictureManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SET_ASPECTRATIO.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4K2KPhotoDisablePip(Object srv_ref, int arg1, int arg2) {
        PictureManager srv = (PictureManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_PHOTO_DISABLE_PIP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4K2KPhotoDisablePop(Object srv_ref, int arg1, int arg2) {
        PictureManager srv = (PictureManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_PHOTO_DISABLE_POP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4K2KPhotoDisableDualview(Object srv_ref, int arg1, int arg2) {
        PictureManager srv = (PictureManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_PHOTO_DISABLE_DUALVIEW.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4K2KPhotoDisableTravelingmode(Object srv_ref, int arg1, int arg2) {
        PictureManager srv = (PictureManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_PHOTO_DISABLE_TRAVELINGMODE.ordinal(), arg1, arg2));
        }
    }

    protected void release() throws Throwable {
        _pictureManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _pictureManager = null;
    }
}
