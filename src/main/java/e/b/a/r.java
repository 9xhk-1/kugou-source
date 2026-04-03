package e.b.a;

import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class r extends FilterInputStream {
    public int a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f346d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f347f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f349i;
    public byte[] j;

    public r(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.b) {
            this.f347f.g();
        } else {
            this.f348h.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (read(this.f349i, 0, 1) == -1) {
            return -1;
        }
        return this.f349i[0] & ExifInterface.MARKER;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return read(new byte[j < ((long) 512) ? (int) j : 512]);
    }

    public r(InputStream inputStream, boolean z) throws IOException {
        super(inputStream);
        this.a = 0;
        this.f346d = null;
        this.f349i = new byte[1];
        this.j = new byte[512];
        this.f348h = new o(inputStream);
        this.b = false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int iF;
        if (this.b) {
            this.f347f.e(bArr, i2, i3);
            do {
                InputStream inputStream = this.f346d;
                byte[] bArr2 = this.j;
                int i4 = inputStream.read(bArr2, 0, bArr2.length);
                if (i4 != -1) {
                    this.f347f.d(this.j, 0, i4, true);
                    iF = this.f347f.f(this.a);
                    int i5 = this.f347f.f356f;
                    if (i5 <= 0) {
                        if (iF != 1) {
                            if (iF == -2) {
                                break;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return i5;
                    }
                } else {
                    return -1;
                }
            } while (iF != -3);
            throw new u("deflating: " + this.f347f.f359i);
        }
        return this.f348h.read(bArr, i2, i3);
    }
}
