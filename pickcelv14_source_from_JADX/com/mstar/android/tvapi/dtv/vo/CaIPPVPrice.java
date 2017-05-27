package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class CaIPPVPrice implements Serializable, Parcelable {
    public static final Creator<CaIPPVPrice> CREATOR;
    private static final long serialVersionUID = -235691783434420L;
    public short m_byPriceCode;
    public short m_wPrice;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.CaIPPVPrice.1 */
    static class C02091 implements Creator<CaIPPVPrice> {
        C02091() {
        }

        public CaIPPVPrice createFromParcel(Parcel in) {
            return new CaIPPVPrice(null);
        }

        public CaIPPVPrice[] newArray(int size) {
            return new CaIPPVPrice[size];
        }
    }

    public CaIPPVPrice() {
        this.m_wPrice = (short) 0;
        this.m_byPriceCode = (short) 0;
    }

    public short getM_wPrice() {
        return this.m_wPrice;
    }

    public void setM_wPrice(short m_wPrice) {
        this.m_wPrice = m_wPrice;
    }

    public short getM_byPriceCode() {
        return this.m_byPriceCode;
    }

    public void setM_byPriceCode(short m_byPriceCode) {
        this.m_byPriceCode = m_byPriceCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.m_wPrice);
        arg0.writeInt(this.m_byPriceCode);
    }

    private CaIPPVPrice(Parcel in) {
        this.m_wPrice = (short) in.readInt();
        this.m_byPriceCode = (short) in.readInt();
    }

    static {
        CREATOR = new C02091();
    }
}
