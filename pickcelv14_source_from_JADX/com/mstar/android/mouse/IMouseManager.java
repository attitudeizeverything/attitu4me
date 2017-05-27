package com.mstar.android.mouse;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMouseManager extends IInterface {

    public static abstract class Stub extends Binder implements IMouseManager {
        private static final String DESCRIPTOR = "com.mstar.android.mouse.IMouseManager";
        static final int TRANSACTION_addApk = 1;
        static final int TRANSACTION_getApkList = 6;
        static final int TRANSACTION_getMouseControlFlag = 4;
        static final int TRANSACTION_hasApk = 3;
        static final int TRANSACTION_removeAllApk = 5;
        static final int TRANSACTION_removeApk = 2;
        static final int TRANSACTION_sendKeyEvent = 7;

        private static class Proxy implements IMouseManager {
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

            public void addApk(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_addApk, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void removeApk(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_removeApk, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean hasApk(String packageName) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(Stub.TRANSACTION_hasApk, _data, _reply, 0);
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

            public boolean getMouseControlFlag() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMouseControlFlag, _data, _reply, 0);
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

            public void removeAllApk() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_removeAllApk, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String[] getApkList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getApkList, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void sendKeyEvent(int eventAction, int eventKeyCode, long downTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eventAction);
                    _data.writeInt(eventKeyCode);
                    _data.writeLong(downTime);
                    this.mRemote.transact(Stub.TRANSACTION_sendKeyEvent, _data, _reply, 0);
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

        public static IMouseManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IMouseManager)) {
                return new Proxy(obj);
            }
            return (IMouseManager) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_addApk /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    addApk(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_removeApk /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    removeApk(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_hasApk /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = hasApk(data.readString());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_addApk;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getMouseControlFlag /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getMouseControlFlag();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_addApk;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_removeAllApk /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    removeAllApk();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getApkList /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    String[] _result2 = getApkList();
                    reply.writeNoException();
                    reply.writeStringArray(_result2);
                    return true;
                case TRANSACTION_sendKeyEvent /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    sendKeyEvent(data.readInt(), data.readInt(), data.readLong());
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

    void addApk(String str) throws RemoteException;

    String[] getApkList() throws RemoteException;

    boolean getMouseControlFlag() throws RemoteException;

    boolean hasApk(String str) throws RemoteException;

    void removeAllApk() throws RemoteException;

    void removeApk(String str) throws RemoteException;

    void sendKeyEvent(int i, int i2, long j) throws RemoteException;
}
