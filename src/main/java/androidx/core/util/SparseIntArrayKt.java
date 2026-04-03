package androidx.core.util;

import android.util.SparseIntArray;
import f.s;
import f.u.z;
import f.z.c.a;
import f.z.c.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i2) {
        j.f(sparseIntArray, "$this$contains");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i2) {
        j.f(sparseIntArray, "$this$containsKey");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i2) {
        j.f(sparseIntArray, "$this$containsValue");
        return sparseIntArray.indexOfValue(i2) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p<? super Integer, ? super Integer, s> pVar) {
        j.f(sparseIntArray, "$this$forEach");
        j.f(pVar, "action");
        int size = sparseIntArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i2, int i3) {
        j.f(sparseIntArray, "$this$getOrDefault");
        return sparseIntArray.get(i2, i3);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i2, a<Integer> aVar) {
        j.f(sparseIntArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i2);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : aVar.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        j.f(sparseIntArray, "$this$size");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        j.f(sparseIntArray, "$this$isEmpty");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        j.f(sparseIntArray, "$this$isNotEmpty");
        return sparseIntArray.size() != 0;
    }

    public static final z keyIterator(final SparseIntArray sparseIntArray) {
        j.f(sparseIntArray, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // f.u.z
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        j.f(sparseIntArray, "$this$plus");
        j.f(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        j.f(sparseIntArray, "$this$putAll");
        j.f(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i2), sparseIntArray2.valueAt(i2));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i2, int i3) {
        j.f(sparseIntArray, "$this$remove");
        int iIndexOfKey = sparseIntArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || i3 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i2, int i3) {
        j.f(sparseIntArray, "$this$set");
        sparseIntArray.put(i2, i3);
    }

    public static final z valueIterator(final SparseIntArray sparseIntArray) {
        j.f(sparseIntArray, "$this$valueIterator");
        return new z() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // f.u.z
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
