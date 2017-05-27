package fi.iki.elonen;

public interface WebServerPluginInfo {
    String[] getIndexFilesForMimeType(String str);

    String[] getMimeTypes();

    WebServerPlugin getWebServerPlugin(String str);
}
