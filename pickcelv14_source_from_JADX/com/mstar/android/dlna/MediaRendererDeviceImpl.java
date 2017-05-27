package com.mstar.android.dlna;

import java.util.ArrayList;

/* compiled from: DLNAImpl */
class MediaRendererDeviceImpl implements MediaRendererDevice {
    private native synchronized DeviceInfo JNI_DMR_GetDeviceInfo();

    private native synchronized void JNI_DMR_SetDeviceCapabilities(int i, DeviceCapabilities deviceCapabilities);

    private native synchronized void JNI_DMR_SetDeviceInfo(DeviceInfo deviceInfo);

    private native synchronized void JNI_DMR_SetListener(MediaRendererDeviceListener mediaRendererDeviceListener);

    private native synchronized void JNI_DMR_SetMediaInfo(int i, MediaInfo mediaInfo);

    private native synchronized void JNI_DMR_SetPositionInfo(int i, PositionInfo positionInfo);

    private native synchronized void JNI_DMR_SetProtocolInfo(ArrayList<ProtocolInfo> arrayList);

    private native synchronized void JNI_DMR_SetTransportInfo(int i, TransportInfo transportInfo);

    private native synchronized void JNI_DMR_SetTransportSettings(int i, TransportSettings transportSettings);

    private native synchronized void JNI_DMR_SetVolume(int i, VolumeInfo volumeInfo);

    MediaRendererDeviceImpl() {
    }

    public void SetListener(MediaRendererDeviceListener listener) {
        JNI_DMR_SetListener(listener);
    }

    public void SetProtocolInfo(ArrayList<ProtocolInfo> protocol_info) {
        JNI_DMR_SetProtocolInfo(protocol_info);
    }

    public void SetMediaInfo(int instance_id, MediaInfo media_info) {
        JNI_DMR_SetMediaInfo(instance_id, media_info);
    }

    public void SetTransportInfo(int instance_id, TransportInfo transport_info) {
        JNI_DMR_SetTransportInfo(instance_id, transport_info);
    }

    public void SetPositionInfo(int instance_id, PositionInfo position_info) {
        JNI_DMR_SetPositionInfo(instance_id, position_info);
    }

    public void SetDeviceCapabilities(int instance_id, DeviceCapabilities device_capabilities) {
        JNI_DMR_SetDeviceCapabilities(instance_id, device_capabilities);
    }

    public void SetTransportSettings(int instance_id, TransportSettings transport_settings) {
        JNI_DMR_SetTransportSettings(instance_id, transport_settings);
    }

    public void SetVolume(int instance_id, VolumeInfo volume_info) {
        JNI_DMR_SetVolume(instance_id, volume_info);
    }

    public DeviceInfo GetDeviceInfo() {
        return JNI_DMR_GetDeviceInfo();
    }

    public void SetDeviceInfo(DeviceInfo device_info) {
        JNI_DMR_SetDeviceInfo(device_info);
    }
}
