package h.a.b.p;

import h.a.b.k;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends OutputStream {
    public IOException a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1689d;

    public void a() throws IOException {
        IOException iOException = this.a;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void b() throws IOException {
        if (this.f1689d) {
            a();
            throw new IOException("Writing after request completed.");
        }
        if (this.b) {
            throw new IOException("Stream has been closed.");
        }
    }

    public abstract void c() throws IOException;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b = true;
    }

    public abstract k d();

    public abstract void e() throws IOException;

    public void f(IOException iOException) {
        this.a = iOException;
        this.f1689d = true;
    }
}
