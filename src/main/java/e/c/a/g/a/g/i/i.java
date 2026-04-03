package e.c.a.g.a.g.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i<Objects> extends e.c.a.g.a.r.e.a<Objects> {
    public String b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f851d = false;

    public i(String str, String str2) {
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    public String a(byte[] bArr) throws Exception {
        return e.c.a.g.a.r.g.a.a(bArr, "utf-8", this.b, this.c);
    }

    public boolean b() {
        return this.f851d;
    }
}
