package com.mstar.android.tv;

import android.os.RemoteException;
import android.os.ServiceManager;
import com.mstar.android.tv.ITvService.Stub;

public class TvManager {
    private static final String TAG = "TvManager";
    static TvManager mInstance;
    ITvService mService;

    static {
        mInstance = null;
    }

    private TvManager(ITvService service) {
        this.mService = null;
        this.mService = service;
    }

    public static TvManager getInstance() {
        if (mInstance == null) {
            synchronized (TvManager.class) {
                if (mInstance == null) {
                    mInstance = new TvManager(Stub.asInterface(ServiceManager.getService("tv")));
                }
            }
        }
        return mInstance;
    }

    public ITvS3D getTvS3D() {
        try {
            return this.mService.getTvS3D();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvAtscChannel getTvAtscChannel() {
        try {
            return this.mService.getTvAtscChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvIsdbChannel getTvIsdbChannel() {
        try {
            return this.mService.getTvIsdbChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvAudio getTvAudio() {
        try {
            return this.mService.getTvAudio();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvCc getTvCc() {
        try {
            return this.mService.getTvCc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvCec getTvCec() {
        try {
            return this.mService.getTvCec();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvCi getTvCi() {
        try {
            return this.mService.getTvCi();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvChannel getTvChannel() {
        try {
            return this.mService.getTvChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvCommon getTvCommon() {
        try {
            return this.mService.getTvCommon();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvEpg getTvEpg() {
        try {
            return this.mService.getTvEpg();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvFactory getTvFactory() {
        try {
            return this.mService.getTvFactory();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvPicture getTvPicture() {
        try {
            return this.mService.getTvPicture();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvTimer getTvTimer() {
        try {
            return this.mService.getTvTimer();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvPipPop getTvPipPop() {
        try {
            return this.mService.getTvPipPop();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvMhl getTvMhl() {
        try {
            return this.mService.getTvMhl();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvPvr getTvPvr() {
        try {
            return this.mService.getTvPvr();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvGinga getTvGinga() {
        try {
            return this.mService.getTvGinga();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ITvParentalControl getTvParentalControl() {
        try {
            return this.mService.getTvParentalControl();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
