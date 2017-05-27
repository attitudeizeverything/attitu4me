package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.e */
public interface C0059e extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.e.a */
    public static abstract class C0350a extends Binder implements C0059e {

        /* renamed from: com.google.android.youtube.player.internal.e.a.a */
        private static class C0349a implements C0059e {
            private IBinder f115a;

            C0349a(IBinder iBinder) {
                this.f115a = iBinder;
            }

            public final void m247a(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f115a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f115a;
            }
        }

        public C0350a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    m73a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m73a(boolean z) throws RemoteException;
}
