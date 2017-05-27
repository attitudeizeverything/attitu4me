package com.mstar.android.tvapi.dtv.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.vo.EnumCardState;
import com.mstar.android.tvapi.dtv.vo.EnumMmiType;
import java.lang.ref.WeakReference;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public final class CiManager {
    private static CiManager _cimanager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnCiEventListener mOnEventListener;
    private int mcimanagerContext;

    /* renamed from: com.mstar.android.tvapi.dtv.common.CiManager.1 */
    static /* synthetic */ class C01931 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[EVENT.EV_CIMMI_UI_DATA_READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[EVENT.EV_CIMMI_UI_CLOSEMMI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[EVENT.EV_CIMMI_UI_CARD_INSERTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[EVENT.EV_CIMMI_UI_CARD_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[EVENT.EV_CIMMI_UI_AUTOTEST_MESSAGE_SHOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static class CredentialValidDateRange {
        public int validFromDate;
        public int validToDate;
    }

    protected enum EVENT {
        EV_CIMMI_UI_DATA_READY,
        EV_CIMMI_UI_CLOSEMMI,
        EV_CIMMI_UI_CARD_INSERTED,
        EV_CIMMI_UI_CARD_REMOVED,
        EV_CIMMI_UI_AUTOTEST_MESSAGE_SHOWN,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private CiManager mMSrv;

        public EventHandler(CiManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_CIMMI_UI_DATA_READY.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01931.$SwitchMap$com$mstar$android$tvapi$dtv$common$CiManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (CiManager.this.mOnEventListener != null) {
                            CiManager.this.mOnEventListener.onUiDataReady(this.mMSrv, msg.what);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (CiManager.this.mOnEventListener != null) {
                            CiManager.this.mOnEventListener.onUiCloseMmi(this.mMSrv, msg.what);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (CiManager.this.mOnEventListener != null) {
                            CiManager.this.mOnEventListener.onUiCardInserted(this.mMSrv, msg.what);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (CiManager.this.mOnEventListener != null) {
                            CiManager.this.mOnEventListener.onUiCardRemoved(this.mMSrv, msg.what);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (CiManager.this.mOnEventListener != null) {
                            CiManager.this.mOnEventListener.onUiAutotestMessageShown(this.mMSrv, msg.what);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    public interface OnCiEventListener {
        boolean onUiAutotestMessageShown(CiManager ciManager, int i);

        boolean onUiCardInserted(CiManager ciManager, int i);

        boolean onUiCardRemoved(CiManager ciManager, int i);

        boolean onUiCloseMmi(CiManager ciManager, int i);

        boolean onUiDataReady(CiManager ciManager, int i);
    }

    private final native void native_finalize();

    private final native int native_getCardState() throws TvCommonException;

    private final native int native_getMMIType() throws TvCommonException;

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native boolean answerEnq(String str) throws TvCommonException;

    public final native void answerMenu(short s) throws TvCommonException;

    public final native boolean backEnq() throws TvCommonException;

    public final native void backMenu() throws TvCommonException;

    public native void ciClearOPSearchSuspended() throws TvCommonException;

    public final native void close() throws TvCommonException;

    public native boolean deleteOpCacheByCicamId(int i) throws TvCommonException;

    public native boolean deleteOpCacheByIndex(short s) throws TvCommonException;

    public native boolean enterCiOperatorProfile(short s) throws TvCommonException;

    public final native void enterMenu() throws TvCommonException;

    public native void exitCiOperatorProfile() throws TvCommonException;

    public final native CredentialValidDateRange getCiCredentialValidRange() throws TvCommonException;

    public native int getCurrentOpCicamId() throws TvCommonException;

    public native short getCurrentOpIndexByCicamId(int i) throws TvCommonException;

    public final native short getEnqAnsLength() throws TvCommonException;

    public final native short getEnqBlindAnswer() throws TvCommonException;

    public final native short getEnqLength() throws TvCommonException;

    public final native String getEnqString() throws TvCommonException;

    public final native int getListBottomLength() throws TvCommonException;

    public final native String getListBottomString() throws TvCommonException;

    public final native short getListChoiceNumber() throws TvCommonException;

    public final native String getListSelectionString(int i) throws TvCommonException;

    public final native int getListSubtitleLength() throws TvCommonException;

    public native String getListSubtitleString() throws TvCommonException;

    public final native int getListTitleLength() throws TvCommonException;

    public native String getListTitleString() throws TvCommonException;

    public final native int getMenuBottomLength() throws TvCommonException;

    public final native String getMenuBottomString() throws TvCommonException;

    public final native short getMenuChoiceNumber() throws TvCommonException;

    public final native String getMenuSelectionString(int i) throws TvCommonException;

    public final native String getMenuString() throws TvCommonException;

    public final native int getMenuSubtitleLength() throws TvCommonException;

    public final native String getMenuSubtitleString() throws TvCommonException;

    public final native int getMenuTitleLength() throws TvCommonException;

    public final native String getMenuTitleString() throws TvCommonException;

    public native short getOpCacheCount() throws TvCommonException;

    public native short getOpDtvSysTypeByIndex(short s) throws TvCommonException;

    public native int getOpIso639LangCodeByCicamId(int i) throws TvCommonException;

    public native String getOpProfileNameByIndex(short s) throws TvCommonException;

    public final native boolean isCiCredentialModeValid(short s) throws TvCommonException;

    public final native boolean isCiMenuOn() throws TvCommonException;

    public final native boolean isDataExisted() throws TvCommonException;

    public native boolean isOpMode() throws TvCommonException;

    public native boolean isOpTuning() throws TvCommonException;

    public native boolean resetOPCacheDB(boolean z) throws TvCommonException;

    public native boolean sendCiOpSearchCancel() throws TvCommonException;

    public native boolean sendCiOpSearchStart(boolean z) throws TvCommonException;

    public final native void setCiCredentialMode(short s) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    public native boolean updateOpCurrentServiceTripleId() throws TvCommonException;

    public EnumMmiType getMmiType() throws TvCommonException {
        int re = native_getMMIType();
        if (re >= 0 && re <= EnumMmiType.E_MAX.ordinal()) {
            return EnumMmiType.values()[re];
        }
        throw new TvCommonException("getMMIType failed");
    }

    public EnumCardState getCardState() throws TvCommonException {
        int re = native_getCardState();
        if (re >= EnumCardState.E_NO.ordinal() && re <= EnumCardState.E_MAX.ordinal()) {
            return EnumCardState.values()[re];
        }
        throw new TvCommonException("getCardState failed");
    }

    static {
        try {
            System.loadLibrary("cimanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load cimanager_jni library:\n" + e.toString());
        }
        _cimanager = null;
    }

    protected static CiManager getInstance() {
        if (_cimanager == null) {
            synchronized (CiManager.class) {
                if (_cimanager == null) {
                    _cimanager = new CiManager();
                }
            }
        }
        return _cimanager;
    }

    private CiManager() {
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

    public void setOnCiEventListener(OnCiEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeCI callback, postEventFromNative");
        }
    }

    private static void PostEvent_DataReady(Object srv_ref, int arg1, int arg2) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CIMMI_UI_DATA_READY.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_DataReady");
        }
    }

    private static void PostEvent_CloseMmi(Object srv_ref, int arg1, int arg2) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CIMMI_UI_CLOSEMMI.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_CloseMmi");
        }
    }

    private static void PostEvent_CardInserted(Object srv_ref, int arg1, int arg2) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CIMMI_UI_CARD_INSERTED.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_CardInserted");
        }
    }

    private static void PostEvent_CardRemoved(Object srv_ref, int arg1, int arg2) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CIMMI_UI_CARD_REMOVED.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_CardRemoved");
        }
    }

    private static void PostEvent_AutotestMessageShown(Object srv_ref, int arg1, int arg2) {
        CiManager srv = (CiManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CIMMI_UI_AUTOTEST_MESSAGE_SHOWN.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_AutotestMessageShown");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }
}
