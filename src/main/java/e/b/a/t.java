package e.b.a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class t {
    public byte[] a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f359i;
    public e j;
    public m k;
    public int l;
    public c m;

    public t() {
        this(new a());
    }

    public void a() {
        e eVar = this.j;
        int i2 = eVar.f295i;
        int i3 = this.f357g;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 == 0) {
            return;
        }
        byte[] bArr = eVar.f292d;
        int length = bArr.length;
        int i4 = eVar.f294h;
        if (length > i4) {
            byte[] bArr2 = this.f355e;
            if (bArr2.length > this.f356f && bArr.length >= i4 + i2) {
                int length2 = bArr2.length;
            }
        }
        System.arraycopy(bArr, i4, this.f355e, this.f356f, i2);
        this.f356f += i2;
        e eVar2 = this.j;
        eVar2.f294h += i2;
        this.f358h += (long) i2;
        this.f357g -= i2;
        int i5 = eVar2.f295i - i2;
        eVar2.f295i = i5;
        if (i5 == 0) {
            eVar2.f294h = 0;
        }
    }

    public void b() {
        this.a = null;
        this.f355e = null;
        this.f359i = null;
    }

    public int c(byte[] bArr, int i2, int i3) {
        int i4 = this.c;
        if (i4 <= i3) {
            i3 = i4;
        }
        if (i3 == 0) {
            return 0;
        }
        this.c = i4 - i3;
        if (this.j.j != 0) {
            this.m.update(this.a, this.b, i3);
        }
        System.arraycopy(this.a, this.b, bArr, i2, i3);
        this.b += i3;
        this.f354d += (long) i3;
        return i3;
    }

    public void d(byte[] bArr, int i2, int i3, boolean z) {
        if (i3 > 0 || !z || this.a == null) {
            int i4 = this.c;
            if (i4 <= 0 || !z) {
                this.a = bArr;
                this.b = i2;
                this.c = i3;
            } else {
                byte[] bArr2 = new byte[i4 + i3];
                System.arraycopy(this.a, this.b, bArr2, 0, i4);
                System.arraycopy(bArr, i2, bArr2, this.c, i3);
                this.a = bArr2;
                this.b = 0;
                this.c += i3;
            }
        }
    }

    public void e(byte[] bArr, int i2, int i3) {
        this.f355e = bArr;
        this.f356f = i2;
        this.f357g = i3;
    }

    public t(c cVar) {
        this.m = cVar;
    }
}
