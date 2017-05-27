package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Detect3dFormatParameter implements Parcelable {
    public static final Creator<Detect3dFormatParameter> CREATOR;
    public int bCbPixelThreshold;
    public int detect3DFormatPara_Version;
    public int gYPixelThreshold;
    public int hitPixelPercentage;
    public int horSampleCount;
    public int horSearchRange;
    public int maxCheckingFrameCount;
    public int rCrPixelThreshold;
    public int verSampleCount;
    public int verSearchRange;

    /* renamed from: com.mstar.android.tvapi.common.vo.Detect3dFormatParameter.1 */
    static class C01301 implements Creator<Detect3dFormatParameter> {
        C01301() {
        }

        public Detect3dFormatParameter createFromParcel(Parcel in) {
            return new Detect3dFormatParameter(in);
        }

        public Detect3dFormatParameter[] newArray(int size) {
            return new Detect3dFormatParameter[size];
        }
    }

    public Detect3dFormatParameter() {
        this.detect3DFormatPara_Version = 0;
        this.horSearchRange = 0;
        this.verSearchRange = 0;
        this.gYPixelThreshold = 0;
        this.rCrPixelThreshold = 0;
        this.bCbPixelThreshold = 0;
        this.horSampleCount = 0;
        this.verSampleCount = 0;
        this.maxCheckingFrameCount = 0;
        this.hitPixelPercentage = 0;
    }

    public Detect3dFormatParameter(Parcel in) {
        this.detect3DFormatPara_Version = in.readInt();
        this.horSearchRange = in.readInt();
        this.verSearchRange = in.readInt();
        this.gYPixelThreshold = in.readInt();
        this.rCrPixelThreshold = in.readInt();
        this.bCbPixelThreshold = in.readInt();
        this.horSampleCount = in.readInt();
        this.verSampleCount = in.readInt();
        this.maxCheckingFrameCount = in.readInt();
        this.hitPixelPercentage = in.readInt();
    }

    static {
        CREATOR = new C01301();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.detect3DFormatPara_Version);
        dest.writeInt(this.horSearchRange);
        dest.writeInt(this.verSearchRange);
        dest.writeInt(this.gYPixelThreshold);
        dest.writeInt(this.rCrPixelThreshold);
        dest.writeInt(this.bCbPixelThreshold);
        dest.writeInt(this.horSampleCount);
        dest.writeInt(this.verSampleCount);
        dest.writeInt(this.maxCheckingFrameCount);
        dest.writeInt(this.hitPixelPercentage);
    }
}
