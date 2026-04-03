package com.tencent.tmachine.trace.cpu.data;

import f.z.c.a;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuUsageStat$procCpuUsagePercent$2 extends k implements a<Float> {
    public final /* synthetic */ CpuUsageStat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuUsageStat$procCpuUsagePercent$2(CpuUsageStat cpuUsageStat) {
        super(0);
        this.this$0 = cpuUsageStat;
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.getProcCpuTime() / this.this$0.getCpuTime();
    }
}
