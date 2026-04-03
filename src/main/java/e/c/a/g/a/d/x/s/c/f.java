package e.c.a.g.a.d.x.s.c;

import android.content.Context;
import android.text.TextUtils;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public final e.c.a.g.a.d.x.s.b.a a;
    public String b;
    public e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e.c.a.g.a.d.b.a f609i;

    public f(e.c.a.g.a.d.x.s.b.a aVar, boolean z) {
        this(aVar);
        this.f606f = z;
    }

    public e.c.a.g.a.d.b.a a() {
        return this.f609i;
    }

    public byte[] b() {
        e eVar = this.c;
        if (eVar == null) {
            return null;
        }
        return eVar.r();
    }

    public String c() {
        return this.b;
    }

    public e.c.a.g.a.d.x.s.b.a d() {
        return this.a;
    }

    public int e() {
        e eVar = this.c;
        if (eVar == null) {
            return 0;
        }
        int iP = eVar.p();
        if (iP == 0) {
            return 1;
        }
        if (iP != 1) {
            return iP != 2 ? 0 : 3;
        }
        return 2;
    }

    public boolean f() {
        return this.f607g;
    }

    public boolean g() {
        return TextUtils.isEmpty(this.b) || this.a.n();
    }

    public void h() {
        e.c.a.g.a.d.x.s.b.a aVar;
        String strF;
        if (!g() || (aVar = this.a) == null || aVar.f() == null) {
            return;
        }
        Context contextA = e.c.c.o.f.a();
        if (this.a.n()) {
            strF = this.a.c() + " - " + this.a.m();
        } else {
            strF = this.a.f();
            if (h1.k(strF)) {
                return;
            }
        }
        String str = strF;
        long jD = this.a.d();
        String strL = this.a.l();
        String strE = this.a.e();
        if (this.f606f) {
            this.c = new e(contextA, str, jD, strL, strE, this.a.h(), this.a.b(), this.a.i(), this.a.k(), this.a.j(), true, true);
        } else {
            this.c = new e(contextA, str, jD, strL, strE, this.a.b(), this.a.k(), this.a.j());
        }
        if (f()) {
            this.c.z(f());
            this.c.A(this.b);
        }
        this.b = this.c.m();
        this.f604d = this.c.y();
        this.f605e = this.c.u();
        this.f608h = this.c.x();
        this.c.v();
        this.c.t();
        if (!this.f608h && ((this.f604d || this.f605e) && TextUtils.isEmpty(this.b))) {
            this.b = this.c.o(this.a);
            if (g0.a) {
                g0.c("lyric file", "返回备用的歌词路径 " + this.b);
            }
        }
        if (this.f608h && !this.f604d && !this.f605e && TextUtils.isEmpty(this.b)) {
            this.b = this.c.n(this.a);
            if (g0.a) {
                g0.c("lyric file", "返回备用的歌词路径111 " + this.b);
            }
        }
        this.f609i = this.c.s();
        this.c.q();
    }

    public f(e.c.a.g.a.d.x.s.b.a aVar) {
        this.b = null;
        this.f606f = false;
        this.f607g = false;
        this.f609i = null;
        this.a = aVar;
        this.b = g.e(aVar, true);
    }
}
