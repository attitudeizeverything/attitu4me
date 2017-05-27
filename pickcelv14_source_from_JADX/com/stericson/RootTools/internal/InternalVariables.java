package com.stericson.RootTools.internal;

import com.stericson.RootTools.containers.Mount;
import com.stericson.RootTools.containers.Permissions;
import com.stericson.RootTools.containers.Symlink;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InternalVariables {
    protected static final String PS_REGEX = "^\\S+\\s+([0-9]+).*$";
    protected static boolean accessGiven;
    protected static String busyboxVersion;
    protected static boolean found;
    protected static String getSpaceFor;
    protected static String inode;
    protected static ArrayList<Mount> mounts;
    protected static boolean nativeToolsReady;
    protected static Set<String> path;
    protected static Permissions permissions;
    protected static Pattern psPattern;
    protected static List<String> results;
    protected static String[] space;
    protected static ArrayList<Symlink> symlinks;

    static {
        accessGiven = false;
        nativeToolsReady = false;
        found = false;
        inode = "";
        psPattern = Pattern.compile(PS_REGEX);
    }
}
