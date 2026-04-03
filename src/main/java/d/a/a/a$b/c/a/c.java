package d.a.a.a$b.c.a;

import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a<d.a.a.a$b.c.b.c.c> {
    public final void a(d.a.a.a$b.c.b.c.c cVar) throws Throwable {
        j.e(cVar, "cardUpdateEvent");
        e.g.b.b.a.a("State.CardStateEventAggregate", j.l("CardEvent process: ", cVar));
        ((d.a.a.a$b.c.b.a) this.a.getValue()).b(cVar);
        cVar.b(System.currentTimeMillis());
    }
}
