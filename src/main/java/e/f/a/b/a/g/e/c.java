package e.f.a.b.a.g.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import f.s;
import f.z.d.g;
import f.z.d.j;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e.f.a.b.a.g.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1473d = new a(null);
    public String a;
    public String b;
    public String c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        new c();
    }

    public c() {
        super("report_data", "CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,uuid TEXT,process_name TEXT,app_id TEXT,app_version TEXT,params TEXT,userId TEXT,status TINYINT,occur_time BIGINT);");
        this.a = "";
        this.b = "";
        this.c = "";
    }

    @Override // e.f.a.b.a.g.a
    public Object a(SQLiteDatabase sQLiteDatabase, f.z.c.a<? extends Object> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        ArrayList arrayList = new ArrayList();
        try {
            Object objInvoke = aVar.invoke();
            Boolean bool = Boolean.TRUE;
            Cursor cursorQuery = sQLiteDatabase.query("report_data", null, j.a(objInvoke, bool) ? "process_name=? and app_id=? and app_version=? and status=? and occur_time>=?" : "process_name=? and app_id=? and app_version=?", j.a(aVar.invoke(), bool) ? new String[]{this.a, this.b, this.c, String.valueOf(e.f.a.b.a.g.b.TO_SEND.a()), String.valueOf(System.currentTimeMillis() - ((long) 259200000))} : new String[]{this.a, this.b, this.c}, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    while (!cursorQuery.isAfterLast()) {
                        e.f.a.b.a.l.b bVarC = c(cursorQuery);
                        if (bVarC != null) {
                            arrayList.add(bVarC);
                        }
                        cursorQuery.moveToNext();
                    }
                    s sVar = s.a;
                    f.y.a.a(cursorQuery, null);
                } finally {
                }
            }
        } catch (Throwable th) {
            e.f.a.b.a.c.b.c("ReportDataTable", "[search] err:", th);
        }
        return arrayList;
    }

    @Override // e.f.a.b.a.g.a
    public long b(SQLiteDatabase sQLiteDatabase, f.z.c.a<Long> aVar) {
        j.f(sQLiteDatabase, "dataBase");
        j.f(aVar, "block");
        return 0L;
    }

    public final e.f.a.b.a.l.b c(Cursor cursor) throws JSONException {
        if (cursor == null) {
            return null;
        }
        e.f.a.b.a.l.b bVar = new e.f.a.b.a.l.b(null, 1, null);
        bVar.a(cursor.getInt(cursor.getColumnIndex(DbOpenHelper.ID)));
        String string = cursor.getString(cursor.getColumnIndex("uuid"));
        j.b(string, "it.getString(it.getColumnIndex(COLUMN_UUID))");
        bVar.d(string);
        bVar.b(cursor.getLong(cursor.getColumnIndex("occur_time")));
        bVar.c(new JSONObject(cursor.getString(cursor.getColumnIndex("params"))));
        return bVar;
    }
}
