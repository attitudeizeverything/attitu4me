package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import com.google.android.youtube.player.internal.C0081w.C0080a;

public abstract class aa {
    private static final aa f17a;

    static {
        f17a = m21b();
    }

    public static aa m20a() {
        return f17a;
    }

    private static aa m21b() {
        try {
            return (aa) Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(aa.class).newInstance();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        } catch (ClassNotFoundException e3) {
            return new ac();
        }
    }

    public abstract C0343a m22a(C0344b c0344b, YouTubeThumbnailView youTubeThumbnailView);

    public abstract C0344b m23a(Context context, String str, C0076a c0076a, C0077b c0077b);

    public abstract C0058d m24a(Activity activity, C0344b c0344b, boolean z) throws C0080a;
}
