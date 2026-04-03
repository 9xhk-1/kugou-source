package f.u;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m extends l {
    public static final <T> ArrayList<T> c(T... tArr) {
        f.z.d.j.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new e(tArr, true));
    }

    public static final <T> List<T> d() {
        return w.a;
    }

    public static final <T> int e(List<? extends T> list) {
        f.z.d.j.e(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> f(T... tArr) {
        f.z.d.j.e(tArr, "elements");
        return tArr.length > 0 ? h.a(tArr) : d();
    }

    public static final <T> List<T> g(T... tArr) {
        f.z.d.j.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new e(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> h(List<? extends T> list) {
        f.z.d.j.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : l.b(list.get(0)) : d();
    }

    public static final void i() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
