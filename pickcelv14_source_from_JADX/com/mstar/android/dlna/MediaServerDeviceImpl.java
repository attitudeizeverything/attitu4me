package com.mstar.android.dlna;

import java.util.ArrayList;

/* compiled from: DLNAImpl */
class MediaServerDeviceImpl implements MediaServerDevice {
    private native synchronized int DMSDisableUpload();

    private native synchronized int DMSEnableUpload();

    private native synchronized int DMSSetUploadItemSaveDir(String str);

    private native synchronized void JNI_DMS_AddMediaFile(String str, MediaMetaData mediaMetaData);

    private native synchronized ShareItem JNI_DMS_Browse(String str);

    private native synchronized DeviceInfo JNI_DMS_GetDeviceInfo();

    private native synchronized void JNI_DMS_RemoveMediaFile(String str);

    private native synchronized void JNI_DMS_SetDeviceInfo(DeviceInfo deviceInfo);

    private native synchronized void JNI_DMS_SetListener(MediaServerDeviceListener mediaServerDeviceListener);

    private native synchronized void JNI_DMS_SetPassword(String str);

    private native synchronized void JNI_DMS_SetProtocolInfo(ArrayList<ProtocolInfo> arrayList);

    MediaServerDeviceImpl() {
    }

    public void SetListener(MediaServerDeviceListener listener) {
        JNI_DMS_SetListener(listener);
    }

    public void SetProtocolInfo(ArrayList<ProtocolInfo> protocol_info) {
        JNI_DMS_SetProtocolInfo(protocol_info);
    }

    public void AddMediaFile(String path, MediaMetaData metadata) {
        JNI_DMS_AddMediaFile(path, metadata);
    }

    public void RemoveMediaFile(String path) {
        JNI_DMS_RemoveMediaFile(path);
    }

    public ShareItem Browse(String path) {
        return JNI_DMS_Browse(path);
    }

    public int EnableUpload() {
        return DMSEnableUpload();
    }

    public int DisableUpload() {
        return DMSDisableUpload();
    }

    public int SetUploadItemSaveDir(String dir_path) {
        return DMSSetUploadItemSaveDir(dir_path);
    }

    public DeviceInfo GetDeviceInfo() {
        return JNI_DMS_GetDeviceInfo();
    }

    public void SetDeviceInfo(DeviceInfo device_info) {
        JNI_DMS_SetDeviceInfo(device_info);
    }

    public void SetPassword(String pw) {
        JNI_DMS_SetPassword(pw);
    }
}
