package e.c.a.g.a.g.n.h;

import e.c.a.g.a.s.q;
import f.z.d.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    public static final int a(e.c.a.g.a.g.n.f.b bVar) {
        if (bVar == null) {
            return 0;
        }
        if (d(bVar)) {
            return 1;
        }
        return (g(bVar) && f(bVar)) ? 3 : 2;
    }

    public static final int b(e.c.a.g.a.g.n.f.b bVar) {
        if (bVar == null || bVar.g() <= 0) {
            return 4;
        }
        return a(bVar);
    }

    public static final boolean c(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "ringGoods");
        return (bVar.j() & 6) > 0;
    }

    public static final boolean d(e.c.a.g.a.g.n.f.b bVar) {
        if (bVar == null) {
            return false;
        }
        return !h(bVar) || (bVar.j() == 0 && bVar.c() == 0);
    }

    public static final boolean e(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "ringGoods");
        return (bVar.j() & 1) > 0;
    }

    public static final boolean f(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "ringGoods");
        return e(bVar) || c(bVar);
    }

    public static final boolean g(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "goods");
        return (bVar.i() & 2) == 0;
    }

    public static final boolean h(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "goods");
        return bVar.g() > 0;
    }

    public static final boolean i(e.c.a.g.a.g.n.f.b bVar) {
        j.e(bVar, "ringGoods");
        return ((bVar.a() & 32) > 0 && bVar.b() == 3) || (bVar.a() & 1) == 1;
    }

    public static final String j(CharSequence charSequence, String str) {
        j.e(charSequence, "title");
        j.e(str, "extension");
        String strC = e.c.a.g.a.f.f.a.c();
        q.f(strC);
        File file = new File(strC);
        int length = charSequence.length() - 1;
        String strL = "";
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (Character.isLetterOrDigit(charSequence.charAt(i2)) || '-' == charSequence.charAt(i2)) {
                    strL = j.l(strL, Character.valueOf(charSequence.charAt(i2)));
                }
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        }
        return file.getAbsolutePath() + '/' + strL + str;
    }

    public static final int k(int i2, e.c.a.g.a.g.n.g.c cVar) {
        j.e(cVar, "soundFile");
        return (int) ((((i2 * 1.0f) * cVar.g()) / cVar.h()) + 0.5f);
    }
}
