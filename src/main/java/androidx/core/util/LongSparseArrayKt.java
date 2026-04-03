package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import f.s;
import f.u.a0;
import f.z.c.a;
import f.z.c.p;
import f.z.d.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        j.f(longSparseArray, "$this$contains");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        j.f(longSparseArray, "$this$containsKey");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        j.f(longSparseArray, "$this$containsValue");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p<? super Long, ? super T, s> pVar) {
        j.f(longSparseArray, "$this$forEach");
        j.f(pVar, "action");
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        j.f(longSparseArray, "$this$getOrDefault");
        T t2 = longSparseArray.get(j);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, a<? extends T> aVar) {
        j.f(longSparseArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : aVar.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        j.f(longSparseArray, "$this$size");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        j.f(longSparseArray, "$this$isEmpty");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        j.f(longSparseArray, "$this$isNotEmpty");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> a0 keyIterator(final LongSparseArray<T> longSparseArray) {
        j.f(longSparseArray, "$this$keyIterator");
        return new a0() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // f.u.a0
            public long nextLong() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        j.f(longSparseArray, "$this$plus");
        j.f(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        j.f(longSparseArray, "$this$putAll");
        j.f(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.put(longSparseArray2.keyAt(i2), longSparseArray2.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        j.f(longSparseArray, "$this$remove");
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !j.a(t, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        j.f(longSparseArray, "$this$set");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(final LongSparseArray<T> longSparseArray) {
        j.f(longSparseArray, "$this$valueIterator");
        return new Iterator<T>() { // from class: androidx.core.util.LongSparseArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // java.util.Iterator
            public T next() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return (T) longSparseArray2.valueAt(i2);
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
