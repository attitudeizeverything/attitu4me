package com.mstar.android.tvapi.dtv.listener;

import com.mstar.android.tvapi.dtv.vo.DtvEventScan;

public interface OnDtvPlayerEventListener {
    boolean onAudioModeChange(int i, boolean z);

    boolean onChangeTtxStatus(int i, boolean z);

    boolean onCiLoadCredentialFail(int i);

    boolean onDtvAutoTuningScanInfo(int i, DtvEventScan dtvEventScan);

    boolean onDtvAutoUpdateScan(int i);

    boolean onDtvChannelNameReady(int i);

    boolean onDtvPriComponentMissing(int i);

    boolean onDtvProgramInfoReady(int i);

    boolean onEpgTimerSimulcast(int i, int i2);

    boolean onGingaStatusMode(int i, boolean z);

    boolean onHbbtvStatusMode(int i, boolean z);

    boolean onMheg5EventHandler(int i, int i2);

    boolean onMheg5ReturnKey(int i, int i2);

    boolean onMheg5StatusMode(int i, int i2);

    boolean onOadDownload(int i, int i2);

    boolean onOadHandler(int i, int i2, int i3);

    boolean onOadTimeout(int i, int i2);

    boolean onPopupScanDialogFrequencyChange(int i);

    boolean onPopupScanDialogLossSignal(int i);

    boolean onPopupScanDialogNewMultiplex(int i);

    boolean onRctPresence(int i);

    boolean onSignalLock(int i);

    boolean onSignalUnLock(int i);

    boolean onTsChange(int i);

    boolean onUiOPExitServiceList(int i);

    boolean onUiOPRefreshQuery(int i);

    boolean onUiOPServiceList(int i);
}
