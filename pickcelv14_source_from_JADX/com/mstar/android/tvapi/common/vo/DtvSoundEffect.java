package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvSoundEffect implements Parcelable {
    public static final Creator<DtvSoundEffect> CREATOR;
    public static final int MAX_EQ_BAND_NUM = 5;
    public static final int MAX_PEQ_BAND_NUM = 5;
    public int avcAttachTime;
    public int avcReleaseTime;
    public int avcThreshold;
    public int balance;
    public int bass;
    public int echoTime;
    public short eqBandNumber;
    public int noiseReductionThreshold;
    public short peqBandNumber;
    public int preScale;
    public int soundDrcThreshold;
    public SoundParameterEq[] soundParameterEqs;
    public SoundParameterPeq[] soundParameterPeqs;
    public int surroundXaValue;
    public int surroundXbValue;
    public int surroundXkValue;
    public int treble;

    /* renamed from: com.mstar.android.tvapi.common.vo.DtvSoundEffect.1 */
    static class C01331 implements Creator<DtvSoundEffect> {
        C01331() {
        }

        public DtvSoundEffect createFromParcel(Parcel in) {
            return new DtvSoundEffect(in);
        }

        public DtvSoundEffect[] newArray(int size) {
            return new DtvSoundEffect[size];
        }
    }

    public DtvSoundEffect() {
        int i;
        this.soundParameterEqs = new SoundParameterEq[MAX_PEQ_BAND_NUM];
        this.soundParameterPeqs = new SoundParameterPeq[MAX_PEQ_BAND_NUM];
        this.preScale = 0;
        this.treble = 0;
        this.bass = 0;
        this.balance = 0;
        this.eqBandNumber = (short) 0;
        this.peqBandNumber = (short) 0;
        this.avcThreshold = 0;
        this.avcAttachTime = 0;
        this.avcReleaseTime = 0;
        this.surroundXaValue = 0;
        this.surroundXbValue = 0;
        this.surroundXkValue = 0;
        this.soundDrcThreshold = 0;
        this.noiseReductionThreshold = 0;
        this.echoTime = 0;
        for (i = 0; i < MAX_PEQ_BAND_NUM; i++) {
            this.soundParameterEqs[i] = new SoundParameterEq();
        }
        for (i = 0; i < MAX_PEQ_BAND_NUM; i++) {
            this.soundParameterPeqs[i] = new SoundParameterPeq();
        }
    }

    public DtvSoundEffect(Parcel in) {
        int i;
        this.soundParameterEqs = new SoundParameterEq[MAX_PEQ_BAND_NUM];
        this.soundParameterPeqs = new SoundParameterPeq[MAX_PEQ_BAND_NUM];
        this.preScale = in.readInt();
        this.treble = in.readInt();
        this.bass = in.readInt();
        this.balance = in.readInt();
        this.eqBandNumber = (short) in.readInt();
        this.peqBandNumber = (short) in.readInt();
        this.avcThreshold = in.readInt();
        this.avcAttachTime = in.readInt();
        this.avcReleaseTime = in.readInt();
        this.surroundXaValue = in.readInt();
        this.surroundXbValue = in.readInt();
        this.surroundXkValue = in.readInt();
        this.soundDrcThreshold = in.readInt();
        this.noiseReductionThreshold = in.readInt();
        this.echoTime = in.readInt();
        for (i = 0; i < MAX_PEQ_BAND_NUM; i++) {
            this.soundParameterEqs[i] = (SoundParameterEq) SoundParameterEq.CREATOR.createFromParcel(in);
        }
        for (i = 0; i < MAX_PEQ_BAND_NUM; i++) {
            this.soundParameterPeqs[i] = (SoundParameterPeq) SoundParameterPeq.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C01331();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.preScale);
        dest.writeInt(this.treble);
        dest.writeInt(this.bass);
        dest.writeInt(this.balance);
        dest.writeInt(this.eqBandNumber);
        dest.writeInt(this.peqBandNumber);
        dest.writeParcelableArray(this.soundParameterEqs, 0);
        dest.writeParcelableArray(this.soundParameterPeqs, 0);
        dest.writeInt(this.avcThreshold);
        dest.writeInt(this.avcAttachTime);
        dest.writeInt(this.avcReleaseTime);
        dest.writeInt(this.surroundXaValue);
        dest.writeInt(this.surroundXbValue);
        dest.writeInt(this.surroundXkValue);
        dest.writeInt(this.soundDrcThreshold);
        dest.writeInt(this.noiseReductionThreshold);
        dest.writeInt(this.echoTime);
    }
}
