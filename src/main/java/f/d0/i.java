package f.d0;

import f.u.m;
import f.z.c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public static final class a<T> implements Iterable<T> {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    public static final <T> Iterable<T> e(b<? extends T> bVar) {
        f.z.d.j.e(bVar, "$this$asIterable");
        return new a(bVar);
    }

    public static final <T, R> b<R> f(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        f.z.d.j.e(bVar, "$this$map");
        f.z.d.j.e(lVar, "transform");
        return new j(bVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C g(b<? extends T> bVar, C c) {
        f.z.d.j.e(bVar, "$this$toCollection");
        f.z.d.j.e(c, "destination");
        Iterator<? extends T> it = bVar.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> h(b<? extends T> bVar) {
        f.z.d.j.e(bVar, "$this$toList");
        return m.h(i(bVar));
    }

    public static final <T> List<T> i(b<? extends T> bVar) {
        f.z.d.j.e(bVar, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        g(bVar, arrayList);
        return arrayList;
    }
}
