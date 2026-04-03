package com.qinghe.music163pro.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.xtc.cardwidget.external.card.serviceLayer.AppCardWidgetProvider;
import e.c.a.g.a.d.x.f;
import e.g.a.b.a.b.a.a.a;
import e.g.a.b.a.b.c.a;

public class MusicCardWidgetProvider extends AppCardWidgetProvider {
    private static final String TAG = "MusicCardWidgetProvider";
    private static final String ACTION_META_CHANGED = "com.kugou.young.watch.metachanged";
    private static final String ACTION_PLAY_STATE_CHANGED = "com.kugou.young.watch.playstatechanged";

    private BroadcastReceiver receiver;
    private String widgetCode = "";

    @Override
    public String getCardLayoutName(String code) {
        return "app_163music_widget.json";
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate");
        return super.onCreate();
    }

    @Override
    public void onResume(Context context, String code) {
        super.onResume(context, code);
        widgetCode = code;
        registerReceiver();
        updateCard();
    }

    @Override
    public void onPause(Context context, String code) {
        super.onPause(context, code);
        unregisterReceiver();
    }

    @Override
    public void onDestroy(Context context, String code) {
        super.onDestroy(context, code);
        unregisterReceiver();
    }

    private void registerReceiver() {
        if (receiver != null || getContext() == null) {
            return;
        }
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (ACTION_META_CHANGED.equals(action) || ACTION_PLAY_STATE_CHANGED.equals(action)) {
                    updateCard();
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_META_CHANGED);
        filter.addAction(ACTION_PLAY_STATE_CHANGED);
        e.c.a.g.a.f.d.a.b(receiver, filter);
    }

    private void unregisterReceiver() {
        if (receiver != null) {
            e.c.a.g.a.f.d.a.g(receiver);
            receiver = null;
        }
    }

    private void updateCard() {
        if (widgetCode == null || widgetCode.length() == 0) {
            return;
        }
        a.c(new CardUpdater(), widgetCode, true);
    }

    private static final class CardUpdater extends a {
        @Override
        public boolean b(e.g.a.c.a.a dsl) {
            KGMusicWrapper song = f.e();
            String title = song == null ? "网易云音乐" : song.getDisplayName();
            String singer = song == null ? "未在播放" : song.getArtistName();

            if (title == null || title.length() == 0) {
                title = "网易云音乐";
            }
            if (singer == null || singer.length() == 0) {
                singer = "未知歌手";
            }

            dsl.f("song_title", title);
            dsl.f("singer_title", singer);
            dsl.b("player_image", R.drawable.album_img_default);
            dsl.b("pause_button", f.q() ? R.drawable.young_ic_widget_pause_song : R.drawable.young_ic_widget_play_song);

            int[] posAndDuration = f.j();
            int current = 0;
            int total = 0;
            int progress = 0;
            if (posAndDuration != null && posAndDuration.length == 2) {
                current = Math.max(0, posAndDuration[0]);
                total = Math.max(0, posAndDuration[1]);
                progress = total > 0 ? (current * 100) / total : 0;
            }
            dsl.e("progress_music", progress);
            dsl.f("song_time_current", formatMs(current));
            dsl.f("song_time_total", formatMs(total));
            return true;
        }

        private String formatMs(int ms) {
            int seconds = Math.max(0, ms / 1000);
            int m = seconds / 60;
            int s = seconds % 60;
            String mm = m < 10 ? "0" + m : String.valueOf(m);
            String ss = s < 10 ? "0" + s : String.valueOf(s);
            return mm + ":" + ss;
        }
    }
}
