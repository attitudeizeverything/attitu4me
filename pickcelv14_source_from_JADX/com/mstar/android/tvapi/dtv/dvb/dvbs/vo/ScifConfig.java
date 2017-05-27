package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScifConfig implements Parcelable {
    public static final Creator<ScifConfig> CREATOR;
    public short numBank;
    public short numStaPos;
    public short numUB;
    public EnumRfType rfType;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.ScifConfig.1 */
    static class C01981 implements Creator<ScifConfig> {
        C01981() {
        }

        public ScifConfig createFromParcel(Parcel in) {
            return new ScifConfig(null);
        }

        public ScifConfig[] newArray(int size) {
            return new ScifConfig[size];
        }
    }

    public enum EnumRfType {
        E_NONE_RF,
        E_STANDARD_RF,
        E_WIDE_RF
    }

    public ScifConfig() {
        this.numStaPos = (short) 0;
        this.numBank = (short) 0;
        this.rfType = EnumRfType.E_NONE_RF;
        this.numUB = (short) 0;
    }

    public int describeContents() {
        return 0;
    }

    private ScifConfig(Parcel in) {
        this.numStaPos = (short) in.readInt();
        this.numBank = (short) in.readInt();
        this.rfType = EnumRfType.values()[in.readInt()];
        this.numUB = (short) in.readInt();
    }

    static {
        CREATOR = new C01981();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.numStaPos);
        arg0.writeInt(this.numBank);
        arg0.writeInt(this.rfType.ordinal());
        arg0.writeInt(this.numUB);
    }
}
