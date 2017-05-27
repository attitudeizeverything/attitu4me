package com.mstar.android.tvapi.common.listener;

import com.mstar.android.tvapi.common.vo.HbbtvEventInfo;

public interface OnTvPlayerEventListener {
    boolean on4k2kHDMIDisableDualView(int i, int i2, int i3);

    boolean on4k2kHDMIDisablePip(int i, int i2, int i3);

    boolean on4k2kHDMIDisablePop(int i, int i2, int i3);

    boolean on4k2kHDMIDisableTravelingMode(int i, int i2, int i3);

    boolean onDtvChannelInfoUpdate(int i, int i2, int i3);

    boolean onDtvPsipTsUpdate(int i, int i2, int i3);

    boolean onEmerencyAlert(int i, int i2, int i3);

    boolean onEpgUpdateList(int i, int i2);

    boolean onHbbtvUiEvent(int i, HbbtvEventInfo hbbtvEventInfo);

    boolean onPopupDialog(int i, int i2, int i3);

    boolean onPvrNotifyAlwaysTimeShiftProgramNotReady(int i);

    boolean onPvrNotifyAlwaysTimeShiftProgramReady(int i);

    boolean onPvrNotifyCiPlusProtection(int i);

    boolean onPvrNotifyCiPlusRetentionLimitUpdate(int i, int i2);

    boolean onPvrNotifyOverRun(int i);

    boolean onPvrNotifyParentalControl(int i, int i2);

    boolean onPvrNotifyPlaybackBegin(int i);

    boolean onPvrNotifyPlaybackSpeedChange(int i);

    boolean onPvrNotifyPlaybackStop(int i);

    boolean onPvrNotifyPlaybackTime(int i, int i2);

    boolean onPvrNotifyRecordSize(int i, int i2);

    boolean onPvrNotifyRecordStop(int i);

    boolean onPvrNotifyRecordTime(int i, int i2);

    boolean onPvrNotifyTimeShiftOverwritesAfter(int i, int i2);

    boolean onPvrNotifyTimeShiftOverwritesBefore(int i, int i2);

    boolean onPvrNotifyUsbRemoved(int i, int i2);

    boolean onScreenSaverMode(int i, int i2);

    boolean onSignalLock(int i);

    boolean onSignalUnLock(int i);

    boolean onTvProgramInfoReady(int i);
}
