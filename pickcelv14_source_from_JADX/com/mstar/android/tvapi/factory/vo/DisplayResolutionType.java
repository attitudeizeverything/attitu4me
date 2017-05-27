package com.mstar.android.tvapi.factory.vo;

import java.util.Hashtable;

public class DisplayResolutionType {
    private static Hashtable<Integer, Integer> enumhash;

    public enum EnumDisplayResolutionType {
        E_DISPLAY_RES_MIN(0),
        E_DISPLAY_SEC32_LE32A_FULLHD(E_DISPLAY_RES_MIN.getValue()),
        E_DISPLAY_RES_SXGA(1),
        E_DISPLAY_RES_WXGA(2),
        E_DISPLAY_RES_WXGA_PLUS(3),
        E_DISPLAY_RES_WSXGA(4),
        E_DISPLAY_RES_FULL_HD(5),
        E_DISPLAY_DACOUT_PAL_MIN(6),
        E_DISPLAY_DACOUT_576I(E_DISPLAY_DACOUT_PAL_MIN.getValue()),
        E_DISPLAY_DACOUT_576P(7),
        E_DISPLAY_DACOUT_720P_50(8),
        E_DISPLAY_DACOUT_1080P_24(9),
        E_DISPLAY_DACOUT_1080P_25(10),
        E_DISPLAY_DACOUT_1080I_50(11),
        E_DISPLAY_DACOUT_1080P_50(12),
        E_DISPLAY_DACOUT_PAL_MAX(E_DISPLAY_DACOUT_1080P_50.getValue()),
        E_DISPLAY_DACOUT_NTSC_MIN(13),
        E_DISPLAY_DACOUT_480I(E_DISPLAY_DACOUT_NTSC_MIN.getValue()),
        E_DISPLAY_DACOUT_480P(14),
        E_DISPLAY_DACOUT_720P_60(15),
        E_DISPLAY_DACOUT_1080P_30(16),
        E_DISPLAY_DACOUT_1080I_60(17),
        E_DISPLAY_DACOUT_1080P_60(18),
        E_DISPLAY_DACOUT_NTSC_MAX(E_DISPLAY_DACOUT_1080P_60.getValue()),
        E_DISPLAY_DACOUT_AUTO(19),
        E_DISPLAY_CMO_CMO260J2_WUXGA(20),
        E_DISPLAY_VGAOUT_60_MIN(64),
        E_DISPLAY_VGAOUT_640x480P_60(E_DISPLAY_VGAOUT_60_MIN.getValue()),
        E_DISPLAY_VGAOUT_60_MAX(E_DISPLAY_VGAOUT_640x480P_60.getValue()),
        E_DISPLAY_TTLOUT_60_MIN(192),
        E_DISPLAY_TTLOUT_480X272_60(E_DISPLAY_TTLOUT_60_MIN.getValue()),
        E_DISPLAY_TTLOUT_60_MAX(E_DISPLAY_TTLOUT_480X272_60.getValue()),
        E_DISPLAY_RES_MAX_NUM(193);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumDisplayResolutionType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            DisplayResolutionType.enumhash.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) DisplayResolutionType.enumhash.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        enumhash = new Hashtable();
    }
}
