package f.b0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends e {
    public static final float a(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static final int b(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static final long c(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final float d(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static final int e(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static final long f(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final float g(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    public static final int h(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static final b i(int i2, int i3) {
        return b.f1508f.a(i2, i3, -1);
    }

    public static final d j(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? d.f1513i.a() : new d(i2, i3 - 1);
    }
}
