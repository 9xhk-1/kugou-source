package e.c.a.g.a.d.r.p.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public int a;
    public String b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<c> f511f;

    public void a(List<c> list) {
        if (list == null) {
            return;
        }
        if (this.f511f == null) {
            this.f511f = new ArrayList();
        }
        this.f511f.addAll(list);
    }

    public b b() {
        return this.f509d;
    }

    public int c() {
        return this.c;
    }

    public List<c> d() {
        return this.f511f;
    }

    public String e() {
        return this.b;
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.f510e;
    }

    public void h(b bVar) {
        this.f509d = bVar;
    }

    public void i(int i2) {
        this.c = i2;
    }

    public void j(List<c> list) {
        this.f511f = list;
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(e.c.a.g.a.d.b.a aVar) {
    }

    public void m(int i2) {
        this.a = i2;
    }

    public void n(int i2) {
        this.f510e = i2;
    }
}
