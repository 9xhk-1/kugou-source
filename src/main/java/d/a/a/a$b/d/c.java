package d.a.a.a$b.d;

import f.s;
import f.z.c.l;
import f.z.d.k;

/* JADX INFO: loaded from: classes.dex */
public final class c extends k implements f.z.c.a<s> {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l<byte[], s> f289d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar, String str, l<? super byte[], s> lVar) {
        super(0);
        this.a = bVar;
        this.b = str;
        this.f289d = lVar;
    }

    @Override // f.z.c.a
    public s invoke() {
        this.a.b.put(this.b, this.f289d);
        e.g.b.b.a.a("Facade.CardClientFacade", f.z.d.j.l("--observe : widgetCode : ", this.b));
        return s.a;
    }
}
