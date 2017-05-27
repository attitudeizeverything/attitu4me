package com.mstar.android.tvapi.common.vo;

import android.text.format.Time;

public class TimerPowerOffModeStatus extends Time {
    private int enTimerPeriod;

    public TimerPowerOffModeStatus() {
        this.enTimerPeriod = 0;
    }

    public EnumTimerPeriod getTimerPeriod() {
        return EnumTimerPeriod.values()[this.enTimerPeriod];
    }

    public void setTimerPeriod(EnumTimerPeriod timerperiod) {
        this.enTimerPeriod = timerperiod.ordinal();
    }
}
