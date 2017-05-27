package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.EnumSleepTimeState;
import com.mstar.android.tvapi.common.vo.EpgEventTimerInfo;
import com.mstar.android.tvapi.common.vo.OnTimeTvDescriptor;
import com.mstar.android.tvapi.common.vo.StandardTime;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumTimeZone;
import com.mstar.android.tvapi.dtv.vo.EnumEpgTimerCheck;

public class TvTimerManager {
    private static final String TAG = "TvTimerManager";
    static TvTimerManager mInstance;
    private static ITvTimer mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvTimerManager() {
    }

    public static TvTimerManager getInstance() {
        if (mInstance == null) {
            synchronized (TvTimerManager.class) {
                if (mInstance == null) {
                    mInstance = new TvTimerManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvTimer getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvTimer();
        return mService;
    }

    public StandardTime getCurTimer() {
        StandardTime time = null;
        try {
            time = getService().getCurTimer();
            Log.d(TAG, "getCurTimer:" + time.year + "." + time.month + "." + time.monthDay + "." + time.hour + "." + time.minute + "." + time.second);
            return time;
        } catch (RemoteException e) {
            e.printStackTrace();
            return time;
        }
    }

    public boolean setOnTimer(StandardTime time) {
        Log.d(TAG, "setOnTimer:" + time.year + "." + time.month + "." + time.monthDay + "." + time.hour + "." + time.minute + "." + time.second);
        try {
            return getService().setOnTimer(time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public StandardTime getOnTimer() {
        StandardTime time = null;
        try {
            time = getService().getOnTimer();
            Log.d(TAG, "getCurTimer, return StandardTime year = " + time.year + ", month = " + time.month + ", day = " + time.monthDay + ", hour = " + time.hour + ", minute = " + time.minute + ", second = " + time.second);
            return time;
        } catch (RemoteException e) {
            e.printStackTrace();
            return time;
        }
    }

    public boolean setOnTimeEvent(OnTimeTvDescriptor stEvent) {
        Log.d(TAG, "setOnTimeEvent, paras OnTimeTvDescriptor stEvent.mChNo = " + stEvent.mChNo + ", stEvent.mVol = " + stEvent.mVol + ", stEvent.enTVSrc = " + stEvent.enTVSrc);
        try {
            return getService().setOnTimeEvent(stEvent);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public OnTimeTvDescriptor getOnTimeEvent() {
        OnTimeTvDescriptor descriptor = null;
        try {
            descriptor = getService().getOnTimeEvent();
            Log.d(TAG, "setOnTimeEvent, return OnTimeTvDescriptor mChNo = " + descriptor.mChNo + ", mVol = " + descriptor.mVol + ", enTVSrc = " + descriptor.enTVSrc);
            return descriptor;
        } catch (RemoteException e) {
            e.printStackTrace();
            return descriptor;
        }
    }

    public boolean setOnTimerEnable(boolean bEnable) {
        Log.d(TAG, "setAtvChannel(), paras bEnable = " + bEnable);
        try {
            return getService().setOnTimerEnable(bEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOnTimerEnable() {
        try {
            return getService().isOnTimerEnable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setOffTimer(StandardTime time) {
        Log.d(TAG, "setOnTimer:" + time.year + "." + time.month + "." + time.monthDay + "." + time.hour + "." + time.minute + "." + time.second);
        try {
            return getService().setOffTimer(time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public StandardTime getOffTimer() {
        StandardTime time = null;
        try {
            time = getService().getOffTimer();
            Log.d(TAG, "getOffTimer:" + time.year + "." + time.month + "." + time.monthDay + "." + time.hour + "." + time.minute + "." + time.second);
            return time;
        } catch (RemoteException e) {
            e.printStackTrace();
            return time;
        }
    }

    public boolean setOffTimerEnable(boolean bEnable) {
        Log.d(TAG, "setAtvChannel(), paras bEnable = " + bEnable);
        try {
            return getService().setOffTimerEnable(bEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOffTimerEnable() {
        try {
            return getService().isOffTimerEnable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setSleepMode(EnumSleepTimeState eMode) {
        Log.d(TAG, "setSleepMode(), paras eMode = " + eMode);
        try {
            return getService().setSleepMode(eMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumSleepTimeState getSleepMode() {
        EnumSleepTimeState en = null;
        try {
            en = EnumSleepTimeState.values()[getService().getSleepMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getSleepMode(), return int " + en);
        return en;
    }

    public EnumTimeZone getTimeZone() {
        EnumTimeZone en = null;
        try {
            int iReturn = getService().getTimeZone();
            int iordinal = EnumTimeZone.getOrdinalThroughValue(iReturn);
            if (iordinal != -1) {
                en = EnumTimeZone.values()[iordinal];
            }
            Log.d(TAG, "getTimeZone(), return int " + iReturn);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return en;
    }

    public void setTimeZone(EnumTimeZone zone, boolean isSaved) {
        try {
            getService().setTimeZone(zone.ordinal(), isSaved);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getRtcClock() {
        int iReturn = 0;
        try {
            iReturn = getService().getRtcClock();
            Log.d(TAG, "getRtcClock(), return int " + iReturn);
            return iReturn;
        } catch (RemoteException e) {
            e.printStackTrace();
            return iReturn;
        }
    }

    public int getClockOffset() {
        int iReturn = 0;
        try {
            iReturn = getService().getClockOffset();
            Log.d(TAG, "getRtcClock(), return int " + iReturn);
            return iReturn;
        } catch (RemoteException e) {
            e.printStackTrace();
            return iReturn;
        }
    }

    public void setClkTime(long time, boolean isSave) {
        try {
            getService().setClkTime(time, isSave);
            Log.d(TAG, "set CLK Time");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean setAutoSync(boolean bSync) {
        boolean result = false;
        try {
            result = getService().setAutoSync(bSync);
            Log.d(TAG, "set Auto Sync");
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            return result;
        }
    }

    public void setDaylightSavingState(boolean flag) {
        try {
            getService().setDaylightSavingState(flag);
            Log.d(TAG, "set daylightsavingstate");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean getDaylightSavingState() {
        boolean result = false;
        try {
            result = getService().getDaylightSavingState();
            Log.d(TAG, "get daylightsavingstate");
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            return result;
        }
    }

    public EpgEventTimerInfo getEpgTimerEventByIndex(int index) {
        try {
            return getService().getEpgTimerEventByIndex(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getEpgTimerEventCount() {
        try {
            return getService().getEpgTimerEventCount();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public EnumEpgTimerCheck addEpgEvent(EpgEventTimerInfo vo) {
        try {
            return EnumEpgTimerCheck.values()[getService().addEpgEvent(vo)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delEpgEvent(int epgEvent) {
        try {
            return getService().delEpgEvent(epgEvent);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEpgScheduleRecordRemiderExist(int secondsFromNow) {
        try {
            return getService().isEpgScheduleRecordRemiderExist(secondsFromNow);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delAllEpgEvent() {
        try {
            return getService().delAllEpgEvent();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cancelEpgTimerEvent(int timeActing, boolean checkEndTime) {
        try {
            getService().cancelEpgTimerEvent(timeActing, checkEndTime);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EpgEventTimerInfo getEpgTimerRecordingProgram() {
        try {
            return getService().getEpgTimerRecordingProgram();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumEpgTimerCheck isEpgTimerSettingValid(EpgEventTimerInfo timerInfoVo) {
        try {
            return EnumEpgTimerCheck.values()[getService().isEpgTimerSettingValid(timerInfoVo)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
