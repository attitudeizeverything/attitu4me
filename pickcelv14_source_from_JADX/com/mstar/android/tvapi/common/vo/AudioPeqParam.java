package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioPeqParam implements Parcelable {
    public static final Creator<AudioPeqParam> CREATOR;
    public short band;
    public short foh;
    public short fol;
    public short gain;
    public short qValue;

    /* renamed from: com.mstar.android.tvapi.common.vo.AudioPeqParam.1 */
    static class C01221 implements Creator<AudioPeqParam> {
        C01221() {
        }

        public AudioPeqParam createFromParcel(Parcel in) {
            return new AudioPeqParam(in);
        }

        public AudioPeqParam[] newArray(int size) {
            return new AudioPeqParam[size];
        }
    }

    public AudioPeqParam() {
        this.band = (short) 0;
        this.gain = (short) 0;
        this.foh = (short) 0;
        this.fol = (short) 0;
        this.qValue = (short) 0;
    }

    public AudioPeqParam(Parcel in) {
        this.band = (short) in.readInt();
        this.gain = (short) in.readInt();
        this.foh = (short) in.readInt();
        this.fol = (short) in.readInt();
        this.qValue = (short) in.readInt();
    }

    static {
        CREATOR = new C01221();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.band);
        dest.writeInt(this.gain);
        dest.writeInt(this.foh);
        dest.writeInt(this.fol);
        dest.writeInt(this.qValue);
    }
}
