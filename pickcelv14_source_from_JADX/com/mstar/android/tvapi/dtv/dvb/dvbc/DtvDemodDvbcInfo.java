package com.mstar.android.tvapi.dtv.dvb.dvbc;

public class DtvDemodDvbcInfo {
    public boolean bSerialTS;
    public boolean bSpecInv;
    public byte eLockStatus;
    public byte eQamMode;
    public short u16Quality;
    public short u16Strength;
    public short u16SymbolRate;
    public short u16SymbolRateHal;
    public short u16Version;
    public int u32ChkScanTimeStart;
    public int u32FcFs;
    public int u32IFFreq;
    public int u32Intp;
    public byte u8Qam;
    public byte u8SarValue;

    public DtvDemodDvbcInfo() {
        this.u16Version = (short) 0;
        this.u16SymbolRate = (short) 0;
        this.eQamMode = (byte) 0;
        this.u32IFFreq = 0;
        this.bSpecInv = false;
        this.bSerialTS = false;
        this.u8SarValue = (byte) 0;
        this.u32ChkScanTimeStart = 0;
        this.eLockStatus = (byte) 0;
        this.u16Strength = (short) 0;
        this.u16Quality = (short) 0;
        this.u32Intp = 0;
        this.u32FcFs = 0;
        this.u8Qam = (byte) 0;
        this.u16SymbolRateHal = (short) 0;
    }
}
