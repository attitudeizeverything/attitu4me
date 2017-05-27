package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.C0064j.C0360a.C0359a;
import com.google.android.youtube.player.internal.C0065k.C0362a;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.l */
public interface C0066l extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.l.a */
    public static abstract class C0364a extends Binder implements C0066l {

        /* renamed from: com.google.android.youtube.player.internal.l.a.a */
        private static class C0363a implements C0066l {
            private IBinder f122a;

            C0363a(IBinder iBinder) {
                this.f122a = iBinder;
            }

            public final IBinder m273a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.f122a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final C0065k m274a(C0064j c0064j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeStrongBinder(c0064j != null ? c0064j.asBinder() : null);
                    this.f122a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0065k a = C0362a.m272a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m275a(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f122a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f122a;
            }
        }

        public static C0066l m276a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0066l)) ? new C0363a(iBinder) : (C0066l) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder a = m97a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    C0064j c0064j;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c0064j = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                        c0064j = (queryLocalInterface == null || !(queryLocalInterface instanceof C0064j)) ? new C0359a(readStrongBinder) : (C0064j) queryLocalInterface;
                    }
                    C0065k a2 = m98a(c0064j);
                    parcel2.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    m99a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m97a() throws RemoteException;

    C0065k m98a(C0064j c0064j) throws RemoteException;

    void m99a(boolean z) throws RemoteException;
}
