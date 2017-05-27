package com.mstar.android.dlna;

public interface MediaRendererDeviceListener {
    boolean OnGetDeviceCapabilities(int i);

    boolean OnGetMediaInfo(int i);

    boolean OnGetPositionInfo(int i);

    boolean OnGetProtocolInfo();

    boolean OnGetTransportInfo(int i);

    boolean OnGetTransportSettings(int i);

    boolean OnGetVolume(int i);

    boolean OnKeepAlive(int i);

    boolean OnNext(int i);

    boolean OnPause(int i);

    boolean OnPlay(int i, String str);

    boolean OnPrevious(int i);

    boolean OnRotateClockwise(int i);

    boolean OnRotateCounterClockwise(int i);

    boolean OnSeek(int i, SeekMode seekMode, String str);

    boolean OnSelectPreset(int i);

    boolean OnSetAVTransportURI(int i, String str, ShareObject shareObject);

    boolean OnSetNextAVTransportURI(int i, String str, ShareObject shareObject);

    boolean OnSetVolume(int i, VolumeInfo volumeInfo);

    boolean OnStop(int i);

    boolean OnZoomIn(int i);

    boolean OnZoomOut(int i);
}
