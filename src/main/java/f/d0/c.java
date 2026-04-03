package f.d0;

import f.j;
import f.k;
import f.s;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends d<T> implements Iterator<T>, f.w.d<s> {
    public int a;
    public T b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Iterator<? extends T> f1514d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f.w.d<? super s> f1515f;

    @Override // f.d0.d
    public Object a(T t, f.w.d<? super s> dVar) {
        this.b = t;
        this.a = 3;
        this.f1515f = dVar;
        Object objD = f.w.i.c.d();
        if (objD == f.w.i.c.d()) {
            f.w.j.a.h.c(dVar);
        }
        return objD == f.w.i.c.d() ? objD : s.a;
    }

    public final Throwable b() {
        int i2 = this.a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    public final T c() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void d(f.w.d<? super s> dVar) {
        this.f1515f = dVar;
    }

    @Override // f.w.d
    public f.w.g getContext() {
        return f.w.h.a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator<? extends T> it = this.f1514d;
                f.z.d.j.c(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.f1514d = null;
            }
            this.a = 5;
            f.w.d<? super s> dVar = this.f1515f;
            f.z.d.j.c(dVar);
            this.f1515f = null;
            s sVar = s.a;
            j.a aVar = f.j.a;
            f.j.a(sVar);
            dVar.resumeWith(sVar);
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            return c();
        }
        if (i2 == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.f1514d;
            f.z.d.j.c(it);
            return it.next();
        }
        if (i2 != 3) {
            throw b();
        }
        this.a = 0;
        T t = this.b;
        this.b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // f.w.d
    public void resumeWith(Object obj) throws Throwable {
        k.b(obj);
        this.a = 4;
    }
}
