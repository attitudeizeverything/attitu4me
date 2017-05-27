package com.mstar.android.media;

import android.media.Metadata;

public class DivxResumeInfo {
    private static final boolean LOGD = false;
    private static final String TAG = "DivxResumeInfo";
    private String mSName;
    private String mSPath;
    private int mU32PTS;
    private long mU64FilePos;
    private int mU8Edition;
    private int mU8ResumeMKV;
    private int mU8Title;

    public DivxResumeInfo(Metadata metadata) {
        this.mU64FilePos = metadata.getLong(41);
        this.mU32PTS = metadata.getInt(42);
        this.mU8ResumeMKV = metadata.getInt(43);
        this.mU8Title = metadata.getInt(44);
        this.mU8Edition = metadata.getInt(45);
    }

    public void setFilePos(long filePos) {
        this.mU64FilePos = filePos;
    }

    public long getFilePos() {
        return this.mU64FilePos;
    }

    public void setPTS(int pts) {
        this.mU32PTS = pts;
    }

    public int getPTS() {
        return this.mU32PTS;
    }

    public void setResumeMKV(int mkv) {
        this.mU8ResumeMKV = mkv;
    }

    public int getResumeMKV() {
        return this.mU8ResumeMKV;
    }

    public void setTitle(int title) {
        this.mU8Title = title;
    }

    public int getTitle() {
        return this.mU8Title;
    }

    public void setEdition(int edition) {
        this.mU8Edition = edition;
    }

    public int getEdition() {
        return this.mU8Edition;
    }

    public void setPath(String path) {
        this.mSPath = path;
    }

    public String getPath() {
        return this.mSPath;
    }

    public void setName(String name) {
        this.mSName = name;
    }

    public String getName() {
        return this.mSName;
    }
}
