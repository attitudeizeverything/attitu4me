package com.mstar.android.tvapi.dtv.vo;

public class CaEntitleIDs {
    public int[] pdwEntitleIds;
    public short sEntitleIDsState;

    public CaEntitleIDs() {
        this.pdwEntitleIds = new int[300];
        this.sEntitleIDsState = (short) 0;
        for (int i = 0; i < 300; i++) {
            this.pdwEntitleIds[i] = 0;
        }
    }
}
