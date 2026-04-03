package e.c.a.g.a.g.n.h;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String[] a = {DbOpenHelper.ID, "artist", "album", "title", "_size", "duration", "mime_type", "album_id", "artist_id", "_display_name", "_data", "track"};

    public static long a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Audio.Media.getContentUriForPath(str), a, "_data=?", new String[]{str}, null);
        if (cursorQuery != null) {
            j = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(DbOpenHelper.ID)) : -1L;
            cursorQuery.close();
        }
        return j;
    }
}
