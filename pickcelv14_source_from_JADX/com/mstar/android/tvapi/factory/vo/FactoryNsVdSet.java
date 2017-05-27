package com.mstar.android.tvapi.factory.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FactoryNsVdSet implements Parcelable {
    public static final Creator<FactoryNsVdSet> CREATOR;
    public short aFEC_43;
    public short aFEC_44;
    public short aFEC_66_Bit76;
    public short aFEC_6E_Bit3210;
    public short aFEC_6E_Bit7654;
    public short aFEC_A0;
    public short aFEC_A1;
    public short aFEC_CB;
    public short aFEC_CF_Bit2_ATV;
    public short aFEC_CF_Bit2_AV;
    public short aFEC_D4;
    public short aFEC_D5_Bit2;
    public short aFEC_D7_HIGH_BOUND;
    public short aFEC_D7_LOW_BOUND;
    public short aFEC_D8_Bit3210;
    public short aFEC_D9_Bit0;

    /* renamed from: com.mstar.android.tvapi.factory.vo.FactoryNsVdSet.1 */
    static class C02331 implements Creator<FactoryNsVdSet> {
        C02331() {
        }

        public FactoryNsVdSet createFromParcel(Parcel in) {
            return new FactoryNsVdSet(null);
        }

        public FactoryNsVdSet[] newArray(int size) {
            return new FactoryNsVdSet[size];
        }
    }

    public FactoryNsVdSet() {
        this.aFEC_D4 = (short) 0;
        this.aFEC_D8_Bit3210 = (short) 0;
        this.aFEC_D5_Bit2 = (short) 0;
        this.aFEC_D7_LOW_BOUND = (short) 0;
        this.aFEC_D7_HIGH_BOUND = (short) 0;
        this.aFEC_D9_Bit0 = (short) 0;
        this.aFEC_A0 = (short) 0;
        this.aFEC_A1 = (short) 0;
        this.aFEC_66_Bit76 = (short) 0;
        this.aFEC_6E_Bit7654 = (short) 0;
        this.aFEC_6E_Bit3210 = (short) 0;
        this.aFEC_43 = (short) 0;
        this.aFEC_44 = (short) 0;
        this.aFEC_CB = (short) 0;
        this.aFEC_CF_Bit2_ATV = (short) 0;
        this.aFEC_CF_Bit2_AV = (short) 0;
    }

    private FactoryNsVdSet(Parcel in) {
        this.aFEC_D4 = (short) in.readInt();
        this.aFEC_D8_Bit3210 = (short) in.readInt();
        this.aFEC_D5_Bit2 = (short) in.readInt();
        this.aFEC_D7_LOW_BOUND = (short) in.readInt();
        this.aFEC_D7_HIGH_BOUND = (short) in.readInt();
        this.aFEC_D9_Bit0 = (short) in.readInt();
        this.aFEC_A0 = (short) in.readInt();
        this.aFEC_A1 = (short) in.readInt();
        this.aFEC_66_Bit76 = (short) in.readInt();
        this.aFEC_6E_Bit7654 = (short) in.readInt();
        this.aFEC_6E_Bit3210 = (short) in.readInt();
        this.aFEC_43 = (short) in.readInt();
        this.aFEC_44 = (short) in.readInt();
        this.aFEC_CB = (short) in.readInt();
        this.aFEC_CF_Bit2_ATV = (short) in.readInt();
        this.aFEC_CF_Bit2_AV = (short) in.readInt();
    }

    static {
        CREATOR = new C02331();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.aFEC_D4);
        arg0.writeInt(this.aFEC_D8_Bit3210);
        arg0.writeInt(this.aFEC_D5_Bit2);
        arg0.writeInt(this.aFEC_D7_LOW_BOUND);
        arg0.writeInt(this.aFEC_D7_HIGH_BOUND);
        arg0.writeInt(this.aFEC_D9_Bit0);
        arg0.writeInt(this.aFEC_A0);
        arg0.writeInt(this.aFEC_A1);
        arg0.writeInt(this.aFEC_66_Bit76);
        arg0.writeInt(this.aFEC_6E_Bit7654);
        arg0.writeInt(this.aFEC_6E_Bit3210);
        arg0.writeInt(this.aFEC_43);
        arg0.writeInt(this.aFEC_44);
        arg0.writeInt(this.aFEC_CB);
        arg0.writeInt(this.aFEC_CF_Bit2_ATV);
        arg0.writeInt(this.aFEC_CF_Bit2_AV);
    }
}
