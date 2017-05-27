package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TravelingEngineCaps implements Parcelable {
    public static final Creator<TravelingEngineCaps> CREATOR;
    public int exist;
    public int isYC420Support;
    public int length;
    public int version;

    /* renamed from: com.mstar.android.tvapi.common.vo.TravelingEngineCaps.1 */
    static class C01711 implements Creator<TravelingEngineCaps> {
        C01711() {
        }

        public TravelingEngineCaps createFromParcel(Parcel in) {
            return new TravelingEngineCaps(in);
        }

        public TravelingEngineCaps[] newArray(int size) {
            return new TravelingEngineCaps[size];
        }
    }

    public TravelingEngineCaps() {
        this.version = 0;
        this.length = 0;
        this.exist = 0;
        this.isYC420Support = 0;
    }

    public TravelingEngineCaps(Parcel in) {
        this.version = in.readInt();
        this.length = in.readInt();
        this.exist = in.readInt();
        this.isYC420Support = in.readInt();
    }

    static {
        CREATOR = new C01711();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.version);
        dest.writeInt(this.length);
        dest.writeInt(this.exist);
        dest.writeInt(this.isYC420Support);
    }
}
