package com.mstar.android.tvapi.common.vo;

import com.mstar.android.tvapi.common.exception.TvCommonException;

public class AudioOutParameter {
    public int spdifDelayTime;
    private int spdifOutModeInUi;
    public int speakerDelayTime;
    private int spidfOutModActive;

    public EnumSpdifType getspdifOutModeInUi() throws TvCommonException {
        if (this.spdifOutModeInUi < EnumSpdifType.E_PCM.ordinal() || this.spdifOutModeInUi > EnumSpdifType.E_NONPCM.ordinal()) {
            return EnumSpdifType.values()[this.spdifOutModeInUi];
        }
        throw new TvCommonException("getEnumSpdifType  failed");
    }

    public void setspdifOutModeInUi(EnumSpdifType espdifOutModeInUi) {
        this.spdifOutModeInUi = espdifOutModeInUi.ordinal();
    }

    public EnumSpdifType getspidfOutModActive() throws TvCommonException {
        if (this.spidfOutModActive < EnumSpdifType.E_PCM.ordinal() || this.spidfOutModActive > EnumSpdifType.E_NONPCM.ordinal()) {
            return EnumSpdifType.values()[this.spidfOutModActive];
        }
        throw new TvCommonException("spidfOutModActive  failed");
    }

    public void setspidfOutModActive(EnumSpdifType espidfOutModActive) {
        this.spidfOutModActive = espidfOutModActive.ordinal();
    }
}
