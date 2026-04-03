package com.example.mockcard.service;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;

import android.support.v4.media.session.MediaSessionCompat;

import com.example.mockcard.player.MockPlayerController;
import com.example.mockcard.player.MockSong;

public final class MediaSessionController {
    private static MediaSession mediaSession;

    private MediaSessionController() {
    }

    public static synchronized void init(Context context) {
        if (mediaSession != null) {
            return;
        }
        Context appContext = context.getApplicationContext();
        mediaSession = new MediaSession(appContext, "mock-media-session");
        mediaSession.setCallback(new MediaSession.Callback() {
            @Override
            public void onPlay() {
                MockPlayerController.play();
            }

            @Override
            public void onPause() {
                MockPlayerController.pause();
            }

            @Override
            public void onSkipToNext() {
                MockPlayerController.nextSong();
            }

            @Override
            public void onSkipToPrevious() {
                MockPlayerController.prevSong();
            }
        });
        mediaSession.setActive(true);
        syncNow();
    }

    public static synchronized void syncNow() {
        if (mediaSession == null) {
            return;
        }
        MockSong song = MockPlayerController.current();
        int[] pd = MockPlayerController.positionAndDuration();

        PlaybackState.Builder ps = new PlaybackState.Builder();
        ps.setActions(
                PlaybackState.ACTION_PLAY
                        | PlaybackState.ACTION_PAUSE
                        | PlaybackState.ACTION_SKIP_TO_NEXT
                        | PlaybackState.ACTION_SKIP_TO_PREVIOUS
                        | PlaybackState.ACTION_PLAY_PAUSE
        );

        int state = MockPlayerController.isPlaying() ? PlaybackState.STATE_PLAYING : PlaybackState.STATE_PAUSED;
        ps.setState(state, pd[0], 1.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            ps.setBufferedPosition(pd[0]);
        }
        mediaSession.setPlaybackState(ps.build());

        MediaMetadata.Builder md = new MediaMetadata.Builder();
        if (song != null) {
            md.putString(MediaMetadata.METADATA_KEY_TITLE, song.title);
            md.putString(MediaMetadata.METADATA_KEY_ARTIST, song.artist);
            md.putLong(MediaMetadata.METADATA_KEY_DURATION, song.durationMs);
        }
        mediaSession.setMetadata(md.build());
    }

    public static synchronized MediaSession.Token token() {
        if (mediaSession == null) {
            return null;
        }
        return mediaSession.getSessionToken();
    }

    public static synchronized MediaSessionCompat.Token compatToken() {
        if (mediaSession == null) {
            return null;
        }
        return MediaSessionCompat.Token.fromToken(mediaSession.getSessionToken());
    }

    public static AudioAttributes notificationAudioAttributes() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
    }
}
