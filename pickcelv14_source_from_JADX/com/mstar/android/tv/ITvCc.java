package com.mstar.android.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mstar.android.tvapi.common.vo.CCSetting;
import com.mstar.android.tvapi.common.vo.CaptionOptionSetting;

public interface ITvCc extends IInterface {

    public static abstract class Stub extends Binder implements ITvCc {
        private static final String DESCRIPTOR = "com.mstar.android.tv.ITvCc";
        static final int TRANSACTION_creatPreviewCcWindow = 3;
        static final int TRANSACTION_doesCcExist = 10;
        static final int TRANSACTION_drawPreviewCc = 4;
        static final int TRANSACTION_exitPreviewCc = 5;
        static final int TRANSACTION_getAdvancedSetting = 8;
        static final int TRANSACTION_getCCSetting = 6;
        static final int TRANSACTION_setAdvancedSetting = 9;
        static final int TRANSACTION_setCCSetting = 7;
        static final int TRANSACTION_startCc = 1;
        static final int TRANSACTION_stopCc = 2;

        private static class Proxy implements ITvCc {
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

            public boolean startCc() throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startCc, _data, _reply, 0);
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

            public boolean creatPreviewCcWindow() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_creatPreviewCcWindow, _data, _reply, 0);
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

            public boolean drawPreviewCc(CaptionOptionSetting setting) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (setting != null) {
                        _data.writeInt(Stub.TRANSACTION_startCc);
                        setting.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_drawPreviewCc, _data, _reply, 0);
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

            public boolean exitPreviewCc() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_exitPreviewCc, _data, _reply, 0);
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

            public CCSetting getCCSetting() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    CCSetting _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCCSetting, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (CCSetting) CCSetting.CREATOR.createFromParcel(_reply);
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

            public void setCCSetting(CCSetting setting) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (setting != null) {
                        _data.writeInt(Stub.TRANSACTION_startCc);
                        setting.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_setCCSetting, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public CaptionOptionSetting getAdvancedSetting(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    CaptionOptionSetting _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_getAdvancedSetting, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (CaptionOptionSetting) CaptionOptionSetting.CREATOR.createFromParcel(_reply);
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

            public void setAdvancedSetting(CaptionOptionSetting setting, int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (setting != null) {
                        _data.writeInt(Stub.TRANSACTION_startCc);
                        setting.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(index);
                    this.mRemote.transact(Stub.TRANSACTION_setAdvancedSetting, _data, _reply, 0);
                    _reply.readException();
                } finally {
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvCc asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvCc)) {
                return new Proxy(obj);
            }
            return (ITvCc) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            boolean _result;
            CaptionOptionSetting _arg0;
            switch (code) {
                case TRANSACTION_startCc /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = startCc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_stopCc /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = stopCc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_creatPreviewCcWindow /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = creatPreviewCcWindow();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_drawPreviewCc /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (CaptionOptionSetting) CaptionOptionSetting.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    _result = drawPreviewCc(_arg0);
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_exitPreviewCc /*5*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = exitPreviewCc();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_getCCSetting /*6*/:
                    data.enforceInterface(DESCRIPTOR);
                    CCSetting _result2 = getCCSetting();
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(TRANSACTION_startCc);
                        _result2.writeToParcel(reply, TRANSACTION_startCc);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setCCSetting /*7*/:
                    CCSetting _arg02;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (CCSetting) CCSetting.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    setCCSetting(_arg02);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAdvancedSetting /*8*/:
                    data.enforceInterface(DESCRIPTOR);
                    CaptionOptionSetting _result3 = getAdvancedSetting(data.readInt());
                    reply.writeNoException();
                    if (_result3 != null) {
                        reply.writeInt(TRANSACTION_startCc);
                        _result3.writeToParcel(reply, TRANSACTION_startCc);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_setAdvancedSetting /*9*/:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (CaptionOptionSetting) CaptionOptionSetting.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    setAdvancedSetting(_arg0, data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_doesCcExist /*10*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = doesCcExist();
                    reply.writeNoException();
                    if (_result) {
                        i = TRANSACTION_startCc;
                    }
                    reply.writeInt(i);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean creatPreviewCcWindow() throws RemoteException;

    boolean doesCcExist() throws RemoteException;

    boolean drawPreviewCc(CaptionOptionSetting captionOptionSetting) throws RemoteException;

    boolean exitPreviewCc() throws RemoteException;

    CaptionOptionSetting getAdvancedSetting(int i) throws RemoteException;

    CCSetting getCCSetting() throws RemoteException;

    void setAdvancedSetting(CaptionOptionSetting captionOptionSetting, int i) throws RemoteException;

    void setCCSetting(CCSetting cCSetting) throws RemoteException;

    boolean startCc() throws RemoteException;

    boolean stopCc() throws RemoteException;
}
