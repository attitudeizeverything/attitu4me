package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CecSetting implements Parcelable {
    public static final Creator<CecSetting> CREATOR;
    public short amplifierControl;
    public short arcStatus;
    public short audioModeStatus;
    public short autoStandby;
    public short cecStatus;
    public int checkSum;
    public short quickMenuSpeakerPreference;
    public short speakerPreference;
    public short tvAutoPowerOn;

    /* renamed from: com.mstar.android.tvapi.common.vo.CecSetting.1 */
    static class C01261 implements Creator<CecSetting> {
        C01261() {
        }

        public CecSetting createFromParcel(Parcel in) {
            return new CecSetting(in);
        }

        public CecSetting[] newArray(int size) {
            return new CecSetting[size];
        }
    }

    public CecSetting() {
        this.checkSum = 0;
        this.cecStatus = (short) 0;
        this.autoStandby = (short) 0;
        this.arcStatus = (short) 0;
        this.audioModeStatus = (short) 0;
        this.tvAutoPowerOn = (short) 0;
        this.amplifierControl = (short) 0;
        this.speakerPreference = (short) 0;
        this.quickMenuSpeakerPreference = (short) 0;
    }

    public CecSetting(Parcel in) {
        this.arcStatus = (short) in.readInt();
        this.audioModeStatus = (short) in.readInt();
        this.autoStandby = (short) in.readInt();
        this.cecStatus = (short) in.readInt();
        this.checkSum = in.readInt();
        this.tvAutoPowerOn = (short) in.readInt();
        this.amplifierControl = (short) in.readInt();
        this.speakerPreference = (short) in.readInt();
        this.quickMenuSpeakerPreference = (short) in.readInt();
    }

    static {
        CREATOR = new C01261();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.arcStatus);
        dest.writeInt(this.audioModeStatus);
        dest.writeInt(this.autoStandby);
        dest.writeInt(this.cecStatus);
        dest.writeInt(this.checkSum);
        dest.writeInt(this.tvAutoPowerOn);
        dest.writeInt(this.amplifierControl);
        dest.writeInt(this.speakerPreference);
        dest.writeInt(this.quickMenuSpeakerPreference);
    }
}
