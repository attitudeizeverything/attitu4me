package com.mstar.android.dlna;

public interface DeviceListener {
    void OnDisappeared(MediaRendererController mediaRendererController);

    void OnDisappeared(MediaServerController mediaServerController);

    void OnDiscovered(MediaRendererController mediaRendererController);

    void OnDiscovered(MediaServerController mediaServerController);
}
