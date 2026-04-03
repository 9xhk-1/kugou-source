package com.tencent.tmachine.trace.cpu.data;

import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuInfo {
    private final float mainThreadRunningPercent;
    private final float procCpuUsagePercent;
    private final float sysCpuUsagePercent;
    private final long timeStamp;

    public CpuInfo(float f2, float f3, float f4, long j) {
        this.sysCpuUsagePercent = f2;
        this.procCpuUsagePercent = f3;
        this.mainThreadRunningPercent = f4;
        this.timeStamp = j;
    }

    public static /* synthetic */ CpuInfo copy$default(CpuInfo cpuInfo, float f2, float f3, float f4, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = cpuInfo.sysCpuUsagePercent;
        }
        if ((i2 & 2) != 0) {
            f3 = cpuInfo.procCpuUsagePercent;
        }
        float f5 = f3;
        if ((i2 & 4) != 0) {
            f4 = cpuInfo.mainThreadRunningPercent;
        }
        float f6 = f4;
        if ((i2 & 8) != 0) {
            j = cpuInfo.timeStamp;
        }
        return cpuInfo.copy(f2, f5, f6, j);
    }

    public final float component1() {
        return this.sysCpuUsagePercent;
    }

    public final float component2() {
        return this.procCpuUsagePercent;
    }

    public final float component3() {
        return this.mainThreadRunningPercent;
    }

    public final long component4() {
        return this.timeStamp;
    }

    public final CpuInfo copy(float f2, float f3, float f4, long j) {
        return new CpuInfo(f2, f3, f4, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpuInfo)) {
            return false;
        }
        CpuInfo cpuInfo = (CpuInfo) obj;
        return Float.compare(this.sysCpuUsagePercent, cpuInfo.sysCpuUsagePercent) == 0 && Float.compare(this.procCpuUsagePercent, cpuInfo.procCpuUsagePercent) == 0 && Float.compare(this.mainThreadRunningPercent, cpuInfo.mainThreadRunningPercent) == 0 && this.timeStamp == cpuInfo.timeStamp;
    }

    public final float getMainThreadRunningPercent() {
        return this.mainThreadRunningPercent;
    }

    public final float getProcCpuUsagePercent() {
        return this.procCpuUsagePercent;
    }

    public final float getSysCpuUsagePercent() {
        return this.sysCpuUsagePercent;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.sysCpuUsagePercent) * 31) + Float.floatToIntBits(this.procCpuUsagePercent)) * 31) + Float.floatToIntBits(this.mainThreadRunningPercent)) * 31) + b.a(this.timeStamp);
    }

    public String toString() {
        return "CpuInfo(sysCpuUsagePercent=" + this.sysCpuUsagePercent + ", procCpuUsagePercent=" + this.procCpuUsagePercent + ", mainThreadRunningPercent=" + this.mainThreadRunningPercent + ", timeStamp=" + this.timeStamp + ")";
    }
}
