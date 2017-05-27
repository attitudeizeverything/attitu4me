package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ColorTemperatureExData implements Parcelable {
    public static final Creator<ColorTemperatureExData> CREATOR;
    public int blueGain;
    public int blueOffset;
    public int greenGain;
    public int greenOffset;
    public int redGain;
    public int redOffset;

    /* renamed from: com.mstar.android.tvapi.common.vo.ColorTemperatureExData.1 */
    static class C01281 implements Creator<ColorTemperatureExData> {
        C01281() {
        }

        public ColorTemperatureExData createFromParcel(Parcel in) {
            return new ColorTemperatureExData(in);
        }

        public ColorTemperatureExData[] newArray(int size) {
            return new ColorTemperatureExData[size];
        }
    }

    public ColorTemperatureExData() {
        this.redGain = 0;
        this.greenGain = 0;
        this.blueGain = 0;
        this.redOffset = 0;
        this.greenOffset = 0;
        this.blueOffset = 0;
    }

    public ColorTemperatureExData(Parcel in) {
        this.redGain = in.readInt();
        this.greenGain = in.readInt();
        this.blueGain = in.readInt();
        this.redOffset = in.readInt();
        this.greenOffset = in.readInt();
        this.blueOffset = in.readInt();
    }

    static {
        CREATOR = new C01281();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.redGain);
        dest.writeInt(this.greenGain);
        dest.writeInt(this.blueGain);
        dest.writeInt(this.redOffset);
        dest.writeInt(this.greenOffset);
        dest.writeInt(this.blueOffset);
    }
}
