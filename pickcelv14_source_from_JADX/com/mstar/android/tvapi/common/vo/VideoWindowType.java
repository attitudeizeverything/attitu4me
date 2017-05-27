package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoWindowType implements Parcelable {
    public static final Creator<VideoWindowType> CREATOR;
    public int height;
    public int width;
    public int f60x;
    public int f61y;

    /* renamed from: com.mstar.android.tvapi.common.vo.VideoWindowType.1 */
    static class C01811 implements Creator<VideoWindowType> {
        C01811() {
        }

        public VideoWindowType createFromParcel(Parcel in) {
            return new VideoWindowType(in);
        }

        public VideoWindowType[] newArray(int size) {
            return new VideoWindowType[size];
        }
    }

    public VideoWindowType() {
        this.f60x = 0;
        this.f61y = 0;
        this.width = 0;
        this.height = 0;
    }

    public VideoWindowType(Parcel in) {
        this.f60x = in.readInt();
        this.f61y = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    static {
        CREATOR = new C01811();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f60x);
        dest.writeInt(this.f61y);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }
}
