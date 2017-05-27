package com.mstar.android.dlna;

import java.util.ArrayList;

public interface MediaRendererController {
    DeviceCapabilities GetDeviceCapabilities(int i) throws ActionUnsupportedException, HostUnreachableException;

    DeviceInfo GetDeviceInfo() throws ActionUnsupportedException, HostUnreachableException;

    MediaInfo GetMediaInfo(int i) throws ActionUnsupportedException, HostUnreachableException;

    PositionInfo GetPositionInfo(int i) throws ActionUnsupportedException, HostUnreachableException;

    ArrayList<ProtocolInfo> GetProtocolInfo() throws ActionUnsupportedException, HostUnreachableException;

    TransportInfo GetTransportInfo(int i) throws ActionUnsupportedException, HostUnreachableException;

    TransportSettings GetTransportSettings(int i) throws ActionUnsupportedException, HostUnreachableException;

    int GetVolume(int i, Channel channel) throws ActionUnsupportedException, HostUnreachableException;

    void Next(int i) throws ActionUnsupportedException, HostUnreachableException;

    void Pause(int i) throws ActionUnsupportedException, HostUnreachableException;

    void Play(int i, String str) throws ActionUnsupportedException, HostUnreachableException;

    void Previous(int i) throws ActionUnsupportedException, HostUnreachableException;

    void RotateClockwise(int i) throws ActionUnsupportedException, HostUnreachableException;

    void RotateCounterClockwise(int i) throws ActionUnsupportedException, HostUnreachableException;

    void Seek(int i, SeekMode seekMode, String str) throws ActionUnsupportedException, HostUnreachableException;

    void SetAVTransportURI(int i, String str, String str2) throws ActionUnsupportedException, HostUnreachableException, ActionFailedException;

    void SetVolume(int i, VolumeInfo volumeInfo) throws ActionUnsupportedException, HostUnreachableException;

    void Stop(int i) throws ActionUnsupportedException, HostUnreachableException;

    void ZoomIn(int i) throws ActionUnsupportedException, HostUnreachableException;

    void ZoomOut(int i) throws ActionUnsupportedException, HostUnreachableException;
}
