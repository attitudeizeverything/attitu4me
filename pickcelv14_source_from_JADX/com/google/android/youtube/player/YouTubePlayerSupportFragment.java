package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.C0056b;
import com.google.android.youtube.player.internal.ab;

public class YouTubePlayerSupportFragment extends Fragment implements Provider {
    private final C0339a f86a;
    private Bundle f87b;
    private YouTubePlayerView f88c;
    private String f89d;
    private OnInitializedListener f90e;
    private boolean f91f;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerSupportFragment.a */
    private final class C0339a implements C0056b {
        final /* synthetic */ YouTubePlayerSupportFragment f85a;

        private C0339a(YouTubePlayerSupportFragment youTubePlayerSupportFragment) {
            this.f85a = youTubePlayerSupportFragment;
        }

        public final void m150a(YouTubePlayerView youTubePlayerView) {
        }

        public final void m151a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            this.f85a.initialize(str, this.f85a.f90e);
        }
    }

    public YouTubePlayerSupportFragment() {
        this.f86a = new C0339a();
    }

    private void m153a() {
        if (this.f88c != null && this.f90e != null) {
            this.f88c.m172a(this.f91f);
            this.f88c.m171a(getActivity(), this, this.f89d, this.f90e, this.f87b);
            this.f87b = null;
            this.f90e = null;
        }
    }

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    public void initialize(String str, OnInitializedListener onInitializedListener) {
        this.f89d = ab.m27a(str, (Object) "Developer key cannot be null or empty");
        this.f90e = onInitializedListener;
        m153a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f87b = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f88c = new YouTubePlayerView(getActivity(), null, 0, this.f86a);
        m153a();
        return this.f88c;
    }

    public void onDestroy() {
        if (this.f88c != null) {
            Activity activity = getActivity();
            YouTubePlayerView youTubePlayerView = this.f88c;
            boolean z = activity == null || activity.isFinishing();
            youTubePlayerView.m174b(z);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f88c.m176c(getActivity().isFinishing());
        this.f88c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.f88c.m175c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f88c.m173b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", this.f88c != null ? this.f88c.m178e() : this.f87b);
    }

    public void onStart() {
        super.onStart();
        this.f88c.m170a();
    }

    public void onStop() {
        this.f88c.m177d();
        super.onStop();
    }
}
