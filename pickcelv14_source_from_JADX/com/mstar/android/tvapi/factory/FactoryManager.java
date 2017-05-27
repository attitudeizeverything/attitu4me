package com.mstar.android.tvapi.factory;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumColorTemperature;
import com.mstar.android.tvapi.common.vo.EnumScalerWindow;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.factory.vo.DisplayResolutionType.EnumDisplayResolutionType;
import com.mstar.android.tvapi.factory.vo.EnumAcOnPowerOnMode;
import com.mstar.android.tvapi.factory.vo.EnumAdcSetIndexType;
import com.mstar.android.tvapi.factory.vo.EnumFwType;
import com.mstar.android.tvapi.factory.vo.EnumPqUpdateFile;
import com.mstar.android.tvapi.factory.vo.EnumScreenMute;
import com.mstar.android.tvapi.factory.vo.FactoryNsVdSet;
import com.mstar.android.tvapi.factory.vo.PanelVersionInfo;
import com.mstar.android.tvapi.factory.vo.PictureModeValue;
import com.mstar.android.tvapi.factory.vo.PqlCalibrationData;
import com.mstar.android.tvapi.factory.vo.UrsaVersionInfo;
import com.mstar.android.tvapi.factory.vo.WbGainOffset;
import com.mstar.android.tvapi.factory.vo.WbGainOffsetEx;
import java.lang.ref.WeakReference;

public class FactoryManager {
    private static FactoryManager _factoryManager;
    private int mFactoryManagerContext;
    private int mNativeContext;

    private final native String getUpdatePqFilePath(int i) throws TvCommonException;

    private final native WbGainOffset naitve_getWbGainOffset(int i) throws TvCommonException;

    private final native void native_finalize();

    private final native PqlCalibrationData native_getAdcGainOffset(int i, int i2) throws TvCommonException;

    private final native int native_getDisplayResolution() throws TvCommonException;

    private native int native_getEnvironmentPowerMode() throws TvCommonException;

    private native int native_getFwVersion(int i);

    private native short native_getResolutionMappingIndex(int i) throws TvCommonException;

    private final native WbGainOffsetEx native_getWbGainOffsetEx(int i, int i2) throws TvCommonException;

    private static final native void native_init();

    private final native void native_setAdcGainOffset(int i, int i2, PqlCalibrationData pqlCalibrationData) throws TvCommonException;

    private native boolean native_setEnvironmentPowerMode(int i) throws TvCommonException;

    private final native void native_setVideoTestPattern(int i) throws TvCommonException;

    private final native void native_setWbGainOffset(int i, short s, short s2, short s3, short s4, short s5, short s6) throws TvCommonException;

    private final native void native_setWbGainOffsetEx(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws TvCommonException;

    private final native void native_setup(Object obj);

    public final native boolean autoAdc() throws TvCommonException;

    public final native void copySubColorDataToAllSource() throws TvCommonException;

    public final native void copyWhiteBalanceSettingToAllSource() throws TvCommonException;

    public final native boolean disablePVRRecordAll() throws TvCommonException;

    public final native boolean disableUart() throws TvCommonException;

    public final native boolean disableWdt() throws TvCommonException;

    public final native boolean enablePVRRecordAll() throws TvCommonException;

    public final native boolean enableUart() throws TvCommonException;

    @Deprecated
    public native boolean enableUartDebug() throws TvCommonException;

    public final native boolean enableWdt() throws TvCommonException;

    public native short getEnvironmentPowerOnMusicVolume() throws TvCommonException;

    public native String getMACAddrString() throws TvCommonException;

    public final native PictureModeValue getPictureModeValue() throws TvCommonException;

    public final native int getQmapCurrentTableIdx(short s) throws TvCommonException;

    public final native String getQmapIpName(short s) throws TvCommonException;

    public final native int getQmapIpNum() throws TvCommonException;

    public final native String getQmapTableName(short s, short s2) throws TvCommonException;

    public final native int getQmapTableNum(short s) throws TvCommonException;

    public native String getSoftwareVersion() throws TvCommonException;

    public final native boolean getUartEnv() throws TvCommonException;

    public native boolean getWOLEnableStatus() throws TvCommonException;

    public final native boolean isAgingModeOn() throws TvCommonException;

    public final native boolean isPVRRecordAllOn() throws TvCommonException;

    public final native boolean isUartOn() throws TvCommonException;

    public final native boolean isWdtOn() throws TvCommonException;

    public final native void loadPqTable(int i, int i2) throws TvCommonException;

    public final native String native_getPQVersion(int i) throws TvCommonException;

    public final native PanelVersionInfo panelGetVersionInfo() throws TvCommonException;

    public native short[] readBytesFromI2C(int i, short[] sArr, short s) throws TvCommonException;

    public final native boolean resetDisplayResolution() throws TvCommonException;

    public final native boolean restoreDbFromUsb() throws TvCommonException;

    public native void restoreFactoryAtvProgramTable(short s) throws TvCommonException;

    public native void restoreFactoryDtvProgramTable(short s) throws TvCommonException;

    public final native boolean setBrightness(short s) throws TvCommonException;

    public native void setCIPlusKeyViaUsbKey() throws TvCommonException;

    public final native boolean setContrast(short s) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    public native boolean setEnvironmentPowerOnMusicVolume(short s) throws TvCommonException;

    public final native void setFactoryVdInitParameter(FactoryNsVdSet factoryNsVdSet) throws TvCommonException;

    public final native void setFactoryVdParameter(FactoryNsVdSet factoryNsVdSet) throws TvCommonException;

    public native void setHDCPKeyViaUsbKey() throws TvCommonException;

    public final native boolean setHue(short s) throws TvCommonException;

    public native void setMACAddrViaUsbKey() throws TvCommonException;

    public native void setPQParameterViaUsbKey() throws TvCommonException;

    public final native boolean setSaturation(short s) throws TvCommonException;

    public final native boolean setSharpness(short s) throws TvCommonException;

    public final native void setUartEnv(boolean z) throws TvCommonException;

    public native void setWOLEnableStatus(boolean z) throws TvCommonException;

    public native boolean setXvyccDataFromPanel(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) throws TvCommonException;

    public native boolean startUartDebug() throws TvCommonException;

    public native void stopTvService() throws TvCommonException;

    public final native boolean storeDbToUsb() throws TvCommonException;

    @Deprecated
    public native boolean switchUart() throws TvCommonException;

    public native boolean uartSwitch() throws TvCommonException;

    public final native void updatePqIniFiles() throws TvCommonException;

    public final native boolean updateSscParameter() throws TvCommonException;

    public final native UrsaVersionInfo ursaGetVersionInfo() throws TvCommonException;

    public native boolean writeBytesToI2C(int i, short[] sArr, short[] sArr2) throws TvCommonException;

    static {
        _factoryManager = null;
        try {
            System.loadLibrary("factorymanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load factorymanager_jni library:\n" + e.toString());
        }
    }

    protected static FactoryManager getInstance(Object obj) {
        if (obj.getClass().getName().equals("com.mstar.android.tvapi.common.TvFactoryManagerProxy") && _factoryManager == null) {
            synchronized (FactoryManager.class) {
                if (_factoryManager == null) {
                    _factoryManager = new FactoryManager();
                }
            }
        }
        return _factoryManager;
    }

    protected FactoryManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    public void release() throws Throwable {
        _factoryManager = null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _factoryManager = null;
    }

    public final EnumDisplayResolutionType getDisplayResolution() throws TvCommonException {
        int iordinal = EnumDisplayResolutionType.getOrdinalThroughValue(native_getDisplayResolution());
        if (iordinal != -1) {
            return EnumDisplayResolutionType.values()[iordinal];
        }
        throw new TvCommonException("funtion getDisplayResolution fail");
    }

    public final void setVideoTestPattern(EnumScreenMute color) throws TvCommonException {
        native_setVideoTestPattern(color.ordinal());
    }

    public final void setAdcGainOffset(EnumScalerWindow enWin, EnumAdcSetIndexType eAdcIndex, PqlCalibrationData stADCGainOffset) throws TvCommonException {
        native_setAdcGainOffset(enWin.ordinal(), eAdcIndex.ordinal(), stADCGainOffset);
    }

    public final PqlCalibrationData getAdcGainOffset(EnumScalerWindow enWin, EnumAdcSetIndexType eAdcIndex) throws TvCommonException {
        return native_getAdcGainOffset(enWin.ordinal(), eAdcIndex.ordinal());
    }

    public final void setWbGainOffset(EnumColorTemperature eColorTemp, short redGain, short greenGain, short blueGain, short redOffset, short greenOffset, short blueOffset) throws TvCommonException {
        native_setWbGainOffset(eColorTemp.getValue(), redGain, greenGain, blueGain, redOffset, greenOffset, blueOffset);
    }

    public final void setWbGainOffsetEx(EnumColorTemperature eColorTemp, int redGain, int greenGain, int blueGain, int redOffset, int greenOffset, int blueOffset, EnumInputSource enSrcType) throws TvCommonException {
        native_setWbGainOffsetEx(eColorTemp.getValue(), redGain, greenGain, blueGain, redOffset, greenOffset, blueOffset, enSrcType.ordinal());
    }

    public final WbGainOffset getWbGainOffset(EnumColorTemperature eColorTemp) throws TvCommonException {
        return naitve_getWbGainOffset(eColorTemp.getValue());
    }

    public final WbGainOffsetEx getWbGainOffsetEx(EnumColorTemperature eColorTemp, int enSrcType) throws TvCommonException {
        return native_getWbGainOffsetEx(eColorTemp.getValue(), enSrcType);
    }

    public final String getPQVersion(EnumScalerWindow escalerwindow) throws TvCommonException {
        return native_getPQVersion(escalerwindow.ordinal());
    }

    public int getFwVersion(EnumFwType type) throws TvCommonException {
        return native_getFwVersion(type.ordinal());
    }

    public short getResolutionMappingIndex(EnumInputSource eInputSrc) throws TvCommonException {
        return native_getResolutionMappingIndex(eInputSrc.ordinal());
    }

    public boolean setEnvironmentPowerMode(EnumAcOnPowerOnMode ePowerMode) throws TvCommonException {
        return native_setEnvironmentPowerMode(ePowerMode.ordinal());
    }

    public EnumAcOnPowerOnMode getEnvironmentPowerMode() throws TvCommonException {
        int iReturn = native_getEnvironmentPowerMode();
        if (iReturn >= EnumAcOnPowerOnMode.E_ACON_POWERON_SECONDARY.ordinal() && iReturn <= EnumAcOnPowerOnMode.E_ACON_POWERON_MAX.ordinal()) {
            return EnumAcOnPowerOnMode.values()[iReturn];
        }
        throw new TvCommonException("get EnvironmentPowerMode failed \n");
    }

    public final String getUpdatePqFilePath(EnumPqUpdateFile epqUpdateFile) throws TvCommonException {
        return getUpdatePqFilePath(epqUpdateFile.ordinal());
    }
}
