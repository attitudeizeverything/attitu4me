package com.mstar.android.tvapi.dtv.vo;

public class CaSlotInfo {
    public short sSlotInfoState;
    public int wBalance;
    public int wCreditLimit;

    public CaSlotInfo() {
        this.sSlotInfoState = (short) 0;
        this.wCreditLimit = 0;
        this.wBalance = 0;
    }
}
