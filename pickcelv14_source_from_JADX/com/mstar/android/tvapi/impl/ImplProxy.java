package com.mstar.android.tvapi.impl;

public class ImplProxy {
    protected static PlayerImpl getPlayerImplInstance(Object obj) {
        return PlayerImpl.getInstance(obj);
    }

    protected static ScanManagerImpl getScanManagerImplInstance(Object obj) {
        return ScanManagerImpl.getInstance(obj);
    }
}
