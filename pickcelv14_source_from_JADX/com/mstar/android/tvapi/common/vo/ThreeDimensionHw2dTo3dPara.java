package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDimensionHw2dTo3dPara implements Parcelable {
    public static final Creator<ThreeDimensionHw2dTo3dPara> CREATOR;
    public int artificialGain;
    public int concave;
    public int eleSel;
    public int gain;
    public int hw2dTo3dParaVersion;
    public int modSel;
    public int offset;

    /* renamed from: com.mstar.android.tvapi.common.vo.ThreeDimensionHw2dTo3dPara.1 */
    static class C01681 implements Creator<ThreeDimensionHw2dTo3dPara> {
        C01681() {
        }

        public ThreeDimensionHw2dTo3dPara createFromParcel(Parcel in) {
            return new ThreeDimensionHw2dTo3dPara(in);
        }

        public ThreeDimensionHw2dTo3dPara[] newArray(int size) {
            return new ThreeDimensionHw2dTo3dPara[size];
        }
    }

    public ThreeDimensionHw2dTo3dPara() {
        this.hw2dTo3dParaVersion = 0;
        this.concave = 0;
        this.gain = 0;
        this.offset = 0;
        this.artificialGain = 0;
        this.eleSel = 0;
        this.modSel = 0;
    }

    public ThreeDimensionHw2dTo3dPara(Parcel in) {
        this.hw2dTo3dParaVersion = in.readInt();
        this.concave = in.readInt();
        this.gain = in.readInt();
        this.offset = in.readInt();
        this.artificialGain = in.readInt();
        this.eleSel = in.readInt();
        this.modSel = in.readInt();
    }

    static {
        CREATOR = new C01681();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hw2dTo3dParaVersion);
        dest.writeInt(this.concave);
        dest.writeInt(this.gain);
        dest.writeInt(this.offset);
        dest.writeInt(this.artificialGain);
        dest.writeInt(this.eleSel);
        dest.writeInt(this.modSel);
    }
}
