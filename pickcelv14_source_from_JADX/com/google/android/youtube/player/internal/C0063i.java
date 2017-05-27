package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.C0057c.C0346a.C0345a;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.i */
public interface C0063i extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.i.a */
    public static abstract class C0358a extends Binder implements C0063i {

        /* renamed from: com.google.android.youtube.player.internal.i.a.a */
        private static class C0357a implements C0063i {
            private IBinder f119a;

            C0357a(IBinder iBinder) {
                this.f119a = iBinder;
            }

            public final void m262a(C0057c c0057c, int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
                    obtain.writeStrongBinder(c0057c != null ? c0057c.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f119a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f119a;
            }
        }

        public static C0063i m263a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0063i)) ? new C0357a(iBinder) : (C0063i) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            switch (i) {
                case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                    C0057c c0057c;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c0057c = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                        c0057c = (queryLocalInterface == null || !(queryLocalInterface instanceof C0057c)) ? new C0345a(readStrongBinder) : (C0057c) queryLocalInterface;
                    }
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m88a(c0057c, readInt, readString, readString2, readString3, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m88a(C0057c c0057c, int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;
}
