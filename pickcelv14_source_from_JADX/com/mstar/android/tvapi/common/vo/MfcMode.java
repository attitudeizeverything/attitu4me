package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MfcMode implements Parcelable {
    public static final Creator<MfcMode> CREATOR;
    public EnumMfc mfc;

    /* renamed from: com.mstar.android.tvapi.common.vo.MfcMode.1 */
    static class C01491 implements Creator<MfcMode> {
        C01491() {
        }

        public MfcMode createFromParcel(Parcel in) {
            return new MfcMode(in);
        }

        public MfcMode[] newArray(int size) {
            return new MfcMode[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public MfcMode(Parcel in) {
        this.mfc = EnumMfc.E_HIGH;
        this.mfc = EnumMfc.values()[in.readInt()];
    }

    static {
        CREATOR = new C01491();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.mfc.ordinal());
    }
}
