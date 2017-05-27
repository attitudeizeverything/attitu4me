package com.mstar.android.tvapi.dtv.common;

import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.atsc.AtscPlayer;
import com.mstar.android.tvapi.dtv.dvb.DvbPlayer;
import com.mstar.android.tvapi.dtv.dvb.dvbc.DvbcScanManager;
import com.mstar.android.tvapi.dtv.dvb.dvbt.DvbtScanManager;

public final class DtvManager extends TvManager {
    public static DvbPlayer getDvbPlayerManager() {
        System.out.println("-----DvbPlayer------");
        return new DtvPlayerImplProxy().getPlayerImplInstance();
    }

    public static DtvScanManager getDtvScanManager() {
        return new DtvScanImplProxy().getScanImplInstance();
    }

    public static DvbcScanManager getDvbcScanManager() {
        return new DtvScanImplProxy().getScanImplInstance();
    }

    public static DvbtScanManager getDvbtScanManager() {
        return new DtvScanImplProxy().getScanImplInstance();
    }

    public static CiManager getCiManager() throws TvCommonException {
        return CiManager.getInstance();
    }

    public static EpgManager getEpgManager() throws TvCommonException {
        return EpgManager.getInstance();
    }

    public static OadManager getOadManager() throws TvCommonException {
        return OadManager.getInstance();
    }

    public static SubtitleManager getSubtitleManager() throws TvCommonException {
        return SubtitleManager.getInstance();
    }

    public static AtscPlayer getAtscPlayerManager() {
        System.out.println("-----AtscPlayer------");
        return new DtvPlayerImplProxy().getPlayerImplInstance();
    }
}
