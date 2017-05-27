package com.mstar.android.tv;

import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import com.mstar.android.tv.ITvEventClient.Stub;
import com.mstar.android.tvapi.common.listener.OnTvEventListener;
import com.mstar.android.tvapi.common.vo.EnumAtvAudioModeType;
import com.mstar.android.tvapi.common.vo.EnumAudioReturn;
import com.mstar.android.tvapi.common.vo.EnumScreenMuteType;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import java.util.ArrayList;
import java.util.Iterator;

public class TvCommonManager {
    private static final String TAG = "TvCommonManager";
    static TvCommonManager mInstance;
    private static ITvCommon mService;
    private Client tvClient;
    private ArrayList<OnTvEventListener> tvListeners;

    private class Client extends Stub {
        private Client() {
        }

        public boolean onDtvReadyPopupDialog(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onDtvReadyPopupDialog(what, arg1, arg2);
            }
            return false;
        }

        public boolean onScartMuteOsdMode(int what) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onScartMuteOsdMode(what);
            }
            return false;
        }

        public boolean onSignalUnlock(int what) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onSignalUnlock(what);
            }
            return false;
        }

        public boolean onSignalLock(int what) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onSignalLock(what);
            }
            return false;
        }

        public boolean onUnityEvent(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onUnityEvent(what, arg1, arg2);
            }
            return false;
        }

        public boolean onScreenSaverMode(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onScreenSaverMode(what, arg1, arg2);
            }
            return false;
        }

        public boolean onAtscPopupDialog(int what, int arg1, int arg2) throws RemoteException {
            Iterator i$ = TvCommonManager.this.tvListeners.iterator();
            while (i$.hasNext()) {
                ((OnTvEventListener) i$.next()).onAtscPopupDialog(what, arg1, arg2);
            }
            return false;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvCommonManager() {
        this.tvListeners = new ArrayList();
    }

    public static TvCommonManager getInstance() {
        if (mInstance == null) {
            synchronized (TvCommonManager.class) {
                if (mInstance == null) {
                    mInstance = new TvCommonManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvCommon getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvCommon();
        return mService;
    }

    public void setInputSource(EnumInputSource source) {
        Log.d(TAG, "setInputSource, paras source = " + source);
        try {
            getService().setInputSource(source.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumInputSource getCurrentInputSource() {
        EnumInputSource en = null;
        try {
            return EnumInputSource.values()[getService().getCurrentInputSource()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public EnumInputSource getCurrentSubInputSource() {
        EnumInputSource en = null;
        try {
            en = EnumInputSource.values()[getService().getCurrentSubInputSource()];
            Log.d(TAG, "getCurrentSubInputSource, return EnumInputSource " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean[] GetInputSourceStatus() {
        boolean[] bSrcStatus = null;
        try {
            bSrcStatus = getService().GetInputSourceStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return bSrcStatus;
    }

    public boolean setPowerOnSource(EnumInputSource eSource) {
        Log.d(TAG, "setPowerOnSource, paras eSource = " + eSource);
        try {
            return getService().setPowerOnSource(eSource.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumInputSource getPowerOnSource() {
        EnumInputSource en = null;
        try {
            en = EnumInputSource.values()[getService().getPowerOnSource()];
            Log.d(TAG, "getPowerOnSource, return EnumInputSource " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public void setPowerOnAVMute(boolean enable) {
        try {
            getService().setPowerOnAVMute(enable);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean getPowerOnAVMute() {
        boolean enable = false;
        try {
            enable = getService().getPowerOnAVMute();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return enable;
    }

    public void enterSleepMode(boolean bMode, boolean bNoSignalPwDn) {
        Log.d(TAG, "enterSleepMode paras bMode = " + bMode + ", bNoSignalPwDn" + bNoSignalPwDn);
        try {
            getService().enterSleepMode(bMode, bNoSignalPwDn);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void recoverySystem(String url) {
        try {
            getService().recoverySystem(url);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void standbySystem(String Pwd) {
        try {
            getService().standbySystem(Pwd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void openSurfaceView(int x, int y, int width, int height) throws RemoteException {
        try {
            getService().openSurfaceView(x, y, width, height);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setSurfaceView(int x, int y, int width, int height) throws RemoteException {
        try {
            getService().setSurfaceView(x, y, width, height);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void closeSurfaceView() throws RemoteException {
        try {
            getService().closeSurfaceView();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void rebootSystem(String Pwd) {
        try {
            getService().rebootSystem(Pwd);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int[] getSourceList() {
        try {
            return getService().getSourceList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumAudioReturn setAtvMtsMode(EnumAtvAudioModeType mode) {
        try {
            return EnumAudioReturn.values()[getService().setAtvMtsMode(mode.ordinal())];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumAtvAudioModeType getAtvMtsMode() {
        try {
            return EnumAtvAudioModeType.values()[getService().getAtvMtsMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EnumAudioReturn setToNextAtvMtsMode() {
        ITvCommon service = getService();
        EnumAudioReturn result = EnumAudioReturn.E_RETURN_NOTOK;
        try {
            return EnumAudioReturn.values()[service.setToNextAtvMtsMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return result;
        }
    }

    public EnumAtvAudioModeType getAtvSoundMode() {
        try {
            return EnumAtvAudioModeType.values()[getService().getAtvSoundMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void OSD_Set3Dformat(int mode) {
        SystemProperties.set("mstar.desk-display-mode", String.valueOf(mode));
    }

    public int[] setTvosCommonCommand(String cmd) {
        try {
            return getService().setTvosCommonCommand(cmd);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setVideoMute(boolean bScreenMute, EnumScreenMuteType enColor, int screenUnMuteTime, EnumInputSource eSrcType) {
        Log.d(TAG, "setVideoMute");
        try {
            return getService().setVideoMute(bScreenMute, enColor.ordinal(), screenUnMuteTime, eSrcType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerOnTvEventListener(OnTvEventListener listener) {
        if (this.tvClient == null) {
            this.tvClient = new Client();
            try {
                getService().addClient("DeskTvEventListener", this.tvClient);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.tvListeners.add(listener);
        return true;
    }
}
