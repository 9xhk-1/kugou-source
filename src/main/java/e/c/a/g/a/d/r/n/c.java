package e.c.a.g.a.d.r.n;

import e.c.a.g.a.f.o.g.e.d;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.a {
    public e.c.a.g.a.f.o.g.e.d a;

    public void a(b bVar) {
        e.c.a.g.a.f.o.g.e.d dVar = this.a;
        if (dVar != null) {
            dVar.e(65537, bVar).f();
        }
    }

    public void b() {
        e.c.a.g.a.f.o.g.e.d dVar = this.a;
        if (dVar != null) {
            dVar.f(65537);
        }
    }

    public void c() {
        this.a = new e.c.a.g.a.f.o.g.e.d("FeeSubTaskDispatcher", this);
    }

    @Override // e.c.a.g.a.f.o.g.e.d.a
    public boolean handleInstruction(e.c.a.g.a.f.o.g.e.a aVar) {
        if (aVar.a != 65537) {
            return false;
        }
        try {
            ((b) aVar.b).run();
            return false;
        } catch (Exception e2) {
            g0.k(e2);
            return false;
        }
    }
}
