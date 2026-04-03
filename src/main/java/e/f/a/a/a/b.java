package e.f.a.a.a;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public String a;
    public String b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1321f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class<?> f1322g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1323h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1324i = true;
    public boolean j = true;
    public boolean k = false;

    public static class a {
        public synchronized Map<String, String> a(int i2, String str, String str2, String str3) {
            throw null;
        }

        public synchronized byte[] b(int i2, String str, String str2, String str3) {
            throw null;
        }
    }

    public synchronized String a() {
        String str;
        str = this.b;
        if (str == null) {
            str = e.f.a.a.a.h.b.m().D;
        }
        return str;
    }

    public synchronized String b() {
        String str;
        str = this.c;
        if (str == null) {
            str = e.f.a.a.a.h.b.m().f1345e;
        }
        return str;
    }

    public synchronized long c() {
        return this.f1319d;
    }

    public synchronized String d() {
        String strD;
        strD = this.a;
        if (strD == null) {
            strD = e.f.a.a.a.h.b.m().d();
        }
        return strD;
    }

    public synchronized String e() {
        return this.f1320e;
    }

    public synchronized Class<?> f() {
        return this.f1322g;
    }

    public synchronized boolean g() {
        return this.f1321f;
    }

    public synchronized boolean h() {
        return this.f1323h;
    }

    public boolean i() {
        return this.f1324i;
    }

    public synchronized boolean j() {
        return this.j;
    }

    public synchronized boolean k() {
        return this.k;
    }

    public synchronized b l(long j) {
        this.f1319d = j;
        return this;
    }

    public synchronized b m(boolean z) {
        return this;
    }

    public synchronized b n(boolean z) {
        this.f1321f = z;
        return this;
    }

    public synchronized b o(boolean z) {
        this.j = z;
        return this;
    }
}
