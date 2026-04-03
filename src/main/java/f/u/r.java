package f.u;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class r extends q {
    public static final <T> boolean l(Collection<? super T> collection, T[] tArr) {
        f.z.d.j.e(collection, "$this$addAll");
        f.z.d.j.e(tArr, "elements");
        return collection.addAll(h.a(tArr));
    }
}
