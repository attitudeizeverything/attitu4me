package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvMhl extends IInterface {

    public static abstract class Stub extends Binder implements ITvMhl {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvMhl";
        static final int TRANSACTION_CbusStatus = 2;
        static final int TRANSACTION_IRKeyProcess = 1;
        static final int TRANSACTION_IsMhlPortInUse = 3;
        static final int TRANSACTION_getAutoSwitch = 6;
        static final int TRANSACTION_setAutoSwitch = 5;
        static final int TRANSACTION_setDebugMode = 4;

        private static class Proxy implements ITvMhl {
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

            public boolean IRKeyProcess(int keycode, boolean bIsRelease) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(keycode);
                    if (bIsRelease) {
                        i = Stub.TRANSACTION_IRKeyProcess;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_IRKeyProcess, _data, _reply, 0);
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

            public boolean CbusStatus() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_CbusStatus, _data, _reply, 0);
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

            public boolean IsMhlPortInUse() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_IsMhlPortInUse, _data, _reply, 0);
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

            public void setDebugMode(boolean mode) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mode) {
                        i = Stub.TRANSACTION_IRKeyProcess;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setDebugMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setAutoSwitch(boolean isOpen) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (isOpen) {
                        i = Stub.TRANSACTION_IRKeyProcess;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setAutoSwitch, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean getAutoSwitch() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAutoSwitch, _data, _reply, 0);
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

        public static ITvMhl asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvMhl)) {
                return new Proxy(obj);
            }
            return (ITvMhl) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            boolean _arg0;
            switch (code) {
                case TRANSACTION_IRKeyProcess /*1*/:
                    boolean _arg1;
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = IRKeyProcess(_arg02, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_IRKeyProcess;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_CbusStatus /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = CbusStatus();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_IRKeyProcess;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_IsMhlPortInUse /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = IsMhlPortInUse();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_IRKeyProcess;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDebugMode /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setDebugMode(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setAutoSwitch /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setAutoSwitch(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAutoSwitch /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getAutoSwitch();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_IRKeyProcess;
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

    boolean CbusStatus() throws RemoteException;

    boolean IRKeyProcess(int i, boolean z) throws RemoteException;

    boolean IsMhlPortInUse() throws RemoteException;

    boolean getAutoSwitch() throws RemoteException;

    void setAutoSwitch(boolean z) throws RemoteException;

    void setDebugMode(boolean z) throws RemoteException;
}
