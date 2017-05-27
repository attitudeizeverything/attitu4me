package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.CaptureThumbnailResult;
import com.mstar.android.tvapi.common.vo.PvrFileInfo;
import com.mstar.android.tvapi.common.vo.VideoWindowType;

public interface ITvPvr extends IInterface {

    public static abstract class Stub extends Binder implements ITvPvr {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvPvr";
        static final int TRANSACTION_assignThumbnailFileInfoHandler = 53;
        static final int TRANSACTION_captureThumbnail = 43;
        static final int TRANSACTION_changeDevice = 57;
        static final int TRANSACTION_checkUsbSpeed = 44;
        static final int TRANSACTION_clearMetadata = 64;
        static final int TRANSACTION_createMetadata = 63;
        static final int TRANSACTION_deletefile = 66;
        static final int TRANSACTION_getCurPlaybackTimeInSecond = 39;
        static final int TRANSACTION_getCurPlaybackingFileName = 38;
        static final int TRANSACTION_getCurRecordTimeInSecond = 40;
        static final int TRANSACTION_getCurRecordingFileName = 37;
        static final int TRANSACTION_getFileEventName = 52;
        static final int TRANSACTION_getFileLcn = 50;
        static final int TRANSACTION_getFileServiceName = 51;
        static final int TRANSACTION_getMetadataSortKey = 60;
        static final int TRANSACTION_getPlaybackSpeed = 23;
        static final int TRANSACTION_getPvrFileInfo = 49;
        static final int TRANSACTION_getPvrFileNumber = 48;
        static final int TRANSACTION_getPvrMountPath = 65;
        static final int TRANSACTION_getRecordedFileDurationTime = 59;
        static final int TRANSACTION_getThumbnailDisplay = 56;
        static final int TRANSACTION_getThumbnailNumber = 54;
        static final int TRANSACTION_getThumbnailPath = 55;
        static final int TRANSACTION_getUsbDeviceIndex = 47;
        static final int TRANSACTION_getUsbDeviceNumber = 46;
        static final int TRANSACTION_getUsbPartitionNumber = 45;
        static final int TRANSACTION_isAlwaysTimeShift = 15;
        static final int TRANSACTION_isAlwaysTimeShiftPlaybackPaused = 11;
        static final int TRANSACTION_isAlwaysTimeShiftRecording = 12;
        static final int TRANSACTION_isPlaybackPaused = 34;
        static final int TRANSACTION_isPlaybacking = 32;
        static final int TRANSACTION_isRecordPaused = 35;
        static final int TRANSACTION_isRecording = 31;
        static final int TRANSACTION_isTimeShiftRecording = 33;
        static final int TRANSACTION_jumpPlaybackTime = 24;
        static final int TRANSACTION_jumpToThumbnail = 41;
        static final int TRANSACTION_pauseAlwaysTimeShiftPlayback = 10;
        static final int TRANSACTION_pauseAlwaysTimeShiftRecord = 7;
        static final int TRANSACTION_pausePlayback = 16;
        static final int TRANSACTION_pauseRecord = 3;
        static final int TRANSACTION_resumePlayback = 17;
        static final int TRANSACTION_resumeRecord = 4;
        static final int TRANSACTION_setAlwaysTimeShift = 14;
        static final int TRANSACTION_setMetadataSortAscending = 62;
        static final int TRANSACTION_setMetadataSortKey = 61;
        static final int TRANSACTION_setPlaybackSpeed = 22;
        static final int TRANSACTION_setPlaybackWindow = 36;
        static final int TRANSACTION_setPvrParams = 58;
        static final int TRANSACTION_setTimeShiftFileSize = 42;
        static final int TRANSACTION_startAlwaysTimeShiftPlayback = 8;
        static final int TRANSACTION_startAlwaysTimeShiftRecord = 5;
        static final int TRANSACTION_startPlayback = 13;
        static final int TRANSACTION_startPlaybackLoop = 20;
        static final int TRANSACTION_startRecord = 1;
        static final int TRANSACTION_startTimeShiftPlayback = 27;
        static final int TRANSACTION_startTimeShiftRecord = 25;
        static final int TRANSACTION_stepInPlayback = 19;
        static final int TRANSACTION_stopAlwaysTimeShiftPlayback = 9;
        static final int TRANSACTION_stopAlwaysTimeShiftRecord = 6;
        static final int TRANSACTION_stopPlayback = 18;
        static final int TRANSACTION_stopPlaybackLoop = 21;
        static final int TRANSACTION_stopPvr = 30;
        static final int TRANSACTION_stopRecord = 2;
        static final int TRANSACTION_stopTimeShift = 29;
        static final int TRANSACTION_stopTimeShiftPlayback = 28;
        static final int TRANSACTION_stopTimeShiftRecord = 26;

        private static class Proxy implements ITvPvr {
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

            public int startRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startRecord, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopRecord, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void pauseRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pauseRecord, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void resumeRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resumeRecord, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int startAlwaysTimeShiftRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startAlwaysTimeShiftRecord, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int stopAlwaysTimeShiftRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAlwaysTimeShiftRecord, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int pauseAlwaysTimeShiftRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pauseAlwaysTimeShiftRecord, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int startAlwaysTimeShiftPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startAlwaysTimeShiftPlayback, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopAlwaysTimeShiftPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAlwaysTimeShiftPlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int pauseAlwaysTimeShiftPlayback(boolean ready) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ready) {
                        i = Stub.TRANSACTION_startRecord;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_pauseAlwaysTimeShiftPlayback, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isAlwaysTimeShiftPlaybackPaused() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isAlwaysTimeShiftPlaybackPaused, _data, _reply, 0);
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

            public boolean isAlwaysTimeShiftRecording() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isAlwaysTimeShiftRecording, _data, _reply, 0);
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

            public int startPlayback(String fileName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(fileName);
                    this.mRemote.transact(Stub.TRANSACTION_startPlayback, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setAlwaysTimeShift(boolean open) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (open) {
                        i = Stub.TRANSACTION_startRecord;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setAlwaysTimeShift, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isAlwaysTimeShift() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isAlwaysTimeShift, _data, _reply, 0);
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

            public void pausePlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_pausePlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void resumePlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_resumePlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopPlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stepInPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stepInPlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void startPlaybackLoop(int abLoopBeginTime, int abLoopEndTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(abLoopBeginTime);
                    _data.writeInt(abLoopEndTime);
                    this.mRemote.transact(Stub.TRANSACTION_startPlaybackLoop, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopPlaybackLoop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopPlaybackLoop, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPlaybackSpeed(int playbackSpeed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(playbackSpeed);
                    this.mRemote.transact(Stub.TRANSACTION_setPlaybackSpeed, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getPlaybackSpeed() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPlaybackSpeed, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean jumpPlaybackTime(int jumpToTimeInSeconds) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(jumpToTimeInSeconds);
                    this.mRemote.transact(Stub.TRANSACTION_jumpPlaybackTime, _data, _reply, 0);
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

            public int startTimeShiftRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startTimeShiftRecord, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopTimeShiftRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopTimeShiftRecord, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int startTimeShiftPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startTimeShiftPlayback, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopTimeShiftPlayback() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopTimeShiftPlayback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stopTimeShift() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopTimeShift, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean stopPvr() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopPvr, _data, _reply, 0);
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

            public boolean isRecording() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isRecording, _data, _reply, 0);
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

            public boolean isPlaybacking() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isPlaybacking, _data, _reply, 0);
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

            public boolean isTimeShiftRecording() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isTimeShiftRecording, _data, _reply, 0);
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

            public boolean isPlaybackPaused() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isPlaybackPaused, _data, _reply, 0);
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

            public boolean isRecordPaused() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isRecordPaused, _data, _reply, 0);
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

            public void setPlaybackWindow(VideoWindowType videoWindowType, int containerWidth, int containerHeight) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (videoWindowType != null) {
                        _data.writeInt(Stub.TRANSACTION_startRecord);
                        videoWindowType.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(containerWidth);
                    _data.writeInt(containerHeight);
                    this.mRemote.transact(Stub.TRANSACTION_setPlaybackWindow, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCurRecordingFileName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurRecordingFileName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCurPlaybackingFileName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurPlaybackingFileName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurPlaybackTimeInSecond() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurPlaybackTimeInSecond, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurRecordTimeInSecond() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurRecordTimeInSecond, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean jumpToThumbnail(int thumbnailIndex) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(thumbnailIndex);
                    this.mRemote.transact(Stub.TRANSACTION_jumpToThumbnail, _data, _reply, 0);
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

            public void setTimeShiftFileSize(long timeShiftFileSizeInKb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(timeShiftFileSizeInKb);
                    this.mRemote.transact(Stub.TRANSACTION_setTimeShiftFileSize, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public CaptureThumbnailResult captureThumbnail() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    CaptureThumbnailResult _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_captureThumbnail, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (CaptureThumbnailResult) CaptureThumbnailResult.CREATOR.createFromParcel(_reply);
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

            public int checkUsbSpeed() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_checkUsbSpeed, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getUsbPartitionNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUsbPartitionNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getUsbDeviceNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUsbDeviceNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getUsbDeviceIndex() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUsbDeviceIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getPvrFileNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPvrFileNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public PvrFileInfo getPvrFileInfo(int index, int nSortKey) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    PvrFileInfo _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(nSortKey);
                    this.mRemote.transact(Stub.TRANSACTION_getPvrFileInfo, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (PvrFileInfo) PvrFileInfo.CREATOR.createFromParcel(_reply);
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

            public int getFileLcn(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getFileLcn, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getFileServiceName(String fileName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(fileName);
                    this.mRemote.transact(Stub.TRANSACTION_getFileServiceName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getFileEventName(String fileName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(fileName);
                    this.mRemote.transact(Stub.TRANSACTION_getFileEventName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean assignThumbnailFileInfoHandler(String fileName) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(fileName);
                    this.mRemote.transact(Stub.TRANSACTION_assignThumbnailFileInfoHandler, _data, _reply, 0);
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

            public int getThumbnailNumber() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getThumbnailNumber, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getThumbnailPath(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getThumbnailPath, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getThumbnailDisplay(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getThumbnailDisplay, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean changeDevice(int deviceIndex) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(deviceIndex);
                    this.mRemote.transact(Stub.TRANSACTION_changeDevice, _data, _reply, 0);
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

            public boolean setPvrParams(String mountpath, int fsType) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(mountpath);
                    _data.writeInt(fsType);
                    this.mRemote.transact(Stub.TRANSACTION_setPvrParams, _data, _reply, 0);
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

            public int getRecordedFileDurationTime(String filename) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(filename);
                    this.mRemote.transact(Stub.TRANSACTION_getRecordedFileDurationTime, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getMetadataSortKey() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMetadataSortKey, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setMetadataSortKey(int nSortKey) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nSortKey);
                    this.mRemote.transact(Stub.TRANSACTION_setMetadataSortKey, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setMetadataSortAscending(boolean bIsAscend) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bIsAscend) {
                        i = Stub.TRANSACTION_startRecord;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setMetadataSortAscending, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean createMetadata(String mountPath) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(mountPath);
                    this.mRemote.transact(Stub.TRANSACTION_createMetadata, _data, _reply, 0);
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

            public void clearMetadata() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_clearMetadata, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getPvrMountPath() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPvrMountPath, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void deletefile(int index, String fileName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeString(fileName);
                    this.mRemote.transact(Stub.TRANSACTION_deletefile, _data, _reply, 0);
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

        public static ITvPvr asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvPvr)) {
                return new Proxy(obj);
            }
            return (ITvPvr) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            int _result;
            boolean _arg0;
            boolean _result2;
            String _result3;
            switch (code) {
                case TRANSACTION_startRecord /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startRecord();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_stopRecord /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopRecord();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_pauseRecord /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    pauseRecord();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_resumeRecord /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    resumeRecord();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startAlwaysTimeShiftRecord /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startAlwaysTimeShiftRecord();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_stopAlwaysTimeShiftRecord /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopAlwaysTimeShiftRecord();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_pauseAlwaysTimeShiftRecord /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = pauseAlwaysTimeShiftRecord();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_startAlwaysTimeShiftPlayback /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startAlwaysTimeShiftPlayback();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_stopAlwaysTimeShiftPlayback /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopAlwaysTimeShiftPlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_pauseAlwaysTimeShiftPlayback /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = pauseAlwaysTimeShiftPlayback(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_isAlwaysTimeShiftPlaybackPaused /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isAlwaysTimeShiftPlaybackPaused();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isAlwaysTimeShiftRecording /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isAlwaysTimeShiftRecording();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_startPlayback /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startPlayback(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setAlwaysTimeShift /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setAlwaysTimeShift(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isAlwaysTimeShift /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isAlwaysTimeShift();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_pausePlayback /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    pausePlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_resumePlayback /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    resumePlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopPlayback /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopPlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stepInPlayback /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    stepInPlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startPlaybackLoop /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    startPlaybackLoop(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopPlaybackLoop /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopPlaybackLoop();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setPlaybackSpeed /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    setPlaybackSpeed(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getPlaybackSpeed /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getPlaybackSpeed();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_jumpPlaybackTime /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = jumpPlaybackTime(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_startTimeShiftRecord /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startTimeShiftRecord();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_stopTimeShiftRecord /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopTimeShiftRecord();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_startTimeShiftPlayback /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startTimeShiftPlayback();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_stopTimeShiftPlayback /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopTimeShiftPlayback();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopTimeShift /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    stopTimeShift();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_stopPvr /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = stopPvr();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isRecording /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isRecording();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isPlaybacking /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isPlaybacking();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isTimeShiftRecording /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isTimeShiftRecording();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isPlaybackPaused /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isPlaybackPaused();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_isRecordPaused /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = isRecordPaused();
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setPlaybackWindow /*36*/:
                    VideoWindowType _arg02;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (VideoWindowType) VideoWindowType.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    setPlaybackWindow(_arg02, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getCurRecordingFileName /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCurRecordingFileName();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getCurPlaybackingFileName /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCurPlaybackingFileName();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getCurPlaybackTimeInSecond /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurPlaybackTimeInSecond();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getCurRecordTimeInSecond /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurRecordTimeInSecond();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_jumpToThumbnail /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = jumpToThumbnail(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setTimeShiftFileSize /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    setTimeShiftFileSize(data.readLong());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_captureThumbnail /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    CaptureThumbnailResult _result4 = captureThumbnail();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(TRANSACTION_startRecord);
                        _result4.writeToParcel(reply, TRANSACTION_startRecord);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_checkUsbSpeed /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = checkUsbSpeed();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getUsbPartitionNumber /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getUsbPartitionNumber();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getUsbDeviceNumber /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getUsbDeviceNumber();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getUsbDeviceIndex /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getUsbDeviceIndex();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getPvrFileNumber /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getPvrFileNumber();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getPvrFileInfo /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    PvrFileInfo _result5 = getPvrFileInfo(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(TRANSACTION_startRecord);
                        _result5.writeToParcel(reply, TRANSACTION_startRecord);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_getFileLcn /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getFileLcn(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getFileServiceName /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getFileServiceName(data.readString());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getFileEventName /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getFileEventName(data.readString());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_assignThumbnailFileInfoHandler /*53*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = assignThumbnailFileInfoHandler(data.readString());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getThumbnailNumber /*54*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getThumbnailNumber();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getThumbnailPath /*55*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getThumbnailPath(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getThumbnailDisplay /*56*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getThumbnailDisplay(data.readInt());
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_changeDevice /*57*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = changeDevice(data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setPvrParams /*58*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = setPvrParams(data.readString(), data.readInt());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getRecordedFileDurationTime /*59*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getRecordedFileDurationTime(data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_getMetadataSortKey /*60*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getMetadataSortKey();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case TRANSACTION_setMetadataSortKey /*61*/:
                    data.enforceInterface(DESCRIPTOR);
                    setMetadataSortKey(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setMetadataSortAscending /*62*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    setMetadataSortAscending(_arg0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_createMetadata /*63*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = createMetadata(data.readString());
                    reply.writeNoException();
                    if (_result2) {
                        i = TRANSACTION_startRecord;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_clearMetadata /*64*/:
                    data.enforceInterface(DESCRIPTOR);
                    clearMetadata();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getPvrMountPath /*65*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getPvrMountPath();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_deletefile /*66*/:
                    data.enforceInterface(DESCRIPTOR);
                    deletefile(data.readInt(), data.readString());
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

    boolean assignThumbnailFileInfoHandler(String str) throws RemoteException;

    CaptureThumbnailResult captureThumbnail() throws RemoteException;

    boolean changeDevice(int i) throws RemoteException;

    int checkUsbSpeed() throws RemoteException;

    void clearMetadata() throws RemoteException;

    boolean createMetadata(String str) throws RemoteException;

    void deletefile(int i, String str) throws RemoteException;

    int getCurPlaybackTimeInSecond() throws RemoteException;

    String getCurPlaybackingFileName() throws RemoteException;

    int getCurRecordTimeInSecond() throws RemoteException;

    String getCurRecordingFileName() throws RemoteException;

    String getFileEventName(String str) throws RemoteException;

    int getFileLcn(int i) throws RemoteException;

    String getFileServiceName(String str) throws RemoteException;

    int getMetadataSortKey() throws RemoteException;

    int getPlaybackSpeed() throws RemoteException;

    PvrFileInfo getPvrFileInfo(int i, int i2) throws RemoteException;

    int getPvrFileNumber() throws RemoteException;

    String getPvrMountPath() throws RemoteException;

    int getRecordedFileDurationTime(String str) throws RemoteException;

    String getThumbnailDisplay(int i) throws RemoteException;

    int getThumbnailNumber() throws RemoteException;

    String getThumbnailPath(int i) throws RemoteException;

    int getUsbDeviceIndex() throws RemoteException;

    int getUsbDeviceNumber() throws RemoteException;

    int getUsbPartitionNumber() throws RemoteException;

    boolean isAlwaysTimeShift() throws RemoteException;

    boolean isAlwaysTimeShiftPlaybackPaused() throws RemoteException;

    boolean isAlwaysTimeShiftRecording() throws RemoteException;

    boolean isPlaybackPaused() throws RemoteException;

    boolean isPlaybacking() throws RemoteException;

    boolean isRecordPaused() throws RemoteException;

    boolean isRecording() throws RemoteException;

    boolean isTimeShiftRecording() throws RemoteException;

    boolean jumpPlaybackTime(int i) throws RemoteException;

    boolean jumpToThumbnail(int i) throws RemoteException;

    int pauseAlwaysTimeShiftPlayback(boolean z) throws RemoteException;

    int pauseAlwaysTimeShiftRecord() throws RemoteException;

    void pausePlayback() throws RemoteException;

    void pauseRecord() throws RemoteException;

    void resumePlayback() throws RemoteException;

    void resumeRecord() throws RemoteException;

    void setAlwaysTimeShift(boolean z) throws RemoteException;

    void setMetadataSortAscending(boolean z) throws RemoteException;

    void setMetadataSortKey(int i) throws RemoteException;

    void setPlaybackSpeed(int i) throws RemoteException;

    void setPlaybackWindow(VideoWindowType videoWindowType, int i, int i2) throws RemoteException;

    boolean setPvrParams(String str, int i) throws RemoteException;

    void setTimeShiftFileSize(long j) throws RemoteException;

    int startAlwaysTimeShiftPlayback() throws RemoteException;

    int startAlwaysTimeShiftRecord() throws RemoteException;

    int startPlayback(String str) throws RemoteException;

    void startPlaybackLoop(int i, int i2) throws RemoteException;

    int startRecord() throws RemoteException;

    int startTimeShiftPlayback() throws RemoteException;

    int startTimeShiftRecord() throws RemoteException;

    void stepInPlayback() throws RemoteException;

    void stopAlwaysTimeShiftPlayback() throws RemoteException;

    int stopAlwaysTimeShiftRecord() throws RemoteException;

    void stopPlayback() throws RemoteException;

    void stopPlaybackLoop() throws RemoteException;

    boolean stopPvr() throws RemoteException;

    void stopRecord() throws RemoteException;

    void stopTimeShift() throws RemoteException;

    void stopTimeShiftPlayback() throws RemoteException;

    void stopTimeShiftRecord() throws RemoteException;
}
