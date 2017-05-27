package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum EnumPictureMode implements Parcelable {
    PICTURE_DYNAMIC,
    PICTURE_NORMAL,
    PICTURE_SOFT,
    PICTURE_USER,
    PICTURE_GAME,
    PICTURE_AUTO,
    PICTURE_PC,
    PICTURE_VIVID,
    PICTURE_NATURAL,
    PICTURE_SPORTS,
    PICTURE_NUMS;
    
    public static final Creator<EnumPictureMode> CREATOR;

    /* renamed from: com.mstar.android.tvapi.common.vo.EnumPictureMode.1 */
    static class C01361 implements Creator<EnumPictureMode> {
        C01361() {
        }

        public EnumPictureMode createFromParcel(Parcel in) {
            return EnumPictureMode.values()[in.readInt()];
        }

        public EnumPictureMode[] newArray(int size) {
            return new EnumPictureMode[size];
        }
    }

    static {
        CREATOR = new C01361();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(ordinal());
    }
}
