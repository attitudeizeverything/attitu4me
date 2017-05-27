package com.mstar.android.tvapi.factory.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PictureModeValue implements Parcelable {
    public static final Creator<PictureModeValue> CREATOR;
    public short brightness;
    public short contrast;
    public short hue;
    public short saturation;
    public short sharpness;

    /* renamed from: com.mstar.android.tvapi.factory.vo.PictureModeValue.1 */
    static class C02341 implements Creator<PictureModeValue> {
        C02341() {
        }

        public PictureModeValue createFromParcel(Parcel in) {
            return new PictureModeValue(null);
        }

        public PictureModeValue[] newArray(int size) {
            return new PictureModeValue[size];
        }
    }

    public PictureModeValue() {
        this.brightness = (short) 0;
        this.contrast = (short) 0;
        this.saturation = (short) 0;
        this.sharpness = (short) 0;
        this.hue = (short) 0;
    }

    private PictureModeValue(Parcel in) {
        this.brightness = (short) in.readInt();
        this.contrast = (short) in.readInt();
        this.saturation = (short) in.readInt();
        this.sharpness = (short) in.readInt();
        this.hue = (short) in.readInt();
    }

    static {
        CREATOR = new C02341();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.brightness);
        arg0.writeInt(this.contrast);
        arg0.writeInt(this.saturation);
        arg0.writeInt(this.sharpness);
        arg0.writeInt(this.hue);
    }
}
