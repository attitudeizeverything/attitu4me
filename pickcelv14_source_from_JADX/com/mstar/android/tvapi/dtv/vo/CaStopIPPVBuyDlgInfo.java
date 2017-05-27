package com.mstar.android.tvapi.dtv.vo;

public class CaStopIPPVBuyDlgInfo {
    public boolean bBuyProgram;
    public String pbyPinCode;
    public short sEcmPid;
    public short sIPPVBuyDlgState;
    public short sPrice;
    public short sPriceCode;

    public CaStopIPPVBuyDlgInfo() {
        this.sIPPVBuyDlgState = (short) 0;
        this.bBuyProgram = false;
        this.sEcmPid = (short) 0;
        this.pbyPinCode = "";
        this.sPrice = (short) 0;
        this.sPriceCode = (short) 0;
    }

    public short getsIPPVBuyDlgState() {
        return this.sIPPVBuyDlgState;
    }

    public void setsIPPVBuyDlgState(short sIPPVBuyDlgState) {
        this.sIPPVBuyDlgState = sIPPVBuyDlgState;
    }

    public boolean isbBuyProgram() {
        return this.bBuyProgram;
    }

    public void setbBuyProgram(boolean bBuyProgram) {
        this.bBuyProgram = bBuyProgram;
    }

    public short getsEcmPid() {
        return this.sEcmPid;
    }

    public void setsEcmPid(short sEcmPid) {
        this.sEcmPid = sEcmPid;
    }

    public String getPbyPinCode() {
        return this.pbyPinCode;
    }

    public void setPbyPinCode(String pbyPinCode) {
        this.pbyPinCode = pbyPinCode;
    }

    public short getsPrice() {
        return this.sPrice;
    }

    public void setsPrice(short sPrice) {
        this.sPrice = sPrice;
    }

    public short getsPriceCode() {
        return this.sPriceCode;
    }

    public void setsPriceCode(short sPriceCode) {
        this.sPriceCode = sPriceCode;
    }
}
