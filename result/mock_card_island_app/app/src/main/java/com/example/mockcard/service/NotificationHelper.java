package com.example.mockcard.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import android.support.v4.media.session.MediaSessionCompat;

import com.example.mockcard.R;
import com.example.mockcard.player.MockPlayerController;
import com.example.mockcard.player.MockSong;
import com.example.mockcard.receiver.PlayerActionReceiver;

public final class NotificationHelper {
    public static final String CH_PLAYBACK = "mock_playback_v2";
    public static final String CH_ISLAND = "mock_island_v2";

    private NotificationHelper() {
    }

    public static void ensureChannels(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm == null) {
            return;
        }

        NotificationChannel playback = new NotificationChannel(CH_PLAYBACK, context.getString(R.string.channel_playback), NotificationManager.IMPORTANCE_LOW);
        if (Build.VERSION.SDK_INT >= 26 && MediaSessionController.notificationAudioAttributes() != null) {
            playback.setSound(null, MediaSessionController.notificationAudioAttributes());
        } else {
            playback.setSound(null, null);
        }
        playback.enableVibration(false);
        nm.createNotificationChannel(playback);

        NotificationChannel island = new NotificationChannel(CH_ISLAND, context.getString(R.string.channel_card), NotificationManager.IMPORTANCE_LOW);
        island.setSound(null, null);
        island.enableVibration(false);
        nm.createNotificationChannel(island);
    }

    public static Notification buildPlaybackNotification(Context context) {
        MockSong song = MockPlayerController.current();
        String title = song == null ? context.getString(R.string.noti_title) : song.title;
        String text = song == null ? context.getString(R.string.noti_text) : song.artist;

        PendingIntent prev = pendingBroadcast(context, PlayerActionReceiver.ACTION_PREV, 101);
        PendingIntent play = pendingBroadcast(context, PlayerActionReceiver.ACTION_PLAY, 102);
        PendingIntent next = pendingBroadcast(context, PlayerActionReceiver.ACTION_NEXT, 103);

        androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(context, CH_PLAYBACK)
                .setSmallIcon(R.drawable.ic_mock_logo)
                .setContentTitle(title)
                .setContentText(text)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setSilent(true)
                .setShowWhen(false)
                .addAction(0, "Prev", prev)
                .addAction(0, MockPlayerController.isPlaying() ? "Pause" : "Play", play)
                .addAction(0, "Next", next);

        MediaSessionCompat.Token token = MediaSessionController.compatToken();
        if (token != null) {
            builder.setStyle(new androidx.media.app.NotificationCompat.MediaStyle().setMediaSession(token).setShowActionsInCompactView(0, 1, 2));
        }
        return builder.build();
    }

    public static Notification buildIslandLikeNotification(Context context) {
        MockSong song = MockPlayerController.current();
        String title = song == null ? "Island" : ("Island: " + song.title);

        androidx.core.app.NotificationCompat.Builder b = new androidx.core.app.NotificationCompat.Builder(context, CH_ISLAND)
                .setSmallIcon(R.drawable.ic_mock_logo)
                .setContentTitle(title)
                .setContentText(MockPlayerController.isPlaying() ? "Playing" : "Paused")
                .setAutoCancel(true)
                .setPriority(androidx.core.app.NotificationCompat.PRIORITY_LOW)
                .setOnlyAlertOnce(true)
                .setSilent(true)
                .setCategory(androidx.core.app.NotificationCompat.CATEGORY_TRANSPORT);

        b.getExtras().putBoolean("show_heytap_indicator", true);
        b.getExtras().putString("mock_island_source", "manual_trigger");
        return b.build();
    }

    private static PendingIntent pendingBroadcast(Context c, String action, int req) {
        Intent i = new Intent(c, PlayerActionReceiver.class);
        i.setAction(action);
        return PendingIntent.getBroadcast(c, req, i, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
    }
}
