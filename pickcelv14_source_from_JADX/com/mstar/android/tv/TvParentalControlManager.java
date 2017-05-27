package com.mstar.android.tv;

import android.os.RemoteException;

public class TvParentalControlManager {
    private static final String TAG = "TvParentalControlManager";
    static TvParentalControlManager mInstance;
    private static ITvParentalControl mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvParentalControlManager() {
    }

    public static TvParentalControlManager getInstance() {
        if (mInstance == null) {
            synchronized (TvParentalControlManager.class) {
                if (mInstance == null) {
                    mInstance = new TvParentalControlManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvParentalControl getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvParentalControl();
        return mService;
    }

    public int getParentalControlRating() {
        int i = -1;
        try {
            i = getService().getParentalControlRating();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void setParentalControlRating(int rating) {
        try {
            getService().setParentalControlRating(rating);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getParentalPassword() {
        int i = -1;
        try {
            i = getService().getParentalPassword();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void setParentalPassword(int psw) {
        try {
            getService().setParentalPassword(psw);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setSystemLock(boolean islocked) {
        try {
            getService().setSystemLock(islocked);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isSystemLock() {
        try {
            return getService().isSystemLock();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unlockChannel() {
        try {
            getService().unlockChannel();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
