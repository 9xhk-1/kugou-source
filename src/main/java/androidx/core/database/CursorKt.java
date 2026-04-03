package androidx.core.database;

import android.database.Cursor;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getBlobOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getBlob(i2);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getDoubleOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i2));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getFloatOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i2));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getIntOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i2));
    }

    public static final Long getLongOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getLongOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    public static final Short getShortOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getShortOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i2));
    }

    public static final String getStringOrNull(Cursor cursor, int i2) {
        j.f(cursor, "$this$getStringOrNull");
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }
}
