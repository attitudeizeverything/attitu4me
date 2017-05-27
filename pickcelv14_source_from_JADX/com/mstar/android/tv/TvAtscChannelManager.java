package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tvapi.common.vo.EnumAntennaType;
import com.mstar.android.tvapi.common.vo.ProgramInfo;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumInputSource;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscMainListChannelInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscScanChannelNotify;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaEngRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.EnumCanadaFreRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.RR5RatingPair;
import com.mstar.android.tvapi.dtv.atsc.vo.Regin5DimensionInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaMpaaRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaTvRatingInformation;
import java.util.List;

public class TvAtscChannelManager {
    private static final String TAG = "TvAtscChannelManager";
    static TvAtscChannelManager mInstance;
    private static ITvAtscChannel mService;

    static {
        mInstance = null;
        mService = null;
    }

    private TvAtscChannelManager() {
    }

    public static TvAtscChannelManager getInstance() {
        if (mInstance == null) {
            synchronized (TvAtscChannelManager.class) {
                if (mInstance == null) {
                    mInstance = new TvAtscChannelManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvAtscChannel getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvAtscChannel();
        return mService;
    }

    public boolean deleteAllMainList() {
        try {
            return getService().deleteAllMainList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDtvMainList() {
        try {
            return getService().deleteDtvMainList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAtvMainList() {
        try {
            return getService().deleteAtvMainList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChannelInformationByRf(short rfCh) {
        Log.d(TAG, "deleteChannelInformationByRf, paras rfCh = " + rfCh);
        try {
            return getService().deleteChannelInformationByRf(rfCh);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AtscMainListChannelInformation getCurrentChannelInformation() {
        AtscMainListChannelInformation tv = null;
        try {
            tv = getService().getCurrentChannelInformation();
            Log.d(TAG, "getCurrentChannelInformation, return AtscMainListChannelInformation id = " + tv.id + ", majorNumber = " + tv.majorNumber + ", minorNumbe = " + tv.minorNumber + ", progId = " + tv.progId + ", rfCh = " + tv.rfCh);
            return tv;
        } catch (RemoteException e) {
            e.printStackTrace();
            return tv;
        }
    }

    public boolean changeProgramList() {
        try {
            return getService().changeProgramList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProgramInfo getCurrentProgramInfo() {
        ProgramInfo tv = null;
        try {
            tv = getService().getCurrentProgramInfo();
            Log.d(TAG, "getCurrentProgramInfo, return ProgramInfo antennaType = " + tv.antennaType + ", favorite = " + tv.favorite + ", frequency = " + tv.frequency + ", majorNum = " + tv.majorNum + ", minorNum = " + tv.minorNum + ", number = " + tv.number + ", progId = " + tv.progId + ", queryIndex = " + tv.queryIndex + ", screenMuteStatus = " + tv.screenMuteStatus + ", serviceId = " + tv.serviceId + ", serviceName = " + tv.serviceName + ", serviceType = " + tv.serviceType + ", transportStreamId = " + tv.transportStreamId);
            return tv;
        } catch (RemoteException e) {
            e.printStackTrace();
            return tv;
        }
    }

    public boolean programSel(int majorNumber, int minorNumber) {
        Log.d(TAG, "programSel, paras majorNumber = " + majorNumber + ", minorNumber = " + minorNumber);
        try {
            return getService().programSel(majorNumber, minorNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void setProgramName(int majorNumber, int minorNumber, String programName) {
        Log.d(TAG, "setProgramName, paras majorNumber = " + majorNumber + ", minorNumber = " + minorNumber + ", programName = " + programName);
        try {
            getService().setProgramName(majorNumber, minorNumber, programName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final boolean changeDtvToManualFirstService(int rfCh) {
        Log.d(TAG, "changeDtvToManualFirstService, paras rfCh = " + rfCh);
        try {
            return getService().changeDtvToManualFirstService(rfCh);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumCanadaEngRatingType getCanadaEngRatingLock() {
        EnumCanadaEngRatingType en = null;
        try {
            en = EnumCanadaEngRatingType.values()[getService().getCanadaEngRatingLock()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getCanadaEngRatingLock, return EnumCanadaEngRatingType " + en);
        return en;
    }

    public EnumCanadaFreRatingType getCanadaFreRatingLock() {
        EnumCanadaFreRatingType en = null;
        try {
            en = EnumCanadaFreRatingType.values()[getService().getCanadaFreRatingLock()];
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getCanadaFreRatingLock, return EnumCanadaFreRatingType " + en);
        return en;
    }

    public String getCurrentRatingInformation() {
        String s = null;
        try {
            s = getService().getCurrentRatingInformation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getCurrentRatingInformation, return Sting " + s);
        return s;
    }

    public Region5RatingInformation getRRTInformation() {
        Region5RatingInformation tv = null;
        try {
            tv = getService().getRRTInformation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getRRTInformation, return Region5RatingInformation dimensionNo = " + tv.dimensionNo);
        return tv;
    }

    public UsaMpaaRatingType getUsaMpaaRatingLock() {
        UsaMpaaRatingType tv = null;
        try {
            tv = getService().getUsaMpaaRatingLock();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getUsaMpaaRatingLock, return UsaMpaaRatingType enUaMpaaRatingType = " + tv.enUaMpaaRatingType + ", isNr = " + tv.isNr);
        return tv;
    }

    public UsaTvRatingInformation getUsaTvRatingLock() {
        UsaTvRatingInformation tv = null;
        try {
            tv = getService().getUsaTvRatingLock();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "return UsaTvRatingInformation " + tv);
        return tv;
    }

    public boolean resetRRTSetting() {
        try {
            return getService().resetRRTSetting();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCanadaEngRatingLock(EnumCanadaEngRatingType enRatingType) {
        Log.d(TAG, "setCanadaEngRatingLock, paras enRatingType = " + enRatingType);
        try {
            return getService().setCanadaEngRatingLock(enRatingType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCanadaFreRatingLock(EnumCanadaFreRatingType enRatingType) {
        Log.d(TAG, "setCanadaFreRatingLock, paras enRatingType = " + enRatingType);
        try {
            return getService().setCanadaFreRatingLock(enRatingType.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setUsaMpaaRatingLock(UsaMpaaRatingType usaMpaaRatingType) {
        Log.d(TAG, "setUsaMpaaRatingLock, paras usaMpaaRatingType = " + usaMpaaRatingType);
        try {
            return getService().setUsaMpaaRatingLock(usaMpaaRatingType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setUsaTvRatingLock(UsaTvRatingInformation usaTvRatingInfo) {
        Log.d(TAG, "setUsaTvRatingLock, paras usaTvRatingInfo = " + usaTvRatingInfo);
        try {
            return getService().setUsaTvRatingLock(usaTvRatingInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVChipGuideline(short ratingType, short para1, short para2, short para3) {
        Log.d(TAG, "setVChipGuideline, paras ratingType = " + ratingType + ", para1 = " + para1 + ", para2 = " + para2 + ", para3 = " + para3);
        try {
            return getService().setVChipGuideline(ratingType, para1, para2, para3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getCurrentVChipBlockStatus() {
        try {
            return getService().getCurrentVChipBlockStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getVChipInputSourceBlockStatus(EnumInputSource enInputSource) {
        Log.d(TAG, "getVChipInputSourceBlockStatus, paras enInputSource = " + enInputSource);
        try {
            return getService().getVChipInputSourceBlockStatus(enInputSource.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setVChipInputSourceBlockStatus(EnumInputSource enInputSource, boolean enable) {
        Log.d(TAG, "setVChipInputSourceBlockStatus, paras enInputSource = " + enInputSource + ", enable = " + enable);
        try {
            getService().setVChipInputSourceBlockStatus(enInputSource.ordinal(), enable);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ProgramInfo getProgramInfo(int queryIndex) {
        Log.d(TAG, "getProgramInfo, paras queryIndex = " + Integer.toString(queryIndex));
        try {
            return getService().getProgramInfo(queryIndex);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDtvAntennaType(EnumAntennaType type) {
        Log.d(TAG, "setDtvAntennaType(), paras type = " + type);
        try {
            getService().setDtvAntennaType(type.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean setUsaTvGuideline(int age, int rank) throws RemoteException {
        try {
            return getService().setUsaTvGuideline(age, rank);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setUsaMpaaGuideline(int rank, boolean isNr) throws RemoteException {
        try {
            return getService().setUsaMpaaGuideline(rank, isNr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCanadaEngGuideline(int rank) throws RemoteException {
        try {
            return getService().setCanadaEngGuideline(rank);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCanadaFreGuideline(int rank) throws RemoteException {
        try {
            return getService().setCanadaFreGuideline(rank);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setDynamicGuideline(int grad, int rank, int value) throws RemoteException {
        try {
            return getService().setDynamicGuideline(grad, rank, value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getBlockUnlockUnrated() {
        try {
            return getService().getBlockUnlockUnrated();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setBlockUnlockUnrated(boolean enable) {
        Log.d(TAG, "setBlockUnlockUnrated, paras usaTvRatingInfo = " + enable);
        try {
            getService().setBlockUnlockUnrated(enable);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getRRT5NoDimension() {
        try {
            return getService().getRRT5NoDimension();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Regin5DimensionInformation> getRRT5Dimension() {
        try {
            return getService().getRRT5Dimension();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RR5RatingPair> getRR5RatingPair(int index, int count) {
        try {
            return getService().getRR5RatingPair(index, count);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRR5RatingPair(int title, int index, int value) {
        try {
            getService().setRR5RatingPair(title, index, value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getBlockSysLockMode() {
        try {
            return getService().getBlockSysLockMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setBlockSysLockMode(int value) {
        try {
            getService().setBlockSysLockMode(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public AtscScanChannelNotify getTSUpdateInfo(int index) {
        try {
            return getService().getTSUpdateInfo(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] getInputBlockFlag() {
        try {
            return getService().getInputBlockFlag();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setInputBlockFlag(int[] value) {
        try {
            getService().setInputBlockFlag(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
