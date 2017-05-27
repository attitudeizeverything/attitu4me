package com.mstar.android.samba;

public class SmbAuthentication {
    public static final SmbAuthentication ANONYMOUS;
    private String passwd;
    private String username;

    static {
        ANONYMOUS = null;
    }

    public SmbAuthentication(String username, String password) {
        if (username == null) {
            this.username = " ";
        } else {
            this.username = username;
        }
        if (password == null) {
            this.passwd = "";
        } else {
            this.passwd = password;
        }
    }

    public String getName() {
        return this.username;
    }

    public String getPassword() {
        return this.passwd;
    }
}
