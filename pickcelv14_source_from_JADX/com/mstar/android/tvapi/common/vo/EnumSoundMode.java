package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumSoundMode implements Parcelable {
    E_STANDARD,
    E_MUSIC,
    E_MOVIE,
    E_SPORTS,
    E_USER,
    E_ONSITE1,
    E_ONSITE2,
    E_NUM;
    
    public static final Creator<EnumSoundMode> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumSoundMode.1 */
    static class C01371 implements Creator<EnumSoundMode> {
        C01371() {
        }

        public EnumSoundMode createFromParcel(Parcel in) {
            return EnumSoundMode.values()[in.readInt()];
        }

        public EnumSoundMode[] newArray(int size) {
            return new EnumSoundMode[size];
        }
    }

    static {
        CREATOR = new C01371();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(ordinal());
    }
}
