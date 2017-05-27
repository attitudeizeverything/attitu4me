package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumFavoriteId;
import com.mstar.android.tvapi.common.vo.EnumFirstServiceInputType;
import com.mstar.android.tvapi.common.vo.EnumFirstServiceType;
import com.mstar.android.tvapi.common.vo.EnumProgramAttribute;
import com.mstar.android.tvapi.common.vo.EnumProgramCountType;
import com.mstar.android.tvapi.common.vo.EnumProgramInfoType;
import com.mstar.android.tvapi.common.vo.EnumProgramLoopType;
import com.mstar.android.tvapi.common.vo.GetServiceInfo;
import com.mstar.android.tvapi.common.vo.ProgramInfo;
import com.mstar.android.tvapi.common.vo.ProgramInfoQueryCriteria;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscMainListChannelInformation;
import java.lang.ref.WeakReference;

public final class ChannelManager {
    private static final String ICHANNEL_MANAGER = "mstar.IChannelManager";
    private static ChannelManager _channelManager;
    private int mChannelManagerContext;
    private int mNativeContext;

    private final native ProgramInfo native_ATSC_getProgramInfo(int i) throws TvCommonException;

    private final native void native_addProgramToFavorite(int i, int i2, short s, int i3) throws TvCommonException;

    private final native boolean native_changeToFirstService(int i, int i2) throws TvCommonException;

    private final native void native_deleteProgramFromFavorite(int i, int i2, short s, int i3) throws TvCommonException;

    private final native void native_finalize();

    private final native boolean native_genMixProgList(boolean z) throws TvCommonException;

    private final native boolean native_getProgramAttribute(int i, int i2, short s, int i3) throws TvCommonException;

    private final native int native_getProgramCount(int i) throws TvCommonException;

    private final native ProgramInfo native_getProgramInfo(ProgramInfoQueryCriteria programInfoQueryCriteria, int i) throws TvCommonException;

    private final native ProgramInfo native_getProgramInfoById(int i) throws TvCommonException;

    private static final native void native_init();

    private final native void native_programDown(int i) throws TvCommonException;

    private final native void native_programUp(int i) throws TvCommonException;

    private final native void native_setProgramAttribute(int i, int i2, short s, int i3, boolean z) throws TvCommonException;

    private final native void native_setup(Object obj);

    public final native boolean changeDtvToManualFirstService(int i) throws TvCommonException;

    public final native boolean changeProgramList() throws TvCommonException;

    public final native boolean deleteAllMainList() throws TvCommonException;

    public final native boolean deleteAtvMainList() throws TvCommonException;

    public final native boolean deleteChannelInformationByRf(short s) throws TvCommonException;

    public final native boolean deleteDtvMainList() throws TvCommonException;

    public final native int getCurrChannelNumber() throws TvCommonException;

    public final native AtscMainListChannelInformation getCurrentChannelInformation() throws TvCommonException;

    public final native ProgramInfo getCurrentProgramInfo() throws TvCommonException;

    public final native int getNvodReferenceServicesCount() throws TvCommonException;

    public final native GetServiceInfo[] getNvodReferenceServicesInfo(int i) throws TvCommonException;

    public final native String getProgramName(int i, short s, short s2) throws TvCommonException;

    public final native void moveProgram(int i, int i2) throws TvCommonException;

    public final native void returnToPreviousProgram() throws TvCommonException;

    public final native void selectProgram(int i, short s, int i2) throws TvCommonException;

    public final native boolean selectProgram(int i, int i2) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setProgramName(int i, int i2, String str) throws TvCommonException;

    public final native void setProgramName(int i, short s, int i2, String str) throws TvCommonException;

    public final native void switchPrograms(int i, int i2) throws TvCommonException;

    static {
        _channelManager = null;
        try {
            System.loadLibrary("channelmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load channelmanager_jni library:\n" + e.toString());
        }
    }

    protected static ChannelManager getInstance() {
        if (_channelManager == null) {
            synchronized (ChannelManager.class) {
                if (_channelManager == null) {
                    _channelManager = new ChannelManager();
                }
            }
        }
        return _channelManager;
    }

    private ChannelManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("ChannelManager callback  \n");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _channelManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _channelManager = null;
    }

    public void setProgramAttribute(EnumProgramAttribute enProgramAttribute, int programNo, short programType, int programId, boolean attributeValue) throws TvCommonException {
        native_setProgramAttribute(enProgramAttribute.ordinal(), programNo, programType, programId, attributeValue);
    }

    public boolean getProgramAttribute(EnumProgramAttribute enProgramAttribute, int programNo, short programType, int programId) throws TvCommonException {
        return native_getProgramAttribute(enProgramAttribute.ordinal(), programNo, programType, programId);
    }

    public final void programDown(EnumProgramLoopType programLoopType) throws TvCommonException {
        native_programDown(programLoopType.ordinal());
    }

    public void addProgramToFavorite(EnumFavoriteId favoriteId, int programNo, short programType, int programId) throws TvCommonException {
        native_addProgramToFavorite(favoriteId.getValue(), programNo, programType, programId);
    }

    public void deleteProgramFromFavorite(EnumFavoriteId favoriteId, int programNo, short programType, int programId) throws TvCommonException {
        native_deleteProgramFromFavorite(favoriteId.getValue(), programNo, programType, programId);
    }

    public final void programUp(EnumProgramLoopType programLoopType) throws TvCommonException {
        native_programUp(programLoopType.ordinal());
    }

    public ProgramInfo getProgramInfo(ProgramInfoQueryCriteria criteria, EnumProgramInfoType programInfoType) throws TvCommonException {
        return native_getProgramInfo(criteria, programInfoType.ordinal());
    }

    public int getProgramCount(EnumProgramCountType programCountType) throws TvCommonException {
        return native_getProgramCount(programCountType.ordinal());
    }

    public boolean changeToFirstService(EnumFirstServiceInputType enInputType, EnumFirstServiceType enServiceType) throws TvCommonException {
        return native_changeToFirstService(enInputType.ordinal(), enServiceType.ordinal());
    }

    public boolean genMixProgList(boolean backup) throws TvCommonException {
        return native_genMixProgList(backup);
    }

    public ProgramInfo getProgramInfo(int queryIndex) throws TvCommonException {
        return native_ATSC_getProgramInfo(queryIndex);
    }

    public final ProgramInfo getProgramInfoById(int Id) throws TvCommonException {
        return native_getProgramInfoById(Id);
    }
}
