package f.d0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class g extends f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // f.d0.b
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static final <T> b<T> c(Iterator<? extends T> it) {
        f.z.d.j.e(it, "$this$asSequence");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> d(b<? extends T> bVar) {
        f.z.d.j.e(bVar, "$this$constrainOnce");
        return bVar instanceof f.d0.a ? bVar : new f.d0.a(bVar);
    }
}
