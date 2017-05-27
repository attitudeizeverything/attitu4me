package com.mstar.android.tvapi.dtv.dvb.isdb;

import android.os.Parcel;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.dtv.dvb.isdb.vo.GingaInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GingaManager {
    private static final String LIBRARY = "gingamanager_jni";
    private static final String TAG = "GingaManager";
    private static GingaManager mInstance;
    private int mNativeContext;

    private final native boolean _getGingaApps(Parcel parcel, Parcel parcel2) throws TvCommonException;

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(Object obj);

    public final native boolean autoStartApplication() throws TvCommonException;

    public final native boolean disableGigna() throws TvCommonException;

    public final native boolean enableGinga() throws TvCommonException;

    public final native boolean isGingaEnabled() throws TvCommonException;

    public final native boolean isGingaRunning() throws TvCommonException;

    public final native boolean processKey(int i, boolean z) throws TvCommonException;

    public final native boolean startApplication(long j, long j2) throws TvCommonException;

    public final native boolean stopApplication() throws TvCommonException;

    static {
        mInstance = null;
        try {
            System.loadLibrary(LIBRARY);
            native_init();
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, String.format("Cannot load %s library:%s\n", new Object[]{LIBRARY, e.toString()}));
        }
    }

    public static GingaManager getInstance() {
        if (mInstance == null) {
            synchronized (GingaManager.class) {
                if (mInstance == null) {
                    mInstance = new GingaManager();
                }
            }
        }
        return mInstance;
    }

    protected GingaManager() {
        try {
            native_setup(new WeakReference(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            native_finalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mInstance = null;
    }

    public final ArrayList<GingaInfo> getApps(String path) throws TvCommonException {
        Parcel reply = Parcel.obtain();
        Parcel request = Parcel.obtain();
        request.writeString(path);
        Log.i(TAG, path);
        _getGingaApps(request, reply);
        ArrayList<GingaInfo> result = new ArrayList();
        int arrayLenth = reply.readInt();
        for (int i = 0; i < arrayLenth; i++) {
            GingaInfo arrayElement = new GingaInfo();
            arrayElement.aid = reply.readInt();
            arrayElement.oid = reply.readInt();
            arrayElement.name = reply.readString();
            arrayElement.type = reply.readInt();
            arrayElement.flag = reply.readInt();
            result.add(arrayElement);
        }
        request.recycle();
        reply.recycle();
        return result;
    }
}
