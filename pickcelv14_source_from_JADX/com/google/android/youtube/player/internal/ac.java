package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import com.google.android.youtube.player.internal.C0081w.C0080a;

public final class ac extends aa {
    public final C0343a m196a(C0344b c0344b, YouTubeThumbnailView youTubeThumbnailView) {
        return new C0446p(c0344b, youTubeThumbnailView);
    }

    public final C0344b m197a(Context context, String str, C0076a c0076a, C0077b c0077b) {
        return new C0444o(context, str, context.getPackageName(), C0084z.m127d(context), c0076a, c0077b);
    }

    public final C0058d m198a(Activity activity, C0344b c0344b, boolean z) throws C0080a {
        return C0081w.m113a(activity, c0344b.m199a(), z);
    }
}
