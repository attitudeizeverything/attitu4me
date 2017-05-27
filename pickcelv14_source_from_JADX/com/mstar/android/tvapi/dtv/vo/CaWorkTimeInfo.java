package com.mstar.android.tvapi.dtv.vo;

public class CaWorkTimeInfo {
    public short sStartHour;
    public short sWorkTimeState;
    public short syEndHour;
    public short syEndMin;
    public short syEndSec;
    public short syStartMin;
    public short syStartSec;

    public CaWorkTimeInfo() {
        this.sWorkTimeState = (short) -1;
        this.sStartHour = (short) 0;
        this.syStartMin = (short) 0;
        this.syStartSec = (short) 0;
        this.syEndHour = (short) 0;
        this.syEndMin = (short) 0;
        this.syEndSec = (short) 0;
    }
}
