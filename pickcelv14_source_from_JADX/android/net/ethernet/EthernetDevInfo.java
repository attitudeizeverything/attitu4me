package android.net.ethernet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mstar.android.media.MMediaPlayer;
import com.squareup.okhttp.internal.http.HttpTransport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EthernetDevInfo implements Parcelable {
    public static final Creator<EthernetDevInfo> CREATOR;
    public static final String ETHERNET_CONN_MODE_DHCP = "dhcp";
    public static final String ETHERNET_CONN_MODE_MANUAL = "manual";
    private static final String TAG = "EthernetDevInfo";
    private static final boolean enLOG = false;
    private String dev_name;
    private String dns;
    private String dns2;
    private String ipaddr;
    private String mode;
    private String netmask;
    private String proxy_exclusion;
    private String proxy_host;
    private int proxy_on;
    private String proxy_port;
    private String route;

    /* renamed from: android.net.ethernet.EthernetDevInfo.1 */
    static class C00001 implements Creator<EthernetDevInfo> {
        C00001() {
        }

        public EthernetDevInfo createFromParcel(Parcel in) {
            boolean z = true;
            EthernetDevInfo info = new EthernetDevInfo();
            info.setIfName(in.readString());
            info.setIpAddress(in.readString());
            info.setNetMask(in.readString());
            info.setRouteAddr(in.readString());
            info.setDnsAddr(in.readString());
            info.setDns2Addr(in.readString());
            info.setConnectMode(in.readString());
            if (in.readInt() != 1) {
                z = false;
            }
            info.setProxyOn(z);
            info.setProxyHost(in.readString());
            info.setProxyPort(in.readString());
            info.setProxyExclusionList(in.readString());
            return info;
        }

        public EthernetDevInfo[] newArray(int size) {
            return new EthernetDevInfo[size];
        }
    }

    public EthernetDevInfo() {
        this.dev_name = null;
        this.ipaddr = null;
        this.netmask = null;
        this.route = null;
        this.dns = null;
        this.dns2 = null;
        this.mode = ETHERNET_CONN_MODE_DHCP;
        this.proxy_on = 0;
        this.proxy_host = null;
        this.proxy_port = null;
        this.proxy_exclusion = null;
    }

    public void setIfName(String ifname) {
        if (ifname != null) {
            this.dev_name = ifname;
        }
    }

    public String getIfName() {
        return this.dev_name;
    }

    public void setIpAddress(String ip) {
        if (ip != null) {
            this.ipaddr = ip;
        }
    }

    public String getIpAddress() {
        return this.ipaddr;
    }

    public void setNetMask(String mask) {
        if (mask != null) {
            this.netmask = mask;
        }
    }

    public String getNetMask() {
        return this.netmask;
    }

    public void setRouteAddr(String route) {
        if (route != null) {
            this.route = route;
        }
    }

    public String getRouteAddr() {
        return this.route;
    }

    public void setDnsAddr(String dns) {
        if (dns != null) {
            this.dns = dns;
        }
    }

    public String getDnsAddr() {
        return this.dns;
    }

    public void setDns2Addr(String dns2) {
        if (dns2 != null) {
            this.dns2 = dns2;
        }
    }

    public String getDns2Addr() {
        return this.dns2;
    }

    public boolean setConnectMode(String mode) {
        if (mode == null || (!mode.equals(ETHERNET_CONN_MODE_DHCP) && !mode.equals(ETHERNET_CONN_MODE_MANUAL))) {
            return false;
        }
        this.mode = mode;
        return true;
    }

    public String getConnectMode() {
        return this.mode;
    }

    public void setProxyOn(boolean enabled) {
        this.proxy_on = enabled ? 1 : 0;
    }

    public boolean getProxyOn() {
        return this.proxy_on == 1;
    }

    public void setProxyHost(String host) {
        if (host != null) {
            this.proxy_host = host;
        }
    }

    public String getProxyHost() {
        return this.proxy_host;
    }

    public void setProxyPort(String port) {
        if (port != null) {
            this.proxy_port = port;
        }
    }

    public String getProxyPort() {
        return this.proxy_port;
    }

    public void setProxyExclusionList(String exclusion) {
        if (exclusion != null) {
            this.proxy_exclusion = exclusion;
        }
    }

    public String getProxyExclusionList() {
        return this.proxy_exclusion;
    }

    public int describeContents() {
        return 0;
    }

    private String loadFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer(MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[HttpTransport.DEFAULT_CHUNK_LENGTH];
        while (true) {
            int numRead = reader.read(buf);
            if (numRead != -1) {
                fileData.append(String.valueOf(buf, 0, numRead));
            } else {
                reader.close();
                return fileData.toString();
            }
        }
    }

    public String getMacAddress(String ifname) {
        String str = null;
        if (ifname.equals("eth0") || ifname.equals("eth1")) {
            try {
                str = loadFileAsString("/sys/class/net/" + ifname + "/address").toUpperCase().substring(0, 17);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dev_name);
        dest.writeString(this.ipaddr);
        dest.writeString(this.netmask);
        dest.writeString(this.route);
        dest.writeString(this.dns);
        dest.writeString(this.dns2);
        dest.writeString(this.mode);
        dest.writeInt(this.proxy_on);
        dest.writeString(this.proxy_host);
        dest.writeString(this.proxy_port);
        dest.writeString(this.proxy_exclusion);
    }

    static {
        CREATOR = new C00001();
    }
}
