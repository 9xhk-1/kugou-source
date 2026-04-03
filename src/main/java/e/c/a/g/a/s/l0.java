package e.c.a.g.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {
    public static <T> void a(List<T> list, r<T> rVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (rVar.isFilter(it.next())) {
                it.remove();
            }
        }
    }

    @Nullable
    public static <T> T b(T[] tArr, e.c.a.g.a.s.y1.b<T, Boolean> bVar) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            Boolean boolOnCall = bVar.onCall(t);
            if (boolOnCall != null && boolOnCall.booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public static <T> T c(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    @Nullable
    public static <T> T d(T[] tArr, int i2, T t) {
        return (tArr == null || i2 < 0 || i2 >= tArr.length) ? t : tArr[i2];
    }

    public static <T> int e(Collection<T> collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static <T> int f(T[] tArr) {
        if (tArr != null) {
            return tArr.length;
        }
        return 0;
    }

    public static <T> boolean g(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean h(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    public static <T> void i(List<T> list, int i2, @NonNull e.c.a.g.a.s.y1.a<List<T>> aVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i3 = 0;
        int size = list.size();
        while (i3 < size) {
            int iMin = Math.min(i3 + i2, size);
            aVar.onCall(list.subList(i3, iMin));
            i3 = iMin;
        }
    }
}
