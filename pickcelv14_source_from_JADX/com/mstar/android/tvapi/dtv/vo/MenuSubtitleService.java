package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;

public class MenuSubtitleService implements Parcelable {
    public static final Creator<MenuSubtitleService> CREATOR;
    public static final int MAX_STRINGCODE_COUNT = 4;
    public int eLanguage;
    public int enSubtitleType;
    public short refCount;
    public char[] stringCodes;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.MenuSubtitleService.1 */
    static class C02291 implements Creator<MenuSubtitleService> {
        C02291() {
        }

        public MenuSubtitleService createFromParcel(Parcel in) {
            return new MenuSubtitleService(null);
        }

        public MenuSubtitleService[] newArray(int size) {
            return new MenuSubtitleService[size];
        }
    }

    static {
        CREATOR = new C02291();
    }

    private MenuSubtitleService(Parcel in) {
        this.stringCodes = new char[MAX_STRINGCODE_COUNT];
        this.eLanguage = in.readInt();
        this.enSubtitleType = in.readInt();
        this.refCount = (short) in.readInt();
        this.stringCodes = in.readString().toCharArray();
    }

    public MenuSubtitleService() {
        this.stringCodes = new char[MAX_STRINGCODE_COUNT];
        this.eLanguage = 0;
        this.enSubtitleType = 0;
        this.refCount = (short) 0;
        for (int i = 0; i < MAX_STRINGCODE_COUNT; i++) {
            this.stringCodes[i] = '\u0000';
        }
    }

    public MenuSubtitleService(int eLanguage, int enSubtitleType, short refCount, char[] stringCodes) {
        this.stringCodes = new char[MAX_STRINGCODE_COUNT];
        this.eLanguage = eLanguage;
        this.enSubtitleType = enSubtitleType;
        this.refCount = (short) 0;
        this.stringCodes = stringCodes;
    }

    public EnumLanguage getLanguage() {
        return EnumLanguage.values()[this.eLanguage];
    }

    public void setLanguage(EnumLanguage language) {
        this.eLanguage = language.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.eLanguage);
        dest.writeInt(this.enSubtitleType);
        dest.writeInt(this.refCount);
        dest.writeCharArray(this.stringCodes);
    }
}
