package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import com.google.android.youtube.player.internal.C0059e.C0350a.C0349a;
import com.google.android.youtube.player.internal.C0060f.C0352a.C0351a;
import com.google.android.youtube.player.internal.C0061g.C0354a.C0353a;
import com.google.android.youtube.player.internal.C0062h.C0356a.C0355a;
import com.google.android.youtube.player.internal.C0079u.C0369a;
import com.mstar.android.camera.MCamera.Parameters;
import com.mstar.android.media.MstMediaMetadataRetriever;
import com.mstar.android.samba.OnRecvMsg;
import com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation;
import com.mstar.android.widi.WidiMonitor;
import java.util.List;
import jcifs.dcerpc.msrpc.lsarpc;
import jcifs.smb.SID;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.d */
public interface C0058d extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.d.a */
    public static abstract class C0348a extends Binder implements C0058d {

        /* renamed from: com.google.android.youtube.player.internal.d.a.a */
        private static class C0347a implements C0058d {
            private IBinder f114a;

            C0347a(IBinder iBinder) {
                this.f114a = iBinder;
            }

            public final void m203a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m204a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.f114a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m205a(Configuration configuration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (configuration != null) {
                        obtain.writeInt(1);
                        configuration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f114a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m206a(C0059e c0059e) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(c0059e != null ? c0059e.asBinder() : null);
                    this.f114a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m207a(C0060f c0060f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(c0060f != null ? c0060f.asBinder() : null);
                    this.f114a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m208a(C0061g c0061g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(c0061g != null ? c0061g.asBinder() : null);
                    this.f114a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m209a(C0062h c0062h) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStrongBinder(c0062h != null ? c0062h.asBinder() : null);
                    this.f114a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m210a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    this.f114a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m211a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f114a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m212a(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f114a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m213a(List<String> list, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f114a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m214a(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f114a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m215a(int i, KeyEvent keyEvent) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f114a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m216a(Bundle bundle) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f114a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f114a;
            }

            public final void m217b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m218b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.f114a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m219b(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f114a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m220b(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f114a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m221b(List<String> list, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f114a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m222b(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f114a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m223b(int i, KeyEvent keyEvent) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f114a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m224c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.f114a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m225c(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f114a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m226c() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m227d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    obtain.writeInt(i);
                    this.f114a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m228d(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f114a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m229d() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m230e(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f114a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean m231e() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m232f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m233g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int m234h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int m235i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int m236j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m237k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m238l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m239m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m240n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m241o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m242p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m243q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle m244r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final C0079u m245s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f114a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    C0079u a = C0369a.m314a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0058d m246a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0058d)) ? new C0347a(iBinder) : (C0058d) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            int i3 = 0;
            boolean c;
            int h;
            boolean z;
            IBinder readStrongBinder;
            IInterface queryLocalInterface;
            Bundle r;
            int readInt;
            KeyEvent keyEvent;
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m41a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m38a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m46b(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_ALIAS /*4*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m39a(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_WKN_GRP /*5*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m47b(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_DELETED /*6*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m40a(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_INVALID /*7*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m48b(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_UNKNOWN /*8*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m30a();
                    parcel2.writeNoException();
                    return true;
                case SmbConstants.FLAGS_OFFSET /*9*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m44b();
                    parcel2.writeNoException();
                    return true;
                case SmbConstants.DEFAULT_MAX_MPX_COUNT /*10*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    c = m53c();
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case WidiMonitor.WIDI_SHOW_SCREEN_EVENT /*11*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    c = m56d();
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case lsarpc.POLICY_INFO_DNS_DOMAIN /*12*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    c = m58e();
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case WidiMonitor.WIDI_DISCONNECTION_EVENT /*13*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m59f();
                    parcel2.writeNoException();
                    return true;
                case SmbConstants.SIGNATURE_OFFSET /*14*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m60g();
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_STOP_SUCCESS_EVENT /*15*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    h = m61h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h);
                    return true;
                case SmbFile.TYPE_NAMED_PIPE /*16*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    h = m62i();
                    parcel2.writeNoException();
                    parcel2.writeInt(h);
                    return true;
                case WidiMonitor.WIDI_START_SUCCESS_EVENT /*17*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m31a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_BINDED_SUCCESS_EVENT /*18*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m45b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case OnRecvMsg.NT_STATUS_UMOUNT_FAILURE /*19*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m49b(z);
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_BINDED_FAIL_EVENT /*20*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m51c(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_CONNECTION_FAIL_EVENT /*21*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    h = m63j();
                    parcel2.writeNoException();
                    parcel2.writeInt(h);
                    return true;
                case WidiMonitor.WIDI_AUTHENTICATE_FAIL_EVENT /*22*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m54d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_DHCP_FAIL_EVENT /*23*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m37a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case SmbConstants.TID_OFFSET /*24*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m52c(z);
                    parcel2.writeNoException();
                    return true;
                case WidiMonitor.WIDI_CONNECTING_EVENT /*25*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m55d(z);
                    parcel2.writeNoException();
                    return true;
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_IS_DEVICE_FIRSTTIME_REG /*26*/:
                    C0059e c0349a;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                        c0349a = (queryLocalInterface == null || !(queryLocalInterface instanceof C0059e)) ? new C0349a(readStrongBinder) : (C0059e) queryLocalInterface;
                    }
                    m33a(c0349a);
                    parcel2.writeNoException();
                    return true;
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_IS_DEVICE_REG /*27*/:
                    C0062h c0355a;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                        c0355a = (queryLocalInterface == null || !(queryLocalInterface instanceof C0062h)) ? new C0355a(readStrongBinder) : (C0062h) queryLocalInterface;
                    }
                    m36a(c0355a);
                    parcel2.writeNoException();
                    return true;
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_REG_CODE /*28*/:
                    C0061g c0353a;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        c0353a = (queryLocalInterface == null || !(queryLocalInterface instanceof C0061g)) ? new C0353a(readStrongBinder) : (C0061g) queryLocalInterface;
                    }
                    m35a(c0353a);
                    parcel2.writeNoException();
                    return true;
                case MstMediaMetadataRetriever.METADATA_KEY_DIVX_DRM_GEN_DEREG_CODE /*29*/:
                    C0060f c0351a;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                        c0351a = (queryLocalInterface == null || !(queryLocalInterface instanceof C0060f)) ? new C0351a(readStrongBinder) : (C0060f) queryLocalInterface;
                    }
                    m34a(c0351a);
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_DVI2 /*30*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m64k();
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_DVI3 /*31*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m65l();
                    parcel2.writeNoException();
                    return true;
                case SmbFile.TYPE_PRINTER /*32*/:
                    Configuration configuration;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        configuration = (Configuration) Configuration.CREATOR.createFromParcel(parcel);
                    }
                    m32a(configuration);
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_DVI_MAX /*33*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m66m();
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_STORAGE /*34*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m67n();
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_KTV /*35*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m68o();
                    parcel2.writeNoException();
                    return true;
                case Region5RatingInformation.RRT5_REGNAME_LENGTH /*36*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m69p();
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_DTV2 /*37*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m57e(z);
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_STORAGE2 /*38*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m70q();
                    parcel2.writeNoException();
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_DTV3 /*39*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    r = m71r();
                    parcel2.writeNoException();
                    if (r != null) {
                        parcel2.writeInt(1);
                        r.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case Parameters.MAPI_INPUT_SOURCE_SCALER_OP /*40*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (parcel.readInt() != 0) {
                        r = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    c = m43a(r);
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                    }
                    c = m42a(readInt, keyEvent);
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                    }
                    c = m50b(readInt, keyEvent);
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    C0079u s = m72s();
                    parcel2.writeNoException();
                    if (s != null) {
                        iBinder = s.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m30a() throws RemoteException;

    void m31a(int i) throws RemoteException;

    void m32a(Configuration configuration) throws RemoteException;

    void m33a(C0059e c0059e) throws RemoteException;

    void m34a(C0060f c0060f) throws RemoteException;

    void m35a(C0061g c0061g) throws RemoteException;

    void m36a(C0062h c0062h) throws RemoteException;

    void m37a(String str) throws RemoteException;

    void m38a(String str, int i) throws RemoteException;

    void m39a(String str, int i, int i2) throws RemoteException;

    void m40a(List<String> list, int i, int i2) throws RemoteException;

    void m41a(boolean z) throws RemoteException;

    boolean m42a(int i, KeyEvent keyEvent) throws RemoteException;

    boolean m43a(Bundle bundle) throws RemoteException;

    void m44b() throws RemoteException;

    void m45b(int i) throws RemoteException;

    void m46b(String str, int i) throws RemoteException;

    void m47b(String str, int i, int i2) throws RemoteException;

    void m48b(List<String> list, int i, int i2) throws RemoteException;

    void m49b(boolean z) throws RemoteException;

    boolean m50b(int i, KeyEvent keyEvent) throws RemoteException;

    void m51c(int i) throws RemoteException;

    void m52c(boolean z) throws RemoteException;

    boolean m53c() throws RemoteException;

    void m54d(int i) throws RemoteException;

    void m55d(boolean z) throws RemoteException;

    boolean m56d() throws RemoteException;

    void m57e(boolean z) throws RemoteException;

    boolean m58e() throws RemoteException;

    void m59f() throws RemoteException;

    void m60g() throws RemoteException;

    int m61h() throws RemoteException;

    int m62i() throws RemoteException;

    int m63j() throws RemoteException;

    void m64k() throws RemoteException;

    void m65l() throws RemoteException;

    void m66m() throws RemoteException;

    void m67n() throws RemoteException;

    void m68o() throws RemoteException;

    void m69p() throws RemoteException;

    void m70q() throws RemoteException;

    Bundle m71r() throws RemoteException;

    C0079u m72s() throws RemoteException;
}
