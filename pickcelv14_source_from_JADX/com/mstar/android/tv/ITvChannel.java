package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.ProgramInfo;
import com.mstar.android.tvapi.common.vo.ProgramInfoQueryCriteria;
import com.mstar.android.tvapi.dtv.vo.DtvAudioInfo;
import com.mstar.android.tvapi.dtv.vo.DtvSubtitleInfo;
import com.mstar.android.tvapi.dtv.vo.RfInfo;

public interface ITvChannel extends IInterface {

    public static abstract class Stub extends Binder implements ITvChannel {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvChannel";
        static final int TRANSACTION_addProgramToFavorite = 6;
        static final int TRANSACTION_changeToFirstService = 2;
        static final int TRANSACTION_closeSubtitle = 19;
        static final int TRANSACTION_deleteProgramFromFavorite = 20;
        static final int TRANSACTION_getAtvCurrentFrequency = 7;
        static final int TRANSACTION_getAtvProgramInfo = 8;
        static final int TRANSACTION_getAtvSoundSystem = 9;
        static final int TRANSACTION_getAtvStationName = 23;
        static final int TRANSACTION_getAtvVideoSystem = 10;
        static final int TRANSACTION_getAudioInfo = 58;
        static final int TRANSACTION_getAudioLanguageDefaultValue = 59;
        static final int TRANSACTION_getChannelSwitchMode = 55;
        static final int TRANSACTION_getCurrentChannelNumber = 11;
        static final int TRANSACTION_getCurrentLanguageIndex = 47;
        static final int TRANSACTION_getProgramAttribute = 34;
        static final int TRANSACTION_getProgramCount = 24;
        static final int TRANSACTION_getProgramCtrl = 35;
        static final int TRANSACTION_getProgramInfo = 56;
        static final int TRANSACTION_getProgramName = 57;
        static final int TRANSACTION_getRfInfo = 53;
        static final int TRANSACTION_getSIFMtsMode = 36;
        static final int TRANSACTION_getSubtitleInfo = 38;
        static final int TRANSACTION_getSystemCountry = 37;
        static final int TRANSACTION_getVideoStandard = 33;
        static final int TRANSACTION_isSignalStabled = 32;
        static final int TRANSACTION_openSubtitle = 31;
        static final int TRANSACTION_pauseAtvAutoTuning = 13;
        static final int TRANSACTION_pauseDtvScan = 41;
        static final int TRANSACTION_playDtvCurrentProgram = 42;
        static final int TRANSACTION_programDown = 29;
        static final int TRANSACTION_programUp = 30;
        static final int TRANSACTION_registerOnAtvPlayerEventListener = 51;
        static final int TRANSACTION_registerOnDtvPlayerEventListener = 50;
        static final int TRANSACTION_registerOnTvPlayerEventListener = 49;
        static final int TRANSACTION_resumeAtvAutoTuning = 14;
        static final int TRANSACTION_resumeDtvScan = 43;
        static final int TRANSACTION_setAtvChannel = 15;
        static final int TRANSACTION_setAtvForceSoundSystem = 16;
        static final int TRANSACTION_setAtvForceVedioSystem = 17;
        static final int TRANSACTION_setAtvProgramInfo = 18;
        static final int TRANSACTION_setAudioLanguageDefaultValue = 60;
        static final int TRANSACTION_setChannelChangeFreezeMode = 48;
        static final int TRANSACTION_setChannelSwitchMode = 54;
        static final int TRANSACTION_setDtvAntennaType = 44;
        static final int TRANSACTION_setDtvManualScanByFreq = 39;
        static final int TRANSACTION_setDtvManualScanByRF = 40;
        static final int TRANSACTION_setProgramAttribute = 28;
        static final int TRANSACTION_setProgramCtrl = 27;
        static final int TRANSACTION_setSystemCountry = 26;
        static final int TRANSACTION_startATSCAtvManualTuning = 5;
        static final int TRANSACTION_startAtvAutoTuning = 4;
        static final int TRANSACTION_startAtvManualTuning = 1;
        static final int TRANSACTION_startDtvAutoScan = 21;
        static final int TRANSACTION_startDtvFullScan = 22;
        static final int TRANSACTION_startDtvManualScan = 45;
        static final int TRANSACTION_stopAtvAutoTuning = 12;
        static final int TRANSACTION_stopAtvManualTuning = 3;
        static final int TRANSACTION_stopDtvScan = 46;
        static final int TRANSACTION_switchAudioTrack = 25;
        static final int TRANSACTION_switchMSrvDtvRouteCmd = 52;

        private static class Proxy implements ITvChannel {
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

            public boolean startAtvManualTuning(int EventIntervalMs, int Frequency, int eMode) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(EventIntervalMs);
                    _data.writeInt(Frequency);
                    _data.writeInt(eMode);
                    this.mRemote.transact(Stub.TRANSACTION_startAtvManualTuning, _data, _reply, 0);
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

            public boolean changeToFirstService(int enInputType, int enServiceType) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enInputType);
                    _data.writeInt(enServiceType);
                    this.mRemote.transact(Stub.TRANSACTION_changeToFirstService, _data, _reply, 0);
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

            public void stopAtvManualTuning() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAtvManualTuning, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean startAtvAutoTuning(int EventIntervalMs, int FrequencyStart, int FrequencyEnd) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(EventIntervalMs);
                    _data.writeInt(FrequencyStart);
                    _data.writeInt(FrequencyEnd);
                    this.mRemote.transact(Stub.TRANSACTION_startAtvAutoTuning, _data, _reply, 0);
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

            public void startATSCAtvManualTuning(int major, int minor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(major);
                    _data.writeInt(minor);
                    this.mRemote.transact(Stub.TRANSACTION_startATSCAtvManualTuning, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void addProgramToFavorite(int favoriteId, int programNo, int programType, int programId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(favoriteId);
                    _data.writeInt(programNo);
                    _data.writeInt(programType);
                    _data.writeInt(programId);
                    this.mRemote.transact(Stub.TRANSACTION_addProgramToFavorite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvCurrentFrequency() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvCurrentFrequency, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvProgramInfo(int Cmd, int u16Program) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Cmd);
                    _data.writeInt(u16Program);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvProgramInfo, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvSoundSystem() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvSoundSystem, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvVideoSystem() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvVideoSystem, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurrentChannelNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentChannelNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean stopAtvAutoTuning() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAtvAutoTuning, _data, _reply, 0);
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

            public boolean pauseAtvAutoTuning() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pauseAtvAutoTuning, _data, _reply, 0);
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

            public boolean resumeAtvAutoTuning() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resumeAtvAutoTuning, _data, _reply, 0);
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

            public int setAtvChannel(int ChannelNumber) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(ChannelNumber);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvChannel, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAtvForceSoundSystem(int eSoundSystem) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eSoundSystem);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvForceSoundSystem, _data, _reply, 0);
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

            public boolean setAtvForceVedioSystem(int eVideoSystem) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eVideoSystem);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvForceVedioSystem, _data, _reply, 0);
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

            public int setAtvProgramInfo(int Cmd, int Program, int Param2) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Cmd);
                    _data.writeInt(Program);
                    _data.writeInt(Param2);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvProgramInfo, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean closeSubtitle() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_closeSubtitle, _data, _reply, 0);
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

            public void deleteProgramFromFavorite(int favoriteId, int programNo, int programType, int programId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(favoriteId);
                    _data.writeInt(programNo);
                    _data.writeInt(programType);
                    _data.writeInt(programId);
                    this.mRemote.transact(Stub.TRANSACTION_deleteProgramFromFavorite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean startDtvAutoScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startDtvAutoScan, _data, _reply, 0);
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

            public boolean startDtvFullScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startDtvFullScan, _data, _reply, 0);
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

            public String getAtvStationName(int programNo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(programNo);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvStationName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getProgramCount(int programCountType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(programCountType);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramCount, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void switchAudioTrack(int track) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(track);
                    this.mRemote.transact(Stub.TRANSACTION_switchAudioTrack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setSystemCountry(int memberCountry) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(memberCountry);
                    this.mRemote.transact(Stub.TRANSACTION_setSystemCountry, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int setProgramCtrl(int Cmd, int u16Param2, int u16Param3) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Cmd);
                    _data.writeInt(u16Param2);
                    _data.writeInt(u16Param3);
                    this.mRemote.transact(Stub.TRANSACTION_setProgramCtrl, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setProgramAttribute(int enpa, int programNo, int programType, int programId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enpa);
                    _data.writeInt(programNo);
                    _data.writeInt(programType);
                    _data.writeInt(programId);
                    this.mRemote.transact(Stub.TRANSACTION_setProgramAttribute, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean programDown() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_programDown, _data, _reply, 0);
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

            public boolean programUp() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_programUp, _data, _reply, 0);
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

            public boolean openSubtitle(int index) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_openSubtitle, _data, _reply, 0);
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

            public boolean isSignalStabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isSignalStabled, _data, _reply, 0);
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

            public int getVideoStandard() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVideoStandard, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean getProgramAttribute(int enpa, int programNo, int programType, int programId) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enpa);
                    _data.writeInt(programNo);
                    _data.writeInt(programType);
                    _data.writeInt(programId);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramAttribute, _data, _reply, 0);
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

            public int getProgramCtrl(int Cmd, int u16Param2, int u16Param3) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Cmd);
                    _data.writeInt(u16Param2);
                    _data.writeInt(u16Param3);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramCtrl, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getSIFMtsMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSIFMtsMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getSystemCountry() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSystemCountry, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public DtvSubtitleInfo getSubtitleInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    DtvSubtitleInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSubtitleInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (DtvSubtitleInfo) DtvSubtitleInfo.CREATOR.createFromParcel(_reply);
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

            public boolean setDtvManualScanByFreq(int FrequencyKHz) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(FrequencyKHz);
                    this.mRemote.transact(Stub.TRANSACTION_setDtvManualScanByFreq, _data, _reply, 0);
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

            public boolean setDtvManualScanByRF(int RFNum) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(RFNum);
                    this.mRemote.transact(Stub.TRANSACTION_setDtvManualScanByRF, _data, _reply, 0);
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

            public boolean pauseDtvScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pauseDtvScan, _data, _reply, 0);
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

            public boolean playDtvCurrentProgram() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_playDtvCurrentProgram, _data, _reply, 0);
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

            public boolean resumeDtvScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resumeDtvScan, _data, _reply, 0);
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

            public void setDtvAntennaType(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(Stub.TRANSACTION_setDtvAntennaType, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean startDtvManualScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startDtvManualScan, _data, _reply, 0);
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

            public boolean stopDtvScan() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopDtvScan, _data, _reply, 0);
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

            public int getCurrentLanguageIndex(String languageCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(languageCode);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentLanguageIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setChannelChangeFreezeMode(boolean freezeMode) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (freezeMode) {
                        i = Stub.TRANSACTION_startAtvManualTuning;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setChannelChangeFreezeMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean registerOnTvPlayerEventListener(int listener) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerOnTvPlayerEventListener, _data, _reply, 0);
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

            public boolean registerOnDtvPlayerEventListener(int listener) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerOnDtvPlayerEventListener, _data, _reply, 0);
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

            public boolean registerOnAtvPlayerEventListener(int listener) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerOnAtvPlayerEventListener, _data, _reply, 0);
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

            public boolean switchMSrvDtvRouteCmd(int dtvRoute) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(dtvRoute);
                    this.mRemote.transact(Stub.TRANSACTION_switchMSrvDtvRouteCmd, _data, _reply, 0);
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

            public RfInfo getRfInfo(int rfSignalInfoType, int rfChNo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    RfInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rfSignalInfoType);
                    _data.writeInt(rfChNo);
                    this.mRemote.transact(Stub.TRANSACTION_getRfInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (RfInfo) RfInfo.CREATOR.createFromParcel(_reply);
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

            public boolean setChannelSwitchMode(int eMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMode);
                    this.mRemote.transact(Stub.TRANSACTION_setChannelSwitchMode, _data, _reply, 0);
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

            public int getChannelSwitchMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getChannelSwitchMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ProgramInfo getProgramInfo(ProgramInfoQueryCriteria criteria, int eProgramInfoType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    ProgramInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (criteria != null) {
                        _data.writeInt(Stub.TRANSACTION_startAtvManualTuning);
                        criteria.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(eProgramInfoType);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (ProgramInfo) ProgramInfo.CREATOR.createFromParcel(_reply);
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

            public String getProgramName(int progNo, int progType, int progID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(progNo);
                    _data.writeInt(progType);
                    _data.writeInt(progID);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public DtvAudioInfo getAudioInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    DtvAudioInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (DtvAudioInfo) DtvAudioInfo.CREATOR.createFromParcel(_reply);
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

            public int getAudioLanguageDefaultValue() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioLanguageDefaultValue, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setAudioLanguageDefaultValue(int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioLanguageDefaultValue, _data, _reply, 0);
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

        public static ITvChannel asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvChannel)) {
                return new Proxy(obj);
            }
            return (ITvChannel) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            String _result3;
            switch (code) {
                case TRANSACTION_startAtvManualTuning /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startAtvManualTuning(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_changeToFirstService /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = changeToFirstService(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_stopAtvManualTuning /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopAtvManualTuning();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startAtvAutoTuning /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startAtvAutoTuning(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_startATSCAtvManualTuning /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    startATSCAtvManualTuning(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_addProgramToFavorite /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    addProgramToFavorite(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAtvCurrentFrequency /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAtvCurrentFrequency();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getAtvProgramInfo /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAtvProgramInfo(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getAtvSoundSystem /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAtvSoundSystem();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getAtvVideoSystem /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAtvVideoSystem();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getCurrentChannelNumber /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentChannelNumber();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_stopAtvAutoTuning /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopAtvAutoTuning();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_pauseAtvAutoTuning /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = pauseAtvAutoTuning();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_resumeAtvAutoTuning /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = resumeAtvAutoTuning();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAtvChannel /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setAtvChannel(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAtvForceSoundSystem /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAtvForceSoundSystem(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAtvForceVedioSystem /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAtvForceVedioSystem(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAtvProgramInfo /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setAtvProgramInfo(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_closeSubtitle /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = closeSubtitle();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_deleteProgramFromFavorite /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    deleteProgramFromFavorite(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startDtvAutoScan /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startDtvAutoScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_startDtvFullScan /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startDtvFullScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAtvStationName /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAtvStationName(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getProgramCount /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getProgramCount(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_switchAudioTrack /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    switchAudioTrack(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setSystemCountry /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    setSystemCountry(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setProgramCtrl /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setProgramCtrl(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setProgramAttribute /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    setProgramAttribute(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_programDown /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = programDown();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_programUp /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = programUp();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_openSubtitle /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = openSubtitle(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isSignalStabled /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isSignalStabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVideoStandard /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVideoStandard();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getProgramAttribute /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getProgramAttribute(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getProgramCtrl /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getProgramCtrl(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getSIFMtsMode /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSIFMtsMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getSystemCountry /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getSystemCountry();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getSubtitleInfo /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    DtvSubtitleInfo _result4 = getSubtitleInfo();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_startAtvManualTuning);
                        _result4.writeToParcel(reply, TRANSACTION_startAtvManualTuning);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setDtvManualScanByFreq /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setDtvManualScanByFreq(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDtvManualScanByRF /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setDtvManualScanByRF(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_pauseDtvScan /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = pauseDtvScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_playDtvCurrentProgram /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = playDtvCurrentProgram();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_resumeDtvScan /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = resumeDtvScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDtvAntennaType /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    setDtvAntennaType(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startDtvManualScan /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startDtvManualScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_stopDtvScan /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopDtvScan();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurrentLanguageIndex /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentLanguageIndex(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setChannelChangeFreezeMode /*48*/:
                    boolean _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setChannelChangeFreezeMode(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_registerOnTvPlayerEventListener /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = registerOnTvPlayerEventListener(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_registerOnDtvPlayerEventListener /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = registerOnDtvPlayerEventListener(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_registerOnAtvPlayerEventListener /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = registerOnAtvPlayerEventListener(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_switchMSrvDtvRouteCmd /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = switchMSrvDtvRouteCmd(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getRfInfo /*53*/:
                    data.enforceInterface(DESCRIPTOR);
                    RfInfo _result5 = getRfInfo(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(TRANSACTION_startAtvManualTuning);
                        _result5.writeToParcel(reply, TRANSACTION_startAtvManualTuning);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setChannelSwitchMode /*54*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setChannelSwitchMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startAtvManualTuning;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getChannelSwitchMode /*55*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getChannelSwitchMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getProgramInfo /*56*/:
                    ProgramInfoQueryCriteria _arg02;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (ProgramInfoQueryCriteria) ProgramInfoQueryCriteria.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    ProgramInfo _result6 = getProgramInfo(_arg02, data.readInt());
                    reply.writeNoException();
                    if (_result6 != null) {
                        reply.writeInt(TRANSACTION_startAtvManualTuning);
                        _result6.writeToParcel(reply, TRANSACTION_startAtvManualTuning);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getProgramName /*57*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getProgramName(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getAudioInfo /*58*/:
                    data.enforceInterface(DESCRIPTOR);
                    DtvAudioInfo _result7 = getAudioInfo();
                    reply.writeNoException();
                    if (_result7 != null) {
                        reply.writeInt(TRANSACTION_startAtvManualTuning);
                        _result7.writeToParcel(reply, TRANSACTION_startAtvManualTuning);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getAudioLanguageDefaultValue /*59*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioLanguageDefaultValue();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioLanguageDefaultValue /*60*/:
                    data.enforceInterface(DESCRIPTOR);
                    setAudioLanguageDefaultValue(data.readInt());
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

    void addProgramToFavorite(int i, int i2, int i3, int i4) throws RemoteException;

    boolean changeToFirstService(int i, int i2) throws RemoteException;

    boolean closeSubtitle() throws RemoteException;

    void deleteProgramFromFavorite(int i, int i2, int i3, int i4) throws RemoteException;

    int getAtvCurrentFrequency() throws RemoteException;

    int getAtvProgramInfo(int i, int i2) throws RemoteException;

    int getAtvSoundSystem() throws RemoteException;

    String getAtvStationName(int i) throws RemoteException;

    int getAtvVideoSystem() throws RemoteException;

    DtvAudioInfo getAudioInfo() throws RemoteException;

    int getAudioLanguageDefaultValue() throws RemoteException;

    int getChannelSwitchMode() throws RemoteException;

    int getCurrentChannelNumber() throws RemoteException;

    int getCurrentLanguageIndex(String str) throws RemoteException;

    boolean getProgramAttribute(int i, int i2, int i3, int i4) throws RemoteException;

    int getProgramCount(int i) throws RemoteException;

    int getProgramCtrl(int i, int i2, int i3) throws RemoteException;

    ProgramInfo getProgramInfo(ProgramInfoQueryCriteria programInfoQueryCriteria, int i) throws RemoteException;

    String getProgramName(int i, int i2, int i3) throws RemoteException;

    RfInfo getRfInfo(int i, int i2) throws RemoteException;

    int getSIFMtsMode() throws RemoteException;

    DtvSubtitleInfo getSubtitleInfo() throws RemoteException;

    int getSystemCountry() throws RemoteException;

    int getVideoStandard() throws RemoteException;

    boolean isSignalStabled() throws RemoteException;

    boolean openSubtitle(int i) throws RemoteException;

    boolean pauseAtvAutoTuning() throws RemoteException;

    boolean pauseDtvScan() throws RemoteException;

    boolean playDtvCurrentProgram() throws RemoteException;

    boolean programDown() throws RemoteException;

    boolean programUp() throws RemoteException;

    boolean registerOnAtvPlayerEventListener(int i) throws RemoteException;

    boolean registerOnDtvPlayerEventListener(int i) throws RemoteException;

    boolean registerOnTvPlayerEventListener(int i) throws RemoteException;

    boolean resumeAtvAutoTuning() throws RemoteException;

    boolean resumeDtvScan() throws RemoteException;

    int setAtvChannel(int i) throws RemoteException;

    boolean setAtvForceSoundSystem(int i) throws RemoteException;

    boolean setAtvForceVedioSystem(int i) throws RemoteException;

    int setAtvProgramInfo(int i, int i2, int i3) throws RemoteException;

    void setAudioLanguageDefaultValue(int i) throws RemoteException;

    void setChannelChangeFreezeMode(boolean z) throws RemoteException;

    boolean setChannelSwitchMode(int i) throws RemoteException;

    void setDtvAntennaType(int i) throws RemoteException;

    boolean setDtvManualScanByFreq(int i) throws RemoteException;

    boolean setDtvManualScanByRF(int i) throws RemoteException;

    void setProgramAttribute(int i, int i2, int i3, int i4) throws RemoteException;

    int setProgramCtrl(int i, int i2, int i3) throws RemoteException;

    void setSystemCountry(int i) throws RemoteException;

    void startATSCAtvManualTuning(int i, int i2) throws RemoteException;

    boolean startAtvAutoTuning(int i, int i2, int i3) throws RemoteException;

    boolean startAtvManualTuning(int i, int i2, int i3) throws RemoteException;

    boolean startDtvAutoScan() throws RemoteException;

    boolean startDtvFullScan() throws RemoteException;

    boolean startDtvManualScan() throws RemoteException;

    boolean stopAtvAutoTuning() throws RemoteException;

    void stopAtvManualTuning() throws RemoteException;

    boolean stopDtvScan() throws RemoteException;

    void switchAudioTrack(int i) throws RemoteException;

    boolean switchMSrvDtvRouteCmd(int i) throws RemoteException;
}
