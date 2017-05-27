package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CaptureThumbnailResult implements Parcelable {
    public static final Creator<CaptureThumbnailResult> CREATOR;
    public int thumbnailIndex;
    private int thumbnailStatus;

    /* renamed from: com.mstar.android.tvapi.common.vo.CaptureThumbnailResult.1 */
    static class C01251 implements Creator<CaptureThumbnailResult> {
        C01251() {
        }

        public CaptureThumbnailResult createFromParcel(Parcel in) {
            return new CaptureThumbnailResult(in);
        }

        public CaptureThumbnailResult[] newArray(int size) {
            return new CaptureThumbnailResult[size];
        }
    }

    public EnumPvrThumbnailStatus getPvrThumbnailStatus() {
        return EnumPvrThumbnailStatus.values()[this.thumbnailStatus];
    }

    public void setPvrThumbnailStatus(EnumPvrThumbnailStatus eThumbnailStatus) {
        this.thumbnailStatus = eThumbnailStatus.ordinal();
    }

    public CaptureThumbnailResult() {
        this.thumbnailStatus = 0;
        this.thumbnailIndex = 0;
    }

    public CaptureThumbnailResult(Parcel in) {
        this.thumbnailStatus = in.readInt();
        this.thumbnailIndex = in.readInt();
    }

    static {
        CREATOR = new C01251();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.thumbnailStatus);
        dest.writeInt(this.thumbnailIndex);
    }
}
