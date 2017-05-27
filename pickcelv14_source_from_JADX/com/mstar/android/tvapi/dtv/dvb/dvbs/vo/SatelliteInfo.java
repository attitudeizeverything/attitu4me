package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SatelliteInfo implements Parcelable {
    public static final Creator<SatelliteInfo> CREATOR;
    public int angle;
    public short channelId;
    public short diseqcLevel;
    public short e22KOnOff;
    EnumLnbType eLNBType;
    EnumLnbTypeReal eLNBTypeReal;
    public int frequency;
    public int hiLOF;
    public short lnbPwrOnOff;
    public int lowLOF;
    public int numberOfTp;
    public short ov12VOnOff;
    public short position;
    public String satName;
    public short satelliteId;
    public short swt10Port;
    public short swt11Port;
    public short toneburstType;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.SatelliteInfo.1 */
    static class C01971 implements Creator<SatelliteInfo> {
        C01971() {
        }

        public SatelliteInfo createFromParcel(Parcel in) {
            return new SatelliteInfo(null);
        }

        public SatelliteInfo[] newArray(int size) {
            return new SatelliteInfo[size];
        }
    }

    public enum EnumLnbType {
        E_C_BAND,
        E_KU_BAND
    }

    public enum EnumLnbTypeReal {
        E_LNB_UNIVERSAL,
        E_LNB_9750,
        E_LNB_5150
    }

    public SatelliteInfo() {
        this.satName = "";
        this.lowLOF = 0;
        this.hiLOF = 0;
        this.eLNBTypeReal = EnumLnbTypeReal.E_LNB_5150;
        this.eLNBType = EnumLnbType.E_C_BAND;
        this.diseqcLevel = (short) 0;
        this.toneburstType = (short) 0;
        this.swt10Port = (short) 0;
        this.swt11Port = (short) 0;
        this.e22KOnOff = (short) 0;
        this.lnbPwrOnOff = (short) 0;
        this.ov12VOnOff = (short) 0;
        this.position = (short) 0;
        this.angle = 0;
        this.numberOfTp = 0;
        this.satelliteId = (short) 0;
        this.channelId = (short) 0;
        this.frequency = 0;
    }

    public int describeContents() {
        return 0;
    }

    private SatelliteInfo(Parcel in) {
        this.satName = in.readString();
        this.lowLOF = in.readInt();
        this.hiLOF = in.readInt();
        this.eLNBTypeReal = EnumLnbTypeReal.values()[in.readInt()];
        this.eLNBType = EnumLnbType.values()[in.readInt()];
        this.diseqcLevel = (short) in.readInt();
        this.toneburstType = (short) in.readInt();
        this.swt10Port = (short) in.readInt();
        this.swt11Port = (short) in.readInt();
        this.e22KOnOff = (short) in.readInt();
        this.lnbPwrOnOff = (short) in.readInt();
        this.ov12VOnOff = (short) in.readInt();
        this.position = (short) in.readInt();
        this.angle = in.readInt();
        this.numberOfTp = in.readInt();
        this.satelliteId = (short) in.readInt();
        this.channelId = (short) in.readInt();
        this.frequency = in.readInt();
    }

    static {
        CREATOR = new C01971();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(this.satName);
        arg0.writeInt(this.lowLOF);
        arg0.writeInt(this.hiLOF);
        arg0.writeInt(this.eLNBTypeReal.ordinal());
        arg0.writeInt(this.eLNBType.ordinal());
        arg0.writeInt(this.diseqcLevel);
        arg0.writeInt(this.toneburstType);
        arg0.writeInt(this.swt10Port);
        arg0.writeInt(this.swt11Port);
        arg0.writeInt(this.e22KOnOff);
        arg0.writeInt(this.lnbPwrOnOff);
        arg0.writeInt(this.ov12VOnOff);
        arg0.writeInt(this.position);
        arg0.writeInt(this.angle);
        arg0.writeInt(this.numberOfTp);
        arg0.writeInt(this.satelliteId);
        arg0.writeInt(this.channelId);
        arg0.writeInt(this.frequency);
    }
}
