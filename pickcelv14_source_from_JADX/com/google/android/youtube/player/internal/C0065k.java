package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.k */
public interface C0065k extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.k.a */
    public static abstract class C0362a extends Binder implements C0065k {

        /* renamed from: com.google.android.youtube.player.internal.k.a.a */
        private static class C0361a implements C0065k {
            private IBinder f121a;

            C0361a(IBinder iBinder) {
                this.f121a = iBinder;
            }

            public final void m266a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f121a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m267a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    obtain.writeString(str);
                    this.f121a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m268a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f121a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f121a;
            }

            public final void m269b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f121a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m270c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f121a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m271d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f121a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0065k m272a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0065k)) ? new C0361a(iBinder) : (C0065k) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m92a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m93a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m91a();
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_ALIAS /*4*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m94b();
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_WKN_GRP /*5*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m95c();
                    parcel2.writeNoException();
                    return true;
                case SID.SID_TYPE_DELETED /*6*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    m96d();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m91a() throws RemoteException;

    void m92a(String str) throws RemoteException;

    void m93a(String str, int i) throws RemoteException;

    void m94b() throws RemoteException;

    void m95c() throws RemoteException;

    void m96d() throws RemoteException;
}
