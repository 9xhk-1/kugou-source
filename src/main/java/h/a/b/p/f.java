package h.a.b.p;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class f extends InputStream {
    public final d a;
    public boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f1687d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IOException f1688f;

    public f(d dVar) {
        this.a = dVar;
    }

    public final void a() throws IOException {
        if (this.b) {
            IOException iOException = this.f1688f;
            if (iOException != null) {
                throw iOException;
            }
        } else {
            if (b()) {
                return;
            }
            if (this.f1687d == null) {
                this.f1687d = ByteBuffer.allocateDirect(32768);
            }
            this.f1687d.clear();
            this.a.r(this.f1687d);
            IOException iOException2 = this.f1688f;
            if (iOException2 != null) {
                throw iOException2;
            }
            ByteBuffer byteBuffer = this.f1687d;
            if (byteBuffer != null) {
                byteBuffer.flip();
            }
        }
    }

    public final boolean b() {
        ByteBuffer byteBuffer = this.f1687d;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void c(IOException iOException) {
        this.f1688f = iOException;
        this.b = true;
        this.f1687d = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        a();
        if (b()) {
            return this.f1687d.get() & ExifInterface.MARKER;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        a();
        if (!b()) {
            return -1;
        }
        int iMin = Math.min(this.f1687d.limit() - this.f1687d.position(), i3);
        this.f1687d.get(bArr, i2, iMin);
        return iMin;
    }
}
