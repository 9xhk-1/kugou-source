package androidx.core.util;

import android.util.SparseArray;
import f.s;
import f.u.z;
import f.z.c.a;
import f.z.c.p;
import f.z.d.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i2) {
        j.f(sparseArray, "$this$contains");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i2) {
        j.f(sparseArray, "$this$containsKey");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        j.f(sparseArray, "$this$containsValue");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p<? super Integer, ? super T, s> pVar) {
        j.f(sparseArray, "$this$forEach");
        j.f(pVar, "action");
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$getOrDefault");
        T t2 = sparseArray.get(i2);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i2, a<? extends T> aVar) {
        j.f(sparseArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        T t = sparseArray.get(i2);
        return t != null ? t : aVar.invoke();
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$size");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$isEmpty");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$isNotEmpty");
        return sparseArray.size() != 0;
    }

    public static final <T> z keyIterator(final SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$keyIterator");
        return new z() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // f.u.z
            public int nextInt() {
                SparseArray sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        j.f(sparseArray, "$this$plus");
        j.f(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        j.f(sparseArray, "$this$putAll");
        j.f(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$remove");
        int iIndexOfKey = sparseArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || !j.a(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$set");
        sparseArray.put(i2, t);
    }

    public static final <T> Iterator<T> valueIterator(final SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$valueIterator");
        return new Iterator<T>() { // from class: androidx.core.util.SparseArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // java.util.Iterator
            public T next() {
                SparseArray sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return (T) sparseArray2.valueAt(i2);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
