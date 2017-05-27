package com.mstar.android.tvapi.dtv.dvb.isdb.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GingaInfo implements Parcelable {
    public static final Creator<GingaInfo> CREATOR;
    public int aid;
    public int flag;
    public String name;
    public int oid;
    public int type;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.isdb.vo.GingaInfo.1 */
    static class C02001 implements Creator<GingaInfo> {
        C02001() {
        }

        public GingaInfo createFromParcel(Parcel in) {
            return new GingaInfo(in);
        }

        public GingaInfo[] newArray(int size) {
            return new GingaInfo[size];
        }
    }

    public GingaInfo(int a, int o, String n, int t, int f) {
        this.aid = a;
        this.oid = o;
        this.name = n;
        this.type = t;
        this.flag = f;
    }

    public GingaInfo(Parcel in) {
        this.aid = in.readInt();
        this.oid = in.readInt();
        this.name = in.readString();
        this.type = in.readInt();
        this.flag = in.readInt();
    }

    static {
        CREATOR = new C02001();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.aid);
        dest.writeInt(this.oid);
        dest.writeString(this.name);
        dest.writeInt(this.type);
        dest.writeInt(this.flag);
    }
}
