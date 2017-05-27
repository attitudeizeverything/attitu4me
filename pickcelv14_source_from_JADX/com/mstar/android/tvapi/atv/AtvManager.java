package com.mstar.android.tvapi.atv;

import com.mstar.android.tvapi.common.TvManager;

public final class AtvManager extends TvManager {
    public static AtvPlayer getAtvPlayerManager() {
        return new AtvPlayerImplProxy().getPlayerImplInstance();
    }

    public static AtvScanManager getAtvScanManager() {
        return new AtvScanImplProxy().getScanImplInstance();
    }
}
