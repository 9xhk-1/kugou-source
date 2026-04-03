package com.tencent.tmachine.trace.provider.stacktrace;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tencent.tmachine.trace.core.ErrorExtra;
import com.tencent.tmachine.trace.core.IProviderListener;
import com.tencent.tmachine.trace.provider.Provider;
import f.z.d.g;
import f.z.d.j;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class StackTracer extends Provider {
    public static final int ERROR_NOT_SUPPORT_ANDROID_VERSION = -100;
    public static final int ERROR_THREAD_IS_NOT_ALIVE = -99;
    private final ConcurrentHashMap<Thread, ThreadTracer> tracerMap;
    public static final Companion Companion = new Companion(null);
    private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void prepare$default(Companion companion, Context context, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                context = null;
            }
            companion.prepare(context);
        }

        public final void prepare(Context context) {
            if (context != null) {
                try {
                    StackTracer stackTracer = new StackTracer(null, 1, 0 == true ? 1 : 0);
                    String packageName = context.getPackageName();
                    j.b(packageName, "ctx.packageName");
                    stackTracer.prepare(packageName);
                } catch (Throwable unused) {
                }
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public StackTracer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public StackTracer(ISoLoader iSoLoader) {
        if (isSoLoaded.compareAndSet(false, true)) {
            (iSoLoader == null ? new DefaultSoSystemLoader() : iSoLoader).loadLibrary("tmachine");
        }
        this.tracerMap = new ConcurrentHashMap<>();
    }

    public static /* synthetic */ boolean dump$default(StackTracer stackTracer, Thread thread, long j, long j2, String str, boolean z, boolean z2, int i2, Object obj) {
        return stackTracer.dump(thread, j, j2, str, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? true : z2);
    }

    private final native boolean nativeDestroy();

    private final native boolean nativeDisable();

    private final native boolean nativeEnable();

    private final native boolean nativeInitialize();

    private final native boolean nativeTryTraceOnce(long j);

    public static final void prepare(Context context) {
        Companion.prepare(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void prepare(String str);

    @Override // com.tencent.tmachine.trace.provider.Provider, com.tencent.tmachine.trace.provider.IProvider
    public boolean destroy() {
        return ((getProviderStatus() == 1 || getProviderStatus() == 2 || getProviderStatus() == 4) && nativeDestroy()) ? super.destroy() : getProviderStatus() == 0 || getProviderStatus() == 8;
    }

    @Override // com.tencent.tmachine.trace.provider.Provider, com.tencent.tmachine.trace.provider.IProvider
    public boolean disable() {
        return (getProviderStatus() == 2 && nativeDisable()) ? super.disable() : getProviderStatus() == 0 || getProviderStatus() == 4 || getProviderStatus() == 8;
    }

    public final boolean dump(Thread thread, long j, long j2, String str) {
        return dump$default(this, thread, j, j2, str, false, false, 48, null);
    }

    public final boolean dump(Thread thread, long j, long j2, String str, boolean z) {
        return dump$default(this, thread, j, j2, str, z, false, 32, null);
    }

    public final boolean dump(Thread thread, long j, long j2, String str, boolean z, boolean z2) {
        ThreadTracer threadTracer;
        j.f(thread, "thread");
        j.f(str, "outputPath");
        if ((getProviderStatus() == 1 || getProviderStatus() == 2 || getProviderStatus() == 4) && (threadTracer = this.tracerMap.get(thread)) != null) {
            return threadTracer.dump(j, j2, str, z, z2);
        }
        return false;
    }

    @Override // com.tencent.tmachine.trace.provider.Provider, com.tencent.tmachine.trace.provider.IProvider
    public boolean enable() {
        return ((getProviderStatus() == 1 || getProviderStatus() == 4) && nativeEnable()) ? super.enable() : getProviderStatus() == 2;
    }

    @Override // com.tencent.tmachine.trace.provider.Provider, com.tencent.tmachine.trace.provider.IProvider
    public void error(ErrorExtra errorExtra) {
        super.error(errorExtra);
    }

    @Override // com.tencent.tmachine.trace.provider.Provider, com.tencent.tmachine.trace.provider.IProvider
    public boolean init(IProviderListener iProviderListener) {
        j.f(iProviderListener, "providerListener");
        if (getProviderStatus() == 0 || getProviderStatus() == 8) {
            setProviderListener(iProviderListener);
            try {
                if (Build.VERSION.SDK_INT < 23 || !Process.is64Bit()) {
                    error(new ErrorExtra(-100, "not support android version or runtime"));
                    return false;
                }
                if (nativeInitialize()) {
                    return super.init(iProviderListener);
                }
            } catch (Throwable th) {
                error(new ErrorExtra(-100, "not support android version or runtime, err=" + th.getMessage()));
                return false;
            }
        }
        return getProviderStatus() == 1 || getProviderStatus() == 2 || getProviderStatus() == 4;
    }

    public final boolean startTracing(Thread thread, long j, long j2, IThreadTracerListener iThreadTracerListener, boolean z, boolean z2) {
        j.f(thread, "thread");
        j.f(iThreadTracerListener, "listener");
        if (getProviderStatus() != 2) {
            return false;
        }
        ThreadTracer threadTracer = this.tracerMap.get(thread);
        if (threadTracer != null) {
            return threadTracer.startTracing();
        }
        ThreadTracer threadTracer2 = new ThreadTracer(thread, j, j2, iThreadTracerListener, z, z2);
        this.tracerMap.put(thread, threadTracer2);
        return threadTracer2.startTracing();
    }

    public final boolean stopTracing(Thread thread) {
        ThreadTracer threadTracer;
        j.f(thread, "thread");
        if (getProviderStatus() != 2 || (threadTracer = this.tracerMap.get(thread)) == null) {
            return false;
        }
        boolean zStopTracing = threadTracer.stopTracing();
        this.tracerMap.remove(thread);
        return zStopTracing;
    }

    public final int threadTraceNum() {
        return this.tracerMap.size();
    }

    public final boolean tryTraceOnce(Thread thread) throws NoSuchFieldException {
        j.f(thread, "thread");
        if (j.a(thread, Thread.currentThread()) || getProviderStatus() == 0 || getProviderStatus() == 8) {
            return false;
        }
        Field declaredField = Thread.class.getDeclaredField("nativePeer");
        j.b(declaredField, "field");
        declaredField.setAccessible(true);
        return nativeTryTraceOnce(declaredField.getLong(thread));
    }

    public /* synthetic */ StackTracer(ISoLoader iSoLoader, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : iSoLoader);
    }
}
