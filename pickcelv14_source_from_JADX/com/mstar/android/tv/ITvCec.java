package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.CecSetting;

public interface ITvCec extends IInterface {

    public static abstract class Stub extends Binder implements ITvCec {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvCec";
        static final int TRANSACTION_deviceListGetItemIndex = 13;
        static final int TRANSACTION_deviceListGetListStr = 12;
        static final int TRANSACTION_disableDeviceMenu = 8;
        static final int TRANSACTION_enableDeviceMenu = 7;
        static final int TRANSACTION_getCECListCnt = 11;
        static final int TRANSACTION_getCecConfiguration = 2;
        static final int TRANSACTION_getDeviceName = 9;
        static final int TRANSACTION_registerOnCecEventListener = 10;
        static final int TRANSACTION_routingChangeInDeviceListSetting = 4;
        static final int TRANSACTION_sendCecKey = 5;
        static final int TRANSACTION_setCecConfiguration = 1;
        static final int TRANSACTION_setMenuLanguage = 6;
        static final int TRANSACTION_setStreamPath = 3;

        private static class Proxy implements ITvCec {
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

            public boolean setCecConfiguration(CecSetting cecSetting) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (cecSetting != null) {
                        _data.writeInt(Stub.TRANSACTION_setCecConfiguration);
                        cecSetting.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setCecConfiguration, _data, _reply, 0);
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

            public CecSetting getCecConfiguration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    CecSetting _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCecConfiguration, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (CecSetting) CecSetting.CREATOR.createFromParcel(_reply);
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

            public boolean setStreamPath(int enCecDeviceLa) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enCecDeviceLa);
                    this.mRemote.transact(Stub.TRANSACTION_setStreamPath, _data, _reply, 0);
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

            public void routingChangeInDeviceListSetting(int deviceLa) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(deviceLa);
                    this.mRemote.transact(Stub.TRANSACTION_routingChangeInDeviceListSetting, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean sendCecKey(int keyCode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(keyCode);
                    this.mRemote.transact(Stub.TRANSACTION_sendCecKey, _data, _reply, 0);
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

            public boolean setMenuLanguage(int menuLang) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(menuLang);
                    this.mRemote.transact(Stub.TRANSACTION_setMenuLanguage, _data, _reply, 0);
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

            public boolean enableDeviceMenu() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableDeviceMenu, _data, _reply, 0);
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

            public boolean disableDeviceMenu() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableDeviceMenu, _data, _reply, 0);
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

            public String getDeviceName(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getDeviceName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean registerOnCecEventListener(int listener) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerOnCecEventListener, _data, _reply, 0);
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

            public int getCECListCnt(int hdmi_port) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hdmi_port);
                    this.mRemote.transact(Stub.TRANSACTION_getCECListCnt, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String deviceListGetListStr(int hdmi_port, int cec_idx) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hdmi_port);
                    _data.writeInt(cec_idx);
                    this.mRemote.transact(Stub.TRANSACTION_deviceListGetListStr, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int deviceListGetItemIndex(int hdmi_port, int ActiveLA) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hdmi_port);
                    _data.writeInt(ActiveLA);
                    this.mRemote.transact(Stub.TRANSACTION_deviceListGetItemIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvCec asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvCec)) {
                return new Proxy(obj);
            }
            return (ITvCec) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            String _result2;
            int _result3;
            switch (code) {
                case TRANSACTION_setCecConfiguration /*1*/:
                    CecSetting _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (CecSetting) CecSetting.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    _result = setCecConfiguration(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCecConfiguration /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    CecSetting _result4 = getCecConfiguration();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_setCecConfiguration);
                        _result4.writeToParcel(reply, TRANSACTION_setCecConfiguration);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setStreamPath /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setStreamPath(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_routingChangeInDeviceListSetting /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    routingChangeInDeviceListSetting(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_sendCecKey /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = sendCecKey(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setMenuLanguage /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setMenuLanguage(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enableDeviceMenu /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableDeviceMenu();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disableDeviceMenu /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableDeviceMenu();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getDeviceName /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDeviceName(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case TRANSACTION_registerOnCecEventListener /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = registerOnCecEventListener(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCecConfiguration;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCECListCnt /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCECListCnt(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_deviceListGetListStr /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = deviceListGetListStr(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case TRANSACTION_deviceListGetItemIndex /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = deviceListGetItemIndex(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    int deviceListGetItemIndex(int i, int i2) throws RemoteException;

    String deviceListGetListStr(int i, int i2) throws RemoteException;

    boolean disableDeviceMenu() throws RemoteException;

    boolean enableDeviceMenu() throws RemoteException;

    int getCECListCnt(int i) throws RemoteException;

    CecSetting getCecConfiguration() throws RemoteException;

    String getDeviceName(int i) throws RemoteException;

    boolean registerOnCecEventListener(int i) throws RemoteException;

    void routingChangeInDeviceListSetting(int i) throws RemoteException;

    boolean sendCecKey(int i) throws RemoteException;

    boolean setCecConfiguration(CecSetting cecSetting) throws RemoteException;

    boolean setMenuLanguage(int i) throws RemoteException;

    boolean setStreamPath(int i) throws RemoteException;
}
