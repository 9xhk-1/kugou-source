package f.b0;

import f.z.d.j;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
public interface a<T extends Comparable<? super T>> {

    /* JADX INFO: renamed from: f.b0.a$a, reason: collision with other inner class name */
    public static final class C0265a {
        public static <T extends Comparable<? super T>> boolean a(a<T> aVar, T t) {
            j.e(t, "value");
            return t.compareTo(aVar.getStart()) >= 0 && t.compareTo(aVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(a<T> aVar) {
            return aVar.getStart().compareTo(aVar.getEndInclusive()) > 0;
        }
    }

    boolean contains(T t);

    T getEndInclusive();

    T getStart();

    boolean isEmpty();
}
