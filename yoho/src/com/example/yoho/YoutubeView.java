package com.example.yoho;

import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeView extends YouTubeBaseActivity implements OnInitializedListener {
    public static final String API_KEY = "AIzaSyDWzRJOluIZeKCnoQX46hm1mqtXQGGuHMA";
    public static String VIDEO_ID;
    private static final Object mSingletonLock;
    private PlaybackEventListener playbackEventListener;
    private PlayerStateChangeListener playerStateChangeListener;
    YouTubePlayerView youTubePlayerView;

    /* renamed from: com.pickcel.agent.YoutubeView.1 */
    class C04111 implements PlaybackEventListener {
        C04111() {
        }

        public void onBuffering(boolean arg0) {
        }

        public void onPaused() {
        }

        public void onPlaying() {
        }

        public void onSeekTo(int arg0) {
        }

        public void onStopped() {
        }
    }

    /* renamed from: com.pickcel.agent.YoutubeView.2 */
    class C04122 implements PlayerStateChangeListener {
        C04122() {
        }

        public void onAdStarted() {
        }

        public void onError(ErrorReason arg0) {
        }

        public void onLoaded(String arg0) {
        }

        public void onLoading() {
        }

        public void onVideoEnded() {
        }

        public void onVideoStarted() {
        }
    }

    public YoutubeView() {
        this.playbackEventListener = new C04111();
        this.playerStateChangeListener = new C04122();
    }

    static {
        mSingletonLock = new Object();
        VIDEO_ID = "1YnlX4CkPDY";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0253R.layout.youtube_view);
        AudioManager mAudioManager = (AudioManager) getSystemService("audio");
        int originalVolume = mAudioManager.getStreamVolume(3);
        mAudioManager.setStreamVolume(3, mAudioManager.getStreamMaxVolume(3), 0);
        VIDEO_ID = getIntent().getExtras().getString("url_path");
        this.youTubePlayerView = (YouTubePlayerView) findViewById(C0253R.id.youtube_player);
        this.youTubePlayerView.initialize(API_KEY, this);
    }

    public void onInitializationFailure(Provider provider, YouTubeInitializationResult arg1) {
        Toast.makeText(this, "Failured to Initialize!", 1).show();
    }

    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(this.playerStateChangeListener);
        player.setPlaybackEventListener(this.playbackEventListener);
        if (!wasRestored) {
            if (player.isPlaying()) {
                player.release();
            }
            player.loadVideo(VIDEO_ID);
            player.setPlayerStyle(PlayerStyle.MINIMAL);
            player.setFullscreen(true);
            player.setManageAudioFocus(true);
        }
    }
}
