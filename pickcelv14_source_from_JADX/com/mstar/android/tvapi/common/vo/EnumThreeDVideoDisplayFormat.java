package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumThreeDVideoDisplayFormat implements Parcelable {
    E_ThreeD_Video_DISPLAYFORMAT_NONE,
    E_ThreeD_Video_DISPLAYFORMAT_SIDE_BY_SIDE,
    E_ThreeD_Video_DISPLAYFORMAT_TOP_BOTTOM,
    E_ThreeD_Video_DISPLAYFORMAT_FRAME_PACKING,
    E_ThreeD_Video_DISPLAYFORMAT_LINE_ALTERNATIVE,
    E_ThreeD_Video_DISPLAYFORMAT_2DTO3D,
    E_ThreeD_Video_DISPLAYFORMAT_AUTO,
    E_ThreeD_Video_DISPLAYFORMAT_CHECK_BOARD,
    E_ThreeD_Video_DISPLAYFORMAT_PIXEL_ALTERNATIVE,
    E_ThreeD_Video_DISPLAYFORMAT_FRAME_ALTERNATIVE,
    E_ThreeD_Video_DISPLAYFORMAT_COUNT;
    
    public static final Creator<EnumThreeDVideoDisplayFormat> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumThreeDVideoDisplayFormat.1 */
    static class C01421 implements Creator<EnumThreeDVideoDisplayFormat> {
        C01421() {
        }

        public EnumThreeDVideoDisplayFormat createFromParcel(Parcel in) {
            return EnumThreeDVideoDisplayFormat.values()[in.readInt()];
        }

        public EnumThreeDVideoDisplayFormat[] newArray(int size) {
            return new EnumThreeDVideoDisplayFormat[size];
        }
    }

    static {
        CREATOR = new C01421();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
