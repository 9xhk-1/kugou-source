package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {
    public static final j1 a = new j1();
    public static String[] b;

    public static final boolean a(String str) {
        f.z.d.j.e(str, "flag");
        boolean z = false;
        if (b == null) {
            b = e.c.a.g.a.f.e.c.a.a().getAllValuesOfConfig(e.c.a.g.a.f.e.b.q4);
            if (g0.a) {
                String[] strArr = b;
                g0.b("SwitchConfigUtil", f.z.d.j.l("justDoItV2 mSwitchConfig:", Boolean.valueOf(strArr != null && f.u.i.f(strArr, str))));
            }
        }
        String[] strArr2 = b;
        if (strArr2 != null && f.u.i.f(strArr2, str)) {
            z = true;
        }
        if (g0.a) {
            g0.b("SwitchConfigUtil", "vipSwitchConfig:" + str + ", result: " + z);
        }
        return z;
    }
}
