package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class MpegNoiseReduction {
    private static Hashtable<Integer, Integer> htEnumMpegNoiseReduction;

    public enum EnumMpegNoiseReduction {
        E_MPEG_NR_MIN(0),
        E_MPEG_NR_OFF(E_MPEG_NR_MIN.getValue()),
        E_MPEG_NR_LOW(1),
        E_MPEG_NR_MIDDLE(2),
        E_MPEG_NR_HIGH(3),
        E_MPEG_NR_NUM(4);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumMpegNoiseReduction(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            MpegNoiseReduction.htEnumMpegNoiseReduction.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) MpegNoiseReduction.htEnumMpegNoiseReduction.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumMpegNoiseReduction = new Hashtable();
    }
}
