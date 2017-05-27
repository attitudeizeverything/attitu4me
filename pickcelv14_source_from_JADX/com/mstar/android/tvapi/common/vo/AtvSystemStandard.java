package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class AtvSystemStandard {
    private static Hashtable<Integer, Integer> htEnumAtvSystemStandard;

    public enum EnumAtvSystemStandard {
        E_BG(0),
        E_DK(4),
        E_I(3),
        E_L(9),
        E_M(10),
        E_M_BTSC(11),
        E_NUM(12);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumAtvSystemStandard(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            AtvSystemStandard.htEnumAtvSystemStandard.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) AtvSystemStandard.htEnumAtvSystemStandard.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumAtvSystemStandard = new Hashtable();
    }
}
