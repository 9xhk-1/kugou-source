package e.f.a.b.a.g;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tme.fireeye.lib.base.db.DBHelper;
import e.f.a.b.a.g.e.d;
import f.u.m;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static volatile c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1466d = new a(null);
    public SQLiteDatabase a;
    public DBHelper b;

    public static final class a {
        public a() {
        }

        public final c a(DBHelper dBHelper) {
            j.f(dBHelper, "dbHelper");
            c cVar = c.c;
            if (cVar == null) {
                synchronized (this) {
                    cVar = c.c;
                    if (cVar == null) {
                        cVar = new c(null);
                        c.c = cVar;
                        cVar.f(dBHelper);
                        cVar.d();
                    }
                }
            }
            return cVar;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        m.c(e.f.a.b.a.g.e.c.f1473d, e.f.a.b.a.g.e.a.c, d.b, e.f.a.b.a.g.e.b.a);
    }

    public c() {
    }

    public final void d() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null || !(sQLiteDatabase == null || sQLiteDatabase.isOpen())) {
            try {
                DBHelper dBHelper = this.b;
                this.a = dBHelper != null ? dBHelper.getWritableDatabase() : null;
            } catch (SQLiteException e2) {
                e.f.a.b.a.c.b.c("FireEye_db_persist_DBHandler", "[open] err=", e2);
            }
        }
    }

    public final Object e(e.f.a.b.a.g.a aVar, f.z.c.a<? extends Object> aVar2) {
        j.f(aVar, "table");
        j.f(aVar2, "block");
        if (this.a == null) {
            return null;
        }
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null && !sQLiteDatabase.isOpen()) {
            return null;
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = this.a;
            if (sQLiteDatabase2 != null) {
                return aVar.a(sQLiteDatabase2, aVar2);
            }
            return null;
        } catch (Throwable th) {
            e.f.a.b.a.c.b.c("FireEye_db_persist_DBHandler", "[sqlSearch] err=", th);
            return null;
        }
    }

    public final void f(DBHelper dBHelper) {
        this.b = dBHelper;
    }

    public final long g(e.f.a.b.a.g.a aVar, f.z.c.a<Long> aVar2) {
        j.f(aVar, "table");
        j.f(aVar2, "block");
        if (this.a == null) {
            return -2L;
        }
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null && !sQLiteDatabase.isOpen()) {
            return -2L;
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = this.a;
            if (sQLiteDatabase2 != null) {
                return aVar.b(sQLiteDatabase2, aVar2);
            }
            return -2L;
        } catch (Throwable th) {
            e.f.a.b.a.c.b.c("FireEye_db_persist_DBHandler", "[sql] err=", th);
            return -1L;
        }
    }

    public /* synthetic */ c(g gVar) {
        this();
    }
}
