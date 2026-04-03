package e.b.a;

import androidx.core.app.FrameMetricsAggregator;
import androidx.exifinterface.media.ExifInterface;
import androidx.media.AudioAttributesCompat;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final int[] o = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, AudioAttributesCompat.FLAG_ALL, 2047, 4095, 8191, 16383, 32767, 65535};
    public int a;
    public int b;
    public int[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f312d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f317i;
    public byte j;
    public int[] k;
    public int l;
    public int[] m;
    public int n;

    public void a(t tVar) {
    }

    public int b(int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, j jVar, t tVar) {
        int i6;
        int i7;
        int i8;
        int i9 = tVar.b;
        int i10 = tVar.c;
        int i11 = jVar.k;
        int i12 = jVar.j;
        int i13 = jVar.p;
        int i14 = jVar.o;
        int i15 = i13 < i14 ? (i14 - i13) - 1 : jVar.n - i13;
        int[] iArr3 = o;
        int i16 = iArr3[i2];
        int i17 = iArr3[i3];
        while (true) {
            if (i12 >= 20) {
                int i18 = i11 & i16;
                int i19 = (i4 + i18) * 3;
                int i20 = iArr[i19];
                if (i20 == 0) {
                    int i21 = i19 + 1;
                    i11 >>= iArr[i21];
                    i12 -= iArr[i21];
                    i8 = i13 + 1;
                    jVar.m[i13] = (byte) iArr[i19 + 2];
                } else {
                    do {
                        int i22 = i19 + 1;
                        i11 >>= iArr[i22];
                        i12 -= iArr[i22];
                        if ((i20 & 16) != 0) {
                            int i23 = i20 & 15;
                            int i24 = iArr[i19 + 2] + (o[i23] & i11);
                            int i25 = i11 >> i23;
                            int i26 = i12 - i23;
                            while (i26 < 15) {
                                i10--;
                                i25 |= (tVar.a[i9] & ExifInterface.MARKER) << i26;
                                i26 += 8;
                                i9++;
                            }
                            int i27 = i25 & i17;
                            int i28 = (i5 + i27) * 3;
                            int i29 = iArr2[i28];
                            while (true) {
                                int i30 = i28 + 1;
                                i25 >>= iArr2[i30];
                                i26 -= iArr2[i30];
                                if ((i29 & 16) != 0) {
                                    int i31 = i29 & 15;
                                    while (i26 < i31) {
                                        i10--;
                                        i25 |= (tVar.a[i9] & ExifInterface.MARKER) << i26;
                                        i26 += 8;
                                        i9++;
                                    }
                                    int i32 = iArr2[i28 + 2] + (o[i31] & i25);
                                    int i33 = i25 >> i31;
                                    int i34 = i26 - i31;
                                    int i35 = i15 - i24;
                                    if (i13 >= i32) {
                                        int i36 = i13 - i32;
                                        int i37 = i13 - i36;
                                        if (i37 <= 0 || 2 <= i37) {
                                            byte[] bArr = jVar.m;
                                            System.arraycopy(bArr, i36, bArr, i13, 2);
                                            i13 += 2;
                                            i6 = i36 + 2;
                                        } else {
                                            byte[] bArr2 = jVar.m;
                                            int i38 = i13 + 1;
                                            int i39 = i36 + 1;
                                            bArr2[i13] = bArr2[i36];
                                            i13 = i38 + 1;
                                            i6 = i39 + 1;
                                            bArr2[i38] = bArr2[i39];
                                        }
                                        i24 -= 2;
                                    } else {
                                        i6 = i13 - i32;
                                        do {
                                            i7 = jVar.n;
                                            i6 += i7;
                                        } while (i6 < 0);
                                        int i40 = i7 - i6;
                                        if (i24 > i40) {
                                            i24 -= i40;
                                            int i41 = i13 - i6;
                                            if (i41 <= 0 || i40 <= i41) {
                                                byte[] bArr3 = jVar.m;
                                                System.arraycopy(bArr3, i6, bArr3, i13, i40);
                                                i13 += i40;
                                            } else {
                                                while (true) {
                                                    byte[] bArr4 = jVar.m;
                                                    int i42 = i6 + 1;
                                                    bArr4[i13] = bArr4[i6];
                                                    i40--;
                                                    i13++;
                                                    if (i40 == 0) {
                                                        break;
                                                    }
                                                    i6 = i42;
                                                }
                                            }
                                            i6 = 0;
                                        }
                                    }
                                    int i43 = i13 - i6;
                                    if (i43 <= 0 || i24 <= i43) {
                                        byte[] bArr5 = jVar.m;
                                        System.arraycopy(bArr5, i6, bArr5, i13, i24);
                                        i13 += i24;
                                    } else {
                                        while (true) {
                                            byte[] bArr6 = jVar.m;
                                            int i44 = i6 + 1;
                                            bArr6[i13] = bArr6[i6];
                                            i24--;
                                            i13++;
                                            if (i24 == 0) {
                                                break;
                                            }
                                            i6 = i44;
                                        }
                                    }
                                    i11 = i33;
                                    i12 = i34;
                                    i15 = i35;
                                } else {
                                    if ((i29 & 64) != 0) {
                                        tVar.f359i = "invalid distance code";
                                        int i45 = tVar.c - i10;
                                        int i46 = i26 >> 3;
                                        if (i46 < i45) {
                                            i45 = i46;
                                        }
                                        int i47 = i9 - i45;
                                        jVar.k = i25;
                                        jVar.j = i26 - (i45 << 3);
                                        tVar.c = i10 + i45;
                                        tVar.f354d += (long) (i47 - tVar.b);
                                        tVar.b = i47;
                                        jVar.p = i13;
                                        return -3;
                                    }
                                    i27 = i27 + iArr2[i28 + 2] + (o[i29] & i25);
                                    i28 = (i5 + i27) * 3;
                                    i29 = iArr2[i28];
                                }
                            }
                        } else {
                            if ((i20 & 64) != 0) {
                                if ((i20 & 32) != 0) {
                                    int i48 = tVar.c - i10;
                                    int i49 = i12 >> 3;
                                    if (i49 < i48) {
                                        i48 = i49;
                                    }
                                    int i50 = i9 - i48;
                                    jVar.k = i11;
                                    jVar.j = i12 - (i48 << 3);
                                    tVar.c = i10 + i48;
                                    tVar.f354d += (long) (i50 - tVar.b);
                                    tVar.b = i50;
                                    jVar.p = i13;
                                    return 1;
                                }
                                tVar.f359i = "invalid literal/length code";
                                int i51 = tVar.c - i10;
                                int i52 = i12 >> 3;
                                if (i52 < i51) {
                                    i51 = i52;
                                }
                                int i53 = i9 - i51;
                                jVar.k = i11;
                                jVar.j = i12 - (i51 << 3);
                                tVar.c = i10 + i51;
                                tVar.f354d += (long) (i53 - tVar.b);
                                tVar.b = i53;
                                jVar.p = i13;
                                return -3;
                            }
                            i18 = i18 + iArr[i19 + 2] + (o[i20] & i11);
                            i19 = (i4 + i18) * 3;
                            i20 = iArr[i19];
                        }
                    } while (i20 != 0);
                    int i54 = i19 + 1;
                    i11 >>= iArr[i54];
                    i12 -= iArr[i54];
                    i8 = i13 + 1;
                    jVar.m[i13] = (byte) iArr[i19 + 2];
                }
                i15--;
                i13 = i8;
                if (i15 < 258 || i10 < 10) {
                    break;
                }
            } else {
                i10--;
                i11 |= (tVar.a[i9] & ExifInterface.MARKER) << i12;
                i12 += 8;
                i9++;
            }
        }
        int i55 = tVar.c - i10;
        int i56 = i12 >> 3;
        if (i56 < i55) {
            i55 = i56;
        }
        int i57 = i9 - i55;
        jVar.k = i11;
        jVar.j = i12 - (i55 << 3);
        tVar.c = i10 + i55;
        tVar.f354d += (long) (i57 - tVar.b);
        tVar.b = i57;
        jVar.p = i13;
        return 0;
    }

    public void c(int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, t tVar) {
        this.a = 0;
        this.f317i = (byte) i2;
        this.j = (byte) i3;
        this.k = iArr;
        this.l = i4;
        this.m = iArr2;
        this.n = i5;
        this.c = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
    
        r19.k = r3;
        r19.j = r4;
        r20.c = r2;
        r20.f354d += (long) (r1 - r20.b);
        r20.b = r1;
        r19.p = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ad, code lost:
    
        return r19.b(r20, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b4 A[LOOP:1: B:56:0x0133->B:90:0x01b4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int d(e.b.a.j r19, e.b.a.t r20, int r21) {
        /*
            Method dump skipped, instruction units count: 990
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.k.d(e.b.a.j, e.b.a.t, int):int");
    }
}
