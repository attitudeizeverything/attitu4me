package com.mstar.android.dlna;

public class ShareResource {
    private ProtocolInfo protocol_info;
    private long size;
    private String uri;

    public String getURI() {
        return this.uri;
    }

    public void setURI(String uri) {
        this.uri = uri;
    }

    public ProtocolInfo getProtocolInfo() {
        return this.protocol_info;
    }

    public void setProtocolInfo(ProtocolInfo protocol_info) {
        this.protocol_info = protocol_info;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
