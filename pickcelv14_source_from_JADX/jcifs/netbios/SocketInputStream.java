package jcifs.netbios;

import com.mstar.android.MKeyEvent;
import java.io.IOException;
import java.io.InputStream;
import jcifs.smb.SID;
import org.apache.cordova.CordovaResourceApi;

class SocketInputStream extends InputStream {
    private static final int TMP_BUFFER_SIZE = 256;
    private int bip;
    private byte[] header;
    private InputStream in;
    private int f67n;
    private SessionServicePacket ssp;
    private byte[] tmp;
    private int tot;

    SocketInputStream(InputStream in) {
        this.in = in;
        this.header = new byte[4];
        this.tmp = new byte[TMP_BUFFER_SIZE];
    }

    public synchronized int read() throws IOException {
        int i;
        if (read(this.tmp, 0, 1) < 0) {
            i = -1;
        } else {
            i = this.tmp[0] & MKeyEvent.KEYCODE_SLEEP;
        }
        return i;
    }

    public synchronized int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public synchronized int read(byte[] b, int off, int len) throws IOException {
        int i = -1;
        synchronized (this) {
            if (len == 0) {
                i = 0;
            } else {
                this.tot = 0;
                while (true) {
                    if (this.bip > 0) {
                        this.f67n = this.in.read(b, off, Math.min(len, this.bip));
                        if (this.f67n != -1) {
                            this.tot += this.f67n;
                            off += this.f67n;
                            len -= this.f67n;
                            this.bip -= this.f67n;
                            if (len == 0) {
                                i = this.tot;
                            }
                        } else if (this.tot > 0) {
                            i = this.tot;
                        }
                    } else {
                        switch (SessionServicePacket.readPacketType(this.in, this.header, 0)) {
                            case CordovaResourceApi.URI_TYPE_UNKNOWN /*-1*/:
                                if (this.tot > 0) {
                                    i = this.tot;
                                    break;
                                }
                                break;
                            case SID.SID_TYPE_USE_NONE /*0*/:
                                this.bip = SessionServicePacket.readLength(this.header, 0);
                                continue;
                            case 133:
                                break;
                            default:
                                continue;
                        }
                    }
                }
            }
        }
        return i;
    }

    public synchronized long skip(long numbytes) throws IOException {
        long j = 0;
        synchronized (this) {
            if (numbytes > 0) {
                long n = numbytes;
                while (n > 0) {
                    int r = read(this.tmp, 0, (int) Math.min(256, n));
                    if (r < 0) {
                        break;
                    }
                    n -= (long) r;
                }
                j = numbytes - n;
            }
        }
        return j;
    }

    public int available() throws IOException {
        if (this.bip > 0) {
            return this.bip;
        }
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }
}
