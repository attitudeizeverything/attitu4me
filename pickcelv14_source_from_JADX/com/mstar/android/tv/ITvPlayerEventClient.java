package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.HbbtvEventInfo;

public interface ITvPlayerEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ITvPlayerEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvPlayerEventClient";
        static final int TRANSACTION_onHbbtvUiEvent = 2;
        static final int TRANSACTION_onPopupDialog = 3;
        static final int TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramNotReady = 18;
        static final int TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramReady = 17;
        static final int TRANSACTION_onPvrNotifyCiPlusProtection = 15;
        static final int TRANSACTION_onPvrNotifyCiPlusRetentionLimitUpdate = 19;
        static final int TRANSACTION_onPvrNotifyOverRun = 13;
        static final int TRANSACTION_onPvrNotifyParentalControl = 16;
        static final int TRANSACTION_onPvrNotifyPlaybackBegin = 10;
        static final int TRANSACTION_onPvrNotifyPlaybackSpeedChange = 5;
        static final int TRANSACTION_onPvrNotifyPlaybackStop = 9;
        static final int TRANSACTION_onPvrNotifyPlaybackTime = 4;
        static final int TRANSACTION_onPvrNotifyRecordSize = 7;
        static final int TRANSACTION_onPvrNotifyRecordStop = 8;
        static final int TRANSACTION_onPvrNotifyRecordTime = 6;
        static final int TRANSACTION_onPvrNotifyTimeShiftOverwritesAfter = 12;
        static final int TRANSACTION_onPvrNotifyTimeShiftOverwritesBefore = 11;
        static final int TRANSACTION_onPvrNotifyUsbRemoved = 14;
        static final int TRANSACTION_onScreenSaverMode = 1;
        static final int TRANSACTION_onSignalLock = 21;
        static final int TRANSACTION_onSignalUnLock = 22;
        static final int TRANSACTION_onTvProgramInfoReady = 20;

        private static class Proxy implements ITvPlayerEventClient {
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

            public boolean onScreenSaverMode(int what, int arg1) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onScreenSaverMode, _data, _reply, 0);
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

            public boolean onHbbtvUiEvent(int what, HbbtvEventInfo eventInfo) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (eventInfo != null) {
                        _data.writeInt(Stub.TRANSACTION_onScreenSaverMode);
                        eventInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onHbbtvUiEvent, _data, _reply, 0);
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

            public boolean onPopupDialog(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onPopupDialog, _data, _reply, 0);
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

            public boolean onPvrNotifyPlaybackTime(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackTime, _data, _reply, 0);
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

            public boolean onPvrNotifyPlaybackSpeedChange(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackSpeedChange, _data, _reply, 0);
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

            public boolean onPvrNotifyRecordTime(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyRecordTime, _data, _reply, 0);
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

            public boolean onPvrNotifyRecordSize(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyRecordSize, _data, _reply, 0);
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

            public boolean onPvrNotifyRecordStop(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
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

            public boolean onPvrNotifyPlaybackStop(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackStop, _data, _reply, 0);
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

            public boolean onPvrNotifyPlaybackBegin(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyPlaybackBegin, _data, _reply, 0);
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

            public boolean onPvrNotifyTimeShiftOverwritesBefore(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyTimeShiftOverwritesBefore, _data, _reply, 0);
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

            public boolean onPvrNotifyTimeShiftOverwritesAfter(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyTimeShiftOverwritesAfter, _data, _reply, 0);
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

            public boolean onPvrNotifyOverRun(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyOverRun, _data, _reply, 0);
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

            public boolean onPvrNotifyUsbRemoved(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyUsbRemoved, _data, _reply, 0);
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

            public boolean onPvrNotifyCiPlusProtection(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyCiPlusProtection, _data, _reply, 0);
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

            public boolean onPvrNotifyParentalControl(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyParentalControl, _data, _reply, 0);
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

            public boolean onPvrNotifyAlwaysTimeShiftProgramReady(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramReady, _data, _reply, 0);
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

            public boolean onPvrNotifyAlwaysTimeShiftProgramNotReady(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramNotReady, _data, _reply, 0);
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

            public boolean onPvrNotifyCiPlusRetentionLimitUpdate(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onPvrNotifyCiPlusRetentionLimitUpdate, _data, _reply, 0);
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

            public boolean onTvProgramInfoReady(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onTvProgramInfoReady, _data, _reply, 0);
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvPlayerEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvPlayerEventClient)) {
                return new Proxy(obj);
            }
            return (ITvPlayerEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            switch (code) {
                case TRANSACTION_onScreenSaverMode /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onScreenSaverMode(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onHbbtvUiEvent /*2*/:
                    HbbtvEventInfo _arg1;
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = (HbbtvEventInfo) HbbtvEventInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    _result = onHbbtvUiEvent(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPopupDialog /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPopupDialog(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackTime /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackTime(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackSpeedChange /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackSpeedChange(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyRecordTime /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyRecordTime(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyRecordSize /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyRecordSize(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyRecordStop /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyRecordStop(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackStop /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackStop(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyPlaybackBegin /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyPlaybackBegin(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyTimeShiftOverwritesBefore /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyTimeShiftOverwritesBefore(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyTimeShiftOverwritesAfter /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyTimeShiftOverwritesAfter(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyOverRun /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyOverRun(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyUsbRemoved /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyUsbRemoved(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyCiPlusProtection /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyCiPlusProtection(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyParentalControl /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyParentalControl(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramReady /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyAlwaysTimeShiftProgramReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyAlwaysTimeShiftProgramNotReady /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyAlwaysTimeShiftProgramNotReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPvrNotifyCiPlusRetentionLimitUpdate /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPvrNotifyCiPlusRetentionLimitUpdate(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onTvProgramInfoReady /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onTvProgramInfoReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalLock /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalUnLock /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalUnLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onScreenSaverMode;
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

    boolean onHbbtvUiEvent(int i, HbbtvEventInfo hbbtvEventInfo) throws RemoteException;

    boolean onPopupDialog(int i, int i2, int i3) throws RemoteException;

    boolean onPvrNotifyAlwaysTimeShiftProgramNotReady(int i) throws RemoteException;

    boolean onPvrNotifyAlwaysTimeShiftProgramReady(int i) throws RemoteException;

    boolean onPvrNotifyCiPlusProtection(int i) throws RemoteException;

    boolean onPvrNotifyCiPlusRetentionLimitUpdate(int i, int i2) throws RemoteException;

    boolean onPvrNotifyOverRun(int i) throws RemoteException;

    boolean onPvrNotifyParentalControl(int i, int i2) throws RemoteException;

    boolean onPvrNotifyPlaybackBegin(int i) throws RemoteException;

    boolean onPvrNotifyPlaybackSpeedChange(int i) throws RemoteException;

    boolean onPvrNotifyPlaybackStop(int i) throws RemoteException;

    boolean onPvrNotifyPlaybackTime(int i, int i2) throws RemoteException;

    boolean onPvrNotifyRecordSize(int i, int i2) throws RemoteException;

    boolean onPvrNotifyRecordStop(int i) throws RemoteException;

    boolean onPvrNotifyRecordTime(int i, int i2) throws RemoteException;

    boolean onPvrNotifyTimeShiftOverwritesAfter(int i, int i2) throws RemoteException;

    boolean onPvrNotifyTimeShiftOverwritesBefore(int i, int i2) throws RemoteException;

    boolean onPvrNotifyUsbRemoved(int i, int i2) throws RemoteException;

    boolean onScreenSaverMode(int i, int i2) throws RemoteException;

    boolean onSignalLock(int i) throws RemoteException;

    boolean onSignalUnLock(int i) throws RemoteException;

    boolean onTvProgramInfoReady(int i) throws RemoteException;
}
