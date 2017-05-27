package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CaptionOptionSetting implements Parcelable {
    public static final Creator<CaptionOptionSetting> CREATOR;
    public short currProgInfoBGColor;
    public short currProgInfoBGOpacity;
    public short currProgInfoEdgeColor;
    public short currProgInfoEdgeStyle;
    public short currProgInfoFGColor;
    public short currProgInfoFGOpacity;
    public short currProgInfoFontSize;
    public short currProgInfoFontStyle;
    public short currProgInfoIsDefault;
    public short currProgInfoItalicsAttr;
    public short currProgInfoUnderlineAttr;

    /* renamed from: com.mstar.android.tvapi.common.vo.CaptionOptionSetting.1 */
    static class C01241 implements Creator<CaptionOptionSetting> {
        C01241() {
        }

        public CaptionOptionSetting createFromParcel(Parcel in) {
            return new CaptionOptionSetting(in);
        }

        public CaptionOptionSetting[] newArray(int size) {
            return new CaptionOptionSetting[size];
        }
    }

    public CaptionOptionSetting(short isDefault, short fGColor, short bGColor, short fGOpacity, short bGOpacity, short fontSize, short fontStyle, short edgeStyle, short edgeColor, short italicsAttr, short underlineAttr) {
        this.currProgInfoIsDefault = isDefault;
        this.currProgInfoFGColor = fGColor;
        this.currProgInfoBGColor = bGColor;
        this.currProgInfoFGOpacity = fGOpacity;
        this.currProgInfoBGOpacity = bGOpacity;
        this.currProgInfoFontSize = fontSize;
        this.currProgInfoFontStyle = fontStyle;
        this.currProgInfoEdgeStyle = edgeStyle;
        this.currProgInfoEdgeColor = edgeColor;
        this.currProgInfoItalicsAttr = italicsAttr;
        this.currProgInfoUnderlineAttr = underlineAttr;
    }

    public CaptionOptionSetting(Parcel in) {
        this.currProgInfoIsDefault = (short) in.readInt();
        this.currProgInfoFGColor = (short) in.readInt();
        this.currProgInfoBGColor = (short) in.readInt();
        this.currProgInfoFGOpacity = (short) in.readInt();
        this.currProgInfoBGOpacity = (short) in.readInt();
        this.currProgInfoFontSize = (short) in.readInt();
        this.currProgInfoFontStyle = (short) in.readInt();
        this.currProgInfoEdgeStyle = (short) in.readInt();
        this.currProgInfoEdgeColor = (short) in.readInt();
        this.currProgInfoItalicsAttr = (short) in.readInt();
        this.currProgInfoUnderlineAttr = (short) in.readInt();
    }

    static {
        CREATOR = new C01241();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.currProgInfoIsDefault);
        dest.writeInt(this.currProgInfoFGColor);
        dest.writeInt(this.currProgInfoBGColor);
        dest.writeInt(this.currProgInfoFGOpacity);
        dest.writeInt(this.currProgInfoBGOpacity);
        dest.writeInt(this.currProgInfoFontSize);
        dest.writeInt(this.currProgInfoFontStyle);
        dest.writeInt(this.currProgInfoEdgeStyle);
        dest.writeInt(this.currProgInfoEdgeColor);
        dest.writeInt(this.currProgInfoItalicsAttr);
        dest.writeInt(this.currProgInfoUnderlineAttr);
    }
}
