package com.mstar.android.widi;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.mstar.android.widi.IWidiManager.Stub;

public class WidiManager {
    public static final String EXTRA_ARG1 = "widi_arg1";
    public static final String EXTRA_ARG2 = "widi_arg2";
    public static final String EXTRA_CURRENT_WIDI_STATE = "current_widi_state";
    public static final String EXTRA_PREVIOUS_WIDI_STATE = "previous_widi_state";
    private static final String TAG = "WidiManager";
    public static final String WIDI_STATE_CHANGED_ACTION = "com.mstar.android.widi.WIDI_STATE_CHANGED";
    public static final int WIDI_STATE_CONNECTED = 8;
    public static final int WIDI_STATE_CONNECTING = 6;
    public static final int WIDI_STATE_DISCONNECTED = 5;
    public static final int WIDI_STATE_DRIVER_LOADED = 4;
    public static final int WIDI_STATE_DRIVER_LOADING = 3;
    public static final int WIDI_STATE_DRIVER_UNLOADED = 1;
    public static final int WIDI_STATE_DRIVER_UNLOADING = 2;
    public static final int WIDI_STATE_NOT_SUPPORT = 0;
    public static final int WIDI_STATE_OBTAINING_IP = 9;
    public static final int WIDI_STATE_SHOW_PIN = 7;
    public static final int WIDI_STATE_SHOW_SCREEN = 10;
    static WidiManager mInstance;
    static final Object mInstanceSync;
    IWidiManager mService;

    static {
        mInstanceSync = new Object();
        mInstance = null;
    }

    private WidiManager(IWidiManager service) {
        this.mService = null;
        this.mService = service;
    }

    public static WidiManager getInstance() {
        if (mInstance == null) {
            synchronized (mInstanceSync) {
                if (mInstance == null) {
                    mInstance = new WidiManager(Stub.asInterface(ServiceManager.getService("widi")));
                }
            }
        }
        return mInstance;
    }

    public void startWidi() {
        Log.d(TAG, "start widi...");
        try {
            this.mService.startWidi();
        } catch (RemoteException e) {
            Log.d(TAG, "start widi failed");
        }
    }

    public void stopWidi() {
        Log.d(TAG, "stop widi...");
        try {
            this.mService.stopWidi();
        } catch (RemoteException e) {
            Log.d(TAG, "stop widi failed");
        }
    }
}
