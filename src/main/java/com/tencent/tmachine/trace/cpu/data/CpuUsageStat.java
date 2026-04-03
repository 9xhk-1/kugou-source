package com.tencent.tmachine.trace.cpu.data;

import defpackage.b;
import f.d;
import f.f;
import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuUsageStat {
    private final long cpuTime;
    private final long curFreq;
    private final long idleTime;
    private final int interval;
    private final long mainThreadCpuTime;
    private final d mainThreadRunningPercent$delegate;
    private final long maxFreq;
    private final long procCpuTime;
    private final d procCpuUsagePercent$delegate;
    private int realInterval;
    private final d sysCpuUsagePercent$delegate;
    private final long wallTime;

    public CpuUsageStat(long j, int i2, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.wallTime = j;
        this.interval = i2;
        this.cpuTime = j2;
        this.idleTime = j3;
        this.maxFreq = j4;
        this.curFreq = j5;
        this.procCpuTime = j6;
        this.mainThreadCpuTime = j7;
        this.realInterval = i2;
        this.sysCpuUsagePercent$delegate = f.b(new CpuUsageStat$sysCpuUsagePercent$2(this));
        this.procCpuUsagePercent$delegate = f.b(new CpuUsageStat$procCpuUsagePercent$2(this));
        this.mainThreadRunningPercent$delegate = f.b(new CpuUsageStat$mainThreadRunningPercent$2(this));
    }

    public final long component1() {
        return this.wallTime;
    }

    public final int component2() {
        return this.interval;
    }

    public final long component3() {
        return this.cpuTime;
    }

    public final long component4() {
        return this.idleTime;
    }

    public final long component5() {
        return this.maxFreq;
    }

    public final long component6() {
        return this.curFreq;
    }

    public final long component7() {
        return this.procCpuTime;
    }

    public final long component8() {
        return this.mainThreadCpuTime;
    }

    public final CpuUsageStat copy(long j, int i2, long j2, long j3, long j4, long j5, long j6, long j7) {
        return new CpuUsageStat(j, i2, j2, j3, j4, j5, j6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpuUsageStat)) {
            return false;
        }
        CpuUsageStat cpuUsageStat = (CpuUsageStat) obj;
        return this.wallTime == cpuUsageStat.wallTime && this.interval == cpuUsageStat.interval && this.cpuTime == cpuUsageStat.cpuTime && this.idleTime == cpuUsageStat.idleTime && this.maxFreq == cpuUsageStat.maxFreq && this.curFreq == cpuUsageStat.curFreq && this.procCpuTime == cpuUsageStat.procCpuTime && this.mainThreadCpuTime == cpuUsageStat.mainThreadCpuTime;
    }

    public final long getCpuTime() {
        return this.cpuTime;
    }

    public final long getCurFreq() {
        return this.curFreq;
    }

    public final long getIdleTime() {
        return this.idleTime;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final long getMainThreadCpuTime() {
        return this.mainThreadCpuTime;
    }

    public final float getMainThreadRunningPercent() {
        return ((Number) this.mainThreadRunningPercent$delegate.getValue()).floatValue();
    }

    public final long getMaxFreq() {
        return this.maxFreq;
    }

    public final long getProcCpuTime() {
        return this.procCpuTime;
    }

    public final float getProcCpuUsagePercent() {
        return ((Number) this.procCpuUsagePercent$delegate.getValue()).floatValue();
    }

    public final int getRealInterval() {
        return this.realInterval;
    }

    public final float getSysCpuUsagePercent() {
        return ((Number) this.sysCpuUsagePercent$delegate.getValue()).floatValue();
    }

    public final long getWallTime() {
        return this.wallTime;
    }

    public int hashCode() {
        return (((((((((((((b.a(this.wallTime) * 31) + this.interval) * 31) + b.a(this.cpuTime)) * 31) + b.a(this.idleTime)) * 31) + b.a(this.maxFreq)) * 31) + b.a(this.curFreq)) * 31) + b.a(this.procCpuTime)) * 31) + b.a(this.mainThreadCpuTime);
    }

    public final void setRealInterval(int i2) {
        this.realInterval = i2;
    }

    public String toString() {
        return "CpuUsageStat(wallTime=" + this.wallTime + ", interval=" + this.interval + ", cpuTime=" + this.cpuTime + ", idleTime=" + this.idleTime + ", maxFreq=" + this.maxFreq + ", curFreq=" + this.curFreq + ", procCpuTime=" + this.procCpuTime + ", mainThreadCpuTime=" + this.mainThreadCpuTime + ", realInterval=" + this.realInterval + ", sysCpuUsagePercent=" + getSysCpuUsagePercent() + ", procCpuUsagePercent=" + getProcCpuUsagePercent() + ", mainThreadRunningPercent=" + getMainThreadRunningPercent() + ')';
    }

    public /* synthetic */ CpuUsageStat(long j, int i2, long j2, long j3, long j4, long j5, long j6, long j7, int i3, g gVar) {
        this(j, i2, j2, j3, j4, j5, j6, (i3 & 128) != 0 ? -1L : j7);
    }
}
