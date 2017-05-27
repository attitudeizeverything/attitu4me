package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ColorTemperature implements Parcelable {
    public static final Creator<ColorTemperature> CREATOR;
    public short blueOffset;
    public short buleGain;
    public short greenGain;
    public short greenOffset;
    public short redGain;
    public short redOffset;

    /* renamed from: com.mstar.android.tvapi.common.vo.ColorTemperature.1 */
    static class C01271 implements Creator<ColorTemperature> {
        C01271() {
        }

        public ColorTemperature createFromParcel(Parcel in) {
            return new ColorTemperature(in);
        }

        public ColorTemperature[] newArray(int size) {
            return new ColorTemperature[size];
        }
    }

    public ColorTemperature() {
        this.redGain = (short) 0;
        this.greenGain = (short) 0;
        this.buleGain = (short) 0;
        this.redOffset = (short) 0;
        this.greenOffset = (short) 0;
        this.blueOffset = (short) 0;
    }

    public ColorTemperature(short v1, short v2, short v3, short v4, short v5, short v6) {
        this.redGain = v1;
        this.greenGain = v2;
        this.greenGain = v3;
        this.redOffset = v4;
        this.greenOffset = v5;
        this.blueOffset = v6;
    }

    public ColorTemperature(Parcel in) {
        this.redGain = (short) in.readInt();
        this.greenGain = (short) in.readInt();
        this.buleGain = (short) in.readInt();
        this.redOffset = (short) in.readInt();
        this.greenOffset = (short) in.readInt();
        this.blueOffset = (short) in.readInt();
    }

    static {
        CREATOR = new C01271();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.redGain);
        dest.writeInt(this.greenGain);
        dest.writeInt(this.buleGain);
        dest.writeInt(this.redOffset);
        dest.writeInt(this.greenOffset);
        dest.writeInt(this.blueOffset);
    }
}
