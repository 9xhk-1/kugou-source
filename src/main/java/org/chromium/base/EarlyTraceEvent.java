package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EarlyTraceEvent {
    public static final Object a = new Object();
    public static volatile int b;
    public static List<a> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, a> f1694d;

    public static final class a {
        public final String a;
        public final int b;
        public final long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f1695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1696e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1697f;

        @SuppressLint({"NewApi"})
        public static long a() {
            return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.elapsedRealtime() * 1000000;
        }

        public void b() {
            this.f1696e = a();
            this.f1697f = SystemClock.currentThreadTimeMillis();
        }
    }

    public static void a(List<a> list) {
        long jNativeGetTimeTicksNowUs = (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - a.a();
        for (a aVar : list) {
            nativeRecordEarlyEvent(aVar.a, aVar.c + jNativeGetTimeTicksNowUs, aVar.f1696e + jNativeGetTimeTicksNowUs, aVar.b, aVar.f1697f - aVar.f1695d);
        }
    }

    public static void b(String str) {
        if (c()) {
            synchronized (a) {
                if (c()) {
                    a aVarRemove = f1694d.remove(str);
                    if (aVarRemove == null) {
                        return;
                    }
                    aVarRemove.b();
                    c.add(aVarRemove);
                    if (b == 2) {
                        d();
                    }
                }
            }
        }
    }

    public static boolean c() {
        int i2 = b;
        return i2 == 1 || i2 == 2;
    }

    public static void d() {
        if (!c.isEmpty()) {
            a(c);
            c.clear();
        }
        if (f1694d.isEmpty()) {
            b = 3;
            f1694d = null;
            c = null;
        }
    }

    private static native void nativeRecordEarlyEvent(String str, long j, long j2, int i2, long j3);
}
