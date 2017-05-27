package com.mstar.android.tvapi.common.exception;

public interface TvExceptionConstant {
    public static final String EXCEPTION_MSG_COMMON = "Exception happened ";
    public static final String EXCEPTION_MSG_IPC_FAIL = "Exception happened in ipc!! ";
    public static final String EXCEPTION_MSG_JNI_FAIL = "Exception happened in jni!! ";
    public static final String EXCEPTION_MSG_NATIVE_CALL_FAIL = "Exception happened in native call!! ";
    public static final String EXCEPTION_MSG_OUT_OF_BOUND = "Exception happened in bound";
    public static final String EXCEPTION_MSG_UNSUPPORTED = "Exception happened for unsupported!";
    public static final short EXCEPTION_TYPE_IPC_FAIL = (short) 2;
    public static final short EXCEPTION_TYPE_JNI_FAIL = (short) 3;
    public static final short EXCEPTION_TYPE_NATIVE_CALL_FAIL = (short) 1;
    public static final short EXCEPTION_TYPE_NATIVE_COMMON = (short) 0;
}
