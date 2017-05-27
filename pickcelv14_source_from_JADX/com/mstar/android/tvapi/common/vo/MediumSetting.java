package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediumSetting implements Parcelable {
    public static final Creator<MediumSetting> CREATOR;
    public char antennaPower;
    public int antennaType;
    public int cableSystem;
    public int checkSum;

    /* renamed from: com.mstar.android.tvapi.common.vo.MediumSetting.1 */
    static class C01481 implements Creator<MediumSetting> {
        C01481() {
        }

        public MediumSetting createFromParcel(Parcel in) {
            return new MediumSetting(in);
        }

        public MediumSetting[] newArray(int size) {
            return new MediumSetting[size];
        }
    }

    public MediumSetting() {
        this.checkSum = 0;
        this.antennaType = 0;
        this.cableSystem = 0;
        this.antennaPower = '\u0000';
    }

    public MediumSetting(Parcel in) {
        this.checkSum = in.readInt();
        this.antennaType = in.readInt();
        this.cableSystem = in.readInt();
        this.antennaPower = (char) in.readInt();
    }

    static {
        CREATOR = new C01481();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.checkSum);
        dest.writeInt(this.antennaType);
        dest.writeInt(this.cableSystem);
        dest.writeInt(this.antennaPower);
    }
}
