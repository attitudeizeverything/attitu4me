package com.mstar.android.tvapi.common.vo;

import com.mstar.android.MKeyEvent;
import jcifs.smb.SmbNamedPipe;

public class ScreenPixelInfo {
    public boolean bShowRepWin;
    public EnumPixelRGBStage enStage;
    public int tmpStage;
    public short u16BCbMax;
    public short u16BCbMin;
    public short u16GYMax;
    public short u16GYMin;
    public short u16RCrMax;
    public short u16RCrMin;
    public short u16RepWinColor;
    public short u16ReportPixelInfo_Length;
    public short u16XEnd;
    public short u16XStart;
    public short u16YEnd;
    public short u16YStart;
    public long u32BCbSum;
    public long u32GYSum;
    public long u32RCrSum;
    public int u32ReportPixelInfo_Version;

    public enum EnumPixelRGBStage {
        PIXEL_STAGE_AFTER_DLC(1),
        PIXEL_STAGE_PRE_GAMMA(2),
        PIXEL_STAGE_AFTER_OSD(3),
        PIXEL_STAGE_MAX(MKeyEvent.KEYCODE_SLEEP);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumPixelRGBStage(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static EnumPixelRGBStage valueOf(int value) {
            switch (value) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    return PIXEL_STAGE_AFTER_DLC;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    return PIXEL_STAGE_PRE_GAMMA;
                case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                    return PIXEL_STAGE_AFTER_OSD;
                case MKeyEvent.KEYCODE_SLEEP /*255*/:
                    return PIXEL_STAGE_MAX;
                default:
                    return null;
            }
        }
    }
}
