package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g, Serializable {
    public static final h a = new h();

    @Override // f.w.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        j.e(pVar, "operation");
        return r;
    }

    @Override // f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        j.e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // f.w.g
    public g minusKey(g.c<?> cVar) {
        j.e(cVar, "key");
        return this;
    }

    @Override // f.w.g
    public g plus(g gVar) {
        j.e(gVar, "context");
        return gVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
