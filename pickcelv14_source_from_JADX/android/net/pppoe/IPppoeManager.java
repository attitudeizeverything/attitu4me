package android.net.pppoe;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPppoeManager extends IInterface {

    public static abstract class Stub extends Binder implements IPppoeManager {
        private static final String DESCRIPTOR = "android.net.pppoe.IPppoeManager";
        static final int TRANSACTION_getPppoeStatus = 2;
        static final int TRANSACTION_setPppoeStatus = 1;

        private static class Proxy implements IPppoeManager {
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

            public void setPppoeStatus(String status, boolean sendBroadcast) throws RemoteException {
                int i = Stub.TRANSACTION_setPppoeStatus;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(status);
                    if (!sendBroadcast) {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPppoeStatus, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getPppoeStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPppoeStatus, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
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

        public static IPppoeManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IPppoeManager)) {
                return new Proxy(obj);
            }
            return (IPppoeManager) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case TRANSACTION_setPppoeStatus /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    setPppoeStatus(data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getPppoeStatus /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    String _result = getPppoeStatus();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getPppoeStatus() throws RemoteException;

    void setPppoeStatus(String str, boolean z) throws RemoteException;
}
