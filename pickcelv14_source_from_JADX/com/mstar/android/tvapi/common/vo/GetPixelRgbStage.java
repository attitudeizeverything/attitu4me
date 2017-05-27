package com.mstar.android.tvapi.common.vo;

import com.mstar.android.MKeyEvent;
import java.util.Hashtable;

public class GetPixelRgbStage {
    private static Hashtable<Integer, Integer> htEnumGetPixelRgbStage;

    public enum EnumGetPixelRgbStage {
        E_GET_PIXEL_STAGE_AFTER_DLC(1),
        E_GET_PIXEL_STAGE_PRE_GAMMA(2),
        E_GET_PIXEL_STAGE_AFTER_OSD(3),
        E_GET_PIXEL_STAGE_MAX(MKeyEvent.KEYCODE_SLEEP);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumGetPixelRgbStage(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            GetPixelRgbStage.htEnumGetPixelRgbStage.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) GetPixelRgbStage.htEnumGetPixelRgbStage.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumGetPixelRgbStage = new Hashtable();
    }
}
