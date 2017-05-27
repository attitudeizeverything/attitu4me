package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PanelProperty implements Parcelable {
    public static final Creator<PanelProperty> CREATOR;
    public int height;
    public int width;

    /* renamed from: com.mstar.android.tvapi.common.vo.PanelProperty.1 */
    static class C01561 implements Creator<PanelProperty> {
        C01561() {
        }

        public PanelProperty createFromParcel(Parcel in) {
            return new PanelProperty(in);
        }

        public PanelProperty[] newArray(int size) {
            return new PanelProperty[size];
        }
    }

    public PanelProperty() {
        this.width = 0;
        this.height = 0;
    }

    public PanelProperty(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
    }

    static {
        CREATOR = new C01561();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }
}
