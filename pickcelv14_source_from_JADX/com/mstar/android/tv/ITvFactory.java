package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvFactory extends IInterface {

    public static abstract class Stub extends Binder implements ITvFactory {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvFactory";
        static final int TRANSACTION_changeWbParameterWhenSourceChange = 27;
        static final int TRANSACTION_enableUartDebug = 156;
        static final int TRANSACTION_execAutoAdc = 24;
        static final int TRANSACTION_execSetInputSource = 11;
        static final int TRANSACTION_get3DSelfAdaptiveLevel = 166;
        static final int TRANSACTION_getAdcBlueGain = 17;
        static final int TRANSACTION_getAdcBlueOffset = 23;
        static final int TRANSACTION_getAdcGreenGain = 15;
        static final int TRANSACTION_getAdcGreenOffset = 21;
        static final int TRANSACTION_getAdcIndex = 26;
        static final int TRANSACTION_getAdcPhase = 168;
        static final int TRANSACTION_getAdcRedGain = 13;
        static final int TRANSACTION_getAdcRedOffset = 19;
        static final int TRANSACTION_getAefc43 = 87;
        static final int TRANSACTION_getAefc44 = 89;
        static final int TRANSACTION_getAefc66Bit76 = 81;
        static final int TRANSACTION_getAefc6EBit3210 = 85;
        static final int TRANSACTION_getAefc6EBit7654 = 83;
        static final int TRANSACTION_getAefcA0 = 77;
        static final int TRANSACTION_getAefcA1 = 79;
        static final int TRANSACTION_getAefcCb = 91;
        static final int TRANSACTION_getAefcCfBit2Atv = 153;
        static final int TRANSACTION_getAefcCfBit2Av = 155;
        static final int TRANSACTION_getAefcD4 = 65;
        static final int TRANSACTION_getAefcD5Bit2 = 67;
        static final int TRANSACTION_getAefcD7HighBound = 73;
        static final int TRANSACTION_getAefcD7LowBound = 75;
        static final int TRANSACTION_getAefcD8Bit3210 = 69;
        static final int TRANSACTION_getAefcD9Bit0 = 71;
        static final int TRANSACTION_getAudioDspVersion = 101;
        static final int TRANSACTION_getAudioHiDevMode = 95;
        static final int TRANSACTION_getAudioNrThreshold = 97;
        static final int TRANSACTION_getAudioPrescale = 164;
        static final int TRANSACTION_getAudioSifThreshold = 99;
        static final int TRANSACTION_getBoardType = 135;
        static final int TRANSACTION_getChinaDescramblerBox = 57;
        static final int TRANSACTION_getCompileTime = 137;
        static final int TRANSACTION_getCurveType = 103;
        static final int TRANSACTION_getDelayReduce = 59;
        static final int TRANSACTION_getDtvAvAbnormalDelay = 158;
        static final int TRANSACTION_getFactoryPreSetFeature = 160;
        static final int TRANSACTION_getGainDistributionThreshold = 151;
        static final int TRANSACTION_getLvdsModulation = 123;
        static final int TRANSACTION_getLvdsPercentage = 125;
        static final int TRANSACTION_getLvdsenable = 121;
        static final int TRANSACTION_getMiuEnable = 115;
        static final int TRANSACTION_getMiuModulation = 117;
        static final int TRANSACTION_getMiuPercentage = 119;
        static final int TRANSACTION_getOsdV0Nonlinear = 105;
        static final int TRANSACTION_getOsdV100Nonlinear = 113;
        static final int TRANSACTION_getOsdV25Nonlinear = 107;
        static final int TRANSACTION_getOsdV50Nonlinear = 109;
        static final int TRANSACTION_getOsdV75Nonlinear = 111;
        static final int TRANSACTION_getOverScanHPosition = 6;
        static final int TRANSACTION_getOverScanHSize = 4;
        static final int TRANSACTION_getOverScanSourceType = 2;
        static final int TRANSACTION_getOverScanVPosition = 10;
        static final int TRANSACTION_getOverScanVSize = 8;
        static final int TRANSACTION_getPanelSwing = 162;
        static final int TRANSACTION_getPanelType = 136;
        static final int TRANSACTION_getPeqFoCoarse = 127;
        static final int TRANSACTION_getPeqFoFine = 129;
        static final int TRANSACTION_getPeqGain = 131;
        static final int TRANSACTION_getPeqQ = 133;
        static final int TRANSACTION_getPowerOnMode = 144;
        static final int TRANSACTION_getSoftWareVersion = 134;
        static final int TRANSACTION_getTestPattern = 141;
        static final int TRANSACTION_getUartOnOff = 146;
        static final int TRANSACTION_getVdDspVersion = 93;
        static final int TRANSACTION_getVifAgcRef = 149;
        static final int TRANSACTION_getVifAsiaSignalOption = 49;
        static final int TRANSACTION_getVifClampGainOvNegative = 55;
        static final int TRANSACTION_getVifCrKi = 47;
        static final int TRANSACTION_getVifCrKp = 45;
        static final int TRANSACTION_getVifCrKpKiAdjust = 51;
        static final int TRANSACTION_getVifCrThreshold = 61;
        static final int TRANSACTION_getVifOverModulation = 53;
        static final int TRANSACTION_getVifTop = 41;
        static final int TRANSACTION_getVifVersion = 63;
        static final int TRANSACTION_getVifVgaMaximum = 43;
        static final int TRANSACTION_getWatchDogMode = 139;
        static final int TRANSACTION_getWbBlueGain = 33;
        static final int TRANSACTION_getWbBlueOffset = 39;
        static final int TRANSACTION_getWbGreenGain = 31;
        static final int TRANSACTION_getWbGreenOffset = 37;
        static final int TRANSACTION_getWbRedGain = 29;
        static final int TRANSACTION_getWbRedOffset = 35;
        static final int TRANSACTION_restoreToDefault = 142;
        static final int TRANSACTION_set3DSelfAdaptiveLevel = 165;
        static final int TRANSACTION_setAdcBlueGain = 16;
        static final int TRANSACTION_setAdcBlueOffset = 22;
        static final int TRANSACTION_setAdcGreenGain = 14;
        static final int TRANSACTION_setAdcGreenOffset = 20;
        static final int TRANSACTION_setAdcIndex = 25;
        static final int TRANSACTION_setAdcPhase = 167;
        static final int TRANSACTION_setAdcRedGain = 12;
        static final int TRANSACTION_setAdcRedOffset = 18;
        static final int TRANSACTION_setAefc43 = 86;
        static final int TRANSACTION_setAefc44 = 88;
        static final int TRANSACTION_setAefc66Bit76 = 80;
        static final int TRANSACTION_setAefc6EBit3210 = 84;
        static final int TRANSACTION_setAefc6EBit7654 = 82;
        static final int TRANSACTION_setAefcA0 = 76;
        static final int TRANSACTION_setAefcA1 = 78;
        static final int TRANSACTION_setAefcCB = 90;
        static final int TRANSACTION_setAefcCfBit2Atv = 152;
        static final int TRANSACTION_setAefcCfBit2Av = 154;
        static final int TRANSACTION_setAefcD4 = 64;
        static final int TRANSACTION_setAefcD5Bit2 = 66;
        static final int TRANSACTION_setAefcD7HighBound = 72;
        static final int TRANSACTION_setAefcD7LowBound = 74;
        static final int TRANSACTION_setAefcD8Bit3210 = 68;
        static final int TRANSACTION_setAefcD9Bit0 = 70;
        static final int TRANSACTION_setAudioDspVersion = 100;
        static final int TRANSACTION_setAudioHiDevMode = 94;
        static final int TRANSACTION_setAudioNrThreshold = 96;
        static final int TRANSACTION_setAudioPrescale = 163;
        static final int TRANSACTION_setAudioSifThreshold = 98;
        static final int TRANSACTION_setChinaDescramblerBox = 56;
        static final int TRANSACTION_setCurveType = 102;
        static final int TRANSACTION_setDelayReduce = 58;
        static final int TRANSACTION_setDtvAvAbnormalDelay = 157;
        static final int TRANSACTION_setEnvironment = 147;
        static final int TRANSACTION_setFactoryPreSetFeature = 159;
        static final int TRANSACTION_setGainDistributionThreshold = 150;
        static final int TRANSACTION_setLvdsEnable = 120;
        static final int TRANSACTION_setLvdsModulation = 122;
        static final int TRANSACTION_setLvdsPercentage = 124;
        static final int TRANSACTION_setMiuEnable = 114;
        static final int TRANSACTION_setMiuModulation = 116;
        static final int TRANSACTION_setMiuPercentage = 118;
        static final int TRANSACTION_setOsdV0Nonlinear = 104;
        static final int TRANSACTION_setOsdV100Nonlinear = 112;
        static final int TRANSACTION_setOsdV25Nonlinear = 106;
        static final int TRANSACTION_setOsdV50Nonlinear = 108;
        static final int TRANSACTION_setOsdV75Nonlinear = 110;
        static final int TRANSACTION_setOverScanHPosition = 5;
        static final int TRANSACTION_setOverScanHSize = 3;
        static final int TRANSACTION_setOverScanSourceType = 1;
        static final int TRANSACTION_setOverScanVPosition = 9;
        static final int TRANSACTION_setOverScanVSize = 7;
        static final int TRANSACTION_setPanelSwing = 161;
        static final int TRANSACTION_setPeqFoCoarse = 126;
        static final int TRANSACTION_setPeqFoFine = 128;
        static final int TRANSACTION_setPeqGain = 130;
        static final int TRANSACTION_setPeqQ = 132;
        static final int TRANSACTION_setPowerOnMode = 143;
        static final int TRANSACTION_setTestPattern = 140;
        static final int TRANSACTION_setUartOnOff = 145;
        static final int TRANSACTION_setVdDspVersion = 92;
        static final int TRANSACTION_setVifAgcRef = 148;
        static final int TRANSACTION_setVifAsiaSignalOption = 48;
        static final int TRANSACTION_setVifClampGainOvNegative = 54;
        static final int TRANSACTION_setVifCrKi = 46;
        static final int TRANSACTION_setVifCrKp = 44;
        static final int TRANSACTION_setVifCrKpKiAdjust = 50;
        static final int TRANSACTION_setVifCrThreshold = 60;
        static final int TRANSACTION_setVifOverModulation = 52;
        static final int TRANSACTION_setVifTop = 40;
        static final int TRANSACTION_setVifVersion = 62;
        static final int TRANSACTION_setVifVgaMaximum = 42;
        static final int TRANSACTION_setWatchDogMode = 138;
        static final int TRANSACTION_setWbBlueGain = 32;
        static final int TRANSACTION_setWbBlueOffset = 38;
        static final int TRANSACTION_setWbGreenGain = 30;
        static final int TRANSACTION_setWbGreenOffset = 36;
        static final int TRANSACTION_setWbRedGain = 28;
        static final int TRANSACTION_setWbRedOffset = 34;

        private static class Proxy implements ITvFactory {
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

            public boolean setOverScanSourceType(int SourceType) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(SourceType);
                    this.mRemote.transact(Stub.TRANSACTION_setOverScanSourceType, _data, _reply, 0);
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

            public int getOverScanSourceType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOverScanSourceType, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOverScanHSize(int hSize) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hSize);
                    this.mRemote.transact(Stub.TRANSACTION_setOverScanHSize, _data, _reply, 0);
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

            public int getOverScanHSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOverScanHSize, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOverScanHPosition(int hPosition) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(hPosition);
                    this.mRemote.transact(Stub.TRANSACTION_setOverScanHPosition, _data, _reply, 0);
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

            public int getOverScanHPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOverScanHPosition, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOverScanVSize(int vSize) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vSize);
                    this.mRemote.transact(Stub.TRANSACTION_setOverScanVSize, _data, _reply, 0);
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

            public int getOverScanVSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOverScanVSize, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOverScanVPosition(int vPosition) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vPosition);
                    this.mRemote.transact(Stub.TRANSACTION_setOverScanVPosition, _data, _reply, 0);
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

            public int getOverScanVPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOverScanVPosition, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean execSetInputSource(int inputSource) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(inputSource);
                    this.mRemote.transact(Stub.TRANSACTION_execSetInputSource, _data, _reply, 0);
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

            public boolean setAdcRedGain(int redGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(redGain);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcRedGain, _data, _reply, 0);
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

            public int getAdcRedGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcRedGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcGreenGain(int greenGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(greenGain);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcGreenGain, _data, _reply, 0);
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

            public int getAdcGreenGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcGreenGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcBlueGain(int blueGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(blueGain);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcBlueGain, _data, _reply, 0);
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

            public int getAdcBlueGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcBlueGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcRedOffset(int redOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(redOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcRedOffset, _data, _reply, 0);
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

            public int getAdcRedOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcRedOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcGreenOffset(int greenOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(greenOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcGreenOffset, _data, _reply, 0);
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

            public int getAdcGreenOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcGreenOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcBlueOffset(int blueOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(blueOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcBlueOffset, _data, _reply, 0);
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

            public int getAdcBlueOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcBlueOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean execAutoAdc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_execAutoAdc, _data, _reply, 0);
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

            public boolean setAdcIndex(int eIdx) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(eIdx);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcIndex, _data, _reply, 0);
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

            public int getAdcIndex() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcIndex, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean changeWbParameterWhenSourceChange() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_changeWbParameterWhenSourceChange, _data, _reply, 0);
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

            public boolean setWbRedGain(int redGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(redGain);
                    this.mRemote.transact(Stub.TRANSACTION_setWbRedGain, _data, _reply, 0);
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

            public int getWbRedGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbRedGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWbGreenGain(int greenGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(greenGain);
                    this.mRemote.transact(Stub.TRANSACTION_setWbGreenGain, _data, _reply, 0);
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

            public int getWbGreenGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbGreenGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWbBlueGain(int blueGain) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(blueGain);
                    this.mRemote.transact(Stub.TRANSACTION_setWbBlueGain, _data, _reply, 0);
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

            public int getWbBlueGain() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbBlueGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWbRedOffset(int redOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(redOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setWbRedOffset, _data, _reply, 0);
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

            public int getWbRedOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbRedOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWbGreenOffset(int greenOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(greenOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setWbGreenOffset, _data, _reply, 0);
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

            public int getWbGreenOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbGreenOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWbBlueOffset(int blueOffset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(blueOffset);
                    this.mRemote.transact(Stub.TRANSACTION_setWbBlueOffset, _data, _reply, 0);
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

            public int getWbBlueOffset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWbBlueOffset, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifTop(int vifTop) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifTop);
                    this.mRemote.transact(Stub.TRANSACTION_setVifTop, _data, _reply, 0);
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

            public int getVifTop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifTop, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifVgaMaximum(int vifVgaMaximum) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifVgaMaximum);
                    this.mRemote.transact(Stub.TRANSACTION_setVifVgaMaximum, _data, _reply, 0);
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

            public int getVifVgaMaximum() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifVgaMaximum, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifCrKp(int vifCrKp) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifCrKp);
                    this.mRemote.transact(Stub.TRANSACTION_setVifCrKp, _data, _reply, 0);
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

            public int getVifCrKp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifCrKp, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifCrKi(int vifCrKi) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifCrKi);
                    this.mRemote.transact(Stub.TRANSACTION_setVifCrKi, _data, _reply, 0);
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

            public int getVifCrKi() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifCrKi, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifAsiaSignalOption(boolean vifAsiaSignalOption) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vifAsiaSignalOption) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setVifAsiaSignalOption, _data, _reply, 0);
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

            public boolean getVifAsiaSignalOption() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifAsiaSignalOption, _data, _reply, 0);
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

            public boolean setVifCrKpKiAdjust(boolean vifCrKpKiAdjust) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vifCrKpKiAdjust) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setVifCrKpKiAdjust, _data, _reply, 0);
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

            public boolean getVifCrKpKiAdjust() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifCrKpKiAdjust, _data, _reply, 0);
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

            public boolean setVifOverModulation(boolean vifOverModulation) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vifOverModulation) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setVifOverModulation, _data, _reply, 0);
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

            public boolean getVifOverModulation() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifOverModulation, _data, _reply, 0);
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

            public boolean setVifClampGainOvNegative(int vifClampGainOvNegative) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifClampGainOvNegative);
                    this.mRemote.transact(Stub.TRANSACTION_setVifClampGainOvNegative, _data, _reply, 0);
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

            public int getVifClampGainOvNegative() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifClampGainOvNegative, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setChinaDescramblerBox(int chinaDescramblerBox) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(chinaDescramblerBox);
                    this.mRemote.transact(Stub.TRANSACTION_setChinaDescramblerBox, _data, _reply, 0);
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

            public int getChinaDescramblerBox() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getChinaDescramblerBox, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setDelayReduce(int delayReduce) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(delayReduce);
                    this.mRemote.transact(Stub.TRANSACTION_setDelayReduce, _data, _reply, 0);
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

            public int getDelayReduce() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDelayReduce, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifCrThreshold(int vifCrThreshold) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifCrThreshold);
                    this.mRemote.transact(Stub.TRANSACTION_setVifCrThreshold, _data, _reply, 0);
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

            public int getVifCrThreshold() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifCrThreshold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVifVersion(int vifVersion) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifVersion);
                    this.mRemote.transact(Stub.TRANSACTION_setVifVersion, _data, _reply, 0);
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

            public int getVifVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifVersion, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD4(int aefcD4) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD4);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD4, _data, _reply, 0);
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

            public int getAefcD4() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD5Bit2(int aefcD5Bit2) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD5Bit2);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD5Bit2, _data, _reply, 0);
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

            public int getAefcD5Bit2() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD5Bit2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD8Bit3210(int aefcD8Bit3210) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD8Bit3210);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD8Bit3210, _data, _reply, 0);
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

            public int getAefcD8Bit3210() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD8Bit3210, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD9Bit0(int aefcD9Bit0) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD9Bit0);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD9Bit0, _data, _reply, 0);
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

            public int getAefcD9Bit0() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD9Bit0, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD7HighBound(int aefcD7HighBound) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD7HighBound);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD7HighBound, _data, _reply, 0);
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

            public int getAefcD7HighBound() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD7HighBound, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcD7LowBound(int aefcD7LowBound) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcD7LowBound);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcD7LowBound, _data, _reply, 0);
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

            public int getAefcD7LowBound() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcD7LowBound, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcA0(int aefcA0) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcA0);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcA0, _data, _reply, 0);
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

            public int getAefcA0() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcA0, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcA1(int aefcA1) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcA1);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcA1, _data, _reply, 0);
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

            public int getAefcA1() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcA1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefc66Bit76(int aefc66Bit76) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefc66Bit76);
                    this.mRemote.transact(Stub.TRANSACTION_setAefc66Bit76, _data, _reply, 0);
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

            public int getAefc66Bit76() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefc66Bit76, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefc6EBit7654(int aefc6EBit7654) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefc6EBit7654);
                    this.mRemote.transact(Stub.TRANSACTION_setAefc6EBit7654, _data, _reply, 0);
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

            public int getAefc6EBit7654() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefc6EBit7654, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefc6EBit3210(int aefc6EBit3210) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefc6EBit3210);
                    this.mRemote.transact(Stub.TRANSACTION_setAefc6EBit3210, _data, _reply, 0);
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

            public int getAefc6EBit3210() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefc6EBit3210, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefc43(int aefc43) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefc43);
                    this.mRemote.transact(Stub.TRANSACTION_setAefc43, _data, _reply, 0);
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

            public int getAefc43() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefc43, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefc44(int aefc44) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefc44);
                    this.mRemote.transact(Stub.TRANSACTION_setAefc44, _data, _reply, 0);
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

            public int getAefc44() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefc44, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcCB(int aefcCB) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcCB);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcCB, _data, _reply, 0);
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

            public int getAefcCb() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcCb, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setVdDspVersion(int vdDspVersion) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vdDspVersion);
                    this.mRemote.transact(Stub.TRANSACTION_setVdDspVersion, _data, _reply, 0);
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

            public int getVdDspVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVdDspVersion, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAudioHiDevMode(int audioHiDevMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioHiDevMode);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioHiDevMode, _data, _reply, 0);
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

            public int getAudioHiDevMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioHiDevMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAudioNrThreshold(int audioNrThreshold) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioNrThreshold);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioNrThreshold, _data, _reply, 0);
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

            public int getAudioNrThreshold() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioNrThreshold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAudioSifThreshold(int audioSifThreshold) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioSifThreshold);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioSifThreshold, _data, _reply, 0);
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

            public int getAudioSifThreshold() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioSifThreshold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAudioDspVersion(int aduioDspVersion) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aduioDspVersion);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioDspVersion, _data, _reply, 0);
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

            public int getAudioDspVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioDspVersion, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setCurveType(int curveTypeIndex) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(curveTypeIndex);
                    this.mRemote.transact(Stub.TRANSACTION_setCurveType, _data, _reply, 0);
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

            public int getCurveType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurveType, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOsdV0Nonlinear(int nonlinearVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nonlinearVal);
                    this.mRemote.transact(Stub.TRANSACTION_setOsdV0Nonlinear, _data, _reply, 0);
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

            public int getOsdV0Nonlinear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOsdV0Nonlinear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOsdV25Nonlinear(int nonlinearVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nonlinearVal);
                    this.mRemote.transact(Stub.TRANSACTION_setOsdV25Nonlinear, _data, _reply, 0);
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

            public int getOsdV25Nonlinear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOsdV25Nonlinear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOsdV50Nonlinear(int nonlinearVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nonlinearVal);
                    this.mRemote.transact(Stub.TRANSACTION_setOsdV50Nonlinear, _data, _reply, 0);
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

            public int getOsdV50Nonlinear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOsdV50Nonlinear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOsdV75Nonlinear(int nonlinearVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nonlinearVal);
                    this.mRemote.transact(Stub.TRANSACTION_setOsdV75Nonlinear, _data, _reply, 0);
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

            public int getOsdV75Nonlinear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOsdV75Nonlinear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setOsdV100Nonlinear(int nonlinearVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(nonlinearVal);
                    this.mRemote.transact(Stub.TRANSACTION_setOsdV100Nonlinear, _data, _reply, 0);
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

            public int getOsdV100Nonlinear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getOsdV100Nonlinear, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setMiuEnable(boolean miuSscEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (miuSscEnable) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setMiuEnable, _data, _reply, 0);
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

            public boolean getMiuEnable() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMiuEnable, _data, _reply, 0);
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

            public boolean setMiuModulation(int miuSscSpan) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(miuSscSpan);
                    this.mRemote.transact(Stub.TRANSACTION_setMiuModulation, _data, _reply, 0);
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

            public int getMiuModulation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMiuModulation, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setMiuPercentage(int miuSscStep) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(miuSscStep);
                    this.mRemote.transact(Stub.TRANSACTION_setMiuPercentage, _data, _reply, 0);
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

            public int getMiuPercentage() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getMiuPercentage, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setLvdsEnable(boolean lvdsSscEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (lvdsSscEnable) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setLvdsEnable, _data, _reply, 0);
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

            public boolean getLvdsenable() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLvdsenable, _data, _reply, 0);
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

            public boolean setLvdsModulation(int lvdsSscSpan) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(lvdsSscSpan);
                    this.mRemote.transact(Stub.TRANSACTION_setLvdsModulation, _data, _reply, 0);
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

            public int getLvdsModulation() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLvdsModulation, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setLvdsPercentage(int lvdsSscStep) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(lvdsSscStep);
                    this.mRemote.transact(Stub.TRANSACTION_setLvdsPercentage, _data, _reply, 0);
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

            public int getLvdsPercentage() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLvdsPercentage, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPeqFoCoarse(int index, int coarseVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(coarseVal);
                    this.mRemote.transact(Stub.TRANSACTION_setPeqFoCoarse, _data, _reply, 0);
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

            public int getPeqFoCoarse(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getPeqFoCoarse, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPeqFoFine(int index, int fineVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(fineVal);
                    this.mRemote.transact(Stub.TRANSACTION_setPeqFoFine, _data, _reply, 0);
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

            public int getPeqFoFine(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getPeqFoFine, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPeqGain(int index, int gainVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(gainVal);
                    this.mRemote.transact(Stub.TRANSACTION_setPeqGain, _data, _reply, 0);
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

            public int getPeqGain(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getPeqGain, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPeqQ(int index, int QValue) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    _data.writeInt(QValue);
                    this.mRemote.transact(Stub.TRANSACTION_setPeqQ, _data, _reply, 0);
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

            public int getPeqQ(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getPeqQ, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getSoftWareVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSoftWareVersion, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getBoardType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBoardType, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getPanelType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPanelType, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCompileTime() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCompileTime, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setWatchDogMode(boolean isEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (isEnable) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setWatchDogMode, _data, _reply, 0);
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

            public boolean getWatchDogMode() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWatchDogMode, _data, _reply, 0);
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

            public boolean setTestPattern(int testPatternMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(testPatternMode);
                    this.mRemote.transact(Stub.TRANSACTION_setTestPattern, _data, _reply, 0);
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

            public int getTestPattern() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTestPattern, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean restoreToDefault() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_restoreToDefault, _data, _reply, 0);
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

            public boolean setPowerOnMode(int factoryPowerMode) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(factoryPowerMode);
                    this.mRemote.transact(Stub.TRANSACTION_setPowerOnMode, _data, _reply, 0);
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

            public int getPowerOnMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPowerOnMode, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setUartOnOff(boolean isEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (isEnable) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setUartOnOff, _data, _reply, 0);
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

            public boolean getUartOnOff() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUartOnOff, _data, _reply, 0);
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

            public boolean setEnvironment(String name, String value) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeString(value);
                    this.mRemote.transact(Stub.TRANSACTION_setEnvironment, _data, _reply, 0);
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

            public boolean setVifAgcRef(int vifAgcRef) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(vifAgcRef);
                    this.mRemote.transact(Stub.TRANSACTION_setVifAgcRef, _data, _reply, 0);
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

            public int getVifAgcRef() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVifAgcRef, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setGainDistributionThreshold(int gainDistributionThreshold) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(gainDistributionThreshold);
                    this.mRemote.transact(Stub.TRANSACTION_setGainDistributionThreshold, _data, _reply, 0);
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

            public int getGainDistributionThreshold() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getGainDistributionThreshold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcCfBit2Atv(int aefcCfBit2Atv) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcCfBit2Atv);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcCfBit2Atv, _data, _reply, 0);
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

            public int getAefcCfBit2Atv() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcCfBit2Atv, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAefcCfBit2Av(int aefcCfBit2Av) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aefcCfBit2Av);
                    this.mRemote.transact(Stub.TRANSACTION_setAefcCfBit2Av, _data, _reply, 0);
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

            public int getAefcCfBit2Av() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAefcCfBit2Av, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean enableUartDebug() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enableUartDebug, _data, _reply, 0);
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

            public boolean setDtvAvAbnormalDelay(boolean isEnable) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (isEnable) {
                        i = Stub.TRANSACTION_setOverScanSourceType;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setDtvAvAbnormalDelay, _data, _reply, 0);
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

            public boolean getDtvAvAbnormalDelay() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDtvAvAbnormalDelay, _data, _reply, 0);
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

            public boolean setFactoryPreSetFeature(int factoryPreset) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(factoryPreset);
                    this.mRemote.transact(Stub.TRANSACTION_setFactoryPreSetFeature, _data, _reply, 0);
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

            public int getFactoryPreSetFeature() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getFactoryPreSetFeature, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setPanelSwing(int panleSwingVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(panleSwingVal);
                    this.mRemote.transact(Stub.TRANSACTION_setPanelSwing, _data, _reply, 0);
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

            public int getPanelSwing() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPanelSwing, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAudioPrescale(int audioPrescaleVal) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(audioPrescaleVal);
                    this.mRemote.transact(Stub.TRANSACTION_setAudioPrescale, _data, _reply, 0);
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

            public int getAudioPrescale() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioPrescale, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean set3DSelfAdaptiveLevel(int threeDSelfAdaptiveLevel) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(threeDSelfAdaptiveLevel);
                    this.mRemote.transact(Stub.TRANSACTION_set3DSelfAdaptiveLevel, _data, _reply, 0);
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

            public int get3DSelfAdaptiveLevel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_get3DSelfAdaptiveLevel, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean setAdcPhase(int phase) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(phase);
                    this.mRemote.transact(Stub.TRANSACTION_setAdcPhase, _data, _reply, 0);
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

            public int getAdcPhase() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAdcPhase, _data, _reply, 0);
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

        public static ITvFactory asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvFactory)) {
                return new Proxy(obj);
            }
            return (ITvFactory) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            int _result2;
            boolean _arg0;
            String _result3;
            switch (code) {
                case TRANSACTION_setOverScanSourceType /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOverScanSourceType(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOverScanSourceType /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOverScanSourceType();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOverScanHSize /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOverScanHSize(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOverScanHSize /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOverScanHSize();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOverScanHPosition /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOverScanHPosition(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOverScanHPosition /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOverScanHPosition();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOverScanVSize /*7*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOverScanVSize(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOverScanVSize /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOverScanVSize();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOverScanVPosition /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOverScanVPosition(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOverScanVPosition /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOverScanVPosition();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_execSetInputSource /*11*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = execSetInputSource(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAdcRedGain /*12*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcRedGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcRedGain /*13*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcRedGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcGreenGain /*14*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcGreenGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcGreenGain /*15*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcGreenGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcBlueGain /*16*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcBlueGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcBlueGain /*17*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcBlueGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcRedOffset /*18*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcRedOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcRedOffset /*19*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcRedOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcGreenOffset /*20*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcGreenOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcGreenOffset /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcGreenOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcBlueOffset /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcBlueOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcBlueOffset /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcBlueOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_execAutoAdc /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = execAutoAdc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setAdcIndex /*25*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcIndex(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcIndex /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcIndex();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_changeWbParameterWhenSourceChange /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = changeWbParameterWhenSourceChange();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setWbRedGain /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbRedGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbRedGain /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbRedGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWbGreenGain /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbGreenGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbGreenGain /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbGreenGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWbBlueGain /*32*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbBlueGain(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbBlueGain /*33*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbBlueGain();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWbRedOffset /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbRedOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbRedOffset /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbRedOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWbGreenOffset /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbGreenOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbGreenOffset /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbGreenOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setWbBlueOffset /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setWbBlueOffset(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWbBlueOffset /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getWbBlueOffset();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifTop /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifTop(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifTop /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifTop();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifVgaMaximum /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifVgaMaximum(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifVgaMaximum /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifVgaMaximum();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifCrKp /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifCrKp(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifCrKp /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifCrKp();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifCrKi /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifCrKi(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifCrKi /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifCrKi();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifAsiaSignalOption /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setVifAsiaSignalOption(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifAsiaSignalOption /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getVifAsiaSignalOption();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVifCrKpKiAdjust /*50*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setVifCrKpKiAdjust(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifCrKpKiAdjust /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getVifCrKpKiAdjust();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVifOverModulation /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setVifOverModulation(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifOverModulation /*53*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getVifOverModulation();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVifClampGainOvNegative /*54*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifClampGainOvNegative(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifClampGainOvNegative /*55*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifClampGainOvNegative();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setChinaDescramblerBox /*56*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setChinaDescramblerBox(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getChinaDescramblerBox /*57*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getChinaDescramblerBox();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setDelayReduce /*58*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setDelayReduce(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getDelayReduce /*59*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getDelayReduce();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifCrThreshold /*60*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifCrThreshold(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifCrThreshold /*61*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifCrThreshold();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVifVersion /*62*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifVersion(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifVersion /*63*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifVersion();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD4 /*64*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD4(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD4 /*65*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD4();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD5Bit2 /*66*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD5Bit2(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD5Bit2 /*67*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD5Bit2();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD8Bit3210 /*68*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD8Bit3210(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD8Bit3210 /*69*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD8Bit3210();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD9Bit0 /*70*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD9Bit0(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD9Bit0 /*71*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD9Bit0();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD7HighBound /*72*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD7HighBound(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD7HighBound /*73*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD7HighBound();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcD7LowBound /*74*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcD7LowBound(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcD7LowBound /*75*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcD7LowBound();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcA0 /*76*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcA0(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcA0 /*77*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcA0();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcA1 /*78*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcA1(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcA1 /*79*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcA1();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefc66Bit76 /*80*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefc66Bit76(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefc66Bit76 /*81*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefc66Bit76();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefc6EBit7654 /*82*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefc6EBit7654(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefc6EBit7654 /*83*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefc6EBit7654();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefc6EBit3210 /*84*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefc6EBit3210(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefc6EBit3210 /*85*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefc6EBit3210();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefc43 /*86*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefc43(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefc43 /*87*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefc43();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefc44 /*88*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefc44(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefc44 /*89*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefc44();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcCB /*90*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcCB(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcCb /*91*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcCb();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setVdDspVersion /*92*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVdDspVersion(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVdDspVersion /*93*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVdDspVersion();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioHiDevMode /*94*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAudioHiDevMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAudioHiDevMode /*95*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioHiDevMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioNrThreshold /*96*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAudioNrThreshold(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAudioNrThreshold /*97*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioNrThreshold();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioSifThreshold /*98*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAudioSifThreshold(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAudioSifThreshold /*99*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioSifThreshold();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioDspVersion /*100*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAudioDspVersion(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAudioDspVersion /*101*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioDspVersion();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setCurveType /*102*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setCurveType(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCurveType /*103*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurveType();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOsdV0Nonlinear /*104*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOsdV0Nonlinear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOsdV0Nonlinear /*105*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOsdV0Nonlinear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOsdV25Nonlinear /*106*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOsdV25Nonlinear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOsdV25Nonlinear /*107*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOsdV25Nonlinear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOsdV50Nonlinear /*108*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOsdV50Nonlinear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOsdV50Nonlinear /*109*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOsdV50Nonlinear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOsdV75Nonlinear /*110*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOsdV75Nonlinear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOsdV75Nonlinear /*111*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOsdV75Nonlinear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setOsdV100Nonlinear /*112*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setOsdV100Nonlinear(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getOsdV100Nonlinear /*113*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getOsdV100Nonlinear();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setMiuEnable /*114*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setMiuEnable(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getMiuEnable /*115*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getMiuEnable();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setMiuModulation /*116*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setMiuModulation(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getMiuModulation /*117*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMiuModulation();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setMiuPercentage /*118*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setMiuPercentage(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getMiuPercentage /*119*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getMiuPercentage();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setLvdsEnable /*120*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setLvdsEnable(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getLvdsenable /*121*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getLvdsenable();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setLvdsModulation /*122*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setLvdsModulation(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getLvdsModulation /*123*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getLvdsModulation();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setLvdsPercentage /*124*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setLvdsPercentage(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getLvdsPercentage /*125*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getLvdsPercentage();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPeqFoCoarse /*126*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPeqFoCoarse(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPeqFoCoarse /*127*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPeqFoCoarse(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPeqFoFine /*128*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPeqFoFine(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPeqFoFine /*129*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPeqFoFine(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPeqGain /*130*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPeqGain(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPeqGain /*131*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPeqGain(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPeqQ /*132*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPeqQ(data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPeqQ /*133*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPeqQ(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getSoftWareVersion /*134*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getSoftWareVersion();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getBoardType /*135*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getBoardType();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getPanelType /*136*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getPanelType();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_getCompileTime /*137*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getCompileTime();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case TRANSACTION_setWatchDogMode /*138*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setWatchDogMode(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getWatchDogMode /*139*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getWatchDogMode();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setTestPattern /*140*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setTestPattern(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getTestPattern /*141*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getTestPattern();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_restoreToDefault /*142*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = restoreToDefault();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setPowerOnMode /*143*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPowerOnMode(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPowerOnMode /*144*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPowerOnMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setUartOnOff /*145*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setUartOnOff(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getUartOnOff /*146*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getUartOnOff();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setEnvironment /*147*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setEnvironment(data.readString(), data.readString());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setVifAgcRef /*148*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setVifAgcRef(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getVifAgcRef /*149*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getVifAgcRef();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setGainDistributionThreshold /*150*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setGainDistributionThreshold(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getGainDistributionThreshold /*151*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getGainDistributionThreshold();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcCfBit2Atv /*152*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcCfBit2Atv(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcCfBit2Atv /*153*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcCfBit2Atv();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAefcCfBit2Av /*154*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAefcCfBit2Av(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAefcCfBit2Av /*155*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAefcCfBit2Av();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_enableUartDebug /*156*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = enableUartDebug();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setDtvAvAbnormalDelay /*157*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = true;
                    } else {
                        _arg0 = false;
                    }
                    _result = setDtvAvAbnormalDelay(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getDtvAvAbnormalDelay /*158*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getDtvAvAbnormalDelay();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_setFactoryPreSetFeature /*159*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setFactoryPreSetFeature(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getFactoryPreSetFeature /*160*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getFactoryPreSetFeature();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setPanelSwing /*161*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setPanelSwing(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getPanelSwing /*162*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPanelSwing();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAudioPrescale /*163*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAudioPrescale(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAudioPrescale /*164*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioPrescale();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_set3DSelfAdaptiveLevel /*165*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = set3DSelfAdaptiveLevel(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_get3DSelfAdaptiveLevel /*166*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = get3DSelfAdaptiveLevel();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setAdcPhase /*167*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = setAdcPhase(data.readInt());
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_setOverScanSourceType;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getAdcPhase /*168*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAdcPhase();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean changeWbParameterWhenSourceChange() throws RemoteException;

    boolean enableUartDebug() throws RemoteException;

    boolean execAutoAdc() throws RemoteException;

    boolean execSetInputSource(int i) throws RemoteException;

    int get3DSelfAdaptiveLevel() throws RemoteException;

    int getAdcBlueGain() throws RemoteException;

    int getAdcBlueOffset() throws RemoteException;

    int getAdcGreenGain() throws RemoteException;

    int getAdcGreenOffset() throws RemoteException;

    int getAdcIndex() throws RemoteException;

    int getAdcPhase() throws RemoteException;

    int getAdcRedGain() throws RemoteException;

    int getAdcRedOffset() throws RemoteException;

    int getAefc43() throws RemoteException;

    int getAefc44() throws RemoteException;

    int getAefc66Bit76() throws RemoteException;

    int getAefc6EBit3210() throws RemoteException;

    int getAefc6EBit7654() throws RemoteException;

    int getAefcA0() throws RemoteException;

    int getAefcA1() throws RemoteException;

    int getAefcCb() throws RemoteException;

    int getAefcCfBit2Atv() throws RemoteException;

    int getAefcCfBit2Av() throws RemoteException;

    int getAefcD4() throws RemoteException;

    int getAefcD5Bit2() throws RemoteException;

    int getAefcD7HighBound() throws RemoteException;

    int getAefcD7LowBound() throws RemoteException;

    int getAefcD8Bit3210() throws RemoteException;

    int getAefcD9Bit0() throws RemoteException;

    int getAudioDspVersion() throws RemoteException;

    int getAudioHiDevMode() throws RemoteException;

    int getAudioNrThreshold() throws RemoteException;

    int getAudioPrescale() throws RemoteException;

    int getAudioSifThreshold() throws RemoteException;

    String getBoardType() throws RemoteException;

    int getChinaDescramblerBox() throws RemoteException;

    String getCompileTime() throws RemoteException;

    int getCurveType() throws RemoteException;

    int getDelayReduce() throws RemoteException;

    boolean getDtvAvAbnormalDelay() throws RemoteException;

    int getFactoryPreSetFeature() throws RemoteException;

    int getGainDistributionThreshold() throws RemoteException;

    int getLvdsModulation() throws RemoteException;

    int getLvdsPercentage() throws RemoteException;

    boolean getLvdsenable() throws RemoteException;

    boolean getMiuEnable() throws RemoteException;

    int getMiuModulation() throws RemoteException;

    int getMiuPercentage() throws RemoteException;

    int getOsdV0Nonlinear() throws RemoteException;

    int getOsdV100Nonlinear() throws RemoteException;

    int getOsdV25Nonlinear() throws RemoteException;

    int getOsdV50Nonlinear() throws RemoteException;

    int getOsdV75Nonlinear() throws RemoteException;

    int getOverScanHPosition() throws RemoteException;

    int getOverScanHSize() throws RemoteException;

    int getOverScanSourceType() throws RemoteException;

    int getOverScanVPosition() throws RemoteException;

    int getOverScanVSize() throws RemoteException;

    int getPanelSwing() throws RemoteException;

    String getPanelType() throws RemoteException;

    int getPeqFoCoarse(int i) throws RemoteException;

    int getPeqFoFine(int i) throws RemoteException;

    int getPeqGain(int i) throws RemoteException;

    int getPeqQ(int i) throws RemoteException;

    int getPowerOnMode() throws RemoteException;

    String getSoftWareVersion() throws RemoteException;

    int getTestPattern() throws RemoteException;

    boolean getUartOnOff() throws RemoteException;

    int getVdDspVersion() throws RemoteException;

    int getVifAgcRef() throws RemoteException;

    boolean getVifAsiaSignalOption() throws RemoteException;

    int getVifClampGainOvNegative() throws RemoteException;

    int getVifCrKi() throws RemoteException;

    int getVifCrKp() throws RemoteException;

    boolean getVifCrKpKiAdjust() throws RemoteException;

    int getVifCrThreshold() throws RemoteException;

    boolean getVifOverModulation() throws RemoteException;

    int getVifTop() throws RemoteException;

    int getVifVersion() throws RemoteException;

    int getVifVgaMaximum() throws RemoteException;

    boolean getWatchDogMode() throws RemoteException;

    int getWbBlueGain() throws RemoteException;

    int getWbBlueOffset() throws RemoteException;

    int getWbGreenGain() throws RemoteException;

    int getWbGreenOffset() throws RemoteException;

    int getWbRedGain() throws RemoteException;

    int getWbRedOffset() throws RemoteException;

    boolean restoreToDefault() throws RemoteException;

    boolean set3DSelfAdaptiveLevel(int i) throws RemoteException;

    boolean setAdcBlueGain(int i) throws RemoteException;

    boolean setAdcBlueOffset(int i) throws RemoteException;

    boolean setAdcGreenGain(int i) throws RemoteException;

    boolean setAdcGreenOffset(int i) throws RemoteException;

    boolean setAdcIndex(int i) throws RemoteException;

    boolean setAdcPhase(int i) throws RemoteException;

    boolean setAdcRedGain(int i) throws RemoteException;

    boolean setAdcRedOffset(int i) throws RemoteException;

    boolean setAefc43(int i) throws RemoteException;

    boolean setAefc44(int i) throws RemoteException;

    boolean setAefc66Bit76(int i) throws RemoteException;

    boolean setAefc6EBit3210(int i) throws RemoteException;

    boolean setAefc6EBit7654(int i) throws RemoteException;

    boolean setAefcA0(int i) throws RemoteException;

    boolean setAefcA1(int i) throws RemoteException;

    boolean setAefcCB(int i) throws RemoteException;

    boolean setAefcCfBit2Atv(int i) throws RemoteException;

    boolean setAefcCfBit2Av(int i) throws RemoteException;

    boolean setAefcD4(int i) throws RemoteException;

    boolean setAefcD5Bit2(int i) throws RemoteException;

    boolean setAefcD7HighBound(int i) throws RemoteException;

    boolean setAefcD7LowBound(int i) throws RemoteException;

    boolean setAefcD8Bit3210(int i) throws RemoteException;

    boolean setAefcD9Bit0(int i) throws RemoteException;

    boolean setAudioDspVersion(int i) throws RemoteException;

    boolean setAudioHiDevMode(int i) throws RemoteException;

    boolean setAudioNrThreshold(int i) throws RemoteException;

    boolean setAudioPrescale(int i) throws RemoteException;

    boolean setAudioSifThreshold(int i) throws RemoteException;

    boolean setChinaDescramblerBox(int i) throws RemoteException;

    boolean setCurveType(int i) throws RemoteException;

    boolean setDelayReduce(int i) throws RemoteException;

    boolean setDtvAvAbnormalDelay(boolean z) throws RemoteException;

    boolean setEnvironment(String str, String str2) throws RemoteException;

    boolean setFactoryPreSetFeature(int i) throws RemoteException;

    boolean setGainDistributionThreshold(int i) throws RemoteException;

    boolean setLvdsEnable(boolean z) throws RemoteException;

    boolean setLvdsModulation(int i) throws RemoteException;

    boolean setLvdsPercentage(int i) throws RemoteException;

    boolean setMiuEnable(boolean z) throws RemoteException;

    boolean setMiuModulation(int i) throws RemoteException;

    boolean setMiuPercentage(int i) throws RemoteException;

    boolean setOsdV0Nonlinear(int i) throws RemoteException;

    boolean setOsdV100Nonlinear(int i) throws RemoteException;

    boolean setOsdV25Nonlinear(int i) throws RemoteException;

    boolean setOsdV50Nonlinear(int i) throws RemoteException;

    boolean setOsdV75Nonlinear(int i) throws RemoteException;

    boolean setOverScanHPosition(int i) throws RemoteException;

    boolean setOverScanHSize(int i) throws RemoteException;

    boolean setOverScanSourceType(int i) throws RemoteException;

    boolean setOverScanVPosition(int i) throws RemoteException;

    boolean setOverScanVSize(int i) throws RemoteException;

    boolean setPanelSwing(int i) throws RemoteException;

    boolean setPeqFoCoarse(int i, int i2) throws RemoteException;

    boolean setPeqFoFine(int i, int i2) throws RemoteException;

    boolean setPeqGain(int i, int i2) throws RemoteException;

    boolean setPeqQ(int i, int i2) throws RemoteException;

    boolean setPowerOnMode(int i) throws RemoteException;

    boolean setTestPattern(int i) throws RemoteException;

    boolean setUartOnOff(boolean z) throws RemoteException;

    boolean setVdDspVersion(int i) throws RemoteException;

    boolean setVifAgcRef(int i) throws RemoteException;

    boolean setVifAsiaSignalOption(boolean z) throws RemoteException;

    boolean setVifClampGainOvNegative(int i) throws RemoteException;

    boolean setVifCrKi(int i) throws RemoteException;

    boolean setVifCrKp(int i) throws RemoteException;

    boolean setVifCrKpKiAdjust(boolean z) throws RemoteException;

    boolean setVifCrThreshold(int i) throws RemoteException;

    boolean setVifOverModulation(boolean z) throws RemoteException;

    boolean setVifTop(int i) throws RemoteException;

    boolean setVifVersion(int i) throws RemoteException;

    boolean setVifVgaMaximum(int i) throws RemoteException;

    boolean setWatchDogMode(boolean z) throws RemoteException;

    boolean setWbBlueGain(int i) throws RemoteException;

    boolean setWbBlueOffset(int i) throws RemoteException;

    boolean setWbGreenGain(int i) throws RemoteException;

    boolean setWbGreenOffset(int i) throws RemoteException;

    boolean setWbRedGain(int i) throws RemoteException;

    boolean setWbRedOffset(int i) throws RemoteException;
}
