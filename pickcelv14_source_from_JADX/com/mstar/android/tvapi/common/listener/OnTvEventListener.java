package com.mstar.android.tvapi.common.listener;

public interface OnTvEventListener {
    boolean on4k2kHDMIDisableDualView(int i, int i2, int i3);

    boolean on4k2kHDMIDisablePip(int i, int i2, int i3);

    boolean on4k2kHDMIDisablePop(int i, int i2, int i3);

    boolean on4k2kHDMIDisableTravelingMode(int i, int i2, int i3);

    boolean onAtscPopupDialog(int i, int i2, int i3);

    boolean onDeadthEvent(int i, int i2, int i3);

    boolean onDtvReadyPopupDialog(int i, int i2, int i3);

    boolean onScartMuteOsdMode(int i);

    boolean onScreenSaverMode(int i, int i2, int i3);

    boolean onSignalLock(int i);

    boolean onSignalUnlock(int i);

    boolean onUnityEvent(int i, int i2, int i3);
}
