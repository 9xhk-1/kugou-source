package com.kugou.datacollect.base.cache;

import android.content.ContentValues;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes2.dex */
public class WatchDataCollectProvider extends CommonProvider {
    @Override // com.kugou.datacollect.base.cache.CommonProvider, android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        try {
            return super.bulkInsert(uri, contentValuesArr);
        } catch (SQLiteFullException e2) {
            g0.k(e2);
            return 0;
        }
    }

    @Override // com.kugou.datacollect.base.cache.CommonProvider, android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            return super.insert(uri, contentValues);
        } catch (SQLiteFullException e2) {
            g0.k(e2);
            return null;
        }
    }
}
