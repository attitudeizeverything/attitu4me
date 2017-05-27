package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CustomerOadInfo implements Parcelable {
    public static final Creator<CustomerOadInfo> CREATOR;
    public int hwModel;
    public int hwVersion;
    public int oui;
    public int swApModel;
    public int swApVersion;

    /* renamed from: com.mstar.android.tvapi.common.vo.CustomerOadInfo.1 */
    static class C01291 implements Creator<CustomerOadInfo> {
        C01291() {
        }

        public CustomerOadInfo createFromParcel(Parcel in) {
            return new CustomerOadInfo(in);
        }

        public CustomerOadInfo[] newArray(int size) {
            return new CustomerOadInfo[size];
        }
    }

    public CustomerOadInfo() {
        this.oui = 0;
        this.hwModel = 0;
        this.hwVersion = 0;
        this.swApModel = 0;
        this.swApVersion = 0;
    }

    public CustomerOadInfo(Parcel in) {
        this.oui = in.readInt();
        this.hwModel = in.readInt();
        this.hwVersion = in.readInt();
        this.swApModel = in.readInt();
        this.swApVersion = in.readInt();
    }

    static {
        CREATOR = new C01291();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.oui);
        dest.writeInt(this.hwModel);
        dest.writeInt(this.hwVersion);
        dest.writeInt(this.swApModel);
        dest.writeInt(this.swApVersion);
    }
}
