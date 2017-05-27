package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioInfo implements Parcelable {
    public static final Creator<AudioInfo> CREATOR;
    public short aacProfileAndLevel;
    public short aacType;
    public int audioPid;
    public short audioType;
    public boolean broadcastMixAd;
    public LangIso639 isoLangInfo;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.AudioInfo.1 */
    static class C02071 implements Creator<AudioInfo> {
        C02071() {
        }

        public AudioInfo createFromParcel(Parcel in) {
            return new AudioInfo(null);
        }

        public AudioInfo[] newArray(int size) {
            return new AudioInfo[size];
        }
    }

    public AudioInfo() {
        this.isoLangInfo = new LangIso639();
        this.audioPid = 0;
        this.audioType = (short) 0;
        this.broadcastMixAd = false;
        this.aacType = (short) 0;
        this.aacProfileAndLevel = (short) 0;
    }

    private AudioInfo(Parcel in) {
        this.isoLangInfo = (LangIso639) LangIso639.CREATOR.createFromParcel(in);
        this.audioPid = in.readInt();
        this.audioType = (short) in.readInt();
        this.broadcastMixAd = in.readInt() != 0;
        this.aacType = (short) in.readInt();
        this.aacProfileAndLevel = (short) in.readInt();
    }

    static {
        CREATOR = new C02071();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 0;
        this.isoLangInfo.writeToParcel(dest, 0);
        dest.writeInt(this.audioPid);
        dest.writeInt(this.audioType);
        if (this.broadcastMixAd) {
            i = 1;
        }
        dest.writeInt(i);
        dest.writeInt(this.aacType);
        dest.writeInt(this.aacProfileAndLevel);
    }
}
