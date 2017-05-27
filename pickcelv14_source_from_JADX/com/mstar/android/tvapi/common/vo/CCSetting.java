package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CCSetting implements Parcelable {
    public static final Creator<CCSetting> CREATOR;
    public short advancedMode;
    public short basicMode;
    public short ccMode;

    /* renamed from: com.mstar.android.tvapi.common.vo.CCSetting.1 */
    static class C01231 implements Creator<CCSetting> {
        C01231() {
        }

        public CCSetting createFromParcel(Parcel in) {
            return new CCSetting(in);
        }

        public CCSetting[] newArray(int size) {
            return new CCSetting[size];
        }
    }

    public CCSetting(short ccMode, short basicMode, short advancedMode) {
        this.ccMode = ccMode;
        this.basicMode = basicMode;
        this.advancedMode = advancedMode;
    }

    public CCSetting(Parcel in) {
        this.ccMode = (short) in.readInt();
        this.basicMode = (short) in.readInt();
        this.advancedMode = (short) in.readInt();
    }

    static {
        CREATOR = new C01231();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ccMode);
        dest.writeInt(this.basicMode);
        dest.writeInt(this.advancedMode);
    }
}
