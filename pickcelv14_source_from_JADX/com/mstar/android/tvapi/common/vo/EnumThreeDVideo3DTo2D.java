package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumThreeDVideo3DTo2D implements Parcelable {
    E_ThreeD_Video_3DTO2D_NONE,
    E_ThreeD_Video_3DTO2D_SIDE_BY_SIDE,
    E_ThreeD_Video_3DTO2D_TOP_BOTTOM,
    E_ThreeD_Video_3DTO2D_FRAME_PACKING,
    E_ThreeD_Video_3DTO2D_LINE_ALTERNATIVE,
    E_ThreeD_Video_3DTO2D_FRAME_ALTERNATIVE,
    E_ThreeD_Video_3DTO2D_AUTO,
    E_ThreeD_Video_3DTO2D_CHECK_BOARD,
    E_ThreeD_Video_3DTO2D_PIXEL_ALTERNATIVE,
    E_ThreeD_Video_3DTO2D_COUNT;
    
    public static final Creator<EnumThreeDVideo3DTo2D> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumThreeDVideo3DTo2D.1 */
    static class C01401 implements Creator<EnumThreeDVideo3DTo2D> {
        C01401() {
        }

        public EnumThreeDVideo3DTo2D createFromParcel(Parcel in) {
            return EnumThreeDVideo3DTo2D.values()[in.readInt()];
        }

        public EnumThreeDVideo3DTo2D[] newArray(int size) {
            return new EnumThreeDVideo3DTo2D[size];
        }
    }

    static {
        CREATOR = new C01401();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
