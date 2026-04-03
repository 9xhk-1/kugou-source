package com.kugou.common.permission.checker;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionTest {
    public static final OuterAccessors ACCESSOR = new OuterAccessors();

    public static class CursorTest {
        public static void read(Cursor cursor) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int type = cursor.getType(0);
                if (type == 0 || type == 4) {
                    return;
                }
                cursor.getString(0);
            }
        }
    }

    boolean test() throws Throwable;
}
