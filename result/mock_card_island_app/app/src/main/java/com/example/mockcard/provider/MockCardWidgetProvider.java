package com.example.mockcard.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.example.mockcard.player.MockPlayerController;
import com.example.mockcard.player.MockSong;

import org.json.JSONObject;

public class MockCardWidgetProvider extends ContentProvider {
    private static final String TAG = "MockCardWidgetProvider";

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public static JSONObject snapshotJson() {
        JSONObject obj = new JSONObject();
        try {
            MockSong song = MockPlayerController.current();
            String title = song == null ? "Mock Song" : song.title;
            String artist = song == null ? "Mock Artist" : song.artist;
            int[] pd = MockPlayerController.positionAndDuration();
            int progress = pd[1] > 0 ? (pd[0] * 100) / pd[1] : 0;
            obj.put("song_title", title);
            obj.put("singer_title", artist);
            obj.put("progress_music", progress);
            obj.put("is_playing", MockPlayerController.isPlaying());
            obj.put("duration_ms", pd[1]);
            obj.put("position_ms", pd[0]);
        } catch (Exception ignore) {
        }
        return obj;
    }
}
