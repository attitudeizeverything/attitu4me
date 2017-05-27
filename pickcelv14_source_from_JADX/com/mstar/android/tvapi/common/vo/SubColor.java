package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SubColor implements Parcelable {
    public static final Creator<SubColor> CREATOR;
    public int checkSum;
    public short subBrightness;
    public short subContrast;

    /* renamed from: com.mstar.android.tvapi.common.vo.SubColor.1 */
    static class C01671 implements Creator<SubColor> {
        C01671() {
        }

        public SubColor createFromParcel(Parcel in) {
            return new SubColor(in);
        }

        public SubColor[] newArray(int size) {
            return new SubColor[size];
        }
    }

    public SubColor() {
        this.checkSum = 0;
        this.subBrightness = (short) 0;
        this.subContrast = (short) 0;
    }

    public SubColor(Parcel in) {
        this.checkSum = in.readInt();
        this.subBrightness = (short) in.readInt();
        this.subContrast = (short) in.readInt();
    }

    static {
        CREATOR = new C01671();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.checkSum);
        dest.writeInt(this.subBrightness);
        dest.writeInt(this.subContrast);
    }
}
