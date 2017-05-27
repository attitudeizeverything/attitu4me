package jcifs.ntlmssp;

import com.mstar.android.MKeyEvent;
import jcifs.Config;

public abstract class NtlmMessage implements NtlmFlags {
    protected static final byte[] NTLMSSP_SIGNATURE;
    private static final String OEM_ENCODING;
    protected static final String UNI_ENCODING = "UTF-16LE";
    private int flags;

    public abstract byte[] toByteArray();

    static {
        NTLMSSP_SIGNATURE = new byte[]{(byte) 78, (byte) 84, (byte) 76, (byte) 77, (byte) 83, (byte) 83, (byte) 80, (byte) 0};
        OEM_ENCODING = Config.DEFAULT_OEM_ENCODING;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getFlag(int flag) {
        return (getFlags() & flag) != 0;
    }

    public void setFlag(int flag, boolean value) {
        setFlags(value ? getFlags() | flag : getFlags() & (flag ^ -1));
    }

    static int readULong(byte[] src, int index) {
        return (((src[index] & MKeyEvent.KEYCODE_SLEEP) | ((src[index + 1] & MKeyEvent.KEYCODE_SLEEP) << 8)) | ((src[index + 2] & MKeyEvent.KEYCODE_SLEEP) << 16)) | ((src[index + 3] & MKeyEvent.KEYCODE_SLEEP) << 24);
    }

    static int readUShort(byte[] src, int index) {
        return (src[index] & MKeyEvent.KEYCODE_SLEEP) | ((src[index + 1] & MKeyEvent.KEYCODE_SLEEP) << 8);
    }

    static byte[] readSecurityBuffer(byte[] src, int index) {
        int length = readUShort(src, index);
        byte[] buffer = new byte[length];
        System.arraycopy(src, readULong(src, index + 4), buffer, 0, length);
        return buffer;
    }

    static void writeULong(byte[] dest, int offset, int ulong) {
        dest[offset] = (byte) (ulong & MKeyEvent.KEYCODE_SLEEP);
        dest[offset + 1] = (byte) ((ulong >> 8) & MKeyEvent.KEYCODE_SLEEP);
        dest[offset + 2] = (byte) ((ulong >> 16) & MKeyEvent.KEYCODE_SLEEP);
        dest[offset + 3] = (byte) ((ulong >> 24) & MKeyEvent.KEYCODE_SLEEP);
    }

    static void writeUShort(byte[] dest, int offset, int ushort) {
        dest[offset] = (byte) (ushort & MKeyEvent.KEYCODE_SLEEP);
        dest[offset + 1] = (byte) ((ushort >> 8) & MKeyEvent.KEYCODE_SLEEP);
    }

    static void writeSecurityBuffer(byte[] dest, int offset, int bodyOffset, byte[] src) {
        int length;
        if (src != null) {
            length = src.length;
        } else {
            length = 0;
        }
        if (length != 0) {
            writeUShort(dest, offset, length);
            writeUShort(dest, offset + 2, length);
            writeULong(dest, offset + 4, bodyOffset);
            System.arraycopy(src, 0, dest, bodyOffset, length);
        }
    }

    static String getOEMEncoding() {
        return OEM_ENCODING;
    }
}
