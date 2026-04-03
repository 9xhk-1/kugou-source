package h.a.b.o;

import h.a.b.k;
import h.a.b.l;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends k {
    public final k a;

    public g(k kVar) {
        this.a = kVar;
    }

    @Override // h.a.b.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // h.a.b.k
    public long getLength() throws IOException {
        return this.a.getLength();
    }

    @Override // h.a.b.k
    public void read(l lVar, ByteBuffer byteBuffer) throws IOException {
        this.a.read(lVar, byteBuffer);
    }

    @Override // h.a.b.k
    public void rewind(l lVar) throws IOException {
        this.a.rewind(lVar);
    }
}
