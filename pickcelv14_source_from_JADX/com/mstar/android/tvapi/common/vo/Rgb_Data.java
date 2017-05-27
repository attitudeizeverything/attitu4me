package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Rgb_Data implements Parcelable {
    public static final Creator<Rgb_Data> CREATOR;
    public int f57b;
    public int f58g;
    public int f59r;

    /* renamed from: com.mstar.android.tvapi.common.vo.Rgb_Data.1 */
    static class C01621 implements Creator<Rgb_Data> {
        C01621() {
        }

        public Rgb_Data createFromParcel(Parcel in) {
            return new Rgb_Data(in);
        }

        public Rgb_Data[] newArray(int size) {
            return new Rgb_Data[size];
        }
    }

    public Rgb_Data() {
        this.f59r = 0;
        this.f58g = 0;
        this.f57b = 0;
    }

    public Rgb_Data(Parcel in) {
        this.f59r = in.readInt();
        this.f58g = in.readInt();
        this.f57b = in.readInt();
    }

    static {
        CREATOR = new C01621();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f59r);
        dest.writeInt(this.f58g);
        dest.writeInt(this.f57b);
    }
}
