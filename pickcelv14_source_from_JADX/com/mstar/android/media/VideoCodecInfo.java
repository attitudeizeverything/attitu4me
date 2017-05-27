package com.mstar.android.media;

import android.media.Metadata;
import android.util.Log;

public class VideoCodecInfo {
    private static final boolean LOGD = true;
    private static final String TAG = "VideoCodecInfo";
    private int mDuration;
    private int mNumTracks;
    private String mVideoCodec;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mVideoframeRate;

    public VideoCodecInfo(Metadata metadata) {
        Log.d(TAG, "VideoCodecInfo constructure");
        if (metadata.has(27)) {
            this.mVideoCodec = metadata.getString(27);
        } else {
            this.mVideoCodec = null;
        }
        Log.d(TAG, "mVideoCodec : " + this.mVideoCodec);
        if (metadata.has(24)) {
            this.mVideoframeRate = metadata.getInt(24);
        } else {
            this.mVideoframeRate = -1;
        }
        Log.d(TAG, "mVideoframeRate : " + this.mVideoframeRate);
        if (metadata.has(29)) {
            this.mVideoWidth = metadata.getInt(29);
        } else {
            this.mVideoWidth = -1;
        }
        Log.d(TAG, "mVideoWidth : " + this.mVideoWidth);
        if (metadata.has(28)) {
            this.mVideoHeight = metadata.getInt(28);
        } else {
            this.mVideoHeight = -1;
        }
        Log.d(TAG, "mVideoHeight : " + this.mVideoHeight);
        if (metadata.has(30)) {
            this.mNumTracks = metadata.getInt(30);
        } else {
            this.mNumTracks = -1;
        }
        Log.d(TAG, "mNumTracks : " + this.mNumTracks);
        if (metadata.has(14)) {
            this.mDuration = metadata.getInt(14);
        } else {
            this.mDuration = -1;
        }
        Log.d(TAG, "mDuration : " + this.mDuration);
    }

    public VideoCodecInfo() {
        this.mVideoCodec = null;
        this.mVideoframeRate = -1;
        this.mVideoWidth = -1;
        this.mVideoHeight = -1;
        this.mNumTracks = -1;
        this.mDuration = -1;
    }

    public int getVideoframeRate() {
        if (this.mVideoframeRate == -1) {
            Log.d(TAG, "error in getVideoframeRate!");
        }
        return this.mVideoframeRate;
    }

    public int getVideoWidth() {
        if (this.mVideoWidth == -1) {
            Log.d(TAG, "error in getVideoWidth!");
        }
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        if (this.mVideoHeight == -1) {
            Log.d(TAG, "error in getVideoHeight!");
        }
        return this.mVideoHeight;
    }

    public int getNumTracks() {
        if (this.mNumTracks == -1) {
            Log.d(TAG, "error in getNumTracks!");
        }
        return this.mNumTracks;
    }

    public int getDuration() {
        if (this.mDuration == -1) {
            Log.d(TAG, "error in getDuration!");
        }
        return this.mDuration;
    }

    public void setCodecType(String codec) {
        this.mVideoCodec = codec;
    }

    public String getCodecType() {
        if (this.mVideoCodec == null) {
            Log.d(TAG, "error in getCodecType!");
        }
        return this.mVideoCodec;
    }
}
