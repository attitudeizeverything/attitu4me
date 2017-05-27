package com.mstar.android.tvapi.dtv.common;

import com.mstar.android.tvapi.common.TvPlayer;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.listener.OnDtvPlayerEventListener;
import com.mstar.android.tvapi.dtv.vo.DtvAudioInfo;
import com.mstar.android.tvapi.dtv.vo.DtvType.EnumDtvSetAudioMode;
import com.mstar.android.tvapi.dtv.vo.RfInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo.EnumInfoType;

public interface DtvPlayer extends TvPlayer {
    boolean autostartApplication() throws TvCommonException;

    boolean disableGigna() throws TvCommonException;

    boolean enableGinga() throws TvCommonException;

    DtvAudioInfo getAudioInfo() throws TvCommonException;

    RfInfo getRfInfo(EnumInfoType enumInfoType, int i) throws TvCommonException;

    boolean isGingaEnabled() throws TvCommonException;

    boolean isGingaRunning() throws TvCommonException;

    boolean playCurrentProgram() throws TvCommonException;

    boolean processKey(int i, boolean z) throws TvCommonException;

    boolean setAudioMode(EnumDtvSetAudioMode enumDtvSetAudioMode) throws TvCommonException;

    boolean setManualTuneByFreq(int i) throws TvCommonException;

    boolean setManualTuneByRf(short s) throws TvCommonException;

    void setOnDtvPlayerEventListener(OnDtvPlayerEventListener onDtvPlayerEventListener);

    boolean startApplication(long j, long j2) throws TvCommonException;

    boolean stopApplication() throws TvCommonException;

    void switchAudioTrack(int i) throws TvCommonException;
}
