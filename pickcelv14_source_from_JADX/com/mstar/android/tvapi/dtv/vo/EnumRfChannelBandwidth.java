package com.mstar.android.tvapi.dtv.vo;

public enum EnumRfChannelBandwidth {
    E_7_MHZ(7),
    E_8_MHZ(8);
    
    private final int value;

    private EnumRfChannelBandwidth(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
