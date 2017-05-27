package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumThreeDVideo3DOutputAspect implements Parcelable {
    E_ThreeD_Video_3DOUTPUTASPECT_FULLSCREEN,
    E_ThreeD_Video_3DOUTPUTASPECT_CENTER,
    E_ThreeD_Video_3DOUTPUTASPECT_AUTOADAPTED,
    E_ThreeD_Video_3DOUTPUTASPECT_COUNT;
    
    public static final Creator<EnumThreeDVideo3DOutputAspect> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumThreeDVideo3DOutputAspect.1 */
    static class C01391 implements Creator<EnumThreeDVideo3DOutputAspect> {
        C01391() {
        }

        public EnumThreeDVideo3DOutputAspect createFromParcel(Parcel in) {
            return EnumThreeDVideo3DOutputAspect.values()[in.readInt()];
        }

        public EnumThreeDVideo3DOutputAspect[] newArray(int size) {
            return new EnumThreeDVideo3DOutputAspect[size];
        }
    }

    static {
        CREATOR = new C01391();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
