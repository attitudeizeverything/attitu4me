package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgCridEventInfo implements Parcelable {
    public static final Creator<EpgCridEventInfo> CREATOR;
    public EpgEventInfo eventInfo;
    public int serviceNumber;
    public short serviceType;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgCridEventInfo.1 */
    static class C02201 implements Creator<EpgCridEventInfo> {
        C02201() {
        }

        public EpgCridEventInfo createFromParcel(Parcel in) {
            return new EpgCridEventInfo(null);
        }

        public EpgCridEventInfo[] newArray(int size) {
            return new EpgCridEventInfo[size];
        }
    }

    public EpgCridEventInfo() {
        this.serviceType = (short) 0;
        this.serviceNumber = 0;
        this.eventInfo = new EpgEventInfo();
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C02201();
    }

    private EpgCridEventInfo(Parcel in) {
        this.serviceType = (short) in.readInt();
        this.serviceNumber = (short) in.readInt();
        this.eventInfo = (EpgEventInfo) EpgEventInfo.CREATOR.createFromParcel(in);
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.serviceType);
        arg0.writeInt(this.serviceNumber);
        this.eventInfo.writeToParcel(arg0, arg1);
    }
}
