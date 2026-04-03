package e.b.a;

import androidx.core.app.FrameMetricsAggregator;
import androidx.media.AudioAttributesCompat;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final int[] s = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, AudioAttributesCompat.FLAG_ALL, 2047, 4095, 8191, 16383, 32767, 65535};
    public static final int[] t = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
    public int a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f307e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f311i;
    public int j;
    public int k;
    public byte[] m;
    public int n;
    public int o;
    public int p;
    public boolean q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f308f = new int[1];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f309g = new int[1];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f310h = new k();
    public l r = new l();
    public int[] l = new int[4320];

    public j(t tVar, int i2) {
        this.m = new byte[i2];
        this.n = i2;
        this.q = tVar.k.f325e != 0;
        this.a = 0;
        d(tVar);
    }

    public void a(t tVar) {
        d(tVar);
        this.m = null;
        this.l = null;
    }

    public int b(t tVar, int i2) {
        int i3 = tVar.f356f;
        int i4 = this.o;
        int i5 = this.p;
        if (i4 > i5) {
            i5 = this.n;
        }
        int i6 = i5 - i4;
        int i7 = tVar.f357g;
        if (i6 > i7) {
            i6 = i7;
        }
        if (i6 != 0 && i2 == -5) {
            i2 = 0;
        }
        tVar.f357g = i7 - i6;
        tVar.f358h += (long) i6;
        if (this.q) {
            tVar.m.update(this.m, i4, i6);
        }
        System.arraycopy(this.m, i4, tVar.f355e, i3, i6);
        int i8 = i3 + i6;
        int i9 = i4 + i6;
        int i10 = this.n;
        if (i9 == i10) {
            if (this.p == i10) {
                this.p = 0;
            }
            int i11 = this.p - 0;
            int i12 = tVar.f357g;
            if (i11 > i12) {
                i11 = i12;
            }
            if (i11 != 0 && i2 == -5) {
                i2 = 0;
            }
            tVar.f357g = i12 - i11;
            tVar.f358h += (long) i11;
            if (this.q) {
                tVar.m.update(this.m, 0, i11);
            }
            System.arraycopy(this.m, 0, tVar.f355e, i8, i11);
            i8 += i11;
            i9 = i11 + 0;
        }
        tVar.f356f = i8;
        this.o = i9;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e4, code lost:
    
        r27.f307e = null;
        r27.a = 9;
        r28.f359i = "invalid bit length repeat";
        r27.k = r8;
        r27.j = r7;
        r28.c = r9;
        r28.f354d += (long) (r5 - r28.b);
        r28.b = r5;
        r27.p = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0307, code lost:
    
        return b(r28, -3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03ec, code lost:
    
        r27.a = r1;
        r28.f359i = "too many length or distance symbols";
        r27.k = r4;
        r27.j = r5;
        r28.c = r3;
        r28.f354d += (long) (r2 - r28.b);
        r28.b = r2;
        r27.p = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x040a, code lost:
    
        return b(r28, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ff, code lost:
    
        r27.p = r14;
        r1 = b(r28, r13);
        r14 = r27.p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0209, code lost:
    
        if (r27.o == r14) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020b, code lost:
    
        r27.k = r4;
        r27.j = r5;
        r28.c = r3;
        r28.f354d += (long) (r2 - r28.b);
        r28.b = r2;
        r27.p = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0223, code lost:
    
        return b(r28, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0224, code lost:
    
        r27.a = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0228, code lost:
    
        r27.k = r4;
        r27.j = r5;
        r28.c = r3;
        r28.f354d += (long) (r2 - r28.b);
        r28.b = r2;
        r27.p = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0241, code lost:
    
        return b(r28, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x036c A[LOOP:10: B:37:0x00b9->B:117:0x036c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(e.b.a.t r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.j.c(e.b.a.t, int):int");
    }

    public void d(t tVar) {
        if (this.a == 6) {
            this.f310h.a(tVar);
        }
        this.a = 0;
        this.j = 0;
        this.k = 0;
        this.p = 0;
        this.o = 0;
        if (this.q) {
            tVar.m.reset();
        }
    }
}
