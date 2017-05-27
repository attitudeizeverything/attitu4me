package com.stericson.RootTools.execution;

import com.stericson.RootTools.RootTools;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.io.OutputStreamWriter;

public abstract class Command {
    final String[] command;
    int exitCode;
    boolean finished;
    int id;
    int timeout;

    public abstract void output(int i, String str);

    public Command(int id, String... command) {
        this.finished = false;
        this.id = 0;
        this.timeout = NanoHTTPD.SOCKET_READ_TIMEOUT;
        this.command = command;
        this.id = id;
    }

    public Command(int id, int timeout, String... command) {
        this.finished = false;
        this.id = 0;
        this.timeout = NanoHTTPD.SOCKET_READ_TIMEOUT;
        this.command = command;
        this.id = id;
        this.timeout = timeout;
    }

    public String getCommand() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.command) {
            sb.append(append);
            sb.append('\n');
        }
        RootTools.log("Sending command(s): " + sb.toString());
        return sb.toString();
    }

    public void writeCommand(OutputStreamWriter out) throws IOException {
        out.write(getCommand());
    }

    public void commandFinished(int id) {
        RootTools.log("Command " + id + "finished.");
    }

    public void setExitCode(int code) {
        synchronized (this) {
            this.exitCode = code;
            this.finished = true;
            commandFinished(this.id);
            notifyAll();
        }
    }

    public void terminate(String reason) {
        try {
            Shell.closeAll();
            RootTools.log("Terminating all shells.");
            terminated(reason);
        } catch (IOException e) {
        }
    }

    public void terminated(String reason) {
        setExitCode(-1);
        RootTools.log("Command " + this.id + " did not finish.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitForFinish(int r3) throws java.lang.InterruptedException {
        /*
        r2 = this;
        monitor-enter(r2);
    L_0x0001:
        r0 = r2.finished;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x001e;
    L_0x0005:
        r0 = (long) r3;	 Catch:{ all -> 0x001b }
        r2.wait(r0);	 Catch:{ all -> 0x001b }
        r0 = r2.finished;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0001;
    L_0x000d:
        r0 = 1;
        r2.finished = r0;	 Catch:{ all -> 0x001b }
        r0 = "Timeout Exception has occurred.";
        com.stericson.RootTools.RootTools.log(r0);	 Catch:{ all -> 0x001b }
        r0 = "Timeout Exception";
        r2.terminate(r0);	 Catch:{ all -> 0x001b }
        goto L_0x0001;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        throw r0;
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootTools.execution.Command.waitForFinish(int):void");
    }

    public int exitCode(int timeout) throws InterruptedException {
        synchronized (this) {
            waitForFinish(timeout);
        }
        return this.exitCode;
    }

    public void waitForFinish() throws InterruptedException {
        synchronized (this) {
            waitForFinish(this.timeout);
        }
    }

    public int exitCode() throws InterruptedException {
        int exitCode;
        synchronized (this) {
            exitCode = exitCode(this.timeout);
        }
        return exitCode;
    }
}
