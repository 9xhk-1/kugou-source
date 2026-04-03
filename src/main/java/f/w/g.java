package f.w;

import f.w.e;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: f.w.g$a$a, reason: collision with other inner class name */
        public static final class C0268a extends k implements p<g, b, g> {
            public static final C0268a a = new C0268a();

            public C0268a() {
                super(2);
            }

            @Override // f.z.c.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g gVar, b bVar) {
                f.w.c cVar;
                j.e(gVar, "acc");
                j.e(bVar, "element");
                g gVarMinusKey = gVar.minusKey(bVar.getKey());
                h hVar = h.a;
                if (gVarMinusKey == hVar) {
                    return bVar;
                }
                e.b bVar2 = e.c;
                e eVar = (e) gVarMinusKey.get(bVar2);
                if (eVar == null) {
                    cVar = new f.w.c(gVarMinusKey, bVar);
                } else {
                    g gVarMinusKey2 = gVarMinusKey.minusKey(bVar2);
                    if (gVarMinusKey2 == hVar) {
                        return new f.w.c(bVar, eVar);
                    }
                    cVar = new f.w.c(new f.w.c(gVarMinusKey2, bVar), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g gVar2) {
            j.e(gVar2, "context");
            return gVar2 == h.a ? gVar : (g) gVar2.fold(gVar, C0268a.a);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(b bVar, R r, p<? super R, ? super b, ? extends R> pVar) {
                j.e(pVar, "operation");
                return pVar.invoke(r, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                j.e(cVar, "key");
                if (!j.a(bVar.getKey(), cVar)) {
                    return null;
                }
                Objects.requireNonNull(bVar, "null cannot be cast to non-null type E");
                return bVar;
            }

            public static g c(b bVar, c<?> cVar) {
                j.e(cVar, "key");
                return j.a(bVar.getKey(), cVar) ? h.a : bVar;
            }

            public static g d(b bVar, g gVar) {
                j.e(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        @Override // f.w.g
        <R> R fold(R r, p<? super R, ? super b, ? extends R> pVar);

        @Override // f.w.g
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        @Override // f.w.g
        g minusKey(c<?> cVar);

        @Override // f.w.g
        /* synthetic */ g plus(g gVar);
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    g minusKey(c<?> cVar);

    g plus(g gVar);
}
