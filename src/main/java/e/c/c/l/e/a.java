package e.c.c.l.e;

import e.c.c.l.e.b;
import e.c.c.l.e.c;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String b = "and02";
    public static String c = "pbKC7zn{4U*ydo2M1Rir";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f1260d;
    public b a = new b();

    public static a f() {
        if (f1260d == null) {
            synchronized (a.class) {
                if (f1260d == null) {
                    f1260d = new a();
                    f1260d.b();
                }
            }
        }
        return f1260d;
    }

    public byte[] a(byte[] bArr) {
        return this.a.a(bArr);
    }

    public final boolean b() {
        c.a aVarA = new c().a(this.a.b(0L));
        if (aVarA == null || !aVarA.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("gen key failed, errorCode = ");
            sb.append(aVarA != null ? Integer.valueOf(aVarA.b) : null);
            e.c.c.o.g.c("burone-key", sb.toString());
            aVarA = new c().a(this.a.b(0L));
        }
        if (aVarA != null && aVarA.a()) {
            this.a.f(aVarA.c);
            e.c.c.o.g.b("burone-key", "gen key success !!!!!");
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("retry failed, errorCode = ");
        sb2.append(aVarA != null ? Integer.valueOf(aVarA.b) : null);
        e.c.c.o.g.b("burone-key", sb2.toString());
        return false;
    }

    public long c() {
        return d(System.currentTimeMillis());
    }

    public long d(long j) {
        long j2;
        long j3;
        b.a aVarC = this.a.c();
        if (aVarC != null) {
            j2 = aVarC.b;
            j3 = aVarC.a;
        } else {
            j2 = 0;
            j3 = 0;
        }
        return (j2 > 0 || j3 > 0) ? ((j / 1000) - j3) + j2 : j / 1000;
    }

    public String e() {
        b.a aVarC = this.a.c();
        if (aVarC != null) {
            return aVarC.c;
        }
        return null;
    }

    public String g() {
        return this.a.d();
    }

    public boolean h() {
        return this.a.e();
    }

    public boolean i() {
        return b();
    }
}
