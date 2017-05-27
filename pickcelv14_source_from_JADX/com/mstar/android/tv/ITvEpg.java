package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.PresentFollowingEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscEpgEventInfo;
import com.mstar.android.tvapi.dtv.atsc.vo.AtscProgramInfo;
import com.mstar.android.tvapi.dtv.vo.DtvEitInfo;
import com.mstar.android.tvapi.dtv.vo.EpgEventInfo;
import com.mstar.android.tvapi.dtv.vo.EpgFirstMatchHdCast;
import java.util.List;

public interface ITvEpg extends IInterface {

    public static abstract class Stub extends Binder implements ITvEpg {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvEpg";
        static final int TRANSACTION_addingEpgPriority = 3;
        static final int TRANSACTION_beginToGetEventInformation = 8;
        static final int TRANSACTION_disableEpgBarkerChannel = 18;
        static final int TRANSACTION_enableEpgBarkerChannel = 17;
        static final int TRANSACTION_endToGetEventInformation = 9;
        static final int TRANSACTION_getEitInfo = 13;
        static final int TRANSACTION_getEpgEventOffsetTime = 12;
        static final int TRANSACTION_getEvent1stMatchHdBroadcast = 7;
        static final int TRANSACTION_getEventCount = 5;
        static final int TRANSACTION_getEventDescriptor = 15;
        static final int TRANSACTION_getEventExtendInfoByTime = 2;
        static final int TRANSACTION_getEventInfo = 14;
        static final int TRANSACTION_getEventInfoByTime = 1;
        static final int TRANSACTION_getFirstEventInformation = 10;
        static final int TRANSACTION_getIsdbEventCount = 6;
        static final int TRANSACTION_getNextEventInformation = 11;
        static final int TRANSACTION_getPresentFollowingEventInfo = 16;
        static final int TRANSACTION_resetEPGProgPriority = 4;

        private static class Proxy implements ITvEpg {
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

            public AtscEpgEventInfo getEventInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscEpgEventInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(majorNumber);
                    _data.writeInt(minorNumber);
                    _data.writeInt(serviceNumber);
                    _data.writeInt(programId);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getEventInfoByTime, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscEpgEventInfo) AtscEpgEventInfo.CREATOR.createFromParcel(_reply);
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

            public AtscEpgEventInfo getEventExtendInfoByTime(int majorNumber, int minorNumber, int serviceNumber, int programId, long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscEpgEventInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(majorNumber);
                    _data.writeInt(minorNumber);
                    _data.writeInt(serviceNumber);
                    _data.writeInt(programId);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getEventExtendInfoByTime, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscEpgEventInfo) AtscEpgEventInfo.CREATOR.createFromParcel(_reply);
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

            public void addingEpgPriority(AtscProgramInfo programInfo, int addingPriority) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (programInfo != null) {
                        _data.writeInt(Stub.TRANSACTION_getEventInfoByTime);
                        programInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(addingPriority);
                    this.mRemote.transact(Stub.TRANSACTION_addingEpgPriority, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean resetEPGProgPriority() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resetEPGProgPriority, _data, _reply, 0);
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

            public int getEventCount(int majorNumber, int minorNumber, int serviceNumber, int programId, long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(majorNumber);
                    _data.writeInt(minorNumber);
                    _data.writeInt(serviceNumber);
                    _data.writeInt(programId);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getEventCount, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getIsdbEventCount(int serviceType, int serviceNo, long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceType);
                    _data.writeInt(serviceNo);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getIsdbEventCount, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public EpgFirstMatchHdCast getEvent1stMatchHdBroadcast(int serviceType, int serviceNo, long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    EpgFirstMatchHdCast _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceType);
                    _data.writeInt(serviceNo);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getEvent1stMatchHdBroadcast, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (EpgFirstMatchHdCast) EpgFirstMatchHdCast.CREATOR.createFromParcel(_reply);
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

            public boolean beginToGetEventInformation(int serviceNumber, int majorNumber, int minorNumber, int programId) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceNumber);
                    _data.writeInt(majorNumber);
                    _data.writeInt(minorNumber);
                    _data.writeInt(programId);
                    this.mRemote.transact(Stub.TRANSACTION_beginToGetEventInformation, _data, _reply, 0);
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

            public void endToGetEventInformation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_endToGetEventInformation, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public AtscEpgEventInfo getFirstEventInformation(long baseTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscEpgEventInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(baseTime);
                    this.mRemote.transact(Stub.TRANSACTION_getFirstEventInformation, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscEpgEventInfo) AtscEpgEventInfo.CREATOR.createFromParcel(_reply);
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

            public AtscEpgEventInfo getNextEventInformation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    AtscEpgEventInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getNextEventInformation, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (AtscEpgEventInfo) AtscEpgEventInfo.CREATOR.createFromParcel(_reply);
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

            public int getEpgEventOffsetTime(long utcTime, boolean isStartTime) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(utcTime);
                    if (isStartTime) {
                        i = Stub.TRANSACTION_getEventInfoByTime;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getEpgEventOffsetTime, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public DtvEitInfo getEitInfo(boolean bPresent) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    DtvEitInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bPresent) {
                        i = Stub.TRANSACTION_getEventInfoByTime;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getEitInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (DtvEitInfo) DtvEitInfo.CREATOR.createFromParcel(_reply);
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

            public List<EpgEventInfo> getEventInfo(int serviceType, int serviceNo, long baseTime, int maxEventInfoCount) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceType);
                    _data.writeInt(serviceNo);
                    _data.writeLong(baseTime);
                    _data.writeInt(maxEventInfoCount);
                    this.mRemote.transact(Stub.TRANSACTION_getEventInfo, _data, _reply, 0);
                    _reply.readException();
                    List<EpgEventInfo> _result = _reply.createTypedArrayList(EpgEventInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getEventDescriptor(int serviceType, int serviceNumber, long baseTime, int epgDescriptionType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceType);
                    _data.writeInt(serviceNumber);
                    _data.writeLong(baseTime);
                    _data.writeInt(epgDescriptionType);
                    this.mRemote.transact(Stub.TRANSACTION_getEventDescriptor, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public PresentFollowingEventInfo getPresentFollowingEventInfo(int serviceType, int serviceNo, boolean present, int descriptionType) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    PresentFollowingEventInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(serviceType);
                    _data.writeInt(serviceNo);
                    if (present) {
                        i = Stub.TRANSACTION_getEventInfoByTime;
                    }
                    _data.writeInt(i);
                    _data.writeInt(descriptionType);
                    this.mRemote.transact(Stub.TRANSACTION_getPresentFollowingEventInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (PresentFollowingEventInfo) PresentFollowingEventInfo.CREATOR.createFromParcel(_reply);
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

            public boolean enableEpgBarkerChannel() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableEpgBarkerChannel, _data, _reply, 0);
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

            public boolean disableEpgBarkerChannel() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableEpgBarkerChannel, _data, _reply, 0);
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

        public static ITvEpg asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvEpg)) {
                return new Proxy(obj);
            }
            return (ITvEpg) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AtscEpgEventInfo _result;
            boolean _result2;
            int _result3;
            switch (code) {
                case TRANSACTION_getEventInfoByTime /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getEventInfoByTime(data.readInt(), data.readInt(), data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_getEventExtendInfoByTime /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getEventExtendInfoByTime(data.readInt(), data.readInt(), data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_addingEpgPriority /*3*/:
                    AtscProgramInfo _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (AtscProgramInfo) AtscProgramInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    addingEpgPriority(_arg0, data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_resetEPGProgPriority /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = resetEPGProgPriority();
                    reply.writeNoException();
                    reply.writeInt(_result2 ? TRANSACTION_getEventInfoByTime : 0);
                    return true;
                case TRANSACTION_getEventCount /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getEventCount(data.readInt(), data.readInt(), data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getIsdbEventCount /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getIsdbEventCount(data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getEvent1stMatchHdBroadcast /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    EpgFirstMatchHdCast _result4 = getEvent1stMatchHdBroadcast(data.readInt(), data.readInt(), data.readLong());
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result4.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_beginToGetEventInformation /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = beginToGetEventInformation(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2 ? TRANSACTION_getEventInfoByTime : 0);
                    return true;
                case TRANSACTION_endToGetEventInformation /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    endToGetEventInformation();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getFirstEventInformation /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getFirstEventInformation(data.readLong());
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_getNextEventInformation /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getNextEventInformation();
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_getEpgEventOffsetTime /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getEpgEventOffsetTime(data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case TRANSACTION_getEitInfo /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    DtvEitInfo _result5 = getEitInfo(data.readInt() != 0);
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result5.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_getEventInfo /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    List<EpgEventInfo> _result6 = getEventInfo(data.readInt(), data.readInt(), data.readLong(), data.readInt());
                    reply.writeNoException();
                    reply.writeTypedList(_result6);
                    return true;
                case TRANSACTION_getEventDescriptor /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    String _result7 = getEventDescriptor(data.readInt(), data.readInt(), data.readLong(), data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result7);
                    return true;
                case TRANSACTION_getPresentFollowingEventInfo /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    PresentFollowingEventInfo _result8 = getPresentFollowingEventInfo(data.readInt(), data.readInt(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    if (_result8 != null) {
                        reply.writeInt(TRANSACTION_getEventInfoByTime);
                        _result8.writeToParcel(reply, TRANSACTION_getEventInfoByTime);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case TRANSACTION_enableEpgBarkerChannel /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = enableEpgBarkerChannel();
                    reply.writeNoException();
                    reply.writeInt(_result2 ? TRANSACTION_getEventInfoByTime : 0);
                    return true;
                case TRANSACTION_disableEpgBarkerChannel /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = disableEpgBarkerChannel();
                    reply.writeNoException();
                    reply.writeInt(_result2 ? TRANSACTION_getEventInfoByTime : 0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void addingEpgPriority(AtscProgramInfo atscProgramInfo, int i) throws RemoteException;

    boolean beginToGetEventInformation(int i, int i2, int i3, int i4) throws RemoteException;

    boolean disableEpgBarkerChannel() throws RemoteException;

    boolean enableEpgBarkerChannel() throws RemoteException;

    void endToGetEventInformation() throws RemoteException;

    DtvEitInfo getEitInfo(boolean z) throws RemoteException;

    int getEpgEventOffsetTime(long j, boolean z) throws RemoteException;

    EpgFirstMatchHdCast getEvent1stMatchHdBroadcast(int i, int i2, long j) throws RemoteException;

    int getEventCount(int i, int i2, int i3, int i4, long j) throws RemoteException;

    String getEventDescriptor(int i, int i2, long j, int i3) throws RemoteException;

    AtscEpgEventInfo getEventExtendInfoByTime(int i, int i2, int i3, int i4, long j) throws RemoteException;

    List<EpgEventInfo> getEventInfo(int i, int i2, long j, int i3) throws RemoteException;

    AtscEpgEventInfo getEventInfoByTime(int i, int i2, int i3, int i4, long j) throws RemoteException;

    AtscEpgEventInfo getFirstEventInformation(long j) throws RemoteException;

    int getIsdbEventCount(int i, int i2, long j) throws RemoteException;

    AtscEpgEventInfo getNextEventInformation() throws RemoteException;

    PresentFollowingEventInfo getPresentFollowingEventInfo(int i, int i2, boolean z, int i3) throws RemoteException;

    boolean resetEPGProgPriority() throws RemoteException;
}
