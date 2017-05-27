package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.factory.FactoryManager;

public class TvFactoryManagerProxy extends FactoryManager {
    protected FactoryManager getFactoryManagerInstance() {
        return FactoryManager.getInstance(this);
    }
}
