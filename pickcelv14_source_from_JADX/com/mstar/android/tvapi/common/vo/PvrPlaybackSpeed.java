package com.mstar.android.tvapi.common.vo;

import android.support.v4.internal.view.SupportMenu;
import com.mstar.android.media.MMediaPlayer;
import java.util.Hashtable;

public class PvrPlaybackSpeed {
    private static Hashtable<Integer, Integer> mHtEnumPvrPlaybackSpeed;

    public enum EnumPvrPlaybackSpeed {
        E_PVR_PLAYBACK_SPEED_32XFB(-32000),
        E_PVR_PLAYBACK_SPEED_16XFB(-16000),
        E_PVR_PLAYBACK_SPEED_8XFB(-8000),
        E_PVR_PLAYBACK_SPEED_4XFB(-4000),
        E_PVR_PLAYBACK_SPEED_2XFB(-2000),
        E_PVR_PLAYBACK_SPEED_1XFB(-1000),
        E_PVR_PLAYBACK_SPEED_0X(0),
        E_PVR_PLAYBACK_SPEED_STEP_IN(1),
        E_PVR_PLAYBACK_SPEED_FF_1_32X(32),
        E_PVR_PLAYBACK_SPEED_FF_1_16X(64),
        E_PVR_PLAYBACK_SPEED_FF_1_8X(125),
        E_PVR_PLAYBACK_SPEED_FF_1_4X(SmbConstants.DEFAULT_SSN_LIMIT),
        E_PVR_PLAYBACK_SPEED_FF_1_2X(500),
        E_PVR_PLAYBACK_SPEED_1X(MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA),
        E_PVR_PLAYBACK_SPEED_2XFF(2000),
        E_PVR_PLAYBACK_SPEED_4XFF(4000),
        E_PVR_PLAYBACK_SPEED_8XFF(8000),
        E_PVR_PLAYBACK_SPEED_16XFF(16000),
        E_PVR_PLAYBACK_SPEED_32XFF(32000),
        E_PVR_PLAYBACK_SPEED_INVALID(SupportMenu.USER_MASK);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumPvrPlaybackSpeed(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            PvrPlaybackSpeed.mHtEnumPvrPlaybackSpeed.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) PvrPlaybackSpeed.mHtEnumPvrPlaybackSpeed.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        mHtEnumPvrPlaybackSpeed = new Hashtable();
    }
}
