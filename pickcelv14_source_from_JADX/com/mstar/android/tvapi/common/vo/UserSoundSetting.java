package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.vo.TvOsType.EnumLanguage;

public class UserSoundSetting implements Parcelable {
    public static final Creator<UserSoundSetting> CREATOR;
    public EnumSoundAdOutput adOutput;
    public short adVolume;
    public SoundModeSetting[] astSoundModeSettings;
    public EnumAudysseyDynamicVolumeMode audysseyDynamicVolume;
    public EnumAudysseyEqMode audysseyEq;
    public short balance;
    public int checkSum;
    public boolean enableAVC;
    public boolean enableAd;
    public boolean enableHi;
    public short headPhonePreScale;
    public short headphoneVolume;
    public short lineOutPreScale;
    public short muteFlag;
    public short primaryFlag;
    public short scart1PreScale;
    public short scart2PreScale;
    public EnumAudioMode soundAudioChannel;
    public EnumLanguage soundAudioLanguage1;
    public EnumLanguage soundAudioLanguage2;
    public EnumSoundMode soundMode;
    public short spdifDelay;
    public short speakerPreScale;
    public short speakerdelay;
    public EnumSurroundType surround;
    public EnumSurroundSystemType surroundSoundMode;
    public short volume;

    /* renamed from: com.mstar.android.tvapi.common.vo.UserSoundSetting.1 */
    static class C01761 implements Creator<UserSoundSetting> {
        C01761() {
        }

        public UserSoundSetting createFromParcel(Parcel in) {
            return new UserSoundSetting(in);
        }

        public UserSoundSetting[] newArray(int size) {
            return new UserSoundSetting[size];
        }
    }

    public UserSoundSetting() {
        this.astSoundModeSettings = new SoundModeSetting[EnumAudioMode.E_NUM.ordinal()];
        this.checkSum = 0;
        this.soundMode = EnumSoundMode.E_MOVIE;
        this.audysseyDynamicVolume = EnumAudysseyDynamicVolumeMode.E_VOLUME_NUM;
        this.audysseyEq = EnumAudysseyEqMode.E_NUM;
        this.surroundSoundMode = EnumSurroundSystemType.E_BBE;
        this.surround = EnumSurroundType.E_CHAMPAIGN;
        this.enableAVC = false;
        this.volume = (short) 0;
        this.headphoneVolume = (short) 0;
        this.balance = (short) 0;
        this.primaryFlag = (short) 0;
        this.soundAudioLanguage1 = EnumLanguage.E_ENGLISH;
        this.soundAudioLanguage2 = EnumLanguage.E_ACHINESE;
        this.muteFlag = (short) 0;
        this.soundAudioChannel = EnumAudioMode.E_LL;
        this.enableAd = false;
        this.adVolume = (short) 0;
        this.adOutput = EnumSoundAdOutput.E_BOTH;
        this.spdifDelay = (short) 0;
        this.speakerdelay = (short) 0;
        this.speakerPreScale = (short) 0;
        this.headPhonePreScale = (short) 0;
        this.lineOutPreScale = (short) 0;
        this.scart1PreScale = (short) 0;
        this.scart2PreScale = (short) 0;
        this.enableHi = false;
        for (int i = 0; i < EnumAudioMode.E_NUM.ordinal(); i++) {
            this.astSoundModeSettings[i] = new SoundModeSetting();
        }
    }

    public UserSoundSetting(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.astSoundModeSettings = new SoundModeSetting[EnumAudioMode.E_NUM.ordinal()];
        this.checkSum = in.readInt();
        this.soundMode = EnumSoundMode.E_MOVIE;
        this.audysseyDynamicVolume = EnumAudysseyDynamicVolumeMode.values()[in.readInt()];
        this.audysseyEq = EnumAudysseyEqMode.values()[in.readInt()];
        this.surroundSoundMode = EnumSurroundSystemType.values()[in.readInt()];
        this.surround = EnumSurroundType.values()[in.readInt()];
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.enableAVC = z;
        this.volume = (short) in.readInt();
        this.headphoneVolume = (short) in.readInt();
        this.balance = (short) in.readInt();
        this.primaryFlag = (short) in.readInt();
        this.soundAudioLanguage1 = EnumLanguage.values()[in.readInt()];
        this.soundAudioLanguage2 = EnumLanguage.values()[in.readInt()];
        this.muteFlag = (short) in.readInt();
        this.soundAudioChannel = EnumAudioMode.values()[in.readInt()];
        if (in.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.enableAd = z;
        this.adVolume = (short) in.readInt();
        this.adOutput = EnumSoundAdOutput.values()[in.readInt()];
        this.spdifDelay = (short) in.readInt();
        this.speakerdelay = (short) in.readInt();
        this.speakerPreScale = (short) in.readInt();
        this.headPhonePreScale = (short) in.readInt();
        this.lineOutPreScale = (short) in.readInt();
        this.scart1PreScale = (short) in.readInt();
        this.scart2PreScale = (short) in.readInt();
        if (in.readInt() != 1) {
            z2 = false;
        }
        this.enableHi = z2;
        for (int i = 0; i < EnumAudioMode.E_NUM.ordinal(); i++) {
            this.astSoundModeSettings[i] = (SoundModeSetting) SoundModeSetting.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C01761();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeInt(this.checkSum);
        dest.writeInt(this.soundMode.ordinal());
        dest.writeParcelableArray(this.astSoundModeSettings, 0);
        dest.writeInt(this.audysseyDynamicVolume.ordinal());
        dest.writeInt(this.audysseyEq.ordinal());
        dest.writeInt(this.surroundSoundMode.ordinal());
        dest.writeInt(this.surround.ordinal());
        dest.writeInt(this.enableAVC ? 1 : 0);
        dest.writeInt(this.volume);
        dest.writeInt(this.headphoneVolume);
        dest.writeInt(this.balance);
        dest.writeInt(this.primaryFlag);
        dest.writeInt(this.soundAudioLanguage1.ordinal());
        dest.writeInt(this.soundAudioLanguage2.ordinal());
        dest.writeInt(this.muteFlag);
        dest.writeInt(this.soundAudioChannel.ordinal());
        if (this.enableAd) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeInt(this.adVolume);
        dest.writeInt(this.adOutput.ordinal());
        dest.writeInt(this.spdifDelay);
        dest.writeInt(this.speakerdelay);
        dest.writeInt(this.speakerPreScale);
        dest.writeInt(this.headPhonePreScale);
        dest.writeInt(this.lineOutPreScale);
        dest.writeInt(this.scart1PreScale);
        dest.writeInt(this.scart2PreScale);
        if (!this.enableHi) {
            i2 = 0;
        }
        dest.writeInt(i2);
    }
}
