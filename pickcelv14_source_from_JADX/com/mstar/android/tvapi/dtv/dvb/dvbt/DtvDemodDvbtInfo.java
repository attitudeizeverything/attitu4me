package com.mstar.android.tvapi.dtv.dvb.dvbt;

public class DtvDemodDvbtInfo {
    public float SfoValue;
    public float TotalCfo;
    public short u16ChannelLength;
    public byte u16DemodState;
    public short u16Version;
    public byte u8ChLen;
    public byte u8Constel;
    public byte u8DigAci;
    public byte u8Fd;
    public byte u8Fft;
    public byte u8FlagCi;
    public byte u8Gi;
    public byte u8Hiearchy;
    public byte u8HpCr;
    public byte u8LpCr;
    public byte u8PertoneNum;
    public byte u8SnrSel;
    public byte u8TdCoef;

    public DtvDemodDvbtInfo() {
        this.u16Version = (short) 0;
        this.u16DemodState = (byte) 0;
        this.SfoValue = 0.0f;
        this.TotalCfo = 0.0f;
        this.u16ChannelLength = (short) 0;
        this.u8Fft = (byte) 0;
        this.u8Constel = (byte) 0;
        this.u8Gi = (byte) 0;
        this.u8HpCr = (byte) 0;
        this.u8LpCr = (byte) 0;
        this.u8Hiearchy = (byte) 0;
        this.u8Fd = (byte) 0;
        this.u8ChLen = (byte) 0;
        this.u8SnrSel = (byte) 0;
        this.u8PertoneNum = (byte) 0;
        this.u8DigAci = (byte) 0;
        this.u8FlagCi = (byte) 0;
        this.u8TdCoef = (byte) 0;
    }
}
