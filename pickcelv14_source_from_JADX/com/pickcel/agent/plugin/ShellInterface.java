package com.pickcel.agent.plugin;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jcifs.smb.SmbNamedPipe;

public class ShellInterface {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$pickcel$agent$plugin$ShellInterface$OUTPUT = null;
    private static final String EXIT = "exit\n";
    private static final String[] SU_COMMANDS;
    private static final String TAG = "ShellInterface";
    private static final String[] TEST_COMMANDS;
    private static final Pattern UID_PATTERN;
    private static String shell;

    private static class InputStreamHandler extends Thread {
        StringBuffer output;
        private final boolean sink;
        private final InputStream stream;

        public String getOutput() {
            return this.output.toString();
        }

        InputStreamHandler(InputStream stream, boolean sink) {
            this.sink = sink;
            this.stream = stream;
            start();
        }

        public void run() {
            try {
                if (this.sink) {
                    do {
                    } while (this.stream.read() != -1);
                    return;
                }
                this.output = new StringBuffer();
                BufferedReader b = new BufferedReader(new InputStreamReader(this.stream));
                while (true) {
                    String s = b.readLine();
                    if (s != null) {
                        this.output.append(s);
                    } else {
                        return;
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    enum OUTPUT {
        STDOUT,
        STDERR,
        BOTH
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$pickcel$agent$plugin$ShellInterface$OUTPUT() {
        int[] iArr = $SWITCH_TABLE$com$pickcel$agent$plugin$ShellInterface$OUTPUT;
        if (iArr == null) {
            iArr = new int[OUTPUT.values().length];
            try {
                iArr[OUTPUT.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OUTPUT.STDERR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OUTPUT.STDOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$pickcel$agent$plugin$ShellInterface$OUTPUT = iArr;
        }
        return iArr;
    }

    static {
        UID_PATTERN = Pattern.compile("^uid=(\\d+).*?");
        SU_COMMANDS = new String[]{"su", "/system/xbin/su", "/system/bin/su"};
        TEST_COMMANDS = new String[]{"id", "/system/xbin/id", "/system/bin/id"};
    }

    public static synchronized boolean isSuAvailable() {
        boolean z;
        synchronized (ShellInterface.class) {
            if (shell == null) {
                checkSu();
            }
            z = shell != null;
        }
        return z;
    }

    public static synchronized void setShell(String shell) {
        synchronized (ShellInterface.class) {
            shell = shell;
        }
    }

    private static boolean checkSu() {
        for (String command : SU_COMMANDS) {
            shell = command;
            if (isRootUid()) {
                return true;
            }
        }
        shell = null;
        return false;
    }

    private static boolean isRootUid() {
        String out = null;
        for (String command : TEST_COMMANDS) {
            out = getProcessOutput(command);
            if (out != null && out.length() > 0) {
                break;
            }
        }
        if (out == null || out.length() == 0) {
            return false;
        }
        Matcher matcher = UID_PATTERN.matcher(out);
        if (matcher.matches() && "0".equals(matcher.group(1))) {
            return true;
        }
        return false;
    }

    public static String getProcessOutput(String command) {
        try {
            return _runCommand(command, OUTPUT.STDERR);
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean runCommand(String command) {
        try {
            _runCommand(command, OUTPUT.BOTH);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String _runCommand(String command, OUTPUT o) throws IOException {
        Exception e;
        String msg;
        Throwable th;
        DataOutputStream os = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(shell);
            DataOutputStream os2 = new DataOutputStream(process.getOutputStream());
            try {
                InputStreamHandler sh = sinkProcessOutput(process, o);
                os2.writeBytes(new StringBuilder(String.valueOf(command)).append('\n').toString());
                os2.flush();
                os2.writeBytes(EXIT);
                os2.flush();
                process.waitFor();
                if (sh != null) {
                    String output = sh.getOutput();
                    Log.d(TAG, new StringBuilder(String.valueOf(command)).append(" output: ").append(output).toString());
                    if (os2 != null) {
                        try {
                            os2.close();
                        } catch (Exception e2) {
                            return output;
                        }
                    }
                    if (process == null) {
                        return output;
                    }
                    process.destroy();
                    return output;
                }
                if (os2 != null) {
                    try {
                        os2.close();
                    } catch (Exception e3) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return null;
            } catch (Exception e4) {
                e = e4;
                os = os2;
                try {
                    msg = e.getMessage();
                    Log.e(TAG, "runCommand error: " + msg);
                    throw new IOException(msg);
                } catch (Throwable th2) {
                    th = th2;
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception e5) {
                            throw th;
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                os = os2;
                if (os != null) {
                    os.close();
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            msg = e.getMessage();
            Log.e(TAG, "runCommand error: " + msg);
            throw new IOException(msg);
        }
    }

    public static InputStreamHandler sinkProcessOutput(Process p, OUTPUT o) {
        InputStreamHandler output;
        InputStreamHandler inputStreamHandler;
        switch ($SWITCH_TABLE$com$pickcel$agent$plugin$ShellInterface$OUTPUT()[o.ordinal()]) {
            case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                output = new InputStreamHandler(p.getErrorStream(), false);
                inputStreamHandler = new InputStreamHandler(p.getInputStream(), true);
                return output;
            case SmbNamedPipe.PIPE_TYPE_WRONLY /*2*/:
                output = new InputStreamHandler(p.getInputStream(), false);
                inputStreamHandler = new InputStreamHandler(p.getErrorStream(), true);
                return output;
            case SmbNamedPipe.PIPE_TYPE_RDWR /*3*/:
                inputStreamHandler = new InputStreamHandler(p.getInputStream(), true);
                inputStreamHandler = new InputStreamHandler(p.getErrorStream(), true);
                return null;
            default:
                return null;
        }
    }
}
