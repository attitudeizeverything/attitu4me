package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TravelingModeInfo implements Parcelable {
    public static final Creator<TravelingModeInfo> CREATOR;
    public int captureStage;
    public int framerateX10;
    public int height;
    public byte isCaptureOSD;
    public int length;
    public long magicValueAddr;
    public int mapiSubSource;
    public int memoryAlignment;
    public int memoryFormat;
    public int memoryPhysicalAddress;
    public int memorySize;
    public int travelingSource;
    public int version;
    public int width;

    /* renamed from: com.mstar.android.tvapi.common.vo.TravelingModeInfo.1 */
    static class C01721 implements Creator<TravelingModeInfo> {
        C01721() {
        }

        public TravelingModeInfo createFromParcel(Parcel in) {
            return new TravelingModeInfo(in);
        }

        public TravelingModeInfo[] newArray(int size) {
            return new TravelingModeInfo[size];
        }
    }

    public TravelingModeInfo() {
        this.version = 0;
        this.length = 0;
        this.memoryAlignment = 0;
        this.memoryPhysicalAddress = 0;
        this.memorySize = 0;
        this.memoryFormat = 0;
        this.travelingSource = 0;
        this.mapiSubSource = 0;
        this.isCaptureOSD = (byte) 0;
        this.width = 0;
        this.height = 0;
        this.framerateX10 = 0;
        this.captureStage = 0;
        this.magicValueAddr = 0;
    }

    public TravelingModeInfo(Parcel in) {
        this.version = in.readInt();
        this.length = in.readInt();
        this.memoryAlignment = in.readInt();
        this.memoryPhysicalAddress = in.readInt();
        this.memorySize = in.readInt();
        this.memoryFormat = in.readInt();
        this.travelingSource = in.readInt();
        this.mapiSubSource = in.readInt();
        this.isCaptureOSD = in.readByte();
        this.width = in.readInt();
        this.height = in.readInt();
        this.framerateX10 = in.readInt();
        this.captureStage = in.readInt();
        this.magicValueAddr = in.readLong();
    }

    static {
        CREATOR = new C01721();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.version);
        dest.writeInt(this.length);
        dest.writeInt(this.memoryAlignment);
        dest.writeInt(this.memoryPhysicalAddress);
        dest.writeInt(this.memorySize);
        dest.writeInt(this.memoryFormat);
        dest.writeInt(this.travelingSource);
        dest.writeInt(this.mapiSubSource);
        dest.writeByte(this.isCaptureOSD);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.framerateX10);
        dest.writeInt(this.captureStage);
        dest.writeLong(this.magicValueAddr);
    }
}
