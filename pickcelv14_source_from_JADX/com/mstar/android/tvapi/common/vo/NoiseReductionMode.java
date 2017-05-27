package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NoiseReductionMode implements Parcelable {
    public static final Creator<NoiseReductionMode> CREATOR;
    public int mpegNr;
    public int nr;

    /* renamed from: com.mstar.android.tvapi.common.vo.NoiseReductionMode.1 */
    static class C01521 implements Creator<NoiseReductionMode> {
        C01521() {
        }

        public NoiseReductionMode createFromParcel(Parcel in) {
            return new NoiseReductionMode(in);
        }

        public NoiseReductionMode[] newArray(int size) {
            return new NoiseReductionMode[size];
        }
    }

    public NoiseReductionMode() {
        this.nr = 0;
        this.mpegNr = 0;
    }

    public NoiseReductionMode(Parcel in) {
        this.nr = in.readInt();
        this.mpegNr = in.readInt();
    }

    static {
        CREATOR = new C01521();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nr);
        dest.writeInt(this.mpegNr);
    }
}
