package f.u;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g0 extends f0 {
    public static final <T> Set<T> a(T... tArr) {
        f.z.d.j.e(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(c0.a(tArr.length));
        i.t(tArr, linkedHashSet);
        return linkedHashSet;
    }
}
