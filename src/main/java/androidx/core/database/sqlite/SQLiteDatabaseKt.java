package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import f.z.c.l;
import f.z.d.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, l<? super SQLiteDatabase, ? extends T> lVar) {
        j.f(sQLiteDatabase, "$this$transaction");
        j.f(lVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            i.b(1);
            sQLiteDatabase.endTransaction();
            i.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        j.f(sQLiteDatabase, "$this$transaction");
        j.f(lVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            i.b(1);
            sQLiteDatabase.endTransaction();
            i.a(1);
        }
    }
}
