package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.common.exception.TvOutOfBoundException;
import java.util.Hashtable;

public class DtvProgramSignalInfo implements Parcelable {
    public static final Creator<DtvProgramSignalInfo> CREATOR;
    private static Hashtable<Integer, Integer> enumhash;
    public short amMode;
    private int modulationMode;
    public String networkName;
    public int quality;
    public short rfNumber;
    public int strength;
    public int symbolRate;

    /* renamed from: com.mstar.android.tvapi.common.vo.DtvProgramSignalInfo.1 */
    static class C01321 implements Creator<DtvProgramSignalInfo> {
        C01321() {
        }

        public DtvProgramSignalInfo createFromParcel(Parcel in) {
            return new DtvProgramSignalInfo(in);
        }

        public DtvProgramSignalInfo[] newArray(int size) {
            return new DtvProgramSignalInfo[size];
        }
    }

    public enum EnumProgramDemodType {
        E_PROGRAM_DEMOD_ATV(0),
        E_PROGRAM_DEMOD_DVB_T(1),
        E_PROGRAM_DEMOD_DVB_C(2),
        E_PROGRAM_DEMOD_DVB_S(3),
        E_PROGRAM_DEMOD_DTMB(4),
        E_PROGRAM_DEMOD_ATSC(5),
        E_PROGRAM_DEMOD_ATSC_VSB(6),
        E_PROGRAM_DEMOD_ATSC_QPSK(7),
        E_PROGRAM_DEMOD_ATSC_16QAM(8),
        E_PROGRAM_DEMOD_ATSC_64QAM(9),
        E_PROGRAM_DEMOD_ATSC_256QAM(10),
        E_PROGRAM_DEMOD_DVB_T2(11),
        E_PROGRAM_DEMOD_ISDB(12),
        E_PROGRAM_DEMOD_MAX(13),
        E_PROGRAM_DEMOD_NULL(13);
        
        private static int seq;
        private final int value;

        static {
            seq = 0;
        }

        private EnumProgramDemodType(int value) {
            this.value = value;
            setHashtableValue(value);
        }

        private static void setHashtableValue(int value) {
            DtvProgramSignalInfo.enumhash.put(new Integer(value), new Integer(seq));
            seq++;
        }

        public int getValue() {
            return this.value;
        }

        public static int getOrdinalThroughValue(int key) throws TvOutOfBoundException {
            Integer ordinal = (Integer) DtvProgramSignalInfo.enumhash.get(Integer.valueOf(key));
            if (ordinal != null) {
                return ordinal.intValue();
            }
            throw new TvOutOfBoundException();
        }
    }

    static {
        enumhash = new Hashtable();
        CREATOR = new C01321();
    }

    public DtvProgramSignalInfo() {
        this.rfNumber = (short) 0;
        this.modulationMode = 0;
        this.amMode = (short) 0;
        this.quality = 0;
        this.strength = 0;
        this.symbolRate = 0;
        this.networkName = "";
    }

    public DtvProgramSignalInfo(Parcel in) {
        this.rfNumber = (short) in.readInt();
        this.modulationMode = in.readInt();
        this.amMode = (short) in.readInt();
        this.quality = in.readInt();
        this.strength = in.readInt();
        this.symbolRate = in.readInt();
        this.networkName = in.readString();
    }

    public EnumProgramDemodType getModulationMode() throws TvOutOfBoundException {
        return EnumProgramDemodType.values()[EnumProgramDemodType.getOrdinalThroughValue(this.modulationMode)];
    }

    public void setModulationMode(EnumProgramDemodType Mode) {
        this.modulationMode = Mode.getValue();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.rfNumber);
        dest.writeInt(this.modulationMode);
        dest.writeInt(this.amMode);
        dest.writeInt(this.quality);
        dest.writeInt(this.strength);
        dest.writeInt(this.symbolRate);
        dest.writeString(this.networkName);
    }
}
