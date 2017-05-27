package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbPrimaryRegionInfo implements Parcelable {
    public static final Creator<DvbPrimaryRegionInfo> CREATOR;
    public short code;
    public String name;
    public DvbSecondaryRegionInfo[] secondaryRegionInfos;
    public int secondaryRegionNum;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbPrimaryRegionInfo.1 */
    static class C02031 implements Creator<DvbPrimaryRegionInfo> {
        C02031() {
        }

        public DvbPrimaryRegionInfo createFromParcel(Parcel in) {
            return new DvbPrimaryRegionInfo(null);
        }

        public DvbPrimaryRegionInfo[] newArray(int size) {
            return new DvbPrimaryRegionInfo[size];
        }
    }

    public DvbPrimaryRegionInfo() {
        this.code = (short) 0;
        this.name = "";
        this.secondaryRegionNum = 0;
        for (int i = 0; i < this.secondaryRegionInfos.length; i++) {
            this.secondaryRegionInfos[i] = new DvbSecondaryRegionInfo();
        }
    }

    private DvbPrimaryRegionInfo(Parcel in) {
        this.code = (short) in.readInt();
        this.name = in.readString();
        this.secondaryRegionNum = (short) in.readInt();
        for (int i = 0; i < this.secondaryRegionInfos.length; i++) {
            this.secondaryRegionInfos[i] = (DvbSecondaryRegionInfo) DvbSecondaryRegionInfo.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02031();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.code);
        arg0.writeString(this.name);
        arg0.writeInt(this.secondaryRegionNum);
        for (DvbSecondaryRegionInfo writeToParcel : this.secondaryRegionInfos) {
            writeToParcel.writeToParcel(arg0, arg1);
        }
    }
}
