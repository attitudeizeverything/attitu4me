package com.mstar.android.tvapi.factory.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WbGainOffset implements Parcelable {
    public static final Creator<WbGainOffset> CREATOR;
    public short blueGain;
    public short blueOffset;
    public short greenGain;
    public short greenOffset;
    public short redGain;
    public short redOffset;

    /* renamed from: com.mstar.android.tvapi.factory.vo.WbGainOffset.1 */
    static class C02361 implements Creator<WbGainOffset> {
        C02361() {
        }

        public WbGainOffset createFromParcel(Parcel in) {
            return new WbGainOffset(null);
        }

        public WbGainOffset[] newArray(int size) {
            return new WbGainOffset[size];
        }
    }

    public WbGainOffset() {
        this.redGain = (short) 0;
        this.greenGain = (short) 0;
        this.blueGain = (short) 0;
        this.redOffset = (short) 0;
        this.greenOffset = (short) 0;
        this.blueOffset = (short) 0;
    }

    private WbGainOffset(Parcel in) {
        this.redGain = (short) in.readInt();
        this.greenGain = (short) in.readInt();
        this.blueGain = (short) in.readInt();
        this.redOffset = (short) in.readInt();
        this.greenOffset = (short) in.readInt();
        this.blueOffset = (short) in.readInt();
    }

    static {
        CREATOR = new C02361();
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
