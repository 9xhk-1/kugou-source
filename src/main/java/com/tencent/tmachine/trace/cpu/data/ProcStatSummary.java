package com.tencent.tmachine.trace.cpu.data;

import f.d;
import f.f;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcStatSummary {
    private long cstime;
    private long cutime;
    private int numThreads;
    private long sampleWallTime;
    private long stime;
    private long utime;
    private long vsize;
    private String pid = "";
    private String name = "";
    private String state = "";
    private String nice = "";
    private final d totalUsedCpuTime$delegate = f.b(new ProcStatSummary$totalUsedCpuTime$2(this));
    private final d totalUsedCpuTimeMs$delegate = f.b(new ProcStatSummary$totalUsedCpuTimeMs$2(this));

    public final long getCstime() {
        return this.cstime;
    }

    public final long getCutime() {
        return this.cutime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNice() {
        return this.nice;
    }

    public final int getNumThreads() {
        return this.numThreads;
    }

    public final String getPid() {
        return this.pid;
    }

    public final long getSampleWallTime() {
        return this.sampleWallTime;
    }

    public final String getState() {
        return this.state;
    }

    public final long getStime() {
        return this.stime;
    }

    public final long getTotalUsedCpuTime() {
        return ((Number) this.totalUsedCpuTime$delegate.getValue()).longValue();
    }

    public final long getTotalUsedCpuTimeMs() {
        return ((Number) this.totalUsedCpuTimeMs$delegate.getValue()).longValue();
    }

    public final long getUtime() {
        return this.utime;
    }

    public final long getVsize() {
        return this.vsize;
    }

    public final void setCstime(long j) {
        this.cstime = j;
    }

    public final void setCutime(long j) {
        this.cutime = j;
    }

    public final void setName(String str) {
        j.f(str, "<set-?>");
        this.name = str;
    }

    public final void setNice(String str) {
        j.f(str, "<set-?>");
        this.nice = str;
    }

    public final void setNumThreads(int i2) {
        this.numThreads = i2;
    }

    public final void setPid(String str) {
        j.f(str, "<set-?>");
        this.pid = str;
    }

    public final void setSampleWallTime(long j) {
        this.sampleWallTime = j;
    }

    public final void setState(String str) {
        j.f(str, "<set-?>");
        this.state = str;
    }

    public final void setStime(long j) {
        this.stime = j;
    }

    public final void setUtime(long j) {
        this.utime = j;
    }

    public final void setVsize(long j) {
        this.vsize = j;
    }

    public String toString() {
        return "ProcStatSummary(sampleWallTime=" + this.sampleWallTime + ", pid='" + this.pid + "', name='" + this.name + "', state='" + this.state + "', utime=" + this.utime + ", stime=" + this.stime + ", cutime=" + this.cutime + ", cstime=" + this.cstime + ", nice='" + this.nice + "', numThreads=" + this.numThreads + ", vsize=" + this.vsize + ", totalUsedCpuTime=" + getTotalUsedCpuTime() + ", totalUsedCpuTimeMs=" + getTotalUsedCpuTimeMs() + ')';
    }
}
