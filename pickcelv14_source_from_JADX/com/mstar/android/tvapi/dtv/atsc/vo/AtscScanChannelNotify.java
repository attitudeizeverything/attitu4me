package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtscScanChannelNotify implements Parcelable {
    public static final Creator<AtscScanChannelNotify> CREATOR;
    private static final int MAX_LENGTH_OF_SERVICE_NAME = 8;
    public boolean bIsDelOrNot;
    public short majorNum;
    public short minorNum;
    public int progID;
    public short rFCh;
    public short[] serviceName;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.AtscScanChannelNotify.1 */
    static class C01861 implements Creator<AtscScanChannelNotify> {
        C01861() {
        }

        public AtscScanChannelNotify createFromParcel(Parcel in) {
            return new AtscScanChannelNotify(in);
        }

        public AtscScanChannelNotify[] newArray(int size) {
            return new AtscScanChannelNotify[size];
        }
    }

    public AtscScanChannelNotify() {
        this.serviceName = new short[MAX_LENGTH_OF_SERVICE_NAME];
        this.majorNum = (short) 0;
        this.minorNum = (short) 0;
        this.rFCh = (short) 0;
        this.progID = 0;
        this.bIsDelOrNot = true;
        for (int i = 0; i < this.serviceName.length; i++) {
            this.serviceName[i] = (short) 0;
        }
    }

    public AtscScanChannelNotify(Parcel in) {
        this.serviceName = new short[MAX_LENGTH_OF_SERVICE_NAME];
        this.majorNum = (short) in.readInt();
        this.minorNum = (short) in.readInt();
        this.rFCh = (short) in.readInt();
        this.progID = in.readInt();
        this.bIsDelOrNot = in.readInt() == 0;
        for (int i = 0; i < this.serviceName.length; i++) {
            this.serviceName[i] = (short) in.readInt();
        }
    }

    static {
        CREATOR = new C01861();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.majorNum);
        dest.writeInt(this.minorNum);
        dest.writeInt(this.rFCh);
        dest.writeInt(this.progID);
        dest.writeInt(this.bIsDelOrNot ? 0 : 1);
        for (short writeInt : this.serviceName) {
            dest.writeInt(writeInt);
        }
    }
}
