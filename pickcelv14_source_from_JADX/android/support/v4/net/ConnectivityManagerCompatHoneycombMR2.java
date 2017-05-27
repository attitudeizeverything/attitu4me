package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import jcifs.smb.SID;
import jcifs.smb.SmbNamedPipe;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case SID.SID_TYPE_USE_NONE /*0*/:
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
            case SID.SID_TYPE_ALIAS /*4*/:
            case SID.SID_TYPE_WKN_GRP /*5*/:
            case SID.SID_TYPE_DELETED /*6*/:
                return true;
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
            case SID.SID_TYPE_INVALID /*7*/:
            case SmbConstants.FLAGS_OFFSET /*9*/:
                return false;
            default:
                return true;
        }
    }
}
