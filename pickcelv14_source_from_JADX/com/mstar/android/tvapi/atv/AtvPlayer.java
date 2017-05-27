package com.mstar.android.tvapi.atv;

import com.mstar.android.tvapi.atv.listener.OnAtvPlayerEventListener;
import com.mstar.android.tvapi.common.TvPlayer;
import com.mstar.android.tvapi.common.exception.TvCommonException;

public interface AtvPlayer extends TvPlayer {
    boolean disableAft() throws TvCommonException;

    boolean enableAft() throws TvCommonException;

    void initAtvVif() throws TvCommonException;

    boolean isAftEnabled() throws TvCommonException;

    boolean saveAtvProgram(int i) throws TvCommonException;

    void setChannelChangeFreezeMode(boolean z) throws TvCommonException;

    void setOnAtvPlayerEventListener(OnAtvPlayerEventListener onAtvPlayerEventListener);
}
