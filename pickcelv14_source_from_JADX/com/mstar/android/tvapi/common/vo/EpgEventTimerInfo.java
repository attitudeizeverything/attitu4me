package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgEventTimerInfo implements Parcelable {
    public static final Creator<EpgEventTimerInfo> CREATOR;
    public int checkSum;
    public int durationTime;
    public short enRepeatMode;
    public short enTimerType;
    public int eventID;
    public boolean isEndTimeBeforeStart;
    public int majorNumber;
    public int minorNumber;
    public int serviceNumber;
    public int serviceType;
    public int startTime;

    /* renamed from: com.mstar.android.tvapi.common.vo.EpgEventTimerInfo.1 */
    static class C01451 implements Creator<EpgEventTimerInfo> {
        C01451() {
        }

        public EpgEventTimerInfo createFromParcel(Parcel in) {
            return new EpgEventTimerInfo(in);
        }

        public EpgEventTimerInfo[] newArray(int size) {
            return new EpgEventTimerInfo[size];
        }
    }

    public EpgEventTimerInfo() {
        this.checkSum = 0;
        this.enTimerType = (short) 0;
        this.enRepeatMode = (short) 0;
        this.startTime = 0;
        this.durationTime = 0;
        this.serviceType = 0;
        this.serviceNumber = 0;
        this.eventID = 0;
        this.majorNumber = 0;
        this.minorNumber = 0;
        this.isEndTimeBeforeStart = false;
    }

    public EpgEventTimerInfo(Parcel in) {
        boolean z = true;
        this.checkSum = in.readInt();
        this.enTimerType = (short) in.readInt();
        this.enRepeatMode = (short) in.readInt();
        this.startTime = in.readInt();
        this.durationTime = in.readInt();
        this.serviceType = in.readInt();
        this.serviceNumber = in.readInt();
        this.eventID = in.readInt();
        this.majorNumber = in.readInt();
        this.minorNumber = in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.isEndTimeBeforeStart = z;
    }

    static {
        CREATOR = new C01451();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.checkSum);
        dest.writeInt(this.enTimerType);
        dest.writeInt(this.enRepeatMode);
        dest.writeInt(this.startTime);
        dest.writeInt(this.durationTime);
        dest.writeInt(this.serviceType);
        dest.writeInt(this.serviceNumber);
        dest.writeInt(this.eventID);
        dest.writeInt(this.majorNumber);
        dest.writeInt(this.minorNumber);
        dest.writeInt(this.isEndTimeBeforeStart ? 1 : 0);
    }
}
