package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tv.IAtvPlayerEventClient.Stub;
import com.mstar.android.tvapi.atv.listener.OnAtvPlayerEventListener;
import com.mstar.android.tvapi.atv.vo.AtvEventScan;
import com.mstar.android.tvapi.atv.vo.EnumAtvManualTuneMode;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramInfo;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramInfo;
import com.mstar.android.tvapi.common.listener.OnTvPlayerEventListener;
import com.mstar.android.tvapi.common.vo.AtvSystemStandard.EnumAtvSystemStandard;
import com.mstar.android.tvapi.common.vo.EnumAntennaType;
import com.mstar.android.tvapi.common.vo.EnumAtvAudioModeType;
import com.mstar.android.tvapi.common.vo.EnumAvdVideoStandardType;
import com.mstar.android.tvapi.common.vo.EnumChannelSwitchMode;
import com.mstar.android.tvapi.common.vo.EnumFavoriteId;
import com.mstar.android.tvapi.common.vo.EnumFirstServiceInputType;
import com.mstar.android.tvapi.common.vo.EnumFirstServiceType;
import com.mstar.android.tvapi.common.vo.EnumProgramAttribute;
import com.mstar.android.tvapi.common.vo.EnumProgramCountType;
import com.mstar.android.tvapi.common.vo.EnumProgramInfoType;
import com.mstar.android.tvapi.common.vo.EnumServiceType;
import com.mstar.android.tvapi.common.vo.HbbtvEventInfo;
import com.mstar.android.tvapi.common.vo.ProgramInfo;
import com.mstar.android.tvapi.common.vo.ProgramInfoQueryCriteria;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumCountry;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;
import com.mstar.android.tvapi.dtv.listener.OnDtvPlayerEventListener;
import com.mstar.android.tvapi.dtv.vo.DtvAudioInfo;
import com.mstar.android.tvapi.dtv.vo.DtvEventScan;
import com.mstar.android.tvapi.dtv.vo.DtvSubtitleInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo.EnumInfoType;
import java.util.ArrayList;
import java.util.Iterator;

public class TvChannelManager {
    private static final String TAG = "TvChannelManager";
    static TvChannelManager mInstance;
    private static ITvChannel mService;
    private AtvPlayerEventClientCallBack atvClient;
    private ArrayList<OnAtvPlayerEventListener> atvListeners;
    private DtvPlayerEventClientCallBack dtvClient;
    private ArrayList<OnDtvPlayerEventListener> dtvListeners;
    private TvPlayerEventClientCallBack tvClient;
    private ArrayList<OnTvPlayerEventListener> tvListeners;

    private class AtvPlayerEventClientCallBack extends Stub {
        private AtvPlayerEventClientCallBack() {
        }

        public boolean onAtvAutoTuningScanInfo(int what, AtvEventScan extra) throws RemoteException {
            Iterator i$ = TvChannelManager.this.atvListeners.iterator();
            while (i$.hasNext()) {
                ((OnAtvPlayerEventListener) i$.next()).onAtvAutoTuningScanInfo(what, extra);
            }
            return true;
        }

        public boolean onAtvManualTuningScanInfo(int what, AtvEventScan extra) throws RemoteException {
            Iterator i$ = TvChannelManager.this.atvListeners.iterator();
            while (i$.hasNext()) {
                ((OnAtvPlayerEventListener) i$.next()).onAtvManualTuningScanInfo(what, extra);
            }
            return true;
        }

        public boolean onSignalLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.atvListeners.iterator();
            while (i$.hasNext()) {
                ((OnAtvPlayerEventListener) i$.next()).onSignalLock(what);
            }
            return true;
        }

        public boolean onSignalUnLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.atvListeners.iterator();
            while (i$.hasNext()) {
                ((OnAtvPlayerEventListener) i$.next()).onSignalUnLock(what);
            }
            return true;
        }

        public boolean onAtvProgramInfoReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.atvListeners.iterator();
            while (i$.hasNext()) {
                ((OnAtvPlayerEventListener) i$.next()).onAtvProgramInfoReady(what);
            }
            return true;
        }
    }

    private class DtvPlayerEventClientCallBack extends IDtvPlayerEventClient.Stub {
        private DtvPlayerEventClientCallBack() {
        }

        public boolean onDtvChannelNameReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onDtvChannelNameReady(what);
            }
            return true;
        }

        public boolean onDtvAutoTuningScanInfo(int what, DtvEventScan extra) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onDtvAutoTuningScanInfo(what, extra);
            }
            return true;
        }

        public boolean onDtvProgramInfoReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onDtvProgramInfoReady(what);
            }
            return true;
        }

        public boolean onCiLoadCredentialFail(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onCiLoadCredentialFail(what);
            }
            return true;
        }

        public boolean onEpgTimerSimulcast(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onEpgTimerSimulcast(what, arg1);
            }
            return true;
        }

        public boolean onHbbtvStatusMode(int what, boolean arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onHbbtvStatusMode(what, arg1);
            }
            return true;
        }

        public boolean onMheg5StatusMode(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onMheg5StatusMode(what, arg1);
            }
            return true;
        }

        public boolean onMheg5ReturnKey(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onMheg5ReturnKey(what, arg1);
            }
            return true;
        }

        public boolean onOadHandler(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onOadHandler(what, arg1, arg2);
            }
            return true;
        }

        public boolean onOadDownload(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onOadDownload(what, arg1);
            }
            return true;
        }

        public boolean onDtvAutoUpdateScan(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onDtvAutoUpdateScan(what);
            }
            return true;
        }

        public boolean onTsChange(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onTsChange(what);
            }
            return true;
        }

        public boolean onPopupScanDialogLossSignal(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onPopupScanDialogLossSignal(what);
            }
            return true;
        }

        public boolean onPopupScanDialogNewMultiplex(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onPopupScanDialogNewMultiplex(what);
            }
            return true;
        }

        public boolean onPopupScanDialogFrequencyChange(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onPopupScanDialogFrequencyChange(what);
            }
            return true;
        }

        public boolean onRctPresence(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onRctPresence(what);
            }
            return true;
        }

        public boolean onChangeTtxStatus(int what, boolean arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onChangeTtxStatus(what, arg1);
            }
            return true;
        }

        public boolean onDtvPriComponentMissing(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onDtvPriComponentMissing(what);
            }
            return true;
        }

        public boolean onAudioModeChange(int what, boolean arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onAudioModeChange(what, arg1);
            }
            return true;
        }

        public boolean onMheg5EventHandler(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onMheg5EventHandler(what, arg1);
            }
            return true;
        }

        public boolean onOadTimeout(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onOadTimeout(what, arg1);
            }
            return true;
        }

        public boolean onGingaStatusMode(int what, boolean arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onGingaStatusMode(what, arg1);
            }
            return true;
        }

        public boolean onSignalLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onSignalLock(what);
            }
            return true;
        }

        public boolean onSignalUnLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onSignalUnLock(what);
            }
            return true;
        }

        public boolean onUiOPRefreshQuery(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onUiOPRefreshQuery(what);
            }
            return true;
        }

        public boolean onUiOPServiceList(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onUiOPServiceList(what);
            }
            return true;
        }

        public boolean onUiOPExitServiceList(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.dtvListeners.iterator();
            while (i$.hasNext()) {
                ((OnDtvPlayerEventListener) i$.next()).onUiOPExitServiceList(what);
            }
            return true;
        }
    }

    private class TvPlayerEventClientCallBack extends ITvPlayerEventClient.Stub {
        private TvPlayerEventClientCallBack() {
        }

        public boolean onScreenSaverMode(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onScreenSaverMode(what, arg1);
            }
            return true;
        }

        public boolean onHbbtvUiEvent(int what, HbbtvEventInfo eventInfo) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onHbbtvUiEvent(what, eventInfo);
            }
            return true;
        }

        public boolean onPopupDialog(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPopupDialog(what, arg1, arg2);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackTime(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyPlaybackTime(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackSpeedChange(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyPlaybackSpeedChange(what);
            }
            return true;
        }

        public boolean onPvrNotifyRecordTime(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyRecordTime(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyRecordSize(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyRecordSize(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyRecordStop(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyRecordStop(what);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackStop(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyPlaybackStop(what);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackBegin(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyPlaybackBegin(what);
            }
            return true;
        }

        public boolean onPvrNotifyTimeShiftOverwritesBefore(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyTimeShiftOverwritesBefore(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyTimeShiftOverwritesAfter(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyTimeShiftOverwritesAfter(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyOverRun(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyOverRun(what);
            }
            return true;
        }

        public boolean onPvrNotifyUsbRemoved(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyUsbRemoved(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyCiPlusProtection(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyCiPlusProtection(what);
            }
            return true;
        }

        public boolean onPvrNotifyParentalControl(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyParentalControl(what, arg1);
            }
            return true;
        }

        public boolean onPvrNotifyAlwaysTimeShiftProgramReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyAlwaysTimeShiftProgramReady(what);
            }
            return true;
        }

        public boolean onPvrNotifyAlwaysTimeShiftProgramNotReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyAlwaysTimeShiftProgramNotReady(what);
            }
            return true;
        }

        public boolean onPvrNotifyCiPlusRetentionLimitUpdate(int what, int arg1) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onPvrNotifyCiPlusRetentionLimitUpdate(what, arg1);
            }
            return true;
        }

        public boolean onTvProgramInfoReady(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onTvProgramInfoReady(what);
            }
            return true;
        }

        public boolean onSignalLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onSignalLock(what);
            }
            return true;
        }

        public boolean onSignalUnLock(int what) throws RemoteException {
            Iterator i$ = TvChannelManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvPlayerEventListener) i$.next()).onSignalUnLock(what);
            }
            return true;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvChannelManager() {
        this.tvListeners = new ArrayList();
        this.atvListeners = new ArrayList();
        this.dtvListeners = new ArrayList();
    }

    public static TvChannelManager getInstance() {
        if (mInstance == null) {
            synchronized (TvChannelManager.class) {
                if (mInstance == null) {
                    mInstance = new TvChannelManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvChannel getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvChannel();
        return mService;
    }

    public boolean startAtvManualTuning(int EventIntervalMs, int Frequency, EnumAtvManualTuneMode eMode) {
        Log.d(TAG, "startAtvManualTuning(), paras EventIntervalMs = " + EventIntervalMs + ", Frequency = " + Frequency + ", eMode = " + eMode);
        try {
            return getService().startAtvManualTuning(EventIntervalMs, Frequency, eMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeToFirstService(EnumFirstServiceInputType enInputType, EnumFirstServiceType enServiceType) {
        Log.d(TAG, "changeToFirstService(), paras enInputType = " + enInputType + ", enServiceType = " + enServiceType);
        try {
            return getService().changeToFirstService(enInputType.ordinal(), enServiceType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void stopAtvManualTuning() {
        try {
            getService().stopAtvManualTuning();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean startAtvAutoTuning(int EventIntervalMs, int FrequencyStart, int FrequencyEnd) {
        Log.d(TAG, "startAtvAutoTuning(),  paras EventIntervalMs = " + EventIntervalMs + ", FrequencyStart = " + FrequencyStart + ", FrequencyEnd = " + FrequencyEnd);
        try {
            return getService().startAtvAutoTuning(EventIntervalMs, FrequencyStart, FrequencyEnd);
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void startATSCAtvManualTuning(int major, int minor) {
        Log.d(TAG, "startAtvManualTuning(),  major number = " + major);
        try {
            getService().startATSCAtvManualTuning(major, minor);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addProgramToFavorite(EnumFavoriteId favoriteId, int programNo, int programType, int programId) {
        Log.d(TAG, "addProgramToFavorite(), paras favoriteId = " + favoriteId + ", programNo = " + programNo + ", programType = " + programType + ", programId = " + programId);
        try {
            getService().addProgramToFavorite(favoriteId.getValue(), programNo, programType, programId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getAtvCurrentFrequency() {
        int i = -1;
        try {
            i = getService().getAtvCurrentFrequency();
            Log.d(TAG, "getAtvCurrentFrequency(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public int getAtvProgramInfo(EnumGetProgramInfo Cmd, int u16Program) {
        Log.d(TAG, "getAtvProgramInfo(), paras Cmd = " + Cmd + ", u16Program = " + u16Program);
        try {
            return getService().getAtvProgramInfo(Cmd.ordinal(), u16Program);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public EnumAtvSystemStandard getAtvSoundSystem() {
        EnumAtvSystemStandard en = null;
        try {
            en = EnumAtvSystemStandard.values()[getService().getAtvSoundSystem()];
            Log.d(TAG, "getAtvSoundSystem() , return EnumAtvSystemStandard " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public EnumAvdVideoStandardType getAtvVideoSystem() {
        EnumAvdVideoStandardType en = null;
        try {
            en = EnumAvdVideoStandardType.values()[getService().getAtvVideoSystem()];
            Log.d(TAG, "getAtvVideoSystem(), return EnumAvdVideoStandardType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public int getCurrentChannelNumber() {
        int i = -1;
        try {
            i = getService().getCurrentChannelNumber();
            Log.d(TAG, "getCurrentChannelNumber(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean stopAtvAutoTuning() {
        try {
            return getService().stopAtvAutoTuning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pauseAtvAutoTuning() {
        try {
            return getService().pauseAtvAutoTuning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resumeAtvAutoTuning() {
        try {
            return getService().resumeAtvAutoTuning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int setAtvChannel(int ChannelNumber) {
        int i = -1;
        try {
            i = getService().setAtvChannel(ChannelNumber);
            Log.d(TAG, "setAtvChannel, return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setAtvForceSoundSystem(EnumAtvSystemStandard eSoundSystem) {
        Log.d(TAG, "setAtvForceSoundSystem(), paras eSoundSystem = " + eSoundSystem);
        try {
            return getService().setAtvForceSoundSystem(eSoundSystem.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setAtvForceVedioSystem(EnumAvdVideoStandardType eVideoSystem) {
        Log.d(TAG, "setAtvForceVedioSystem(), paras eVideoSystem = " + eVideoSystem);
        try {
            return getService().setAtvForceVedioSystem(eVideoSystem.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int setAtvProgramInfo(EnumSetProgramInfo Cmd, int Program, int Param2) {
        Log.d(TAG, "setAtvProgramInfo(), paras Cmd = " + Cmd + ", Program = " + Program + ", Parma2 = " + Param2);
        int i = -1;
        try {
            i = getService().setAtvProgramInfo(Cmd.ordinal(), Program, Param2);
            Log.d(TAG, "setAtvProgramInfo(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean closeSubtitle() {
        try {
            return getService().closeSubtitle();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteProgramFromFavorite(EnumFavoriteId favoriteId, int programNo, int programType, int programId) {
        Log.d(TAG, "deleteProgramFromFavorite(), paras favoriteId = " + favoriteId + ", programNo = " + programNo + ", programType = " + programType + ", programId = " + programId);
        try {
            getService().deleteProgramFromFavorite(favoriteId.getValue(), programNo, programType, programId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean startDtvAutoScan() {
        try {
            return getService().startDtvAutoScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean startDtvFullScan() {
        try {
            return getService().startDtvFullScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getAtvStationName(int programNo) {
        Log.d(TAG, "getAtvStationName(), paras programNo = " + programNo);
        String s = null;
        try {
            s = getService().getAtvStationName(programNo);
            Log.d(TAG, "getAtvStationName(), return String " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
            return s;
        }
    }

    public int getProgramCount(EnumProgramCountType programCountType) {
        Log.d(TAG, "getProgramCount(),paras programCountType = " + programCountType);
        int i = -1;
        try {
            i = getService().getProgramCount(programCountType.ordinal());
            Log.d(TAG, "getProgramCount(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public void switchAudioTrack(int track) {
        Log.d(TAG, "switchAudioTrack(), paras track = " + track);
        try {
            getService().switchAudioTrack(track);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setSystemCountry(EnumCountry memberCountry) {
        Log.d(TAG, "setSystemCountry(), paras memberCountry = " + memberCountry);
        try {
            getService().setSystemCountry(memberCountry.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int setProgramCtrl(EnumSetProgramCtrl Cmd, int u16Param2, int u16Param3) {
        Log.d(TAG, "setProgramCtrl(), paras Cmd = " + Cmd + ", u16Param2 = " + u16Param2 + ", u16Param3 = " + u16Param3);
        int i = -1;
        try {
            i = getService().setProgramCtrl(Cmd.ordinal(), u16Param2, u16Param3);
            Log.d(TAG, "setProgramCtrl(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public void setProgramAttribute(EnumProgramAttribute enpa, int programNo, int programType, int programId) {
        Log.d(TAG, "setProgramAttribute(), paras enpa = " + enpa + ", programNo = " + programNo + ", programType = " + programType + ", programId = " + programId);
        try {
            getService().setProgramAttribute(enpa.ordinal(), programNo, programType, programId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean programDown() {
        try {
            return getService().programDown();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean programUp() {
        try {
            return getService().programUp();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean openSubtitle(int index) {
        Log.d(TAG, "openSubtitle(), paras index = " + index);
        try {
            return getService().openSubtitle(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isSignalStabled() {
        try {
            return getService().isSignalStabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumAvdVideoStandardType getVideoStandard() {
        EnumAvdVideoStandardType en = null;
        try {
            en = EnumAvdVideoStandardType.values()[getService().getVideoStandard()];
            Log.d(TAG, " getVideoStandard(), return EnumAvdVideoStandardType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean getProgramAttribute(EnumProgramAttribute enpa, int programNo, int programType, int programId) {
        Log.d(TAG, "getProgramAttribute(), paras enpa = " + enpa + ", programNo = " + programNo + ", programType = " + programType + ", programId = " + programId);
        try {
            return getService().getProgramAttribute(enpa.ordinal(), programNo, programType, programId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getProgramCtrl(EnumGetProgramCtrl Cmd, int u16Param2, int u16Param3) {
        Log.d(TAG, "getProgramCtrl(), paras Cmd = " + Cmd + ", u16Param2 = " + u16Param2 + ", u16Param3 = " + u16Param3);
        try {
            return getService().getProgramCtrl(Cmd.ordinal(), u16Param2, u16Param3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public EnumAtvAudioModeType getSIFMtsMode() {
        EnumAtvAudioModeType en = null;
        try {
            en = EnumAtvAudioModeType.values()[getService().getSIFMtsMode()];
            Log.d(TAG, "getSIFMtsMode() , return EnumAtvAudioModeType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public EnumCountry getSystemCountry() {
        EnumCountry en = null;
        try {
            en = EnumCountry.values()[getService().getSystemCountry()];
            Log.d(TAG, "getSystemCountry() , return EnumCountry " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public DtvSubtitleInfo getSubtitleInfo() {
        DtvSubtitleInfo subtitleInfo = null;
        try {
            subtitleInfo = getService().getSubtitleInfo();
            Log.d(TAG, "getSubtitleInfo(), return DtvSubtitleInfo currentSubtitleIndex = " + subtitleInfo.currentSubtitleIndex + ", subtitleServiceNumber = " + subtitleInfo.subtitleServiceNumber + ", subtitleOn = " + subtitleInfo.subtitleOn);
            return subtitleInfo;
        } catch (RemoteException e) {
            e.printStackTrace();
            return subtitleInfo;
        }
    }

    public boolean setDtvManualScanByFreq(int FrequencyKHz) {
        Log.d(TAG, "setDtvManualScanByFreq(), paras FrequencyKHz = " + FrequencyKHz);
        try {
            return getService().setDtvManualScanByFreq(FrequencyKHz);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setDtvManualScanByRF(int RFNum) {
        Log.d(TAG, "setDtvManualScanByRF(), paras RFNum = " + RFNum);
        try {
            return getService().setDtvManualScanByRF(RFNum);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pauseDtvScan() {
        try {
            return getService().pauseDtvScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean playDtvCurrentProgram() {
        try {
            return getService().playDtvCurrentProgram();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resumeDtvScan() {
        try {
            return getService().resumeDtvScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setDtvAntennaType(EnumAntennaType type) {
        Log.d(TAG, "setDtvAntennaType(), paras type = " + type);
        try {
            getService().setDtvAntennaType(type.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean startDtvManualScan() {
        try {
            return getService().startDtvManualScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopDtvScan() {
        try {
            return getService().stopDtvScan();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumLanguage getCurrentLanguageIndex(String languageCode) {
        Log.d(TAG, "getCurrentLanguageIndex(), paras languageCode = " + languageCode);
        EnumLanguage en = null;
        try {
            en = EnumLanguage.values()[getService().getCurrentLanguageIndex(languageCode)];
            Log.d(TAG, "getCurrentLanguageIndex(), return EnumLanguage " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public void setChannelChangeFreezeMode(boolean freezeMode) {
        Log.d(TAG, "setChannelChangeFreezeMode(), paras freezeMode = " + freezeMode);
        try {
            getService().setChannelChangeFreezeMode(freezeMode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean registerOnTvPlayerEventListener(OnTvPlayerEventListener listener) {
        Log.d(TAG, "registerOnTvPlayerEventListener ");
        if (this.tvClient == null) {
            this.tvClient = new TvPlayerEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskTvPlayerEventListener", this.tvClient);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.tvListeners.add(listener);
        return true;
    }

    public synchronized boolean unregisterOnTvPlayerEventListener(OnTvPlayerEventListener listener) {
        this.tvListeners.remove(listener);
        Log.d(TAG, "unregisterOnTvPlayerEventListener  size: " + this.tvListeners.size());
        if (this.tvListeners.size() == 0 && this.tvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskTvPlayerEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.tvClient = null;
        }
        return true;
    }

    public boolean registerOnDtvPlayerEventListener(OnDtvPlayerEventListener listener) {
        Log.d(TAG, "registerOnDtvPlayerEventListener ");
        if (this.dtvClient == null) {
            this.dtvClient = new DtvPlayerEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskDtvPlayerEventListener", this.dtvClient);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.dtvListeners.add(listener);
        return true;
    }

    public synchronized boolean unregisterOnDtvPlayerEventListener(OnDtvPlayerEventListener listener) {
        this.dtvListeners.remove(listener);
        Log.d(TAG, "unregisterOnDtvPlayerEventListener  size: " + this.dtvListeners.size());
        if (this.dtvListeners.size() == 0 && this.dtvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskDtvPlayerEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.dtvClient = null;
        }
        return true;
    }

    public boolean registerOnAtvPlayerEventListener(OnAtvPlayerEventListener listener) {
        Log.d(TAG, "registerOnAtvPlayerEventListener ");
        if (this.atvClient == null) {
            this.atvClient = new AtvPlayerEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskAtvPlayerEventListener", this.atvClient);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.atvListeners.add(listener);
        return true;
    }

    public synchronized boolean unregisterOnAtvPlayerEventListener(OnAtvPlayerEventListener listener) {
        this.atvListeners.remove(listener);
        if (this.atvListeners.size() == 0 && this.atvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskAtvPlayerEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.atvClient = null;
        }
        return true;
    }

    public boolean switchMSrvDtvRouteCmd(short dtvRoute) {
        Log.d(TAG, "switchMSrvDtvRouteCmd(), paras dtvRoute = " + dtvRoute);
        try {
            return getService().switchMSrvDtvRouteCmd(dtvRoute);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public RfInfo getRfInfo(EnumInfoType rfSignalInfoType, int rfChNo) {
        Log.d(TAG, "getRfInfo(), paras rfSignalInfoType = " + rfSignalInfoType + ", rfChNo = " + rfChNo);
        try {
            RfInfo result = getService().getRfInfo(rfSignalInfoType.ordinal(), rfChNo);
            Log.d(TAG, "getRfInfo, return RfInfo frequency = " + result.frequency + ", isVHF = " + result.isVHF + ", rfName = " + result.rfName + ", rfPhyNum = " + result.rfPhyNum);
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setChannelSwitchMode(EnumChannelSwitchMode eMode) {
        Log.d(TAG, "setChannelSwitchMode(), paras eMode = " + eMode);
        try {
            return getService().setChannelSwitchMode(eMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumChannelSwitchMode getChannelSwitchMode() {
        EnumChannelSwitchMode en = null;
        try {
            en = EnumChannelSwitchMode.values()[getService().getChannelSwitchMode()];
            Log.d(TAG, "getChannelSwitchMode(), return EnumChannelSwitchMode " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public ProgramInfo getProgramInfo(ProgramInfoQueryCriteria criteria, EnumProgramInfoType programInfoType) {
        ITvChannel service = getService();
        Log.d(TAG, "getProgramInfo, paras ProgramInfoQueryCriteria is " + criteria.queryIndex + " EnumProgramInfoType is " + programInfoType);
        ProgramInfo programInfo = null;
        try {
            programInfo = service.getProgramInfo(criteria, programInfoType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return programInfo;
    }

    public String getProgramName(int programNo, EnumServiceType progrmType, int programId) {
        ITvChannel service = getService();
        Log.d(TAG, "getProgramName, paras progNo is " + programNo + " progType is " + progrmType + " programId is " + programId);
        String programName = null;
        try {
            programName = service.getProgramName(programNo, progrmType.ordinal(), programId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return programName;
    }

    public DtvAudioInfo getAudioInfo() {
        try {
            return getService().getAudioInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getAudioLanguageDefaultValue() {
        try {
            return getService().getAudioLanguageDefaultValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setAudioLanguageDefaultValue(int value) {
        try {
            getService().setAudioLanguageDefaultValue(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize TvChannelManager ");
        if (this.dtvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskDtvPlayerEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (this.atvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskAtvPlayerEventListener");
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (this.tvClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskTvPlayerEventListener");
            } catch (RemoteException e22) {
                e22.printStackTrace();
            }
        }
    }
}
