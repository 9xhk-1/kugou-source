package g.a;

import f.w.e;
import f.w.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends f.w.a implements f.w.e {
    public b0() {
        super(f.w.e.c);
    }

    public abstract void a(f.w.g gVar, Runnable runnable);

    public boolean b(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        return true;
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        f.z.d.j.f(cVar, "key");
        return (E) e.a.a(this, cVar);
    }

    @Override // f.w.e
    public final <T> f.w.d<T> interceptContinuation(f.w.d<? super T> dVar) {
        f.z.d.j.f(dVar, "continuation");
        return new n0(this, dVar);
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public f.w.g minusKey(g.c<?> cVar) {
        f.z.d.j.f(cVar, "key");
        return e.a.b(this, cVar);
    }

    @Override // f.w.e
    public void releaseInterceptedContinuation(f.w.d<?> dVar) {
        f.z.d.j.f(dVar, "continuation");
        e.a.c(this, dVar);
    }

    public String toString() {
        return l0.a(this) + '@' + l0.b(this);
    }
}
