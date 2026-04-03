package e.c.a.g.a.f.j.c;

import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.h;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a() {
        return !b() || e.c.a.g.a.r.b.G();
    }

    public static boolean b() {
        return c() && e.c.a.g.a.r.b.h() != 1;
    }

    public static boolean c() {
        return e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.W, 0) == 1;
    }

    public static boolean d(e.c.a.g.a.d.r.p.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ((g.o(cVar) && !g.d(cVar)) || h.h(cVar.t())) {
            return false;
        }
        if (e.c.a.g.a.r.b.O() && g.e(cVar)) {
            return false;
        }
        return (g.C(cVar) || g.d(cVar) || g.b(cVar)) && !g.m(cVar);
    }
}
