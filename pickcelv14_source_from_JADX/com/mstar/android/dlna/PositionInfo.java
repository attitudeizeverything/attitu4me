package com.mstar.android.dlna;

public class PositionInfo {
    private int abs_count;
    private String abs_time;
    private int rel_count;
    private String rel_time;
    private int track;
    private String track_duration;
    private String track_metadata;
    private String track_uri;

    public PositionInfo(int track, String track_duration, String track_metadata, String track_uri, String rel_time, String abs_time, int rel_count, int abs_count) {
        this.track = track;
        this.track_duration = track_duration;
        this.track_metadata = track_metadata;
        this.track_uri = track_uri;
        this.rel_time = rel_time;
        this.abs_time = abs_time;
        this.rel_count = rel_count;
        this.abs_count = abs_count;
    }

    public int getTrack() {
        return this.track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getTrackDuration() {
        return this.track_duration;
    }

    public void setTrackDuration(String track_duration) {
        this.track_duration = track_duration;
    }

    public String getTrackMetadata() {
        return this.track_metadata;
    }

    public void setTrackMetadata(String track_metadata) {
        this.track_metadata = track_metadata;
    }

    public String getTrackURI() {
        return this.track_uri;
    }

    public void setTrackURI(String track_uri) {
        this.track_uri = track_uri;
    }

    public String getRelTime() {
        return this.rel_time;
    }

    public void setRelTime(String rel_time) {
        this.rel_time = rel_time;
    }

    public String getAbsTime() {
        return this.abs_time;
    }

    public void setAbsTime(String abs_time) {
        this.abs_time = abs_time;
    }

    public int getRelCount() {
        return this.rel_count;
    }

    public void setRelCount(int rel_count) {
        this.rel_count = rel_count;
    }

    public int getAbsCount() {
        return this.abs_count;
    }

    public void setAbsCount(int abs_count) {
        this.abs_count = abs_count;
    }
}
