package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoundParameterPeq implements Parcelable {
    public static final Creator<SoundParameterPeq> CREATOR;
    public int peqGain;
    public int peqGc;
    public int peqQvalue;

    /* renamed from: com.mstar.android.tvapi.common.vo.SoundParameterPeq.1 */
    static class C01651 implements Creator<SoundParameterPeq> {
        C01651() {
        }

        public SoundParameterPeq createFromParcel(Parcel in) {
            return new SoundParameterPeq(in);
        }

        public SoundParameterPeq[] newArray(int size) {
            return new SoundParameterPeq[size];
        }
    }

    public SoundParameterPeq() {
        this.peqGain = 0;
        this.peqGc = 0;
        this.peqQvalue = 0;
    }

    public SoundParameterPeq(Parcel in) {
        this.peqGain = in.readInt();
        this.peqGc = in.readInt();
        this.peqQvalue = in.readInt();
    }

    static {
        CREATOR = new C01651();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.peqGain);
        dest.writeInt(this.peqGc);
        dest.writeInt(this.peqQvalue);
    }
}
