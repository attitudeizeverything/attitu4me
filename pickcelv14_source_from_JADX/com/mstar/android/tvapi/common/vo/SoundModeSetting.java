package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoundModeSetting implements Parcelable {
    public static final Creator<SoundModeSetting> CREATOR;
    public short balance;
    public short bass;
    public EnumAudioMode enSoundAudioChannel;
    public short eqBand1;
    public short eqBand2;
    public short eqBand3;
    public short eqBand4;
    public short eqBand5;
    public short eqBand6;
    public short eqBand7;
    public short treble;
    public boolean userMode;

    /* renamed from: com.mstar.android.tvapi.common.vo.SoundModeSetting.1 */
    static class C01631 implements Creator<SoundModeSetting> {
        C01631() {
        }

        public SoundModeSetting createFromParcel(Parcel in) {
            return new SoundModeSetting(in);
        }

        public SoundModeSetting[] newArray(int size) {
            return new SoundModeSetting[size];
        }
    }

    public SoundModeSetting() {
        this.bass = (short) 0;
        this.treble = (short) 0;
        this.eqBand1 = (short) 0;
        this.eqBand2 = (short) 0;
        this.eqBand3 = (short) 0;
        this.eqBand4 = (short) 0;
        this.eqBand5 = (short) 0;
        this.eqBand6 = (short) 0;
        this.eqBand7 = (short) 0;
        this.userMode = false;
        this.balance = (short) 0;
        this.enSoundAudioChannel = EnumAudioMode.E_LL;
    }

    public SoundModeSetting(Parcel in) {
        boolean z = true;
        this.bass = (short) in.readInt();
        this.treble = (short) in.readInt();
        this.eqBand1 = (short) in.readInt();
        this.eqBand2 = (short) in.readInt();
        this.eqBand3 = (short) in.readInt();
        this.eqBand4 = (short) in.readInt();
        this.eqBand5 = (short) in.readInt();
        this.eqBand6 = (short) in.readInt();
        this.eqBand7 = (short) in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.userMode = z;
        this.balance = (short) in.readInt();
        this.enSoundAudioChannel = EnumAudioMode.values()[in.readInt()];
    }

    static {
        CREATOR = new C01631();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bass);
        dest.writeInt(this.treble);
        dest.writeInt(this.eqBand1);
        dest.writeInt(this.eqBand2);
        dest.writeInt(this.eqBand3);
        dest.writeInt(this.eqBand4);
        dest.writeInt(this.eqBand5);
        dest.writeInt(this.eqBand6);
        dest.writeInt(this.eqBand7);
        dest.writeInt(this.userMode ? 1 : 0);
        dest.writeInt(this.balance);
        dest.writeInt(this.enSoundAudioChannel.ordinal());
    }
}
