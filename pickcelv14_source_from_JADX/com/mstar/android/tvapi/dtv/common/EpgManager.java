package com.mstar.android.tvapi.dtv.common;

import android.os.Parcel;
import android.text.format.Time;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.exception.TvNativeCallFailException;
import com.mstar.android.tvapi.common.exception.TvOutOfBoundException;
import com.mstar.android.tvapi.common.vo.EnumVideoType;
import com.mstar.android.tvapi.common.vo.PresentFollowingEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscEpgEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscProgramInfo;
import com.mstar.android.tvapi.dtv.vo.DtvEitInfo;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumAspectRatioCode;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumDtvVideoQuality;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumEpgDescriptionType;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumEpgMainGenreType;
import com.mstar.android.tvapi.dtv.vo.EpgCridEventInfo;
import com.mstar.android.tvapi.dtv.vo.EpgCridStatus;
import com.mstar.android.tvapi.dtv.vo.EpgEventInfo;
import com.mstar.android.tvapi.dtv.vo.EpgEventInfo.EnumEpgFunctionStatus;
import com.mstar.android.tvapi.dtv.vo.EpgFirstMatchHdCast;
import com.mstar.android.tvapi.dtv.vo.EpgHdSimulcast;
import com.mstar.android.tvapi.dtv.vo.EpgTrailerLinkInfo;
import com.mstar.android.tvapi.dtv.vo.NvodEventInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class EpgManager {
    private static final int FALSE = 0;
    private static final String IEPG_MANAGER = "mstar.IEpgManager";
    private static EpgManager _epgManager;
    private int mEpgManagerContext;
    private int mNativeContext;

    private final native int _addingEpgPriority(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _atsc_getEventInfoByTime(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getCridAlternateList(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getCridSeriesList(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getCridSplitList(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getCridStatus(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEitInfo(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEvent1stMatchHdBroadcast(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEvent1stMatchHdSimulcast(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventDescriptor(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventExtendInfoByTime(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventHdSimulcast(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventInfo(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private native int _getEventInfoById(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventInfoByRctLink(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getEventInfoByTime(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getFirstEventInformation(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getNextEventInformation(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getNvodTimeShiftEventInfo(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getPresentFollowingEventInfo(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native int _getRctTrailerLink(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native boolean beginGetEventInformation(int i, int i2, int i3, int i4) throws TvCommonException;

    private final native void endGetEventInformation() throws TvCommonException;

    private final native int getEpgEventOffsetTime(int i, boolean z) throws TvCommonException;

    private final native int getEventCount(int i, int i2, int i3, int i4, int i5) throws TvCommonException;

    private final native int getEventCount(short s, int i, int i2) throws TvCommonException;

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native boolean disableEpgBarkerChannel() throws TvCommonException;

    public final native boolean enableEpgBarkerChannel() throws TvCommonException;

    public final native int getNvodTimeShiftEventCount(short s, int i) throws TvCommonException;

    public final native void resetEpgProgramPriority() throws TvCommonException;

    public final native void setEpgProgramPriority(int i) throws TvCommonException;

    public final native void setEpgProgramPriority(short s, int i) throws TvCommonException;

    private EpgManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("EpgManager callback  \n");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    static {
        try {
            System.loadLibrary("epgmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load epgmanager_jni library:\n" + e.toString());
        }
        _epgManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    protected static EpgManager getInstance() {
        if (_epgManager == null) {
            synchronized (EpgManager.class) {
                if (_epgManager == null) {
                    _epgManager = new EpgManager();
                }
            }
        }
        return _epgManager;
    }

    public final ArrayList<EpgEventInfo> getEventInfo(short serviceType, int serviceNo, Time baseTime, int maxEventInfoCount) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(baseTimeX);
        request.writeInt(maxEventInfoCount);
        _getEventInfo(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgEventInfo> result = new ArrayList();
        int arrayLenth = reply.readInt();
        for (int i = FALSE; i < arrayLenth; i++) {
            EpgEventInfo arrayElement = new EpgEventInfo();
            arrayElement.startTime = reply.readInt();
            arrayElement.endTime = reply.readInt();
            arrayElement.durationTime = reply.readInt();
            arrayElement.name = reply.readString();
            arrayElement.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.isScrambled = false;
            } else {
                arrayElement.isScrambled = true;
            }
            arrayElement.genre = (short) reply.readInt();
            arrayElement.parentalRating = (short) reply.readInt();
            arrayElement.description = reply.readString();
            arrayElement.originalStartTime = reply.readInt();
            try {
                arrayElement.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final int getEventCount(short serviceType, int serviceNo, Time baseTime) throws TvCommonException {
        return getEventCount(serviceType, serviceNo, (int) (baseTime.toMillis(true) / 1000));
    }

    public final EpgEventInfo getEventInfoByTime(short serviceType, int serviceNo, Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(baseTimeX);
        _getEventInfoByTime(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        EpgEventInfo result = new EpgEventInfo();
        result.startTime = reply.readInt();
        result.endTime = reply.readInt();
        result.durationTime = reply.readInt();
        result.name = reply.readString();
        result.eventId = reply.readInt();
        if (reply.readInt() == 0) {
            result.isScrambled = false;
        } else {
            result.isScrambled = true;
        }
        result.genre = (short) reply.readInt();
        result.parentalRating = (short) reply.readInt();
        result.description = reply.readString();
        result.originalStartTime = reply.readInt();
        result.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
        request.recycle();
        reply.recycle();
        return result;
    }

    public final EpgEventInfo getEventInfoById(short serviceType, int serviceNo, short eventID) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(eventID);
        _getEventInfoById(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        EpgEventInfo result = new EpgEventInfo();
        result.startTime = reply.readInt();
        result.endTime = reply.readInt();
        result.durationTime = reply.readInt();
        result.name = reply.readString();
        result.eventId = reply.readInt();
        if (reply.readInt() == 0) {
            result.isScrambled = false;
        } else {
            result.isScrambled = true;
        }
        result.genre = (short) reply.readInt();
        result.parentalRating = (short) reply.readInt();
        result.description = reply.readString();
        result.originalStartTime = reply.readInt();
        result.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
        request.recycle();
        reply.recycle();
        return result;
    }

    public String getEventDescriptor(short serviceType, int serviceNumber, Time baseTime, EnumEpgDescriptionType epgDescriptionType) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(baseTimeX);
        request.writeInt(epgDescriptionType.ordinal());
        _getEventDescriptor(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        String result = reply.readString();
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgHdSimulcast> getEventHdSimulcast(short serviceType, int serviceNo, Time baseTime, short maxCount) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(baseTimeX);
        request.writeInt(maxCount);
        _getEventHdSimulcast(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgHdSimulcast> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgHdSimulcast arrayElement = new EpgHdSimulcast();
            EpgEventInfo epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.startTime = reply.readInt();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.endTime = reply.readInt();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.durationTime = reply.readInt();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.name = reply.readString();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.stEventInfo.isScrambled = false;
            } else {
                arrayElement.stEventInfo.isScrambled = true;
            }
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.genre = (short) reply.readInt();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.parentalRating = (short) reply.readInt();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.description = reply.readString();
            epgEventInfo = arrayElement.stEventInfo;
            epgEventInfo.originalStartTime = reply.readInt();
            try {
                int re = EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt());
                arrayElement.stEventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[re]);
                arrayElement.serviceType = (short) reply.readInt();
                arrayElement.serviceNumber = reply.readInt();
                if (reply.readInt() == 0) {
                    arrayElement.isHdEeventResolvable = false;
                } else {
                    arrayElement.isHdEeventResolvable = true;
                }
                if (reply.readInt() == 0) {
                    arrayElement.isHdServiceResolvable = false;
                } else {
                    arrayElement.isHdServiceResolvable = true;
                }
                arrayElement.serviceName = reply.readString();
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final EpgCridStatus getCridStatus(short serviceType, int serviceNumber, Time eventStartTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int eventStartTimeX = (int) (eventStartTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(eventStartTimeX);
        _getCridStatus(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        EpgCridStatus result = new EpgCridStatus();
        if (reply.readInt() == 0) {
            result.isSeries = false;
        } else {
            result.isSeries = true;
        }
        if (reply.readInt() == 0) {
            result.isSplit = false;
        } else {
            result.isSplit = true;
        }
        if (reply.readInt() == 0) {
            result.isAlternate = false;
        } else {
            result.isAlternate = true;
        }
        if (reply.readInt() == 0) {
            result.isRecommend = false;
        } else {
            result.isRecommend = true;
        }
        result.seriesCount = (short) reply.readInt();
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgCridEventInfo> getCridSeriesList(short serviceType, int serviceNumber, Time eventStartTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int eventStartTimeX = (int) (eventStartTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(eventStartTimeX);
        _getCridSeriesList(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgCridEventInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgCridEventInfo arrayElement = new EpgCridEventInfo();
            arrayElement.serviceType = (short) reply.readInt();
            arrayElement.serviceNumber = reply.readInt();
            arrayElement.eventInfo.startTime = reply.readInt();
            arrayElement.eventInfo.endTime = reply.readInt();
            arrayElement.eventInfo.durationTime = reply.readInt();
            arrayElement.eventInfo.name = reply.readString();
            arrayElement.eventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.eventInfo.isScrambled = false;
            } else {
                arrayElement.eventInfo.isScrambled = true;
            }
            arrayElement.eventInfo.genre = (short) reply.readInt();
            arrayElement.eventInfo.parentalRating = (short) reply.readInt();
            arrayElement.eventInfo.description = reply.readString();
            arrayElement.eventInfo.originalStartTime = reply.readInt();
            try {
                arrayElement.eventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgCridEventInfo> getCridSplitList(short serviceType, int serviceNumber, Time eventStartTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int eventStartTimeX = (int) (eventStartTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(eventStartTimeX);
        _getCridSplitList(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgCridEventInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgCridEventInfo arrayElement = new EpgCridEventInfo();
            arrayElement.serviceType = (short) reply.readInt();
            arrayElement.serviceNumber = reply.readInt();
            arrayElement.eventInfo.startTime = reply.readInt();
            arrayElement.eventInfo.endTime = reply.readInt();
            arrayElement.eventInfo.durationTime = reply.readInt();
            arrayElement.eventInfo.name = reply.readString();
            arrayElement.eventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.eventInfo.isScrambled = false;
            } else {
                arrayElement.eventInfo.isScrambled = true;
            }
            arrayElement.eventInfo.genre = (short) reply.readInt();
            arrayElement.eventInfo.parentalRating = (short) reply.readInt();
            arrayElement.eventInfo.description = reply.readString();
            arrayElement.eventInfo.originalStartTime = reply.readInt();
            int re = -1;
            try {
                re = EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt());
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
            arrayElement.eventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[re]);
            result.add(arrayElement);
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgCridEventInfo> getCridAlternateList(short serviceType, int serviceNumber, Time eventStartTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int eventStartTimeX = (int) (eventStartTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(eventStartTimeX);
        _getCridAlternateList(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgCridEventInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgCridEventInfo arrayElement = new EpgCridEventInfo();
            arrayElement.serviceType = (short) reply.readInt();
            arrayElement.serviceNumber = reply.readInt();
            arrayElement.eventInfo.startTime = reply.readInt();
            arrayElement.eventInfo.endTime = reply.readInt();
            arrayElement.eventInfo.durationTime = reply.readInt();
            arrayElement.eventInfo.name = reply.readString();
            arrayElement.eventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.eventInfo.isScrambled = false;
            } else {
                arrayElement.eventInfo.isScrambled = true;
            }
            arrayElement.eventInfo.genre = (short) reply.readInt();
            arrayElement.eventInfo.parentalRating = (short) reply.readInt();
            arrayElement.eventInfo.description = reply.readString();
            arrayElement.eventInfo.originalStartTime = reply.readInt();
            try {
                arrayElement.eventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgTrailerLinkInfo> getRctTrailerLink() throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        _getRctTrailerLink(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgTrailerLinkInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgTrailerLinkInfo arrayElement = new EpgTrailerLinkInfo();
            arrayElement.cridType = reply.readInt();
            arrayElement.iconId = (short) reply.readInt();
            arrayElement.pEventTitle = reply.readString();
            arrayElement.promotionText = reply.readString();
            arrayElement.trailerCrid = reply.readString();
            result.add(arrayElement);
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final ArrayList<EpgCridEventInfo> getEventInfoByRctLink(EpgTrailerLinkInfo epgTrailerLinkInfo) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        request.writeInt(epgTrailerLinkInfo.cridType);
        request.writeInt(epgTrailerLinkInfo.iconId);
        request.writeString(epgTrailerLinkInfo.pEventTitle);
        request.writeString(epgTrailerLinkInfo.promotionText);
        request.writeString(epgTrailerLinkInfo.trailerCrid);
        _getEventInfoByRctLink(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<EpgCridEventInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            EpgCridEventInfo arrayElement = new EpgCridEventInfo();
            arrayElement.serviceType = (short) reply.readInt();
            arrayElement.serviceNumber = reply.readInt();
            arrayElement.eventInfo.startTime = reply.readInt();
            arrayElement.eventInfo.endTime = reply.readInt();
            arrayElement.eventInfo.durationTime = reply.readInt();
            arrayElement.eventInfo.name = reply.readString();
            arrayElement.eventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.eventInfo.isScrambled = false;
            } else {
                arrayElement.eventInfo.isScrambled = true;
            }
            arrayElement.eventInfo.genre = (short) reply.readInt();
            arrayElement.eventInfo.parentalRating = (short) reply.readInt();
            arrayElement.eventInfo.description = reply.readString();
            arrayElement.eventInfo.originalStartTime = reply.readInt();
            try {
                arrayElement.eventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final int getEpgEventOffsetTime(Time utcTime, boolean isStartTime) throws TvCommonException {
        return getEpgEventOffsetTime((int) (utcTime.toMillis(true) / 1000), isStartTime);
    }

    public PresentFollowingEventInfo getPresentFollowingEventInfo(short serviceType, int serviceNo, boolean present, EnumEpgDescriptionType descriptionType) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        if (present) {
            request.writeInt(1);
        } else {
            request.writeInt(FALSE);
        }
        request.writeInt(descriptionType.ordinal());
        _getPresentFollowingEventInfo(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        PresentFollowingEventInfo result = new PresentFollowingEventInfo();
        result.componentInfo.setVideoType(EnumVideoType.values()[reply.readInt()]);
        if (reply.readInt() == 0) {
            result.componentInfo.mheg5Service = false;
        } else {
            result.componentInfo.mheg5Service = true;
        }
        if (reply.readInt() == 0) {
            result.componentInfo.subtitleService = false;
        } else {
            result.componentInfo.subtitleService = true;
        }
        if (reply.readInt() == 0) {
            result.componentInfo.teletextService = false;
        } else {
            result.componentInfo.teletextService = true;
        }
        if (reply.readInt() == 0) {
            result.componentInfo.ccService = false;
        } else {
            result.componentInfo.ccService = true;
        }
        result.componentInfo.setDtvVideoQuality(EnumDtvVideoQuality.values()[reply.readInt()]);
        if (reply.readInt() == 0) {
            result.componentInfo.isAd = false;
        } else {
            result.componentInfo.isAd = true;
        }
        result.componentInfo.audioTrackNum = (short) reply.readInt();
        result.componentInfo.subtitleNum = (short) reply.readInt();
        result.componentInfo.setAspectRatioCode(EnumAspectRatioCode.values()[reply.readInt()]);
        result.componentInfo.setGenreType(EnumEpgMainGenreType.values()[EnumEpgMainGenreType.getOrdinalThroughValue(reply.readInt())]);
        result.componentInfo.parentalRating = (short) reply.readInt();
        result.eventInfo.originalStartTime = reply.readInt();
        result.eventInfo.durationTime = reply.readInt();
        result.eventInfo.startTime = reply.readInt();
        result.eventInfo.endTime = reply.readInt();
        result.eventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
        result.eventInfo.name = reply.readString();
        result.eventInfo.eventId = reply.readInt();
        if (reply.readInt() == 0) {
            result.eventInfo.isScrambled = false;
        } else {
            result.eventInfo.isScrambled = true;
        }
        result.eventInfo.genre = (short) reply.readInt();
        result.eventInfo.parentalRating = (short) reply.readInt();
        result.eventInfo.description = reply.readString();
        request.recycle();
        reply.recycle();
        return result;
    }

    public final EpgFirstMatchHdCast getEvent1stMatchHdSimulcast(short serviceType, int serviceNo, Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(baseTimeX);
        _getEvent1stMatchHdSimulcast(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        EpgFirstMatchHdCast result = new EpgFirstMatchHdCast();
        result.epgEventInfoVO.startTime = reply.readInt();
        result.epgEventInfoVO.endTime = reply.readInt();
        result.epgEventInfoVO.durationTime = reply.readInt();
        result.epgEventInfoVO.name = reply.readString();
        result.epgEventInfoVO.eventId = reply.readInt();
        if (reply.readInt() == 0) {
            result.epgEventInfoVO.isScrambled = false;
        } else {
            result.epgEventInfoVO.isScrambled = true;
        }
        result.epgEventInfoVO.genre = (short) reply.readInt();
        result.epgEventInfoVO.parentalRating = (short) reply.readInt();
        result.epgEventInfoVO.description = reply.readString();
        result.epgEventInfoVO.originalStartTime = reply.readInt();
        result.epgEventInfoVO.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
        result.serviceName = reply.readString();
        if (reply.readInt() == 0) {
            result.isResolvable = false;
        } else {
            result.isResolvable = true;
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final EpgFirstMatchHdCast getEvent1stMatchHdBroadcast(short serviceType, int serviceNo, Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(serviceType);
        request.writeInt(serviceNo);
        request.writeInt(baseTimeX);
        _getEvent1stMatchHdBroadcast(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        EpgFirstMatchHdCast result = new EpgFirstMatchHdCast();
        result.epgEventInfoVO.startTime = reply.readInt();
        result.epgEventInfoVO.endTime = reply.readInt();
        result.epgEventInfoVO.durationTime = reply.readInt();
        result.epgEventInfoVO.name = reply.readString();
        result.epgEventInfoVO.eventId = reply.readInt();
        if (reply.readInt() == 0) {
            result.epgEventInfoVO.isScrambled = false;
        } else {
            result.epgEventInfoVO.isScrambled = true;
        }
        result.epgEventInfoVO.genre = (short) reply.readInt();
        result.epgEventInfoVO.parentalRating = (short) reply.readInt();
        result.epgEventInfoVO.description = reply.readString();
        result.epgEventInfoVO.originalStartTime = reply.readInt();
        result.epgEventInfoVO.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
        result.serviceName = reply.readString();
        if (reply.readInt() == 0) {
            result.isResolvable = false;
        } else {
            result.isResolvable = true;
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final DtvEitInfo getEitInfo(boolean bPresent) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        if (bPresent) {
            request.writeInt(1);
        } else {
            request.writeInt(FALSE);
        }
        _getEitInfo(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        DtvEitInfo result = new DtvEitInfo();
        result.eitCurrentEventPf.eventName = reply.readString();
        result.eitCurrentEventPf.shortEventText = reply.readString();
        result.eitCurrentEventPf.extendedEventItem = reply.readString();
        result.eitCurrentEventPf.extendedEventText = reply.readString();
        result.eitCurrentEventPf.stStartTime.set(((long) reply.readInt()) * 1000);
        result.eitCurrentEventPf.stStartTime.normalize(false);
        if (reply.readInt() == 0) {
            result.eitCurrentEventPf.isStartTimeDayLightTime = false;
        } else {
            result.eitCurrentEventPf.isStartTimeDayLightTime = true;
        }
        result.eitCurrentEventPf.stEndTime.set(((long) reply.readInt()) * 1000);
        result.eitCurrentEventPf.stEndTime.normalize(false);
        if (reply.readInt() == 0) {
            result.eitCurrentEventPf.isEndTimeDayLightTime = false;
        } else {
            result.eitCurrentEventPf.isEndTimeDayLightTime = true;
        }
        result.eitCurrentEventPf.durationInSeconds = reply.readInt();
        if (reply.readInt() == 0) {
            result.eitCurrentEventPf.isScrambled = false;
        } else {
            result.eitCurrentEventPf.isScrambled = true;
        }
        result.eitCurrentEventPf.parentalControl = (short) reply.readInt();
        result.eitCurrentEventPf.parentalObjectiveContent = (short) reply.readInt();
        result.eitCurrentEventPf.contentNibbleLevel1 = (short) reply.readInt();
        result.eitCurrentEventPf.contentNibbleLevel2 = (short) reply.readInt();
        if (reply.readInt() == 0) {
            result.present = false;
        } else {
            result.present = true;
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public ArrayList<NvodEventInfo> getNvodTimeShiftEventInfo(short serviceType, int serviceNumber, int maxEventNum, EnumEpgDescriptionType eEpgDescritionType) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        request.writeInt(serviceType);
        request.writeInt(serviceNumber);
        request.writeInt(maxEventNum);
        request.writeInt(eEpgDescritionType.ordinal());
        _getNvodTimeShiftEventInfo(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        ArrayList<NvodEventInfo> result = new ArrayList();
        int arrayLength = reply.readInt();
        for (int i = FALSE; i < arrayLength; i++) {
            NvodEventInfo arrayElement = new NvodEventInfo();
            arrayElement.epgEventInfo.startTime = reply.readInt();
            arrayElement.epgEventInfo.endTime = reply.readInt();
            arrayElement.epgEventInfo.durationTime = reply.readInt();
            arrayElement.epgEventInfo.name = reply.readString();
            arrayElement.epgEventInfo.eventId = reply.readInt();
            if (reply.readInt() == 0) {
                arrayElement.epgEventInfo.isScrambled = false;
            } else {
                arrayElement.epgEventInfo.isScrambled = true;
            }
            arrayElement.epgEventInfo.genre = (short) reply.readInt();
            arrayElement.epgEventInfo.parentalRating = (short) reply.readInt();
            arrayElement.epgEventInfo.description = reply.readString();
            arrayElement.epgEventInfo.originalStartTime = reply.readInt();
            try {
                arrayElement.epgEventInfo.setEpgFunctionStatus(EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(reply.readInt())]);
                arrayElement.timeShiftedServiceIds.originalNetworkId = reply.readInt();
                arrayElement.timeShiftedServiceIds.transportStreamId = reply.readInt();
                arrayElement.timeShiftedServiceIds.serviceId = reply.readInt();
                result.add(arrayElement);
            } catch (TvOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public final AtscEpgEventInfo getEventInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(majorNumber);
        request.writeInt(minorNumber);
        request.writeInt(serviceNumber);
        request.writeInt(programId);
        request.writeInt(baseTimeX);
        _atsc_getEventInfoByTime(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        AtscEpgEventInfo result = new AtscEpgEventInfo(reply);
        request.recycle();
        reply.recycle();
        return result;
    }

    public final AtscEpgEventInfo getEventExtendInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        int baseTimeX = (int) (baseTime.toMillis(true) / 1000);
        request.writeInt(majorNumber);
        request.writeInt(minorNumber);
        request.writeInt(serviceNumber);
        request.writeInt(programId);
        request.writeInt(baseTimeX);
        _getEventExtendInfoByTime(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        AtscEpgEventInfo result = new AtscEpgEventInfo(reply);
        request.recycle();
        reply.recycle();
        return result;
    }

    public final void addingEpgPriority(AtscProgramInfo programInfo, int addingPriority) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        programInfo.writeToParcel(request, FALSE);
        request.writeInt(addingPriority);
        _addingEpgPriority(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        request.recycle();
        reply.recycle();
    }

    public final int getEventCount(int majorNumber, int minorNumber, int serviceNumber, int programId, Time baseTime) throws TvCommonException {
        return getEventCount(majorNumber, minorNumber, serviceNumber, programId, (int) (baseTime.toMillis(true) / 1000));
    }

    public final boolean beginToGetEventInformation(int serviceNumber, int majorNumber, int minorNumber, int programId) throws TvCommonException {
        return beginGetEventInformation(serviceNumber, majorNumber, minorNumber, programId);
    }

    public final void endToGetEventInformation() throws TvCommonException {
        endGetEventInformation();
    }

    public final AtscEpgEventInfo getFirstEventInformation(Time baseTime) throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        request.writeInt((int) (baseTime.toMillis(true) / 1000));
        _getFirstEventInformation(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        AtscEpgEventInfo result = new AtscEpgEventInfo(reply);
        request.recycle();
        reply.recycle();
        return result;
    }

    public final AtscEpgEventInfo getNextEventInformation() throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        _getNextEventInformation(request, reply);
        if (reply.readInt() == 0) {
            throw new TvNativeCallFailException("funtion failed at tvservice ");
        }
        AtscEpgEventInfo result = new AtscEpgEventInfo(reply);
        request.recycle();
        reply.recycle();
        return result;
    }
}
