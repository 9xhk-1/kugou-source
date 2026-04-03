package com.tencent.tmachine.trace.provider.stacktrace;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmachine.trace.core.ErrorExtra;
import com.tencent.tmachine.trace.core.IProviderListener;
import com.tencent.tmachine.trace.provider.Provider;
import com.tencent.tmachine.trace.util.TMachineLog;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class StackTraceMonitor implements IProviderListener, IThreadTracerListener {
    private static final int MAX_STACK_SIZE = 5;
    private static final String TAG = "StackTraceMonitor";
    private static boolean isInitialized;
    private static StackTracer stackTracer;
    public static final StackTraceMonitor INSTANCE = new StackTraceMonitor();
    private static StackTraceConfig stackTraceConfig = new StackTraceConfig();
    private static Map<String, ArrayList<StackLink>> stackTraceMap = Collections.synchronizedMap(new LinkedHashMap());

    private StackTraceMonitor() {
    }

    public static /* synthetic */ boolean dumpStackTracing$default(StackTraceMonitor stackTraceMonitor, Thread thread, String str, long j, long j2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = -1;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            j2 = stackTraceConfig.getConsumeThreshold();
        }
        return stackTraceMonitor.dumpStackTracing(thread, str, j3, j2);
    }

    public static /* synthetic */ boolean init$default(StackTraceMonitor stackTraceMonitor, StackTraceConfig stackTraceConfig2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            stackTraceConfig2 = null;
        }
        return stackTraceMonitor.init(stackTraceConfig2);
    }

    public final synchronized boolean destroy() {
        boolean z = true;
        if (!isInitialized()) {
            return true;
        }
        TMachineLog.i(TAG, "destroy stack trace monitor", new Object[0]);
        StackTracer stackTracer2 = stackTracer;
        if (stackTracer2 != null) {
            stackTracer2.disable();
        }
        StackTracer stackTracer3 = stackTracer;
        if (stackTracer3 == null || !stackTracer3.destroy()) {
            z = false;
        } else {
            stackTracer = null;
            isInitialized = false;
        }
        return z;
    }

    public final boolean dumpStackTracing(Thread thread, String str) {
        return dumpStackTracing$default(this, thread, str, 0L, 0L, 12, null);
    }

    public final boolean dumpStackTracing(Thread thread, String str, long j) {
        return dumpStackTracing$default(this, thread, str, j, 0L, 8, null);
    }

    public final synchronized boolean dumpStackTracing(Thread thread, String str, long j, long j2) {
        j.f(thread, "thread");
        j.f(str, "savePath");
        if (!isInitialized()) {
            return false;
        }
        StackTracer stackTracer2 = stackTracer;
        return stackTracer2 != null ? stackTracer2.dump(thread, j, j2, str, true, stackTraceConfig.isWithSignature()) : false;
    }

    public final ArrayList<StackLink> getStackLinkList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return stackTraceMap.get(str);
    }

    public final synchronized StackTraceConfig getStackTraceConfig() {
        return stackTraceConfig;
    }

    public final boolean init() {
        return init$default(this, null, 1, null);
    }

    public final synchronized boolean init(StackTraceConfig stackTraceConfig2) {
        if (isInitialized()) {
            return true;
        }
        TMachineLog.i(TAG, "init stack trace monitor, config=" + stackTraceConfig2, new Object[0]);
        if (stackTraceConfig2 == null) {
            stackTraceConfig2 = new StackTraceConfig();
        }
        stackTraceConfig = stackTraceConfig2;
        StackTracer stackTracer2 = new StackTracer(null, 1, null);
        stackTracer = stackTracer2;
        if (stackTracer2.init(this)) {
            StackTracer stackTracer3 = stackTracer;
            isInitialized = stackTracer3 != null ? stackTracer3.enable() : false;
        }
        return isInitialized;
    }

    public final synchronized boolean isInitialized() {
        return isInitialized;
    }

    @Override // com.tencent.tmachine.trace.core.IProviderListener
    public void onDestroy(Provider provider) {
        j.f(provider, "provider");
        TMachineLog.i(TAG, "[onDestroy] provider=" + provider, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.core.IProviderListener
    public void onDisable(Provider provider) {
        j.f(provider, "provider");
        TMachineLog.i(TAG, "[onDisable] provider=" + provider, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onDumpSuccess(ThreadTracer threadTracer, ArrayList<StackLink> arrayList, String str) {
        j.f(threadTracer, "threadTracer");
        j.f(str, "tracePath");
        TMachineLog.i(TAG, "[onDumpSuccess] threadTracer=" + threadTracer, new Object[0]);
        TMachineLog.i(TAG, "[onDumpSuccess] tracePath=" + str, new Object[0]);
        TMachineLog.i(TAG, "[onDumpSuccess] stackLinks=" + arrayList, new Object[0]);
        if (stackTraceMap.size() >= 5) {
            stackTraceMap.clear();
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Map<String, ArrayList<StackLink>> map = stackTraceMap;
        j.b(map, "stackTraceMap");
        map.put(str, arrayList);
    }

    @Override // com.tencent.tmachine.trace.core.IProviderListener
    public void onEnable(Provider provider) {
        j.f(provider, "provider");
        TMachineLog.i(TAG, "[onEnable] provider=" + provider, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.core.IProviderListener
    public void onError(Provider provider, ErrorExtra errorExtra) {
        j.f(provider, "provider");
        TMachineLog.e(TAG, "[onError] provider=" + provider + ", errorExtra=" + errorExtra, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.core.IProviderListener
    public void onInit(Provider provider) {
        j.f(provider, "provider");
        TMachineLog.i(TAG, "[onInit] provider=" + provider, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onStart(ThreadTracer threadTracer) {
        j.f(threadTracer, "threadTracer");
        TMachineLog.i(TAG, "[onStart] threadTracer=" + threadTracer, new Object[0]);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onStop(ThreadTracer threadTracer) {
        j.f(threadTracer, "threadTracer");
        TMachineLog.i(TAG, "[onStop] threadTracer=" + threadTracer, new Object[0]);
    }

    public final synchronized void prepare(Context context) {
        StackTracer.Companion.prepare(context);
    }

    public final synchronized boolean startStackTracing(Thread thread) {
        j.f(thread, "thread");
        if (!isInitialized()) {
            return false;
        }
        StackTracer stackTracer2 = stackTracer;
        return stackTracer2 != null ? stackTracer2.startTracing(thread, stackTraceConfig.getTraceInterval(), stackTraceConfig.getTraceDuration(), this, stackTraceConfig.isWithLockTrace(), stackTraceConfig.isEnableFullStackCollect()) : false;
    }

    public final synchronized boolean stopStackTracing(Thread thread) {
        j.f(thread, "thread");
        if (!isInitialized()) {
            return false;
        }
        StackTracer stackTracer2 = stackTracer;
        return stackTracer2 != null ? stackTracer2.stopTracing(thread) : false;
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onError(ThreadTracer threadTracer, ErrorExtra errorExtra) {
        j.f(threadTracer, "threadTracer");
        TMachineLog.e(TAG, "[onError] threadTracer=" + threadTracer + ", errorExtra=" + errorExtra, new Object[0]);
    }
}
