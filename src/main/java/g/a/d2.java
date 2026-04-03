package g.a;

import f.w.g;

/* JADX INFO: loaded from: classes2.dex */
public interface d2<S> extends g.b {

    public static final class a {
        public static <S, R> R a(d2<S> d2Var, R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar) {
            f.z.d.j.f(pVar, "operation");
            return (R) g.b.a.a(d2Var, r, pVar);
        }

        public static <S, E extends g.b> E b(d2<S> d2Var, g.c<E> cVar) {
            f.z.d.j.f(cVar, "key");
            return (E) g.b.a.b(d2Var, cVar);
        }

        public static <S> f.w.g c(d2<S> d2Var, g.c<?> cVar) {
            f.z.d.j.f(cVar, "key");
            return g.b.a.c(d2Var, cVar);
        }

        public static <S> f.w.g d(d2<S> d2Var, f.w.g gVar) {
            f.z.d.j.f(gVar, "context");
            return g.b.a.d(d2Var, gVar);
        }
    }

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <E extends g.b> E get(g.c<E> cVar);

    @Override // f.w.g.b
    /* synthetic */ g.c<?> getKey();

    @Override // f.w.g.b, f.w.g
    /* synthetic */ f.w.g minusKey(g.c<?> cVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ f.w.g plus(f.w.g gVar);

    void restoreThreadContext(f.w.g gVar, S s);

    S updateThreadContext(f.w.g gVar);
}
