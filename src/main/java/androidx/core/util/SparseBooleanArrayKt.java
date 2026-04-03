package androidx.core.util;

import android.util.SparseBooleanArray;
import f.s;
import f.u.k;
import f.u.z;
import f.z.c.a;
import f.z.c.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i2) {
        j.f(sparseBooleanArray, "$this$contains");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i2) {
        j.f(sparseBooleanArray, "$this$containsKey");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        j.f(sparseBooleanArray, "$this$containsValue");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p<? super Integer, ? super Boolean, s> pVar) {
        j.f(sparseBooleanArray, "$this$forEach");
        j.f(pVar, "action");
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        j.f(sparseBooleanArray, "$this$getOrDefault");
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i2, a<Boolean> aVar) {
        j.f(sparseBooleanArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : aVar.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        j.f(sparseBooleanArray, "$this$size");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        j.f(sparseBooleanArray, "$this$isEmpty");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        j.f(sparseBooleanArray, "$this$isNotEmpty");
        return sparseBooleanArray.size() != 0;
    }

    public static final z keyIterator(final SparseBooleanArray sparseBooleanArray) {
        j.f(sparseBooleanArray, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // f.u.z
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        j.f(sparseBooleanArray, "$this$plus");
        j.f(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        j.f(sparseBooleanArray, "$this$putAll");
        j.f(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        j.f(sparseBooleanArray, "$this$remove");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || z != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        j.f(sparseBooleanArray, "$this$set");
        sparseBooleanArray.put(i2, z);
    }

    public static final k valueIterator(final SparseBooleanArray sparseBooleanArray) {
        j.f(sparseBooleanArray, "$this$valueIterator");
        return new k() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // f.u.k
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
