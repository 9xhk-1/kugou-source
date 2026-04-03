package com.tme.fireeye.lib.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e.f.a.b.a.c;
import f.z.d.g;
import f.z.d.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SqliteHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 4;
    private static final String TAG = "SqliteHelper";
    public static final a Companion = new a(null);
    private static final HashMap<String, String> tables = new HashMap<>();

    public static final class a {
        public a() {
        }

        public final HashMap<String, String> a() {
            return SqliteHelper.tables;
        }

        public final void b(String str, String str2) {
            j.f(str, "tableName");
            j.f(str2, "createSql");
            if (str.length() > 0) {
                if (str2.length() > 0) {
                    a().put(str, str2);
                }
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SqliteHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory, 4);
        j.f(context, "context");
        j.f(str, "dbName");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        j.f(sQLiteDatabase, "db");
        c.b.d(TAG, "[onCreate]");
        for (Map.Entry<String, String> entry : tables.entrySet()) {
            c.b.d(TAG, "[onCreate] table.value=" + entry.getValue());
            sQLiteDatabase.execSQL(entry.getValue());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        j.f(sQLiteDatabase, "db");
        c.b.d(TAG, "[onUpgrade] oldVersion=" + i2 + ", newVersion=" + i3);
        for (Map.Entry<String, String> entry : tables.entrySet()) {
            c.b.d(TAG, "[onUpgrade] table.key=" + entry.getKey());
            sQLiteDatabase.execSQL("Drop table if exists " + entry.getKey());
        }
        onCreate(sQLiteDatabase);
    }
}
