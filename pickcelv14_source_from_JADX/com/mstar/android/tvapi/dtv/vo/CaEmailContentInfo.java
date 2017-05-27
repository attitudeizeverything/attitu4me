package com.mstar.android.tvapi.dtv.vo;

public class CaEmailContentInfo {
    public String pcEmailContent;
    public short sEmailContentState;

    public CaEmailContentInfo() {
        this.sEmailContentState = (short) 0;
        this.pcEmailContent = "";
    }

    public short getsEmailContentState() {
        return this.sEmailContentState;
    }

    public void setsEmailContentState(short sEmailContentState) {
        this.sEmailContentState = sEmailContentState;
    }

    public String getPcEmailContent() {
        return this.pcEmailContent;
    }

    public void setPcEmailContent(String pcEmailContent) {
        this.pcEmailContent = pcEmailContent;
    }
}
