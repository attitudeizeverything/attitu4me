package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tv.IAudioEventClient.Stub;
import com.mstar.android.tvapi.common.listener.OnAudioEventListener;
import com.mstar.android.tvapi.common.vo.EnumDtvSoundMode;
import com.mstar.android.tvapi.common.vo.EnumOnOffType;
import com.mstar.android.tvapi.common.vo.EnumSoundMode;
import com.mstar.android.tvapi.common.vo.EnumSpdifType;
import com.mstar.android.tvapi.common.vo.EnumSurroundMode;
import java.util.ArrayList;
import java.util.Iterator;

public class TvAudioManager {
    private static final String TAG = "TvAudioManager";
    static TvAudioManager mInstance;
    private static ITvAudio mService;
    private AudioEventClientCallBack audioEventClientCallBack;
    private ArrayList<OnAudioEventListener> listeners;

    private class AudioEventClientCallBack extends Stub {
        private AudioEventClientCallBack() {
        }

        public boolean onApSetVolumeEvent(int what) throws RemoteException {
            Iterator i$ = TvAudioManager.this.listeners.iterator();
            while (i$.hasNext()) {
                ((OnAudioEventListener) i$.next()).onApSetVolumeEvent(what);
            }
            return true;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvAudioManager() {
        this.listeners = new ArrayList();
    }

    public static TvAudioManager getInstance() {
        if (mInstance == null) {
            synchronized (TvAudioManager.class) {
                if (mInstance == null) {
                    mInstance = new TvAudioManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvAudio getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvAudio();
        return mService;
    }

    public boolean setSoundMode(EnumSoundMode SoundMode) {
        Log.d(TAG, "setSoundMode(), paras SoundMode = " + SoundMode);
        try {
            return getService().setSoundMode(SoundMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    public EnumSoundMode getSoundMode() {
        EnumSoundMode en = null;
        try {
            en = EnumSoundMode.values()[getService().getSoundMode()];
            Log.d(TAG, "getSoundMode(), return EnumSoundMode " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setEarPhoneVolume(int volume) {
        Log.d(TAG, "setEarPhoneVolume(), paras volume = " + volume);
        try {
            return getService().setEarPhoneVolume(volume);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEarPhoneVolume() {
        int i = -1;
        try {
            i = getService().getEarPhoneVolume();
            Log.d(TAG, "getEarPhoneVolume(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setBass(int bassValue) {
        Log.d(TAG, "setBass(), paras bassValue = " + bassValue);
        try {
            return getService().setBass(bassValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getBass() {
        int i = -1;
        try {
            i = getService().getBass();
            Log.d(TAG, "getBass(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setTreble(int bassValue) {
        Log.d(TAG, "setTreble(), paras bassValue = " + bassValue);
        try {
            return getService().setTreble(bassValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTreble() {
        int i = -1;
        try {
            i = getService().getTreble();
            Log.d(TAG, "getTreble(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setBalance(int balanceValue) {
        Log.d(TAG, "setBalance(), paras balanceValue = " + balanceValue);
        try {
            return getService().setBalance(balanceValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getBalance() {
        int i = -1;
        try {
            i = getService().getBalance();
            Log.d(TAG, "getBalance(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setAvcMode(boolean isAvcEnable) {
        Log.d(TAG, "setAvcMode(), paras isAvcEnable = " + isAvcEnable);
        try {
            return getService().setAvcMode(isAvcEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getAvcMode() {
        ITvAudio service = getService();
        try {
            Log.d(TAG, "getAvcMode()");
            return service.getAvcMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setSurroundMode(EnumSurroundMode surroundMode) {
        Log.d(TAG, "setSurroundMode(), paras surroundMode = " + surroundMode);
        try {
            return getService().setSurroundMode(surroundMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumSurroundMode getSurroundMode() {
        EnumSurroundMode en = null;
        try {
            en = EnumSurroundMode.values()[getService().getSurroundMode()];
            Log.d(TAG, "getSurroundMode(), return EnumSurroundMode " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setSpdifOutMode(EnumSpdifType SpdifMode) {
        Log.d(TAG, "setSpdifOutMode(), paras SpdifMode = " + SpdifMode);
        try {
            return getService().setSpdifOutMode(SpdifMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumSpdifType getSpdifOutMode() {
        EnumSpdifType en = null;
        try {
            en = EnumSpdifType.values()[getService().getSpdifOutMode()];
            Log.d(TAG, "getSpdifOutMode(), return EnumSpdifType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setEqBand120(int eqValue) {
        Log.d(TAG, "setEqBand120(), paras eqValue = " + eqValue);
        try {
            return getService().setEqBand120(eqValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEqBand120() {
        int i = -1;
        try {
            i = getService().getEqBand120();
            Log.d(TAG, "getEqBand120(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setEqBand500(int eqValue) {
        Log.d(TAG, "setEqBand500(), paras eqValue = " + eqValue);
        try {
            return getService().setEqBand500(eqValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEqBand500() {
        int i = -1;
        try {
            i = getService().getEqBand500();
            Log.d(TAG, "getEqBand500(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setEqBand1500(int eqValue) {
        Log.d(TAG, "setEqBand1500(, paras eqValue = " + eqValue);
        try {
            return getService().setEqBand1500(eqValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEqBand1500() {
        int i = -1;
        try {
            i = getService().getEqBand1500();
            Log.d(TAG, "getEqBand1500(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setEqBand5k(int eqValue) {
        Log.d(TAG, "setEqBand5k(), paras eqValue = " + eqValue);
        try {
            return getService().setEqBand5k(eqValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEqBand5k() {
        int i = -1;
        try {
            i = getService().getEqBand5k();
            Log.d(TAG, "getEqBand5k(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setEqBand10k(int eqValue) {
        Log.d(TAG, "setEqBand10k(), paras eqValue = " + eqValue);
        try {
            return getService().setEqBand10k(eqValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getEqBand10k() {
        int i = -1;
        try {
            i = getService().getEqBand10k();
            Log.d(TAG, "getEqBand10k(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setBassSwitch(EnumOnOffType en) {
        Log.d(TAG, "setBassSwitch(), paras en = " + en);
        try {
            return getService().setBassSwitch(en.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumOnOffType getBassSwitch() {
        EnumOnOffType en = null;
        try {
            en = EnumOnOffType.values()[getService().getBassSwitch()];
            Log.d(TAG, "getBassSwitch(), return EnumOnOffType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setBassVolume(int volume) {
        ITvAudio service = getService();
        Log.d(TAG, "setBassVolume(), paras volume = " + volume);
        try {
            return service.setBassVolume(volume);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getBassVolume() {
        int i = -1;
        try {
            i = getService().getBassVolume();
            Log.d(TAG, "getBassVolume(), return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setPowerOnOffMusic(EnumOnOffType en) {
        Log.d(TAG, "setPowerOnOffMusic(), paras en = " + en);
        try {
            return getService().setPowerOnOffMusic(en.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumOnOffType getPowerOnOffMusic() {
        EnumOnOffType en = null;
        try {
            en = EnumOnOffType.values()[getService().getPowerOnOffMusic()];
            Log.d(TAG, "getPowerOnOffMusic(), return EnumOnOffType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setWallmusic(EnumOnOffType en) {
        Log.d(TAG, "setWallmusic(), paras en = " + en);
        try {
            return getService().setWallmusic(en.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumOnOffType getWallmusic() {
        EnumOnOffType en = null;
        try {
            en = EnumOnOffType.values()[getService().getWallmusic()];
            Log.d(TAG, "getWallmusic(), return EnumOnOffType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setSeparateHear(EnumOnOffType en) {
        Log.d(TAG, "setSeparateHear(), paras en = " + en);
        try {
            return getService().setSeparateHear(en.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumOnOffType getSeparateHear() {
        EnumOnOffType en = null;
        try {
            en = EnumOnOffType.values()[getService().getSeparateHear()];
            Log.d(TAG, "getSeparateHear(), return EnumOnOffType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean setTrueBass(EnumOnOffType en) {
        Log.d(TAG, "setTrueBass(), paras en = " + en);
        try {
            return getService().setTrueBass(en.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumOnOffType getTrueBass() {
        EnumOnOffType en = null;
        try {
            en = EnumOnOffType.values()[getService().getTrueBass()];
            Log.d(TAG, "getTrueBass(), return EnumOnOffType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public void setDtvOutputMode(EnumDtvSoundMode enDtvSoundMode) {
        Log.d(TAG, "setDtvOutputMode(), paras enDtvSoundMode = " + enDtvSoundMode);
        try {
            getService().setDtvOutputMode(enDtvSoundMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumDtvSoundMode getDtvOutputMode() {
        EnumDtvSoundMode en = null;
        try {
            en = EnumDtvSoundMode.values()[getService().getDtvOutputMode()];
            Log.d(TAG, "getDtvOutputMode(), return EnumDtvSoundMode " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public void registerOnAudioEventListener(OnAudioEventListener listener) {
        if (this.audioEventClientCallBack == null) {
            this.audioEventClientCallBack = new AudioEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskAudioEventListener", this.audioEventClientCallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.listeners.add(listener);
    }

    public synchronized boolean unregisterOnAudioEventListener(OnAudioEventListener listener) {
        this.listeners.remove(listener);
        if (this.listeners.size() == 0 && this.audioEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskAudioEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.audioEventClientCallBack = null;
        }
        return true;
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize TvAudioManager ");
        if (this.audioEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskAudioEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
