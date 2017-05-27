package com.mstar.android.tvapi.common.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;

public class NetworkSetting implements Parcelable {
    public static final Creator<NetworkSetting> CREATOR;
    public boolean bnetSelected;
    public short dns0;
    public short dns1;
    public short dns2;
    public short dns3;
    public short gateway0;
    public short gateway1;
    public short gateway2;
    public short gateway3;
    public char[] ip;
    public short ipAddr0;
    public short ipAddr1;
    public short ipAddr2;
    public short ipAddr3;
    public char[] ipName;
    public short netMask0;
    public short netMask1;
    public short netMask2;
    public short netMask3;
    public char[] netPassword;
    public char[] netUserName;
    public EnumNetConfigurationType netconfig;

    /* renamed from: com.mstar.android.tvapi.common.vo.NetworkSetting.1 */
    static class C01501 implements Creator<NetworkSetting> {
        C01501() {
        }

        public NetworkSetting createFromParcel(Parcel in) {
            return new NetworkSetting(in);
        }

        public NetworkSetting[] newArray(int size) {
            return new NetworkSetting[size];
        }
    }

    public NetworkSetting() {
        int i;
        this.ip = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.ipName = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.netUserName = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.netPassword = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.bnetSelected = false;
        this.netconfig = EnumNetConfigurationType.E_DHCP;
        this.ipAddr0 = (short) 0;
        this.ipAddr1 = (short) 0;
        this.ipAddr2 = (short) 0;
        this.ipAddr3 = (short) 0;
        this.netMask0 = (short) 0;
        this.netMask1 = (short) 0;
        this.netMask2 = (short) 0;
        this.netMask3 = (short) 0;
        this.gateway0 = (short) 0;
        this.gateway1 = (short) 0;
        this.gateway2 = (short) 0;
        this.gateway3 = (short) 0;
        this.dns0 = (short) 0;
        this.dns1 = (short) 0;
        this.dns2 = (short) 0;
        this.dns3 = (short) 0;
        for (i = 0; i < TransportMediator.FLAG_KEY_MEDIA_NEXT; i++) {
            this.ip[i] = '\u0000';
        }
        for (i = 0; i < TransportMediator.FLAG_KEY_MEDIA_NEXT; i++) {
            this.ipName[i] = '\u0000';
        }
        for (i = 0; i < TransportMediator.FLAG_KEY_MEDIA_NEXT; i++) {
            this.netUserName[i] = '\u0000';
        }
        for (i = 0; i < TransportMediator.FLAG_KEY_MEDIA_NEXT; i++) {
            this.netPassword[i] = '\u0000';
        }
    }

    public NetworkSetting(Parcel in) {
        boolean z = true;
        this.ip = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.ipName = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.netUserName = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        this.netPassword = new char[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        if (in.readInt() != 1) {
            z = false;
        }
        this.bnetSelected = z;
        this.netconfig = EnumNetConfigurationType.values()[in.readInt()];
        this.ipAddr0 = (short) in.readInt();
        this.ipAddr1 = (short) in.readInt();
        this.ipAddr2 = (short) in.readInt();
        this.ipAddr3 = (short) in.readInt();
        this.netMask0 = (short) in.readInt();
        this.netMask1 = (short) in.readInt();
        this.netMask2 = (short) in.readInt();
        this.netMask3 = (short) in.readInt();
        this.gateway0 = (short) in.readInt();
        this.gateway1 = (short) in.readInt();
        this.gateway2 = (short) in.readInt();
        this.gateway3 = (short) in.readInt();
        this.dns0 = (short) in.readInt();
        this.dns1 = (short) in.readInt();
        this.dns2 = (short) in.readInt();
        this.dns3 = (short) in.readInt();
        in.readCharArray(this.ip);
        in.readCharArray(this.ipName);
        in.readCharArray(this.netUserName);
        in.readCharArray(this.netPassword);
    }

    static {
        CREATOR = new C01501();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bnetSelected ? 1 : 0);
        dest.writeInt(this.netconfig.ordinal());
        dest.writeInt(this.ipAddr0);
        dest.writeInt(this.ipAddr1);
        dest.writeInt(this.ipAddr2);
        dest.writeInt(this.ipAddr3);
        dest.writeInt(this.netMask0);
        dest.writeInt(this.netMask1);
        dest.writeInt(this.netMask2);
        dest.writeInt(this.netMask3);
        dest.writeInt(this.gateway0);
        dest.writeInt(this.gateway1);
        dest.writeInt(this.gateway2);
        dest.writeInt(this.gateway3);
        dest.writeInt(this.dns0);
        dest.writeInt(this.dns1);
        dest.writeInt(this.dns2);
        dest.writeInt(this.dns3);
        dest.writeCharArray(this.ip);
        dest.writeCharArray(this.ipName);
        dest.writeCharArray(this.netUserName);
        dest.writeCharArray(this.netPassword);
    }
}
