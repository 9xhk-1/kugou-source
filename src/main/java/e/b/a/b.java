package e.b.a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c, Cloneable {
    public static int[] b = new int[256];
    public int a = 0;

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 8;
            int i4 = i2;
            while (true) {
                i3--;
                if (i3 < 0) {
                    break;
                } else {
                    i4 = (i4 & 1) != 0 ? (i4 >>> 1) ^ (-306674912) : i4 >>> 1;
                }
            }
            b[i2] = i4;
        }
    }

    @Override // e.b.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b copy() {
        b bVar = new b();
        bVar.a = this.a;
        return bVar;
    }

    @Override // e.b.a.c
    public long getValue() {
        return ((long) this.a) & 4294967295L;
    }

    @Override // e.b.a.c
    public void reset() {
        this.a = 0;
    }

    @Override // e.b.a.c
    public void update(byte[] bArr, int i2, int i3) {
        int i4 = this.a ^ (-1);
        while (true) {
            i3--;
            if (i3 < 0) {
                this.a = i4 ^ (-1);
                return;
            }
            i4 = (i4 >>> 8) ^ b[(bArr[i2] ^ i4) & 255];
            i2++;
        }
    }

    @Override // e.b.a.c
    public void reset(long j) {
        this.a = (int) (j & 4294967295L);
    }
}
