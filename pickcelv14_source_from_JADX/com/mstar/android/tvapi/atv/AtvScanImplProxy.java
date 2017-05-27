package com.mstar.android.tvapi.atv;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.ScanManagerImpl;

public final class AtvScanImplProxy extends ImplProxy {
    protected ScanManagerImpl getScanImplInstance() {
        return ImplProxy.getScanManagerImplInstance(this);
    }
}
