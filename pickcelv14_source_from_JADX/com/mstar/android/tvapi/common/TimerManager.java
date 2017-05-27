package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumEpgTimerActType;
import com.mstar.android.tvapi.common.vo.EnumOffTimerMode;
import com.mstar.android.tvapi.common.vo.EnumSleepTimeState;
import com.mstar.android.tvapi.common.vo.EpgEventTimerInfo;
import com.mstar.android.tvapi.common.vo.TimerPowerOffModeStatus;
import com.mstar.android.tvapi.common.vo.TimerPowerOn;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumTimeZone;
import com.mstar.android.tvapi.dtv.vo.EnumEpgTimerCheck;
import com.mstar.android.widi.WidiMonitor;
import java.lang.ref.WeakReference;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public final class TimerManager {
    private static TimerManager _timerManager;
    private static OnTimerEventListener mOnEventListener;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private int mTimerManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.TimerManager.1 */
    static /* synthetic */ class C01171 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_DESTROY_COUNTDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_ONESECOND_BEAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_LASTMINUTE_WARN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_UPDATE_LASTMINUTE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_SIGNAL_LOCK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_EPG_TIME_UP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_EPGTIMER_COUNTDOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_EPGTIMER_RECORD_START.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_PVR_NOTIFY_RECORD_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_OAD_TIMESCAN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_TIMER_POWOER_EVENT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[EVENT.EV_TIMER_SYSTEMCLKCHG_EVENT.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    protected enum EVENT {
        EV_DESTROY_COUNTDOWN,
        EV_ONESECOND_BEAT,
        EV_LASTMINUTE_WARN,
        EV_UPDATE_LASTMINUTE,
        EV_SIGNAL_LOCK,
        EV_EPG_TIME_UP,
        EV_EPGTIMER_COUNTDOWN,
        EV_EPGTIMER_RECORD_START,
        EV_PVR_NOTIFY_RECORD_STOP,
        EV_OAD_TIMESCAN,
        EV_TIMER_POWOER_EVENT,
        EV_TIMER_SYSTEMCLKCHG_EVENT,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private TimerManager mMSrv;

        public EventHandler(TimerManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_DESTROY_COUNTDOWN.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01171.$SwitchMap$com$mstar$android$tvapi$common$TimerManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onDestroyCountDown(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onOneSecondBeat(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onLastMinuteWarn(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onUpdateLastMinute(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onSignalLock(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_DELETED /*6*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onEpgTimeUp(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_INVALID /*7*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onEpgTimerCountDown(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_UNKNOWN /*8*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onEpgTimerRecordStart(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.FLAGS_OFFSET /*9*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onPvrNotifyRecordStop(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onOadTimeScan(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onPowerDownTime(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                        if (TimerManager.mOnEventListener != null) {
                            TimerManager.mOnEventListener.onSystemClkChg(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    public interface OnTimerEventListener {
        boolean onDestroyCountDown(TimerManager timerManager, int i, int i2, int i3);

        boolean onEpgTimeUp(TimerManager timerManager, int i, int i2, int i3);

        boolean onEpgTimerCountDown(TimerManager timerManager, int i, int i2, int i3);

        boolean onEpgTimerRecordStart(TimerManager timerManager, int i, int i2, int i3);

        boolean onLastMinuteWarn(TimerManager timerManager, int i, int i2, int i3);

        boolean onOadTimeScan(TimerManager timerManager, int i, int i2, int i3);

        boolean onOneSecondBeat(TimerManager timerManager, int i, int i2, int i3);

        boolean onPowerDownTime(TimerManager timerManager, int i, int i2, int i3);

        boolean onPvrNotifyRecordStop(TimerManager timerManager, int i, int i2, int i3);

        boolean onSignalLock(TimerManager timerManager, int i, int i2, int i3);

        boolean onSystemClkChg(TimerManager timerManager, int i, int i2, int i3);

        boolean onUpdateLastMinute(TimerManager timerManager, int i, int i2, int i3);
    }

    private final native int native_addEpgEvent(EpgEventTimerInfo epgEventTimerInfo) throws TvCommonException;

    private native void native_disablePowerOffMode(int i) throws TvCommonException;

    private final native void native_finalize();

    private final native int native_getSleeperState() throws TvCommonException;

    private final native int native_getTimeZone() throws TvCommonException;

    private static final native void native_init();

    private final native int native_isEpgTimerSettingValid(EpgEventTimerInfo epgEventTimerInfo) throws TvCommonException;

    private final native void native_setOnTime(TimerPowerOn timerPowerOn, boolean z, boolean z2, int i) throws TvCommonException;

    private final native void native_setSleepModeTime(int i) throws TvCommonException;

    private final native void native_setTimeZone(int i, boolean z) throws TvCommonException;

    private final native void native_setup(Object obj);

    public final native void cancelEpgTimerEvent(int i, boolean z) throws TvCommonException;

    public final native Time convertSeconds2StTime(int i) throws TvCommonException;

    public final native int convertStTime2Seconds(Time time) throws TvCommonException;

    public final native boolean delAllEpgEvent() throws TvCommonException;

    public final native boolean delEpgEvent(int i) throws TvCommonException;

    public final native boolean deletePastEpgTimer() throws TvCommonException;

    public final native boolean execEpgTimerAction() throws TvCommonException;

    public final native Time getClkTime() throws TvCommonException;

    public native int getClockOffset() throws TvCommonException;

    public native boolean getDaylightSavingState() throws TvCommonException;

    public final native EpgEventTimerInfo getEpgTimerEventByIndex(int i) throws TvCommonException;

    public final native int getEpgTimerEventCount() throws TvCommonException;

    public final native EpgEventTimerInfo getEpgTimerRecordingProgram() throws TvCommonException;

    public final native int getNextNDayClkTimeInSeconds(short s) throws TvCommonException;

    public final native TimerPowerOffModeStatus getOffModeStatus() throws TvCommonException;

    public final native TimerPowerOn getOnTime() throws TvCommonException;

    public native int getRtcClock() throws TvCommonException;

    public final native short getSleepModeTime() throws TvCommonException;

    public final native Time getStClkTime() throws TvCommonException;

    public final native Time getStOnTime() throws TvCommonException;

    public final native int[] getUTCTimeOffset() throws TvCommonException;

    public final native boolean isEpgScheduleRecordRemiderExist(int i) throws TvCommonException;

    public final native boolean isTimeFormat12HRs() throws TvCommonException;

    public final native void setClkTime(Time time, boolean z) throws TvCommonException;

    public native void setDaylightSavingState(boolean z) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setOffModeStatus(TimerPowerOffModeStatus timerPowerOffModeStatus, boolean z) throws TvCommonException;

    public native void setSleepTime(int i) throws TvCommonException;

    public final native void setTimeFormat12HRs() throws TvCommonException;

    public final native void setTimeFormat24HRs() throws TvCommonException;

    static {
        _timerManager = null;
        try {
            System.loadLibrary("timermanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load timermanager_jni library:\n" + e.toString());
        }
    }

    protected static TimerManager getInstance() {
        if (_timerManager == null) {
            synchronized (TimerManager.class) {
                if (_timerManager == null) {
                    _timerManager = new TimerManager();
                }
            }
        }
        return _timerManager;
    }

    private TimerManager() {
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
        Log.d("", "looper is null " + (looper == null));
        native_setup(new WeakReference(this));
    }

    public void setOnTimerEventListener(OnTimerEventListener listener) {
        mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n Native Timer callback, postEventFromNative");
        }
    }

    private static void PostEvent_DestroyCountDown(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DESTROY_COUNTDOWN.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_DestroyCountDown");
        }
    }

    private static void PostEvent_OneSecondBeat(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ONESECOND_BEAT.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_OneSecondBeat");
        }
    }

    private static void PostEvent_LastMinuteWarn(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_LASTMINUTE_WARN.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_LastMinuteWarn");
        }
    }

    private static void PostEvent_UpdateLastMinute(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_UPDATE_LASTMINUTE.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_UpdateLastMinute");
        }
    }

    private static void PostEvent_SignalLock(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SIGNAL_LOCK.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_SignalLock");
        }
    }

    private static void PostEvent_EpgTimeUp(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EPG_TIME_UP.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_EpgTimeUp");
        }
    }

    private static void PostEvent_EpgTimerCountDown(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EPGTIMER_COUNTDOWN.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_EpgTimerCountDown");
        }
    }

    private static void PostEvent_EpgTimerRecordStart(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EPGTIMER_RECORD_START.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_EpgTimerRecordStart");
        }
    }

    private static void PostEvent_PvrNotifyRecordStop(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_RECORD_STOP.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_PvrNotifyRecordStop");
        }
    }

    private static void PostEvent_OadTimeScan(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_OAD_TIMESCAN.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_OadTimeScan");
        }
    }

    private static void PostEvent_Power(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_TIMER_POWOER_EVENT.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_Power");
        }
    }

    private static void PostEvent_SystemClkChg(Object srv_ref, int arg1, int arg2) {
        TimerManager srv = (TimerManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_TIMER_SYSTEMCLKCHG_EVENT.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Timer callback, PostEvent_SystemClkChg");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _timerManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _timerManager = null;
    }

    public final EnumTimeZone getTimeZone() throws TvCommonException {
        int iordinal = EnumTimeZone.getOrdinalThroughValue(native_getTimeZone());
        if (iordinal != -1) {
            return EnumTimeZone.values()[iordinal];
        }
        throw new TvCommonException("gettimezone  error");
    }

    public final void setTimeZone(EnumTimeZone timezone, boolean isSave) throws TvCommonException {
        native_setTimeZone(timezone.getValue(), true);
    }

    public EnumSleepTimeState getSleeperState() throws TvCommonException {
        int re = native_getSleeperState();
        if (re >= EnumSleepTimeState.E_OFF.ordinal() && re <= EnumSleepTimeState.E_TOTAL.ordinal()) {
            return EnumSleepTimeState.values()[re];
        }
        throw new TvCommonException("getSleeperState failed");
    }

    public EnumEpgTimerCheck addEpgEvent(EpgEventTimerInfo vo) throws TvCommonException {
        int iReturn = native_addEpgEvent(vo);
        if (iReturn >= EnumEpgTimerCheck.E_NONE.ordinal() && iReturn <= EnumEpgTimerCheck.E_FULL.ordinal()) {
            return EnumEpgTimerCheck.values()[iReturn];
        }
        throw new TvCommonException("native_addEpgEvent failed");
    }

    public EnumEpgTimerCheck isEpgTimerSettingValid(EpgEventTimerInfo timerInfoVo) throws TvCommonException {
        int iReturn = native_isEpgTimerSettingValid(timerInfoVo);
        if (iReturn >= EnumEpgTimerCheck.E_NONE.ordinal() && iReturn <= EnumEpgTimerCheck.E_FULL.ordinal()) {
            return EnumEpgTimerCheck.values()[iReturn];
        }
        throw new TvCommonException("isEpgTimerSettingValid failed");
    }

    public final void setOnTime(TimerPowerOn timerPowerOn, boolean bSave, boolean boot_setup, EnumEpgTimerActType enEPGTimerActionMode) throws TvCommonException {
        native_setOnTime(timerPowerOn, bSave, boot_setup, enEPGTimerActionMode.ordinal());
    }

    public void setSleepModeTime(EnumSleepTimeState enSleepTimeState) throws TvCommonException {
        native_setSleepModeTime(enSleepTimeState.ordinal());
    }

    public final void disablePowerOffMode(EnumOffTimerMode offTimerMode) throws TvCommonException {
        native_disablePowerOffMode(offTimerMode.ordinal());
    }
}
