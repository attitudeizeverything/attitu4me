package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Picture implements Parcelable {
    public static final Creator<Picture> CREATOR;
    public short backlight;
    public short brightness;
    public int colorTemp;
    public short contrast;
    public int dynamicBacklight;
    public int dynamicContrast;
    public short hue;
    public int perfectClear;
    public short saturation;
    public short sharpness;
    public int vibrantColour;

    /* renamed from: com.mstar.android.tvapi.common.vo.Picture.1 */
    static class C01571 implements Creator<Picture> {
        C01571() {
        }

        public Picture createFromParcel(Parcel in) {
            return new Picture(null);
        }

        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    }

    public Picture() {
        this.backlight = (short) 0;
        this.contrast = (short) 0;
        this.brightness = (short) 0;
        this.saturation = (short) 0;
        this.sharpness = (short) 0;
        this.hue = (short) 0;
        this.colorTemp = 0;
        this.vibrantColour = 0;
        this.perfectClear = 0;
        this.dynamicContrast = 0;
        this.dynamicBacklight = 0;
    }

    private Picture(Parcel in) {
        this.backlight = (short) in.readInt();
        this.contrast = (short) in.readInt();
        this.brightness = (short) in.readInt();
        this.saturation = (short) in.readInt();
        this.sharpness = (short) in.readInt();
        this.hue = (short) in.readInt();
        this.colorTemp = in.readInt();
        this.vibrantColour = in.readInt();
        this.perfectClear = in.readInt();
        this.dynamicContrast = in.readInt();
        this.dynamicBacklight = in.readInt();
    }

    static {
        CREATOR = new C01571();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.backlight);
        dest.writeInt(this.contrast);
        dest.writeInt(this.brightness);
        dest.writeInt(this.saturation);
        dest.writeInt(this.sharpness);
        dest.writeInt(this.hue);
        dest.writeInt(this.colorTemp);
        dest.writeInt(this.vibrantColour);
        dest.writeInt(this.perfectClear);
        dest.writeInt(this.dynamicContrast);
        dest.writeInt(this.dynamicBacklight);
    }
}
