package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvParentalControl extends IInterface {

    public static abstract class Stub extends Binder implements ITvParentalControl {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvParentalControl";
        static final int TRANSACTION_getParentalControlRating = 1;
        static final int TRANSACTION_getParentalPassword = 3;
        static final int TRANSACTION_isSystemLock = 6;
        static final int TRANSACTION_setParentalControlRating = 2;
        static final int TRANSACTION_setParentalPassword = 4;
        static final int TRANSACTION_setSystemLock = 5;
        static final int TRANSACTION_unlockChannel = 7;

        private static class Proxy implements ITvParentalControl {
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

            public int getParentalControlRating() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getParentalControlRating, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setParentalControlRating(int rating) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rating);
                    this.mRemote.transact(Stub.TRANSACTION_setParentalControlRating, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getParentalPassword() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getParentalPassword, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setParentalPassword(int psw) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(psw);
                    this.mRemote.transact(Stub.TRANSACTION_setParentalPassword, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setSystemLock(boolean islocked) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (islocked) {
                        i = Stub.TRANSACTION_getParentalControlRating;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setSystemLock, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isSystemLock() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isSystemLock, _data, _reply, 0);
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

            public void unlockChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_unlockChannel, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvParentalControl asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvParentalControl)) {
                return new Proxy(obj);
            }
            return (ITvParentalControl) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int _arg0 = 0;
            int _result;
            switch (code) {
                case TRANSACTION_getParentalControlRating /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getParentalControlRating();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setParentalControlRating /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    setParentalControlRating(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getParentalPassword /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getParentalPassword();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setParentalPassword /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    setParentalPassword(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSystemLock /*5*/:
                    boolean _arg02;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    }
                    setSystemLock(_arg02);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isSystemLock /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result2 = isSystemLock();
                    reply.writeNoException();
                    if (_result2) {
                        _arg0 = TRANSACTION_getParentalControlRating;
                    }
                    reply.writeInt(_arg0);
                    return true;
                case TRANSACTION_unlockChannel /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    unlockChannel();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    int getParentalControlRating() throws RemoteException;

    int getParentalPassword() throws RemoteException;

    boolean isSystemLock() throws RemoteException;

    void setParentalControlRating(int i) throws RemoteException;

    void setParentalPassword(int i) throws RemoteException;

    void setSystemLock(boolean z) throws RemoteException;

    void unlockChannel() throws RemoteException;
}
