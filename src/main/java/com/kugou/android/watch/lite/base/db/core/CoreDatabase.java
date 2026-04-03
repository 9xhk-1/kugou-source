package com.kugou.android.watch.lite.base.db.core;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import e.c.a.g.a.d.f.c.a.d;
import e.c.a.g.a.d.f.c.a.e;
import e.c.a.g.a.d.f.c.a.j;
import e.c.a.g.a.d.f.c.a.k;
import e.c.a.g.a.d.f.c.a.m;
import e.c.a.g.a.d.f.c.a.o;
import e.c.a.g.a.d.f.c.a.q;
import e.c.a.g.a.d.s.f;
import f.z.d.g;

/* JADX INFO: loaded from: classes.dex */
@Database(entities = {j.class, KGPlaylistMusic.class, KGMusic.class, e.c.a.g.a.d.f.c.a.a.class, q.class, d.class, e.c.a.g.a.d.s.d.class}, exportSchema = false, version = 3)
public abstract class CoreDatabase extends RoomDatabase {
    public static volatile CoreDatabase b;
    public static final c a = new c(null);
    public static final Migration c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Migration f20d = new b();

    public static final class a extends Migration {
        public a() {
            super(1, 2);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            f.z.d.j.e(supportSQLiteDatabase, "database");
            supportSQLiteDatabase.execSQL("\n            CREATE TABLE IF NOT EXISTS `history_record` (\n                `opTime` INTEGER NOT NULL,\n                `mixId` INTEGER NOT NULL,\n                `playCount` INTEGER NOT NULL,\n                `action` INTEGER NOT NULL,\n                `userId` INTEGER NOT NULL,\n                PRIMARY KEY(`opTime`)\n            )\n        ");
        }
    }

    public static final class b extends Migration {
        public b() {
            super(2, 3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            f.z.d.j.e(supportSQLiteDatabase, "database");
            supportSQLiteDatabase.execSQL("\n            CREATE TABLE IF NOT EXISTS 'fee_kubi_buy_info_tab' (\n                'id' INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 0 NOT NULL,\n                'fileHash' TEXT COLLATE NOCASE,\n                'mixid' INTEGER DEFAULT 0 NOT NULL,\n                'userid' INTEGER DEFAULT 0 NOT NULL,\n                'updateTime' INTEGER DEFAULT 0 NOT NULL,\n                'createTime' INTEGER DEFAULT 0 NOT NULL,\n                'albumId' INTEGER DEFAULT 0 NOT NULL\n            )\n        ");
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }

        public final CoreDatabase a(Context context) {
            RoomDatabase roomDatabaseBuild = Room.databaseBuilder(context.getApplicationContext(), CoreDatabase.class, "Core.db").enableMultiInstanceInvalidation().addMigrations(c(), d()).build();
            f.z.d.j.d(roomDatabaseBuild, "databaseBuilder(context.applicationContext, CoreDatabase::class.java, \"Core.db\")\n                .enableMultiInstanceInvalidation()\n                .addMigrations(MIGRATION_1_2,MIGRATION_2_3) // 添加迁移\n               .build()");
            return (CoreDatabase) roomDatabaseBuild;
        }

        public final CoreDatabase b(Context context) {
            f.z.d.j.e(context, "context");
            CoreDatabase coreDatabase = CoreDatabase.b;
            if (coreDatabase == null) {
                synchronized (this) {
                    coreDatabase = CoreDatabase.b;
                    if (coreDatabase == null) {
                        CoreDatabase coreDatabaseA = CoreDatabase.a.a(context);
                        CoreDatabase.b = coreDatabaseA;
                        coreDatabase = coreDatabaseA;
                    }
                }
            }
            return coreDatabase;
        }

        public final Migration c() {
            return CoreDatabase.c;
        }

        public final Migration d() {
            return CoreDatabase.f20d;
        }
    }

    public abstract e.c.a.g.a.d.f.c.a.b e();

    public abstract f f();

    public abstract e g();

    public abstract e.c.a.g.a.d.f.c.a.g h();

    public abstract k i();

    public abstract m j();

    public abstract o k();
}
