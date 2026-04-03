package com.tencent.tmachine.trace.cpu.sysfs;

import com.tencent.tmachine.trace.cpu.CpuKtExtensions;
import f.z.c.a;
import f.z.d.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class Cpu$cpuCapacity$2 extends k implements a<Long> {
    public final /* synthetic */ Cpu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cpu$cpuCapacity$2(Cpu cpu) {
        super(0);
        this.this$0 = cpu;
    }

    @Override // f.z.c.a
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return CpuKtExtensions.INSTANCE.readLong(new File(this.this$0.basePath, "cpu_capacity"));
    }
}
