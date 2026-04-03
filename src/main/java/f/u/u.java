package f.u;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class u extends t {
    public static final <T> String A(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.z.d.j.e(iterable, "$this$joinToString");
        f.z.d.j.e(charSequence, "separator");
        f.z.d.j.e(charSequence2, "prefix");
        f.z.d.j.e(charSequence3, "postfix");
        f.z.d.j.e(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        y(iterable, sb, charSequence, charSequence2, charSequence3, i2, charSequence4, lVar);
        String string = sb.toString();
        f.z.d.j.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String B(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l lVar, int i3, Object obj) {
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
        return A(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T C(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) D((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> T D(List<? extends T> list) {
        f.z.d.j.e(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(m.e(list));
    }

    public static final <T extends Comparable<? super T>> T E(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$minOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> F(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return M(iterable);
        }
        List<T> listN = N(iterable);
        t.m(listN);
        return listN;
    }

    public static final <T> T G(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) H((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T H(List<? extends T> list) {
        f.z.d.j.e(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> I(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        f.z.d.j.e(iterable, "$this$sortedWith");
        f.z.d.j.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listN = N(iterable);
            q.k(listN, comparator);
            return listN;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return M(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        h.e(array, comparator);
        return h.a(array);
    }

    public static final <T> List<T> J(Iterable<? extends T> iterable, int i2) {
        f.z.d.j.e(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return m.d();
        }
        if (iterable instanceof Collection) {
            if (i2 >= ((Collection) iterable).size()) {
                return M(iterable);
            }
            if (i2 == 1) {
                return l.b(t(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return m.h(arrayList);
    }

    public static final <T, C extends Collection<? super T>> C K(Iterable<? extends T> iterable, C c) {
        f.z.d.j.e(iterable, "$this$toCollection");
        f.z.d.j.e(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final int[] L(Collection<Integer> collection) {
        f.z.d.j.e(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        return iArr;
    }

    public static final <T> List<T> M(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return m.h(N(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m.d();
        }
        if (size != 1) {
            return O(collection);
        }
        return l.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> N(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return O((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        K(iterable, arrayList);
        return arrayList;
    }

    public static final <T> List<T> O(Collection<? extends T> collection) {
        f.z.d.j.e(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> P(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$toMutableSet");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        K(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static final <T> List<List<T>> Q(Iterable<? extends T> iterable, int i2, int i3, boolean z) {
        f.z.d.j.e(iterable, "$this$windowed");
        h0.a(i2, i3);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = h0.b(iterable.iterator(), i2, i3, z, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i3) + (size % i3 == 0 ? 0 : 1));
        int i4 = 0;
        while (i4 >= 0 && size > i4) {
            int iE = f.b0.f.e(i2, size - i4);
            if (iE < i2 && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iE);
            for (int i5 = 0; i5 < iE; i5++) {
                arrayList3.add(list.get(i5 + i4));
            }
            arrayList2.add(arrayList3);
            i4 += i3;
        }
        return arrayList2;
    }

    public static final <T> List<List<T>> n(Iterable<? extends T> iterable, int i2) {
        f.z.d.j.e(iterable, "$this$chunked");
        return Q(iterable, i2, i2, true);
    }

    public static final <T> boolean o(Iterable<? extends T> iterable, T t) {
        f.z.d.j.e(iterable, "$this$contains");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t) : x(iterable, t) >= 0;
    }

    public static final <T> List<T> p(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$distinct");
        return M(P(iterable));
    }

    public static final <T> List<T> q(Iterable<? extends T> iterable, int i2) {
        ArrayList arrayList;
        f.z.d.j.e(iterable, "$this$drop");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return M(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i2;
            if (size <= 0) {
                return m.d();
            }
            if (size == 1) {
                return l.b(C(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i2 < size2) {
                        arrayList.add(((List) iterable).get(i2));
                        i2++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t : iterable) {
            if (i3 >= i2) {
                arrayList.add(t);
            } else {
                i3++;
            }
        }
        return m.h(arrayList);
    }

    public static final <T> List<T> r(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        s(iterable, arrayList);
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C s(Iterable<? extends T> iterable, C c) {
        f.z.d.j.e(iterable, "$this$filterNotNullTo");
        f.z.d.j.e(c, "destination");
        for (T t : iterable) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    public static final <T> T t(Iterable<? extends T> iterable) {
        f.z.d.j.e(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) u((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T u(List<? extends T> list) {
        f.z.d.j.e(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T v(List<? extends T> list) {
        f.z.d.j.e(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T w(List<? extends T> list, int i2) {
        f.z.d.j.e(list, "$this$getOrNull");
        if (i2 < 0 || i2 > m.e(list)) {
            return null;
        }
        return list.get(i2);
    }

    public static final <T> int x(Iterable<? extends T> iterable, T t) {
        f.z.d.j.e(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i2 = 0;
        for (T t2 : iterable) {
            if (i2 < 0) {
                m.i();
                throw null;
            }
            if (f.z.d.j.a(t, t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A y(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.z.d.j.e(iterable, "$this$joinTo");
        f.z.d.j.e(a, "buffer");
        f.z.d.j.e(charSequence, "separator");
        f.z.d.j.e(charSequence2, "prefix");
        f.z.d.j.e(charSequence3, "postfix");
        f.z.d.j.e(charSequence4, "truncated");
        a.append(charSequence2);
        int i3 = 0;
        for (T t : iterable) {
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

    public static /* synthetic */ Appendable z(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, f.z.c.l lVar, int i3, Object obj) throws IOException {
        y(iterable, appendable, (i3 & 2) != 0 ? ", " : charSequence, (i3 & 4) != 0 ? "" : charSequence2, (i3 & 8) == 0 ? charSequence3 : "", (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : lVar);
        return appendable;
    }
}
