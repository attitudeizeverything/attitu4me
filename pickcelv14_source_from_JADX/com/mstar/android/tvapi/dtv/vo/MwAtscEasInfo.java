package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import jcifs.smb.SmbNamedPipe;

public class MwAtscEasInfo implements Parcelable {
    public static final Creator<MwAtscEasInfo> CREATOR;
    public MapiPsipEasException[] astException;
    public MapiPsipEasLocationCode[] astLocationCode;
    public short[] au8AlertText;
    public short[] au8EAS_EventCode;
    public int[] au8EAS_OriginatorCode;
    public short[] au8NatActText;
    public int u16DetailsMajorNum;
    public int u16DetailsMinorNum;
    public int u16EAS_EventID;
    public int u16EventDuration;
    public int u32EventStartTime;
    public int u8AlertPriority;
    public int u8AlertTimeRemain;
    public int u8ExceptionCount;
    public int u8LocationCodeCount;
    public int u8VerNum;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.MwAtscEasInfo.1 */
    static class C02301 implements Creator<MwAtscEasInfo> {
        C02301() {
        }

        public MwAtscEasInfo createFromParcel(Parcel in) {
            return new MwAtscEasInfo(in);
        }

        public MwAtscEasInfo[] newArray(int size) {
            return new MwAtscEasInfo[size];
        }
    }

    public MwAtscEasInfo() {
        int i;
        this.astException = new MapiPsipEasException[31];
        this.astLocationCode = new MapiPsipEasLocationCode[31];
        this.au8EAS_OriginatorCode = new int[3];
        this.au8EAS_EventCode = new short[5];
        this.au8NatActText = new short[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.au8AlertText = new short[SmbNamedPipe.PIPE_TYPE_TRANSACT];
        for (i = 0; i < 31; i++) {
            this.astException[i] = new MapiPsipEasException();
        }
        for (i = 0; i < 31; i++) {
            this.astLocationCode[i] = new MapiPsipEasLocationCode();
        }
        this.u8VerNum = 0;
        this.u16EAS_EventID = 0;
        for (i = 0; i < this.au8EAS_OriginatorCode.length; i++) {
            this.au8EAS_OriginatorCode[i] = 0;
        }
        this.u8AlertTimeRemain = 0;
        this.u32EventStartTime = 0;
        this.u16EventDuration = 0;
        this.u8AlertPriority = 0;
        this.u16DetailsMajorNum = 0;
        this.u16DetailsMinorNum = 0;
        this.u8LocationCodeCount = 0;
        this.u8ExceptionCount = 0;
        for (i = 0; i < this.au8EAS_EventCode.length; i++) {
            this.au8EAS_EventCode[i] = (short) 0;
        }
        for (i = 0; i < this.au8NatActText.length; i++) {
            this.au8NatActText[i] = (short) 0;
        }
        for (i = 0; i < this.au8AlertText.length; i++) {
            this.au8AlertText[i] = (short) 0;
        }
    }

    public MwAtscEasInfo(Parcel in) {
        int i;
        this.astException = new MapiPsipEasException[31];
        this.astLocationCode = new MapiPsipEasLocationCode[31];
        this.au8EAS_OriginatorCode = new int[3];
        this.au8EAS_EventCode = new short[5];
        this.au8NatActText = new short[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.au8AlertText = new short[SmbNamedPipe.PIPE_TYPE_TRANSACT];
        for (i = 0; i < 31; i++) {
            this.astException[i] = (MapiPsipEasException) MapiPsipEasException.CREATOR.createFromParcel(in);
        }
        for (i = 0; i < 31; i++) {
            this.astLocationCode[i] = (MapiPsipEasLocationCode) MapiPsipEasLocationCode.CREATOR.createFromParcel(in);
        }
        this.u8VerNum = in.readInt();
        this.u16EAS_EventID = in.readInt();
        for (i = 0; i < this.au8EAS_OriginatorCode.length; i++) {
            this.au8EAS_OriginatorCode[i] = (short) in.readInt();
        }
        this.u8AlertTimeRemain = in.readInt();
        this.u32EventStartTime = in.readInt();
        this.u16EventDuration = in.readInt();
        this.u8AlertPriority = in.readInt();
        this.u16DetailsMajorNum = in.readInt();
        this.u16DetailsMinorNum = in.readInt();
        this.u8LocationCodeCount = in.readInt();
        this.u8ExceptionCount = in.readInt();
        for (i = 0; i < this.au8EAS_EventCode.length; i++) {
            this.au8EAS_EventCode[i] = (short) in.readInt();
        }
        for (i = 0; i < this.au8NatActText.length; i++) {
            this.au8NatActText[i] = (short) in.readInt();
        }
        for (i = 0; i < this.au8AlertText.length; i++) {
            this.au8AlertText[i] = (short) in.readInt();
        }
    }

    static {
        CREATOR = new C02301();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        for (i = 0; i < 31; i++) {
            this.astException[i].writeToParcel(dest, 0);
        }
        for (i = 0; i < 31; i++) {
            this.astLocationCode[i].writeToParcel(dest, 0);
        }
        dest.writeInt(this.u8VerNum);
        dest.writeInt(this.u16EAS_EventID);
        for (int writeInt : this.au8EAS_OriginatorCode) {
            dest.writeInt(writeInt);
        }
        dest.writeInt(this.u8AlertTimeRemain);
        dest.writeInt(this.u32EventStartTime);
        dest.writeInt(this.u16EventDuration);
        dest.writeInt(this.u8AlertPriority);
        dest.writeInt(this.u16DetailsMajorNum);
        dest.writeInt(this.u16DetailsMinorNum);
        dest.writeInt(this.u8LocationCodeCount);
        dest.writeInt(this.u8ExceptionCount);
        for (short writeInt2 : this.au8EAS_EventCode) {
            dest.writeInt(writeInt2);
        }
        for (short writeInt22 : this.au8NatActText) {
            dest.writeInt(writeInt22);
        }
        for (short writeInt222 : this.au8AlertText) {
            dest.writeInt(writeInt222);
        }
    }
}
