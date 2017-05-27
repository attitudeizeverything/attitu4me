package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvNetworkRegionInfo implements Parcelable {
    public static final Creator<DtvNetworkRegionInfo> CREATOR;
    public DtvNetworkRegion[] dtvNetworkRegionVOs;
    public short networkRegionsNumber;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvNetworkRegionInfo.1 */
    static class C02171 implements Creator<DtvNetworkRegionInfo> {
        C02171() {
        }

        public DtvNetworkRegionInfo createFromParcel(Parcel in) {
            return new DtvNetworkRegionInfo(in);
        }

        public DtvNetworkRegionInfo[] newArray(int size) {
            return new DtvNetworkRegionInfo[size];
        }
    }

    public DtvNetworkRegionInfo() {
        this.networkRegionsNumber = (short) 0;
        for (int i = 0; i < this.dtvNetworkRegionVOs.length; i++) {
            this.dtvNetworkRegionVOs[i] = new DtvNetworkRegion();
        }
    }

    public int describeContents() {
        return 0;
    }

    public DtvNetworkRegionInfo(Parcel in) {
        this.networkRegionsNumber = (short) in.readInt();
        for (int i = 0; i < this.dtvNetworkRegionVOs.length; i++) {
            this.dtvNetworkRegionVOs[i] = (DtvNetworkRegion) DtvNetworkRegion.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02171();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.networkRegionsNumber);
        for (DtvNetworkRegion writeToParcel : this.dtvNetworkRegionVOs) {
            writeToParcel.writeToParcel(arg0, arg1);
        }
    }
}
