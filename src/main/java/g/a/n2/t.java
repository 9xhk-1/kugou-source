package g.a.n2;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t {
    public static final int a(String str, int i2, int i3, int i4) {
        f.z.d.j.f(str, "propertyName");
        return (int) r.c(str, i2, i3, i4);
    }

    public static final long b(String str, long j, long j2, long j3) {
        f.z.d.j.f(str, "propertyName");
        String strD = r.d(str);
        if (strD == null) {
            return j;
        }
        Long lH = f.e0.m.h(strD);
        if (lH == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lH.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final boolean c(String str, boolean z) {
        f.z.d.j.f(str, "propertyName");
        String strD = r.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z;
    }

    public static /* synthetic */ int d(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return r.b(str, i2, i3, i4);
    }

    public static /* synthetic */ long e(String str, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return r.c(str, j, j4, j3);
    }
}
