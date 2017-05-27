package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ITvEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvEventClient";
        static final int TRANSACTION_onAtscPopupDialog = 7;
        static final int TRANSACTION_onDtvReadyPopupDialog = 1;
        static final int TRANSACTION_onScartMuteOsdMode = 2;
        static final int TRANSACTION_onScreenSaverMode = 6;
        static final int TRANSACTION_onSignalLock = 4;
        static final int TRANSACTION_onSignalUnlock = 3;
        static final int TRANSACTION_onUnityEvent = 5;

        private static class Proxy implements ITvEventClient {
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

            public boolean onDtvReadyPopupDialog(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onDtvReadyPopupDialog, _data, _reply, 0);
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

            public boolean onScartMuteOsdMode(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onScartMuteOsdMode, _data, _reply, 0);
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

            public boolean onSignalUnlock(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onSignalUnlock, _data, _reply, 0);
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

            public boolean onSignalLock(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onSignalLock, _data, _reply, 0);
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

            public boolean onUnityEvent(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onUnityEvent, _data, _reply, 0);
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

            public boolean onScreenSaverMode(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onScreenSaverMode, _data, _reply, 0);
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

            public boolean onAtscPopupDialog(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onAtscPopupDialog, _data, _reply, 0);
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

        public static ITvEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvEventClient)) {
                return new Proxy(obj);
            }
            return (ITvEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onDtvReadyPopupDialog /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDtvReadyPopupDialog(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onScartMuteOsdMode /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onScartMuteOsdMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalUnlock /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalUnlock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalLock /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUnityEvent /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUnityEvent(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onScreenSaverMode /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onScreenSaverMode(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onAtscPopupDialog /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onAtscPopupDialog(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvReadyPopupDialog;
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

    boolean onAtscPopupDialog(int i, int i2, int i3) throws RemoteException;

    boolean onDtvReadyPopupDialog(int i, int i2, int i3) throws RemoteException;

    boolean onScartMuteOsdMode(int i) throws RemoteException;

    boolean onScreenSaverMode(int i, int i2, int i3) throws RemoteException;

    boolean onSignalLock(int i) throws RemoteException;

    boolean onSignalUnlock(int i) throws RemoteException;

    boolean onUnityEvent(int i, int i2, int i3) throws RemoteException;
}
