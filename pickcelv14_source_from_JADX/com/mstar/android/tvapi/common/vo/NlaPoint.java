package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NlaPoint implements Parcelable {
    public static final Creator<NlaPoint> CREATOR;
    public short osdV0;
    public short osdV100;
    public short osdV25;
    public short osdV50;
    public short osdV75;

    /* renamed from: com.mstar.android.tvapi.common.vo.NlaPoint.1 */
    static class C01511 implements Creator<NlaPoint> {
        C01511() {
        }

        public NlaPoint createFromParcel(Parcel in) {
            return new NlaPoint(in);
        }

        public NlaPoint[] newArray(int size) {
            return new NlaPoint[size];
        }
    }

    public NlaPoint() {
        this.osdV0 = (short) 0;
        this.osdV25 = (short) 0;
        this.osdV50 = (short) 0;
        this.osdV75 = (short) 0;
        this.osdV100 = (short) 0;
    }

    public NlaPoint(Parcel in) {
        this.osdV0 = (short) in.readInt();
        this.osdV25 = (short) in.readInt();
        this.osdV50 = (short) in.readInt();
        this.osdV75 = (short) in.readInt();
        this.osdV100 = (short) in.readInt();
    }

    static {
        CREATOR = new C01511();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.osdV0);
        dest.writeInt(this.osdV25);
        dest.writeInt(this.osdV50);
        dest.writeInt(this.osdV75);
        dest.writeInt(this.osdV100);
    }
}
