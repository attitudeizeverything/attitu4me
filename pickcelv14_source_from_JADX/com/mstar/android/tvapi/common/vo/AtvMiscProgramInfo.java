package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtvMiscProgramInfo implements Parcelable {
    public static final Creator<AtvMiscProgramInfo> CREATOR;
    public boolean bIsAutoColorSystem;
    public byte eAudioMode;
    public byte eAudioStandard;
    public boolean eMedium;
    public byte eVideoStandard;
    public byte eVolumeCompensation;
    public boolean isAutoFrequencyTuning;
    public boolean isDirectTuned;
    public byte isDualAudioSelected;
    public boolean isHide;
    public boolean isLock;
    public boolean isRealtimeAudioDetectionEnabled;
    public boolean isSkip;
    public short u8AutoFrequencyTuningOffset;
    public short u8ChannelNumber;
    public byte u8Favorite;
    public byte unused;

    /* renamed from: com.mstar.android.tvapi.common.vo.AtvMiscProgramInfo.1 */
    static class C01201 implements Creator<AtvMiscProgramInfo> {
        C01201() {
        }

        public AtvMiscProgramInfo createFromParcel(Parcel in) {
            return new AtvMiscProgramInfo(in);
        }

        public AtvMiscProgramInfo[] newArray(int size) {
            return new AtvMiscProgramInfo[size];
        }
    }

    public AtvMiscProgramInfo() {
        this.eAudioStandard = (byte) 0;
        this.isSkip = false;
        this.isHide = false;
        this.eVideoStandard = (byte) 0;
        this.isDualAudioSelected = (byte) 0;
        this.eVolumeCompensation = (byte) 0;
        this.eAudioMode = (byte) 0;
        this.isRealtimeAudioDetectionEnabled = false;
        this.u8Favorite = (byte) 0;
        this.eMedium = false;
        this.isLock = false;
        this.u8ChannelNumber = (short) 0;
        this.isAutoFrequencyTuning = false;
        this.isDirectTuned = false;
        this.u8AutoFrequencyTuningOffset = (short) 0;
        this.bIsAutoColorSystem = false;
        this.unused = (byte) 0;
    }

    public AtvMiscProgramInfo(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.eAudioStandard = in.readByte();
        this.isSkip = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isHide = z;
        this.eVideoStandard = in.readByte();
        this.isDualAudioSelected = in.readByte();
        this.eVolumeCompensation = in.readByte();
        this.eAudioMode = in.readByte();
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isRealtimeAudioDetectionEnabled = z;
        this.u8Favorite = in.readByte();
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.eMedium = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isLock = z;
        this.u8ChannelNumber = (short) in.readInt();
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isAutoFrequencyTuning = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDirectTuned = z;
        this.u8AutoFrequencyTuningOffset = (short) in.readInt();
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.bIsAutoColorSystem = z2;
        this.unused = in.readByte();
    }

    static {
        CREATOR = new C01201();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeByte(this.eAudioStandard);
        dest.writeInt(this.isSkip ? 1 : 0);
        if (this.isHide) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeByte(this.eVideoStandard);
        dest.writeByte(this.isDualAudioSelected);
        dest.writeByte(this.eVolumeCompensation);
        dest.writeByte(this.eAudioMode);
        if (this.isRealtimeAudioDetectionEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeByte(this.u8Favorite);
        if (this.eMedium) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.isLock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeInt(this.u8ChannelNumber);
        if (this.isAutoFrequencyTuning) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.isDirectTuned) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeInt(this.u8AutoFrequencyTuningOffset);
        if (!this.bIsAutoColorSystem) {
            i2 = 0;
        }
        dest.writeInt(i2);
        dest.writeByte(this.unused);
    }
}
