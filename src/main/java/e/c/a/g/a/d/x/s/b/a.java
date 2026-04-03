package e.c.a.g.a.d.x.s.b;

import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class a implements Cloneable {
    public String a;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f583d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f584f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f586i;
    public boolean j;
    public String k;
    public int l;
    public String m;
    public String n;
    public long o;
    public int p = 0;

    public static String a(String str) {
        return str == null ? "" : str.replace(".mp3", "").replace(".MP3", "").replace(".wma", "").replace(".WMA", "").replace(".aac", "").replace(".AAC", "").replace(".ogg", "").replace(".OGG", "");
    }

    public void A(String str) {
        this.b = str;
    }

    public void B(boolean z) {
        this.j = z;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.a;
    }

    public Object clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            g0.k(e2);
            return null;
        }
    }

    public long d() {
        return this.f586i;
    }

    public String e() {
        return this.f583d;
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.f584f;
    }

    public String h() {
        return this.m;
    }

    public int i() {
        return this.p;
    }

    public long j() {
        return this.o;
    }

    public int k() {
        return this.l;
    }

    public String l() {
        return this.f585h;
    }

    public String m() {
        return this.b;
    }

    public boolean n() {
        return this.j;
    }

    public void o(String str) {
        this.k = str;
    }

    public void p(String str) {
        this.a = str;
    }

    public void q(long j) {
    }

    public void r(long j) {
        this.f586i = j;
    }

    public void s(String str) {
        this.f583d = a(str);
        this.n = str;
    }

    public void t(String str) {
        this.f584f = str;
    }

    public void u(String str) {
        this.m = str;
    }

    public void v(int i2) {
        this.p = i2;
    }

    public void w(String str) {
    }

    public void x(long j) {
        this.o = j;
    }

    public void y(int i2) {
        this.l = i2;
    }

    public void z(String str) {
        this.f585h = str;
    }
}
