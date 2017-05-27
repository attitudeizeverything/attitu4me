package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.atv.vo.AtvEventScan;

public interface IAtvPlayerEventClient extends IInterface {

    public static abstract class Stub extends Binder implements IAtvPlayerEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.IAtvPlayerEventClient";
        static final int TRANSACTION_onAtvAutoTuningScanInfo = 1;
        static final int TRANSACTION_onAtvManualTuningScanInfo = 2;
        static final int TRANSACTION_onAtvProgramInfoReady = 5;
        static final int TRANSACTION_onSignalLock = 3;
        static final int TRANSACTION_onSignalUnLock = 4;

        private static class Proxy implements IAtvPlayerEventClient {
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

            public boolean onAtvAutoTuningScanInfo(int what, AtvEventScan extra) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (extra != null) {
                        _data.writeInt(Stub.TRANSACTION_onAtvAutoTuningScanInfo);
                        extra.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onAtvAutoTuningScanInfo, _data, _reply, 0);
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

            public boolean onAtvManualTuningScanInfo(int what, AtvEventScan extra) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (extra != null) {
                        _data.writeInt(Stub.TRANSACTION_onAtvAutoTuningScanInfo);
                        extra.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onAtvManualTuningScanInfo, _data, _reply, 0);
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

            public boolean onSignalUnLock(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onSignalUnLock, _data, _reply, 0);
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

            public boolean onAtvProgramInfoReady(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onAtvProgramInfoReady, _data, _reply, 0);
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

        public static IAtvPlayerEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IAtvPlayerEventClient)) {
                return new Proxy(obj);
            }
            return (IAtvPlayerEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            int _arg0;
            AtvEventScan _arg1;
            boolean _result;
            switch (code) {
                case TRANSACTION_onAtvAutoTuningScanInfo /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = (AtvEventScan) AtvEventScan.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    _result = onAtvAutoTuningScanInfo(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onAtvAutoTuningScanInfo;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onAtvManualTuningScanInfo /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = (AtvEventScan) AtvEventScan.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    _result = onAtvManualTuningScanInfo(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onAtvAutoTuningScanInfo;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalLock /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onAtvAutoTuningScanInfo;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalUnLock /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalUnLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onAtvAutoTuningScanInfo;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onAtvProgramInfoReady /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onAtvProgramInfoReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onAtvAutoTuningScanInfo;
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

    boolean onAtvAutoTuningScanInfo(int i, AtvEventScan atvEventScan) throws RemoteException;

    boolean onAtvManualTuningScanInfo(int i, AtvEventScan atvEventScan) throws RemoteException;

    boolean onAtvProgramInfoReady(int i) throws RemoteException;

    boolean onSignalLock(int i) throws RemoteException;

    boolean onSignalUnLock(int i) throws RemoteException;
}
