package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITimerEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ITimerEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITimerEventClient";
        static final int TRANSACTION_onDestroyCountDown = 1;
        static final int TRANSACTION_onEpgTimeUp = 6;
        static final int TRANSACTION_onEpgTimerCountDown = 7;
        static final int TRANSACTION_onEpgTimerRecordStart = 8;
        static final int TRANSACTION_onLastMinuteWarn = 3;
        static final int TRANSACTION_onOadTimeScan = 10;
        static final int TRANSACTION_onOneSecondBeat = 2;
        static final int TRANSACTION_onPowerDownTime = 11;
        static final int TRANSACTION_onPvrNotifyRecordStop = 9;
        static final int TRANSACTION_onSignalLock = 5;
        static final int TRANSACTION_onUpdateLastMinute = 4;

        private static class Proxy implements ITimerEventClient {
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

            public boolean onDestroyCountDown(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onDestroyCountDown, _data, _reply, 0);
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

            public boolean onOneSecondBeat(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onOneSecondBeat, _data, _reply, 0);
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

            public boolean onLastMinuteWarn(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onLastMinuteWarn, _data, _reply, 0);
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

            public boolean onUpdateLastMinute(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onUpdateLastMinute, _data, _reply, 0);
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

            public boolean onSignalLock(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
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

            public boolean onEpgTimeUp(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onEpgTimeUp, _data, _reply, 0);
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

            public boolean onEpgTimerCountDown(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onEpgTimerCountDown, _data, _reply, 0);
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

            public boolean onEpgTimerRecordStart(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onEpgTimerRecordStart, _data, _reply, 0);
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

            public boolean onPvrNotifyRecordStop(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyRecordStop, _data, _reply, 0);
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

            public boolean onOadTimeScan(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onOadTimeScan, _data, _reply, 0);
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

            public boolean onPowerDownTime(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPowerDownTime, _data, _reply, 0);
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

        public static ITimerEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITimerEventClient)) {
                return new Proxy(obj);
            }
            return (ITimerEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onDestroyCountDown /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDestroyCountDown(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOneSecondBeat /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOneSecondBeat(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onLastMinuteWarn /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onLastMinuteWarn(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUpdateLastMinute /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUpdateLastMinute(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalLock /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalLock(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEpgTimeUp /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEpgTimeUp(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEpgTimerCountDown /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEpgTimerCountDown(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEpgTimerRecordStart /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEpgTimerRecordStart(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyRecordStop /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyRecordStop(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOadTimeScan /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOadTimeScan(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPowerDownTime /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPowerDownTime(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDestroyCountDown;
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

    boolean onDestroyCountDown(int i, int i2, int i3) throws RemoteException;

    boolean onEpgTimeUp(int i, int i2, int i3) throws RemoteException;

    boolean onEpgTimerCountDown(int i, int i2, int i3) throws RemoteException;

    boolean onEpgTimerRecordStart(int i, int i2, int i3) throws RemoteException;

    boolean onLastMinuteWarn(int i, int i2, int i3) throws RemoteException;

    boolean onOadTimeScan(int i, int i2, int i3) throws RemoteException;

    boolean onOneSecondBeat(int i, int i2, int i3) throws RemoteException;

    boolean onPowerDownTime(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyRecordStop(int i, int i2, int i3) throws RemoteException;

    boolean onSignalLock(int i, int i2, int i3) throws RemoteException;

    boolean onUpdateLastMinute(int i, int i2, int i3) throws RemoteException;
}
