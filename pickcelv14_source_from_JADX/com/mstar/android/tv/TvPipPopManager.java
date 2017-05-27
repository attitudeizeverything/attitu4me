package com.mstar.android.tv;

import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.EnumPipModes;
import com.mstar.android.tvapi.common.vo.EnumPipReturn;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoWindowType;

public class TvPipPopManager {
    private static final String TAG = "TvPipPopManager";
    static TvPipPopManager mInstance;
    private static ITvPipPop mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvPipPopManager() {
    }

    public static TvPipPopManager getInstance() {
        if (mInstance == null) {
            synchronized (TvPipPopManager.class) {
                if (mInstance == null) {
                    mInstance = new TvPipPopManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvPipPop getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvPipPop();
        return mService;
    }

    public boolean checkPipSupport(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) {
        try {
            return getService().checkPipSupport(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkPipSupportOnSubSrc(EnumInputSource eMainInputSrc) {
        try {
            return getService().checkPipSupportOnSubSrc(eMainInputSrc.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPipReturn enablePipTV(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc, VideoWindowType dispWin) {
        try {
            return EnumPipReturn.values()[getService().enablePipTV(eMainInputSrc.ordinal(), eSubInputSrc.ordinal(), dispWin)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setPipSubwindow(VideoWindowType dispWin) {
        try {
            return getService().setPipSubwindow(dispWin);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPipReturn enablePipMM(EnumInputSource eMainInputSrc, VideoWindowType dispWin) {
        try {
            return EnumPipReturn.values()[getService().enablePipMM(eMainInputSrc.ordinal(), dispWin)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean disablePip() {
        try {
            return getService().disablePip();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int[] getSubWindowSourceList(boolean ispip) {
        try {
            return getService().getSubWindowSourceList(ispip);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPipDisplayFocusWindow(EnumScalerWindow enScalerWindow) {
        try {
            getService().setPipDisplayFocusWindow(enScalerWindow.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPopSupport(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) {
        try {
            return getService().checkPopSupport(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPipReturn enablePopTV(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) {
        try {
            return EnumPipReturn.values()[getService().enablePopTV(eMainInputSrc.ordinal(), eSubInputSrc.ordinal())];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumPipReturn enablePopMM(EnumInputSource eMainInputSrc) {
        try {
            return EnumPipReturn.values()[getService().enablePopMM(eMainInputSrc.ordinal())];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean disablePop() {
        try {
            return getService().disablePop();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkTravelingModeSupport(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) {
        try {
            return getService().checkTravelingModeSupport(eMainInputSrc.ordinal(), eSubInputSrc.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPipReturn enableTravelingModeTV(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc) {
        try {
            return EnumPipReturn.values()[getService().enableTravelingModeTV(eMainInputSrc.ordinal(), eSubInputSrc.ordinal())];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumPipReturn enableTravelingModeMM(EnumInputSource eMainInputSrc) {
        try {
            return EnumPipReturn.values()[getService().enableTravelingModeMM(eMainInputSrc.ordinal())];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean disableTravelingMode() {
        try {
            return getService().disableTravelingMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getIsPipOn() {
        try {
            return getService().getIsPipOn();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPipOnFlag(boolean pipOnFlag) {
        try {
            return getService().setPipOnFlag(pipOnFlag);
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean enable3dDualView(EnumInputSource eMainInputSrc, EnumInputSource eSubInputSrc, VideoWindowType mainWin, VideoWindowType subWin) {
        try {
            return getService().enable3dDualView(eMainInputSrc.ordinal(), eSubInputSrc.ordinal(), mainWin, subWin);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disable3dDualView() {
        try {
            return getService().disable3dDualView();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPipModeEnabled() {
        try {
            return getService().isPipModeEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPipModes getPipMode() {
        try {
            return EnumPipModes.values()[getService().getPipMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] getMainWindowSourceList() {
        try {
            return getService().getMainWindowSourceList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
