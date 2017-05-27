package fi.iki.elonen;

import android.annotation.TargetApi;
import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.StringTokenizer;

@TargetApi(9)
public class SimpleWebServer extends NanoHTTPD {
    public static final List<String> INDEX_FILE_NAMES;
    private static final String LICENCE = "Copyright (c) 2012-2013 by Paul S. Hawke, 2001,2005-2013 by Jarno Elonen, 2010 by Konstantinos Togias\n\nRedistribution and use in source and binary forms, with or without\nmodification, are permitted provided that the following conditions\nare met:\n\nRedistributions of source code must retain the above copyright notice,\nthis list of conditions and the following disclaimer. Redistributions in\nbinary form must reproduce the above copyright notice, this list of\nconditions and the following disclaimer in the documentation and/or other\nmaterials provided with the distribution. The name of the author may not\nbe used to endorse or promote products derived from this software without\nspecific prior written permission. \n \nTHIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR\nIMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\nOF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.\nIN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,\nINCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT\nNOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\nDATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY\nTHEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE\nOF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.";
    public static final String MIME_DEFAULT_BINARY = "application/octet-stream";
    private static final Map<String, String> MIME_TYPES;
    private static Map<String, WebServerPlugin> mimeTypeHandlers;
    private final boolean quiet;
    private final List<File> rootDirs;

    /* renamed from: fi.iki.elonen.SimpleWebServer.1 */
    class C02761 extends ArrayList<String> {
        C02761() {
            add("index.html");
            add("index.htm");
        }
    }

    /* renamed from: fi.iki.elonen.SimpleWebServer.2 */
    class C02772 extends HashMap<String, String> {
        C02772() {
            put("css", "text/css");
            put("htm", NanoHTTPD.MIME_HTML);
            put("html", NanoHTTPD.MIME_HTML);
            put("xml", "text/xml");
            put("java", "text/x-java-source, text/java");
            put("md", NanoHTTPD.MIME_PLAINTEXT);
            put("txt", NanoHTTPD.MIME_PLAINTEXT);
            put("asc", NanoHTTPD.MIME_PLAINTEXT);
            put("gif", "image/gif");
            put("jpg", "image/jpeg");
            put("jpeg", "image/jpeg");
            put("png", "image/png");
            put("mp3", "audio/mpeg");
            put("m3u", "audio/mpeg-url");
            put("mp4", "video/mp4");
            put("ogv", "video/ogg");
            put("flv", "video/x-flv");
            put("mov", "video/quicktime");
            put("swf", "application/x-shockwave-flash");
            put("js", "application/javascript");
            put("pdf", "application/pdf");
            put("doc", "application/msword");
            put("ogg", "application/x-ogg");
            put("zip", SimpleWebServer.MIME_DEFAULT_BINARY);
            put("exe", SimpleWebServer.MIME_DEFAULT_BINARY);
            put("class", SimpleWebServer.MIME_DEFAULT_BINARY);
        }
    }

    /* renamed from: fi.iki.elonen.SimpleWebServer.3 */
    class C02783 extends FileInputStream {
        private final /* synthetic */ long val$dataLen;

        C02783(File $anonymous0, long j) throws FileNotFoundException {
            this.val$dataLen = j;
            super($anonymous0);
        }

        public int available() throws IOException {
            return (int) this.val$dataLen;
        }
    }

    /* renamed from: fi.iki.elonen.SimpleWebServer.4 */
    class C02794 implements FilenameFilter {
        C02794() {
        }

        public boolean accept(File dir, String name) {
            return new File(dir, name).isFile();
        }
    }

    /* renamed from: fi.iki.elonen.SimpleWebServer.5 */
    class C02805 implements FilenameFilter {
        C02805() {
        }

        public boolean accept(File dir, String name) {
            return new File(dir, name).isDirectory();
        }
    }

    static {
        INDEX_FILE_NAMES = new C02761();
        MIME_TYPES = new C02772();
        mimeTypeHandlers = new HashMap();
    }

    public SimpleWebServer(String host, int port, File wwwroot, boolean quiet) {
        super(host, port);
        this.quiet = quiet;
        this.rootDirs = new ArrayList();
        this.rootDirs.add(wwwroot);
        init();
    }

    public SimpleWebServer(String host, int port, List<File> wwwroots, boolean quiet) {
        super(host, port);
        this.quiet = quiet;
        this.rootDirs = new ArrayList(wwwroots);
        init();
    }

    public void init() {
    }

    public static void startServer(List<File> rootDirs) {
        String host = "0.0.0.0";
        Map<String, String> options = new HashMap();
        if (rootDirs.isEmpty()) {
            rootDirs.add(new File(".").getAbsoluteFile());
        }
        options.put("host", host);
        options.put("port", 8765);
        options.put("quiet", String.valueOf(false));
        StringBuilder sb = new StringBuilder();
        for (File dir : rootDirs) {
            if (sb.length() > 0) {
                sb.append(":");
            }
            try {
                sb.append(dir.getCanonicalPath());
            } catch (IOException e) {
            }
        }
        options.put("home", sb.toString());
        Iterator it = ServiceLoader.load(WebServerPluginInfo.class).iterator();
        while (it.hasNext()) {
            WebServerPluginInfo info = (WebServerPluginInfo) it.next();
            for (String mime : info.getMimeTypes()) {
                String[] indexFiles = info.getIndexFilesForMimeType(mime);
                if (null == null) {
                    System.out.print("# Found plugin for Mime type: \"" + mime + "\"");
                    if (indexFiles != null) {
                        System.out.print(" (serving index files: ");
                        for (String indexFile : indexFiles) {
                            System.out.print(indexFile + " ");
                        }
                    }
                    System.out.println(").");
                }
                registerPluginForMimeType(indexFiles, mime, info.getWebServerPlugin(mime), options);
            }
        }
        ServerRunner.executeInstance(new SimpleWebServer(host, 8765, (List) rootDirs, false));
    }

    protected static void registerPluginForMimeType(String[] indexFiles, String mimeType, WebServerPlugin plugin, Map<String, String> commandLineOptions) {
        if (mimeType != null && plugin != null) {
            if (indexFiles != null) {
                for (String filename : indexFiles) {
                    int dot = filename.lastIndexOf(46);
                    if (dot >= 0) {
                        MIME_TYPES.put(filename.substring(dot + 1).toLowerCase(), mimeType);
                    }
                }
                INDEX_FILE_NAMES.addAll(Arrays.asList(indexFiles));
            }
            mimeTypeHandlers.put(mimeType, plugin);
            plugin.initialize(commandLineOptions);
        }
    }

    private File getRootDir() {
        return (File) this.rootDirs.get(0);
    }

    private List<File> getRootDirs() {
        return this.rootDirs;
    }

    private void addWwwRootDir(File wwwroot) {
        this.rootDirs.add(wwwroot);
    }

    private String encodeUri(String uri) {
        String newUri = "";
        StringTokenizer st = new StringTokenizer(uri, "/ ", true);
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            if (tok.equals("/")) {
                newUri = new StringBuilder(String.valueOf(newUri)).append("/").toString();
            } else if (tok.equals(" ")) {
                newUri = new StringBuilder(String.valueOf(newUri)).append("%20").toString();
            } else {
                try {
                    newUri = new StringBuilder(String.valueOf(newUri)).append(URLEncoder.encode(tok, "UTF-8")).toString();
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return newUri;
    }

    public Response serve(IHTTPSession session) {
        Map<String, String> header = session.getHeaders();
        Map<String, String> parms = session.getParms();
        String uri = session.getUri();
        if (!this.quiet) {
            System.out.println(session.getMethod() + " '" + uri + "' ");
            for (String value : header.keySet()) {
                System.out.println("  HDR: '" + value + "' = '" + ((String) header.get(value)) + "'");
            }
            for (String value2 : parms.keySet()) {
                System.out.println("  PRM: '" + value2 + "' = '" + ((String) parms.get(value2)) + "'");
            }
        }
        for (File homeDir : getRootDirs()) {
            if (!homeDir.isDirectory()) {
                return getInternalErrorResponse("given path is not a directory (" + homeDir + ").");
            }
        }
        return respond(Collections.unmodifiableMap(header), session, uri);
    }

    private Response respond(Map<String, String> headers, IHTTPSession session, String uri) {
        uri = uri.trim().replace(File.separatorChar, '/');
        if (uri.indexOf(63) >= 0) {
            uri = uri.substring(0, uri.indexOf(63));
        }
        if (!uri.startsWith("src/main")) {
            if (!uri.endsWith("src/main")) {
                if (!uri.contains("../")) {
                    boolean canServeUri = false;
                    File homeDir = null;
                    List<File> roots = getRootDirs();
                    int i = 0;
                    while (!canServeUri && i < roots.size()) {
                        homeDir = (File) roots.get(i);
                        canServeUri = canServeUri(uri, homeDir);
                        i++;
                    }
                    if (!canServeUri) {
                        return getNotFoundResponse();
                    }
                    File f = new File(homeDir, uri);
                    if (f.isDirectory()) {
                        if (!uri.endsWith("/")) {
                            uri = new StringBuilder(String.valueOf(uri)).append("/").toString();
                            String str = "\">";
                            str = "</a></body></html>";
                            Response res = createResponse(Status.REDIRECT, NanoHTTPD.MIME_HTML, "<html><body>Redirected: <a href=\"" + uri + r17 + uri + r17);
                            res.addHeader("Location", uri);
                            return res;
                        }
                    }
                    if (f.isDirectory()) {
                        String indexFile = findIndexFileInDirectory(f);
                        if (indexFile != null) {
                            return respond(headers, session, new StringBuilder(String.valueOf(uri)).append(indexFile).toString());
                        } else if (!f.canRead()) {
                            return getForbiddenResponse("No directory listing.");
                        } else {
                            return createResponse(Status.OK, NanoHTTPD.MIME_HTML, listDirectory(uri, f));
                        }
                    }
                    Response response;
                    String mimeTypeForFile = getMimeTypeForFile(uri);
                    WebServerPlugin plugin = (WebServerPlugin) mimeTypeHandlers.get(mimeTypeForFile);
                    if (plugin != null) {
                        response = plugin.serveFile(uri, headers, session, f, mimeTypeForFile);
                        if (response != null && (response instanceof InternalRewrite)) {
                            InternalRewrite rewrite = (InternalRewrite) response;
                            return respond(rewrite.getHeaders(), session, rewrite.getUri());
                        }
                    }
                    response = serveFile(uri, headers, f, mimeTypeForFile);
                    if (response == null) {
                        response = getNotFoundResponse();
                    }
                    return response;
                }
            }
        }
        return getForbiddenResponse("Won't serve ../ for security reasons.");
    }

    protected Response getNotFoundResponse() {
        return createResponse(Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "Error 404, file not found.");
    }

    protected Response getForbiddenResponse(String s) {
        return createResponse(Status.FORBIDDEN, NanoHTTPD.MIME_PLAINTEXT, "FORBIDDEN: " + s);
    }

    protected Response getInternalErrorResponse(String s) {
        return createResponse(Status.INTERNAL_ERROR, NanoHTTPD.MIME_PLAINTEXT, "INTERNAL ERRROR: " + s);
    }

    private boolean canServeUri(String uri, File homeDir) {
        boolean canServeUri = new File(homeDir, uri).exists();
        if (canServeUri) {
            return canServeUri;
        }
        WebServerPlugin plugin = (WebServerPlugin) mimeTypeHandlers.get(getMimeTypeForFile(uri));
        if (plugin != null) {
            return plugin.canServeUri(uri, homeDir);
        }
        return canServeUri;
    }

    Response serveFile(String uri, Map<String, String> header, File file, String mime) {
        try {
            String etag = Integer.toHexString((file.getAbsolutePath() + file.lastModified() + file.length()).hashCode());
            long startFrom = 0;
            long endAt = -1;
            String range = (String) header.get("range");
            if (range != null) {
                if (range.startsWith("bytes=")) {
                    range = range.substring("bytes=".length());
                    int minus = range.indexOf(45);
                    if (minus > 0) {
                        try {
                            startFrom = Long.parseLong(range.substring(0, minus));
                            endAt = Long.parseLong(range.substring(minus + 1));
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
            long fileLen = file.length();
            Response res;
            if (range == null || startFrom < 0) {
                if (etag.equals(header.get("if-none-match"))) {
                    return createResponse(Status.NOT_MODIFIED, mime, "");
                }
                res = createResponse(Status.OK, mime, new FileInputStream(file));
                res.addHeader("Content-Length", fileLen);
                res.addHeader("ETag", etag);
                return res;
            } else if (startFrom >= fileLen) {
                res = createResponse(Status.RANGE_NOT_SATISFIABLE, NanoHTTPD.MIME_PLAINTEXT, "");
                res.addHeader("Content-Range", "bytes 0-0/" + fileLen);
                res.addHeader("ETag", etag);
                return res;
            } else {
                if (endAt < 0) {
                    endAt = fileLen - 1;
                }
                long newLen = (endAt - startFrom) + 1;
                if (newLen < 0) {
                    newLen = 0;
                }
                long dataLen = newLen;
                InputStream fis = new C02783(file, dataLen);
                fis.skip(startFrom);
                res = createResponse(Status.PARTIAL_CONTENT, mime, fis);
                res.addHeader("Content-Length", dataLen);
                res.addHeader("Content-Range", "bytes " + startFrom + "-" + endAt + "/" + fileLen);
                res.addHeader("ETag", etag);
                return res;
            }
        } catch (IOException e2) {
            return getForbiddenResponse("Reading file failed.");
        }
    }

    private String getMimeTypeForFile(String uri) {
        int dot = uri.lastIndexOf(46);
        String mime = null;
        if (dot >= 0) {
            mime = (String) MIME_TYPES.get(uri.substring(dot + 1).toLowerCase());
        }
        return mime == null ? MIME_DEFAULT_BINARY : mime;
    }

    private Response createResponse(Status status, String mimeType, InputStream message) {
        Response res = new Response((IStatus) status, mimeType, message);
        res.addHeader("Accept-Ranges", "bytes");
        return res;
    }

    private Response createResponse(Status status, String mimeType, String message) {
        Response res = new Response((IStatus) status, mimeType, message);
        res.addHeader("Accept-Ranges", "bytes");
        return res;
    }

    private String findIndexFileInDirectory(File directory) {
        for (String fileName : INDEX_FILE_NAMES) {
            if (new File(directory, fileName).exists()) {
                return fileName;
            }
        }
        return null;
    }

    protected String listDirectory(String uri, File f) {
        String heading = "Directory " + uri;
        StringBuilder msg = new StringBuilder("<html><head><title>" + heading + "</title><style><!--\n" + "span.dirname { font-weight: bold; }\n" + "span.filesize { font-size: 75%; }\n" + "// -->\n" + "</style>" + "</head><body><h1>" + heading + "</h1>");
        String up = null;
        if (uri.length() > 1) {
            String u = uri.substring(0, uri.length() - 1);
            int slash = u.lastIndexOf(47);
            if (slash >= 0 && slash < u.length()) {
                up = uri.substring(0, slash + 1);
            }
        }
        List<String> files = Arrays.asList(f.list(new C02794()));
        Collections.sort(files);
        List<String> directories = Arrays.asList(f.list(new C02805()));
        Collections.sort(directories);
        if (up != null || directories.size() + files.size() > 0) {
            msg.append("<ul>");
            if (up != null || directories.size() > 0) {
                msg.append("<section class=\"directories\">");
                if (up != null) {
                    msg.append("<li><a rel=\"directory\" href=\"").append(up).append("\"><span class=\"dirname\">..</span></a></b></li>");
                }
                for (String directory : directories) {
                    String dir = new StringBuilder(String.valueOf(directory)).append("/").toString();
                    msg.append("<li><a rel=\"directory\" href=\"").append(encodeUri(new StringBuilder(String.valueOf(uri)).append(dir).toString())).append("\"><span class=\"dirname\">").append(dir).append("</span></a></b></li>");
                }
                msg.append("</section>");
            }
            if (files.size() > 0) {
                msg.append("<section class=\"files\">");
                for (String file : files) {
                    msg.append("<li><a href=\"").append(encodeUri(new StringBuilder(String.valueOf(uri)).append(file).toString())).append("\"><span class=\"filename\">").append(file).append("</span></a>");
                    long len = new File(f, file).length();
                    msg.append("&nbsp;<span class=\"filesize\">(");
                    if (len < 1024) {
                        msg.append(len).append(" bytes");
                    } else if (len < 1048576) {
                        msg.append(len / 1024).append(".").append(((len % 1024) / 10) % 100).append(" KB");
                    } else {
                        msg.append(len / 1048576).append(".").append(((len % 1048576) / 10) % 100).append(" MB");
                    }
                    msg.append(")</span></li>");
                }
                msg.append("</section>");
            }
            msg.append("</ul>");
        }
        msg.append("</body></html>");
        return msg.toString();
    }
}
