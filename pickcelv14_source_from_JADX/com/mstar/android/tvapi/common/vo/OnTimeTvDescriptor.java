package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OnTimeTvDescriptor implements Parcelable {
    public static final Creator<OnTimeTvDescriptor> CREATOR;
    public EnumTimeOnTimerSource enTVSrc;
    public int mChNo;
    public short mVol;

    /* renamed from: com.mstar.android.tvapi.common.vo.OnTimeTvDescriptor.1 */
    static class C01541 implements Creator<OnTimeTvDescriptor> {
        C01541() {
        }

        public OnTimeTvDescriptor createFromParcel(Parcel in) {
            return new OnTimeTvDescriptor(null);
        }

        public OnTimeTvDescriptor[] newArray(int size) {
            return new OnTimeTvDescriptor[size];
        }
    }

    static {
        CREATOR = new C01541();
    }

    public OnTimeTvDescriptor(EnumTimeOnTimerSource eSource, int ch, short i) {
        this.enTVSrc = eSource;
        this.mChNo = ch;
        this.mVol = i;
    }

    private OnTimeTvDescriptor(Parcel in) {
        this.enTVSrc = EnumTimeOnTimerSource.values()[in.readInt()];
        this.mChNo = in.readInt();
        this.mVol = (short) in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.enTVSrc.ordinal());
        arg0.writeInt(this.mChNo);
        arg0.writeInt(this.mVol);
    }
}
