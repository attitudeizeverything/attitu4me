package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Region5RatingInformation implements Parcelable {
    public static final Creator<Region5RatingInformation> CREATOR;
    public static final int RRT5_DIMENSIONS = 256;
    public static final int RRT5_DIMNAME_LENGTH = 24;
    public static final int RRT5_LEVELS = 15;
    public static final int RRT5_REGNAME_LENGTH = 36;
    public static final int RRT5_TEXT_LENGTH = 16;
    public short dimensionNo;
    public Region5DimensionInformation[] regin5Dimensions;
    public short[] region5Name;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation.1 */
    static class C01891 implements Creator<Region5RatingInformation> {
        C01891() {
        }

        public Region5RatingInformation createFromParcel(Parcel in) {
            return new Region5RatingInformation(null);
        }

        public Region5RatingInformation[] newArray(int size) {
            return new Region5RatingInformation[size];
        }
    }

    public class Region5DimensionInformation {
        public String[] abbRatingText;
        public short[] dimensionName;
        public char graduatedScale;
        public short valuesDefined;

        public Region5DimensionInformation(Parcel in) {
            this.dimensionName = new short[Region5RatingInformation.RRT5_DIMNAME_LENGTH];
            this.abbRatingText = new String[Region5RatingInformation.RRT5_LEVELS];
            for (int i = 0; i < Region5RatingInformation.RRT5_DIMNAME_LENGTH; i++) {
                this.dimensionName[i] = (short) in.readInt();
            }
            this.valuesDefined = (short) in.readInt();
            this.graduatedScale = (char) in.readByte();
            for (String str : this.abbRatingText) {
                in.readString();
            }
        }

        public void writeToParcel(Parcel out) {
            for (int i = 0; i < Region5RatingInformation.RRT5_DIMNAME_LENGTH; i++) {
                out.writeInt(this.dimensionName[i]);
            }
            out.writeInt(this.valuesDefined);
            out.writeByte((byte) this.graduatedScale);
            for (String str : this.abbRatingText) {
                out.writeString(str);
            }
        }
    }

    private Region5RatingInformation(Parcel in) {
        int i;
        this.region5Name = new short[RRT5_REGNAME_LENGTH];
        this.regin5Dimensions = new Region5DimensionInformation[RRT5_DIMENSIONS];
        for (i = 0; i < RRT5_REGNAME_LENGTH; i++) {
            this.region5Name[i] = (short) in.readInt();
        }
        this.dimensionNo = (short) in.readInt();
        for (i = 0; i < RRT5_DIMENSIONS; i++) {
            this.regin5Dimensions[i] = new Region5DimensionInformation(in);
        }
    }

    static {
        CREATOR = new C01891();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        int i;
        for (i = 0; i < RRT5_REGNAME_LENGTH; i++) {
            arg0.writeInt(this.region5Name[i]);
        }
        arg0.writeInt(this.dimensionNo);
        for (i = 0; i < RRT5_DIMENSIONS; i++) {
            this.regin5Dimensions[i].writeToParcel(arg0);
        }
    }
}
