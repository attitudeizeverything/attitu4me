package com.mstar.android.tvapi.dtv.vo;

import com.mstar.android.MKeyEvent;
import com.mstar.android.tvapi.common.exception.TvOutOfBoundException;
import java.util.Hashtable;

public enum EnumEpgFunctionStatus {
    E_EPG_FUNC_STATUS_SUCCESS(0),
    E_EPG_FUNC_STATUS_INVALID(1),
    E_EPG_FUNC_STATUS_NO_EVENT(2),
    E_EPG_FUNC_STATUS_NO_STRING(3),
    E_EPG_FUNC_STATUS_NO_CHANNEL(4),
    E_EPG_FUNC_STATUS_CRID_NOT_FOUND(5),
    E_EPG_FUNC_STATUS_DB_NO_CONNECT(10),
    E_EPG_FUNC_STATUS_DB_NO_LOCK(11),
    E_EPG_FUNC_STATUS_DB_NO_CHANNEL_DB(12),
    E_EPG_FUNC_STATUS_NO_FUNCTION(MKeyEvent.KEYCODE_SLEEP);
    
    private static Hashtable<Integer, Integer> enumhash;
    private static int seq;
    private final int value;

    static {
        seq = 0;
        enumhash = new Hashtable();
    }

    private EnumEpgFunctionStatus(int value) {
        this.value = value;
        setHashtableValue(value);
    }

    private static void setHashtableValue(int value) {
        enumhash.put(new Integer(value), new Integer(seq));
        seq++;
    }

    public int getValue() {
        return this.value;
    }

    public static int getOrdinalThroughValue(int key) throws TvOutOfBoundException {
        Integer ordinal = (Integer) enumhash.get(Integer.valueOf(key));
        if (ordinal != null) {
            return ordinal.intValue();
        }
        throw new TvOutOfBoundException();
    }
}
