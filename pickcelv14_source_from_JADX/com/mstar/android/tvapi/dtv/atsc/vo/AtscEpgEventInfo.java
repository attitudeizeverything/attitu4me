package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.MKeyEvent;
import java.util.Hashtable;
import jcifs.smb.SmbNamedPipe;

public class AtscEpgEventInfo implements Parcelable {
    public static final Creator<AtscEpgEventInfo> CREATOR;
    private static Hashtable<Integer, Integer> enumhash;
    public boolean bHasCCInfo;
    public int durationTime;
    public EnumAtscEpgFunctionStatus enStrStatus;
    public int endTime;
    public String sExtendedText;
    public String sName;
    public AtscEpgRating stRating;
    public int startTime;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.AtscEpgEventInfo.1 */
    static class C01821 implements Creator<AtscEpgEventInfo> {
        C01821() {
        }

        public AtscEpgEventInfo createFromParcel(Parcel in) {
            return new AtscEpgEventInfo(in);
        }

        public AtscEpgEventInfo[] newArray(int size) {
            return new AtscEpgEventInfo[size];
        }
    }

    public enum EnumAtscEpgFunctionStatus {
        EN_ATSC_EPG_FUNC_STATUS_SUCCESS(0),
        EN_ATSC_EPG_FUNC_STATUS_INVALID(1),
        EN_ATSC_EPG_FUNC_STATUS_NO_EVENT(2),
        EN_ATSC_EPG_FUNC_STATUS_NO_STRING(3),
        EN_ATSC_EPG_FUNC_STATUS_NO_CHANNEL(4),
        EN_ATSC_EPG_FUNC_STATUS_DB_NO_CONNECT(10),
        EN_ATSC_EPG_FUNC_STATUS_DB_NO_LOCK(11),
        EN_ATSC_EPG_FUNC_STATUS_DB_NO_CHANNEL_DB(12),
        EN_ATSC_EPG_FUNC_STATUS_NO_FUNCTION(MKeyEvent.KEYCODE_SLEEP),
        EN_ATSC_EPG_FUNC_STATUS_UNDEFINED(SmbNamedPipe.PIPE_TYPE_CALL);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumAtscEpgFunctionStatus(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            AtscEpgEventInfo.enumhash.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) {
            Integer ordinal = (Integer) AtscEpgEventInfo.enumhash.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            return ((Integer) AtscEpgEventInfo.enumhash.get(Integer.valueOf(SmbNamedPipe.PIPE_TYPE_CALL))).intValue();
        }
    }

    static {
        enumhash = new Hashtable();
        CREATOR = new C01821();
    }

    public AtscEpgEventInfo(Parcel in) {
        boolean z = true;
        this.startTime = in.readInt();
        this.endTime = in.readInt();
        this.durationTime = in.readInt();
        this.enStrStatus = EnumAtscEpgFunctionStatus.values()[EnumAtscEpgFunctionStatus.getOrdinalThroughValue(in.readInt())];
        this.sName = in.readString();
        if (in.readInt() != 1) {
            z = false;
        }
        this.bHasCCInfo = z;
        this.stRating = (AtscEpgRating) AtscEpgRating.CREATOR.createFromParcel(in);
        this.sExtendedText = in.readString();
    }

    public AtscEpgEventInfo() {
        this.startTime = 0;
        this.endTime = 0;
        this.durationTime = 0;
        this.enStrStatus = EnumAtscEpgFunctionStatus.EN_ATSC_EPG_FUNC_STATUS_UNDEFINED;
        this.sName = "";
        this.bHasCCInfo = false;
        this.stRating = new AtscEpgRating();
        this.sExtendedText = "";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        int i;
        arg0.writeInt(this.startTime);
        arg0.writeInt(this.endTime);
        arg0.writeInt(this.durationTime);
        arg0.writeInt(this.enStrStatus.getValue());
        arg0.writeString(this.sName);
        if (this.bHasCCInfo) {
            i = 1;
        } else {
            i = 0;
        }
        arg0.writeInt(i);
        this.stRating.writeToParcel(arg0, 0);
        arg0.writeString(this.sExtendedText);
    }
}
