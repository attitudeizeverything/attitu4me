package com.mstar.android.tvapi.dtv.common;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.ScanManagerImpl;

public class DtvScanImplProxy extends ImplProxy {
    protected ScanManagerImpl getScanImplInstance() {
        return ImplProxy.getScanManagerImplInstance(this);
    }
}
