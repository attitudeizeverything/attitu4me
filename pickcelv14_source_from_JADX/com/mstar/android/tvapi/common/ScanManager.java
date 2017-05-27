package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.common.exception.TvCommonException;

public interface ScanManager {
    boolean getSmartScanMode() throws TvCommonException;

    boolean isScanning() throws TvCommonException;

    void release() throws Throwable;

    void setSmartScanMode(boolean z) throws TvCommonException;
}
