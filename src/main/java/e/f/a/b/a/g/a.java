package e.f.a.b.a.g;

import android.database.sqlite.SQLiteDatabase;
import com.tme.fireeye.lib.base.db.DBHelper;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public a(String str, String str2) {
        j.f(str, "tableName");
        j.f(str2, "createTableSql");
        DBHelper.Companion.b(str, str2);
    }

    public abstract Object a(SQLiteDatabase sQLiteDatabase, f.z.c.a<? extends Object> aVar);

    public abstract long b(SQLiteDatabase sQLiteDatabase, f.z.c.a<Long> aVar);
}
