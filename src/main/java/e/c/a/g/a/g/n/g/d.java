package e.c.a.g.a.g.n.g;

import androidx.exifinterface.media.ExifInterface;
import e.c.a.g.a.g.n.g.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f992i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public class a implements c.a {
        @Override // e.c.a.g.a.g.n.g.c.a
        public c create() {
            return new d();
        }

        @Override // e.c.a.g.a.g.n.g.c.a
        public String[] getSupportedExtensions() {
            return new String[]{"wav"};
        }
    }

    public static c.a k() {
        return new a();
    }

    @Override // e.c.a.g.a.g.n.g.c
    public void a(File file) throws IOException {
        int i2;
        byte[] bArr;
        super.a(file);
        int length = (int) this.b.length();
        this.k = length;
        if (length < 128) {
            throw new IOException("File too small to parse");
        }
        FileInputStream fileInputStream = new FileInputStream(this.b);
        byte[] bArr2 = new byte[12];
        if (fileInputStream.read(bArr2, 0, 12) < 0) {
            throw new IOException("Can not read header ");
        }
        this.n += 12;
        if (bArr2[0] == 82) {
            int i3 = 1;
            if (bArr2[1] == 73 && bArr2[2] == 70 && bArr2[3] == 70 && bArr2[8] == 87 && bArr2[9] == 65 && bArr2[10] == 86 && bArr2[11] == 69) {
                this.m = 0;
                this.l = 0;
                while (this.n + 8 <= this.k) {
                    byte[] bArr3 = new byte[8];
                    if (fileInputStream.read(bArr3, 0, 8) < 0) {
                        throw new IOException("Can not read chunkHeader ");
                    }
                    this.n += 8;
                    int i4 = ((bArr3[7] & 255) << 24) | ((bArr3[6] & 255) << 16) | ((bArr3[5] & 255) << 8) | (bArr3[4] & 255);
                    if (bArr3[0] == 102 && bArr3[i3] == 109 && bArr3[2] == 116 && bArr3[3] == 32) {
                        if (i4 < 16 || i4 > 1024) {
                            throw new IOException("WAV file has bad fmt chunk");
                        }
                        byte[] bArr4 = new byte[i4];
                        if (fileInputStream.read(bArr4, 0, i4) < 0) {
                            throw new IOException("Can not read chunkLen ");
                        }
                        this.n += i4;
                        int i5 = ((bArr4[i3] & ExifInterface.MARKER) << 8) | (bArr4[0] & ExifInterface.MARKER);
                        this.m = ((bArr4[3] & ExifInterface.MARKER) << 8) | (bArr4[2] & ExifInterface.MARKER);
                        this.l = (bArr4[4] & ExifInterface.MARKER) | ((bArr4[7] & ExifInterface.MARKER) << 24) | ((bArr4[6] & ExifInterface.MARKER) << 16) | ((bArr4[5] & ExifInterface.MARKER) << 8);
                        if (i5 != i3) {
                            throw new IOException("Unsupported WAV file encoding");
                        }
                    } else if (bArr3[0] == 100 && bArr3[i3] == 97 && bArr3[2] == 116 && bArr3[3] == 97) {
                        int i6 = this.m;
                        if (i6 == 0 || (i2 = this.l) == 0) {
                            throw new IOException("Bad WAV file: data chunk before fmt chunk");
                        }
                        int i7 = ((i2 * i6) / 50) * 2;
                        this.j = i7;
                        int i8 = ((i7 - 1) + i4) / i7;
                        this.f989f = i8;
                        this.f990g = new int[i8];
                        this.f991h = new int[i8];
                        this.f992i = new int[i8];
                        byte[] bArr5 = new byte[i7];
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < i4) {
                            int i11 = this.j;
                            if (i9 + i11 > i4) {
                                i9 = i4 - i11;
                            }
                            if (fileInputStream.read(bArr5, 0, i11) < 0) {
                                throw new IOException("Can not read oneFrame ");
                            }
                            int i12 = 1;
                            int i13 = 0;
                            while (i12 < i11) {
                                int iAbs = Math.abs((int) bArr5[i12]);
                                if (iAbs > i13) {
                                    i13 = iAbs;
                                }
                                i12 += this.m * 4;
                            }
                            int[] iArr = this.f990g;
                            int i14 = this.n;
                            iArr[i10] = i14;
                            this.f991h[i10] = i11;
                            this.f992i[i10] = i13;
                            i10 += i3;
                            this.n = i14 + i11;
                            i9 += i11;
                            c.b bVar = this.a;
                            if (bVar != null) {
                                double d2 = i9;
                                Double.isNaN(d2);
                                bArr = bArr5;
                                double d3 = i4;
                                Double.isNaN(d3);
                                if (!bVar.reportProgress((d2 * 1.0d) / d3)) {
                                    break;
                                }
                            } else {
                                bArr = bArr5;
                            }
                            bArr5 = bArr;
                            i3 = 1;
                        }
                    } else {
                        if (fileInputStream.skip(i4) < 0) {
                            throw new IOException("Can not skip chunkLen ");
                        }
                        this.n += i4;
                    }
                    i3 = 1;
                }
                return;
            }
        }
        throw new IOException("Not a WAV file");
    }

    @Override // e.c.a.g.a.g.n.g.c
    public void b(File file, int i2, int i3) throws IOException {
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(this.b);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long j = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j += (long) this.f991h[i2 + i4];
        }
        long j2 = 36 + j;
        int i5 = this.l;
        long j3 = i5;
        int i6 = this.m;
        long j4 = i5 * 2 * i6;
        long j5 = j;
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i6, 0, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), (byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255), (byte) (i6 * 2), 0, 16, 0, 100, 97, 116, 97, (byte) (j5 & 255), (byte) ((j5 >> 8) & 255), (byte) ((j5 >> 16) & 255), (byte) ((j5 >> 24) & 255)}, 0, 44);
        byte[] bArr = new byte[this.j];
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i2 + i8;
            int i10 = this.f990g[i9] - i7;
            int i11 = this.f991h[i9];
            if (i10 >= 0) {
                if (i10 > 0) {
                    if (fileInputStream.skip(i10) < 0) {
                        throw new IOException("Can not skip skip ");
                    }
                    i7 += i10;
                }
                if (fileInputStream.read(bArr, 0, i11) < 0) {
                    throw new IOException("Can not read buffer ");
                }
                fileOutputStream.write(bArr, 0, i11);
                i7 += i11;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int[] d() {
        return this.f991h;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int f() {
        return this.f989f;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int g() {
        return this.l;
    }

    @Override // e.c.a.g.a.g.n.g.c
    public int h() {
        return this.l / 50;
    }
}
