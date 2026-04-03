package e.c.a.g.a.f.j.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public c a;

    public static class b {
        public static final l a = new l();
    }

    static {
        b.a.c(new i());
    }

    public static l b() {
        return b.a;
    }

    public void a(List<e.c.a.g.a.f.j.b.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.a.addFees(arrayList);
    }

    public final void c(c cVar) {
        this.a = cVar;
    }

    public l() {
        e.c.a.g.a.r.b.c();
    }
}
