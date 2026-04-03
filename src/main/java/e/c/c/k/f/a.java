package e.c.c.k.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public Cursor a(String str, String[] strArr) {
        return null;
    }

    public abstract int b(Uri uri, String str, String[] strArr);

    public abstract SQLiteOpenHelper c();

    public abstract String d(Uri uri);

    public abstract Uri e(Uri uri, ContentValues contentValues);

    public abstract boolean f(Context context);

    public abstract Cursor g(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor h(String str, String[] strArr) {
        return c().getReadableDatabase().rawQuery(str, strArr);
    }

    public abstract int i(Uri uri, ContentValues contentValues, String str, String[] strArr);

    public void j() {
    }
}
