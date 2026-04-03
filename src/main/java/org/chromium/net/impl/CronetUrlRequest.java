package org.chromium.net.impl;

import com.kugou.framework.libcommon.netcore.BaseConnection;
import h.a.b.d;
import h.a.b.j;
import h.a.b.k;
import h.a.b.m;
import h.a.b.o.e;
import h.a.b.o.h;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CronetUrlRequest extends e {
    public final boolean a;
    public long b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1725f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CronetUrlRequestContext f1726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f1727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1728i;
    public final int j;
    public String k;
    public final b l;
    public final Collection<Object> m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final boolean r;
    public final int s;
    public CronetUploadDataStream t;
    public d u;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.t.r();
            synchronized (CronetUrlRequest.this.f1725f) {
                if (CronetUrlRequest.this.s()) {
                    return;
                }
                CronetUrlRequest.this.t.m(CronetUrlRequest.this.b);
                CronetUrlRequest.this.u();
            }
        }
    }

    public static final class b extends ArrayList<Map.Entry<String, String>> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, m.b bVar, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4) {
        ArrayList arrayList = new ArrayList();
        this.f1727h = arrayList;
        this.l = new b(null);
        Objects.requireNonNull(str, "URL is required");
        Objects.requireNonNull(bVar, "Listener is required");
        Objects.requireNonNull(executor, "Executor is required");
        this.a = z3;
        this.f1726g = cronetUrlRequestContext;
        this.f1728i = str;
        arrayList.add(str);
        this.j = p(i2);
        new h(bVar);
        this.m = collection;
        this.n = z;
        this.o = z2;
        this.p = z4;
        this.q = i3;
        this.r = z5;
        this.s = i4;
    }

    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    private native long nativeCreateRequestAdapter(long j, String str, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4);

    private native void nativeDestroy(long j, boolean z);

    private native void nativeFollowDeferredRedirect(long j);

    private native void nativeGetStatus(long j, VersionSafeCallbacks$UrlRequestStatusListener versionSafeCallbacks$UrlRequestStatusListener);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    private native boolean nativeSetHttpMethod(long j, String str);

    private native void nativeStart(long j);

    public static int p(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 4 ? 4 : 5;
        }
        return 3;
    }

    @Override // h.a.b.m
    public void a() {
        synchronized (this.f1725f) {
            if (!s() && this.c) {
                q(2);
            }
        }
    }

    @Override // h.a.b.m
    public void b() {
        synchronized (this.f1725f) {
            if (!this.f1723d) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.f1723d = false;
            if (s()) {
                return;
            }
            nativeFollowDeferredRedirect(this.b);
        }
    }

    @Override // h.a.b.m
    public boolean c() {
        boolean zS;
        synchronized (this.f1725f) {
            zS = s();
        }
        return zS;
    }

    @Override // h.a.b.m
    public void d(ByteBuffer byteBuffer) {
        h.a.b.o.d.b(byteBuffer);
        h.a.b.o.d.a(byteBuffer);
        synchronized (this.f1725f) {
            if (!this.f1724e) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.f1724e = false;
            if (s()) {
                return;
            }
            if (nativeReadData(this.b, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                return;
            }
            this.f1724e = true;
            throw new IllegalArgumentException("Unable to call native read");
        }
    }

    @Override // h.a.b.m
    public void e() {
        synchronized (this.f1725f) {
            o();
            try {
                this.b = nativeCreateRequestAdapter(this.f1726g.g(), this.f1728i, this.j, this.n, this.o, this.f1726g.h(), this.p, this.q, this.r, this.s);
                this.f1726g.l();
                String str = this.k;
                if (str != null && !nativeSetHttpMethod(this.b, str)) {
                    throw new IllegalArgumentException("Invalid http method " + this.k);
                }
                boolean z = false;
                for (Map.Entry<String, String> entry : this.l) {
                    if (entry.getKey().equalsIgnoreCase("Content-Type") && !entry.getValue().isEmpty()) {
                        z = true;
                    }
                    if (!nativeAddRequestHeader(this.b, entry.getKey(), entry.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + entry.getKey() + BaseConnection.HTTP_REQ_ENTITY_MERGE + entry.getValue());
                    }
                }
                CronetUploadDataStream cronetUploadDataStream = this.t;
                if (cronetUploadDataStream == null) {
                    this.c = true;
                    u();
                } else {
                    if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.c = true;
                    cronetUploadDataStream.t(new a());
                }
            } catch (RuntimeException e2) {
                q(1);
                throw e2;
            }
        }
    }

    @Override // h.a.b.o.e
    public void f(String str, String str2) {
        o();
        Objects.requireNonNull(str, "Invalid header name.");
        Objects.requireNonNull(str2, "Invalid header value.");
        this.l.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // h.a.b.o.e
    public void g(String str) {
        o();
        Objects.requireNonNull(str, "Method is required.");
        this.k = str;
    }

    @Override // h.a.b.o.e
    public void h(k kVar, Executor executor) {
        Objects.requireNonNull(kVar, "Invalid UploadDataProvider.");
        if (this.k == null) {
            this.k = "POST";
        }
        this.t = new CronetUploadDataStream(kVar, executor, this);
    }

    public void n() {
        if (!this.a && this.f1726g.j(Thread.currentThread())) {
            throw new j();
        }
    }

    public final void o() {
        synchronized (this.f1725f) {
            if (this.c || s()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    public final void q(int i2) {
        if (this.b == 0) {
            return;
        }
        this.f1726g.k();
        nativeDestroy(this.b, i2 == 2);
        this.b = 0L;
    }

    public final void r(d dVar) {
        synchronized (this.f1725f) {
            if (s()) {
                return;
            }
            this.u = dVar;
            q(1);
        }
    }

    public final boolean s() {
        return this.c && this.b == 0;
    }

    public void t(Throwable th) {
        h.a.b.o.a aVar = new h.a.b.o.a("Exception received from UploadDataProvider", th);
        h.a.a.b.c(CronetUrlRequestContext.f1729g, "Exception in upload method", th);
        r(aVar);
    }

    public final void u() {
        nativeStart(this.b);
    }
}
