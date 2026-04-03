package e.b.a;

import androidx.exifinterface.media.ExifInterface;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Cloneable {
    public static final a[] i0 = {new a(0, 0, 0, 0, 0), new a(4, 4, 8, 4, 1), new a(4, 5, 16, 8, 1), new a(4, 6, 32, 32, 1), new a(4, 4, 16, 16, 2), new a(8, 16, 32, 32, 2), new a(8, 16, 128, 128, 2), new a(8, 32, 128, 256, 2), new a(32, 128, 258, 1024, 2), new a(32, 258, 258, 4096, 2)};
    public static final String[] j0 = {"need dictionary", "stream end", "", "file error", "stream error", "data error", "insufficient memory", "buffer error", "incompatible version", ""};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int U;
    public int V;
    public int X;
    public int Y;
    public int Z;
    public t a;
    public int a0;
    public int b;
    public int b0;
    public int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f292d;
    public int d0;
    public int e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f293f;
    public short f0;
    public int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f295i;
    public byte k;
    public int l;
    public int m;
    public int n;
    public int o;
    public byte[] p;
    public int q;
    public short[] r;
    public short[] s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;
    public int j = 1;
    public q P = new q();
    public q Q = new q();
    public q R = new q();
    public short[] S = new short[16];
    public int[] T = new int[573];
    public byte[] W = new byte[573];
    public i h0 = null;
    public short[] M = new short[1146];
    public short[] N = new short[122];
    public short[] O = new short[78];

    public static class a {
        public int a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f297e;

        public a(int i2, int i3, int i4, int i5, int i6) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.f296d = i5;
            this.f297e = i6;
        }
    }

    public e(t tVar) {
        this.a = tVar;
    }

    public static boolean L(short[] sArr, int i2, int i3, byte[] bArr) {
        short s = sArr[i2 * 2];
        short s2 = sArr[i3 * 2];
        if (s >= s2) {
            return s == s2 && bArr[i2] <= bArr[i3];
        }
        return true;
    }

    public void A(short[] sArr, int i2) {
        int i3 = this.T[i2];
        int i4 = i2 << 1;
        while (true) {
            int i5 = this.U;
            if (i4 > i5) {
                break;
            }
            if (i4 < i5) {
                int[] iArr = this.T;
                int i6 = i4 + 1;
                if (L(sArr, iArr[i6], iArr[i4], this.W)) {
                    i4 = i6;
                }
            }
            if (L(sArr, i3, this.T[i4], this.W)) {
                break;
            }
            int[] iArr2 = this.T;
            iArr2[i2] = iArr2[i4];
            int i7 = i4;
            i4 <<= 1;
            i2 = i7;
        }
        this.T[i2] = i3;
    }

    public final void B(int i2) {
        C((byte) (i2 >> 8));
        C((byte) i2);
    }

    public final void C(byte b) {
        byte[] bArr = this.f292d;
        int i2 = this.f295i;
        this.f295i = i2 + 1;
        bArr[i2] = b;
    }

    public final void D(byte[] bArr, int i2, int i3) {
        System.arraycopy(bArr, i2, this.f292d, this.f295i, i3);
        this.f295i += i3;
    }

    public final void E(int i2) {
        C((byte) i2);
        C((byte) (i2 >>> 8));
    }

    public void F(short[] sArr, int i2) {
        int i3;
        int i4;
        short s = sArr[1];
        if (s == 0) {
            i3 = 138;
            i4 = 3;
        } else {
            i3 = 7;
            i4 = 4;
        }
        short s2 = -1;
        sArr[((i2 + 1) * 2) + 1] = -1;
        int i5 = 0;
        int i6 = 0;
        while (i5 <= i2) {
            i5++;
            short s3 = sArr[(i5 * 2) + 1];
            i6++;
            if (i6 >= i3 || s != s3) {
                if (i6 < i4) {
                    short[] sArr2 = this.O;
                    int i7 = s * 2;
                    sArr2[i7] = (short) (sArr2[i7] + i6);
                } else if (s != 0) {
                    if (s != s2) {
                        short[] sArr3 = this.O;
                        int i8 = s * 2;
                        sArr3[i8] = (short) (sArr3[i8] + 1);
                    }
                    short[] sArr4 = this.O;
                    sArr4[32] = (short) (sArr4[32] + 1);
                } else if (i6 <= 10) {
                    short[] sArr5 = this.O;
                    sArr5[34] = (short) (sArr5[34] + 1);
                } else {
                    short[] sArr6 = this.O;
                    sArr6[36] = (short) (sArr6[36] + 1);
                }
                if (s3 == 0) {
                    s2 = s;
                    i3 = 138;
                } else if (s == s3) {
                    i3 = 6;
                    s2 = s;
                } else {
                    s2 = s;
                    i3 = 7;
                    i4 = 4;
                    i6 = 0;
                }
                i4 = 3;
                i6 = 0;
            }
            s = s3;
        }
    }

    public void G(int i2, int i3, int i4) {
        H(i2 - 257, 5);
        int i5 = i3 - 1;
        H(i5, 5);
        H(i4 - 4, 4);
        for (int i6 = 0; i6 < i4; i6++) {
            H(this.O[(q.f343g[i6] * 2) + 1], 3);
        }
        J(this.M, i2 - 1);
        J(this.N, i5);
    }

    public void H(int i2, int i3) {
        int i4 = this.g0;
        if (i4 <= 16 - i3) {
            this.f0 = (short) (((i2 << i4) & 65535) | this.f0);
            this.g0 = i4 + i3;
            return;
        }
        short s = (short) (((i2 << i4) & 65535) | this.f0);
        this.f0 = s;
        E(s);
        int i5 = this.g0;
        this.f0 = (short) (i2 >>> (16 - i5));
        this.g0 = i5 + (i3 - 16);
    }

    public final void I(int i2, short[] sArr) {
        int i3 = i2 * 2;
        H(sArr[i3] & 65535, sArr[i3 + 1] & 65535);
    }

    public void J(short[] sArr, int i2) {
        int i3;
        int i4;
        short s = sArr[1];
        if (s == 0) {
            i3 = 138;
            i4 = 3;
        } else {
            i3 = 7;
            i4 = 4;
        }
        int i5 = 0;
        int i6 = 0;
        short s2 = -1;
        while (i5 <= i2) {
            i5++;
            short s3 = sArr[(i5 * 2) + 1];
            i6++;
            if (i6 >= i3 || s != s3) {
                if (i6 < i4) {
                    do {
                        I(s, this.O);
                        i6--;
                    } while (i6 != 0);
                } else if (s != 0) {
                    if (s != s2) {
                        I(s, this.O);
                        i6--;
                    }
                    I(16, this.O);
                    H(i6 - 3, 2);
                } else if (i6 <= 10) {
                    I(17, this.O);
                    H(i6 - 3, 3);
                } else {
                    I(18, this.O);
                    H(i6 - 11, 7);
                }
                if (s3 == 0) {
                    s2 = s;
                    i3 = 138;
                } else if (s == s3) {
                    i3 = 6;
                    s2 = s;
                } else {
                    s2 = s;
                    i3 = 7;
                    i4 = 4;
                    i6 = 0;
                }
                i4 = 3;
                i6 = 0;
            }
            s = s3;
        }
    }

    public void K() {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 7) {
            i3 += this.M[i2 * 2];
            i2++;
        }
        int i4 = 0;
        while (i2 < 128) {
            i4 += this.M[i2 * 2];
            i2++;
        }
        while (i2 < 256) {
            i3 += this.M[i2 * 2];
            i2++;
        }
        this.k = (byte) (i3 <= (i4 >>> 2) ? 1 : 0);
    }

    public void M() {
        q qVar = this.P;
        qVar.a = this.M;
        qVar.c = p.f336h;
        q qVar2 = this.Q;
        qVar2.a = this.N;
        qVar2.c = p.f337i;
        q qVar3 = this.R;
        qVar3.a = this.O;
        qVar3.c = p.j;
        this.f0 = (short) 0;
        this.g0 = 0;
        this.e0 = 8;
        x();
    }

    public void a() {
        H(2, 3);
        short[] sArr = p.f334f;
        I(256, sArr);
        e();
        if (((this.e0 + 1) + 10) - this.g0 < 9) {
            H(2, 3);
            I(256, sArr);
            e();
        }
        this.e0 = 7;
    }

    public void b(int i2, int i3, boolean z) {
        int i4;
        int iG;
        int i5;
        if (this.I > 0) {
            if (this.k == 2) {
                K();
            }
            this.P.b(this);
            this.Q.b(this);
            iG = g();
            i4 = ((this.b0 + 3) + 7) >>> 3;
            i5 = ((this.c0 + 3) + 7) >>> 3;
            if (i5 <= i4) {
                i4 = i5;
            }
        } else {
            i4 = i3 + 5;
            iG = 0;
            i5 = i4;
        }
        if (i3 + 4 <= i4 && i2 != -1) {
            c(i2, i3, z);
        } else if (i5 == i4) {
            H((z ? 1 : 0) + 2, 3);
            h(p.f334f, p.f335g);
        } else {
            H((z ? 1 : 0) + 4, 3);
            G(this.P.b + 1, this.Q.b + 1, iG + 1);
            h(this.M, this.N);
        }
        x();
        if (z) {
            f();
        }
    }

    public void c(int i2, int i3, boolean z) {
        H((z ? 1 : 0) + 0, 3);
        i(i2, i3, true);
    }

    public Object clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        eVar.f292d = r(eVar.f292d);
        eVar.p = r(eVar.p);
        eVar.r = t(eVar.r);
        eVar.s = t(eVar.s);
        eVar.M = t(eVar.M);
        eVar.N = t(eVar.N);
        eVar.O = t(eVar.O);
        eVar.S = t(eVar.S);
        eVar.T = s(eVar.T);
        eVar.W = r(eVar.W);
        eVar.P.a = eVar.M;
        eVar.Q.a = eVar.N;
        eVar.R.a = eVar.O;
        i iVar = eVar.h0;
        if (iVar != null) {
            eVar.h0 = (i) iVar.clone();
        }
        return eVar;
    }

    public boolean d(int i2, int i3) {
        byte[] bArr = this.f292d;
        int i4 = this.a0;
        int i5 = this.Z;
        bArr[(i5 * 2) + i4] = (byte) (i2 >>> 8);
        bArr[i4 + (i5 * 2) + 1] = (byte) i2;
        bArr[this.X + i5] = (byte) i3;
        this.Z = i5 + 1;
        if (i2 == 0) {
            short[] sArr = this.M;
            int i6 = i3 * 2;
            sArr[i6] = (short) (sArr[i6] + 1);
        } else {
            this.d0++;
            short[] sArr2 = this.M;
            int i7 = (q.f345i[i3] + 256 + 1) * 2;
            sArr2[i7] = (short) (sArr2[i7] + 1);
            short[] sArr3 = this.N;
            int iC = q.c(i2 - 1) * 2;
            sArr3[iC] = (short) (sArr3[iC] + 1);
        }
        int i8 = this.Z;
        if ((i8 & 8191) == 0 && this.I > 2) {
            int i9 = i8 * 8;
            int i10 = this.C - this.y;
            for (int i11 = 0; i11 < 30; i11++) {
                i9 = (int) (((long) i9) + (((long) this.N[i11 * 2]) * (((long) q.f341e[i11]) + 5)));
            }
            int i12 = i9 >>> 3;
            if (this.d0 < this.Z / 2 && i12 < i10 / 2) {
                return true;
            }
        }
        return this.Z == this.Y - 1;
    }

    public void e() {
        int i2 = this.g0;
        if (i2 == 16) {
            E(this.f0);
            this.f0 = (short) 0;
            this.g0 = 0;
        } else if (i2 >= 8) {
            C((byte) this.f0);
            this.f0 = (short) (this.f0 >>> 8);
            this.g0 -= 8;
        }
    }

    public void f() {
        int i2 = this.g0;
        if (i2 > 8) {
            E(this.f0);
        } else if (i2 > 0) {
            C((byte) this.f0);
        }
        this.f0 = (short) 0;
        this.g0 = 0;
    }

    public int g() {
        F(this.M, this.P.b);
        F(this.N, this.Q.b);
        this.R.b(this);
        int i2 = 18;
        while (i2 >= 3 && this.O[(q.f343g[i2] * 2) + 1] == 0) {
            i2--;
        }
        this.b0 += ((i2 + 1) * 3) + 5 + 5 + 4;
        return i2;
    }

    public void h(short[] sArr, short[] sArr2) {
        if (this.Z != 0) {
            int i2 = 0;
            do {
                byte[] bArr = this.f292d;
                int i3 = this.a0;
                int i4 = i2 * 2;
                int i5 = (bArr[i3 + i4 + 1] & ExifInterface.MARKER) | ((bArr[i3 + i4] << 8) & 65280);
                int i6 = bArr[this.X + i2] & ExifInterface.MARKER;
                i2++;
                if (i5 == 0) {
                    I(i6, sArr);
                } else {
                    byte b = q.f345i[i6];
                    I(b + 256 + 1, sArr);
                    int i7 = q.f340d[b];
                    if (i7 != 0) {
                        H(i6 - q.j[b], i7);
                    }
                    int i8 = i5 - 1;
                    int iC = q.c(i8);
                    I(iC, sArr2);
                    int i9 = q.f341e[iC];
                    if (i9 != 0) {
                        H(i8 - q.k[iC], i9);
                    }
                }
            } while (i2 < this.Z);
        }
        I(256, sArr);
        this.e0 = sArr[513];
    }

    public void i(int i2, int i3, boolean z) {
        f();
        this.e0 = 8;
        if (z) {
            E((short) i3);
            E((short) (i3 ^ (-1)));
        }
        D(this.p, i2, i3);
    }

    public int j(int i2) {
        int i3;
        if (i2 <= 4 && i2 >= 0) {
            t tVar = this.a;
            if (tVar.f355e != null && ((tVar.a != null || tVar.c == 0) && ((i3 = this.b) != 666 || i2 == 4))) {
                if (tVar.f357g == 0) {
                    tVar.f359i = j0[7];
                    return -5;
                }
                int i4 = this.l;
                this.l = i2;
                if (i3 == 42) {
                    if (this.j == 2) {
                        w().a(this);
                        this.b = 113;
                        this.a.m.reset();
                    } else {
                        int i5 = (((this.n - 8) << 4) + 8) << 8;
                        int i6 = ((this.I - 1) & 255) >> 1;
                        if (i6 > 3) {
                            i6 = 3;
                        }
                        int i7 = i5 | (i6 << 6);
                        if (this.C != 0) {
                            i7 |= 32;
                        }
                        this.b = 113;
                        B(i7 + (31 - (i7 % 31)));
                        if (this.C != 0) {
                            long value = this.a.m.getValue();
                            B((int) (value >>> 16));
                            B((int) (value & WebSocketProtocol.PAYLOAD_SHORT_MAX));
                        }
                        this.a.m.reset();
                    }
                }
                if (this.f295i != 0) {
                    this.a.a();
                    if (this.a.f357g == 0) {
                        this.l = -1;
                        return 0;
                    }
                } else {
                    t tVar2 = this.a;
                    if (tVar2.c == 0 && i2 <= i4 && i2 != 4) {
                        tVar2.f359i = j0[7];
                        return -5;
                    }
                }
                int i8 = this.b;
                if (i8 == 666) {
                    t tVar3 = this.a;
                    if (tVar3.c != 0) {
                        tVar3.f359i = j0[7];
                        return -5;
                    }
                }
                if (this.a.c != 0 || this.E != 0 || (i2 != 0 && i8 != 666)) {
                    int i9 = i0[this.I].f297e;
                    int iP = i9 != 0 ? i9 != 1 ? i9 != 2 ? -1 : p(i2) : o(i2) : q(i2);
                    if (iP == 2 || iP == 3) {
                        this.b = 666;
                    }
                    if (iP == 0 || iP == 2) {
                        if (this.a.f357g == 0) {
                            this.l = -1;
                        }
                        return 0;
                    }
                    if (iP == 1) {
                        if (i2 == 1) {
                            a();
                        } else {
                            c(0, 0, false);
                            if (i2 == 3) {
                                for (int i10 = 0; i10 < this.u; i10++) {
                                    this.s[i10] = 0;
                                }
                            }
                        }
                        this.a.a();
                        if (this.a.f357g == 0) {
                            this.l = -1;
                            return 0;
                        }
                    }
                }
                if (i2 != 4) {
                    return 0;
                }
                int i11 = this.j;
                if (i11 <= 0) {
                    return 1;
                }
                if (i11 == 2) {
                    long value2 = this.a.m.getValue();
                    C((byte) (value2 & 255));
                    C((byte) ((value2 >> 8) & 255));
                    C((byte) ((value2 >> 16) & 255));
                    C((byte) ((value2 >> 24) & 255));
                    C((byte) (this.a.f354d & 255));
                    C((byte) ((this.a.f354d >> 8) & 255));
                    C((byte) ((this.a.f354d >> 16) & 255));
                    C((byte) (255 & (this.a.f354d >> 24)));
                    w().b(value2);
                } else {
                    long value3 = this.a.m.getValue();
                    B((int) (value3 >>> 16));
                    B((int) (value3 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
                }
                this.a.a();
                int i12 = this.j;
                if (i12 > 0) {
                    this.j = -i12;
                }
                return this.f295i != 0 ? 0 : 1;
            }
            tVar.f359i = j0[4];
        }
        return -2;
    }

    public int k() {
        int i2 = this.b;
        if (i2 != 42 && i2 != 113 && i2 != 666) {
            return -2;
        }
        this.f292d = null;
        this.s = null;
        this.r = null;
        this.p = null;
        return i2 == 113 ? -3 : 0;
    }

    public int l(int i2, int i3) {
        return m(i2, 8, i3, 8, 0);
    }

    public final int m(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        t tVar = this.a;
        tVar.f359i = null;
        if (i2 == -1) {
            i2 = 6;
        }
        if (i4 < 0) {
            i7 = 0;
            i4 = -i4;
        } else if (i4 > 15) {
            i4 -= 16;
            tVar.m = new b();
            i7 = 2;
        } else {
            i7 = 1;
        }
        if (i5 < 1 || i5 > 9 || i3 != 8 || i4 < 9 || i4 > 15 || i2 < 0 || i2 > 9 || i6 < 0 || i6 > 2) {
            return -2;
        }
        this.a.j = this;
        this.j = i7;
        this.n = i4;
        int i8 = 1 << i4;
        this.m = i8;
        this.o = i8 - 1;
        int i9 = i5 + 7;
        this.v = i9;
        int i10 = 1 << i9;
        this.u = i10;
        this.w = i10 - 1;
        this.x = ((i9 + 3) - 1) / 3;
        this.p = new byte[i8 * 2];
        this.r = new short[i8];
        this.s = new short[i10];
        int i11 = 1 << (i5 + 6);
        this.Y = i11;
        this.f292d = new byte[i11 * 4];
        this.f293f = i11 * 4;
        this.a0 = i11 / 2;
        this.X = i11 * 3;
        this.I = i2;
        this.J = i6;
        return n();
    }

    public int n() {
        t tVar = this.a;
        tVar.f358h = 0L;
        tVar.f354d = 0L;
        tVar.f359i = null;
        tVar.l = 2;
        this.f295i = 0;
        this.f294h = 0;
        int i2 = this.j;
        if (i2 < 0) {
            this.j = -i2;
        }
        this.b = this.j == 0 ? 113 : 42;
        tVar.m.reset();
        this.l = 0;
        M();
        y();
        return 0;
    }

    public int o(int i2) {
        boolean zD;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            if (this.E < 262) {
                u();
                int i7 = this.E;
                if (i7 < 262 && i2 == 0) {
                    return 0;
                }
                if (i7 == 0) {
                    v(i2 == 4);
                    return this.a.f357g == 0 ? i2 == 4 ? 2 : 0 : i2 == 4 ? 3 : 1;
                }
            }
            if (this.E >= 3) {
                int i8 = this.t << this.x;
                byte[] bArr = this.p;
                int i9 = this.C;
                int i10 = (i8 ^ (bArr[i9 + 2] & ExifInterface.MARKER)) & this.w;
                this.t = i10;
                short[] sArr = this.s;
                int i11 = sArr[i10] & 65535;
                this.r[this.o & i9] = sArr[i10];
                sArr[i10] = (short) i9;
                i6 = i11;
            }
            if (i6 != 0 && ((this.C - i6) & 65535) <= this.m - 262 && this.J != 2) {
                this.z = z(i6);
            }
            int i12 = this.z;
            if (i12 >= 3) {
                zD = d(this.C - this.D, i12 - 3);
                int i13 = this.E;
                int i14 = this.z;
                int i15 = i13 - i14;
                this.E = i15;
                if (i14 > this.H || i15 < 3) {
                    int i16 = this.C + i14;
                    this.C = i16;
                    this.z = 0;
                    byte[] bArr2 = this.p;
                    int i17 = bArr2[i16] & ExifInterface.MARKER;
                    this.t = i17;
                    this.t = ((bArr2[i16 + 1] & ExifInterface.MARKER) ^ (i17 << this.x)) & this.w;
                } else {
                    this.z = i14 - 1;
                    do {
                        i3 = this.C + 1;
                        this.C = i3;
                        int i18 = ((this.t << this.x) ^ (this.p[i3 + 2] & ExifInterface.MARKER)) & this.w;
                        this.t = i18;
                        short[] sArr2 = this.s;
                        i4 = sArr2[i18] & 65535;
                        this.r[this.o & i3] = sArr2[i18];
                        sArr2[i18] = (short) i3;
                        i5 = this.z - 1;
                        this.z = i5;
                    } while (i5 != 0);
                    this.C = i3 + 1;
                    i6 = i4;
                }
            } else {
                zD = d(0, this.p[this.C] & ExifInterface.MARKER);
                this.E--;
                this.C++;
            }
            if (zD) {
                v(false);
                if (this.a.f357g == 0) {
                    return 0;
                }
            }
        }
    }

    public int p(int i2) {
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            if (this.E < 262) {
                u();
                int i6 = this.E;
                if (i6 < 262 && i2 == 0) {
                    return 0;
                }
                if (i6 == 0) {
                    if (this.B != 0) {
                        d(0, this.p[this.C - 1] & ExifInterface.MARKER);
                        this.B = 0;
                    }
                    v(i2 == 4);
                    return this.a.f357g == 0 ? i2 == 4 ? 2 : 0 : i2 == 4 ? 3 : 1;
                }
            }
            if (this.E >= 3) {
                int i7 = this.t << this.x;
                byte[] bArr = this.p;
                int i8 = this.C;
                int i9 = (i7 ^ (bArr[i8 + 2] & ExifInterface.MARKER)) & this.w;
                this.t = i9;
                short[] sArr = this.s;
                int i10 = sArr[i9] & 65535;
                this.r[this.o & i8] = sArr[i9];
                sArr[i9] = (short) i8;
                i5 = i10;
            }
            int i11 = this.z;
            this.F = i11;
            this.A = this.D;
            this.z = 2;
            if (i5 != 0 && i11 < this.H && ((this.C - i5) & 65535) <= this.m - 262) {
                if (this.J != 2) {
                    this.z = z(i5);
                }
                int i12 = this.z;
                if (i12 <= 5 && (this.J == 1 || (i12 == 3 && this.C - this.D > 4096))) {
                    this.z = 2;
                }
            }
            int i13 = this.F;
            if (i13 >= 3 && this.z <= i13) {
                int i14 = this.C;
                int i15 = (this.E + i14) - 3;
                boolean zD = d((i14 - 1) - this.A, i13 - 3);
                int i16 = this.E;
                int i17 = this.F;
                this.E = i16 - (i17 - 1);
                this.F = i17 - 2;
                do {
                    i3 = this.C + 1;
                    this.C = i3;
                    if (i3 <= i15) {
                        int i18 = ((this.t << this.x) ^ (this.p[i3 + 2] & ExifInterface.MARKER)) & this.w;
                        this.t = i18;
                        short[] sArr2 = this.s;
                        int i19 = sArr2[i18] & 65535;
                        this.r[this.o & i3] = sArr2[i18];
                        sArr2[i18] = (short) i3;
                        i5 = i19;
                    }
                    i4 = this.F - 1;
                    this.F = i4;
                } while (i4 != 0);
                this.B = 0;
                this.z = 2;
                this.C = i3 + 1;
                if (zD) {
                    v(false);
                    if (this.a.f357g == 0) {
                        return 0;
                    }
                } else {
                    continue;
                }
            } else if (this.B != 0) {
                if (d(0, this.p[this.C - 1] & ExifInterface.MARKER)) {
                    v(false);
                }
                this.C++;
                this.E--;
                if (this.a.f357g == 0) {
                    return 0;
                }
            } else {
                this.B = 1;
                this.C++;
                this.E--;
            }
        }
    }

    public int q(int i2) {
        int i3 = this.f293f;
        int i4 = 65535 > i3 + (-5) ? i3 - 5 : 65535;
        while (true) {
            if (this.E <= 1) {
                u();
                int i5 = this.E;
                if (i5 == 0 && i2 == 0) {
                    return 0;
                }
                if (i5 == 0) {
                    v(i2 == 4);
                    return this.a.f357g == 0 ? i2 == 4 ? 2 : 0 : i2 == 4 ? 3 : 1;
                }
            }
            int i6 = this.C + this.E;
            this.C = i6;
            this.E = 0;
            int i7 = this.y + i4;
            if (i6 == 0 || i6 >= i7) {
                this.E = i6 - i7;
                this.C = i7;
                v(false);
                if (this.a.f357g == 0) {
                    return 0;
                }
            }
            if (this.C - this.y >= this.m - 262) {
                v(false);
                if (this.a.f357g == 0) {
                    return 0;
                }
            }
        }
    }

    public final byte[] r(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final int[] s(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public final short[] t(short[] sArr) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        System.arraycopy(sArr, 0, sArr2, 0, length);
        return sArr2;
    }

    public void u() {
        int i2;
        int i3;
        do {
            int i4 = this.q;
            int i5 = this.E;
            int i6 = this.C;
            int i7 = (i4 - i5) - i6;
            if (i7 == 0 && i6 == 0 && i5 == 0) {
                i7 = this.m;
            } else if (i7 == -1) {
                i7--;
            } else {
                int i8 = this.m;
                if (i6 >= (i8 + i8) - 262) {
                    byte[] bArr = this.p;
                    System.arraycopy(bArr, i8, bArr, 0, i8);
                    int i9 = this.D;
                    int i10 = this.m;
                    this.D = i9 - i10;
                    this.C -= i10;
                    this.y -= i10;
                    int i11 = this.u;
                    int i12 = i11;
                    do {
                        short[] sArr = this.s;
                        i11--;
                        int i13 = sArr[i11] & 65535;
                        i2 = this.m;
                        sArr[i11] = i13 >= i2 ? (short) (i13 - i2) : (short) 0;
                        i12--;
                    } while (i12 != 0);
                    int i14 = i2;
                    do {
                        short[] sArr2 = this.r;
                        i2--;
                        int i15 = sArr2[i2] & 65535;
                        i3 = this.m;
                        sArr2[i2] = i15 >= i3 ? (short) (i15 - i3) : (short) 0;
                        i14--;
                    } while (i14 != 0);
                    i7 += i3;
                }
            }
            t tVar = this.a;
            if (tVar.c == 0) {
                return;
            }
            int iC = this.E + tVar.c(this.p, this.C + this.E, i7);
            this.E = iC;
            if (iC >= 3) {
                byte[] bArr2 = this.p;
                int i16 = this.C;
                int i17 = bArr2[i16] & ExifInterface.MARKER;
                this.t = i17;
                this.t = ((bArr2[i16 + 1] & ExifInterface.MARKER) ^ (i17 << this.x)) & this.w;
            }
            if (iC >= 262) {
                return;
            }
        } while (this.a.c != 0);
    }

    public void v(boolean z) {
        int i2 = this.y;
        b(i2 >= 0 ? i2 : -1, this.C - i2, z);
        this.y = this.C;
        this.a.a();
    }

    public synchronized i w() {
        if (this.h0 == null) {
            this.h0 = new i();
        }
        return this.h0;
    }

    public void x() {
        for (int i2 = 0; i2 < 286; i2++) {
            this.M[i2 * 2] = 0;
        }
        for (int i3 = 0; i3 < 30; i3++) {
            this.N[i3 * 2] = 0;
        }
        for (int i4 = 0; i4 < 19; i4++) {
            this.O[i4 * 2] = 0;
        }
        this.M[512] = 1;
        this.c0 = 0;
        this.b0 = 0;
        this.d0 = 0;
        this.Z = 0;
    }

    public void y() {
        this.q = this.m * 2;
        this.s[this.u - 1] = 0;
        for (int i2 = 0; i2 < this.u - 1; i2++) {
            this.s[i2] = 0;
        }
        a[] aVarArr = i0;
        int i3 = this.I;
        this.H = aVarArr[i3].b;
        this.K = aVarArr[i3].a;
        this.L = aVarArr[i3].c;
        this.G = aVarArr[i3].f296d;
        this.C = 0;
        this.y = 0;
        this.E = 0;
        this.F = 2;
        this.z = 2;
        this.B = 0;
        this.t = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00be A[PHI: r1 r2 r7 r9
  0x00be: PHI (r1v2 int) = (r1v1 int), (r1v1 int), (r1v1 int), (r1v1 int), (r1v11 int) binds: [B:13:0x0033, B:15:0x0039, B:17:0x003f, B:19:0x0049, B:45:0x00bd] A[DONT_GENERATE, DONT_INLINE]
  0x00be: PHI (r2v2 int) = (r2v1 int), (r2v1 int), (r2v1 int), (r2v1 int), (r2v3 int) binds: [B:13:0x0033, B:15:0x0039, B:17:0x003f, B:19:0x0049, B:45:0x00bd] A[DONT_GENERATE, DONT_INLINE]
  0x00be: PHI (r7v3 byte) = (r7v2 byte), (r7v2 byte), (r7v2 byte), (r7v2 byte), (r7v4 byte) binds: [B:13:0x0033, B:15:0x0039, B:17:0x003f, B:19:0x0049, B:45:0x00bd] A[DONT_GENERATE, DONT_INLINE]
  0x00be: PHI (r9v3 byte) = (r9v2 byte), (r9v2 byte), (r9v2 byte), (r9v2 byte), (r9v4 byte) binds: [B:13:0x0033, B:15:0x0039, B:17:0x003f, B:19:0x0049, B:45:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cd A[EDGE_INSN: B:56:0x00cd->B:50:0x00cd BREAK  A[LOOP:0: B:12:0x002d->B:59:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int z(int r14) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.e.z(int):int");
    }
}
