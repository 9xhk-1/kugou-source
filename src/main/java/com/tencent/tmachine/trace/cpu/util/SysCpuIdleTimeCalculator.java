package com.tencent.tmachine.trace.cpu.util;

import com.tencent.tmachine.trace.cpu.PseudoReadException;
import com.tencent.tmachine.trace.cpu.sysfs.Cpu;
import com.tencent.tmachine.trace.util.TMachineLog;
import f.z.d.g;
import f.z.d.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class SysCpuIdleTimeCalculator {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SysCpuIdleTime";
    private final int sampleIntervalMills;
    private final Map<Integer, Long> lastCpuIdleTimes = new LinkedHashMap();
    private boolean allowReadScalingMaxFeqFile = true;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public SysCpuIdleTimeCalculator(int i2) {
        this.sampleIntervalMills = i2;
    }

    public final long getSysIdleDeltaTime(List<Cpu> list, long j) throws PseudoReadException {
        long jMaxFreq;
        j.f(list, "allCpu");
        long j2 = 1000 * j;
        long j3 = 0;
        long j4 = 0;
        for (Cpu cpu : list) {
            long jIdleTime = cpu.idleTime();
            Long l = this.lastCpuIdleTimes.get(Integer.valueOf(cpu.getCpuIndex()));
            this.lastCpuIdleTimes.put(Integer.valueOf(cpu.getCpuIndex()), Long.valueOf(jIdleTime));
            if (l != null) {
                long jLongValue = jIdleTime - l.longValue();
                if (jLongValue == j3) {
                    long jScalingCurFreq = cpu.getCpuFreq().scalingCurFreq();
                    if (this.allowReadScalingMaxFeqFile) {
                        try {
                            jMaxFreq = cpu.getCpuFreq().scalingMaxFreq();
                        } catch (Exception unused) {
                            this.allowReadScalingMaxFeqFile = false;
                            jMaxFreq = cpu.getCpuFreq().maxFreq();
                        }
                    } else {
                        jMaxFreq = cpu.getCpuFreq().maxFreq();
                    }
                    long j5 = jMaxFreq;
                    if (j5 == jScalingCurFreq) {
                        TMachineLog.e(TAG, cpu.getCpuIndex() + " idle 为0，运行在最高频率 " + jScalingCurFreq + ' ' + j5, new Object[0]);
                        j4 += jLongValue;
                    } else {
                        TMachineLog.e(TAG, cpu.getCpuIndex() + " idle 为0，不是最高频率 " + jScalingCurFreq + ' ' + j5, new Object[0]);
                        jLongValue = j2;
                        j4 += jLongValue;
                    }
                } else {
                    if (jLongValue > j2) {
                        TMachineLog.e(TAG, cpu.getCpuIndex() + " idle 时间过长 " + jLongValue, new Object[0]);
                        jLongValue = j2;
                    }
                    j4 += jLongValue;
                }
            }
            j3 = 0;
        }
        return j4 / ((long) 1000);
    }
}
