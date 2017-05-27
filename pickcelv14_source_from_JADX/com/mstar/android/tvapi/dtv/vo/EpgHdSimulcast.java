package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgHdSimulcast implements Parcelable {
    public static final Creator<EpgHdSimulcast> CREATOR;
    public boolean isHdEeventResolvable;
    public boolean isHdServiceResolvable;
    public boolean isSimulcast;
    public String serviceName;
    public int serviceNumber;
    public short serviceType;
    public EpgEventInfo stEventInfo;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgHdSimulcast.1 */
    static class C02241 implements Creator<EpgHdSimulcast> {
        C02241() {
        }

        public EpgHdSimulcast createFromParcel(Parcel in) {
            return new EpgHdSimulcast(null);
        }

        public EpgHdSimulcast[] newArray(int size) {
            return new EpgHdSimulcast[size];
        }
    }

    public EpgHdSimulcast() {
        this.isSimulcast = false;
        this.serviceName = "";
        this.serviceType = (short) 0;
        this.serviceNumber = 0;
        this.isHdEeventResolvable = false;
        this.isHdServiceResolvable = false;
        this.stEventInfo = new EpgEventInfo();
    }

    static {
        CREATOR = new C02241();
    }

    private EpgHdSimulcast(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.isSimulcast = in.readInt() == 1;
        this.serviceName = in.readString();
        this.serviceType = (short) in.readInt();
        this.serviceNumber = in.readInt();
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isHdEeventResolvable = z;
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.isHdServiceResolvable = z2;
        this.stEventInfo = (EpgEventInfo) EpgEventInfo.CREATOR.createFromParcel(in);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        int i;
        int i2 = 1;
        arg0.writeInt(this.isSimulcast ? 1 : 0);
        arg0.writeString(this.serviceName);
        arg0.writeInt(this.serviceType);
        arg0.writeInt(this.serviceNumber);
        if (this.isHdEeventResolvable) {
            i = 1;
        } else {
            i = 0;
        }
        arg0.writeInt(i);
        if (!this.isHdServiceResolvable) {
            i2 = 0;
        }
        arg0.writeInt(i2);
        this.stEventInfo.writeToParcel(arg0, arg1);
    }
}
