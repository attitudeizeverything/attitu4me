package com.mstar.android.tvapi.dtv.vo;

public class CaEmailSpaceInfo {
    public short sEmailNum;
    public short sEmptyNum;
    public short saEmailSpaceState;

    public CaEmailSpaceInfo() {
        this.saEmailSpaceState = (short) 0;
        this.sEmailNum = (short) 0;
        this.sEmptyNum = (short) 0;
    }

    public short getSaEmailSpaceState() {
        return this.saEmailSpaceState;
    }

    public void setSaEmailSpaceState(short saEmailSpaceState) {
        this.saEmailSpaceState = saEmailSpaceState;
    }

    public short getsEmailNum() {
        return this.sEmailNum;
    }

    public void setsEmailNum(short sEmailNum) {
        this.sEmailNum = sEmailNum;
    }

    public short getsEmptyNum() {
        return this.sEmptyNum;
    }

    public void setsEmptyNum(short sEmptyNum) {
        this.sEmptyNum = sEmptyNum;
    }
}
