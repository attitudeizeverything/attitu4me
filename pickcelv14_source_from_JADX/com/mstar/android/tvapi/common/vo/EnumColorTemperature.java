package com.mstar.android.tvapi.common.vo;

public enum EnumColorTemperature {
    E_COLOR_TEMP_MIN(0),
    E_COLOR_TEMP_COOL(E_COLOR_TEMP_MIN.getValue()),
    E_COLOR_TEMP_NATURE(1),
    E_COLOR_TEMP_WARM(2),
    E_COLOR_TEMP_USER(3),
    E_COLOR_TEMP_MAX(E_COLOR_TEMP_USER.getValue()),
    E_COLOR_TEMP_NUM(4);
    
    private final int value;

    private EnumColorTemperature(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
