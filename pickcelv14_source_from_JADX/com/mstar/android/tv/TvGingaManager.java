package com.mstar.android.tv;

import android.os.RemoteException;
import com.mstar.android.tvapi.dtv.dvb.isdb.vo.GingaInfo;
import java.util.List;

public class TvGingaManager {
    private static final String TAG = "TvGingaManager";
    static TvGingaManager mInstance;
    private static ITvGinga mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvGingaManager() {
    }

    public static TvGingaManager getInstance() {
        if (mInstance == null) {
            synchronized (TvGingaManager.class) {
                if (mInstance == null) {
                    mInstance = new TvGingaManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvGinga getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvGinga();
        return mService;
    }

    public boolean processKey(int keycode, boolean bPressed) {
        try {
            return getService().processKey(keycode, bPressed);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<GingaInfo> getApps(String path) {
        try {
            return getService().getApps(path);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean startApplication(long aid, long oid) {
        try {
            return getService().startApplication(aid, oid);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopApplication() {
        try {
            return getService().stopApplication();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isGingaRunning() {
        try {
            return getService().isGingaRunning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enableGinga() {
        try {
            return getService().enableGinga();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableGinga() {
        try {
            return getService().disableGinga();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isGingaEnabled() {
        try {
            return getService().isGingaEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
