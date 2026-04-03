package h.a.b.p;

import h.a.b.k;
import h.a.b.l;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f1675f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ByteBuffer f1676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f1677i = new C0279b();
    public boolean j = false;

    /* JADX INFO: renamed from: h.a.b.p.b$b, reason: collision with other inner class name */
    public class C0279b extends k {
        public C0279b() {
        }

        @Override // h.a.b.k
        public long getLength() {
            return -1L;
        }

        @Override // h.a.b.k
        public void read(l lVar, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() < b.this.f1676h.remaining()) {
                int iLimit = b.this.f1676h.limit();
                b.this.f1676h.limit(b.this.f1676h.position() + byteBuffer.remaining());
                byteBuffer.put(b.this.f1676h);
                b.this.f1676h.limit(iLimit);
                lVar.a(false);
                return;
            }
            byteBuffer.put(b.this.f1676h);
            b.this.f1676h.clear();
            lVar.a(b.this.j);
            if (b.this.j) {
                return;
            }
            b.this.f1675f.c();
        }

        @Override // h.a.b.k
        public void rewind(l lVar) {
            lVar.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    public b(d dVar, int i2, i iVar) {
        Objects.requireNonNull(dVar);
        if (i2 <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.f1676h = ByteBuffer.allocate(i2);
        this.f1675f = iVar;
    }

    @Override // h.a.b.p.g
    public void c() throws IOException {
    }

    @Override // h.a.b.p.g, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.j) {
            return;
        }
        this.j = true;
        this.f1676h.flip();
    }

    @Override // h.a.b.p.g
    public k d() {
        return this.f1677i;
    }

    @Override // h.a.b.p.g
    public void e() throws IOException {
    }

    public final void j() throws IOException {
        if (this.f1676h.hasRemaining()) {
            return;
        }
        k();
    }

    public final void k() throws IOException {
        b();
        this.f1676h.flip();
        this.f1675f.a();
        a();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        j();
        this.f1676h.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        b();
        if (bArr.length - i2 < i3 || i2 < 0 || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(i4, this.f1676h.remaining());
            this.f1676h.put(bArr, (i2 + i3) - i4, iMin);
            i4 -= iMin;
            j();
        }
    }
}
