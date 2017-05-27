package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvCommon extends IInterface {

    public static abstract class Stub extends Binder implements ITvCommon {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvCommon";
        static final int TRANSACTION_GetInputSourceStatus = 4;
        static final int TRANSACTION_addClient = 11;
        static final int TRANSACTION_closeSurfaceView = 21;
        static final int TRANSACTION_enterSleepMode = 9;
        static final int TRANSACTION_getAtvMtsMode = 15;
        static final int TRANSACTION_getAtvSoundMode = 16;
        static final int TRANSACTION_getClient = 10;
        static final int TRANSACTION_getCurrentInputSource = 2;
        static final int TRANSACTION_getCurrentSubInputSource = 3;
        static final int TRANSACTION_getPowerOnAVMute = 8;
        static final int TRANSACTION_getPowerOnSource = 6;
        static final int TRANSACTION_getSourceList = 13;
        static final int TRANSACTION_openSurfaceView = 19;
        static final int TRANSACTION_rebootSystem = 22;
        static final int TRANSACTION_recoverySystem = 17;
        static final int TRANSACTION_removeClient = 12;
        static final int TRANSACTION_setAtvMtsMode = 14;
        static final int TRANSACTION_setInputSource = 1;
        static final int TRANSACTION_setPowerOnAVMute = 7;
        static final int TRANSACTION_setPowerOnSource = 5;
        static final int TRANSACTION_setSurfaceView = 20;
        static final int TRANSACTION_setToNextAtvMtsMode = 23;
        static final int TRANSACTION_setTvosCommonCommand = 24;
        static final int TRANSACTION_setVideoMute = 25;
        static final int TRANSACTION_standbySystem = 18;

        private static class Proxy implements ITvCommon {
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

            public void setInputSource(int source) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(source);
                    this.mRemote.transact(Stub.TRANSACTION_setInputSource, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurrentInputSource() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentInputSource, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurrentSubInputSource() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentSubInputSource, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean[] GetInputSourceStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_GetInputSourceStatus, _data, _reply, 0);
                    _reply.readException();
                    boolean[] _result = _reply.createBooleanArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPowerOnSource(int eSource) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eSource);
                    this.mRemote.transact(Stub.TRANSACTION_setPowerOnSource, _data, _reply, 0);
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

            public int getPowerOnSource() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPowerOnSource, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPowerOnAVMute(boolean enable) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (enable) {
                        i = Stub.TRANSACTION_setInputSource;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPowerOnAVMute, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean getPowerOnAVMute() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPowerOnAVMute, _data, _reply, 0);
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

            public void enterSleepMode(boolean bMode, boolean bNoSignalPwDn) throws RemoteException {
                int i = Stub.TRANSACTION_setInputSource;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bMode ? Stub.TRANSACTION_setInputSource : 0);
                    if (!bNoSignalPwDn) {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_enterSleepMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public IBinder getClient(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    this.mRemote.transact(Stub.TRANSACTION_getClient, _data, _reply, 0);
                    _reply.readException();
                    IBinder _result = _reply.readStrongBinder();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void addClient(String name, IBinder client) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeStrongBinder(client);
                    this.mRemote.transact(Stub.TRANSACTION_addClient, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void removeClient(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    this.mRemote.transact(Stub.TRANSACTION_removeClient, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int[] getSourceList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSourceList, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int setAtvMtsMode(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvMtsMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvMtsMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvMtsMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvSoundMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvSoundMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void recoverySystem(String url) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(url);
                    this.mRemote.transact(Stub.TRANSACTION_recoverySystem, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void standbySystem(String Pwd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(Pwd);
                    this.mRemote.transact(Stub.TRANSACTION_standbySystem, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void openSurfaceView(int x, int y, int width, int height) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(x);
                    _data.writeInt(y);
                    _data.writeInt(width);
                    _data.writeInt(height);
                    this.mRemote.transact(Stub.TRANSACTION_openSurfaceView, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setSurfaceView(int x, int y, int width, int height) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(x);
                    _data.writeInt(y);
                    _data.writeInt(width);
                    _data.writeInt(height);
                    this.mRemote.transact(Stub.TRANSACTION_setSurfaceView, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void closeSurfaceView() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_closeSurfaceView, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void rebootSystem(String Pwd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(Pwd);
                    this.mRemote.transact(Stub.TRANSACTION_rebootSystem, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int setToNextAtvMtsMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_setToNextAtvMtsMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int[] setTvosCommonCommand(String cmd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(cmd);
                    this.mRemote.transact(Stub.TRANSACTION_setTvosCommonCommand, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVideoMute(boolean bScreenMute, int enColor, int screenUnMuteTime, int eSrcType) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bScreenMute) {
                        i = Stub.TRANSACTION_setInputSource;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    _data.writeInt(enColor);
                    _data.writeInt(screenUnMuteTime);
                    _data.writeInt(eSrcType);
                    this.mRemote.transact(Stub.TRANSACTION_setVideoMute, _data, _reply, 0);
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvCommon asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvCommon)) {
                return new Proxy(obj);
            }
            return (ITvCommon) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            int _result;
            boolean _result2;
            boolean _arg0;
            int[] _result3;
            switch (code) {
                case TRANSACTION_setInputSource /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    setInputSource(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCurrentInputSource /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurrentInputSource();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getCurrentSubInputSource /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurrentSubInputSource();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_GetInputSourceStatus /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    boolean[] _result4 = GetInputSourceStatus();
                    reply.writeNoException();
                    reply.writeBooleanArray(_result4);
                    return true;
                case TRANSACTION_setPowerOnSource /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setPowerOnSource(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_setInputSource;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPowerOnSource /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getPowerOnSource();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setPowerOnAVMute /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setPowerOnAVMute(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getPowerOnAVMute /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPowerOnAVMute();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_setInputSource;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enterSleepMode /*9*/:
                    boolean _arg1;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    enterSleepMode(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getClient /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    IBinder _result5 = getClient(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(_result5);
                    return true;
                case TRANSACTION_addClient /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    addClient(data.readString(), data.readStrongBinder());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_removeClient /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    removeClient(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getSourceList /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getSourceList();
                    reply.writeNoException();
                    reply.writeIntArray(_result3);
                    return true;
                case TRANSACTION_setAtvMtsMode /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAtvMtsMode(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getAtvMtsMode /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getAtvMtsMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getAtvSoundMode /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getAtvSoundMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_recoverySystem /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    recoverySystem(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_standbySystem /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    standbySystem(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_openSurfaceView /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    openSurfaceView(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSurfaceView /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    setSurfaceView(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_closeSurfaceView /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    closeSurfaceView();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_rebootSystem /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    rebootSystem(data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setToNextAtvMtsMode /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setToNextAtvMtsMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setTvosCommonCommand /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = setTvosCommonCommand(data.readString());
                    reply.writeNoException();
                    reply.writeIntArray(_result3);
                    return true;
                case TRANSACTION_setVideoMute /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result2 = setVideoMute(_arg0, data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_setInputSource;
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

    boolean[] GetInputSourceStatus() throws RemoteException;

    void addClient(String str, IBinder iBinder) throws RemoteException;

    void closeSurfaceView() throws RemoteException;

    void enterSleepMode(boolean z, boolean z2) throws RemoteException;

    int getAtvMtsMode() throws RemoteException;

    int getAtvSoundMode() throws RemoteException;

    IBinder getClient(String str) throws RemoteException;

    int getCurrentInputSource() throws RemoteException;

    int getCurrentSubInputSource() throws RemoteException;

    boolean getPowerOnAVMute() throws RemoteException;

    int getPowerOnSource() throws RemoteException;

    int[] getSourceList() throws RemoteException;

    void openSurfaceView(int i, int i2, int i3, int i4) throws RemoteException;

    void rebootSystem(String str) throws RemoteException;

    void recoverySystem(String str) throws RemoteException;

    void removeClient(String str) throws RemoteException;

    int setAtvMtsMode(int i) throws RemoteException;

    void setInputSource(int i) throws RemoteException;

    void setPowerOnAVMute(boolean z) throws RemoteException;

    boolean setPowerOnSource(int i) throws RemoteException;

    void setSurfaceView(int i, int i2, int i3, int i4) throws RemoteException;

    int setToNextAtvMtsMode() throws RemoteException;

    int[] setTvosCommonCommand(String str) throws RemoteException;

    boolean setVideoMute(boolean z, int i, int i2, int i3) throws RemoteException;

    void standbySystem(String str) throws RemoteException;
}
