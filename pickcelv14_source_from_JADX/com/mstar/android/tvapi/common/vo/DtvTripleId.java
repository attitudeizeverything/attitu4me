package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvTripleId implements Parcelable {
    public static final Creator<DtvTripleId> CREATOR;
    public int originalNetworkId;
    public int serviceId;
    public int transportStreamId;

    /* renamed from: com.mstar.android.tvapi.common.vo.DtvTripleId.1 */
    static class C01341 implements Creator<DtvTripleId> {
        C01341() {
        }

        public DtvTripleId createFromParcel(Parcel in) {
            return new DtvTripleId(in);
        }

        public DtvTripleId[] newArray(int size) {
            return new DtvTripleId[size];
        }
    }

    public DtvTripleId() {
        this.originalNetworkId = 0;
        this.transportStreamId = 0;
        this.serviceId = 0;
    }

    public DtvTripleId(Parcel in) {
        this.originalNetworkId = in.readInt();
        this.transportStreamId = in.readInt();
        this.serviceId = in.readInt();
    }

    static {
        CREATOR = new C01341();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.originalNetworkId);
        dest.writeInt(this.transportStreamId);
        dest.writeInt(this.serviceId);
    }
}
