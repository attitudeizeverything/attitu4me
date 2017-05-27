package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbCountryInfo implements Parcelable {
    public static final Creator<DvbCountryInfo> CREATOR;
    public char[] countryCode;
    public int primaryRegionCount;
    public DvbPrimaryRegionInfo[] primaryRegionInfos;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbCountryInfo.1 */
    static class C02011 implements Creator<DvbCountryInfo> {
        C02011() {
        }

        public DvbCountryInfo createFromParcel(Parcel in) {
            return new DvbCountryInfo(null);
        }

        public DvbCountryInfo[] newArray(int size) {
            return new DvbCountryInfo[size];
        }
    }

    public DvbCountryInfo() {
        int i;
        this.countryCode = new char[3];
        this.primaryRegionCount = 0;
        for (i = 0; i < this.countryCode.length; i++) {
            this.countryCode[i] = '\u0000';
        }
        for (i = 0; i < this.primaryRegionInfos.length; i++) {
            this.primaryRegionInfos[i] = new DvbPrimaryRegionInfo();
        }
    }

    private DvbCountryInfo(Parcel in) {
        this.countryCode = new char[3];
        this.primaryRegionCount = in.readInt();
        in.readCharArray(this.countryCode);
        for (int i = 0; i < this.primaryRegionInfos.length; i++) {
            this.primaryRegionInfos[i] = (DvbPrimaryRegionInfo) DvbPrimaryRegionInfo.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02011();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.primaryRegionCount);
        arg0.writeCharArray(this.countryCode);
        for (DvbPrimaryRegionInfo writeToParcel : this.primaryRegionInfos) {
            writeToParcel.writeToParcel(arg0, arg1);
        }
    }
}
