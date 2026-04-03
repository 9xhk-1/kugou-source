package e.c.a.g.a.f.k;

import android.text.TextUtils;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f687f = new a(null);
    public int a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f689e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final <T> c<T> a() {
            c<T> cVar = new c<>();
            cVar.h(true);
            cVar.m(1);
            return cVar;
        }
    }

    public final T a() {
        return this.f688d;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d(String str) {
        j.e(str, "def");
        if (TextUtils.isEmpty(this.c)) {
            return str;
        }
        String str2 = this.c;
        j.c(str2);
        return str2;
    }

    public final boolean e() {
        return this.f689e;
    }

    public final boolean f() {
        return this.a == 1;
    }

    public final void g(T t) {
        this.f688d = t;
    }

    public final void h(boolean z) {
        this.f689e = z;
    }

    public final void i(int i2) {
        this.b = i2;
    }

    public final void j(String str) {
        this.c = str;
    }

    public final void k(int i2) {
        this.b = i2;
    }

    public final void l(String str) {
        this.c = str;
    }

    public final void m(int i2) {
        this.a = i2;
    }
}
