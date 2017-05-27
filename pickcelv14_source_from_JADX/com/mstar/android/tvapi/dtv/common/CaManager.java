package com.mstar.android.tvapi.dtv.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.vo.CACardSNInfo;
import com.mstar.android.tvapi.dtv.vo.CARatingInfo;
import com.mstar.android.tvapi.dtv.vo.CaACListInfo;
import com.mstar.android.tvapi.dtv.vo.CaDetitleChkNums;
import com.mstar.android.tvapi.dtv.vo.CaEmailContentInfo;
import com.mstar.android.tvapi.dtv.vo.CaEmailHeadInfo;
import com.mstar.android.tvapi.dtv.vo.CaEmailHeadsInfo;
import com.mstar.android.tvapi.dtv.vo.CaEmailSpaceInfo;
import com.mstar.android.tvapi.dtv.vo.CaEntitleIDs;
import com.mstar.android.tvapi.dtv.vo.CaFeedDataInfo;
import com.mstar.android.tvapi.dtv.vo.CaIPPVProgramInfos;
import com.mstar.android.tvapi.dtv.vo.CaLockService;
import com.mstar.android.tvapi.dtv.vo.CaOperatorChildStatus;
import com.mstar.android.tvapi.dtv.vo.CaOperatorIds;
import com.mstar.android.tvapi.dtv.vo.CaOperatorInfo;
import com.mstar.android.tvapi.dtv.vo.CaServiceEntitles;
import com.mstar.android.tvapi.dtv.vo.CaSlotIDs;
import com.mstar.android.tvapi.dtv.vo.CaSlotInfo;
import com.mstar.android.tvapi.dtv.vo.CaStartIPPVBuyDlgInfo;
import com.mstar.android.tvapi.dtv.vo.CaStopIPPVBuyDlgInfo;
import com.mstar.android.tvapi.dtv.vo.CaWorkTimeInfo;
import com.mstar.android.widi.WidiMonitor;
import java.lang.ref.WeakReference;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public final class CaManager {
    private static CaManager _camanager;
    public static int _current_detitle_type;
    public static int _current_email_type;
    private static int _current_event;
    private static int _current_msg_type;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnCaEventListener mOnEventListener;
    private int mcamanagerContext;

    /* renamed from: com.mstar.android.tvapi.dtv.common.CaManager.1 */
    static /* synthetic */ class C01921 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT = new int[CA_EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_START_IPPV_BUY_DLG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_HIDE_IPPV_DLG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_EMAIL_NOTIFY_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_SHOW_OSD_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_HIDE_OSD_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_REQUEST_FEEDING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_SHOW_BUY_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_SHOW_FINGER_MESSAGE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_SHOW_PROGRESS_STRIP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_ACTION_REQUEST.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_ENTITLE_CHANGED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_DETITLE_RECEVIED.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_LOCKSERVICE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_UNLOCKSERVICE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[CA_EVENT.EV_CA_OTASTATE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    protected enum CA_EVENT {
        EV_CA_START_IPPV_BUY_DLG,
        EV_CA_HIDE_IPPV_DLG,
        EV_CA_EMAIL_NOTIFY_ICON,
        EV_CA_SHOW_OSD_MESSAGE,
        EV_CA_HIDE_OSD_MESSAGE,
        EV_CA_REQUEST_FEEDING,
        EV_CA_SHOW_BUY_MESSAGE,
        EV_CA_SHOW_FINGER_MESSAGE,
        EV_CA_SHOW_PROGRESS_STRIP,
        EV_CA_ACTION_REQUEST,
        EV_CA_ENTITLE_CHANGED,
        EV_CA_DETITLE_RECEVIED,
        EV_CA_LOCKSERVICE,
        EV_CA_UNLOCKSERVICE,
        EV_CA_OTASTATE,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private CaManager mMSrv;

        public EventHandler(CaManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                CA_EVENT[] ev = CA_EVENT.values();
                if (msg.what > CA_EVENT.EV_MAX.ordinal() || msg.what < CA_EVENT.EV_CA_START_IPPV_BUY_DLG.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01921.$SwitchMap$com$mstar$android$tvapi$dtv$common$CaManager$CA_EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onStartIppvBuyDlg(this.mMSrv, msg.what, msg.arg1, msg.arg2, (CaStartIPPVBuyDlgInfo) msg.obj);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onHideIPPVDlg(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onEmailNotifyIcon(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onShowOSDMessage(this.mMSrv, msg.what, msg.arg1, msg.arg2, (String) msg.obj);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onHideOSDMessage(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_DELETED /*6*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onRequestFeeding(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_INVALID /*7*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onShowBuyMessage(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_UNKNOWN /*8*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onShowFingerMessage(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.FLAGS_OFFSET /*9*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onShowProgressStrip(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onActionRequest(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onEntitleChanged(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onDetitleReceived(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onLockService(this.mMSrv, msg.what, msg.arg1, msg.arg2, (CaLockService) msg.obj);
                        }
                    case SmbConstants.SIGNATURE_OFFSET /*14*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onUNLockService(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                        if (CaManager.this.mOnEventListener != null) {
                            CaManager.this.mOnEventListener.onOtaState(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    public interface OnCaEventListener {
        boolean onActionRequest(CaManager caManager, int i, int i2, int i3);

        boolean onDetitleReceived(CaManager caManager, int i, int i2, int i3);

        boolean onEmailNotifyIcon(CaManager caManager, int i, int i2, int i3);

        boolean onEntitleChanged(CaManager caManager, int i, int i2, int i3);

        boolean onHideIPPVDlg(CaManager caManager, int i, int i2, int i3);

        boolean onHideOSDMessage(CaManager caManager, int i, int i2, int i3);

        boolean onLockService(CaManager caManager, int i, int i2, int i3, CaLockService caLockService);

        boolean onOtaState(CaManager caManager, int i, int i2, int i3);

        boolean onRequestFeeding(CaManager caManager, int i, int i2, int i3);

        boolean onShowBuyMessage(CaManager caManager, int i, int i2, int i3);

        boolean onShowFingerMessage(CaManager caManager, int i, int i2, int i3);

        boolean onShowOSDMessage(CaManager caManager, int i, int i2, int i3, String str);

        boolean onShowProgressStrip(CaManager caManager, int i, int i2, int i3);

        boolean onStartIppvBuyDlg(CaManager caManager, int i, int i2, int i3, CaStartIPPVBuyDlgInfo caStartIPPVBuyDlgInfo);

        boolean onUNLockService(CaManager caManager, int i, int i2, int i3);
    }

    public static final native short CaChangePin(String str, String str2) throws TvCommonException;

    public static final native boolean CaDelDetitleChkNum(short s, int i) throws TvCommonException;

    public static final native void CaDelEmail(int i) throws TvCommonException;

    public static final native CaACListInfo CaGetACList(short s) throws TvCommonException;

    public static final native CACardSNInfo CaGetCardSN() throws TvCommonException;

    public static final native CaDetitleChkNums CaGetDetitleChkNums(short s) throws TvCommonException;

    public static final native boolean CaGetDetitleReaded(short s) throws TvCommonException;

    public static final native CaEmailContentInfo CaGetEmailContent(int i) throws TvCommonException;

    public static final native CaEmailHeadInfo CaGetEmailHead(int i) throws TvCommonException;

    public static final native CaEmailHeadsInfo CaGetEmailHeads(short s, short s2) throws TvCommonException;

    public static final native CaEmailSpaceInfo CaGetEmailSpaceInfo() throws TvCommonException;

    public static final native CaEntitleIDs CaGetEntitleIDs(short s) throws TvCommonException;

    public static final native CaIPPVProgramInfos CaGetIPPVProgram(short s) throws TvCommonException;

    public static final native CaOperatorChildStatus CaGetOperatorChildStatus(short s) throws TvCommonException;

    public static final native CaOperatorIds CaGetOperatorIds() throws TvCommonException;

    public static final native CaOperatorInfo CaGetOperatorInfo(short s) throws TvCommonException;

    public static final native short CaGetPlatformID() throws TvCommonException;

    public static final native CARatingInfo CaGetRating() throws TvCommonException;

    public static final native CaServiceEntitles CaGetServiceEntitles(short s) throws TvCommonException;

    public static final native CaSlotIDs CaGetSlotIDs(short s) throws TvCommonException;

    public static final native CaSlotInfo CaGetSlotInfo(short s, short s2) throws TvCommonException;

    public static final native int CaGetVer() throws TvCommonException;

    public static final native CaWorkTimeInfo CaGetWorkTime() throws TvCommonException;

    public static final native short CaIsPaired(short s, String str) throws TvCommonException;

    public static final native boolean CaOTAStateConfirm(int i, int i2) throws TvCommonException;

    public static final native CaFeedDataInfo CaReadFeedDataFromParent(short s) throws TvCommonException;

    public static final native void CaRefreshInterface() throws TvCommonException;

    public static final native short CaSetRating(String str, short s) throws TvCommonException;

    public static final native short CaSetWorkTime(String str, CaWorkTimeInfo caWorkTimeInfo) throws TvCommonException;

    public static final native short CaStopIPPVBuyDlg(CaStopIPPVBuyDlgInfo caStopIPPVBuyDlgInfo) throws TvCommonException;

    public static final native short CaWriteFeedDataToChild(short s, CaFeedDataInfo caFeedDataInfo) throws TvCommonException;

    private final native void native_finalize();

    public static final native void native_init();

    private final native void native_setup(Object obj);

    static {
        try {
            System.loadLibrary("camanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load camanager_jni library:\n " + e.toString());
        }
        _camanager = null;
        _current_event = 0;
        _current_msg_type = 0;
        _current_email_type = 0;
        _current_detitle_type = 0;
    }

    public static CaManager getInstance() {
        if (_camanager == null) {
            synchronized (CaManager.class) {
                if (_camanager == null) {
                    _camanager = new CaManager();
                }
            }
        }
        return _camanager;
    }

    public static int getCurrentEvent() {
        return _current_event;
    }

    public static int getCurrentMsgType() {
        return _current_msg_type;
    }

    public static void setCurrentEvent(int CurrentEvent) {
        _current_event = CurrentEvent;
    }

    public static void setCurrentMsgType(int MsgType) {
        _current_msg_type = MsgType;
    }

    public CaManager() {
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

    public void setOnCaEventListener(OnCaEventListener listener) {
        this.mOnEventListener = listener;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n NativeCA callback, postEventFromNative");
        }
    }

    private static void PostEvent_StartIppvBuyDlg(Object srv_ref, int arg1, CaStartIPPVBuyDlgInfo arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_START_IPPV_BUY_DLG.ordinal(), arg1, 0, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_StartIppvBuyDlg");
        }
    }

    private static void PostEvent_HideIPPVDlg(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_HIDE_IPPV_DLG.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_HideIPPVDlg");
        }
    }

    private static void PostEvent_EmailNotifyIcon(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                _current_email_type = arg1;
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_EMAIL_NOTIFY_ICON.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_EmailNotifyIcon");
        }
    }

    private static void PostEvent_ShowOSDMessage(Object srv_ref, int arg1, String arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_SHOW_OSD_MESSAGE.ordinal(), arg1, 0, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_ShowOSDMessage: " + arg2);
        }
    }

    private static void PostEvent_HideOSDMessage(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_HIDE_OSD_MESSAGE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_HideOSDMessage");
        }
    }

    private static void PostEvent_RequestFeeding(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_REQUEST_FEEDING.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_RequestFeeding");
        }
    }

    private static void PostEvent_ShowBuyMessage(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                Log.i("CaManager", "//////////////////////////////////EV_CA_SHOW_BUY_MESSAGE/////////////////////////////////////////////////");
                _current_event = CA_EVENT.EV_CA_SHOW_BUY_MESSAGE.ordinal();
                _current_msg_type = arg2;
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_SHOW_BUY_MESSAGE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_ShowBuyMessage :" + arg2);
        }
    }

    private static void PostEvent_ShowFingerMessage(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_SHOW_FINGER_MESSAGE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_ShowFingerMessage");
        }
    }

    private static void PostEvent_ShowProgressStrip(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_SHOW_PROGRESS_STRIP.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_ShowProgressStrip");
        }
    }

    private static void PostEvent_ActionRequest(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_ACTION_REQUEST.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_ActionRequest");
        }
    }

    private static void PostEvent_EntitleChanged(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_ENTITLE_CHANGED.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_EntitleChanged");
        }
    }

    private static void PostEvent_DetitleReceived(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                _current_detitle_type = arg1;
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_DETITLE_RECEVIED.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_DetitleReceived");
        }
    }

    private static void PostEvent_LockService(Object srv_ref, int arg1, CaLockService arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_LOCKSERVICE.ordinal(), arg1, 0, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_LockService");
        }
    }

    private static void PostEvent_UNLockService(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_UNLOCKSERVICE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_UNLockService");
        }
    }

    private static void PostEvent_OtaState(Object srv_ref, int arg1, int arg2) {
        CaManager srv = (CaManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(CA_EVENT.EV_CA_OTASTATE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native CA callback, PostEvent_OtaState");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }
}
