package f.e0;

/* JADX INFO: loaded from: classes2.dex */
public class n extends m {
    public static final boolean j(String str, String str2, boolean z) {
        f.z.d.j.e(str, "$this$endsWith");
        f.z.d.j.e(str2, "suffix");
        return !z ? str.endsWith(str2) : o(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return j(str, str2, z);
    }

    public static final boolean l(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean m(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return l(str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean n(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            f.z.d.j.e(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            f.b0.d r0 = f.e0.o.x(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = 1
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            f.u.z r3 = (f.u.z) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = f.e0.a.c(r3)
            if (r3 != 0) goto L24
            r4 = 0
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = 1
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f.e0.n.n(java.lang.CharSequence):boolean");
    }

    public static final boolean o(String str, int i2, String str2, int i3, int i4, boolean z) {
        f.z.d.j.e(str, "$this$regionMatches");
        f.z.d.j.e(str2, "other");
        return !z ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final String p(String str, String str2, String str3, boolean z) {
        f.z.d.j.e(str, "$this$replace");
        f.z.d.j.e(str2, "oldValue");
        f.z.d.j.e(str3, "newValue");
        int i2 = 0;
        int iA = o.A(str, str2, 0, z);
        if (iA < 0) {
            return str;
        }
        int length = str2.length();
        int iB = f.b0.f.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i2, iA);
            sb.append(str3);
            i2 = iA + length;
            if (iA >= str.length()) {
                break;
            }
            iA = o.A(str, str2, iA + iB, z);
        } while (iA > 0);
        sb.append((CharSequence) str, i2, str.length());
        String string = sb.toString();
        f.z.d.j.d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String q(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return p(str, str2, str3, z);
    }

    public static final boolean r(String str, String str2, boolean z) {
        f.z.d.j.e(str, "$this$startsWith");
        f.z.d.j.e(str2, "prefix");
        return !z ? str.startsWith(str2) : o(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean s(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return r(str, str2, z);
    }
}
