package com.example.mockcard.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import androidx.annotation.Nullable;

import com.example.mockcard.player.MockPlayerController;

public class MusicPlaybackService extends Service {
    public static final int NOTI_PLAYBACK_ID = 1001;
    public static final int NOTI_ISLAND_ID = 1002;

    private final Handler main = new Handler(Looper.getMainLooper());
    private final Runnable ticker = new Runnable() {
        @Override
        public void run() {
            MockPlayerController.tick1000ms();
            updatePlaybackNotification();
            main.postDelayed(this, 1000);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationHelper.ensureChannels(this);
        startForeground(NOTI_PLAYBACK_ID, NotificationHelper.buildPlaybackNotification(this));
        main.post(ticker);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent == null ? null : intent.getAction();
        if ("com.example.mockcard.ACTION_SHOW_ISLAND".equals(action)) {
            showIslandLikeNotification();
        } else {
            updatePlaybackNotification();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        main.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void updatePlaybackNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (nm != null) {
            nm.notify(NOTI_PLAYBACK_ID, NotificationHelper.buildPlaybackNotification(this));
        }
    }

    public void showIslandLikeNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (nm != null) {
            nm.notify(NOTI_ISLAND_ID, NotificationHelper.buildIslandLikeNotification(this));
        }
    }

    public static void requestIslandHint(Context context) {
        Intent i = new Intent(context, MusicPlaybackService.class);
        i.setAction("com.example.mockcard.ACTION_SHOW_ISLAND");
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(i);
        } else {
            context.startService(i);
        }
    }
}
