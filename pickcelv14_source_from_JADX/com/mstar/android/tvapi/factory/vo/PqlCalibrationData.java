package com.mstar.android.tvapi.factory.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PqlCalibrationData implements Parcelable {
    public static final Creator<PqlCalibrationData> CREATOR;
    public int blueGain;
    public int blueOffset;
    public int greenGain;
    public int greenOffset;
    public int redGain;
    public int redOffset;

    /* renamed from: com.mstar.android.tvapi.factory.vo.PqlCalibrationData.1 */
    static class C02351 implements Creator<PqlCalibrationData> {
        C02351() {
        }

        public PqlCalibrationData createFromParcel(Parcel in) {
            return new PqlCalibrationData(null);
        }

        public PqlCalibrationData[] newArray(int size) {
            return new PqlCalibrationData[size];
        }
    }

    public PqlCalibrationData() {
        this.redGain = 0;
        this.greenGain = 0;
        this.blueGain = 0;
        this.redOffset = 0;
        this.greenOffset = 0;
        this.blueOffset = 0;
    }

    private PqlCalibrationData(Parcel in) {
        this.redGain = in.readInt();
        this.greenGain = in.readInt();
        this.blueGain = in.readInt();
        this.redOffset = in.readInt();
        this.greenOffset = in.readInt();
        this.blueOffset = in.readInt();
    }

    static {
        CREATOR = new C02351();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.redGain);
        arg0.writeInt(this.greenGain);
        arg0.writeInt(this.blueGain);
        arg0.writeInt(this.redOffset);
        arg0.writeInt(this.greenOffset);
        arg0.writeInt(this.blueOffset);
    }
}
