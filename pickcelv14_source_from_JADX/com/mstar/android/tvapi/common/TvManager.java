package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnTvEventListener;
import com.mstar.android.tvapi.common.vo.DivxDrmRegistrationInfo;
import com.mstar.android.tvapi.common.vo.EnumDrmOpMode;
import com.mstar.android.tvapi.common.vo.EnumPowerOnLogoMode;
import com.mstar.android.tvapi.common.vo.EnumPowerOnMusicMode;
import com.mstar.android.tvapi.common.vo.EnumScreenMuteType;
import com.mstar.android.tvapi.common.vo.EnumStrCommandType;
import com.mstar.android.tvapi.common.vo.EnumUrsaUpgradeStatus;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;
import com.mstar.android.tvapi.common.vo.TvTypeInfo;
import com.mstar.android.tvapi.common.vo.UsbUpgradeCfg;
import com.mstar.android.tvapi.dtv.dvb.isdb.GingaManager;
import com.mstar.android.tvapi.dtv.dvb.vo.EnumDvbSystemType;
import com.mstar.android.tvapi.factory.FactoryManager;
import com.mstar.android.widi.WidiMonitor;
import java.lang.ref.WeakReference;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

public class TvManager {
    private static TvManager _tvManager;
    private EventHandler mEventHandler;
    private short[] mInputSrcStatus;
    private int mNativeContext;
    private OnTvEventListener mOnEventListener;
    private int mTvManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.TvManager.1 */
    static /* synthetic */ class C01181 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_DTV_READY_POPUP_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_SCARTMUTE_OSD_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_SIGNAL_UNLOCK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_SIGNAL_LOCK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_UNITY_EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_SCREEN_SAVER_MODE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_ATSC_POPUP_DIALOG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_DEATH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_PIP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_POP.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_DUALVIEW.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_TRAVELINGMODE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    protected enum EVENT {
        EV_DTV_READY_POPUP_DIALOG,
        EV_SCARTMUTE_OSD_MODE,
        EV_SIGNAL_UNLOCK,
        EV_SIGNAL_LOCK,
        EV_UNITY_EVENT,
        EV_SCREEN_SAVER_MODE,
        EV_ATSC_POPUP_DIALOG,
        EV_DEATH,
        EV_4K2K_HDMI_DISABLE_PIP,
        EV_4K2K_HDMI_DISABLE_POP,
        EV_4K2K_HDMI_DISABLE_DUALVIEW,
        EV_4K2K_HDMI_DISABLE_TRAVELINGMODE,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private TvManager mMSrv;

        public EventHandler(TvManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_DTV_READY_POPUP_DIALOG.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01181.$SwitchMap$com$mstar$android$tvapi$common$TvManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onDtvReadyPopupDialog(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onScartMuteOsdMode(msg.what);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onSignalUnlock(msg.what);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onSignalLock(msg.what);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onUnityEvent(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_DELETED /*6*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onScreenSaverMode(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_INVALID /*7*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onAtscPopupDialog(msg.what, msg.arg1, msg.arg2);
                        }
                    case SID.SID_TYPE_UNKNOWN /*8*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.onDeadthEvent(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.FLAGS_OFFSET /*9*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.on4k2kHDMIDisablePip(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.on4k2kHDMIDisablePop(msg.what, msg.arg1, msg.arg2);
                        }
                    case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.on4k2kHDMIDisableDualView(msg.what, msg.arg1, msg.arg2);
                        }
                    case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                        if (TvManager.this.mOnEventListener != null) {
                            TvManager.this.mOnEventListener.on4k2kHDMIDisableTravelingMode(msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private native boolean native_enablePowerOnLogo(int i) throws TvCommonException;

    private native void native_finalize();

    private native int native_getCurrentInputSource() throws TvCommonException;

    private native int native_getCurrentLanguageIndex(String str) throws TvCommonException;

    private native int native_getCurrentMainInputSource() throws TvCommonException;

    private native int native_getCurrentSubInputSource() throws TvCommonException;

    private native DivxDrmRegistrationInfo native_getDivxDrmRegistrationInformation(int i) throws TvCommonException;

    private native int native_getEnvironmentPowerOnLogoMode() throws TvCommonException;

    private native int native_getEnvironmentPowerOnMusicMode() throws TvCommonException;

    private native int native_getRoutePathDtvType(short s) throws TvCommonException;

    private static native void native_init();

    private native boolean native_sendStrCommand(int i, int i2, int i3) throws TvCommonException;

    private native boolean native_setEnvironmentPowerOnLogoMode(int i) throws TvCommonException;

    private native boolean native_setEnvironmentPowerOnMusicMode(int i) throws TvCommonException;

    private native boolean native_setInputSource(int i) throws TvCommonException;

    private native boolean native_setInputSource(int i, boolean z, boolean z2, boolean z3) throws TvCommonException;

    private native void native_setLanguage(int i);

    private native boolean native_setVideoMute(boolean z, int i, int i2, int i3) throws TvCommonException;

    private native void native_setup(Object obj);

    private native int native_startUrsaFirmwareUpgrade(String str) throws TvCommonException;

    public native void disableI2c(int i) throws TvCommonException;

    public native boolean disablePowerOnLogo() throws TvCommonException;

    public native boolean disablePowerOnMusic() throws TvCommonException;

    protected native void disableScartOutRgb() throws TvCommonException;

    public native void disableTvosIr() throws TvCommonException;

    public native void enableI2c(int i) throws TvCommonException;

    public native boolean enablePowerOnMusic() throws TvCommonException;

    protected native void enableScartOutRgb() throws TvCommonException;

    public native void enterSleepMode(boolean z, boolean z2) throws TvCommonException;

    public native void enterStrMode() throws TvCommonException;

    public native boolean getAllResourcesForce(boolean z);

    public native int getCurrentDtvRoute() throws TvCommonException;

    public native short getDefaultDisplay() throws TvCommonException;

    public native String getEnvironment(String str) throws TvCommonException;

    public native int getFrcVersion() throws TvCommonException;

    public native int getGpioDeviceStatus(int i) throws TvCommonException;

    public native short getSarAdcLevel(short s) throws TvCommonException;

    public native int[] getSourceList() throws TvCommonException;

    public native String getSystemBoardName() throws TvCommonException;

    public native int getSystemCurrentGammaTableNo() throws TvCommonException;

    public native String getSystemPanelName() throws TvCommonException;

    public native String getSystemSoftwareVersion() throws TvCommonException;

    public native int getSystemTotalGammaTableNo() throws TvCommonException;

    public native TvTypeInfo getTvInfo() throws TvCommonException;

    public native String getTvosInterfaceCommand() throws TvCommonException;

    public native boolean isSignalStable(int i) throws TvCommonException;

    public native boolean isTvBootFinished() throws TvCommonException;

    public native boolean isUsbUpgradeFileValid() throws TvCommonException;

    public native boolean isUsbUpgradeFileValid(String str) throws TvCommonException;

    public native void playPowerOffMusic(String str, int i) throws TvCommonException;

    public native short[] readFromEeprom(short s, int i) throws TvCommonException;

    public native short[] readFromFlashByAddr(int i, int i2) throws TvCommonException;

    public native short[] readFromFlashByBank(int i, int i2) throws TvCommonException;

    public native short[] readFromSpiFlashByAddress(int i, int i2) throws TvCommonException;

    public native short[] readFromSpiFlashByBank(int i, int i2) throws TvCommonException;

    public native void rebootSystem() throws TvCommonException;

    public native boolean resetForMbootUpgrade(String str) throws TvCommonException;

    public native boolean resetForNandUpgrade() throws TvCommonException;

    public native boolean resetForNetworkUpgrade() throws TvCommonException;

    public native boolean resetForUsbUpgrade(UsbUpgradeCfg usbUpgradeCfg) throws TvCommonException;

    public native void resetPostEvent() throws TvCommonException;

    public native boolean resetToFactoryDefault() throws TvCommonException;

    public native int searchFileInUsb(String str, String str2) throws TvCommonException;

    public native int setChannel(int i, boolean z) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    public native boolean setDefaultDisplay(short s) throws TvCommonException;

    public native boolean setEnvironment(String str, String str2) throws TvCommonException;

    public native boolean setGpioDeviceStatus(int i, boolean z) throws TvCommonException;

    public native short[] setTvosCommonCommand(String str) throws TvCommonException;

    public native boolean setTvosInterfaceCommand(String str) throws TvCommonException;

    public native boolean updateCustomerIniFile(String str, String str2) throws TvCommonException;

    public native boolean updatePanelIniFile(String str, String str2) throws TvCommonException;

    public native boolean writeToEeprom(short s, short[] sArr) throws TvCommonException;

    public native boolean writeToFlashByAddr(int i, short[] sArr) throws TvCommonException;

    public native boolean writeToFlashByBank(int i, short[] sArr) throws TvCommonException;

    public native boolean writeToSpiFlashByAddress(int i, short[] sArr) throws TvCommonException;

    public native boolean writeToSpiFlashByBank(int i, short[] sArr) throws TvCommonException;

    static {
        try {
            System.loadLibrary("tvmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load tvmanager_jni library:\n" + e.toString());
        }
        _tvManager = null;
    }

    public static TvManager getInstance() {
        if (_tvManager == null) {
            synchronized (TvManager.class) {
                if (_tvManager == null) {
                    _tvManager = new TvManager();
                }
            }
        }
        return _tvManager;
    }

    protected TvManager() {
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

    public void setOnTvEventListener(OnTvEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2));
        }
    }

    private static void PostEvent_DtvReadyPopupDialog(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_READY_POPUP_DIALOG.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_ScartMuteOsdMode(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SCARTMUTE_OSD_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SignalUnlock(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SIGNAL_UNLOCK.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SignalLock(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SIGNAL_LOCK.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_UnityEvent(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_UNITY_EVENT.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_ScreenSaverMode(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SCREEN_SAVER_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PopupDialog(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ATSC_POPUP_DIALOG.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    private static void PostEvent_4k2kHDMIDisablePip(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_PIP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisablePop(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_POP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisableDualView(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_DUALVIEW.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisableTravelingMode(Object srv_ref, int arg1, int arg2) {
        TvManager srv = (TvManager) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_TRAVELINGMODE.ordinal(), arg1, arg2));
        }
    }

    public void finalizeAllManager() throws Throwable {
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _tvManager = null;
    }

    public EnumInputSource getCurrentInputSource() throws TvCommonException {
        int iReturn = native_getCurrentInputSource();
        if (iReturn >= EnumInputSource.E_INPUT_SOURCE_VGA.ordinal() && iReturn <= EnumInputSource.E_INPUT_SOURCE_NONE.ordinal()) {
            return EnumInputSource.values()[iReturn];
        }
        throw new TvCommonException("native_getCurrentInputSource failed");
    }

    public boolean setInputSource(EnumInputSource eInputSrc, boolean bWriteDb, boolean bUpdateLock, boolean bLock) throws TvCommonException {
        return native_setInputSource(eInputSrc.ordinal(), bWriteDb, bUpdateLock, bLock);
    }

    public boolean enablePowerOnLogo(EnumPowerOnLogoMode powerOnLogoMode) throws TvCommonException {
        return native_enablePowerOnLogo(powerOnLogoMode.ordinal());
    }

    public boolean setVideoMute(boolean bScreenMute, EnumScreenMuteType enColor, int screenUnMuteTime, EnumInputSource eSrcType) throws TvCommonException {
        return native_setVideoMute(bScreenMute, enColor.ordinal(), screenUnMuteTime, eSrcType.ordinal());
    }

    public void setLanguage(EnumLanguage enLanguage) throws TvCommonException {
        native_setLanguage(enLanguage.ordinal());
    }

    public boolean setInputSource(EnumInputSource eInputSrc) throws TvCommonException {
        return native_setInputSource(eInputSrc.ordinal());
    }

    public AudioManager getAudioManager() {
        return AudioManager.getInstance();
    }

    public GingaManager getGingaManager() {
        return GingaManager.getInstance();
    }

    public CecManager getCecManager() {
        return CecManager.getInstance();
    }

    public MhlManager getMhlManager() {
        return MhlManager.getInstance();
    }

    public ParentalcontrolManager getParentalcontrolManager() {
        return ParentalcontrolManager.getInstance();
    }

    public LogoManager getLogoManager() {
        return LogoManager.getInstance();
    }

    public PvrManager getPvrManager() {
        return PvrManager.getInstance();
    }

    public PipManager getPipManager() {
        return PipManager.getInstance();
    }

    public ThreeDimensionManager getThreeDimensionManager() {
        return ThreeDimensionManager.getInstance();
    }

    public DatabaseManager getDatabaseManager() {
        return DatabaseManager.getInstance();
    }

    public TvPlayer getPlayerManager() {
        return new TvPlayerImplProxy().getPlayerImplInstance();
    }

    public ChannelManager getChannelManager() {
        return ChannelManager.getInstance();
    }

    public PictureManager getPictureManager() {
        return PictureManager.getInstance();
    }

    public TimerManager getTimerManager() {
        return TimerManager.getInstance();
    }

    public FactoryManager getFactoryManager() {
        return new TvFactoryManagerProxy().getFactoryManagerInstance();
    }

    public ScanManager getScanManager() {
        return new TvScanImplProxy().getScanImplInstance();
    }

    public EnumLanguage getCurrentLanguageIndex(String languageCode) throws TvCommonException {
        int iReturn = native_getCurrentLanguageIndex(languageCode);
        if (iReturn >= EnumLanguage.E_CZECH.ordinal() && iReturn <= EnumLanguage.E_MAX.ordinal()) {
            return EnumLanguage.values()[iReturn];
        }
        throw new TvCommonException("getCurrentLanguageIndex failed");
    }

    public EnumDvbSystemType getRoutePathDtvType(short index) throws TvCommonException {
        int iReturn = native_getRoutePathDtvType(index);
        if (iReturn >= EnumDvbSystemType.E_DVB_System_NONE.ordinal() && iReturn <= EnumDvbSystemType.E_DVB_System_NUM.ordinal()) {
            return EnumDvbSystemType.values()[iReturn];
        }
        throw new TvCommonException("native_getRoutePathDtvType failed");
    }

    public DivxDrmRegistrationInfo getDivxDrmRegistrationInformation(EnumDrmOpMode drmOpMode) throws TvCommonException {
        return native_getDivxDrmRegistrationInformation(drmOpMode.ordinal());
    }

    public EnumUrsaUpgradeStatus startUrsaFirmwareUpgrade(String fileName) throws TvCommonException {
        int iReturn = native_startUrsaFirmwareUpgrade(fileName);
        if (iReturn != -1) {
            return EnumUrsaUpgradeStatus.values()[iReturn];
        }
        throw new TvCommonException("startUrsaFirmwareUpgrade error ");
    }

    public boolean setEnvironmentPowerOnLogoMode(EnumPowerOnLogoMode eLogoMode) throws TvCommonException {
        return native_setEnvironmentPowerOnLogoMode(eLogoMode.ordinal());
    }

    public EnumPowerOnLogoMode getEnvironmentPowerOnLogoMode() throws TvCommonException {
        int iReturn = native_getEnvironmentPowerOnLogoMode();
        if (iReturn >= EnumPowerOnLogoMode.E_POWERON_LOGO_DEFAULT.ordinal() && iReturn <= EnumPowerOnLogoMode.E_POWERON_LOGO_MAX.ordinal()) {
            return EnumPowerOnLogoMode.values()[iReturn];
        }
        throw new TvCommonException("get environment value for power on logomode failed \n");
    }

    public boolean setEnvironmentPowerOnMusicMode(EnumPowerOnMusicMode eMusicMode) throws TvCommonException {
        return native_setEnvironmentPowerOnMusicMode(eMusicMode.ordinal());
    }

    public EnumPowerOnMusicMode getEnvironmentPowerOnMusicMode() throws TvCommonException {
        int iReturn = native_getEnvironmentPowerOnMusicMode();
        if (iReturn >= EnumPowerOnMusicMode.E_POWERON_MUSIC_OFF.ordinal() && iReturn <= EnumPowerOnMusicMode.E_POWERON_MUSIC_MAX.ordinal()) {
            return EnumPowerOnMusicMode.values()[iReturn];
        }
        throw new TvCommonException("get evironment for prowe on music mode failed");
    }

    public EnumInputSource getCurrentMainInputSource() throws TvCommonException {
        int iReturn = native_getCurrentMainInputSource();
        if (iReturn >= EnumInputSource.E_INPUT_SOURCE_VGA.ordinal() && iReturn <= EnumInputSource.E_INPUT_SOURCE_NONE.ordinal()) {
            return EnumInputSource.values()[iReturn];
        }
        throw new TvCommonException("native_getCurrentMainInputSource failed");
    }

    public EnumInputSource getCurrentSubInputSource() throws TvCommonException {
        int iReturn = native_getCurrentSubInputSource();
        if (iReturn >= EnumInputSource.E_INPUT_SOURCE_VGA.ordinal() && iReturn <= EnumInputSource.E_INPUT_SOURCE_NONE.ordinal()) {
            return EnumInputSource.values()[iReturn];
        }
        throw new TvCommonException("native_getCurrentSubInputSource failed");
    }

    public boolean sendStrCommand(EnumStrCommandType eCmd, int wParam, int lParam) throws TvCommonException {
        return native_sendStrCommand(eCmd.ordinal(), wParam, lParam);
    }
}
