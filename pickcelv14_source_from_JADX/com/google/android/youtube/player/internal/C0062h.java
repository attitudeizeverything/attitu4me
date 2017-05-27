package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.h */
public interface C0062h extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.h.a */
    public static abstract class C0356a extends Binder implements C0062h {

        /* renamed from: com.google.android.youtube.player.internal.h.a.a */
        private static class C0355a implements C0062h {
            private IBinder f118a;

            C0355a(IBinder iBinder) {
                this.f118a = iBinder;
            }

            public final void m259a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f118a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f118a;
            }

            public final void m260b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f118a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m261c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f118a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0356a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IPlaylistEventListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m85a();
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m86b();
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m87c();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m85a() throws RemoteException;

    void m86b() throws RemoteException;

    void m87c() throws RemoteException;
}
