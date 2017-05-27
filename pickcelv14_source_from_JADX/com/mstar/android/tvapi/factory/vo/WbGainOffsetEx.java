package com.mstar.android.tvapi.factory.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WbGainOffsetEx implements Parcelable {
    public static final Creator<WbGainOffsetEx> CREATOR;
    public int blueGain;
    public int blueOffset;
    public int greenGain;
    public int greenOffset;
    public int redGain;
    public int redOffset;

    /* renamed from: com.mstar.android.tvapi.factory.vo.WbGainOffsetEx.1 */
    static class C02371 implements Creator<WbGainOffsetEx> {
        C02371() {
        }

        public WbGainOffsetEx createFromParcel(Parcel in) {
            return new WbGainOffsetEx(null);
        }

        public WbGainOffsetEx[] newArray(int size) {
            return new WbGainOffsetEx[size];
        }
    }

    public WbGainOffsetEx() {
        this.redGain = 0;
        this.greenGain = 0;
        this.blueGain = 0;
        this.redOffset = 0;
        this.greenOffset = 0;
        this.blueOffset = 0;
    }

    private WbGainOffsetEx(Parcel in) {
        this.redGain = in.readInt();
        this.greenGain = in.readInt();
        this.blueGain = in.readInt();
        this.redOffset = in.readInt();
        this.greenOffset = in.readInt();
        this.blueOffset = in.readInt();
    }

    static {
        CREATOR = new C02371();
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
