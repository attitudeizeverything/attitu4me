package com.mstar.android.media;

import android.os.Parcel;
import android.util.Log;
import com.mstar.android.widi.WidiMonitor;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;

public class SubtitleTrackInfo {
    private static final String TAG = "SubtitleTrackInfo";
    private final int INFO_NUM;
    private final int MAX_SUBTITLE_TRACK;
    private int mDataPos;
    private boolean mIsGetAllInfo;
    private Parcel mParcel;
    private SUBTITLE_LANGUAGE_TYPE mSubtitleLanguageType;
    private int mSubtitleNum;

    /* renamed from: com.mstar.android.media.SubtitleTrackInfo.1 */
    static /* synthetic */ class C00951 {
        static final /* synthetic */ int[] f55x5599595a;

        static {
            f55x5599595a = new int[SUBTITLE_LANGUAGE_TYPE.values().length];
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_GERMAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ENGLISH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_SPANISH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_GREEK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_FRENCH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_CROATIAN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ITALIAN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_DUTCH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_POLISH.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_PORTUGUESE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_RUSSIAN.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ROMANIAN.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_SWEDISH.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ARABIC.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_CHINESE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_JAPANESE.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_KOREAN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f55x5599595a[SUBTITLE_LANGUAGE_TYPE.E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_FARSI.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    private enum SUBTITLE_FILE_TYPE {
        E_MEDIA_SUBTITLE_FILE_TYPE_SMI,
        E_MEDIA_SUBTITLE_FILE_TYPE_SRT,
        E_MEDIA_SUBTITLE_FILE_TYPE_SSA,
        E_MEDIA_SUBTITLE_FILE_TYPE_ASS,
        E_MEDIA_SUBTITLE_FILE_TYPE_SUB,
        E_MEDIA_SUBTITLE_FILE_TYPE_TXT,
        E_MEDIA_SUBTITLE_FILE_TYPE_SUBIDX,
        E_MEDIA_SUBTITLE_FILE_TYPE_SUP,
        E_MEDIA_SUBTITLE_FILE_TYPE_INTERNAL,
        E_MEDIA_SUBTITLE_FILE_TYPE_LRC,
        E_MEDIA_SUBTITLE_FILE_TYPE_NUM
    }

    private enum SUBTITLE_LANGUAGE_TYPE {
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_UNDEFINED,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_GERMAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ENGLISH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_SPANISH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_GREEK,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_FRENCH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_CROATIAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ITALIAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_DUTCH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_POLISH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_PORTUGUESE,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_RUSSIAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ROMANIAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_SWEDISH,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_ARABIC,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_CHINESE,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_JAPANESE,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_KOREAN,
        E_MS_PLAYER_SUBTITLE_PARSER_LANGUAGE_FARSI,
        E_MEDIA_SUBTITLE_PARSER_LANGUAGE_FINNISH,
        E_MEDIA_SUBTITLE_PARSER_LANGUAGE_NORWEGIAN
    }

    private enum SUBTITLE_PARSER_CODE_TYPE {
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_UNKNOWN,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_UNICODE,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_UNICODE_BIG,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_UTF8,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_NATIVE,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_ARGB8888,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_ARGB1555,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_ARGB4444,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_YUV422,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_I2,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_I4,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_I8,
        E_MEDIA_SUBTITLE_PARSER_CODE_TYPE_NUM
    }

    public SubtitleTrackInfo(Parcel reply) {
        this.MAX_SUBTITLE_TRACK = 20;
        this.INFO_NUM = 3;
        this.mParcel = reply;
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel getted is null OR calling SubtitleTrackInfo funtion with a wrong way!");
            return;
        }
        this.mIsGetAllInfo = false;
        this.mDataPos = this.mParcel.dataPosition();
        Log.e(TAG, "mDataPos = " + this.mDataPos);
    }

    public SubtitleTrackInfo(Parcel reply, int subtitleNum) {
        this.MAX_SUBTITLE_TRACK = 20;
        this.INFO_NUM = 3;
        this.mParcel = reply;
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel getted is null OR calling SubtitleTrackInfo funtion with a wrong way!");
            return;
        }
        int totalInfoNum = this.mParcel.readInt();
        this.mDataPos = this.mParcel.dataPosition();
        this.mIsGetAllInfo = true;
        this.mSubtitleNum = (totalInfoNum - 2) / 3;
        if (this.mSubtitleNum > 20) {
            Log.d(TAG, "Subtitle's number overflow! ");
            this.mSubtitleNum = 20;
        }
        if (totalInfoNum < 2) {
            Log.d(TAG, "The video is NOT playing through MstarPlayer or MstPlayer,so all the subtitle trakc infomations are invalid!");
        }
    }

    public int getSubtitleType() {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return -2;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        return this.mParcel.readInt();
    }

    public int getSubtitleCodeType() {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return -2;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        this.mParcel.readInt();
        return this.mParcel.readInt();
    }

    public String getSubtitleLanguageType(boolean isChinese) {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return null;
        }
        if (!this.mIsGetAllInfo) {
            this.mParcel.setDataPosition(this.mDataPos);
            this.mParcel.readInt();
            this.mParcel.readInt();
            this.mSubtitleLanguageType = SUBTITLE_LANGUAGE_TYPE.values()[this.mParcel.readInt()];
        }
        if (this.mSubtitleLanguageType == null) {
            return null;
        }
        if (isChinese) {
            return "";
        }
        switch (C00951.f55x5599595a[this.mSubtitleLanguageType.ordinal()]) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                return "German";
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                return "English";
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                return "Spanish";
            case SID.SID_TYPE_ALIAS /*4*/:
                return "Greek";
            case SID.SID_TYPE_WKN_GRP /*5*/:
                return "French";
            case SID.SID_TYPE_DELETED /*6*/:
                return "Croatian";
            case SID.SID_TYPE_INVALID /*7*/:
                return "Italian";
            case SID.SID_TYPE_UNKNOWN /*8*/:
                return "Dutch";
            case SmbConstants.FLAGS_OFFSET /*9*/:
                return "Polish";
            case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                return "Portuguese";
            case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                return "Russian";
            case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                return "Romanian";
            case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                return "Swedish";
            case SmbConstants.SIGNATURE_OFFSET /*14*/:
                return "Arabic";
            case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                return "Chinese";
            case SmbFile.TYPE_NAMED_PIPE /*16*/:
                return "Japanese";
            case WidiMonitor.WIDI_START_SUCCESS_EVENT /*17*/:
                return "Korean";
            case WidiMonitor.WIDI_BINDED_SUCCESS_EVENT /*18*/:
                return "Farsi";
            default:
                return "undefined";
        }
    }

    public void getSubtitleType(int[] info) {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        int i = 0;
        while (i < this.mSubtitleNum) {
            try {
                info[i] = this.mParcel.readInt();
                this.mParcel.readInt();
                this.mParcel.readInt();
                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                Log.e(TAG, "Parameter of getSubtitleType function must be allocated based on the return value of getAllSubtitleCount()!", ex);
                return;
            }
        }
    }

    public void getSubtitleCodeType(int[] info) {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        int i = 0;
        while (i < this.mSubtitleNum) {
            this.mParcel.readInt();
            try {
                info[i] = this.mParcel.readInt();
                this.mParcel.readInt();
                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                Log.e(TAG, "Parameter of getSubtitleCodeType function must be allocated based on the return value of getAllSubtitleCount()!", ex);
                return;
            }
        }
    }

    public void getSubtitleLanguageType(String[] info, boolean isChinese) {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        int i = 0;
        while (i < this.mSubtitleNum) {
            this.mParcel.readInt();
            this.mParcel.readInt();
            this.mSubtitleLanguageType = SUBTITLE_LANGUAGE_TYPE.values()[this.mParcel.readInt()];
            try {
                info[i] = getSubtitleLanguageType(isChinese);
                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                Log.e(TAG, "Parameter of getSubtitleLanguageType function must be allocated based on the return value of getAllSubtitleCount()!", ex);
                return;
            }
        }
    }

    public int getAllSubtitleCount() {
        return this.mSubtitleNum;
    }

    public int getAllInternalSubtitleCount() {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return -2;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        for (int i = 0; i < this.mSubtitleNum * 3; i++) {
            this.mParcel.readInt();
        }
        return this.mParcel.readInt();
    }

    public int getAllImageSubtitleCount() {
        if (this.mParcel == null) {
            Log.e(TAG, "The parcel in SubtitleTrackInfo object is null!");
            return -2;
        }
        this.mParcel.setDataPosition(this.mDataPos);
        for (int i = 0; i < (this.mSubtitleNum * 3) + 1; i++) {
            this.mParcel.readInt();
        }
        return this.mParcel.readInt();
    }
}
