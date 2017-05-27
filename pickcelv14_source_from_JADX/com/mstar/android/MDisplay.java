package com.mstar.android;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import com.mstar.android.tvapi.common.PictureManager;
import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.exception.TvCommonException;

public class MDisplay {
    static final int GET_PANEL_MODE = 17;
    static final int SET_AUTO_STEREO_MODE = 14;
    static final int SET_BYPASS_TRANSFORM_MODE = 15;
    static final int SET_GOP_STRETCH_WIN = 18;
    static final int SET_PANEL_MODE = 16;

    public enum PanelMode {
        E_PANELMODE_NONE,
        E_PANELMODE_NORMAL,
        E_PANELMODE_4K1K_FP,
        E_PANELMODE_4K2K_15HZ
    }

    public static void set3DDisplayMode(int mode) {
        SystemProperties.set("mstar.desk-display-mode", String.valueOf(mode));
    }

    public static void setAutoStereoMode(int identity, int autoStereo) {
        try {
            IBinder surfaceFlinger = ServiceManager.getService("SurfaceFlinger");
            if (surfaceFlinger != null) {
                Parcel data = Parcel.obtain();
                data.writeInterfaceToken("android.ui.ISurfaceComposer");
                data.writeInt(identity);
                data.writeInt(autoStereo);
                surfaceFlinger.transact(SET_AUTO_STEREO_MODE, data, null, 0);
                data.recycle();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void setBypassTransformMode(int identity, int bypassTransform) {
        try {
            IBinder surfaceFlinger = ServiceManager.getService("SurfaceFlinger");
            if (surfaceFlinger != null) {
                Parcel data = Parcel.obtain();
                data.writeInterfaceToken("android.ui.ISurfaceComposer");
                data.writeInt(identity);
                data.writeInt(bypassTransform);
                surfaceFlinger.transact(SET_BYPASS_TRANSFORM_MODE, data, null, 0);
                data.recycle();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void setPanelMode(PanelMode mode) {
        boolean z = false;
        try {
            IBinder surfaceFlinger = ServiceManager.getService("SurfaceFlinger");
            if (surfaceFlinger != null) {
                Parcel data = Parcel.obtain();
                data.writeInterfaceToken("android.ui.ISurfaceComposer");
                data.writeInt(mode.ordinal());
                surfaceFlinger.transact(SET_PANEL_MODE, data, null, 0);
                data.recycle();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            PictureManager pictureManager = TvManager.getInstance().getPictureManager();
            if (mode != PanelMode.E_PANELMODE_NORMAL) {
                z = true;
            }
            pictureManager.enter4K2KMode(z);
        } catch (TvCommonException e2) {
            e2.printStackTrace();
        }
    }

    public static PanelMode getPanelMode() {
        PanelMode mode = PanelMode.E_PANELMODE_NONE;
        try {
            IBinder surfaceFlinger = ServiceManager.getService("SurfaceFlinger");
            if (surfaceFlinger == null) {
                return mode;
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            data.writeInterfaceToken("android.ui.ISurfaceComposer");
            surfaceFlinger.transact(GET_PANEL_MODE, data, reply, 0);
            mode = PanelMode.values()[reply.readInt()];
            data.recycle();
            reply.recycle();
            return mode;
        } catch (RemoteException e) {
            e.printStackTrace();
            return mode;
        }
    }
}
