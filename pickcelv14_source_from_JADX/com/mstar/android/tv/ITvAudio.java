package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvAudio extends IInterface {

    public static abstract class Stub extends Binder implements ITvAudio {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvAudio";
        static final int TRANSACTION_getAvcMode = 12;
        static final int TRANSACTION_getBalance = 10;
        static final int TRANSACTION_getBass = 6;
        static final int TRANSACTION_getBassSwitch = 28;
        static final int TRANSACTION_getBassVolume = 30;
        static final int TRANSACTION_getDtvOutputMode = 40;
        static final int TRANSACTION_getEarPhoneVolume = 4;
        static final int TRANSACTION_getEqBand10k = 26;
        static final int TRANSACTION_getEqBand120 = 18;
        static final int TRANSACTION_getEqBand1500 = 22;
        static final int TRANSACTION_getEqBand500 = 20;
        static final int TRANSACTION_getEqBand5k = 24;
        static final int TRANSACTION_getPowerOnOffMusic = 32;
        static final int TRANSACTION_getSeparateHear = 36;
        static final int TRANSACTION_getSoundMode = 2;
        static final int TRANSACTION_getSpdifOutMode = 16;
        static final int TRANSACTION_getSurroundMode = 14;
        static final int TRANSACTION_getTreble = 8;
        static final int TRANSACTION_getTrueBass = 38;
        static final int TRANSACTION_getWallmusic = 34;
        static final int TRANSACTION_registerOnAudioEventListener = 41;
        static final int TRANSACTION_setAvcMode = 11;
        static final int TRANSACTION_setBalance = 9;
        static final int TRANSACTION_setBass = 5;
        static final int TRANSACTION_setBassSwitch = 27;
        static final int TRANSACTION_setBassVolume = 29;
        static final int TRANSACTION_setDtvOutputMode = 39;
        static final int TRANSACTION_setEarPhoneVolume = 3;
        static final int TRANSACTION_setEqBand10k = 25;
        static final int TRANSACTION_setEqBand120 = 17;
        static final int TRANSACTION_setEqBand1500 = 21;
        static final int TRANSACTION_setEqBand500 = 19;
        static final int TRANSACTION_setEqBand5k = 23;
        static final int TRANSACTION_setPowerOnOffMusic = 31;
        static final int TRANSACTION_setSeparateHear = 35;
        static final int TRANSACTION_setSoundMode = 1;
        static final int TRANSACTION_setSpdifOutMode = 15;
        static final int TRANSACTION_setSurroundMode = 13;
        static final int TRANSACTION_setTreble = 7;
        static final int TRANSACTION_setTrueBass = 37;
        static final int TRANSACTION_setWallmusic = 33;

        private static class Proxy implements ITvAudio {
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

            public boolean setSoundMode(int SoundMode) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(SoundMode);
                    this.mRemote.transact(Stub.TRANSACTION_setSoundMode, _data, _reply, 0);
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

            public int getSoundMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSoundMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEarPhoneVolume(int volume) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(volume);
                    this.mRemote.transact(Stub.TRANSACTION_setEarPhoneVolume, _data, _reply, 0);
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

            public int getEarPhoneVolume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEarPhoneVolume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setBass(int bassValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bassValue);
                    this.mRemote.transact(Stub.TRANSACTION_setBass, _data, _reply, 0);
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

            public int getBass() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBass, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setTreble(int bassValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(bassValue);
                    this.mRemote.transact(Stub.TRANSACTION_setTreble, _data, _reply, 0);
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

            public int getTreble() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTreble, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setBalance(int balanceValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(balanceValue);
                    this.mRemote.transact(Stub.TRANSACTION_setBalance, _data, _reply, 0);
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

            public int getBalance() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBalance, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAvcMode(boolean isAvcEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (isAvcEnable) {
                        i = Stub.TRANSACTION_setSoundMode;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setAvcMode, _data, _reply, 0);
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

            public boolean getAvcMode() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAvcMode, _data, _reply, 0);
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

            public boolean setSurroundMode(int surroundMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(surroundMode);
                    this.mRemote.transact(Stub.TRANSACTION_setSurroundMode, _data, _reply, 0);
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

            public int getSurroundMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSurroundMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setSpdifOutMode(int SpdifMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(SpdifMode);
                    this.mRemote.transact(Stub.TRANSACTION_setSpdifOutMode, _data, _reply, 0);
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

            public int getSpdifOutMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSpdifOutMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEqBand120(int eqValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eqValue);
                    this.mRemote.transact(Stub.TRANSACTION_setEqBand120, _data, _reply, 0);
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

            public int getEqBand120() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEqBand120, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEqBand500(int eqValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eqValue);
                    this.mRemote.transact(Stub.TRANSACTION_setEqBand500, _data, _reply, 0);
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

            public int getEqBand500() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEqBand500, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEqBand1500(int eqValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eqValue);
                    this.mRemote.transact(Stub.TRANSACTION_setEqBand1500, _data, _reply, 0);
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

            public int getEqBand1500() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEqBand1500, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEqBand5k(int eqValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eqValue);
                    this.mRemote.transact(Stub.TRANSACTION_setEqBand5k, _data, _reply, 0);
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

            public int getEqBand5k() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEqBand5k, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setEqBand10k(int eqValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eqValue);
                    this.mRemote.transact(Stub.TRANSACTION_setEqBand10k, _data, _reply, 0);
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

            public int getEqBand10k() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEqBand10k, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setBassSwitch(int en) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(en);
                    this.mRemote.transact(Stub.TRANSACTION_setBassSwitch, _data, _reply, 0);
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

            public int getBassSwitch() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBassSwitch, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setBassVolume(int volume) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(volume);
                    this.mRemote.transact(Stub.TRANSACTION_setBassVolume, _data, _reply, 0);
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

            public int getBassVolume() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBassVolume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPowerOnOffMusic(int en) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(en);
                    this.mRemote.transact(Stub.TRANSACTION_setPowerOnOffMusic, _data, _reply, 0);
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

            public int getPowerOnOffMusic() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPowerOnOffMusic, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWallmusic(int en) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(en);
                    this.mRemote.transact(Stub.TRANSACTION_setWallmusic, _data, _reply, 0);
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

            public int getWallmusic() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWallmusic, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setSeparateHear(int en) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(en);
                    this.mRemote.transact(Stub.TRANSACTION_setSeparateHear, _data, _reply, 0);
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

            public int getSeparateHear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSeparateHear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setTrueBass(int en) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(en);
                    this.mRemote.transact(Stub.TRANSACTION_setTrueBass, _data, _reply, 0);
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

            public int getTrueBass() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTrueBass, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setDtvOutputMode(int enDtvSoundMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enDtvSoundMode);
                    this.mRemote.transact(Stub.TRANSACTION_setDtvOutputMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getDtvOutputMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDtvOutputMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void registerOnAudioEventListener(int listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerOnAudioEventListener, _data, _reply, 0);
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

        public static ITvAudio asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvAudio)) {
                return new Proxy(obj);
            }
            return (ITvAudio) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            switch (code) {
                case TRANSACTION_setSoundMode /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setSoundMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSoundMode /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSoundMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEarPhoneVolume /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEarPhoneVolume(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEarPhoneVolume /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEarPhoneVolume();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setBass /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setBass(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBass /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getBass();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setTreble /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setTreble(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getTreble /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getTreble();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setBalance /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setBalance(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBalance /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getBalance();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAvcMode /*11*/:
                    boolean _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setAvcMode(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAvcMode /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getAvcMode();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setSurroundMode /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setSurroundMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSurroundMode /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSurroundMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setSpdifOutMode /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setSpdifOutMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSpdifOutMode /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSpdifOutMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEqBand120 /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEqBand120(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEqBand120 /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEqBand120();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEqBand500 /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEqBand500(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEqBand500 /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEqBand500();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEqBand1500 /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEqBand1500(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEqBand1500 /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEqBand1500();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEqBand5k /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEqBand5k(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEqBand5k /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEqBand5k();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEqBand10k /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEqBand10k(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEqBand10k /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEqBand10k();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setBassSwitch /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setBassSwitch(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBassSwitch /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getBassSwitch();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setBassVolume /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setBassVolume(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBassVolume /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getBassVolume();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPowerOnOffMusic /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPowerOnOffMusic(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPowerOnOffMusic /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPowerOnOffMusic();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWallmusic /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWallmusic(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWallmusic /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWallmusic();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setSeparateHear /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setSeparateHear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSeparateHear /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSeparateHear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setTrueBass /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setTrueBass(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setSoundMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getTrueBass /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getTrueBass();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setDtvOutputMode /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    setDtvOutputMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getDtvOutputMode /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDtvOutputMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_registerOnAudioEventListener /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    registerOnAudioEventListener(data.readInt());
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

    boolean getAvcMode() throws RemoteException;

    int getBalance() throws RemoteException;

    int getBass() throws RemoteException;

    int getBassSwitch() throws RemoteException;

    int getBassVolume() throws RemoteException;

    int getDtvOutputMode() throws RemoteException;

    int getEarPhoneVolume() throws RemoteException;

    int getEqBand10k() throws RemoteException;

    int getEqBand120() throws RemoteException;

    int getEqBand1500() throws RemoteException;

    int getEqBand500() throws RemoteException;

    int getEqBand5k() throws RemoteException;

    int getPowerOnOffMusic() throws RemoteException;

    int getSeparateHear() throws RemoteException;

    int getSoundMode() throws RemoteException;

    int getSpdifOutMode() throws RemoteException;

    int getSurroundMode() throws RemoteException;

    int getTreble() throws RemoteException;

    int getTrueBass() throws RemoteException;

    int getWallmusic() throws RemoteException;

    void registerOnAudioEventListener(int i) throws RemoteException;

    boolean setAvcMode(boolean z) throws RemoteException;

    boolean setBalance(int i) throws RemoteException;

    boolean setBass(int i) throws RemoteException;

    boolean setBassSwitch(int i) throws RemoteException;

    boolean setBassVolume(int i) throws RemoteException;

    void setDtvOutputMode(int i) throws RemoteException;

    boolean setEarPhoneVolume(int i) throws RemoteException;

    boolean setEqBand10k(int i) throws RemoteException;

    boolean setEqBand120(int i) throws RemoteException;

    boolean setEqBand1500(int i) throws RemoteException;

    boolean setEqBand500(int i) throws RemoteException;

    boolean setEqBand5k(int i) throws RemoteException;

    boolean setPowerOnOffMusic(int i) throws RemoteException;

    boolean setSeparateHear(int i) throws RemoteException;

    boolean setSoundMode(int i) throws RemoteException;

    boolean setSpdifOutMode(int i) throws RemoteException;

    boolean setSurroundMode(int i) throws RemoteException;

    boolean setTreble(int i) throws RemoteException;

    boolean setTrueBass(int i) throws RemoteException;

    boolean setWallmusic(int i) throws RemoteException;
}
