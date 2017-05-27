package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import java.lang.ref.WeakReference;

public final class LogoManager {
    private static LogoManager _logoManager;
    private int mLogoManagerContext;
    private int mNativeContext;

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native void hideBusyAnimation() throws TvCommonException;

    public final native void showBusyAnimation() throws TvCommonException;

    static {
        _logoManager = null;
        try {
            System.loadLibrary("logomanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load logomanager_jni library:\n" + e.toString());
        }
    }

    protected static LogoManager getInstance() {
        if (_logoManager == null) {
            synchronized (LogoManager.class) {
                if (_logoManager == null) {
                    _logoManager = new LogoManager();
                }
            }
        }
        return _logoManager;
    }

    private LogoManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("\n NativeLogoManager callback");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _logoManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _logoManager = null;
    }
}
