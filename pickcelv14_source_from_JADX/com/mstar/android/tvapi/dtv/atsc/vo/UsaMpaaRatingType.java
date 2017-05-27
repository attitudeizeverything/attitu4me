package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UsaMpaaRatingType implements Parcelable {
    public static final Creator<UsaMpaaRatingType> CREATOR;
    public EnumUsaMpaaRatingType enUaMpaaRatingType;
    public boolean isNr;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.UsaMpaaRatingType.1 */
    static class C01901 implements Creator<UsaMpaaRatingType> {
        C01901() {
        }

        public UsaMpaaRatingType createFromParcel(Parcel in) {
            return new UsaMpaaRatingType(null);
        }

        public UsaMpaaRatingType[] newArray(int size) {
            return new UsaMpaaRatingType[size];
        }
    }

    public enum EnumUsaMpaaRatingType {
        E_MPAA_RATING_NA,
        E_MPAA_RATING_G,
        E_MPAA_RATING_PG,
        E_MPAA_RATING_PG_13,
        E_MPAA_RATING_R,
        E_MPAA_RATING_NC_17,
        E_MPAA_RATING_X,
        E_MPAA_RATING_NOT_RATED,
        E_MPAA_RATING_MAX_LEVEL
    }

    public UsaMpaaRatingType() {
        this.enUaMpaaRatingType = EnumUsaMpaaRatingType.E_MPAA_RATING_NA;
        this.isNr = false;
    }

    private UsaMpaaRatingType(Parcel in) {
        boolean z = true;
        this.enUaMpaaRatingType = EnumUsaMpaaRatingType.values()[in.readInt()];
        if (in.readInt() != 1) {
            z = false;
        }
        this.isNr = z;
    }

    static {
        CREATOR = new C01901();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.enUaMpaaRatingType.ordinal());
        dest.writeInt(this.isNr ? 1 : 0);
    }
}
