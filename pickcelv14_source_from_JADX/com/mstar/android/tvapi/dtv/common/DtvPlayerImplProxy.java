package com.mstar.android.tvapi.dtv.common;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.PlayerImpl;

public class DtvPlayerImplProxy extends ImplProxy {
    protected PlayerImpl getPlayerImplInstance() {
        return ImplProxy.getPlayerImplInstance(this);
    }
}
