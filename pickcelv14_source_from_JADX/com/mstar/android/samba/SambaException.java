package com.mstar.android.samba;

import jcifs.smb.SmbException;

public class SambaException extends Exception {
    public static final int ERR_NULLPOINTER = 2;
    public static final int ERR_UNSUPPORTTYPE = 3;
    public static final int SMBERR_UNKNOWN = 1;
    private static final long serialVersionUID = 1;
    int errcode;

    SambaException(SmbException e) {
        this.errcode = e.getNtStatus();
        setStackTrace(e.getStackTrace());
    }

    SambaException(int errcode) {
        this.errcode = errcode;
    }

    public int getErr() {
        return this.errcode;
    }
}
