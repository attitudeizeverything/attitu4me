package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbMuxInfo implements Parcelable {
    public static final Creator<DvbMuxInfo> CREATOR;
    public short bandwidth;
    public int cellID;
    public int frequency;
    public int lossSignalFrequency;
    public int lossSignalStartTime;
    public boolean lpCoding;
    public short modulationMode;
    public int networkId;
    public int networkTableID;
    public int originalNetworkId;
    public int plpID;
    public int polarityPilotsReserved;
    public int refCnt;
    public short rfNumber;
    public short satID;
    public int satTableId;
    public int symbRate;
    public int transportStreamId;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbMuxInfo.1 */
    static class C02021 implements Creator<DvbMuxInfo> {
        C02021() {
        }

        public DvbMuxInfo createFromParcel(Parcel in) {
            return new DvbMuxInfo(null);
        }

        public DvbMuxInfo[] newArray(int size) {
            return new DvbMuxInfo[size];
        }
    }

    public DvbMuxInfo() {
        this.satTableId = 0;
        this.networkTableID = 0;
        this.refCnt = 0;
        this.transportStreamId = 0;
        this.originalNetworkId = 0;
        this.networkId = 0;
        this.cellID = 0;
        this.rfNumber = (short) 0;
        this.frequency = 0;
        this.lossSignalFrequency = 0;
        this.lossSignalStartTime = 0;
        this.symbRate = 0;
        this.modulationMode = (short) 0;
        this.plpID = 0;
        this.lpCoding = false;
        this.satID = (short) 0;
        this.bandwidth = (short) 0;
        this.polarityPilotsReserved = 0;
    }

    private DvbMuxInfo(Parcel in) {
        boolean z = true;
        this.satTableId = in.readInt();
        this.networkTableID = in.readInt();
        this.refCnt = in.readInt();
        this.transportStreamId = in.readInt();
        this.originalNetworkId = in.readInt();
        this.networkId = in.readInt();
        this.cellID = in.readInt();
        this.rfNumber = (short) in.readInt();
        this.frequency = in.readInt();
        this.lossSignalFrequency = in.readInt();
        this.lossSignalStartTime = in.readInt();
        this.symbRate = in.readInt();
        this.modulationMode = (short) in.readInt();
        this.plpID = in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.lpCoding = z;
        this.satID = (short) in.readInt();
        this.bandwidth = (short) in.readInt();
        this.polarityPilotsReserved = in.readInt();
    }

    static {
        CREATOR = new C02021();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.satTableId);
        arg0.writeInt(this.networkTableID);
        arg0.writeInt(this.refCnt);
        arg0.writeInt(this.transportStreamId);
        arg0.writeInt(this.originalNetworkId);
        arg0.writeInt(this.networkId);
        arg0.writeInt(this.cellID);
        arg0.writeInt(this.rfNumber);
        arg0.writeInt(this.frequency);
        arg0.writeInt(this.lossSignalFrequency);
        arg0.writeInt(this.lossSignalStartTime);
        arg0.writeInt(this.symbRate);
        arg0.writeInt(this.modulationMode);
        arg0.writeInt(this.plpID);
        arg0.writeInt(this.lpCoding ? 1 : 0);
        arg0.writeInt(this.satID);
        arg0.writeInt(this.bandwidth);
        arg0.writeInt(this.polarityPilotsReserved);
    }
}
