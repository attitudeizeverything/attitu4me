package com.mstar.android.dlna;

public class DLNAFactory {
    private static DLNA instance;

    public static synchronized DLNA CreateInstance() {
        DLNA dlna;
        synchronized (DLNAFactory.class) {
            if (instance == null) {
                instance = new DLNAImpl();
            }
            dlna = instance;
        }
        return dlna;
    }
}
