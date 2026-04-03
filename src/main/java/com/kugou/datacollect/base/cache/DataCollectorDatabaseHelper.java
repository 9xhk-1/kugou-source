package com.kugou.datacollect.base.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e.c.c.o.b;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes2.dex */
public class DataCollectorDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "bisdk.db";
    private static final int DATABASE_VERSION = 5;
    private static volatile DataCollectorDatabaseHelper mFxDatabaseHelper;

    private DataCollectorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 5, null);
        setWriteAheadLoggingEnabled(true);
    }

    public static synchronized DataCollectorDatabaseHelper getHelper(Context context) {
        if (mFxDatabaseHelper == null) {
            synchronized (DataCollectorDatabaseHelper.class) {
                if (mFxDatabaseHelper == null) {
                    mFxDatabaseHelper = new DataCollectorDatabaseHelper(context);
                }
            }
        }
        return mFxDatabaseHelper;
    }

    public void addAppVersionColumn(SQLiteDatabase sQLiteDatabase) {
        try {
            if (b.a(sQLiteDatabase, "data_collect_info", "app_version")) {
                return;
            }
            sQLiteDatabase.execSQL("ALTER TABLE data_collect_info ADD COLUMN app_version TEXT ");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception unused) {
            return SQLiteDatabase.openDatabase(f.a().getDatabasePath(DATABASE_NAME).getPath(), null, 17, null);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception unused) {
            return SQLiteDatabase.openDatabase(f.a().getDatabasePath(DATABASE_NAME).getPath(), null, 16, null);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_collect_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT ,bussiniss TEXT ,time BIGINT ,first_post_time BIGINT ,app_version INTEGER ,lastsent_begin_id INTEGER ,type TEXT ,UNIQUE (_id) ON CONFLICT REPLACE );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 <= 1 || i3 != 1) {
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_collect_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT ,bussiniss TEXT ,time BIGINT ,first_post_time BIGINT ,app_version INTEGER ,lastsent_begin_id INTEGER ,type TEXT ,UNIQUE (_id) ON CONFLICT REPLACE );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            updateCollectInfoTable(sQLiteDatabase);
        } else if (i2 != 2) {
            return;
        }
        addAppVersionColumn(sQLiteDatabase);
    }

    public void updateCollectInfoTable(SQLiteDatabase sQLiteDatabase) {
        if (!b.a(sQLiteDatabase, "data_collect_info", "first_post_time")) {
            sQLiteDatabase.execSQL("ALTER TABLE data_collect_info ADD COLUMN first_post_time BIGINT ");
        }
        if (b.a(sQLiteDatabase, "data_collect_info", "lastsent_begin_id")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE data_collect_info ADD COLUMN lastsent_begin_id INTEGER ");
    }
}
