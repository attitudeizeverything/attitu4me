package com.mstar.android.storage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.storage.IISOActionListener.Stub;
import android.os.storage.IMountService;
import android.os.storage.StorageVolume;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MStorageManager {
    private static final String TAG = "MStorageManager";
    static MStorageManager mInstance;
    static final Object mInstanceSync;
    private static MStorageManager mMStorageManager;
    private ISOActionListener mISOActionListener;
    private final AtomicInteger mNextNonce;
    IMountService mService;
    Looper mTgtLooper;

    private class ISOActionListener extends Stub {
        private HashMap<Integer, ISOListenerDelegate> mListeners;
        private HashMap<OnISOEvnetListener, ArrayList<Integer>> nonces;

        private ISOActionListener() {
            this.mListeners = new HashMap();
            this.nonces = new HashMap();
        }

        public void onISOEvent(String filename, int nonce, int status) {
            synchronized (this.mListeners) {
                ISOListenerDelegate delegate = (ISOListenerDelegate) this.mListeners.get(Integer.valueOf(nonce));
                if (delegate != null) {
                    if (delegate.getListener() == null) {
                        removeListener(null, Integer.valueOf(nonce));
                        return;
                    }
                    delegate.sendISOStateChanged(filename, status);
                }
            }
        }

        public Integer addListener(OnISOEvnetListener listener) {
            ISOListenerDelegate delegate = new ISOListenerDelegate(listener);
            Integer nonce = new Integer(delegate.nonce);
            synchronized (this.mListeners) {
                synchronized (this.nonces) {
                    this.mListeners.put(nonce, delegate);
                    ArrayList<Integer> array = (ArrayList) this.nonces.get(listener);
                    if (array == null) {
                        array = new ArrayList(1);
                        this.nonces.put(listener, array);
                    }
                    array.add(nonce);
                }
            }
            return nonce;
        }

        public void removeListener(OnISOEvnetListener listener) {
            synchronized (this.mListeners) {
                synchronized (this.nonces) {
                    ArrayList<Integer> array = (ArrayList) this.nonces.remove(listener);
                    if (array != null) {
                        for (int i = 0; i < array.size(); i++) {
                            this.mListeners.remove(array.get(i));
                        }
                    }
                }
            }
        }

        public void removeListener(OnISOEvnetListener listener, Integer nonce) {
            if (nonce != null) {
                synchronized (this.mListeners) {
                    synchronized (this.nonces) {
                        ArrayList<Integer> array = (ArrayList) this.nonces.get(listener);
                        if (array != null) {
                            array.remove(nonce);
                            if (array.size() == 0) {
                                this.nonces.remove(listener);
                            }
                            this.mListeners.remove(nonce);
                        }
                    }
                }
            }
        }
    }

    private class ISOListenerDelegate {
        private final Handler mHandler;
        private final OnISOEvnetListener mISOEvnetListener;
        private final int nonce;

        /* renamed from: com.mstar.android.storage.MStorageManager.ISOListenerDelegate.1 */
        class C01021 extends Handler {
            final /* synthetic */ MStorageManager val$this$0;

            C01021(Looper x0, MStorageManager mStorageManager) {
                this.val$this$0 = mStorageManager;
                super(x0);
            }

            public void handleMessage(Message msg) {
                OnISOEvnetListener listener = ISOListenerDelegate.this.getListener();
                if (listener != null) {
                    StorageEvent e = msg.obj;
                    if (msg.what == 4) {
                        ISOStateChangedStorageEvent ev = (ISOStateChangedStorageEvent) e;
                        listener.onISOStateChange(ev.path, ev.state);
                        return;
                    }
                    Log.e(MStorageManager.TAG, "Unsupported event " + msg.what);
                }
            }
        }

        public ISOListenerDelegate(OnISOEvnetListener listener) {
            this.nonce = MStorageManager.this.getNextNonce();
            this.mISOEvnetListener = listener;
            this.mHandler = new C01021(MStorageManager.this.mTgtLooper, MStorageManager.this);
        }

        public OnISOEvnetListener getListener() {
            return this.mISOEvnetListener;
        }

        public void sendISOStateChanged(String path, int state) {
            this.mHandler.sendMessage(new ISOStateChangedStorageEvent(path, state).getMessage());
        }
    }

    private class StorageEvent {
        static final int EVENT_ISO_STATE_CHANGED = 4;
        private Message mMessage;

        public StorageEvent(int what) {
            this.mMessage = Message.obtain();
            this.mMessage.what = what;
            this.mMessage.obj = this;
        }

        public Message getMessage() {
            return this.mMessage;
        }
    }

    private class ISOStateChangedStorageEvent extends StorageEvent {
        public final String path;
        public final int state;

        public ISOStateChangedStorageEvent(String path, int state) {
            super(4);
            this.path = path;
            this.state = state;
        }
    }

    static {
        mInstanceSync = new Object();
        mInstance = null;
        mMStorageManager = null;
    }

    private int getNextNonce() {
        return this.mNextNonce.getAndIncrement();
    }

    private MStorageManager(IMountService service, Looper tgtLooper) {
        this.mService = null;
        this.mISOActionListener = new ISOActionListener();
        this.mNextNonce = new AtomicInteger(0);
        this.mService = service;
        this.mTgtLooper = tgtLooper;
    }

    public static MStorageManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mInstanceSync) {
                if (mInstance == null) {
                    mInstance = new MStorageManager(IMountService.Stub.asInterface(ServiceManager.getService("mount")), context.getMainLooper());
                }
            }
        }
        return mInstance;
    }

    public String getVolumeState(String mountPoint) {
        if (this.mService == null) {
            return "removed";
        }
        try {
            return this.mService.getVolumeState(mountPoint);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume state", e);
            return null;
        }
    }

    public StorageVolume[] getVolumeList() {
        if (this.mService == null) {
            return new StorageVolume[0];
        }
        try {
            Parcelable[] list = this.mService.getVolumeList();
            if (list == null) {
                return new StorageVolume[0];
            }
            int length = list.length;
            StorageVolume[] result = new StorageVolume[length];
            for (int i = 0; i < length; i++) {
                result[i] = (StorageVolume) list[i];
            }
            return result;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume list", e);
            return null;
        }
    }

    public String[] getVolumePaths() {
        StorageVolume[] volumes = getVolumeList();
        if (volumes == null) {
            return null;
        }
        int count = volumes.length;
        String[] paths = new String[count];
        for (int i = 0; i < count; i++) {
            paths[i] = volumes[i].getPath();
        }
        return paths;
    }

    public String getVolumeLabel(String mountPoint) {
        try {
            return this.mService.getVolumeLabel(mountPoint);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume label", e);
            return null;
        }
    }

    public String getVolumeUUID(String mountPoint) {
        try {
            return this.mService.getVolumeUUID(mountPoint);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume uuid", e);
            return null;
        }
    }

    public void unmountVolume(String mountPoint, boolean force, boolean removeEncryption) {
        try {
            this.mService.unmountVolume(mountPoint, force, removeEncryption);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to unmount volume", e);
        }
    }

    public boolean formatVolume(String mountPoint) {
        try {
            if (this.mService.formatVolume(mountPoint) == 0) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to format volume", e);
            return false;
        }
    }

    public boolean mountVolume(String mountPoint) {
        try {
            if (this.mService.mountVolume(mountPoint) == 0) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount volume", e);
            return false;
        }
    }

    public boolean mountISO(String filename, OnISOEvnetListener listener) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        try {
            Integer nonce = this.mISOActionListener.addListener(listener);
            boolean res = this.mService.mountISO(filename, this.mISOActionListener, nonce.intValue());
            if (res) {
                return res;
            }
            this.mISOActionListener.removeListener(listener, nonce);
            return res;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount ISO", e);
            return false;
        }
    }

    public void removeOnISOEvnetListener(OnISOEvnetListener listener) {
        this.mISOActionListener.removeListener(listener);
    }

    public String getISOFileMountPath(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        try {
            return this.mService.getISOFileMountPath(filename);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get the mount path of the ISO file", e);
            return null;
        }
    }

    public boolean isISOFileMounted(String filename) {
        return getISOFileMountPath(filename) != null;
    }

    public boolean unmountISO(String filename, boolean force) {
        if (filename == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        try {
            return this.mService.unmountISO(filename, force);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to unmount ISO", e);
            return false;
        }
    }

    public String[] getMountedISOFileList() {
        try {
            return this.mService.getMountedISOFileList();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get the mounted ISO files", e);
            return null;
        }
    }

    public boolean mountSamba(String host, String shareDirectory, String mountPoint, String userName, String password) {
        try {
            return this.mService.mountSamba(host, shareDirectory, mountPoint, userName, password, false, true);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount Samba", e);
            return false;
        }
    }

    public boolean unmountSamba(String mountPoint, boolean force) {
        try {
            return this.mService.unmountSamba(mountPoint, force);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to unmount Samba", e);
            return false;
        }
    }
}
