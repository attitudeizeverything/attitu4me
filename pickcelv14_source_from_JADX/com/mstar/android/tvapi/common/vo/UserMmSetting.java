package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserMmSetting implements Parcelable {
    public static final Creator<UserMmSetting> CREATOR;
    public byte previewOn;
    public byte reserved;
    public byte resumePlay;
    public short slideShowMode;
    public short slideShowTime;
    public short subtitleBgColor;
    public short subtitleFontColor;
    public short subtitleSpecific;

    /* renamed from: com.mstar.android.tvapi.common.vo.UserMmSetting.1 */
    static class C01751 implements Creator<UserMmSetting> {
        C01751() {
        }

        public UserMmSetting createFromParcel(Parcel in) {
            return new UserMmSetting(in);
        }

        public UserMmSetting[] newArray(int size) {
            return new UserMmSetting[size];
        }
    }

    public UserMmSetting() {
        this.subtitleSpecific = (short) 0;
        this.subtitleBgColor = (short) 0;
        this.subtitleFontColor = (short) 0;
        this.slideShowTime = (short) 0;
        this.slideShowMode = (short) 0;
        this.previewOn = (byte) 0;
        this.resumePlay = (byte) 0;
        this.reserved = (byte) 0;
    }

    public UserMmSetting(Parcel in) {
        this.subtitleSpecific = (short) in.readInt();
        this.subtitleBgColor = (short) in.readInt();
        this.subtitleFontColor = (short) in.readInt();
        this.slideShowTime = (short) in.readInt();
        this.slideShowMode = (short) in.readInt();
        this.previewOn = in.readByte();
        this.resumePlay = in.readByte();
        this.reserved = in.readByte();
    }

    static {
        CREATOR = new C01751();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.subtitleSpecific);
        dest.writeInt(this.subtitleBgColor);
        dest.writeInt(this.subtitleFontColor);
        dest.writeInt(this.slideShowTime);
        dest.writeInt(this.slideShowMode);
        dest.writeByte(this.previewOn);
        dest.writeByte(this.resumePlay);
        dest.writeByte(this.reserved);
    }
}
