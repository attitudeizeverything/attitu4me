package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.Time;

public class EitCurrentEventPf implements Parcelable {
    public static final Creator<EitCurrentEventPf> CREATOR;
    public short contentNibbleLevel1;
    public short contentNibbleLevel2;
    public int durationInSeconds;
    public String eventName;
    public String extendedEventItem;
    public String extendedEventText;
    public boolean isEndTimeDayLightTime;
    public boolean isScrambled;
    public boolean isStartTimeDayLightTime;
    public short parentalControl;
    public short parentalObjectiveContent;
    public String shortEventText;
    public Time stEndTime;
    public Time stStartTime;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EitCurrentEventPf.1 */
    static class C02191 implements Creator<EitCurrentEventPf> {
        C02191() {
        }

        public EitCurrentEventPf createFromParcel(Parcel in) {
            return new EitCurrentEventPf(in);
        }

        public EitCurrentEventPf[] newArray(int size) {
            return new EitCurrentEventPf[size];
        }
    }

    public EitCurrentEventPf() {
        this.eventName = "";
        this.shortEventText = "";
        this.extendedEventItem = "";
        this.extendedEventText = "";
        this.stStartTime = new Time();
        this.isStartTimeDayLightTime = false;
        this.stEndTime = new Time();
        this.isEndTimeDayLightTime = false;
        this.durationInSeconds = 0;
        this.isScrambled = false;
        this.parentalControl = (short) 0;
        this.parentalObjectiveContent = (short) 0;
        this.contentNibbleLevel1 = (short) 0;
        this.contentNibbleLevel2 = (short) 0;
    }

    public int describeContents() {
        return 0;
    }

    public EitCurrentEventPf(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.eventName = in.readString();
        this.shortEventText = in.readString();
        this.extendedEventItem = in.readString();
        this.extendedEventText = in.readString();
        this.stStartTime = new Time();
        this.stStartTime.set(in.readLong());
        this.isStartTimeDayLightTime = in.readInt() == 1;
        this.stEndTime = new Time();
        this.stEndTime.set(in.readLong());
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isEndTimeDayLightTime = z;
        this.durationInSeconds = in.readInt();
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.isScrambled = z2;
        this.parentalControl = (short) in.readInt();
        this.parentalObjectiveContent = (short) in.readInt();
        this.contentNibbleLevel1 = (short) in.readInt();
        this.contentNibbleLevel2 = (short) in.readInt();
    }

    static {
        CREATOR = new C02191();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        int i;
        int i2 = 1;
        arg0.writeString(this.eventName);
        arg0.writeString(this.shortEventText);
        arg0.writeString(this.extendedEventItem);
        arg0.writeString(this.extendedEventText);
        arg0.writeLong(this.stStartTime.toMillis(true));
        arg0.writeInt(this.isStartTimeDayLightTime ? 1 : 0);
        arg0.writeLong(this.stEndTime.toMillis(true));
        if (this.isEndTimeDayLightTime) {
            i = 1;
        } else {
            i = 0;
        }
        arg0.writeInt(i);
        arg0.writeInt(this.durationInSeconds);
        if (!this.isScrambled) {
            i2 = 0;
        }
        arg0.writeInt(i2);
        arg0.writeInt(this.parentalControl);
        arg0.writeInt(this.parentalObjectiveContent);
        arg0.writeInt(this.contentNibbleLevel1);
        arg0.writeInt(this.contentNibbleLevel2);
    }
}
