package e.f.a.b.a.g.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import f.e0.n;
import f.s;
import f.z.d.g;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.f.a.b.a.g.a {
    public static final a b = new a(null);
    public String a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        new d();
    }

    public d() {
        super("SafeModeTable", "CREATE TABLE SafeModeTable (p_id TEXT,proc TEXT,uid TEXT,v_sdk TEXT,v_app TEXT,ts BIGINT);");
    }

    @Override // e.f.a.b.a.g.a
    public long b(SQLiteDatabase sQLiteDatabase, f.z.c.a<Long> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        return 0L;
    }

    public final e.f.a.b.a.j.a.a c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndex("p_id"));
        j.b(string, "it.getString(it.getColumnIndex(COLUMN_PLUGIN_ID))");
        String string2 = cursor.getString(cursor.getColumnIndex("proc"));
        j.b(string2, "it.getString(it.getColumnIndex(COLUMN_PROCESS))");
        String string3 = cursor.getString(cursor.getColumnIndex("uid"));
        j.b(string3, "it.getString(it.getColumnIndex(COLUMN_USER_ID))");
        String string4 = cursor.getString(cursor.getColumnIndex("v_sdk"));
        j.b(string4, "it.getString(it.getColum…ndex(COLUMN_SDK_VERSION))");
        String string5 = cursor.getString(cursor.getColumnIndex("v_app"));
        j.b(string5, "it.getString(it.getColum…ndex(COLUMN_APP_VERSION))");
        return new e.f.a.b.a.j.a.a(string, string2, string3, string4, string5, cursor.getLong(cursor.getColumnIndex("ts")));
    }

    @Override // e.f.a.b.a.g.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<e.f.a.b.a.j.a.a> a(SQLiteDatabase sQLiteDatabase, f.z.c.a<? extends Object> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        String str = this.a;
        if (str == null || n.n(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = sQLiteDatabase.query("SafeModeTable", null, "p_id=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    while (!cursorQuery.isAfterLast()) {
                        e.f.a.b.a.j.a.a aVarC = c(cursorQuery);
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
            e.f.a.b.a.c.b.c("SafeModeTable", "[search] err:", th);
        }
        return arrayList;
    }
}
