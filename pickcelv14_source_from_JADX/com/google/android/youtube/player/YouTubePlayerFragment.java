package com.google.android.youtube.player;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.C0056b;
import com.google.android.youtube.player.internal.ab;

public class YouTubePlayerFragment extends Fragment implements Provider {
    private final C0338a f79a;
    private Bundle f80b;
    private YouTubePlayerView f81c;
    private String f82d;
    private OnInitializedListener f83e;
    private boolean f84f;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerFragment.a */
    private final class C0338a implements C0056b {
        final /* synthetic */ YouTubePlayerFragment f78a;

        private C0338a(YouTubePlayerFragment youTubePlayerFragment) {
            this.f78a = youTubePlayerFragment;
        }

        public final void m146a(YouTubePlayerView youTubePlayerView) {
        }

        public final void m147a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            this.f78a.initialize(str, this.f78a.f83e);
        }
    }

    public YouTubePlayerFragment() {
        this.f79a = new C0338a();
    }

    private void m149a() {
        if (this.f81c != null && this.f83e != null) {
            this.f81c.m172a(this.f84f);
            this.f81c.m171a(getActivity(), this, this.f82d, this.f83e, this.f80b);
            this.f80b = null;
            this.f83e = null;
        }
    }

    public static YouTubePlayerFragment newInstance() {
        return new YouTubePlayerFragment();
    }

    public void initialize(String str, OnInitializedListener onInitializedListener) {
        this.f82d = ab.m27a(str, (Object) "Developer key cannot be null or empty");
        this.f83e = onInitializedListener;
        m149a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f80b = bundle != null ? bundle.getBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f81c = new YouTubePlayerView(getActivity(), null, 0, this.f79a);
        m149a();
        return this.f81c;
    }

    public void onDestroy() {
        if (this.f81c != null) {
            Activity activity = getActivity();
            YouTubePlayerView youTubePlayerView = this.f81c;
            boolean z = activity == null || activity.isFinishing();
            youTubePlayerView.m174b(z);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f81c.m176c(getActivity().isFinishing());
        this.f81c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.f81c.m175c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f81c.m173b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE", this.f81c != null ? this.f81c.m178e() : this.f80b);
    }

    public void onStart() {
        super.onStart();
        this.f81c.m170a();
    }

    public void onStop() {
        this.f81c.m177d();
        super.onStop();
    }
}
