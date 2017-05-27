package com.mstar.android.tvapi.dtv.dvb.dvbs.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR;
    private short latitude;
    private String locationName;
    private short longitude;

    /* renamed from: com.mstar.android.tvapi.dtv.dvb.dvbs.vo.LocationInfo.1 */
    static class C01961 implements Creator<LocationInfo> {
        C01961() {
        }

        public LocationInfo createFromParcel(Parcel in) {
            return new LocationInfo(null);
        }

        public LocationInfo[] newArray(int size) {
            return new LocationInfo[size];
        }
    }

    public LocationInfo() {
        this.locationName = "";
        this.longitude = (short) 0;
        this.latitude = (short) 0;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public short getLongitude() {
        return this.longitude;
    }

    public short getLatitude() {
        return this.latitude;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLongitude(short longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(short latitude) {
        this.latitude = latitude;
    }

    public int describeContents() {
        return 0;
    }

    private LocationInfo(Parcel in) {
        this.locationName = in.readString();
        this.longitude = (short) in.readInt();
        this.latitude = (short) in.readInt();
    }

    static {
        CREATOR = new C01961();
    }

    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(this.locationName);
        arg0.writeInt(this.longitude);
        arg0.writeInt(this.latitude);
    }
}
