package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.ColorTemperatureExData;
import com.mstar.android.tvapi.common.vo.EnumColorTemperature;
import com.mstar.android.tvapi.common.vo.EnumPictureMode;
import com.mstar.android.tvapi.common.vo.EnumVideoArcType;
import com.mstar.android.tvapi.common.vo.EnumVideoItem;
import com.mstar.android.tvapi.common.vo.Film.EnumFilm;
import com.mstar.android.tvapi.common.vo.NoiseReduction.EnumNoiseReduction;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoInfo;
import com.mstar.android.tvapi.common.vo.VideoWindowType;

public class TvPictureManager {
    private static final String TAG = "TvPictureManager";
    static TvPictureManager mInstance;
    private static ITvPicture mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvPictureManager() {
    }

    public static TvPictureManager getInstance() {
        if (mInstance == null) {
            synchronized (TvPictureManager.class) {
                if (mInstance == null) {
                    mInstance = new TvPictureManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvPicture getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvPicture();
        return mService;
    }

    public boolean setPictureModeIdx(EnumPictureMode ePicMode) {
        Log.d(TAG, "setPictureModeIdx(), paras ePicMode = " + ePicMode);
        try {
            return getService().setPictureModeIdx(ePicMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPictureMode getPictureModeIdx() {
        EnumPictureMode en = null;
        try {
            en = EnumPictureMode.values()[getService().getPictureModeIdx()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPictureModeIdx(), return EnumPictureMode " + en);
        return en;
    }

    public boolean setVideoArc(EnumVideoArcType eArcIdx) {
        Log.d(TAG, "setVideoArc(), paras eArcIdx = " + eArcIdx);
        try {
            return getService().setVideoArc(eArcIdx.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumVideoArcType getVideoArc() {
        EnumVideoArcType en = null;
        try {
            en = EnumVideoArcType.values()[getService().getVideoArc()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVideoArc(), return EnumVideoArcType " + en);
        return en;
    }

    public boolean setVideoItem(EnumVideoItem eIndex, int value) {
        Log.d(TAG, "setVideoItem(), paras eIndex = " + eIndex + ", value = " + value);
        try {
            return getService().setVideoItem(eIndex.ordinal(), value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getVideoItem(EnumVideoItem eIndex) {
        Log.d(TAG, "getVideoItem(), paras eIndex = " + eIndex);
        int i = -1;
        try {
            i = getService().getVideoItem(eIndex.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVideoItem(), return int " + i);
        return i;
    }

    public boolean setBacklight(int value) {
        Log.d(TAG, "setBacklight(), paras value = " + value);
        try {
            return getService().setBacklight(value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getBacklight() {
        int i = -1;
        try {
            i = getService().getBacklight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getBacklight(), return int " + i);
        return i;
    }

    public boolean setColorTempIdx(EnumColorTemperature eColorTemp) {
        Log.d(TAG, "setColorTempIdx(), paras eColorTemp = " + eColorTemp);
        try {
            return getService().setColorTempIdx(eColorTemp.getValue());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumColorTemperature getColorTempIdx() {
        ITvPicture service = getService();
        try {
            for (EnumColorTemperature en : EnumColorTemperature.values()) {
                if (en.getValue() == service.getColorTempIdx()) {
                    Log.d(TAG, "getColorTempIdx(), return EnumColorTemperature " + en);
                    return en;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean setColorTempPara(ColorTemperatureExData stColorTemp) {
        Log.d(TAG, "setColorTempPara, paras ColorTemperatureExData stColorTemp.redGain = " + stColorTemp.redGain + ", stColorTemp.blueGain = " + stColorTemp.blueGain + ", stColorTemp.greenGain = " + stColorTemp.greenGain + ", stColorTemp.redOffset = " + stColorTemp.redOffset + ", stColorTemp.blueOffse = " + stColorTemp.blueOffset + ", stColorTemp.greenOffset = " + stColorTemp.greenOffset);
        try {
            return getService().setColorTempPara(stColorTemp);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ColorTemperatureExData getColorTempPara() {
        ColorTemperatureExData tv = null;
        try {
            tv = getService().getColorTempPara();
            Log.d(TAG, "getColorTempPara, return ColorTemperatureExData redGain = " + tv.redGain + ", blueGain = " + tv.blueGain + ", greenGain = " + tv.greenGain + ", redOffset = " + tv.redOffset + ", blueOffse = " + tv.blueOffset + ", greenOffset = " + tv.greenOffset);
            return tv;
        } catch (RemoteException e) {
            e.printStackTrace();
            return tv;
        }
    }

    public boolean setNR(EnumNoiseReduction eNRIdx) {
        Log.d(TAG, "setNR(), paras eNRIdx = " + eNRIdx);
        try {
            return getService().setNR(eNRIdx.getValue());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumNoiseReduction getNR() {
        ITvPicture service = getService();
        try {
            for (EnumNoiseReduction en : EnumNoiseReduction.values()) {
                if (en.getValue() == service.getNR()) {
                    Log.d(TAG, "getNR(), return en " + en);
                    return en;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean setPCHPos(int hpos) {
        Log.d(TAG, "setPCHPos(), paras hpos = " + hpos);
        try {
            return getService().setPCHPos(hpos);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPCHPos() {
        int i = -1;
        try {
            i = getService().getPCHPos();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPCHPos(), return int " + i);
        return i;
    }

    public boolean setPCVPos(int vpos) {
        Log.d(TAG, "setPCVPos(), paras vpos = " + vpos);
        try {
            return getService().setPCVPos(vpos);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPCVPos() {
        int i = -1;
        try {
            i = getService().getPCVPos();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPCVPos(), return int " + i);
        return i;
    }

    public boolean setPCClock(int clock) {
        Log.d(TAG, "setPCClock(), paras clock = " + clock);
        try {
            return getService().setPCClock(clock);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPCClock() {
        int i = -1;
        try {
            i = getService().getPCClock();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPCClock(), return int " + i);
        return i;
    }

    public boolean setPCPhase(int phase) {
        Log.d(TAG, "setPCPhase(), paras phase = " + phase);
        try {
            return getService().setPCPhase(phase);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPCPhase() {
        int i = -1;
        try {
            i = getService().getPCPhase();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPCPhase(), return int " + i);
        return i;
    }

    public boolean execAutoPc() {
        try {
            return getService().execAutoPc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean freezeImage() {
        try {
            return getService().freezeImage();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unFreezeImage() {
        try {
            return getService().unFreezeImage();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setDisplayWindow(VideoWindowType videoWindowType) {
        Log.d(TAG, "setDisplayWindow, paras VideoWindowType videoWindowType.x = " + videoWindowType.f60x + ", videoWindowType.y = " + videoWindowType.f61y + ", videoWindowType.width = " + videoWindowType.width + ", videoWindowType.height = " + videoWindowType.height);
        try {
            getService().setDisplayWindow(videoWindowType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public VideoInfo getVideoInfo() {
        VideoInfo videoInfo = null;
        try {
            videoInfo = getService().getVideoInfo();
            Log.d(TAG, "getVideoInfo, return VideoInfo videoInfo.frameRate = " + videoInfo.frameRate + ", videoInfo.hResolution = " + videoInfo.hResolution + ", videoInfo.modeIndex = " + videoInfo.modeIndex + ", videoInfo.vResolution = " + videoInfo.vResolution);
            return videoInfo;
        } catch (RemoteException e) {
            e.printStackTrace();
            return videoInfo;
        }
    }

    public boolean setColorRange(byte value) {
        Log.d(TAG, "setAtvChannel(), paras value = " + value);
        try {
            return getService().setColorRange(value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte getColorRange() {
        byte b = (byte) -1;
        try {
            b = getService().getColorRange();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getColorRange(), return byte " + b);
        return b;
    }

    public boolean setFilmMode(EnumFilm eMode) {
        Log.d(TAG, "setAtvChannel(), paras eMode = " + eMode);
        try {
            return getService().setFilmMode(eMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumFilm getFilmMode() {
        ITvPicture service = getService();
        try {
            for (EnumFilm en : EnumFilm.values()) {
                if (en.getValue() == service.getFilmMode()) {
                    Log.d(TAG, "getFilmMode(), return EnumFilm " + en);
                    return en;
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean enableDlc() {
        try {
            return getService().enableDlc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableDlc() {
        try {
            return getService().disableDlc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDlcEnabled() {
        try {
            return getService().isDlcEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enableDcc() {
        try {
            return getService().enableDcc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableDcc() {
        try {
            return getService().disableDcc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDccEnabled() {
        try {
            return getService().isDccEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enableDbc() {
        try {
            return getService().enableDbc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean disableDbc() {
        try {
            return getService().disableDbc();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDbcEnabled() {
        try {
            return getService().isDbcEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVideoItemByInputSource(EnumVideoItem eIndex, int value, EnumInputSource input) {
        Log.d(TAG, "setVideoItem(), paras eIndex = " + eIndex + ", value = " + value + ", input = " + input);
        try {
            return getService().setVideoItemByInputSource(eIndex.ordinal(), value, input.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getVideoItemByInputSource(EnumVideoItem eIndex, EnumInputSource input) {
        Log.d(TAG, "getVideoItem(), paras eIndex = " + eIndex + ", input = " + input);
        int i = -1;
        try {
            i = getService().getVideoItemByInputSource(eIndex.ordinal(), input.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVideoItem(), return int " + i);
        return i;
    }

    public void enableBacklight() {
        Log.d(TAG, "enableBacklight");
        try {
            getService().enableBacklight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void disableBacklight() {
        Log.d(TAG, "disableBacklight");
        try {
            getService().disableBacklight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void SetResolution(byte resloution) {
        try {
            getService().setResolution(resloution);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public byte GetResloution() {
        try {
            return getService().getResolution();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    public void SetReproduce(int rate) {
        try {
            getService().setReproduceRate(rate);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int GetReproduce() {
        try {
            return getService().getReproduceRate();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean setMEMCMode(String interfaceCommand) {
        try {
            return getService().setMEMCMode(interfaceCommand);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int[] getPcModeInfo() {
        try {
            return getService().getPcModeInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
