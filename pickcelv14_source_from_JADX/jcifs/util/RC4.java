package jcifs.util;

import com.mstar.android.MKeyEvent;
import jcifs.smb.SmbNamedPipe;

public class RC4 {
    int f72i;
    int f73j;
    byte[] f74s;

    public RC4(byte[] key) {
        init(key, 0, key.length);
    }

    public void init(byte[] key, int ki, int klen) {
        this.f74s = new byte[SmbNamedPipe.PIPE_TYPE_CALL];
        this.f72i = 0;
        while (this.f72i < SmbNamedPipe.PIPE_TYPE_CALL) {
            this.f74s[this.f72i] = (byte) this.f72i;
            this.f72i++;
        }
        this.f73j = 0;
        this.f72i = 0;
        while (this.f72i < SmbNamedPipe.PIPE_TYPE_CALL) {
            this.f73j = ((this.f73j + key[(this.f72i % klen) + ki]) + this.f74s[this.f72i]) & MKeyEvent.KEYCODE_SLEEP;
            byte t = this.f74s[this.f72i];
            this.f74s[this.f72i] = this.f74s[this.f73j];
            this.f74s[this.f73j] = t;
            this.f72i++;
        }
        this.f73j = 0;
        this.f72i = 0;
    }

    public void update(byte[] src, int soff, int slen, byte[] dst, int doff) {
        int slim = soff + slen;
        int doff2 = doff;
        int soff2 = soff;
        while (soff2 < slim) {
            this.f72i = (this.f72i + 1) & MKeyEvent.KEYCODE_SLEEP;
            this.f73j = (this.f73j + this.f74s[this.f72i]) & MKeyEvent.KEYCODE_SLEEP;
            byte t = this.f74s[this.f72i];
            this.f74s[this.f72i] = this.f74s[this.f73j];
            this.f74s[this.f73j] = t;
            doff = doff2 + 1;
            soff = soff2 + 1;
            dst[doff2] = (byte) (src[soff2] ^ this.f74s[(this.f74s[this.f72i] + this.f74s[this.f73j]) & MKeyEvent.KEYCODE_SLEEP]);
            doff2 = doff;
            soff2 = soff;
        }
    }
}
