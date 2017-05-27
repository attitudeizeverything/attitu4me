package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RfInfo implements Parcelable {
    public static final Creator<RfInfo> CREATOR;
    public int frequency;
    public boolean isVHF;
    public String rfName;
    public short rfPhyNum;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.RfInfo.1 */
    static class C02321 implements Creator<RfInfo> {
        C02321() {
        }

        public RfInfo createFromParcel(Parcel in) {
            return new RfInfo(null);
        }

        public RfInfo[] newArray(int size) {
            return new RfInfo[size];
        }
    }

    public enum EnumInfoType {
        E_FIRST_TO_SHOW_RF,
        E_NEXT_RF,
        E_PREV_RF,
        E_RF_INFO
    }

    public RfInfo() {
        this.rfPhyNum = (short) 0;
        this.frequency = 0;
        this.isVHF = false;
        this.rfName = "";
    }

    private RfInfo(Parcel in) {
        this.rfPhyNum = (short) in.readInt();
        this.frequency = in.readInt();
        this.isVHF = in.readInt() != 0;
        this.rfName = in.readString();
    }

    static {
        CREATOR = new C02321();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.rfPhyNum);
        dest.writeInt(this.frequency);
        dest.writeInt(this.isVHF ? 1 : 0);
        dest.writeString(this.rfName);
    }
}
