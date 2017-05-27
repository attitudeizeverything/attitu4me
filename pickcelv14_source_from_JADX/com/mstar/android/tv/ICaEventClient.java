package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.dtv.vo.CaLockService;
import com.mstar.android.tvapi.dtv.vo.CaStartIPPVBuyDlgInfo;

public interface ICaEventClient extends IInterface {

    public static abstract class Stub extends Binder implements ICaEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ICaEventClient";
        static final int TRANSACTION_onActionRequest = 10;
        static final int TRANSACTION_onDetitleReceived = 12;
        static final int TRANSACTION_onEmailNotifyIcon = 3;
        static final int TRANSACTION_onEntitleChanged = 11;
        static final int TRANSACTION_onHideIPPVDlg = 2;
        static final int TRANSACTION_onHideOSDMessage = 5;
        static final int TRANSACTION_onLockService = 13;
        static final int TRANSACTION_onOtaState = 15;
        static final int TRANSACTION_onRequestFeeding = 6;
        static final int TRANSACTION_onShowBuyMessage = 7;
        static final int TRANSACTION_onShowFingerMessage = 8;
        static final int TRANSACTION_onShowOSDMessage = 4;
        static final int TRANSACTION_onShowProgressStrip = 9;
        static final int TRANSACTION_onStartIppvBuyDlg = 1;
        static final int TRANSACTION_onUNLockService = 14;

        private static class Proxy implements ICaEventClient {
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

            public boolean onStartIppvBuyDlg(int what, int arg1, int arg2, CaStartIPPVBuyDlgInfo arg3) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    if (arg3 != null) {
                        _data.writeInt(Stub.TRANSACTION_onStartIppvBuyDlg);
                        arg3.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onStartIppvBuyDlg, _data, _reply, 0);
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

            public boolean onHideIPPVDlg(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onHideIPPVDlg, _data, _reply, 0);
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

            public boolean onEmailNotifyIcon(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onEmailNotifyIcon, _data, _reply, 0);
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

            public boolean onShowOSDMessage(int what, int arg1, int arg2, String arg3) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    _data.writeString(arg3);
                    this.mRemote.transact(Stub.TRANSACTION_onShowOSDMessage, _data, _reply, 0);
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

            public boolean onHideOSDMessage(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onHideOSDMessage, _data, _reply, 0);
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

            public boolean onRequestFeeding(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onRequestFeeding, _data, _reply, 0);
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

            public boolean onShowBuyMessage(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onShowBuyMessage, _data, _reply, 0);
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

            public boolean onShowFingerMessage(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onShowFingerMessage, _data, _reply, 0);
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

            public boolean onShowProgressStrip(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onShowProgressStrip, _data, _reply, 0);
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

            public boolean onActionRequest(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onActionRequest, _data, _reply, 0);
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

            public boolean onEntitleChanged(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onEntitleChanged, _data, _reply, 0);
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

            public boolean onDetitleReceived(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onDetitleReceived, _data, _reply, 0);
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

            public boolean onLockService(int what, int arg1, int arg2, CaLockService arg3) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    if (arg3 != null) {
                        _data.writeInt(Stub.TRANSACTION_onStartIppvBuyDlg);
                        arg3.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onLockService, _data, _reply, 0);
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

            public boolean onUNLockService(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onUNLockService, _data, _reply, 0);
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

            public boolean onOtaState(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onOtaState, _data, _reply, 0);
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

        public static ICaEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ICaEventClient)) {
                return new Proxy(obj);
            }
            return (ICaEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            int _arg0;
            int _arg1;
            int _arg2;
            boolean _result;
            switch (code) {
                case TRANSACTION_onStartIppvBuyDlg /*1*/:
                    CaStartIPPVBuyDlgInfo _arg3;
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    _arg1 = data.readInt();
                    _arg2 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg3 = (CaStartIPPVBuyDlgInfo) CaStartIPPVBuyDlgInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    _result = onStartIppvBuyDlg(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onHideIPPVDlg /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onHideIPPVDlg(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEmailNotifyIcon /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEmailNotifyIcon(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onShowOSDMessage /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onShowOSDMessage(data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onHideOSDMessage /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onHideOSDMessage(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onRequestFeeding /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onRequestFeeding(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onShowBuyMessage /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onShowBuyMessage(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onShowFingerMessage /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onShowFingerMessage(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onShowProgressStrip /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onShowProgressStrip(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onActionRequest /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onActionRequest(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEntitleChanged /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEntitleChanged(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onDetitleReceived /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDetitleReceived(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onLockService /*13*/:
                    CaLockService _arg32;
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    _arg1 = data.readInt();
                    _arg2 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg32 = (CaLockService) CaLockService.CREATOR.createFromParcel(data);
                    } else {
                        _arg32 = null;
                    }
                    _result = onLockService(_arg0, _arg1, _arg2, _arg32);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUNLockService /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUNLockService(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOtaState /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOtaState(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onStartIppvBuyDlg;
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

    boolean onActionRequest(int i, int i2, int i3) throws RemoteException;

    boolean onDetitleReceived(int i, int i2, int i3) throws RemoteException;

    boolean onEmailNotifyIcon(int i, int i2, int i3) throws RemoteException;

    boolean onEntitleChanged(int i, int i2, int i3) throws RemoteException;

    boolean onHideIPPVDlg(int i, int i2, int i3) throws RemoteException;

    boolean onHideOSDMessage(int i, int i2, int i3) throws RemoteException;

    boolean onLockService(int i, int i2, int i3, CaLockService caLockService) throws RemoteException;

    boolean onOtaState(int i, int i2, int i3) throws RemoteException;

    boolean onRequestFeeding(int i, int i2, int i3) throws RemoteException;

    boolean onShowBuyMessage(int i, int i2, int i3) throws RemoteException;

    boolean onShowFingerMessage(int i, int i2, int i3) throws RemoteException;

    boolean onShowOSDMessage(int i, int i2, int i3, String str) throws RemoteException;

    boolean onShowProgressStrip(int i, int i2, int i3) throws RemoteException;

    boolean onStartIppvBuyDlg(int i, int i2, int i3, CaStartIPPVBuyDlgInfo caStartIPPVBuyDlgInfo) throws RemoteException;

    boolean onUNLockService(int i, int i2, int i3) throws RemoteException;
}
