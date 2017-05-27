package com.mstar.android.ethernet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IEthernetManager extends IInterface {

    public static abstract class Stub extends Binder implements IEthernetManager {
        private static final String DESCRIPTOR = "com.mstar.android.ethernet.IEthernetManager";
        static final int TRANSACTION_getDeviceNameList = 1;
        static final int TRANSACTION_getSavedConfig = 6;
        static final int TRANSACTION_getState = 3;
        static final int TRANSACTION_getTotalInterface = 7;
        static final int TRANSACTION_isCableConnected = 10;
        static final int TRANSACTION_isConfigured = 5;
        static final int TRANSACTION_isNetworkConnected = 9;
        static final int TRANSACTION_setMode = 8;
        static final int TRANSACTION_setState = 2;
        static final int TRANSACTION_updateDevInfo = 4;

        private static class Proxy implements IEthernetManager {
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

            public String[] getDeviceNameList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDeviceNameList, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setState(int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(state);
                    this.mRemote.transact(Stub.TRANSACTION_setState, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void updateDevInfo(EthernetDevInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (info != null) {
                        _data.writeInt(Stub.TRANSACTION_getDeviceNameList);
                        info.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_updateDevInfo, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isConfigured() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isConfigured, _data, _reply, 0);
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

            public EthernetDevInfo getSavedConfig() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    EthernetDevInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSavedConfig, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (EthernetDevInfo) EthernetDevInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getTotalInterface() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTotalInterface, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setMode(String mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(mode);
                    this.mRemote.transact(Stub.TRANSACTION_setMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isNetworkConnected() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isNetworkConnected, _data, _reply, 0);
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

            public boolean isCableConnected() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isCableConnected, _data, _reply, 0);
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

        public static IEthernetManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IEthernetManager)) {
                return new Proxy(obj);
            }
            return (IEthernetManager) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            int _result;
            boolean _result2;
            switch (code) {
                case TRANSACTION_getDeviceNameList /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    String[] _result3 = getDeviceNameList();
                    reply.writeNoException();
                    reply.writeStringArray(_result3);
                    return true;
                case TRANSACTION_setState /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    setState(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getState /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getState();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_updateDevInfo /*4*/:
                    EthernetDevInfo _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (EthernetDevInfo) EthernetDevInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    updateDevInfo(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isConfigured /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isConfigured();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getDeviceNameList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSavedConfig /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    EthernetDevInfo _result4 = getSavedConfig();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_getDeviceNameList);
                        _result4.writeToParcel(reply, TRANSACTION_getDeviceNameList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getTotalInterface /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getTotalInterface();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setMode /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    setMode(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isNetworkConnected /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isNetworkConnected();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getDeviceNameList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isCableConnected /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isCableConnected();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getDeviceNameList;
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

    String[] getDeviceNameList() throws RemoteException;

    EthernetDevInfo getSavedConfig() throws RemoteException;

    int getState() throws RemoteException;

    int getTotalInterface() throws RemoteException;

    boolean isCableConnected() throws RemoteException;

    boolean isConfigured() throws RemoteException;

    boolean isNetworkConnected() throws RemoteException;

    void setMode(String str) throws RemoteException;

    void setState(int i) throws RemoteException;

    void updateDevInfo(EthernetDevInfo ethernetDevInfo) throws RemoteException;
}
