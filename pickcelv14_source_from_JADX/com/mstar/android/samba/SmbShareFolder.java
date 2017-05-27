package com.mstar.android.samba;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SmbShareFolder extends SambaFile implements Parcelable {
    public static final Creator<SmbShareFolder> CREATOR;
    private SmbDevice device;
    private String mFolderName;

    /* renamed from: com.mstar.android.samba.SmbShareFolder.1 */
    static class C01001 implements Creator<SmbShareFolder> {
        C01001() {
        }

        public SmbShareFolder createFromParcel(Parcel in) {
            return new SmbShareFolder(in);
        }

        public SmbShareFolder[] newArray(int size) {
            return new SmbShareFolder[size];
        }
    }

    public SmbShareFolder(SmbDevice ssv) {
        this.device = null;
        this.device = ssv;
    }

    public SmbShareFolder(SmbDevice ssv, String name) {
        this.device = null;
        this.device = ssv;
        this.mFolderName = name;
    }

    public SmbDevice getSmbDevice() {
        return this.device;
    }

    public SmbAuthentication getAuth() {
        return this.device.getAuth();
    }

    public String localPath() {
        return getSmbDevice().localPath() + getFileName();
    }

    public String remotePath() {
        return getPath();
    }

    public boolean canRead() {
        return super.canRead();
    }

    public boolean canWrite() {
        return super.canWrite();
    }

    public void mount(SmbAuthentication smbAuthentication, int flags) {
        this.device.mount(smbAuthentication, flags);
    }

    public void unmount() {
        this.device.unmount();
    }

    public boolean isMounted() {
        return this.device.isMounted();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getFileName());
    }

    static {
        CREATOR = new C01001();
    }

    public SmbShareFolder(Parcel in) {
        this.device = null;
        this.mFolderName = in.readString();
    }
}
