package com.kugou.android.watch.lite.base.db.secondary;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import e.c.a.g.a.d.f.d.b.b;
import e.c.a.g.a.d.f.d.b.d;
import e.c.a.g.a.d.f.d.b.e;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
@Database(entities = {d.class, e.c.a.g.a.d.f.d.b.a.class}, exportSchema = false, version = 1)
public abstract class SecondaryDatabase extends RoomDatabase {
    public static final a a = new a(null);
    public static volatile SecondaryDatabase b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final SecondaryDatabase a(Context context) {
            RoomDatabase roomDatabaseBuild = Room.databaseBuilder(context.getApplicationContext(), SecondaryDatabase.class, "Secondary.db").enableMultiInstanceInvalidation().build();
            j.d(roomDatabaseBuild, "databaseBuilder(\n                context.applicationContext,\n                SecondaryDatabase::class.java,\n                \"Secondary.db\"\n            )\n                .enableMultiInstanceInvalidation()\n                .build()");
            return (SecondaryDatabase) roomDatabaseBuild;
        }

        public final SecondaryDatabase b(Context context) {
            j.e(context, "context");
            SecondaryDatabase secondaryDatabase = SecondaryDatabase.b;
            if (secondaryDatabase == null) {
                synchronized (this) {
                    secondaryDatabase = SecondaryDatabase.b;
                    if (secondaryDatabase == null) {
                        SecondaryDatabase secondaryDatabaseA = SecondaryDatabase.a.a(context);
                        SecondaryDatabase.b = secondaryDatabaseA;
                        secondaryDatabase = secondaryDatabaseA;
                    }
                }
            }
            return secondaryDatabase;
        }
    }

    public abstract b c();

    public abstract e d();
}
