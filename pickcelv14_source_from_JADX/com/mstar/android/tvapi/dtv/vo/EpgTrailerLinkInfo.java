package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EpgTrailerLinkInfo implements Parcelable {
    public static final Creator<EpgTrailerLinkInfo> CREATOR;
    public int cridType;
    public short iconId;
    public String pEventTitle;
    public String promotionText;
    public String trailerCrid;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgTrailerLinkInfo.1 */
    static class C02251 implements Creator<EpgTrailerLinkInfo> {
        C02251() {
        }

        public EpgTrailerLinkInfo createFromParcel(Parcel in) {
            return new EpgTrailerLinkInfo(null);
        }

        public EpgTrailerLinkInfo[] newArray(int size) {
            return new EpgTrailerLinkInfo[size];
        }
    }

    public EpgTrailerLinkInfo() {
        this.cridType = 0;
        this.iconId = (short) 0;
        this.promotionText = "";
        this.trailerCrid = "";
        this.pEventTitle = "";
    }

    static {
        CREATOR = new C02251();
    }

    private EpgTrailerLinkInfo(Parcel in) {
        this.cridType = in.readInt();
        this.iconId = (short) in.readInt();
        this.promotionText = in.readString();
        this.trailerCrid = in.readString();
        this.pEventTitle = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.cridType);
        arg0.writeInt(this.iconId);
        arg0.writeString(this.promotionText);
        arg0.writeString(this.trailerCrid);
        arg0.writeString(this.pEventTitle);
    }
}
