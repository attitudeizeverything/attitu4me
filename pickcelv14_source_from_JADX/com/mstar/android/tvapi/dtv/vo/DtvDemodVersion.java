package com.mstar.android.tvapi.dtv.vo;

public class DtvDemodVersion {
    public char[] build;
    public char[] changelist;
    public char[] name;
    public char[] version;

    public DtvDemodVersion() {
        this.name = new char[4];
        this.version = new char[2];
        this.build = new char[2];
        this.changelist = new char[8];
    }
}
