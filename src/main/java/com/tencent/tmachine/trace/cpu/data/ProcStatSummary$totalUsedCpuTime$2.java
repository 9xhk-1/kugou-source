package com.tencent.tmachine.trace.cpu.data;

import f.z.c.a;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcStatSummary$totalUsedCpuTime$2 extends k implements a<Long> {
    public final /* synthetic */ ProcStatSummary this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcStatSummary$totalUsedCpuTime$2(ProcStatSummary procStatSummary) {
        super(0);
        this.this$0 = procStatSummary;
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getUtime() + this.this$0.getStime();
    }
}
