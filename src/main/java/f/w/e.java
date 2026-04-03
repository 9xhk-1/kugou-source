package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.j;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends g.b {
    public static final b c = b.a;

    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> cVar) {
            j.e(cVar, "key");
            if (!(cVar instanceof f.w.b)) {
                if (e.c != cVar) {
                    return null;
                }
                Objects.requireNonNull(eVar, "null cannot be cast to non-null type E");
                return eVar;
            }
            f.w.b bVar = (f.w.b) cVar;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e2 = (E) bVar.b(eVar);
            if (e2 instanceof g.b) {
                return e2;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> cVar) {
            j.e(cVar, "key");
            if (!(cVar instanceof f.w.b)) {
                return e.c == cVar ? h.a : eVar;
            }
            f.w.b bVar = (f.w.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.a;
        }

        public static void c(e eVar, d<?> dVar) {
            j.e(dVar, "continuation");
        }
    }

    public static final class b implements g.c<e> {
        public static final /* synthetic */ b a = new b();
    }

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar);

    @Override // f.w.g.b, f.w.g
    <E extends g.b> E get(g.c<E> cVar);

    @Override // f.w.g.b
    /* synthetic */ g.c<?> getKey();

    <T> d<T> interceptContinuation(d<? super T> dVar);

    @Override // f.w.g.b, f.w.g
    g minusKey(g.c<?> cVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ g plus(g gVar);

    void releaseInterceptedContinuation(d<?> dVar);
}
