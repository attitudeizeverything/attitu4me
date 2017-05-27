package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.c */
public interface C0057c extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.c.a */
    public static abstract class C0346a extends Binder implements C0057c {

        /* renamed from: com.google.android.youtube.player.internal.c.a.a */
        private static class C0345a implements C0057c {
            private IBinder f113a;

            C0345a(IBinder iBinder) {
                this.f113a = iBinder;
            }

            public final void m202a(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    this.f113a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f113a;
            }
        }

        public C0346a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    m29a(parcel.readString(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m29a(String str, IBinder iBinder) throws RemoteException;
}
