package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.dtv.vo.DtvEventScan;

public interface IDtvPlayerEventClient extends IInterface {

    public static abstract class Stub extends Binder implements IDtvPlayerEventClient {
        private static final String DESCRIPTOR = "com.mstar.android.tv.IDtvPlayerEventClient";
        static final int TRANSACTION_onAudioModeChange = 19;
        static final int TRANSACTION_onChangeTtxStatus = 17;
        static final int TRANSACTION_onCiLoadCredentialFail = 4;
        static final int TRANSACTION_onDtvAutoTuningScanInfo = 2;
        static final int TRANSACTION_onDtvAutoUpdateScan = 11;
        static final int TRANSACTION_onDtvChannelNameReady = 1;
        static final int TRANSACTION_onDtvPriComponentMissing = 18;
        static final int TRANSACTION_onDtvProgramInfoReady = 3;
        static final int TRANSACTION_onEpgTimerSimulcast = 5;
        static final int TRANSACTION_onGingaStatusMode = 22;
        static final int TRANSACTION_onHbbtvStatusMode = 6;
        static final int TRANSACTION_onMheg5EventHandler = 20;
        static final int TRANSACTION_onMheg5ReturnKey = 8;
        static final int TRANSACTION_onMheg5StatusMode = 7;
        static final int TRANSACTION_onOadDownload = 10;
        static final int TRANSACTION_onOadHandler = 9;
        static final int TRANSACTION_onOadTimeout = 21;
        static final int TRANSACTION_onPopupScanDialogFrequencyChange = 15;
        static final int TRANSACTION_onPopupScanDialogLossSignal = 13;
        static final int TRANSACTION_onPopupScanDialogNewMultiplex = 14;
        static final int TRANSACTION_onRctPresence = 16;
        static final int TRANSACTION_onSignalLock = 23;
        static final int TRANSACTION_onSignalUnLock = 24;
        static final int TRANSACTION_onTsChange = 12;
        static final int TRANSACTION_onUiOPExitServiceList = 27;
        static final int TRANSACTION_onUiOPRefreshQuery = 25;
        static final int TRANSACTION_onUiOPServiceList = 26;

        private static class Proxy implements IDtvPlayerEventClient {
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

            public boolean onDtvChannelNameReady(int what) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onDtvChannelNameReady, _data, _reply, 0);
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

            public boolean onDtvAutoTuningScanInfo(int what, DtvEventScan extra) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (extra != null) {
                        _data.writeInt(Stub.TRANSACTION_onDtvChannelNameReady);
                        extra.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onDtvAutoTuningScanInfo, _data, _reply, 0);
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

            public boolean onDtvProgramInfoReady(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onDtvProgramInfoReady, _data, _reply, 0);
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

            public boolean onCiLoadCredentialFail(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onCiLoadCredentialFail, _data, _reply, 0);
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

            public boolean onEpgTimerSimulcast(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onEpgTimerSimulcast, _data, _reply, 0);
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

            public boolean onHbbtvStatusMode(int what, boolean arg1) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (arg1) {
                        i = Stub.TRANSACTION_onDtvChannelNameReady;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_onHbbtvStatusMode, _data, _reply, 0);
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

            public boolean onMheg5StatusMode(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onMheg5StatusMode, _data, _reply, 0);
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

            public boolean onMheg5ReturnKey(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onMheg5ReturnKey, _data, _reply, 0);
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

            public boolean onOadHandler(int what, int arg1, int arg2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    _data.writeInt(arg2);
                    this.mRemote.transact(Stub.TRANSACTION_onOadHandler, _data, _reply, 0);
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

            public boolean onOadDownload(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onOadDownload, _data, _reply, 0);
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

            public boolean onDtvAutoUpdateScan(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onDtvAutoUpdateScan, _data, _reply, 0);
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

            public boolean onTsChange(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onTsChange, _data, _reply, 0);
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

            public boolean onPopupScanDialogLossSignal(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPopupScanDialogLossSignal, _data, _reply, 0);
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

            public boolean onPopupScanDialogNewMultiplex(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPopupScanDialogNewMultiplex, _data, _reply, 0);
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

            public boolean onPopupScanDialogFrequencyChange(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onPopupScanDialogFrequencyChange, _data, _reply, 0);
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

            public boolean onRctPresence(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onRctPresence, _data, _reply, 0);
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

            public boolean onChangeTtxStatus(int what, boolean arg1) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (arg1) {
                        i = Stub.TRANSACTION_onDtvChannelNameReady;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_onChangeTtxStatus, _data, _reply, 0);
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

            public boolean onDtvPriComponentMissing(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onDtvPriComponentMissing, _data, _reply, 0);
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

            public boolean onAudioModeChange(int what, boolean arg1) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (arg1) {
                        i = Stub.TRANSACTION_onDtvChannelNameReady;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_onAudioModeChange, _data, _reply, 0);
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

            public boolean onMheg5EventHandler(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onMheg5EventHandler, _data, _reply, 0);
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

            public boolean onOadTimeout(int what, int arg1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(arg1);
                    this.mRemote.transact(Stub.TRANSACTION_onOadTimeout, _data, _reply, 0);
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

            public boolean onGingaStatusMode(int what, boolean arg1) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    if (arg1) {
                        i = Stub.TRANSACTION_onDtvChannelNameReady;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_onGingaStatusMode, _data, _reply, 0);
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

            public boolean onUiOPRefreshQuery(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiOPRefreshQuery, _data, _reply, 0);
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

            public boolean onUiOPServiceList(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiOPServiceList, _data, _reply, 0);
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

            public boolean onUiOPExitServiceList(int what) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(what);
                    this.mRemote.transact(Stub.TRANSACTION_onUiOPExitServiceList, _data, _reply, 0);
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

        public static IDtvPlayerEventClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IDtvPlayerEventClient)) {
                return new Proxy(obj);
            }
            return (IDtvPlayerEventClient) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _arg0;
            boolean _arg1;
            switch (code) {
                case TRANSACTION_onDtvChannelNameReady /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDtvChannelNameReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onDtvAutoTuningScanInfo /*2*/:
                    DtvEventScan _arg12;
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg12 = (DtvEventScan) DtvEventScan.CREATOR.createFromParcel(data);
                    } else {
                        _arg12 = null;
                    }
                    _result = onDtvAutoTuningScanInfo(_arg0, _arg12);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onDtvProgramInfoReady /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDtvProgramInfoReady(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onCiLoadCredentialFail /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onCiLoadCredentialFail(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onEpgTimerSimulcast /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onEpgTimerSimulcast(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onHbbtvStatusMode /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = onHbbtvStatusMode(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onMheg5StatusMode /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onMheg5StatusMode(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onMheg5ReturnKey /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onMheg5ReturnKey(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOadHandler /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOadHandler(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOadDownload /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOadDownload(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onDtvAutoUpdateScan /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDtvAutoUpdateScan(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onTsChange /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onTsChange(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPopupScanDialogLossSignal /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPopupScanDialogLossSignal(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPopupScanDialogNewMultiplex /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPopupScanDialogNewMultiplex(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onPopupScanDialogFrequencyChange /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onPopupScanDialogFrequencyChange(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onRctPresence /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onRctPresence(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onChangeTtxStatus /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = onChangeTtxStatus(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onDtvPriComponentMissing /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onDtvPriComponentMissing(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onAudioModeChange /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = onAudioModeChange(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onMheg5EventHandler /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onMheg5EventHandler(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onOadTimeout /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onOadTimeout(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onGingaStatusMode /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = onGingaStatusMode(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalLock /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onSignalUnLock /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onSignalUnLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiOPRefreshQuery /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiOPRefreshQuery(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiOPServiceList /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiOPServiceList(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_onUiOPExitServiceList /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = onUiOPExitServiceList(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_onDtvChannelNameReady;
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

    boolean onAudioModeChange(int i, boolean z) throws RemoteException;

    boolean onChangeTtxStatus(int i, boolean z) throws RemoteException;

    boolean onCiLoadCredentialFail(int i) throws RemoteException;

    boolean onDtvAutoTuningScanInfo(int i, DtvEventScan dtvEventScan) throws RemoteException;

    boolean onDtvAutoUpdateScan(int i) throws RemoteException;

    boolean onDtvChannelNameReady(int i) throws RemoteException;

    boolean onDtvPriComponentMissing(int i) throws RemoteException;

    boolean onDtvProgramInfoReady(int i) throws RemoteException;

    boolean onEpgTimerSimulcast(int i, int i2) throws RemoteException;

    boolean onGingaStatusMode(int i, boolean z) throws RemoteException;

    boolean onHbbtvStatusMode(int i, boolean z) throws RemoteException;

    boolean onMheg5EventHandler(int i, int i2) throws RemoteException;

    boolean onMheg5ReturnKey(int i, int i2) throws RemoteException;

    boolean onMheg5StatusMode(int i, int i2) throws RemoteException;

    boolean onOadDownload(int i, int i2) throws RemoteException;

    boolean onOadHandler(int i, int i2, int i3) throws RemoteException;

    boolean onOadTimeout(int i, int i2) throws RemoteException;

    boolean onPopupScanDialogFrequencyChange(int i) throws RemoteException;

    boolean onPopupScanDialogLossSignal(int i) throws RemoteException;

    boolean onPopupScanDialogNewMultiplex(int i) throws RemoteException;

    boolean onRctPresence(int i) throws RemoteException;

    boolean onSignalLock(int i) throws RemoteException;

    boolean onSignalUnLock(int i) throws RemoteException;

    boolean onTsChange(int i) throws RemoteException;

    boolean onUiOPExitServiceList(int i) throws RemoteException;

    boolean onUiOPRefreshQuery(int i) throws RemoteException;

    boolean onUiOPServiceList(int i) throws RemoteException;
}
