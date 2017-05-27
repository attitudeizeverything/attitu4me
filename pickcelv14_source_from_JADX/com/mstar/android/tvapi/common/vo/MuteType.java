package com.mstar.android.tvapi.common.vo;

import android.support.v4.media.TransportMediator;
import com.squareup.okhttp.internal.http.HttpTransport;
import java.util.Hashtable;
import jcifs.smb.SmbNamedPipe;

public class MuteType {
    private static Hashtable<Integer, Integer> htEnumMuteType;

    public enum EnumMuteType {
        E_MUTE_PERMANENT(1),
        E_MOMENT(2),
        E_BYUSER(4),
        E_BYSYNC(8),
        E_BYVCHIP(16),
        E_BYBLOCK(32),
        E_INTERNAL1(64),
        E_INTERNAL2(TransportMediator.FLAG_KEY_MEDIA_NEXT),
        E_INTERNAL3(SmbNamedPipe.PIPE_TYPE_CALL),
        E_DURING_LIMITED_TIME(SmbNamedPipe.PIPE_TYPE_TRANSACT),
        E_MHEGAP(HttpTransport.DEFAULT_CHUNK_LENGTH),
        E_CI(SmbConstants.FLAGS2_EXTENDED_SECURITY_NEGOTIATION),
        E_SCAN(SmbConstants.FLAGS2_RESOLVE_PATHS_IN_DFS),
        E_SOURCESWITCH(HTTPSession.BUFSIZE),
        E_USER_SPEAKER(SmbConstants.FLAGS2_STATUS32),
        E_USER_HP(SmbConstants.FLAGS2_UNICODE),
        E_USER_SPDIF(SmbConstants.DELETE),
        E_USER_SCART1(SmbConstants.READ_CONTROL),
        E_USER_SCART2(SmbConstants.WRITE_DAC),
        E_MUTE_ALL(SmbConstants.WRITE_OWNER),
        E_MUTE_USER_DATA_IN(SmbConstants.SYNCHRONIZE);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumMuteType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            MuteType.htEnumMuteType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) MuteType.htEnumMuteType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumMuteType = new Hashtable();
    }
}
