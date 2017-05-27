package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.VideoWindowType;

public interface ITvPipPop extends IInterface {

    public static abstract class Stub extends Binder implements ITvPipPop {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvPipPop";
        static final int TRANSACTION_checkPipSupport = 1;
        static final int TRANSACTION_checkPipSupportOnSubSrc = 2;
        static final int TRANSACTION_checkPopSupport = 10;
        static final int TRANSACTION_checkTravelingModeSupport = 14;
        static final int TRANSACTION_disable3dDualView = 21;
        static final int TRANSACTION_disablePip = 6;
        static final int TRANSACTION_disablePop = 13;
        static final int TRANSACTION_disableTravelingMode = 17;
        static final int TRANSACTION_enable3dDualView = 20;
        static final int TRANSACTION_enablePipMM = 5;
        static final int TRANSACTION_enablePipTV = 3;
        static final int TRANSACTION_enablePopMM = 12;
        static final int TRANSACTION_enablePopTV = 11;
        static final int TRANSACTION_enableTravelingModeMM = 16;
        static final int TRANSACTION_enableTravelingModeTV = 15;
        static final int TRANSACTION_getIsPipOn = 18;
        static final int TRANSACTION_getMainWindowSourceList = 8;
        static final int TRANSACTION_getPipMode = 23;
        static final int TRANSACTION_getSubWindowSourceList = 7;
        static final int TRANSACTION_isPipModeEnabled = 22;
        static final int TRANSACTION_setPipDisplayFocusWindow = 9;
        static final int TRANSACTION_setPipOnFlag = 19;
        static final int TRANSACTION_setPipSubwindow = 4;

        private static class Proxy implements ITvPipPop {
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

            public boolean checkPipSupport(int eMainInputSrc, int eSubInputSrc) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_checkPipSupport, _data, _reply, 0);
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

            public boolean checkPipSupportOnSubSrc(int eMainInputSrc) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_checkPipSupportOnSubSrc, _data, _reply, 0);
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

            public int enablePipTV(int eMainInputSrc, int eSubInputSrc, VideoWindowType dispWin) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    if (dispWin != null) {
                        _data.writeInt(Stub.TRANSACTION_checkPipSupport);
                        dispWin.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_enablePipTV, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPipSubwindow(VideoWindowType dispWin) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dispWin != null) {
                        _data.writeInt(Stub.TRANSACTION_checkPipSupport);
                        dispWin.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setPipSubwindow, _data, _reply, 0);
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

            public int enablePipMM(int eMainInputSrc, VideoWindowType dispWin) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    if (dispWin != null) {
                        _data.writeInt(Stub.TRANSACTION_checkPipSupport);
                        dispWin.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_enablePipMM, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean disablePip() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disablePip, _data, _reply, 0);
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

            public int[] getSubWindowSourceList(boolean ispip) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ispip) {
                        i = Stub.TRANSACTION_checkPipSupport;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getSubWindowSourceList, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int[] getMainWindowSourceList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMainWindowSourceList, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPipDisplayFocusWindow(int enScalerWindow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enScalerWindow);
                    this.mRemote.transact(Stub.TRANSACTION_setPipDisplayFocusWindow, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean checkPopSupport(int eMainInputSrc, int eSubInputSrc) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_checkPopSupport, _data, _reply, 0);
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

            public int enablePopTV(int eMainInputSrc, int eSubInputSrc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_enablePopTV, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int enablePopMM(int eMainInputSrc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_enablePopMM, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean disablePop() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disablePop, _data, _reply, 0);
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

            public boolean checkTravelingModeSupport(int eMainInputSrc, int eSubInputSrc) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_checkTravelingModeSupport, _data, _reply, 0);
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

            public int enableTravelingModeTV(int eMainInputSrc, int eSubInputSrc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_enableTravelingModeTV, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int enableTravelingModeMM(int eMainInputSrc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    this.mRemote.transact(Stub.TRANSACTION_enableTravelingModeMM, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean disableTravelingMode() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableTravelingMode, _data, _reply, 0);
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

            public boolean getIsPipOn() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getIsPipOn, _data, _reply, 0);
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

            public boolean setPipOnFlag(boolean pipOnFlag) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (pipOnFlag) {
                        i = Stub.TRANSACTION_checkPipSupport;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPipOnFlag, _data, _reply, 0);
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

            public boolean enable3dDualView(int eMainInputSrc, int eSubInputSrc, VideoWindowType mainWin, VideoWindowType subWin) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMainInputSrc);
                    _data.writeInt(eSubInputSrc);
                    if (mainWin != null) {
                        _data.writeInt(Stub.TRANSACTION_checkPipSupport);
                        mainWin.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (subWin != null) {
                        _data.writeInt(Stub.TRANSACTION_checkPipSupport);
                        subWin.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_enable3dDualView, _data, _reply, 0);
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

            public boolean disable3dDualView() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disable3dDualView, _data, _reply, 0);
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

            public boolean isPipModeEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isPipModeEnabled, _data, _reply, 0);
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

            public int getPipMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPipMode, _data, _reply, 0);
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

        public static ITvPipPop asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvPipPop)) {
                return new Proxy(obj);
            }
            return (ITvPipPop) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _arg0;
            int _arg1;
            VideoWindowType _arg2;
            int _result2;
            boolean _arg02;
            int[] _result3;
            switch (code) {
                case TRANSACTION_checkPipSupport /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = checkPipSupport(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_checkPipSupportOnSubSrc /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = checkPipSupportOnSubSrc(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enablePipTV /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    _arg1 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg2 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    _result2 = enablePipTV(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPipSubwindow /*4*/:
                    VideoWindowType _arg03;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    _result = setPipSubwindow(_arg03);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enablePipMM /*5*/:
                    VideoWindowType _arg12;
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg12 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg12 = null;
                    }
                    _result2 = enablePipMM(_arg0, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_disablePip /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disablePip();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSubWindowSourceList /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result3 = getSubWindowSourceList(_arg02);
                    reply.writeNoException();
                    reply.writeIntArray(_result3);
                    return true;
                case TRANSACTION_getMainWindowSourceList /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMainWindowSourceList();
                    reply.writeNoException();
                    reply.writeIntArray(_result3);
                    return true;
                case TRANSACTION_setPipDisplayFocusWindow /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    setPipDisplayFocusWindow(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_checkPopSupport /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = checkPopSupport(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enablePopTV /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = enablePopTV(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_enablePopMM /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = enablePopMM(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_disablePop /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disablePop();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_checkTravelingModeSupport /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = checkTravelingModeSupport(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enableTravelingModeTV /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = enableTravelingModeTV(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_enableTravelingModeMM /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = enableTravelingModeMM(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_disableTravelingMode /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableTravelingMode();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getIsPipOn /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getIsPipOn();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setPipOnFlag /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result = setPipOnFlag(_arg02);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enable3dDualView /*20*/:
                    VideoWindowType _arg3;
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    _arg1 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg2 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    if (data.readInt() != 0) {
                        _arg3 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    _result = enable3dDualView(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disable3dDualView /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disable3dDualView();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isPipModeEnabled /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isPipModeEnabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_checkPipSupport;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPipMode /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPipMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean checkPipSupport(int i, int i2) throws RemoteException;

    boolean checkPipSupportOnSubSrc(int i) throws RemoteException;

    boolean checkPopSupport(int i, int i2) throws RemoteException;

    boolean checkTravelingModeSupport(int i, int i2) throws RemoteException;

    boolean disable3dDualView() throws RemoteException;

    boolean disablePip() throws RemoteException;

    boolean disablePop() throws RemoteException;

    boolean disableTravelingMode() throws RemoteException;

    boolean enable3dDualView(int i, int i2, VideoWindowType videoWindowType, VideoWindowType videoWindowType2) throws RemoteException;

    int enablePipMM(int i, VideoWindowType videoWindowType) throws RemoteException;

    int enablePipTV(int i, int i2, VideoWindowType videoWindowType) throws RemoteException;

    int enablePopMM(int i) throws RemoteException;

    int enablePopTV(int i, int i2) throws RemoteException;

    int enableTravelingModeMM(int i) throws RemoteException;

    int enableTravelingModeTV(int i, int i2) throws RemoteException;

    boolean getIsPipOn() throws RemoteException;

    int[] getMainWindowSourceList() throws RemoteException;

    int getPipMode() throws RemoteException;

    int[] getSubWindowSourceList(boolean z) throws RemoteException;

    boolean isPipModeEnabled() throws RemoteException;

    void setPipDisplayFocusWindow(int i) throws RemoteException;

    boolean setPipOnFlag(boolean z) throws RemoteException;

    boolean setPipSubwindow(VideoWindowType videoWindowType) throws RemoteException;
}
