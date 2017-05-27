package com.mstar.android.dlna;

public class VolumeInfo {
    private Channel channel;
    private int current_volume;

    public VolumeInfo(Channel channel, int current_volume) {
        this.channel = channel;
        this.current_volume = current_volume;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public int getCurrentVolume() {
        return this.current_volume;
    }

    public void setCurrentVolume(int current_volume) {
        this.current_volume = current_volume;
    }

    public String toString() {
        return "VolumeInfo [ channel=" + this.channel.toString() + " current_volume " + this.current_volume + "]";
    }
}
