package e.c.a.g.a.r.e;

import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.s0;
import f.e0.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final boolean a() {
        int i2;
        int i3;
        String strB = e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.q3, null);
        if (strB == null || strB.length() == 0) {
            i2 = 7;
            i3 = 1;
        } else {
            try {
                List listS = o.S(strB, new String[]{"_"}, false, 0, 6, null);
                i2 = Integer.parseInt((String) listS.get(0));
                i3 = Integer.parseInt((String) listS.get(1));
            } catch (Exception unused) {
                return false;
            }
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        long jD = k.d(System.currentTimeMillis());
        long jD2 = k.d(e.c.a.g.a.f.m.b.m().o());
        if (g0.a) {
            g0.b("LoginGuider", "checkJumpLogin: today:" + ((Object) k.b(jD)) + ", lastDay:" + ((Object) k.b(jD2)));
        }
        if (jD - jD2 >= i2 * 86400000) {
            e.c.a.g.a.f.m.b.m().Z(0);
        }
        int iP = e.c.a.g.a.f.m.b.m().p();
        if (g0.a) {
            g0.b("LoginGuider", "checkJumpLogin: show:" + iP + ", max:" + i3);
        }
        if (iP >= i3) {
            return false;
        }
        if (iP <= 0) {
            e.c.a.g.a.f.m.b.m().Y(jD);
        }
        e.c.a.g.a.f.m.b.m().Z(iP + 1);
        b();
        return true;
    }

    public final void b() {
        s0.a.l("10");
    }

    public final void c() {
        e.c.a.g.a.f.m.b.m().Y(k.d(System.currentTimeMillis()));
        e.c.a.g.a.f.m.b.m().Z(1);
    }
}
