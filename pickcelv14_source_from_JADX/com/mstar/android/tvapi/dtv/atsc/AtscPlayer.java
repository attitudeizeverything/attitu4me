package com.mstar.android.tvapi.dtv.atsc;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.CaptionOptionSetting;
import com.mstar.android.tvapi.common.vo.EnumAntennaType;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscScanChannelNotify;
import com.mstar.android.tvapi.dtv.atsc.vo.AudioMuteType.EnumAudioMuteType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaEngRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaFreRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumUsaTvRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaMpaaRatingType.EnumUsaMpaaRatingType;
import com.mstar.android.tvapi.dtv.common.DtvPlayer;
import com.mstar.android.tvapi.dtv.vo.MwAtscEasInfo;

public interface AtscPlayer extends DtvPlayer {
    boolean createPreviewCCWin() throws TvCommonException;

    boolean doesCcExist() throws TvCommonException;

    boolean drawPreviewCCWin(CaptionOptionSetting captionOptionSetting) throws TvCommonException;

    boolean enterPassToUnlockByUser(boolean z) throws TvCommonException;

    boolean enterPassToUnlockUnratedByUser(boolean z) throws TvCommonException;

    boolean exitPreviewCCWin() throws TvCommonException;

    int getCcMode() throws TvCommonException;

    String getCurrentRatingInformation() throws TvCommonException;

    boolean getCurrentVChipBlockStatus() throws TvCommonException;

    MwAtscEasInfo getEASInProgress() throws TvCommonException;

    boolean getEasProgressSatus() throws TvCommonException;

    Region5RatingInformation getRRTInformation() throws TvCommonException;

    AtscScanChannelNotify getTSUpdateInfo(int i) throws TvCommonException;

    void setAntennaType(EnumAntennaType enumAntennaType) throws TvCommonException;

    boolean setAudioMute(EnumAudioMuteType enumAudioMuteType, EnumInputSource enumInputSource) throws TvCommonException;

    boolean setCanadaEngGuideline(EnumCanadaEngRatingType enumCanadaEngRatingType) throws TvCommonException;

    boolean setCanadaFreGuideline(EnumCanadaFreRatingType enumCanadaFreRatingType) throws TvCommonException;

    void setCcMode(int i) throws TvCommonException;

    boolean setDynamicGuideline(short s, short s2, short s3) throws TvCommonException;

    void setEasAudioDesired(boolean z) throws TvCommonException;

    void setEasProgressDone() throws TvCommonException;

    boolean setUsaMpaaGuideline(EnumUsaMpaaRatingType enumUsaMpaaRatingType, boolean z) throws TvCommonException;

    boolean setUsaTvGuideline(EnumUsaTvRatingType enumUsaTvRatingType, short s) throws TvCommonException;

    boolean setVChipGuideline(short s, short s2, short s3, short s4) throws TvCommonException;

    boolean startCc() throws TvCommonException;

    boolean stopCc() throws TvCommonException;
}
