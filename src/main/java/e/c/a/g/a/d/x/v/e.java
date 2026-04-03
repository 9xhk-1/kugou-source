package e.c.a.g.a.d.x.v;

import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f628d = new a(null);
    public final int a;
    public final int b;
    public final int c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }

        public final e a() {
            return l1.m0() ? new o() : l1.V() ? new f() : l1.g0() ? new l() : l1.f0() ? new j() : l1.U() ? new i() : l1.n0() ? new q() : (l1.X() || l1.b0()) ? new i() : l1.N() ? new i() : new o();
        }
    }

    public e(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        if (g0.a && e.c.a.g.a.c.a.a.b()) {
            return 60;
        }
        return this.b;
    }

    public final int c() {
        return this.c;
    }
}
