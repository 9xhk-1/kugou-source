package e.c.c.k.f;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.kugou.datacollect.base.cache.DataCollectorDatabaseHelper;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public static UriMatcher c;
    public DataCollectorDatabaseHelper a;
    public String b = "data_collect_info";

    @Override // e.c.c.k.f.a
    public int b(Uri uri, String str, String[] strArr) {
        int iMatch = c.match(uri);
        if (iMatch == 0 || iMatch == 1) {
            this.b = "data_collect_info";
        }
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase.delete(this.b, str, strArr);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // e.c.c.k.f.a
    public SQLiteOpenHelper c() {
        return this.a;
    }

    @Override // e.c.c.k.f.a
    public String d(Uri uri) {
        int iMatch = c.match(uri);
        if (iMatch == 0) {
            return "vnd.android.cursor.dir/data_collect_info";
        }
        if (iMatch != 1) {
            return null;
        }
        return "vnd.android.cursor.item/data_collect_info";
    }

    @Override // e.c.c.k.f.a
    public Uri e(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase;
        e.c.c.o.g.a("DataCollectContentProvider", "insert db");
        if (contentValues.containsKey("isMomeryCache") && contentValues.getAsBoolean("isMomeryCache").booleanValue()) {
            e.q().c(new b(contentValues.getAsString("type"), contentValues.getAsString("bussiniss"), contentValues.getAsString("data"), contentValues.getAsLong("time").longValue()));
            return null;
        }
        if (contentValues.containsKey("sendATOnce") && contentValues.getAsBoolean("sendATOnce").booleanValue()) {
            e.c.c.k.g.b.a().h();
            return null;
        }
        int iMatch = c.match(uri);
        if (iMatch == 0 || iMatch == 1) {
            this.b = "data_collect_info";
        }
        try {
            writableDatabase = this.a.getWritableDatabase();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        long jInsert = writableDatabase.isOpen() ? writableDatabase.insert(this.b, null, contentValues) : 0L;
        if (jInsert > 0) {
            return ContentUris.withAppendedId(f.f(), jInsert);
        }
        return null;
    }

    @Override // e.c.c.k.f.a
    public boolean f(Context context) {
        this.a = DataCollectorDatabaseHelper.getHelper(context);
        UriMatcher uriMatcher = new UriMatcher(-1);
        c = uriMatcher;
        uriMatcher.addURI(c.b(context.getPackageName()), "data_collect_info", 0);
        c.addURI(c.b(context.getPackageName()), "data_collect_info/#", 1);
        return this.a != null;
    }

    @Override // e.c.c.k.f.a
    public Cursor g(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = c.match(uri);
        if (iMatch == 0 || iMatch == 1) {
            this.b = "data_collect_info";
        }
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase.query(this.b, strArr, str, strArr2, null, null, str2);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // e.c.c.k.f.a
    public int i(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iMatch = c.match(uri);
        if (iMatch == 0 || iMatch == 1) {
            this.b = "data_collect_info";
        }
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase.update(this.b, contentValues, str, strArr);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
