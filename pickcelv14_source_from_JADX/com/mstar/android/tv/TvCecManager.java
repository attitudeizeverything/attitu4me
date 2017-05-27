package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tv.ICecEventClient.Stub;
import com.mstar.android.tvapi.common.listener.OnCecEventListener;
import com.mstar.android.tvapi.common.vo.CecSetting;
import com.mstar.android.tvapi.common.vo.EnumCecDeviceLa;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;
import java.util.ArrayList;
import java.util.Iterator;

public class TvCecManager {
    private static final String TAG = "TvCecManager";
    static TvCecManager mInstance;
    private static ITvCec mService;
    private CecEventClientCallBack cecEventClientCallBack;
    private ArrayList<OnCecEventListener> listeners;

    private class CecEventClientCallBack extends Stub {
        private CecEventClientCallBack() {
        }

        public boolean onImageViewOn(int what) throws RemoteException {
            Iterator i$ = TvCecManager.this.listeners.iterator();
            while (i$.hasNext()) {
                ((OnCecEventListener) i$.next()).onImageViewOn(what);
            }
            return true;
        }

        public boolean onTextViewOn(int what) throws RemoteException {
            Iterator i$ = TvCecManager.this.listeners.iterator();
            while (i$.hasNext()) {
                ((OnCecEventListener) i$.next()).onTextViewOn(what);
            }
            return true;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvCecManager() {
        this.listeners = new ArrayList();
    }

    public static TvCecManager getInstance() {
        if (mInstance == null) {
            synchronized (TvCecManager.class) {
                if (mInstance == null) {
                    mInstance = new TvCecManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvCec getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvCec();
        return mService;
    }

    public boolean setCecConfiguration(CecSetting cecSetting) {
        Log.d(TAG, "setCecConfiguration, paras CecSetting  cecSetting.arcStatus = " + cecSetting.arcStatus + ", cecSetting.audioModeStatus = " + cecSetting.audioModeStatus + ", cecSetting.autoStandby = " + cecSetting.autoStandby + ", cecSetting.cecStatus = " + cecSetting.cecStatus + ", cecSetting.checkSum = " + cecSetting.checkSum);
        try {
            return getService().setCecConfiguration(cecSetting);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CecSetting getCecConfiguration() {
        CecSetting setting = null;
        try {
            setting = getService().getCecConfiguration();
            Log.d(TAG, "getCecConfiguration, return CecSetting  arcStatus = " + setting.arcStatus + ", audioModeStatus = " + setting.audioModeStatus + ", autoStandby = " + setting.autoStandby + ", cecStatus = " + setting.cecStatus + ", checkSum = " + setting.checkSum);
            return setting;
        } catch (RemoteException e) {
            e.printStackTrace();
            return setting;
        }
    }

    public boolean setStreamPath(EnumCecDeviceLa enCecDeviceLa) {
        Log.d(TAG, "setStreamPath, paras enCecDeviceLa = " + enCecDeviceLa);
        try {
            return getService().setStreamPath(enCecDeviceLa.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void routingChangeInDeviceListSetting(int deviceLa) {
        Log.d(TAG, "routingChangeInDeviceListSetting  deviceLa = " + deviceLa);
        try {
            getService().routingChangeInDeviceListSetting(deviceLa);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean sendCecKey(int keyCode) {
        Log.d(TAG, "sendCecKey, paras keyCode = " + keyCode);
        try {
            return getService().sendCecKey(keyCode);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setMenuLanguage(EnumLanguage menuLang) {
        Log.d(TAG, "setMenuLanguage, paras menuLang = " + menuLang);
        try {
            return getService().setMenuLanguage(menuLang.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enableDeviceMenu() {
        try {
            return getService().enableDeviceMenu();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableDeviceMenu() {
        try {
            return getService().disableDeviceMenu();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getDeviceName(int index) {
        Log.d(TAG, "getDeviceName, paras index = " + index);
        String s = null;
        try {
            s = getService().getDeviceName(index);
            Log.d(TAG, "return String " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
            return s;
        }
    }

    public int getCECListCnt(int hdmi_port) {
        Log.d(TAG, "getCECListCnt, paras hdmi_port = " + hdmi_port);
        int num = 0;
        try {
            num = getService().getCECListCnt(hdmi_port);
            Log.d(TAG, "return hdmi_port " + num);
            return num;
        } catch (RemoteException e) {
            e.printStackTrace();
            return num;
        }
    }

    public String deviceListGetListStr(int hdmi_port, int cec_idx) {
        Log.d(TAG, "deviceListGetListStr, paras hdmi_port = " + hdmi_port + ", cec_idx=" + cec_idx);
        String s = null;
        try {
            s = getService().deviceListGetListStr(hdmi_port, cec_idx);
            Log.d(TAG, "return String " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
            return s;
        }
    }

    public int deviceListGetItemIndex(int hdmi_port, int ActiveLA) {
        Log.d(TAG, "deviceListGetItemIndex, paras hdmi_port = " + hdmi_port + ", ActiveLA=" + ActiveLA);
        int idx = 0;
        try {
            idx = getService().deviceListGetItemIndex(hdmi_port, ActiveLA);
            Log.d(TAG, "return idx " + idx);
            return idx;
        } catch (RemoteException e) {
            e.printStackTrace();
            return idx;
        }
    }

    public boolean registerOnCecEventListener(OnCecEventListener listener) {
        if (this.cecEventClientCallBack == null) {
            this.cecEventClientCallBack = new CecEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskCecEventListener", this.cecEventClientCallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.listeners.add(listener);
        return true;
    }

    public synchronized boolean unregisterOnCecEventListener(OnCecEventListener listener) {
        this.listeners.remove(listener);
        if (this.listeners.size() == 0 && this.cecEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskCecEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.cecEventClientCallBack = null;
        }
        return true;
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize TvCecManager ");
        if (this.cecEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskCecEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
