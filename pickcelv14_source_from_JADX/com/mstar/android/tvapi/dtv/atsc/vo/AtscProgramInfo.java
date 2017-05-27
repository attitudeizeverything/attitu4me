package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.dtv.vo.AudioInfo;

public class AtscProgramInfo implements Parcelable {
    public static final Creator<AtscProgramInfo> CREATOR;
    public static final int MAX_AUD_LANG_NUM = 16;
    public static final int MAX_SERVICE_NAME = 8;
    AudioInfo[] audInfo;
    public short audLangNum;
    AtscChannelAttribute chAttribute;
    public int id;
    public int muxTableId;
    public int pcrPid;
    public int pmtPID;
    public int programNumber;
    AtscTableVersion psipVersionNum;
    public String serviceName;
    public int sourceId;
    public int videoPID;
    AtscVirtualChannelNumber virtualChNum;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.AtscProgramInfo.1 */
    static class C01851 implements Creator<AtscProgramInfo> {
        C01851() {
        }

        public AtscProgramInfo createFromParcel(Parcel in) {
            return new AtscProgramInfo(null);
        }

        public AtscProgramInfo[] newArray(int size) {
            return new AtscProgramInfo[size];
        }
    }

    public class AtscChannelAttribute {
        public byte favorite;
        public byte isHide;
        public byte isLock;
        public byte isRenamed;
        public byte isScramble;
        public byte isSkipped;
        public byte scrambleChStatus;
        public short serviceType;

        public AtscChannelAttribute() {
            this.scrambleChStatus = (byte) 0;
            this.isScramble = (byte) 0;
            this.isSkipped = (byte) 0;
            this.isLock = (byte) 0;
            this.favorite = (byte) 0;
            this.isHide = (byte) 0;
            this.isRenamed = (byte) 0;
            this.serviceType = (short) 0;
        }
    }

    public class AtscTableVersion {
        public short mgtVer;
        public short patVer;
        public short pmtVer;
        public short rrtVer;
        public short vctVer;

        public AtscTableVersion() {
            this.patVer = (short) 0;
            this.pmtVer = (short) 0;
            this.vctVer = (short) 0;
            this.mgtVer = (short) 0;
            this.rrtVer = (short) 0;
        }
    }

    public class AtscVirtualChannelNumber {
        public int majorNumber;
        public int minorNumber;

        public AtscVirtualChannelNumber() {
            this.majorNumber = 0;
            this.minorNumber = 0;
        }
    }

    public AtscProgramInfo() {
        this.id = 0;
        this.muxTableId = 0;
        this.psipVersionNum = new AtscTableVersion();
        this.chAttribute = new AtscChannelAttribute();
        this.serviceName = "";
        this.pcrPid = 0;
        this.videoPID = 0;
        this.pmtPID = 0;
        this.virtualChNum = new AtscVirtualChannelNumber();
        this.audLangNum = (short) 0;
        this.audInfo = new AudioInfo[MAX_AUD_LANG_NUM];
        for (int i = 0; i < MAX_AUD_LANG_NUM; i++) {
            this.audInfo[i] = new AudioInfo();
        }
        this.programNumber = 0;
        this.sourceId = 0;
    }

    private AtscProgramInfo(Parcel in) {
        this.id = in.readInt();
        this.muxTableId = in.readInt();
        this.psipVersionNum = new AtscTableVersion();
        this.psipVersionNum.mgtVer = (short) in.readInt();
        this.psipVersionNum.patVer = (short) in.readInt();
        this.psipVersionNum.pmtVer = (short) in.readInt();
        this.psipVersionNum.rrtVer = (short) in.readInt();
        this.psipVersionNum.vctVer = (short) in.readInt();
        this.chAttribute = new AtscChannelAttribute();
        this.chAttribute.favorite = in.readByte();
        this.chAttribute.isHide = in.readByte();
        this.chAttribute.isLock = in.readByte();
        this.chAttribute.isRenamed = in.readByte();
        this.chAttribute.isScramble = in.readByte();
        this.chAttribute.isSkipped = in.readByte();
        this.chAttribute.scrambleChStatus = in.readByte();
        this.chAttribute.serviceType = (short) in.readByte();
        this.serviceName = in.readString();
        this.pcrPid = in.readInt();
        this.videoPID = in.readInt();
        this.pmtPID = in.readInt();
        this.virtualChNum = new AtscVirtualChannelNumber();
        this.virtualChNum.majorNumber = in.readInt();
        this.virtualChNum.minorNumber = in.readInt();
        this.audLangNum = (short) in.readInt();
        for (int i = 0; i < MAX_AUD_LANG_NUM; i++) {
            this.audInfo[i] = (AudioInfo) AudioInfo.CREATOR.createFromParcel(in);
        }
        this.programNumber = in.readInt();
        this.sourceId = in.readInt();
    }

    static {
        CREATOR = new C01851();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int arg1) {
        out.writeInt(this.id);
        out.writeInt(this.muxTableId);
        out.writeInt(this.psipVersionNum.mgtVer);
        out.writeInt(this.psipVersionNum.patVer);
        out.writeInt(this.psipVersionNum.pmtVer);
        out.writeInt(this.psipVersionNum.rrtVer);
        out.writeInt(this.psipVersionNum.vctVer);
        out.writeInt(this.chAttribute.favorite);
        out.writeInt(this.chAttribute.isHide);
        out.writeInt(this.chAttribute.isLock);
        out.writeInt(this.chAttribute.isRenamed);
        out.writeInt(this.chAttribute.isScramble);
        out.writeInt(this.chAttribute.isSkipped);
        out.writeInt(this.chAttribute.scrambleChStatus);
        out.writeInt(this.chAttribute.serviceType);
        out.writeString(this.serviceName);
        out.writeInt(this.pcrPid);
        out.writeInt(this.videoPID);
        out.writeInt(this.pmtPID);
        out.writeInt(this.virtualChNum.majorNumber);
        out.writeInt(this.virtualChNum.minorNumber);
        out.writeInt(this.audLangNum);
        for (int i = 0; i < MAX_AUD_LANG_NUM; i++) {
            this.audInfo[i].writeToParcel(out, arg1);
        }
        out.writeInt(this.programNumber);
        out.writeInt(this.sourceId);
    }
}
