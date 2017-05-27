package com.mstar.android.tvapi.atv.listener;

import com.mstar.android.tvapi.atv.vo.AtvEventScan;

public interface OnAtvPlayerEventListener {
    boolean onAtvAutoTuningScanInfo(int i, AtvEventScan atvEventScan);

    boolean onAtvManualTuningScanInfo(int i, AtvEventScan atvEventScan);

    boolean onAtvProgramInfoReady(int i);

    boolean onSignalLock(int i);

    boolean onSignalUnLock(int i);
}
