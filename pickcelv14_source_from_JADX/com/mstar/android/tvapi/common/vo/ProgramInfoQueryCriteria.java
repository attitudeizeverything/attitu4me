package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProgramInfoQueryCriteria implements Parcelable {
    public static final Creator<ProgramInfoQueryCriteria> CREATOR;
    public int number;
    public int queryIndex;
    protected short serviceType;

    /* renamed from: com.mstar.android.tvapi.common.vo.ProgramInfoQueryCriteria.1 */
    static class C01601 implements Creator<ProgramInfoQueryCriteria> {
        C01601() {
        }

        public ProgramInfoQueryCriteria createFromParcel(Parcel in) {
            return new ProgramInfoQueryCriteria(in);
        }

        public ProgramInfoQueryCriteria[] newArray(int size) {
            return new ProgramInfoQueryCriteria[size];
        }
    }

    public ProgramInfoQueryCriteria() {
        this.queryIndex = 0;
        this.number = 0;
        this.serviceType = (short) 0;
        this.serviceType = (short) EnumServiceType.E_SERVICETYPE_INVALID.ordinal();
    }

    public ProgramInfoQueryCriteria(int queryIndex, int num, EnumServiceType serviceType) {
        this.queryIndex = queryIndex;
        this.number = num;
        this.serviceType = (short) serviceType.ordinal();
    }

    public ProgramInfoQueryCriteria(Parcel in) {
        this.queryIndex = in.readInt();
        this.number = in.readInt();
        this.serviceType = (short) in.readInt();
    }

    public EnumServiceType getServiceType() {
        return EnumServiceType.values()[this.serviceType];
    }

    public void setServiceType(EnumServiceType eServiceType) {
        this.serviceType = (short) eServiceType.ordinal();
    }

    static {
        CREATOR = new C01601();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.queryIndex);
        dest.writeInt(this.number);
        dest.writeInt(this.serviceType);
    }
}
