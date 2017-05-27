package com.mstar.android.tvapi.common.vo;

import android.text.format.Time;

public class TimerPowerOn extends Time {
    public int channelNumber;
    private int enBootMode;
    private int enTimerPeriod;
    private int enTvSource;
    public short volume;

    public TimerPowerOn() {
        this.enTimerPeriod = 0;
        this.enTvSource = 0;
        this.channelNumber = 0;
        this.volume = (short) 0;
        this.enBootMode = 0;
    }

    public EnumTimerBootType getBootMode() {
        return EnumTimerBootType.values()[this.enBootMode];
    }

    public void setBootMode(EnumTimerBootType v_BootMode) {
        this.enBootMode = v_BootMode.ordinal();
    }

    public EnumTimeOnTimerSource getTvSource() {
        return EnumTimeOnTimerSource.values()[this.enTvSource];
    }

    public void setTvSource(EnumTimeOnTimerSource enTimerSource) {
        this.enTvSource = enTimerSource.ordinal();
    }

    public EnumTimerPeriod getTimerPeriod() {
        return EnumTimerPeriod.values()[this.enTimerPeriod];
    }

    public void setTimerPeriod(EnumTimerPeriod timerperiod) {
        this.enTimerPeriod = timerperiod.ordinal();
    }
}
