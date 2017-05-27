package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.C0056b;

public class YouTubeBaseActivity extends Activity {
    private C0337a f2a;
    private YouTubePlayerView f3b;
    private int f4c;
    private Bundle f5d;

    /* renamed from: com.google.android.youtube.player.YouTubeBaseActivity.a */
    private final class C0337a implements C0056b {
        final /* synthetic */ YouTubeBaseActivity f77a;

        private C0337a(YouTubeBaseActivity youTubeBaseActivity) {
            this.f77a = youTubeBaseActivity;
        }

        public final void m144a(YouTubePlayerView youTubePlayerView) {
            if (!(this.f77a.f3b == null || this.f77a.f3b == youTubePlayerView)) {
                this.f77a.f3b.m176c(true);
            }
            this.f77a.f3b = youTubePlayerView;
            if (this.f77a.f4c > 0) {
                youTubePlayerView.m170a();
            }
            if (this.f77a.f4c >= 2) {
                youTubePlayerView.m173b();
            }
        }

        public final void m145a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            youTubePlayerView.m171a(this.f77a, youTubePlayerView, str, onInitializedListener, this.f77a.f5d);
            this.f77a.f5d = null;
        }
    }

    final C0056b m6a() {
        return this.f2a;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2a = new C0337a();
        this.f5d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    protected void onDestroy() {
        if (this.f3b != null) {
            this.f3b.m174b(isFinishing());
        }
        super.onDestroy();
    }

    protected void onPause() {
        this.f4c = 1;
        if (this.f3b != null) {
            this.f3b.m175c();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f4c = 2;
        if (this.f3b != null) {
            this.f3b.m173b();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", this.f3b != null ? this.f3b.m178e() : this.f5d);
    }

    protected void onStart() {
        super.onStart();
        this.f4c = 1;
        if (this.f3b != null) {
            this.f3b.m170a();
        }
    }

    protected void onStop() {
        this.f4c = 0;
        if (this.f3b != null) {
            this.f3b.m177d();
        }
        super.onStop();
    }
}
