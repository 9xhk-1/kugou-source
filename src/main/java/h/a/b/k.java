package h.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract long getLength() throws IOException;

    public abstract void read(l lVar, ByteBuffer byteBuffer) throws IOException;

    public abstract void rewind(l lVar) throws IOException;
}
