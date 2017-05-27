package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.listener.OnMhlEventListener;
import java.lang.ref.WeakReference;
import jcifs.smb.SmbNamedPipe;

public final class MhlManager {
    private static MhlManager _mhlManager;
    private EventHandler mEventHandler;
    private int mMhlmanagerContext;
    private int mNativeContext;
    private OnMhlEventListener mOnEventListener;

    /* renamed from: com.mstar.android.tvapi.common.MhlManager.1 */
    static /* synthetic */ class C01121 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$MhlManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$MhlManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$MhlManager$EVENT[EVENT.EV_KEY_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$MhlManager$EVENT[EVENT.EV_AUTO_SWITCH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected enum EVENT {
        EV_KEY_INFO,
        EV_AUTO_SWITCH,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private MhlManager mMSrv;

        public EventHandler(MhlManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_KEY_INFO.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01121.$SwitchMap$com$mstar$android$tvapi$common$MhlManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (MhlManager.this.mOnEventListener != null) {
                            MhlManager.this.mOnEventListener.onKeyInfo(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (MhlManager.this.mOnEventListener != null) {
                            MhlManager.this.mOnEventListener.onAutoSwitch(msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native boolean CbusStatus();

    public final native boolean IRKeyProcess(int i, boolean z);

    public final native boolean IsMhlPortInUse();

    public final native boolean getAutoSwitch();

    public final native void setAutoSwitch(boolean z);

    public final native void setDebugMode(boolean z);

    static {
        _mhlManager = null;
        try {
            System.loadLibrary("mhlmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load mhlmanager_jni library:\n" + e.toString());
        }
    }

    protected static MhlManager getInstance() {
        if (_mhlManager == null) {
            synchronized (MhlManager.class) {
                if (_mhlManager == null) {
                    _mhlManager = new MhlManager();
                }
            }
        }
        return _mhlManager;
    }

    private MhlManager() {
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

    public void setOnMhlEventListener(OnMhlEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        MhlManager srv = (MhlManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeCEC callback, postEventFromNative");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    private static void PostEvent_KeyInfo(Object srv_ref, int arg1, int arg2) {
        MhlManager srv = (MhlManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_KEY_INFO.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_AutoSwitch(Object srv_ref, int arg1, int arg2) {
        MhlManager srv = (MhlManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_AUTO_SWITCH.ordinal(), arg1, arg2));
        }
    }

    protected void release() throws Throwable {
        _mhlManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _mhlManager = null;
    }
}
