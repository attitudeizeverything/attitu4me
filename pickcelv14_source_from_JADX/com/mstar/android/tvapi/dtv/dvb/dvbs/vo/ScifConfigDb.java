package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScifConfigDb implements Parcelable {
    public static final Creator<ScifConfigDb> CREATOR;
    public static final int MAX_NUM_UBAND = 8;
    public short[] frequencies;
    public short hiLOF;
    public short lowLOF;
    public ScifConfig scifConfig;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.ScifConfigDb.1 */
    static class C01991 implements Creator<ScifConfigDb> {
        C01991() {
        }

        public ScifConfigDb createFromParcel(Parcel in) {
            return new ScifConfigDb(null);
        }

        public ScifConfigDb[] newArray(int size) {
            return new ScifConfigDb[size];
        }
    }

    public ScifConfigDb() {
        this.frequencies = new short[MAX_NUM_UBAND];
        this.scifConfig = new ScifConfig();
        this.hiLOF = (short) 0;
        this.lowLOF = (short) 0;
        for (int i = 0; i < MAX_NUM_UBAND; i++) {
            this.frequencies[i] = (short) 0;
        }
    }

    public int describeContents() {
        return 0;
    }

    private ScifConfigDb(Parcel in) {
        this.frequencies = new short[MAX_NUM_UBAND];
        this.scifConfig = (ScifConfig) ScifConfig.CREATOR.createFromParcel(in);
        this.hiLOF = (short) in.readInt();
        this.lowLOF = (short) in.readInt();
        for (int i = 0; i < MAX_NUM_UBAND; i++) {
            this.frequencies[i] = (short) in.readInt();
        }
    }

    static {
        CREATOR = new C01991();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        this.scifConfig.writeToParcel(arg0, arg1);
        arg0.writeInt(this.hiLOF);
        arg0.writeInt(this.lowLOF);
        for (int i = 0; i < MAX_NUM_UBAND; i++) {
            arg0.writeInt(this.frequencies[i]);
        }
    }
}
