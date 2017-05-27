package com.mstar.android.tvapi.atv;

import com.mstar.android.tvapi.atv.vo.EnumAtvManualTuneMode;
import com.mstar.android.tvapi.atv.vo.EnumAutoScanState;
import com.mstar.android.tvapi.atv.vo.EnumCommonCommand;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumGetProgramInfo;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramCtrl;
import com.mstar.android.tvapi.atv.vo.EnumSetProgramInfo;
import com.mstar.android.tvapi.common.ScanManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.AtvProgramData;
import com.mstar.android.tvapi.common.vo.EnumDBType;
import com.mstar.android.tvapi.common.vo.EnumMedium;

public interface AtvScanManager extends ScanManager {
    int commondCmd(EnumCommonCommand enumCommonCommand, int i, int i2) throws TvCommonException;

    boolean connectDatabase(EnumDBType enumDBType) throws TvCommonException;

    int getAtvProgramInfo(EnumGetProgramInfo enumGetProgramInfo, int i) throws TvCommonException;

    AtvProgramData getAtvProgramMiscInfo(int i) throws TvCommonException;

    String getAtvStationName(int i) throws TvCommonException;

    int getCurrentFrequency() throws TvCommonException;

    EnumMedium getNtscAntenna() throws TvCommonException;

    int getProgramControl(EnumGetProgramCtrl enumGetProgramCtrl, int i, int i2) throws TvCommonException;

    boolean setAtvProgramInfo(EnumSetProgramInfo enumSetProgramInfo, int i, int i2) throws TvCommonException;

    boolean setAtvProgramMiscInfo(int i, AtvProgramData atvProgramData) throws TvCommonException;

    boolean setAtvStationName(int i, String str) throws TvCommonException;

    boolean setAutoTuningEnd() throws TvCommonException;

    boolean setAutoTuningPause() throws TvCommonException;

    boolean setAutoTuningResume() throws TvCommonException;

    boolean setAutoTuningStart(int i, int i2, int i3, EnumAutoScanState enumAutoScanState) throws TvCommonException;

    void setDebugMode(boolean z) throws TvCommonException;

    void setManualTuningEnd() throws TvCommonException;

    boolean setManualTuningStart(int i, int i2, EnumAtvManualTuneMode enumAtvManualTuneMode) throws TvCommonException;

    boolean setNtscAntenna(EnumMedium enumMedium) throws TvCommonException;

    boolean setProgramControl(EnumSetProgramCtrl enumSetProgramCtrl, int i, int i2) throws TvCommonException;

    void startNtscDirectTune(int i, int i2) throws TvCommonException;
}
