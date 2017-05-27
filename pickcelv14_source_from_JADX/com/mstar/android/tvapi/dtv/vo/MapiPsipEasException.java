package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MapiPsipEasException implements Parcelable {
    public static final Creator<MapiPsipEasException> CREATOR;
    public boolean bInBandRef;
    public int u16ExcMajorNum;
    public int u16ExcMinorNum;
    public int u16ExcOOB_SrcID;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.MapiPsipEasException.1 */
    static class C02271 implements Creator<MapiPsipEasException> {
        C02271() {
        }

        public MapiPsipEasException createFromParcel(Parcel in) {
            return new MapiPsipEasException(in);
        }

        public MapiPsipEasException[] newArray(int size) {
            return new MapiPsipEasException[size];
        }
    }

    public MapiPsipEasException() {
        this.u16ExcMajorNum = 0;
        this.u16ExcMinorNum = 0;
        this.u16ExcOOB_SrcID = 0;
        this.bInBandRef = true;
    }

    public MapiPsipEasException(Parcel in) {
        this.u16ExcMajorNum = in.readInt();
        this.u16ExcMinorNum = in.readInt();
        this.u16ExcOOB_SrcID = in.readInt();
        this.bInBandRef = in.readInt() == 0;
    }

    static {
        CREATOR = new C02271();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.u16ExcMajorNum);
        dest.writeInt(this.u16ExcMinorNum);
        dest.writeInt(this.u16ExcOOB_SrcID);
        dest.writeInt(this.bInBandRef ? 0 : 1);
    }
}
