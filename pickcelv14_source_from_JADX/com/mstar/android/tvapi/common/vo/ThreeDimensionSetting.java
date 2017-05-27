package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThreeDimensionSetting implements Parcelable {
    public static final Creator<ThreeDimensionSetting> CREATOR;
    public Enum2dDisplayFormat en2DFormat;
    public Enum3dDisplayFormat en3DFormat;
    public int en3DTimerPeriod;
    public EnumAutoStart enAutoStart;
    public EnumDisplayMode enDisplayMode;

    /* renamed from: com.mstar.android.tvapi.common.vo.ThreeDimensionSetting.1 */
    static class C01701 implements Creator<ThreeDimensionSetting> {
        C01701() {
        }

        public ThreeDimensionSetting createFromParcel(Parcel in) {
            return new ThreeDimensionSetting(in);
        }

        public ThreeDimensionSetting[] newArray(int size) {
            return new ThreeDimensionSetting[size];
        }
    }

    public enum Enum2dDisplayFormat {
        E_SBS,
        E_TAB,
        E_FP,
        E_NATIVE,
        E_FRMA,
        E_LAP,
        E_NUM
    }

    public enum EnumAutoStart {
        E_OFF,
        E_2D,
        E_3D,
        E_NUM
    }

    public enum EnumTimerPeriod {
        E_TIMER_PERIOD_OFF(0),
        E_TIMER_PERIOD_30(1800000),
        E_TIMER_PERIOD_60(3600000),
        E_TIMER_PERIOD_90(5400000),
        E_TIMER_PERIOD_120(7200000),
        E_TIMER_PERIOD_NUM(7200001);
        
        private final int value;

        private EnumTimerPeriod(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public ThreeDimensionSetting() {
        this.enDisplayMode = EnumDisplayMode.E_MODE_2D;
        this.en3DFormat = Enum3dDisplayFormat.E_CKB;
        this.en2DFormat = Enum2dDisplayFormat.E_FP;
        this.enAutoStart = EnumAutoStart.E_2D;
        this.en3DTimerPeriod = 0;
    }

    public ThreeDimensionSetting(Parcel in) {
        this.enDisplayMode = EnumDisplayMode.values()[in.readInt()];
        this.en3DFormat = Enum3dDisplayFormat.values()[in.readInt()];
        this.en2DFormat = Enum2dDisplayFormat.values()[in.readInt()];
        this.enAutoStart = EnumAutoStart.values()[in.readInt()];
        this.en3DTimerPeriod = in.readInt();
    }

    static {
        CREATOR = new C01701();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.enDisplayMode.ordinal());
        dest.writeInt(this.en3DFormat.ordinal());
        dest.writeInt(this.en2DFormat.ordinal());
        dest.writeInt(this.enAutoStart.ordinal());
        dest.writeInt(this.en3DTimerPeriod);
    }
}
