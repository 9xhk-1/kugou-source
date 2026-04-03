package e.f.a.b.a.k.c;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
    }

    public static boolean a(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean b(long j, long j2) {
        return j == j2;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean d(boolean z, boolean z2) {
        return z == z2;
    }
}
