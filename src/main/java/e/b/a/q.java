package e.b.a;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f340d = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f341e = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f345i;
    public static final int[] j;
    public static final int[] k;
    public short[] a;
    public int b;
    public p c;

    static {
        int[] iArr = new int[19];
        iArr[16] = 2;
        iArr[17] = 3;
        iArr[18] = 7;
        f342f = iArr;
        f343g = new byte[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
        f344h = new byte[]{0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0, 0, 16, 17, 18, 18, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29};
        f345i = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28};
        j = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 20, 24, 28, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 0};
        k = new int[]{0, 1, 2, 3, 4, 6, 8, 12, 16, 24, 32, 48, 64, 96, 128, 192, 256, 384, 512, 768, 1024, 1536, 2048, 3072, 4096, 6144, 8192, 12288, 16384, 24576};
    }

    public static int a(int i2, int i3) {
        int i4 = 0;
        do {
            int i5 = i4 | (i2 & 1);
            i2 >>>= 1;
            i4 = i5 << 1;
            i3--;
        } while (i3 > 0);
        return i4 >>> 1;
    }

    public static int c(int i2) {
        return i2 < 256 ? f344h[i2] : f344h[(i2 >>> 7) + 256];
    }

    public static void e(short[] sArr, int i2, short[] sArr2) {
        short[] sArr3 = new short[16];
        short s = 0;
        for (int i3 = 1; i3 <= 15; i3++) {
            s = (short) ((s + sArr2[i3 - 1]) << 1);
            sArr3[i3] = s;
        }
        for (int i4 = 0; i4 <= i2; i4++) {
            int i5 = i4 * 2;
            short s2 = sArr[i5 + 1];
            if (s2 != 0) {
                short s3 = sArr3[s2];
                sArr3[s2] = (short) (s3 + 1);
                sArr[i5] = (short) a(s3, s2);
            }
        }
    }

    public void b(e eVar) {
        int i2;
        int i3;
        int i4;
        short[] sArr = this.a;
        p pVar = this.c;
        short[] sArr2 = pVar.a;
        int i5 = pVar.f338d;
        eVar.U = 0;
        eVar.V = 573;
        int i6 = -1;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * 2;
            if (sArr[i8] != 0) {
                int[] iArr = eVar.T;
                int i9 = eVar.U + 1;
                eVar.U = i9;
                iArr[i9] = i7;
                eVar.W[i7] = 0;
                i6 = i7;
            } else {
                sArr[i8 + 1] = 0;
            }
        }
        while (true) {
            i2 = eVar.U;
            if (i2 >= 2) {
                break;
            }
            int[] iArr2 = eVar.T;
            int i10 = i2 + 1;
            eVar.U = i10;
            if (i6 < 2) {
                i4 = i6 + 1;
                i3 = i4;
            } else {
                i3 = i6;
                i4 = 0;
            }
            iArr2[i10] = i4;
            int i11 = i4 * 2;
            sArr[i11] = 1;
            eVar.W[i4] = 0;
            eVar.b0--;
            if (sArr2 != null) {
                eVar.c0 -= sArr2[i11 + 1];
            }
            i6 = i3;
        }
        this.b = i6;
        for (int i12 = i2 / 2; i12 >= 1; i12--) {
            eVar.A(sArr, i12);
        }
        while (true) {
            int[] iArr3 = eVar.T;
            int i13 = iArr3[1];
            int i14 = eVar.U;
            eVar.U = i14 - 1;
            iArr3[1] = iArr3[i14];
            eVar.A(sArr, 1);
            int[] iArr4 = eVar.T;
            int i15 = iArr4[1];
            int i16 = eVar.V - 1;
            eVar.V = i16;
            iArr4[i16] = i13;
            int i17 = i16 - 1;
            eVar.V = i17;
            iArr4[i17] = i15;
            int i18 = i13 * 2;
            int i19 = i15 * 2;
            sArr[i5 * 2] = (short) (sArr[i18] + sArr[i19]);
            byte[] bArr = eVar.W;
            bArr[i5] = (byte) (Math.max((int) bArr[i13], (int) bArr[i15]) + 1);
            short s = (short) i5;
            sArr[i19 + 1] = s;
            sArr[i18 + 1] = s;
            int i20 = i5 + 1;
            eVar.T[1] = i5;
            eVar.A(sArr, 1);
            if (eVar.U < 2) {
                int[] iArr5 = eVar.T;
                int i21 = eVar.V - 1;
                eVar.V = i21;
                iArr5[i21] = iArr5[1];
                d(eVar);
                e(sArr, i6, eVar.S);
                return;
            }
            i5 = i20;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(e eVar) {
        short[] sArr;
        short[] sArr2 = this.a;
        p pVar = this.c;
        short[] sArr3 = pVar.a;
        int[] iArr = pVar.b;
        int i2 = pVar.c;
        int i3 = pVar.f339e;
        for (int i4 = 0; i4 <= 15; i4++) {
            eVar.S[i4] = 0;
        }
        int[] iArr2 = eVar.T;
        int i5 = eVar.V;
        sArr2[(iArr2[i5] * 2) + 1] = 0;
        int i6 = i5 + 1;
        int i7 = 0;
        while (i6 < 573) {
            int i8 = eVar.T[i6];
            int i9 = i8 * 2;
            int i10 = i9 + 1;
            int i11 = sArr2[(sArr2[i10] * 2) + 1] + 1;
            if (i11 > i3) {
                i7++;
                i11 = i3;
            }
            sArr2[i10] = (short) i11;
            if (i8 <= this.b) {
                short[] sArr4 = eVar.S;
                sArr4[i11] = (short) (sArr4[i11] + 1);
                int i12 = i8 >= i2 ? iArr[i8 - i2] : 0;
                short s = sArr2[i9];
                eVar.b0 += (i11 + i12) * s;
                if (sArr3 != null) {
                    eVar.c0 += s * (sArr3[i10] + i12);
                }
            }
            i6++;
        }
        if (i7 == 0) {
            return;
        }
        int i13 = i7;
        do {
            int i14 = i3 - 1;
            while (true) {
                sArr = eVar.S;
                if (sArr[i14] != 0) {
                    break;
                } else {
                    i14--;
                }
            }
            sArr[i14] = (short) (sArr[i14] - 1);
            int i15 = i14 + 1;
            sArr[i15] = (short) (sArr[i15] + 2);
            sArr[i3] = (short) (sArr[i3] - 1);
            i13 -= 2;
        } while (i13 > 0);
        for (int i16 = i3; i16 != 0; i16--) {
            short s2 = eVar.S[i16];
            while (s2 != 0) {
                i6--;
                int i17 = eVar.T[i6];
                if (i17 <= this.b) {
                    int i18 = i17 * 2;
                    int i19 = i18 + 1;
                    if (sArr2[i19] != i16) {
                        eVar.b0 = (int) (((long) eVar.b0) + ((((long) i16) - ((long) sArr2[i19])) * ((long) sArr2[i18])));
                        sArr2[i19] = (short) i16;
                    }
                    s2--;
                }
            }
        }
    }
}
