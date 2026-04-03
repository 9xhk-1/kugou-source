package e.b.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class s extends FilterOutputStream {
    public int a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f350d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f351f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OutputStream f352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f353i;
    public g j;
    public n k;
    public byte[] l;

    public s(OutputStream outputStream, int i2) throws IOException {
        this(outputStream, i2, false);
    }

    public synchronized void a() {
        if (this.f353i) {
            return;
        }
        if (this.f351f) {
            try {
                this.j.b();
            } catch (Exception unused) {
            }
        } else {
            this.k.f();
        }
        this.f353i = true;
    }

    public void b() throws IOException {
        if (this.f351f) {
            write("".getBytes(), 0, 0);
        } else {
            this.j.b();
        }
        flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            b();
        } catch (IOException unused) {
        } catch (Throwable th) {
            a();
            this.f352h.close();
            this.f352h = null;
            throw th;
        }
        a();
        this.f352h.close();
        this.f352h = null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f352h.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.l;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }

    public s(OutputStream outputStream, int i2, boolean z) throws IOException {
        super(outputStream);
        this.a = 512;
        this.b = 0;
        this.f350d = new byte[512];
        this.f353i = false;
        this.l = new byte[1];
        this.f352h = outputStream;
        this.j = new g(outputStream, new f(i2, z));
        this.f351f = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return;
        }
        if (this.f351f) {
            this.j.write(bArr, i2, i3);
            return;
        }
        this.k.d(bArr, i2, i3, true);
        int iG = 0;
        do {
            n nVar = this.k;
            if (nVar.c <= 0) {
                break;
            }
            byte[] bArr2 = this.f350d;
            nVar.e(bArr2, 0, bArr2.length);
            iG = this.k.g(this.b);
            int i4 = this.k.f356f;
            if (i4 > 0) {
                this.f352h.write(this.f350d, 0, i4);
            }
        } while (iG == 0);
        if (iG == 0) {
            return;
        }
        throw new u("inflating: " + this.k.f359i);
    }
}
