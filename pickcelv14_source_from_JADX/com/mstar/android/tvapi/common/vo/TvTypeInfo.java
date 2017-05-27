package com.mstar.android.tvapi.common.vo;

public class TvTypeInfo {
    private int atvType;
    public int audioType;
    public short dtvType;
    public int ipEnableType;
    public String routePath;
    public int stbType;
    private int tvType;

    public enum EnumAtvSystemType {
        E_ATV_SYSTEM_TYPE_NTSC_ENABLE,
        E_ATV_SYSTEM_TYPE_PAL_ENABLE,
        E_ATV_SYSTEM_TYPE_CHINA_ENABLE,
        E_ATV_SYSTEM_TYPE_PAL_M_ENABLE,
        E_ATV_SYSTEM_TYPE_ATV_SYSTEM_ID_MAX
    }

    public enum EnumAudioSystemType {
        E_AUDIO_SYSTEM_TYPE_BTSC_ENABLE,
        E_AUDIO_SYSTEM_TYPE_A2_ENABLE,
        E_AUDIO_SYSTEM_TYPE_EIAJ_ENABLE,
        E_AUDIO_SYSTEM_TYPE_AUDIO_SYSTEM_ID_MAX
    }

    public enum EnumStbSystemType {
        E_STB_SYSTEM_TYPE_STB_DISABLE,
        E_STB_SYSTEM_TYPE_STB_ENABLE
    }

    public enum EnumTvProductType {
        E_TV_PRODUCT_TYPE_ATV_Only,
        E_TV_PRODUCT_TYPE_DTV_Only,
        E_TV_PRODUCT_TYPE_ATV_Plus_DTV,
        E_TV_PRODUCT_TYPE_None,
        E_TV_PRODUCT_TYPE_ID_MAX
    }

    public void settvtype(EnumTvProductType tvproductType) {
        this.tvType = tvproductType.ordinal();
    }

    public EnumTvProductType gettvtype() {
        if (this.tvType < EnumTvProductType.E_TV_PRODUCT_TYPE_ATV_Only.ordinal() || this.tvType > EnumTvProductType.E_TV_PRODUCT_TYPE_ID_MAX.ordinal()) {
            return EnumTvProductType.values()[this.tvType];
        }
        return EnumTvProductType.E_TV_PRODUCT_TYPE_None;
    }

    public void setAtvType(EnumAtvSystemType atvsystemType) {
        this.atvType = atvsystemType.ordinal();
    }

    public EnumAtvSystemType getAtvType() {
        if (this.atvType < EnumAtvSystemType.E_ATV_SYSTEM_TYPE_NTSC_ENABLE.ordinal() || this.atvType > EnumAtvSystemType.E_ATV_SYSTEM_TYPE_ATV_SYSTEM_ID_MAX.ordinal()) {
            return EnumAtvSystemType.values()[this.atvType];
        }
        return EnumAtvSystemType.E_ATV_SYSTEM_TYPE_ATV_SYSTEM_ID_MAX;
    }

    public void setAudioType(EnumAudioSystemType audiosystemType) {
        this.audioType = audiosystemType.ordinal();
    }

    public EnumAudioSystemType getAudioType() {
        if (this.audioType < EnumAudioSystemType.E_AUDIO_SYSTEM_TYPE_BTSC_ENABLE.ordinal() || this.audioType > EnumAudioSystemType.E_AUDIO_SYSTEM_TYPE_AUDIO_SYSTEM_ID_MAX.ordinal()) {
            return EnumAudioSystemType.values()[this.atvType];
        }
        return EnumAudioSystemType.E_AUDIO_SYSTEM_TYPE_AUDIO_SYSTEM_ID_MAX;
    }

    public void setStbType(EnumStbSystemType stbSystemType) {
        this.stbType = stbSystemType.ordinal();
    }

    public EnumStbSystemType getStbType() {
        if (this.stbType < EnumStbSystemType.E_STB_SYSTEM_TYPE_STB_DISABLE.ordinal() || this.stbType > EnumStbSystemType.E_STB_SYSTEM_TYPE_STB_ENABLE.ordinal()) {
            return EnumStbSystemType.values()[this.atvType];
        }
        return EnumStbSystemType.E_STB_SYSTEM_TYPE_STB_DISABLE;
    }

    public TvTypeInfo() {
        this.tvType = 0;
        this.atvType = 0;
        this.dtvType = (short) 0;
        this.audioType = 0;
        this.stbType = 0;
        this.ipEnableType = 0;
    }
}
