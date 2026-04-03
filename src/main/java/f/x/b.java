package f.x;

import f.e0.o;
import f.z.d.j;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final a a;

    /* JADX WARN: Removed duplicated region for block: B:43:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.b.<clinit>():void");
    }

    public static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iD = o.D(property, '.', 0, false, 6, null);
        if (iD < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = iD + 1;
        int iD2 = o.D(property, '.', i2, false, 4, null);
        if (iD2 < 0) {
            iD2 = property.length();
        }
        Objects.requireNonNull(property, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = property.substring(0, iD);
        j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(property, "null cannot be cast to non-null type java.lang.String");
        String strSubstring2 = property.substring(i2, iD2);
        j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
