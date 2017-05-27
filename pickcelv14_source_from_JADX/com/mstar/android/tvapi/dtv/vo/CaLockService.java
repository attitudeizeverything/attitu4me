package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CaLockService implements Parcelable {
    public static final Creator<CaLockService> CREATOR;
    public CaComponent[] m_CompArr;
    public short m_ComponentNum;
    public short m_Modulation;
    public int m_dwFrequency;
    public short m_fec_inner;
    public short m_fec_outer;
    public int m_symbol_rate;
    public short m_wPcrPid;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.CaLockService.1 */
    static class C02101 implements Creator<CaLockService> {
        C02101() {
        }

        public CaLockService createFromParcel(Parcel in) {
            return new CaLockService(null);
        }

        public CaLockService[] newArray(int size) {
            return new CaLockService[size];
        }
    }

    public CaLockService() {
        this.m_CompArr = new CaComponent[5];
        this.m_dwFrequency = 0;
        this.m_symbol_rate = 0;
        this.m_wPcrPid = (short) 0;
        this.m_Modulation = (short) 0;
        this.m_ComponentNum = (short) 0;
        for (int i = 0; i < 5; i++) {
            this.m_CompArr[i] = new CaComponent();
        }
    }

    private CaLockService(Parcel in) {
        this.m_CompArr = new CaComponent[5];
        this.m_dwFrequency = in.readInt();
        this.m_symbol_rate = in.readInt();
        this.m_wPcrPid = (short) in.readInt();
        this.m_Modulation = (short) in.readInt();
        this.m_ComponentNum = (short) in.readInt();
        for (int i = 0; i < 5; i++) {
            this.m_CompArr[i] = (CaComponent) CaComponent.CREATOR.createFromParcel(in);
        }
    }

    static {
        CREATOR = new C02101();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.m_dwFrequency);
        arg0.writeInt(this.m_symbol_rate);
        arg0.writeInt(this.m_wPcrPid);
        arg0.writeInt(this.m_Modulation);
        arg0.writeInt(this.m_ComponentNum);
        for (int i = 0; i < 5; i++) {
            this.m_CompArr[i].writeToParcel(arg0, arg1);
        }
    }
}
