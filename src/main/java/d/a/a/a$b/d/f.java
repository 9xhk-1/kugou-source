package d.a.a.a$b.d;

import f.s;
import f.z.d.k;

/* JADX INFO: loaded from: classes.dex */
public final class f extends k implements f.z.c.a<s> {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, b bVar) {
        super(0);
        this.a = str;
        this.b = bVar;
    }

    @Override // f.z.c.a
    public s invoke() {
        e.g.b.b.a.a("Facade.CardClientFacade", f.z.d.j.l("--unObserve : widgetCode : ", this.a));
        this.b.b.remove(this.a);
        return s.a;
    }
}
