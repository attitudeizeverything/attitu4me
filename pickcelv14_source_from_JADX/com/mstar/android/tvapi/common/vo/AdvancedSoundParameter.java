package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AdvancedSoundParameter implements Parcelable {
    public static final Creator<AdvancedSoundParameter> CREATOR;
    public int paramAudysseyAbxFilset;
    public int paramAudysseyAbxGdry;
    public int paramAudysseyAbxGwet;
    public int paramAudysseyDynamicEqEqOffset;
    public int paramAudysseyDynamicVolCompressMode;
    public int paramAudysseyDynamicVolGc;
    public int paramAudysseyDynamicVolVolSetting;
    public int paramDolbyPl2vdpkSmod;
    public int paramDolbyPl2vdpkWmod;
    public int paramDtsUltraTvEvoAdd3dBon;
    public int paramDtsUltraTvEvoMonoInput;
    public int paramDtsUltraTvEvoPceLevel;
    public int paramDtsUltraTvEvoVlfeLevel;
    public int paramDtsUltraTvEvoWideningon;
    public int paramDtsUltraTvSymDefault;
    public int paramDtsUltraTvSymLevel;
    public int paramDtsUltraTvSymMode;
    public int paramDtsUltraTvSymReset;
    public int paramSrsTheaterSoundDcControl;
    public int paramSrsTheaterSoundDefinitionControl;
    public int paramSrsTheaterSoundHardLimiterBoostGain;
    public int paramSrsTheaterSoundHardLimiterLevel;
    public int paramSrsTheaterSoundHeadRoomGain;
    public int paramSrsTheaterSoundHpfFc;
    public int paramSrsTheaterSoundInputGain;
    public int paramSrsTheaterSoundSpeakerSize;
    public int paramSrsTheaterSoundTruVolumeCalibrate;
    public int paramSrsTheaterSoundTruVolumeInputGain;
    public int paramSrsTheaterSoundTruVolumeMaxGain;
    public int paramSrsTheaterSoundTruVolumeMode;
    public int paramSrsTheaterSoundTruVolumeNoiseMngrThld;
    public int paramSrsTheaterSoundTruVolumeOutputGain;
    public int paramSrsTheaterSoundTruVolumeRefLevel;
    public int paramSrsTheaterSoundTrubassControl;
    public int paramSrsTheaterasoundSurrLevelControl;
    public int paramSrsTheaterasoundTrubassCompressorControl;
    public int paramSrsTheaterasoundTrubassProcessMode;
    public int paramSrsTheaterasoundTrubassSpeakerAnalysis;
    public int paramSrsTheaterasoundTrubassSpeakerAudio;
    public int paramSrsTheaterasoundTshdInputGain;
    public int paramSrsTheaterasoundTshdOnputGain;
    public int paramSrsTshdSetDcControl;
    public int paramSrsTshdSetDefinitionControl;
    public int paramSrsTshdSetInputGain;
    public int paramSrsTshdSetInputMode;
    public int paramSrsTshdSetLimiterControl;
    public int paramSrsTshdSetOutputGain;
    public int paramSrsTshdSetOutputMode;
    public int paramSrsTshdSetSpeakerSize;
    public int paramSrsTshdSetSurroundLevel;
    public int paramSrsTshdSetTrubassControl;
    public int paramSrsTshdSetWowCenterControl;
    public int paramSrsTshdSetWowHdSrs3dMode;
    public int paramSrsTshdSetWowSpaceControl;
    public int paramSrsTsxtSetDcGain;
    public int paramSrsTsxtSetInputGain;
    public int paramSrsTsxtSetInputMode;
    public int paramSrsTsxtSetOutputGain;
    public int paramSrsTsxtSetSpeakerSize;
    public int paramSrsTsxtSetTrubassGain;

    /* renamed from: com.mstar.android.tvapi.common.vo.AdvancedSoundParameter.1 */
    static class C01191 implements Creator<AdvancedSoundParameter> {
        C01191() {
        }

        public AdvancedSoundParameter createFromParcel(Parcel in) {
            return new AdvancedSoundParameter(null);
        }

        public AdvancedSoundParameter[] newArray(int size) {
            return new AdvancedSoundParameter[size];
        }
    }

    public AdvancedSoundParameter() {
        this.paramDolbyPl2vdpkSmod = 0;
        this.paramDolbyPl2vdpkWmod = 0;
        this.paramSrsTsxtSetInputGain = 0;
        this.paramSrsTsxtSetDcGain = 0;
        this.paramSrsTsxtSetTrubassGain = 0;
        this.paramSrsTsxtSetSpeakerSize = 0;
        this.paramSrsTsxtSetInputMode = 0;
        this.paramSrsTsxtSetOutputGain = 0;
        this.paramSrsTshdSetInputMode = 0;
        this.paramSrsTshdSetOutputMode = 0;
        this.paramSrsTshdSetSpeakerSize = 0;
        this.paramSrsTshdSetTrubassControl = 0;
        this.paramSrsTshdSetDefinitionControl = 0;
        this.paramSrsTshdSetDcControl = 0;
        this.paramSrsTshdSetSurroundLevel = 0;
        this.paramSrsTshdSetInputGain = 0;
        this.paramSrsTshdSetWowSpaceControl = 0;
        this.paramSrsTshdSetWowCenterControl = 0;
        this.paramSrsTshdSetWowHdSrs3dMode = 0;
        this.paramSrsTshdSetLimiterControl = 0;
        this.paramSrsTshdSetOutputGain = 0;
        this.paramSrsTheaterSoundInputGain = 0;
        this.paramSrsTheaterSoundDefinitionControl = 0;
        this.paramSrsTheaterSoundDcControl = 0;
        this.paramSrsTheaterSoundTrubassControl = 0;
        this.paramSrsTheaterSoundSpeakerSize = 0;
        this.paramSrsTheaterSoundHardLimiterLevel = 0;
        this.paramSrsTheaterSoundHardLimiterBoostGain = 0;
        this.paramSrsTheaterSoundHeadRoomGain = 0;
        this.paramSrsTheaterSoundTruVolumeMode = 0;
        this.paramSrsTheaterSoundTruVolumeRefLevel = 0;
        this.paramSrsTheaterSoundTruVolumeMaxGain = 0;
        this.paramSrsTheaterSoundTruVolumeNoiseMngrThld = 0;
        this.paramSrsTheaterSoundTruVolumeCalibrate = 0;
        this.paramSrsTheaterSoundTruVolumeInputGain = 0;
        this.paramSrsTheaterSoundTruVolumeOutputGain = 0;
        this.paramSrsTheaterSoundHpfFc = 0;
        this.paramDtsUltraTvEvoMonoInput = 0;
        this.paramDtsUltraTvEvoWideningon = 0;
        this.paramDtsUltraTvEvoAdd3dBon = 0;
        this.paramDtsUltraTvEvoPceLevel = 0;
        this.paramDtsUltraTvEvoVlfeLevel = 0;
        this.paramDtsUltraTvSymDefault = 0;
        this.paramDtsUltraTvSymMode = 0;
        this.paramDtsUltraTvSymLevel = 0;
        this.paramDtsUltraTvSymReset = 0;
        this.paramAudysseyDynamicVolCompressMode = 0;
        this.paramAudysseyDynamicVolGc = 0;
        this.paramAudysseyDynamicVolVolSetting = 0;
        this.paramAudysseyDynamicEqEqOffset = 0;
        this.paramAudysseyAbxGwet = 0;
        this.paramAudysseyAbxGdry = 0;
        this.paramAudysseyAbxFilset = 0;
        this.paramSrsTheaterasoundTshdInputGain = 0;
        this.paramSrsTheaterasoundTshdOnputGain = 0;
        this.paramSrsTheaterasoundSurrLevelControl = 0;
        this.paramSrsTheaterasoundTrubassCompressorControl = 0;
        this.paramSrsTheaterasoundTrubassProcessMode = 0;
        this.paramSrsTheaterasoundTrubassSpeakerAudio = 0;
        this.paramSrsTheaterasoundTrubassSpeakerAnalysis = 0;
    }

    private AdvancedSoundParameter(Parcel in) {
        this.paramDolbyPl2vdpkSmod = in.readInt();
        this.paramDolbyPl2vdpkWmod = in.readInt();
        this.paramSrsTsxtSetInputGain = in.readInt();
        this.paramSrsTsxtSetDcGain = in.readInt();
        this.paramSrsTsxtSetTrubassGain = in.readInt();
        this.paramSrsTsxtSetSpeakerSize = in.readInt();
        this.paramSrsTsxtSetInputMode = in.readInt();
        this.paramSrsTsxtSetOutputGain = in.readInt();
        this.paramSrsTshdSetInputMode = in.readInt();
        this.paramSrsTshdSetOutputMode = in.readInt();
        this.paramSrsTshdSetSpeakerSize = in.readInt();
        this.paramSrsTshdSetTrubassControl = in.readInt();
        this.paramSrsTshdSetDefinitionControl = in.readInt();
        this.paramSrsTshdSetDcControl = in.readInt();
        this.paramSrsTshdSetSurroundLevel = in.readInt();
        this.paramSrsTshdSetInputGain = in.readInt();
        this.paramSrsTshdSetWowSpaceControl = in.readInt();
        this.paramSrsTshdSetWowCenterControl = in.readInt();
        this.paramSrsTshdSetWowHdSrs3dMode = in.readInt();
        this.paramSrsTshdSetLimiterControl = in.readInt();
        this.paramSrsTshdSetOutputGain = in.readInt();
        this.paramSrsTheaterSoundInputGain = in.readInt();
        this.paramSrsTheaterSoundDefinitionControl = in.readInt();
        this.paramSrsTheaterSoundDcControl = in.readInt();
        this.paramSrsTheaterSoundTrubassControl = in.readInt();
        this.paramSrsTheaterSoundSpeakerSize = in.readInt();
        this.paramSrsTheaterSoundHardLimiterLevel = in.readInt();
        this.paramSrsTheaterSoundHardLimiterBoostGain = in.readInt();
        this.paramSrsTheaterSoundHeadRoomGain = in.readInt();
        this.paramSrsTheaterSoundTruVolumeMode = in.readInt();
        this.paramSrsTheaterSoundTruVolumeRefLevel = in.readInt();
        this.paramSrsTheaterSoundTruVolumeMaxGain = in.readInt();
        this.paramSrsTheaterSoundTruVolumeNoiseMngrThld = in.readInt();
        this.paramSrsTheaterSoundTruVolumeCalibrate = in.readInt();
        this.paramSrsTheaterSoundTruVolumeInputGain = in.readInt();
        this.paramSrsTheaterSoundTruVolumeOutputGain = in.readInt();
        this.paramSrsTheaterSoundHpfFc = in.readInt();
        this.paramDtsUltraTvEvoMonoInput = in.readInt();
        this.paramDtsUltraTvEvoWideningon = in.readInt();
        this.paramDtsUltraTvEvoAdd3dBon = in.readInt();
        this.paramDtsUltraTvEvoPceLevel = in.readInt();
        this.paramDtsUltraTvEvoVlfeLevel = in.readInt();
        this.paramDtsUltraTvSymDefault = in.readInt();
        this.paramDtsUltraTvSymMode = in.readInt();
        this.paramDtsUltraTvSymLevel = in.readInt();
        this.paramDtsUltraTvSymReset = in.readInt();
        this.paramAudysseyDynamicVolCompressMode = in.readInt();
        this.paramAudysseyDynamicVolGc = in.readInt();
        this.paramAudysseyDynamicVolVolSetting = in.readInt();
        this.paramAudysseyDynamicEqEqOffset = in.readInt();
        this.paramAudysseyAbxGwet = in.readInt();
        this.paramAudysseyAbxGdry = in.readInt();
        this.paramAudysseyAbxFilset = in.readInt();
        this.paramSrsTheaterasoundTshdInputGain = in.readInt();
        this.paramSrsTheaterasoundTshdOnputGain = in.readInt();
        this.paramSrsTheaterasoundSurrLevelControl = in.readInt();
        this.paramSrsTheaterasoundTrubassCompressorControl = in.readInt();
        this.paramSrsTheaterasoundTrubassProcessMode = in.readInt();
        this.paramSrsTheaterasoundTrubassSpeakerAudio = in.readInt();
        this.paramSrsTheaterasoundTrubassSpeakerAnalysis = in.readInt();
    }

    static {
        CREATOR = new C01191();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.paramDolbyPl2vdpkSmod);
        dest.writeInt(this.paramDolbyPl2vdpkWmod);
        dest.writeInt(this.paramSrsTsxtSetInputGain);
        dest.writeInt(this.paramSrsTsxtSetDcGain);
        dest.writeInt(this.paramSrsTsxtSetTrubassGain);
        dest.writeInt(this.paramSrsTsxtSetSpeakerSize);
        dest.writeInt(this.paramSrsTsxtSetInputMode);
        dest.writeInt(this.paramSrsTsxtSetOutputGain);
        dest.writeInt(this.paramSrsTshdSetInputMode);
        dest.writeInt(this.paramSrsTshdSetOutputMode);
        dest.writeInt(this.paramSrsTshdSetSpeakerSize);
        dest.writeInt(this.paramSrsTshdSetTrubassControl);
        dest.writeInt(this.paramSrsTshdSetDefinitionControl);
        dest.writeInt(this.paramSrsTshdSetDcControl);
        dest.writeInt(this.paramSrsTshdSetSurroundLevel);
        dest.writeInt(this.paramSrsTshdSetInputGain);
        dest.writeInt(this.paramSrsTshdSetWowSpaceControl);
        dest.writeInt(this.paramSrsTshdSetWowCenterControl);
        dest.writeInt(this.paramSrsTshdSetWowHdSrs3dMode);
        dest.writeInt(this.paramSrsTshdSetLimiterControl);
        dest.writeInt(this.paramSrsTshdSetOutputGain);
        dest.writeInt(this.paramSrsTheaterSoundInputGain);
        dest.writeInt(this.paramSrsTheaterSoundDefinitionControl);
        dest.writeInt(this.paramSrsTheaterSoundDcControl);
        dest.writeInt(this.paramSrsTheaterSoundTrubassControl);
        dest.writeInt(this.paramSrsTheaterSoundSpeakerSize);
        dest.writeInt(this.paramSrsTheaterSoundHardLimiterLevel);
        dest.writeInt(this.paramSrsTheaterSoundHardLimiterBoostGain);
        dest.writeInt(this.paramSrsTheaterSoundHeadRoomGain);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeMode);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeRefLevel);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeMaxGain);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeNoiseMngrThld);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeCalibrate);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeInputGain);
        dest.writeInt(this.paramSrsTheaterSoundTruVolumeOutputGain);
        dest.writeInt(this.paramSrsTheaterSoundHpfFc);
        dest.writeInt(this.paramDtsUltraTvEvoMonoInput);
        dest.writeInt(this.paramDtsUltraTvEvoWideningon);
        dest.writeInt(this.paramDtsUltraTvEvoAdd3dBon);
        dest.writeInt(this.paramDtsUltraTvEvoPceLevel);
        dest.writeInt(this.paramDtsUltraTvEvoVlfeLevel);
        dest.writeInt(this.paramDtsUltraTvSymDefault);
        dest.writeInt(this.paramDtsUltraTvSymMode);
        dest.writeInt(this.paramDtsUltraTvSymLevel);
        dest.writeInt(this.paramDtsUltraTvSymReset);
        dest.writeInt(this.paramAudysseyDynamicVolCompressMode);
        dest.writeInt(this.paramAudysseyDynamicVolGc);
        dest.writeInt(this.paramAudysseyDynamicVolVolSetting);
        dest.writeInt(this.paramAudysseyDynamicEqEqOffset);
        dest.writeInt(this.paramAudysseyAbxGwet);
        dest.writeInt(this.paramAudysseyAbxGdry);
        dest.writeInt(this.paramAudysseyAbxFilset);
        dest.writeInt(this.paramSrsTheaterasoundTshdInputGain);
        dest.writeInt(this.paramSrsTheaterasoundTshdOnputGain);
        dest.writeInt(this.paramSrsTheaterasoundSurrLevelControl);
        dest.writeInt(this.paramSrsTheaterasoundTrubassCompressorControl);
        dest.writeInt(this.paramSrsTheaterasoundTrubassProcessMode);
        dest.writeInt(this.paramSrsTheaterasoundTrubassSpeakerAudio);
        dest.writeInt(this.paramSrsTheaterasoundTrubassSpeakerAnalysis);
    }
}
