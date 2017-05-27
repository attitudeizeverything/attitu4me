package jcifs.smb;

import android.support.v4.internal.view.SupportMenu;
import jcifs.Config;

public class BufferCache {
    private static final int MAX_BUFFERS;
    static Object[] cache;
    private static int freeBuffers;

    static {
        MAX_BUFFERS = Config.getInt("jcifs.smb.maxBuffers", 16);
        cache = new Object[MAX_BUFFERS];
        freeBuffers = 0;
    }

    public static byte[] getBuffer() {
        synchronized (cache) {
            byte[] buf;
            if (freeBuffers > 0) {
                for (int i = 0; i < MAX_BUFFERS; i++) {
                    if (cache[i] != null) {
                        buf = (byte[]) cache[i];
                        cache[i] = null;
                        freeBuffers--;
                        return buf;
                    }
                }
            }
            buf = new byte[SupportMenu.USER_MASK];
            return buf;
        }
    }

    static void getBuffers(SmbComTransaction req, SmbComTransactionResponse rsp) {
        synchronized (cache) {
            req.txn_buf = getBuffer();
            rsp.txn_buf = getBuffer();
        }
    }

    public static void releaseBuffer(byte[] buf) {
        synchronized (cache) {
            if (freeBuffers < MAX_BUFFERS) {
                for (int i = 0; i < MAX_BUFFERS; i++) {
                    if (cache[i] == null) {
                        cache[i] = buf;
                        freeBuffers++;
                        return;
                    }
                }
            }
        }
    }
}
