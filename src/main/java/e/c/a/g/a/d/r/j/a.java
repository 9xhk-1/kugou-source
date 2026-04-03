package e.c.a.g.a.d.r.j;

import android.content.Context;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.j.c.e;
import e.c.a.g.a.d.r.n.d;
import e.c.a.g.a.d.r.o.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(List list) {
        if (list != null) {
            list.clear();
        }
    }

    public static e b(d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar instanceof c ? new e.c.a.g.a.d.r.j.e.c((c) dVar) : dVar instanceof e.c.a.g.a.d.r.k.b ? new e.c.a.g.a.d.r.j.e.b((e.c.a.g.a.d.r.k.b) dVar) : dVar instanceof e.c.a.g.a.d.r.m.a ? new e.c.a.g.a.d.r.j.e.a((e.c.a.g.a.d.r.m.a) dVar) : new e.c.a.g.a.d.r.j.e.d(dVar);
    }

    public static boolean c(e.c.a.g.a.d.r.p.a.c cVar) {
        return g.a(cVar) && g.b(cVar);
    }

    public static boolean d(e.c.a.g.a.d.r.p.a.c cVar, String str) {
        return "album".equals(cVar.D()) && "Album".equals(str);
    }

    public static void e(String str, String str2, List<e.c.a.g.a.d.r.n.a<?>> list) {
    }

    public static void f(Context context) {
    }
}
