package jcifs.http;

import com.squareup.okhttp.internal.http.HttpTransport;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jcifs.Config;
import jcifs.smb.SmbAuthException;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.util.LogStream;
import jcifs.util.MimeMap;

public class NetworkExplorer extends HttpServlet {
    private static LogStream log;
    private boolean credentialsSupplied;
    private String defaultDomain;
    private boolean enableBasic;
    private boolean insecureBasic;
    private MimeMap mimeMap;
    private NtlmSsp ntlmSsp;
    private String realm;
    private String style;

    static {
        log = LogStream.getInstance();
    }

    public void init() throws ServletException {
        StringBuffer sb = new StringBuffer();
        byte[] buf = new byte[HttpTransport.DEFAULT_CHUNK_LENGTH];
        Config.setProperty("jcifs.smb.client.soTimeout", "600000");
        Config.setProperty("jcifs.smb.client.attrExpirationPeriod", "300000");
        Enumeration e = getInitParameterNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            if (name.startsWith("jcifs.")) {
                Config.setProperty(name, getInitParameter(name));
            }
        }
        if (Config.getProperty("jcifs.smb.client.username") == null) {
            this.ntlmSsp = new NtlmSsp();
        } else {
            this.credentialsSupplied = true;
        }
        try {
            this.mimeMap = new MimeMap();
            InputStream is = getClass().getClassLoader().getResourceAsStream("jcifs/http/ne.css");
            while (true) {
                int n = is.read(buf);
                if (n == -1) {
                    break;
                }
                sb.append(new String(buf, 0, n, "ISO8859_1"));
            }
            this.style = sb.toString();
            this.enableBasic = Config.getBoolean("jcifs.http.enableBasic", false);
            this.insecureBasic = Config.getBoolean("jcifs.http.insecureBasic", false);
            this.realm = Config.getProperty("jcifs.http.basicRealm");
            if (this.realm == null) {
                this.realm = "jCIFS";
            }
            this.defaultDomain = Config.getProperty("jcifs.smb.client.domain");
            int level = Config.getInt("jcifs.util.loglevel", -1);
            if (level != -1) {
                LogStream.setLevel(level);
            }
            LogStream logStream = log;
            if (LogStream.level > 2) {
                try {
                    Config.store(log, "JCIFS PROPERTIES");
                } catch (IOException e2) {
                }
            }
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        }
    }

    protected void doFile(HttpServletRequest req, HttpServletResponse resp, SmbFile file) throws IOException {
        byte[] buf = new byte[HTTPSession.BUFSIZE];
        SmbFileInputStream in = new SmbFileInputStream(file);
        ServletOutputStream out = resp.getOutputStream();
        String url = file.getPath();
        resp.setContentType(NanoHTTPD.MIME_PLAINTEXT);
        int n = url.lastIndexOf(46);
        if (n > 0) {
            String type = url.substring(n + 1);
            if (type != null && type.length() > 1 && type.length() < 6) {
                resp.setContentType(this.mimeMap.getMimeType(type));
            }
        }
        resp.setHeader("Content-Length", file.length() + "");
        resp.setHeader("Accept-Ranges", "Bytes");
        while (true) {
            n = in.read(buf);
            if (n != -1) {
                out.write(buf, 0, n);
            } else {
                return;
            }
        }
    }

    protected int compareNames(SmbFile f1, String f1name, SmbFile f2) throws IOException {
        if (f1.isDirectory() != f2.isDirectory()) {
            return f1.isDirectory() ? -1 : 1;
        } else {
            return f1name.compareToIgnoreCase(f2.getName());
        }
    }

    protected int compareSizes(SmbFile f1, String f1name, SmbFile f2) throws IOException {
        if (f1.isDirectory() != f2.isDirectory()) {
            if (f1.isDirectory()) {
                return -1;
            }
            return 1;
        } else if (f1.isDirectory()) {
            return f1name.compareToIgnoreCase(f2.getName());
        } else {
            long diff = f1.length() - f2.length();
            if (diff == 0) {
                return f1name.compareToIgnoreCase(f2.getName());
            }
            if (diff <= 0) {
                return 1;
            }
            return -1;
        }
    }

    protected int compareTypes(SmbFile f1, String f1name, SmbFile f2) throws IOException {
        if (f1.isDirectory() == f2.isDirectory()) {
            String f2name = f2.getName();
            if (f1.isDirectory()) {
                return f1name.compareToIgnoreCase(f2name);
            }
            int i = f1name.lastIndexOf(46);
            String t1 = i == -1 ? "" : f1name.substring(i + 1);
            i = f2name.lastIndexOf(46);
            i = t1.compareToIgnoreCase(i == -1 ? "" : f2name.substring(i + 1));
            if (i == 0) {
                return f1name.compareToIgnoreCase(f2name);
            }
            return i;
        } else if (f1.isDirectory()) {
            return -1;
        } else {
            return 1;
        }
    }

    protected int compareDates(SmbFile f1, String f1name, SmbFile f2) throws IOException {
        if (f1.isDirectory() != f2.isDirectory()) {
            if (f1.isDirectory()) {
                return -1;
            }
            return 1;
        } else if (f1.isDirectory()) {
            return f1name.compareToIgnoreCase(f2.getName());
        } else {
            if (f1.lastModified() <= f2.lastModified()) {
                return 1;
            }
            return -1;
        }
    }

    protected void doDirectory(HttpServletRequest req, HttpServletResponse resp, SmbFile dir) throws IOException {
        int length;
        ListIterator iter;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d/yy h:mm a");
        simpleDateFormat.setCalendar(new GregorianCalendar());
        SmbFile[] dirents = dir.listFiles();
        LogStream logStream = log;
        if (LogStream.level > 2) {
            log.println(dirents.length + " items listed");
        }
        LinkedList sorted = new LinkedList();
        String fmt = req.getParameter("fmt");
        if (fmt == null) {
            fmt = "col";
        }
        int sort = 0;
        String str = req.getParameter("sort");
        if (str == null || str.equals("name")) {
            sort = 0;
        } else if (str.equals("size")) {
            sort = 1;
        } else if (str.equals("type")) {
            sort = 2;
        } else if (str.equals("date")) {
            sort = 3;
        }
        int fileCount = 0;
        int dirCount = 0;
        int maxLen = 28;
        int i = 0;
        while (true) {
            length = dirents.length;
            if (i >= r0) {
                break;
            }
            try {
                if (dirents[i].getType() == 16) {
                    i++;
                }
            } catch (SmbAuthException sae) {
                logStream = log;
                if (LogStream.level > 2) {
                    sae.printStackTrace(log);
                }
            } catch (SmbException se) {
                logStream = log;
                if (LogStream.level > 2) {
                    se.printStackTrace(log);
                }
                if (se.getNtStatus() != -1073741823) {
                    break;
                    throw se;
                }
            }
            if (dirents[i].isDirectory()) {
                dirCount++;
            } else {
                fileCount++;
            }
            String name = dirents[i].getName();
            logStream = log;
            if (LogStream.level > 3) {
                log.println(i + ": " + name);
            }
            int len = name.length();
            if (len > maxLen) {
                maxLen = len;
            }
            iter = sorted.listIterator();
            int j = 0;
            while (iter.hasNext()) {
                if (sort == 0) {
                    if (compareNames(dirents[i], name, (SmbFile) iter.next()) < 0) {
                        break;
                    }
                } else if (sort == 1) {
                    if (compareSizes(dirents[i], name, (SmbFile) iter.next()) < 0) {
                        break;
                    }
                } else if (sort == 2) {
                    if (compareTypes(dirents[i], name, (SmbFile) iter.next()) < 0) {
                        break;
                    }
                } else if (sort == 3) {
                    if (compareDates(dirents[i], name, (SmbFile) iter.next()) < 0) {
                        break;
                    }
                } else {
                    continue;
                }
                j++;
            }
            sorted.add(j, dirents[i]);
            i++;
        }
        if (maxLen > 50) {
            maxLen = 50;
        }
        maxLen *= 9;
        PrintWriter out = resp.getWriter();
        resp.setContentType(NanoHTTPD.MIME_HTML);
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<html><head><title>Network Explorer</title>");
        out.println("<meta HTTP-EQUIV=\"Pragma\" CONTENT=\"no-cache\">");
        out.println("<style TYPE=\"text/css\">");
        out.println(this.style);
        length = dirents.length;
        if (r0 < 200) {
            out.println("    a:hover {");
            out.println("        background: #a2ff01;");
            out.println("    }");
        }
        out.println("</STYLE>");
        out.println("</head><body>");
        out.print("<a class=\"sort\" style=\"width: " + maxLen + ";\" href=\"?fmt=detail&sort=name\">Name</a>");
        out.println("<a class=\"sort\" href=\"?fmt=detail&sort=size\">Size</a>");
        out.println("<a class=\"sort\" href=\"?fmt=detail&sort=type\">Type</a>");
        out.println("<a class=\"sort\" style=\"width: 180\" href=\"?fmt=detail&sort=date\">Modified</a><br clear='all'><p>");
        String path = dir.getCanonicalPath();
        if (path.length() < 7) {
            out.println("<b><big>smb://</big></b><br>");
            path = ".";
        } else {
            out.println("<b><big>" + path + "</big></b><br>");
            path = "../";
        }
        out.println((dirCount + fileCount) + " objects (" + dirCount + " directories, " + fileCount + " files)<br>");
        out.println("<b><a class=\"plain\" href=\".\">normal</a> | <a class=\"plain\" href=\"?fmt=detail\">detailed</a></b>");
        out.println("<p><table border='0' cellspacing='0' cellpadding='0'><tr><td>");
        out.print("<A style=\"width: " + maxLen);
        out.print("; height: 18;\" HREF=\"");
        out.print(path);
        out.println("\"><b>&uarr;</b></a>");
        if (fmt.equals("detail")) {
            out.println("<br clear='all'>");
        }
        if (path.length() == 1 || dir.getType() != 2) {
            path = "";
        }
        iter = sorted.listIterator();
        while (iter.hasNext()) {
            SmbFile f = (SmbFile) iter.next();
            name = f.getName();
            if (fmt.equals("detail")) {
                out.print("<A style=\"width: " + maxLen);
                out.print("; height: 18;\" HREF=\"");
                out.print(path);
                out.print(name);
                if (f.isDirectory()) {
                    out.print("?fmt=detail\"><b>");
                    out.print(name);
                    out.print("</b></a>");
                } else {
                    out.print("\"><b>");
                    out.print(name);
                    out.print("</b></a><div align='right'>");
                    out.print((f.length() / 1024) + " KB </div><div>");
                    i = name.lastIndexOf(46) + 1;
                    if (i <= 1 || name.length() - i >= 6) {
                        out.print("&nbsp;</div>");
                    } else {
                        out.print(name.substring(i).toUpperCase() + "</div class='ext'>");
                    }
                    out.print("<div style='width: 180'>");
                    out.print(simpleDateFormat.format(new Date(f.lastModified())));
                    out.print("</div>");
                }
                out.println("<br clear='all'>");
            } else {
                out.print("<A style=\"width: " + maxLen);
                if (f.isDirectory()) {
                    out.print("; height: 18;\" HREF=\"");
                    out.print(path);
                    out.print(name);
                    out.print("\"><b>");
                    out.print(name);
                    out.print("</b></a>");
                } else {
                    out.print(";\" HREF=\"");
                    out.print(path);
                    out.print(name);
                    out.print("\"><b>");
                    out.print(name);
                    out.print("</b><br><small>");
                    out.print((f.length() / 1024) + "KB <br>");
                    out.print(simpleDateFormat.format(new Date(f.lastModified())));
                    out.print("</small>");
                    out.println("</a>");
                }
            }
        }
        out.println("</td></tr></table>");
        out.println("</BODY></HTML>");
        out.close();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String parseServerAndShare(java.lang.String r11) {
        /*
        r10 = this;
        r7 = 0;
        r9 = 47;
        r8 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r4 = new char[r8];
        if (r11 != 0) goto L_0x000a;
    L_0x0009:
        return r7;
    L_0x000a:
        r3 = r11.length();
        r1 = 0;
        r5 = r1;
    L_0x0010:
        if (r5 >= r3) goto L_0x001b;
    L_0x0012:
        r8 = r11.charAt(r5);
        if (r8 != r9) goto L_0x001b;
    L_0x0018:
        r5 = r5 + 1;
        goto L_0x0010;
    L_0x001b:
        if (r5 == r3) goto L_0x0009;
    L_0x001d:
        r2 = r1;
    L_0x001e:
        if (r5 >= r3) goto L_0x002e;
    L_0x0020:
        r0 = r11.charAt(r5);
        if (r0 == r9) goto L_0x002e;
    L_0x0026:
        r1 = r2 + 1;
        r4[r2] = r0;
        r5 = r5 + 1;
        r2 = r1;
        goto L_0x001e;
    L_0x002e:
        if (r5 >= r3) goto L_0x0039;
    L_0x0030:
        r7 = r11.charAt(r5);
        if (r7 != r9) goto L_0x0039;
    L_0x0036:
        r5 = r5 + 1;
        goto L_0x002e;
    L_0x0039:
        if (r5 >= r3) goto L_0x0059;
    L_0x003b:
        r1 = r2 + 1;
        r4[r2] = r9;
    L_0x003f:
        r2 = r1 + 1;
        r6 = r5 + 1;
        r0 = r11.charAt(r5);
        r4[r1] = r0;
        if (r6 >= r3) goto L_0x004d;
    L_0x004b:
        if (r0 != r9) goto L_0x0056;
    L_0x004d:
        r1 = r2;
        r5 = r6;
    L_0x004f:
        r7 = new java.lang.String;
        r8 = 0;
        r7.<init>(r4, r8, r1);
        goto L_0x0009;
    L_0x0056:
        r1 = r2;
        r5 = r6;
        goto L_0x003f;
    L_0x0059:
        r1 = r2;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.http.NetworkExplorer.parseServerAndShare(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doGet(javax.servlet.http.HttpServletRequest r29, javax.servlet.http.HttpServletResponse r30) throws java.io.IOException, javax.servlet.ServletException {
        /*
        r28 = this;
        r22 = 0;
        r17 = 1;
        r13 = 0;
        r25 = 0;
        r0 = r29;
        r1 = r25;
        r23 = r0.getSession(r1);
        r16 = r29.getPathInfo();
        if (r16 == 0) goto L_0x003b;
    L_0x0015:
        r0 = r28;
        r1 = r16;
        r22 = r0.parseServerAndShare(r1);
        if (r22 == 0) goto L_0x003b;
    L_0x001f:
        r25 = 47;
        r0 = r22;
        r1 = r25;
        r9 = r0.indexOf(r1);
        if (r9 <= 0) goto L_0x003b;
    L_0x002b:
        r25 = 0;
        r0 = r22;
        r1 = r25;
        r25 = r0.substring(r1, r9);
        r22 = r25.toLowerCase();
        r17 = 0;
    L_0x003b:
        r25 = "Authorization";
        r0 = r29;
        r1 = r25;
        r12 = r0.getHeader(r1);
        r0 = r28;
        r0 = r0.enableBasic;
        r25 = r0;
        if (r25 == 0) goto L_0x00a6;
    L_0x004d:
        r0 = r28;
        r0 = r0.insecureBasic;
        r25 = r0;
        if (r25 != 0) goto L_0x005b;
    L_0x0055:
        r25 = r29.isSecure();
        if (r25 == 0) goto L_0x00a6;
    L_0x005b:
        r14 = 1;
    L_0x005c:
        if (r12 == 0) goto L_0x01c1;
    L_0x005e:
        r25 = "NTLM ";
        r0 = r25;
        r25 = r12.startsWith(r0);
        if (r25 != 0) goto L_0x0074;
    L_0x0068:
        if (r14 == 0) goto L_0x01c1;
    L_0x006a:
        r25 = "Basic ";
        r0 = r25;
        r25 = r12.startsWith(r0);
        if (r25 == 0) goto L_0x01c1;
    L_0x0074:
        r25 = "NTLM ";
        r0 = r25;
        r25 = r12.startsWith(r0);
        if (r25 == 0) goto L_0x00b1;
    L_0x007e:
        if (r16 == 0) goto L_0x0082;
    L_0x0080:
        if (r22 != 0) goto L_0x00a8;
    L_0x0082:
        r25 = "\u0001\u0002__MSBROWSE__\u0002";
        r26 = 1;
        r27 = 0;
        r25 = jcifs.netbios.NbtAddress.getByName(r25, r26, r27);
        r11 = r25.getHostAddress();
        r5 = jcifs.UniAddress.getByName(r11);
    L_0x0094:
        r29.getSession();
        r4 = jcifs.smb.SmbSession.getChallenge(r5);
        r0 = r29;
        r1 = r30;
        r13 = jcifs.http.NtlmSsp.authenticate(r0, r1, r4);
        if (r13 != 0) goto L_0x0121;
    L_0x00a5:
        return;
    L_0x00a6:
        r14 = 0;
        goto L_0x005c;
    L_0x00a8:
        r0 = r22;
        r1 = r17;
        r5 = jcifs.UniAddress.getByName(r0, r1);
        goto L_0x0094;
    L_0x00b1:
        r3 = new java.lang.String;
        r25 = 6;
        r0 = r25;
        r25 = r12.substring(r0);
        r25 = jcifs.util.Base64.decode(r25);
        r26 = "US-ASCII";
        r0 = r25;
        r1 = r26;
        r3.<init>(r0, r1);
        r25 = 58;
        r0 = r25;
        r10 = r3.indexOf(r0);
        r25 = -1;
        r0 = r25;
        if (r10 == r0) goto L_0x01b3;
    L_0x00d6:
        r25 = 0;
        r0 = r25;
        r24 = r3.substring(r0, r10);
    L_0x00de:
        r25 = -1;
        r0 = r25;
        if (r10 == r0) goto L_0x01b7;
    L_0x00e4:
        r25 = r10 + 1;
        r0 = r25;
        r15 = r3.substring(r0);
    L_0x00ec:
        r25 = 92;
        r10 = r24.indexOf(r25);
        r25 = -1;
        r0 = r25;
        if (r10 != r0) goto L_0x00fe;
    L_0x00f8:
        r25 = 47;
        r10 = r24.indexOf(r25);
    L_0x00fe:
        r25 = -1;
        r0 = r25;
        if (r10 == r0) goto L_0x01bb;
    L_0x0104:
        r25 = 0;
        r0 = r24;
        r1 = r25;
        r6 = r0.substring(r1, r10);
    L_0x010e:
        r25 = -1;
        r0 = r25;
        if (r10 == r0) goto L_0x011a;
    L_0x0114:
        r25 = r10 + 1;
        r24 = r24.substring(r25);
    L_0x011a:
        r13 = new jcifs.smb.NtlmPasswordAuthentication;
        r0 = r24;
        r13.<init>(r6, r0, r15);
    L_0x0121:
        r25 = r29.getSession();
        r26 = new java.lang.StringBuilder;
        r26.<init>();
        r27 = "npa-";
        r26 = r26.append(r27);
        r0 = r26;
        r1 = r22;
        r26 = r0.append(r1);
        r26 = r26.toString();
        r0 = r25;
        r1 = r26;
        r0.setAttribute(r1, r13);
    L_0x0143:
        if (r13 == 0) goto L_0x0242;
    L_0x0145:
        r8 = new jcifs.smb.SmbFile;	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25 = new java.lang.StringBuilder;	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25.<init>();	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r26 = "smb:/";
        r25 = r25.append(r26);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r0 = r25;
        r1 = r16;
        r25 = r0.append(r1);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25 = r25.toString();	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r0 = r25;
        r8.<init>(r0, r13);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
    L_0x0163:
        r25 = r8.isDirectory();	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        if (r25 == 0) goto L_0x026f;
    L_0x0169:
        r0 = r28;
        r1 = r29;
        r2 = r30;
        r0.doDirectory(r1, r2, r8);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        goto L_0x00a5;
    L_0x0174:
        r21 = move-exception;
        if (r23 == 0) goto L_0x0195;
    L_0x0177:
        r25 = new java.lang.StringBuilder;
        r25.<init>();
        r26 = "npa-";
        r25 = r25.append(r26);
        r0 = r25;
        r1 = r22;
        r25 = r0.append(r1);
        r25 = r25.toString();
        r0 = r23;
        r1 = r25;
        r0.removeAttribute(r1);
    L_0x0195:
        r25 = r21.getNtStatus();
        r26 = -1073741819; // 0xffffffffc0000005 float:-2.0000012 double:NaN;
        r0 = r25;
        r1 = r26;
        if (r0 != r1) goto L_0x02f4;
    L_0x01a2:
        r25 = r29.getRequestURL();
        r25 = r25.toString();
        r0 = r30;
        r1 = r25;
        r0.sendRedirect(r1);
        goto L_0x00a5;
    L_0x01b3:
        r24 = r3;
        goto L_0x00de;
    L_0x01b7:
        r15 = "";
        goto L_0x00ec;
    L_0x01bb:
        r0 = r28;
        r6 = r0.defaultDomain;
        goto L_0x010e;
    L_0x01c1:
        r0 = r28;
        r0 = r0.credentialsSupplied;
        r25 = r0;
        if (r25 != 0) goto L_0x0143;
    L_0x01c9:
        if (r23 == 0) goto L_0x01ec;
    L_0x01cb:
        r25 = new java.lang.StringBuilder;
        r25.<init>();
        r26 = "npa-";
        r25 = r25.append(r26);
        r0 = r25;
        r1 = r22;
        r25 = r0.append(r1);
        r25 = r25.toString();
        r0 = r23;
        r1 = r25;
        r13 = r0.getAttribute(r1);
        r13 = (jcifs.smb.NtlmPasswordAuthentication) r13;
    L_0x01ec:
        if (r13 != 0) goto L_0x0143;
    L_0x01ee:
        r25 = "WWW-Authenticate";
        r26 = "NTLM";
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.setHeader(r1, r2);
        if (r14 == 0) goto L_0x0227;
    L_0x01fd:
        r25 = "WWW-Authenticate";
        r26 = new java.lang.StringBuilder;
        r26.<init>();
        r27 = "Basic realm=\"";
        r26 = r26.append(r27);
        r0 = r28;
        r0 = r0.realm;
        r27 = r0;
        r26 = r26.append(r27);
        r27 = "\"";
        r26 = r26.append(r27);
        r26 = r26.toString();
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.addHeader(r1, r2);
    L_0x0227:
        r25 = "Connection";
        r26 = "close";
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.setHeader(r1, r2);
        r25 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        r0 = r30;
        r1 = r25;
        r0.setStatus(r1);
        r30.flushBuffer();
        goto L_0x00a5;
    L_0x0242:
        if (r22 != 0) goto L_0x024f;
    L_0x0244:
        r8 = new jcifs.smb.SmbFile;	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25 = "smb://";
        r0 = r25;
        r8.<init>(r0);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        goto L_0x0163;
    L_0x024f:
        r8 = new jcifs.smb.SmbFile;	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25 = new java.lang.StringBuilder;	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25.<init>();	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r26 = "smb:/";
        r25 = r25.append(r26);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r0 = r25;
        r1 = r16;
        r25 = r0.append(r1);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r25 = r25.toString();	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        r0 = r25;
        r8.<init>(r0);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        goto L_0x0163;
    L_0x026f:
        r0 = r28;
        r1 = r29;
        r2 = r30;
        r0.doFile(r1, r2, r8);	 Catch:{ SmbAuthException -> 0x0174, DfsReferral -> 0x027a }
        goto L_0x00a5;
    L_0x027a:
        r7 = move-exception;
        r19 = r29.getRequestURL();
        r18 = r29.getQueryString();
        r20 = new java.lang.StringBuffer;
        r25 = 0;
        r26 = r19.length();
        r27 = r29.getPathInfo();
        r27 = r27.length();
        r26 = r26 - r27;
        r0 = r19;
        r1 = r25;
        r2 = r26;
        r25 = r0.substring(r1, r2);
        r0 = r20;
        r1 = r25;
        r0.<init>(r1);
        r25 = 47;
        r0 = r20;
        r1 = r25;
        r0.append(r1);
        r0 = r7.server;
        r25 = r0;
        r0 = r20;
        r1 = r25;
        r0.append(r1);
        r25 = 47;
        r0 = r20;
        r1 = r25;
        r0.append(r1);
        r0 = r7.share;
        r25 = r0;
        r0 = r20;
        r1 = r25;
        r0.append(r1);
        r25 = 47;
        r0 = r20;
        r1 = r25;
        r0.append(r1);
        if (r18 == 0) goto L_0x02e4;
    L_0x02d9:
        r25 = r29.getQueryString();
        r0 = r20;
        r1 = r25;
        r0.append(r1);
    L_0x02e4:
        r25 = r20.toString();
        r0 = r30;
        r1 = r25;
        r0.sendRedirect(r1);
        r30.flushBuffer();
        goto L_0x00a5;
    L_0x02f4:
        r25 = "WWW-Authenticate";
        r26 = "NTLM";
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.setHeader(r1, r2);
        if (r14 == 0) goto L_0x032d;
    L_0x0303:
        r25 = "WWW-Authenticate";
        r26 = new java.lang.StringBuilder;
        r26.<init>();
        r27 = "Basic realm=\"";
        r26 = r26.append(r27);
        r0 = r28;
        r0 = r0.realm;
        r27 = r0;
        r26 = r26.append(r27);
        r27 = "\"";
        r26 = r26.append(r27);
        r26 = r26.toString();
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.addHeader(r1, r2);
    L_0x032d:
        r25 = "Connection";
        r26 = "close";
        r0 = r30;
        r1 = r25;
        r2 = r26;
        r0.setHeader(r1, r2);
        r25 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        r0 = r30;
        r1 = r25;
        r0.setStatus(r1);
        r30.flushBuffer();
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: jcifs.http.NetworkExplorer.doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse):void");
    }
}
