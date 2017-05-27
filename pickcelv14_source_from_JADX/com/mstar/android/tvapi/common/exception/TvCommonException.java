package com.mstar.android.tvapi.common.exception;

public class TvCommonException extends Exception implements TvExceptionConstant {
    public TvCommonException(String a_sExceptionMsg) {
        super(a_sExceptionMsg);
    }

    public TvCommonException(String a_sExceptionMsg, Exception e) {
        super(a_sExceptionMsg, e);
    }

    public String getMessage() {
        return TvExceptionConstant.EXCEPTION_MSG_COMMON;
    }
}
