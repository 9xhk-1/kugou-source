package androidx.core.content;

import android.content.ContentValues;
import f.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(i<String, ? extends Object>... iVarArr) {
        j.f(iVarArr, "pairs");
        ContentValues contentValues = new ContentValues(iVarArr.length);
        for (i<String, ? extends Object> iVar : iVarArr) {
            String strA = iVar.a();
            Object objB = iVar.b();
            if (objB == null) {
                contentValues.putNull(strA);
            } else if (objB instanceof String) {
                contentValues.put(strA, (String) objB);
            } else if (objB instanceof Integer) {
                contentValues.put(strA, (Integer) objB);
            } else if (objB instanceof Long) {
                contentValues.put(strA, (Long) objB);
            } else if (objB instanceof Boolean) {
                contentValues.put(strA, (Boolean) objB);
            } else if (objB instanceof Float) {
                contentValues.put(strA, (Float) objB);
            } else if (objB instanceof Double) {
                contentValues.put(strA, (Double) objB);
            } else if (objB instanceof byte[]) {
                contentValues.put(strA, (byte[]) objB);
            } else if (objB instanceof Byte) {
                contentValues.put(strA, (Byte) objB);
            } else {
                if (!(objB instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + '\"');
                }
                contentValues.put(strA, (Short) objB);
            }
        }
        return contentValues;
    }
}
