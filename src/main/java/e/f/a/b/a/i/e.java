package e.f.a.b.a.i;

import f.s;
import f.z.c.l;
import f.z.d.g;
import f.z.d.j;
import f.z.d.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public volatile d a;
    public final ConcurrentHashMap<e.f.a.b.a.i.b, c> b;
    public final boolean c;

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends k implements f.z.c.a<s> {
        public final /* synthetic */ l a;
        public final /* synthetic */ e.f.a.b.a.i.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, e.f.a.b.a.i.b bVar) {
            super(0);
            this.a = lVar;
            this.b = bVar;
        }

        public final void a() {
            this.a.invoke(this.b);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b extends k implements f.z.c.a<s> {
        public final /* synthetic */ l a;
        public final /* synthetic */ e.f.a.b.a.i.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, e.f.a.b.a.i.b bVar) {
            super(0);
            this.a = lVar;
            this.b = bVar;
        }

        public final void a() {
            this.a.invoke(this.b);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public e() {
        this(false, 1, null);
    }

    public e(boolean z) {
        this.c = z;
        this.a = d.INIT;
        this.b = new ConcurrentHashMap<>();
    }

    public final void a() {
        if (!this.c) {
            for (Map.Entry<e.f.a.b.a.i.b, c> entry : this.b.entrySet()) {
                l<e.f.a.b.a.i.b, s> lVarA = this.a.a();
                if (lVarA != null) {
                    lVarA.invoke(entry.getKey());
                }
            }
            return;
        }
        d dVar = this.a;
        for (Map.Entry<e.f.a.b.a.i.b, c> entry2 : this.b.entrySet()) {
            l<e.f.a.b.a.i.b, s> lVarA2 = dVar.a();
            if (lVarA2 != null) {
                b(lVarA2, entry2.getKey());
            }
        }
    }

    public final void b(l<? super e.f.a.b.a.i.b, s> lVar, e.f.a.b.a.i.b bVar) {
        if ((bVar instanceof e.f.a.b.a.i.a) && ((e.f.a.b.a.i.a) bVar).serial()) {
            e.f.a.b.a.m.e.b.f1487d.b(new a(lVar, bVar));
        } else {
            e.f.a.b.a.m.e.b.f1487d.b(new b(lVar, bVar));
        }
    }

    public synchronized void c(e.f.a.b.a.i.b bVar) {
        j.f(bVar, "observer");
        this.b.remove(bVar);
    }

    public final synchronized void d() {
        d dVar = this.a;
        d dVar2 = d.OFF;
        if (dVar == dVar2) {
            return;
        }
        this.a = dVar2;
        a();
    }

    public final synchronized void e() {
        d dVar = this.a;
        d dVar2 = d.ON;
        if (dVar == dVar2) {
            return;
        }
        this.a = dVar2;
        a();
    }

    public /* synthetic */ e(boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? true : z);
    }
}
