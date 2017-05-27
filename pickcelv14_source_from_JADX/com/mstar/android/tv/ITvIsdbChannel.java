package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.ProgramInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscMainListChannelInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscScanChannelNotify;
import com.mstar.android.tvapi.dtv.atsc.vo.RR5RatingPair;
import com.mstar.android.tvapi.dtv.atsc.vo.Regin5DimensionInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.Region5RatingInformation;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaMpaaRatingType;
import com.mstar.android.tvapi.dtv.atsc.vo.UsaTvRatingInformation;
import java.util.List;

public interface ITvIsdbChannel extends IInterface {

    public static abstract class Stub extends Binder implements ITvIsdbChannel {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvIsdbChannel";
        static final int TRANSACTION_changeDtvToManualFirstService = 10;
        static final int TRANSACTION_changeProgramList = 6;
        static final int TRANSACTION_commondCmd = 47;
        static final int TRANSACTION_connectDatabase = 50;
        static final int TRANSACTION_deleteAllMainList = 1;
        static final int TRANSACTION_deleteAtvMainList = 3;
        static final int TRANSACTION_deleteChannelInformationByRf = 4;
        static final int TRANSACTION_deleteDtvMainList = 2;
        static final int TRANSACTION_doesCcExist = 43;
        static final int TRANSACTION_forceVideoStandard = 61;
        static final int TRANSACTION_genMixProgList = 51;
        static final int TRANSACTION_getAntennaType = 53;
        static final int TRANSACTION_getAtvProgramInfo = 59;
        static final int TRANSACTION_getBlockSysLockMode = 39;
        static final int TRANSACTION_getBlockUnlockUnrated = 33;
        static final int TRANSACTION_getCanadaEngRatingLock = 11;
        static final int TRANSACTION_getCanadaFreRatingLock = 12;
        static final int TRANSACTION_getCcMode = 45;
        static final int TRANSACTION_getCurrentChannelInformation = 5;
        static final int TRANSACTION_getCurrentProgramInfo = 7;
        static final int TRANSACTION_getCurrentRatingInformation = 13;
        static final int TRANSACTION_getCurrentVChipBlockStatus = 23;
        static final int TRANSACTION_getNtscAntenna = 48;
        static final int TRANSACTION_getProgramControl = 56;
        static final int TRANSACTION_getProgramInfo = 26;
        static final int TRANSACTION_getRR5RatingPair = 38;
        static final int TRANSACTION_getRRT5Dimension = 36;
        static final int TRANSACTION_getRRT5NoDimension = 35;
        static final int TRANSACTION_getRRTInformation = 14;
        static final int TRANSACTION_getTSUpdateInfo = 46;
        static final int TRANSACTION_getUsaMpaaRatingLock = 15;
        static final int TRANSACTION_getUsaTvRatingLock = 16;
        static final int TRANSACTION_getVChipInputSourceBlockStatus = 24;
        static final int TRANSACTION_programSel = 8;
        static final int TRANSACTION_resetRRTSetting = 17;
        static final int TRANSACTION_saveAtvProgram = 55;
        static final int TRANSACTION_setAntennaType = 52;
        static final int TRANSACTION_setAtvProgramInfo = 60;
        static final int TRANSACTION_setBlockSysLockMode = 40;
        static final int TRANSACTION_setBlockUnlockUnrated = 34;
        static final int TRANSACTION_setCanadaEngGuideline = 30;
        static final int TRANSACTION_setCanadaEngRatingLock = 18;
        static final int TRANSACTION_setCanadaFreGuideline = 31;
        static final int TRANSACTION_setCanadaFreRatingLock = 19;
        static final int TRANSACTION_setCcMode = 44;
        static final int TRANSACTION_setChannel = 54;
        static final int TRANSACTION_setDtvAntennaType = 27;
        static final int TRANSACTION_setDynamicGuideline = 32;
        static final int TRANSACTION_setManualTuningEnd = 58;
        static final int TRANSACTION_setManualTuningStart = 57;
        static final int TRANSACTION_setNtscAntenna = 49;
        static final int TRANSACTION_setProgramName = 9;
        static final int TRANSACTION_setRR5RatingPair = 37;
        static final int TRANSACTION_setUsaMpaaGuideline = 29;
        static final int TRANSACTION_setUsaMpaaRatingLock = 20;
        static final int TRANSACTION_setUsaTvGuideline = 28;
        static final int TRANSACTION_setUsaTvRatingLock = 21;
        static final int TRANSACTION_setVChipGuideline = 22;
        static final int TRANSACTION_setVChipInputSourceBlockStatus = 25;
        static final int TRANSACTION_startCc = 41;
        static final int TRANSACTION_stopCc = 42;

        private static class Proxy implements ITvIsdbChannel {
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

            public boolean deleteAllMainList() throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_deleteAllMainList, _data, _reply, 0);
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

            public boolean deleteDtvMainList() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_deleteDtvMainList, _data, _reply, 0);
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

            public boolean deleteAtvMainList() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_deleteAtvMainList, _data, _reply, 0);
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

            public boolean deleteChannelInformationByRf(int rfCh) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rfCh);
                    this.mRemote.transact(Stub.TRANSACTION_deleteChannelInformationByRf, _data, _reply, 0);
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

            public AtscMainListChannelInformation getCurrentChannelInformation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscMainListChannelInformation _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentChannelInformation, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscMainListChannelInformation) AtscMainListChannelInformation.CREATOR.createFromParcel(_reply);
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

            public boolean changeProgramList() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_changeProgramList, _data, _reply, 0);
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

            public ProgramInfo getCurrentProgramInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    ProgramInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentProgramInfo, _data, _reply, 0);
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

            public boolean programSel(int u32Number, int u8ServiceType) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(u32Number);
                    _data.writeInt(u8ServiceType);
                    this.mRemote.transact(Stub.TRANSACTION_programSel, _data, _reply, 0);
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

            public void setProgramName(int majorNumber, int minorNumber, String programName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(majorNumber);
                    _data.writeInt(minorNumber);
                    _data.writeString(programName);
                    this.mRemote.transact(Stub.TRANSACTION_setProgramName, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean changeDtvToManualFirstService(int rfCh) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rfCh);
                    this.mRemote.transact(Stub.TRANSACTION_changeDtvToManualFirstService, _data, _reply, 0);
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

            public int getCanadaEngRatingLock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCanadaEngRatingLock, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCanadaFreRatingLock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCanadaFreRatingLock, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCurrentRatingInformation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentRatingInformation, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public Region5RatingInformation getRRTInformation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    Region5RatingInformation _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRRTInformation, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (Region5RatingInformation) Region5RatingInformation.CREATOR.createFromParcel(_reply);
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

            public UsaMpaaRatingType getUsaMpaaRatingLock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    UsaMpaaRatingType _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUsaMpaaRatingLock, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (UsaMpaaRatingType) UsaMpaaRatingType.CREATOR.createFromParcel(_reply);
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

            public UsaTvRatingInformation getUsaTvRatingLock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    UsaTvRatingInformation _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUsaTvRatingLock, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (UsaTvRatingInformation) UsaTvRatingInformation.CREATOR.createFromParcel(_reply);
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

            public boolean resetRRTSetting() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resetRRTSetting, _data, _reply, 0);
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

            public boolean setCanadaEngRatingLock(int enRatingType) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enRatingType);
                    this.mRemote.transact(Stub.TRANSACTION_setCanadaEngRatingLock, _data, _reply, 0);
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

            public boolean setCanadaFreRatingLock(int enRatingType) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enRatingType);
                    this.mRemote.transact(Stub.TRANSACTION_setCanadaFreRatingLock, _data, _reply, 0);
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

            public boolean setUsaMpaaRatingLock(UsaMpaaRatingType usaMpaaRatingType) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (usaMpaaRatingType != null) {
                        _data.writeInt(Stub.TRANSACTION_deleteAllMainList);
                        usaMpaaRatingType.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setUsaMpaaRatingLock, _data, _reply, 0);
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

            public boolean setUsaTvRatingLock(UsaTvRatingInformation usaTvRatingInfo) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (usaTvRatingInfo != null) {
                        _data.writeInt(Stub.TRANSACTION_deleteAllMainList);
                        usaTvRatingInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setUsaTvRatingLock, _data, _reply, 0);
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

            public boolean setVChipGuideline(int ratingType, int para1, int para2, int para3) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(ratingType);
                    _data.writeInt(para1);
                    _data.writeInt(para2);
                    _data.writeInt(para3);
                    this.mRemote.transact(Stub.TRANSACTION_setVChipGuideline, _data, _reply, 0);
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

            public boolean getCurrentVChipBlockStatus() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentVChipBlockStatus, _data, _reply, 0);
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

            public boolean getVChipInputSourceBlockStatus(int enInputSource) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enInputSource);
                    this.mRemote.transact(Stub.TRANSACTION_getVChipInputSourceBlockStatus, _data, _reply, 0);
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

            public void setVChipInputSourceBlockStatus(int enInputSource, boolean enable) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enInputSource);
                    if (enable) {
                        i = Stub.TRANSACTION_deleteAllMainList;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setVChipInputSourceBlockStatus, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ProgramInfo getProgramInfo(int queryIndex) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    ProgramInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(queryIndex);
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

            public boolean setUsaTvGuideline(int age, int rank) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(age);
                    _data.writeInt(rank);
                    this.mRemote.transact(Stub.TRANSACTION_setUsaTvGuideline, _data, _reply, 0);
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

            public boolean setUsaMpaaGuideline(int rank, boolean isNr) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rank);
                    if (isNr) {
                        i = Stub.TRANSACTION_deleteAllMainList;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setUsaMpaaGuideline, _data, _reply, 0);
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

            public boolean setCanadaEngGuideline(int rank) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rank);
                    this.mRemote.transact(Stub.TRANSACTION_setCanadaEngGuideline, _data, _reply, 0);
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

            public boolean setCanadaFreGuideline(int rank) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rank);
                    this.mRemote.transact(Stub.TRANSACTION_setCanadaFreGuideline, _data, _reply, 0);
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

            public boolean setDynamicGuideline(int grad, int rank, int value) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(grad);
                    _data.writeInt(rank);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setDynamicGuideline, _data, _reply, 0);
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

            public boolean getBlockUnlockUnrated() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBlockUnlockUnrated, _data, _reply, 0);
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

            public void setBlockUnlockUnrated(boolean enable) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (enable) {
                        i = Stub.TRANSACTION_deleteAllMainList;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setBlockUnlockUnrated, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getRRT5NoDimension() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRRT5NoDimension, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public List<Regin5DimensionInformation> getRRT5Dimension() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRRT5Dimension, _data, _reply, 0);
                    _reply.readException();
                    List<Regin5DimensionInformation> _result = _reply.createTypedArrayList(Regin5DimensionInformation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setRR5RatingPair(int title, int index, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(title);
                    _data.writeInt(index);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setRR5RatingPair, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public List<RR5RatingPair> getRR5RatingPair(int index, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(count);
                    this.mRemote.transact(Stub.TRANSACTION_getRR5RatingPair, _data, _reply, 0);
                    _reply.readException();
                    List<RR5RatingPair> _result = _reply.createTypedArrayList(RR5RatingPair.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getBlockSysLockMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBlockSysLockMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setBlockSysLockMode(int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setBlockSysLockMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean startCc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startCc, _data, _reply, 0);
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

            public boolean stopCc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopCc, _data, _reply, 0);
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

            public boolean doesCcExist() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_doesCcExist, _data, _reply, 0);
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

            public void setCcMode(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode);
                    this.mRemote.transact(Stub.TRANSACTION_setCcMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCcMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCcMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public AtscScanChannelNotify getTSUpdateInfo(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscScanChannelNotify _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getTSUpdateInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscScanChannelNotify) AtscScanChannelNotify.CREATOR.createFromParcel(_reply);
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

            public void commondCmd(int command, int programNo, int param3) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(command);
                    _data.writeInt(programNo);
                    _data.writeInt(param3);
                    this.mRemote.transact(Stub.TRANSACTION_commondCmd, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getNtscAntenna() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getNtscAntenna, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setNtscAntenna(int db) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(db);
                    this.mRemote.transact(Stub.TRANSACTION_setNtscAntenna, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void connectDatabase(int db) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(db);
                    this.mRemote.transact(Stub.TRANSACTION_connectDatabase, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean genMixProgList(boolean backup) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (backup) {
                        i = Stub.TRANSACTION_deleteAllMainList;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_genMixProgList, _data, _reply, 0);
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

            public void setAntennaType(int enAntennaType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enAntennaType);
                    this.mRemote.transact(Stub.TRANSACTION_setAntennaType, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAntennaType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAntennaType, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int setChannel(int u16channelnum, boolean bcheckblock) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(u16channelnum);
                    if (bcheckblock) {
                        i = Stub.TRANSACTION_deleteAllMainList;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setChannel, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean saveAtvProgram(int currentProgramNo) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(currentProgramNo);
                    this.mRemote.transact(Stub.TRANSACTION_saveAtvProgram, _data, _reply, 0);
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

            public int getProgramControl(int command, int programNo, int param3) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(command);
                    _data.writeInt(programNo);
                    _data.writeInt(param3);
                    this.mRemote.transact(Stub.TRANSACTION_getProgramControl, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setManualTuningStart(int eEventIntervalMs, int frequency, int eMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eEventIntervalMs);
                    _data.writeInt(frequency);
                    _data.writeInt(eMode);
                    this.mRemote.transact(Stub.TRANSACTION_setManualTuningStart, _data, _reply, 0);
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

            public void setManualTuningEnd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_setManualTuningEnd, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAtvProgramInfo(int command, int programNo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(command);
                    _data.writeInt(programNo);
                    this.mRemote.transact(Stub.TRANSACTION_getAtvProgramInfo, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAtvProgramInfo(int command, int programNo, int param3) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(command);
                    _data.writeInt(programNo);
                    _data.writeInt(param3);
                    this.mRemote.transact(Stub.TRANSACTION_setAtvProgramInfo, _data, _reply, 0);
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

            public void forceVideoStandard(int videoStandardType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(videoStandardType);
                    this.mRemote.transact(Stub.TRANSACTION_forceVideoStandard, _data, _reply, 0);
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

        public static ITvIsdbChannel asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvIsdbChannel)) {
                return new Proxy(obj);
            }
            return (ITvIsdbChannel) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            ProgramInfo _result2;
            int _result3;
            int _arg0;
            boolean _arg1;
            boolean _arg02;
            switch (code) {
                case TRANSACTION_deleteAllMainList /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteAllMainList();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_deleteDtvMainList /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteDtvMainList();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_deleteAtvMainList /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteAtvMainList();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_deleteChannelInformationByRf /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteChannelInformationByRf(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurrentChannelInformation /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    AtscMainListChannelInformation _result4 = getCurrentChannelInformation();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result4.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_changeProgramList /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = changeProgramList();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurrentProgramInfo /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentProgramInfo();
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result2.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_programSel /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = programSel(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setProgramName /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    setProgramName(data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_changeDtvToManualFirstService /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = changeDtvToManualFirstService(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCanadaEngRatingLock /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCanadaEngRatingLock();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getCanadaFreRatingLock /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCanadaFreRatingLock();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getCurrentRatingInformation /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    String _result5 = getCurrentRatingInformation();
                    reply.writeNoException();
                    reply.writeString(_result5);
                    return true;
                case TRANSACTION_getRRTInformation /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    Region5RatingInformation _result6 = getRRTInformation();
                    reply.writeNoException();
                    if (_result6 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result6.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getUsaMpaaRatingLock /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    UsaMpaaRatingType _result7 = getUsaMpaaRatingLock();
                    reply.writeNoException();
                    if (_result7 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result7.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getUsaTvRatingLock /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    UsaTvRatingInformation _result8 = getUsaTvRatingLock();
                    reply.writeNoException();
                    if (_result8 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result8.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_resetRRTSetting /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = resetRRTSetting();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setCanadaEngRatingLock /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setCanadaEngRatingLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setCanadaFreRatingLock /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setCanadaFreRatingLock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setUsaMpaaRatingLock /*20*/:
                    UsaMpaaRatingType _arg03;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = (UsaMpaaRatingType) UsaMpaaRatingType.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    _result = setUsaMpaaRatingLock(_arg03);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setUsaTvRatingLock /*21*/:
                    UsaTvRatingInformation _arg04;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = (UsaTvRatingInformation) UsaTvRatingInformation.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    _result = setUsaTvRatingLock(_arg04);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVChipGuideline /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVChipGuideline(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurrentVChipBlockStatus /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurrentVChipBlockStatus();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVChipInputSourceBlockStatus /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getVChipInputSourceBlockStatus(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVChipInputSourceBlockStatus /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    setVChipInputSourceBlockStatus(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getProgramInfo /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getProgramInfo(data.readInt());
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result2.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setDtvAntennaType /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    setDtvAntennaType(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setUsaTvGuideline /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setUsaTvGuideline(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setUsaMpaaGuideline /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result = setUsaMpaaGuideline(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setCanadaEngGuideline /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setCanadaEngGuideline(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setCanadaFreGuideline /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setCanadaFreGuideline(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDynamicGuideline /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setDynamicGuideline(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBlockUnlockUnrated /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getBlockUnlockUnrated();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setBlockUnlockUnrated /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    setBlockUnlockUnrated(_arg02);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getRRT5NoDimension /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getRRT5NoDimension();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getRRT5Dimension /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    List<Regin5DimensionInformation> _result9 = getRRT5Dimension();
                    reply.writeNoException();
                    reply.writeTypedList(_result9);
                    return true;
                case TRANSACTION_setRR5RatingPair /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    setRR5RatingPair(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getRR5RatingPair /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    List<RR5RatingPair> _result10 = getRR5RatingPair(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeTypedList(_result10);
                    return true;
                case TRANSACTION_getBlockSysLockMode /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getBlockSysLockMode();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setBlockSysLockMode /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    setBlockSysLockMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startCc /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startCc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_stopCc /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopCc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_doesCcExist /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = doesCcExist();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setCcMode /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    setCcMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCcMode /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCcMode();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getTSUpdateInfo /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    AtscScanChannelNotify _result11 = getTSUpdateInfo(data.readInt());
                    reply.writeNoException();
                    if (_result11 != null) {
                        reply.writeInt(TRANSACTION_deleteAllMainList);
                        _result11.writeToParcel(reply, TRANSACTION_deleteAllMainList);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_commondCmd /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    commondCmd(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getNtscAntenna /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getNtscAntenna();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setNtscAntenna /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    setNtscAntenna(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_connectDatabase /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    connectDatabase(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_genMixProgList /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result = genMixProgList(_arg02);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAntennaType /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    setAntennaType(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAntennaType /*53*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAntennaType();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setChannel /*54*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    _result3 = setChannel(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_saveAtvProgram /*55*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = saveAtvProgram(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getProgramControl /*56*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getProgramControl(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setManualTuningStart /*57*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setManualTuningStart(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setManualTuningEnd /*58*/:
                    data.enforceInterface(DESCRIPTOR);
                    setManualTuningEnd();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAtvProgramInfo /*59*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAtvProgramInfo(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setAtvProgramInfo /*60*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAtvProgramInfo(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_deleteAllMainList;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_forceVideoStandard /*61*/:
                    data.enforceInterface(DESCRIPTOR);
                    forceVideoStandard(data.readInt());
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

    boolean changeDtvToManualFirstService(int i) throws RemoteException;

    boolean changeProgramList() throws RemoteException;

    void commondCmd(int i, int i2, int i3) throws RemoteException;

    void connectDatabase(int i) throws RemoteException;

    boolean deleteAllMainList() throws RemoteException;

    boolean deleteAtvMainList() throws RemoteException;

    boolean deleteChannelInformationByRf(int i) throws RemoteException;

    boolean deleteDtvMainList() throws RemoteException;

    boolean doesCcExist() throws RemoteException;

    void forceVideoStandard(int i) throws RemoteException;

    boolean genMixProgList(boolean z) throws RemoteException;

    int getAntennaType() throws RemoteException;

    int getAtvProgramInfo(int i, int i2) throws RemoteException;

    int getBlockSysLockMode() throws RemoteException;

    boolean getBlockUnlockUnrated() throws RemoteException;

    int getCanadaEngRatingLock() throws RemoteException;

    int getCanadaFreRatingLock() throws RemoteException;

    int getCcMode() throws RemoteException;

    AtscMainListChannelInformation getCurrentChannelInformation() throws RemoteException;

    ProgramInfo getCurrentProgramInfo() throws RemoteException;

    String getCurrentRatingInformation() throws RemoteException;

    boolean getCurrentVChipBlockStatus() throws RemoteException;

    int getNtscAntenna() throws RemoteException;

    int getProgramControl(int i, int i2, int i3) throws RemoteException;

    ProgramInfo getProgramInfo(int i) throws RemoteException;

    List<RR5RatingPair> getRR5RatingPair(int i, int i2) throws RemoteException;

    List<Regin5DimensionInformation> getRRT5Dimension() throws RemoteException;

    int getRRT5NoDimension() throws RemoteException;

    Region5RatingInformation getRRTInformation() throws RemoteException;

    AtscScanChannelNotify getTSUpdateInfo(int i) throws RemoteException;

    UsaMpaaRatingType getUsaMpaaRatingLock() throws RemoteException;

    UsaTvRatingInformation getUsaTvRatingLock() throws RemoteException;

    boolean getVChipInputSourceBlockStatus(int i) throws RemoteException;

    boolean programSel(int i, int i2) throws RemoteException;

    boolean resetRRTSetting() throws RemoteException;

    boolean saveAtvProgram(int i) throws RemoteException;

    void setAntennaType(int i) throws RemoteException;

    boolean setAtvProgramInfo(int i, int i2, int i3) throws RemoteException;

    void setBlockSysLockMode(int i) throws RemoteException;

    void setBlockUnlockUnrated(boolean z) throws RemoteException;

    boolean setCanadaEngGuideline(int i) throws RemoteException;

    boolean setCanadaEngRatingLock(int i) throws RemoteException;

    boolean setCanadaFreGuideline(int i) throws RemoteException;

    boolean setCanadaFreRatingLock(int i) throws RemoteException;

    void setCcMode(int i) throws RemoteException;

    int setChannel(int i, boolean z) throws RemoteException;

    void setDtvAntennaType(int i) throws RemoteException;

    boolean setDynamicGuideline(int i, int i2, int i3) throws RemoteException;

    void setManualTuningEnd() throws RemoteException;

    boolean setManualTuningStart(int i, int i2, int i3) throws RemoteException;

    void setNtscAntenna(int i) throws RemoteException;

    void setProgramName(int i, int i2, String str) throws RemoteException;

    void setRR5RatingPair(int i, int i2, int i3) throws RemoteException;

    boolean setUsaMpaaGuideline(int i, boolean z) throws RemoteException;

    boolean setUsaMpaaRatingLock(UsaMpaaRatingType usaMpaaRatingType) throws RemoteException;

    boolean setUsaTvGuideline(int i, int i2) throws RemoteException;

    boolean setUsaTvRatingLock(UsaTvRatingInformation usaTvRatingInformation) throws RemoteException;

    boolean setVChipGuideline(int i, int i2, int i3, int i4) throws RemoteException;

    void setVChipInputSourceBlockStatus(int i, boolean z) throws RemoteException;

    boolean startCc() throws RemoteException;

    boolean stopCc() throws RemoteException;
}
