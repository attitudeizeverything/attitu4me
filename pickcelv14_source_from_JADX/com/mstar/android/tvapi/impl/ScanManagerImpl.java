package com.mstar.android.tvapi.impl;

import android.os.Parcel;
import com.mstar.android.tvapi.atv.AtvScanManager;
import com.mstar.android.tvapi.atv.vo.EnumAtvManualTuneMode;
import com.mstar.android.tvapi.atv.vo.EnumAutoScanState;
import com.mstar.android.tvapi.atv.vo.EnumCommonCommand;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramInfo;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramInfo;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.AtvProgramData;
import com.mstar.android.tvapi.common.vo.EnumCableOperator;
import com.mstar.android.tvapi.common.vo.EnumDBType;
import com.mstar.android.tvapi.common.vo.EnumMedium;
import com.mstar.android.tvapi.dtv.dvb.dvbc.DvbcScanManager;
import com.mstar.android.tvapi.dtv.dvb.dvbc.vo.EnumCabConstelType;
import com.mstar.android.tvapi.dtv.dvb.dvbt.DvbtScanManager;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbCountryInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbPrimaryRegionInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbSecondaryRegionInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbTargetRegionInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbTeritaryRegionInfo;
import com.mstar.android.tvapi.dtv.vo.DtvNetworkRegionInfo;
import com.mstar.android.tvapi.dtv.vo.EnumRfChannelBandwidth;
import java.lang.ref.WeakReference;

public class ScanManagerImpl implements AtvScanManager, DvbtScanManager, DvbcScanManager {
    private static final String IEPG_MANAGER = "mstar.IScanManagerImpl";
    private static ScanManagerImpl _scanmanagerimpl;
    private int mNativeContext;
    private int mScanManagerImplContext;

    private final native int native_commondCmd(int i, int i2, int i3) throws TvCommonException;

    private final native boolean native_connectDatabase(int i) throws TvCommonException;

    private native void native_finalize();

    private final native int native_getAtvProgramInfo(int i, int i2) throws TvCommonException;

    private final native int native_getNtscAntenna() throws TvCommonException;

    private final native int native_getProgramControl(int i, int i2, int i3) throws TvCommonException;

    private final native int native_getRegionInfo(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private static native void native_init();

    private final native boolean native_setAtvProgramInfo(int i, int i2, int i3) throws TvCommonException;

    private final native boolean native_setAutoTuningStart(int i, int i2, int i3, int i4) throws TvCommonException;

    private final native boolean native_setBandwidth(int i) throws TvCommonException;

    private final native void native_setCableOperator(int i) throws TvCommonException;

    private final native boolean native_setManualTuningStart(int i, int i2, int i3) throws TvCommonException;

    private final native boolean native_setNtscAntenna(int i) throws TvCommonException;

    private final native boolean native_setProgramControl(int i, int i2, int i3);

    private final native boolean native_setScanParam(short s, int i, int i2, int i3, short s2, boolean z) throws TvCommonException;

    private native void native_setup(Object obj);

    public final native AtvProgramData getAtvProgramMiscInfo(int i) throws TvCommonException;

    public final native String getAtvStationName(int i) throws TvCommonException;

    public final native int getCurrentFrequency() throws TvCommonException;

    public final native int getDefaultHomingChannelFrequency() throws TvCommonException;

    public final native int getDefaultNetworkId() throws TvCommonException;

    public final native DtvNetworkRegionInfo getRegionNetworks() throws TvCommonException;

    public final native boolean getSmartScanMode() throws TvCommonException;

    public final native boolean isScanning() throws TvCommonException;

    public final native boolean pauseScan() throws TvCommonException;

    public final native boolean resolveConflictLcn() throws TvCommonException;

    public final native boolean resumeScan() throws TvCommonException;

    public final native boolean setAtvProgramMiscInfo(int i, AtvProgramData atvProgramData) throws TvCommonException;

    public final native boolean setAtvStationName(int i, String str) throws TvCommonException;

    public final native boolean setAutoTuningEnd() throws TvCommonException;

    public final native boolean setAutoTuningPause() throws TvCommonException;

    public final native boolean setAutoTuningResume() throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setManualTuningEnd() throws TvCommonException;

    public final native boolean setRegion(String str, short s, short s2, int i) throws TvCommonException;

    public final native void setSmartScanMode(boolean z) throws TvCommonException;

    public final native void startAutoScan() throws TvCommonException;

    public final native void startAutoUpdateScan() throws TvCommonException;

    public final native boolean startFullScan() throws TvCommonException;

    public final native boolean startManualScan() throws TvCommonException;

    public final native void startNtscDirectTune(int i, int i2) throws TvCommonException;

    public final native boolean startQuickScan() throws TvCommonException;

    public final native void startStandbyScan() throws TvCommonException;

    public final native boolean stopScan() throws TvCommonException;

    public final native boolean updateSameProgram(boolean z) throws TvCommonException;

    static {
        try {
            System.loadLibrary("scanmanagerimpl_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load scanmanagerimpl_jni library:\n" + e.toString());
        }
        _scanmanagerimpl = null;
    }

    protected static ScanManagerImpl getInstance(Object obj) {
        String objname = obj.getClass().getName();
        if ((objname.equals("com.mstar.android.tvapi.atv.AtvScanImplProxy") || objname.equals("com.mstar.android.tvapi.dtv.common.DtvScanImplProxy") || objname.equals("com.mstar.android.tvapi.common.TvScanImplProxy")) && _scanmanagerimpl == null) {
            synchronized (ScanManagerImpl.class) {
                if (_scanmanagerimpl == null) {
                    _scanmanagerimpl = new ScanManagerImpl();
                }
            }
        }
        return _scanmanagerimpl;
    }

    protected ScanManagerImpl() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("\n NativeScanManagerImpl callback");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    public void release() throws Throwable {
        _scanmanagerimpl = null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _scanmanagerimpl = null;
    }

    public boolean setScanParam(short symbolRate, EnumCabConstelType enConstellation, int nitFrequency, int endFrequncy, short networkId, boolean bEnablePersistNitCableInformation) throws TvCommonException {
        return native_setScanParam(symbolRate, enConstellation.ordinal(), nitFrequency, endFrequncy, networkId, bEnablePersistNitCableInformation);
    }

    public final DvbTargetRegionInfo getRegionInfo() throws TvCommonException {
        Parcel request = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        request.writeInterfaceToken(IEPG_MANAGER);
        native_getRegionInfo(request, reply);
        DvbTargetRegionInfo result = new DvbTargetRegionInfo();
        result.countryCount = (short) reply.readInt();
        result.countryInfos = new DvbCountryInfo[result.countryCount];
        for (short i = (short) 0; i < result.countryCount; i++) {
            int j;
            for (j = 0; j < 3; j++) {
                result.countryInfos[i].countryCode[j] = (char) reply.readInt();
            }
            result.countryInfos[i].primaryRegionCount = reply.readInt();
            result.countryInfos[i].primaryRegionInfos = new DvbPrimaryRegionInfo[result.countryInfos[i].primaryRegionCount];
            for (j = 0; j < result.countryInfos[i].primaryRegionCount; j++) {
                result.countryInfos[i].primaryRegionInfos[j].code = (short) reply.readInt();
                result.countryInfos[i].primaryRegionInfos[j].name = reply.readString();
                result.countryInfos[i].primaryRegionInfos[j].secondaryRegionNum = reply.readInt();
                result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos = new DvbSecondaryRegionInfo[result.countryInfos[i].primaryRegionInfos[j].secondaryRegionNum];
                for (int k = 0; k < result.countryInfos[i].primaryRegionInfos[j].secondaryRegionNum; k++) {
                    result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].code = (short) reply.readInt();
                    result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].regionName = reply.readString();
                    result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionNum = reply.readInt();
                    result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionInfos = new DvbTeritaryRegionInfo[result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionNum];
                    for (int l = 0; l < result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionNum; l++) {
                        result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionInfos[l].code = (short) reply.readInt();
                        result.countryInfos[i].primaryRegionInfos[j].secondaryRegionInfos[k].tertiaryRegionInfos[l].regionName = reply.readString();
                    }
                }
            }
        }
        request.recycle();
        reply.recycle();
        return result;
    }

    public void setCableOperator(EnumCableOperator cableOperators) throws TvCommonException {
        native_setCableOperator(cableOperators.ordinal());
    }

    public final boolean setAutoTuningStart(int eventIntervalMs, int frequencyStart, int frequencyEnds, EnumAutoScanState autoScanState) throws TvCommonException {
        return native_setAutoTuningStart(eventIntervalMs, frequencyStart, frequencyEnds, autoScanState.ordinal());
    }

    public final boolean setManualTuningStart(int eEventIntervalMs, int frequency, EnumAtvManualTuneMode eMode) throws TvCommonException {
        return native_setManualTuningStart(eEventIntervalMs, frequency, eMode.ordinal());
    }

    public boolean setBandwidth(EnumRfChannelBandwidth enRfChannelBandwidth) throws TvCommonException {
        return native_setBandwidth(enRfChannelBandwidth.getValue());
    }

    public final boolean setAtvProgramInfo(EnumSetProgramInfo command, int programNo, int parameter) throws TvCommonException {
        return native_setAtvProgramInfo(command.ordinal(), programNo, parameter);
    }

    public int getAtvProgramInfo(EnumGetProgramInfo command, int programNo) throws TvCommonException {
        return native_getAtvProgramInfo(command.ordinal(), programNo);
    }

    public boolean setProgramControl(EnumSetProgramCtrl command, int programNo, int param3) throws TvCommonException {
        return native_setProgramControl(command.ordinal(), programNo, param3);
    }

    public int getProgramControl(EnumGetProgramCtrl command, int programNo, int param3) throws TvCommonException {
        return native_getProgramControl(command.ordinal(), programNo, param3);
    }

    public int commondCmd(EnumCommonCommand command, int programNo, int param3) throws TvCommonException {
        return native_commondCmd(command.ordinal(), programNo, param3);
    }

    public boolean setNtscAntenna(EnumMedium antenna) throws TvCommonException {
        return native_setNtscAntenna(antenna.ordinal());
    }

    public EnumMedium getNtscAntenna() throws TvCommonException {
        int iReturn = native_getNtscAntenna();
        if (iReturn >= EnumMedium.MEDIUM_CABLE.ordinal() && iReturn <= EnumMedium.MEDIUM_NUM.ordinal()) {
            return EnumMedium.values()[iReturn];
        }
        throw new TvCommonException("native_getNtscAntenna failed");
    }

    public boolean connectDatabase(EnumDBType db) throws TvCommonException {
        return native_connectDatabase(db.ordinal());
    }
}
