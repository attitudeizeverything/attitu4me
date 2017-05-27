package com.mstar.android.storage;

public abstract class OnISOEvnetListener {
    public static final int MOUNTED = 1;
    public static final int UNMOUNTED = 2;

    public void onISOStateChange(String path, int state) {
    }
}
