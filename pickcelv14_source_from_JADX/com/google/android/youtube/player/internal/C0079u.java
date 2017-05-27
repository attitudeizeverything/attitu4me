package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.youtube.player.internal.u */
public interface C0079u extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.u.a */
    public static abstract class C0369a extends Binder implements C0079u {

        /* renamed from: com.google.android.youtube.player.internal.u.a.a */
        private static class C0368a implements C0079u {
            private IBinder f139a;

            C0368a(IBinder iBinder) {
                this.f139a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f139a;
            }
        }

        public C0369a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static C0079u m314a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0079u)) ? new C0368a(iBinder) : (C0079u) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
