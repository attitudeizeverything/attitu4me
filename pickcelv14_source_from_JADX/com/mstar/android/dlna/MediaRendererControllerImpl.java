package com.mstar.android.dlna;

import java.util.ArrayList;

/* compiled from: DLNAImpl */
class MediaRendererControllerImpl implements MediaRendererController {
    private int handle;

    private native synchronized DeviceCapabilities JNI_DMRC_GetDeviceCapabilities(int i);

    private native synchronized DeviceInfo JNI_DMRC_GetDeviceInfo();

    private native synchronized MediaInfo JNI_DMRC_GetMediaInfo(int i);

    private native synchronized PositionInfo JNI_DMRC_GetPositionInfo(int i);

    private native synchronized ArrayList<ProtocolInfo> JNI_DMRC_GetProtocolInfo();

    private native synchronized TransportInfo JNI_DMRC_GetTransportInfo(int i);

    private native synchronized TransportSettings JNI_DMRC_GetTransportSettings(int i);

    private native synchronized int JNI_DMRC_GetVolume(int i, Channel channel);

    private native synchronized void JNI_DMRC_Next(int i);

    private native synchronized void JNI_DMRC_Pause(int i);

    private native synchronized void JNI_DMRC_Play(int i, String str);

    private native synchronized void JNI_DMRC_Previous(int i);

    private native synchronized void JNI_DMRC_RotateClockwise(int i);

    private native synchronized void JNI_DMRC_RotateCounterClockwise(int i);

    private native synchronized void JNI_DMRC_Seek(int i, SeekMode seekMode, String str);

    private native synchronized void JNI_DMRC_SetAVTransportURI(int i, String str, String str2);

    private native synchronized void JNI_DMRC_SetVolume(int i, VolumeInfo volumeInfo);

    private native synchronized void JNI_DMRC_Stop(int i);

    private native synchronized void JNI_DMRC_ZoomIn(int i);

    private native synchronized void JNI_DMRC_ZoomOut(int i);

    public MediaRendererControllerImpl() {
        this.handle = 0;
    }

    public DeviceInfo GetDeviceInfo() {
        return JNI_DMRC_GetDeviceInfo();
    }

    public ArrayList<ProtocolInfo> GetProtocolInfo() {
        return JNI_DMRC_GetProtocolInfo();
    }

    public MediaInfo GetMediaInfo(int instance_id) {
        return JNI_DMRC_GetMediaInfo(instance_id);
    }

    public DeviceCapabilities GetDeviceCapabilities(int instance_id) {
        return JNI_DMRC_GetDeviceCapabilities(instance_id);
    }

    public TransportInfo GetTransportInfo(int instance_id) {
        return JNI_DMRC_GetTransportInfo(instance_id);
    }

    public PositionInfo GetPositionInfo(int instance_id) {
        return JNI_DMRC_GetPositionInfo(instance_id);
    }

    public TransportSettings GetTransportSettings(int instance_id) {
        return JNI_DMRC_GetTransportSettings(instance_id);
    }

    public void SetAVTransportURI(int instance_id, String uri, String metadata) {
        JNI_DMRC_SetAVTransportURI(instance_id, uri, metadata);
    }

    public void Stop(int instance_id) {
        JNI_DMRC_Stop(instance_id);
    }

    public void Play(int instance_id, String speed) {
        JNI_DMRC_Play(instance_id, speed);
    }

    public void Pause(int instance_id) {
        JNI_DMRC_Pause(instance_id);
    }

    public void Seek(int instance_id, SeekMode mode, String target) {
        JNI_DMRC_Seek(instance_id, mode, target);
    }

    public void Next(int instance_id) {
        JNI_DMRC_Next(instance_id);
    }

    public void Previous(int instance_id) {
        JNI_DMRC_Previous(instance_id);
    }

    public void ZoomIn(int instance_id) {
        JNI_DMRC_ZoomIn(instance_id);
    }

    public void ZoomOut(int instance_id) {
        JNI_DMRC_ZoomOut(instance_id);
    }

    public void RotateClockwise(int instance_id) {
        JNI_DMRC_RotateClockwise(instance_id);
    }

    public void RotateCounterClockwise(int instance_id) {
        JNI_DMRC_RotateCounterClockwise(instance_id);
    }

    public int GetVolume(int instance_id, Channel channel) {
        return JNI_DMRC_GetVolume(instance_id, channel);
    }

    public void SetVolume(int instance_id, VolumeInfo info) {
        JNI_DMRC_SetVolume(instance_id, info);
    }
}
