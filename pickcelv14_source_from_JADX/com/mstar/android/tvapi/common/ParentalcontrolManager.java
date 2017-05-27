package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public final class ParentalcontrolManager {
    private static ParentalcontrolManager _parentalcontrolManager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private int mParentalcontrolManagerContext;

    private class EventHandler extends Handler {
        private ParentalcontrolManager mMSrv;

        public EventHandler(ParentalcontrolManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
            }
        }
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native int GetParentalControlRating();

    public final native int GetParentalPassword();

    public final native boolean isSystemLock();

    public final native void setParentalControlRating(int i);

    public final native void setParentalPassword(int i);

    public final native void setSystemLock(boolean z);

    static {
        _parentalcontrolManager = null;
        try {
            System.loadLibrary("parentalcontrolmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load ParentalcontrolManager_jni library:\n" + e.toString());
        }
    }

    protected static ParentalcontrolManager getInstance() {
        if (_parentalcontrolManager == null) {
            synchronized (ParentalcontrolManager.class) {
                if (_parentalcontrolManager == null) {
                    _parentalcontrolManager = new ParentalcontrolManager();
                }
            }
        }
        return _parentalcontrolManager;
    }

    private ParentalcontrolManager() {
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
        try {
            native_setup(new WeakReference(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        ParentalcontrolManager srv = (ParentalcontrolManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeCEC callback, postEventFromNative");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _parentalcontrolManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            native_finalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        _parentalcontrolManager = null;
    }
}
