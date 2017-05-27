package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProgramInfo implements Parcelable {
    public static final Creator<ProgramInfo> CREATOR;
    public int antennaType;
    public short favorite;
    public int frequency;
    public boolean isDelete;
    public boolean isHide;
    public boolean isLock;
    public boolean isScramble;
    public boolean isSkip;
    public boolean isVisible;
    public short majorNum;
    public short minorNum;
    public int number;
    public int progId;
    public int queryIndex;
    public int screenMuteStatus;
    public int serviceId;
    public String serviceName;
    public short serviceType;
    public int transportStreamId;

    /* renamed from: com.mstar.android.tvapi.common.vo.ProgramInfo.1 */
    static class C01591 implements Creator<ProgramInfo> {
        C01591() {
        }

        public ProgramInfo createFromParcel(Parcel in) {
            return new ProgramInfo(null);
        }

        public ProgramInfo[] newArray(int size) {
            return new ProgramInfo[size];
        }
    }

    static {
        CREATOR = new C01591();
    }

    private ProgramInfo(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.queryIndex = in.readInt();
        this.number = in.readInt();
        this.majorNum = (short) in.readInt();
        this.minorNum = (short) in.readInt();
        this.progId = in.readInt();
        this.favorite = (short) in.readInt();
        this.isLock = in.readInt() == 1;
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
        this.frequency = in.readInt();
        this.transportStreamId = in.readInt();
        this.serviceId = in.readInt();
        this.antennaType = in.readInt();
    }

    public ProgramInfo(int queryIndex, int number, short majorNum, short minorNum, int progId, short favorite, boolean isLock, boolean isSkip, boolean isScramble, boolean isDelete, boolean isVisible, boolean isHide, short serviceType, int screenMuteStatus, String serviceName, int frequency, int transportStreamId, int serviceId, int antennaType) {
        this.queryIndex = queryIndex;
        this.number = number;
        this.majorNum = majorNum;
        this.minorNum = minorNum;
        this.progId = progId;
        this.favorite = favorite;
        this.isLock = isLock;
        this.isSkip = isSkip;
        this.isScramble = isScramble;
        this.isDelete = isDelete;
        this.isVisible = isVisible;
        this.isHide = isHide;
        this.serviceType = serviceType;
        this.screenMuteStatus = screenMuteStatus;
        this.serviceName = serviceName;
        this.frequency = frequency;
        this.transportStreamId = transportStreamId;
        this.serviceId = serviceId;
        this.antennaType = antennaType;
    }

    public ProgramInfo() {
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
        this.frequency = 0;
        this.transportStreamId = 0;
        this.serviceId = 0;
        this.antennaType = 0;
    }

    public ProgramInfo(int queryIndex) {
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
        this.frequency = 0;
        this.transportStreamId = 0;
        this.serviceId = 0;
        this.antennaType = 0;
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
        dest.writeInt(this.frequency);
        dest.writeInt(this.transportStreamId);
        dest.writeInt(this.serviceId);
        dest.writeInt(this.antennaType);
    }
}
