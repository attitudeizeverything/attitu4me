package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoundParameterEq implements Parcelable {
    public static final Creator<SoundParameterEq> CREATOR;
    public int eqLevel;

    /* renamed from: com.mstar.android.tvapi.common.vo.SoundParameterEq.1 */
    static class C01641 implements Creator<SoundParameterEq> {
        C01641() {
        }

        public SoundParameterEq createFromParcel(Parcel in) {
            return new SoundParameterEq(in);
        }

        public SoundParameterEq[] newArray(int size) {
            return new SoundParameterEq[size];
        }
    }

    public SoundParameterEq() {
        this.eqLevel = 0;
    }

    public SoundParameterEq(Parcel in) {
        this.eqLevel = in.readInt();
    }

    static {
        CREATOR = new C01641();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.eqLevel);
    }
}
