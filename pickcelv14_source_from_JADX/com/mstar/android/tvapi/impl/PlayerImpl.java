package com.mstar.android.tvapi.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.mstar.android.camera.MCamera.Parameters;
import com.mstar.android.media.MstMediaMetadataRetriever;
import com.mstar.android.samba.OnRecvMsg;
import com.mstar.android.tvapi.atv.AtvPlayer;
import com.mstar.android.tvapi.atv.listener.OnAtvPlayerEventListener;
import com.mstar.android.tvapi.atv.vo.AtvEventScan;
import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnTvPlayerEventListener;
import com.mstar.android.tvapi.common.vo.CaptionOptionSetting;
import com.mstar.android.tvapi.common.vo.DtvProgramSignalInfo;
import com.mstar.android.tvapi.common.vo.EnumAntennaType;
import com.mstar.android.tvapi.common.vo.EnumAvdVideoStandardType;
import com.mstar.android.tvapi.common.vo.EnumStdDetectionState;
import com.mstar.android.tvapi.common.vo.EnumTeletextCommand;
import com.mstar.android.tvapi.common.vo.EnumTeletextMode;
import com.mstar.android.tvapi.common.vo.HbbtvEventInfo;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumCountry;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumTimeZone;
import com.mstar.android.tvapi.common.vo.VideoArcInfo;
import com.mstar.android.tvapi.common.vo.VideoInfo;
import com.mstar.android.tvapi.dtv.atsc.AtscPlayer;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscScanChannelNotify;
import com.mstar.android.tvapi.dtv.atsc.vo.AudioMuteType.EnumAudioMuteType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaEngRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaFreRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumUsaTvRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumVChipRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaMpaaRatingType.EnumUsaMpaaRatingType;
import com.mstar.android.tvapi.dtv.dvb.DvbPlayer;
import com.mstar.android.tvapi.dtv.dvb.dvbc.DtvDemodDvbcInfo;
import com.mstar.android.tvapi.dtv.dvb.dvbc.vo.EnumChinaDvbcRegion;
import com.mstar.android.tvapi.dtv.dvb.dvbt.DtvDemodDvbtInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbMuxInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.EnumCurrentEventStatus;
import com.mstar.android.tvapi.dtv.listener.OnDtvPlayerEventListener;
import com.mstar.android.tvapi.dtv.vo.DtvAudioInfo;
import com.mstar.android.tvapi.dtv.vo.DtvDemodType;
import com.mstar.android.tvapi.dtv.vo.DtvDemodVersion;
import com.mstar.android.tvapi.dtv.vo.DtvEventScan;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumDtvSetAudioMode;
import com.mstar.android.tvapi.dtv.vo.EnumParentalRating;
import com.mstar.android.tvapi.dtv.vo.MwAtscEasInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo.EnumInfoType;
import com.mstar.android.widi.WidiMonitor;
import java.lang.ref.WeakReference;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;

public class PlayerImpl implements AtvPlayer, DvbPlayer, AtscPlayer {
    private static PlayerImpl _playerImpl;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private int mNativeSurfaceTexture;
    private OnAtvPlayerEventListener mOnAtvPlayerEventListener;
    private OnDtvPlayerEventListener mOnDtvPlayerEventListener;
    private OnTvPlayerEventListener mOnTvPlayerEventListener;
    private int mPlayerContext;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;

    /* renamed from: com.mstar.android.tvapi.impl.PlayerImpl.1 */
    static /* synthetic */ class C02381 {
        static final /* synthetic */ int[] f62x5c30a25b;
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_CHANNELNAME_READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_ATV_AUTO_TUNING_SCAN_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_ATV_MANUAL_TUNING_SCAN_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_AUTO_TUNING_SCAN_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_PROGRAM_INFO_READY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_SIGNAL_LOCK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_SIGNAL_UNLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_POPUP_DIALOG.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_SCREEN_SAVER_MODE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_CI_LOAD_CREDENTIAL_FAIL.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_EPGTIMER_SIMULCAST.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_HBBTV_STATUS_MODE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_MHEG5_STATUS_MODE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_MHEG5_RETURN_KEY.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_OAD_HANDLER.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_OAD_DOWNLOAD.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_TIME.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_SPEED_CHANGE.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_RECORD_TIME.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_RECORD_SIZE.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_RECORD_STOP.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_STOP.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_BEGIN.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_BEFORE.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_AFTER.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_OVER_RUN.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_USB_REMOVED.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_CI_PLUS_PROTECTION.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_PARENTAL_CONTROL.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_READY.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_NOTREADY.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_PVR_NOTIFY_CI_PLUS_RETENTION_LIMIT_UPDATE.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_AUTO_UPDATE_SCAN.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_TS_CHANGE.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_POPUP_SCAN_DIALOGE_LOSS_SIGNAL.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_POPUP_SCAN_DIALOGE_NEW_MULTIPLEX.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_POPUP_SCAN_DIALOGE_FREQUENCY_CHANGE.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_RCT_PRESENCE.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_CHANGE_TTX_STATUS.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_PRI_COMPONENT_MISSING.ordinal()] = 40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_AUDIO_MODE_CHANGE.ordinal()] = 41;
            } catch (NoSuchFieldError e41) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_MHEG5_EVENT_HANDLER.ordinal()] = 42;
            } catch (NoSuchFieldError e42) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_OAD_TIMEOUT.ordinal()] = 43;
            } catch (NoSuchFieldError e43) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_GINGA_STATUS_MODE.ordinal()] = 44;
            } catch (NoSuchFieldError e44) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_HBBTV_UI_EVENT.ordinal()] = 45;
            } catch (NoSuchFieldError e45) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_EPG_UPDATE_LIST.ordinal()] = 46;
            } catch (NoSuchFieldError e46) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_PIP.ordinal()] = 47;
            } catch (NoSuchFieldError e47) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_POP.ordinal()] = 48;
            } catch (NoSuchFieldError e48) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_DUALVIEW.ordinal()] = 49;
            } catch (NoSuchFieldError e49) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_4K2K_HDMI_DISABLE_TRAVELINGMODE.ordinal()] = 50;
            } catch (NoSuchFieldError e50) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_PSIP_TS_UPDATE.ordinal()] = 51;
            } catch (NoSuchFieldError e51) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_EMERGENCY_ALERT.ordinal()] = 52;
            } catch (NoSuchFieldError e52) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_DTV_CHANNEL_INFO_UPDATE.ordinal()] = 53;
            } catch (NoSuchFieldError e53) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_CI_OP_REFRESH_QUERY.ordinal()] = 54;
            } catch (NoSuchFieldError e54) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_CI_OP_SERVICE_LIST.ordinal()] = 55;
            } catch (NoSuchFieldError e55) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[EVENT.EV_CI_OP_EXIT_SERVICE_LIST.ordinal()] = 56;
            } catch (NoSuchFieldError e56) {
            }
            f62x5c30a25b = new int[EnumInputSource.values().length];
            try {
                f62x5c30a25b[EnumInputSource.E_INPUT_SOURCE_ATV.ordinal()] = 1;
            } catch (NoSuchFieldError e57) {
            }
            try {
                f62x5c30a25b[EnumInputSource.E_INPUT_SOURCE_DTV.ordinal()] = 2;
            } catch (NoSuchFieldError e58) {
            }
        }
    }

    protected enum EVENT {
        EV_DTV_CHANNELNAME_READY,
        EV_ATV_AUTO_TUNING_SCAN_INFO,
        EV_ATV_MANUAL_TUNING_SCAN_INFO,
        EV_DTV_AUTO_TUNING_SCAN_INFO,
        EV_DTV_PROGRAM_INFO_READY,
        EV_SIGNAL_LOCK,
        EV_SIGNAL_UNLOCK,
        EV_POPUP_DIALOG,
        EV_SCREEN_SAVER_MODE,
        EV_CI_LOAD_CREDENTIAL_FAIL,
        EV_EPGTIMER_SIMULCAST,
        EV_HBBTV_STATUS_MODE,
        EV_MHEG5_STATUS_MODE,
        EV_MHEG5_RETURN_KEY,
        EV_OAD_HANDLER,
        EV_OAD_DOWNLOAD,
        EV_PVR_NOTIFY_PLAYBACK_TIME,
        EV_PVR_NOTIFY_PLAYBACK_SPEED_CHANGE,
        EV_PVR_NOTIFY_RECORD_TIME,
        EV_PVR_NOTIFY_RECORD_SIZE,
        EV_PVR_NOTIFY_RECORD_STOP,
        EV_PVR_NOTIFY_PLAYBACK_STOP,
        EV_PVR_NOTIFY_PLAYBACK_BEGIN,
        EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_BEFORE,
        EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_AFTER,
        EV_PVR_NOTIFY_OVER_RUN,
        EV_PVR_NOTIFY_USB_REMOVED,
        EV_PVR_NOTIFY_CI_PLUS_PROTECTION,
        EV_PVR_NOTIFY_PARENTAL_CONTROL,
        EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_READY,
        EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_NOTREADY,
        EV_PVR_NOTIFY_CI_PLUS_RETENTION_LIMIT_UPDATE,
        EV_DTV_AUTO_UPDATE_SCAN,
        EV_TS_CHANGE,
        EV_POPUP_SCAN_DIALOGE_LOSS_SIGNAL,
        EV_POPUP_SCAN_DIALOGE_NEW_MULTIPLEX,
        EV_POPUP_SCAN_DIALOGE_FREQUENCY_CHANGE,
        EV_RCT_PRESENCE,
        EV_CHANGE_TTX_STATUS,
        EV_DTV_PRI_COMPONENT_MISSING,
        EV_AUDIO_MODE_CHANGE,
        EV_MHEG5_EVENT_HANDLER,
        EV_OAD_TIMEOUT,
        EV_GINGA_STATUS_MODE,
        EV_HBBTV_UI_EVENT,
        EV_EPG_UPDATE_LIST,
        EV_4K2K_HDMI_DISABLE_PIP,
        EV_4K2K_HDMI_DISABLE_POP,
        EV_4K2K_HDMI_DISABLE_DUALVIEW,
        EV_4K2K_HDMI_DISABLE_TRAVELINGMODE,
        EV_DTV_PSIP_TS_UPDATE,
        EV_EMERGENCY_ALERT,
        EV_DTV_CHANNEL_INFO_UPDATE,
        EV_CI_OP_REFRESH_QUERY,
        EV_CI_OP_SERVICE_LIST,
        EV_CI_OP_EXIT_SERVICE_LIST,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private PlayerImpl mMSrv;

        public EventHandler(PlayerImpl srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_DTV_CHANNELNAME_READY.ordinal()) {
                    Log.e("PlayerImpl", "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                EnumInputSource inputSource;
                switch (C02381.$SwitchMap$com$mstar$android$tvapi$impl$PlayerImpl$EVENT[ev[msg.what].ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onDtvChannelNameReady(msg.what);
                        }
                    case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                        if (PlayerImpl.this.mOnAtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnAtvPlayerEventListener.onAtvAutoTuningScanInfo(msg.what, (AtvEventScan) msg.obj);
                        }
                    case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                        if (PlayerImpl.this.mOnAtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnAtvPlayerEventListener.onAtvManualTuningScanInfo(msg.what, (AtvEventScan) msg.obj);
                        }
                    case SID.SID_TYPE_ALIAS /*4*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onDtvAutoTuningScanInfo(msg.what, (DtvEventScan) msg.obj);
                        }
                    case SID.SID_TYPE_WKN_GRP /*5*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            inputSource = null;
                            try {
                                inputSource = TvManager.getInstance().getCurrentInputSource();
                            } catch (TvCommonException e) {
                                e.printStackTrace();
                            }
                            switch (C02381.f62x5c30a25b[inputSource.ordinal()]) {
                                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                                    PlayerImpl.this.mOnAtvPlayerEventListener.onAtvProgramInfoReady(msg.what);
                                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                                    PlayerImpl.this.mOnDtvPlayerEventListener.onDtvProgramInfoReady(msg.what);
                                default:
                                    if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                                        PlayerImpl.this.mOnTvPlayerEventListener.onTvProgramInfoReady(msg.what);
                                    }
                            }
                        }
                    case SID.SID_TYPE_DELETED /*6*/:
                        if (PlayerImpl.this.mOnAtvPlayerEventListener != null) {
                            inputSource = null;
                            try {
                                inputSource = TvManager.getInstance().getCurrentInputSource();
                            } catch (TvCommonException e2) {
                                e2.printStackTrace();
                            }
                            switch (C02381.f62x5c30a25b[inputSource.ordinal()]) {
                                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                                    PlayerImpl.this.mOnAtvPlayerEventListener.onSignalLock(msg.what);
                                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                                    PlayerImpl.this.mOnDtvPlayerEventListener.onSignalLock(msg.what);
                                default:
                                    if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                                        PlayerImpl.this.mOnTvPlayerEventListener.onSignalLock(msg.what);
                                    }
                            }
                        }
                    case SID.SID_TYPE_INVALID /*7*/:
                        if (PlayerImpl.this.mOnAtvPlayerEventListener != null) {
                            inputSource = null;
                            try {
                                inputSource = TvManager.getInstance().getCurrentInputSource();
                            } catch (TvCommonException e22) {
                                e22.printStackTrace();
                            }
                            switch (C02381.f62x5c30a25b[inputSource.ordinal()]) {
                                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                                    PlayerImpl.this.mOnAtvPlayerEventListener.onSignalUnLock(msg.what);
                                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                                    PlayerImpl.this.mOnDtvPlayerEventListener.onSignalUnLock(msg.what);
                                default:
                                    if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                                        PlayerImpl.this.mOnTvPlayerEventListener.onSignalUnLock(msg.what);
                                    }
                            }
                        }
                    case SID.SID_TYPE_UNKNOWN /*8*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPopupDialog(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbConstants.FLAGS_OFFSET /*9*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onScreenSaverMode(msg.what, msg.arg1);
                        }
                    case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onCiLoadCredentialFail(msg.what);
                        }
                    case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onEpgTimerSimulcast(msg.what, msg.arg1);
                        }
                    case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener == null) {
                            return;
                        }
                        if (msg.arg1 != 0) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onHbbtvStatusMode(msg.what, true);
                        } else {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onHbbtvStatusMode(msg.what, false);
                        }
                    case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onMheg5StatusMode(msg.what, msg.arg1);
                        }
                    case SmbConstants.SIGNATURE_OFFSET /*14*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onMheg5ReturnKey(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onOadHandler(msg.what, msg.arg1, msg.arg2);
                        }
                    case SmbFile.TYPE_NAMED_PIPE /*16*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onOadDownload(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_START_SUCCESS_EVENT /*17*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyPlaybackTime(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_BINDED_SUCCESS_EVENT /*18*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyPlaybackSpeedChange(msg.what);
                        }
                    case OnRecvMsg.NT_STATUS_UMOUNT_FAILURE /*19*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyRecordTime(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_BINDED_FAIL_EVENT /*20*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyRecordSize(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_CONNECTION_FAIL_EVENT /*21*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyRecordStop(msg.what);
                        }
                    case WidiMonitor.WIDI_AUTHENTICATE_FAIL_EVENT /*22*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyPlaybackStop(msg.what);
                        }
                    case WidiMonitor.WIDI_DHCP_FAIL_EVENT /*23*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyPlaybackBegin(msg.what);
                        }
                    case SmbConstants.TID_OFFSET /*24*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyTimeShiftOverwritesBefore(msg.what, msg.arg1);
                        }
                    case WidiMonitor.WIDI_CONNECTING_EVENT /*25*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyTimeShiftOverwritesAfter(msg.what, msg.arg1);
                        }
                    case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_IS_DEVICE_FIRSTTIME_REG /*26*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyOverRun(msg.what);
                        }
                    case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_IS_DEVICE_REG /*27*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyUsbRemoved(msg.what, msg.arg1);
                        }
                    case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_REG_CODE /*28*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyCiPlusProtection(msg.what);
                        }
                    case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_DEREG_CODE /*29*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyParentalControl(msg.what, msg.arg1);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_DVI2 /*30*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyAlwaysTimeShiftProgramReady(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_DVI3 /*31*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyAlwaysTimeShiftProgramNotReady(msg.what);
                        }
                    case SmbFile.TYPE_PRINTER /*32*/:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onPvrNotifyCiPlusRetentionLimitUpdate(msg.what, msg.arg1);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_DVI_MAX /*33*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onDtvAutoUpdateScan(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_STORAGE /*34*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onTsChange(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_KTV /*35*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onPopupScanDialogLossSignal(msg.what);
                        }
                    case Region5RatingInformation.RRT5_REGNAME_LENGTH /*36*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onPopupScanDialogNewMultiplex(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_DTV2 /*37*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onPopupScanDialogFrequencyChange(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_STORAGE2 /*38*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onRctPresence(msg.what);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_DTV3 /*39*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener == null) {
                            return;
                        }
                        if (msg.arg1 != 0) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onChangeTtxStatus(msg.what, true);
                        } else {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onChangeTtxStatus(msg.what, false);
                        }
                    case Parameters.MAPI_INPUT_SOURCE_SCALER_OP /*40*/:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onDtvPriComponentMissing(msg.what);
                        }
                    case 41:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener == null) {
                            return;
                        }
                        if (msg.arg1 != 0) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onAudioModeChange(msg.what, true);
                        } else {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onAudioModeChange(msg.what, false);
                        }
                    case 42:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onMheg5EventHandler(msg.what, msg.arg1);
                        }
                    case 43:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onOadTimeout(msg.what, msg.arg1);
                        }
                    case 44:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener == null) {
                            return;
                        }
                        if (msg.arg1 != 0) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onGingaStatusMode(msg.what, true);
                        } else {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onGingaStatusMode(msg.what, false);
                        }
                    case 45:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onHbbtvUiEvent(msg.what, (HbbtvEventInfo) msg.obj);
                        }
                    case 46:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onEpgUpdateList(msg.what, msg.arg1);
                        }
                    case 47:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.on4k2kHDMIDisablePip(msg.what, msg.arg1, msg.arg2);
                        }
                    case 48:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.on4k2kHDMIDisablePop(msg.what, msg.arg1, msg.arg2);
                        }
                    case 49:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.on4k2kHDMIDisableDualView(msg.what, msg.arg1, msg.arg2);
                        }
                    case 50:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.on4k2kHDMIDisableTravelingMode(msg.what, msg.arg1, msg.arg2);
                        }
                    case 51:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onDtvPsipTsUpdate(msg.what, msg.arg1, msg.arg2);
                        }
                    case 52:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onEmerencyAlert(msg.what, msg.arg1, msg.arg2);
                        }
                    case 53:
                        if (PlayerImpl.this.mOnTvPlayerEventListener != null) {
                            PlayerImpl.this.mOnTvPlayerEventListener.onDtvChannelInfoUpdate(msg.what, msg.arg1, msg.arg2);
                        }
                    case 54:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onUiOPRefreshQuery(msg.what);
                        }
                    case 55:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onUiOPServiceList(msg.what);
                        }
                    case 56:
                        if (PlayerImpl.this.mOnDtvPlayerEventListener != null) {
                            PlayerImpl.this.mOnDtvPlayerEventListener.onUiOPExitServiceList(msg.what);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    private native int _getCurrentEventStatus(int i) throws TvCommonException;

    private native void _setCurrentEventStatus(int i, int i2) throws TvCommonException;

    private native void _setVideoSurface(Surface surface);

    private final native boolean native_atsc_setAntennaType(int i) throws TvCommonException;

    private final native boolean native_detectInputSource(int i) throws TvCommonException;

    private final native void native_finalize();

    private native void native_forceVideoStandard(int i) throws TvCommonException;

    private final native VideoArcInfo native_getAspectRatio() throws TvCommonException;

    private final native int native_getChinaDvbcRegion() throws TvCommonException;

    private final native int[] native_getNitFrequencyByDtvRegion(int i) throws TvCommonException;

    private final native RfInfo native_getRfInfo(int i, int i2) throws TvCommonException;

    private final native int native_getVideoStandard() throws TvCommonException;

    private final native int native_getVideoStandardDetectionState() throws TvCommonException;

    private static final native void native_init();

    private final native boolean native_openPAT(int i) throws TvCommonException;

    private final native boolean native_openTeletext(int i) throws TvCommonException;

    private final native boolean native_sendTeletextCommand(int i) throws TvCommonException;

    private final native boolean native_setAudioMode(int i) throws TvCommonException;

    private native boolean native_setAudioMute(int i, int i2) throws TvCommonException;

    private final native void native_setChannelChangeFreezeMode(boolean z) throws TvCommonException;

    private final native void native_setChinaDvbcRegion(int i) throws TvCommonException;

    private final native boolean native_setCountry(int i) throws TvCommonException;

    private final native void native_setParental(int i) throws TvCommonException;

    private final native void native_setTimeZone(int i) throws TvCommonException;

    private final native void native_setup(Object obj);

    public final native boolean autostartApplication() throws TvCommonException;

    public final native boolean closeTeletext() throws TvCommonException;

    public native boolean createPreviewCCWin() throws TvCommonException;

    public final native boolean disableAft() throws TvCommonException;

    public final native void disableAutoClock() throws TvCommonException;

    public final native boolean disableAutoScartOut() throws TvCommonException;

    public final native boolean disableGigna() throws TvCommonException;

    public final native boolean doesCcExist() throws TvCommonException;

    public native boolean drawPreviewCCWin(CaptionOptionSetting captionOptionSetting) throws TvCommonException;

    public final native boolean enableAft() throws TvCommonException;

    public final native void enableAutoClock() throws TvCommonException;

    public final native boolean enableAutoScartOut() throws TvCommonException;

    public final native boolean enableGinga() throws TvCommonException;

    public native boolean enterPassToUnlockByUser(boolean z) throws TvCommonException;

    public native boolean enterPassToUnlockUnratedByUser(boolean z) throws TvCommonException;

    public native boolean exitPreviewCCWin() throws TvCommonException;

    public final native int getAirChannelType() throws TvCommonException;

    public final native int getAntennaType() throws TvCommonException;

    public final native DtvAudioInfo getAudioInfo() throws TvCommonException;

    public final native int getCcMode() throws TvCommonException;

    public native String getCountryCode() throws TvCommonException;

    public final native DvbMuxInfo getCurrentMuxInfo() throws TvCommonException;

    public native String getCurrentRatingInformation() throws TvCommonException;

    public final native DtvProgramSignalInfo getCurrentSignalInformation() throws TvCommonException;

    public native boolean getCurrentVChipBlockStatus() throws TvCommonException;

    public native DtvDemodDvbcInfo getDemodDVBCInfo() throws TvCommonException;

    public native DtvDemodDvbtInfo getDemodDVBTInfo() throws TvCommonException;

    public final native int getDtvRouteCount() throws TvCommonException;

    public native MwAtscEasInfo getEASInProgress() throws TvCommonException;

    public native boolean getEasProgressSatus() throws TvCommonException;

    public final native String getLanguageCode() throws TvCommonException;

    public final native int[] getLogoData() throws TvCommonException;

    public final native String getMheg5PfgContent() throws TvCommonException;

    public final native DvbMuxInfo getMuxInfoByProgramNumber(int i, short s) throws TvCommonException;

    public final native int getPhaseRange() throws TvCommonException;

    public native Region5RatingInformation getRRTInformation() throws TvCommonException;

    public final native AtscScanChannelNotify getTSUpdateInfo(int i) throws TvCommonException;

    public final native VideoInfo getVideoInfo() throws TvCommonException;

    public final native boolean hasTeletextClockSignal() throws TvCommonException;

    public final native boolean hasTeletextSignal() throws TvCommonException;

    public final native void initAtvVif() throws TvCommonException;

    public final native void initOfflineDetection() throws TvCommonException;

    public final native boolean isAftEnabled() throws TvCommonException;

    public final native boolean isGingaEnabled() throws TvCommonException;

    public final native boolean isGingaRunning() throws TvCommonException;

    public final native boolean isHdmiMode();

    public final native boolean isSignalStable() throws TvCommonException;

    public final native boolean isTeletextDisplayed() throws TvCommonException;

    public final native boolean isTeletextSubtitleChannel() throws TvCommonException;

    public native DtvDemodVersion native_getDTVDemodVersion(int i) throws TvCommonException;

    public final native boolean playCurrentProgram() throws TvCommonException;

    public final native boolean processKey(int i, boolean z) throws TvCommonException;

    public final native boolean saveAtvProgram(int i) throws TvCommonException;

    public final native boolean sendMheg5Command(short s) throws TvCommonException;

    public final native boolean sendMheg5IcsCommand(int i, short s) throws TvCommonException;

    public native boolean setAutoSync(boolean z) throws TvCommonException;

    public final native void setCcMode(int i) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setDtvRoute(short s) throws TvCommonException;

    public native void setEasAudioDesired(boolean z) throws TvCommonException;

    public native void setEasProgressDone() throws TvCommonException;

    public final native void setFavoriteRegion(int i) throws TvCommonException;

    public final native boolean setHPosition(int i) throws TvCommonException;

    public final native boolean setHdmiGpio(int[] iArr) throws TvCommonException;

    public final native boolean setManualTuneByFreq(int i) throws TvCommonException;

    public final native boolean setManualTuneByRf(short s) throws TvCommonException;

    public final native boolean setMirror(boolean z) throws TvCommonException;

    public final native boolean setPhase(int i) throws TvCommonException;

    public final native boolean setSize(int i) throws TvCommonException;

    public native boolean setVChipGuideline(short s, short s2, short s3, short s4) throws TvCommonException;

    public final native boolean setVPosition(int i) throws TvCommonException;

    public final native boolean startApplication(long j, long j2) throws TvCommonException;

    public native void startAutoStandardDetection() throws TvCommonException;

    public final native boolean startCc() throws TvCommonException;

    public final native boolean startPcModeAtuoTune() throws TvCommonException;

    public final native boolean stopApplication() throws TvCommonException;

    public final native boolean stopCc() throws TvCommonException;

    public final native void switchAudioTrack(int i) throws TvCommonException;

    public final native boolean switchDtvRoute(short s) throws TvCommonException;

    public final native boolean unlockChannel() throws TvCommonException;

    private void updateSurfaceScreenOn() {
        if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.setKeepScreenOn(true);
        }
    }

    public void setDisplay(SurfaceHolder sh) {
        this.mSurfaceHolder = sh;
        if (sh != null) {
            this.mSurface = sh.getSurface();
        } else {
            this.mSurface = null;
        }
        _setVideoSurface(this.mSurface);
        updateSurfaceScreenOn();
    }

    public RfInfo getRfInfo(EnumInfoType rfSignalInfoType, int rfChNo) throws TvCommonException {
        return native_getRfInfo(rfSignalInfoType.ordinal(), rfChNo);
    }

    public final VideoArcInfo getAspectRatio() throws TvCommonException {
        return native_getAspectRatio();
    }

    public boolean openTeletext(EnumTeletextMode eMode) throws TvCommonException {
        return native_openTeletext(eMode.ordinal());
    }

    public final boolean sendTeletextCommand(EnumTeletextCommand eCmd) throws TvCommonException {
        return native_sendTeletextCommand(eCmd.ordinal());
    }

    public final boolean openPAT(EnumTeletextCommand eCmd) throws TvCommonException {
        return native_openPAT(eCmd.ordinal());
    }

    public EnumAvdVideoStandardType getVideoStandard() throws TvCommonException {
        int iReturn = native_getVideoStandard();
        if (iReturn >= EnumAvdVideoStandardType.PAL_BGHI.ordinal() && iReturn <= EnumAvdVideoStandardType.MAX.ordinal()) {
            return EnumAvdVideoStandardType.values()[iReturn];
        }
        throw new TvCommonException("native_getVideoStandard failed");
    }

    public EnumStdDetectionState getVideoStandardDetectionState() throws TvCommonException {
        int iReturn = native_getVideoStandardDetectionState();
        if (iReturn >= EnumStdDetectionState.VERIFY.ordinal() && iReturn <= EnumStdDetectionState.DUMP.ordinal()) {
            return EnumStdDetectionState.values()[iReturn];
        }
        throw new TvCommonException("native_getVideoStandardDetectionState failed");
    }

    public boolean setCountry(EnumCountry enCountry) throws TvCommonException {
        return native_setCountry(enCountry.ordinal());
    }

    public void setParental(EnumParentalRating enParentalRating) throws TvCommonException {
        native_setParental(enParentalRating.ordinal());
    }

    public DtvDemodVersion getDTVDemodVersion(DtvDemodType eDemodType) throws TvCommonException {
        return native_getDTVDemodVersion(eDemodType.ordinal());
    }

    static {
        _playerImpl = null;
        try {
            System.loadLibrary("playerimpl_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load playerimpl_jni library:\n" + e.toString());
        }
    }

    protected static PlayerImpl getInstance(Object obj) {
        String objname = obj.getClass().getName();
        if ((objname.equals("com.mstar.android.tvapi.atv.AtvPlayerImplProxy") || objname.equals("com.mstar.android.tvapi.dtv.common.DtvPlayerImplProxy") || objname.equals("com.mstar.android.tvapi.common.TvPlayerImplProxy")) && _playerImpl == null) {
            synchronized (PlayerImpl.class) {
                if (_playerImpl == null) {
                    _playerImpl = new PlayerImpl();
                }
            }
        }
        return _playerImpl;
    }

    protected PlayerImpl() {
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

    public void setOnTvPlayerEventListener(OnTvPlayerEventListener listener) {
        this.mOnTvPlayerEventListener = listener;
    }

    public void setOnAtvPlayerEventListener(OnAtvPlayerEventListener listener) {
        this.mOnAtvPlayerEventListener = listener;
    }

    public void setOnDtvPlayerEventListener(OnDtvPlayerEventListener listener) {
        this.mOnDtvPlayerEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
        }
    }

    private static void PostEvent_ChannelNameReady(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_CHANNELNAME_READY.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_AtvAutoTuning(Object srv_ref, AtvEventScan atveventparam, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ATV_AUTO_TUNING_SCAN_INFO.ordinal(), atveventparam));
        }
    }

    private static void PostEvent_ManualTuning(Object srv_ref, AtvEventScan atveventparam, int ext1) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_ATV_MANUAL_TUNING_SCAN_INFO.ordinal(), atveventparam));
        }
    }

    private static void PostEvent_DtvAutoTuning(Object srv_ref, DtvEventScan dtveventparam, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_AUTO_TUNING_SCAN_INFO.ordinal(), dtveventparam));
        }
    }

    private static void PostEvent_ProgramInfoReady(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_PROGRAM_INFO_READY.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SignalLock(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SIGNAL_LOCK.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SignalUnlock(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SIGNAL_UNLOCK.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PopupDialog(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_POPUP_DIALOG.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_ScreenSaverMode(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_SCREEN_SAVER_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_CiLoadCredentialFail(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CI_LOAD_CREDENTIAL_FAIL.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_EpgTimerSimulcast(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EPGTIMER_SIMULCAST.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_HbbtvStatusMode(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_HBBTV_STATUS_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_Mheg5StatusMode(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_MHEG5_STATUS_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_Mheg5ReturnKey(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_MHEG5_RETURN_KEY.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_OadHandler(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_OAD_HANDLER.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_OadDownload(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_OAD_DOWNLOAD.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrPlaybackTime(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_TIME.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_PvrPlaybackSpeedChange(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_SPEED_CHANGE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrRecordTime(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_RECORD_TIME.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_PvrRecordSize(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_RECORD_SIZE.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_PvrRecordStop(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_RECORD_STOP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrPlaybackStop(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_STOP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrPlaybackBegin(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_BEGIN.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrTimeshiftBefore(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_BEFORE.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_PvrTimeshiftAfter(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_TIMESHIFT_OVERWRITES_AFTER.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_OverRun(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_OVER_RUN.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_UsbRemoved(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_USB_REMOVED.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_CiPlusProtection(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_CI_PLUS_PROTECTION.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_ParentalControl(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PARENTAL_CONTROL.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_AlwaysTimeshiftProgramReady(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_READY.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_AlwaysTimeShiftProgramNotReady(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_ALWAYS_TIMESHIFT_PROGRAM_NOTREADY.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PvrCiPlusRetentionLimit(Object srv_ref, int ext1, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_CI_PLUS_RETENTION_LIMIT_UPDATE.ordinal(), ext1, ext2));
        }
    }

    private static void PostEvent_AutoUpdateScan(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_AUTO_UPDATE_SCAN.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_TsChange(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_TS_CHANGE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PopupScanDialogLossSignal(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_POPUP_SCAN_DIALOGE_LOSS_SIGNAL.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PopupScanDialogNewMultiplex(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_POPUP_SCAN_DIALOGE_NEW_MULTIPLEX.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PopupScanDialogFreqChange(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_POPUP_SCAN_DIALOGE_FREQUENCY_CHANGE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_RctPresence(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_RCT_PRESENCE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_ChangeTtxStatus(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CHANGE_TTX_STATUS.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_PriComponentMissing(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_PRI_COMPONENT_MISSING.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_AudioModeChange(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_AUDIO_MODE_CHANGE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_Mheg5EventHandler(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_MHEG5_EVENT_HANDLER.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_OadTimeOut(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_OAD_TIMEOUT.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_GingaStatusMode(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_GINGA_STATUS_MODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_HbbtvEvent(Object srv_ref, HbbtvEventInfo bbtvinfo, int ext2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_HBBTV_UI_EVENT.ordinal(), bbtvinfo));
        }
    }

    private static void PostEvent_EpgUpdateList(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EPG_UPDATE_LIST.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    private static void PostEvent_4k2kHDMIDisablePip(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_PIP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisablePop(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_POP.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisableDualView(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_DUALVIEW.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_4k2kHDMIDisableTravelingMode(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_4K2K_HDMI_DISABLE_TRAVELINGMODE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_DtvPsipTsUpdate(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_PSIP_TS_UPDATE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_Emerency_Alert(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_EMERGENCY_ALERT.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_DtvChannelInfoUpdate(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null && srv.mEventHandler != null) {
            srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_DTV_CHANNEL_INFO_UPDATE.ordinal(), arg1, arg2));
        }
    }

    private static void PostEvent_OPRefreshQuery(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CI_OP_REFRESH_QUERY.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_OPRefreshQuery");
        }
    }

    private static void PostEvent_OPServiceList(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CI_OP_SERVICE_LIST.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_OPServiceList");
        }
    }

    private static void PostEvent_ExitOPServiceList(Object srv_ref, int arg1, int arg2) {
        PlayerImpl srv = (PlayerImpl) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_CI_OP_EXIT_SERVICE_LIST.ordinal(), arg1, arg2));
            }
            System.out.println("\n NativeCI callback, PostEvent_ExitOPServiceList");
        }
    }

    public void release() throws Throwable {
        _playerImpl = null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _playerImpl = null;
    }

    public boolean setAudioMode(EnumDtvSetAudioMode mode) throws TvCommonException {
        return native_setAudioMode(mode.ordinal());
    }

    public void setTimeZone(EnumTimeZone timeZone) throws TvCommonException {
        native_setTimeZone(timeZone.getValue());
    }

    public void setChannelChangeFreezeMode(boolean freezeMode) throws TvCommonException {
        native_setChannelChangeFreezeMode(freezeMode);
    }

    public void forceVideoStandard(EnumAvdVideoStandardType videoStandardType) throws TvCommonException {
        native_forceVideoStandard(videoStandardType.ordinal());
    }

    public boolean detectInputSource(EnumInputSource inputSource) throws TvCommonException {
        return native_detectInputSource(inputSource.ordinal());
    }

    public final int[] getNitFrequencyByDtvRegion(EnumChinaDvbcRegion eRegion) throws TvCommonException {
        return native_getNitFrequencyByDtvRegion(eRegion.ordinal());
    }

    public EnumChinaDvbcRegion getChinaDvbcRegion() throws TvCommonException {
        int iReturn = native_getChinaDvbcRegion();
        if (iReturn >= EnumChinaDvbcRegion.E_CN_OTHERS.ordinal() && iReturn <= EnumChinaDvbcRegion.E_CN_NUM.ordinal()) {
            return EnumChinaDvbcRegion.values()[iReturn];
        }
        throw new TvCommonException("getChinaDvbcRegion failed");
    }

    public final void setChinaDvbcRegion(EnumChinaDvbcRegion eRegion) throws TvCommonException {
        native_setChinaDvbcRegion(eRegion.ordinal());
    }

    public boolean setAudioMute(EnumAudioMuteType enMuteType, EnumInputSource enInputSource) throws TvCommonException {
        return native_setAudioMute(enMuteType.getValue(), enInputSource.ordinal());
    }

    public void setAntennaType(EnumAntennaType antennaType) throws TvCommonException {
        native_atsc_setAntennaType(antennaType.ordinal());
    }

    public final boolean setUsaTvGuideline(EnumUsaTvRatingType age, short rank) throws TvCommonException {
        return setVChipGuideline((short) EnumVChipRatingType.E_US_TV.ordinal(), (short) age.ordinal(), rank, (short) 0);
    }

    public final boolean setUsaMpaaGuideline(EnumUsaMpaaRatingType rank, boolean isNr) throws TvCommonException {
        return setVChipGuideline((short) EnumVChipRatingType.E_US_MPAA.ordinal(), (short) rank.ordinal(), (short) (isNr ? 1 : 0), (short) 0);
    }

    public final boolean setCanadaEngGuideline(EnumCanadaEngRatingType rank) throws TvCommonException {
        return setVChipGuideline((short) EnumVChipRatingType.E_CANADA_ENG.ordinal(), (short) rank.ordinal(), (short) 0, (short) 0);
    }

    public final boolean setCanadaFreGuideline(EnumCanadaFreRatingType rank) throws TvCommonException {
        return setVChipGuideline((short) EnumVChipRatingType.E_CANADA_FRE.ordinal(), (short) rank.ordinal(), (short) 0, (short) 0);
    }

    public final boolean setDynamicGuideline(short grad, short rank, short value) throws TvCommonException {
        return setVChipGuideline((short) EnumVChipRatingType.E_DYNAMIC.ordinal(), grad, rank, value);
    }

    public int getCurrentEventStatus(EnumCurrentEventStatus type) throws TvCommonException {
        return _getCurrentEventStatus(type.ordinal());
    }

    public void setCurrentEventStatus(EnumCurrentEventStatus type, boolean flag) throws TvCommonException {
        _setCurrentEventStatus(type.ordinal(), flag ? 1 : 0);
    }
}
