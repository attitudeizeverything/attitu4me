package com.mstar.android.dlna;

public class MediaInfo {
    String current_uri;
    String current_uri_metadata;
    String media_duration;
    String next_uri;
    String next_uri_metadata;
    int nr_tracks;
    String play_medium;
    String record_medium;
    String write_status;

    public MediaInfo(int nr_tracks, String media_duration, String current_uri, String current_uri_metadata, String next_uri, String next_uri_metadata, String play_medium, String record_medium, String write_status) {
        this.nr_tracks = nr_tracks;
        this.media_duration = media_duration;
        this.current_uri = current_uri;
        this.current_uri_metadata = current_uri_metadata;
        this.next_uri = next_uri;
        this.next_uri_metadata = next_uri_metadata;
        this.play_medium = play_medium;
        this.record_medium = record_medium;
        this.write_status = write_status;
    }

    public int getNRTracks() {
        return this.nr_tracks;
    }

    public void setNRTracks(int nr_tracks) {
        this.nr_tracks = nr_tracks;
    }

    public String getMediaDuration() {
        return this.media_duration;
    }

    public void setMediaDuration(String media_duration) {
        this.media_duration = media_duration;
    }

    public String getCurrentURI() {
        return this.current_uri;
    }

    public void setCurrentURI(String current_uri) {
        this.current_uri = current_uri;
    }

    public String getCurrentURIMetadata() {
        return this.current_uri_metadata;
    }

    public void setCurrentURIMetadata(String current_uri_metadata) {
        this.current_uri_metadata = current_uri_metadata;
    }

    public String getNextURI() {
        return this.next_uri;
    }

    public void setNextURI(String next_uri) {
        this.next_uri = next_uri;
    }

    public String getNextURIMetadata() {
        return this.next_uri_metadata;
    }

    public void setNextURIMetadata(String next_uri_metadata) {
        this.next_uri_metadata = next_uri_metadata;
    }

    public String getPlayMedium() {
        return this.play_medium;
    }

    public void setPlayMedium(String play_medium) {
        this.play_medium = play_medium;
    }

    public String getRecordMedium() {
        return this.record_medium;
    }

    public void setRecordMedium(String record_medium) {
        this.record_medium = record_medium;
    }

    public String getWritestatus() {
        return this.write_status;
    }

    public void setWritestatus(String write_status) {
        this.write_status = write_status;
    }
}
