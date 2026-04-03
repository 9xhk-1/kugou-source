package com.tencent.tmachine.trace.provider.stacktrace;

import android.os.Looper;
import com.tencent.tmachine.trace.core.ErrorExtra;
import f.z.d.g;
import f.z.d.j;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class ThreadTracer {
    public static final Companion Companion = new Companion(null);
    private static final String FILTER_SYSTEM_METHOD1 = "nSyncAndDrawFrame";
    private static final String FILTER_SYSTEM_METHOD2 = "nativePollOnce";
    private final boolean enableFullStackCollect;
    private final ThreadTracer$innerListener$1 innerListener;
    private final boolean isMainThread;
    private final IThreadTracerListener listener;
    private long nativePeer;
    private final Thread thread;
    private final long traceDurationMillis;
    private final long traceIntervalMillis;
    private final boolean withLockTrace;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public ThreadTracer(Thread thread, long j, long j2, IThreadTracerListener iThreadTracerListener, boolean z, boolean z2) throws NoSuchFieldException {
        j.f(thread, "thread");
        j.f(iThreadTracerListener, "listener");
        this.thread = thread;
        this.traceIntervalMillis = j;
        this.traceDurationMillis = j2;
        this.listener = iThreadTracerListener;
        this.withLockTrace = z;
        this.enableFullStackCollect = z2;
        Looper mainLooper = Looper.getMainLooper();
        j.b(mainLooper, "Looper.getMainLooper()");
        this.isMainThread = j.a(mainLooper.getThread(), thread);
        this.innerListener = new ThreadTracer$innerListener$1(this);
        Field declaredField = Thread.class.getDeclaredField("nativePeer");
        j.b(declaredField, "field");
        declaredField.setAccessible(true);
        this.nativePeer = declaredField.getLong(thread);
    }

    private final native boolean nativeDumpTrace(String str, boolean z, Thread thread, long j, long j2, String str2, boolean z2, boolean z3);

    private final native boolean nativeStartTracing(String str, boolean z, Thread thread, long j, long j2, long j3, IThreadTracerListener iThreadTracerListener, boolean z2, boolean z3);

    private final native boolean nativeStopTracing(String str, boolean z, Thread thread);

    public final boolean dump(long j, long j2, String str, boolean z, boolean z2) {
        j.f(str, "outputPath");
        return nativeDumpTrace(String.valueOf(hashCode()), this.isMainThread, this.thread, j, j2, str, z, z2);
    }

    public final Thread getThread() {
        return this.thread;
    }

    public final boolean isMainThread() {
        return this.isMainThread;
    }

    public final boolean startTracing() {
        if (!this.thread.isAlive()) {
            this.innerListener.onError(this, new ErrorExtra(-99, "thread is not alive"));
            return false;
        }
        boolean zNativeStartTracing = nativeStartTracing(String.valueOf(hashCode()), this.isMainThread, this.thread, this.nativePeer, this.traceIntervalMillis, this.traceDurationMillis, this.innerListener, this.withLockTrace, this.enableFullStackCollect);
        if (zNativeStartTracing) {
            this.innerListener.onStart(this);
        }
        return zNativeStartTracing;
    }

    public final boolean stopTracing() {
        boolean zNativeStopTracing = nativeStopTracing(String.valueOf(hashCode()), this.isMainThread, this.thread);
        if (zNativeStopTracing) {
            this.innerListener.onStop(this);
        }
        return zNativeStopTracing;
    }
}
