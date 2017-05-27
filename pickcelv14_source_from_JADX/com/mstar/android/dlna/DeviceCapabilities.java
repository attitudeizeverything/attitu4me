package com.mstar.android.dlna;

public class DeviceCapabilities {
    private String play_media;
    private String rec_media;
    private String rec_quality_modes;

    public DeviceCapabilities(String play_media, String rec_media, String rec_quality_modes) {
        this.play_media = play_media;
        this.rec_media = rec_media;
        this.rec_quality_modes = rec_quality_modes;
    }

    public String getPlayMedia() {
        return this.play_media;
    }

    public void setPlayMedia(String play_media) {
        this.play_media = play_media;
    }

    public String getRecMedia() {
        return this.rec_media;
    }

    public void setRecMedia(String rec_media) {
        this.rec_media = rec_media;
    }

    public String getRecQualityModes() {
        return this.rec_quality_modes;
    }

    public void setRecQualityModes(String rec_quality_modes) {
        this.rec_quality_modes = rec_quality_modes;
    }
}
