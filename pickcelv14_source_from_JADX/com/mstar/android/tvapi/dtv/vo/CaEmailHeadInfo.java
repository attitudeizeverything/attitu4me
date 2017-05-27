package com.mstar.android.tvapi.dtv.vo;

public class CaEmailHeadInfo {
    public short m_bNewEmail;
    public String pcEmailHead;
    public short sEmailHeadState;
    public int wActionID;
    public int wCreateTime;
    public short wImportance;

    public CaEmailHeadInfo() {
        this.sEmailHeadState = (short) 0;
        this.wActionID = 0;
        this.wCreateTime = 0;
        this.wImportance = (short) 0;
        this.pcEmailHead = "";
        this.m_bNewEmail = (short) 0;
    }

    public short getsEmailHeadState() {
        return this.sEmailHeadState;
    }

    public void setsEmailHeadState(short sEmailHeadState) {
        this.sEmailHeadState = sEmailHeadState;
    }

    public int getwActionID() {
        return this.wActionID;
    }

    public void setwActionID(int wActionID) {
        this.wActionID = wActionID;
    }

    public int getwCreateTime() {
        return this.wCreateTime;
    }

    public void setwCreateTime(int wCreateTime) {
        this.wCreateTime = wCreateTime;
    }

    public short getwImportance() {
        return this.wImportance;
    }

    public void setwImportance(short wImportance) {
        this.wImportance = wImportance;
    }

    public String getPcEmailHead() {
        return this.pcEmailHead;
    }

    public void setPcEmailHead(String pcEmailHead) {
        this.pcEmailHead = pcEmailHead;
    }

    public short getM_bNewEmail() {
        return this.m_bNewEmail;
    }

    public void setM_bNewEmail(short m_bNewEmail) {
        this.m_bNewEmail = m_bNewEmail;
    }
}
