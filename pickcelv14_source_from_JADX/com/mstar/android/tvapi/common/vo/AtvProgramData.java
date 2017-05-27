package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtvProgramData implements Parcelable {
    public static final Creator<AtvProgramData> CREATOR;
    public byte fineTune;
    public short[] listPage;
    public AtvMiscProgramInfo misc;
    public String name;
    public int pll;
    public short sort;

    /* renamed from: com.mstar.android.tvapi.common.vo.AtvProgramData.1 */
    static class C01211 implements Creator<AtvProgramData> {
        C01211() {
        }

        public AtvProgramData createFromParcel(Parcel in) {
            return new AtvProgramData(in);
        }

        public AtvProgramData[] newArray(int size) {
            return new AtvProgramData[size];
        }
    }

    public AtvProgramData() {
        this.listPage = new short[5];
        this.pll = 0;
        this.misc = new AtvMiscProgramInfo();
        this.sort = (short) 0;
        this.fineTune = (byte) 0;
        this.name = "";
        for (int i = 0; i < this.listPage.length; i++) {
            this.listPage[i] = (short) 0;
        }
    }

    public AtvProgramData(Parcel in) {
        this.listPage = new short[5];
        this.pll = in.readInt();
        this.misc = (AtvMiscProgramInfo) AtvMiscProgramInfo.CREATOR.createFromParcel(in);
        this.sort = (short) in.readInt();
        this.fineTune = in.readByte();
        this.name = in.readString();
        for (int i = 0; i < this.listPage.length; i++) {
            this.listPage[i] = (short) in.readInt();
        }
    }

    static {
        CREATOR = new C01211();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.pll);
        this.misc.writeToParcel(dest, 0);
        dest.writeInt(this.sort);
        dest.writeByte(this.fineTune);
        dest.writeString(this.name);
        for (short writeInt : this.listPage) {
            dest.writeInt(writeInt);
        }
    }
}
