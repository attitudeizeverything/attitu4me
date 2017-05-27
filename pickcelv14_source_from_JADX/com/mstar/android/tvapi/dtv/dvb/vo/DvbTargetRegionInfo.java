package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbTargetRegionInfo implements Parcelable {
    public static final Creator<DvbTargetRegionInfo> CREATOR;
    public short countryCount;
    public DvbCountryInfo[] countryInfos;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbTargetRegionInfo.1 */
    static class C02051 implements Creator<DvbTargetRegionInfo> {
        C02051() {
        }

        public DvbTargetRegionInfo createFromParcel(Parcel in) {
            return new DvbTargetRegionInfo(null);
        }

        public DvbTargetRegionInfo[] newArray(int size) {
            return new DvbTargetRegionInfo[size];
        }
    }

    public DvbTargetRegionInfo() {
        this.countryCount = (short) 0;
        for (int i = 0; i < this.countryInfos.length; i++) {
            this.countryInfos[i] = new DvbCountryInfo();
        }
    }

    private DvbTargetRegionInfo(Parcel in) {
        this.countryCount = (short) in.readInt();
        for (int i = 0; i < this.countryInfos.length; i++) {
            this.countryInfos[i] = (DvbCountryInfo) DvbCountryInfo.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02051();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.countryCount);
        for (DvbCountryInfo writeToParcel : this.countryInfos) {
            writeToParcel.writeToParcel(arg0, arg1);
        }
    }
}
