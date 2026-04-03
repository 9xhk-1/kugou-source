package f.u;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends c0 {
    public static final <K, V> Map<K, V> d() {
        x xVar = x.a;
        Objects.requireNonNull(xVar, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return xVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        f.z.d.j.e(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        return size != 0 ? size != 1 ? map : c0.c(map) : d();
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends f.i<? extends K, ? extends V>> iterable) {
        f.z.d.j.e(map, "$this$putAll");
        f.z.d.j.e(iterable, "pairs");
        for (f.i<? extends K, ? extends V> iVar : iterable) {
            map.put(iVar.a(), iVar.b());
        }
    }

    public static final <K, V> Map<K, V> g(Iterable<? extends f.i<? extends K, ? extends V>> iterable) {
        f.z.d.j.e(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            h(iterable, linkedHashMap);
            return e(linkedHashMap);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size == 1) {
            return c0.b(iterable instanceof List ? (f.i<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(c0.a(collection.size()));
        h(iterable, linkedHashMap2);
        return linkedHashMap2;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends f.i<? extends K, ? extends V>> iterable, M m) {
        f.z.d.j.e(iterable, "$this$toMap");
        f.z.d.j.e(m, "destination");
        f(m, iterable);
        return m;
    }
}
