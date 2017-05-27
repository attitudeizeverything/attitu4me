package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.dtv.dvb.isdb.vo.GingaInfo;
import java.util.List;

public interface ITvGinga extends IInterface {

    public static abstract class Stub extends Binder implements ITvGinga {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvGinga";
        static final int TRANSACTION_disableGinga = 7;
        static final int TRANSACTION_enableGinga = 6;
        static final int TRANSACTION_getApps = 2;
        static final int TRANSACTION_isGingaEnabled = 8;
        static final int TRANSACTION_isGingaRunning = 5;
        static final int TRANSACTION_processKey = 1;
        static final int TRANSACTION_startApplication = 3;
        static final int TRANSACTION_stopApplication = 4;

        private static class Proxy implements ITvGinga {
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

            public boolean processKey(int keycode, boolean bPressed) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(keycode);
                    if (bPressed) {
                        i = Stub.TRANSACTION_processKey;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_processKey, _data, _reply, 0);
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

            public List<GingaInfo> getApps(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(Stub.TRANSACTION_getApps, _data, _reply, 0);
                    _reply.readException();
                    List<GingaInfo> _result = _reply.createTypedArrayList(GingaInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean startApplication(long aid, long oid) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(aid);
                    _data.writeLong(oid);
                    this.mRemote.transact(Stub.TRANSACTION_startApplication, _data, _reply, 0);
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

            public boolean stopApplication() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopApplication, _data, _reply, 0);
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

            public boolean isGingaRunning() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isGingaRunning, _data, _reply, 0);
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

            public boolean enableGinga() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableGinga, _data, _reply, 0);
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

            public boolean disableGinga() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableGinga, _data, _reply, 0);
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

            public boolean isGingaEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isGingaEnabled, _data, _reply, 0);
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

        public static ITvGinga asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvGinga)) {
                return new Proxy(obj);
            }
            return (ITvGinga) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_processKey /*1*/:
                    boolean _arg1;
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = processKey(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getApps /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    List<GingaInfo> _result2 = getApps(data.readString());
                    reply.writeNoException();
                    reply.writeTypedList(_result2);
                    return true;
                case TRANSACTION_startApplication /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startApplication(data.readLong(), data.readLong());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_stopApplication /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopApplication();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isGingaRunning /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isGingaRunning();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enableGinga /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableGinga();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disableGinga /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableGinga();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isGingaEnabled /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isGingaEnabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_processKey;
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

    boolean disableGinga() throws RemoteException;

    boolean enableGinga() throws RemoteException;

    List<GingaInfo> getApps(String str) throws RemoteException;

    boolean isGingaEnabled() throws RemoteException;

    boolean isGingaRunning() throws RemoteException;

    boolean processKey(int i, boolean z) throws RemoteException;

    boolean startApplication(long j, long j2) throws RemoteException;

    boolean stopApplication() throws RemoteException;
}
