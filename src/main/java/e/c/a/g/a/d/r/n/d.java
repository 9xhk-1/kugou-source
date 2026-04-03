package e.c.a.g.a.d.r.n;

import com.kugou.android.watch.lite.base.player.Initiator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.c.a.g.a.d.r.e f497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Initiator f498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<a<T>> f500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f501i;
    public List<a<T>> j;
    public final byte[] a = new byte[0];
    public boolean b = true;
    public int c = 0;
    public int k = 0;

    public boolean A() {
        return this.k == 18;
    }

    public boolean B() {
        return this.k == 1005;
    }

    public boolean C() {
        int i2 = this.k;
        return i2 == 1001 || i2 == 1003 || i2 == 1002 || i2 == 1004 || i2 == 14 || i2 == 15 || i2 == 1006;
    }

    public boolean D() {
        return false;
    }

    public boolean E() {
        e.c.a.g.a.d.r.p.a.c cVarB;
        List<a<T>> list = this.f500h;
        if (list == null || list.size() <= 0 || this.f500h.get(0) == null || (cVarB = this.f500h.get(0).b()) == null) {
            return true;
        }
        return e.c.a.g.a.d.r.g.D(m(cVarB));
    }

    public abstract boolean F(a<T> aVar);

    public boolean G() {
        return false;
    }

    public abstract int H(int i2);

    public void I() {
    }

    public void J(List<a<T>> list) {
        this.f500h = list;
    }

    public void K(boolean z) {
    }

    public void L(e.c.a.g.a.d.r.e eVar) {
        this.f497e = eVar;
    }

    public void M(g gVar) {
        this.f501i = gVar;
    }

    public void N(int i2) {
        this.k = i2;
    }

    public void O(String str) {
        this.f496d = str;
    }

    public void P(f fVar) {
        this.f499g = fVar;
    }

    public void Q() {
    }

    public abstract boolean R();

    public void S() {
        synchronized (this.a) {
            while (this.b) {
                try {
                    this.a.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void a() {
    }

    public void b() {
    }

    public final d<T> c(Initiator initiator) {
        this.f498f = initiator;
        return this;
    }

    public boolean d() {
        return true;
    }

    public void e() {
        synchronized (this.a) {
            this.b = false;
            this.a.notifyAll();
            this.f501i = null;
        }
    }

    public List<a<T>> f() {
        if (this.f500h == null) {
            this.f500h = q();
        }
        return this.f500h;
    }

    public Initiator g() {
        return this.f498f;
    }

    public e.c.a.g.a.d.r.e h() {
        return this.f497e;
    }

    public List<a<T>> i() {
        return this.j;
    }

    public abstract e.c.a.g.a.d.r.p.a.g j(T t);

    public int k() {
        return this.k;
    }

    public String l() {
        return this.f496d;
    }

    public e.c.a.g.a.d.r.p.a.c m(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar;
    }

    public f n() {
        return this.f499g;
    }

    public abstract boolean o();

    public boolean p() {
        return false;
    }

    public abstract List<a<T>> q();

    public boolean r() {
        return this.b;
    }

    public boolean s() {
        return this.k == 1;
    }

    public boolean t() {
        return this.k == 16;
    }

    public boolean u() {
        int i2 = this.k;
        return i2 == 1001 || i2 == 1003 || i2 == 1002 || i2 == 1004 || i2 == 14 || i2 == 15 || i2 == 1006 || i2 == 1005 || i2 == 4;
    }

    public boolean v() {
        return this.k == 3;
    }

    public boolean w() {
        return this.k == 1014;
    }

    public boolean x() {
        return this.k == 8;
    }

    public boolean y() {
        int i2 = this.k;
        return i2 == 1007 || i2 == 1008 || i2 == 1009 || i2 == 1010 || i2 == 1011;
    }

    public boolean z() {
        return this.k == 1013;
    }
}
