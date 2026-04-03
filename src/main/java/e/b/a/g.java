package e.b.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class g extends FilterOutputStream {
    public final f a;
    public byte[] b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f298d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f299f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f301i;
    public boolean j;

    public g(OutputStream outputStream, f fVar) throws IOException {
        this(outputStream, fVar, 512, true);
    }

    public int a(int i2) throws IOException {
        f fVar = this.a;
        byte[] bArr = this.b;
        fVar.e(bArr, 0, bArr.length);
        int iF = this.a.f(i2);
        if (iF == -5 ? this.a.c > 0 || i2 == 4 : !(iF == 0 || iF == 1)) {
            throw new IOException("failed to deflate");
        }
        int i3 = this.a.f356f;
        if (i3 > 0) {
            ((FilterOutputStream) this).out.write(this.b, 0, i3);
        }
        return iF;
    }

    public void b() throws IOException {
        while (!this.a.h()) {
            a(4);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f298d) {
            return;
        }
        b();
        if (this.f301i) {
            this.a.g();
        }
        if (this.j) {
            ((FilterOutputStream) this).out.close();
        }
        this.f298d = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int iA;
        if (this.f299f && !this.a.h()) {
            do {
                iA = a(2);
                if (this.a.f356f < this.b.length) {
                    break;
                }
            } while (iA != 1);
        }
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f300h;
        bArr[0] = (byte) (i2 & 255);
        write(bArr, 0, 1);
    }

    public g(OutputStream outputStream, f fVar, int i2, boolean z) throws IOException {
        super(outputStream);
        this.f298d = false;
        this.f299f = false;
        this.f300h = new byte[1];
        this.f301i = false;
        this.j = true;
        if (outputStream == null || fVar == null) {
            throw null;
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("buffer size must be greater than 0");
        }
        this.a = fVar;
        this.b = new byte[i2];
        this.j = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.a.h()) {
            throw new IOException("finished");
        }
        if (((i2 < 0) | (bArr.length <= i2)) || (i2 + i3 > bArr.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return;
        }
        int i4 = this.f299f ? 2 : 0;
        this.a.d(bArr, i2, i3, true);
        while (this.a.c > 0 && a(i4) != 1) {
        }
    }
}
