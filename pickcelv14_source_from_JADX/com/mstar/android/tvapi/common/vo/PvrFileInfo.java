package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PvrFileInfo implements Parcelable {
    public static final Creator<PvrFileInfo> CREATOR;
    public String filename;
    public boolean isRecording;
    private int key;

    /* renamed from: com.mstar.android.tvapi.common.vo.PvrFileInfo.1 */
    static class C01611 implements Creator<PvrFileInfo> {
        C01611() {
        }

        public PvrFileInfo createFromParcel(Parcel in) {
            return new PvrFileInfo(in);
        }

        public PvrFileInfo[] newArray(int size) {
            return new PvrFileInfo[size];
        }
    }

    public enum EnumPvrFileInfoSortKey {
        E_SORT_FILENAME,
        E_SORT_TIME,
        E_SORT_LCN,
        E_SORT_CHANNEL,
        E_SORT_PROGRAM,
        E_SORT_MAX_KEY
    }

    public EnumPvrFileInfoSortKey getPvrFileInfoSortKey() {
        return EnumPvrFileInfoSortKey.values()[this.key];
    }

    public void getPvrFileInfoSortKey(EnumPvrFileInfoSortKey sortKey) {
        this.key = sortKey.ordinal();
    }

    public PvrFileInfo() {
        this.filename = "";
        this.isRecording = false;
        this.key = 0;
    }

    public PvrFileInfo(Parcel in) {
        boolean z = true;
        this.filename = in.readString();
        if (in.readInt() != 1) {
            z = false;
        }
        this.isRecording = z;
        this.key = in.readInt();
    }

    static {
        CREATOR = new C01611();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.filename);
        dest.writeInt(this.isRecording ? 1 : 0);
        dest.writeInt(this.key);
    }
}
