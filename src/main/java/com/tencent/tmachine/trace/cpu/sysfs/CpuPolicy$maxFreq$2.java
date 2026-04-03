package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.CpuKtExtensions;
import f.z.c.a;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuPolicy$maxFreq$2 extends k implements a<Long> {
    public final /* synthetic */ CpuPolicy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuPolicy$maxFreq$2(CpuPolicy cpuPolicy) {
        super(0);
        this.this$0 = cpuPolicy;
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return CpuKtExtensions.INSTANCE.readLong(this.this$0.getMaxFreqFile());
    }
}
