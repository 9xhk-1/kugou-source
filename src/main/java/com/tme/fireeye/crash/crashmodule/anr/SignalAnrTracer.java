package com.tme.fireeye.crash.crashmodule.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import com.tencent.tmachine.trace.cpu.monitor.CpuInfoMonitor;
import com.tencent.tmachine.trace.looper.data.DispatchRecordTrace;
import com.tencent.tmachine.trace.looper.data.PendingMsgTrace;
import com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor;
import com.tencent.tmachine.trace.looper.util.LooperUtil;
import com.tencent.tmachine.trace.provider.stacktrace.StackTraceMonitor;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import e.f.a.a.a.k.c;
import e.f.a.a.b.f.d;
import e.f.a.a.b.f.f;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SignalAnrTracer {
    private static final int ANR_DUMP_MAX_TIME = 20000;
    private static final long BACKGROUND_MSG_THRESHOLD = -10000;
    private static final String CHECK_ANR_STATE_THREAD_NAME = "Check-ANR-State-Thread";
    private static final int CHECK_ERROR_STATE_COUNT = 40;
    private static final int CHECK_ERROR_STATE_INTERVAL = 500;
    public static final long FOREGROUND_MSG_THRESHOLD = -2000;
    private static final String SYSTEM_TRACE_FILE_PREFIX = "anr_sys_trace_file";
    private static final String TAG = "SignalAnrTracer";
    private static e.f.a.a.b.f.b anrExtraInfo;
    private static d checkTimeHandler;
    private static Context context;
    private static String hookTraceFilePath;
    private static boolean isOpenDumpSysAnrTrace;
    private static Field mQueueFieldBeforeM;
    private static b sSignalAnrDetectedListener;
    private static String sysAnrTraceFileDir;
    private static final List<String> whiteListStacks;
    public static Long CHECK_ANR_INTERVAL = 120000L;
    private static boolean currentForeground = false;
    private static boolean hasInit = false;
    private static boolean hasInstance = false;
    private static long anrMessageWhen = 0;
    private static String anrMessageString = "";
    private static String stackTrace = "";
    private static String nativeBacktraceStackTrace = "";
    private static long lastReportedTimeStamp = 0;
    private static volatile long lastCheckAnrTimeStamp = 0;
    private static long onAnrDumpedTimeStamp = 0;
    private static long onNativeBacktraceDumpedTimeStamp = 0;
    private static boolean needForwardSignalImmediately = true;
    private static final AtomicBoolean isAnrProcessing = new AtomicBoolean(false);
    public static boolean openCheckTime = false;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SignalAnrTracer.checkErrorStateCycle(this.a);
        }
    }

    public interface b {
        void onAnrDetected(long j, String str, String str2, String str3, long j2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, boolean z, boolean z2, e.f.a.a.b.f.b bVar);

        void onNativeBacktraceDetected(long j, String str, String str2, long j2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, e.f.a.a.b.f.b bVar);
    }

    static {
        ArrayList arrayList = new ArrayList();
        whiteListStacks = arrayList;
        arrayList.add("com.tme.fireeye.crash.crashmodule.JavaCrashHandler.uncaughtException");
    }

    public SignalAnrTracer(Context context2) {
        hasInstance = true;
        context = context2;
        if (openCheckTime) {
            d dVar = new d();
            checkTimeHandler = dVar;
            dVar.g();
        }
    }

    private static ActivityManager.ProcessErrorStateInfo checkErrorState() {
        try {
            c.f("[checkErrorState] start", new Object[0]);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                c.f("[checkErrorState] procs == null", new Object[0]);
                return null;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                c.f("[checkErrorState] found Error State proccessName = %s, proc.condition = %d", processErrorStateInfo.processName, Integer.valueOf(processErrorStateInfo.condition));
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    c.f("maybe received other apps ANR signal", new Object[0]);
                    return null;
                }
                if (processErrorStateInfo.pid != Process.myPid()) {
                    c.f("proc.pid = %d, myPid = %d, not equal, continue", Integer.valueOf(processErrorStateInfo.pid), Integer.valueOf(Process.myPid()));
                } else {
                    if (processErrorStateInfo.condition == 2) {
                        c.f("error sate longMsg = %s", processErrorStateInfo.longMsg);
                        return processErrorStateInfo;
                    }
                    c.f("proc.condition is not NOT_RESPONDING, continue", Integer.valueOf(processErrorStateInfo.pid), Integer.valueOf(Process.myPid()));
                }
            }
            return null;
        } catch (Throwable th) {
            c.c("[checkErrorState] error : %s", th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkErrorStateCycle(boolean z) {
        int i2 = 0;
        while (i2 < 40) {
            i2++;
            try {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoCheckErrorState = checkErrorState();
                if (processErrorStateInfoCheckErrorState != null) {
                    report(processErrorStateInfoCheckErrorState, z, false, false);
                    return;
                }
                Thread.sleep(500L);
            } catch (Throwable th) {
                c.c("checkErrorStateCycle error, e : " + th.getMessage(), new Object[0]);
                return;
            }
        }
    }

    private static void confirmRealAnr(boolean z) {
        c.f("[confirmRealAnr] isSigQuit=" + z, new Object[0]);
        anrExtraInfo = new e.f.a.a.b.f.b();
        if (isMainThreadBlocked()) {
            report(null, z, true, !needForwardSignalImmediately);
            return;
        }
        new Thread(new a(z), CHECK_ANR_STATE_THREAD_NAME).start();
        if (z) {
            if (isOpenDumpSysAnrTrace) {
                String dumpSysAnrTracePath = getDumpSysAnrTracePath(onAnrDumpedTimeStamp);
                if (safeNativeDumpSysAnrTrace(dumpSysAnrTracePath)) {
                    hookTraceFilePath = dumpSysAnrTracePath;
                } else {
                    hookTraceFilePath = null;
                }
            }
            if (needForwardSignalImmediately) {
                return;
            }
            nativeSendSigQuitToSignalCatcher();
        }
    }

    private static void dumpMethodAndCpuTraceIfNeed(boolean z) {
        JSONArray jSONArrayA;
        try {
            e.f.a.a.b.f.c cVarV = e.f.a.a.b.f.c.v();
            if (cVarV == null || anrExtraInfo == null) {
                return;
            }
            long j = z ? onAnrDumpedTimeStamp : onNativeBacktraceDumpedTimeStamp;
            if (cVarV.E()) {
                String strH = cVarV.H(j);
                if (StackTraceMonitor.INSTANCE.dumpStackTracing(Looper.getMainLooper().getThread(), strH)) {
                    anrExtraInfo.f1391e = strH;
                } else {
                    c.c("[report] dump method trace failed, path=" + strH, new Object[0]);
                }
            }
            if (cVarV.z() && (jSONArrayA = f.a(CpuInfoMonitor.INSTANCE.getCache())) != null) {
                String strS = cVarV.s(j);
                e.f.a.a.a.k.f.A(strS, jSONArrayA.toString(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                anrExtraInfo.f1392f = strS;
            }
            if (!cVarV.A()) {
                PendingMsgTrace pendingMsgTraceGeneratePendingMsgTrace = LooperMsgDispatchMonitor.INSTANCE.generatePendingMsgTrace(LooperUtil.getLooperPendingMessages());
                anrExtraInfo.b = Integer.valueOf(pendingMsgTraceGeneratePendingMsgTrace.getPendingMsgCnt());
                anrExtraInfo.c = pendingMsgTraceGeneratePendingMsgTrace.getSyncBarrierMsgList();
                anrExtraInfo.f1390d = pendingMsgTraceGeneratePendingMsgTrace.getKeyPendingMsgList();
                return;
            }
            DispatchRecordTrace cache = LooperMsgDispatchMonitor.INSTANCE.getCache();
            if (cache != null) {
                anrExtraInfo.b = Integer.valueOf(cache.getPendingMsgCnt());
                anrExtraInfo.c = cache.getSyncBarrierMsgList();
                anrExtraInfo.f1390d = cache.getKeyPendingMsgList();
                JSONObject jSONObjectB = f.b(cache);
                if (jSONObjectB != null) {
                    String strG = cVarV.G(j);
                    e.f.a.a.a.k.f.A(strG, jSONObjectB.toString(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    anrExtraInfo.f1393g = strG;
                }
            }
        } catch (Throwable th) {
            c.d(th);
        }
    }

    private static String getDumpSysAnrTracePath(long j) {
        return new File(sysAnrTraceFileDir, "anr_sys_trace_file_" + j + ".txt").getAbsolutePath();
    }

    public static boolean isFreeze(ArrayList<Long> arrayList) {
        if (arrayList == null) {
            return false;
        }
        long j = currentForeground ? 5000L : NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME;
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().longValue() > j) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMainThreadBlocked() {
        MessageQueue queue;
        Message message;
        StrategyBean strategyBeanH;
        long j;
        StrategyBean strategyBeanH2;
        d dVar = checkTimeHandler;
        ArrayList<Long> arrayListF = dVar != null ? dVar.f() : null;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                queue = Looper.getMainLooper().getQueue();
            } else {
                if (mQueueFieldBeforeM == null) {
                    Field declaredField = Looper.class.getDeclaredField("mQueue");
                    mQueueFieldBeforeM = declaredField;
                    declaredField.setAccessible(true);
                }
                queue = (MessageQueue) mQueueFieldBeforeM.get(Looper.getMainLooper());
            }
            Field declaredField2 = queue.getClass().getDeclaredField("mMessages");
            declaredField2.setAccessible(true);
            message = (Message) declaredField2.get(queue);
        } catch (Exception unused) {
        }
        if (message == null) {
            c.f("mMessage is null", new Object[0]);
            return false;
        }
        anrMessageString = message.toString();
        c.f("anrMessageString = " + anrMessageString, new Object[0]);
        long when = message.getWhen();
        if (when == 0) {
            return false;
        }
        long jUptimeMillis = when - SystemClock.uptimeMillis();
        anrMessageWhen = jUptimeMillis;
        e.f.a.a.b.f.b bVar = anrExtraInfo;
        if (bVar != null) {
            bVar.a = Long.valueOf(jUptimeMillis);
        }
        long j2 = BACKGROUND_MSG_THRESHOLD;
        if (currentForeground) {
            j2 = FOREGROUND_MSG_THRESHOLD;
            if (needForwardSignalImmediately) {
                e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
                if (aVarG != null && (strategyBeanH2 = aVarG.h()) != null) {
                    j = strategyBeanH2.x;
                    j2 = -j;
                }
            } else {
                e.f.a.a.a.i.a aVarG2 = e.f.a.a.a.i.a.g();
                if (aVarG2 != null && (strategyBeanH = aVarG2.h()) != null) {
                    j = strategyBeanH.y;
                    j2 = -j;
                }
            }
        }
        c.f("timeThreshold: " + j2 + ", blockTime: " + jUptimeMillis, new Object[0]);
        if (j2 >= 0 || jUptimeMillis >= j2) {
            return false;
        }
        return !isFreeze(arrayListF);
    }

    private static boolean isWhiteListStack(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = whiteListStacks.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static native boolean nativeDumpSysAnrTrace(String str);

    private static native void nativeFreeSignalAnrDetective();

    private static native void nativeInitSignalAnrDetective(boolean z);

    public static native void nativeSendSigQuitToSignalCatcher();

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0014, B:8:0x001e, B:10:0x006f, B:14:0x0078, B:16:0x0080, B:17:0x0083, B:19:0x0089, B:12:0x0073, B:20:0x00a8), top: B:26:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void onANRDumped() {
        /*
            java.lang.Class<com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer> r0 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.class
            monitor-enter(r0)
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lad
            long r3 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.lastCheckAnrTimeStamp     // Catch: java.lang.Throwable -> Lad
            long r1 = r1 - r3
            java.lang.Long r3 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.CHECK_ANR_INTERVAL     // Catch: java.lang.Throwable -> Lad
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> Lad
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto La8
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.isAnrProcessing     // Catch: java.lang.Throwable -> Lad
            r2 = 1
            r3 = 0
            boolean r4 = r1.compareAndSet(r3, r2)     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto La8
            r4 = 0
            com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.hookTraceFilePath = r4     // Catch: java.lang.Throwable -> Lad
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lad
            com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.onAnrDumpedTimeStamp = r4     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = e.f.a.a.b.i.a.a()     // Catch: java.lang.Throwable -> Lad
            com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.stackTrace = r4     // Catch: java.lang.Throwable -> Lad
            boolean r4 = e.f.a.a.b.i.a.d()     // Catch: java.lang.Throwable -> Lad
            com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.currentForeground = r4     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.stackTrace     // Catch: java.lang.Throwable -> Lad
            boolean r4 = isWhiteListStack(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r5.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = "[onANRDumped] timeStamp="
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            long r6 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.onAnrDumpedTimeStamp     // Catch: java.lang.Throwable -> Lad
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = ", currentForeground="
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            boolean r6 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.currentForeground     // Catch: java.lang.Throwable -> Lad
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = ", isWhiteListStack="
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            r5.append(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = ", stackTrace="
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.stackTrace     // Catch: java.lang.Throwable -> Lad
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lad
            e.f.a.a.a.k.c.f(r5, r6)     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto L73
            boolean r5 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.needForwardSignalImmediately     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto L76
        L73:
            nativeSendSigQuitToSignalCatcher()     // Catch: java.lang.Throwable -> Lad
        L76:
            if (r4 != 0) goto L83
            java.lang.String r4 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.stackTrace     // Catch: java.lang.Throwable -> Lad
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto L83
            confirmRealAnr(r2)     // Catch: java.lang.Throwable -> Lad
        L83:
            boolean r1 = r1.compareAndSet(r2, r3)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto Lab
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lad
            com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.lastCheckAnrTimeStamp = r1     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r1.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "[onANRDumped] lastCheckAnrTime="
            r1.append(r2)     // Catch: java.lang.Throwable -> Lad
            long r4 = com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.lastCheckAnrTimeStamp     // Catch: java.lang.Throwable -> Lad
            r1.append(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lad
            e.f.a.a.a.k.c.f(r1, r2)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        La8:
            nativeSendSigQuitToSignalCatcher()     // Catch: java.lang.Throwable -> Lad
        Lab:
            monitor-exit(r0)
            return
        Lad:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer.onANRDumped():void");
    }

    private static void onNativeBacktraceDumped() {
        if (System.currentTimeMillis() - lastCheckAnrTimeStamp >= CHECK_ANR_INTERVAL.longValue()) {
            AtomicBoolean atomicBoolean = isAnrProcessing;
            if (atomicBoolean.compareAndSet(false, true)) {
                c.f("happens onNativeBacktraceDumped", new Object[0]);
                if (System.currentTimeMillis() - lastReportedTimeStamp < 20000) {
                    c.f("report SIGQUIT recently, just return", new Object[0]);
                    return;
                }
                onNativeBacktraceDumpedTimeStamp = System.currentTimeMillis();
                String strA = e.f.a.a.b.i.a.a();
                nativeBacktraceStackTrace = strA;
                boolean zIsWhiteListStack = isWhiteListStack(strA);
                c.f("[onNativeBacktraceDumped] timeStamp=" + onNativeBacktraceDumpedTimeStamp + ", isWhiteListStack=" + zIsWhiteListStack + ", stackTrace = " + nativeBacktraceStackTrace, new Object[0]);
                if (!zIsWhiteListStack && !TextUtils.isEmpty(nativeBacktraceStackTrace)) {
                    confirmRealAnr(false);
                }
                if (atomicBoolean.compareAndSet(true, false)) {
                    lastCheckAnrTimeStamp = System.currentTimeMillis();
                    c.f("[onANRDumped] lastCheckAnrTime=" + lastCheckAnrTimeStamp, new Object[0]);
                }
            }
        }
    }

    public static boolean printTrace(String str) {
        if (!hasInstance) {
            c.c("[printTrace] SignalAnrTracer has not been initialize", new Object[0]);
            return false;
        }
        c.f("[printTrace] printTraceFilePath=" + str, new Object[0]);
        if (!TextUtils.isEmpty(str)) {
            return safeNativeDumpSysAnrTrace(str);
        }
        c.c("[printTrace] printTraceFilePath error, return", new Object[0]);
        return false;
    }

    private static void report(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, boolean z, boolean z2, boolean z3) {
        dumpMethodAndCpuTraceIfNeed(z);
        lastReportedTimeStamp = System.currentTimeMillis();
        b bVar = sSignalAnrDetectedListener;
        if (bVar != null) {
            if (z) {
                bVar.onAnrDetected(onAnrDumpedTimeStamp, stackTrace, hookTraceFilePath, anrMessageString, anrMessageWhen, processErrorStateInfo, z2, z3, anrExtraInfo);
            } else {
                bVar.onNativeBacktraceDetected(onNativeBacktraceDumpedTimeStamp, nativeBacktraceStackTrace, anrMessageString, anrMessageWhen, processErrorStateInfo, anrExtraInfo);
            }
        }
    }

    private static boolean safeNativeDumpSysAnrTrace(String str) {
        try {
            return nativeDumpSysAnrTrace(str);
        } catch (Throwable th) {
            c.c("[safeNativeDumpSysAnrTrace] err:", th);
            return false;
        }
    }

    public String dumpSysAnrTrace() {
        if (!isOpenDumpSysAnrTrace) {
            return null;
        }
        String dumpSysAnrTracePath = getDumpSysAnrTracePath(onAnrDumpedTimeStamp);
        if (safeNativeDumpSysAnrTrace(dumpSysAnrTracePath)) {
            hookTraceFilePath = dumpSysAnrTracePath;
        } else {
            hookTraceFilePath = null;
        }
        return hookTraceFilePath;
    }

    public void setCheckAnrInterval(long j) {
        CHECK_ANR_INTERVAL = Long.valueOf(j);
    }

    public void setForwardSignalImmediately(boolean z) {
        needForwardSignalImmediately = z;
    }

    public void setSignalAnrDetectedListener(b bVar) {
        sSignalAnrDetectedListener = bVar;
    }

    public void startAnrDetective(boolean z, String str) {
        c.f("[startAnrDetective] hasInit=" + hasInit + ", anrPrintTraceFilePath=" + str, new Object[0]);
        try {
            if (hasInit) {
                return;
            }
            sysAnrTraceFileDir = str;
            isOpenDumpSysAnrTrace = Build.VERSION.SDK_INT >= 21 && !TextUtils.isEmpty(str);
            nativeInitSignalAnrDetective(z);
            hasInit = true;
        } catch (Throwable th) {
            isOpenDumpSysAnrTrace = false;
            hasInit = false;
            c.c("[startAnrDetective] error : %s", th.getMessage());
        }
    }

    public void stopAnrDetective() {
        c.f("[stopAnrDetective]", new Object[0]);
        nativeFreeSignalAnrDetective();
        hasInit = false;
        isOpenDumpSysAnrTrace = false;
        d dVar = checkTimeHandler;
        if (dVar != null) {
            dVar.h();
        }
    }
}
