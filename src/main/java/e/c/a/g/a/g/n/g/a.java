package e.c.a.g.a.g.n.g;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import e.c.a.g.a.g.n.g.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"UseSparseArrays"})
public class a extends c {
    public static final int[] s = {1684631142, 1751411826, 1835296868, 1835297121, 1835626086, 1836019574, 1836476516, 1936549988, 1937007212, 1937011556, 1937011578, 1937011827, 1953196132, 1953653099};
    public static final int[] t = {1684631142, 1751411826, 1835296868, 1836476516, 1936549988, 1953196132, 1937011556};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f982i;
    public int j;
    public HashMap<Integer, b> k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: e.c.a.g.a.g.n.g.a$a, reason: collision with other inner class name */
    public class C0153a implements c.a {
        @Override // e.c.a.g.a.g.n.g.c.a
        public c create() {
            return new a();
        }

        @Override // e.c.a.g.a.g.n.g.c.a
        public String[] getSupportedExtensions() {
            return new String[]{"aac", "m4a"};
        }
    }

    public class b {
        public int a;
        public byte[] b;

        public b(a aVar) {
        }
    }

    public static c.a n() {
        return new C0153a();
    }

    @Override // e.c.a.g.a.g.n.g.c
    public void a(File file) throws IOException {
        int i2;
        super.a(file);
        this.l = 0;
        this.m = 0;
        this.f979f = 0;
        this.o = 255;
        this.p = 0;
        this.n = 0;
        this.q = -1;
        this.r = -1;
        this.k = new HashMap<>();
        int length = (int) this.b.length();
        this.j = length;
        if (length < 128) {
            throw new IOException("File too small to parse");
        }
        FileInputStream fileInputStream = new FileInputStream(this.b);
        byte[] bArr = new byte[41];
        if (fileInputStream.skip(this.j - 41) >= 0 && fileInputStream.read(bArr, 0, 41) < 0) {
            throw new IOException("can not read checkstream");
        }
        if (bArr[0] == 107 && bArr[1] == 103 && bArr[2] == 109 && bArr[3] == 112 && bArr[4] == 51 && bArr[5] == 104 && bArr[6] == 97 && bArr[7] == 115 && bArr[8] == 104) {
            this.j -= 41;
        }
        fileInputStream.close();
        byte[] bArr2 = new byte[8];
        if (new FileInputStream(this.b).read(bArr2, 0, 8) < 0) {
            throw new IOException("can not read header");
        }
        if (bArr2[0] != 0 || bArr2[4] != 102 || bArr2[5] != 116 || bArr2[6] != 121 || bArr2[7] != 112) {
            throw new IOException("Unknown file format");
        }
        p(new FileInputStream(this.b), this.j);
        int i3 = this.q;
        if (i3 <= 0 || this.r <= 0) {
            throw new IOException("Didn't find mdat");
        }
        if (i3 - 570 > 0) {
            FileInputStream fileInputStream2 = new FileInputStream(this.b);
            if (fileInputStream2.skip(this.q - 570) < 0) {
                throw new IOException("can not skip skipAACFromResult");
            }
            byte[] bArr3 = new byte[14];
            if (fileInputStream2.read(bArr3, 0, 14) < 0) {
                throw new IOException("can not read cs");
            }
            i2 = (bArr3[0] == 78 && bArr3[1] == 101 && bArr3[2] == 114 && bArr3[3] == 111 && bArr3[5] == 65 && bArr3[6] == 65 && bArr3[7] == 67 && bArr3[9] == 99 && bArr3[10] == 111 && bArr3[11] == 100 && bArr3[12] == 101 && bArr3[13] == 99) ? 8 : 0;
            fileInputStream2.close();
        } else {
            i2 = 0;
        }
        FileInputStream fileInputStream3 = new FileInputStream(this.b);
        int i4 = this.q + i2;
        this.q = i4;
        if (fileInputStream3.skip(i4) < 0) {
            throw new IOException("can not skip mdat");
        }
        this.n = this.q;
        o(fileInputStream3, this.r);
        boolean z = false;
        for (int i5 : s) {
            if (!this.k.containsKey(Integer.valueOf(i5))) {
                z = true;
            }
        }
        if (z) {
            throw new IOException("Could not parse MP4 file");
        }
    }

    @Override // e.c.a.g.a.g.n.g.c
    public void b(File file, int i2, int i3) throws IOException {
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(this.b);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        k(1718909296, new byte[]{77, 52, 65, 32, 0, 0, 0, 0, 77, 52, 65, 32, 109, 112, 52, 50, 105, 115, 111, 109, 0, 0, 0, 0});
        byte b2 = (byte) ((i3 >> 24) & 255);
        byte b3 = (byte) ((i3 >> 16) & 255);
        byte b4 = (byte) ((i3 >> 8) & 255);
        byte b5 = (byte) (i3 & 255);
        int i4 = this.m;
        k(1937011827, new byte[]{0, 0, 0, 0, 0, 0, 0, 1, b2, b3, b4, b5, (byte) ((i4 >> 24) & 255), (byte) ((i4 >> 16) & 255), (byte) ((i4 >> 8) & 255), (byte) (i4 & 255)});
        k(1937011555, new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, b2, b3, b4, b5, 0, 0, 0, 1});
        int i5 = i3 * 4;
        byte[] bArr = new byte[i5 + 12];
        bArr[8] = b2;
        bArr[9] = b3;
        bArr[10] = b4;
        bArr[11] = b5;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 * 4;
            int[] iArr = this.f981h;
            int i8 = i2 + i6;
            bArr[i7 + 12] = (byte) ((iArr[i8] >> 24) & 255);
            bArr[i7 + 13] = (byte) ((iArr[i8] >> 16) & 255);
            bArr[i7 + 14] = (byte) ((iArr[i8] >> 8) & 255);
            bArr[i7 + 15] = (byte) (iArr[i8] & 255);
        }
        k(1937011578, bArr);
        int i9 = i5 + 144 + this.k.get(1937011556).a + this.k.get(1937011555).a + this.k.get(1836476516).a + this.k.get(1953196132).a + this.k.get(1835296868).a + this.k.get(1751411826).a + this.k.get(1936549988).a + this.k.get(1684631142).a;
        k(1937007471, new byte[]{0, 0, 0, 0, 0, 0, 0, 1, (byte) ((i9 >> 24) & 255), (byte) ((i9 >> 16) & 255), (byte) ((i9 >> 8) & 255), (byte) (i9 & 255)});
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + 2082758400;
        byte[] bArr2 = {(byte) ((jCurrentTimeMillis >> 24) & 255), (byte) ((jCurrentTimeMillis >> 16) & 255), (byte) ((jCurrentTimeMillis >> 8) & 255), (byte) (jCurrentTimeMillis & 255)};
        long j = ((long) (i3 * 1024)) * 1000;
        int i10 = this.l;
        long j2 = j / ((long) i10);
        if (j % ((long) i10) > 0) {
            j2++;
        }
        byte[] bArr3 = {(byte) ((j2 >> 26) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 8) & 255), (byte) (j2 & 255)};
        b bVar = this.k.get(1835296868);
        if (bVar == null) {
            bVar = new b(this);
            this.k.put(1835296868, bVar);
        }
        byte[] bArr4 = {0, 0, 0, 0, bArr2[0], bArr2[1], bArr2[2], bArr2[3], bArr2[0], bArr2[1], bArr2[2], bArr2[3], 0, 0, 3, -24, bArr3[0], bArr3[1], bArr3[2], bArr3[3], 0, 0, 0, 0};
        bVar.b = bArr4;
        bVar.a = bArr4.length + 8;
        b bVar2 = this.k.get(1836476516);
        if (bVar2 == null) {
            bVar2 = new b(this);
            this.k.put(1836476516, bVar2);
        }
        byte[] bArr5 = {0, 0, 0, 0, bArr2[0], bArr2[1], bArr2[2], bArr2[3], bArr2[0], bArr2[1], bArr2[2], bArr2[3], 0, 0, 3, -24, bArr3[0], bArr3[1], bArr3[2], bArr3[3], 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
        bVar2.b = bArr5;
        bVar2.a = bArr5.length + 8;
        this.k.get(1937007212).a = this.k.get(1937011556).a + 8 + this.k.get(1937011827).a + this.k.get(1937011555).a + this.k.get(1937011578).a + this.k.get(1937007471).a;
        this.k.get(1835626086).a = this.k.get(1684631142).a + 8 + this.k.get(1936549988).a + this.k.get(1937007212).a;
        this.k.get(1835297121).a = this.k.get(1835296868).a + 8 + this.k.get(1751411826).a + this.k.get(1835626086).a;
        this.k.get(1953653099).a = this.k.get(1953196132).a + 8 + this.k.get(1835297121).a;
        this.k.get(1836019574).a = this.k.get(1836476516).a + 8 + this.k.get(1953653099).a;
        int i11 = 8;
        for (int i12 = 0; i12 < i3; i12++) {
            i11 += this.f981h[i2 + i12];
        }
        this.k.get(1835295092).a = i11;
        m(fileOutputStream, 1718909296);
        l(fileOutputStream, 1836019574);
        m(fileOutputStream, 1836476516);
        l(fileOutputStream, 1953653099);
        m(fileOutputStream, 1953196132);
        l(fileOutputStream, 1835297121);
        m(fileOutputStream, 1835296868);
        m(fileOutputStream, 1751411826);
        l(fileOutputStream, 1835626086);
        m(fileOutputStream, 1684631142);
        m(fileOutputStream, 1936549988);
        l(fileOutputStream, 1937007212);
        m(fileOutputStream, 1937011556);
        m(fileOutputStream, 1937011827);
        m(fileOutputStream, 1937011555);
        m(fileOutputStream, 1937011578);
        m(fileOutputStream, 1937007471);
        l(fileOutputStream, 1835295092);
        int i13 = 0;
        for (int i14 = 0; i14 < i3; i14++) {
            int[] iArr2 = this.f981h;
            int i15 = i2 + i14;
            if (iArr2[i15] > i13) {
                i13 = iArr2[i15];
            }
        }
        byte[] bArr6 = new byte[i13];
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            int i18 = i2 + i17;
            int i19 = this.f980g[i18] - i16;
            int i20 = this.f981h[i18];
            if (i19 >= 0) {
                if (i19 > 0 && fileInputStream.skip(i19) > 0) {
                    i16 += i19;
                }
                if (fileInputStream.read(bArr6, 0, i20) > 0) {
                    fileOutputStream.write(bArr6, 0, i20);
                    i16 += i20;
                }
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int[] d() {
        return this.f981h;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int f() {
        return this.f979f;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int g() {
        return this.l;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int h() {
        return this.m;
    }

    public void k(int i2, byte[] bArr) {
        b bVar = this.k.get(Integer.valueOf(i2));
        if (bVar == null) {
            bVar = new b(this);
            this.k.put(Integer.valueOf(i2), bVar);
        }
        bVar.a = bArr.length + 8;
        bVar.b = bArr;
    }

    public void l(FileOutputStream fileOutputStream, int i2) throws IOException {
        int i3 = this.k.get(Integer.valueOf(i2)).a;
        fileOutputStream.write(new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255), (byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)}, 0, 8);
    }

    public void m(FileOutputStream fileOutputStream, int i2) throws IOException {
        b bVar = this.k.get(Integer.valueOf(i2));
        l(fileOutputStream, i2);
        fileOutputStream.write(bVar.b, 0, bVar.a - 8);
    }

    public void o(InputStream inputStream, int i2) throws IOException {
        int i3 = this.n;
        for (int i4 = 0; i4 < this.f979f; i4++) {
            int[] iArr = this.f980g;
            int i5 = this.n;
            iArr[i4] = i5;
            if ((i5 - i3) + this.f981h[i4] > i2 - 8) {
                this.f982i[i4] = 0;
            } else {
                t(inputStream, i4);
            }
            int[] iArr2 = this.f982i;
            if (iArr2[i4] < this.o) {
                this.o = iArr2[i4];
            }
            if (iArr2[i4] > this.p) {
                this.p = iArr2[i4];
            }
            c.b bVar = this.a;
            if (bVar != null) {
                double d2 = this.n;
                Double.isNaN(d2);
                double d3 = this.j;
                Double.isNaN(d3);
                if (!bVar.reportProgress((d2 * 1.0d) / d3)) {
                    return;
                }
            }
        }
    }

    public final void p(InputStream inputStream, int i2) throws IOException {
        while (i2 > 8) {
            int i3 = this.n;
            byte[] bArr = new byte[8];
            if (inputStream.read(bArr, 0, 8) < 0) {
                throw new IOException("Could not read atomHeader");
            }
            int i4 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
            if (i4 > i2) {
                i4 = i2;
            }
            int i5 = (bArr[7] & ExifInterface.MARKER) | ((bArr[4] & ExifInterface.MARKER) << 24) | ((bArr[5] & ExifInterface.MARKER) << 16) | ((bArr[6] & ExifInterface.MARKER) << 8);
            b bVar = new b(this);
            bVar.a = i4;
            this.k.put(Integer.valueOf(i5), bVar);
            int i6 = this.n + 8;
            this.n = i6;
            if (i5 == 1836019574 || i5 == 1953653099 || i5 == 1835297121 || i5 == 1835626086 || i5 == 1937007212) {
                p(inputStream, i4);
            } else if (i5 == 1937011578) {
                r(inputStream, i4 - 8);
            } else if (i5 == 1937011827) {
                s(inputStream, i4 - 8);
            } else if (i5 == 1835295092) {
                this.q = i6;
                this.r = i4 - 8;
            } else {
                for (int i7 : t) {
                    if (i7 == i5) {
                        int i8 = i4 - 8;
                        byte[] bArr2 = new byte[i8];
                        if (inputStream.read(bArr2, 0, i8) < 0) {
                            throw new IOException("Could not read savedAtom");
                        }
                        this.n += i8;
                        this.k.get(Integer.valueOf(i5)).b = bArr2;
                    }
                }
            }
            if (i5 == 1937011556) {
                q();
            }
            i2 -= i4;
            int i9 = i4 - (this.n - i3);
            if (i9 < 0) {
                throw new IOException("Went over by " + (-i9) + " bytes");
            }
            if (inputStream.skip(i9) < 0) {
                throw new IOException("Could not skip result");
            }
            this.n += i9;
        }
    }

    public void q() {
        byte[] bArr = this.k.get(1937011556).b;
        byte b2 = bArr[32];
        byte b3 = bArr[33];
        this.l = (bArr[41] & ExifInterface.MARKER) | ((bArr[40] & ExifInterface.MARKER) << 8);
    }

    public void r(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) < 0) {
            throw new IOException("Could not read stszHeader");
        }
        this.n += 12;
        int i3 = (bArr[11] & 255) | ((bArr[8] & 255) << 24) | ((bArr[9] & 255) << 16) | ((bArr[10] & 255) << 8);
        this.f979f = i3;
        this.f980g = new int[i3];
        this.f981h = new int[i3];
        this.f982i = new int[i3];
        byte[] bArr2 = new byte[i3 * 4];
        if (inputStream.read(bArr2, 0, i3 * 4) < 0) {
            throw new IOException("Could not read frameLenBytes");
        }
        this.n += this.f979f * 4;
        for (int i4 = 0; i4 < this.f979f; i4++) {
            int i5 = i4 * 4;
            this.f981h[i4] = (bArr2[i5 + 3] & ExifInterface.MARKER) | ((bArr2[i5 + 0] & ExifInterface.MARKER) << 24) | ((bArr2[i5 + 1] & ExifInterface.MARKER) << 16) | ((bArr2[i5 + 2] & ExifInterface.MARKER) << 8);
        }
    }

    public void s(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[16];
        if (inputStream.read(bArr, 0, 16) < 0) {
            throw new IOException("Could not read sttsData");
        }
        this.n += 16;
        this.m = ((bArr[12] & ExifInterface.MARKER) << 24) | ((bArr[13] & ExifInterface.MARKER) << 16) | ((bArr[14] & ExifInterface.MARKER) << 8) | (bArr[15] & ExifInterface.MARKER);
    }

    public void t(InputStream inputStream, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f981h[i2] < 4) {
            this.f982i[i2] = 0;
            if (inputStream.skip(r2[i2]) < 0) {
                throw new IOException("Could not skip mFrameLens");
            }
            return;
        }
        int i7 = this.n;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr, 0, 4) < 0) {
            throw new IOException("Could not read stream");
        }
        this.n += 4;
        int i8 = (bArr[0] & 224) >> 5;
        if (i8 == 0) {
            this.f982i[i2] = ((bArr[1] & 254) >> 1) | ((bArr[0] & 1) << 7);
        } else if (i8 == 1) {
            if (((bArr[1] & 96) >> 5) == 2) {
                i3 = bArr[1] & 15;
                i4 = (bArr[2] & 254) >> 1;
                i5 = ((bArr[3] & 128) >> 7) | ((bArr[2] & 1) << 1);
                i6 = 25;
            } else {
                i3 = ((bArr[1] & 15) << 2) | ((bArr[2] & 192) >> 6);
                i4 = -1;
                i5 = (bArr[2] & 24) >> 3;
                i6 = 21;
            }
            if (i5 == 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < 7; i10++) {
                    if ((i4 & (1 << i10)) == 0) {
                        i9++;
                    }
                }
                i6 += i3 * (i9 + 1);
            }
            int i11 = ((i6 + 7) / 8) + 1;
            byte[] bArr2 = new byte[i11];
            bArr2[0] = bArr[0];
            bArr2[1] = bArr[1];
            bArr2[2] = bArr[2];
            bArr2[3] = bArr[3];
            int i12 = i11 - 4;
            if (inputStream.read(bArr2, 4, i12) < 0) {
                throw new IOException("Could not read stream");
            }
            this.n += i12;
            int i13 = 0;
            for (int i14 = 0; i14 < 8; i14++) {
                int i15 = i14 + i6;
                int i16 = i15 / 8;
                int i17 = 7 - (i15 % 8);
                i13 += ((bArr2[i16] & (1 << i17)) >> i17) << (7 - i14);
            }
            this.f982i[i2] = i13;
        } else if (i2 > 0) {
            int[] iArr = this.f982i;
            iArr[i2] = iArr[i2 - 1];
        } else {
            this.f982i[i2] = 0;
        }
        int i18 = this.f981h[i2] - (this.n - i7);
        if (inputStream.skip(i18) < 0) {
            throw new IOException("Could not skip stream");
        }
        this.n += i18;
    }
}
