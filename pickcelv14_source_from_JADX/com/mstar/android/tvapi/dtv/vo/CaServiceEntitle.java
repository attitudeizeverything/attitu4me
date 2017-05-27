package com.mstar.android.tvapi.dtv.vo;

public class CaServiceEntitle {
    public short m_bCanTape;
    public short sBeginDate;
    public short sExpireDate;
    public int wwProductID;

    public CaServiceEntitle() {
        this.wwProductID = 0;
        this.sBeginDate = (short) 0;
        this.sExpireDate = (short) 0;
        this.m_bCanTape = (short) 0;
    }
}
