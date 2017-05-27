package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICiEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ICiEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ICiEventClient";
        static final int TRANSACTION_onUiAutotestMessageShown = 5;
        static final int TRANSACTION_onUiCardInserted = 3;
        static final int TRANSACTION_onUiCardRemoved = 4;
        static final int TRANSACTION_onUiCloseMmi = 2;
        static final int TRANSACTION_onUiDataReady = 1;

        private static class Proxy implements ICiEventClient {
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

            public boolean onUiDataReady(int what) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiDataReady, _data, _reply, 0);
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

            public boolean onUiCloseMmi(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiCloseMmi, _data, _reply, 0);
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

            public boolean onUiCardInserted(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiCardInserted, _data, _reply, 0);
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

            public boolean onUiCardRemoved(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiCardRemoved, _data, _reply, 0);
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

            public boolean onUiAutotestMessageShown(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiAutotestMessageShown, _data, _reply, 0);
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

        public static ICiEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ICiEventClient)) {
                return new Proxy(obj);
            }
            return (ICiEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onUiDataReady /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiDataReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onUiDataReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiCloseMmi /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiCloseMmi(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onUiDataReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiCardInserted /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiCardInserted(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onUiDataReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiCardRemoved /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiCardRemoved(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onUiDataReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiAutotestMessageShown /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiAutotestMessageShown(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onUiDataReady;
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

    boolean onUiAutotestMessageShown(int i) throws RemoteException;

    boolean onUiCardInserted(int i) throws RemoteException;

    boolean onUiCardRemoved(int i) throws RemoteException;

    boolean onUiCloseMmi(int i) throws RemoteException;

    boolean onUiDataReady(int i) throws RemoteException;
}
