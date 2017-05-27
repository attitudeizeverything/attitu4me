package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtscEpgRating implements Parcelable {
    public static final Creator<AtscEpgRating> CREATOR;
    public byte caEngFlag;
    public byte caEngRatingD0;
    public byte caFreFlag;
    public byte caFreRatingD1;
    public byte dialog;
    public byte fantasyViolence;
    public byte language;
    public byte mpaaFlag;
    public byte mpaaRatingD2;
    public byte ratingRxIsOK;
    public byte sexualContent;
    public byte tvRatingForChild;
    public byte tvRatingForEntire;
    public byte violence;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.AtscEpgRating.1 */
    static class C01831 implements Creator<AtscEpgRating> {
        C01831() {
        }

        public AtscEpgRating createFromParcel(Parcel in) {
            return new AtscEpgRating(in);
        }

        public AtscEpgRating[] newArray(int size) {
            return new AtscEpgRating[size];
        }
    }

    public AtscEpgRating() {
        this.ratingRxIsOK = (byte) 0;
        this.mpaaFlag = (byte) 0;
        this.tvRatingForEntire = (byte) 0;
        this.dialog = (byte) 0;
        this.language = (byte) 0;
        this.sexualContent = (byte) 0;
        this.violence = (byte) 0;
        this.fantasyViolence = (byte) 0;
        this.mpaaRatingD2 = (byte) 0;
        this.tvRatingForChild = (byte) 0;
        this.caEngFlag = (byte) 0;
        this.caFreFlag = (byte) 0;
        this.caEngRatingD0 = (byte) 0;
        this.caFreRatingD1 = (byte) 0;
    }

    public AtscEpgRating(Parcel in) {
        this.ratingRxIsOK = in.readByte();
        this.mpaaFlag = in.readByte();
        this.tvRatingForEntire = in.readByte();
        this.dialog = in.readByte();
        this.language = in.readByte();
        this.sexualContent = in.readByte();
        this.violence = in.readByte();
        this.fantasyViolence = in.readByte();
        this.mpaaRatingD2 = in.readByte();
        this.tvRatingForChild = in.readByte();
        this.caEngFlag = in.readByte();
        this.caFreFlag = in.readByte();
        this.caEngRatingD0 = in.readByte();
        this.caFreRatingD1 = in.readByte();
    }

    static {
        CREATOR = new C01831();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.ratingRxIsOK);
        dest.writeByte(this.mpaaFlag);
        dest.writeByte(this.tvRatingForEntire);
        dest.writeByte(this.dialog);
        dest.writeByte(this.language);
        dest.writeByte(this.sexualContent);
        dest.writeByte(this.violence);
        dest.writeByte(this.fantasyViolence);
        dest.writeByte(this.mpaaRatingD2);
        dest.writeByte(this.tvRatingForChild);
        dest.writeByte(this.caEngFlag);
        dest.writeByte(this.caFreFlag);
        dest.writeByte(this.caEngRatingD0);
        dest.writeByte(this.caFreRatingD1);
    }
}
