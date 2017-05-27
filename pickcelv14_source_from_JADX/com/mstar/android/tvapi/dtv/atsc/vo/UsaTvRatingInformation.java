package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UsaTvRatingInformation implements Parcelable {
    public static final Creator<UsaTvRatingInformation> CREATOR;
    public boolean bTV_14_ALL_Lock;
    public boolean bTV_14_D_Lock;
    public boolean bTV_14_L_Lock;
    public boolean bTV_14_S_Lock;
    public boolean bTV_14_V_Lock;
    public boolean bTV_G_ALL_Lock;
    public boolean bTV_G_D_Lock;
    public boolean bTV_G_L_Lock;
    public boolean bTV_G_S_Lock;
    public boolean bTV_G_V_Lock;
    public boolean bTV_MA_ALL_Lock;
    public boolean bTV_MA_D_Lock;
    public boolean bTV_MA_L_Lock;
    public boolean bTV_MA_S_Lock;
    public boolean bTV_MA_V_Lock;
    public boolean bTV_PG_ALL_Lock;
    public boolean bTV_PG_D_Lock;
    public boolean bTV_PG_L_Lock;
    public boolean bTV_PG_S_Lock;
    public boolean bTV_PG_V_Lock;
    public boolean bTV_Y7_ALL_Lock;
    public boolean bTV_Y7_FV_Lock;
    public boolean bTV_Y_ALL_Lock;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.UsaTvRatingInformation.1 */
    static class C01911 implements Creator<UsaTvRatingInformation> {
        C01911() {
        }

        public UsaTvRatingInformation createFromParcel(Parcel in) {
            return new UsaTvRatingInformation(null);
        }

        public UsaTvRatingInformation[] newArray(int size) {
            return new UsaTvRatingInformation[size];
        }
    }

    public UsaTvRatingInformation() {
        this.bTV_Y_ALL_Lock = false;
        this.bTV_Y7_ALL_Lock = false;
        this.bTV_Y7_FV_Lock = false;
        this.bTV_G_ALL_Lock = false;
        this.bTV_G_V_Lock = false;
        this.bTV_G_S_Lock = false;
        this.bTV_G_L_Lock = false;
        this.bTV_G_D_Lock = false;
        this.bTV_PG_ALL_Lock = false;
        this.bTV_PG_V_Lock = false;
        this.bTV_PG_S_Lock = false;
        this.bTV_PG_L_Lock = false;
        this.bTV_PG_D_Lock = false;
        this.bTV_14_ALL_Lock = false;
        this.bTV_14_V_Lock = false;
        this.bTV_14_S_Lock = false;
        this.bTV_14_L_Lock = false;
        this.bTV_14_D_Lock = false;
        this.bTV_MA_ALL_Lock = false;
        this.bTV_MA_V_Lock = false;
        this.bTV_MA_S_Lock = false;
        this.bTV_MA_L_Lock = false;
        this.bTV_MA_D_Lock = false;
    }

    private UsaTvRatingInformation(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.bTV_Y_ALL_Lock = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_Y7_ALL_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_Y7_FV_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_G_ALL_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_G_V_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_G_S_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_G_L_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_G_D_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_PG_ALL_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_PG_V_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_PG_S_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_PG_L_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_PG_D_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_14_ALL_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_14_V_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_14_S_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_14_L_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_14_D_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_MA_ALL_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_MA_V_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_MA_S_Lock = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bTV_MA_L_Lock = z;
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.bTV_MA_D_Lock = z2;
    }

    static {
        CREATOR = new C01911();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeInt(this.bTV_Y_ALL_Lock ? 1 : 0);
        if (this.bTV_Y7_ALL_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_Y7_FV_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_G_ALL_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_G_V_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_G_S_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_G_L_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_G_D_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_PG_ALL_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_PG_V_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_PG_S_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_PG_L_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_PG_D_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_14_ALL_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_14_V_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_14_S_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_14_L_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_14_D_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_MA_ALL_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_MA_V_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_MA_S_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.bTV_MA_L_Lock) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (!this.bTV_MA_D_Lock) {
            i2 = 0;
        }
        dest.writeInt(i2);
    }
}
