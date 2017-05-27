package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgCridStatus implements Parcelable {
    public static final Creator<EpgCridStatus> CREATOR;
    public boolean isAlternate;
    public boolean isRecommend;
    public boolean isSeries;
    public boolean isSplit;
    public short seriesCount;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgCridStatus.1 */
    static class C02211 implements Creator<EpgCridStatus> {
        C02211() {
        }

        public EpgCridStatus createFromParcel(Parcel in) {
            return new EpgCridStatus(null);
        }

        public EpgCridStatus[] newArray(int size) {
            return new EpgCridStatus[size];
        }
    }

    public EpgCridStatus() {
        this.isSeries = false;
        this.isSplit = false;
        this.isAlternate = false;
        this.isRecommend = false;
        this.seriesCount = (short) 0;
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C02211();
    }

    private EpgCridStatus(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.isSeries = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isSplit = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isAlternate = z;
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.isRecommend = z2;
        this.seriesCount = (short) in.readInt();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        int i;
        int i2 = 1;
        arg0.writeInt(this.isSeries ? 1 : 0);
        if (this.isSplit) {
            i = 1;
        } else {
            i = 0;
        }
        arg0.writeInt(i);
        if (this.isAlternate) {
            i = 1;
        } else {
            i = 0;
        }
        arg0.writeInt(i);
        if (!this.isRecommend) {
            i2 = 0;
        }
        arg0.writeInt(i2);
        arg0.writeInt(this.seriesCount);
    }
}
