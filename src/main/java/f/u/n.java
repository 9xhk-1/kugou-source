package f.u;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class n extends m {
    public static final <T> int j(Iterable<? extends T> iterable, int i2) {
        f.z.d.j.e(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
