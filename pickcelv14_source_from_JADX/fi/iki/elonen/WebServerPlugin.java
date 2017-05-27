package fi.iki.elonen;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import java.io.File;
import java.util.Map;

public interface WebServerPlugin {
    boolean canServeUri(String str, File file);

    void initialize(Map<String, String> map);

    Response serveFile(String str, Map<String, String> map, IHTTPSession iHTTPSession, File file, String str2);
}
