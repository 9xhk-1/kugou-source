package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import f.i;
import f.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(i<String, ? extends Object>... iVarArr) {
        j.f(iVarArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(iVarArr.length);
        for (i<String, ? extends Object> iVar : iVarArr) {
            String strA = iVar.a();
            Object objB = iVar.b();
            if (objB == null) {
                persistableBundle.putString(strA, null);
            } else if (objB instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + strA + '\"');
                }
                persistableBundle.putBoolean(strA, ((Boolean) objB).booleanValue());
            } else if (objB instanceof Double) {
                persistableBundle.putDouble(strA, ((Number) objB).doubleValue());
            } else if (objB instanceof Integer) {
                persistableBundle.putInt(strA, ((Number) objB).intValue());
            } else if (objB instanceof Long) {
                persistableBundle.putLong(strA, ((Number) objB).longValue());
            } else if (objB instanceof String) {
                persistableBundle.putString(strA, (String) objB);
            } else if (objB instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + strA + '\"');
                }
                persistableBundle.putBooleanArray(strA, (boolean[]) objB);
            } else if (objB instanceof double[]) {
                persistableBundle.putDoubleArray(strA, (double[]) objB);
            } else if (objB instanceof int[]) {
                persistableBundle.putIntArray(strA, (int[]) objB);
            } else if (objB instanceof long[]) {
                persistableBundle.putLongArray(strA, (long[]) objB);
            } else {
                if (!(objB instanceof Object[])) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + '\"');
                }
                Class<?> componentType = objB.getClass().getComponentType();
                if (componentType == null) {
                    j.n();
                    throw null;
                }
                j.b(componentType, "value::class.java.componentType!!");
                if (!String.class.isAssignableFrom(componentType)) {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strA + '\"');
                }
                if (objB == null) {
                    throw new p("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                persistableBundle.putStringArray(strA, (String[]) objB);
            }
        }
        return persistableBundle;
    }
}
