package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbsScanParam implements Parcelable {
    public static final Creator<DvbsScanParam> CREATOR;
    private int networkSearch;
    private boolean polarization;
    private short scanMode;
    private short serviceType;
    private int symbolRate;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.DvbsScanParam.1 */
    static class C01941 implements Creator<DvbsScanParam> {
        C01941() {
        }

        public DvbsScanParam createFromParcel(Parcel in) {
            return new DvbsScanParam(null);
        }

        public DvbsScanParam[] newArray(int size) {
            return new DvbsScanParam[size];
        }
    }

    public DvbsScanParam() {
        this.symbolRate = 0;
        this.networkSearch = 0;
        this.scanMode = (short) 0;
        this.serviceType = (short) 0;
        this.polarization = false;
    }

    private DvbsScanParam(Parcel in) {
        boolean z = true;
        this.symbolRate = in.readInt();
        this.networkSearch = in.readInt();
        this.scanMode = (short) in.readInt();
        this.serviceType = (short) in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.polarization = z;
    }

    static {
        CREATOR = new C01941();
    }

    public int getSymbolRate() {
        return this.symbolRate;
    }

    public int getNetworkSearch() {
        return this.networkSearch;
    }

    public short getScanMode() {
        return this.scanMode;
    }

    public short getServiceType() {
        return this.serviceType;
    }

    public boolean isPolarization() {
        return this.polarization;
    }

    public void setSymbolRate(int symbolRate) {
        this.symbolRate = symbolRate;
    }

    public void setNetworkSearch(int networkSearch) {
        this.networkSearch = networkSearch;
    }

    public void setScanMode(short scanMode) {
        this.scanMode = scanMode;
    }

    public void setServiceType(short serviceType) {
        this.serviceType = serviceType;
    }

    public void setPolarization(boolean polarization) {
        this.polarization = polarization;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.symbolRate);
        arg0.writeInt(this.networkSearch);
        arg0.writeInt(this.scanMode);
        arg0.writeInt(this.serviceType);
        arg0.writeInt(this.polarization ? 1 : 0);
    }
}
