package e.c.a.g.a.d.o.g;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.o.c.g;
import e.c.a.g.a.d.x.h;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.d.f.a;
import e.c.e.b.b.b;

/* JADX INFO: loaded from: classes.dex */
public class b extends e.c.a.g.a.d.o.g.a {
    public e.c.a.g.a.d.i.c a;
    public h b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b = h.y();
            b.this.b.z();
            g0.b("KGCommonApplication", "PlayerService.init ");
            b.this.a = e.c.a.g.a.d.i.c.h();
            b.this.a.i();
            g.c("@1:@manual:FileManager", b.this.a);
            g0.b("KGCommonApplication", "FileManager.init ");
        }
    }

    public b(Context context) {
        super(context);
    }

    public static c f(Context context) {
        b bVar = new b(context);
        bVar.a();
        return bVar;
    }

    @Override // e.c.a.g.a.d.o.g.a
    public void a() {
        super.a();
        e.c.a.g.a.d.o.d.a aVar = new e.c.a.g.a.d.o.d.a();
        aVar.g();
        g.c("@1:@manual:Ack", aVar);
        g0.b("KGCommonApplication", "AckService.init ");
        b.a aVarE = e.c.e.b.b.b.e();
        aVarE.e(KGApplication.getContext());
        aVarE.c();
        a.C0211a c0211aD = e.c.d.f.a.d();
        c0211aD.e(KGApplication.getContext());
        a.C0211a c0211a = c0211aD;
        c0211a.f(e.c.e.b.b.b.f());
        a.C0211a c0211a2 = c0211a;
        c0211a2.g(e.c.e.b.b.b.g());
        c0211a2.c();
        j0.b().a(new a());
    }

    @Override // e.c.a.g.a.d.o.g.c
    public void destroy() {
        e.c.a.g.a.d.r.n.h.f();
        h hVar = this.b;
        if (hVar != null) {
            hVar.v();
        }
        e.a().stop();
    }
}
