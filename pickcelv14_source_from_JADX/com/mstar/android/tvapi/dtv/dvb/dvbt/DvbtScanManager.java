package com.mstar.android.tvapi.dtv.dvb.dvbt;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.common.DtvScanManager;

public interface DvbtScanManager extends DtvScanManager {
    boolean resolveConflictLcn() throws TvCommonException;

    boolean setRegion(String str, short s, short s2, int i) throws TvCommonException;
}
