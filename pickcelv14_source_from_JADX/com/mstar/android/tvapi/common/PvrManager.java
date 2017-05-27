package com.mstar.android.tvapi.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mstar.android.tvapi.common.exception.TvCommonException;
import com.mstar.android.tvapi.common.vo.CaptureThumbnailResult;
import com.mstar.android.tvapi.common.vo.EnumPvrStatus;
import com.mstar.android.tvapi.common.vo.PvrFileInfo;
import com.mstar.android.tvapi.common.vo.PvrPlaybackSpeed.EnumPvrPlaybackSpeed;
import com.mstar.android.tvapi.common.vo.PvrUsbDeviceLabel.EnumPvrUsbDeviceLabel;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.lang.ref.WeakReference;

public final class PvrManager {
    public static final int E_FILE_SYSTEM_TYPE_EXFAT = 7;
    public static final int E_FILE_SYSTEM_TYPE_EXT2 = 3;
    public static final int E_FILE_SYSTEM_TYPE_EXT3 = 4;
    public static final int E_FILE_SYSTEM_TYPE_EXT4 = 8;
    public static final int E_FILE_SYSTEM_TYPE_INVALID = 9;
    public static final int E_FILE_SYSTEM_TYPE_JFFS2 = 1;
    public static final int E_FILE_SYSTEM_TYPE_MSDOS = 5;
    public static final int E_FILE_SYSTEM_TYPE_NTFS = 6;
    public static final int E_FILE_SYSTEM_TYPE_UNKNOWN = 0;
    public static final int E_FILE_SYSTEM_TYPE_VFAT = 2;
    public static final int PVR_FILE_INFO_SORT_CHANNEL = 3;
    public static final int PVR_FILE_INFO_SORT_FILENAME = 0;
    public static final int PVR_FILE_INFO_SORT_LCN = 2;
    public static final int PVR_FILE_INFO_SORT_MAX_KEY = 5;
    public static final int PVR_FILE_INFO_SORT_PROGRAM = 4;
    public static final int PVR_FILE_INFO_SORT_TIME = 1;
    private static PvrManager _pvrManager;
    private EventHandler mEventHandler;
    private int mNativeContext;
    private OnPvrEventListener mOnEventListener;
    private int mPvrManagerContext;

    /* renamed from: com.mstar.android.tvapi.common.PvrManager.1 */
    static /* synthetic */ class C01151 {
        static final /* synthetic */ int[] $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT;

        static {
            $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT = new int[EVENT.values().length];
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[EVENT.EV_PVR_NOTIFY_USB_INSERTED.ordinal()] = PvrManager.PVR_FILE_INFO_SORT_TIME;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[EVENT.EV_PVR_NOTIFY_USB_REMOVED.ordinal()] = PvrManager.PVR_FILE_INFO_SORT_LCN;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[EVENT.EV_PVR_NOTIFY_FORMAT_FINISHED.ordinal()] = PvrManager.PVR_FILE_INFO_SORT_CHANNEL;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_STOP.ordinal()] = PvrManager.PVR_FILE_INFO_SORT_PROGRAM;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[EVENT.EV_PVR_NOTIFY_PLAYBACK_BEGIN.ordinal()] = PvrManager.PVR_FILE_INFO_SORT_MAX_KEY;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    protected enum EVENT {
        EV_PVR_NOTIFY_USB_INSERTED,
        EV_PVR_NOTIFY_USB_REMOVED,
        EV_PVR_NOTIFY_FORMAT_FINISHED,
        EV_PVR_NOTIFY_PLAYBACK_STOP,
        EV_PVR_NOTIFY_PLAYBACK_BEGIN,
        EV_MAX
    }

    private class EventHandler extends Handler {
        private PvrManager mMSrv;

        public EventHandler(PvrManager srv, Looper looper) {
            super(looper);
            this.mMSrv = srv;
        }

        public void handleMessage(Message msg) {
            if (this.mMSrv.mNativeContext != 0) {
                EVENT[] ev = EVENT.values();
                if (msg.what > EVENT.EV_MAX.ordinal() || msg.what < EVENT.EV_PVR_NOTIFY_USB_INSERTED.ordinal()) {
                    Log.e(getClass().getCanonicalName(), "Native post event out of bound:" + Integer.toString(msg.what));
                    return;
                }
                switch (C01151.$SwitchMap$com$mstar$android$tvapi$common$PvrManager$EVENT[ev[msg.what].ordinal()]) {
                    case PvrManager.PVR_FILE_INFO_SORT_TIME /*1*/:
                        if (PvrManager.this.mOnEventListener != null) {
                            PvrManager.this.mOnEventListener.onPvrNotifyUsbInserted(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case PvrManager.PVR_FILE_INFO_SORT_LCN /*2*/:
                        if (PvrManager.this.mOnEventListener != null) {
                            PvrManager.this.mOnEventListener.onPvrNotifyUsbRemoved(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case PvrManager.PVR_FILE_INFO_SORT_CHANNEL /*3*/:
                        if (PvrManager.this.mOnEventListener != null) {
                            PvrManager.this.mOnEventListener.onPvrNotifyFormatFinished(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case PvrManager.PVR_FILE_INFO_SORT_PROGRAM /*4*/:
                        if (PvrManager.this.mOnEventListener != null) {
                            PvrManager.this.mOnEventListener.onPvrNotifyPlaybackStop(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    case PvrManager.PVR_FILE_INFO_SORT_MAX_KEY /*5*/:
                        if (PvrManager.this.mOnEventListener != null) {
                            PvrManager.this.mOnEventListener.onPvrNotifyPlaybackBegin(this.mMSrv, msg.what, msg.arg1, msg.arg2);
                        }
                    default:
                        System.err.println("Unknown message type " + msg.what);
                }
            }
        }
    }

    public interface OnPvrEventListener {
        boolean onPvrNotifyFormatFinished(PvrManager pvrManager, int i, int i2, int i3);

        boolean onPvrNotifyPlaybackBegin(PvrManager pvrManager, int i, int i2, int i3);

        boolean onPvrNotifyPlaybackStop(PvrManager pvrManager, int i, int i2, int i3);

        boolean onPvrNotifyUsbInserted(PvrManager pvrManager, int i, int i2, int i3);

        boolean onPvrNotifyUsbRemoved(PvrManager pvrManager, int i, int i2, int i3);
    }

    private final native void native_finalize();

    private final native boolean native_getIsBootByRecord();

    private final native int native_getPlaybackSpeed() throws TvCommonException;

    private final native int native_getUsbDeviceLabel(int i) throws TvCommonException;

    private static final native void native_init();

    private final native boolean native_isSupportISDB();

    private final native boolean native_isSupportStandBy();

    private final native int native_pauseAlwaysTimeShiftPlayback(boolean z) throws TvCommonException;

    private final native void native_setIsBootByRecord(boolean z);

    private final native void native_setPlaybackSpeed(int i) throws TvCommonException;

    private final native void native_setPvrRecordStandByOnOff(boolean z);

    private final native void native_setup(Object obj);

    private final native int native_startPlayback(String str) throws TvCommonException;

    private final native int native_startPlayback(String str, int i) throws TvCommonException;

    private final native int native_startPlayback(String str, int i, int i2) throws TvCommonException;

    private final native int native_startRecord() throws TvCommonException;

    private final native int native_startTimeShiftPlayback() throws TvCommonException;

    private final native int native_startTimeShiftRecord() throws TvCommonException;

    public final native boolean assignThumbnailFileInfoHandler(String str) throws TvCommonException;

    public final native CaptureThumbnailResult captureThumbnail() throws TvCommonException;

    public native boolean changeDevice(short s) throws TvCommonException;

    public final native int checkUsbSpeed() throws TvCommonException;

    public final native void clearMetadata() throws TvCommonException;

    public final native boolean createMetadata(String str) throws TvCommonException;

    public final native void deletefile(int i, String str) throws TvCommonException;

    public final native void doPlaybackFastBackward() throws TvCommonException;

    public final native void doPlaybackFastForward() throws TvCommonException;

    public final native void doPlaybackJumpBackward() throws TvCommonException;

    public final native void doPlaybackJumpForward() throws TvCommonException;

    public final native int getCurPlaybackTimeInSecond() throws TvCommonException;

    public final native String getCurPlaybackingFileName() throws TvCommonException;

    public final native int getCurRecordTimeInSecond() throws TvCommonException;

    public final native String getCurRecordingFileName() throws TvCommonException;

    public final native int getEstimateRecordRemainingTime() throws TvCommonException;

    public final native String getFileEventName(String str) throws TvCommonException;

    public final native int getFileLcn(int i) throws TvCommonException;

    public final native String getFileServiceName(String str) throws TvCommonException;

    public final native int getMetadataSortKey() throws TvCommonException;

    public final native PvrFileInfo getPvrFileInfo(int i, int i2) throws TvCommonException;

    public final native int getPvrFileNumber() throws TvCommonException;

    public final native String getPvrMountPath() throws TvCommonException;

    public final native int getRecordedFileDurationTime(String str) throws TvCommonException;

    public final native String getThumbnailDisplay(int i) throws TvCommonException;

    public final native int getThumbnailNumber() throws TvCommonException;

    public final native String getThumbnailPath(int i) throws TvCommonException;

    public final native int[] getThumbnailTimeStamp(int i) throws TvCommonException;

    public final native short getUsbDeviceIndex() throws TvCommonException;

    public final native int getUsbDeviceNumber() throws TvCommonException;

    public final native int getUsbPartitionNumber() throws TvCommonException;

    public final native boolean isAlwaysTimeShift() throws TvCommonException;

    public final native boolean isAlwaysTimeShiftPlaybackPaused() throws TvCommonException;

    public final native boolean isAlwaysTimeShiftRecording() throws TvCommonException;

    public final native boolean isMetadataSortAscending() throws TvCommonException;

    public final native boolean isPlaybackParentalLock() throws TvCommonException;

    public final native boolean isPlaybackPaused() throws TvCommonException;

    public final native boolean isPlaybacking() throws TvCommonException;

    public final native boolean isRecordPaused() throws TvCommonException;

    public final native boolean isRecording() throws TvCommonException;

    public final native boolean isTimeShiftRecording() throws TvCommonException;

    public final native boolean jumpPlaybackTime(int i) throws TvCommonException;

    public final native boolean jumpToThumbnail(int i) throws TvCommonException;

    public final native short pauseAlwaysTimeShiftRecord() throws TvCommonException;

    public final native void pausePlayback() throws TvCommonException;

    public final native void pauseRecord() throws TvCommonException;

    public final native void resumePlayback() throws TvCommonException;

    public final native void resumeRecord() throws TvCommonException;

    public final native void setAlwaysTimeShift(boolean z) throws TvCommonException;

    public native void setDebugMode(boolean z) throws TvCommonException;

    public final native void setMetadataSortAscending(boolean z) throws TvCommonException;

    public final native void setMetadataSortKey(int i) throws TvCommonException;

    public final native void setPlaybackWindow(VideoWindowType videoWindowType, int i, int i2) throws TvCommonException;

    public final native boolean setPvrParams(String str, short s) throws TvCommonException;

    public final native void setRecordAll(boolean z) throws TvCommonException;

    public final native void setTimeShiftFileSize(long j) throws TvCommonException;

    public final native short startAlwaysTimeShiftPlayback() throws TvCommonException;

    public final native short startAlwaysTimeShiftRecord() throws TvCommonException;

    public final native void startPlaybackLoop(int i, int i2) throws TvCommonException;

    public final native void stepInPlayback() throws TvCommonException;

    public final native void stopAlwaysTimeShiftPlayback() throws TvCommonException;

    public final native short stopAlwaysTimeShiftRecord() throws TvCommonException;

    public final native void stopPlayback() throws TvCommonException;

    public final native void stopPlaybackLoop() throws TvCommonException;

    public final native boolean stopPvr() throws TvCommonException;

    public final native void stopRecord() throws TvCommonException;

    public final native void stopTimeShift() throws TvCommonException;

    public final native void stopTimeShiftPlayback() throws TvCommonException;

    public final native void stopTimeShiftRecord() throws TvCommonException;

    static {
        _pvrManager = null;
        try {
            System.loadLibrary("pvrmanager_jni");
            native_init();
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load pvrmanager_jni library:\n" + e.toString());
        }
    }

    protected static PvrManager getInstance() {
        if (_pvrManager == null) {
            synchronized (PvrManager.class) {
                if (_pvrManager == null) {
                    _pvrManager = new PvrManager();
                }
            }
        }
        return _pvrManager;
    }

    public final EnumPvrStatus startRecord() throws TvCommonException {
        int iReturn = native_startRecord();
        if (iReturn >= 0 && iReturn <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[iReturn];
        }
        throw new TvCommonException("startRecord failed");
    }

    public EnumPvrStatus startPlayback(String fileName) throws TvCommonException {
        int ret = native_startPlayback(fileName);
        if (ret >= 0 && ret <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[ret];
        }
        throw new TvCommonException("startPlayback failed");
    }

    public final EnumPvrStatus startPlayback(String fileName, int playbackTimeInSecond) throws TvCommonException {
        int iReturn = native_startPlayback(fileName, playbackTimeInSecond);
        if (iReturn >= 0 && iReturn <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[iReturn];
        }
        throw new TvCommonException("startPlayback failed");
    }

    public final EnumPvrStatus startPlayback(String fileName, int playbackTimeInSecond, int thumbnailPts) throws TvCommonException {
        int iReturn = native_startPlayback(fileName, playbackTimeInSecond, thumbnailPts);
        if (iReturn >= 0 && iReturn <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[iReturn];
        }
        throw new TvCommonException("startPlayback failed");
    }

    public final void setPlaybackSpeed(EnumPvrPlaybackSpeed playbackSpeed) throws TvCommonException {
        native_setPlaybackSpeed(playbackSpeed.getValue());
    }

    public final EnumPvrPlaybackSpeed getPlaybackSpeed() throws TvCommonException {
        int iordinal = EnumPvrPlaybackSpeed.getOrdinalThroughValue(native_getPlaybackSpeed());
        if (iordinal != -1) {
            return EnumPvrPlaybackSpeed.values()[iordinal];
        }
        throw new TvCommonException("get playbackspeed failed \n");
    }

    public EnumPvrStatus startTimeShiftRecord() throws TvCommonException {
        int ret = native_startTimeShiftRecord();
        if (ret >= EnumPvrStatus.E_SUCCESS.ordinal() && ret <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[ret];
        }
        throw new TvCommonException("startTimeShiftRecord failed");
    }

    public void setIsBootByRecord(boolean isBootByRecord) {
        native_setIsBootByRecord(isBootByRecord);
    }

    public boolean getIsBootByRecord() {
        return native_getIsBootByRecord();
    }

    public void setPvrRecordStandByOnOff(boolean on) {
        native_setPvrRecordStandByOnOff(on);
    }

    public boolean isSupportISDB() {
        return native_isSupportISDB();
    }

    public boolean isSupportStandBy() {
        return native_isSupportStandBy();
    }

    public final EnumPvrStatus pauseAlwaysTimeShiftPlayback(boolean ready) throws TvCommonException {
        int iReturn = native_pauseAlwaysTimeShiftPlayback(ready);
        if (iReturn >= EnumPvrStatus.E_SUCCESS.ordinal() && iReturn <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[iReturn];
        }
        throw new TvCommonException("pauseAlwaysTimeShiftPlayback failed");
    }

    public final EnumPvrStatus startTimeShiftPlayback() throws TvCommonException {
        int iReturn = native_startTimeShiftPlayback();
        if (iReturn >= EnumPvrStatus.E_SUCCESS.ordinal() && iReturn <= EnumPvrStatus.E_NUM.ordinal()) {
            return EnumPvrStatus.values()[iReturn];
        }
        throw new TvCommonException("startTimeShiftPlayback failed");
    }

    public final EnumPvrUsbDeviceLabel getUsbDeviceLabel(int deviceIndex) throws TvCommonException {
        int iordinal = EnumPvrUsbDeviceLabel.getOrdinalThroughValue(native_getUsbDeviceLabel(deviceIndex));
        if (iordinal != -1) {
            return EnumPvrUsbDeviceLabel.values()[iordinal];
        }
        throw new TvCommonException("getusbdevicelabel failed");
    }

    private PvrManager() {
        Looper looper = Looper.myLooper();
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            looper = Looper.getMainLooper();
            if (looper != null) {
                this.mEventHandler = new EventHandler(this, looper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    public void setOnPvrEventListener(OnPvrEventListener listener) {
        this.mOnEventListener = listener;
    }

    private static void postEventFromNative(Object srv_ref, int what, int arg1, int arg2, Object obj) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(what, arg1, arg2, obj));
            }
            System.out.println("\n Native Pvr callback, postEventFromNative");
        }
    }

    private static void PostEvent_UsbInserted(Object srv_ref, int arg1, int arg2) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_USB_INSERTED.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Pvr callback, PostEvent_UsbInserted");
        }
    }

    private static void PostEvent_UsbRemoved(Object srv_ref, int arg1, int arg2) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_USB_REMOVED.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Pvr callback, PostEvent_UsbRemoved");
        }
    }

    private static void PostEvent_FormatFinished(Object srv_ref, int arg1, int arg2) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_FORMAT_FINISHED.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Pvr callback, PostEvent_FormatFinished");
        }
    }

    private static void PostEvent_PlaybackStop(Object srv_ref, int arg1, int arg2) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_STOP.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Pvr callback, PostEvent_PlayBackStop");
        }
    }

    private static void PostEvent_PlaybackBegin(Object srv_ref, int arg1, int arg2) {
        PvrManager srv = (PvrManager) ((WeakReference) srv_ref).get();
        if (srv != null) {
            if (srv.mEventHandler != null) {
                srv.mEventHandler.sendMessage(srv.mEventHandler.obtainMessage(EVENT.EV_PVR_NOTIFY_PLAYBACK_BEGIN.ordinal(), arg1, arg2));
            }
            System.out.println("\n Native Pvr callback, PostEvent_Playbackbegin");
        }
    }

    private static void PostEvent_SnServiceDeadth(Object srv_ref, int arg1, int arg2) {
    }

    protected void release() throws Throwable {
        _pvrManager = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
        _pvrManager = null;
    }
}
