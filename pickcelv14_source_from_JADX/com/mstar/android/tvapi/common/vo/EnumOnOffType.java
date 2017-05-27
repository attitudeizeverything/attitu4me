package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumOnOffType implements Parcelable {
    E_OFF,
    E_ON,
    E_NUM;
    
    public static final Creator<EnumOnOffType> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumOnOffType.1 */
    static class C01351 implements Creator<EnumOnOffType> {
        C01351() {
        }

        public EnumOnOffType createFromParcel(Parcel in) {
            return EnumOnOffType.values()[in.readInt()];
        }

        public EnumOnOffType[] newArray(int size) {
            return new EnumOnOffType[size];
        }
    }

    static {
        CREATOR = new C01351();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
