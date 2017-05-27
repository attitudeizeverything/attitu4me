package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.Time;

public class StandardTime extends Time implements Parcelable {
    public static final Creator<StandardTime> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.StandardTime.1 */
    static class C01661 implements Creator<StandardTime> {
        C01661() {
        }

        public StandardTime createFromParcel(Parcel in) {
            return new StandardTime(in);
        }

        public StandardTime[] newArray(int size) {
            return new StandardTime[size];
        }
    }

    public StandardTime() {
        this.year = 0;
        this.month = 0;
        this.monthDay = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public StandardTime(Parcel in) {
        this.year = (short) in.readInt();
        this.month = (short) in.readInt();
        this.monthDay = (short) in.readInt();
        this.hour = (short) in.readInt();
        this.minute = (short) in.readInt();
        this.second = (short) in.readInt();
    }

    static {
        CREATOR = new C01661();
    }

    public StandardTime(int year, int month, int day, int hour, int min, int sec) {
        this.year = year;
        this.month = month;
        this.monthDay = day;
        this.hour = hour;
        this.minute = min;
        this.second = sec;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.year);
        arg0.writeInt(this.month);
        arg0.writeInt(this.monthDay);
        arg0.writeInt(this.hour);
        arg0.writeInt(this.minute);
        arg0.writeInt(this.second);
    }
}
