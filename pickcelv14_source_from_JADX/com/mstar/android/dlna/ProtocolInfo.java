package com.mstar.android.dlna;

public class ProtocolInfo {
    private String additional_info;
    private String content_format;
    private String network;
    private String protocol;

    public ProtocolInfo(String protocol, String network, String content_format, String additional_info) {
        this.protocol = protocol;
        this.network = network;
        this.content_format = content_format;
        this.additional_info = additional_info;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getContentFormat() {
        return this.content_format;
    }

    public void setContentFormat(String content_format) {
        this.content_format = content_format;
    }

    public String getAdditionalInfo() {
        return this.additional_info;
    }

    public void setAdditionalInfo(String additional_info) {
        this.additional_info = additional_info;
    }

    public String toString() {
        return "ProtocolInfo [protocol=" + this.protocol + ", network=" + this.network + ", content_format=" + this.content_format + ", additional_info=" + this.additional_info + "]";
    }
}
