package com.tencent.tmachine.trace.cpu.monitor;

import com.tencent.tmachine.trace.cpu.data.CpuInfo;
import com.tencent.tmachine.trace.cpu.data.CpuInfoTrace;
import com.tencent.tmachine.trace.cpu.data.CpuUsageStat;
import com.tencent.tmachine.trace.cpu.data.ProcStatSummary;
import com.tencent.tmachine.trace.cpu.procfs.ProcPseudo;
import com.tencent.tmachine.trace.cpu.sysfs.CpuPolicy;
import com.tencent.tmachine.trace.cpu.sysfs.SysCpu;
import com.tencent.tmachine.trace.cpu.util.Clock;
import com.tencent.tmachine.trace.cpu.util.SysCpuIdleTimeCalculator;
import com.tencent.tmachine.trace.util.TMachineLog;
import com.tencent.tmachine.trace.util.TraceUtil;
import f.z.d.g;
import f.z.d.j;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuInfoMonitor {
    private static final String TAG = "CpuUsageMonitor";
    private static boolean isStarted;
    private static ProcStatSummary lastMainThreadStatSummary;
    private static ProcStatSummary lastProcStatSummary;
    private static long lastSampleWallTime;
    private static long lastTotalCpuTime;
    private static Future<?> workFuture;
    public static final CpuInfoMonitor INSTANCE = new CpuInfoMonitor();
    private static final DecimalFormat df = new DecimalFormat("##.####");
    private static SysCpuIdleTimeCalculator sysCpuIdleTimeCalculator = new SysCpuIdleTimeCalculator(1000);
    private static Config config = new Config();
    private static CpuInfoTrace cache = new CpuInfoTrace();

    public static final class Config {
        public static final Companion Companion = new Companion(null);
        public static final int DEFAULT_CPU_INFO_CACHE_MAX_SIZE = 30;
        public static final int DEFAULT_SAMPLE_INTERVAL_MS = 1000;
        private ScheduledExecutorService scheduler;
        private final boolean profileCpuFrequencyUsage = true;
        private boolean profileMainThreadCpuUsage = true;
        private int sampleIntervalMs = 1000;
        private int cpuInfoCacheMaxSize = 30;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        public final int getCpuInfoCacheMaxSize() {
            return this.cpuInfoCacheMaxSize;
        }

        public final boolean getProfileCpuFrequencyUsage() {
            return this.profileCpuFrequencyUsage;
        }

        public final boolean getProfileMainThreadCpuUsage() {
            return this.profileMainThreadCpuUsage;
        }

        public final int getSampleIntervalMs() {
            return this.sampleIntervalMs;
        }

        public final ScheduledExecutorService getScheduler() {
            return this.scheduler;
        }

        public final void setCpuInfoCacheMaxSize(int i2) {
            this.cpuInfoCacheMaxSize = i2;
        }

        public final void setProfileMainThreadCpuUsage(boolean z) {
            this.profileMainThreadCpuUsage = z;
        }

        public final void setSampleIntervalMs(int i2) {
            this.sampleIntervalMs = i2;
        }

        public final void setScheduler(ScheduledExecutorService scheduledExecutorService) {
            this.scheduler = scheduledExecutorService;
        }
    }

    private CpuInfoMonitor() {
    }

    private final synchronized void enqueueHistoryTrace(CpuInfo cpuInfo) {
        if (cache.getCpuInfoList().size() == config.getCpuInfoCacheMaxSize()) {
            cache.getCpuInfoList().poll();
        }
        cache.getCpuInfoList().offer(cpuInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void sampleAndCalculate() {
        long totalUsedCpuTimeMs;
        long currentTimestampMs = Clock.Companion.getCurrentTimestampMs();
        int sampleIntervalMs = config.getSampleIntervalMs();
        long jScalingMaxFreq = 0;
        long jScalingCurFreq = 0;
        long cpuTime = 0;
        for (CpuPolicy cpuPolicy : SysCpu.INSTANCE.cpuClusters()) {
            cpuTime += cpuPolicy.readCpuTime() * ((long) cpuPolicy.affectedCpuCount());
            if (config.getProfileCpuFrequencyUsage()) {
                jScalingMaxFreq += cpuPolicy.scalingMaxFreq() * ((long) cpuPolicy.affectedCpuCount());
                jScalingCurFreq += cpuPolicy.scalingCurFreq() * ((long) cpuPolicy.affectedCpuCount());
            }
        }
        long sysIdleDeltaTime = sysCpuIdleTimeCalculator.getSysIdleDeltaTime(SysCpu.INSTANCE.cpus(), sampleIntervalMs);
        ProcPseudo.Companion companion = ProcPseudo.Companion;
        ProcStatSummary procStatSummary = companion.myProcPseudo().readProcStatSummary();
        ProcStatSummary procStatSummary2 = config.getProfileMainThreadCpuUsage() ? companion.myMainThreadTaskPseudo().readProcStatSummary() : null;
        long j = lastTotalCpuTime;
        if (j > 0) {
            long j2 = cpuTime - j;
            long totalUsedCpuTimeMs2 = procStatSummary.getTotalUsedCpuTimeMs();
            ProcStatSummary procStatSummary3 = lastProcStatSummary;
            if (procStatSummary3 == null) {
                j.n();
                throw null;
            }
            long totalUsedCpuTimeMs3 = totalUsedCpuTimeMs2 - procStatSummary3.getTotalUsedCpuTimeMs();
            long j3 = currentTimestampMs - lastSampleWallTime;
            if (!config.getProfileMainThreadCpuUsage()) {
                totalUsedCpuTimeMs = -1;
            } else {
                if (procStatSummary2 == null) {
                    j.n();
                    throw null;
                }
                long totalUsedCpuTimeMs4 = procStatSummary2.getTotalUsedCpuTimeMs();
                ProcStatSummary procStatSummary4 = lastMainThreadStatSummary;
                if (procStatSummary4 == null) {
                    j.n();
                    throw null;
                }
                totalUsedCpuTimeMs = totalUsedCpuTimeMs4 - procStatSummary4.getTotalUsedCpuTimeMs();
            }
            CpuUsageStat cpuUsageStat = new CpuUsageStat(j3, sampleIntervalMs, j2, sysIdleDeltaTime, jScalingMaxFreq, jScalingCurFreq, totalUsedCpuTimeMs3, totalUsedCpuTimeMs);
            StringBuilder sb = new StringBuilder();
            sb.append("系统CPU使用率 ");
            DecimalFormat decimalFormat = df;
            sb.append(decimalFormat.format(Float.valueOf(cpuUsageStat.getSysCpuUsagePercent())));
            sb.append(" 进程CPU使用率 ");
            sb.append(decimalFormat.format(Float.valueOf(cpuUsageStat.getProcCpuUsagePercent())));
            sb.append(" 主线程CPU占用率（占进程） ");
            sb.append(decimalFormat.format(Float.valueOf(cpuUsageStat.getMainThreadRunningPercent())));
            TMachineLog.i(TAG, sb.toString(), new Object[0]);
            enqueueHistoryTrace(new CpuInfo(cpuUsageStat.getSysCpuUsagePercent(), cpuUsageStat.getProcCpuUsagePercent(), cpuUsageStat.getMainThreadRunningPercent(), System.currentTimeMillis()));
        }
        lastSampleWallTime = currentTimestampMs;
        lastTotalCpuTime = cpuTime;
        lastProcStatSummary = procStatSummary;
        lastMainThreadStatSummary = procStatSummary2;
    }

    public static /* synthetic */ void startMonitor$default(CpuInfoMonitor cpuInfoMonitor, Config config2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config2 = null;
        }
        cpuInfoMonitor.startMonitor(config2);
    }

    public final synchronized CpuInfoTrace getCache() {
        if (!isStarted()) {
            TMachineLog.e(TAG, "cpu monitor is not enable, return null", new Object[0]);
            return null;
        }
        CpuInfoTrace cpuInfoTrace = new CpuInfoTrace();
        cpuInfoTrace.getCpuInfoList().addAll(cache.getCpuInfoList());
        return cpuInfoTrace;
    }

    public final synchronized JSONArray getCacheJsonArray() {
        CpuInfoTrace cache2;
        cache2 = getCache();
        return cache2 == null ? null : TraceUtil.cpuTraceToJSON(cache2);
    }

    public final synchronized boolean isStarted() {
        return isStarted;
    }

    public final void startMonitor() {
        startMonitor$default(this, null, 1, null);
    }

    public final synchronized void startMonitor(Config config2) {
        if (isStarted()) {
            return;
        }
        TMachineLog.i(TAG, "start cpu monitor", new Object[0]);
        if (config2 == null) {
            config2 = new Config();
        }
        config = config2;
        sysCpuIdleTimeCalculator = new SysCpuIdleTimeCalculator(config.getSampleIntervalMs());
        ScheduledExecutorService scheduler = config.getScheduler();
        if (scheduler == null) {
            scheduler = Executors.newScheduledThreadPool(1);
        }
        workFuture = scheduler.scheduleAtFixedRate(new Runnable() { // from class: com.tencent.tmachine.trace.cpu.monitor.CpuInfoMonitor.startMonitor.1
            @Override // java.lang.Runnable
            public final void run() {
                CpuInfoMonitor.INSTANCE.sampleAndCalculate();
            }
        }, 0L, config.getSampleIntervalMs(), TimeUnit.MILLISECONDS);
        isStarted = true;
    }

    public final synchronized void stopMonitor() {
        if (isStarted()) {
            TMachineLog.i(TAG, "stop cpu monitor", new Object[0]);
            cache.getCpuInfoList().clear();
            lastSampleWallTime = 0L;
            lastTotalCpuTime = 0L;
            lastProcStatSummary = null;
            lastMainThreadStatSummary = null;
            Future<?> future = workFuture;
            if (future != null) {
                future.cancel(false);
            }
            workFuture = null;
            isStarted = false;
        }
    }
}
