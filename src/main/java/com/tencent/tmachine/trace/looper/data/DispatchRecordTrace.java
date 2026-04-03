package com.tencent.tmachine.trace.looper.data;

import f.z.d.j;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DispatchRecordTrace {
    private final List<HistoryRecord> historyRecordList;
    private List<KeyPendingMsg> keyPendingMsgList;
    private int pendingMsgCnt;
    private final List<PendingRecord> pendingRecordList;
    private final RunningRecord runningRecord;
    private List<SyncBarrierMsg> syncBarrierMsgList;

    public DispatchRecordTrace(List<HistoryRecord> list, RunningRecord runningRecord, List<PendingRecord> list2) {
        this.historyRecordList = list;
        this.runningRecord = runningRecord;
        this.pendingRecordList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DispatchRecordTrace copy$default(DispatchRecordTrace dispatchRecordTrace, List list, RunningRecord runningRecord, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = dispatchRecordTrace.historyRecordList;
        }
        if ((i2 & 2) != 0) {
            runningRecord = dispatchRecordTrace.runningRecord;
        }
        if ((i2 & 4) != 0) {
            list2 = dispatchRecordTrace.pendingRecordList;
        }
        return dispatchRecordTrace.copy(list, runningRecord, list2);
    }

    public final List<HistoryRecord> component1() {
        return this.historyRecordList;
    }

    public final RunningRecord component2() {
        return this.runningRecord;
    }

    public final List<PendingRecord> component3() {
        return this.pendingRecordList;
    }

    public final DispatchRecordTrace copy(List<HistoryRecord> list, RunningRecord runningRecord, List<PendingRecord> list2) {
        return new DispatchRecordTrace(list, runningRecord, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DispatchRecordTrace)) {
            return false;
        }
        DispatchRecordTrace dispatchRecordTrace = (DispatchRecordTrace) obj;
        return j.a(this.historyRecordList, dispatchRecordTrace.historyRecordList) && j.a(this.runningRecord, dispatchRecordTrace.runningRecord) && j.a(this.pendingRecordList, dispatchRecordTrace.pendingRecordList);
    }

    public final List<HistoryRecord> getHistoryRecordList() {
        return this.historyRecordList;
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

    public final RunningRecord getRunningRecord() {
        return this.runningRecord;
    }

    public final List<SyncBarrierMsg> getSyncBarrierMsgList() {
        return this.syncBarrierMsgList;
    }

    public int hashCode() {
        List<HistoryRecord> list = this.historyRecordList;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        RunningRecord runningRecord = this.runningRecord;
        int iHashCode2 = (iHashCode + (runningRecord != null ? runningRecord.hashCode() : 0)) * 31;
        List<PendingRecord> list2 = this.pendingRecordList;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setKeyPendingMsgList(List<KeyPendingMsg> list) {
        this.keyPendingMsgList = list;
    }

    public final void setPendingMsgCnt(int i2) {
        this.pendingMsgCnt = i2;
    }

    public final void setSyncBarrierMsgList(List<SyncBarrierMsg> list) {
        this.syncBarrierMsgList = list;
    }

    public String toString() {
        return "DispatchRecordTrace(historyRecordList=" + this.historyRecordList + ", runningRecord=" + this.runningRecord + ", pendingRecordList=" + this.pendingRecordList + ")";
    }
}
