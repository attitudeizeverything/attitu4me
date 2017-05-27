package com.mstar.android.dlna;

import java.util.ArrayList;

class DLNAImpl implements DLNA {
    private native synchronized void JNI_DLNA_AsyncSearchDevice();

    private native synchronized void JNI_DLNA_Finalize();

    private native synchronized String JNI_DLNA_GetIP();

    private native synchronized int JNI_DLNA_GetPort();

    private native String JNI_DLNA_GetVersion();

    private native synchronized boolean JNI_DLNA_Initialize(String str, int i);

    private native synchronized void JNI_DLNA_SetDescriptionFile(String str);

    private native synchronized void JNI_DLNA_SetDeviceListener(DeviceListener deviceListener);

    DLNAImpl() {
    }

    public boolean Initialize(String ip, int port) {
        return JNI_DLNA_Initialize(ip, port);
    }

    public void SetDescriptionFile(String xml) {
        JNI_DLNA_SetDescriptionFile(xml);
    }

    public void Finalize() {
        JNI_DLNA_Finalize();
    }

    public MediaRendererDevice CreateMediaRendererDevice() {
        return new MediaRendererDeviceImpl();
    }

    public MediaServerDevice CreateMediaServerDevice() {
        return new MediaServerDeviceImpl();
    }

    public void SetDeviceListener(DeviceListener listener) {
        JNI_DLNA_SetDeviceListener(listener);
    }

    public void AsyncSearchDevice() {
        JNI_DLNA_AsyncSearchDevice();
    }

    public ArrayList<MediaRendererController> GetMediaRendererControllerList() {
        return new ArrayList();
    }

    public ArrayList<MediaServerController> GetMediaServerControllerList() {
        return new ArrayList();
    }

    public String GetVersion() {
        return JNI_DLNA_GetVersion();
    }

    public int GetPort() {
        return JNI_DLNA_GetPort();
    }

    public String GetIP() {
        return JNI_DLNA_GetIP();
    }

    static {
        System.loadLibrary("dlna_jni");
    }
}
