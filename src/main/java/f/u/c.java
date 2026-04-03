package f.u;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements Iterator<T> {
    public i0 a = i0.NotReady;
    public T b;

    public abstract void a();

    public final void b() {
        this.a = i0.Done;
    }

    public final void c(T t) {
        this.b = t;
        this.a = i0.Ready;
    }

    public final boolean d() {
        this.a = i0.Failed;
        a();
        return this.a == i0.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        i0 i0Var = this.a;
        if (!(i0Var != i0.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = b.a[i0Var.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = i0.NotReady;
        return this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
