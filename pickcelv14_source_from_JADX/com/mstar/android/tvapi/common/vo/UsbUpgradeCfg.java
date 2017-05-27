package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UsbUpgradeCfg implements Parcelable {
    public static final Creator<UsbUpgradeCfg> CREATOR;
    public boolean IsUpgradeApplication;
    public boolean IsUpgradeConfig;
    public boolean IsUpgradeKernel;
    public boolean IsUpgradeMslib;
    public boolean IsUpgradeRootfs;
    public String acPath;

    /* renamed from: com.mstar.android.tvapi.common.vo.UsbUpgradeCfg.1 */
    static class C01731 implements Creator<UsbUpgradeCfg> {
        C01731() {
        }

        public UsbUpgradeCfg createFromParcel(Parcel in) {
            return new UsbUpgradeCfg(in);
        }

        public UsbUpgradeCfg[] newArray(int size) {
            return new UsbUpgradeCfg[size];
        }
    }

    public UsbUpgradeCfg() {
        this.IsUpgradeKernel = false;
        this.IsUpgradeRootfs = false;
        this.IsUpgradeMslib = false;
        this.IsUpgradeApplication = false;
        this.IsUpgradeConfig = false;
        this.acPath = "";
    }

    public UsbUpgradeCfg(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.IsUpgradeKernel = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.IsUpgradeRootfs = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.IsUpgradeMslib = z;
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.IsUpgradeApplication = z;
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.IsUpgradeConfig = z2;
        this.acPath = in.readString();
    }

    static {
        CREATOR = new C01731();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeInt(this.IsUpgradeKernel ? 1 : 0);
        if (this.IsUpgradeRootfs) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.IsUpgradeMslib) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.IsUpgradeApplication) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (!this.IsUpgradeConfig) {
            i2 = 0;
        }
        dest.writeInt(i2);
        dest.writeString(this.acPath);
    }
}
