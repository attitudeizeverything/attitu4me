package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.vo.EnumVideoType;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumAspectRatioCode;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumDtvVideoQuality;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumEpgMainGenreType;

public class DtvEventComponentInfo implements Parcelable {
    public static final Creator<DtvEventComponentInfo> CREATOR;
    public short audioTrackNum;
    public boolean ccService;
    private int enAspectRatio;
    private int enGenreType;
    private int enHd;
    public boolean isAd;
    public boolean mheg5Service;
    public short parentalRating;
    public short subtitleNum;
    public boolean subtitleService;
    public boolean teletextService;
    private int videoType;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvEventComponentInfo.1 */
    static class C02141 implements Creator<DtvEventComponentInfo> {
        C02141() {
        }

        public DtvEventComponentInfo createFromParcel(Parcel in) {
            return new DtvEventComponentInfo(in);
        }

        public DtvEventComponentInfo[] newArray(int size) {
            return new DtvEventComponentInfo[size];
        }
    }

    public DtvEventComponentInfo() {
        this.videoType = 0;
        this.mheg5Service = false;
        this.subtitleService = false;
        this.teletextService = false;
        this.ccService = false;
        this.enHd = 0;
        this.isAd = false;
        this.audioTrackNum = (short) 0;
        this.subtitleNum = (short) 0;
        this.enAspectRatio = 0;
        this.enGenreType = 0;
        this.parentalRating = (short) 0;
    }

    public DtvEventComponentInfo(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.videoType = in.readInt();
        this.mheg5Service = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.subtitleService = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.teletextService = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.ccService = z;
        this.enHd = in.readInt();
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.isAd = z2;
        this.audioTrackNum = (short) in.readInt();
        this.subtitleNum = (short) in.readInt();
        this.enAspectRatio = in.readInt();
        this.enGenreType = in.readInt();
        this.parentalRating = (short) in.readInt();
    }

    public EnumVideoType getVideoType() {
        return EnumVideoType.values()[this.videoType];
    }

    public void setVideoType(EnumVideoType videoType) {
        this.videoType = videoType.ordinal();
    }

    public EnumDtvVideoQuality getDtvVideoQuality() {
        return EnumDtvVideoQuality.values()[this.enHd];
    }

    public void setDtvVideoQuality(EnumDtvVideoQuality videQuality) {
        this.enHd = videQuality.ordinal();
    }

    public EnumAspectRatioCode getAspectRatioCode() {
        return EnumAspectRatioCode.values()[this.enAspectRatio];
    }

    public void setAspectRatioCode(EnumAspectRatioCode aspectRatio) {
        this.enAspectRatio = aspectRatio.ordinal();
    }

    public EnumEpgMainGenreType getGenreType() {
        return null;
    }

    public void setGenreType(EnumEpgMainGenreType genreType) {
        this.enGenreType = genreType.getValue();
    }

    static {
        CREATOR = new C02141();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeInt(this.videoType);
        dest.writeInt(this.mheg5Service ? 1 : 0);
        if (this.subtitleService) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.teletextService) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.ccService) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeInt(this.enHd);
        if (!this.isAd) {
            i2 = 0;
        }
        dest.writeInt(i2);
        dest.writeInt(this.audioTrackNum);
        dest.writeInt(this.subtitleNum);
        dest.writeInt(this.enAspectRatio);
        dest.writeInt(this.enGenreType);
        dest.writeInt(this.parentalRating);
    }
}
