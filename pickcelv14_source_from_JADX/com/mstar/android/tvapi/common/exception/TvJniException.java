package com.mstar.android.tvapi.common.exception;

public class TvJniException extends TvCommonException {
    public TvJniException() {
        super(TvExceptionConstant.EXCEPTION_MSG_NATIVE_CALL_FAIL);
    }

    public TvJniException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvJniException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }
}
