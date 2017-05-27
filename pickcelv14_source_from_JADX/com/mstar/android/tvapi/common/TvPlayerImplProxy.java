package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.PlayerImpl;

public class TvPlayerImplProxy extends ImplProxy {
    protected PlayerImpl getPlayerImplInstance() {
        return ImplProxy.getPlayerImplInstance(this);
    }
}
