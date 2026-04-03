package org.chromium.net;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyChangeListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f1710e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ProxyChangeListener f1711f;
    public final Looper a;
    public b b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1712d;

    public interface a {
        void proxySettingsChanged();
    }

    public static class b {
        public final String a;
        public final int b;
        public final String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f1713d;

        public b(String str, int i2, String str2, String[] strArr) {
            this.a = str;
            this.b = i2;
            this.c = str2;
            this.f1713d = strArr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) || this.b == bVar.b;
        }
    }

    public ProxyChangeListener() {
        Looper looperMyLooper = Looper.myLooper();
        this.a = looperMyLooper;
        new Handler(looperMyLooper);
    }

    @Nullable
    public static ProxyChangeListener a() {
        return f1711f;
    }

    private native void nativeProxySettingsChanged(long j);

    private native void nativeProxySettingsChangedTo(long j, String str, int i2, String str2, String[] strArr);

    public final void b(b bVar) {
        if (f1710e) {
            a aVar = this.f1712d;
            if (aVar != null) {
                aVar.proxySettingsChanged();
            }
            long j = this.c;
            if (j == 0) {
                return;
            }
            if (bVar != null) {
                b bVar2 = this.b;
                if (bVar2 != null && bVar2.equals(bVar)) {
                    return;
                } else {
                    nativeProxySettingsChangedTo(this.c, bVar.a, bVar.b, bVar.c, bVar.f1713d);
                }
            } else {
                nativeProxySettingsChanged(j);
            }
            this.b = bVar;
        }
    }

    public void c(b bVar) {
        b(bVar);
    }
}
