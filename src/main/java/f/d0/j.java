package f.d0;

import f.z.c.l;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T, R> implements b<R> {
    public final b<T> a;
    public final l<T, R> b;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public static final class a implements Iterator<R> {
        public final Iterator<T> a;

        public a() {
            this.a = j.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) j.this.b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        f.z.d.j.e(bVar, "sequence");
        f.z.d.j.e(lVar, "transformer");
        this.a = bVar;
        this.b = lVar;
    }

    @Override // f.d0.b
    public Iterator<R> iterator() {
        return new a();
    }
}
