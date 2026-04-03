package org.chromium.net.impl;

import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import h.a.b.m;
import h.a.b.o.b;
import h.a.b.o.e;
import h.a.b.p.d;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class CronetUrlRequestContext extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f1729g = "CronetUrlRequestContext";
    public final Object a;
    public final AtomicInteger b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread f1730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f1731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, Object> f1732f;

    static {
        new HashSet();
    }

    private static native void nativeAddPkp(long j, String str, byte[][] bArr, boolean z, long j2);

    private static native void nativeAddQuicHint(long j, String str, int i2, int i3);

    private native void nativeConfigureNetworkQualityEstimatorForTesting(long j, boolean z, boolean z2, boolean z3);

    private static native long nativeCreateRequestContextAdapter(long j);

    private static native long nativeCreateRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i2, long j, String str4, long j2, boolean z5, boolean z6, String str5);

    private native void nativeDestroy(long j);

    private native void nativeGetCertVerifierData(long j);

    private static native byte[] nativeGetHistogramDeltas();

    private native void nativeInitRequestContextOnInitThread(long j);

    private native void nativeProvideRTTObservations(long j, boolean z);

    private native void nativeProvideThroughputObservations(long j, boolean z);

    private static native int nativeSetMinLogLevel(int i2);

    private native void nativeStartNetLogToDisk(long j, String str, boolean z, int i2);

    private native boolean nativeStartNetLogToFile(long j, String str, boolean z);

    private native void nativeStopNetLog(long j);

    @Override // h.a.b.c
    public URLConnection b(URL url) {
        return c(url, Proxy.NO_PROXY);
    }

    @Override // h.a.b.g
    public URLConnection c(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        if ("http".equals(protocol) || AckProtocolTypeUtil.HTTPS_LABEL.equals(protocol)) {
            return new d(url, this);
        }
        throw new UnsupportedOperationException("Unexpected protocol:" + protocol);
    }

    @Override // h.a.b.o.b
    public e d(String str, m.b bVar, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4) throws Throwable {
        synchronized (this.a) {
            try {
                try {
                    f();
                    return new CronetUrlRequest(this, str, i2, bVar, executor, collection, z, z2, z3, z4, i3, z5, i4);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void f() throws IllegalStateException {
        if (!i()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    public long g() {
        long j;
        synchronized (this.a) {
            f();
            j = this.c;
        }
        return j;
    }

    public boolean h() {
        boolean z;
        synchronized (this.f1731e) {
            z = !this.f1732f.isEmpty();
        }
        return z;
    }

    public final boolean i() {
        return this.c != 0;
    }

    public boolean j(Thread thread) {
        return thread == this.f1730d;
    }

    public void k() {
        this.b.decrementAndGet();
    }

    public void l() {
        this.b.incrementAndGet();
    }
}
