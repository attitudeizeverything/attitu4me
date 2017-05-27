package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvSubtitleInfo implements Parcelable {
    public static final Creator<DtvSubtitleInfo> CREATOR;
    public static final int MAX_MENUSUBTITLESERVICE_COUNT = 24;
    public short currentSubtitleIndex;
    public boolean subtitleOn;
    public short subtitleServiceNumber;
    public MenuSubtitleService[] subtitleServices;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvSubtitleInfo.1 */
    static class C02181 implements Creator<DtvSubtitleInfo> {
        C02181() {
        }

        public DtvSubtitleInfo createFromParcel(Parcel in) {
            return new DtvSubtitleInfo(null);
        }

        public DtvSubtitleInfo[] newArray(int size) {
            return new DtvSubtitleInfo[size];
        }
    }

    static {
        CREATOR = new C02181();
    }

    private DtvSubtitleInfo(Parcel in) {
        this.subtitleServices = new MenuSubtitleService[MAX_MENUSUBTITLESERVICE_COUNT];
        for (int i = 0; i < MAX_MENUSUBTITLESERVICE_COUNT; i++) {
            this.subtitleServices[i] = (MenuSubtitleService) MenuSubtitleService.CREATOR.createFromParcel(in);
        }
        this.currentSubtitleIndex = (short) in.readInt();
        this.subtitleServiceNumber = (short) in.readInt();
        this.subtitleOn = in.readInt() == 1;
    }

    public DtvSubtitleInfo() {
        this.subtitleServices = new MenuSubtitleService[MAX_MENUSUBTITLESERVICE_COUNT];
        this.currentSubtitleIndex = (short) 0;
        this.subtitleServiceNumber = (short) 0;
        this.subtitleOn = false;
        for (int i = 0; i < MAX_MENUSUBTITLESERVICE_COUNT; i++) {
            this.subtitleServices[i] = new MenuSubtitleService();
        }
    }

    public DtvSubtitleInfo(MenuSubtitleService[] subtitleServices, short currentSubtitleIndex, short subtitleServiceNumber, boolean subtitleOn) {
        this.subtitleServices = new MenuSubtitleService[MAX_MENUSUBTITLESERVICE_COUNT];
        this.subtitleServices = subtitleServices;
        this.currentSubtitleIndex = currentSubtitleIndex;
        this.subtitleServiceNumber = subtitleServiceNumber;
        this.subtitleOn = subtitleOn;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        for (int i = 0; i < MAX_MENUSUBTITLESERVICE_COUNT; i++) {
            this.subtitleServices[i].writeToParcel(dest, flags);
        }
        dest.writeInt(this.currentSubtitleIndex);
        dest.writeInt(this.subtitleServiceNumber);
        dest.writeInt(this.subtitleOn ? 1 : 0);
    }
}
