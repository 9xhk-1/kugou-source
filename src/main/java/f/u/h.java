package f.u;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    public static final <T> List<T> a(T[] tArr) {
        f.z.d.j.e(tArr, "$this$asList");
        List<T> listA = j.a(tArr);
        f.z.d.j.d(listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    public static final <T> T[] b(T[] tArr, T[] tArr2, int i2, int i3, int i4) {
        f.z.d.j.e(tArr, "$this$copyInto");
        f.z.d.j.e(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ Object[] c(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        b(objArr, objArr2, i2, i3, i4);
        return objArr2;
    }

    public static final <T> void d(T[] tArr, T t, int i2, int i3) {
        f.z.d.j.e(tArr, "$this$fill");
        Arrays.fill(tArr, i2, i3, t);
    }

    public static final <T> void e(T[] tArr, Comparator<? super T> comparator) {
        f.z.d.j.e(tArr, "$this$sortWith");
        f.z.d.j.e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
