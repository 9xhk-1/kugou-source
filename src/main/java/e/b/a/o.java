package e.b.a;

import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class o extends FilterInputStream {
    public final n a;
    public byte[] b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f330d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f331f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f333i;
    public byte[] j;
    public byte[] k;

    public o(InputStream inputStream) throws IOException {
        this(inputStream, new n());
        this.f333i = true;
    }

    public void a() throws IOException {
        if (this.f330d) {
            throw new IOException("Stream closed");
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.b;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 != -1) {
            this.a.d(this.b, 0, i2, true);
        } else {
            if (this.a.k.c == -1) {
                throw new EOFException("Unexpected end of ZLIB input stream");
            }
            throw new IOException("footer is not found");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (this.f330d) {
            throw new IOException("Stream closed");
        }
        return this.f331f ? 0 : 1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f330d) {
            return;
        }
        if (this.f333i) {
            this.a.f();
        }
        if (this.f332h) {
            ((FilterInputStream) this).in.close();
        }
        this.f330d = true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f330d) {
            throw new IOException("Stream closed");
        }
        if (read(this.j, 0, 1) == -1) {
            return -1;
        }
        return this.j[0] & ExifInterface.MARKER;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        if (this.f330d) {
            throw new IOException("Stream closed");
        }
        int iMin = (int) Math.min(j, 2147483647L);
        int i2 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            int length = iMin - i2;
            byte[] bArr = this.k;
            if (length > bArr.length) {
                length = bArr.length;
            }
            int i3 = read(bArr, 0, length);
            if (i3 == -1) {
                this.f331f = true;
                break;
            }
            i2 += i3;
        }
        return i2;
    }

    public o(InputStream inputStream, n nVar) throws IOException {
        this(inputStream, nVar, 512);
    }

    public o(InputStream inputStream, n nVar, int i2) throws IOException {
        this(inputStream, nVar, i2, true);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f330d) {
            Objects.requireNonNull(bArr);
            if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            if (this.f331f) {
                return -1;
            }
            this.a.e(bArr, i2, i3);
            int i4 = 0;
            while (!this.f331f) {
                if (this.a.c == 0) {
                    a();
                }
                int iG = this.a.g(0);
                n nVar = this.a;
                int i5 = nVar.f356f;
                i4 += i5 - i2;
                if (iG != -3) {
                    if (iG == 1 || iG == 2) {
                        this.f331f = true;
                        if (iG == 2) {
                            return -1;
                        }
                    }
                    if (nVar.f357g == 0) {
                        break;
                    }
                    i2 = i5;
                } else {
                    throw new IOException(this.a.f359i);
                }
            }
            return i4;
        }
        throw new IOException("Stream closed");
    }

    public o(InputStream inputStream, n nVar, int i2, boolean z) throws IOException {
        super(inputStream);
        this.f330d = false;
        this.f331f = false;
        this.f332h = true;
        this.f333i = false;
        this.j = new byte[1];
        this.k = new byte[512];
        if (inputStream == null || nVar == null) {
            throw null;
        }
        if (i2 > 0) {
            this.a = nVar;
            this.b = new byte[i2];
            this.f332h = z;
            return;
        }
        throw new IllegalArgumentException("buffer size must be greater than 0");
    }
}
