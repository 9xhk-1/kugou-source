package org.chromium.net.impl;

import android.annotation.SuppressLint;
import h.a.b.k;
import h.a.b.l;
import h.a.b.o.g;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CronetUploadDataStream extends l {
    public static final String m = "CronetUploadDataStream";
    public final Executor a;
    public final g b;
    public final CronetUrlRequest c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f1717g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f1718h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1719i = 0;
    public c j = c.NOT_IN_CALLBACK;
    public boolean k = false;
    public Runnable l;

    public class a implements Runnable {
        public final /* synthetic */ CronetUploadDataStream a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.f1718h) {
                if (this.a.f1719i == 0) {
                    return;
                }
                this.a.o(c.NOT_IN_CALLBACK);
                if (this.a.f1717g == null) {
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
                this.a.j = c.READ;
                try {
                    this.a.n();
                    g gVar = this.a.b;
                    CronetUploadDataStream cronetUploadDataStream = this.a;
                    gVar.read(cronetUploadDataStream, cronetUploadDataStream.f1717g);
                } catch (Exception e2) {
                    this.a.s(e2);
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetUploadDataStream.this.n();
                CronetUploadDataStream.this.b.close();
            } catch (Exception e2) {
                h.a.a.b.c(CronetUploadDataStream.m, "Exception thrown when closing", e2);
            }
        }
    }

    public enum c {
        READ,
        REWIND,
        GET_LENGTH,
        NOT_IN_CALLBACK
    }

    public CronetUploadDataStream(k kVar, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.a = executor;
        this.b = new g(kVar);
        this.c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    private static native void nativeDestroy(long j);

    private native void nativeOnReadSucceeded(long j, int i2, boolean z);

    private native void nativeOnRewindSucceeded(long j);

    @Override // h.a.b.l
    @SuppressLint({"DefaultLocale"})
    public void a(boolean z) {
        synchronized (this.f1718h) {
            o(c.READ);
            if (this.f1716f != this.f1717g.limit()) {
                throw new IllegalStateException("ByteBuffer limit changed");
            }
            if (z && this.f1714d >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int iPosition = this.f1717g.position();
            long j = this.f1715e - ((long) iPosition);
            this.f1715e = j;
            if (j < 0 && this.f1714d >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f1714d - this.f1715e), Long.valueOf(this.f1714d)));
            }
            this.f1717g.position(0);
            this.f1717g = null;
            this.j = c.NOT_IN_CALLBACK;
            q();
            long j2 = this.f1719i;
            if (j2 == 0) {
                return;
            }
            nativeOnReadSucceeded(j2, iPosition, z);
        }
    }

    @Override // h.a.b.l
    public void b(Exception exc) {
        synchronized (this.f1718h) {
            o(c.REWIND);
            s(exc);
        }
    }

    @Override // h.a.b.l
    public void c() {
        synchronized (this.f1718h) {
            o(c.REWIND);
            this.j = c.NOT_IN_CALLBACK;
            this.f1715e = this.f1714d;
            long j = this.f1719i;
            if (j == 0) {
                return;
            }
            nativeOnRewindSucceeded(j);
        }
    }

    public void m(long j) {
        synchronized (this.f1718h) {
            this.f1719i = nativeAttachUploadDataToRequest(j, this.f1714d);
        }
    }

    public final void n() {
        this.c.n();
    }

    public final void o(c cVar) {
        if (this.j == cVar) {
            return;
        }
        throw new IllegalStateException("Expected " + cVar + ", but was " + this.j);
    }

    public final void p() {
        synchronized (this.f1718h) {
            if (this.j == c.READ) {
                this.k = true;
                return;
            }
            long j = this.f1719i;
            if (j == 0) {
                return;
            }
            nativeDestroy(j);
            this.f1719i = 0L;
            Runnable runnable = this.l;
            if (runnable != null) {
                runnable.run();
            }
            t(new b());
        }
    }

    public final void q() {
        synchronized (this.f1718h) {
            if (this.j == c.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.k) {
                p();
            }
        }
    }

    public void r() {
        synchronized (this.f1718h) {
            this.j = c.GET_LENGTH;
        }
        try {
            this.c.n();
            long length = this.b.getLength();
            this.f1714d = length;
            this.f1715e = length;
        } catch (Throwable th) {
            s(th);
        }
        synchronized (this.f1718h) {
            this.j = c.NOT_IN_CALLBACK;
        }
    }

    public final void s(Throwable th) {
        boolean z;
        synchronized (this.f1718h) {
            c cVar = this.j;
            c cVar2 = c.NOT_IN_CALLBACK;
            if (cVar == cVar2) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            z = cVar == c.GET_LENGTH;
            this.j = cVar2;
            this.f1717g = null;
            q();
        }
        if (z) {
            try {
                this.b.close();
            } catch (Exception e2) {
                h.a.a.b.c(m, "Failure closing data provider", e2);
            }
        }
        this.c.t(th);
    }

    public void t(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (Throwable th) {
            this.c.t(th);
        }
    }
}
