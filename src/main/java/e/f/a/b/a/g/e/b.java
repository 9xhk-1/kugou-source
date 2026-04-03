package e.f.a.b.a.g.e;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import f.s;
import f.z.d.g;
import f.z.d.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.f.a.b.a.g.a {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        new b();
    }

    public b() {
        super("ProcessExitReasonTable", "CREATE TABLE ProcessExitReasonTable (proc TEXT,ts BIGINT,reason BIGINT,reason_str TEXT,sub_reason BIGINT,sub_reason_str TEXT,is_foreground BIGINT DEFAULT 0,status BIGINT,importance BIGINT,importance_str TEXT,att_file TEXT,extra TEXT,insert_ts BIGINT);");
    }

    @Override // e.f.a.b.a.g.a
    public Object a(SQLiteDatabase sQLiteDatabase, f.z.c.a<? extends Object> aVar) {
        Cursor cursorQuery;
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        ArrayList arrayList = new ArrayList();
        try {
            if (Build.VERSION.SDK_INT >= 16 && (cursorQuery = sQLiteDatabase.query("ProcessExitReasonTable", null, null, null, null, null, null)) != null) {
                try {
                    cursorQuery.moveToFirst();
                    while (!cursorQuery.isAfterLast()) {
                        e.f.a.b.a.g.d.a aVarC = c(cursorQuery);
                        if (aVarC != null) {
                            arrayList.add(aVarC);
                        }
                        cursorQuery.moveToNext();
                    }
                    s sVar = s.a;
                    f.y.a.a(cursorQuery, null);
                } finally {
                }
            }
        } catch (Throwable th) {
            e.f.a.b.a.c.b.c("ProcessExitReasonTable", "[search] err:", th);
        }
        return arrayList;
    }

    @Override // e.f.a.b.a.g.a
    public long b(SQLiteDatabase sQLiteDatabase, f.z.c.a<Long> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        return 0L;
    }

    @SuppressLint({"Range"})
    public final e.f.a.b.a.g.d.a c(Cursor cursor) {
        return e.f.a.b.a.g.d.a.m.a(cursor);
    }
}
