package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class NoiseReduction {
    private static Hashtable<Integer, Integer> htEnumNoiseReduction;

    public enum EnumNoiseReduction {
        E_NR_MIN(0),
        E_NR_OFF(E_NR_MIN.getValue()),
        E_NR_LOW(1),
        E_NR_MIDDLE(2),
        E_NR_HIGH(3),
        E_NR_AUTO(4),
        E_NR_NUM(5);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumNoiseReduction(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            NoiseReduction.htEnumNoiseReduction.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) NoiseReduction.htEnumNoiseReduction.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumNoiseReduction = new Hashtable();
    }
}
