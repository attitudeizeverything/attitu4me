package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnCecEventListener;
import com.mstar.android.tvapi.common.vo.CecSetting;
import com.mstar.android.tvapi.common.vo.EnumCecDeviceLa;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;
import java.lang.ref.WeakReference;
import jcifs.smb.SmbNamedPipe;

public final class CecManager {
    private static CecManager _cecManager;
    private int mCecmanagerContext;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnCecEventListener mOnEventListener;

    /* renamed from: com.mstar.android.tvapi.common.CecManager.1 */
    static /* synthetic */ class C01111 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$CecManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$CecManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$CecManager$EVENT[EVENT.EV_CEC_IMAGE_VIEW_ON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$CecManager$EVENT[EVENT.EV_CEC_TEXT_VIEW_ON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected enum EVENT {
        EV_CEC_IMAGE_VIEW_ON,
        EV_CEC_TEXT_VIEW_ON,
        EV_UNDEFINED
    }

    private class EventHandler extends Handler {
        private CecManager mMSrv;

        public EventHandler(CecManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_UNDEFINED.ordinal() || msg.what < EVENT.EV_CEC_IMAGE_VIEW_ON.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01111.$SwitchMap$com$mstar$android$tvapi$common$CecManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (CecManager.this.mOnEventListener != null) {
                            CecManager.this.mOnEventListener.onImageViewOn(msg.what);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (CecManager.this.mOnEventListener != null) {
                            CecManager.this.mOnEventListener.onTextViewOn(msg.what);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native int native_setMenuLanguage(int i) throws TvCommonException;

    private final native void native_setStreamPath(int i);

    private final native void native_setup(Object obj);

    public final native int deviceListGetItemIndex(int i, int i2) throws TvCommonException;

    public final native String deviceListGetListStr(int i, int i2) throws TvCommonException;

    public final native boolean disableDeviceMenu() throws TvCommonException;

    public final native boolean enableDeviceMenu() throws TvCommonException;

    public final native int getCECListCnt(int i) throws TvCommonException;

    public final native CecSetting getCecConfiguration() throws TvCommonException;

    public final native String getDeviceName(int i) throws TvCommonException;

    public final native void routingChangeInDeviceListSetting(int i);

    public final native boolean sendCecKey(int i) throws TvCommonException;

    public final native void setCecConfiguration(CecSetting cecSetting);

    public final native void setDebugMode(boolean z) throws TvCommonException;

    static {
        _cecManager = null;
        try {
            System.loadLibrary("cecmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load cecmanager_jni library:\n" + e.toString());
        }
    }

    protected static CecManager getInstance() {
        if (_cecManager == null) {
            synchronized (CecManager.class) {
                if (_cecManager == null) {
                    _cecManager = new CecManager();
                }
            }
        }
        return _cecManager;
    }

    public void setStreamPath(EnumCecDeviceLa enCecDeviceLa) {
        native_setStreamPath(enCecDeviceLa.ordinal());
    }

    public int setMenuLanguage(EnumLanguage menuLang) throws TvCommonException {
        return native_setMenuLanguage(menuLang.ordinal());
    }

    private CecManager() {
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

    public void setOnCecEventListener(OnCecEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        CecManager srv = (CecManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeCEC callback, postEventFromNative");
        }
    }

    private static void PostEvent_ImageViewOn(Object srv_ref, int arg1, int arg2) {
        CecManager srv = (CecManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CEC_IMAGE_VIEW_ON.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCEC callback, PostEvent_ImageViewOn");
        }
    }

    private static void PostEvent_TextViewOn(Object srv_ref, int arg1, int arg2) {
        CecManager srv = (CecManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CEC_TEXT_VIEW_ON.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCEC callback, PostEvent_TextViewOn");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _cecManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _cecManager = null;
    }
}
