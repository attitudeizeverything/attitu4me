package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPictureEventClient extends IInterface {

    public static abstract class Stub extends Binder implements IPictureEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.IPictureEventClient";
        static final int TRANSACTION_on4K2KPhotoDisableDualview = 4;
        static final int TRANSACTION_on4K2KPhotoDisablePip = 2;
        static final int TRANSACTION_on4K2KPhotoDisablePop = 3;
        static final int TRANSACTION_on4K2KPhotoDisableTravelingmode = 5;
        static final int TRANSACTION_onSetAspectratio = 1;

        private static class Proxy implements IPictureEventClient {
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

            public boolean onSetAspectratio(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onSetAspectratio, _data, _reply, 0);
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

            public boolean on4K2KPhotoDisablePip(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_on4K2KPhotoDisablePip, _data, _reply, 0);
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

            public boolean on4K2KPhotoDisablePop(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_on4K2KPhotoDisablePop, _data, _reply, 0);
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

            public boolean on4K2KPhotoDisableDualview(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_on4K2KPhotoDisableDualview, _data, _reply, 0);
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

            public boolean on4K2KPhotoDisableTravelingmode(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_on4K2KPhotoDisableTravelingmode, _data, _reply, 0);
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

        public static IPictureEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IPictureEventClient)) {
                return new Proxy(obj);
            }
            return (IPictureEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onSetAspectratio /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSetAspectratio(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onSetAspectratio;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_on4K2KPhotoDisablePip /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = on4K2KPhotoDisablePip(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onSetAspectratio;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_on4K2KPhotoDisablePop /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = on4K2KPhotoDisablePop(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onSetAspectratio;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_on4K2KPhotoDisableDualview /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = on4K2KPhotoDisableDualview(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onSetAspectratio;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_on4K2KPhotoDisableTravelingmode /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = on4K2KPhotoDisableTravelingmode(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onSetAspectratio;
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

    boolean on4K2KPhotoDisableDualview(int i, int i2, int i3) throws RemoteException;

    boolean on4K2KPhotoDisablePip(int i, int i2, int i3) throws RemoteException;

    boolean on4K2KPhotoDisablePop(int i, int i2, int i3) throws RemoteException;

    boolean on4K2KPhotoDisableTravelingmode(int i, int i2, int i3) throws RemoteException;

    boolean onSetAspectratio(int i, int i2, int i3) throws RemoteException;
}
