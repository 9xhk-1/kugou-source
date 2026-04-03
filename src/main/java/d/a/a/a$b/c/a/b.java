package d.a.a.a$b.c.a;

import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a<d.a.a.a$b.c.b.c.b> {
    public final void a(d.a.a.a$b.c.b.c.b bVar) throws Throwable {
        j.e(bVar, "cardStateEvent");
        bVar.a(System.currentTimeMillis());
        ((d.a.a.a$b.c.b.a) this.a.getValue()).b(bVar);
        e.g.b.b.a.a("State.CardStateEventAggregate", j.l("CardEvent process : ", bVar));
    }
}
