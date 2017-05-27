package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener;
import com.google.android.youtube.player.internal.C0059e.C0350a;
import com.google.android.youtube.player.internal.C0060f.C0352a;
import com.google.android.youtube.player.internal.C0061g.C0354a;
import com.google.android.youtube.player.internal.C0062h.C0356a;
import java.util.List;

/* renamed from: com.google.android.youtube.player.internal.s */
public final class C0367s implements YouTubePlayer {
    private C0344b f137a;
    private C0058d f138b;

    /* renamed from: com.google.android.youtube.player.internal.s.1 */
    class C04481 extends C0350a {
        final /* synthetic */ OnFullscreenListener f156a;
        final /* synthetic */ C0367s f157b;

        C04481(C0367s c0367s, OnFullscreenListener onFullscreenListener) {
            this.f157b = c0367s;
            this.f156a = onFullscreenListener;
        }

        public final void m339a(boolean z) {
            this.f156a.onFullscreen(z);
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.2 */
    class C04492 extends C0356a {
        final /* synthetic */ PlaylistEventListener f158a;
        final /* synthetic */ C0367s f159b;

        C04492(C0367s c0367s, PlaylistEventListener playlistEventListener) {
            this.f159b = c0367s;
            this.f158a = playlistEventListener;
        }

        public final void m340a() {
            this.f158a.onPrevious();
        }

        public final void m341b() {
            this.f158a.onNext();
        }

        public final void m342c() {
            this.f158a.onPlaylistEnded();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.3 */
    class C04503 extends C0354a {
        final /* synthetic */ PlayerStateChangeListener f160a;
        final /* synthetic */ C0367s f161b;

        C04503(C0367s c0367s, PlayerStateChangeListener playerStateChangeListener) {
            this.f161b = c0367s;
            this.f160a = playerStateChangeListener;
        }

        public final void m343a() {
            this.f160a.onLoading();
        }

        public final void m344a(String str) {
            this.f160a.onLoaded(str);
        }

        public final void m345b() {
            this.f160a.onAdStarted();
        }

        public final void m346b(String str) {
            ErrorReason valueOf;
            try {
                valueOf = ErrorReason.valueOf(str);
            } catch (IllegalArgumentException e) {
                valueOf = ErrorReason.UNKNOWN;
            } catch (NullPointerException e2) {
                valueOf = ErrorReason.UNKNOWN;
            }
            this.f160a.onError(valueOf);
        }

        public final void m347c() {
            this.f160a.onVideoStarted();
        }

        public final void m348d() {
            this.f160a.onVideoEnded();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.4 */
    class C04514 extends C0352a {
        final /* synthetic */ PlaybackEventListener f162a;
        final /* synthetic */ C0367s f163b;

        C04514(C0367s c0367s, PlaybackEventListener playbackEventListener) {
            this.f163b = c0367s;
            this.f162a = playbackEventListener;
        }

        public final void m349a() {
            this.f162a.onPlaying();
        }

        public final void m350a(int i) {
            this.f162a.onSeekTo(i);
        }

        public final void m351a(boolean z) {
            this.f162a.onBuffering(z);
        }

        public final void m352b() {
            this.f162a.onPaused();
        }

        public final void m353c() {
            this.f162a.onStopped();
        }
    }

    public C0367s(C0344b c0344b, C0058d c0058d) {
        this.f137a = (C0344b) ab.m26a((Object) c0344b, (Object) "connectionClient cannot be null");
        this.f138b = (C0058d) ab.m26a((Object) c0058d, (Object) "embeddedPlayer cannot be null");
    }

    public final View m300a() {
        try {
            return (View) C0452v.m355a(this.f138b.m72s());
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m301a(Configuration configuration) {
        try {
            this.f138b.m32a(configuration);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m302a(boolean z) {
        try {
            this.f138b.m41a(z);
            this.f137a.m201a(z);
            this.f137a.m109d();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean m303a(int i, KeyEvent keyEvent) {
        try {
            return this.f138b.m42a(i, keyEvent);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean m304a(Bundle bundle) {
        try {
            return this.f138b.m43a(bundle);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void addFullscreenControlFlag(int i) {
        try {
            this.f138b.m54d(i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m305b() {
        try {
            this.f138b.m66m();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m306b(boolean z) {
        try {
            this.f138b.m57e(z);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean m307b(int i, KeyEvent keyEvent) {
        try {
            return this.f138b.m50b(i, keyEvent);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m308c() {
        try {
            this.f138b.m67n();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void cuePlaylist(String str) {
        cuePlaylist(str, 0, 0);
    }

    public final void cuePlaylist(String str, int i, int i2) {
        try {
            this.f138b.m39a(str, i, i2);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void cueVideo(String str) {
        cueVideo(str, 0);
    }

    public final void cueVideo(String str, int i) {
        try {
            this.f138b.m38a(str, i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void cueVideos(List<String> list) {
        cueVideos(list, 0, 0);
    }

    public final void cueVideos(List<String> list, int i, int i2) {
        try {
            this.f138b.m40a((List) list, i, i2);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m309d() {
        try {
            this.f138b.m68o();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m310e() {
        try {
            this.f138b.m69p();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m311f() {
        try {
            this.f138b.m70q();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void m312g() {
        try {
            this.f138b.m65l();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.f138b.m61h();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.f138b.m62i();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final int getFullscreenControlFlags() {
        try {
            return this.f138b.m63j();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final Bundle m313h() {
        try {
            return this.f138b.m71r();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean hasNext() {
        try {
            return this.f138b.m56d();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.f138b.m58e();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final boolean isPlaying() {
        try {
            return this.f138b.m53c();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void loadPlaylist(String str) {
        loadPlaylist(str, 0, 0);
    }

    public final void loadPlaylist(String str, int i, int i2) {
        try {
            this.f138b.m47b(str, i, i2);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void loadVideo(String str) {
        loadVideo(str, 0);
    }

    public final void loadVideo(String str, int i) {
        try {
            this.f138b.m46b(str, i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void loadVideos(List<String> list) {
        loadVideos(list, 0, 0);
    }

    public final void loadVideos(List<String> list, int i, int i2) {
        try {
            this.f138b.m48b((List) list, i, i2);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void next() {
        try {
            this.f138b.m59f();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void pause() {
        try {
            this.f138b.m44b();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void play() {
        try {
            this.f138b.m30a();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void previous() {
        try {
            this.f138b.m60g();
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void release() {
        m302a(true);
    }

    public final void seekRelativeMillis(int i) {
        try {
            this.f138b.m45b(i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void seekToMillis(int i) {
        try {
            this.f138b.m31a(i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setFullscreen(boolean z) {
        try {
            this.f138b.m49b(z);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setFullscreenControlFlags(int i) {
        try {
            this.f138b.m51c(i);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setManageAudioFocus(boolean z) {
        try {
            this.f138b.m55d(z);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setOnFullscreenListener(OnFullscreenListener onFullscreenListener) {
        try {
            this.f138b.m33a(new C04481(this, onFullscreenListener));
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setPlaybackEventListener(PlaybackEventListener playbackEventListener) {
        try {
            this.f138b.m34a(new C04514(this, playbackEventListener));
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setPlayerStateChangeListener(PlayerStateChangeListener playerStateChangeListener) {
        try {
            this.f138b.m35a(new C04503(this, playerStateChangeListener));
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setPlayerStyle(PlayerStyle playerStyle) {
        try {
            this.f138b.m37a(playerStyle.name());
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setPlaylistEventListener(PlaylistEventListener playlistEventListener) {
        try {
            this.f138b.m36a(new C04492(this, playlistEventListener));
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }

    public final void setShowFullscreenButton(boolean z) {
        try {
            this.f138b.m52c(z);
        } catch (RemoteException e) {
            throw new C0071q(e);
        }
    }
}
