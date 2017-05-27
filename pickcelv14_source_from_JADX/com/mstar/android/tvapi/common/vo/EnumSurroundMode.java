package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumSurroundMode implements Parcelable {
    E_SURROUND_MODE_OFF,
    E_SURROUND_MODE_ON;
    
    public static final Creator<EnumSurroundMode> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumSurroundMode.1 */
    static class C01381 implements Creator<EnumSurroundMode> {
        C01381() {
        }

        public EnumSurroundMode createFromParcel(Parcel in) {
            return EnumSurroundMode.values()[in.readInt()];
        }

        public EnumSurroundMode[] newArray(int size) {
            return new EnumSurroundMode[size];
        }
    }

    static {
        CREATOR = new C01381();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
