package com.mstar.android.tvapi.common.vo;

public class Time {
    public static final int E_TIMER_BOOT_ON_TIMER = 0;
    public static final int E_TIMER_BOOT_RECORDER = 2;
    public static final int E_TIMER_BOOT_REMINDER = 1;
    public boolean autoSleepFlag;
    public boolean clockMode;
    public short eTimeZoneInfo;
    public short enOnTimeState;
    public boolean is12Hour;
    public boolean isAutoSync;
    public boolean isDaylightSaving;
    public int offTimeFlag;
    public short offTimeState;
    public short offTimerInfoHour;
    public short offTimerInfoMin;
    public int offsetTime;
    public short onTimeFlag;
    public short onTimeTvSrc;
    public int onTimerChannel;
    public short onTimerInfoHour;
    public short onTimerInfoMin;
    public short onTimerVolume;
    public int timeDataCS;
    public int timerBootMode;

    public Time() {
        this.timeDataCS = E_TIMER_BOOT_ON_TIMER;
        this.onTimeFlag = (short) 0;
        this.offTimeFlag = E_TIMER_BOOT_ON_TIMER;
        this.offTimeState = (short) 0;
        this.offTimerInfoHour = (short) 0;
        this.offTimerInfoMin = (short) 0;
        this.enOnTimeState = (short) 0;
        this.onTimerInfoHour = (short) 0;
        this.onTimerInfoMin = (short) 0;
        this.onTimerChannel = E_TIMER_BOOT_ON_TIMER;
        this.onTimeTvSrc = (short) 0;
        this.onTimerVolume = (short) 0;
        this.eTimeZoneInfo = (short) 0;
        this.is12Hour = false;
        this.isAutoSync = false;
        this.clockMode = false;
        this.autoSleepFlag = false;
        this.isDaylightSaving = false;
        this.offsetTime = E_TIMER_BOOT_ON_TIMER;
        this.timerBootMode = E_TIMER_BOOT_ON_TIMER;
    }
}
