package com.google.android.youtube.player.internal;

import android.text.TextUtils;

public final class ab {
    public static <T> T m25a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static <T> T m26a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String m27a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void m28a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
