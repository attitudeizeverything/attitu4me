package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvEitInfo implements Parcelable {
    public static final Creator<DtvEitInfo> CREATOR;
    public EitCurrentEventPf eitCurrentEventPf;
    public boolean present;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvEitInfo.1 */
    static class C02131 implements Creator<DtvEitInfo> {
        C02131() {
        }

        public DtvEitInfo createFromParcel(Parcel in) {
            return new DtvEitInfo(in);
        }

        public DtvEitInfo[] newArray(int size) {
            return new DtvEitInfo[size];
        }
    }

    public DtvEitInfo() {
        this.eitCurrentEventPf = new EitCurrentEventPf();
        this.present = false;
    }

    public int describeContents() {
        return 0;
    }

    public DtvEitInfo(Parcel in) {
        this.eitCurrentEventPf = (EitCurrentEventPf) EitCurrentEventPf.CREATOR.createFromParcel(in);
        this.present = in.readInt() == 1;
    }

    static {
        CREATOR = new C02131();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        this.eitCurrentEventPf.writeToParcel(arg0, arg1);
        arg0.writeInt(this.present ? 1 : 0);
    }
}
