package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.ColorTemperatureExData;
import com.mstar.android.tvapi.common.vo.VideoInfo;
import com.mstar.android.tvapi.common.vo.VideoWindowType;

public interface ITvPicture extends IInterface {

    public static abstract class Stub extends Binder implements ITvPicture {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvPicture";
        static final int TRANSACTION_disableBacklight = 28;
        static final int TRANSACTION_disableDbc = 41;
        static final int TRANSACTION_disableDcc = 38;
        static final int TRANSACTION_disableDlc = 35;
        static final int TRANSACTION_enableBacklight = 27;
        static final int TRANSACTION_enableDbc = 40;
        static final int TRANSACTION_enableDcc = 37;
        static final int TRANSACTION_enableDlc = 34;
        static final int TRANSACTION_execAutoPc = 23;
        static final int TRANSACTION_freezeImage = 24;
        static final int TRANSACTION_getBacklight = 8;
        static final int TRANSACTION_getColorRange = 31;
        static final int TRANSACTION_getColorTempIdx = 10;
        static final int TRANSACTION_getColorTempPara = 12;
        static final int TRANSACTION_getFilmMode = 33;
        static final int TRANSACTION_getNR = 14;
        static final int TRANSACTION_getPCClock = 20;
        static final int TRANSACTION_getPCHPos = 16;
        static final int TRANSACTION_getPCPhase = 22;
        static final int TRANSACTION_getPCVPos = 18;
        static final int TRANSACTION_getPcModeInfo = 50;
        static final int TRANSACTION_getPictureModeIdx = 2;
        static final int TRANSACTION_getReproduceRate = 45;
        static final int TRANSACTION_getResolution = 48;
        static final int TRANSACTION_getVideoArc = 4;
        static final int TRANSACTION_getVideoInfo = 29;
        static final int TRANSACTION_getVideoItem = 6;
        static final int TRANSACTION_getVideoItemByInputSource = 44;
        static final int TRANSACTION_isDbcEnabled = 42;
        static final int TRANSACTION_isDccEnabled = 39;
        static final int TRANSACTION_isDlcEnabled = 36;
        static final int TRANSACTION_setBacklight = 7;
        static final int TRANSACTION_setColorRange = 30;
        static final int TRANSACTION_setColorTempIdx = 9;
        static final int TRANSACTION_setColorTempPara = 11;
        static final int TRANSACTION_setDisplayWindow = 26;
        static final int TRANSACTION_setFilmMode = 32;
        static final int TRANSACTION_setMEMCMode = 49;
        static final int TRANSACTION_setNR = 13;
        static final int TRANSACTION_setPCClock = 19;
        static final int TRANSACTION_setPCHPos = 15;
        static final int TRANSACTION_setPCPhase = 21;
        static final int TRANSACTION_setPCVPos = 17;
        static final int TRANSACTION_setPictureModeIdx = 1;
        static final int TRANSACTION_setReproduceRate = 46;
        static final int TRANSACTION_setResolution = 47;
        static final int TRANSACTION_setVideoArc = 3;
        static final int TRANSACTION_setVideoItem = 5;
        static final int TRANSACTION_setVideoItemByInputSource = 43;
        static final int TRANSACTION_unFreezeImage = 25;

        private static class Proxy implements ITvPicture {
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

            public boolean setPictureModeIdx(int ePicMode) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(ePicMode);
                    this.mRemote.transact(Stub.TRANSACTION_setPictureModeIdx, _data, _reply, 0);
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

            public int getPictureModeIdx() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPictureModeIdx, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVideoArc(int eArcIdx) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eArcIdx);
                    this.mRemote.transact(Stub.TRANSACTION_setVideoArc, _data, _reply, 0);
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

            public int getVideoArc() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVideoArc, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVideoItem(int eIndex, int value) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eIndex);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setVideoItem, _data, _reply, 0);
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

            public int getVideoItem(int eIndex) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eIndex);
                    this.mRemote.transact(Stub.TRANSACTION_getVideoItem, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setBacklight(int value) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(value);
                    this.mRemote.transact(Stub.TRANSACTION_setBacklight, _data, _reply, 0);
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

            public int getBacklight() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBacklight, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setColorTempIdx(int eColorTemp) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eColorTemp);
                    this.mRemote.transact(Stub.TRANSACTION_setColorTempIdx, _data, _reply, 0);
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

            public int getColorTempIdx() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getColorTempIdx, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setColorTempPara(ColorTemperatureExData stColorTemp) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (stColorTemp != null) {
                        _data.writeInt(Stub.TRANSACTION_setPictureModeIdx);
                        stColorTemp.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setColorTempPara, _data, _reply, 0);
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

            public ColorTemperatureExData getColorTempPara() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    ColorTemperatureExData _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getColorTempPara, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (ColorTemperatureExData) ColorTemperatureExData.CREATOR.createFromParcel(_reply);
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

            public boolean setNR(int eNRIdx) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eNRIdx);
                    this.mRemote.transact(Stub.TRANSACTION_setNR, _data, _reply, 0);
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

            public int getNR() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getNR, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPCHPos(int hpos) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hpos);
                    this.mRemote.transact(Stub.TRANSACTION_setPCHPos, _data, _reply, 0);
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

            public int getPCHPos() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPCHPos, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPCVPos(int vpos) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vpos);
                    this.mRemote.transact(Stub.TRANSACTION_setPCVPos, _data, _reply, 0);
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

            public int getPCVPos() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPCVPos, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPCClock(int clock) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(clock);
                    this.mRemote.transact(Stub.TRANSACTION_setPCClock, _data, _reply, 0);
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

            public int getPCClock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPCClock, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPCPhase(int phase) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(phase);
                    this.mRemote.transact(Stub.TRANSACTION_setPCPhase, _data, _reply, 0);
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

            public int getPCPhase() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPCPhase, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean execAutoPc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_execAutoPc, _data, _reply, 0);
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

            public boolean freezeImage() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_freezeImage, _data, _reply, 0);
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

            public boolean unFreezeImage() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_unFreezeImage, _data, _reply, 0);
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

            public void setDisplayWindow(VideoWindowType videoWindowType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (videoWindowType != null) {
                        _data.writeInt(Stub.TRANSACTION_setPictureModeIdx);
                        videoWindowType.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setDisplayWindow, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void enableBacklight() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableBacklight, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void disableBacklight() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableBacklight, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public VideoInfo getVideoInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    VideoInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVideoInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (VideoInfo) VideoInfo.CREATOR.createFromParcel(_reply);
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

            public boolean setColorRange(byte value) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeByte(value);
                    this.mRemote.transact(Stub.TRANSACTION_setColorRange, _data, _reply, 0);
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

            public byte getColorRange() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getColorRange, _data, _reply, 0);
                    _reply.readException();
                    byte _result = _reply.readByte();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setFilmMode(int eMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eMode);
                    this.mRemote.transact(Stub.TRANSACTION_setFilmMode, _data, _reply, 0);
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

            public int getFilmMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getFilmMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean enableDlc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableDlc, _data, _reply, 0);
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

            public boolean disableDlc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableDlc, _data, _reply, 0);
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

            public boolean isDlcEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isDlcEnabled, _data, _reply, 0);
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

            public boolean enableDcc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableDcc, _data, _reply, 0);
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

            public boolean disableDcc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableDcc, _data, _reply, 0);
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

            public boolean isDccEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isDccEnabled, _data, _reply, 0);
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

            public boolean enableDbc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableDbc, _data, _reply, 0);
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

            public boolean disableDbc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_disableDbc, _data, _reply, 0);
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

            public boolean isDbcEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isDbcEnabled, _data, _reply, 0);
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

            public boolean setVideoItemByInputSource(int eIndex, int value, int input) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eIndex);
                    _data.writeInt(value);
                    _data.writeInt(input);
                    this.mRemote.transact(Stub.TRANSACTION_setVideoItemByInputSource, _data, _reply, 0);
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

            public int getVideoItemByInputSource(int eIndex, int input) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eIndex);
                    _data.writeInt(input);
                    this.mRemote.transact(Stub.TRANSACTION_getVideoItemByInputSource, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getReproduceRate() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getReproduceRate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setReproduceRate(int rate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(rate);
                    this.mRemote.transact(Stub.TRANSACTION_setReproduceRate, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setResolution(byte resolution) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeByte(resolution);
                    this.mRemote.transact(Stub.TRANSACTION_setResolution, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public byte getResolution() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getResolution, _data, _reply, 0);
                    _reply.readException();
                    byte _result = _reply.readByte();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setMEMCMode(String interfaceCommand) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(interfaceCommand);
                    this.mRemote.transact(Stub.TRANSACTION_setMEMCMode, _data, _reply, 0);
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

            public int[] getPcModeInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPcModeInfo, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
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

        public static ITvPicture asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvPicture)) {
                return new Proxy(obj);
            }
            return (ITvPicture) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            byte _result3;
            switch (code) {
                case TRANSACTION_setPictureModeIdx /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPictureModeIdx(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPictureModeIdx /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPictureModeIdx();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVideoArc /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVideoArc(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVideoArc /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVideoArc();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVideoItem /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVideoItem(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVideoItem /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVideoItem(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setBacklight /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setBacklight(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getBacklight /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getBacklight();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setColorTempIdx /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setColorTempIdx(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getColorTempIdx /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getColorTempIdx();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setColorTempPara /*11*/:
                    ColorTemperatureExData _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (ColorTemperatureExData) ColorTemperatureExData.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    _result = setColorTempPara(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getColorTempPara /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    ColorTemperatureExData _result4 = getColorTempPara();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_setPictureModeIdx);
                        _result4.writeToParcel(reply, TRANSACTION_setPictureModeIdx);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setNR /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setNR(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getNR /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getNR();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPCHPos /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPCHPos(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPCHPos /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPCHPos();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPCVPos /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPCVPos(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPCVPos /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPCVPos();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPCClock /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPCClock(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPCClock /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPCClock();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPCPhase /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPCPhase(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPCPhase /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPCPhase();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_execAutoPc /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = execAutoPc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_freezeImage /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = freezeImage();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_unFreezeImage /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = unFreezeImage();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDisplayWindow /*26*/:
                    VideoWindowType _arg02;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    setDisplayWindow(_arg02);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_enableBacklight /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    enableBacklight();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_disableBacklight /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    disableBacklight();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getVideoInfo /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    VideoInfo _result5 = getVideoInfo();
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(TRANSACTION_setPictureModeIdx);
                        _result5.writeToParcel(reply, TRANSACTION_setPictureModeIdx);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setColorRange /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setColorRange(data.readByte());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getColorRange /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getColorRange();
                    reply.writeNoException();
                    reply.writeByte(_result3);
                    return true;
                case TRANSACTION_setFilmMode /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setFilmMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getFilmMode /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getFilmMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_enableDlc /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableDlc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disableDlc /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableDlc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isDlcEnabled /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isDlcEnabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enableDcc /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableDcc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disableDcc /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableDcc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isDccEnabled /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isDccEnabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_enableDbc /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableDbc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_disableDbc /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = disableDbc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isDbcEnabled /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isDbcEnabled();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVideoItemByInputSource /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVideoItemByInputSource(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVideoItemByInputSource /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVideoItemByInputSource(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getReproduceRate /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getReproduceRate();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setReproduceRate /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    setReproduceRate(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setResolution /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    setResolution(data.readByte());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getResolution /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getResolution();
                    reply.writeNoException();
                    reply.writeByte(_result3);
                    return true;
                case TRANSACTION_setMEMCMode /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setMEMCMode(data.readString());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setPictureModeIdx;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPcModeInfo /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    int[] _result6 = getPcModeInfo();
                    reply.writeNoException();
                    reply.writeIntArray(_result6);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void disableBacklight() throws RemoteException;

    boolean disableDbc() throws RemoteException;

    boolean disableDcc() throws RemoteException;

    boolean disableDlc() throws RemoteException;

    void enableBacklight() throws RemoteException;

    boolean enableDbc() throws RemoteException;

    boolean enableDcc() throws RemoteException;

    boolean enableDlc() throws RemoteException;

    boolean execAutoPc() throws RemoteException;

    boolean freezeImage() throws RemoteException;

    int getBacklight() throws RemoteException;

    byte getColorRange() throws RemoteException;

    int getColorTempIdx() throws RemoteException;

    ColorTemperatureExData getColorTempPara() throws RemoteException;

    int getFilmMode() throws RemoteException;

    int getNR() throws RemoteException;

    int getPCClock() throws RemoteException;

    int getPCHPos() throws RemoteException;

    int getPCPhase() throws RemoteException;

    int getPCVPos() throws RemoteException;

    int[] getPcModeInfo() throws RemoteException;

    int getPictureModeIdx() throws RemoteException;

    int getReproduceRate() throws RemoteException;

    byte getResolution() throws RemoteException;

    int getVideoArc() throws RemoteException;

    VideoInfo getVideoInfo() throws RemoteException;

    int getVideoItem(int i) throws RemoteException;

    int getVideoItemByInputSource(int i, int i2) throws RemoteException;

    boolean isDbcEnabled() throws RemoteException;

    boolean isDccEnabled() throws RemoteException;

    boolean isDlcEnabled() throws RemoteException;

    boolean setBacklight(int i) throws RemoteException;

    boolean setColorRange(byte b) throws RemoteException;

    boolean setColorTempIdx(int i) throws RemoteException;

    boolean setColorTempPara(ColorTemperatureExData colorTemperatureExData) throws RemoteException;

    void setDisplayWindow(VideoWindowType videoWindowType) throws RemoteException;

    boolean setFilmMode(int i) throws RemoteException;

    boolean setMEMCMode(String str) throws RemoteException;

    boolean setNR(int i) throws RemoteException;

    boolean setPCClock(int i) throws RemoteException;

    boolean setPCHPos(int i) throws RemoteException;

    boolean setPCPhase(int i) throws RemoteException;

    boolean setPCVPos(int i) throws RemoteException;

    boolean setPictureModeIdx(int i) throws RemoteException;

    void setReproduceRate(int i) throws RemoteException;

    void setResolution(byte b) throws RemoteException;

    boolean setVideoArc(int i) throws RemoteException;

    boolean setVideoItem(int i, int i2) throws RemoteException;

    boolean setVideoItemByInputSource(int i, int i2, int i3) throws RemoteException;

    boolean unFreezeImage() throws RemoteException;
}
