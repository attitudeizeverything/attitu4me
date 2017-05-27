package fi.iki.elonen;

import fi.iki.elonen.NanoHTTPD.Response;
import java.util.Map;

public class InternalRewrite extends Response {
    private final Map<String, String> headers;
    private final String uri;

    public InternalRewrite(Map<String, String> headers, String uri) {
        super(null);
        this.headers = headers;
        this.uri = uri;
    }

    public String getUri() {
        return this.uri;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }
}
