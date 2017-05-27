package com.mstar.android.tvapi.common.exception;

public class TvOutOfBoundException extends TvCommonException {
    public TvOutOfBoundException() {
        super(TvExceptionConstant.EXCEPTION_MSG_OUT_OF_BOUND);
    }

    public TvOutOfBoundException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvOutOfBoundException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }
}
