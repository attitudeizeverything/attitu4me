package com.mstar.android.tvapi.dtv.vo;

public class CaDetitleChkNums {
    public boolean bReadFlag;
    public int[] pdwEntitleIds;
    public short sDetitleChkNumsState;

    public CaDetitleChkNums() {
        this.pdwEntitleIds = new int[5];
        this.sDetitleChkNumsState = (short) 0;
        this.bReadFlag = false;
        for (int i = 0; i < 5; i++) {
            this.pdwEntitleIds[i] = 0;
        }
    }
}
