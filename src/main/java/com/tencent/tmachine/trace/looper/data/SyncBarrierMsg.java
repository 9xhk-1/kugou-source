package com.tencent.tmachine.trace.looper.data;

import defpackage.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class SyncBarrierMsg {
    private final long blockTime;
    private final int index;
    private final MsgDesc msgDesc;

    public SyncBarrierMsg(int i2, long j, MsgDesc msgDesc) {
        this.index = i2;
        this.blockTime = j;
        this.msgDesc = msgDesc;
    }

    public static /* synthetic */ SyncBarrierMsg copy$default(SyncBarrierMsg syncBarrierMsg, int i2, long j, MsgDesc msgDesc, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = syncBarrierMsg.index;
        }
        if ((i3 & 2) != 0) {
            j = syncBarrierMsg.blockTime;
        }
        if ((i3 & 4) != 0) {
            msgDesc = syncBarrierMsg.msgDesc;
        }
        return syncBarrierMsg.copy(i2, j, msgDesc);
    }

    public final int component1() {
        return this.index;
    }

    public final long component2() {
        return this.blockTime;
    }

    public final MsgDesc component3() {
        return this.msgDesc;
    }

    public final SyncBarrierMsg copy(int i2, long j, MsgDesc msgDesc) {
        return new SyncBarrierMsg(i2, j, msgDesc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncBarrierMsg)) {
            return false;
        }
        SyncBarrierMsg syncBarrierMsg = (SyncBarrierMsg) obj;
        return this.index == syncBarrierMsg.index && this.blockTime == syncBarrierMsg.blockTime && j.a(this.msgDesc, syncBarrierMsg.msgDesc);
    }

    public final long getBlockTime() {
        return this.blockTime;
    }

    public final int getIndex() {
        return this.index;
    }

    public final MsgDesc getMsgDesc() {
        return this.msgDesc;
    }

    public int hashCode() {
        int iA = ((this.index * 31) + b.a(this.blockTime)) * 31;
        MsgDesc msgDesc = this.msgDesc;
        return iA + (msgDesc != null ? msgDesc.hashCode() : 0);
    }

    public String toString() {
        return "SyncBarrierMsg(index=" + this.index + ", blockTime=" + this.blockTime + ", msgDesc=" + this.msgDesc + ")";
    }
}
