package com.mstar.android.tvapi.atv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtvEventScan implements Parcelable {
    public static final Creator<AtvEventScan> CREATOR;
    public boolean bIsScaningEnable;
    public short curScannedChannel;
    public int frequencyKHz;
    public short percent;
    public short scannedChannelNum;

    /* renamed from: com.mstar.android.tvapi.atv.vo.AtvEventScan.1 */
    static class C01091 implements Creator<AtvEventScan> {
        C01091() {
        }

        public AtvEventScan createFromParcel(Parcel in) {
            return new AtvEventScan(null);
        }

        public AtvEventScan[] newArray(int size) {
            return new AtvEventScan[size];
        }
    }

    public AtvEventScan() {
        this.percent = (short) 0;
        this.frequencyKHz = 0;
        this.scannedChannelNum = (short) 0;
        this.curScannedChannel = (short) 0;
        this.bIsScaningEnable = false;
    }

    public int describeContents() {
        return 0;
    }

    private AtvEventScan(Parcel in) {
        boolean z = true;
        this.percent = (short) in.readInt();
        this.frequencyKHz = in.readInt();
        this.scannedChannelNum = (short) in.readInt();
        this.curScannedChannel = (short) in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.bIsScaningEnable = z;
    }

    static {
        CREATOR = new C01091();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.percent);
        arg0.writeInt(this.frequencyKHz);
        arg0.writeInt(this.scannedChannelNum);
        arg0.writeInt(this.curScannedChannel);
        arg0.writeInt(this.bIsScaningEnable ? 1 : 0);
    }
}
