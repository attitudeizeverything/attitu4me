package com.mstar.android.tvapi.common;

import android.view.SurfaceHolder;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.listener.OnTvPlayerEventListener;
import com.mstar.android.tvapi.common.vo.EnumAvdVideoStandardType;
import com.mstar.android.tvapi.common.vo.EnumStdDetectionState;
import com.mstar.android.tvapi.common.vo.EnumTeletextCommand;
import com.mstar.android.tvapi.common.vo.EnumTeletextMode;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.common.vo.VideoArcInfo;
import com.mstar.android.tvapi.common.vo.VideoInfo;
import com.mstar.android.tvapi.dtv.dvb.dvbc.vo.EnumChinaDvbcRegion;

public interface TvPlayer {
    boolean closeTeletext() throws TvCommonException;

    boolean detectInputSource(EnumInputSource enumInputSource) throws TvCommonException;

    void forceVideoStandard(EnumAvdVideoStandardType enumAvdVideoStandardType) throws TvCommonException;

    VideoArcInfo getAspectRatio() throws TvCommonException;

    EnumChinaDvbcRegion getChinaDvbcRegion() throws TvCommonException;

    String getMheg5PfgContent() throws TvCommonException;

    int[] getNitFrequencyByDtvRegion(EnumChinaDvbcRegion enumChinaDvbcRegion) throws TvCommonException;

    int getPhaseRange() throws TvCommonException;

    VideoInfo getVideoInfo() throws TvCommonException;

    EnumAvdVideoStandardType getVideoStandard() throws TvCommonException;

    EnumStdDetectionState getVideoStandardDetectionState() throws TvCommonException;

    boolean hasTeletextClockSignal() throws TvCommonException;

    boolean hasTeletextSignal() throws TvCommonException;

    void initOfflineDetection() throws TvCommonException;

    boolean isHdmiMode();

    boolean isSignalStable() throws TvCommonException;

    boolean isTeletextDisplayed() throws TvCommonException;

    boolean isTeletextSubtitleChannel() throws TvCommonException;

    boolean openPAT(EnumTeletextCommand enumTeletextCommand) throws TvCommonException;

    boolean openTeletext(EnumTeletextMode enumTeletextMode) throws TvCommonException;

    void release() throws Throwable;

    boolean sendMheg5Command(short s) throws TvCommonException;

    boolean sendMheg5IcsCommand(int i, short s) throws TvCommonException;

    boolean sendTeletextCommand(EnumTeletextCommand enumTeletextCommand) throws TvCommonException;

    boolean setAutoSync(boolean z) throws TvCommonException;

    void setChinaDvbcRegion(EnumChinaDvbcRegion enumChinaDvbcRegion) throws TvCommonException;

    void setDebugMode(boolean z) throws TvCommonException;

    void setDisplay(SurfaceHolder surfaceHolder) throws TvCommonException;

    boolean setHPosition(int i) throws TvCommonException;

    boolean setHdmiGpio(int[] iArr) throws TvCommonException;

    boolean setMirror(boolean z) throws TvCommonException;

    void setOnTvPlayerEventListener(OnTvPlayerEventListener onTvPlayerEventListener);

    boolean setPhase(int i) throws TvCommonException;

    boolean setSize(int i) throws TvCommonException;

    boolean setVPosition(int i) throws TvCommonException;

    void startAutoStandardDetection() throws TvCommonException;

    boolean startPcModeAtuoTune() throws TvCommonException;
}
