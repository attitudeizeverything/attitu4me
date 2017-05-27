package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OadWakeupInfo implements Parcelable {
    public static final Creator<OadWakeupInfo> CREATOR;
    public int checkSum;
    public int scheduleOn;
    public int wakeUpTime;

    /* renamed from: com.mstar.android.tvapi.common.vo.OadWakeupInfo.1 */
    static class C01531 implements Creator<OadWakeupInfo> {
        C01531() {
        }

        public OadWakeupInfo createFromParcel(Parcel in) {
            return new OadWakeupInfo(in);
        }

        public OadWakeupInfo[] newArray(int size) {
            return new OadWakeupInfo[size];
        }
    }

    public OadWakeupInfo() {
        this.checkSum = 0;
        this.scheduleOn = 0;
        this.wakeUpTime = 0;
    }

    public OadWakeupInfo(Parcel in) {
        this.checkSum = in.readInt();
        this.scheduleOn = in.readInt();
        this.wakeUpTime = in.readInt();
    }

    static {
        CREATOR = new C01531();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.checkSum);
        dest.writeInt(this.scheduleOn);
        dest.writeInt(this.wakeUpTime);
    }
}
