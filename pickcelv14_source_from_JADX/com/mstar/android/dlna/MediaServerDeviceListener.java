package com.mstar.android.dlna;

public interface MediaServerDeviceListener {
    boolean OnCreateObject(String str);

    boolean OnGetProtocolInfo();
}
