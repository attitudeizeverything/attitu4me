package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.ScanManagerImpl;

public class TvScanImplProxy extends ImplProxy {
    protected ScanManagerImpl getScanImplInstance() {
        return ImplProxy.getScanManagerImplInstance(this);
    }
}
