package com.mstar.android.tvapi.common.vo;

import java.util.Hashtable;

public class AudioCommonInfoType {
    private static Hashtable<Integer, Integer> htEnumAudioCommonInfoType;

    public enum EnumAudioCommonInfoType {
        E_AUDIO_COMMON_INFO_TYPE_DecStatus(0),
        E_AUDIO_COMMON_INFO_TYPE_SampleRate_(1),
        E_AUDIO_COMMON_INFO_TYPE_SoundMode_(2),
        E_AUDIO_COMMON_INFO_TYPE_DecOutMode_(3),
        E_AUDIO_COMMON_INFO_TYPE_ChannelMode_(4),
        E_AUDIO_COMMON_INFO_TYPE_MMFileSize_(5),
        E_AUDIO_COMMON_INFO_TYPE_33Bit_PTS_(6),
        E_AUDIO_COMMON_INFO_TYPE_33Bit_STCPTS_DIFF_(7),
        E_AUDIO_COMMON_INFO_TYPE_1ms_PTS_(8),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_BufferSize_(9),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_BufferAddr_(10),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_MMTag_(11),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_MMResidualPCM_(12),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_ESBufferSize_(13),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_PCMBufferSize_(14),
        E_AUDIO_COMMON_INFO_TYPE_DEC2_BufferSize_(15),
        E_AUDIO_COMMON_INFO_TYPE_DEC2_BufferAddr_(16),
        E_AUDIO_COMMON_INFO_TYPE_DEC2_MMTag_(17),
        E_AUDIO_COMMON_INFO_TYPE_DEC2_MMResidualPCM_(18),
        E_AUDIO_COMMON_INFO_TYPE_DecodeErrorCnt_(19),
        E_AUDIO_COMMON_INFO_TYPE_MM_FFx2_(20),
        E_AUDIO_COMMON_INFO_TYPE_setBypassSPDIF_PAPB_chk_(21),
        E_AUDIO_COMMON_INFO_TYPE_CompressBin_LoadCode_(22),
        E_AUDIO_COMMON_INFO_TYPE_CompressBin_DDRAddress_(23),
        E_AUDIO_COMMON_INFO_TYPE_DMAReader_BufferLevel_(24),
        E_AUDIO_COMMON_INFO_TYPE_DMAReader_Command_(25),
        E_AUDIO_COMMON_INFO_TYPE_SetSCMS_(26),
        E_AUDIO_COMMON_INFO_TYPE_GetSCMS_(27),
        E_AUDIO_COMMON_INFO_TYPE_ADC_InputGain_(28),
        E_AUDIO_COMMON_INFO_TYPE_KTV_SetType_(29),
        E_AUDIO_COMMON_INFO_TYPE_getSignal_Energy_(30),
        E_AUDIO_COMMON_INFO_TYPE_getNR_Status_(31),
        E_AUDIO_COMMON_INFO_TYPE_setNR_Threshold_(32),
        E_AUDIO_COMMON_INFO_TYPE_setSPDIF_FS_(33),
        E_AUDIO_COMMON_INFO_TYPE_getSPDIF_FS_(34),
        E_AUDIO_COMMON_INFO_TYPE_setSpdifDelay_(35),
        E_AUDIO_COMMON_INFO_TYPE_ReadByte_(36),
        E_AUDIO_COMMON_INFO_TYPE_WriteByte_(37),
        E_AUDIO_COMMON_INFO_TYPE_hdmiTx_outType_(38),
        E_AUDIO_COMMON_INFO_TYPE_hdmiTx_outFreq_(39),
        E_AUDIO_COMMON_INFO_TYPE_PTS_info_(40),
        E_AUDIO_COMMON_INFO_TYPE_RTSP_Mem_(41),
        E_AUDIO_COMMON_INFO_TYPE_setSpdif_BufferProcess_(42),
        E_AUDIO_COMMON_INFO_TYPE_DEC1_setBufferProcess_(43),
        E_AUDIO_COMMON_INFO_TYPE_setES_REQ_SZ_(44),
        E_AUDIO_COMMON_INFO_TYPE_AD_OutputStyle_(45),
        E_AUDIO_COMMON_INFO_TYPE_getHDMI_CopyRight_C_Bit_(46),
        E_AUDIO_COMMON_INFO_TYPE_getHDMI_CopyRight_L_Bit_(47),
        E_AUDIO_COMMON_INFO_TYPE_Set_UNI_NEED_DECODE_FRMCNT_(48),
        E_AUDIO_COMMON_INFO_TYPE_Set_UNI_ES_Wptr_(49),
        E_AUDIO_COMMON_INFO_TYPE_Get_UNI_ES_MEMCNT_(50),
        E_AUDIO_COMMON_INFO_TYPE_Set_MENU_WT_PTR_(51),
        E_AUDIO_COMMON_INFO_TYPE_Get_MENU_WT_PTR_(52),
        E_AUDIO_COMMON_INFO_TYPE_Get_MENU_KEY_CNT_(53),
        E_AUDIO_COMMON_INFO_TYPE_Get_CurSynthRate_(54),
        E_AUDIO_COMMON_INFO_TYPE_ADC1_InputGain_(55);
        
        private static int seq;
        private final int value;

        private EnumAudioCommonInfoType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            AudioCommonInfoType.htEnumAudioCommonInfoType.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) AudioCommonInfoType.htEnumAudioCommonInfoType.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return -1;
        }
    }

    static {
        htEnumAudioCommonInfoType = new Hashtable();
    }
}
