package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideo3DOutputAspect;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideo3DTo2D;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideoAutoStart;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideoDisplayFormat;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideoLrViewSwitch;
import com.mstar.android.tvapi.common.vo.EnumThreeDVideoSelfAdaptiveDetect;

public class TvS3DManager {
    private static final String TAG = "TvS3DManager";
    static TvS3DManager mInstance;
    private static ITvS3D mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvS3DManager() {
    }

    public static TvS3DManager getInstance() {
        if (mInstance == null) {
            synchronized (TvS3DManager.class) {
                if (mInstance == null) {
                    mInstance = new TvS3DManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvS3D getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvS3D();
        return mService;
    }

    public boolean setSelfAdaptiveDetect(EnumThreeDVideoSelfAdaptiveDetect selfAdaptiveDetect) {
        Log.d(TAG, "setSelfAdaptiveDetect(), paras selfAdaptiveDetect = " + selfAdaptiveDetect);
        try {
            return getService().setSelfAdaptiveDetect(selfAdaptiveDetect.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideoSelfAdaptiveDetect getSelfAdaptiveDetect() {
        EnumThreeDVideoSelfAdaptiveDetect en = null;
        try {
            en = EnumThreeDVideoSelfAdaptiveDetect.values()[getService().getSelfAdaptiveDetect()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getSelfAdaptiveDetect(), return EnumThreeDVideoSelfAdaptiveDetect " + en);
        return en;
    }

    public boolean setDisplayFormat(EnumThreeDVideoDisplayFormat displayFormat) {
        Log.d(TAG, "setDisplayFormat(), paras displayFormat = " + displayFormat);
        try {
            return getService().setDisplayFormat(displayFormat.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideoDisplayFormat getDisplayFormat() {
        EnumThreeDVideoDisplayFormat en = null;
        try {
            en = EnumThreeDVideoDisplayFormat.values()[getService().getDisplayFormat()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getDisplayFormat(), return EnumThreeDVideoDisplayFormat " + en);
        return en;
    }

    public boolean set3DTo2D(EnumThreeDVideo3DTo2D displayMode) {
        Log.d(TAG, "set3DTo2D(), paras displayMode = " + displayMode);
        try {
            return getService().set3DTo2D(displayMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideo3DTo2D getDisplay3DTo2DMode() {
        EnumThreeDVideo3DTo2D en = null;
        try {
            en = EnumThreeDVideo3DTo2D.values()[getService().getDisplay3DTo2DMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getDisplay3DTo2DMode(), return EnumThreeDVideo3DTo2D " + en);
        return en;
    }

    public boolean set3DDepthMode(int mode3DDepth) {
        Log.d(TAG, "set3DDepthMode(i), paras mode3DDepth = " + mode3DDepth);
        try {
            return getService().set3DDepthMode(mode3DDepth);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int get3DDepthMode() {
        int i = -1;
        try {
            i = getService().get3DDepthMode();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "get3DDepthMode(), return int " + i);
        return i;
    }

    public boolean set3DOffsetMode(int mode3DOffset) {
        Log.d(TAG, "set3DOffsetMode(), paras mode3DOffset = " + mode3DOffset);
        try {
            return getService().set3DOffsetMode(mode3DOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int get3DOffsetMode() {
        int i = -1;
        try {
            i = getService().get3DOffsetMode();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "get3DOffsetMode(), return int " + i);
        return i;
    }

    public boolean setAutoStartMode(EnumThreeDVideoAutoStart autoStartMode) {
        Log.d(TAG, "setAutoStartMode(), paras autoStartMode = " + autoStartMode);
        try {
            return getService().setAutoStartMode(autoStartMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideoAutoStart getAutoStartMode() {
        EnumThreeDVideoAutoStart en = null;
        try {
            en = EnumThreeDVideoAutoStart.values()[getService().getAutoStartMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAutoStartMode(), return EnumThreeDVideoAutoStart " + en);
        return en;
    }

    public boolean set3DOutputAspectMode(EnumThreeDVideo3DOutputAspect outputAspectMode) {
        Log.d(TAG, "set3DOutputAspectMode(), paras outputAspectMode = " + outputAspectMode);
        try {
            return getService().set3DOutputAspectMode(outputAspectMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideo3DOutputAspect get3DOutputAspectMode() {
        EnumThreeDVideo3DOutputAspect en = null;
        try {
            en = EnumThreeDVideo3DOutputAspect.values()[getService().get3DOutputAspectMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "get3DOutputAspectMode(), return EnumThreeDVideo3DOutputAspect " + en);
        return en;
    }

    public boolean setLrViewSwitch(EnumThreeDVideoLrViewSwitch LrViewSwitchMode) {
        Log.d(TAG, "setLrViewSwitch(), paras LrViewSwitchMode = " + LrViewSwitchMode);
        try {
            return getService().setLrViewSwitch(LrViewSwitchMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumThreeDVideoLrViewSwitch getLrViewSwitch() {
        EnumThreeDVideoLrViewSwitch en = null;
        try {
            en = EnumThreeDVideoLrViewSwitch.values()[getService().getLrViewSwitch()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, " getLrViewSwitch(), return EnumThreeDVideoLrViewSwitch " + en);
        return en;
    }

    public void setDisplayFormatForUI(int threedDisplayFormatIdx) {
        try {
            getService().setDisplayFormatForUI(threedDisplayFormatIdx);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
