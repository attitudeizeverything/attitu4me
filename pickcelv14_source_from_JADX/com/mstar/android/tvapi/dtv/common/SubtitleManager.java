package com.mstar.android.tvapi.dtv.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.vo.DtvSubtitleInfo;
import java.lang.ref.WeakReference;

public final class SubtitleManager {
    private static SubtitleManager _subtitlemanager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnSubtitleEventListener mOnEventListener;
    private int mSubtitleManagerContext;

    private class EventHandler extends Handler {
        private SubtitleManager mMSrv;

        public EventHandler(SubtitleManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
            }
        }
    }

    public interface OnSubtitleEventListener {
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public native boolean closeSubtitle() throws TvCommonException;

    public native DtvSubtitleInfo getSubtitleInfo() throws TvCommonException;

    public native boolean openSubtitle(int i) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    static {
        try {
            System.loadLibrary("subtitlemanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load subtitlemanager_jni library:\n" + e.toString());
        }
        _subtitlemanager = null;
    }

    protected static SubtitleManager getInstance() {
        if (_subtitlemanager == null) {
            synchronized (SubtitleManager.class) {
                if (_subtitlemanager == null) {
                    _subtitlemanager = new SubtitleManager();
                }
            }
        }
        return _subtitlemanager;
    }

    private SubtitleManager() {
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

    public void setOnSubtitleEventListener(OnSubtitleEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        SubtitleManager srv = (SubtitleManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeSubtitle callback, postEventFromNative");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }
}
