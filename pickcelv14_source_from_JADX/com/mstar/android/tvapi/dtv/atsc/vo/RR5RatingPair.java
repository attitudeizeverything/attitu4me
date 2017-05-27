package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RR5RatingPair implements Parcelable {
    public static final Creator<RR5RatingPair> CREATOR;
    public String abbRatingText;
    public int rR5RatingPair_id;
    public int regin5Dimension_index;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.RR5RatingPair.1 */
    static class C01871 implements Creator<RR5RatingPair> {
        C01871() {
        }

        public RR5RatingPair createFromParcel(Parcel in) {
            return new RR5RatingPair(null);
        }

        public RR5RatingPair[] newArray(int size) {
            return new RR5RatingPair[size];
        }
    }

    public RR5RatingPair() {
        this.regin5Dimension_index = 0;
        this.abbRatingText = "default";
        this.rR5RatingPair_id = 0;
    }

    private RR5RatingPair(Parcel in) {
        this.regin5Dimension_index = in.readInt();
        this.abbRatingText = in.readString();
        this.rR5RatingPair_id = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C01871();
    }

    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeInt(this.regin5Dimension_index);
        dest.writeString(this.abbRatingText);
        dest.writeInt(this.rR5RatingPair_id);
    }
}
