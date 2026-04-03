package e.f.a.b.a.g.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import f.e0.n;
import f.s;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.f.a.b.a.g.a {
    public static final C0254a c = new C0254a(null);
    public String a;
    public String b;

    /* JADX INFO: renamed from: e.f.a.b.a.g.e.a$a, reason: collision with other inner class name */
    public static final class C0254a {
        public C0254a() {
        }

        public /* synthetic */ C0254a(g gVar) {
            this();
        }
    }

    static {
        new a();
    }

    public a() {
        super("KeyValueTable", "CREATE TABLE KeyValueTable (k TEXT PRIMARY KEY,v TEXT);");
    }

    @Override // e.f.a.b.a.g.a
    public Object a(SQLiteDatabase sQLiteDatabase, f.z.c.a<? extends Object> aVar) {
        String strC;
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        String str = this.a;
        String str2 = null;
        if (str == null || n.n(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = sQLiteDatabase.query("KeyValueTable", null, "k=?", new String[]{str}, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                cursorQuery.moveToFirst();
                strC = !cursorQuery.isAfterLast() ? c(cursorQuery) : null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                s sVar = s.a;
                try {
                    f.y.a.a(cursorQuery, null);
                    return strC;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = strC;
                    e.f.a.b.a.c.b.c("KeyValueTable", "[search] err:", th);
                    return str2;
                }
            } catch (Throwable th3) {
                str2 = strC;
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    f.y.a.a(cursorQuery, th);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            e.f.a.b.a.c.b.c("KeyValueTable", "[search] err:", th);
            return str2;
        }
    }

    @Override // e.f.a.b.a.g.a
    public long b(SQLiteDatabase sQLiteDatabase, f.z.c.a<Long> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        String str = this.a;
        if ((str == null || n.n(str)) || this.b == null) {
            return -3L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("k", this.a);
        contentValues.put("v", this.b);
        return sQLiteDatabase.replace("KeyValueTable", null, contentValues);
    }

    public final String c(Cursor cursor) {
        if (cursor != null) {
            return cursor.getString(cursor.getColumnIndex("v"));
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this();
        j.f(str, "key");
        this.a = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2) {
        this();
        j.f(str, "key");
        j.f(str2, "value");
        this.a = str;
        this.b = str2;
    }
}
