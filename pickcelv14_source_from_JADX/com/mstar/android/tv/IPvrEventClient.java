package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPvrEventClient extends IInterface {

    public static abstract class Stub extends Binder implements IPvrEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.IPvrEventClient";
        static final int TRANSACTION_onPvrNotifyFormatFinished = 3;
        static final int TRANSACTION_onPvrNotifyPlaybackBegin = 4;
        static final int TRANSACTION_onPvrNotifyPlaybackStop = 5;
        static final int TRANSACTION_onPvrNotifyUsbInserted = 1;
        static final int TRANSACTION_onPvrNotifyUsbRemoved = 2;

        private static class Proxy implements IPvrEventClient {
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

            public boolean onPvrNotifyUsbInserted(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyUsbInserted, _data, _reply, 0);
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

            public boolean onPvrNotifyUsbRemoved(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyUsbRemoved, _data, _reply, 0);
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

            public boolean onPvrNotifyFormatFinished(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyFormatFinished, _data, _reply, 0);
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

            public boolean onPvrNotifyPlaybackBegin(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackBegin, _data, _reply, 0);
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

            public boolean onPvrNotifyPlaybackStop(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackStop, _data, _reply, 0);
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

        public static IPvrEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IPvrEventClient)) {
                return new Proxy(obj);
            }
            return (IPvrEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onPvrNotifyUsbInserted /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyUsbInserted(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onPvrNotifyUsbInserted;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyUsbRemoved /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyUsbRemoved(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onPvrNotifyUsbInserted;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyFormatFinished /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyFormatFinished(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onPvrNotifyUsbInserted;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackBegin /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackBegin(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onPvrNotifyUsbInserted;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackStop /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackStop(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onPvrNotifyUsbInserted;
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

    boolean onPvrNotifyFormatFinished(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyPlaybackBegin(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyPlaybackStop(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyUsbInserted(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyUsbRemoved(int i, int i2, int i3) throws RemoteException;
}
