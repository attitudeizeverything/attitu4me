package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDimensionInfo implements Parcelable {
    public static final Creator<ThreeDimensionInfo> CREATOR;
    public boolean enable3d;
    public int input3dMode;
    public int output3dMode;

    /* renamed from: com.mstar.android.tvapi.common.vo.ThreeDimensionInfo.1 */
    static class C01691 implements Creator<ThreeDimensionInfo> {
        C01691() {
        }

        public ThreeDimensionInfo createFromParcel(Parcel in) {
            return new ThreeDimensionInfo(in);
        }

        public ThreeDimensionInfo[] newArray(int size) {
            return new ThreeDimensionInfo[size];
        }
    }

    public ThreeDimensionInfo() {
        this.enable3d = false;
        this.input3dMode = 0;
        this.output3dMode = 0;
    }

    public ThreeDimensionInfo(Parcel in) {
        boolean z = true;
        if (in.readInt() != 1) {
            z = false;
        }
        this.enable3d = z;
        this.input3dMode = in.readInt();
        this.output3dMode = in.readInt();
    }

    static {
        CREATOR = new C01691();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.enable3d ? 1 : 0);
        dest.writeInt(this.input3dMode);
        dest.writeInt(this.output3dMode);
    }
}
