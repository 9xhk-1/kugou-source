package f.w;

import f.w.g;
import f.w.g.b;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {
    public final g.c<?> a;
    public final l<g.b, E> b;

    public final boolean a(g.c<?> cVar) {
        j.e(cVar, "key");
        return cVar == this || this.a == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lf/w/g$b;)TE; */
    public final g.b b(g.b bVar) {
        j.e(bVar, "element");
        return (g.b) this.b.invoke(bVar);
    }
}
