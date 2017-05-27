package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.youtube.player.internal.m */
public final class C0067m {
    public final String f18a;
    public final String f19b;
    public final String f20c;
    public final String f21d;
    public final String f22e;
    public final String f23f;
    public final String f24g;
    public final String f25h;
    public final String f26i;
    public final String f27j;

    public C0067m(Context context) {
        Resources resources = context.getResources();
        Locale locale = (resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale;
        Map a = C0082x.m114a(locale);
        this.f18a = (String) a.get("error_initializing_player");
        this.f19b = (String) a.get("get_youtube_app_title");
        this.f20c = (String) a.get("get_youtube_app_text");
        this.f21d = (String) a.get("get_youtube_app_action");
        this.f22e = (String) a.get("enable_youtube_app_title");
        this.f23f = (String) a.get("enable_youtube_app_text");
        this.f24g = (String) a.get("enable_youtube_app_action");
        this.f25h = (String) a.get("update_youtube_app_title");
        this.f26i = (String) a.get("update_youtube_app_text");
        this.f27j = (String) a.get("update_youtube_app_action");
    }
}
