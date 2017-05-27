package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Regin5DimensionInformation implements Parcelable {
    public static final Creator<Regin5DimensionInformation> CREATOR;
    public String dimensionName;
    public int graduated_Scale;
    public int index;
    public int values_Defined;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.Regin5DimensionInformation.1 */
    static class C01881 implements Creator<Regin5DimensionInformation> {
        C01881() {
        }

        public Regin5DimensionInformation createFromParcel(Parcel in) {
            return new Regin5DimensionInformation(null);
        }

        public Regin5DimensionInformation[] newArray(int size) {
            return new Regin5DimensionInformation[size];
        }
    }

    public Regin5DimensionInformation(int index, String dimensionName, int values_Defined, int graduated_Scale) {
        this.index = index;
        this.dimensionName = dimensionName;
        this.values_Defined = values_Defined;
        this.graduated_Scale = graduated_Scale;
    }

    private Regin5DimensionInformation(Parcel in) {
        this.index = in.readInt();
        this.dimensionName = in.readString();
        this.values_Defined = in.readInt();
        this.graduated_Scale = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C01881();
    }

    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeInt(this.index);
        dest.writeString(this.dimensionName);
        dest.writeInt(this.values_Defined);
        dest.writeInt(this.graduated_Scale);
    }
}
