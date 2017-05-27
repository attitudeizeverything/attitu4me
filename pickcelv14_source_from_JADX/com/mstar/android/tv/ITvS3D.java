package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvS3D extends IInterface {

    public static abstract class Stub extends Binder implements ITvS3D {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvS3D";
        static final int TRANSACTION_get3DDepthMode = 8;
        static final int TRANSACTION_get3DOffsetMode = 10;
        static final int TRANSACTION_get3DOutputAspectMode = 14;
        static final int TRANSACTION_getAutoStartMode = 12;
        static final int TRANSACTION_getDisplay3DTo2DMode = 6;
        static final int TRANSACTION_getDisplayFormat = 4;
        static final int TRANSACTION_getLrViewSwitch = 16;
        static final int TRANSACTION_getSelfAdaptiveDetect = 2;
        static final int TRANSACTION_set3DDepthMode = 7;
        static final int TRANSACTION_set3DOffsetMode = 9;
        static final int TRANSACTION_set3DOutputAspectMode = 13;
        static final int TRANSACTION_set3DTo2D = 5;
        static final int TRANSACTION_setAutoStartMode = 11;
        static final int TRANSACTION_setDisplayFormat = 3;
        static final int TRANSACTION_setDisplayFormatForUI = 17;
        static final int TRANSACTION_setLrViewSwitch = 15;
        static final int TRANSACTION_setSelfAdaptiveDetect = 1;

        private static class Proxy implements ITvS3D {
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

            public boolean setSelfAdaptiveDetect(int selfAdaptiveDetect) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(selfAdaptiveDetect);
                    this.mRemote.transact(Stub.TRANSACTION_setSelfAdaptiveDetect, _data, _reply, 0);
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

            public int getSelfAdaptiveDetect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSelfAdaptiveDetect, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setDisplayFormat(int displayFormat) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayFormat);
                    this.mRemote.transact(Stub.TRANSACTION_setDisplayFormat, _data, _reply, 0);
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

            public int getDisplayFormat() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDisplayFormat, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean set3DTo2D(int displayMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayMode);
                    this.mRemote.transact(Stub.TRANSACTION_set3DTo2D, _data, _reply, 0);
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

            public int getDisplay3DTo2DMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDisplay3DTo2DMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean set3DDepthMode(int mode3DDepth) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode3DDepth);
                    this.mRemote.transact(Stub.TRANSACTION_set3DDepthMode, _data, _reply, 0);
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

            public int get3DDepthMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_get3DDepthMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean set3DOffsetMode(int mode3DOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode3DOffset);
                    this.mRemote.transact(Stub.TRANSACTION_set3DOffsetMode, _data, _reply, 0);
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

            public int get3DOffsetMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_get3DOffsetMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAutoStartMode(int autoStartMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(autoStartMode);
                    this.mRemote.transact(Stub.TRANSACTION_setAutoStartMode, _data, _reply, 0);
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

            public int getAutoStartMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAutoStartMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean set3DOutputAspectMode(int outputAspectMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(outputAspectMode);
                    this.mRemote.transact(Stub.TRANSACTION_set3DOutputAspectMode, _data, _reply, 0);
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

            public int get3DOutputAspectMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_get3DOutputAspectMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setLrViewSwitch(int LrViewSwitchMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(LrViewSwitchMode);
                    this.mRemote.transact(Stub.TRANSACTION_setLrViewSwitch, _data, _reply, 0);
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

            public int getLrViewSwitch() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLrViewSwitch, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setDisplayFormatForUI(int threedDisplayFormatIdx) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(threedDisplayFormatIdx);
                    this.mRemote.transact(Stub.TRANSACTION_setDisplayFormatForUI, _data, _reply, 0);
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

        public static ITvS3D asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvS3D)) {
                return new Proxy(obj);
            }
            return (ITvS3D) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            switch (code) {
                case TRANSACTION_setSelfAdaptiveDetect /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setSelfAdaptiveDetect(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSelfAdaptiveDetect /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSelfAdaptiveDetect();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setDisplayFormat /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setDisplayFormat(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getDisplayFormat /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDisplayFormat();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_set3DTo2D /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = set3DTo2D(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getDisplay3DTo2DMode /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDisplay3DTo2DMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_set3DDepthMode /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = set3DDepthMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_get3DDepthMode /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = get3DDepthMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_set3DOffsetMode /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = set3DOffsetMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_get3DOffsetMode /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = get3DOffsetMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAutoStartMode /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAutoStartMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAutoStartMode /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAutoStartMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_set3DOutputAspectMode /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = set3DOutputAspectMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_get3DOutputAspectMode /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = get3DOutputAspectMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setLrViewSwitch /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setLrViewSwitch(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSelfAdaptiveDetect;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getLrViewSwitch /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getLrViewSwitch();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setDisplayFormatForUI /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    setDisplayFormatForUI(data.readInt());
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

    int get3DDepthMode() throws RemoteException;

    int get3DOffsetMode() throws RemoteException;

    int get3DOutputAspectMode() throws RemoteException;

    int getAutoStartMode() throws RemoteException;

    int getDisplay3DTo2DMode() throws RemoteException;

    int getDisplayFormat() throws RemoteException;

    int getLrViewSwitch() throws RemoteException;

    int getSelfAdaptiveDetect() throws RemoteException;

    boolean set3DDepthMode(int i) throws RemoteException;

    boolean set3DOffsetMode(int i) throws RemoteException;

    boolean set3DOutputAspectMode(int i) throws RemoteException;

    boolean set3DTo2D(int i) throws RemoteException;

    boolean setAutoStartMode(int i) throws RemoteException;

    boolean setDisplayFormat(int i) throws RemoteException;

    void setDisplayFormatForUI(int i) throws RemoteException;

    boolean setLrViewSwitch(int i) throws RemoteException;

    boolean setSelfAdaptiveDetect(int i) throws RemoteException;
}
