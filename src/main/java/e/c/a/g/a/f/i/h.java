package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends b implements f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f672i = {"image/jpeg", "image/png", "image/gif", "image/jpg"};
    public static final String[] j = {"image/jpeg", "image/png", "image/gif"};
    public static final String[] k = {DbOpenHelper.ID, "_data", "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified"};

    public h(ContentResolver contentResolver, Uri uri, Uri uri2, int i2, String str) {
        super(contentResolver, uri, i2, str);
    }

    @Override // e.c.a.g.a.f.i.b
    public Cursor b() {
        return MediaStore.Images.Media.query(this.b, this.f662d, k, l(), m(), k());
    }

    @Override // e.c.a.g.a.f.i.b
    public long e(Cursor cursor) {
        return cursor.getLong(0);
    }

    @Override // e.c.a.g.a.f.i.f
    public HashMap<String, String> getBucketIds() {
        Cursor cursorQuery;
        try {
            cursorQuery = MediaStore.Images.Media.query(this.b, this.f662d.buildUpon().appendQueryParameter("distinct", "true").build(), new String[]{"bucket_display_name", "bucket_id"}, l(), m(), null);
        } catch (Exception unused) {
            cursorQuery = null;
        }
        try {
            HashMap<String, String> map = new HashMap<>();
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(1), cursorQuery.getString(0));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // e.c.a.g.a.f.i.b
    public a j(Cursor cursor) {
        long j2 = cursor.getLong(0);
        String string = cursor.getString(1);
        long j3 = cursor.getLong(2);
        if (j3 == 0) {
            j3 = cursor.getLong(7) * 1000;
        }
        long j4 = j3;
        long j5 = cursor.getLong(3);
        int i2 = cursor.getInt(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(6);
        String str = (string2 == null || string2.length() == 0) ? string : string2;
        return new g(this, this.b, j2, cursor.getPosition(), a(j2), string, j5, string3, j4, str, str, i2);
    }

    public String l() {
        String str;
        String str2;
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            str = "(mime_type in (?, ?, ?, ?))";
            str2 = "(mime_type in (?, ?, ?, ?)) AND bucket_id = ?";
        } else {
            str = "(mime_type in (?, ?, ?))";
            str2 = "(mime_type in (?, ?, ?)) AND bucket_id = ?";
        }
        return this.f664f == null ? str : str2;
    }

    public String[] m() {
        String[] strArr = j;
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            strArr = f672i;
        }
        if (this.f664f == null) {
            return strArr;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = this.f664f;
        return strArr2;
    }
}
