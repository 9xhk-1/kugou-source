package com.example.mockcard.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.mockcard.R;
import com.example.mockcard.player.MockPlayerController;
import com.example.mockcard.player.MockSong;
import com.example.mockcard.receiver.PlayerActionReceiver;

public class MusicCardAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        updateAll(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent == null ? null : intent.getAction();
        if (MockPlayerController.ACTION_META_CHANGED.equals(action)
                || MockPlayerController.ACTION_PLAY_STATE_CHANGED.equals(action)
                || "com.example.mockcard.ACTION_CARD_REFRESH".equals(action)
                || AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
            updateAll(context);
        }
    }

    public static void updateAll(Context context) {
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        ComponentName provider = new ComponentName(context, MusicCardAppWidgetProvider.class);
        int[] ids = manager.getAppWidgetIds(provider);
        for (int id : ids) {
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_music_card);
            bindData(context, rv);
            bindActions(context, rv);
            manager.updateAppWidget(id, rv);
        }
    }

    private static void bindData(Context context, RemoteViews rv) {
        MockSong song = MockPlayerController.current();
        String title = song == null ? context.getString(R.string.noti_title) : song.title;
        String artist = song == null ? context.getString(R.string.noti_text) : song.artist;

        int[] pd = MockPlayerController.positionAndDuration();
        int progress = pd[1] > 0 ? (pd[0] * 100) / pd[1] : 0;

        rv.setTextViewText(R.id.widgetSong, title);
        rv.setTextViewText(R.id.widgetArtist, artist);
        rv.setProgressBar(R.id.widgetProgress, 100, progress, false);
        rv.setImageViewResource(
                R.id.widgetPlay,
                MockPlayerController.isPlaying() ? android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play
        );
    }

    private static void bindActions(Context context, RemoteViews rv) {
        rv.setOnClickPendingIntent(
                R.id.widgetPrev,
                actionIntent(context, PlayerActionReceiver.ACTION_PREV, 201)
        );
        rv.setOnClickPendingIntent(
                R.id.widgetPlay,
                actionIntent(context, PlayerActionReceiver.ACTION_PLAY, 202)
        );
        rv.setOnClickPendingIntent(
                R.id.widgetNext,
                actionIntent(context, PlayerActionReceiver.ACTION_NEXT, 203)
        );
    }

    private static PendingIntent actionIntent(Context context, String action, int reqCode) {
        Intent i = new Intent(context, PlayerActionReceiver.class);
        i.setAction(action);
        return PendingIntent.getBroadcast(
                context,
                reqCode,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
    }
}
