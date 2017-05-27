package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbsTransponderInfo implements Parcelable {
    public static final Creator<DvbsTransponderInfo> CREATOR;
    public int frequency;
    public byte polarity;
    public short rf;
    public short satelliteId;
    public int symbolRate;
    public int tpId;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.DvbsTransponderInfo.1 */
    static class C01951 implements Creator<DvbsTransponderInfo> {
        C01951() {
        }

        public DvbsTransponderInfo createFromParcel(Parcel in) {
            return new DvbsTransponderInfo(null);
        }

        public DvbsTransponderInfo[] newArray(int size) {
            return new DvbsTransponderInfo[size];
        }
    }

    public DvbsTransponderInfo() {
        this.frequency = 0;
        this.symbolRate = 0;
        this.polarity = (byte) 0;
        this.satelliteId = (short) 0;
        this.rf = (short) 0;
        this.tpId = 0;
    }

    public int describeContents() {
        return 0;
    }

    private DvbsTransponderInfo(Parcel in) {
        this.frequency = in.readInt();
        this.symbolRate = in.readInt();
        this.polarity = (byte) in.readInt();
        this.satelliteId = (short) in.readInt();
        this.rf = (short) in.readInt();
        this.tpId = in.readInt();
    }

    static {
        CREATOR = new C01951();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.frequency);
        arg0.writeInt(this.symbolRate);
        arg0.writeInt(this.polarity);
        arg0.writeInt(this.satelliteId);
        arg0.writeInt(this.rf);
        arg0.writeInt(this.tpId);
    }
}
