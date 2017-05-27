package com.mstar.android.tvapi.dtv.atsc.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AtscMainListChannelInformation implements Parcelable {
    public static final Creator<AtscMainListChannelInformation> CREATOR;
    public int id;
    public int majorNumber;
    public int minorNumber;
    public int progId;
    public short rfCh;

    /* renamed from: com.mstar.android.tvapi.dtv.atsc.vo.AtscMainListChannelInformation.1 */
    static class C01841 implements Creator<AtscMainListChannelInformation> {
        C01841() {
        }

        public AtscMainListChannelInformation createFromParcel(Parcel in) {
            return new AtscMainListChannelInformation(null);
        }

        public AtscMainListChannelInformation[] newArray(int size) {
            return new AtscMainListChannelInformation[size];
        }
    }

    private AtscMainListChannelInformation(Parcel in) {
        this.majorNumber = in.readInt();
        this.minorNumber = in.readInt();
        this.rfCh = (short) in.readInt();
        this.progId = in.readInt();
        this.id = in.readInt();
    }

    static {
        CREATOR = new C01841();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.majorNumber);
        dest.writeInt(this.minorNumber);
        dest.writeInt(this.rfCh);
        dest.writeInt(this.progId);
        dest.writeInt(this.id);
    }
}
