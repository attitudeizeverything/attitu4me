package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumThreeDVideoAutoStart implements Parcelable {
    E_ThreeD_Video_AUTOSTART_OFF,
    E_ThreeD_Video_AUTOSTART_2D,
    E_ThreeD_Video_AUTOSTART_3D,
    E_ThreeD_Video_AUTOSTART_COUNT;
    
    public static final Creator<EnumThreeDVideoAutoStart> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumThreeDVideoAutoStart.1 */
    static class C01411 implements Creator<EnumThreeDVideoAutoStart> {
        C01411() {
        }

        public EnumThreeDVideoAutoStart createFromParcel(Parcel in) {
            return EnumThreeDVideoAutoStart.values()[in.readInt()];
        }

        public EnumThreeDVideoAutoStart[] newArray(int size) {
            return new EnumThreeDVideoAutoStart[size];
        }
    }

    static {
        CREATOR = new C01411();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
