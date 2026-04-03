package com.tencent.tmachine.trace.looper.data;

import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public final class RunningRecord {
    private final long occurTime;
    private final long wallTime;

    public RunningRecord(long j, long j2) {
        this.occurTime = j;
        this.wallTime = j2;
    }

    public static /* synthetic */ RunningRecord copy$default(RunningRecord runningRecord, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = runningRecord.occurTime;
        }
        if ((i2 & 2) != 0) {
            j2 = runningRecord.wallTime;
        }
        return runningRecord.copy(j, j2);
    }

    public final long component1() {
        return this.occurTime;
    }

    public final long component2() {
        return this.wallTime;
    }

    public final RunningRecord copy(long j, long j2) {
        return new RunningRecord(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RunningRecord)) {
            return false;
        }
        RunningRecord runningRecord = (RunningRecord) obj;
        return this.occurTime == runningRecord.occurTime && this.wallTime == runningRecord.wallTime;
    }

    public final long getOccurTime() {
        return this.occurTime;
    }

    public final long getWallTime() {
        return this.wallTime;
    }

    public int hashCode() {
        return (b.a(this.occurTime) * 31) + b.a(this.wallTime);
    }

    public String toString() {
        return "RunningRecord(occurTime=" + this.occurTime + ", wallTime=" + this.wallTime + ")";
    }
}
