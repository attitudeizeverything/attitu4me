package com.mstar.android.tvapi.common.vo;

import android.support.v4.media.TransportMediator;
import java.util.Hashtable;
import jcifs.netbios.NbtException;
import jcifs.netbios.SessionServicePacket;

public class KtvInfoType {
    private static Hashtable<Integer, Integer> htEnumKtvInfoType;

    public enum EnumKtvInfoType {
        E_KTV_SETINFO_MODEL(0),
        E_KTV_SETINFO_ADC_GAIN(1),
        E_KTV_SETINFO_DEC_MUTE(2),
        E_KTV_SETINFO_DEC_PLAY_WO_OUT(3),
        E_KTV_SETINFO_ADC1_GAIN(4),
        E_KTV_SETINFO_MIC_SOUNDMODE(5),
        E_KTV_SETINFO_BG_MUSIC_SOUNDMODE(6),
        E_KTV_SETNFO_END(63),
        E_KTV_PARAM_TYPE1(TransportMediator.FLAG_KEY_MEDIA_NEXT),
        E_KTV_PARAM_TYPE2(NbtException.NOT_LISTENING_CALLING),
        E_KTV_PARAM_TYPE3(TransportMediator.KEYCODE_MEDIA_RECORD),
        E_KTV_PARAM_TYPE4(SessionServicePacket.NEGATIVE_SESSION_RESPONSE),
        E_KTV_PARAM_TYPE5(132),
        E_KTV_PARAM_TYPE6(133),
        E_KTV_PARAM_TYPE7(134),
        E_KTV_PARAM_TYPE8(135),
        E_KTV_PARAM_TYPE9(136),
        E_KTV_PARAM_TYPE10(137),
        E_KTV_PARAM_TYPE11(138),
        E_KTV_PARAM_TYPE12(139),
        E_KTV_PARAM_TYPE13(140),
        E_KTV_PARAM_TYPE14(142),
        E_KTV_PARAM_TYPE15(NbtException.UNSPECIFIED),
        E_KTV_PARAM_TYPE16(144);
        
        private static int seq;
        private final int value;

        private EnumKtvInfoType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            KtvInfoType.htEnumKtvInfoType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) KtvInfoType.htEnumKtvInfoType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumKtvInfoType = new Hashtable();
    }
}
