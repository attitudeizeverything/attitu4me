package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OverScanSettingUser implements Parcelable {
    public static final Creator<OverScanSettingUser> CREATOR;
    public short overScanHRatio;
    public short overScanHposition;
    public short overScanVRatio;
    public short overScanVposition;

    /* renamed from: com.mstar.android.tvapi.common.vo.OverScanSettingUser.1 */
    static class C01551 implements Creator<OverScanSettingUser> {
        C01551() {
        }

        public OverScanSettingUser createFromParcel(Parcel in) {
            return new OverScanSettingUser(in);
        }

        public OverScanSettingUser[] newArray(int size) {
            return new OverScanSettingUser[size];
        }
    }

    public OverScanSettingUser() {
        this.overScanHposition = (short) 0;
        this.overScanVposition = (short) 0;
        this.overScanHRatio = (short) 0;
        this.overScanVRatio = (short) 0;
    }

    public OverScanSettingUser(Parcel in) {
        this.overScanHposition = (short) in.readInt();
        this.overScanVposition = (short) in.readInt();
        this.overScanHRatio = (short) in.readInt();
        this.overScanVRatio = (short) in.readInt();
    }

    static {
        CREATOR = new C01551();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.overScanHposition);
        dest.writeInt(this.overScanVposition);
        dest.writeInt(this.overScanHRatio);
        dest.writeInt(this.overScanVRatio);
    }
}
