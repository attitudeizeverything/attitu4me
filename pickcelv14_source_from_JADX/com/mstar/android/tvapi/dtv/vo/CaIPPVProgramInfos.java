package com.mstar.android.tvapi.dtv.vo;

public class CaIPPVProgramInfos {
    public CaIPPVProgramInfo[] IPPVProgramInfo;
    public short sIPPVInfoState;
    public short sNumber;

    public CaIPPVProgramInfos() {
        this.IPPVProgramInfo = new CaIPPVProgramInfo[300];
        this.sIPPVInfoState = (short) 0;
        this.sNumber = (short) 0;
        for (int i = 0; i < 300; i++) {
            this.IPPVProgramInfo[i] = new CaIPPVProgramInfo();
        }
    }
}
