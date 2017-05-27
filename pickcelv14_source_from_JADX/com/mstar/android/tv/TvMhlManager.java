package com.mstar.android.tv;

import android.os.RemoteException;

public class TvMhlManager {
    private static final String TAG = "TvMhlManager";
    static TvMhlManager mInstance;
    private static ITvMhl mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvMhlManager() {
    }

    public static TvMhlManager getInstance() {
        if (mInstance == null) {
            synchronized (TvMhlManager.class) {
                if (mInstance == null) {
                    mInstance = new TvMhlManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvMhl getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvMhl();
        return mService;
    }

    public boolean IRKeyProcess(int keycode, boolean bIsRelease) {
        try {
            return getService().IRKeyProcess(keycode, bIsRelease);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean CbusStatus() {
        boolean cbusStatus = false;
        try {
            cbusStatus = getService().CbusStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return cbusStatus;
    }

    public boolean IsMhlPortInUse() {
        boolean mhlPortInUse = false;
        try {
            mhlPortInUse = getService().IsMhlPortInUse();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return mhlPortInUse;
    }

    public void setDebugMode(boolean mode) {
        try {
            getService().setDebugMode(mode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setAutoSwitch(boolean isOpen) {
        try {
            getService().setAutoSwitch(isOpen);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean getAutoSwitch() {
        boolean autoSwitch = false;
        try {
            autoSwitch = getService().getAutoSwitch();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return autoSwitch;
    }
}
