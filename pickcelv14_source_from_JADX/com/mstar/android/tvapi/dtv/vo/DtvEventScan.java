package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvEventScan implements Parcelable {
    public static final Creator<DtvEventScan> CREATOR;
    public int currFrequency;
    public short currRFCh;
    public short dataSrvCount;
    public short dtvSrvCount;
    public short radioSrvCount;
    public short scanPercentageNum;
    public int scanStatus;
    public short signalQuality;
    public short signalStrength;
    public int userData;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvEventScan.1 */
    static class C02151 implements Creator<DtvEventScan> {
        C02151() {
        }

        public DtvEventScan createFromParcel(Parcel in) {
            return new DtvEventScan(in);
        }

        public DtvEventScan[] newArray(int size) {
            return new DtvEventScan[size];
        }
    }

    public DtvEventScan() {
        this.scanStatus = 0;
        this.currRFCh = (short) 0;
        this.scanPercentageNum = (short) 0;
        this.dtvSrvCount = (short) 0;
        this.radioSrvCount = (short) 0;
        this.dataSrvCount = (short) 0;
        this.signalQuality = (short) 0;
        this.signalStrength = (short) 0;
        this.currFrequency = 0;
        this.userData = 0;
    }

    public int describeContents() {
        return 0;
    }

    public DtvEventScan(Parcel in) {
        this.scanStatus = in.readInt();
        this.currRFCh = (short) in.readInt();
        this.scanPercentageNum = (short) in.readInt();
        this.dtvSrvCount = (short) in.readInt();
        this.radioSrvCount = (short) in.readInt();
        this.dataSrvCount = (short) in.readInt();
        this.signalQuality = (short) in.readInt();
        this.signalStrength = (short) in.readInt();
        this.currFrequency = in.readInt();
        this.userData = in.readInt();
    }

    static {
        CREATOR = new C02151();
    }

    public void writeToParcel(Parcel out, int arg1) {
        out.writeInt(this.scanStatus);
        out.writeInt(this.currRFCh);
        out.writeInt(this.scanPercentageNum);
        out.writeInt(this.dtvSrvCount);
        out.writeInt(this.radioSrvCount);
        out.writeInt(this.dataSrvCount);
        out.writeInt(this.signalQuality);
        out.writeInt(this.signalStrength);
        out.writeInt(this.currFrequency);
        out.writeInt(this.userData);
    }
}
