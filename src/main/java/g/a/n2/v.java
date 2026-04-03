package g.a.n2;

import f.w.g;
import g.a.d2;

/* JADX INFO: loaded from: classes2.dex */
public final class v<T> implements d2<T> {
    public final g.c<?> a;
    public final T b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<T> f1620d;

    public v(T t, ThreadLocal<T> threadLocal) {
        f.z.d.j.f(threadLocal, "threadLocal");
        this.b = t;
        this.f1620d = threadLocal;
        this.a = new w(threadLocal);
    }

    @Override // g.a.d2, f.w.g.b, f.w.g
    public <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar) {
        f.z.d.j.f(pVar, "operation");
        return (R) d2.a.a(this, r, pVar);
    }

    @Override // g.a.d2, f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        f.z.d.j.f(cVar, "key");
        if (f.z.d.j.a(getKey(), cVar)) {
            return this;
        }
        return null;
    }

    @Override // g.a.d2, f.w.g.b
    public g.c<?> getKey() {
        return this.a;
    }

    @Override // g.a.d2, f.w.g.b, f.w.g
    public f.w.g minusKey(g.c<?> cVar) {
        f.z.d.j.f(cVar, "key");
        return f.z.d.j.a(getKey(), cVar) ? f.w.h.a : this;
    }

    @Override // g.a.d2, f.w.g.b, f.w.g
    public f.w.g plus(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        return d2.a.d(this, gVar);
    }

    @Override // g.a.d2
    public void restoreThreadContext(f.w.g gVar, T t) {
        f.z.d.j.f(gVar, "context");
        this.f1620d.set(t);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.b + ", threadLocal = " + this.f1620d + ')';
    }

    @Override // g.a.d2
    public T updateThreadContext(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        T t = this.f1620d.get();
        this.f1620d.set(this.b);
        return t;
    }
}
