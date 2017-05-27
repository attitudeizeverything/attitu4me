package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.EnumNlaSetIndex;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.factory.vo.EnumAcOnPowerOnMode;
import com.mstar.android.tvapi.factory.vo.EnumAdcSetIndexType;
import com.mstar.android.tvapi.factory.vo.EnumScreenMute;

public class TvFactoryManager {
    private static final String TAG = "TvFactoryManager";
    static TvFactoryManager mInstance;
    private static ITvFactory mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvFactoryManager() {
    }

    public static TvFactoryManager getInstance() {
        if (mInstance == null) {
            synchronized (TvFactoryManager.class) {
                if (mInstance == null) {
                    mInstance = new TvFactoryManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvFactory getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvFactory();
        return mService;
    }

    public boolean execSetInputSource(EnumInputSource inputSource) {
        Log.d(TAG, "execSetInputSource, paras inputSource = " + inputSource);
        try {
            getService().execSetInputSource(inputSource.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setAdcRedGain(int redGain) {
        Log.d(TAG, "setAdcRedGain, paras redGain = " + redGain);
        try {
            getService().setAdcRedGain(redGain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcRedGain() {
        int i = -1;
        try {
            i = getService().getAdcRedGain();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcRedGain, return int " + i);
        return i;
    }

    public boolean setAdcGreenGain(int greenGain) {
        Log.d(TAG, "setAdcGreenGain, paras greenGain = " + greenGain);
        try {
            getService().setAdcGreenGain(greenGain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcGreenGain() {
        int i = -1;
        try {
            i = getService().getAdcGreenGain();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcGreenGain, return int " + i);
        return i;
    }

    public boolean setAdcBlueGain(int blueGain) {
        Log.d(TAG, "setAdcBlueGain, paras blueGain = " + blueGain);
        try {
            getService().setAdcBlueGain(blueGain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcBlueGain() {
        int i = -1;
        try {
            i = getService().getAdcBlueGain();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcBlueGain, return int " + i);
        return i;
    }

    public boolean setAdcRedOffset(int redOffset) {
        Log.d(TAG, "setAdcRedOffset, paras redOffset = " + redOffset);
        try {
            getService().setAdcRedOffset(redOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcRedOffset() {
        int i = -1;
        try {
            i = getService().getAdcRedOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcRedOffset, return int " + i);
        return i;
    }

    public boolean setAdcGreenOffset(int greenOffset) {
        Log.d(TAG, "setAdcGreenOffset, paras greenOffset = " + greenOffset);
        try {
            getService().setAdcGreenOffset(greenOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcGreenOffset() {
        int i = -1;
        try {
            i = getService().getAdcGreenOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcGreenOffset, return int " + i);
        return i;
    }

    public boolean setAdcBlueOffset(int blueOffset) {
        Log.d(TAG, "setAdcBlueOffset, paras blueOffset = " + blueOffset);
        try {
            getService().setAdcBlueOffset(blueOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcBlueOffset() {
        int i = -1;
        try {
            i = getService().getAdcBlueOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcBlueOffset, return int " + i);
        return i;
    }

    public boolean setAdcPhase(int phase) {
        Log.d(TAG, "setAdcPhase, return int " + phase);
        try {
            getService().setAdcPhase(phase);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getAdcPhase() {
        int i = -1;
        try {
            i = getService().getAdcPhase();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAdcPhase, return int " + i);
        return i;
    }

    public boolean execAutoAdc() {
        try {
            getService().execAutoAdc();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setAdcIndex(EnumAdcSetIndexType eIdx) {
        Log.d(TAG, "setAdcIndex, paras eIdx = " + eIdx);
        try {
            return getService().setAdcIndex(eIdx.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumAdcSetIndexType getAdcIndex() {
        EnumAdcSetIndexType en = null;
        try {
            en = EnumAdcSetIndexType.values()[getService().getAdcIndex()];
            Log.d(TAG, "getAdcIndex, return EnumAdcSetIndexType " + en);
            return en;
        } catch (RemoteException e) {
            e.printStackTrace();
            return en;
        }
    }

    public boolean changeWbParameterWhenSourceChange() {
        try {
            return getService().changeWbParameterWhenSourceChange();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setWbRedGain(short redGain) {
        Log.d(TAG, "setWbRedGain, paras redGain = " + redGain);
        try {
            getService().setWbRedGain(redGain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public short getWbRedGain() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbRedGain();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getWbRedGain, return short " + i);
        return i;
    }

    public boolean setWbGreenGain(short greenGain) {
        Log.d(TAG, "setWbGreenGain, paras greenGain = " + greenGain);
        try {
            return getService().setWbGreenGain(greenGain);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getWbGreenGain() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbGreenGain();
            Log.d(TAG, "getWbGreenGain, return short " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setWbBlueGain(short blueGain) {
        Log.d(TAG, "setWbBlueGain, paras blueGain = " + blueGain);
        try {
            return getService().setWbBlueGain(blueGain);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getWbBlueGain() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbBlueGain();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getWbBlueGain, return short " + i);
        return i;
    }

    public boolean setWbRedOffset(short redOffset) {
        Log.d(TAG, "setWbRedOffset, paras redOffset = " + redOffset);
        try {
            return getService().setWbRedOffset(redOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getWbRedOffset() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbRedOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getWbRedOffset, return short " + i);
        return i;
    }

    public boolean setWbGreenOffset(short greenOffset) {
        Log.d(TAG, "setWbGreenOffset, paras greenOffset = " + greenOffset);
        try {
            return getService().setWbGreenOffset(greenOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getWbGreenOffset() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbGreenOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getWbGreenOffset, return short " + i);
        return i;
    }

    public boolean setWbBlueOffset(short blueOffset) {
        Log.d(TAG, "setWbBlueOffset, paras blueOffset = " + blueOffset);
        try {
            return getService().setWbBlueOffset(blueOffset);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getWbBlueOffset() {
        short i = (short) -1;
        try {
            i = (short) getService().getWbBlueOffset();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getWbBlueOffset, return short " + i);
        return i;
    }

    public boolean setVifTop(short vifTop) {
        Log.d(TAG, "setVifTop, paras vifTop = " + vifTop);
        try {
            return getService().setVifTop(vifTop);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVifTop() {
        short i = (short) -1;
        try {
            i = (short) getService().getVifTop();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifTop, return short " + i);
        return i;
    }

    public boolean setVifVgaMaximum(int vifVgaMaximum) {
        Log.d(TAG, "setVifVgaMaximum, paras vifVgaMaximum = " + vifVgaMaximum);
        try {
            return getService().setVifVgaMaximum(vifVgaMaximum);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getVifVgaMaximum() {
        int i = -1;
        try {
            i = getService().getVifVgaMaximum();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifVgaMaximum, return int " + i);
        return i;
    }

    public boolean setVifCrKp(short vifCrKp) {
        Log.d(TAG, "setVifCrKp, paras vifCrKp = " + vifCrKp);
        try {
            return getService().setVifCrKp(vifCrKp);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVifCrKp() {
        short i = (short) -1;
        try {
            i = (short) getService().getVifCrKp();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifCrKp, return int " + i);
        return i;
    }

    public boolean setVifCrKi(short vifCrKi) {
        Log.d(TAG, "setVifCrKi, paras vifCrKi = " + vifCrKi);
        try {
            return getService().setVifCrKi(vifCrKi);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVifCrKi() {
        short i = (short) -1;
        try {
            i = (short) getService().getVifCrKi();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifCrKi, return short " + i);
        return i;
    }

    public boolean setVifAsiaSignalOption(boolean vifAsiaSignalOption) {
        Log.d(TAG, "setVifAsiaSignalOption, paras vifAsiaSignalOption = " + vifAsiaSignalOption);
        try {
            return getService().setVifAsiaSignalOption(vifAsiaSignalOption);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getVifAsiaSignalOption() {
        try {
            return getService().getVifAsiaSignalOption();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVifCrKpKiAdjust(boolean vifCrKpKiAdjust) {
        Log.d(TAG, "setVifCrKpKiAdjust, paras vifCrKpKiAdjust = " + vifCrKpKiAdjust);
        try {
            return getService().setVifCrKpKiAdjust(vifCrKpKiAdjust);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getVifCrKpKiAdjust() {
        try {
            return getService().getVifCrKpKiAdjust();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVifOverModulation(boolean vifOverModulation) {
        Log.d(TAG, "setVifOverModulation, paras vifOverModulation = " + vifOverModulation);
        try {
            return getService().setVifOverModulation(vifOverModulation);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getVifOverModulation() {
        try {
            return getService().getVifOverModulation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVifClampGainOvNegative(int vifClampGainOvNegative) {
        Log.d(TAG, "setVifClampGainOvNegative, paras vifClampGainOvNegative = " + vifClampGainOvNegative);
        try {
            return getService().setVifClampGainOvNegative(vifClampGainOvNegative);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getVifClampGainOvNegative() {
        int i = -1;
        try {
            i = getService().getVifClampGainOvNegative();
            Log.d(TAG, "getVifClampGainOvNegative, return int " + i);
            return i;
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    public boolean setChinaDescramblerBox(short chinaDescramblerBox) {
        Log.d(TAG, "setChinaDescramblerBox, paras chinaDescramblerBox = " + chinaDescramblerBox);
        try {
            return getService().setChinaDescramblerBox(chinaDescramblerBox);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getChinaDescramblerBox() {
        short i = (short) -1;
        try {
            i = (short) getService().getChinaDescramblerBox();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getChinaDescramblerBox, return short " + i);
        return i;
    }

    public boolean setDelayReduce(short delayReduce) {
        Log.d(TAG, "setDelayReduce, paras delayReduce = " + delayReduce);
        try {
            return getService().setDelayReduce(delayReduce);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getDelayReduce() {
        short i = (short) -1;
        try {
            i = (short) getService().getDelayReduce();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getDelayReduce, return short " + i);
        return i;
    }

    public boolean setVifCrThreshold(int vifCrThreshold) {
        Log.d(TAG, "setVifCrThreshold, paras vifCrThreshold = " + vifCrThreshold);
        try {
            return getService().setVifCrThreshold(vifCrThreshold);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getVifCrThreshold() {
        int i = -1;
        try {
            i = getService().getVifCrThreshold();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifCrThreshold, return int " + i);
        return i;
    }

    public boolean setVifVersion(short vifVersion) {
        Log.d(TAG, "setVifVersion, paras vifVersion = " + vifVersion);
        try {
            return getService().setVifVersion(vifVersion);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVifVersion() {
        short i = (short) -1;
        try {
            i = (short) getService().getVifVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifVersion, return short " + i);
        return i;
    }

    public boolean setVifAgcRef(short vifAgcRef) {
        Log.d(TAG, "setVifAgcRef, paras vifAgcRef = " + vifAgcRef);
        try {
            return getService().setVifAgcRef(vifAgcRef);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVifAgcRef() {
        short i = (short) -1;
        try {
            i = (short) getService().getVifVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifAgcRef, return short " + i);
        return i;
    }

    public boolean setGainDistributionThreshold(int gainDistributionThreshold) {
        Log.d(TAG, "setGainDistributionThreshold, paras gainDistributionThreshold = " + gainDistributionThreshold);
        try {
            return getService().setGainDistributionThreshold(gainDistributionThreshold);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getGainDistributionThreshold() {
        int i = -1;
        try {
            i = getService().getVifCrThreshold();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifCrThreshold, return int " + i);
        return i;
    }

    public boolean setAefcD4(short aefcD4) {
        Log.d(TAG, "setAefcD4, paras aefcD4 = " + aefcD4);
        try {
            return getService().setAefcD4(aefcD4);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD4() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD4();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD4, return short " + i);
        return i;
    }

    public boolean setAefcD5Bit2(short aefcD5Bit2) {
        Log.d(TAG, "setAefcD5Bit2, paras aefcD5Bit2 = " + aefcD5Bit2);
        try {
            return getService().setAefcD5Bit2(aefcD5Bit2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD5Bit2() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD5Bit2();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD5Bit2, return short " + i);
        return i;
    }

    public boolean setAefcD8Bit3210(short aefcD8Bit3210) {
        Log.d(TAG, "setAefcD8Bit3210, paras aefcD8Bit3210 = " + aefcD8Bit3210);
        try {
            return getService().setAefcD8Bit3210(aefcD8Bit3210);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD8Bit3210() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD8Bit3210();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD8Bit3210, return short " + i);
        return i;
    }

    public boolean setAefcD9Bit0(short aefcD9Bit0) {
        Log.d(TAG, "setAefcD9Bit0, paras aefcD9Bit0 = " + aefcD9Bit0);
        try {
            return getService().setAefcD9Bit0(aefcD9Bit0);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD9Bit0() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD9Bit0();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD9Bit0, return short " + i);
        return i;
    }

    public boolean setAefcD7HighBound(short aefcD7HighBound) {
        Log.d(TAG, "setAefcD7HighBound, paras aefcD7HighBound = " + aefcD7HighBound);
        try {
            return getService().setAefcD7HighBound(aefcD7HighBound);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD7HighBound() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD7HighBound();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD7HighBound, return short " + i);
        return i;
    }

    public boolean setAefcD7LowBound(short aefcD7LowBound) {
        Log.d(TAG, "setAefcD7LowBound, paras aefcD7LowBound = " + aefcD7LowBound);
        try {
            return getService().setAefcD7LowBound(aefcD7LowBound);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcD7LowBound() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcD7LowBound();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcD7LowBound, return short " + i);
        return i;
    }

    public boolean setAefcA0(short aefcA0) {
        Log.d(TAG, "setAefcA0, paras aefcA0 = " + aefcA0);
        try {
            return getService().setAefcA0(aefcA0);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcA0() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcA0();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcA0, return short " + i);
        return i;
    }

    public boolean setAefcA1(short aefcA1) {
        Log.d(TAG, "setAefcA1, paras aefcA1 = " + aefcA1);
        try {
            return getService().setAefcA1(aefcA1);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcA1() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcA1();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefcA1, return short " + i);
        return i;
    }

    public boolean setAefc66Bit76(short aefc66Bit76) {
        Log.d(TAG, "setAefc66Bit76, paras aefc66Bit76 = " + aefc66Bit76);
        try {
            return getService().setAefc66Bit76(aefc66Bit76);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefc66Bit76() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefc66Bit76();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefc66Bit76, return short " + i);
        return i;
    }

    public boolean setAefc6EBit7654(short aefc6EBit7654) {
        Log.d(TAG, "setAefc6EBit7654, paras aefc6EBit7654 = " + aefc6EBit7654);
        try {
            return getService().setAefc6EBit7654(aefc6EBit7654);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefc6EBit7654() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefc6EBit7654();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefc6EBit7654, return short " + i);
        return i;
    }

    public boolean setAefc6EBit3210(short aefc6EBit3210) {
        Log.d(TAG, "setAefc6EBit3210, paras aefc6EBit3210 = " + aefc6EBit3210);
        try {
            return getService().setAefc6EBit3210(aefc6EBit3210);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefc6EBit3210() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefc6EBit3210();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefc6EBit3210, return short " + i);
        return i;
    }

    public boolean setAefc43(short aefc43) {
        Log.d(TAG, "setAefc43, paras aefc43 = " + aefc43);
        try {
            return getService().setAefc43(aefc43);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefc43() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefc43();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefc43, return short " + i);
        return i;
    }

    public boolean setAefc44(short aefc44) {
        Log.d(TAG, "setAefc44, paras aefc44 = " + aefc44);
        try {
            return getService().setAefc44(aefc44);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefc44() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefc44();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAefc44, return short " + i);
        return i;
    }

    public boolean setAefcCB(short aefcCB) {
        Log.d(TAG, "setAefcCB, paras aefcCB = " + aefcCB);
        try {
            return getService().setAefcCB(aefcCB);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcCb() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcCb();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifVgaMaximum, return short " + i);
        return i;
    }

    public boolean setAefcCfBit2Atv(short aefcCfBit2Atv) {
        Log.d(TAG, "setAefcCfBit2Atv, paras aefcCfBit2Atv = " + aefcCfBit2Atv);
        try {
            return getService().setAefcCfBit2Atv(aefcCfBit2Atv);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcCfBit2Atv() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcCb();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifVgaMaximum, return short " + i);
        return i;
    }

    public boolean setAefcCfBit2Av(short aefcCfBit2Av) {
        Log.d(TAG, "setAefcCfBit2Av, paras aefcCfBit2Av = " + aefcCfBit2Av);
        try {
            return getService().setAefcCfBit2Av(aefcCfBit2Av);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAefcCfBit2Av() {
        short i = (short) -1;
        try {
            i = (short) getService().getAefcCb();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVifVgaMaximum, return short " + i);
        return i;
    }

    public boolean setVdDspVersion(short vdDspVersion) {
        Log.d(TAG, "setVdDspVersion, paras vdDspVersion = " + vdDspVersion);
        try {
            return getService().setVdDspVersion(vdDspVersion);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getVdDspVersion() {
        short i = (short) -1;
        try {
            i = (short) getService().getVdDspVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getVdDspVersion, return short " + i);
        return i;
    }

    public boolean setAudioHiDevMode(int audioHiDevMode) {
        Log.d(TAG, "setAudioHiDevMode, paras audioHiDevMode = " + audioHiDevMode);
        try {
            return getService().setAudioHiDevMode(audioHiDevMode);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getAudioHiDevMode() {
        short i = (short) -1;
        try {
            i = (short) getService().getAudioHiDevMode();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAudioHiDevMode, return short " + i);
        return i;
    }

    public boolean setAudioNrThreshold(short audioNrThreshold) {
        Log.d(TAG, "setAudioNrThreshold, paras audioNrThreshold = " + audioNrThreshold);
        try {
            return getService().setAudioNrThreshold(audioNrThreshold);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAudioNrThreshold() {
        short i = (short) -1;
        try {
            i = (short) getService().getAudioNrThreshold();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAudioNrThreshold, return short " + i);
        return i;
    }

    public boolean setAudioSifThreshold(short audioSifThreshold) {
        Log.d(TAG, "setAudioSifThreshold, paras audioSifThreshold = " + audioSifThreshold);
        try {
            return getService().setAudioSifThreshold(audioSifThreshold);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAudioSifThreshold() {
        short i = (short) -1;
        try {
            i = (short) getService().getAudioSifThreshold();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAudioSifThreshold, return short " + i);
        return i;
    }

    public boolean setAudioDspVersion(short aduioDspVersion) {
        Log.d(TAG, "setAudioDspVersion, paras aduioDspVersion = " + aduioDspVersion);
        try {
            return getService().setAudioDspVersion(aduioDspVersion);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAudioDspVersion() {
        short i = (short) -1;
        try {
            i = (short) getService().getAudioDspVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAudioDspVersion, return short " + i);
        return i;
    }

    public boolean setCurveType(EnumNlaSetIndex curveTypeIndex) {
        Log.d(TAG, "setCurveType, paras curveTypeIndex = " + curveTypeIndex);
        try {
            return getService().setCurveType(curveTypeIndex.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumNlaSetIndex getCurveType() {
        EnumNlaSetIndex i = null;
        try {
            i = EnumNlaSetIndex.values()[getService().getCurveType()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getTestPattern" + i);
        return i;
    }

    public boolean setOsdV0Nonlinear(short nonlinearVal) {
        Log.d(TAG, "setOsdV0Nonlinear, paras nonlinearVal = " + nonlinearVal);
        try {
            return getService().setOsdV0Nonlinear(nonlinearVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOsdV0Nonlinear() {
        short i = (short) -1;
        try {
            i = (short) getService().getOsdV0Nonlinear();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOsdV0Nonlinear, return short " + i);
        return i;
    }

    public boolean setOsdV25Nonlinear(short nonlinearVal) {
        Log.d(TAG, "setOsdV25Nonlinear, paras nonlinearVal = " + nonlinearVal);
        try {
            return getService().setOsdV25Nonlinear(nonlinearVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOsdV25Nonlinear() {
        short i = (short) -1;
        try {
            i = (short) getService().getOsdV25Nonlinear();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOsdV25Nonlinear, return short " + i);
        return i;
    }

    public boolean setOsdV50Nonlinear(short nonlinearVal) {
        Log.d(TAG, "setOsdV50Nonlinear, paras nonlinearVal = " + nonlinearVal);
        try {
            return getService().setOsdV50Nonlinear(nonlinearVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOsdV50Nonlinear() {
        short i = (short) -1;
        try {
            i = (short) getService().getOsdV50Nonlinear();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOsdV50Nonlinear, return short " + i);
        return i;
    }

    public boolean setOsdV75Nonlinear(short nonlinearVal) {
        Log.d(TAG, "setOsdV75Nonlinear, paras nonlinearVal = " + nonlinearVal);
        try {
            return getService().setOsdV75Nonlinear(nonlinearVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOsdV75Nonlinear() {
        short i = (short) -1;
        try {
            i = (short) getService().getOsdV75Nonlinear();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOsdV75Nonlinear, return short " + i);
        return i;
    }

    public boolean setOsdV100Nonlinear(short nonlinearVal) {
        Log.d(TAG, "setOsdV100Nonlinear, paras nonlinearVal = " + nonlinearVal);
        try {
            return getService().setOsdV100Nonlinear(nonlinearVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOsdV100Nonlinear() {
        short i = (short) -1;
        try {
            i = (short) getService().getOsdV100Nonlinear();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOsdV100Nonlinear, return short " + i);
        return i;
    }

    public boolean setMiuEnable(boolean miuSscEnable) {
        Log.d(TAG, "setMiuEnable, paras miuSscEnable = " + miuSscEnable);
        try {
            return getService().setMiuEnable(miuSscEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getMiuEnable() {
        try {
            return getService().getMiuEnable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setMiuModulation(int miuSscSpan) {
        Log.d(TAG, "setMiuModulation, paras miuSscSpan = " + miuSscSpan);
        try {
            return getService().setMiuModulation(miuSscSpan);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getMiuModulation() {
        int i = -1;
        try {
            i = getService().getMiuModulation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getMiuModulation, return int " + i);
        return i;
    }

    public boolean setMiuPercentage(int miuSscStep) {
        Log.d(TAG, "setMiuPercentage, paras miuSscStep = " + miuSscStep);
        try {
            return getService().setMiuPercentage(miuSscStep);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getMiuPercentage() {
        int i = -1;
        try {
            i = getService().getMiuPercentage();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getMiuPercentage, return int " + i);
        return i;
    }

    public boolean setLvdsEnable(boolean lvdsSscEnable) {
        Log.d(TAG, "setLvdsEnable, paras lvdsSscEnable = " + lvdsSscEnable);
        try {
            return getService().setLvdsEnable(lvdsSscEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getLvdsenable() {
        try {
            return getService().getLvdsenable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setLvdsModulation(int lvdsSscSpan) {
        Log.d(TAG, "setLvdsModulation, paras lvdsSscSpan = " + lvdsSscSpan);
        try {
            return getService().setLvdsModulation(lvdsSscSpan);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLvdsModulation() {
        int i = -1;
        try {
            i = getService().getLvdsModulation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getLvdsModulation, return int " + i);
        return i;
    }

    public boolean setLvdsPercentage(int lvdsSscStep) {
        Log.d(TAG, "setLvdsPercentage, paras lvdsSscStep = " + lvdsSscStep);
        try {
            return getService().setLvdsPercentage(lvdsSscStep);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLvdsPercentage() {
        int i = -1;
        try {
            i = getService().getLvdsPercentage();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getLvdsPercentage, return int " + i);
        return i;
    }

    public boolean setPeqFoCoarse(int index, int coarseVal) {
        Log.d(TAG, "setPeqFoCoarse, paras coarseVal = " + coarseVal);
        try {
            return getService().setPeqFoCoarse(index, coarseVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPeqFoCoarse(int index) {
        int i = -1;
        try {
            i = getService().getPeqFoCoarse(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPeqFoCoarse, return int " + i);
        return i;
    }

    public boolean setPeqFoFine(int index, int fineVal) {
        Log.d(TAG, "setPeqFoFine, paras fineVal = " + fineVal);
        try {
            return getService().setPeqFoFine(index, fineVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPeqFoFine(int index) {
        int i = -1;
        try {
            i = getService().getPeqFoFine(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPeqFoFine, return int " + i);
        return i;
    }

    public boolean setPeqGain(int index, int gainVal) {
        Log.d(TAG, "setPeqGain, paras gainVal = " + gainVal);
        try {
            return getService().setPeqGain(index, gainVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPeqGain(int index) {
        int i = -1;
        try {
            i = getService().getPeqGain(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPeqGain, return int " + i);
        return i;
    }

    public boolean setPeqQ(int index, int QValue) {
        Log.d(TAG, "setPeqQ, paras QValue = " + QValue);
        try {
            return getService().setPeqQ(index, QValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getPeqQ(int index) {
        int i = -1;
        try {
            i = getService().getPeqQ(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPeqQ, return int " + i);
        return i;
    }

    public String getSoftWareVersion() {
        String i = null;
        try {
            i = getService().getSoftWareVersion();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getSoftWareVersion, return String " + i);
        return i;
    }

    public String getBoardType() {
        String i = null;
        try {
            i = getService().getBoardType();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getBoardType, return String " + i);
        return i;
    }

    public String getPanelType() {
        String i = null;
        try {
            i = getService().getPanelType();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPanelType, return String " + i);
        return i;
    }

    public String getCompileTime() {
        String i = null;
        try {
            i = getService().getCompileTime();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getCompileTime, return String " + i);
        return i;
    }

    public boolean setWatchDogMode(boolean isEnable) {
        Log.d(TAG, "setWatchDogMode, paras isEnable = " + isEnable);
        try {
            return getService().setWatchDogMode(isEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getWatchDogMode() {
        try {
            return getService().getWatchDogMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setTestPattern(EnumScreenMute testPatternMode) {
        Log.d(TAG, "setTestPattern, paras testPatternMode = " + testPatternMode);
        try {
            return getService().setTestPattern(testPatternMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumScreenMute getTestPattern() {
        EnumScreenMute i = null;
        try {
            i = EnumScreenMute.values()[getService().getTestPattern()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getTestPattern, return EnumScreenMute " + i);
        return i;
    }

    public boolean restoreToDefault() {
        try {
            return getService().restoreToDefault();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPowerOnMode(EnumAcOnPowerOnMode factoryPowerMode) {
        Log.d(TAG, "setPowerOnMode, paras factoryPowerMode = " + factoryPowerMode);
        try {
            return getService().setPowerOnMode(factoryPowerMode.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumAcOnPowerOnMode getPowerOnMode() {
        EnumAcOnPowerOnMode i = null;
        try {
            i = EnumAcOnPowerOnMode.values()[getService().getPowerOnMode()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanSourceType, return EnumInputSource " + i);
        return i;
    }

    public boolean setUartOnOff(boolean isEnable) {
        Log.d(TAG, "setUartOnOff, paras isEnable = " + isEnable);
        try {
            return getService().setUartOnOff(isEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getUartOnOff() {
        try {
            return getService().getUartOnOff();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean enableUartDebug() {
        try {
            return getService().enableUartDebug();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setDtvAvAbnormalDelay(boolean isEnable) {
        Log.d(TAG, "setDtvAvAbnormalDelay, paras isEnable = " + isEnable);
        try {
            return getService().setDtvAvAbnormalDelay(isEnable);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getDtvAvAbnormalDelay() {
        try {
            return getService().getDtvAvAbnormalDelay();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setFactoryPreSetFeature(int factoryPreset) {
        Log.d(TAG, "setFactoryPreSetFeature, paras factoryPreset = " + factoryPreset);
        try {
            return getService().setFactoryPreSetFeature(factoryPreset);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getFactoryPreSetFeature() {
        int i = -1;
        try {
            i = (short) getService().getFactoryPreSetFeature();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getFactoryPreSetFeature, return int " + i);
        return i;
    }

    public boolean setPanelSwing(short panleSwingVal) {
        Log.d(TAG, "setPanelSwing, paras panleSwingVal = " + panleSwingVal);
        try {
            return getService().setPanelSwing(panleSwingVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getPanelSwing() {
        short i = (short) -1;
        try {
            i = (short) getService().getPanelSwing();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getPanelSwing, return short " + i);
        return i;
    }

    public boolean setAudioPrescale(short audioPrescaleVal) {
        Log.d(TAG, "setAudioPrescale, paras audioPrescaleVal = " + audioPrescaleVal);
        try {
            return getService().setAudioPrescale(audioPrescaleVal);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getAudioPrescale() {
        short i = (short) -1;
        try {
            i = (short) getService().getAudioPrescale();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getAudioPrescale, return short " + i);
        return i;
    }

    public boolean set3DSelfAdaptiveLevel(int threeDSelfAdaptiveLevel) {
        ITvFactory service = getService();
        Log.d(TAG, "set3DSelfAdaptiveLevel, paras threeDSelfAdaptiveLevel = " + threeDSelfAdaptiveLevel);
        try {
            return service.set3DSelfAdaptiveLevel(threeDSelfAdaptiveLevel);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int get3DSelfAdaptiveLevel() {
        int i = -1;
        try {
            i = (short) getService().get3DSelfAdaptiveLevel();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "get3DSelfAdaptiveLevel, return int " + i);
        return i;
    }

    public boolean setEnvironment(String name, String value) {
        Log.d(TAG, "setEnvironment, paras name = " + name);
        try {
            return getService().setEnvironment(name, value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setOverScanSourceType(EnumInputSource SourceType) {
        Log.d(TAG, "setOverScanSourceType, paras SourceType = " + SourceType);
        try {
            return getService().setOverScanSourceType(SourceType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumInputSource getOverScanSourceType() {
        EnumInputSource en = null;
        try {
            en = EnumInputSource.values()[getService().getOverScanSourceType()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanSourceType, return EnumInputSource " + en);
        return en;
    }

    public boolean setOverScanHSize(short hSize) {
        Log.d(TAG, "setOverScanHSize, paras hSize = " + hSize);
        try {
            return getService().setOverScanHSize(hSize);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOverScanHSize() {
        short s = (short) -1;
        try {
            s = (short) getService().getOverScanHSize();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanHSize, return short " + s);
        return s;
    }

    public boolean setOverScanHPosition(short hPosition) {
        ITvFactory service = getService();
        Log.d(TAG, "setOverScanHPosition, paras hPosition = " + hPosition);
        try {
            return service.setOverScanHPosition(hPosition);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOverScanHPosition() {
        short s = (short) -1;
        try {
            s = (short) getService().getOverScanHPosition();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanHPosition, return short " + s);
        return s;
    }

    public boolean setOverScanVSize(short vSize) {
        ITvFactory service = getService();
        Log.d(TAG, "setOverScanVSize, paras vSize = " + vSize);
        try {
            return service.setOverScanVSize(vSize);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOverScanVSize() {
        short s = (short) -1;
        try {
            s = (short) getService().getOverScanVSize();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanVSize, return short " + s);
        return s;
    }

    public boolean setOverScanVPosition(short vPosition) {
        Log.d(TAG, "setOverScanVPosition, paras vPosition = " + vPosition);
        try {
            return getService().setOverScanVPosition(vPosition);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOverScanVPosition() {
        short s = (short) -1;
        try {
            s = (short) getService().getOverScanVPosition();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getOverScanVPosition, return short " + s);
        return s;
    }
}
