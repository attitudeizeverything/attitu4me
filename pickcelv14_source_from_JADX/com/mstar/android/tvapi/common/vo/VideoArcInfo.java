package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoArcInfo implements Parcelable {
    public static final Creator<VideoArcInfo> CREATOR;
    public short adjArcDown;
    public short adjArcLeft;
    public short adjArcRight;
    public short adjArcUp;
    private int arcType;
    public boolean bSetCusWin;
    private int threeDimensionArcType;

    /* renamed from: com.mstar.android.tvapi.common.vo.VideoArcInfo.1 */
    static class C01781 implements Creator<VideoArcInfo> {
        C01781() {
        }

        public VideoArcInfo createFromParcel(Parcel in) {
            return new VideoArcInfo(in);
        }

        public VideoArcInfo[] newArray(int size) {
            return new VideoArcInfo[size];
        }
    }

    public EnumVideoArcType getArcType() {
        return EnumVideoArcType.values()[this.arcType];
    }

    public void setArcType(EnumVideoArcType enArcType) {
        this.arcType = enArcType.ordinal();
    }

    public Enum3dAspectRatioType get3dArcType() {
        return Enum3dAspectRatioType.values()[this.threeDimensionArcType];
    }

    public void set3dArcType(Enum3dAspectRatioType en3dArcType) {
        this.threeDimensionArcType = en3dArcType.ordinal();
    }

    public VideoArcInfo(Parcel in) {
        boolean z = true;
        this.arcType = in.readInt();
        this.threeDimensionArcType = in.readInt();
        this.adjArcLeft = (short) in.readInt();
        this.adjArcRight = (short) in.readInt();
        this.adjArcUp = (short) in.readInt();
        this.adjArcDown = (short) in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.bSetCusWin = z;
    }

    static {
        CREATOR = new C01781();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.arcType);
        dest.writeInt(this.threeDimensionArcType);
        dest.writeInt(this.adjArcLeft);
        dest.writeInt(this.adjArcRight);
        dest.writeInt(this.adjArcUp);
        dest.writeInt(this.adjArcDown);
        dest.writeInt(this.bSetCusWin ? 1 : 0);
    }
}
