package com.mstar.android.widi;

import android.util.Log;
import com.android.internal.util.StateMachine;
import com.mstar.android.media.MMediaPlayer;

public class WidiMonitor {
    private static final int BACK_TO_READY_STATE_TIME = 1500;
    public static final int BASE_WIDI_MONITOR = 10;
    private static final int MAX_RECV_ERRORS = 10;
    private static final String MONITOR_SOCKET_CLOSED_STR = "connection closed";
    private static final String TAG = "WidiMonitor";
    public static final int WIDI_AUTHENTICATE_FAIL_EVENT = 22;
    private static final String WIDI_AUTHENTICATE_FAIL_STR = "WIDI_AUTHENTICATE_FAIL";
    public static final int WIDI_BACK_TO_READY_EVENT = 24;
    public static final int WIDI_BINDED_FAIL_EVENT = 20;
    public static final int WIDI_BINDED_SUCCESS_EVENT = 18;
    private static final String WIDI_CONNECTED_STR = "WIDI_CONNECTED";
    public static final int WIDI_CONNECTING_EVENT = 25;
    private static final String WIDI_CONNECTING_STR = "WIDI_CONNECTING";
    public static final int WIDI_CONNECTION_EVENT = 12;
    public static final int WIDI_CONNECTION_FAIL_EVENT = 21;
    private static final String WIDI_CONNECTION_FAIL_STR = "WIDI_CONNECTION_FAIL";
    public static final int WIDI_DHCP_FAIL_EVENT = 23;
    private static final String WIDI_DHCP_FAIL_STR = "WIDI_DHCP_FAIL";
    private static final String WIDI_DISCONNECTED_STR = "WIDI_DISCONNECTED";
    public static final int WIDI_DISCONNECTION_EVENT = 13;
    private static final String WIDI_NOT_SIGNAL = "signal 0 received";
    private static final String WIDI_RECV_ERROR_STR = "recv error";
    public static final int WIDI_SHOW_PINCODE_EVENT = 14;
    private static final String WIDI_SHOW_PINCODE_STR = "WIDI_PINCODE-";
    public static final int WIDI_SHOW_SCREEN_EVENT = 11;
    private static final String WIDI_SHOW_SCREEN_STR = "WIDI_SHOW_SCREEN";
    public static final int WIDI_START_FAIL_EVENT = 16;
    private static final String WIDI_START_FAIL_STR = "WIDI_START_FAIL";
    public static final int WIDI_START_SUCCESS_EVENT = 17;
    private static final String WIDI_START_SUCCESS_STR = "WIDI_START_SUCCESS";
    private static final String WIDI_STOP_FAIL_STR = "WIDI_STOP_FAIL";
    public static final int WIDI_STOP_SUCCESS_EVENT = 15;
    private static final String WIDI_STOP_SUCCESS_STR = "WIDI_STOP_SUCCESS";
    private static final String WIDI_TERMINATING_STR = "WIDI_TERMINATING";
    private int mRecvErrors;
    private final WidiNative mWidiNative;
    private final StateMachine mWidiStateMachine;

    class MonitorThread extends Thread {
        public MonitorThread() {
            super(WidiMonitor.TAG);
        }

        public void run() {
            if (WidiMonitor.this.connectToWidi()) {
                WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_BINDED_SUCCESS_EVENT);
                Log.d(WidiMonitor.TAG, "connectToWidi success");
                WidiMonitor.this.mWidiNative;
                if (WidiNative.sendWidiCmd("WIDI_START") != 0) {
                    WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_START_FAIL_EVENT);
                    WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_BINDED_FAIL_EVENT, 3000);
                }
                while (true) {
                    WidiMonitor.this.mWidiNative;
                    String eventStr = WidiNative.waitForWidiEvent();
                    if (eventStr != null) {
                        Log.d(WidiMonitor.TAG, "EventStr = [" + eventStr + "]");
                        String eventData;
                        int ind;
                        if (eventStr.startsWith(WidiMonitor.WIDI_SHOW_PINCODE_STR)) {
                            eventData = eventStr;
                            ind = eventData.indexOf("-");
                            if (ind != -1) {
                                eventData = eventStr.substring(ind + 1);
                            }
                            Log.d(WidiMonitor.TAG, "pincode = [" + eventData + "]");
                            WidiMonitor.this.mWidiStateMachine.obtainMessage(WidiMonitor.WIDI_SHOW_PINCODE_EVENT, eventData).sendToTarget();
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_SHOW_SCREEN_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_SHOW_SCREEN_EVENT, 3000);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_CONNECTING_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_CONNECTING_EVENT);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_CONNECTED_STR)) {
                            eventData = eventStr;
                            ind = eventData.indexOf("-");
                            if (ind != -1) {
                                eventData = eventStr.substring(ind + 1);
                            }
                            Log.d(WidiMonitor.TAG, "interface = " + eventData);
                            WidiMonitor.this.mWidiStateMachine.obtainMessage(WidiMonitor.WIDI_CONNECTION_EVENT, eventData).sendToTarget();
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_DISCONNECTED_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_DISCONNECTION_EVENT);
                            WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_BACK_TO_READY_EVENT, 0);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_TERMINATING_STR)) {
                            eventData = eventStr;
                            ind = eventStr.indexOf(" - ");
                            if (ind != -1) {
                                eventData = eventStr.substring(ind + 3);
                                Log.d(WidiMonitor.TAG, "eventData =" + eventData);
                            }
                            if (eventData.startsWith(WidiMonitor.MONITOR_SOCKET_CLOSED_STR)) {
                                Log.d(WidiMonitor.TAG, "socket is closed,exiting thread");
                                return;
                            } else if (!eventData.startsWith(WidiMonitor.WIDI_RECV_ERROR_STR)) {
                                break;
                            } else if (WidiMonitor.access$304(WidiMonitor.this) > WidiMonitor.MAX_RECV_ERRORS) {
                                break;
                            }
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_STOP_SUCCESS_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_STOP_SUCCESS_EVENT);
                            return;
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_START_SUCCESS_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_START_SUCCESS_EVENT);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_START_FAIL_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_START_FAIL_EVENT);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_CONNECTION_FAIL_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_CONNECTION_FAIL_EVENT);
                            WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_BACK_TO_READY_EVENT, 1500);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_AUTHENTICATE_FAIL_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_AUTHENTICATE_FAIL_EVENT);
                            WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_BACK_TO_READY_EVENT, 5000);
                        } else if (eventStr.startsWith(WidiMonitor.WIDI_DHCP_FAIL_STR)) {
                            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_DHCP_FAIL_EVENT);
                            WidiMonitor.this.mWidiStateMachine.sendMessageDelayed(WidiMonitor.WIDI_BACK_TO_READY_EVENT, 1500);
                        } else {
                            Log.d(WidiMonitor.TAG, "Unknow event");
                        }
                    }
                }
                Log.d(WidiMonitor.TAG, "too many errors,closing connection");
                Log.d(WidiMonitor.TAG, "=====>terminating ");
                WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_STOP_SUCCESS_EVENT);
                return;
            }
            WidiMonitor.this.mWidiStateMachine.sendMessage(WidiMonitor.WIDI_BINDED_FAIL_EVENT);
        }
    }

    static /* synthetic */ int access$304(WidiMonitor x0) {
        int i = x0.mRecvErrors + 1;
        x0.mRecvErrors = i;
        return i;
    }

    public WidiMonitor(StateMachine widiStateMachine, WidiNative widiNative) {
        this.mRecvErrors = 0;
        this.mWidiStateMachine = widiStateMachine;
        this.mWidiNative = widiNative;
    }

    public void startMonitor() {
        new MonitorThread().start();
    }

    private boolean connectToWidi() {
        int countTries = 0;
        while (true) {
            WidiNative widiNative = this.mWidiNative;
            if (WidiNative.connectToWidi()) {
                return true;
            }
            int countTries2 = countTries + 1;
            if (countTries < 5) {
                nap(1);
                countTries = countTries2;
            } else {
                countTries = countTries2;
                return false;
            }
        }
    }

    private static void nap(int secs) {
        try {
            Thread.sleep((long) (secs * MMediaPlayer.MEDIA_INFO_SUBTITLE_UPDATA));
        } catch (InterruptedException e) {
        }
    }
}
