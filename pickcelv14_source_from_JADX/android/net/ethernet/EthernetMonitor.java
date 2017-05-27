package android.net.ethernet;

import android.net.NetworkInfo.DetailedState;
import android.util.Slog;

public class EthernetMonitor {
    private static final int ADD_ADDR = 20;
    private static final int CONNECTED = 1;
    private static final int DEL_LINK = 17;
    private static final int DISCONNECTED = 2;
    private static final int NEW_LINK = 16;
    private static final int PHYUP = 3;
    private static final int REMOVE_ADDR = 4;
    private static final int RM_ADDR = 21;
    private static final String TAG = "EthernetMonitor";
    private static final String connectedEvent = "CONNECTED";
    private static final String disconnectedEvent = "DISCONNECTED";
    private static final boolean localLOGV = true;
    private EthernetStateTracker mTracker;

    class MonitorThread extends Thread {
        public MonitorThread() {
            super("EthMonitor");
        }

        public void run() {
            while (true) {
                Slog.v(EthernetMonitor.TAG, "go poll events");
                String eventName = EthernetNative.waitForEvent();
                if (eventName != null) {
                    Slog.v(EthernetMonitor.TAG, "get event " + eventName);
                    int i = 0;
                    while (i < eventName.length()) {
                        int index = eventName.substring(i).indexOf(":");
                        if (index != -1) {
                            String dev = eventName.substring(i, index);
                            i += index + EthernetMonitor.CONNECTED;
                            index = eventName.substring(i).indexOf(":");
                            if (index != -1) {
                                int cmd = Integer.parseInt(eventName.substring(i, i + index));
                                i += index + EthernetMonitor.CONNECTED;
                                Slog.v(EthernetMonitor.TAG, "dev: " + dev + " ev " + cmd);
                                switch (cmd) {
                                    case EthernetMonitor.NEW_LINK /*16*/:
                                        handleEvent(dev, EthernetMonitor.PHYUP);
                                        break;
                                    case EthernetMonitor.DEL_LINK /*17*/:
                                        handleEvent(dev, EthernetMonitor.DISCONNECTED);
                                        break;
                                    case EthernetMonitor.ADD_ADDR /*20*/:
                                        handleEvent(dev, EthernetMonitor.CONNECTED);
                                        break;
                                    case EthernetMonitor.RM_ADDR /*21*/:
                                        handleEvent(dev, EthernetMonitor.REMOVE_ADDR);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }

        void handleEvent(String ifname, int event) {
            switch (event) {
                case EthernetMonitor.CONNECTED /*1*/:
                    EthernetMonitor.this.mTracker.notifyStateChange(ifname, DetailedState.CONNECTED);
                case EthernetMonitor.DISCONNECTED /*2*/:
                    EthernetMonitor.this.mTracker.notifyStateChange(ifname, DetailedState.DISCONNECTED);
                case EthernetMonitor.PHYUP /*3*/:
                    EthernetMonitor.this.mTracker.notifyPhyConnected(ifname);
                case EthernetMonitor.REMOVE_ADDR /*4*/:
                    EthernetMonitor.this.mTracker.notifyAddressRemove(ifname);
                default:
                    EthernetMonitor.this.mTracker.notifyStateChange(ifname, DetailedState.FAILED);
            }
        }
    }

    public EthernetMonitor(EthernetStateTracker tracker) {
        this.mTracker = tracker;
    }

    public void startMonitoring() {
        new MonitorThread().start();
    }
}
