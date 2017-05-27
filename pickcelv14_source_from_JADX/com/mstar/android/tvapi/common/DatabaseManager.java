package com.mstar.android.tvapi.common;

import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.EnumDatabaseTypeIndex;
import java.lang.ref.WeakReference;

public final class DatabaseManager {
    private static DatabaseManager _DatabaseManager;
    private int mDatabaseManagerContext;
    private int mNativeContext;

    private final native void native_finalize();

    private final native String native_getCustomerSqlDbPathInfo(int i) throws TvCommonException;

    private final native String native_getCustomerSqlDbTableName(int i) throws TvCommonException;

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native void clearNativeDatabaseDirty(short s) throws TvCommonException;

    public final native boolean isNativeDatabaseDirty(short s) throws TvCommonException;

    public final native void setDatabaseDirtyByApplication(short s) throws TvCommonException;

    public final native void setDebugMode(boolean z) throws TvCommonException;

    static {
        _DatabaseManager = null;
        try {
            System.loadLibrary("databasemanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load databasemanager_jni library:\n" + e.toString());
        }
    }

    protected static DatabaseManager getInstance() {
        if (_DatabaseManager == null) {
            synchronized (DatabaseManager.class) {
                if (_DatabaseManager == null) {
                    _DatabaseManager = new DatabaseManager();
                }
            }
        }
        return _DatabaseManager;
    }

    private DatabaseManager() {
        native_setup(new WeakReference(this));
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        System.out.println("\n NativeDatabaseManager callback");
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _DatabaseManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _DatabaseManager = null;
    }

    @Deprecated
    public final String getCustomerSqlDbPathInformation(EnumDatabaseTypeIndex databaseTypeIndex) throws TvCommonException {
        return getCustomerSqlDbPathInfo(databaseTypeIndex);
    }

    public final String getCustomerSqlDbPathInfo(EnumDatabaseTypeIndex databaseTypeIndex) throws TvCommonException {
        return native_getCustomerSqlDbPathInfo(databaseTypeIndex.ordinal());
    }

    public final String getCustomerSqlDbTableName(EnumDatabaseTypeIndex databaseTypeIndex) throws TvCommonException {
        return native_getCustomerSqlDbTableName(databaseTypeIndex.ordinal());
    }
}
