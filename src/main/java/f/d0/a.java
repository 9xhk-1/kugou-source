package f.d0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements b<T> {
    public final AtomicReference<b<T>> a;

    public a(b<? extends T> bVar) {
        f.z.d.j.e(bVar, "sequence");
        this.a = new AtomicReference<>(bVar);
    }

    @Override // f.d0.b
    public Iterator<T> iterator() {
        b<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
