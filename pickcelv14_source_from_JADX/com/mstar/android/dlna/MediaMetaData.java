package com.mstar.android.dlna;

public class MediaMetaData {
    int bitrate;
    int bits_persample;
    int color_depth;
    long duration;
    String mime_type;
    int nr_audio_channels;
    String resolution;
    int sample_frequency;
    long size;

    public MediaMetaData(long size, long duration, int bitrate, int sample_frequency, int bits_persample, int nrAudioChannels, String resolution, int color_depth, String mime_type) {
        this.size = size;
        this.duration = duration;
        this.bitrate = bitrate;
        this.sample_frequency = sample_frequency;
        this.bits_persample = bits_persample;
        this.nr_audio_channels = nrAudioChannels;
        this.resolution = resolution;
        this.color_depth = color_depth;
        this.mime_type = mime_type;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getMIMEType() {
        return this.mime_type;
    }

    public void setMIMEType(String mime_type) {
        this.mime_type = mime_type;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getSampleFrequency() {
        return this.sample_frequency;
    }

    public void setSampleFrequency(int sample_frequency) {
        this.sample_frequency = sample_frequency;
    }

    public int getBitsPersample() {
        return this.bits_persample;
    }

    public void setBitsPersample(int bits_persample) {
        this.bits_persample = bits_persample;
    }

    public int getNrAudioChannels() {
        return this.nr_audio_channels;
    }

    public void setNrAudioChannels(int nrAudioChannels) {
        this.nr_audio_channels = nrAudioChannels;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getColorDepth() {
        return this.color_depth;
    }

    public void setColorDepth(int color_depth) {
        this.color_depth = color_depth;
    }
}
