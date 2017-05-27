package com.mstar.android.dlna;

import java.util.ArrayList;

public interface MediaRendererDevice {
    DeviceInfo GetDeviceInfo();

    void SetDeviceCapabilities(int i, DeviceCapabilities deviceCapabilities);

    void SetDeviceInfo(DeviceInfo deviceInfo);

    void SetListener(MediaRendererDeviceListener mediaRendererDeviceListener);

    void SetMediaInfo(int i, MediaInfo mediaInfo);

    void SetPositionInfo(int i, PositionInfo positionInfo);

    void SetProtocolInfo(ArrayList<ProtocolInfo> arrayList);

    void SetTransportInfo(int i, TransportInfo transportInfo);

    void SetTransportSettings(int i, TransportSettings transportSettings);

    void SetVolume(int i, VolumeInfo volumeInfo);
}
