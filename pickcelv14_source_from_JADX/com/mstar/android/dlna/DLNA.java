package com.mstar.android.dlna;

import java.util.ArrayList;

public interface DLNA {
    void AsyncSearchDevice();

    MediaRendererDevice CreateMediaRendererDevice();

    MediaServerDevice CreateMediaServerDevice();

    void Finalize();

    String GetIP();

    ArrayList<MediaRendererController> GetMediaRendererControllerList();

    ArrayList<MediaServerController> GetMediaServerControllerList();

    int GetPort();

    String GetVersion();

    boolean Initialize(String str, int i);

    void SetDescriptionFile(String str);

    void SetDeviceListener(DeviceListener deviceListener);
}
