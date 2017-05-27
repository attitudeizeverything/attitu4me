package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbSecondaryRegionInfo implements Parcelable {
    public static final Creator<DvbSecondaryRegionInfo> CREATOR;
    public short code;
    public String regionName;
    public DvbTeritaryRegionInfo[] tertiaryRegionInfos;
    public int tertiaryRegionNum;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbSecondaryRegionInfo.1 */
    static class C02041 implements Creator<DvbSecondaryRegionInfo> {
        C02041() {
        }

        public DvbSecondaryRegionInfo createFromParcel(Parcel in) {
            return new DvbSecondaryRegionInfo(null);
        }

        public DvbSecondaryRegionInfo[] newArray(int size) {
            return new DvbSecondaryRegionInfo[size];
        }
    }

    public DvbSecondaryRegionInfo() {
        this.code = (short) 0;
        this.regionName = "";
        this.tertiaryRegionNum = 0;
        for (int i = 0; i < this.tertiaryRegionInfos.length; i++) {
            this.tertiaryRegionInfos[i] = new DvbTeritaryRegionInfo();
        }
    }

    private DvbSecondaryRegionInfo(Parcel in) {
        this.code = (short) in.readInt();
        this.regionName = in.readString();
        this.tertiaryRegionNum = in.readInt();
        for (int i = 0; i < this.tertiaryRegionInfos.length; i++) {
            this.tertiaryRegionInfos[i] = (DvbTeritaryRegionInfo) DvbTeritaryRegionInfo.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02041();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.code);
        arg0.writeString(this.regionName);
        arg0.writeInt(this.tertiaryRegionNum);
        for (DvbTeritaryRegionInfo writeToParcel : this.tertiaryRegionInfos) {
            writeToParcel.writeToParcel(arg0, arg1);
        }
    }
}
