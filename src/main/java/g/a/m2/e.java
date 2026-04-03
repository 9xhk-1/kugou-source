package g.a.m2;

import f.s;
import f.z.c.p;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e<T> implements a<T> {
    public final p<b<? super T>, f.w.d<? super s>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(p<? super b<? super T>, ? super f.w.d<? super s>, ? extends Object> pVar) {
        j.f(pVar, "block");
        this.a = pVar;
    }

    @Override // g.a.m2.a
    public Object collect(b<? super T> bVar, f.w.d<? super s> dVar) {
        return this.a.invoke(new g.a.m2.f.a(bVar, dVar.getContext()), dVar);
    }
}
