package com.mstar.android.tvapi.dtv.common;

import com.mstar.android.tvapi.common.ScanManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbTargetRegionInfo;
import com.mstar.android.tvapi.dtv.vo.DtvNetworkRegionInfo;
import com.mstar.android.tvapi.dtv.vo.EnumRfChannelBandwidth;

public interface DtvScanManager extends ScanManager {
    DvbTargetRegionInfo getRegionInfo() throws TvCommonException;

    DtvNetworkRegionInfo getRegionNetworks() throws TvCommonException;

    boolean pauseScan() throws TvCommonException;

    boolean resumeScan() throws TvCommonException;

    boolean setBandwidth(EnumRfChannelBandwidth enumRfChannelBandwidth) throws TvCommonException;

    void startAutoScan() throws TvCommonException;

    void startAutoUpdateScan() throws TvCommonException;

    boolean startFullScan() throws TvCommonException;

    boolean startManualScan() throws TvCommonException;

    void startStandbyScan() throws TvCommonException;

    boolean stopScan() throws TvCommonException;
}
