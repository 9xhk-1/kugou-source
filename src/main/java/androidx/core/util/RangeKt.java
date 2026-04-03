package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import f.b0.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        j.f(range, "$this$and");
        j.f(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        j.b(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        j.f(range, "$this$plus");
        j.f(t, "value");
        Range<T> rangeExtend = range.extend(t);
        j.b(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        j.f(t, "$this$rangeTo");
        j.f(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> a<T> toClosedRange(final Range<T> range) {
        j.f(range, "$this$toClosedRange");
        return (a<T>) new a<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // f.b0.a
            public boolean contains(Comparable comparable) {
                j.f(comparable, "value");
                return a.C0265a.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // f.b0.a
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // f.b0.a
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // f.b0.a
            public boolean isEmpty() {
                return a.C0265a.b(this);
            }
        };
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(a<T> aVar) {
        j.f(aVar, "$this$toRange");
        return new Range<>(aVar.getStart(), aVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        j.f(range, "$this$plus");
        j.f(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        j.b(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
