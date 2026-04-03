package com.kugou.android.watch.lite.base.db.secondary;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.d.b.b;
import e.c.a.g.a.d.f.d.b.c;
import e.c.a.g.a.d.f.d.b.e;
import e.c.a.g.a.d.f.d.b.f;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class SecondaryDatabase_Impl extends SecondaryDatabase {
    public volatile e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile b f26d;

    public class a extends RoomOpenHelper.Delegate {
        public a(int i2) {
            super(i2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `song_cover` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `hash` TEXT, `display_name` TEXT, `mix_id` INTEGER NOT NULL, `add_time` INTEGER NOT NULL, `url` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `lyric` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `hash` TEXT, `display_name` TEXT, `mix_id` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `file_path` TEXT)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2f0e751f039f3a1898cad8c7c20f9da8')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `song_cover`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `lyric`");
            if (SecondaryDatabase_Impl.this.mCallbacks != null) {
                int size = SecondaryDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) SecondaryDatabase_Impl.this.mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (SecondaryDatabase_Impl.this.mCallbacks != null) {
                int size = SecondaryDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) SecondaryDatabase_Impl.this.mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            SecondaryDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            SecondaryDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (SecondaryDatabase_Impl.this.mCallbacks != null) {
                int size = SecondaryDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) SecondaryDatabase_Impl.this.mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(6);
            map.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map.put("hash", new TableInfo.Column("hash", "TEXT", false, 0, null, 1));
            map.put("display_name", new TableInfo.Column("display_name", "TEXT", false, 0, null, 1));
            map.put("mix_id", new TableInfo.Column("mix_id", "INTEGER", true, 0, null, 1));
            map.put("add_time", new TableInfo.Column("add_time", "INTEGER", true, 0, null, 1));
            map.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("song_cover", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "song_cover");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "song_cover(com.kugou.android.watch.lite.base.db.secondary.table.SongCover).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(6);
            map2.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map2.put("hash", new TableInfo.Column("hash", "TEXT", false, 0, null, 1));
            map2.put("display_name", new TableInfo.Column("display_name", "TEXT", false, 0, null, 1));
            map2.put("mix_id", new TableInfo.Column("mix_id", "INTEGER", true, 0, null, 1));
            map2.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, 1));
            map2.put("file_path", new TableInfo.Column("file_path", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("lyric", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "lyric");
            if (tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "lyric(com.kugou.android.watch.lite.base.db.secondary.table.Lyric).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
        }
    }

    @Override // com.kugou.android.watch.lite.base.db.secondary.SecondaryDatabase
    public b c() {
        b bVar;
        if (this.f26d != null) {
            return this.f26d;
        }
        synchronized (this) {
            if (this.f26d == null) {
                this.f26d = new c(this);
            }
            bVar = this.f26d;
        }
        return bVar;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `song_cover`");
            writableDatabase.execSQL("DELETE FROM `lyric`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "song_cover", "lyric");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "2f0e751f039f3a1898cad8c7c20f9da8", "b7c7aa1ea1958e5c4f1a818946c905e4")).build());
    }

    @Override // com.kugou.android.watch.lite.base.db.secondary.SecondaryDatabase
    public e d() {
        e eVar;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new f(this);
            }
            eVar = this.c;
        }
        return eVar;
    }
}
