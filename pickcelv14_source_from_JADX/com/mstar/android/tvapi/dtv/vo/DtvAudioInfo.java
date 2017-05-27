package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DtvAudioInfo implements Parcelable {
    public static final Creator<DtvAudioInfo> CREATOR;
    public AudioInfo[] audioInfos;
    public short audioLangNum;
    public short currentAudioIndex;
    public short currentChannelMode;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.DtvAudioInfo.1 */
    static class C02121 implements Creator<DtvAudioInfo> {
        C02121() {
        }

        public DtvAudioInfo createFromParcel(Parcel in) {
            return new DtvAudioInfo(in);
        }

        public DtvAudioInfo[] newArray(int size) {
            return new DtvAudioInfo[size];
        }
    }

    public DtvAudioInfo() {
        this.audioInfos = new AudioInfo[16];
        this.audioLangNum = (short) 0;
        this.currentAudioIndex = (short) 0;
        this.currentChannelMode = (short) 0;
        for (int i = 0; i < this.audioInfos.length; i++) {
            this.audioInfos[i] = new AudioInfo();
        }
    }

    public DtvAudioInfo(Parcel in) {
        this.audioInfos = new AudioInfo[16];
        this.audioLangNum = (short) in.readInt();
        for (short i = (short) 0; i < this.audioLangNum; i++) {
            this.audioInfos[i] = (AudioInfo) AudioInfo.CREATOR.createFromParcel(in);
        }
        this.currentAudioIndex = (short) in.readInt();
        this.currentChannelMode = (short) in.readInt();
    }

    static {
        CREATOR = new C02121();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.audioLangNum);
        for (AudioInfo writeToParcel : this.audioInfos) {
            writeToParcel.writeToParcel(dest, flags);
        }
        dest.writeInt(this.currentAudioIndex);
        dest.writeInt(this.currentChannelMode);
    }
}
