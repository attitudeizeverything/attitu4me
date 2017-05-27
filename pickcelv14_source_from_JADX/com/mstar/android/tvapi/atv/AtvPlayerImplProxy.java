package com.mstar.android.tvapi.atv;

import com.mstar.android.tvapi.impl.ImplProxy;
import com.mstar.android.tvapi.impl.PlayerImpl;

public final class AtvPlayerImplProxy extends ImplProxy {
    protected PlayerImpl getPlayerImplInstance() {
        return ImplProxy.getPlayerImplInstance(this);
    }
}
