package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnAudioEventListener;
import com.mstar.android.tvapi.common.vo.AdvancedSoundParameter;
import com.mstar.android.tvapi.common.vo.AtvSystemStandard.EnumAtvSystemStandard;
import com.mstar.android.tvapi.common.vo.AudioCommonInfoType.EnumAudioCommonInfoType;
import com.mstar.android.tvapi.common.vo.AudioOutParameter;
import com.mstar.android.tvapi.common.vo.DtvSoundEffect;
import com.mstar.android.tvapi.common.vo.EnumAdvancedSoundParameterType;
import com.mstar.android.tvapi.common.vo.EnumAdvancedSoundSubProcessType;
import com.mstar.android.tvapi.common.vo.EnumAdvancedSoundType;
import com.mstar.android.tvapi.common.vo.EnumAtvAudioModeType;
import com.mstar.android.tvapi.common.vo.EnumAtvInfoType;
import com.mstar.android.tvapi.common.vo.EnumAudioInputLevelSourceType;
import com.mstar.android.tvapi.common.vo.EnumAudioOutType;
import com.mstar.android.tvapi.common.vo.EnumAudioProcessorType;
import com.mstar.android.tvapi.common.vo.EnumAudioReturn;
import com.mstar.android.tvapi.common.vo.EnumAudioVolumeSourceType;
import com.mstar.android.tvapi.common.vo.EnumAuidoCaptureDeviceType;
import com.mstar.android.tvapi.common.vo.EnumAuidoCaptureSource;
import com.mstar.android.tvapi.common.vo.EnumDtvSoundMode;
import com.mstar.android.tvapi.common.vo.EnumEqualizerType;
import com.mstar.android.tvapi.common.vo.EnumKtvAudioMpegSoundMode;
import com.mstar.android.tvapi.common.vo.EnumKtvMixVolumeType;
import com.mstar.android.tvapi.common.vo.EnumMuteStatusType;
import com.mstar.android.tvapi.common.vo.EnumSoundEffectType;
import com.mstar.android.tvapi.common.vo.EnumSoundGetParameterType;
import com.mstar.android.tvapi.common.vo.EnumSoundHidevMode;
import com.mstar.android.tvapi.common.vo.EnumSoundSetParamType;
import com.mstar.android.tvapi.common.vo.EnumSpdifType;
import com.mstar.android.tvapi.common.vo.KtvInfoType.EnumKtvInfoType;
import com.mstar.android.tvapi.common.vo.MuteType.EnumMuteType;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;
import java.lang.ref.WeakReference;
import jcifs.smb.SmbNamedPipe;

public final class AudioManager {
    public static final int E_ATVPLAYER_AUTO_TUNING_RECEIVE_EVENT_INTERVAL = 800000;
    private static AudioManager _audioManager;
    private int mAudioManagerContext;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnAudioEventListener mOnEventListener;

    /* renamed from: com.mstar.android.tvapi.common.AudioManager.1 */
    static /* synthetic */ class C01101 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$AudioManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$AudioManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$AudioManager$EVENT[EVENT.EV_AP_SETVOLUME_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    protected enum EVENT {
        EV_AP_SETVOLUME_EVENT,
        EV_UNDEFINED
    }

    private class EventHandler extends Handler {
        private AudioManager mMSrv;

        public EventHandler(AudioManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_UNDEFINED.ordinal() || msg.what < EVENT.EV_AP_SETVOLUME_EVENT.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01101.$SwitchMap$com$mstar$android$tvapi$common$AudioManager$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (AudioManager.this.mOnEventListener != null) {
                            AudioManager.this.mOnEventListener.onApSetVolumeEvent(msg.what);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private final native short native_SetSoundParameter(int i, int i2, int i3);

    private native int native_checkAtvSoundSystem() throws TvCommonException;

    private final native short native_disableKtvMixModeMute(int i);

    private final native int native_disableMute(int i) throws TvCommonException;

    private native int native_enableAdvancedSoundEffect(int i, int i2) throws TvCommonException;

    private native int native_enableBasicSoundEffect(int i, boolean z) throws TvCommonException;

    private final native short native_enableKtvMixModeMute(int i);

    private final native int native_enableMute(int i) throws TvCommonException;

    private final native void native_finalize();

    private final native int native_getAdvancedSoundEffect(int i) throws TvCommonException;

    private native int native_getAtvInfo() throws TvCommonException;

    private final native int native_getAtvMtsMode() throws TvCommonException;

    private final native int native_getAtvSoundMode() throws TvCommonException;

    private final native int native_getAtvSoundSystem() throws TvCommonException;

    private native int native_getAudioLanguage1();

    private native int native_getAudioLanguage2();

    private final native byte native_getAudioVolume(int i) throws TvCommonException;

    private final native int native_getBasicSoundEffect(int i) throws TvCommonException;

    private final native int native_getDtvOutputMode() throws TvCommonException;

    private final native short native_getInputLevel(int i) throws TvCommonException;

    private final native int native_getInputSource() throws TvCommonException;

    private final native int native_getKtvSoundInfo(int i) throws TvCommonException;

    private final native int native_getSoundParameter(int i, int i2);

    private static final native void native_init();

    private final native boolean native_isMuteEnabled(int i) throws TvCommonException;

    private native void native_setADAbsoluteVolume(int i);

    private native void native_setADEnable(boolean z);

    private final native int native_setAdvancedSoundEffect(int i, AdvancedSoundParameter advancedSoundParameter) throws TvCommonException;

    private native void native_setAmplifierEqualizerByMode(int i);

    private native int native_setAtvInfo(int i, int i2) throws TvCommonException;

    private final native int native_setAtvMtsMode(int i) throws TvCommonException;

    private final native boolean native_setAtvSoundSystem(int i) throws TvCommonException;

    private final native short native_setAudioCaptureSource(int i, int i2);

    private native void native_setAudioLanguage1(int i);

    private native void native_setAudioLanguage2(int i);

    private native int native_setAudioOutput(int i, AudioOutParameter audioOutParameter) throws TvCommonException;

    private native int native_setAudioSource(int i, int i2);

    private final native void native_setAudioVolume(int i, byte b) throws TvCommonException;

    private native void native_setAutoHOHEnable(boolean z);

    private final native int native_setBasicSoundEffect(int i, DtvSoundEffect dtvSoundEffect) throws TvCommonException;

    private native boolean native_setCommonAudioInfo(int i, int i2, int i3);

    private final native void native_setDigitalOut(int i) throws TvCommonException;

    private final native void native_setDtvOutputMode(int i) throws TvCommonException;

    private final native void native_setInputLevel(int i, short s) throws TvCommonException;

    private final native void native_setInputSource(int i) throws TvCommonException;

    private final native short native_setKtvMixModeVolume(int i, short s, short s2);

    private final native short native_setKtvSoundInfo(int i, int i2, int i3) throws TvCommonException;

    private native int native_setKtvSoundTrack(int i);

    private final native boolean native_setMuteStatus(int i, int i2) throws TvCommonException;

    private final native int native_setToNextAtvMtsMode() throws TvCommonException;

    private final native void native_setup(Object obj);

    public final native short executeAmplifierExtendedCommand(short s, int i, int i2, int[] iArr) throws TvCommonException;

    public final native boolean getAutoVolume() throws TvCommonException;

    public final native boolean setAmplifierMute(boolean z) throws TvCommonException;

    public final native void setAutoVolume(boolean z) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    @Deprecated
    public final native short setSoundSpdifDelay(int i);

    @Deprecated
    public final native short setSoundSpeakerDelay(int i);

    public final native short setSpdifDelay(int i);

    public final native short setSpeakerDelay(int i);

    public final native short setSubWooferVolume(boolean z, short s) throws TvCommonException;

    static {
        _audioManager = null;
        try {
            System.loadLibrary("audiomanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load audiomanager_jni library:\n" + e.toString());
        }
    }

    protected static AudioManager getInstance() {
        if (_audioManager == null) {
            synchronized (AudioManager.class) {
                if (_audioManager == null) {
                    _audioManager = new AudioManager();
                }
            }
        }
        return _audioManager;
    }

    public void setAutoHOHEnable(boolean enable) {
        native_setAutoHOHEnable(enable);
    }

    public void setADEnable(boolean enable) {
        native_setADEnable(enable);
    }

    public void setADAbsoluteVolume(int volume) {
        native_setADAbsoluteVolume(volume);
    }

    public final byte getAudioVolume(EnumAudioVolumeSourceType volSrcType) throws TvCommonException {
        return native_getAudioVolume(volSrcType.ordinal());
    }

    public void setAudioVolume(EnumAudioVolumeSourceType volSrcType, byte volume) throws TvCommonException {
        native_setAudioVolume(volSrcType.ordinal(), volume);
    }

    public EnumAudioReturn setAudioOutput(EnumAudioOutType audioOutType, AudioOutParameter parameter) throws TvCommonException {
        int iReturn = native_setAudioOutput(audioOutType.ordinal(), parameter);
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("setAudioOutput failed");
    }

    public EnumAudioReturn enableMute(EnumMuteType enMuteType) throws TvCommonException {
        int iReturn = native_enableMute(enMuteType.getValue());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("enableMute failed");
    }

    public EnumAudioReturn disableMute(EnumMuteType enMuteType) throws TvCommonException {
        int iReturn = native_disableMute(enMuteType.getValue());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_disableMute failed");
    }

    public final boolean isMuteEnabled(EnumMuteStatusType enMuteStatusType) throws TvCommonException {
        return native_isMuteEnabled(enMuteStatusType.ordinal());
    }

    public EnumAudioReturn setAtvMtsMode(EnumAtvAudioModeType enAtvMtsMode) throws TvCommonException {
        int iReturn = native_setAtvMtsMode(enAtvMtsMode.ordinal());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_SetAtvMtsMode failed");
    }

    public EnumAtvAudioModeType getAtvMtsMode() throws TvCommonException {
        int iReturn = native_getAtvMtsMode();
        if (iReturn >= EnumAtvAudioModeType.E_ATV_AUDIOMODE_INVALID.ordinal() && iReturn <= EnumAtvAudioModeType.E_ATV_AUDIOMODE_NUM.ordinal()) {
            return EnumAtvAudioModeType.values()[iReturn];
        }
        throw new TvCommonException("native_getAtvMtsMode failed");
    }

    public EnumAtvAudioModeType getAtvSoundMode() throws TvCommonException {
        int iReturn = native_getAtvSoundMode();
        if (iReturn >= EnumAtvAudioModeType.E_ATV_AUDIOMODE_INVALID.ordinal() && iReturn <= EnumAtvAudioModeType.E_ATV_AUDIOMODE_NUM.ordinal()) {
            return EnumAtvAudioModeType.values()[iReturn];
        }
        throw new TvCommonException("native_getAtvSoundMode failed");
    }

    public boolean setAtvSoundSystem(EnumAtvSystemStandard enAtvSystemStandard) throws TvCommonException {
        return native_setAtvSoundSystem(enAtvSystemStandard.getValue());
    }

    public EnumAtvSystemStandard getAtvSoundSystem() throws TvCommonException {
        int iReturn = EnumAtvSystemStandard.getOrdinalThroughValue(native_getAtvSoundSystem());
        if (iReturn >= EnumAtvSystemStandard.E_BG.getValue() && iReturn <= EnumAtvSystemStandard.E_NUM.getValue()) {
            return EnumAtvSystemStandard.values()[iReturn];
        }
        throw new TvCommonException("getAtvSoundSystem failed");
    }

    public void setDtvOutputMode(EnumDtvSoundMode enDtvSoundMode) throws TvCommonException {
        native_setDtvOutputMode(enDtvSoundMode.ordinal());
    }

    public EnumDtvSoundMode getDtvOutputMode() throws TvCommonException {
        int iReturn = native_getDtvOutputMode();
        if (iReturn >= EnumDtvSoundMode.E_STEREO.ordinal() && iReturn <= EnumDtvSoundMode.E_NUM.ordinal()) {
            return EnumDtvSoundMode.values()[iReturn];
        }
        throw new TvCommonException("getDtvOutputMode failed");
    }

    public final EnumAudioReturn setBasicSoundEffect(EnumSoundEffectType effectType, DtvSoundEffect dtvSoundEffectVo) throws TvCommonException {
        int iReturn = native_setBasicSoundEffect(effectType.ordinal(), dtvSoundEffectVo);
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("setBasicSoundEffect failed");
    }

    public final int getBasicSoundEffect(EnumSoundGetParameterType effectType) throws TvCommonException {
        return native_getBasicSoundEffect(effectType.ordinal());
    }

    public EnumAudioReturn enableBasicSoundEffect(EnumSoundEffectType soundType, boolean enable) throws TvCommonException {
        int iReturn = native_enableBasicSoundEffect(soundType.ordinal(), enable);
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_checkAtvSoundSystem failed");
    }

    public void setInputLevel(EnumAudioInputLevelSourceType enAudioInputLevelSource, short level) throws TvCommonException {
        native_setInputLevel(enAudioInputLevelSource.ordinal(), level);
    }

    public short getInputLevel(EnumAudioInputLevelSourceType enAudioInputLevelSource) throws TvCommonException {
        return native_getInputLevel(enAudioInputLevelSource.ordinal());
    }

    public void setDigitalOut(EnumSpdifType enSpdifMode) throws TvCommonException {
        native_setDigitalOut(enSpdifMode.ordinal());
    }

    public void setInputSource(EnumInputSource enAudioInputSource) throws TvCommonException {
        native_setInputSource(enAudioInputSource.ordinal());
    }

    public EnumAudioReturn checkAtvSoundSystem() throws TvCommonException {
        int iReturn = native_checkAtvSoundSystem();
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_checkAtvSoundSystem failed");
    }

    public EnumAudioReturn setAtvInfo(EnumAtvInfoType infoType, EnumSoundHidevMode atvInfoConfig) throws TvCommonException {
        int iReturn = native_setAtvInfo(infoType.ordinal(), atvInfoConfig.ordinal());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_setAtvInfo failed");
    }

    public EnumAtvInfoType getAtvInfo() throws TvCommonException {
        int iReturn = native_getAtvInfo();
        if (iReturn >= EnumAtvInfoType.E_ATV_HIDEV_INFO.ordinal() && iReturn <= EnumAtvInfoType.E_ATV_HIDEV_INFO.ordinal()) {
            return EnumAtvInfoType.values()[iReturn];
        }
        throw new TvCommonException("native_getAtvInfo failed");
    }

    public EnumInputSource getInputSource() throws TvCommonException {
        int iReturn = native_getInputSource();
        if (iReturn >= EnumInputSource.E_INPUT_SOURCE_VGA.ordinal() && iReturn <= EnumInputSource.E_INPUT_SOURCE_NONE.ordinal()) {
            return EnumInputSource.values()[iReturn];
        }
        throw new TvCommonException("getInputSource failed");
    }

    public final boolean setMuteStatus(int screenUnMuteTime, EnumInputSource eSrcType) throws TvCommonException {
        return native_setMuteStatus(screenUnMuteTime, eSrcType.ordinal());
    }

    public EnumAudioReturn setToNextAtvMtsMode() throws TvCommonException {
        int iReturn = native_setToNextAtvMtsMode();
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("setToNextAtvMtsMode failed");
    }

    public EnumAudioReturn enableAdvancedSoundEffect(EnumAdvancedSoundType soundType, EnumAdvancedSoundSubProcessType subProcessType) throws TvCommonException {
        int iReturn = native_enableAdvancedSoundEffect(soundType.ordinal(), subProcessType.ordinal());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_enableAdvancedSoundEffect failed");
    }

    public final EnumAudioReturn setAdvancedSoundEffect(EnumAdvancedSoundParameterType advancedSoundParamType, AdvancedSoundParameter advancedSoundParameterVo) throws TvCommonException {
        int iReturn = native_setAdvancedSoundEffect(advancedSoundParamType.ordinal(), advancedSoundParameterVo);
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_setAdvancedSoundEffect failed");
    }

    public final int getAdvancedSoundEffect(EnumAdvancedSoundParameterType advancedSoundParamType) throws TvCommonException {
        return native_getAdvancedSoundEffect(advancedSoundParamType.ordinal());
    }

    public final void setAmplifierEqualizerByMode(EnumEqualizerType equalizertype) throws TvCommonException {
        native_setAmplifierEqualizerByMode(equalizertype.ordinal());
    }

    public final short setSoundParameter(EnumSoundSetParamType eSoundSetParamType, int param1, int param2) {
        return native_SetSoundParameter(eSoundSetParamType.ordinal(), param1, param2);
    }

    public final int getSoundParameter(EnumSoundSetParamType eSoundSetParamType, int param1) {
        return native_getSoundParameter(eSoundSetParamType.ordinal(), param1);
    }

    public final short setKtvMixModeVolume(EnumKtvMixVolumeType eKtvMixVolumeType, short volume1, short volume2) {
        return native_setKtvMixModeVolume(eKtvMixVolumeType.ordinal(), volume1, volume2);
    }

    public final short enableKtvMixModeMute(EnumKtvMixVolumeType eKtvMixVolumeType) {
        return native_enableKtvMixModeMute(eKtvMixVolumeType.ordinal());
    }

    public final short disableKtvMixModeMute(EnumKtvMixVolumeType eKtvMixVolumeType) {
        return native_disableKtvMixModeMute(eKtvMixVolumeType.ordinal());
    }

    public final EnumAudioReturn setAudioCaptureSource(EnumAuidoCaptureDeviceType eAudioCaptureDeviceType, EnumAuidoCaptureSource eAudioCaptureSource) throws TvCommonException {
        short iReturn = native_setAudioCaptureSource(eAudioCaptureDeviceType.ordinal(), eAudioCaptureSource.ordinal());
        if (iReturn >= EnumAudioReturn.E_RETURN_OK.ordinal() && iReturn <= EnumAudioReturn.E_RETURN_UNSUPPORT.ordinal()) {
            return EnumAudioReturn.values()[iReturn];
        }
        throw new TvCommonException("native_setAudioCaptureSource  failed");
    }

    public final short setKtvSoundInfo(EnumKtvInfoType ektvInfoType, int param1, int param2) throws TvCommonException {
        return native_setKtvSoundInfo(ektvInfoType.getValue(), param1, param2);
    }

    public final int getKtvSoundInfo(EnumKtvInfoType ektvInfoType) throws TvCommonException {
        return native_getKtvSoundInfo(ektvInfoType.getValue());
    }

    public int setKtvSoundTrack(EnumKtvAudioMpegSoundMode enSoundMode) {
        return native_setKtvSoundTrack(enSoundMode.ordinal());
    }

    public boolean setCommonAudioInfo(EnumAudioCommonInfoType audioinfoType, int param1, int param2) {
        return native_setCommonAudioInfo(audioinfoType.getValue(), param1, param2);
    }

    public int setAudioSource(EnumInputSource eInputSrc, EnumAudioProcessorType eAudioProcessType) {
        return native_setAudioSource(eInputSrc.ordinal(), eAudioProcessType.ordinal());
    }

    public void setAudioPrimaryLanguage(EnumLanguage enLanguage) {
        native_setAudioLanguage1(enLanguage.ordinal());
    }

    public void setAudioSecondaryLanguage(EnumLanguage enLanguage) {
        native_setAudioLanguage2(enLanguage.ordinal());
    }

    public EnumLanguage getAudioPrimaryLanguage() {
        try {
            return EnumLanguage.values()[native_getAudioLanguage1()];
        } catch (Exception e) {
            return EnumLanguage.E_ENGLISH;
        }
    }

    public EnumLanguage getAudioSecondaryLanguage() {
        try {
            return EnumLanguage.values()[native_getAudioLanguage2()];
        } catch (Exception e) {
            return EnumLanguage.E_ENGLISH;
        }
    }

    private AudioManager() {
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

    public void setOnAudioEventListener(OnAudioEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        AudioManager srv = (AudioManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n Native Audio callback , postEventFromNative");
        }
    }

    private static void PostEvent_ApSetVolume(Object srv_ref, int arg1, int arg2) {
        AudioManager srv = (AudioManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_AP_SETVOLUME_EVENT.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Audio callback, PostEvent_ApSetVolume");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _audioManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _audioManager = null;
    }
}
