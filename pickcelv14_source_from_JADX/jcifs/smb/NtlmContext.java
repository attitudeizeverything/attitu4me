package jcifs.smb;

import jcifs.ntlmssp.Type1Message;
import jcifs.ntlmssp.Type2Message;
import jcifs.ntlmssp.Type3Message;
import jcifs.util.Hexdump;
import jcifs.util.LogStream;

public class NtlmContext {
    NtlmPasswordAuthentication auth;
    boolean isEstablished;
    LogStream log;
    String netbiosName;
    int ntlmsspFlags;
    byte[] serverChallenge;
    byte[] signingKey;
    int state;
    String workstation;

    public NtlmContext(NtlmPasswordAuthentication auth, boolean doSigning) {
        this.isEstablished = false;
        this.serverChallenge = null;
        this.signingKey = null;
        this.netbiosName = null;
        this.state = 1;
        this.auth = auth;
        this.ntlmsspFlags = ((this.ntlmsspFlags | 4) | SmbConstants.WRITE_OWNER) | SmbConstants.GENERIC_EXECUTE;
        if (doSigning) {
            this.ntlmsspFlags |= 1073774608;
        }
        this.workstation = Type1Message.getDefaultWorkstation();
        this.log = LogStream.getInstance();
    }

    public String toString() {
        String ret = "NtlmContext[auth=" + this.auth + ",ntlmsspFlags=0x" + Hexdump.toHexString(this.ntlmsspFlags, 8) + ",workstation=" + this.workstation + ",isEstablished=" + this.isEstablished + ",state=" + this.state + ",serverChallenge=";
        if (this.serverChallenge == null) {
            ret = ret + "null";
        } else {
            ret = ret + Hexdump.toHexString(this.serverChallenge, 0, this.serverChallenge.length * 2);
        }
        ret = ret + ",signingKey=";
        if (this.signingKey == null) {
            ret = ret + "null";
        } else {
            ret = ret + Hexdump.toHexString(this.signingKey, 0, this.signingKey.length * 2);
        }
        return ret + "]";
    }

    public boolean isEstablished() {
        return this.isEstablished;
    }

    public byte[] getServerChallenge() {
        return this.serverChallenge;
    }

    public byte[] getSigningKey() {
        return this.signingKey;
    }

    public String getNetbiosName() {
        return this.netbiosName;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getNtlmsspListItem(byte[] r7, int r8) {
        /*
        r6 = this;
        r2 = 58;
    L_0x0002:
        r0 = jcifs.util.Encdec.dec_uint16le(r7, r2);
        r4 = r2 + 2;
        r1 = jcifs.util.Encdec.dec_uint16le(r7, r4);
        r2 = r2 + 4;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r4 = r2 + r1;
        r5 = r7.length;
        if (r4 <= r5) goto L_0x0017;
    L_0x0015:
        r4 = 0;
    L_0x0016:
        return r4;
    L_0x0017:
        if (r0 != r8) goto L_0x0023;
    L_0x0019:
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0021 }
        r5 = "UTF-16LE";
        r4.<init>(r7, r2, r1, r5);	 Catch:{ UnsupportedEncodingException -> 0x0021 }
        goto L_0x0016;
    L_0x0021:
        r3 = move-exception;
        goto L_0x0015;
    L_0x0023:
        r2 = r2 + r1;
        goto L_0x0002;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.smb.NtlmContext.getNtlmsspListItem(byte[], int):java.lang.String");
    }

    public byte[] initSecContext(byte[] token, int offset, int len) throws SmbException {
        LogStream logStream;
        switch (this.state) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                Type1Message msg1 = new Type1Message(this.ntlmsspFlags, this.auth.getDomain(), this.workstation);
                token = msg1.toByteArray();
                logStream = this.log;
                if (LogStream.level >= 4) {
                    this.log.println(msg1);
                    logStream = this.log;
                    if (LogStream.level >= 6) {
                        Hexdump.hexdump(this.log, token, 0, token.length);
                    }
                }
                this.state++;
                break;
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                try {
                    Type2Message msg2 = new Type2Message(token);
                    logStream = this.log;
                    if (LogStream.level >= 4) {
                        this.log.println(msg2);
                        logStream = this.log;
                        if (LogStream.level >= 6) {
                            Hexdump.hexdump(this.log, token, 0, token.length);
                        }
                    }
                    this.serverChallenge = msg2.getChallenge();
                    this.ntlmsspFlags &= msg2.getFlags();
                    Type3Message msg3 = new Type3Message(msg2, this.auth.getPassword(), this.auth.getDomain(), this.auth.getUsername(), this.workstation, this.ntlmsspFlags);
                    token = msg3.toByteArray();
                    logStream = this.log;
                    if (LogStream.level >= 4) {
                        this.log.println(msg3);
                        logStream = this.log;
                        if (LogStream.level >= 6) {
                            Hexdump.hexdump(this.log, token, 0, token.length);
                        }
                    }
                    if ((this.ntlmsspFlags & 16) != 0) {
                        this.signingKey = msg3.getMasterKey();
                    }
                    this.isEstablished = true;
                    this.state++;
                    break;
                } catch (Throwable e) {
                    throw new SmbException(e.getMessage(), e);
                }
            default:
                throw new SmbException("Invalid state");
        }
        return token;
    }
}
