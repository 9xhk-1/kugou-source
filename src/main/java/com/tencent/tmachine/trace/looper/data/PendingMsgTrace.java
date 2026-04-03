package com.tencent.tmachine.trace.looper.data;

import f.z.d.j;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PendingMsgTrace {
    private final List<KeyPendingMsg> keyPendingMsgList;
    private final int pendingMsgCnt;
    private final List<PendingRecord> pendingRecordList;
    private final List<SyncBarrierMsg> syncBarrierMsgList;

    public PendingMsgTrace(List<PendingRecord> list, int i2, List<SyncBarrierMsg> list2, List<KeyPendingMsg> list3) {
        this.pendingRecordList = list;
        this.pendingMsgCnt = i2;
        this.syncBarrierMsgList = list2;
        this.keyPendingMsgList = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingMsgTrace copy$default(PendingMsgTrace pendingMsgTrace, List list, int i2, List list2, List list3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = pendingMsgTrace.pendingRecordList;
        }
        if ((i3 & 2) != 0) {
            i2 = pendingMsgTrace.pendingMsgCnt;
        }
        if ((i3 & 4) != 0) {
            list2 = pendingMsgTrace.syncBarrierMsgList;
        }
        if ((i3 & 8) != 0) {
            list3 = pendingMsgTrace.keyPendingMsgList;
        }
        return pendingMsgTrace.copy(list, i2, list2, list3);
    }

    public final List<PendingRecord> component1() {
        return this.pendingRecordList;
    }

    public final int component2() {
        return this.pendingMsgCnt;
    }

    public final List<SyncBarrierMsg> component3() {
        return this.syncBarrierMsgList;
    }

    public final List<KeyPendingMsg> component4() {
        return this.keyPendingMsgList;
    }

    public final PendingMsgTrace copy(List<PendingRecord> list, int i2, List<SyncBarrierMsg> list2, List<KeyPendingMsg> list3) {
        return new PendingMsgTrace(list, i2, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingMsgTrace)) {
            return false;
        }
        PendingMsgTrace pendingMsgTrace = (PendingMsgTrace) obj;
        return j.a(this.pendingRecordList, pendingMsgTrace.pendingRecordList) && this.pendingMsgCnt == pendingMsgTrace.pendingMsgCnt && j.a(this.syncBarrierMsgList, pendingMsgTrace.syncBarrierMsgList) && j.a(this.keyPendingMsgList, pendingMsgTrace.keyPendingMsgList);
    }

    public final List<KeyPendingMsg> getKeyPendingMsgList() {
        return this.keyPendingMsgList;
    }

    public final int getPendingMsgCnt() {
        return this.pendingMsgCnt;
    }

    public final List<PendingRecord> getPendingRecordList() {
        return this.pendingRecordList;
    }

    public final List<SyncBarrierMsg> getSyncBarrierMsgList() {
        return this.syncBarrierMsgList;
    }

    public int hashCode() {
        List<PendingRecord> list = this.pendingRecordList;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.pendingMsgCnt) * 31;
        List<SyncBarrierMsg> list2 = this.syncBarrierMsgList;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<KeyPendingMsg> list3 = this.keyPendingMsgList;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "PendingMsgTrace(pendingRecordList=" + this.pendingRecordList + ", pendingMsgCnt=" + this.pendingMsgCnt + ", syncBarrierMsgList=" + this.syncBarrierMsgList + ", keyPendingMsgList=" + this.keyPendingMsgList + ")";
    }
}
