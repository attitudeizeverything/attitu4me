package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class CaStartIPPVBuyDlgInfo implements Serializable, Parcelable {
    public static final Creator<CaStartIPPVBuyDlgInfo> CREATOR;
    private static final long serialVersionUID = -2356912323236760L;
    public int dwProductID;
    public CaIPPVPrice[] m_Price;
    public short wEcmPid;
    public short wExpiredDate;
    public short wTvsID;
    public short wyMessageType;
    public short wyPriceNum;
    public short wySlotID;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.CaStartIPPVBuyDlgInfo.1 */
    static class C02111 implements Creator<CaStartIPPVBuyDlgInfo> {
        C02111() {
        }

        public CaStartIPPVBuyDlgInfo createFromParcel(Parcel in) {
            return new CaStartIPPVBuyDlgInfo(null);
        }

        public CaStartIPPVBuyDlgInfo[] newArray(int size) {
            return new CaStartIPPVBuyDlgInfo[size];
        }
    }

    public CaStartIPPVBuyDlgInfo() {
        this.m_Price = new CaIPPVPrice[2];
        this.dwProductID = 0;
        this.wySlotID = (short) 0;
        this.wyPriceNum = (short) 0;
        this.wExpiredDate = (short) 0;
        for (int i = 0; i < 2; i++) {
            this.m_Price[i] = new CaIPPVPrice();
        }
    }

    public short getWyMessageType() {
        return this.wyMessageType;
    }

    public void setWyMessageType(short wyMessageType) {
        this.wyMessageType = wyMessageType;
    }

    public short getwEcmPid() {
        return this.wEcmPid;
    }

    public void setwEcmPid(short wEcmPid) {
        this.wEcmPid = wEcmPid;
    }

    public int getDwProductID() {
        return this.dwProductID;
    }

    public void setDwProductID(int dwProductID) {
        this.dwProductID = dwProductID;
    }

    public short getwTvsID() {
        return this.wTvsID;
    }

    public void setwTvsID(short wTvsID) {
        this.wTvsID = wTvsID;
    }

    public short getWySlotID() {
        return this.wySlotID;
    }

    public void setWySlotID(short wySlotID) {
        this.wySlotID = wySlotID;
    }

    public short getWyPriceNum() {
        return this.wyPriceNum;
    }

    public void setWyPriceNum(short wyPriceNum) {
        this.wyPriceNum = wyPriceNum;
    }

    public short getwExpiredDate() {
        return this.wExpiredDate;
    }

    public void setwExpiredDate(short wExpiredDate) {
        this.wExpiredDate = wExpiredDate;
    }

    public CaIPPVPrice[] getM_Price() {
        return this.m_Price;
    }

    public void setM_Price(CaIPPVPrice[] m_Price) {
        this.m_Price = m_Price;
    }

    private CaStartIPPVBuyDlgInfo(Parcel in) {
        this.m_Price = new CaIPPVPrice[2];
        this.dwProductID = in.readInt();
        this.wySlotID = (short) in.readInt();
        this.wyPriceNum = (short) in.readInt();
        this.wExpiredDate = (short) in.readInt();
        for (int i = 0; i < 2; i++) {
            this.m_Price[i] = (CaIPPVPrice) CaIPPVPrice.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02111();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.dwProductID);
        arg0.writeInt(this.wySlotID);
        arg0.writeInt(this.wyPriceNum);
        arg0.writeInt(this.wExpiredDate);
        for (int i = 0; i < 2; i++) {
            this.m_Price[i].writeToParcel(arg0, arg1);
        }
    }
}
