package h.a.b.p;

import h.a.b.k;
import h.a.b.l;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1672f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBuffer f1674i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f1673h = new b();
    public boolean j = false;

    public class b extends k {
        public b() {
        }

        @Override // h.a.b.k
        public long getLength() {
            if (a.this.f1672f == -1) {
                return a.this.j ? a.this.f1674i.limit() : a.this.f1674i.position();
            }
            return a.this.f1672f;
        }

        @Override // h.a.b.k
        public void read(l lVar, ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < a.this.f1674i.remaining()) {
                byteBuffer.put(a.this.f1674i.array(), a.this.f1674i.position(), iRemaining);
                a.this.f1674i.position(a.this.f1674i.position() + iRemaining);
            } else {
                byteBuffer.put(a.this.f1674i);
            }
            lVar.a(false);
        }

        @Override // h.a.b.k
        public void rewind(l lVar) {
            a.this.f1674i.position(0);
            lVar.c();
        }
    }

    public a(d dVar, long j) {
        Objects.requireNonNull(dVar, "Argument connection cannot be null.");
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length < 0.");
        }
        int i2 = (int) j;
        this.f1672f = i2;
        this.f1674i = ByteBuffer.allocate(i2);
    }

    @Override // h.a.b.p.g
    public void c() throws IOException {
    }

    @Override // h.a.b.p.g
    public k d() {
        return this.f1673h;
    }

    @Override // h.a.b.p.g
    public void e() throws IOException {
        this.j = true;
        if (this.f1674i.position() < this.f1672f) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.f1674i.flip();
    }

    public final void j(int i2) throws IOException {
        if (this.f1672f != -1 && this.f1674i.position() + i2 > this.f1672f) {
            throw new ProtocolException("exceeded content-length limit of " + this.f1672f + " bytes");
        }
        if (this.j) {
            throw new IllegalStateException("Cannot write after being connected.");
        }
        if (this.f1672f == -1 && this.f1674i.limit() - this.f1674i.position() <= i2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.f1674i.capacity() * 2, this.f1674i.capacity() + i2));
            this.f1674i.flip();
            byteBufferAllocate.put(this.f1674i);
            this.f1674i = byteBufferAllocate;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        b();
        j(1);
        this.f1674i.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        b();
        j(i3);
        this.f1674i.put(bArr, i2, i3);
    }

    public a(d dVar) {
        Objects.requireNonNull(dVar);
        this.f1672f = -1;
        this.f1674i = ByteBuffer.allocate(16384);
    }
}
