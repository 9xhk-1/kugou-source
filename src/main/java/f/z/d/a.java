package f.z.d;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements Iterator<T> {
    public int a;
    public final T[] b;

    public a(T[] tArr) {
        j.e(tArr, "array");
        this.b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.b;
            int i2 = this.a;
            this.a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
