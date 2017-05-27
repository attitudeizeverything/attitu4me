package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tv.ICiEventClient.Stub;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.common.CiManager.CredentialValidDateRange;
import com.mstar.android.tvapi.dtv.common.CiManager.OnCiEventListener;
import com.mstar.android.tvapi.dtv.common.DtvManager;
import com.mstar.android.tvapi.dtv.vo.EnumCardState;
import com.mstar.android.tvapi.dtv.vo.EnumMmiType;
import java.util.ArrayList;
import java.util.Iterator;

public class TvCiManager {
    private static final String TAG = "TvCiManager";
    static TvCiManager mInstance;
    private static ITvCi mService;
    private CiEventClientCallBack ciEventClientCallBack;
    private ArrayList<OnCiEventListener> listeners;

    private class CiEventClientCallBack extends Stub {
        private CiEventClientCallBack() {
        }

        public boolean onUiDataReady(int what) throws RemoteException {
            Iterator i$ = TvCiManager.this.listeners.iterator();
            while (i$.hasNext()) {
                try {
                    ((OnCiEventListener) i$.next()).onUiDataReady(DtvManager.getCiManager(), what);
                } catch (TvCommonException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean onUiCloseMmi(int what) throws RemoteException {
            Iterator i$ = TvCiManager.this.listeners.iterator();
            while (i$.hasNext()) {
                try {
                    ((OnCiEventListener) i$.next()).onUiCloseMmi(DtvManager.getCiManager(), what);
                } catch (TvCommonException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean onUiCardInserted(int what) throws RemoteException {
            Iterator i$ = TvCiManager.this.listeners.iterator();
            while (i$.hasNext()) {
                try {
                    ((OnCiEventListener) i$.next()).onUiCardInserted(DtvManager.getCiManager(), what);
                } catch (TvCommonException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean onUiCardRemoved(int what) throws RemoteException {
            Iterator i$ = TvCiManager.this.listeners.iterator();
            while (i$.hasNext()) {
                try {
                    ((OnCiEventListener) i$.next()).onUiCardRemoved(DtvManager.getCiManager(), what);
                } catch (TvCommonException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public boolean onUiAutotestMessageShown(int what) throws RemoteException {
            Iterator i$ = TvCiManager.this.listeners.iterator();
            while (i$.hasNext()) {
                try {
                    ((OnCiEventListener) i$.next()).onUiAutotestMessageShown(DtvManager.getCiManager(), what);
                } catch (TvCommonException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvCiManager() {
        this.listeners = new ArrayList();
    }

    public static TvCiManager getInstance() {
        if (mInstance == null) {
            synchronized (TvCiManager.class) {
                if (mInstance == null) {
                    mInstance = new TvCiManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvCi getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvCi();
        return mService;
    }

    public void setCiCredentialMode(short credentialMode) {
        Log.d(TAG, "setCiCredentialMode, credentialMode = " + credentialMode);
        try {
            getService().setCiCredentialMode(credentialMode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isCiCredentialModeValid(short credentialMode) {
        Log.d(TAG, "isCiCredentialModeValid, credentialMode = " + credentialMode);
        try {
            return getService().isCiCredentialModeValid(credentialMode);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void enterMenu() {
        Log.d(TAG, "enterMenu");
        try {
            getService().enterMenu();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void backMenu() {
        Log.d(TAG, "backMenu");
        try {
            getService().backMenu();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isDataExisted() {
        Log.d(TAG, "isDataExisted");
        try {
            return getService().isDataExisted();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumMmiType getMmiType() {
        Log.d(TAG, "getMmiType");
        try {
            return EnumMmiType.values()[getService().getMmiType()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getMenuString() {
        Log.d(TAG, "getMenuString");
        try {
            return getService().getMenuString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getMenuTitleString() {
        Log.d(TAG, "getMenuTitleString");
        try {
            return getService().getMenuTitleString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getMenuBottomString() {
        Log.d(TAG, "getMenuBottomString");
        try {
            return getService().getMenuBottomString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getListTitleString() {
        Log.d(TAG, "getListTitleString");
        try {
            return getService().getListTitleString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getListTitleLength() {
        Log.d(TAG, "getListTitleLength");
        try {
            return getService().getListTitleLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public short getMenuChoiceNumber() {
        Log.d(TAG, "getMenuChoiceNumber");
        try {
            return (short) getService().getMenuChoiceNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public short getListChoiceNumber() {
        Log.d(TAG, "getListChoiceNumber");
        try {
            return (short) getService().getListChoiceNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public short getEnqBlindAnswer() {
        Log.d(TAG, "getEnqBlindAnswer");
        try {
            return (short) getService().getEnqBlindAnswer();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public String getListSubtitleString() {
        Log.d(TAG, "getListSubtitleString");
        try {
            return getService().getListSubtitleString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getListSubtitleLength() {
        Log.d(TAG, "getListSubtitleLength");
        try {
            return getService().getListSubtitleLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void enterCiOperatorProfile(short Index) {
        Log.d(TAG, "enterCiOperatorProfile, Index = " + Index);
        try {
            getService().enterCiOperatorProfile(Index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void exitCiOperatorProfile() {
        Log.d(TAG, "exitCiOperatorProfile");
        try {
            getService().exitCiOperatorProfile();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpTuning() {
        Log.d(TAG, "isOpTuning");
        try {
            return getService().isOpTuning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendCiOpSearchStart(boolean bUnattendedFlag) {
        Log.d(TAG, "sendCiOpSearchStart, bUnattendedFlag = " + bUnattendedFlag);
        try {
            return getService().sendCiOpSearchStart(bUnattendedFlag);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getOpProfileNameByIndex(short Index) {
        Log.d(TAG, "getOpProfileNameByIndex, Index = " + Index);
        try {
            return getService().getOpProfileNameByIndex(Index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public short getOpDtvSysTypeByIndex(short Index) {
        Log.d(TAG, "getOpDtvSysTypeByIndex, Index = " + Index);
        try {
            return (short) getService().getOpDtvSysTypeByIndex(Index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public short getOpCacheCount() {
        Log.d(TAG, "getOpCacheCount");
        try {
            return (short) getService().getOpCacheCount();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public boolean deleteOpCacheByIndex(short Index) {
        Log.d(TAG, "deleteOpCacheByIndex, Index = " + Index);
        try {
            return getService().deleteOpCacheByIndex(Index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOpMode() {
        Log.d(TAG, "isOpMode");
        try {
            return getService().isOpMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateOpCurrentServiceTripleId() {
        Log.d(TAG, "updateOpCurrentServiceTripleId");
        try {
            return getService().updateOpCurrentServiceTripleId();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void ciClearOPSearchSuspended() {
        Log.d(TAG, "ciClearOPSearchSuspended");
        try {
            getService().ciClearOPSearchSuspended();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean sendCiOpSearchCancel() {
        Log.d(TAG, "sendCiOpSearchCancel");
        try {
            return getService().sendCiOpSearchCancel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getOpIso639LangCodeByCicamId(int u32CicamId) {
        Log.d(TAG, "getOpIso639LangCodeByCicamId, u32CicamId = " + u32CicamId);
        try {
            return (short) getService().getOpIso639LangCodeByCicamId(u32CicamId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public int getCurrentOpCicamId() {
        Log.d(TAG, "getCurrentOpCicamId");
        try {
            return getService().getCurrentOpCicamId();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean deleteOpCacheByCicamId(int u32CicamId) {
        Log.d(TAG, "deleteOpCacheByCicamId, u32CicamId = " + u32CicamId);
        try {
            return getService().deleteOpCacheByCicamId(u32CicamId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resetOPCacheDB(boolean bDisableChannel) {
        Log.d(TAG, "resetOPCacheDB, bDisableChannel = " + bDisableChannel);
        try {
            return getService().resetOPCacheDB(bDisableChannel);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public short getCurrentOpIndexByCicamId(int u32CicamId) {
        Log.d(TAG, "getCurrentOpIndexByCicamId, u32CicamId = " + u32CicamId);
        try {
            return (short) getService().getCurrentOpIndexByCicamId(u32CicamId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public String getListBottomString() {
        Log.d(TAG, "getListBottomString");
        try {
            return getService().getListBottomString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getMenuSelectionString(int index) {
        Log.d(TAG, "getMenuSelectionString, index = " + index);
        try {
            return getService().getMenuSelectionString(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getListSelectionString(int index) {
        Log.d(TAG, "getListSelectionString, index = " + index);
        try {
            return getService().getListSelectionString(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEnqString() {
        Log.d(TAG, "getEnqString");
        try {
            return getService().getEnqString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getMenuTitleLength() {
        Log.d(TAG, "getMenuTitleLength");
        try {
            return getService().getMenuTitleLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getMenuSubtitleLength() {
        Log.d(TAG, "getMenuSubtitleLength");
        try {
            return getService().getMenuSubtitleLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getMenuSubtitleString() {
        Log.d(TAG, "getMenuSubtitleString");
        try {
            return getService().getMenuSubtitleString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getMenuBottomLength() {
        Log.d(TAG, "getMenuBottomLength");
        try {
            return getService().getMenuBottomLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void close() {
        Log.d(TAG, "close");
        try {
            getService().close();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getListBottomLength() {
        Log.d(TAG, "getListBottomLength");
        try {
            return getService().getListBottomLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public short getEnqLength() {
        Log.d(TAG, "getEnqLength");
        try {
            return (short) getService().getEnqLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public short getEnqAnsLength() {
        Log.d(TAG, "getEnqAnsLength");
        try {
            return (short) getService().getEnqAnsLength();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) 0;
        }
    }

    public boolean backEnq() {
        Log.d(TAG, "backEnq");
        try {
            return getService().backEnq();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean answerEnq(String password) {
        Log.d(TAG, "answerEnq, password = " + password);
        try {
            return getService().answerEnq(password);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void answerMenu(short index) {
        Log.d(TAG, "answerMenu, index = " + index);
        try {
            getService().answerMenu(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumCardState getCardState() {
        Log.d(TAG, "getCardState");
        try {
            return EnumCardState.values()[getService().getCardState()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return EnumCardState.E_NO;
        }
    }

    public boolean isCiMenuOn() {
        Log.d(TAG, "isCiMenuOn");
        try {
            return getService().isCiMenuOn();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CredentialValidDateRange getCiCredentialValidRange() {
        Log.d(TAG, "getCiCredentialValidRange");
        try {
            int[] ciCVR = getService().getCiCredentialValidRange();
            null.validFromDate = ciCVR[0];
            null.validToDate = ciCVR[1];
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDebugMode(boolean mode) {
        Log.d(TAG, "setDebugMode, mode" + mode);
        try {
            getService().setDebugMode(mode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean registerOnCiEventListener(OnCiEventListener listener) {
        if (this.ciEventClientCallBack == null) {
            this.ciEventClientCallBack = new CiEventClientCallBack();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskCiEventListener", this.ciEventClientCallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.listeners.add(listener);
        return true;
    }

    public synchronized boolean unregisterOnCiEventListener(OnCiEventListener listener) {
        this.listeners.remove(listener);
        if (this.listeners.size() == 0 && this.ciEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskCiEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.ciEventClientCallBack = null;
        }
        return true;
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize TvCiManager ");
        if (this.ciEventClientCallBack != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskCiEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
