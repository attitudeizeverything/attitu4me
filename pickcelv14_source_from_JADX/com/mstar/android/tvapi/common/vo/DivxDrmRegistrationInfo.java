package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DivxDrmRegistrationInfo implements Parcelable {
    public static final Creator<DivxDrmRegistrationInfo> CREATOR;
    public short clearLastMemory;
    public char[] deActivationCode;
    public short[] drmData;
    public short isActivated;
    public short isDeactivated;
    public short isKeyGenerated;
    public char[] registrationCode;

    /* renamed from: com.mstar.android.tvapi.common.vo.DivxDrmRegistrationInfo.1 */
    static class C01311 implements Creator<DivxDrmRegistrationInfo> {
        C01311() {
        }

        public DivxDrmRegistrationInfo createFromParcel(Parcel in) {
            return new DivxDrmRegistrationInfo(in);
        }

        public DivxDrmRegistrationInfo[] newArray(int size) {
            return new DivxDrmRegistrationInfo[size];
        }
    }

    public DivxDrmRegistrationInfo() {
        int i;
        this.registrationCode = new char[11];
        this.deActivationCode = new char[9];
        this.drmData = new short[48];
        this.isKeyGenerated = (short) 0;
        this.isActivated = (short) 0;
        this.isDeactivated = (short) 0;
        this.clearLastMemory = (short) 0;
        for (i = 0; i < 11; i++) {
            this.registrationCode[i] = '\u0000';
        }
        for (i = 0; i < 9; i++) {
            this.deActivationCode[i] = '\u0000';
        }
        for (i = 0; i < 48; i++) {
            this.drmData[i] = (short) 0;
        }
    }

    public DivxDrmRegistrationInfo(Parcel in) {
        this.registrationCode = new char[11];
        this.deActivationCode = new char[9];
        this.drmData = new short[48];
        this.isKeyGenerated = (short) in.readInt();
        this.isActivated = (short) in.readInt();
        this.isDeactivated = (short) in.readInt();
        this.clearLastMemory = (short) in.readInt();
        in.readCharArray(this.registrationCode);
        in.readCharArray(this.deActivationCode);
        for (int i = 0; i < 48; i++) {
            this.drmData[i] = (short) in.readInt();
        }
    }

    static {
        CREATOR = new C01311();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeCharArray(this.registrationCode);
        dest.writeCharArray(this.deActivationCode);
        for (int i = 0; i < 48; i++) {
            dest.writeInt(this.drmData[i]);
        }
        dest.writeInt(this.isKeyGenerated);
        dest.writeInt(this.isActivated);
        dest.writeInt(this.isDeactivated);
        dest.writeInt(this.clearLastMemory);
    }
}
