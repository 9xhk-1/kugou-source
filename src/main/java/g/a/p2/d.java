package g.a.p2;

import g.a.b0;
import g.a.b1;
import g.a.m0;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b1 {
    public b a;
    public final int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1636d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1637f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1638h;

    public d(int i2, int i3, long j, String str) {
        f.z.d.j.f(str, "schedulerName");
        this.b = i2;
        this.f1636d = i3;
        this.f1637f = j;
        this.f1638h = str;
        this.a = e();
    }

    @Override // g.a.b0
    public void a(f.w.g gVar, Runnable runnable) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(runnable, "block");
        try {
            b.w(this.a, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            m0.j.a(gVar, runnable);
        }
    }

    public final b0 d(int i2) {
        if (i2 > 0) {
            return new f(this, i2, l.PROBABLY_BLOCKING);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    public final b e() {
        return new b(this.b, this.f1636d, this.f1637f, this.f1638h);
    }

    public final void f(Runnable runnable, j jVar, boolean z) {
        f.z.d.j.f(runnable, "block");
        f.z.d.j.f(jVar, "context");
        try {
            this.a.v(runnable, jVar, z);
        } catch (RejectedExecutionException unused) {
            m0.j.u(this.a.t(runnable, jVar));
        }
    }

    public /* synthetic */ d(int i2, int i3, String str, int i4, f.z.d.g gVar) {
        this((i4 & 1) != 0 ? m.c : i2, (i4 & 2) != 0 ? m.f1644d : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2, int i3, String str) {
        this(i2, i3, m.f1645e, str);
        f.z.d.j.f(str, "schedulerName");
    }
}
