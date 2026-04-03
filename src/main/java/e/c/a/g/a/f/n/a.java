package e.c.a.g.a.f.n;

import e.c.a.g.a.f.m.c;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a a;

    public static a b() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public boolean a(int i2, boolean z) {
        return c.a.e(String.valueOf(i2), z);
    }

    public int c(int i2, int i3) {
        return c.a.b(String.valueOf(i2), i3);
    }

    public long d(int i2, long j) {
        return c.a.c(String.valueOf(i2), j);
    }

    public String e(int i2, String str) {
        return c.a.d(String.valueOf(i2), str);
    }

    public void f(int i2, boolean z) {
        c.a.j(String.valueOf(i2), z);
    }

    public void g(int i2, int i3) {
        c.a.g(String.valueOf(i2), i3);
    }

    public void h(int i2, long j) {
        c.a.h(String.valueOf(i2), j);
    }

    public void i(int i2, String str) {
        c.a.i(String.valueOf(i2), str);
    }
}
