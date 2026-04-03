package com.example.mockcard.ui;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mockcard.R;
import com.example.mockcard.player.MockPlayerController;
import com.example.mockcard.player.MockSong;
import com.example.mockcard.service.MusicPlaybackService;

public class MainActivity extends AppCompatActivity {
    private static final Uri DATA_PROVIDER = Uri.parse("content://com.example.mockcard.provider.data");

    private TextView tvSong;
    private TextView tvState;

    private final BroadcastReceiver stateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            refreshUi();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSong = findViewById(R.id.tvSong);
        tvState = findViewById(R.id.tvState);

        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnIslandHint = findViewById(R.id.btnIslandHint);
        Button btnStop = findViewById(R.id.btnStop);

        startPlaybackService();

        btnPrev.setOnClickListener(v -> callDataProvider("prevSong", null));
        btnPlay.setOnClickListener(v -> callDataProvider("togglePlay", null));
        btnNext.setOnClickListener(v -> callDataProvider("nextSong", null));
        btnIslandHint.setOnClickListener(v -> showIslandHint());
        btnStop.setOnClickListener(v -> stopService(new Intent(this, MusicPlaybackService.class)));

        refreshUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter f = new IntentFilter();
        f.addAction(MockPlayerController.ACTION_META_CHANGED);
        f.addAction(MockPlayerController.ACTION_PLAY_STATE_CHANGED);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(stateReceiver, f, RECEIVER_NOT_EXPORTED);
        } else {
            registerReceiver(stateReceiver, f);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(stateReceiver);
    }

    private void startPlaybackService() {
        Intent intent = new Intent(this, MusicPlaybackService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    private void callDataProvider(String method, Bundle extras) {
        ContentResolver cr = getContentResolver();
        cr.call(DATA_PROVIDER, method, null, extras);
    }

    private void showIslandHint() {
        Intent i = new Intent(this, MusicPlaybackService.class);
        startService(i);
        sendBroadcast(new Intent("com.example.mockcard.ACTION_XTC_TOAST_SYS"));

        android.app.NotificationManager nm = (android.app.NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm != null) {
            nm.notify(MusicPlaybackService.NOTI_ISLAND_ID,
                    com.example.mockcard.service.NotificationHelper.buildIslandLikeNotification(this));
        }
    }

    private void refreshUi() {
        MockSong song = MockPlayerController.current();
        String songText = song == null ? "-" : (song.title + " - " + song.artist);
        tvSong.setText(songText);

        int[] pd = MockPlayerController.positionAndDuration();
        tvState.setText("State: " + (MockPlayerController.isPlaying() ? "playing" : "paused")
                + "  pos=" + (pd[0] / 1000) + "s/" + (pd[1] / 1000) + "s");
    }
}
