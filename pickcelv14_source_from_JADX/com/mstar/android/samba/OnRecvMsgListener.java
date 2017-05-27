package com.mstar.android.samba;

public interface OnRecvMsgListener {
    public static final int MSG_UPDATE_DEVLIST_ADD = 3;
    public static final int MSG_UPDATE_DEVLIST_CANCEL = 1;
    public static final int MSG_UPDATE_DEVLIST_DONE = 2;

    void onRecvMsgListener(int i);
}
