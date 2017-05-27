package com.mstar.android.dlna;

import java.util.ArrayList;

public interface MediaServerDevice {
    void AddMediaFile(String str, MediaMetaData mediaMetaData);

    ShareItem Browse(String str);

    int DisableUpload();

    int EnableUpload();

    DeviceInfo GetDeviceInfo();

    void RemoveMediaFile(String str);

    void SetDeviceInfo(DeviceInfo deviceInfo);

    void SetListener(MediaServerDeviceListener mediaServerDeviceListener);

    void SetPassword(String str);

    void SetProtocolInfo(ArrayList<ProtocolInfo> arrayList);

    int SetUploadItemSaveDir(String str);
}
