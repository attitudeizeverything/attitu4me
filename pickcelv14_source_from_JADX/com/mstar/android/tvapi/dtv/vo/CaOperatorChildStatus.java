package com.mstar.android.tvapi.dtv.vo;

public class CaOperatorChildStatus {
    public boolean bIsCanFeed;
    public String pParentCardSN;
    public short sDelayTime;
    public short sIsChild;
    public short sOperatorChildState;
    public int wLastFeedTime;

    public CaOperatorChildStatus() {
        this.sOperatorChildState = (short) 0;
        this.sIsChild = (short) 0;
        this.sDelayTime = (short) 0;
        this.wLastFeedTime = 0;
        this.pParentCardSN = "";
        this.bIsCanFeed = false;
    }
}
