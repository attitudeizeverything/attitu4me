package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;

public class UserSubtitleSetting implements Parcelable {
    public static final Creator<UserSubtitleSetting> CREATOR;
    public int enableSubTitle;
    public int hardOfHearing;
    public int reserved;
    public EnumLanguage subtitleDefaultLanguage1;
    public EnumLanguage subtitleDefaultLanguage2;

    /* renamed from: com.mstar.android.tvapi.common.vo.UserSubtitleSetting.1 */
    static class C01771 implements Creator<UserSubtitleSetting> {
        C01771() {
        }

        public UserSubtitleSetting createFromParcel(Parcel in) {
            return new UserSubtitleSetting(in);
        }

        public UserSubtitleSetting[] newArray(int size) {
            return new UserSubtitleSetting[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public UserSubtitleSetting(Parcel in) {
        this.subtitleDefaultLanguage1 = EnumLanguage.E_ENGLISH;
        this.subtitleDefaultLanguage2 = EnumLanguage.E_CHINESE;
        this.hardOfHearing = 1;
        this.enableSubTitle = 1;
        this.reserved = 6;
        this.subtitleDefaultLanguage1 = EnumLanguage.values()[in.readInt()];
        this.subtitleDefaultLanguage2 = EnumLanguage.values()[in.readInt()];
        this.hardOfHearing = in.readInt();
        this.enableSubTitle = in.readInt();
        this.reserved = in.readInt();
    }

    static {
        CREATOR = new C01771();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.subtitleDefaultLanguage1.ordinal());
        arg0.writeInt(this.subtitleDefaultLanguage2.ordinal());
        arg0.writeInt(this.hardOfHearing);
        arg0.writeInt(this.enableSubTitle);
        arg0.writeInt(this.reserved);
    }
}
