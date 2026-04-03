package com.example.mockcard.player;

import android.content.Context;
import android.content.Intent;

import com.example.mockcard.service.MediaSessionController;
import com.example.mockcard.widget.MusicCardAppWidgetProvider;

import java.util.ArrayList;
import java.util.List;

public final class MockPlayerController {
    public static final String ACTION_META_CHANGED = "com.example.mockcard.ACTION_META_CHANGED";
    public static final String ACTION_PLAY_STATE_CHANGED = "com.example.mockcard.ACTION_PLAY_STATE_CHANGED";
    public static final String EXTRA_IS_PLAYING = "arg_is_playing";

    private static Context appContext;
    private static final List<MockSong> queue = new ArrayList<>();
    private static int index = 0;
    private static boolean playing = false;
    private static int progressMs = 0;

    private MockPlayerController() {
    }

    public static void init(Context context) {
        appContext = context.getApplicationContext();
        if (queue.isEmpty()) {
            queue.add(new MockSong(1, "First Light", "Mock Artist A", 180000));
            queue.add(new MockSong(2, "Blue Circuit", "Mock Artist B", 210000));
            queue.add(new MockSong(3, "Tiny Galaxy", "Mock Artist C", 195000));
        }
    }

    public static MockSong current() {
        if (queue.isEmpty()) {
            return null;
        }
        if (index < 0) {
            index = 0;
        }
        if (index >= queue.size()) {
            index = queue.size() - 1;
        }
        return queue.get(index);
    }

    public static boolean isPlaying() {
        return playing;
    }

    public static int[] positionAndDuration() {
        MockSong song = current();
        int duration = song == null ? 0 : song.durationMs;
        int pos = Math.max(0, Math.min(progressMs, duration));
        return new int[]{pos, duration};
    }

    public static void togglePlay() {
        playing = !playing;
        notifyStateChanged();
    }

    public static void play() {
        if (!playing) {
            playing = true;
            notifyStateChanged();
        }
    }

    public static void pause() {
        if (playing) {
            playing = false;
            notifyStateChanged();
        }
    }

    public static void nextSong() {
        if (queue.isEmpty()) {
            return;
        }
        index = (index + 1) % queue.size();
        progressMs = 0;
        notifyStateChanged();
    }

    public static void prevSong() {
        if (queue.isEmpty()) {
            return;
        }
        index = (index - 1 + queue.size()) % queue.size();
        progressMs = 0;
        notifyStateChanged();
    }

    public static void seekByPercent(int currentPercent, int maxPercent) {
        MockSong song = current();
        if (song == null) {
            return;
        }
        int max = maxPercent <= 0 ? 100 : maxPercent;
        int safeCurrent = Math.max(0, Math.min(currentPercent, max));
        progressMs = (song.durationMs * safeCurrent) / max;
        notifyStateChanged();
    }

    public static void tick1000ms() {
        if (!playing) {
            return;
        }
        MockSong song = current();
        if (song == null) {
            return;
        }
        progressMs += 1000;
        if (progressMs >= song.durationMs) {
            nextSong();
        } else {
            notifyStateChanged();
        }
    }

    private static void notifyStateChanged() {
        broadcastMetaChanged();
        broadcastPlayState();
        MediaSessionController.syncNow();
        if (appContext != null) {
            MusicCardAppWidgetProvider.updateAll(appContext);
            appContext.sendBroadcast(new Intent("com.example.mockcard.ACTION_CARD_REFRESH"));
        }
    }

    private static void broadcastMetaChanged() {
        if (appContext == null) {
            return;
        }
        appContext.sendBroadcast(new Intent(ACTION_META_CHANGED));
    }

    private static void broadcastPlayState() {
        if (appContext == null) {
            return;
        }
        Intent intent = new Intent(ACTION_PLAY_STATE_CHANGED);
        intent.putExtra(EXTRA_IS_PLAYING, playing);
        appContext.sendBroadcast(intent);
    }
}
