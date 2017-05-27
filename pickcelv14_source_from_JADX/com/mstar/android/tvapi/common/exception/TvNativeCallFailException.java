package com.mstar.android.tvapi.common.exception;

public class TvNativeCallFailException extends TvCommonException {
    public TvNativeCallFailException() {
        super(TvExceptionConstant.EXCEPTION_MSG_NATIVE_CALL_FAIL);
    }

    public TvNativeCallFailException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvNativeCallFailException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }
}
