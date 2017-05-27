package com.mstar.android.tvapi.dtv.vo;

public class CaIPPVProgramInfo {
    public short sBookEdFlag;
    public short sCanTape;
    public short sExpiredDate;
    public short sPrice;
    public short sSlotID;
    public int wdwProductID;

    public CaIPPVProgramInfo() {
        this.wdwProductID = 0;
        this.sBookEdFlag = (short) 0;
        this.sCanTape = (short) 0;
        this.sPrice = (short) 0;
        this.sExpiredDate = (short) 0;
        this.sSlotID = (short) 0;
    }
}
