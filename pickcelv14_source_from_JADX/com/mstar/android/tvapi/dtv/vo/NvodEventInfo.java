package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.vo.DtvTripleId;

public class NvodEventInfo implements Parcelable {
    public static final Creator<NvodEventInfo> CREATOR;
    public EpgEventInfo epgEventInfo;
    public DtvTripleId timeShiftedServiceIds;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.NvodEventInfo.1 */
    static class C02311 implements Creator<NvodEventInfo> {
        C02311() {
        }

        public NvodEventInfo createFromParcel(Parcel in) {
            return new NvodEventInfo(null);
        }

        public NvodEventInfo[] newArray(int size) {
            return new NvodEventInfo[size];
        }
    }

    public NvodEventInfo() {
        this.epgEventInfo = new EpgEventInfo();
        this.timeShiftedServiceIds = new DtvTripleId();
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C02311();
    }

    private NvodEventInfo(Parcel in) {
        this.epgEventInfo = (EpgEventInfo) EpgEventInfo.CREATOR.createFromParcel(in);
        this.timeShiftedServiceIds = (DtvTripleId) DtvTripleId.CREATOR.createFromParcel(in);
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        this.epgEventInfo.writeToParcel(arg0, arg1);
        this.timeShiftedServiceIds.writeToParcel(arg0, arg1);
    }
}
