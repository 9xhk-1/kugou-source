package e.b.a;

import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public int a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f329i;
    public long c = -1;
    public int j = -1;
    public byte[] k = new byte[4];
    public i l = null;
    public ByteArrayOutputStream m = null;

    public class a extends Exception {
        public int a;

        public a(m mVar, int i2) {
            this.a = i2;
        }
    }

    public m(t tVar) {
        this.f328h = tVar;
    }

    public final void a(int i2, long j) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3] = (byte) (255 & j);
            j >>= 8;
        }
        this.f328h.m.update(this.k, 0, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x03dd, code lost:
    
        r4 = r21.f328h;
        r6 = r4.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x03e1, code lost:
    
        if (r6 != 0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x03e3, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x03e4, code lost:
    
        r4.c = r6 - 1;
        r4.f354d++;
        r2 = r4.a;
        r6 = r4.b;
        r4.b = r6 + 1;
        r21.f324d = ((long) ((r2[r6] & androidx.exifinterface.media.ExifInterface.MARKER) << 24)) & 4278190080L;
        r21.a = 3;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0409, code lost:
    
        r4 = r21.f328h;
        r6 = r4.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x040d, code lost:
    
        if (r6 != 0) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x040f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0410, code lost:
    
        r4.c = r6 - 1;
        r4.f354d++;
        r8 = r21.f324d;
        r2 = r4.a;
        r6 = r4.b;
        r4.b = r6 + 1;
        r21.f324d = r8 + (((long) ((r2[r6] & androidx.exifinterface.media.ExifInterface.MARKER) << 16)) & 16711680);
        r21.a = 4;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0432, code lost:
    
        r3 = r21.f328h;
        r4 = r3.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0436, code lost:
    
        if (r4 != 0) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0438, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0439, code lost:
    
        r3.c = r4 - 1;
        r3.f354d++;
        r4 = r21.f324d;
        r2 = r3.a;
        r6 = r3.b;
        r3.b = r6 + 1;
        r21.f324d = r4 + (((long) ((r2[r6] & androidx.exifinterface.media.ExifInterface.MARKER) << 8)) & 65280);
        r21.a = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x045d, code lost:
    
        r2 = r21.f328h;
        r3 = r2.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0461, code lost:
    
        if (r3 != 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0463, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0464, code lost:
    
        r2.c = r3 - 1;
        r2.f354d++;
        r3 = r21.f324d;
        r0 = r2.a;
        r5 = r2.b;
        r2.b = r5 + 1;
        r3 = r3 + (((long) r0[r5]) & 255);
        r21.f324d = r3;
        r2.m.reset(r3);
        r21.a = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0489, code lost:
    
        return 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0294 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x02c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(int r22) {
        /*
            Method dump skipped, instruction units count: 1222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.m.b(int):int");
    }

    public int c() {
        j jVar = this.f327g;
        if (jVar == null) {
            return 0;
        }
        jVar.a(this.f328h);
        return 0;
    }

    public int d(int i2) {
        this.f328h.f359i = null;
        this.f327g = null;
        this.f325e = 0;
        if (i2 < 0) {
            i2 = -i2;
        } else {
            this.f325e = (i2 >> 4) + 1;
            if (i2 < 48) {
                i2 &= 15;
            }
        }
        if (i2 < 8 || i2 > 15) {
            c();
            return -2;
        }
        this.f326f = i2;
        this.f327g = new j(this.f328h, 1 << i2);
        e();
        return 0;
    }

    public int e() {
        t tVar = this.f328h;
        if (tVar == null) {
            return -2;
        }
        tVar.f358h = 0L;
        tVar.f354d = 0L;
        tVar.f359i = null;
        this.a = 14;
        this.j = -1;
        this.f327g.d(tVar);
        return 0;
    }

    public final int f(t tVar, int i2, int i3) throws a {
        if (this.m == null) {
            this.m = new ByteArrayOutputStream();
        }
        while (this.f324d > 0) {
            int i4 = tVar.c;
            if (i4 == 0) {
                throw new a(this, i2);
            }
            tVar.c = i4 - 1;
            tVar.f354d++;
            byte[] bArr = tVar.a;
            int i5 = tVar.b;
            byte b = bArr[i5];
            this.m.write(bArr, i5, 1);
            tVar.m.update(tVar.a, tVar.b, 1);
            tVar.b++;
            this.f324d--;
            i2 = i3;
        }
        return i2;
    }

    public final int g(t tVar, int i2, int i3, int i4) throws a {
        if (this.j == -1) {
            this.j = i2;
            this.f324d = 0L;
        }
        while (true) {
            int i5 = this.j;
            if (i5 <= 0) {
                if (i2 == 2) {
                    this.f324d &= WebSocketProtocol.PAYLOAD_SHORT_MAX;
                } else if (i2 == 4) {
                    this.f324d &= 4294967295L;
                }
                this.j = -1;
                return i3;
            }
            int i6 = tVar.c;
            if (i6 == 0) {
                throw new a(this, i3);
            }
            tVar.c = i6 - 1;
            tVar.f354d++;
            long j = this.f324d;
            byte[] bArr = tVar.a;
            int i7 = tVar.b;
            tVar.b = i7 + 1;
            this.f324d = j | ((long) ((bArr[i7] & ExifInterface.MARKER) << ((i2 - i5) * 8)));
            this.j = i5 - 1;
            i3 = i4;
        }
    }

    public final int h(t tVar, int i2, int i3) throws a {
        if (this.m == null) {
            this.m = new ByteArrayOutputStream();
        }
        while (true) {
            int i4 = tVar.c;
            if (i4 == 0) {
                throw new a(this, i2);
            }
            tVar.c = i4 - 1;
            tVar.f354d++;
            byte[] bArr = tVar.a;
            int i5 = tVar.b;
            byte b = bArr[i5];
            if (b != 0) {
                this.m.write(bArr, i5, 1);
            }
            tVar.m.update(tVar.a, tVar.b, 1);
            tVar.b++;
            if (b == 0) {
                return i3;
            }
            i2 = i3;
        }
    }
}
