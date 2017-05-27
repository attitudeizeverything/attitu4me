package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgFirstMatchHdCast implements Parcelable {
    public static final Creator<EpgFirstMatchHdCast> CREATOR;
    public EpgEventInfo epgEventInfoVO;
    public boolean isResolvable;
    public String serviceName;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgFirstMatchHdCast.1 */
    static class C02231 implements Creator<EpgFirstMatchHdCast> {
        C02231() {
        }

        public EpgFirstMatchHdCast createFromParcel(Parcel in) {
            return new EpgFirstMatchHdCast(null);
        }

        public EpgFirstMatchHdCast[] newArray(int size) {
            return new EpgFirstMatchHdCast[size];
        }
    }

    public EpgFirstMatchHdCast() {
        this.epgEventInfoVO = new EpgEventInfo();
        this.serviceName = "";
        this.isResolvable = false;
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C02231();
    }

    private EpgFirstMatchHdCast(Parcel in) {
        this.epgEventInfoVO = (EpgEventInfo) EpgEventInfo.CREATOR.createFromParcel(in);
        this.serviceName = in.readString();
        this.isResolvable = in.readInt() == 1;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        this.epgEventInfoVO.writeToParcel(arg0, arg1);
        arg0.writeString(this.serviceName);
        arg0.writeInt(this.isResolvable ? 1 : 0);
    }
}
