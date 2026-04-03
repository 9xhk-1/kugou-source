package com.example.mockcard.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.mockcard.player.MockPlayerController;

public class MockCardDataProvider extends ContentProvider {
    private static final String TAG = "MockCardDataProvider";

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        Log.d(TAG, "call method=" + method + ", extras=" + extras);
        if (method == null) {
            return Bundle.EMPTY;
        }
        switch (method) {
            case "togglePlay":
                MockPlayerController.togglePlay();
                break;
            case "nextSong":
                MockPlayerController.nextSong();
                break;
            case "prevSong":
                MockPlayerController.prevSong();
                break;
            case "updateProgress":
                handleProgress(extras);
                break;
            case "openapp":
                break;
            default:
                Log.w(TAG, "Unknown method: " + method);
                break;
        }
        return Bundle.EMPTY;
    }

    private void handleProgress(Bundle extras) {
        if (extras == null) {
            return;
        }
        try {
            int current = Integer.parseInt(extras.getString("current", "0"));
            int max = Integer.parseInt(extras.getString("max", "100"));
            MockPlayerController.seekByPercent(current, max);
        } catch (Exception e) {
            Log.e(TAG, "handleProgress error", e);
        }
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
}
