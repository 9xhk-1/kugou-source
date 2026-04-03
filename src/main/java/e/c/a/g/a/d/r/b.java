package e.c.a.g.a.d.r;

import androidx.annotation.Nullable;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b b;
    public final o0<Long, e.c.a.g.a.d.r.p.a.c> a = new o0<>(3000, 200, 0.75f);

    public static b d() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public void a(List<e.c.a.g.a.d.r.p.a.c> list) {
        if (l0.g(list)) {
            return;
        }
        for (e.c.a.g.a.d.r.p.a.c cVar : list) {
            if (cVar != null && cVar.q() > 0) {
                this.a.put(Long.valueOf(cVar.q()), cVar);
            }
        }
    }

    public void b() {
        this.a.clear();
    }

    @Nullable
    public e.c.a.g.a.d.r.p.a.c c(long j) {
        if (j <= 0) {
            return null;
        }
        return this.a.get(Long.valueOf(j));
    }
}
