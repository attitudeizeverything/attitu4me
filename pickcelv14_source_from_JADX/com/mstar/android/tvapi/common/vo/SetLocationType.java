package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class SetLocationType {
    private static Hashtable<Integer, Integer> htEnumSetLocationType;

    public enum EnumSetLocationType {
        E_SET_LOCATION_BEFORE_GAMMA(1),
        E_SET_LOCATION_AFTER_GAMMA(2),
        E_SET_LOCATION_AFTER_MEMORY(3),
        E_SET_LOCATION_AFTER_DLC(4);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumSetLocationType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            SetLocationType.htEnumSetLocationType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) SetLocationType.htEnumSetLocationType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumSetLocationType = new Hashtable();
    }
}
