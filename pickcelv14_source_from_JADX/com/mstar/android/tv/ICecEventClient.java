package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICecEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ICecEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ICecEventClient";
        static final int TRANSACTION_onImageViewOn = 1;
        static final int TRANSACTION_onTextViewOn = 2;

        private static class Proxy implements ICecEventClient {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean onImageViewOn(int what) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onImageViewOn, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() == 0) {
                        _result = false;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean onTextViewOn(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onTextViewOn, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICecEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ICecEventClient)) {
                return new Proxy(obj);
            }
            return (ICecEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onImageViewOn /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onImageViewOn(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onImageViewOn;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onTextViewOn /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onTextViewOn(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onImageViewOn;
                    }
                    reply.writeInt(i);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean onImageViewOn(int i) throws RemoteException;

    boolean onTextViewOn(int i) throws RemoteException;
}
