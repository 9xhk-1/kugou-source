package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> cVar) {
        j.e(cVar, "key");
        this.key = cVar;
    }

    @Override // f.w.g.b, f.w.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        j.e(pVar, "operation");
        return (R) g.b.a.a(this, r, pVar);
    }

    @Override // f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        j.e(cVar, "key");
        return (E) g.b.a.b(this, cVar);
    }

    @Override // f.w.g.b
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // f.w.g.b, f.w.g
    public g minusKey(g.c<?> cVar) {
        j.e(cVar, "key");
        return g.b.a.c(this, cVar);
    }

    @Override // f.w.g.b, f.w.g
    public g plus(g gVar) {
        j.e(gVar, "context");
        return g.b.a.d(this, gVar);
    }
}
