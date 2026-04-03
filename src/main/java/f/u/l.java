package f.u;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static final <T> Object[] a(T[] tArr, boolean z) {
        f.z.d.j.e(tArr, "$this$copyToArrayOfAny");
        if (z && f.z.d.j.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        f.z.d.j.d(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> b(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        f.z.d.j.d(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }
}
