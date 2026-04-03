package com.tencent.tmachine.trace.looper.data;

import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public final class HistoryRecord {
    private long cpuTime;
    private String desc;
    private int msgCount;
    private MsgDesc msgDesc;
    private final long occurTime;
    private final int recType;
    private long wallTime;

    public HistoryRecord(long j, int i2) {
        this.occurTime = j;
        this.recType = i2;
    }

    public static /* synthetic */ HistoryRecord copy$default(HistoryRecord historyRecord, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = historyRecord.occurTime;
        }
        if ((i3 & 2) != 0) {
            i2 = historyRecord.recType;
        }
        return historyRecord.copy(j, i2);
    }

    public final long component1() {
        return this.occurTime;
    }

    public final int component2() {
        return this.recType;
    }

    public final HistoryRecord copy(long j, int i2) {
        return new HistoryRecord(j, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryRecord)) {
            return false;
        }
        HistoryRecord historyRecord = (HistoryRecord) obj;
        return this.occurTime == historyRecord.occurTime && this.recType == historyRecord.recType;
    }

    public final long getCpuTime() {
        return this.cpuTime;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getMsgCount() {
        return this.msgCount;
    }

    public final MsgDesc getMsgDesc() {
        return this.msgDesc;
    }

    public final long getOccurTime() {
        return this.occurTime;
    }

    public final int getRecType() {
        return this.recType;
    }

    public final long getWallTime() {
        return this.wallTime;
    }

    public int hashCode() {
        return (b.a(this.occurTime) * 31) + this.recType;
    }

    public final void setCpuTime(long j) {
        this.cpuTime = j;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setMsgCount(int i2) {
        this.msgCount = i2;
    }

    public final void setMsgDesc(MsgDesc msgDesc) {
        this.msgDesc = msgDesc;
    }

    public final void setWallTime(long j) {
        this.wallTime = j;
    }

    public String toString() {
        return "HistoryRecord(occurTime=" + this.occurTime + ", recType=" + this.recType + ", wallTime=" + this.wallTime + ", cpuTime=" + this.cpuTime + ", msgCount=" + this.msgCount + ", desc=" + this.desc + ", msgDesc=" + this.msgDesc + ')';
    }
}
