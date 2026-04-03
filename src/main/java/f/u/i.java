package f.u;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h {
    public static final <T> boolean f(T[] tArr, T t) {
        f.z.d.j.e(tArr, "$this$contains");
        return k(tArr, t) >= 0;
    }

    public static final int g(int[] iArr) {
        f.z.d.j.e(iArr, "$this$first");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[0];
    }

    public static final Integer h(int[] iArr) {
        f.z.d.j.e(iArr, "$this$firstOrNull");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <T> T i(T[] tArr) {
        f.z.d.j.e(tArr, "$this$firstOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <T> int j(T[] tArr) {
        f.z.d.j.e(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final <T> int k(T[] tArr, T t) {
        f.z.d.j.e(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (f.z.d.j.a(t, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A l(T[] tArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.z.d.j.e(tArr, "$this$joinTo");
        f.z.d.j.e(a, "buffer");
        f.z.d.j.e(charSequence, "separator");
        f.z.d.j.e(charSequence2, "prefix");
        f.z.d.j.e(charSequence3, "postfix");
        f.z.d.j.e(charSequence4, "truncated");
        a.append(charSequence2);
        int i3 = 0;
        for (T t : tArr) {
            i3++;
            if (i3 > 1) {
                a.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            f.e0.f.a(a, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String m(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.z.d.j.e(tArr, "$this$joinToString");
        f.z.d.j.e(charSequence, "separator");
        f.z.d.j.e(charSequence2, "prefix");
        f.z.d.j.e(charSequence3, "postfix");
        f.z.d.j.e(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        l(tArr, sb, charSequence, charSequence2, charSequence3, i2, charSequence4, lVar);
        String string = sb.toString();
        f.z.d.j.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String n(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return m(objArr, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T o(T[] tArr) {
        f.z.d.j.e(tArr, "$this$last");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[j(tArr)];
    }

    public static final char p(char[] cArr) {
        f.z.d.j.e(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T q(T[] tArr) {
        f.z.d.j.e(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] r(T[] tArr, Comparator<? super T> comparator) {
        f.z.d.j.e(tArr, "$this$sortedArrayWith");
        f.z.d.j.e(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        f.z.d.j.d(tArr2, "java.util.Arrays.copyOf(this, size)");
        h.e(tArr2, comparator);
        return tArr2;
    }

    public static final <T> List<T> s(T[] tArr, Comparator<? super T> comparator) {
        f.z.d.j.e(tArr, "$this$sortedWith");
        f.z.d.j.e(comparator, "comparator");
        return h.a(r(tArr, comparator));
    }

    public static final <T, C extends Collection<? super T>> C t(T[] tArr, C c) {
        f.z.d.j.e(tArr, "$this$toCollection");
        f.z.d.j.e(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }
}
