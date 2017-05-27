package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.EpgEventTimerInfo;
import com.mstar.android.tvapi.common.vo.OnTimeTvDescriptor;
import com.mstar.android.tvapi.common.vo.StandardTime;

public interface ITvTimer extends IInterface {

    public static abstract class Stub extends Binder implements ITvTimer {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvTimer";
        static final int TRANSACTION_addEpgEvent = 24;
        static final int TRANSACTION_cancelEpgTimerEvent = 28;
        static final int TRANSACTION_delAllEpgEvent = 27;
        static final int TRANSACTION_delEpgEvent = 25;
        static final int TRANSACTION_getClockOffset = 17;
        static final int TRANSACTION_getCurTimer = 1;
        static final int TRANSACTION_getDaylightSavingState = 21;
        static final int TRANSACTION_getEpgTimerEventByIndex = 22;
        static final int TRANSACTION_getEpgTimerEventCount = 23;
        static final int TRANSACTION_getEpgTimerRecordingProgram = 29;
        static final int TRANSACTION_getOffTimer = 9;
        static final int TRANSACTION_getOnTimeEvent = 5;
        static final int TRANSACTION_getOnTimer = 3;
        static final int TRANSACTION_getRtcClock = 16;
        static final int TRANSACTION_getSleepMode = 13;
        static final int TRANSACTION_getTimeZone = 14;
        static final int TRANSACTION_isEpgScheduleRecordRemiderExist = 26;
        static final int TRANSACTION_isEpgTimerSettingValid = 30;
        static final int TRANSACTION_isOffTimerEnable = 11;
        static final int TRANSACTION_isOnTimerEnable = 7;
        static final int TRANSACTION_setAutoSync = 19;
        static final int TRANSACTION_setClkTime = 18;
        static final int TRANSACTION_setDaylightSavingState = 20;
        static final int TRANSACTION_setOffTimer = 8;
        static final int TRANSACTION_setOffTimerEnable = 10;
        static final int TRANSACTION_setOnTimeEvent = 4;
        static final int TRANSACTION_setOnTimer = 2;
        static final int TRANSACTION_setOnTimerEnable = 6;
        static final int TRANSACTION_setSleepMode = 12;
        static final int TRANSACTION_setTimeZone = 15;

        private static class Proxy implements ITvTimer {
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

            public StandardTime getCurTimer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    StandardTime _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurTimer, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (StandardTime) StandardTime.CREATOR.createFromParcel(_reply);
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

            public boolean setOnTimer(StandardTime time) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (time != null) {
                        _data.writeInt(Stub.TRANSACTION_getCurTimer);
                        time.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setOnTimer, _data, _reply, 0);
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

            public StandardTime getOnTimer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    StandardTime _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOnTimer, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (StandardTime) StandardTime.CREATOR.createFromParcel(_reply);
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

            public boolean setOnTimeEvent(OnTimeTvDescriptor stEvent) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (stEvent != null) {
                        _data.writeInt(Stub.TRANSACTION_getCurTimer);
                        stEvent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setOnTimeEvent, _data, _reply, 0);
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

            public OnTimeTvDescriptor getOnTimeEvent() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    OnTimeTvDescriptor _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOnTimeEvent, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (OnTimeTvDescriptor) OnTimeTvDescriptor.CREATOR.createFromParcel(_reply);
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

            public boolean setOnTimerEnable(boolean bEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bEnable) {
                        i = Stub.TRANSACTION_getCurTimer;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setOnTimerEnable, _data, _reply, 0);
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

            public boolean isOnTimerEnable() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isOnTimerEnable, _data, _reply, 0);
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

            public boolean setOffTimer(StandardTime time) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (time != null) {
                        _data.writeInt(Stub.TRANSACTION_getCurTimer);
                        time.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setOffTimer, _data, _reply, 0);
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

            public StandardTime getOffTimer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    StandardTime _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOffTimer, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (StandardTime) StandardTime.CREATOR.createFromParcel(_reply);
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

            public boolean setOffTimerEnable(boolean bEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bEnable) {
                        i = Stub.TRANSACTION_getCurTimer;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setOffTimerEnable, _data, _reply, 0);
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

            public boolean isOffTimerEnable() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isOffTimerEnable, _data, _reply, 0);
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

            public boolean setSleepMode(int eMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMode);
                    this.mRemote.transact(Stub.TRANSACTION_setSleepMode, _data, _reply, 0);
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

            public int getSleepMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSleepMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getTimeZone() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTimeZone, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setTimeZone(int zone, boolean isSaved) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(zone);
                    if (isSaved) {
                        i = Stub.TRANSACTION_getCurTimer;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setTimeZone, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getRtcClock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRtcClock, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getClockOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getClockOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setClkTime(long time, boolean isSave) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(time);
                    if (isSave) {
                        i = Stub.TRANSACTION_getCurTimer;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setClkTime, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAutoSync(boolean bSync) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bSync) {
                        i = Stub.TRANSACTION_getCurTimer;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setAutoSync, _data, _reply, 0);
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

            public void setDaylightSavingState(boolean flag) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (flag) {
                        i = Stub.TRANSACTION_getCurTimer;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setDaylightSavingState, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean getDaylightSavingState() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDaylightSavingState, _data, _reply, 0);
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

            public EpgEventTimerInfo getEpgTimerEventByIndex(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    EpgEventTimerInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getEpgTimerEventByIndex, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (EpgEventTimerInfo) EpgEventTimerInfo.CREATOR.createFromParcel(_reply);
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

            public int getEpgTimerEventCount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEpgTimerEventCount, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int addEpgEvent(EpgEventTimerInfo vo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vo != null) {
                        _data.writeInt(Stub.TRANSACTION_getCurTimer);
                        vo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_addEpgEvent, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean delEpgEvent(int epgEvent) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(epgEvent);
                    this.mRemote.transact(Stub.TRANSACTION_delEpgEvent, _data, _reply, 0);
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

            public boolean isEpgScheduleRecordRemiderExist(int secondsFromNow) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(secondsFromNow);
                    this.mRemote.transact(Stub.TRANSACTION_isEpgScheduleRecordRemiderExist, _data, _reply, 0);
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

            public boolean delAllEpgEvent() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_delAllEpgEvent, _data, _reply, 0);
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

            public void cancelEpgTimerEvent(int timeActing, boolean checkEndTime) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(timeActing);
                    if (checkEndTime) {
                        i = Stub.TRANSACTION_getCurTimer;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_cancelEpgTimerEvent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public EpgEventTimerInfo getEpgTimerRecordingProgram() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    EpgEventTimerInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEpgTimerRecordingProgram, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (EpgEventTimerInfo) EpgEventTimerInfo.CREATOR.createFromParcel(_reply);
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

            public int isEpgTimerSettingValid(EpgEventTimerInfo timerInfoVo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (timerInfoVo != null) {
                        _data.writeInt(Stub.TRANSACTION_getCurTimer);
                        timerInfoVo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_isEpgTimerSettingValid, _data, _reply, 0);
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

        public static ITvTimer asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvTimer)) {
                return new Proxy(obj);
            }
            return (ITvTimer) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            StandardTime _result;
            StandardTime _arg0;
            boolean _result2;
            boolean _arg02;
            int _result3;
            int _arg03;
            boolean _arg1;
            EpgEventTimerInfo _result4;
            EpgEventTimerInfo _arg04;
            switch (code) {
                case TRANSACTION_getCurTimer /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurTimer();
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setOnTimer /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (StandardTime) StandardTime.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    _result2 = setOnTimer(_arg0);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOnTimer /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getOnTimer();
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setOnTimeEvent /*4*/:
                    OnTimeTvDescriptor _arg05;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg05 = (OnTimeTvDescriptor) OnTimeTvDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg05 = null;
                    }
                    _result2 = setOnTimeEvent(_arg05);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOnTimeEvent /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    OnTimeTvDescriptor _result5 = getOnTimeEvent();
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result5.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setOnTimerEnable /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result2 = setOnTimerEnable(_arg02);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isOnTimerEnable /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isOnTimerEnable();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setOffTimer /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (StandardTime) StandardTime.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    _result2 = setOffTimer(_arg0);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOffTimer /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getOffTimer();
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setOffTimerEnable /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result2 = setOffTimerEnable(_arg02);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isOffTimerEnable /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isOffTimerEnable();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setSleepMode /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setSleepMode(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getSleepMode /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getSleepMode();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getTimeZone /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getTimeZone();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setTimeZone /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg03 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    setTimeZone(_arg03, _arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getRtcClock /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getRtcClock();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getClockOffset /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getClockOffset();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_setClkTime /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg06 = data.readLong();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    setClkTime(_arg06, _arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setAutoSync /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    _result2 = setAutoSync(_arg02);
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDaylightSavingState /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = true;
                    } else {
                        _arg02 = false;
                    }
                    setDaylightSavingState(_arg02);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getDaylightSavingState /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDaylightSavingState();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getEpgTimerEventByIndex /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getEpgTimerEventByIndex(data.readInt());
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result4.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getEpgTimerEventCount /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getEpgTimerEventCount();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_addEpgEvent /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = (EpgEventTimerInfo) EpgEventTimerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    _result3 = addEpgEvent(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_delEpgEvent /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = delEpgEvent(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isEpgScheduleRecordRemiderExist /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isEpgScheduleRecordRemiderExist(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_delAllEpgEvent /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = delAllEpgEvent();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_getCurTimer;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_cancelEpgTimerEvent /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    _arg03 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg1 = true;
                    } else {
                        _arg1 = false;
                    }
                    cancelEpgTimerEvent(_arg03, _arg1);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getEpgTimerRecordingProgram /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getEpgTimerRecordingProgram();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_getCurTimer);
                        _result4.writeToParcel(reply, TRANSACTION_getCurTimer);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_isEpgTimerSettingValid /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = (EpgEventTimerInfo) EpgEventTimerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    _result3 = isEpgTimerSettingValid(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    int addEpgEvent(EpgEventTimerInfo epgEventTimerInfo) throws RemoteException;

    void cancelEpgTimerEvent(int i, boolean z) throws RemoteException;

    boolean delAllEpgEvent() throws RemoteException;

    boolean delEpgEvent(int i) throws RemoteException;

    int getClockOffset() throws RemoteException;

    StandardTime getCurTimer() throws RemoteException;

    boolean getDaylightSavingState() throws RemoteException;

    EpgEventTimerInfo getEpgTimerEventByIndex(int i) throws RemoteException;

    int getEpgTimerEventCount() throws RemoteException;

    EpgEventTimerInfo getEpgTimerRecordingProgram() throws RemoteException;

    StandardTime getOffTimer() throws RemoteException;

    OnTimeTvDescriptor getOnTimeEvent() throws RemoteException;

    StandardTime getOnTimer() throws RemoteException;

    int getRtcClock() throws RemoteException;

    int getSleepMode() throws RemoteException;

    int getTimeZone() throws RemoteException;

    boolean isEpgScheduleRecordRemiderExist(int i) throws RemoteException;

    int isEpgTimerSettingValid(EpgEventTimerInfo epgEventTimerInfo) throws RemoteException;

    boolean isOffTimerEnable() throws RemoteException;

    boolean isOnTimerEnable() throws RemoteException;

    boolean setAutoSync(boolean z) throws RemoteException;

    void setClkTime(long j, boolean z) throws RemoteException;

    void setDaylightSavingState(boolean z) throws RemoteException;

    boolean setOffTimer(StandardTime standardTime) throws RemoteException;

    boolean setOffTimerEnable(boolean z) throws RemoteException;

    boolean setOnTimeEvent(OnTimeTvDescriptor onTimeTvDescriptor) throws RemoteException;

    boolean setOnTimer(StandardTime standardTime) throws RemoteException;

    boolean setOnTimerEnable(boolean z) throws RemoteException;

    boolean setSleepMode(int i) throws RemoteException;

    void setTimeZone(int i, boolean z) throws RemoteException;
}
