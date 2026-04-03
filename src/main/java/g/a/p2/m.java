package g.a.p2;

import g.a.n2.r;
import g.a.n2.t;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final long a = t.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int b = t.d("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, null);
    public static final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f1645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static n f1646f;

    static {
        t.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int iD = t.d("kotlinx.coroutines.scheduler.core.pool.size", f.b0.f.b(r.a(), 2), 1, 0, 8, null);
        c = iD;
        f1644d = t.d("kotlinx.coroutines.scheduler.max.pool.size", f.b0.f.h(r.a() * 128, iD, 2097150), 0, 2097150, 4, null);
        f1645e = TimeUnit.SECONDS.toNanos(t.e("kotlinx.coroutines.scheduler.keep.alive.sec", 5L, 0L, 0L, 12, null));
        f1646f = g.a;
    }
}
