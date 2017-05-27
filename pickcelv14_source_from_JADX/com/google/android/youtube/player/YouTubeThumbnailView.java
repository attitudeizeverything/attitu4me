package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import com.google.android.youtube.player.internal.C0343a;
import com.google.android.youtube.player.internal.C0344b;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;

public final class YouTubeThumbnailView extends ImageView {
    private C0344b f15a;
    private C0343a f16b;

    public interface OnInitializedListener {
        void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult);

        void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader);
    }

    /* renamed from: com.google.android.youtube.player.YouTubeThumbnailView.a */
    private static final class C0342a implements C0076a, C0077b {
        private YouTubeThumbnailView f107a;
        private OnInitializedListener f108b;

        public C0342a(YouTubeThumbnailView youTubeThumbnailView, OnInitializedListener onInitializedListener) {
            this.f107a = (YouTubeThumbnailView) ab.m26a((Object) youTubeThumbnailView, (Object) "thumbnailView cannot be null");
            this.f108b = (OnInitializedListener) ab.m26a((Object) onInitializedListener, (Object) "onInitializedlistener cannot be null");
        }

        private void m179c() {
            if (this.f107a != null) {
                this.f107a.f15a = null;
                this.f107a = null;
                this.f108b = null;
            }
        }

        public final void m180a() {
            if (this.f107a != null && this.f107a.f15a != null) {
                this.f107a.f16b = aa.m20a().m22a(this.f107a.f15a, this.f107a);
                this.f108b.onInitializationSuccess(this.f107a, this.f107a.f16b);
                m179c();
            }
        }

        public final void m181a(YouTubeInitializationResult youTubeInitializationResult) {
            this.f108b.onInitializationFailure(this.f107a, youTubeInitializationResult);
            m179c();
        }

        public final void m182b() {
            m179c();
        }
    }

    public YouTubeThumbnailView(Context context) {
        this(context, null);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void finalize() throws Throwable {
        if (this.f16b != null) {
            this.f16b.m188b();
            this.f16b = null;
        }
        super.finalize();
    }

    public final void initialize(String str, OnInitializedListener onInitializedListener) {
        Object c0342a = new C0342a(this, onInitializedListener);
        this.f15a = aa.m20a().m23a(getContext(), str, c0342a, c0342a);
        this.f15a.m110e();
    }
}
