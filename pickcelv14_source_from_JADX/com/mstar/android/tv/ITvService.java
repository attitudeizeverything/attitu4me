package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvService extends IInterface {

    public static abstract class Stub extends Binder implements ITvService {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvService";
        static final int TRANSACTION_getTvAtscChannel = 2;
        static final int TRANSACTION_getTvAudio = 4;
        static final int TRANSACTION_getTvCc = 5;
        static final int TRANSACTION_getTvCec = 6;
        static final int TRANSACTION_getTvChannel = 8;
        static final int TRANSACTION_getTvCi = 7;
        static final int TRANSACTION_getTvCommon = 9;
        static final int TRANSACTION_getTvEpg = 10;
        static final int TRANSACTION_getTvFactory = 11;
        static final int TRANSACTION_getTvGinga = 17;
        static final int TRANSACTION_getTvIsdbChannel = 3;
        static final int TRANSACTION_getTvMhl = 15;
        static final int TRANSACTION_getTvParentalControl = 18;
        static final int TRANSACTION_getTvPicture = 12;
        static final int TRANSACTION_getTvPipPop = 14;
        static final int TRANSACTION_getTvPvr = 16;
        static final int TRANSACTION_getTvS3D = 1;
        static final int TRANSACTION_getTvTimer = 13;
        static final int TRANSACTION_resume = 20;
        static final int TRANSACTION_shutdown = 19;

        private static class Proxy implements ITvService {
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

            public ITvS3D getTvS3D() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvS3D, _data, _reply, 0);
                    _reply.readException();
                    ITvS3D _result = com.mstar.android.tv.ITvS3D.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvAtscChannel getTvAtscChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvAtscChannel, _data, _reply, 0);
                    _reply.readException();
                    ITvAtscChannel _result = com.mstar.android.tv.ITvAtscChannel.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvIsdbChannel getTvIsdbChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvIsdbChannel, _data, _reply, 0);
                    _reply.readException();
                    ITvIsdbChannel _result = com.mstar.android.tv.ITvIsdbChannel.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvAudio getTvAudio() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvAudio, _data, _reply, 0);
                    _reply.readException();
                    ITvAudio _result = com.mstar.android.tv.ITvAudio.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvCc getTvCc() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvCc, _data, _reply, 0);
                    _reply.readException();
                    ITvCc _result = com.mstar.android.tv.ITvCc.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvCec getTvCec() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvCec, _data, _reply, 0);
                    _reply.readException();
                    ITvCec _result = com.mstar.android.tv.ITvCec.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvCi getTvCi() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvCi, _data, _reply, 0);
                    _reply.readException();
                    ITvCi _result = com.mstar.android.tv.ITvCi.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvChannel getTvChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvChannel, _data, _reply, 0);
                    _reply.readException();
                    ITvChannel _result = com.mstar.android.tv.ITvChannel.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvCommon getTvCommon() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvCommon, _data, _reply, 0);
                    _reply.readException();
                    ITvCommon _result = com.mstar.android.tv.ITvCommon.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvEpg getTvEpg() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvEpg, _data, _reply, 0);
                    _reply.readException();
                    ITvEpg _result = com.mstar.android.tv.ITvEpg.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvFactory getTvFactory() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvFactory, _data, _reply, 0);
                    _reply.readException();
                    ITvFactory _result = com.mstar.android.tv.ITvFactory.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvPicture getTvPicture() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvPicture, _data, _reply, 0);
                    _reply.readException();
                    ITvPicture _result = com.mstar.android.tv.ITvPicture.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvTimer getTvTimer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvTimer, _data, _reply, 0);
                    _reply.readException();
                    ITvTimer _result = com.mstar.android.tv.ITvTimer.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvPipPop getTvPipPop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvPipPop, _data, _reply, 0);
                    _reply.readException();
                    ITvPipPop _result = com.mstar.android.tv.ITvPipPop.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvMhl getTvMhl() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvMhl, _data, _reply, 0);
                    _reply.readException();
                    ITvMhl _result = com.mstar.android.tv.ITvMhl.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvPvr getTvPvr() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvPvr, _data, _reply, 0);
                    _reply.readException();
                    ITvPvr _result = com.mstar.android.tv.ITvPvr.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvGinga getTvGinga() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvGinga, _data, _reply, 0);
                    _reply.readException();
                    ITvGinga _result = com.mstar.android.tv.ITvGinga.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ITvParentalControl getTvParentalControl() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTvParentalControl, _data, _reply, 0);
                    _reply.readException();
                    ITvParentalControl _result = com.mstar.android.tv.ITvParentalControl.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void shutdown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_shutdown, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resume, _data, _reply, 0);
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

        public static ITvService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvService)) {
                return new Proxy(obj);
            }
            return (ITvService) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case TRANSACTION_getTvS3D /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvS3D _result = getTvS3D();
                    reply.writeNoException();
                    if (_result != null) {
                        iBinder = _result.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvAtscChannel /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvAtscChannel _result2 = getTvAtscChannel();
                    reply.writeNoException();
                    if (_result2 != null) {
                        iBinder = _result2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvIsdbChannel /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvIsdbChannel _result3 = getTvIsdbChannel();
                    reply.writeNoException();
                    if (_result3 != null) {
                        iBinder = _result3.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvAudio /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvAudio _result4 = getTvAudio();
                    reply.writeNoException();
                    if (_result4 != null) {
                        iBinder = _result4.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvCc /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvCc _result5 = getTvCc();
                    reply.writeNoException();
                    if (_result5 != null) {
                        iBinder = _result5.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvCec /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvCec _result6 = getTvCec();
                    reply.writeNoException();
                    if (_result6 != null) {
                        iBinder = _result6.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvCi /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvCi _result7 = getTvCi();
                    reply.writeNoException();
                    if (_result7 != null) {
                        iBinder = _result7.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvChannel /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvChannel _result8 = getTvChannel();
                    reply.writeNoException();
                    if (_result8 != null) {
                        iBinder = _result8.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvCommon /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvCommon _result9 = getTvCommon();
                    reply.writeNoException();
                    if (_result9 != null) {
                        iBinder = _result9.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvEpg /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvEpg _result10 = getTvEpg();
                    reply.writeNoException();
                    if (_result10 != null) {
                        iBinder = _result10.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvFactory /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvFactory _result11 = getTvFactory();
                    reply.writeNoException();
                    if (_result11 != null) {
                        iBinder = _result11.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvPicture /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvPicture _result12 = getTvPicture();
                    reply.writeNoException();
                    if (_result12 != null) {
                        iBinder = _result12.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvTimer /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvTimer _result13 = getTvTimer();
                    reply.writeNoException();
                    if (_result13 != null) {
                        iBinder = _result13.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvPipPop /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvPipPop _result14 = getTvPipPop();
                    reply.writeNoException();
                    if (_result14 != null) {
                        iBinder = _result14.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvMhl /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvMhl _result15 = getTvMhl();
                    reply.writeNoException();
                    if (_result15 != null) {
                        iBinder = _result15.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvPvr /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvPvr _result16 = getTvPvr();
                    reply.writeNoException();
                    if (_result16 != null) {
                        iBinder = _result16.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvGinga /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvGinga _result17 = getTvGinga();
                    reply.writeNoException();
                    if (_result17 != null) {
                        iBinder = _result17.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_getTvParentalControl /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    ITvParentalControl _result18 = getTvParentalControl();
                    reply.writeNoException();
                    if (_result18 != null) {
                        iBinder = _result18.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case TRANSACTION_shutdown /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    shutdown();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_resume /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    resume();
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

    ITvAtscChannel getTvAtscChannel() throws RemoteException;

    ITvAudio getTvAudio() throws RemoteException;

    ITvCc getTvCc() throws RemoteException;

    ITvCec getTvCec() throws RemoteException;

    ITvChannel getTvChannel() throws RemoteException;

    ITvCi getTvCi() throws RemoteException;

    ITvCommon getTvCommon() throws RemoteException;

    ITvEpg getTvEpg() throws RemoteException;

    ITvFactory getTvFactory() throws RemoteException;

    ITvGinga getTvGinga() throws RemoteException;

    ITvIsdbChannel getTvIsdbChannel() throws RemoteException;

    ITvMhl getTvMhl() throws RemoteException;

    ITvParentalControl getTvParentalControl() throws RemoteException;

    ITvPicture getTvPicture() throws RemoteException;

    ITvPipPop getTvPipPop() throws RemoteException;

    ITvPvr getTvPvr() throws RemoteException;

    ITvS3D getTvS3D() throws RemoteException;

    ITvTimer getTvTimer() throws RemoteException;

    void resume() throws RemoteException;

    void shutdown() throws RemoteException;
}
