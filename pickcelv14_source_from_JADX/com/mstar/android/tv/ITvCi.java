package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvCi extends IInterface {

    public static abstract class Stub extends Binder implements ITvCi {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvCi";
        static final int TRANSACTION_answerEnq = 47;
        static final int TRANSACTION_answerMenu = 48;
        static final int TRANSACTION_backEnq = 46;
        static final int TRANSACTION_backMenu = 4;
        static final int TRANSACTION_ciClearOPSearchSuspended = 27;
        static final int TRANSACTION_close = 42;
        static final int TRANSACTION_deleteOpCacheByCicamId = 31;
        static final int TRANSACTION_deleteOpCacheByIndex = 24;
        static final int TRANSACTION_enterCiOperatorProfile = 17;
        static final int TRANSACTION_enterMenu = 3;
        static final int TRANSACTION_exitCiOperatorProfile = 18;
        static final int TRANSACTION_getCardState = 49;
        static final int TRANSACTION_getCiCredentialValidRange = 51;
        static final int TRANSACTION_getCurrentOpCicamId = 30;
        static final int TRANSACTION_getCurrentOpIndexByCicamId = 33;
        static final int TRANSACTION_getEnqAnsLength = 45;
        static final int TRANSACTION_getEnqBlindAnswer = 14;
        static final int TRANSACTION_getEnqLength = 44;
        static final int TRANSACTION_getEnqString = 37;
        static final int TRANSACTION_getListBottomLength = 43;
        static final int TRANSACTION_getListBottomString = 34;
        static final int TRANSACTION_getListChoiceNumber = 13;
        static final int TRANSACTION_getListSelectionString = 36;
        static final int TRANSACTION_getListSubtitleLength = 16;
        static final int TRANSACTION_getListSubtitleString = 15;
        static final int TRANSACTION_getListTitleLength = 11;
        static final int TRANSACTION_getListTitleString = 10;
        static final int TRANSACTION_getMenuBottomLength = 41;
        static final int TRANSACTION_getMenuBottomString = 9;
        static final int TRANSACTION_getMenuChoiceNumber = 12;
        static final int TRANSACTION_getMenuSelectionString = 35;
        static final int TRANSACTION_getMenuString = 7;
        static final int TRANSACTION_getMenuSubtitleLength = 39;
        static final int TRANSACTION_getMenuSubtitleString = 40;
        static final int TRANSACTION_getMenuTitleLength = 38;
        static final int TRANSACTION_getMenuTitleString = 8;
        static final int TRANSACTION_getMmiType = 6;
        static final int TRANSACTION_getOpCacheCount = 23;
        static final int TRANSACTION_getOpDtvSysTypeByIndex = 22;
        static final int TRANSACTION_getOpIso639LangCodeByCicamId = 29;
        static final int TRANSACTION_getOpProfileNameByIndex = 21;
        static final int TRANSACTION_isCiCredentialModeValid = 2;
        static final int TRANSACTION_isCiMenuOn = 50;
        static final int TRANSACTION_isDataExisted = 5;
        static final int TRANSACTION_isOpMode = 25;
        static final int TRANSACTION_isOpTuning = 19;
        static final int TRANSACTION_resetOPCacheDB = 32;
        static final int TRANSACTION_sendCiOpSearchCancel = 28;
        static final int TRANSACTION_sendCiOpSearchStart = 20;
        static final int TRANSACTION_setCiCredentialMode = 1;
        static final int TRANSACTION_setDebugMode = 52;
        static final int TRANSACTION_updateOpCurrentServiceTripleId = 26;

        private static class Proxy implements ITvCi {
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

            public void setCiCredentialMode(int credentialMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(credentialMode);
                    this.mRemote.transact(Stub.TRANSACTION_setCiCredentialMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isCiCredentialModeValid(int credentialMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(credentialMode);
                    this.mRemote.transact(Stub.TRANSACTION_isCiCredentialModeValid, _data, _reply, 0);
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

            public void enterMenu() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enterMenu, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void backMenu() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_backMenu, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isDataExisted() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isDataExisted, _data, _reply, 0);
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

            public int getMmiType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMmiType, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getMenuString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getMenuTitleString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuTitleString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getMenuBottomString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuBottomString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getListTitleString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListTitleString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getListTitleLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListTitleLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getMenuChoiceNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuChoiceNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getListChoiceNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListChoiceNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getEnqBlindAnswer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEnqBlindAnswer, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getListSubtitleString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListSubtitleString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getListSubtitleLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListSubtitleLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void enterCiOperatorProfile(int Index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Index);
                    this.mRemote.transact(Stub.TRANSACTION_enterCiOperatorProfile, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void exitCiOperatorProfile() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_exitCiOperatorProfile, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isOpTuning() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isOpTuning, _data, _reply, 0);
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

            public boolean sendCiOpSearchStart(boolean bUnattendedFlag) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bUnattendedFlag) {
                        i = Stub.TRANSACTION_setCiCredentialMode;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_sendCiOpSearchStart, _data, _reply, 0);
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

            public String getOpProfileNameByIndex(int Index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Index);
                    this.mRemote.transact(Stub.TRANSACTION_getOpProfileNameByIndex, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getOpDtvSysTypeByIndex(int Index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Index);
                    this.mRemote.transact(Stub.TRANSACTION_getOpDtvSysTypeByIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getOpCacheCount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOpCacheCount, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean deleteOpCacheByIndex(int Index) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(Index);
                    this.mRemote.transact(Stub.TRANSACTION_deleteOpCacheByIndex, _data, _reply, 0);
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

            public boolean isOpMode() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isOpMode, _data, _reply, 0);
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

            public boolean updateOpCurrentServiceTripleId() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_updateOpCurrentServiceTripleId, _data, _reply, 0);
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

            public void ciClearOPSearchSuspended() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_ciClearOPSearchSuspended, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean sendCiOpSearchCancel() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_sendCiOpSearchCancel, _data, _reply, 0);
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

            public int getOpIso639LangCodeByCicamId(int u32CicamId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(u32CicamId);
                    this.mRemote.transact(Stub.TRANSACTION_getOpIso639LangCodeByCicamId, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurrentOpCicamId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentOpCicamId, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean deleteOpCacheByCicamId(int u32CicamId) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(u32CicamId);
                    this.mRemote.transact(Stub.TRANSACTION_deleteOpCacheByCicamId, _data, _reply, 0);
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

            public boolean resetOPCacheDB(boolean bDisableChannel) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bDisableChannel) {
                        i = Stub.TRANSACTION_setCiCredentialMode;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_resetOPCacheDB, _data, _reply, 0);
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

            public int getCurrentOpIndexByCicamId(int u32CicamId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(u32CicamId);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentOpIndexByCicamId, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getListBottomString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListBottomString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getMenuSelectionString(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuSelectionString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getListSelectionString(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getListSelectionString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getEnqString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEnqString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getMenuTitleLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuTitleLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getMenuSubtitleLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuSubtitleLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getMenuSubtitleString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuSubtitleString, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getMenuBottomLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMenuBottomLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void close() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_close, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getListBottomLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getListBottomLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getEnqLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEnqLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getEnqAnsLength() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEnqAnsLength, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean backEnq() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_backEnq, _data, _reply, 0);
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

            public boolean answerEnq(String password) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(password);
                    this.mRemote.transact(Stub.TRANSACTION_answerEnq, _data, _reply, 0);
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

            public void answerMenu(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_answerMenu, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCardState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCardState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isCiMenuOn() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isCiMenuOn, _data, _reply, 0);
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

            public int[] getCiCredentialValidRange() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCiCredentialValidRange, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setDebugMode(boolean mode) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mode) {
                        i = Stub.TRANSACTION_setCiCredentialMode;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setDebugMode, _data, _reply, 0);
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

        public static ITvCi asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvCi)) {
                return new Proxy(obj);
            }
            return (ITvCi) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            String _result3;
            boolean _arg0;
            switch (code) {
                case TRANSACTION_setCiCredentialMode /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    setCiCredentialMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isCiCredentialModeValid /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isCiCredentialModeValid(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enterMenu /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    enterMenu();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_backMenu /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    backMenu();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isDataExisted /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isDataExisted();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getMmiType /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMmiType();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getMenuString /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMenuString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getMenuTitleString /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMenuTitleString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getMenuBottomString /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMenuBottomString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getListTitleString /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getListTitleString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getListTitleLength /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getListTitleLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getMenuChoiceNumber /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMenuChoiceNumber();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getListChoiceNumber /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getListChoiceNumber();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getEnqBlindAnswer /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEnqBlindAnswer();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getListSubtitleString /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getListSubtitleString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getListSubtitleLength /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getListSubtitleLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_enterCiOperatorProfile /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    enterCiOperatorProfile(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_exitCiOperatorProfile /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    exitCiOperatorProfile();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isOpTuning /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isOpTuning();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_sendCiOpSearchStart /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = sendCiOpSearchStart(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOpProfileNameByIndex /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getOpProfileNameByIndex(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getOpDtvSysTypeByIndex /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOpDtvSysTypeByIndex(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getOpCacheCount /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOpCacheCount();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_deleteOpCacheByIndex /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteOpCacheByIndex(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isOpMode /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isOpMode();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_updateOpCurrentServiceTripleId /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = updateOpCurrentServiceTripleId();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_ciClearOPSearchSuspended /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    ciClearOPSearchSuspended();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_sendCiOpSearchCancel /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = sendCiOpSearchCancel();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOpIso639LangCodeByCicamId /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOpIso639LangCodeByCicamId(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getCurrentOpCicamId /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentOpCicamId();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_deleteOpCacheByCicamId /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = deleteOpCacheByCicamId(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_resetOPCacheDB /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = resetOPCacheDB(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurrentOpIndexByCicamId /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentOpIndexByCicamId(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getListBottomString /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getListBottomString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getMenuSelectionString /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMenuSelectionString(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getListSelectionString /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getListSelectionString(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getEnqString /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getEnqString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getMenuTitleLength /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMenuTitleLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getMenuSubtitleLength /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMenuSubtitleLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getMenuSubtitleString /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getMenuSubtitleString();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getMenuBottomLength /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMenuBottomLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_close /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    close();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getListBottomLength /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getListBottomLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getEnqLength /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEnqLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getEnqAnsLength /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getEnqAnsLength();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_backEnq /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = backEnq();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_answerEnq /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = answerEnq(data.readString());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_answerMenu /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    answerMenu(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCardState /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCardState();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_isCiMenuOn /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isCiMenuOn();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setCiCredentialMode;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCiCredentialValidRange /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    int[] _result4 = getCiCredentialValidRange();
                    reply.writeNoException();
                    reply.writeIntArray(_result4);
                    return true;
                case TRANSACTION_setDebugMode /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setDebugMode(_arg0);
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

    boolean answerEnq(String str) throws RemoteException;

    void answerMenu(int i) throws RemoteException;

    boolean backEnq() throws RemoteException;

    void backMenu() throws RemoteException;

    void ciClearOPSearchSuspended() throws RemoteException;

    void close() throws RemoteException;

    boolean deleteOpCacheByCicamId(int i) throws RemoteException;

    boolean deleteOpCacheByIndex(int i) throws RemoteException;

    void enterCiOperatorProfile(int i) throws RemoteException;

    void enterMenu() throws RemoteException;

    void exitCiOperatorProfile() throws RemoteException;

    int getCardState() throws RemoteException;

    int[] getCiCredentialValidRange() throws RemoteException;

    int getCurrentOpCicamId() throws RemoteException;

    int getCurrentOpIndexByCicamId(int i) throws RemoteException;

    int getEnqAnsLength() throws RemoteException;

    int getEnqBlindAnswer() throws RemoteException;

    int getEnqLength() throws RemoteException;

    String getEnqString() throws RemoteException;

    int getListBottomLength() throws RemoteException;

    String getListBottomString() throws RemoteException;

    int getListChoiceNumber() throws RemoteException;

    String getListSelectionString(int i) throws RemoteException;

    int getListSubtitleLength() throws RemoteException;

    String getListSubtitleString() throws RemoteException;

    int getListTitleLength() throws RemoteException;

    String getListTitleString() throws RemoteException;

    int getMenuBottomLength() throws RemoteException;

    String getMenuBottomString() throws RemoteException;

    int getMenuChoiceNumber() throws RemoteException;

    String getMenuSelectionString(int i) throws RemoteException;

    String getMenuString() throws RemoteException;

    int getMenuSubtitleLength() throws RemoteException;

    String getMenuSubtitleString() throws RemoteException;

    int getMenuTitleLength() throws RemoteException;

    String getMenuTitleString() throws RemoteException;

    int getMmiType() throws RemoteException;

    int getOpCacheCount() throws RemoteException;

    int getOpDtvSysTypeByIndex(int i) throws RemoteException;

    int getOpIso639LangCodeByCicamId(int i) throws RemoteException;

    String getOpProfileNameByIndex(int i) throws RemoteException;

    boolean isCiCredentialModeValid(int i) throws RemoteException;

    boolean isCiMenuOn() throws RemoteException;

    boolean isDataExisted() throws RemoteException;

    boolean isOpMode() throws RemoteException;

    boolean isOpTuning() throws RemoteException;

    boolean resetOPCacheDB(boolean z) throws RemoteException;

    boolean sendCiOpSearchCancel() throws RemoteException;

    boolean sendCiOpSearchStart(boolean z) throws RemoteException;

    void setCiCredentialMode(int i) throws RemoteException;

    void setDebugMode(boolean z) throws RemoteException;

    boolean updateOpCurrentServiceTripleId() throws RemoteException;
}
