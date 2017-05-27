package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.tvapi.dtv.vo.DtvEventComponentInfo;
import com.mstar.android.tvapi.dtv.vo.EpgEventInfo;

public class PresentFollowingEventInfo implements Parcelable {
    public static final Creator<PresentFollowingEventInfo> CREATOR;
    public DtvEventComponentInfo componentInfo;
    public EpgEventInfo eventInfo;

    /* renamed from: com.mstar.android.tvapi.common.vo.PresentFollowingEventInfo.1 */
    static class C01581 implements Creator<PresentFollowingEventInfo> {
        C01581() {
        }

        public PresentFollowingEventInfo createFromParcel(Parcel in) {
            return new PresentFollowingEventInfo(in);
        }

        public PresentFollowingEventInfo[] newArray(int size) {
            return new PresentFollowingEventInfo[size];
        }
    }

    public PresentFollowingEventInfo() {
        this.componentInfo = new DtvEventComponentInfo();
        this.eventInfo = new EpgEventInfo();
    }

    public PresentFollowingEventInfo(Parcel in) {
        this.componentInfo = (DtvEventComponentInfo) DtvEventComponentInfo.CREATOR.createFromParcel(in);
        this.eventInfo = (EpgEventInfo) EpgEventInfo.CREATOR.createFromParcel(in);
    }

    static {
        CREATOR = new C01581();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        this.componentInfo.writeToParcel(dest, flags);
        this.eventInfo.writeToParcel(dest, flags);
    }
}
