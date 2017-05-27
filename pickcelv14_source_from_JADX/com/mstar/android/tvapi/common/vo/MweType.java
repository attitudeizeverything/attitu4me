package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class MweType {
    private static Hashtable<Integer, Integer> htEnumMweType;

    public enum EnumMweType {
        E_OFF(0),
        E_OPTIMIZE(1),
        E_ENHANCE(2),
        E_SIDE_BY_SIDE(3),
        E_DYNAMICCOMPARE(4),
        E_CENTERBASEDSCALE(5),
        E_MOVEALONG(6),
        E_GOLDENEYES(7),
        E_TRUE_COLOR_ANALYSIS_ASCENSION(8),
        E_LED_BACKLIGHT_CONTROL(9),
        E_HIGH_SPEED_MOVEMENT_PROCESSING(10),
        E_SQUAREMOVE(11),
        E_EN_MS_MWE_CUSTOMER1(12),
        E_EN_MS_MWE_CUSTOMER2(13),
        E_EN_MS_MWE_CUSTOMER3(14),
        E_EN_MS_MWE_CUSTOMER4(15),
        E_EN_MS_MWE_CUSTOMER5(16),
        E_EN_MS_MWE_CUSTOMER6(17),
        E_EN_MS_MWE_CUSTOMER7(18),
        E_EN_MS_MWE_CUSTOMER8(19),
        E_DEFAULT(E_OPTIMIZE.getValue()),
        E_NUM(21);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumMweType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            MweType.htEnumMweType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) MweType.htEnumMweType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumMweType = new Hashtable();
    }
}
