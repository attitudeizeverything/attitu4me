package com.mstar.android.tvapi.dtv.dvb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DvbTeritaryRegionInfo implements Parcelable {
    public static final Creator<DvbTeritaryRegionInfo> CREATOR;
    public int code;
    public String regionName;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.vo.DvbTeritaryRegionInfo.1 */
    static class C02061 implements Creator<DvbTeritaryRegionInfo> {
        C02061() {
        }

        public DvbTeritaryRegionInfo createFromParcel(Parcel in) {
            return new DvbTeritaryRegionInfo(null);
        }

        public DvbTeritaryRegionInfo[] newArray(int size) {
            return new DvbTeritaryRegionInfo[size];
        }
    }

    public DvbTeritaryRegionInfo() {
        this.code = 0;
        this.regionName = "";
    }

    private DvbTeritaryRegionInfo(Parcel in) {
        this.code = in.readInt();
        this.regionName = in.readString();
    }

    static {
        CREATOR = new C02061();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.code);
        arg0.writeString(this.regionName);
    }
}
