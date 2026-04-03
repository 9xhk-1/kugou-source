package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import f.i;
import f.p;
import f.z.d.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class BundleKt {
    public static final Bundle bundleOf(i<String, ? extends Object>... iVarArr) {
        j.f(iVarArr, "pairs");
        Bundle bundle = new Bundle(iVarArr.length);
        for (i<String, ? extends Object> iVar : iVarArr) {
            String strA = iVar.a();
            Object objB = iVar.b();
            if (objB == null) {
                bundle.putString(strA, null);
            } else if (objB instanceof Boolean) {
                bundle.putBoolean(strA, ((Boolean) objB).booleanValue());
            } else if (objB instanceof Byte) {
                bundle.putByte(strA, ((Number) objB).byteValue());
            } else if (objB instanceof Character) {
                bundle.putChar(strA, ((Character) objB).charValue());
            } else if (objB instanceof Double) {
                bundle.putDouble(strA, ((Number) objB).doubleValue());
            } else if (objB instanceof Float) {
                bundle.putFloat(strA, ((Number) objB).floatValue());
            } else if (objB instanceof Integer) {
                bundle.putInt(strA, ((Number) objB).intValue());
            } else if (objB instanceof Long) {
                bundle.putLong(strA, ((Number) objB).longValue());
            } else if (objB instanceof Short) {
                bundle.putShort(strA, ((Number) objB).shortValue());
            } else if (objB instanceof Bundle) {
                bundle.putBundle(strA, (Bundle) objB);
            } else if (objB instanceof CharSequence) {
                bundle.putCharSequence(strA, (CharSequence) objB);
            } else if (objB instanceof Parcelable) {
                bundle.putParcelable(strA, (Parcelable) objB);
            } else if (objB instanceof boolean[]) {
                bundle.putBooleanArray(strA, (boolean[]) objB);
            } else if (objB instanceof byte[]) {
                bundle.putByteArray(strA, (byte[]) objB);
            } else if (objB instanceof char[]) {
                bundle.putCharArray(strA, (char[]) objB);
            } else if (objB instanceof double[]) {
                bundle.putDoubleArray(strA, (double[]) objB);
            } else if (objB instanceof float[]) {
                bundle.putFloatArray(strA, (float[]) objB);
            } else if (objB instanceof int[]) {
                bundle.putIntArray(strA, (int[]) objB);
            } else if (objB instanceof long[]) {
                bundle.putLongArray(strA, (long[]) objB);
            } else if (objB instanceof short[]) {
                bundle.putShortArray(strA, (short[]) objB);
            } else if (objB instanceof Object[]) {
                Class<?> componentType = objB.getClass().getComponentType();
                if (componentType == null) {
                    j.n();
                    throw null;
                }
                j.b(componentType, "value::class.java.componentType!!");
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (objB == null) {
                        throw new p("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                    bundle.putParcelableArray(strA, (Parcelable[]) objB);
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (objB == null) {
                        throw new p("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    bundle.putStringArray(strA, (String[]) objB);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (objB == null) {
                        throw new p("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                    bundle.putCharSequenceArray(strA, (CharSequence[]) objB);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strA + '\"');
                    }
                    bundle.putSerializable(strA, (Serializable) objB);
                }
            } else if (objB instanceof Serializable) {
                bundle.putSerializable(strA, (Serializable) objB);
            } else {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 18 && (objB instanceof IBinder)) {
                    bundle.putBinder(strA, (IBinder) objB);
                } else if (i2 >= 21 && (objB instanceof Size)) {
                    bundle.putSize(strA, (Size) objB);
                } else {
                    if (i2 < 21 || !(objB instanceof SizeF)) {
                        throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + '\"');
                    }
                    bundle.putSizeF(strA, (SizeF) objB);
                }
            }
        }
        return bundle;
    }
}
