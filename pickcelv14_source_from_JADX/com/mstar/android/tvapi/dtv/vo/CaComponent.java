package com.mstar.android.tvapi.dtv.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CaComponent implements Parcelable {
    public static final Creator<CaComponent> CREATOR;
    public short m_CompType;
    public short m_wCompPID;
    public short m_wECMPID;

    /* renamed from: com.mstar.android.tvapi.dtv.vo.CaComponent.1 */
    static class C02081 implements Creator<CaComponent> {
        C02081() {
        }

        public CaComponent createFromParcel(Parcel in) {
            return new CaComponent(null);
        }

        public CaComponent[] newArray(int size) {
            return new CaComponent[size];
        }
    }

    public CaComponent() {
        this.m_wCompPID = (short) 0;
        this.m_wECMPID = (short) 0;
        this.m_CompType = (short) 0;
    }

    private CaComponent(Parcel in) {
        this.m_wCompPID = (short) in.readInt();
        this.m_wECMPID = (short) in.readInt();
        this.m_CompType = (short) in.readInt();
    }

    static {
        CREATOR = new C02081();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeInt(this.m_wCompPID);
        arg0.writeInt(this.m_wECMPID);
        arg0.writeInt(this.m_CompType);
    }
}
