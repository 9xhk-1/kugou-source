package com.qinghe.music163pro.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import e.c.a.g.a.d.x.f;

public class MusicCardDataProvider extends ContentProvider {
    private static final String TAG = "MusicCardDataProvider";

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
                if (f.q()) {
                    f.t();
                } else {
                    f.x();
                }
                break;
            case "nextSong":
                f.s();
                break;
            case "prevSong":
                f.B();
                break;
            case "updateProgress":
                handleProgress(extras);
                break;
            case "openapp":
                openApp();
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
            e.c.a.g.a.m.a.a.g(current, max);
        } catch (Exception e) {
            Log.e(TAG, "handleProgress error", e);
        }
    }

    private void openApp() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent launch = context.getPackageManager().getLaunchIntentForPackage("com.qinghe.163musicpro");
        if (launch == null) {
            launch = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        }
        if (launch == null) {
            return;
        }
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launch);
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
