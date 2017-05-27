package com.mstar.android.tvapi.common.vo;

import com.mstar.android.tvapi.common.vo.MpegNoiseReduction.EnumMpegNoiseReduction;
import java.util.Hashtable;

public class Film {
    private static Hashtable<Integer, Integer> htEnumFilm;

    public enum EnumFilm {
        E_MIN(0),
        E_OFF(EnumMpegNoiseReduction.E_MPEG_NR_MIN.ordinal()),
        E_ON(EnumMpegNoiseReduction.E_MPEG_NR_MIN.ordinal() + 1),
        E_NUM(EnumMpegNoiseReduction.E_MPEG_NR_MIN.ordinal() + 2);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumFilm(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            Film.htEnumFilm.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) Film.htEnumFilm.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumFilm = new Hashtable();
    }
}
