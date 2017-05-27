package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HbbtvEventInfo implements Parcelable {
    public static final Creator<HbbtvEventInfo> CREATOR;
    public int eEvent;
    public int[] param;

    /* renamed from: com.mstar.android.tvapi.common.vo.HbbtvEventInfo.1 */
    static class C01471 implements Creator<HbbtvEventInfo> {
        C01471() {
        }

        public HbbtvEventInfo createFromParcel(Parcel in) {
            return new HbbtvEventInfo(in);
        }

        public HbbtvEventInfo[] newArray(int size) {
            return new HbbtvEventInfo[size];
        }
    }

    public HbbtvEventInfo() {
        this.param = new int[10];
        this.eEvent = 0;
        for (int i = 0; i < 10; i++) {
            this.param[i] = 0;
        }
    }

    public HbbtvEventInfo(Parcel in) {
        this.param = new int[10];
        this.eEvent = in.readInt();
        in.readIntArray(this.param);
    }

    static {
        CREATOR = new C01471();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.eEvent);
        dest.writeIntArray(this.param);
    }
}
