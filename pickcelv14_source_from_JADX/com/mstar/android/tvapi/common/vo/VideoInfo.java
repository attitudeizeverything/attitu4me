package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.exception.TvCommonException;

public class VideoInfo implements Parcelable {
    public static final Creator<VideoInfo> CREATOR;
    private int enScanType;
    public int frameRate;
    public int hResolution;
    public int modeIndex;
    public int vResolution;

    /* renamed from: com.mstar.android.tvapi.common.vo.VideoInfo.1 */
    static class C01791 implements Creator<VideoInfo> {
        C01791() {
        }

        public VideoInfo createFromParcel(Parcel in) {
            return new VideoInfo(in);
        }

        public VideoInfo[] newArray(int size) {
            return new VideoInfo[size];
        }
    }

    public enum EnumScanType {
        E_PROGRESSIVE,
        E_INTERLACED
    }

    public VideoInfo() {
        this.hResolution = 0;
        this.vResolution = 0;
        this.frameRate = 0;
        this.enScanType = 0;
        this.modeIndex = 0;
    }

    public VideoInfo(Parcel in) {
        this.hResolution = in.readInt();
        this.vResolution = in.readInt();
        this.frameRate = in.readInt();
        this.enScanType = in.readInt();
        this.modeIndex = in.readInt();
    }

    static {
        CREATOR = new C01791();
    }

    public EnumScanType getScanType() throws TvCommonException {
        if (this.enScanType >= EnumScanType.E_PROGRESSIVE.ordinal() && this.enScanType <= EnumScanType.E_INTERLACED.ordinal()) {
            return EnumScanType.values()[this.enScanType];
        }
        throw new TvCommonException("enScanType is not in the range ");
    }

    public void setScanType(EnumScanType ScanType) {
        this.enScanType = ScanType.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hResolution);
        dest.writeInt(this.vResolution);
        dest.writeInt(this.frameRate);
        dest.writeInt(this.enScanType);
        dest.writeInt(this.modeIndex);
    }
}
