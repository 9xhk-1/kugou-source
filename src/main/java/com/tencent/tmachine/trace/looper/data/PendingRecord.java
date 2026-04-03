package com.tencent.tmachine.trace.looper.data;

import defpackage.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class PendingRecord {
    private final long blockTime;
    private final String desc;
    private int msgCount = 1;
    private final MsgDesc msgDesc;

    public PendingRecord(long j, String str, MsgDesc msgDesc) {
        this.blockTime = j;
        this.desc = str;
        this.msgDesc = msgDesc;
    }

    public static /* synthetic */ PendingRecord copy$default(PendingRecord pendingRecord, long j, String str, MsgDesc msgDesc, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = pendingRecord.blockTime;
        }
        if ((i2 & 2) != 0) {
            str = pendingRecord.desc;
        }
        if ((i2 & 4) != 0) {
            msgDesc = pendingRecord.msgDesc;
        }
        return pendingRecord.copy(j, str, msgDesc);
    }

    public final long component1() {
        return this.blockTime;
    }

    public final String component2() {
        return this.desc;
    }

    public final MsgDesc component3() {
        return this.msgDesc;
    }

    public final PendingRecord copy(long j, String str, MsgDesc msgDesc) {
        return new PendingRecord(j, str, msgDesc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingRecord)) {
            return false;
        }
        PendingRecord pendingRecord = (PendingRecord) obj;
        return this.blockTime == pendingRecord.blockTime && j.a(this.desc, pendingRecord.desc) && j.a(this.msgDesc, pendingRecord.msgDesc);
    }

    public final long getBlockTime() {
        return this.blockTime;
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

    public int hashCode() {
        int iA = b.a(this.blockTime) * 31;
        String str = this.desc;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        MsgDesc msgDesc = this.msgDesc;
        return iHashCode + (msgDesc != null ? msgDesc.hashCode() : 0);
    }

    public final void setMsgCount(int i2) {
        this.msgCount = i2;
    }

    public String toString() {
        return "PendingRecord(blockTime=" + this.blockTime + ", msgCount=" + this.msgCount + ", desc=" + this.desc + ", msgDesc=" + this.msgDesc + ')';
    }
}
