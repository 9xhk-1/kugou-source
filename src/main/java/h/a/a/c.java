package h.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class c<E> implements Iterable<E> {
    public final List<E> a = new ArrayList();
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1663d;

    public class b implements Object<E> {
        public int a;
        public int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1664d;

        public final void a() {
            if (this.f1664d) {
                return;
            }
            this.f1664d = true;
            c.this.g();
        }

        public boolean hasNext() {
            int i2 = this.b;
            while (i2 < this.a && c.this.h(i2) == null) {
                i2++;
            }
            if (i2 < this.a) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.b;
                if (i2 >= this.a || c.this.h(i2) != null) {
                    break;
                }
                this.b++;
            }
            int i3 = this.b;
            if (i3 >= this.a) {
                a();
                throw new NoSuchElementException();
            }
            c cVar = c.this;
            this.b = i3 + 1;
            return (E) cVar.h(i3);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            c.this.i();
            this.a = c.this.e();
        }
    }

    public final int e() {
        return this.a.size();
    }

    public final void f() {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (this.a.get(size) == null) {
                this.a.remove(size);
            }
        }
    }

    public final void g() {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 <= 0 && this.f1663d) {
            this.f1663d = false;
            f();
        }
    }

    public final E h(int i2) {
        return this.a.get(i2);
    }

    public final void i() {
        this.b++;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }
}
