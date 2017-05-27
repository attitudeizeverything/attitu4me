package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumThreeDVideoLrViewSwitch implements Parcelable {
    E_ThreeD_Video_LRVIEWSWITCH_NOTEXCHANGE,
    E_ThreeD_Video_LRVIEWSWITCH_EXCHANGE,
    E_ThreeD_Video_LRVIEWSWITCH_COUNT;
    
    public static final Creator<EnumThreeDVideoLrViewSwitch> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumThreeDVideoLrViewSwitch.1 */
    static class C01431 implements Creator<EnumThreeDVideoLrViewSwitch> {
        C01431() {
        }

        public EnumThreeDVideoLrViewSwitch createFromParcel(Parcel in) {
            return EnumThreeDVideoLrViewSwitch.values()[in.readInt()];
        }

        public EnumThreeDVideoLrViewSwitch[] newArray(int size) {
            return new EnumThreeDVideoLrViewSwitch[size];
        }
    }

    static {
        CREATOR = new C01431();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
