package e.c.c.o;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                Log.d("mhs_watch_hegui", "columnIsExist tableName = " + str + ", columnName = " + str2);
                cursorQuery = sQLiteDatabase.query(str, null, null, null, null, null, null, "0");
                boolean z = cursorQuery != null && cursorQuery.getColumnIndex(str2) >= 0;
                Log.d("mhs_watch_hegui", "columnIsExist result = " + z + ", c = " + cursorQuery);
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return z;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
