package e.f.a.a.d.a;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e.f.a.a.d.b.f implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static byte[] f1434f;
    public byte a;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f1435d;

    public c() {
        this.a = (byte) 0;
        this.b = "";
        this.f1435d = null;
    }

    @Override // e.f.a.a.d.b.f
    public void a(StringBuilder sb, int i2) {
    }

    @Override // e.f.a.a.d.b.f
    public void b(e.f.a.a.d.b.d dVar) {
        this.a = dVar.b(this.a, 0, true);
        this.b = dVar.y(1, true);
        if (f1434f == null) {
            f1434f = new byte[]{0};
        }
        this.f1435d = dVar.k(f1434f, 2, false);
    }

    @Override // e.f.a.a.d.b.f
    public void c(e.f.a.a.d.b.e eVar) {
        eVar.d(this.a, 0);
        eVar.r(this.b, 1);
        byte[] bArr = this.f1435d;
        if (bArr != null) {
            eVar.w(bArr, 2);
        }
    }

    public c(byte b, String str, byte[] bArr) {
        this.a = (byte) 0;
        this.b = "";
        this.f1435d = null;
        this.a = b;
        this.b = str;
        this.f1435d = bArr;
    }
}
