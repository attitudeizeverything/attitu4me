package com.mstar.android.tvapi.dtv.vo;

public class CaEmailHeadsInfo {
    public CaEmailHeadInfo[] EmailHeads;
    public short sCount;
    public short sEmailHeadsState;
    public short sFromIndex;

    public CaEmailHeadsInfo() {
        this.sEmailHeadsState = (short) 0;
        this.sCount = (short) 0;
        this.sFromIndex = (short) 0;
        for (int i = 0; i < this.EmailHeads.length; i++) {
            this.EmailHeads[i] = new CaEmailHeadInfo();
        }
    }

    public short getsEmailHeadsState() {
        return this.sEmailHeadsState;
    }

    public void setsEmailHeadsState(short sEmailHeadsState) {
        this.sEmailHeadsState = sEmailHeadsState;
    }

    public short getsCount() {
        return this.sCount;
    }

    public void setsCount(short sCount) {
        this.sCount = sCount;
    }

    public short getsFromIndex() {
        return this.sFromIndex;
    }

    public void setsFromIndex(short sFromIndex) {
        this.sFromIndex = sFromIndex;
    }

    public CaEmailHeadInfo[] getEmailHeads() {
        return this.EmailHeads;
    }

    public void setEmailHeads(CaEmailHeadInfo[] emailHeads) {
        this.EmailHeads = emailHeads;
    }
}
