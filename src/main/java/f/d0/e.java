package f.d0;

import f.s;
import f.z.c.p;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {
        public final /* synthetic */ p a;

        public a(p pVar) {
            this.a = pVar;
        }

        @Override // f.d0.b
        public Iterator<T> iterator() {
            return e.a(this.a);
        }
    }

    public static final <T> Iterator<T> a(p<? super d<? super T>, ? super f.w.d<? super s>, ? extends Object> pVar) {
        f.z.d.j.e(pVar, "block");
        c cVar = new c();
        cVar.d(f.w.i.b.b(pVar, cVar, cVar));
        return cVar;
    }

    public static final <T> b<T> b(p<? super d<? super T>, ? super f.w.d<? super s>, ? extends Object> pVar) {
        f.z.d.j.e(pVar, "block");
        return new a(pVar);
    }
}
