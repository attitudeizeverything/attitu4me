package com.mstar.android.tvapi.common.listener;

public interface OnPipEventListener {
    boolean on4k2kUnsupportPip(int i, int i2, int i3);

    boolean on4k2kUnsupportPop(int i, int i2, int i3);

    boolean on4k2kUnsupportTravelingMode(int i, int i2, int i3);

    boolean onEnablePip(int i, int i2, int i3);

    boolean onEnablePop(int i, int i2, int i3);

    boolean onRefreshPreviewModeWindow(int i, int i2, int i3);
}
