package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvNetworkRegion implements Parcelable {
    public static final Creator<DtvNetworkRegion> CREATOR;
    public short networkID;
    public String networkName;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvNetworkRegion.1 */
    static class C02161 implements Creator<DtvNetworkRegion> {
        C02161() {
        }

        public DtvNetworkRegion createFromParcel(Parcel in) {
            return new DtvNetworkRegion(in);
        }

        public DtvNetworkRegion[] newArray(int size) {
            return new DtvNetworkRegion[size];
        }
    }

    public DtvNetworkRegion() {
        this.networkName = "";
        this.networkID = (short) 0;
    }

    public int describeContents() {
        return 0;
    }

    public DtvNetworkRegion(Parcel in) {
        this.networkName = in.readString();
        this.networkID = (short) in.readInt();
    }

    static {
        CREATOR = new C02161();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(this.networkName);
        arg0.writeInt(this.networkID);
    }
}
