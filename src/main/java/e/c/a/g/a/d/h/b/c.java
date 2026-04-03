package e.c.a.g.a.d.h.b;

import e.c.a.g.a.s.g0;
import f.u.m;
import f.z.d.j;
import f.z.d.k;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();
    public static final f.d b = f.f.b(a.a);

    public static final class a extends k implements f.z.c.a<List<? extends Float>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public final List<? extends Float> invoke() {
            return m.f(Float.valueOf(110.0f), Float.valueOf(115.0f));
        }
    }

    public final List<Float> a() {
        return (List) b.getValue();
    }

    public final boolean b() {
        int iF = e.c.a.g.a.g.p.b.f1018d.a().f() * 86400000;
        long jD = e.c.a.g.a.s.k.d(System.currentTimeMillis()) - e.c.a.g.a.s.k.d(e.c.a.g.a.f.m.b.m().j());
        if (jD >= iF) {
            return true;
        }
        if (!g0.a) {
            return false;
        }
        g0.b("DialogShowCtrl", j.l("isCanShow: passDay=", Long.valueOf(jD / ((long) 86400000))));
        return false;
    }

    public final boolean c(float f2) {
        return a().contains(Float.valueOf(f2));
    }

    public final void d(float f2) {
        if (a().contains(Float.valueOf(f2))) {
            e();
        }
    }

    public final void e() {
        e.c.a.g.a.f.m.b.m().P(System.currentTimeMillis());
    }
}
