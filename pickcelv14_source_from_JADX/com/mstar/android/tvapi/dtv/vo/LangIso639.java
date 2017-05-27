package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LangIso639 implements Parcelable {
    public static final Creator<LangIso639> CREATOR;
    private static final int E_ISO_LANG_MAX_LENGTH = 3;
    public short audioMode;
    public short audioType;
    public boolean isValid;
    public char[] isoLangInfo;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.LangIso639.1 */
    static class C02261 implements Creator<LangIso639> {
        C02261() {
        }

        public LangIso639 createFromParcel(Parcel in) {
            return new LangIso639(null);
        }

        public LangIso639[] newArray(int size) {
            return new LangIso639[size];
        }
    }

    public LangIso639() {
        this.isoLangInfo = new char[E_ISO_LANG_MAX_LENGTH];
        this.audioMode = (short) 0;
        this.audioType = (short) 0;
        this.isValid = false;
        for (int i = 0; i < E_ISO_LANG_MAX_LENGTH; i++) {
            this.isoLangInfo[i] = '\u0000';
        }
    }

    private LangIso639(Parcel in) {
        this.isoLangInfo = new char[E_ISO_LANG_MAX_LENGTH];
        String str = in.readString();
        if (str != null) {
            this.isoLangInfo = str.toCharArray();
        }
        this.audioMode = (short) in.readInt();
        this.audioType = (short) in.readInt();
        this.isValid = in.readInt() != 0;
    }

    static {
        CREATOR = new C02261();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(new String(this.isoLangInfo));
        dest.writeInt(this.audioMode);
        dest.writeInt(this.audioType);
        dest.writeInt(this.isValid ? 1 : 0);
    }
}
