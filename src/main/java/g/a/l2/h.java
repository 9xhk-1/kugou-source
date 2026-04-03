package g.a.l2;

import g.a.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class h<E> extends q implements o<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Throwable f1601f;

    public h(Throwable th) {
        this.f1601f = th;
    }

    @Override // g.a.l2.o
    public void completeResumeReceive(Object obj) {
        f.z.d.j.f(obj, "token");
        if (k0.a()) {
            if (!(obj == b.f1587g)) {
                throw new AssertionError();
            }
        }
    }

    @Override // g.a.l2.o
    public /* bridge */ /* synthetic */ Object getOfferResult() {
        w();
        return this;
    }

    @Override // g.a.l2.q
    public void s(Object obj) {
        f.z.d.j.f(obj, "token");
        if (k0.a()) {
            if (!(obj == b.f1587g)) {
                throw new AssertionError();
            }
        }
    }

    @Override // g.a.l2.q
    public /* bridge */ /* synthetic */ Object t() {
        x();
        return this;
    }

    @Override // g.a.n2.i
    public String toString() {
        return "Closed[" + this.f1601f + ']';
    }

    @Override // g.a.l2.o
    public Object tryResumeReceive(E e2, Object obj) {
        return b.f1587g;
    }

    @Override // g.a.l2.q
    public void u(h<?> hVar) {
        f.z.d.j.f(hVar, "closed");
        if (k0.a()) {
            throw new AssertionError();
        }
    }

    @Override // g.a.l2.q
    public Object v(Object obj) {
        return b.f1587g;
    }

    public h<E> w() {
        return this;
    }

    public h<E> x() {
        return this;
    }

    public final Throwable y() {
        Throwable th = this.f1601f;
        return th != null ? th : new i("Channel was closed");
    }

    public final Throwable z() {
        Throwable th = this.f1601f;
        return th != null ? th : new j("Channel was closed");
    }
}
