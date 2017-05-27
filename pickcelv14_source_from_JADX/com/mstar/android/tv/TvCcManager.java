package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.CCSetting;
import com.mstar.android.tvapi.common.vo.CaptionOptionSetting;

public class TvCcManager {
    private static final String TAG = "TvCcManager";
    static TvCcManager mInstance;
    private static ITvCc mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvCcManager() {
    }

    public static TvCcManager getInstance() {
        if (mInstance == null) {
            synchronized (TvCcManager.class) {
                if (mInstance == null) {
                    mInstance = new TvCcManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvCc getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvCc();
        return mService;
    }

    public boolean startCc() {
        try {
            return getService().startCc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopCc() {
        try {
            return getService().stopCc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean creatPreviewCcWindow() {
        try {
            return getService().creatPreviewCcWindow();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean drawPreviewCc(CaptionOptionSetting setting) {
        Log.d(TAG, "drawPreviewCc paras CaptionOptionSetting setting.currProgInfoBGColor = " + setting.currProgInfoBGColor + ", setting.currProgInfoBGOpacity = " + setting.currProgInfoBGOpacity + ", setting.currProgInfoEdgeColor = " + setting.currProgInfoEdgeColor + ", setting.currProgInfoEdgeStyle = " + setting.currProgInfoEdgeStyle + ", setting.currProgInfoFGColor = " + setting.currProgInfoFGColor + ", setting.currProgInfoFGOpacity = " + setting.currProgInfoFGOpacity + ", setting.currProgInfoFontSize = " + setting.currProgInfoFontSize + ", setting.currProgInfoFontStyle = " + setting.currProgInfoFontStyle);
        try {
            return getService().drawPreviewCc(setting);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exitPreviewCc() {
        try {
            return getService().exitPreviewCc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CCSetting getCCSetting() {
        try {
            return getService().getCCSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setCCSetting(CCSetting setting) {
        try {
            getService().setCCSetting(setting);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public CaptionOptionSetting getAdvancedSetting(int index) {
        try {
            return getService().getAdvancedSetting(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAdvancedSetting(CaptionOptionSetting setting, int index) {
        try {
            getService().setAdvancedSetting(setting, index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean doesCcExist() throws RemoteException {
        try {
            return getService().doesCcExist();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
