package com.mstar.android.media;

import android.media.Metadata;
import android.util.Log;
import com.mstar.android.widi.WidiMonitor;
import java.net.IDN;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;

public class AudioTrackInfo {
    private static final String TAG = "AudioTrackInfo";
    private String mAlbum;
    private String mArtist;
    private String mAudioCodec;
    private int mBitRate;
    private int mCodecID;
    private int mCurrentAudioTrackID;
    private int mCurrentPlayTime;
    private MEDIA_AUDIO_LANGUAGE mLanguageType;
    private int mSampleRate;
    private String mTitle;
    private int mTotalPlayTime;
    private int mYear;

    /* renamed from: com.mstar.android.media.AudioTrackInfo.1 */
    static /* synthetic */ class C00921 {
        static final /* synthetic */ int[] f46xec0b2140;

        static {
            f46xec0b2140 = new int[MEDIA_AUDIO_LANGUAGE.values().length];
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_GERMAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_ENGLISH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_SPANISH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_GREEK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_FRENCH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_CROATIAN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_ITALIAN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_DUTCH.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_POLISH.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_PORTUGUESE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_RUSSIAN.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_ROMANIAN.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_SWEDISH.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_ARABIC.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_CHINESE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_JAPANESE.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f46xec0b2140[MEDIA_AUDIO_LANGUAGE.E_MEDIA_AUDIO_LANGUAGE_KOREAN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    private enum MEDIA_AUDIO_LANGUAGE {
        E_MEDIA_AUDIO_LANGUAGE_GERMAN,
        E_MEDIA_AUDIO_LANGUAGE_ENGLISH,
        E_MEDIA_AUDIO_LANGUAGE_SPANISH,
        E_MEDIA_AUDIO_LANGUAGE_GREEK,
        E_MEDIA_AUDIO_LANGUAGE_FRENCH,
        E_MEDIA_AUDIO_LANGUAGE_CROATIAN,
        E_MEDIA_AUDIO_LANGUAGE_ITALIAN,
        E_MEDIA_AUDIO_LANGUAGE_DUTCH,
        E_MEDIA_AUDIO_LANGUAGE_POLISH,
        E_MEDIA_AUDIO_LANGUAGE_PORTUGUESE,
        E_MEDIA_AUDIO_LANGUAGE_RUSSIAN,
        E_MEDIA_AUDIO_LANGUAGE_ROMANIAN,
        E_MEDIA_AUDIO_LANGUAGE_SWEDISH,
        E_MEDIA_AUDIO_LANGUAGE_ARABIC,
        E_MEDIA_AUDIO_LANGUAGE_CHINESE,
        E_MEDIA_AUDIO_LANGUAGE_JAPANESE,
        E_MEDIA_AUDIO_LANGUAGE_KOREAN,
        E_MEDIA_AUDIO_LANGUAGE_UNDEFINED
    }

    public AudioTrackInfo(boolean typeIsAudio, Metadata metadata, String[] strInfo) {
        if (typeIsAudio) {
            if (metadata.has(20)) {
                this.mBitRate = metadata.getInt(20);
            } else {
                this.mBitRate = -1;
            }
            if (metadata.has(33)) {
                String theYear = IDN.toUnicode(metadata.getString(33));
                int len = theYear.length();
                if (len == 0) {
                    Log.d(TAG, "The year information is null.");
                    this.mYear = 0;
                } else {
                    String date = "";
                    int i = 0;
                    while (i < len) {
                        char curChar = theYear.charAt(i);
                        if (curChar >= '0' && curChar <= '9') {
                            date = date.concat(String.valueOf(curChar));
                        } else if (i + 2 >= len || theYear.charAt(i + 2) <= '0' || theYear.charAt(i + 2) >= '9') {
                            date = date.concat("0");
                        }
                        i++;
                    }
                    int length = 8;
                    if (8 > date.length()) {
                        length = date.length();
                    }
                    this.mYear = Integer.parseInt(date.substring(0, length));
                    Log.d(TAG, "mYear:" + this.mYear);
                }
            } else {
                this.mYear = 0;
            }
            if (metadata.has(23)) {
                this.mSampleRate = metadata.getInt(23);
            } else {
                this.mSampleRate = -1;
            }
            this.mTitle = strInfo[0];
            this.mAlbum = strInfo[1];
            this.mArtist = strInfo[2];
            this.mTotalPlayTime = -1;
            this.mCurrentPlayTime = -1;
        } else {
            if (metadata.has(14)) {
                this.mTotalPlayTime = metadata.getInt(14);
            } else {
                this.mTotalPlayTime = -1;
            }
            if (metadata.has(34)) {
                this.mCurrentPlayTime = metadata.getInt(34);
            } else {
                this.mCurrentPlayTime = -1;
            }
            this.mBitRate = -1;
            this.mYear = 0;
            this.mSampleRate = -1;
            this.mTitle = null;
            this.mAlbum = null;
            this.mArtist = null;
        }
        if (metadata.has(59)) {
            this.mCodecID = metadata.getInt(59);
        } else {
            this.mCodecID = -1;
        }
        if (metadata.has(58)) {
            this.mLanguageType = MEDIA_AUDIO_LANGUAGE.values()[metadata.getInt(58)];
        } else {
            this.mLanguageType = null;
        }
        if (metadata.has(36)) {
            this.mCurrentAudioTrackID = metadata.getInt(36);
        } else {
            this.mCurrentAudioTrackID = -1;
        }
        if (metadata.has(26)) {
            this.mAudioCodec = metadata.getString(26);
        } else {
            this.mAudioCodec = null;
        }
    }

    public int getCodecID() {
        return this.mCodecID;
    }

    public String getAudioCodec() {
        return this.mAudioCodec;
    }

    public int getCurrentAudioTrackID() {
        return this.mCurrentAudioTrackID;
    }

    public int getTotalPlayTime() {
        if (-1 == this.mTotalPlayTime) {
            Log.d(TAG, "Only vedio type can get TotalPlayTime.");
        }
        return this.mTotalPlayTime;
    }

    public int getCurrentPlayTime() {
        if (-1 == this.mCurrentPlayTime) {
            Log.d(TAG, "Only vedio type can get CurrentPlayTime.");
        }
        return this.mCurrentPlayTime;
    }

    public int getBitRate() {
        if (-1 == this.mBitRate) {
            Log.d(TAG, "Only audio type can get BiteRate and local audio couldn't get infomation with the function.");
        }
        return this.mBitRate;
    }

    public int getYear() {
        if (this.mYear == 0) {
            Log.d(TAG, "Only audio type can get Year and local audio couldn't get infomation with the function.");
        }
        return this.mYear;
    }

    public int getSampleRate() {
        if (-1 == this.mSampleRate) {
            Log.d(TAG, "Only audio type can get SampleRate and local audio couldn't get infomation with the function.");
        }
        return this.mSampleRate;
    }

    public String getTitle() {
        if (this.mTitle == null) {
            Log.d(TAG, "Only audio type can get Title and local audio couldn't get infomation with the function.");
        }
        return this.mTitle;
    }

    public String getAlbum() {
        if (this.mAlbum == null) {
            Log.d(TAG, "Only audio type can get Album and local audio couldn't get infomation with the function.");
        }
        return this.mAlbum;
    }

    public String getArtist() {
        if (this.mArtist == null) {
            Log.d(TAG, "Only audio type can get Artist and local auido couldn't get infomation with the function.");
        }
        return this.mArtist;
    }

    public String getAudioLanguageType() {
        if (this.mLanguageType == null) {
            return null;
        }
        switch (C00921.f46xec0b2140[this.mLanguageType.ordinal()]) {
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
            default:
                return "undefined";
        }
    }
}
