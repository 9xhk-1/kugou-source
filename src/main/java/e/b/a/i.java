package e.b.a;

/* JADX INFO: loaded from: classes.dex */
public class i implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f302d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f303f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f305i;
    public byte[] j;
    public byte[] k;
    public int l;
    public long m;
    public boolean a = false;
    public boolean b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f304h = 255;
    public long n = 0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    public void a(e eVar) {
        boolean z = this.a;
        ?? r0 = z;
        if (this.b) {
            r0 = (z ? 1 : 0) | 2;
        }
        ?? r02 = r0;
        if (this.f305i != null) {
            r02 = (r0 == true ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (this.j != null) {
            r03 = (r02 == true ? 1 : 0) | 8;
        }
        int i2 = r03;
        if (this.k != null) {
            i2 = (r03 == true ? 1 : 0) | 16;
        }
        int i3 = eVar.I;
        int i4 = i3 == 1 ? 4 : i3 == 9 ? 2 : 0;
        eVar.E(-29921);
        eVar.C((byte) 8);
        eVar.C((byte) i2);
        eVar.C((byte) this.n);
        eVar.C((byte) (this.n >> 8));
        eVar.C((byte) (this.n >> 16));
        eVar.C((byte) (this.n >> 24));
        eVar.C((byte) i4);
        eVar.C((byte) this.f304h);
        byte[] bArr = this.f305i;
        if (bArr != null) {
            eVar.C((byte) bArr.length);
            eVar.C((byte) (this.f305i.length >> 8));
            byte[] bArr2 = this.f305i;
            eVar.D(bArr2, 0, bArr2.length);
        }
        byte[] bArr3 = this.j;
        if (bArr3 != null) {
            eVar.D(bArr3, 0, bArr3.length);
            eVar.C((byte) 0);
        }
        byte[] bArr4 = this.k;
        if (bArr4 != null) {
            eVar.D(bArr4, 0, bArr4.length);
            eVar.C((byte) 0);
        }
    }

    public void b(long j) {
    }

    public Object clone() throws CloneNotSupportedException {
        i iVar = (i) super.clone();
        byte[] bArr = iVar.f305i;
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            iVar.f305i = bArr2;
        }
        byte[] bArr3 = iVar.j;
        if (bArr3 != null) {
            int length2 = bArr3.length;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr3, 0, bArr4, 0, length2);
            iVar.j = bArr4;
        }
        byte[] bArr5 = iVar.k;
        if (bArr5 != null) {
            int length3 = bArr5.length;
            byte[] bArr6 = new byte[length3];
            System.arraycopy(bArr5, 0, bArr6, 0, length3);
            iVar.k = bArr6;
        }
        return iVar;
    }
}
