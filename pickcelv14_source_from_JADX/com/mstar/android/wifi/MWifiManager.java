package com.mstar.android.wifi;

import android.net.wifi.IWifiManager;
import android.net.wifi.IWifiManager.Stub;
import android.os.RemoteException;
import android.os.ServiceManager;

public class MWifiManager {
    public static final String TAG = "MWifiManager";
    public static final String WIFI_DEVICE_ADDED_ACTION = "com.mstar.android.wifi.device.added";
    public static final String WIFI_DEVICE_REMOVED_ACTION = "com.mstar.android.wifi.device.removed";
    static MWifiManager mInstance;
    static final Object mInstanceSync;
    IWifiManager mService;

    static {
        mInstanceSync = new Object();
        mInstance = null;
    }

    private MWifiManager(IWifiManager service) {
        this.mService = null;
        this.mService = service;
    }

    public static MWifiManager getInstance() {
        if (mInstance == null) {
            synchronized (mInstanceSync) {
                if (mInstance == null) {
                    mInstance = new MWifiManager(Stub.asInterface(ServiceManager.getService("wifi")));
                }
            }
        }
        return mInstance;
    }

    public boolean isWifiDeviceSupportWps() {
        try {
            return this.mService.isWifiDeviceSupportWps();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isWifiDeviceSupportSoftap() {
        try {
            return this.mService.isWifiDeviceSupportSoftap();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isWifiDeviceSupportP2p() {
        try {
            return this.mService.isWifiDeviceSupportP2p();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isWifiDeviceExist() {
        try {
            return this.mService.isWifiDeviceExist();
        } catch (RemoteException e) {
            return false;
        }
    }

    public int numOfWifiDeviceExist() {
        try {
            return this.mService.numOfWifiDeviceExist();
        } catch (RemoteException e) {
            return 0;
        }
    }
}
