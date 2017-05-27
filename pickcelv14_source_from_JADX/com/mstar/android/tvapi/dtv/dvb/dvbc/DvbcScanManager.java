package com.mstar.android.tvapi.dtv.dvb.dvbc;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumCableOperator;
import com.mstar.android.tvapi.dtv.common.DtvScanManager;
import com.mstar.android.tvapi.dtv.dvb.dvbc.vo.EnumCabConstelType;

public interface DvbcScanManager extends DtvScanManager {
    int getDefaultHomingChannelFrequency() throws TvCommonException;

    int getDefaultNetworkId() throws TvCommonException;

    void setCableOperator(EnumCableOperator enumCableOperator) throws TvCommonException;

    boolean setScanParam(short s, EnumCabConstelType enumCabConstelType, int i, int i2, short s2, boolean z) throws TvCommonException;

    boolean startQuickScan() throws TvCommonException;
}
