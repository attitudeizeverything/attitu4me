package com.mstar.android.tv;

import android.os.RemoteException;
import android.text.format.Time;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.PresentFollowingEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscEpgEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscProgramInfo;
import com.mstar.android.tvapi.dtv.vo.DtvEitInfo;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumEpgDescriptionType;
import com.mstar.android.tvapi.dtv.vo.EpgEventInfo;
import com.mstar.android.tvapi.dtv.vo.EpgFirstMatchHdCast;
import java.util.List;

public class TvEpgManager {
    private static final String TAG = "TvEpgManager";
    static TvEpgManager mInstance;
    private static ITvEpg mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvEpgManager() {
    }

    public static TvEpgManager getInstance() {
        if (mInstance == null) {
            synchronized (TvEpgManager.class) {
                if (mInstance == null) {
                    mInstance = new TvEpgManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvEpg getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvEpg();
        return mService;
    }

    public AtscEpgEventInfo getEventInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) {
        Log.d(TAG, "getEventInfoByTime, paras majorNumber = " + majorNumber + ", minorNumber = " + minorNumber + ", serviceNumber = " + serviceNumber + ", programId = " + programId + ", baseTime = " + baseTime);
        AtscEpgEventInfo epgEventInfo = null;
        try {
            epgEventInfo = getService().getEventInfoByTime(majorNumber, minorNumber, serviceNumber, programId, baseTime.toMillis(true));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return epgEventInfo;
    }

    public AtscEpgEventInfo getEventExtendInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) {
        Log.d(TAG, "getEventExtendInfoByTime, paras majorNumber = " + majorNumber + ", minorNumber = " + minorNumber + ", serviceNumber = " + serviceNumber + ", programId = " + programId + ", baseTime = " + baseTime);
        AtscEpgEventInfo epgEventInfo = null;
        try {
            epgEventInfo = getService().getEventExtendInfoByTime(majorNumber, minorNumber, serviceNumber, programId, baseTime.toMillis(true));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return epgEventInfo;
    }

    public void addingEpgPriority(AtscProgramInfo programInfo, int addingPriority) {
        Log.d(TAG, "addingEpgPriority, paras programInfo = " + programInfo + ", addingPriority = " + addingPriority);
        try {
            getService().addingEpgPriority(programInfo, addingPriority);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean resetEPGProgPriority() {
        try {
            return getService().resetEPGProgPriority();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEventCount(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) {
        Log.d(TAG, "getEventCount, paras majorNumber = " + majorNumber + ", minorNumber = " + minorNumber + ", serviceNumber = " + serviceNumber + ", programId = " + programId + ", baseTime = " + baseTime);
        int i = -1;
        try {
            i = getService().getEventCount(majorNumber, minorNumber, serviceNumber, programId, baseTime.toMillis(true));
            Log.d(TAG, "return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public int getIsdbEventCount(int serviceType, int serviceNo, Time baseTime) {
        Log.d(TAG, "getIsdbEventCount, serviceNo = " + serviceNo + ", baseTime = " + baseTime);
        int i = -1;
        try {
            i = getService().getIsdbEventCount(serviceType, serviceNo, baseTime.toMillis(true));
            Log.d(TAG, "return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public final EpgFirstMatchHdCast getEvent1stMatchHdBroadcast(int serviceType, int serviceNo, Time baseTime) {
        Log.d(TAG, "getEvent1stMatchHdBroadcast, serviceNo = " + serviceNo + ", baseTime = " + baseTime);
        try {
            return getService().getEvent1stMatchHdBroadcast(serviceType, serviceNo, baseTime.toMillis(true));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean beginToGetEventInformation(int serviceNumber, int majorNumber, int minorNumber, int programId) {
        try {
            return getService().beginToGetEventInformation(serviceNumber, majorNumber, minorNumber, programId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void endToGetEventInformation() {
        try {
            getService().endToGetEventInformation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public AtscEpgEventInfo getFirstEventInformation(Time baseTime) {
        try {
            return getService().getFirstEventInformation(baseTime.toMillis(true));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AtscEpgEventInfo getNextEventInformation() {
        try {
            return getService().getNextEventInformation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getEpgEventOffsetTime(Time utcTime, boolean isStartTime) {
        try {
            return getService().getEpgEventOffsetTime(utcTime.toMillis(true), isStartTime);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public DtvEitInfo getEitInfo(boolean bPresent) {
        try {
            return getService().getEitInfo(bPresent);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<EpgEventInfo> getEventInfo(short serviceType, int serviceNo, Time baseTime, int maxEventInfoCount) {
        try {
            return getService().getEventInfo(serviceType, serviceNo, baseTime.toMillis(true), maxEventInfoCount);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEventDescriptor(short serviceType, int serviceNumber, Time baseTime, EnumEpgDescriptionType epgDescriptionType) {
        try {
            return getService().getEventDescriptor(serviceType, serviceNumber, baseTime.toMillis(true), epgDescriptionType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PresentFollowingEventInfo getPresentFollowingEventInfo(short serviceType, int serviceNo, boolean present, EnumEpgDescriptionType descriptionType) {
        try {
            return getService().getPresentFollowingEventInfo(serviceType, serviceNo, present, descriptionType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean enableEpgBarkerChannel() {
        try {
            return getService().enableEpgBarkerChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableEpgBarkerChannel() {
        try {
            return getService().disableEpgBarkerChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
