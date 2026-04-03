package e.e.a.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends MatrixCursor {
    public static IBinder a(Cursor cursor) {
        Bundle extras;
        if (cursor == null || (extras = cursor.getExtras()) == null) {
            return null;
        }
        return extras.getBinder("KEY_BINDER");
    }
}
