package com.mstar.android.tvapi.dtv.vo;

import com.mstar.android.tvapi.common.vo.TvOsType;
import java.util.Hashtable;

public class DtvType extends TvOsType {
    private static Hashtable<Integer, Integer> enumhash;

    public enum EnumAspectRatioCode {
        E_FORBIDDEN,
        E_ASP_1TO1,
        E_ASP_4TO3,
        E_ASP_16TO9,
        E_ASP_221TO100,
        E_ASP_MAXNUM
    }

    public enum EnumDtvSetAudioMode {
        E_DTV_SET_AUDIO_LR,
        E_DTV_SET_AUDIO_LL,
        E_DTV_SET_AUDIO_RR
    }

    public enum EnumDtvVideoQuality {
        UNDEFINED,
        SD,
        HD
    }

    public enum EnumEpgDescriptionType {
        E_SHORT_DESCRIPTION,
        E_DETAIL_DESCRIPTION,
        E_GUIDANCE_DESCRIPTION,
        E_NONE_DESCRIPTION,
        E_DESCRIPTION_MAX
    }

    public enum EnumEpgMainGenreType {
        UNCLASSIFIED(0),
        MOVIE(1),
        NEWS(2),
        SHOW(3),
        SPORT(4),
        CHILDREN(5),
        MUSIC(6),
        ARTS(7),
        SOCIAL(8),
        EDUCATION(9),
        LEISURE(10),
        SPECIAL(11),
        RESERVED1(12),
        RESERVED2(13),
        RESERVED3(14),
        USER_DEFINED(15),
        MIN(UNCLASSIFIED.getValue()),
        MAX(USER_DEFINED.getValue()),
        SIZE(MAX.getValue() + 1),
        INVALID(MAX.getValue() + 1);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumEpgMainGenreType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            DtvType.enumhash.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) DtvType.enumhash.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    public enum EnumSubtitlingType {
        E_SUBTITLING_TYPE_TELETEXT(1),
        E_SUBTITLING_TYPE_TELETEXT_HOH(2),
        E_SUBTITLING_TYPE_NORMAL_NO(16),
        E_SUBTITLING_TYPE_NORMAL_4X3(17),
        E_SUBTITLING_TYPE_NORMAL_16X9(18),
        E_SUBTITLING_TYPE_NORMAL_221X100(19),
        E_SUBTITLING_TYPE_NORMAL_HD(20),
        E_SUBTITLING_TYPE_HH_NO(32),
        E_SUBTITLING_TYPE_HH_4X3(33),
        E_SUBTITLING_TYPE_HH_16X9(34),
        E_SUBTITLING_TYPE_HH_221X100(35),
        E_SUBTITLING_TYPE_HH_HD(36);
        
        private final int value;

        private EnumSubtitlingType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        enumhash = new Hashtable();
    }
}
