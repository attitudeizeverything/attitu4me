package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.MKeyEvent;
import com.mstar.android.tvapi.common.exception.TvOutOfBoundException;
import java.util.Hashtable;

public class EpgEventInfo implements Parcelable {
    public static final Creator<EpgEventInfo> CREATOR;
    private static Hashtable<Integer, Integer> enumhash;
    public String description;
    public int durationTime;
    public int endTime;
    public int eventId;
    protected int functionStatus;
    public short genre;
    public boolean isScrambled;
    public String name;
    public int originalStartTime;
    public short parentalRating;
    public int startTime;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.EpgEventInfo.1 */
    static class C02221 implements Creator<EpgEventInfo> {
        C02221() {
        }

        public EpgEventInfo createFromParcel(Parcel in) {
            return new EpgEventInfo(in);
        }

        public EpgEventInfo[] newArray(int size) {
            return new EpgEventInfo[size];
        }
    }

    public enum EnumEpgFunctionStatus {
        E_EPG_FUNC_STATUS_SUCCESS(0),
        E_EPG_FUNC_STATUS_INVALID(1),
        E_EPG_FUNC_STATUS_NO_EVENT(2),
        E_EPG_FUNC_STATUS_NO_STRING(3),
        E_EPG_FUNC_STATUS_NO_CHANNEL(4),
        E_EPG_FUNC_STATUS_CRID_NOT_FOUND(5),
        E_EPG_FUNC_STATUS_DB_NO_CONNECT(10),
        E_EPG_FUNC_STATUS_DB_NO_LOCK(11),
        E_EPG_FUNC_STATUS_DB_NO_CHANNEL_DB(12),
        E_EPG_FUNC_STATUS_NO_FUNCTION(MKeyEvent.KEYCODE_SLEEP);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumEpgFunctionStatus(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            EpgEventInfo.enumhash.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) throws TvOutOfBoundException {
            Integer ordinal = (Integer) EpgEventInfo.enumhash.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            throw new TvOutOfBoundException();
        }
    }

    static {
        enumhash = new Hashtable();
        CREATOR = new C02221();
    }

    public EpgEventInfo() {
        this.startTime = 0;
        this.endTime = 0;
        this.durationTime = 0;
        this.name = "";
        this.eventId = 0;
        this.isScrambled = false;
        this.genre = (short) 0;
        this.parentalRating = (short) 0;
        this.description = "";
        this.originalStartTime = 0;
        this.functionStatus = 0;
    }

    public EpgEventInfo(Parcel in) {
        boolean z = true;
        this.startTime = in.readInt();
        this.endTime = in.readInt();
        this.durationTime = in.readInt();
        this.name = in.readString();
        this.eventId = in.readInt();
        if (in.readInt() != 1) {
            z = false;
        }
        this.isScrambled = z;
        this.genre = (short) in.readInt();
        this.parentalRating = (short) in.readInt();
        this.description = in.readString();
        this.originalStartTime = in.readInt();
        this.functionStatus = in.readInt();
    }

    public EnumEpgFunctionStatus getEpgFunctionStatus() throws TvOutOfBoundException {
        return EnumEpgFunctionStatus.values()[EnumEpgFunctionStatus.getOrdinalThroughValue(this.functionStatus)];
    }

    public void setEpgFunctionStatus(EnumEpgFunctionStatus status) {
        this.functionStatus = status.getValue();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.startTime);
        dest.writeInt(this.endTime);
        dest.writeInt(this.durationTime);
        dest.writeString(this.name);
        dest.writeInt(this.eventId);
        dest.writeInt(this.isScrambled ? 1 : 0);
        dest.writeInt(this.genre);
        dest.writeInt(this.parentalRating);
        dest.writeString(this.description);
        dest.writeInt(this.originalStartTime);
        dest.writeInt(this.functionStatus);
    }
}
