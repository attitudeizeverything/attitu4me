package com.mstar.android.media;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.Metadata;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.mstar.android.widi.WidiMonitor;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MMediaPlayer extends MediaPlayer {
    private static final int DATASOURCE_AP_ANDROID_STREAMING = 7;
    private static final int DATASOURCE_AP_ANDROID_USB = 6;
    private static final int DATASOURCE_AP_DLNA = 2;
    private static final int DATASOURCE_AP_HBBTV = 3;
    private static final int DATASOURCE_AP_NETFLIX = 1;
    private static final int DATASOURCE_AP_NORMAL = 0;
    private static final int DATASOURCE_AP_WEBBROWSER = 4;
    private static final int DATASOURCE_AP_WMDRM10 = 5;
    private static final int DATASOURCE_CONTENT_TYPE_ES = 3;
    private static final int DATASOURCE_CONTENT_TYPE_MASS_STORAGE = 0;
    private static final int DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITHOUT_SEEK = 2;
    private static final int DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITH_SEEK = 1;
    private static final int DATASOURCE_ES_AUDIO_CODEC_AAC = 6;
    private static final int DATASOURCE_ES_AUDIO_CODEC_AC3 = 4;
    private static final int DATASOURCE_ES_AUDIO_CODEC_AC3_PLUS = 5;
    private static final int DATASOURCE_ES_AUDIO_CODEC_ADPCM = 8;
    private static final int DATASOURCE_ES_AUDIO_CODEC_AMR_NB = 13;
    private static final int DATASOURCE_ES_AUDIO_CODEC_AMR_WB = 14;
    private static final int DATASOURCE_ES_AUDIO_CODEC_COOK = 10;
    private static final int DATASOURCE_ES_AUDIO_CODEC_DTS = 1;
    private static final int DATASOURCE_ES_AUDIO_CODEC_FLAC = 11;
    private static final int DATASOURCE_ES_AUDIO_CODEC_MP3 = 2;
    private static final int DATASOURCE_ES_AUDIO_CODEC_MPEG = 3;
    private static final int DATASOURCE_ES_AUDIO_CODEC_PCM = 7;
    private static final int DATASOURCE_ES_AUDIO_CODEC_RAAC = 9;
    private static final int DATASOURCE_ES_AUDIO_CODEC_UNKNOW = -1;
    private static final int DATASOURCE_ES_AUDIO_CODEC_VORBIS = 12;
    private static final int DATASOURCE_ES_AUDIO_CODEC_WMA = 0;
    private static final int DATASOURCE_ES_VIDEO_CODEC_AVS = 8;
    private static final int DATASOURCE_ES_VIDEO_CODEC_DIVX = 6;
    private static final int DATASOURCE_ES_VIDEO_CODEC_DIVX3 = 4;
    private static final int DATASOURCE_ES_VIDEO_CODEC_DIVX4 = 5;
    private static final int DATASOURCE_ES_VIDEO_CODEC_FLV = 14;
    private static final int DATASOURCE_ES_VIDEO_CODEC_FOURCCEX = 15;
    private static final int DATASOURCE_ES_VIDEO_CODEC_H263 = 3;
    private static final int DATASOURCE_ES_VIDEO_CODEC_H264 = 7;
    private static final int DATASOURCE_ES_VIDEO_CODEC_MJPEG = 11;
    private static final int DATASOURCE_ES_VIDEO_CODEC_MPEG1VIDEO = 0;
    private static final int DATASOURCE_ES_VIDEO_CODEC_MPEG2VIDEO = 1;
    private static final int DATASOURCE_ES_VIDEO_CODEC_MPEG4 = 2;
    private static final int DATASOURCE_ES_VIDEO_CODEC_RV30 = 9;
    private static final int DATASOURCE_ES_VIDEO_CODEC_RV40 = 10;
    private static final int DATASOURCE_ES_VIDEO_CODEC_TS = 16;
    private static final int DATASOURCE_ES_VIDEO_CODEC_UNKNOW = -1;
    private static final int DATASOURCE_ES_VIDEO_CODEC_VC1 = 12;
    private static final int DATASOURCE_ES_VIDEO_CODEC_WMV3 = 13;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_ASF = 3;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_AVI = 0;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_ESDATA = 8;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_FLV = 7;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_MAX = 9;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_MKV = 2;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_MP4 = 1;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_MPG = 6;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_RM = 4;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_TS = 5;
    private static final int DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN = -1;
    private static final String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE = 2;
    private static final int INVOKE_ID_ADD_EXTERNAL_SOURCE_FD = 3;
    private static final int INVOKE_ID_DESELECT_TRACK = 5;
    private static final int INVOKE_ID_GET_MS_TRACK_INFO = 1002;
    private static final int INVOKE_ID_GET_TRACK_INFO = 1;
    private static final int INVOKE_ID_SELECT_TRACK = 4;
    private static final int INVOKE_ID_SET_VIDEO_SCALE_MODE = 6;
    private static final int KEY_PARAMETER_ACCEPT_NEXT_SEAMLESS = 2010;
    private static final int KEY_PARAMETER_AVCODEC_CHANGED = 2008;
    private static final int KEY_PARAMETER_CHANGE_AV_SYNCHRONIZATION = 2021;
    private static final int KEY_PARAMETER_CHANGE_PROGRAM = 2005;
    private static final int KEY_PARAMETER_CROP_RECT = 3004;
    private static final int KEY_PARAMETER_DATASOURCE_SWITCH = 2002;
    private static final int KEY_PARAMETER_DEMUX_RESET = 2000;
    private static final int KEY_PARAMETER_GET_ACTIVE_AUDIO_TRACK_INFO = 2037;
    private static final int KEY_PARAMETER_GET_ACTIVE_AUDIO_TRACK_NAME = 2038;
    private static final int KEY_PARAMETER_GET_ACTIVE_SUBTITLE_TRACK_NAME = 2039;
    private static final int KEY_PARAMETER_GET_ALL_AUDIO_TRACK_INFO = 2032;
    private static final int KEY_PARAMETER_GET_ALL_CHAPTER_NAME = 2030;
    private static final int KEY_PARAMETER_GET_ALL_EDITION_NAME = 2028;
    private static final int KEY_PARAMETER_GET_ALL_SUBTITLE_TRACK_INFO = 2013;
    private static final int KEY_PARAMETER_GET_ALL_TITLE_NAME = 2026;
    private static final int KEY_PARAMETER_GET_AUTHOR_CHAPTER_COUNT = 2029;
    private static final int KEY_PARAMETER_GET_BUFFER_STATUS = 2018;
    private static final int KEY_PARAMETER_GET_CHAPTER = 2034;
    private static final int KEY_PARAMETER_GET_CONTAINER_PTS = 2022;
    private static final int KEY_PARAMETER_GET_DIVX_DRM_IS_RENTAL_FILE = 2015;
    private static final int KEY_PARAMETER_GET_DIVX_DRM_RENTAL_LIMIT = 2016;
    private static final int KEY_PARAMETER_GET_DIVX_DRM_RENTAL_USE_COUNT = 2017;
    private static final int KEY_PARAMETER_GET_EDITION_COUNT = 2027;
    private static final int KEY_PARAMETER_GET_LAW_RATING = 2031;
    private static final int KEY_PARAMETER_GET_SUBTITLE_TRACK_INFO = 2012;
    private static final int KEY_PARAMETER_GET_TITLE_COUNT = 2025;
    private static final int KEY_PARAMETER_GET_TITLE_EDITION = 2033;
    private static final int KEY_PARAMETER_MEDIA_CREATE_THUMBNAIL_MODE = 2006;
    private static final int KEY_PARAMETER_PAYLOAD_SHOT = 2003;
    private static final int KEY_PARAMETER_ROTATE = 3001;
    private static final int KEY_PARAMETER_ROTATE_SCALE = 3003;
    private static final int KEY_PARAMETER_SCALE = 3002;
    private static final int KEY_PARAMETER_SET_CHAPTER = 2036;
    private static final int KEY_PARAMETER_SET_DUAL_DECODE_PIP = 2024;
    private static final int KEY_PARAMETER_SET_IMAGE_SAMPLESIZE_SURFACESIZE = 3000;
    private static final int KEY_PARAMETER_SET_LOW_LATENCY_MODE = 2023;
    private static final int KEY_PARAMETER_SET_MULTI_THUMBS = 2040;
    private static final int KEY_PARAMETER_SET_RESUME_PLAY = 2014;
    private static final int KEY_PARAMETER_SET_SEAMLESS_MODE = 2001;
    private static final int KEY_PARAMETER_SET_SUBTITLE_INDEX = 2011;
    private static final int KEY_PARAMETER_SET_TITLE_EDITION = 2035;
    private static final int KEY_PARAMETER_SET_TS_INFO = 2009;
    private static final int KEY_PARAMETER_SET_VIDEO_DECODE_ALL = 2019;
    private static final int KEY_PARAMETER_SET_VIDEO_DECODE_I_ONLY = 2020;
    private static final int KEY_PARAMETER_SWITCH_TO_PUSH_DATA_MODE = 2004;
    private static final int KEY_PARAMETER_VIDEO_ONLY_MODE = 2007;
    public static final int MEDIA_ERROR_AUDIO_UNSUPPORT = -5001;
    public static final int MEDIA_ERROR_BASE = -5000;
    public static final int MEDIA_ERROR_CONNECTED_TIMEOUT = -5000;
    public static final int MEDIA_ERROR_DIVX_DRM_AUTH_FAIL = -5008;
    public static final int MEDIA_ERROR_DIVX_DRM_RENTAL_EXPIRE = -5007;
    public static final int MEDIA_ERROR_FILE_FORMAT_UNSUPPORT = -5003;
    public static final int MEDIA_ERROR_OUT_OF_MEMORY = -5004;
    public static final int MEDIA_ERROR_VIDEO_RESOURCE_LOST = -5006;
    public static final int MEDIA_ERROR_VIDEO_SKIP_TOO_MUCH = -5005;
    public static final int MEDIA_ERROR_VIDEO_UNSUPPORT = -5002;
    public static final int MEDIA_INFO_AUDIO_UNSUPPORT = 1002;
    public static final int MEDIA_INFO_NETWORK_CACHE_PERCENT = 1001;
    public static final int MEDIA_INFO_SUBTITLE_UPDATA = 1000;
    public static final int MEDIA_INFO_VIDEO_DECODE_CONTINUOUS_ERR = 1004;
    public static final int MEDIA_INFO_VIDEO_UNSUPPORT = 1003;
    private static final int METADATA_KEY_DIVX_DRM_IS_DEVICE_FIRSTTIME_REG = 26;
    private static final int MS_DATASOURCE_PLAYER_MOVIE = 1;
    private static final int MS_DATASOURCE_PLAYER_MUSIC = 2;
    private static final int MS_DATASOURCE_PLAYER_UNKNOW = 0;
    private static final String TAG = "MMediaPlayer";
    private static final int VIDEO_ASPECT_RATIO_16X9 = 2;
    private static final int VIDEO_ASPECT_RATIO_16X9_COMBIND = 8;
    private static final int VIDEO_ASPECT_RATIO_16X9_PAN_SCAN = 6;
    private static final int VIDEO_ASPECT_RATIO_16X9_PILLARBOX = 3;
    private static final int VIDEO_ASPECT_RATIO_4X3 = 1;
    private static final int VIDEO_ASPECT_RATIO_4X3_COMBIND = 7;
    private static final int VIDEO_ASPECT_RATIO_4X3_LETTER_BOX = 5;
    private static final int VIDEO_ASPECT_RATIO_4X3_PAN_SCAN = 4;
    private static final int VIDEO_ASPECT_RATIO_AUTO = 0;
    private int mDataSourceAppType;
    private int mDataSourceAudioCodec;
    private int mDataSourceContentType;
    private int mDataSourceMediaFormat;
    private int mDataSourcePlayerType;
    private int mDataSourceVideoCodec;
    private int mNaticeSubtitleSurfaceTexture;
    private SurfaceHolder mSubtitleSurfaceHolder;

    /* renamed from: com.mstar.android.media.MMediaPlayer.1 */
    static /* synthetic */ class C00931 {
        static final /* synthetic */ int[] f47x2cee92cb;
        static final /* synthetic */ int[] f48x832033d4;
        static final /* synthetic */ int[] f49xee8ec608;
        static final /* synthetic */ int[] f50x3ff8bcc4;
        static final /* synthetic */ int[] f51x63c565a9;
        static final /* synthetic */ int[] f52x39866a30;
        static final /* synthetic */ int[] f53x4bcacd4b;
        static final /* synthetic */ int[] f54x7d0a408;

        static {
            f54x7d0a408 = new int[EnumVideoAspectRatio.values().length];
            try {
                f54x7d0a408[EnumVideoAspectRatio.E_VIDEO_ASPECT_RATIO_AUTO.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e) {
            }
            try {
                f54x7d0a408[EnumVideoAspectRatio.E_VIDEO_ASPECT_RATIO_4X3.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f54x7d0a408[EnumVideoAspectRatio.E_VIDEO_ASPECT_RATIO_16X9.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e3) {
            }
            f53x4bcacd4b = new int[EnumPlayerSeamlessMode.values().length];
            try {
                f53x4bcacd4b[EnumPlayerSeamlessMode.E_PLAYER_SEAMLESS_NONE.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f53x4bcacd4b[EnumPlayerSeamlessMode.E_PLAYER_SEAMLESS_FREEZ.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f53x4bcacd4b[EnumPlayerSeamlessMode.E_PLAYER_SEAMLESS_SMOTH.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f53x4bcacd4b[EnumPlayerSeamlessMode.E_PLAYER_SEAMLESS_DS.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e7) {
            }
            f49xee8ec608 = new int[EN_MS_DATASOURCE_CONTENT_TYPE.values().length];
            try {
                f49xee8ec608[EN_MS_DATASOURCE_CONTENT_TYPE.E_DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITH_SEEK.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f49xee8ec608[EN_MS_DATASOURCE_CONTENT_TYPE.E_DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITHOUT_SEEK.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f49xee8ec608[EN_MS_DATASOURCE_CONTENT_TYPE.E_DATASOURCE_CONTENT_TYPE_ES.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f49xee8ec608[EN_MS_DATASOURCE_CONTENT_TYPE.E_DATASOURCE_CONTENT_TYPE_MASS_STORAGE.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e11) {
            }
            f52x39866a30 = new int[EN_MS_DATASOURCE_PLAYER_TYPE.values().length];
            try {
                f52x39866a30[EN_MS_DATASOURCE_PLAYER_TYPE.E_DATASOURCE_PLAYER_MOVIE.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f52x39866a30[EN_MS_DATASOURCE_PLAYER_TYPE.E_DATASOURCE_PLAYER_MUSIC.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f52x39866a30[EN_MS_DATASOURCE_PLAYER_TYPE.E_DATASOURCE_PLAYER_UNKNOW.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e14) {
            }
            f50x3ff8bcc4 = new int[EN_MS_DATASOURCE_ES_AUDIO_CODEC.values().length];
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_WMA.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_DTS.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_MP3.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_MPEG.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_AC3.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_AC3_PLUS.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_AAC.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_COMBIND;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_PCM.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_COMBIND;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_ADPCM.ordinal()] = MMediaPlayer.DATASOURCE_MEDIA_FORMAT_TYPE_MAX;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_RAAC.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_RV40;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_COOK.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_MJPEG;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_FLAC.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_VC1;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_VORBIS.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_WMV3;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_AMR_NB.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_FLV;
            } catch (NoSuchFieldError e28) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_AMR_WB.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_FOURCCEX;
            } catch (NoSuchFieldError e29) {
            }
            try {
                f50x3ff8bcc4[EN_MS_DATASOURCE_ES_AUDIO_CODEC.E_DATASOURCE_ES_AUDIO_CODEC_UNKNOW.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_TS;
            } catch (NoSuchFieldError e30) {
            }
            f51x63c565a9 = new int[EN_MS_DATASOURCE_ES_VIDEO_CODEC.values().length];
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_MPEG1VIDEO.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e31) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_MPEG2VIDEO.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e32) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_MPEG4.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e33) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_H263.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e34) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_DIVX3.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
            } catch (NoSuchFieldError e35) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_DIVX4.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
            } catch (NoSuchFieldError e36) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_DIVX.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_COMBIND;
            } catch (NoSuchFieldError e37) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_H264.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_COMBIND;
            } catch (NoSuchFieldError e38) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_AVS.ordinal()] = MMediaPlayer.DATASOURCE_MEDIA_FORMAT_TYPE_MAX;
            } catch (NoSuchFieldError e39) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_RV30.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_RV40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_RV40.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_MJPEG;
            } catch (NoSuchFieldError e41) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_MJPEG.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_VC1;
            } catch (NoSuchFieldError e42) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_VC1.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_WMV3;
            } catch (NoSuchFieldError e43) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_WMV3.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_FLV;
            } catch (NoSuchFieldError e44) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_FLV.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_FOURCCEX;
            } catch (NoSuchFieldError e45) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_FOURCCEX.ordinal()] = MMediaPlayer.DATASOURCE_ES_VIDEO_CODEC_TS;
            } catch (NoSuchFieldError e46) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_TS.ordinal()] = 17;
            } catch (NoSuchFieldError e47) {
            }
            try {
                f51x63c565a9[EN_MS_DATASOURCE_ES_VIDEO_CODEC.E_DATASOURCE_ES_VIDEO_CODEC_UNKNOW.ordinal()] = 18;
            } catch (NoSuchFieldError e48) {
            }
            f48x832033d4 = new int[EN_DATASOURCE_MEDIA_FORMAT_TYPE.values().length];
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_AVI.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e49) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_MP4.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e50) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_MKV.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e51) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_ASF.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e52) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_RM.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
            } catch (NoSuchFieldError e53) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_TS.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
            } catch (NoSuchFieldError e54) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_MPG.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_COMBIND;
            } catch (NoSuchFieldError e55) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_FLV.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_COMBIND;
            } catch (NoSuchFieldError e56) {
            }
            try {
                f48x832033d4[EN_DATASOURCE_MEDIA_FORMAT_TYPE.E_DATASOURCE_MEDIA_FORMAT_TYPE_ESDATA.ordinal()] = MMediaPlayer.DATASOURCE_MEDIA_FORMAT_TYPE_MAX;
            } catch (NoSuchFieldError e57) {
            }
            f47x2cee92cb = new int[EN_DATASOURCE_APP_TYPE.values().length];
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_NETFLIX.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3;
            } catch (NoSuchFieldError e58) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_DLNA.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9;
            } catch (NoSuchFieldError e59) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_HBBTV.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
            } catch (NoSuchFieldError e60) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_WEBBROWSER.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
            } catch (NoSuchFieldError e61) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_WMDRM10.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
            } catch (NoSuchFieldError e62) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_ANDROID_USB.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
            } catch (NoSuchFieldError e63) {
            }
            try {
                f47x2cee92cb[EN_DATASOURCE_APP_TYPE.E_DATASOURCE_AP_ANDROID_STREAMING.ordinal()] = MMediaPlayer.VIDEO_ASPECT_RATIO_4X3_COMBIND;
            } catch (NoSuchFieldError e64) {
            }
        }
    }

    public enum EN_DATASOURCE_APP_TYPE {
        E_DATASOURCE_AP_NORMAL,
        E_DATASOURCE_AP_NETFLIX,
        E_DATASOURCE_AP_DLNA,
        E_DATASOURCE_AP_HBBTV,
        E_DATASOURCE_AP_WEBBROWSER,
        E_DATASOURCE_AP_WMDRM10,
        E_DATASOURCE_AP_ANDROID_USB,
        E_DATASOURCE_AP_ANDROID_STREAMING
    }

    public enum EN_DATASOURCE_MEDIA_FORMAT_TYPE {
        E_DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_AVI,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_MP4,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_MKV,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_ASF,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_RM,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_TS,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_MPG,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_FLV,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_ESDATA,
        E_DATASOURCE_MEDIA_FORMAT_TYPE_MAX
    }

    public enum EN_MOVIE_THUMBNAIL_FORMAT {
        E_MOVIE_THUMBNAIL_ARGB8888,
        E_MOVIE_THUMBNAIL_ARGB1555,
        E_MOVIE_THUMBNAIL_ARGB4444,
        E_MOVIE_THUMBNAIL_YUV422,
        E_MOVIE_THUMBNAIL_NOT_SUPPORT
    }

    public enum EN_MS_DATASOURCE_CONTENT_TYPE {
        E_DATASOURCE_CONTENT_TYPE_MASS_STORAGE,
        E_DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITH_SEEK,
        E_DATASOURCE_CONTENT_TYPE_NETWORK_STREAM_WITHOUT_SEEK,
        E_DATASOURCE_CONTENT_TYPE_ES
    }

    public enum EN_MS_DATASOURCE_ES_AUDIO_CODEC {
        E_DATASOURCE_ES_AUDIO_CODEC_UNKNOW,
        E_DATASOURCE_ES_AUDIO_CODEC_WMA,
        E_DATASOURCE_ES_AUDIO_CODEC_DTS,
        E_DATASOURCE_ES_AUDIO_CODEC_MP3,
        E_DATASOURCE_ES_AUDIO_CODEC_MPEG,
        E_DATASOURCE_ES_AUDIO_CODEC_AC3,
        E_DATASOURCE_ES_AUDIO_CODEC_AC3_PLUS,
        E_DATASOURCE_ES_AUDIO_CODEC_AAC,
        E_DATASOURCE_ES_AUDIO_CODEC_PCM,
        E_DATASOURCE_ES_AUDIO_CODEC_ADPCM,
        E_DATASOURCE_ES_AUDIO_CODEC_RAAC,
        E_DATASOURCE_ES_AUDIO_CODEC_COOK,
        E_DATASOURCE_ES_AUDIO_CODEC_FLAC,
        E_DATASOURCE_ES_AUDIO_CODEC_VORBIS,
        E_DATASOURCE_ES_AUDIO_CODEC_AMR_NB,
        E_DATASOURCE_ES_AUDIO_CODEC_AMR_WB
    }

    public enum EN_MS_DATASOURCE_ES_VIDEO_CODEC {
        E_DATASOURCE_ES_VIDEO_CODEC_UNKNOW,
        E_DATASOURCE_ES_VIDEO_CODEC_MPEG1VIDEO,
        E_DATASOURCE_ES_VIDEO_CODEC_MPEG2VIDEO,
        E_DATASOURCE_ES_VIDEO_CODEC_MPEG4,
        E_DATASOURCE_ES_VIDEO_CODEC_H263,
        E_DATASOURCE_ES_VIDEO_CODEC_DIVX3,
        E_DATASOURCE_ES_VIDEO_CODEC_DIVX4,
        E_DATASOURCE_ES_VIDEO_CODEC_DIVX,
        E_DATASOURCE_ES_VIDEO_CODEC_H264,
        E_DATASOURCE_ES_VIDEO_CODEC_AVS,
        E_DATASOURCE_ES_VIDEO_CODEC_RV30,
        E_DATASOURCE_ES_VIDEO_CODEC_RV40,
        E_DATASOURCE_ES_VIDEO_CODEC_MJPEG,
        E_DATASOURCE_ES_VIDEO_CODEC_VC1,
        E_DATASOURCE_ES_VIDEO_CODEC_WMV3,
        E_DATASOURCE_ES_VIDEO_CODEC_FLV,
        E_DATASOURCE_ES_VIDEO_CODEC_FOURCCEX,
        E_DATASOURCE_ES_VIDEO_CODEC_TS
    }

    public enum EN_MS_DATASOURCE_PLAYER_TYPE {
        E_DATASOURCE_PLAYER_UNKNOW,
        E_DATASOURCE_PLAYER_MOVIE,
        E_DATASOURCE_PLAYER_MUSIC
    }

    public enum EnumPlayerSeamlessMode {
        E_PLAYER_SEAMLESS_NONE,
        E_PLAYER_SEAMLESS_FREEZ,
        E_PLAYER_SEAMLESS_SMOTH,
        E_PLAYER_SEAMLESS_DS
    }

    public enum EnumVideoAspectRatio {
        E_VIDEO_ASPECT_RATIO_AUTO,
        E_VIDEO_ASPECT_RATIO_4X3,
        E_VIDEO_ASPECT_RATIO_16X9,
        E_VIDEO_ASPECT_RATIO_16X9_PILLARBOX,
        E_VIDEO_ASPECT_RATIO_4X3_PAN_SCAN,
        E_VIDEO_ASPECT_RATIO_4X3_LETTER_BOX,
        E_VIDEO_ASPECT_RATIO_16X9_PAN_SCAN,
        E_VIDEO_ASPECT_RATIO_4X3_COMBIND,
        E_VIDEO_ASPECT_RATIO_16X9_COMBIND
    }

    public class InitParameter {
        public int cropHeight;
        public int cropWidth;
        public int cropX;
        public int cropY;
        public float degrees;
        public float scaleX;
        public float scaleY;

        public InitParameter() {
            this.degrees = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.cropX = MMediaPlayer.MS_DATASOURCE_PLAYER_UNKNOW;
            this.cropY = MMediaPlayer.MS_DATASOURCE_PLAYER_UNKNOW;
            this.cropWidth = MMediaPlayer.MS_DATASOURCE_PLAYER_UNKNOW;
            this.cropHeight = MMediaPlayer.MS_DATASOURCE_PLAYER_UNKNOW;
        }
    }

    public static class MsTrackInfo implements Parcelable {
        static final Creator<MsTrackInfo> CREATOR;
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_TIMEDBITMAP = 4;
        public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        final String mLanguage;
        final int mStreamId;
        final int mTrackType;

        /* renamed from: com.mstar.android.media.MMediaPlayer.MsTrackInfo.1 */
        static class C00941 implements Creator<MsTrackInfo> {
            C00941() {
            }

            public MsTrackInfo createFromParcel(Parcel in) {
                return new MsTrackInfo(in);
            }

            public MsTrackInfo[] newArray(int size) {
                return new MsTrackInfo[size];
            }
        }

        public int getTrackType() {
            return this.mTrackType;
        }

        public String getLanguage() {
            return this.mLanguage;
        }

        public int getStreamId() {
            return this.mStreamId;
        }

        MsTrackInfo(Parcel in) {
            this.mTrackType = in.readInt();
            this.mLanguage = in.readString();
            this.mStreamId = in.readInt();
        }

        public int describeContents() {
            return MEDIA_TRACK_TYPE_UNKNOWN;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mTrackType);
            dest.writeString(this.mLanguage);
            dest.writeInt(this.mStreamId);
        }

        static {
            CREATOR = new C00941();
        }
    }

    private native void _setDataSource(InputStream inputStream) throws IOException, IllegalArgumentException, IllegalStateException;

    private native void _setSubtitleSurface(Surface surface);

    private static final native void native_init();

    public native int divx_GetAutochapter();

    public native int divx_GetAutochapterTime(int i);

    public native int divx_GetChapter();

    public native int divx_GetChapterTime(int i);

    public native int divx_GetEdition();

    public native int divx_GetTitle();

    public native void divx_SetAutochapter(int i);

    public native void divx_SetChapter(int i);

    public native void divx_SetEdition(int i);

    public native void divx_SetTitle(int i);

    public native String getAudioTrackStringData(int i);

    public native int getPlayMode();

    public native String getSubtitleData();

    public native Bitmap native_captureMovieThumbnail(Parcel parcel, Parcel parcel2);

    public native void native_divx_SetReplayFlag(boolean z);

    public native int native_divx_SetResumePlay(Parcel parcel);

    public native void native_setExternalDataSourceInfo(Parcel parcel);

    public native void native_setVideoDisplayAspectRatio(int i);

    public native void offSubtitleTrack();

    public native void onSubtitleTrack();

    public native void setAudioTrack(int i);

    public native boolean setPlayMode(int i);

    public native void setSubtitleDataSource(String str);

    public native int setSubtitleSync(int i);

    public native void setSubtitleTrack(int i);

    public MMediaPlayer() {
        this.mDataSourcePlayerType = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceContentType = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceVideoCodec = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceAudioCodec = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceMediaFormat = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceAppType = MS_DATASOURCE_PLAYER_UNKNOW;
    }

    static {
        System.loadLibrary("mmedia_jni");
        native_init();
    }

    @Deprecated
    public boolean SetImageSampleSize(int imageSampleSize) {
        Parcel p = Parcel.obtain();
        p.writeInt(imageSampleSize);
        boolean ret = setParameter(KEY_PARAMETER_SET_IMAGE_SAMPLESIZE_SURFACESIZE, p);
        p.recycle();
        return ret;
    }

    @Deprecated
    public boolean SetImageSampleSize(int imageSampleSize, int surfaceWidth, int surfaceHeight) {
        Parcel p = Parcel.obtain();
        p.writeInt(imageSampleSize);
        p.writeInt(surfaceWidth);
        p.writeInt(surfaceHeight);
        boolean ret = setParameter(KEY_PARAMETER_SET_IMAGE_SAMPLESIZE_SURFACESIZE, p);
        p.recycle();
        return ret;
    }

    public boolean SetImageSampleSize(int imageSampleSize, int surfaceWidth, int surfaceHeight, InitParameter parameter) {
        Parcel p = Parcel.obtain();
        p.writeInt(imageSampleSize);
        p.writeInt(surfaceWidth);
        p.writeInt(surfaceHeight);
        if (parameter != null) {
            p.writeFloat(parameter.degrees);
            p.writeFloat(parameter.scaleX);
            p.writeFloat(parameter.scaleY);
            p.writeInt(parameter.cropX);
            p.writeInt(parameter.cropY);
            p.writeInt(parameter.cropWidth);
            p.writeInt(parameter.cropHeight);
        } else {
            p.writeFloat(0.0f);
            p.writeFloat(1.0f);
            p.writeFloat(1.0f);
            p.writeInt(MS_DATASOURCE_PLAYER_UNKNOW);
            p.writeInt(MS_DATASOURCE_PLAYER_UNKNOW);
            p.writeInt(MS_DATASOURCE_PLAYER_UNKNOW);
            p.writeInt(MS_DATASOURCE_PLAYER_UNKNOW);
        }
        boolean ret = setParameter(KEY_PARAMETER_SET_IMAGE_SAMPLESIZE_SURFACESIZE, p);
        p.recycle();
        return ret;
    }

    @Deprecated
    public boolean ImageRotate(float degrees) {
        Parcel p = Parcel.obtain();
        p.writeFloat(degrees);
        boolean ret = setParameter(KEY_PARAMETER_ROTATE, p);
        p.recycle();
        return ret;
    }

    public boolean ImageRotate(float degrees, boolean isAutoCrop) {
        Parcel p = Parcel.obtain();
        p.writeFloat(degrees);
        p.writeInt(isAutoCrop ? VIDEO_ASPECT_RATIO_4X3 : MS_DATASOURCE_PLAYER_UNKNOW);
        boolean ret = setParameter(KEY_PARAMETER_ROTATE, p);
        p.recycle();
        return ret;
    }

    @Deprecated
    public boolean ImageScale(float scaleX, float scaleY) {
        Parcel p = Parcel.obtain();
        p.writeFloat(scaleX);
        p.writeFloat(scaleY);
        boolean ret = setParameter(KEY_PARAMETER_SCALE, p);
        p.recycle();
        return ret;
    }

    public boolean ImageScale(float scaleX, float scaleY, boolean isAutoCrop) {
        Parcel p = Parcel.obtain();
        p.writeFloat(scaleX);
        p.writeFloat(scaleY);
        p.writeInt(isAutoCrop ? VIDEO_ASPECT_RATIO_4X3 : MS_DATASOURCE_PLAYER_UNKNOW);
        boolean ret = setParameter(KEY_PARAMETER_SCALE, p);
        p.recycle();
        return ret;
    }

    public boolean ImageRotateAndScale(float degrees, float scaleX, float scaleY, boolean isAutoCrop) {
        Parcel p = Parcel.obtain();
        p.writeFloat(degrees);
        p.writeFloat(scaleX);
        p.writeFloat(scaleY);
        p.writeInt(isAutoCrop ? VIDEO_ASPECT_RATIO_4X3 : MS_DATASOURCE_PLAYER_UNKNOW);
        boolean ret = setParameter(KEY_PARAMETER_ROTATE_SCALE, p);
        p.recycle();
        return ret;
    }

    public boolean ImageCropRect(int cropX, int cropY, int cropWidth, int cropHeight) {
        Parcel p = Parcel.obtain();
        p.writeInt(cropX);
        p.writeInt(cropY);
        p.writeInt(cropWidth);
        p.writeInt(cropHeight);
        boolean ret = setParameter(KEY_PARAMETER_CROP_RECT, p);
        p.recycle();
        return ret;
    }

    public boolean DemuxReset() {
        return setParameter(KEY_PARAMETER_DEMUX_RESET, DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN);
    }

    public boolean DataSourceSwitch(String path) {
        return setParameter(KEY_PARAMETER_DATASOURCE_SWITCH, path);
    }

    public boolean setExternalDataSourceAppType(EN_DATASOURCE_APP_TYPE type) {
        switch (C00931.f47x2cee92cb[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_PAN_SCAN /*4*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_4X3_LETTER_BOX /*5*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PAN_SCAN /*6*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_4X3_COMBIND /*7*/:
                this.mDataSourceAppType = VIDEO_ASPECT_RATIO_4X3_COMBIND;
                break;
            default:
                this.mDataSourceAppType = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
        }
        return true;
    }

    public boolean setExternalDataSourceMediaFormat(EN_DATASOURCE_MEDIA_FORMAT_TYPE type) {
        switch (C00931.f48x832033d4[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourceMediaFormat = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_4X3_PAN_SCAN /*4*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_LETTER_BOX /*5*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PAN_SCAN /*6*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_COMBIND /*7*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_COMBIND /*8*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_4X3_COMBIND;
                break;
            case DATASOURCE_MEDIA_FORMAT_TYPE_MAX /*9*/:
                this.mDataSourceMediaFormat = VIDEO_ASPECT_RATIO_16X9_COMBIND;
                break;
            default:
                this.mDataSourceMediaFormat = DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN;
                break;
        }
        return true;
    }

    public boolean setExternalDataSourceVideoCodec(EN_MS_DATASOURCE_ES_VIDEO_CODEC type) {
        switch (C00931.f51x63c565a9[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourceVideoCodec = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_4X3_PAN_SCAN /*4*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_LETTER_BOX /*5*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PAN_SCAN /*6*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_COMBIND /*7*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_COMBIND /*8*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_4X3_COMBIND;
                break;
            case DATASOURCE_MEDIA_FORMAT_TYPE_MAX /*9*/:
                this.mDataSourceVideoCodec = VIDEO_ASPECT_RATIO_16X9_COMBIND;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_RV40 /*10*/:
                this.mDataSourceVideoCodec = DATASOURCE_MEDIA_FORMAT_TYPE_MAX;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_MJPEG /*11*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_RV40;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_VC1 /*12*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_MJPEG;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_WMV3 /*13*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_VC1;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_FLV /*14*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_WMV3;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_FOURCCEX /*15*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_FLV;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_TS /*16*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_FOURCCEX;
                break;
            case WidiMonitor.WIDI_START_SUCCESS_EVENT /*17*/:
                this.mDataSourceVideoCodec = DATASOURCE_ES_VIDEO_CODEC_TS;
                break;
            default:
                this.mDataSourceVideoCodec = DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN;
                break;
        }
        return true;
    }

    public boolean setExternalDataSourceAudioCodec(EN_MS_DATASOURCE_ES_AUDIO_CODEC type) {
        switch (C00931.f50x3ff8bcc4[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourceAudioCodec = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_4X3_PAN_SCAN /*4*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_LETTER_BOX /*5*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_4X3_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PAN_SCAN /*6*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_4X3_LETTER_BOX;
                break;
            case VIDEO_ASPECT_RATIO_4X3_COMBIND /*7*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_16X9_PAN_SCAN;
                break;
            case VIDEO_ASPECT_RATIO_16X9_COMBIND /*8*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_4X3_COMBIND;
                break;
            case DATASOURCE_MEDIA_FORMAT_TYPE_MAX /*9*/:
                this.mDataSourceAudioCodec = VIDEO_ASPECT_RATIO_16X9_COMBIND;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_RV40 /*10*/:
                this.mDataSourceAudioCodec = DATASOURCE_MEDIA_FORMAT_TYPE_MAX;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_MJPEG /*11*/:
                this.mDataSourceAudioCodec = DATASOURCE_ES_VIDEO_CODEC_RV40;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_VC1 /*12*/:
                this.mDataSourceAudioCodec = DATASOURCE_ES_VIDEO_CODEC_MJPEG;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_WMV3 /*13*/:
                this.mDataSourceAudioCodec = DATASOURCE_ES_VIDEO_CODEC_VC1;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_FLV /*14*/:
                this.mDataSourceAudioCodec = DATASOURCE_ES_VIDEO_CODEC_WMV3;
                break;
            case DATASOURCE_ES_VIDEO_CODEC_FOURCCEX /*15*/:
                this.mDataSourceAudioCodec = DATASOURCE_ES_VIDEO_CODEC_FLV;
                break;
            default:
                this.mDataSourceAudioCodec = DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN;
                break;
        }
        return true;
    }

    public boolean setExternalDataSourcePlayerType(EN_MS_DATASOURCE_PLAYER_TYPE type) {
        switch (C00931.f52x39866a30[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourcePlayerType = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourcePlayerType = VIDEO_ASPECT_RATIO_16X9;
                break;
            default:
                this.mDataSourcePlayerType = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
        }
        return true;
    }

    public boolean setExternalDataSourceContentType(EN_MS_DATASOURCE_CONTENT_TYPE type) {
        switch (C00931.f49xee8ec608[type.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                this.mDataSourceContentType = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                this.mDataSourceContentType = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                this.mDataSourceContentType = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            default:
                this.mDataSourceContentType = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
        }
        return true;
    }

    public void setDataSource(InputStream dataSource) throws IOException, IllegalArgumentException, IllegalStateException {
        Parcel p = Parcel.obtain();
        p.writeInt(this.mDataSourcePlayerType);
        p.writeInt(this.mDataSourceContentType);
        p.writeInt(this.mDataSourceVideoCodec);
        p.writeInt(this.mDataSourceAudioCodec);
        p.writeInt(this.mDataSourceMediaFormat);
        p.writeInt(this.mDataSourceAppType);
        native_setExternalDataSourceInfo(p);
        _setDataSource(dataSource);
        this.mDataSourcePlayerType = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceContentType = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceVideoCodec = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceAudioCodec = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceMediaFormat = MS_DATASOURCE_PLAYER_UNKNOW;
        this.mDataSourceAppType = MS_DATASOURCE_PLAYER_UNKNOW;
    }

    public boolean SetSeamlessMode(EnumPlayerSeamlessMode index) {
        int idx;
        switch (C00931.f53x4bcacd4b[index.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                idx = MS_DATASOURCE_PLAYER_UNKNOW;
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                idx = VIDEO_ASPECT_RATIO_4X3;
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                idx = VIDEO_ASPECT_RATIO_16X9;
                break;
            case VIDEO_ASPECT_RATIO_4X3_PAN_SCAN /*4*/:
                idx = VIDEO_ASPECT_RATIO_16X9_PILLARBOX;
                break;
            default:
                idx = DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN;
                break;
        }
        if (idx == DATASOURCE_MEDIA_FORMAT_TYPE_UNKNOWN) {
            return false;
        }
        return setParameter(KEY_PARAMETER_SET_SEAMLESS_MODE, idx);
    }

    public static MMediaPlayer create(InputStream inputStream, SurfaceHolder holder) {
        try {
            MMediaPlayer mp = new MMediaPlayer();
            mp.setDataSource(inputStream);
            if (holder != null) {
                mp.setDisplay(holder);
            }
            mp.prepare();
            return mp;
        } catch (IOException ex) {
            Log.d(TAG, "create failed:", ex);
            return null;
        } catch (IllegalArgumentException ex2) {
            Log.d(TAG, "create failed:", ex2);
            return null;
        } catch (SecurityException ex3) {
            Log.d(TAG, "create failed:", ex3);
            return null;
        }
    }

    public AudioTrackInfo getAudioTrackInfo(boolean typeIsAudio) {
        Metadata data = getMetadata(false, true);
        String[] strInfo = new String[VIDEO_ASPECT_RATIO_16X9_PILLARBOX];
        if (typeIsAudio) {
            for (int i = MS_DATASOURCE_PLAYER_UNKNOW; i < VIDEO_ASPECT_RATIO_16X9_PILLARBOX; i += VIDEO_ASPECT_RATIO_4X3) {
                strInfo[i] = getAudioTrackStringData(i);
            }
        }
        if (data != null) {
            return new AudioTrackInfo(typeIsAudio, data, strInfo);
        }
        Log.e(TAG, "getAudioTrackInfo getMetadata return null!!");
        return null;
    }

    public SubtitleTrackInfo getSubtitleTrackInfo(int trackIndex) {
        if (setParameter(KEY_PARAMETER_SET_SUBTITLE_INDEX, trackIndex)) {
            return new SubtitleTrackInfo(getParcelParameter(KEY_PARAMETER_GET_SUBTITLE_TRACK_INFO));
        }
        return null;
    }

    public SubtitleTrackInfo getAllSubtitleTrackInfo() {
        return new SubtitleTrackInfo(getParcelParameter(KEY_PARAMETER_GET_ALL_SUBTITLE_TRACK_INFO), MS_DATASOURCE_PLAYER_UNKNOW);
    }

    private void updateSubtitleSurfaceScreenOn() {
        if (this.mSubtitleSurfaceHolder != null) {
            this.mSubtitleSurfaceHolder.setKeepScreenOn(false);
        }
    }

    public void setSubtitleDisplay(SurfaceHolder sh) {
        Surface surface;
        this.mSubtitleSurfaceHolder = sh;
        if (sh != null) {
            surface = sh.getSurface();
        } else {
            surface = null;
        }
        _setSubtitleSurface(surface);
        updateSubtitleSurfaceScreenOn();
    }

    public MsTrackInfo[] getMsTrackInfo() throws IllegalStateException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            request.writeInterfaceToken(IMEDIA_PLAYER);
            request.writeInt(MEDIA_INFO_AUDIO_UNSUPPORT);
            invoke(request, reply);
            MsTrackInfo[] trackInfo = (MsTrackInfo[]) reply.createTypedArray(MsTrackInfo.CREATOR);
            return trackInfo;
        } finally {
            request.recycle();
            reply.recycle();
        }
    }

    public DivxDrmInfo divx_GetDrmInfo() {
        Metadata data = getMetadata(false, true);
        if (data != null) {
            return new DivxDrmInfo(data);
        }
        Log.e(TAG, "divx_GetDrmInfo getMetadata return null!!");
        return null;
    }

    public int divx_SetResumePlay(DivxResumeInfo info) {
        Parcel p = Parcel.obtain();
        p.writeLong(info.getFilePos());
        p.writeInt(info.getPTS());
        p.writeInt(info.getResumeMKV());
        p.writeInt(info.getTitle());
        p.writeInt(info.getEdition());
        int ret = native_divx_SetResumePlay(p);
        p.recycle();
        return ret;
    }

    public void divx_GetResumePlay(DivxResumeInfo info) {
        Metadata data = getMetadata(false, true);
        if (data != null) {
            if (data.has(41)) {
                info.setFilePos(data.getLong(41));
            }
            if (data.has(42)) {
                info.setPTS(data.getInt(42));
            }
            if (data.has(43)) {
                info.setResumeMKV(data.getInt(43));
            }
            if (data.has(44)) {
                info.setTitle(data.getInt(44));
            }
            if (data.has(45)) {
                info.setEdition(data.getInt(45));
                return;
            }
            return;
        }
        Log.e(TAG, "divx_GetResumePlay getMetadata return null!!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void divx_GetDrmRegInfo(java.lang.String r5, java.lang.String[] r6) {
        /*
        r4 = this;
        r1 = new android.media.MediaMetadataRetriever;
        r1.<init>();
        r1.setDataSource(r5);	 Catch:{ IllegalArgumentException -> 0x001b, RuntimeException -> 0x0022, all -> 0x0029 }
        r0 = 0;
    L_0x0009:
        r2 = 4;
        if (r0 >= r2) goto L_0x0017;
    L_0x000c:
        r2 = r0 + 26;
        r2 = r1.extractMetadata(r2);	 Catch:{ IllegalArgumentException -> 0x001b, RuntimeException -> 0x0022, all -> 0x0029 }
        r6[r0] = r2;	 Catch:{ IllegalArgumentException -> 0x001b, RuntimeException -> 0x0022, all -> 0x0029 }
        r0 = r0 + 1;
        goto L_0x0009;
    L_0x0017:
        r1.release();	 Catch:{ RuntimeException -> 0x002e }
    L_0x001a:
        return;
    L_0x001b:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0020 }
        goto L_0x001a;
    L_0x0020:
        r2 = move-exception;
        goto L_0x001a;
    L_0x0022:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0027 }
        goto L_0x001a;
    L_0x0027:
        r2 = move-exception;
        goto L_0x001a;
    L_0x0029:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0030 }
    L_0x002d:
        throw r2;
    L_0x002e:
        r2 = move-exception;
        goto L_0x001a;
    L_0x0030:
        r3 = move-exception;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.media.MMediaPlayer.divx_GetDrmRegInfo(java.lang.String, java.lang.String[]):void");
    }

    public String getAudioCodecType() {
        Metadata data = getMetadata(false, true);
        if (data != null && data.has(METADATA_KEY_DIVX_DRM_IS_DEVICE_FIRSTTIME_REG)) {
            return data.getString(METADATA_KEY_DIVX_DRM_IS_DEVICE_FIRSTTIME_REG);
        }
        Log.e(TAG, "getAudioCodecType getMetadata return null!!");
        return null;
    }

    public VideoCodecInfo getVideoInfo() {
        Metadata data = getMetadata(false, true);
        if (data != null) {
            return new VideoCodecInfo(data);
        }
        Log.e(TAG, "getVideoInfo getMetadata return null!!");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap captureVideoThumbnail(java.lang.String r5, int r6, int r7) {
        /*
        r4 = this;
        r0 = 0;
        r1 = new android.media.MediaMetadataRetriever;
        r1.<init>();
        r1.setDataSource(r5);	 Catch:{ IllegalArgumentException -> 0x0016, RuntimeException -> 0x001d, all -> 0x0024 }
        r2 = -1;
        r0 = r1.getFrameAtTime(r2);	 Catch:{ IllegalArgumentException -> 0x0016, RuntimeException -> 0x001d, all -> 0x0024 }
        r1.release();	 Catch:{ RuntimeException -> 0x0030 }
    L_0x0012:
        if (r0 != 0) goto L_0x0029;
    L_0x0014:
        r2 = 0;
    L_0x0015:
        return r2;
    L_0x0016:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x001b }
        goto L_0x0012;
    L_0x001b:
        r2 = move-exception;
        goto L_0x0012;
    L_0x001d:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0022 }
        goto L_0x0012;
    L_0x0022:
        r2 = move-exception;
        goto L_0x0012;
    L_0x0024:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0032 }
    L_0x0028:
        throw r2;
    L_0x0029:
        r2 = 1;
        r0 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r7, r2);
        r2 = r0;
        goto L_0x0015;
    L_0x0030:
        r2 = move-exception;
        goto L_0x0012;
    L_0x0032:
        r3 = move-exception;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mstar.android.media.MMediaPlayer.captureVideoThumbnail(java.lang.String, int, int):android.graphics.Bitmap");
    }

    public void captureVideoThumbnailRelease() {
        Log.d(TAG, "captureVideoThumbnailRelease");
        release();
    }

    public boolean setVideoDisplayAspectRatio(EnumVideoAspectRatio aspectRatio) {
        Log.d(TAG, "aspect Ratio:" + aspectRatio);
        switch (C00931.f54x7d0a408[aspectRatio.ordinal()]) {
            case VIDEO_ASPECT_RATIO_4X3 /*1*/:
                native_setVideoDisplayAspectRatio(MS_DATASOURCE_PLAYER_UNKNOW);
                break;
            case VIDEO_ASPECT_RATIO_16X9 /*2*/:
                native_setVideoDisplayAspectRatio(VIDEO_ASPECT_RATIO_4X3);
                break;
            case VIDEO_ASPECT_RATIO_16X9_PILLARBOX /*3*/:
                native_setVideoDisplayAspectRatio(VIDEO_ASPECT_RATIO_16X9);
                break;
            default:
                native_setVideoDisplayAspectRatio(MS_DATASOURCE_PLAYER_UNKNOW);
                break;
        }
        return true;
    }

    public void addTimedTextSource(String path, String mimeType) throws IOException, IllegalArgumentException, IllegalStateException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream is = new FileInputStream(file);
            addTimedTextSource(is.getFD(), mimeType);
            is.close();
            return;
        }
        throw new IOException(path);
    }

    public void addTimedTextSource(FileDescriptor fd, long offset, long length, String mimeType) throws IllegalArgumentException, IllegalStateException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            request.writeInterfaceToken(IMEDIA_PLAYER);
            request.writeInt(VIDEO_ASPECT_RATIO_16X9_PILLARBOX);
            request.writeFileDescriptor(fd);
            request.writeLong(offset);
            request.writeLong(length);
            request.writeString(mimeType);
            invoke(request, reply);
        } finally {
            request.recycle();
            reply.recycle();
        }
    }
}
