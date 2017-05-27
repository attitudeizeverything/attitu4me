package com.mstar.android.tvapi.common.exception;

public class TvUnsupportedException extends TvCommonException {
    public TvUnsupportedException() {
        super(TvExceptionConstant.EXCEPTION_MSG_UNSUPPORTED);
    }

    public TvUnsupportedException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvUnsupportedException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }
}
