package com.mstar.android.tvapi.common.exception;

public class TvIpcException extends TvCommonException {
    public TvIpcException() {
        super(TvExceptionConstant.EXCEPTION_MSG_NATIVE_CALL_FAIL);
    }

    public TvIpcException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvIpcException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }
}
