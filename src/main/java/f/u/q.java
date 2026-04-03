package f.u;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public static final <T> void k(List<T> list, Comparator<? super T> comparator) {
        f.z.d.j.e(list, "$this$sortWith");
        f.z.d.j.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
