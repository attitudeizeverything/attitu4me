package com.mstar.android.tv;

import android.os.RemoteException;
import android.util.Log;
import com.mstar.android.tv.IPvrEventClient.Stub;
import com.mstar.android.tvapi.common.PvrManager.OnPvrEventListener;
import com.mstar.android.tvapi.common.TvManager;
import com.mstar.android.tvapi.common.vo.CaptureThumbnailResult;
import com.mstar.android.tvapi.common.vo.EnumPvrStatus;
import com.mstar.android.tvapi.common.vo.PvrFileInfo;
import com.mstar.android.tvapi.common.vo.PvrPlaybackSpeed.EnumPvrPlaybackSpeed;
import com.mstar.android.tvapi.common.vo.VideoWindowType;
import java.util.HashMap;

public class TvPvrManager {
    private static final String TAG = "TvPvrManager";
    static TvPvrManager mInstance;
    private static ITvPvr mService;
    private Client pvrClient;
    private HashMap<String, OnPvrEventListener> pvrListeners;

    private class Client extends Stub {
        private Client() {
        }

        public boolean onPvrNotifyUsbInserted(int what, int arg1, int arg2) throws RemoteException {
            for (OnPvrEventListener l : TvPvrManager.this.pvrListeners.values()) {
                l.onPvrNotifyUsbInserted(TvManager.getInstance().getPvrManager(), what, arg1, arg2);
            }
            return true;
        }

        public boolean onPvrNotifyUsbRemoved(int what, int arg1, int arg2) throws RemoteException {
            for (OnPvrEventListener l : TvPvrManager.this.pvrListeners.values()) {
                l.onPvrNotifyUsbRemoved(TvManager.getInstance().getPvrManager(), what, arg1, arg2);
            }
            return true;
        }

        public boolean onPvrNotifyFormatFinished(int what, int arg1, int arg2) throws RemoteException {
            for (OnPvrEventListener l : TvPvrManager.this.pvrListeners.values()) {
                l.onPvrNotifyFormatFinished(TvManager.getInstance().getPvrManager(), what, arg1, arg2);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackBegin(int what, int arg1, int arg2) throws RemoteException {
            for (OnPvrEventListener l : TvPvrManager.this.pvrListeners.values()) {
                l.onPvrNotifyPlaybackBegin(TvManager.getInstance().getPvrManager(), what, arg1, arg2);
            }
            return true;
        }

        public boolean onPvrNotifyPlaybackStop(int what, int arg1, int arg2) throws RemoteException {
            for (OnPvrEventListener l : TvPvrManager.this.pvrListeners.values()) {
                l.onPvrNotifyPlaybackStop(TvManager.getInstance().getPvrManager(), what, arg1, arg2);
            }
            return true;
        }
    }

    static {
        mInstance = null;
        mService = null;
    }

    private TvPvrManager() {
        this.pvrListeners = new HashMap();
    }

    public static TvPvrManager getInstance() {
        if (mInstance == null) {
            synchronized (TvPvrManager.class) {
                if (mInstance == null) {
                    mInstance = new TvPvrManager();
                }
            }
        }
        return mInstance;
    }

    private static ITvPvr getService() {
        if (mService != null) {
            return mService;
        }
        mService = TvManager.getInstance().getTvPvr();
        return mService;
    }

    public EnumPvrStatus startRecord() {
        try {
            return EnumPvrStatus.values()[getService().startRecord()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stopRecord() {
        try {
            getService().stopRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void pauseRecord() {
        try {
            getService().pauseRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void resumeRecord() {
        try {
            getService().resumeRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public short startAlwaysTimeShiftRecord() {
        try {
            return (short) getService().startAlwaysTimeShiftRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) -1;
        }
    }

    public short stopAlwaysTimeShiftRecord() {
        try {
            return (short) getService().stopAlwaysTimeShiftRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) -1;
        }
    }

    public short pauseAlwaysTimeShiftRecord() {
        try {
            return (short) getService().stopAlwaysTimeShiftRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) -1;
        }
    }

    public short startAlwaysTimeShiftPlayback() {
        try {
            return (short) getService().stopAlwaysTimeShiftRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) -1;
        }
    }

    public void stopAlwaysTimeShiftPlayback() {
        try {
            getService().stopAlwaysTimeShiftPlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumPvrStatus pauseAlwaysTimeShiftPlayback(boolean ready) {
        try {
            return EnumPvrStatus.values()[getService().pauseAlwaysTimeShiftPlayback(ready)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isAlwaysTimeShiftPlaybackPaused() {
        try {
            return getService().isAlwaysTimeShiftPlaybackPaused();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAlwaysTimeShiftRecording() {
        try {
            return getService().isAlwaysTimeShiftRecording();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPvrStatus startPlayback(String fileName) {
        try {
            return EnumPvrStatus.values()[getService().startPlayback(fileName)];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAlwaysTimeShift(boolean open) {
        try {
            getService().setAlwaysTimeShift(open);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isAlwaysTimeShift() {
        try {
            return getService().isAlwaysTimeShift();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void pausePlayback() {
        try {
            getService().pausePlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void resumePlayback() {
        try {
            getService().resumePlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stopPlayback() {
        try {
            getService().stopPlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stepInPlayback() {
        try {
            getService().stepInPlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void startPlaybackLoop(int abLoopBeginTime, int abLoopEndTime) {
        try {
            getService().startPlaybackLoop(abLoopBeginTime, abLoopEndTime);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stopPlaybackLoop() {
        try {
            getService().stopPlaybackLoop();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setPlaybackSpeed(EnumPvrPlaybackSpeed playbackSpeed) {
        try {
            getService().setPlaybackSpeed(playbackSpeed.ordinal());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumPvrPlaybackSpeed getPlaybackSpeed() {
        try {
            return EnumPvrPlaybackSpeed.values()[getService().getPlaybackSpeed()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean jumpPlaybackTime(int jumpToTimeInSeconds) {
        try {
            return getService().jumpPlaybackTime(jumpToTimeInSeconds);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EnumPvrStatus startTimeShiftRecord() {
        try {
            return EnumPvrStatus.values()[getService().startTimeShiftRecord()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stopTimeShiftRecord() {
        try {
            getService().stopTimeShiftRecord();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public EnumPvrStatus startTimeShiftPlayback() {
        try {
            return EnumPvrStatus.values()[getService().startTimeShiftPlayback()];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stopTimeShiftPlayback() {
        try {
            getService().stopTimeShiftPlayback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stopTimeShift() {
        try {
            getService().stopTimeShift();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean stopPvr() {
        try {
            return getService().stopPvr();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isRecording() {
        try {
            return getService().isRecording();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPlaybacking() {
        try {
            return getService().isPlaybacking();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isTimeShiftRecording() {
        try {
            return getService().isTimeShiftRecording();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPlaybackPaused() {
        try {
            return getService().isPlaybackPaused();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isRecordPaused() {
        try {
            return getService().isRecordPaused();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setPlaybackWindow(VideoWindowType videoWindowType, int containerWidth, int containerHeight) {
        try {
            getService().setPlaybackWindow(videoWindowType, containerWidth, containerHeight);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getCurRecordingFileName() {
        try {
            return getService().getCurRecordingFileName();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCurPlaybackingFileName() {
        try {
            return getService().getCurPlaybackingFileName();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCurPlaybackTimeInSecond() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getCurPlaybackTimeInSecond();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public int getCurRecordTimeInSecond() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getCurRecordTimeInSecond();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public boolean jumpToThumbnail(int thumbnailIndex) {
        try {
            return getService().jumpToThumbnail(thumbnailIndex);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setTimeShiftFileSize(long timeShiftFileSizeInKb) {
        try {
            getService().setTimeShiftFileSize(timeShiftFileSizeInKb);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public CaptureThumbnailResult captureThumbnail() {
        try {
            return getService().captureThumbnail();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int checkUsbSpeed() {
        int recordStatus = -1;
        try {
            recordStatus = getService().checkUsbSpeed();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public int getUsbPartitionNumber() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getUsbPartitionNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public int getUsbDeviceNumber() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getUsbDeviceNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public short getUsbDeviceIndex() {
        try {
            return (short) getService().getUsbDeviceIndex();
        } catch (RemoteException e) {
            e.printStackTrace();
            return (short) -1;
        }
    }

    public int getPvrFileNumber() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getPvrFileNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public PvrFileInfo getPvrFileInfo(int index, int nSortKey) {
        try {
            return getService().getPvrFileInfo(index, nSortKey);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getFileLcn(int index) {
        int recordStatus = -1;
        try {
            recordStatus = getService().getFileLcn(index);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public String getFileServiceName(String fileName) {
        try {
            return getService().getFileServiceName(fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFileEventName(String fileName) {
        try {
            return getService().getFileEventName(fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean assignThumbnailFileInfoHandler(String fileName) {
        try {
            return getService().assignThumbnailFileInfoHandler(fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getThumbnailNumber() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getThumbnailNumber();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public String getThumbnailPath(int index) {
        try {
            return getService().getThumbnailPath(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getThumbnailDisplay(int index) {
        try {
            return getService().getThumbnailDisplay(index);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean changeDevice(short deviceIndex) {
        try {
            return getService().changeDevice(deviceIndex);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPvrParams(String mountpath, short fsType) {
        try {
            return getService().setPvrParams(mountpath, fsType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRecordedFileDurationTime(String filename) {
        int recordStatus = -1;
        try {
            recordStatus = getService().getRecordedFileDurationTime(filename);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public int getMetadataSortKey() {
        int recordStatus = -1;
        try {
            recordStatus = getService().getMetadataSortKey();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return recordStatus;
    }

    public void setMetadataSortKey(int nSortKey) {
        try {
            getService().setMetadataSortKey(nSortKey);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setMetadataSortAscending(boolean bIsAscend) {
        try {
            getService().setMetadataSortAscending(bIsAscend);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean createMetadata(String mountPath) {
        try {
            return getService().createMetadata(mountPath);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clearMetadata() {
        try {
            getService().clearMetadata();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getPvrMountPath() {
        try {
            return getService().getPvrMountPath();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletefile(int index, String fileName) {
        try {
            getService().deletefile(index, fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean registerOnPvrEventListener(OnPvrEventListener listener) {
        if (this.pvrClient == null) {
            this.pvrClient = new Client();
            try {
                TvManager.getInstance().getTvCommon().addClient("DeskPvrEventListener", this.pvrClient);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.pvrListeners.put(null, listener);
        return true;
    }

    public synchronized boolean unregisterOnPvrEventListener(OnPvrEventListener listener) {
        this.pvrListeners.remove(listener);
        if (this.pvrListeners.size() == 0 && this.pvrClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskPvrEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            this.pvrClient = null;
        }
        return true;
    }

    protected void finalize() throws Throwable {
        Log.d(TAG, "finalize TvPvrManager ");
        if (this.pvrClient != null) {
            try {
                TvManager.getInstance().getTvCommon().removeClient("DeskPvrEventListener");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
