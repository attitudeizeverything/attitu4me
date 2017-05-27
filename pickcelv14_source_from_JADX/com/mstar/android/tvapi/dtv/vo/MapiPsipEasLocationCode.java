package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MapiPsipEasLocationCode implements Parcelable {
    public static final Creator<MapiPsipEasLocationCode> CREATOR;
    public int u16CountyCode;
    public int u8CountySubdivision;
    public int u8StateCode;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.MapiPsipEasLocationCode.1 */
    static class C02281 implements Creator<MapiPsipEasLocationCode> {
        C02281() {
        }

        public MapiPsipEasLocationCode createFromParcel(Parcel in) {
            return new MapiPsipEasLocationCode(in);
        }

        public MapiPsipEasLocationCode[] newArray(int size) {
            return new MapiPsipEasLocationCode[size];
        }
    }

    public MapiPsipEasLocationCode() {
        this.u8StateCode = 0;
        this.u8CountySubdivision = 0;
        this.u16CountyCode = 0;
    }

    public MapiPsipEasLocationCode(Parcel in) {
        this.u8StateCode = in.readInt();
        this.u8CountySubdivision = in.readInt();
        this.u16CountyCode = in.readInt();
    }

    static {
        CREATOR = new C02281();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.u8StateCode);
        dest.writeInt(this.u8CountySubdivision);
        dest.writeInt(this.u16CountyCode);
    }
}
