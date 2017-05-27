package com.mstar.android.tvapi.dtv.vo;

public class CaACListInfo {
    public int[] pACArray;
    public short sACListInfoState;

    public CaACListInfo() {
        this.pACArray = new int[18];
        this.sACListInfoState = (short) 0;
        for (int i = 0; i < 18; i++) {
            this.pACArray[i] = 0;
        }
    }
}
