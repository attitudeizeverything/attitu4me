package com.mstar.android.dlna;

public class TransportInfo {
    String current_speed;
    TransportState current_transport_state;
    TransportStatus current_transport_status;

    public TransportInfo(TransportState current_transport_state, TransportStatus current_transport_status, String current_speed) {
        this.current_transport_state = current_transport_state;
        this.current_transport_status = current_transport_status;
        this.current_speed = current_speed;
    }

    public TransportState getCurrentTransportState() {
        return this.current_transport_state;
    }

    public void setCurrentTransportState(TransportState current_transport_state) {
        this.current_transport_state = current_transport_state;
    }

    public TransportStatus getCurrentTransportStatus() {
        return this.current_transport_status;
    }

    public void setCurrentTransportStatus(TransportStatus current_transport_status) {
        this.current_transport_status = current_transport_status;
    }

    public String getCurrentSpeed() {
        return this.current_speed;
    }

    public void setCurrentSpeed(String current_speed) {
        this.current_speed = current_speed;
    }
}
