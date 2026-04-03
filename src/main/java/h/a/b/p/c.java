package h.a.b.p;

import h.a.b.k;
import h.a.b.l;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends g {
    public static int l = 16384;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f1678f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ByteBuffer f1680i;
    public final k j = new b();
    public long k;

    public class b extends k {
        public b() {
        }

        @Override // h.a.b.k
        public long getLength() {
            return c.this.f1679h;
        }

        @Override // h.a.b.k
        public void read(l lVar, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.f1680i.remaining()) {
                byteBuffer.put(c.this.f1680i);
                c.this.f1680i.clear();
                lVar.a(false);
                c.this.f1678f.c();
                return;
            }
            int iLimit = c.this.f1680i.limit();
            c.this.f1680i.limit(c.this.f1680i.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.f1680i);
            c.this.f1680i.limit(iLimit);
            lVar.a(false);
        }

        @Override // h.a.b.k
        public void rewind(l lVar) {
            lVar.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    public c(d dVar, long j, i iVar) {
        Objects.requireNonNull(dVar);
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.f1679h = j;
        this.f1680i = ByteBuffer.allocate((int) Math.min(j, l));
        this.f1678f = iVar;
        this.k = 0L;
    }

    @Override // h.a.b.p.g
    public void c() throws IOException {
        if (this.k < this.f1679h) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // h.a.b.p.g
    public k d() {
        return this.j;
    }

    @Override // h.a.b.p.g
    public void e() throws IOException {
    }

    public final void j(int i2) throws ProtocolException {
        if (this.k + ((long) i2) <= this.f1679h) {
            return;
        }
        throw new ProtocolException("expected " + (this.f1679h - this.k) + " bytes but received " + i2);
    }

    public final void k() throws IOException {
        if (this.f1680i.hasRemaining()) {
            return;
        }
        l();
    }

    public final void l() throws IOException {
        b();
        this.f1680i.flip();
        this.f1678f.a();
        a();
    }

    public final void m() throws IOException {
        if (this.k == this.f1679h) {
            l();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        b();
        j(1);
        k();
        this.f1680i.put((byte) i2);
        this.k++;
        m();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        b();
        if (bArr.length - i2 >= i3 && i2 >= 0 && i3 >= 0) {
            j(i3);
            int i4 = i3;
            while (i4 > 0) {
                k();
                int iMin = Math.min(i4, this.f1680i.remaining());
                this.f1680i.put(bArr, (i2 + i3) - i4, iMin);
                i4 -= iMin;
            }
            this.k += (long) i3;
            m();
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
