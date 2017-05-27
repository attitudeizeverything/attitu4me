package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserLocationSetting implements Parcelable {
    public static final Creator<UserLocationSetting> CREATOR;
    public int locationNo;
    public short manualLatitude;
    public short manualLongitude;

    /* renamed from: com.mstar.android.tvapi.common.vo.UserLocationSetting.1 */
    static class C01741 implements Creator<UserLocationSetting> {
        C01741() {
        }

        public UserLocationSetting createFromParcel(Parcel in) {
            return new UserLocationSetting(in);
        }

        public UserLocationSetting[] newArray(int size) {
            return new UserLocationSetting[size];
        }
    }

    public UserLocationSetting() {
        this.locationNo = 0;
        this.manualLongitude = (short) 0;
        this.manualLatitude = (short) 0;
    }

    public UserLocationSetting(Parcel in) {
        this.locationNo = in.readInt();
        this.manualLongitude = (short) in.readInt();
        this.manualLatitude = (short) in.readInt();
    }

    static {
        CREATOR = new C01741();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.locationNo);
        dest.writeInt(this.manualLongitude);
        dest.writeInt(this.manualLatitude);
    }
}
