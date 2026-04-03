package com.tencent.tmachine.trace.cpu.sysfs;

import f.z.c.a;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class Cpu$cpuFreq$2 extends k implements a<CpuFreq> {
    public final /* synthetic */ Cpu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cpu$cpuFreq$2(Cpu cpu) {
        super(0);
        this.this$0 = cpu;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // f.z.c.a
    public final CpuFreq invoke() {
        return new CpuFreq(this.this$0.getCpuIndex());
    }
}
