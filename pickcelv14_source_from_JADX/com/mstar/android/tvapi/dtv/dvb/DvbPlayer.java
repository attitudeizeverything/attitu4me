package com.mstar.android.tvapi.dtv.dvb;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.DtvProgramSignalInfo;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumCountry;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumTimeZone;
import com.mstar.android.tvapi.dtv.common.DtvPlayer;
import com.mstar.android.tvapi.dtv.dvb.vo.DvbMuxInfo;
import com.mstar.android.tvapi.dtv.dvb.vo.EnumCurrentEventStatus;
import com.mstar.android.tvapi.dtv.vo.DtvDemodType;
import com.mstar.android.tvapi.dtv.vo.DtvDemodVersion;
import com.mstar.android.tvapi.dtv.vo.EnumParentalRating;

public interface DvbPlayer extends DtvPlayer {
    void disableAutoClock() throws TvCommonException;

    void enableAutoClock() throws TvCommonException;

    int getAntennaType() throws TvCommonException;

    String getCountryCode() throws TvCommonException;

    int getCurrentEventStatus(EnumCurrentEventStatus enumCurrentEventStatus) throws TvCommonException;

    DvbMuxInfo getCurrentMuxInfo() throws TvCommonException;

    DtvProgramSignalInfo getCurrentSignalInformation() throws TvCommonException;

    DtvDemodVersion getDTVDemodVersion(DtvDemodType dtvDemodType) throws TvCommonException;

    int getDtvRouteCount() throws TvCommonException;

    String getLanguageCode() throws TvCommonException;

    int[] getLogoData() throws TvCommonException;

    DvbMuxInfo getMuxInfoByProgramNumber(int i, short s) throws TvCommonException;

    boolean setCountry(EnumCountry enumCountry) throws TvCommonException;

    void setCurrentEventStatus(EnumCurrentEventStatus enumCurrentEventStatus, boolean z) throws TvCommonException;

    void setDtvRoute(short s) throws TvCommonException;

    void setFavoriteRegion(int i) throws TvCommonException;

    void setParental(EnumParentalRating enumParentalRating) throws TvCommonException;

    void setTimeZone(EnumTimeZone enumTimeZone) throws TvCommonException;

    boolean switchDtvRoute(short s) throws TvCommonException;

    boolean unlockChannel() throws TvCommonException;
}
