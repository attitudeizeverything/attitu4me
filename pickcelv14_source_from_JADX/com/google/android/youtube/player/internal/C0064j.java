package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.j */
public interface C0064j extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.j.a */
    public static abstract class C0360a extends Binder implements C0064j {

        /* renamed from: com.google.android.youtube.player.internal.j.a.a */
        private static class C0359a implements C0064j {
            private IBinder f120a;

            C0359a(IBinder iBinder) {
                this.f120a = iBinder;
            }

            public final void m264a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f120a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m265a(String str, boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f120a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f120a;
            }
        }

        public C0360a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    Bitmap bitmap = parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null;
                    String readString = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m89a(bitmap, readString, z2, z);
                    parcel2.writeNoException();
                    return true;
                case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    String readString2 = parcel.readString();
                    boolean z3 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m90a(readString2, z3, z);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m89a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException;

    void m90a(String str, boolean z, boolean z2) throws RemoteException;
}
