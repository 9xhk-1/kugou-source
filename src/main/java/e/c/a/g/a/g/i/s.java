package e.c.a.g.a.g.i;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public short a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f900d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<e.c.a.g.a.g.k.c.a> f901e = new ArrayList<>(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f902f;

    public boolean a(int i2, int i3, String str, int i4, int i5, int i6, short s, String str2, int i7, String str3, int i8, int i9, String str4, long j, boolean z, String str5, boolean z2) {
        if (this.f901e == null) {
            this.f901e = new ArrayList<>(1);
        }
        e.c.a.g.a.g.k.c.a aVar = new e.c.a.g.a.g.k.c.a(i2, i3, str, i4, i5, i6, s, str2, i7, str3, i8, i9, str4, j, z);
        aVar.y(str5);
        aVar.I(z2);
        this.f901e.add(aVar);
        return true;
    }

    public int b() {
        return this.f902f;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.f900d;
    }

    public int f() {
        return this.c;
    }

    public ArrayList<e.c.a.g.a.g.k.c.a> g() {
        return this.f901e;
    }

    public void h(int i2) {
    }

    public void i(int i2) {
        this.f902f = i2;
    }

    public void j(int i2) {
        this.b = i2;
    }

    public void k(short s) {
        this.a = s;
    }

    public void l(int i2) {
        this.f900d = i2;
    }

    public void m(int i2) {
        this.c = i2;
    }

    public void n(int i2) {
    }

    public void o(long j) {
    }
}
