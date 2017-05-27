package com.mstar.android.tvapi.dtv.vo;

public class CaFeedDataInfo {
    public String pbyFeedData;
    public short sFeedDataState;
    public short sdataLen;

    public CaFeedDataInfo() {
        this.sFeedDataState = (short) 0;
        this.sdataLen = (short) 0;
        this.pbyFeedData = "";
    }
}
