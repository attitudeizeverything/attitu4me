package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumVideoItem implements Parcelable {
    MS_VIDEOITEM_BRIGHTNESS,
    MS_VIDEOITEM_CONTRAST,
    MS_VIDEOITEM_SATURATION,
    MS_VIDEOITEM_SHARPNESS,
    MS_VIDEOITEM_HUE,
    MS_VIDEOITEM_NUM;
    
    public static final Creator<EnumVideoItem> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumVideoItem.1 */
    static class C01441 implements Creator<EnumVideoItem> {
        C01441() {
        }

        public EnumVideoItem createFromParcel(Parcel in) {
            return EnumVideoItem.values()[in.readInt()];
        }

        public EnumVideoItem[] newArray(int size) {
            return new EnumVideoItem[size];
        }
    }

    static {
        CREATOR = new C01441();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
}
