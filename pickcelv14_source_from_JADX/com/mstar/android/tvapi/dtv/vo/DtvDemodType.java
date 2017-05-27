package com.mstar.android.tvapi.dtv.vo;

public enum DtvDemodType {
    E_DEMOD_DVB_T(0),
    E_DEMOD_DVB_C(1),
    E_DEMOD_DVB_S(2),
    E_DEMOD_DTMB(3),
    E_DEMOD_DVB_T2(4),
    E_DEMOD_MAX(5),
    E_DEMOD_NULL(E_DEMOD_MAX.getValue());
    
    private final int value;

    private DtvDemodType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
