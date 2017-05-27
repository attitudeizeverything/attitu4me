package com.mstar.android.tvapi.common.vo;

import com.mstar.android.MKeyEvent;
import java.util.Hashtable;

public class PvrUsbDeviceLabel {
    private static Hashtable<Integer, Integer> mHtEnumPvrUsbDeviceLabel;

    public enum EnumPvrUsbDeviceLabel {
        E_LABEL_0(0),
        E_LABEL_1(1),
        E_LABEL_2(2),
        E_LABEL_3(3),
        E_LABEL_MAX(4),
        E_LABEL_CURRENT(MKeyEvent.KEYCODE_CHANNEL_RETURN),
        E_LABEL_UNKNOWN(MKeyEvent.KEYCODE_SLEEP);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumPvrUsbDeviceLabel(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            PvrUsbDeviceLabel.mHtEnumPvrUsbDeviceLabel.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) PvrUsbDeviceLabel.mHtEnumPvrUsbDeviceLabel.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        mHtEnumPvrUsbDeviceLabel = new Hashtable();
    }
}
