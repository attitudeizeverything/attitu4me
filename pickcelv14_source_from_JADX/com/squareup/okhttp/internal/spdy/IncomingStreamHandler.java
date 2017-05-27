package com.squareup.okhttp.internal.spdy;

import java.io.IOException;

public interface IncomingStreamHandler {
    public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS;

    /* renamed from: com.squareup.okhttp.internal.spdy.IncomingStreamHandler.1 */
    class C04201 implements IncomingStreamHandler {
        C04201() {
        }

        public void receive(SpdyStream stream) throws IOException {
            stream.close(ErrorCode.REFUSED_STREAM);
        }
    }

    void receive(SpdyStream spdyStream) throws IOException;

    static {
        REFUSE_INCOMING_STREAMS = new C04201();
    }
}
