package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetServiceInfo implements Parcelable {
    public static final Creator<GetServiceInfo> CREATOR;
    public short favorite;
    public boolean isDelete;
    public boolean isHide;
    public boolean isLock;
    public boolean isScramble;
    public boolean isSkip;
    public boolean isVisible;
    public short majorNum;
    public short minorNum;
    public int number;
    public short nvodTimeShiftServiceNum;
    public int progId;
    public int queryIndex;
    public int screenMuteStatus;
    public String serviceName;
    public short serviceType;
    DtvTripleId[] timeShiftedServiceIds;

    /* renamed from: com.mstar.android.tvapi.common.vo.GetServiceInfo.1 */
    static class C01461 implements Creator<GetServiceInfo> {
        C01461() {
        }

        public GetServiceInfo createFromParcel(Parcel in) {
            return new GetServiceInfo(in);
        }

        public GetServiceInfo[] newArray(int size) {
            return new GetServiceInfo[size];
        }
    }

    public GetServiceInfo() {
        this.queryIndex = 0;
        this.number = 0;
        this.majorNum = (short) 0;
        this.minorNum = (short) 0;
        this.progId = 0;
        this.favorite = (short) 0;
        this.isLock = false;
        this.isSkip = false;
        this.isScramble = false;
        this.isDelete = false;
        this.isVisible = false;
        this.isHide = false;
        this.serviceType = (short) 0;
        this.screenMuteStatus = 0;
        this.serviceName = "";
        this.nvodTimeShiftServiceNum = (short) 0;
        for (int i = 0; i < this.timeShiftedServiceIds.length; i++) {
            this.timeShiftedServiceIds[i] = new DtvTripleId();
        }
    }

    public GetServiceInfo(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.queryIndex = in.readInt();
        this.number = in.readInt();
        this.majorNum = (short) in.readInt();
        this.minorNum = (short) in.readInt();
        this.progId = in.readInt();
        this.favorite = (short) in.readInt();
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isLock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isSkip = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isScramble = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDelete = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isVisible = z;
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.isHide = z2;
        this.serviceType = (short) in.readInt();
        this.screenMuteStatus = in.readInt();
        this.serviceName = in.readString();
        this.nvodTimeShiftServiceNum = (short) in.readInt();
        for (int i = 0; i < this.timeShiftedServiceIds.length; i++) {
            this.timeShiftedServiceIds[i] = (DtvTripleId) DtvTripleId.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C01461();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeInt(this.queryIndex);
        dest.writeInt(this.number);
        dest.writeInt(this.majorNum);
        dest.writeInt(this.minorNum);
        dest.writeInt(this.progId);
        dest.writeInt(this.favorite);
        dest.writeInt(this.isLock ? 1 : 0);
        if (this.isSkip) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.isScramble) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.isDelete) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.isVisible) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (!this.isHide) {
            i2 = 0;
        }
        dest.writeInt(i2);
        dest.writeInt(this.serviceType);
        dest.writeInt(this.screenMuteStatus);
        dest.writeString(this.serviceName);
        dest.writeInt(this.nvodTimeShiftServiceNum);
        dest.writeParcelableArray(this.timeShiftedServiceIds, 0);
    }
}
