package f.e0;

/* JADX INFO: loaded from: classes2.dex */
public class m extends l {
    public static final Integer f(String str) {
        f.z.d.j.e(str, "$this$toIntOrNull");
        return g(str, 10);
    }

    public static final Integer g(String str, int i2) {
        boolean z;
        int i3;
        f.z.d.j.e(str, "$this$toIntOrNull");
        a.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (f.z.d.j.g(cCharAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int iB = a.b(str.charAt(i6), i2);
            if (iB < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + iB) {
                return null;
            }
            i4 = i3 - iB;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static final Long h(String str) {
        f.z.d.j.e(str, "$this$toLongOrNull");
        return i(str, 10);
    }

    public static final Long i(String str, int i2) {
        f.z.d.j.e(str, "$this$toLongOrNull");
        a.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (f.z.d.j.g(cCharAt, 48) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i3 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i3 = 1;
                z = false;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i3 < length) {
            int iB = a.b(str.charAt(i3), i2);
            if (iB < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / ((long) i2);
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * ((long) i2);
            long j6 = iB;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i3++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
