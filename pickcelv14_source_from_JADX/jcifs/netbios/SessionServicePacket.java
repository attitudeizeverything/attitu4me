package jcifs.netbios;

import android.support.v4.internal.view.SupportMenu;
import com.mstar.android.MKeyEvent;
import java.io.IOException;
import java.io.InputStream;

public abstract class SessionServicePacket {
    static final int HEADER_LENGTH = 4;
    static final int MAX_MESSAGE_SIZE = 131071;
    public static final int NEGATIVE_SESSION_RESPONSE = 131;
    public static final int POSITIVE_SESSION_RESPONSE = 130;
    static final int SESSION_KEEP_ALIVE = 133;
    static final int SESSION_MESSAGE = 0;
    static final int SESSION_REQUEST = 129;
    static final int SESSION_RETARGET_RESPONSE = 132;
    int length;
    int type;

    abstract int readTrailerWireFormat(InputStream inputStream, byte[] bArr, int i) throws IOException;

    abstract int writeTrailerWireFormat(byte[] bArr, int i);

    static void writeInt2(int val, byte[] dst, int dstIndex) {
        int dstIndex2 = dstIndex + 1;
        dst[dstIndex] = (byte) ((val >> 8) & MKeyEvent.KEYCODE_SLEEP);
        dst[dstIndex2] = (byte) (val & MKeyEvent.KEYCODE_SLEEP);
    }

    static void writeInt4(int val, byte[] dst, int dstIndex) {
        int i = dstIndex + 1;
        dst[dstIndex] = (byte) ((val >> 24) & MKeyEvent.KEYCODE_SLEEP);
        dstIndex = i + 1;
        dst[i] = (byte) ((val >> 16) & MKeyEvent.KEYCODE_SLEEP);
        i = dstIndex + 1;
        dst[dstIndex] = (byte) ((val >> 8) & MKeyEvent.KEYCODE_SLEEP);
        dst[i] = (byte) (val & MKeyEvent.KEYCODE_SLEEP);
    }

    static int readInt2(byte[] src, int srcIndex) {
        return ((src[srcIndex] & MKeyEvent.KEYCODE_SLEEP) << 8) + (src[srcIndex + 1] & MKeyEvent.KEYCODE_SLEEP);
    }

    static int readInt4(byte[] src, int srcIndex) {
        return ((((src[srcIndex] & MKeyEvent.KEYCODE_SLEEP) << 24) + ((src[srcIndex + 1] & MKeyEvent.KEYCODE_SLEEP) << 16)) + ((src[srcIndex + 2] & MKeyEvent.KEYCODE_SLEEP) << 8)) + (src[srcIndex + 3] & MKeyEvent.KEYCODE_SLEEP);
    }

    static int readLength(byte[] src, int srcIndex) {
        srcIndex++;
        int srcIndex2 = srcIndex + 1;
        srcIndex = srcIndex2 + 1;
        srcIndex2 = srcIndex + 1;
        return (((src[srcIndex] & 1) << 16) + ((src[srcIndex2] & MKeyEvent.KEYCODE_SLEEP) << 8)) + (src[srcIndex] & MKeyEvent.KEYCODE_SLEEP);
    }

    static int readn(InputStream in, byte[] b, int off, int len) throws IOException {
        int i = SESSION_MESSAGE;
        while (i < len) {
            int n = in.read(b, off + i, len - i);
            if (n <= 0) {
                break;
            }
            i += n;
        }
        return i;
    }

    static int readPacketType(InputStream in, byte[] buffer, int bufferIndex) throws IOException {
        int n = readn(in, buffer, bufferIndex, HEADER_LENGTH);
        if (n == HEADER_LENGTH) {
            return buffer[bufferIndex] & MKeyEvent.KEYCODE_SLEEP;
        }
        if (n == -1) {
            return -1;
        }
        throw new IOException("unexpected EOF reading netbios session header");
    }

    public int writeWireFormat(byte[] dst, int dstIndex) {
        this.length = writeTrailerWireFormat(dst, dstIndex + HEADER_LENGTH);
        writeHeaderWireFormat(dst, dstIndex);
        return this.length + HEADER_LENGTH;
    }

    int readWireFormat(InputStream in, byte[] buffer, int bufferIndex) throws IOException {
        readHeaderWireFormat(in, buffer, bufferIndex);
        return readTrailerWireFormat(in, buffer, bufferIndex) + HEADER_LENGTH;
    }

    int writeHeaderWireFormat(byte[] dst, int dstIndex) {
        int dstIndex2 = dstIndex + 1;
        dst[dstIndex] = (byte) this.type;
        if (this.length > SupportMenu.USER_MASK) {
            dst[dstIndex2] = (byte) 1;
        }
        writeInt2(this.length, dst, dstIndex2 + 1);
        return HEADER_LENGTH;
    }

    int readHeaderWireFormat(InputStream in, byte[] buffer, int bufferIndex) throws IOException {
        int bufferIndex2 = bufferIndex + 1;
        this.type = buffer[bufferIndex] & MKeyEvent.KEYCODE_SLEEP;
        this.length = ((buffer[bufferIndex2] & 1) << 16) + readInt2(buffer, bufferIndex2 + 1);
        return HEADER_LENGTH;
    }
}
