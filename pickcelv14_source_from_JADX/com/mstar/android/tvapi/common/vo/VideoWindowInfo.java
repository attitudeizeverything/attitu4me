package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoWindowInfo implements Parcelable {
    public static final Creator<VideoWindowInfo> CREATOR;
    public int hCapStart;
    public int hCropLeft;
    public int hCropRight;
    public int vCapStart;
    public int vCropDown;
    public int vCropUp;

    /* renamed from: com.mstar.android.tvapi.common.vo.VideoWindowInfo.1 */
    static class C01801 implements Creator<VideoWindowInfo> {
        C01801() {
        }

        public VideoWindowInfo createFromParcel(Parcel in) {
            return new VideoWindowInfo(in);
        }

        public VideoWindowInfo[] newArray(int size) {
            return new VideoWindowInfo[size];
        }
    }

    public VideoWindowInfo() {
        this.hCapStart = 0;
        this.vCapStart = 0;
        this.hCropLeft = 0;
        this.hCropRight = 0;
        this.vCropUp = 0;
        this.vCropDown = 0;
    }

    public VideoWindowInfo(Parcel in) {
        this.hCapStart = in.readInt();
        this.vCapStart = in.readInt();
        this.hCropLeft = in.readInt();
        this.hCropRight = in.readInt();
        this.vCropUp = in.readInt();
        this.vCropDown = in.readInt();
    }

    static {
        CREATOR = new C01801();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hCapStart);
        dest.writeInt(this.vCapStart);
        dest.writeInt(this.hCropLeft);
        dest.writeInt(this.hCropRight);
        dest.writeInt(this.vCropUp);
        dest.writeInt(this.vCropDown);
    }
}
