package com.tme.fireeye.crash.comm.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import e.f.a.a.a.a;
import e.f.a.a.a.h.b;
import e.f.a.a.a.k.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class DbOpenHelper extends SQLiteOpenHelper {
    public static final String DATAS = "_dt";
    public static int DB_VERSION = 15;
    public static final String DEFAULT_DB_NAME = "fireeye_db";
    public static final String ID = "_id";
    public static final String ISMERGE = "_me";
    public static final String ISUPLOAD = "_up";
    public static final int MAX_GET_ERROR_TIME = 5;
    public static final String PROCESS = "_pc";
    public static final String SHA1 = "_s1";
    public static final String TABLE_CRASH = "t_cr";
    public static final String TABLE_DOWNLOAD = "dl_1002";
    public static final String TABLE_GRAY_EVENT = "ge_1002";
    public static final String TABLE_LOCAL_RECORD = "t_lr";
    public static final String TABLE_PREFERENCE = "t_pf";
    public static final String TABLE_STRATEGY = "st_1002";
    public static final String TABLE_USER_INFO = "t_ui";
    public static final String THREAD = "_th";
    public static final String TIME = "_tm";
    public static final String TYPE = "_tp";
    public static final String UPLOAD_COUNT = "_uc";
    public static final String UPLOAD_TIME = "_ut";
    public static String dbName = "fireeye_db";
    private List<a> baseModules;
    public Context mContext;

    public DbOpenHelper(Context context, List<a> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(dbName);
        sb.append("_");
        Objects.requireNonNull(b.e(context));
        sb.append("");
        super(context, sb.toString(), (SQLiteDatabase.CursorFactory) null, DB_VERSION);
        this.mContext = context;
        this.baseModules = list;
    }

    public synchronized boolean dropAllTables(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {TABLE_LOCAL_RECORD, TABLE_USER_INFO, TABLE_PREFERENCE};
            for (int i2 = 0; i2 < 3; i2++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + strArr[i2], new String[0]);
            }
        } catch (Throwable th) {
            if (!c.d(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        readableDatabase = null;
        int i2 = 0;
        while (readableDatabase == null && i2 < 5) {
            i2++;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                c.j("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    c.c("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        writableDatabase = null;
        int i2 = 0;
        while (writableDatabase == null && i2 < 5) {
            i2++;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                c.j("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    c.c("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            c.j("[Database] db error delay error record 1min.", new Object[0]);
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_USER_INFO);
            sb.append(" ( ");
            sb.append(ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(UPLOAD_TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(TYPE);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(DATAS);
            sb.append(" ");
            sb.append("blob");
            sb.append(" , ");
            sb.append(PROCESS);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" ) ");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_LOCAL_RECORD);
            sb.append(" ( ");
            sb.append(ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(TYPE);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(PROCESS);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" , ");
            sb.append(THREAD);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" , ");
            sb.append(DATAS);
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_PREFERENCE);
            sb.append(" ( ");
            sb.append(ID);
            sb.append(" ");
            sb.append("integer");
            sb.append(" , ");
            sb.append(TYPE);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" , ");
            sb.append(TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(DATAS);
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(ID);
            sb.append(",");
            sb.append(TYPE);
            sb.append(" )) ");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_CRASH);
            sb.append(" ( ");
            sb.append(ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(SHA1);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" , ");
            sb.append(ISUPLOAD);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(ISMERGE);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(UPLOAD_COUNT);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(DATAS);
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_DOWNLOAD);
            sb.append(" (");
            sb.append(ID);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_dUrl");
            sb.append(" varchar(100), ");
            sb.append("_sFile");
            sb.append(" varchar(100), ");
            sb.append("_sLen");
            sb.append(" INTEGER, ");
            sb.append("_tLen");
            sb.append(" INTEGER, ");
            sb.append("_MD5");
            sb.append(" varchar(100), ");
            sb.append("_DLTIME");
            sb.append(" INTEGER)");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_GRAY_EVENT);
            sb.append(" (");
            sb.append(ID);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_time");
            sb.append(" INTEGER, ");
            sb.append("_datas");
            sb.append(" blob)");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append(TABLE_STRATEGY);
            sb.append(" ( ");
            sb.append(ID);
            sb.append(" ");
            sb.append("integer");
            sb.append(" , ");
            sb.append(TYPE);
            sb.append(" ");
            sb.append(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            sb.append(" , ");
            sb.append(TIME);
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append(DATAS);
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(ID);
            sb.append(",");
            sb.append(TYPE);
            sb.append(" )) ");
            c.b(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!c.d(th)) {
                th.printStackTrace();
            }
        }
        List<a> list = this.baseModules;
        if (list == null) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().c(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!c.d(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (e.f.a.a.a.h.c.d() >= 11) {
            c.j("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            List<a> list = this.baseModules;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().d(sQLiteDatabase, i2, i3);
                    } catch (Throwable th) {
                        if (!c.d(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (dropAllTables(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                c.j("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.mContext.getDatabasePath(dbName);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        c.j("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        List<a> list = this.baseModules;
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().e(sQLiteDatabase, i2, i3);
                } catch (Throwable th) {
                    if (!c.d(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (dropAllTables(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            c.j("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.mContext.getDatabasePath(dbName);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
