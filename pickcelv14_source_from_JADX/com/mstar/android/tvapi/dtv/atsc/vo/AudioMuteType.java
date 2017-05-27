package com.mstar.android.tvapi.dtv.atsc.vo;

import android.support.v4.media.TransportMediator;
import com.mstar.android.MKeyEvent;
import java.util.Hashtable;
import jcifs.netbios.NbtException;
import jcifs.netbios.SessionServicePacket;
import jcifs.smb.SmbNamedPipe;

public class AudioMuteType {
    public static Hashtable<Integer, Integer> htAudioMuteType;

    public enum EnumAudioMuteType {
        E_AUDIO_PERMANENT_MUTEOFF_(0),
        E_AUDIO_PERMANENT_MUTEON_(1),
        E_AUDIO_MOMENT_MUTEOFF_(16),
        E_AUDIO_MOMENT_MUTEON_(17),
        E_AUDIO_BYUSER_MUTEOFF_(32),
        E_AUDIO_BYUSER_MUTEON_(33),
        E_AUDIO_BYSYNC_MUTEOFF_(48),
        E_AUDIO_BYSYNC_MUTEON_(49),
        E_AUDIO_BYVCHIP_MUTEOFF_(64),
        E_AUDIO_BYVCHIP_MUTEON_(65),
        E_AUDIO_BYBLOCK_MUTEOFF_(80),
        E_AUDIO_BYBLOCK_MUTEON_(81),
        E_AUDIO_INTERNAL_1_MUTEOFF_(96),
        E_AUDIO_INTERNAL_1_MUTEON_(97),
        E_AUDIO_SIGNAL_UNSTABLE_MUTEOFF_(112),
        E_AUDIO_SIGNAL_UNSTABLE_MUTEON_(113),
        E_AUDIO_INTERNAL_3_MUTEOFF_(TransportMediator.FLAG_KEY_MEDIA_NEXT),
        E_AUDIO_INTERNAL_3_MUTEON_(NbtException.NOT_LISTENING_CALLING),
        E_AUDIO_INTERNAL_4_MUTEOFF_(TransportMediator.KEYCODE_MEDIA_RECORD),
        E_AUDIO_INTERNAL_4_MUTEON_(SessionServicePacket.NEGATIVE_SESSION_RESPONSE),
        E_AUDIO_DURING_LIMITED_TIME_MUTEOFF_(144),
        E_AUDIO_DURING_LIMITED_TIME_MUTEON_(145),
        E_AUDIO_MHEGAP_MUTEOFF_(160),
        E_AUDIO_MHEGAP_MUTEON_(161),
        E_AUDIO_CI_MUTEOFF_(176),
        E_AUDIO_CI_MUTEON_(177),
        E_AUDIO_SCAN_MUTEOFF_(192),
        E_AUDIO_SCAN_MUTEON_(193),
        E_AUDIO_SOURCESWITCH_MUTEOFF_(208),
        E_AUDIO_SOURCESWITCH_MUTEON_(209),
        E_AUDIO_USER_SPEAKER_MUTEOFF_(224),
        E_AUDIO_USER_SPEAKER_MUTEON_(225),
        E_AUDIO_USER_HP_MUTEOFF_(240),
        E_AUDIO_USER_HP_MUTEON_(241),
        E_AUDIO_USER_SPDIF_MUTEOFF_(SmbNamedPipe.PIPE_TYPE_CALL),
        E_AUDIO_USER_SPDIF_MUTEON_(MKeyEvent.KEYCODE_LIST),
        E_AUDIO_USER_SCART1_MUTEOFF_(MKeyEvent.KEYCODE_GINGA_BACK),
        E_AUDIO_USER_SCART1_MUTEON_(273),
        E_AUDIO_USER_SCART2_MUTEOFF_(288),
        E_AUDIO_USER_SCART2_MUTEON_(289),
        E_AUDIO_ALL_MUTEOFF_(MKeyEvent.KEYCODE_MSTAR_UPDATE),
        E_AUDIO_ALL_MUTEON_(MKeyEvent.KEYCODE_MSTAR_REVEAL),
        E_AUDIO_DATA_IN_MUTEOFF_(320),
        E_AUDIO_DATA_IN_MUTEON_(321),
        E_AUDIO_POWERON_MUTEOFF_(336),
        E_AUDIO_POWERON_MUTEON_(337);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumAudioMuteType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            AudioMuteType.htAudioMuteType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) AudioMuteType.htAudioMuteType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htAudioMuteType = new Hashtable();
    }
}
